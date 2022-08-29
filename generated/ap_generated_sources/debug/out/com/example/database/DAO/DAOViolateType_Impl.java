package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.ViolateType;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOViolateType_Impl implements DAOViolateType {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ViolateType> __insertionAdapterOfViolateType;

  private final EntityDeletionOrUpdateAdapter<ViolateType> __deletionAdapterOfViolateType;

  public DAOViolateType_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfViolateType = new EntityInsertionAdapter<ViolateType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ViolateType` (`id`,`violateName`,`violateDescription`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ViolateType value) {
        stmt.bindLong(1, value.getId());
        if (value.getViolateName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getViolateName());
        }
        if (value.getViolateDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getViolateDescription());
        }
      }
    };
    this.__deletionAdapterOfViolateType = new EntityDeletionOrUpdateAdapter<ViolateType>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ViolateType` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ViolateType value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertViolateType(final ViolateType violateType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfViolateType.insert(violateType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteViolateTypebyId(final ViolateType violateType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfViolateType.handle(violateType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ViolateType> getListViolateType() {
    final String _sql = "SELECT * FROM ViolateType";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfViolateName = CursorUtil.getColumnIndexOrThrow(_cursor, "violateName");
      final int _cursorIndexOfViolateDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "violateDescription");
      final List<ViolateType> _result = new ArrayList<ViolateType>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ViolateType _item;
        final String _tmpViolateName;
        if (_cursor.isNull(_cursorIndexOfViolateName)) {
          _tmpViolateName = null;
        } else {
          _tmpViolateName = _cursor.getString(_cursorIndexOfViolateName);
        }
        final String _tmpViolateDescription;
        if (_cursor.isNull(_cursorIndexOfViolateDescription)) {
          _tmpViolateDescription = null;
        } else {
          _tmpViolateDescription = _cursor.getString(_cursorIndexOfViolateDescription);
        }
        _item = new ViolateType(_tmpViolateName,_tmpViolateDescription);
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
  public List<ViolateType> getListViolateName(final String violateName) {
    final String _sql = "SELECT * FROM ViolateType where ViolateType.violateName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (violateName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, violateName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfViolateName = CursorUtil.getColumnIndexOrThrow(_cursor, "violateName");
      final int _cursorIndexOfViolateDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "violateDescription");
      final List<ViolateType> _result = new ArrayList<ViolateType>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ViolateType _item;
        final String _tmpViolateName;
        if (_cursor.isNull(_cursorIndexOfViolateName)) {
          _tmpViolateName = null;
        } else {
          _tmpViolateName = _cursor.getString(_cursorIndexOfViolateName);
        }
        final String _tmpViolateDescription;
        if (_cursor.isNull(_cursorIndexOfViolateDescription)) {
          _tmpViolateDescription = null;
        } else {
          _tmpViolateDescription = _cursor.getString(_cursorIndexOfViolateDescription);
        }
        _item = new ViolateType(_tmpViolateName,_tmpViolateDescription);
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
  public List<String> getViolateNames() {
    final String _sql = "SELECT violateName From ViolateType ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
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
