package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.Colour;
import com.example.database.entity.Geo2D;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOGeo2D_Impl implements DAOGeo2D {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Geo2D> __insertionAdapterOfGeo2D;

  private final EntityDeletionOrUpdateAdapter<Geo2D> __deletionAdapterOfGeo2D;

  public DAOGeo2D_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGeo2D = new EntityInsertionAdapter<Geo2D>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Geo2D` (`id`,`geoType`,`pointList`,`colorId`,`label`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Geo2D value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getGeoType());
        if (value.getPointList() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPointList());
        }
        stmt.bindLong(4, value.getColorId());
        if (value.getLabel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLabel());
        }
      }
    };
    this.__deletionAdapterOfGeo2D = new EntityDeletionOrUpdateAdapter<Geo2D>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Geo2D` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Geo2D value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertGeo2D(final Geo2D geo2D) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGeo2D.insert(geo2D);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteGeo2DbyId(final Geo2D geo2D) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGeo2D.handle(geo2D);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Geo2D> getListGeo2D() {
    final String _sql = "SELECT * FROM Geo2D";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfGeoType = CursorUtil.getColumnIndexOrThrow(_cursor, "geoType");
      final int _cursorIndexOfPointList = CursorUtil.getColumnIndexOrThrow(_cursor, "pointList");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final List<Geo2D> _result = new ArrayList<Geo2D>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Geo2D _item;
        final int _tmpGeoType;
        _tmpGeoType = _cursor.getInt(_cursorIndexOfGeoType);
        final String _tmpPointList;
        if (_cursor.isNull(_cursorIndexOfPointList)) {
          _tmpPointList = null;
        } else {
          _tmpPointList = _cursor.getString(_cursorIndexOfPointList);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        _item = new Geo2D(_tmpGeoType,_tmpPointList,_tmpLabel,_tmpColorId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Colour getcolorInGeo2D(final int colorid) {
    final String _sql = "SELECT * FROM Colour INNER JOIN Geo2D ON Colour.id = Geo2D.colorId WHERE Geo2D.colorId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, colorid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfColorValue = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorValue");
      final int _cursorIndexOfColorName = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorName");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Colour _result;
      if(_cursor.moveToFirst()) {
        final String _tmpColorValue;
        if (_cursor.isNull(_cursorIndexOfColorValue)) {
          _tmpColorValue = null;
        } else {
          _tmpColorValue = _cursor.getString(_cursorIndexOfColorValue);
        }
        final String _tmpColorName;
        if (_cursor.isNull(_cursorIndexOfColorName)) {
          _tmpColorName = null;
        } else {
          _tmpColorName = _cursor.getString(_cursorIndexOfColorName);
        }
        _result = new Colour(_tmpColorValue,_tmpColorName);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _result.setId(_tmpId_1);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
