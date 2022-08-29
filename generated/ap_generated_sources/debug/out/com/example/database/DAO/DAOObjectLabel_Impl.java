package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.ObjectLabel;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOObjectLabel_Impl implements DAOObjectLabel {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ObjectLabel> __insertionAdapterOfObjectLabel;

  private final EntityDeletionOrUpdateAdapter<ObjectLabel> __deletionAdapterOfObjectLabel;

  public DAOObjectLabel_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfObjectLabel = new EntityInsertionAdapter<ObjectLabel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ObjectLabel` (`id`,`ObjectLabel`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ObjectLabel value) {
        stmt.bindLong(1, value.getId());
        if (value.getObjectLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getObjectLabel());
        }
      }
    };
    this.__deletionAdapterOfObjectLabel = new EntityDeletionOrUpdateAdapter<ObjectLabel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ObjectLabel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ObjectLabel value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertObjectLabel(final ObjectLabel objectLabel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfObjectLabel.insert(objectLabel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteObjectLabelbyId(final ObjectLabel objectLabel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfObjectLabel.handle(objectLabel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ObjectLabel> getListObjectLabel() {
    final String _sql = "SELECT * FROM ObjectLabel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfObjectLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "ObjectLabel");
      final List<ObjectLabel> _result = new ArrayList<ObjectLabel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ObjectLabel _item;
        final String _tmpObjectLabel;
        if (_cursor.isNull(_cursorIndexOfObjectLabel)) {
          _tmpObjectLabel = null;
        } else {
          _tmpObjectLabel = _cursor.getString(_cursorIndexOfObjectLabel);
        }
        _item = new ObjectLabel(_tmpObjectLabel);
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
  public ObjectLabel checkObjectLabel(final String ObjectLabel) {
    final String _sql = "SELECT * FROM ObjectLabel where ObjectLabel.ObjectLabel =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ObjectLabel == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ObjectLabel);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfObjectLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "ObjectLabel");
      final ObjectLabel _result;
      if(_cursor.moveToFirst()) {
        final String _tmpObjectLabel;
        if (_cursor.isNull(_cursorIndexOfObjectLabel)) {
          _tmpObjectLabel = null;
        } else {
          _tmpObjectLabel = _cursor.getString(_cursorIndexOfObjectLabel);
        }
        _result = new ObjectLabel(_tmpObjectLabel);
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
