package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.Colour;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOColour_Impl implements DAOColour {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Colour> __insertionAdapterOfColour;

  private final EntityDeletionOrUpdateAdapter<Colour> __deletionAdapterOfColour;

  private final SharedSQLiteStatement __preparedStmtOfDeleteallColor;

  public DAOColour_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfColour = new EntityInsertionAdapter<Colour>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Colour` (`id`,`ColorValue`,`ColorName`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Colour value) {
        stmt.bindLong(1, value.getId());
        if (value.getColorValue() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getColorValue());
        }
        if (value.getColorName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getColorName());
        }
      }
    };
    this.__deletionAdapterOfColour = new EntityDeletionOrUpdateAdapter<Colour>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Colour` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Colour value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteallColor = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Colour";
        return _query;
      }
    };
  }

  @Override
  public void insertColor(final Colour colour) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfColour.insert(colour);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteColorbyId(final Colour colour) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfColour.handle(colour);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteallColor() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteallColor.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteallColor.release(_stmt);
    }
  }

  @Override
  public List<Colour> getListColor() {
    final String _sql = "SELECT * FROM Colour";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfColorValue = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorValue");
      final int _cursorIndexOfColorName = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorName");
      final List<Colour> _result = new ArrayList<Colour>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Colour _item;
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
        _item = new Colour(_tmpColorValue,_tmpColorName);
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
  public Colour checkColor(final String colorName) {
    final String _sql = "SELECT * FROM Colour where Colour.ColorName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (colorName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, colorName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfColorValue = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorValue");
      final int _cursorIndexOfColorName = CursorUtil.getColumnIndexOrThrow(_cursor, "ColorName");
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
