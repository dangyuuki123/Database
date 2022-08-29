package com.example.database.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.database.entity.VideoEvent;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOVideo_Impl implements DAOVideo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<VideoEvent> __insertionAdapterOfVideoEvent;

  private final EntityDeletionOrUpdateAdapter<VideoEvent> __deletionAdapterOfVideoEvent;

  public DAOVideo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVideoEvent = new EntityInsertionAdapter<VideoEvent>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `VideoEvent` (`id`,`RecordedVideoPath`,`TimeStart`,`TimeEnd`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VideoEvent value) {
        stmt.bindLong(1, value.getId());
        if (value.getRecordedVideoPath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRecordedVideoPath());
        }
        if (value.getTimeStart() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getTimeStart());
        }
        if (value.getTimeEnd() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTimeEnd());
        }
      }
    };
    this.__deletionAdapterOfVideoEvent = new EntityDeletionOrUpdateAdapter<VideoEvent>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `VideoEvent` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, VideoEvent value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertVideo(final VideoEvent videoEvent) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfVideoEvent.insert(videoEvent);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteVideoEventbyId(final VideoEvent videoEvent) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfVideoEvent.handle(videoEvent);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteVideoList(final List<VideoEvent> videoEvents) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfVideoEvent.handleMultiple(videoEvents);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<VideoEvent> getListVideoEvent() {
    final String _sql = "SELECT * FROM VideoEvent";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfRecordedVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "RecordedVideoPath");
      final int _cursorIndexOfTimeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeStart");
      final int _cursorIndexOfTimeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeEnd");
      final List<VideoEvent> _result = new ArrayList<VideoEvent>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final VideoEvent _item;
        final String _tmpRecordedVideoPath;
        if (_cursor.isNull(_cursorIndexOfRecordedVideoPath)) {
          _tmpRecordedVideoPath = null;
        } else {
          _tmpRecordedVideoPath = _cursor.getString(_cursorIndexOfRecordedVideoPath);
        }
        final Integer _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getInt(_cursorIndexOfTimeStart);
        }
        final Integer _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getInt(_cursorIndexOfTimeEnd);
        }
        _item = new VideoEvent(_tmpRecordedVideoPath,_tmpTimeStart,_tmpTimeEnd);
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
  public VideoEvent checkVideoPath(final String RecordedVideoPath) {
    final String _sql = "SELECT * FROM VideoEvent where VideoEvent.RecordedVideoPath=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (RecordedVideoPath == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, RecordedVideoPath);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfRecordedVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "RecordedVideoPath");
      final int _cursorIndexOfTimeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeStart");
      final int _cursorIndexOfTimeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeEnd");
      final VideoEvent _result;
      if(_cursor.moveToFirst()) {
        final String _tmpRecordedVideoPath;
        if (_cursor.isNull(_cursorIndexOfRecordedVideoPath)) {
          _tmpRecordedVideoPath = null;
        } else {
          _tmpRecordedVideoPath = _cursor.getString(_cursorIndexOfRecordedVideoPath);
        }
        final Integer _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getInt(_cursorIndexOfTimeStart);
        }
        final Integer _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getInt(_cursorIndexOfTimeEnd);
        }
        _result = new VideoEvent(_tmpRecordedVideoPath,_tmpTimeStart,_tmpTimeEnd);
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

  @Override
  public List<VideoEvent> GetListVideoEventToDelete(final int TimeOneWeek) {
    final String _sql = "SELECT * FROM VideoEvent where VideoEvent.TimeEnd<=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, TimeOneWeek);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfRecordedVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "RecordedVideoPath");
      final int _cursorIndexOfTimeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeStart");
      final int _cursorIndexOfTimeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "TimeEnd");
      final List<VideoEvent> _result = new ArrayList<VideoEvent>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final VideoEvent _item;
        final String _tmpRecordedVideoPath;
        if (_cursor.isNull(_cursorIndexOfRecordedVideoPath)) {
          _tmpRecordedVideoPath = null;
        } else {
          _tmpRecordedVideoPath = _cursor.getString(_cursorIndexOfRecordedVideoPath);
        }
        final Integer _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getInt(_cursorIndexOfTimeStart);
        }
        final Integer _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getInt(_cursorIndexOfTimeEnd);
        }
        _item = new VideoEvent(_tmpRecordedVideoPath,_tmpTimeStart,_tmpTimeEnd);
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
