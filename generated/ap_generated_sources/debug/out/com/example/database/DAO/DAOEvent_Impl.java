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
import com.example.database.entity.Event;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOEvent_Impl implements DAOEvent {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Event> __insertionAdapterOfEvent;

  private final EntityDeletionOrUpdateAdapter<Event> __deletionAdapterOfEvent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteallEvent;

  public DAOEvent_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvent = new EntityInsertionAdapter<Event>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Event` (`id`,`vehicleTypeId`,`colorId`,`vehicleBrandId`,`violetTypeId`,`time`,`LPLabel`,`ImageFullPath`,`ImageCropVehiclePath`,`VideoId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Event value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getVehicleTypeId());
        stmt.bindLong(3, value.getColorId());
        stmt.bindLong(4, value.getVehicleBrandId());
        stmt.bindLong(5, value.getVioletTypeId());
        if (value.getTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getTime());
        }
        if (value.getLPLabel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLPLabel());
        }
        if (value.getImageFullPath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImageFullPath());
        }
        if (value.getImageCropVehiclePath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getImageCropVehiclePath());
        }
        if (value.getVideoId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getVideoId());
        }
      }
    };
    this.__deletionAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Event` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Event value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteallEvent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Event";
        return _query;
      }
    };
  }

  @Override
  public void insertEvent(final Event event) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEvent.insert(event);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteEventbyId(final Event event) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEvent.handle(event);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteListEvent(final List<Event> events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEvent.handleMultiple(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteallEvent() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteallEvent.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteallEvent.release(_stmt);
    }
  }

  @Override
  public List<Event> getListEvent() {
    final String _sql = "SELECT * FROM Event";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
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
  public List<Event> getListEventbyViolateName(final String colorValue, final String violateName,
      final String vehicletype, final String vehiclebrand) {
    final String _sql = "SELECT * FROM Event inner join Colour on Event.colorId = Colour.id INNER JOIN ViolateType on Event.violetTypeId = Violatetype.id INNER JOIN ObjectType on Event.vehicleTypeId = ObjectType.id INNER Join ObjectLabel on Event.vehicleBrandId = ObjectLabel.id where Event.time between 10000 and 200000 and Colour.ColorValue =? and violatetype.violateName =? and ObjectType.ObjectType=? and ObjectLabel.ObjectLabel =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (colorValue == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, colorValue);
    }
    _argIndex = 2;
    if (violateName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, violateName);
    }
    _argIndex = 3;
    if (vehicletype == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, vehicletype);
    }
    _argIndex = 4;
    if (vehiclebrand == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, vehiclebrand);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_3 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_4 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        final int _tmpId_2;
        _tmpId_2 = _cursor.getInt(_cursorIndexOfId_2);
        _item.setId(_tmpId_2);
        final int _tmpId_3;
        _tmpId_3 = _cursor.getInt(_cursorIndexOfId_3);
        _item.setId(_tmpId_3);
        final int _tmpId_4;
        _tmpId_4 = _cursor.getInt(_cursorIndexOfId_4);
        _item.setId(_tmpId_4);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Event> getListEventToDelete(final int timeOneWeek) {
    final String _sql = "SELECT * FROM Event where Event.time <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, timeOneWeek);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
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
  public List<Event> listEventToNeed(final String violateName, final Integer timeStart,
      final Integer timeEnd) {
    final String _sql = "SELECT * FROM Event inner join Colour on Event.colorId = Colour.id INNER JOIN ViolateType on Event.violetTypeId = Violatetype.id  where Event.time >=? and Event.time <= ? and violatetype.violateName !=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (timeStart == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeStart);
    }
    _argIndex = 2;
    if (timeEnd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeEnd);
    }
    _argIndex = 3;
    if (violateName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, violateName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        final int _tmpId_2;
        _tmpId_2 = _cursor.getInt(_cursorIndexOfId_2);
        _item.setId(_tmpId_2);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Event> getListEventInViolate(final String violateName, final Integer timeStart,
      final Integer timeEnd) {
    final String _sql = "SELECT * FROM Event inner join ViolateType on Event.violetTypeId = ViolateType.id where Event.time >=? and Event.time <= ? and violatetype.violateName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (timeStart == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeStart);
    }
    _argIndex = 2;
    if (timeEnd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeEnd);
    }
    _argIndex = 3;
    if (violateName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, violateName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Event> ListEventObjectLabel(final String ObjectLabel, final Integer timeStart,
      final Integer timeEnd) {
    final String _sql = "SELECT * FROM Event inner join ObjectLabel on Event.vehicleBrandId = ObjectLabel.id where Event.time >=? and Event.time <= ? and ObjectLabel.ObjectLabel =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (timeStart == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeStart);
    }
    _argIndex = 2;
    if (timeEnd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, timeEnd);
    }
    _argIndex = 3;
    if (ObjectLabel == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ObjectLabel);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVehicleTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleTypeId");
      final int _cursorIndexOfColorId = CursorUtil.getColumnIndexOrThrow(_cursor, "colorId");
      final int _cursorIndexOfVehicleBrandId = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicleBrandId");
      final int _cursorIndexOfVioletTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "violetTypeId");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLPLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "LPLabel");
      final int _cursorIndexOfImageFullPath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageFullPath");
      final int _cursorIndexOfImageCropVehiclePath = CursorUtil.getColumnIndexOrThrow(_cursor, "ImageCropVehiclePath");
      final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "VideoId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Long _tmpVehicleTypeId;
        if (_cursor.isNull(_cursorIndexOfVehicleTypeId)) {
          _tmpVehicleTypeId = null;
        } else {
          _tmpVehicleTypeId = _cursor.getLong(_cursorIndexOfVehicleTypeId);
        }
        final Long _tmpColorId;
        if (_cursor.isNull(_cursorIndexOfColorId)) {
          _tmpColorId = null;
        } else {
          _tmpColorId = _cursor.getLong(_cursorIndexOfColorId);
        }
        final Long _tmpVehicleBrandId;
        if (_cursor.isNull(_cursorIndexOfVehicleBrandId)) {
          _tmpVehicleBrandId = null;
        } else {
          _tmpVehicleBrandId = _cursor.getLong(_cursorIndexOfVehicleBrandId);
        }
        final Long _tmpVioletTypeId;
        if (_cursor.isNull(_cursorIndexOfVioletTypeId)) {
          _tmpVioletTypeId = null;
        } else {
          _tmpVioletTypeId = _cursor.getLong(_cursorIndexOfVioletTypeId);
        }
        final Long _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        }
        final String _tmpLPLabel;
        if (_cursor.isNull(_cursorIndexOfLPLabel)) {
          _tmpLPLabel = null;
        } else {
          _tmpLPLabel = _cursor.getString(_cursorIndexOfLPLabel);
        }
        final String _tmpImageFullPath;
        if (_cursor.isNull(_cursorIndexOfImageFullPath)) {
          _tmpImageFullPath = null;
        } else {
          _tmpImageFullPath = _cursor.getString(_cursorIndexOfImageFullPath);
        }
        final String _tmpImageCropVehiclePath;
        if (_cursor.isNull(_cursorIndexOfImageCropVehiclePath)) {
          _tmpImageCropVehiclePath = null;
        } else {
          _tmpImageCropVehiclePath = _cursor.getString(_cursorIndexOfImageCropVehiclePath);
        }
        final Integer _tmpVideoId;
        if (_cursor.isNull(_cursorIndexOfVideoId)) {
          _tmpVideoId = null;
        } else {
          _tmpVideoId = _cursor.getInt(_cursorIndexOfVideoId);
        }
        _item = new Event(_tmpVehicleTypeId,_tmpColorId,_tmpVehicleBrandId,_tmpVioletTypeId,_tmpTime,_tmpLPLabel,_tmpImageFullPath,_tmpImageCropVehiclePath,_tmpVideoId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
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
