package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.ObjectType;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOObjectType_Impl implements DAOObjectType {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ObjectType> __insertionAdapterOfObjectType;

  private final EntityDeletionOrUpdateAdapter<ObjectType> __deletionAdapterOfObjectType;

  public DAOObjectType_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfObjectType = new EntityInsertionAdapter<ObjectType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ObjectType` (`id`,`ObjectType`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ObjectType value) {
        stmt.bindLong(1, value.getId());
        if (value.getObjectType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getObjectType());
        }
      }
    };
    this.__deletionAdapterOfObjectType = new EntityDeletionOrUpdateAdapter<ObjectType>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ObjectType` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ObjectType value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertObjectType(final ObjectType objectType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfObjectType.insert(objectType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteObjectTypebyId(final ObjectType objectType) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfObjectType.handle(objectType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ObjectType> getListObjectType() {
    final String _sql = "SELECT * FROM ObjectType";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfObjectType = CursorUtil.getColumnIndexOrThrow(_cursor, "ObjectType");
      final List<ObjectType> _result = new ArrayList<ObjectType>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ObjectType _item;
        final String _tmpObjectType;
        if (_cursor.isNull(_cursorIndexOfObjectType)) {
          _tmpObjectType = null;
        } else {
          _tmpObjectType = _cursor.getString(_cursorIndexOfObjectType);
        }
        _item = new ObjectType(_tmpObjectType);
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
  public List<ObjectType> getListObjectType(final String type) {
    final String _sql = "SELECT * FROM ObjectType where ObjectType.ObjectType =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfObjectType = CursorUtil.getColumnIndexOrThrow(_cursor, "ObjectType");
      final List<ObjectType> _result = new ArrayList<ObjectType>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ObjectType _item;
        final String _tmpObjectType;
        if (_cursor.isNull(_cursorIndexOfObjectType)) {
          _tmpObjectType = null;
        } else {
          _tmpObjectType = _cursor.getString(_cursorIndexOfObjectType);
        }
        _item = new ObjectType(_tmpObjectType);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
