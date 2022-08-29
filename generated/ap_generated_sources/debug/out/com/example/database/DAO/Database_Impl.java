package com.example.database.DAO;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Database_Impl extends Database {
  private volatile DAOEvent _dAOEvent;

  private volatile DAOColour _dAOColour;

  private volatile DAOGeo2D _dAOGeo2D;

  private volatile DAOObjectLabel _dAOObjectLabel;

  private volatile DAOObjectType _dAOObjectType;

  private volatile DAOViolateType _dAOViolateType;

  private volatile DAOVideo _dAOVideo;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Event` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `vehicleTypeId` INTEGER, `colorId` INTEGER, `vehicleBrandId` INTEGER, `violetTypeId` INTEGER, `time` INTEGER, `LPLabel` TEXT, `ImageFullPath` TEXT, `ImageCropVehiclePath` TEXT, `VideoId` INTEGER, FOREIGN KEY(`colorId`) REFERENCES `Colour`(`id`) ON UPDATE CASCADE ON DELETE SET NULL , FOREIGN KEY(`vehicleTypeId`) REFERENCES `ObjectType`(`id`) ON UPDATE CASCADE ON DELETE SET NULL , FOREIGN KEY(`vehicleBrandId`) REFERENCES `ObjectLabel`(`id`) ON UPDATE CASCADE ON DELETE SET NULL , FOREIGN KEY(`violetTypeId`) REFERENCES `ViolateType`(`id`) ON UPDATE CASCADE ON DELETE SET NULL , FOREIGN KEY(`VideoId`) REFERENCES `VideoEvent`(`id`) ON UPDATE CASCADE ON DELETE SET NULL )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_Event_time` ON `Event` (`time`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Colour` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ColorValue` TEXT, `ColorName` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Geo2D` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `geoType` INTEGER NOT NULL, `pointList` TEXT, `colorId` INTEGER, `label` TEXT, FOREIGN KEY(`colorId`) REFERENCES `Colour`(`id`) ON UPDATE CASCADE ON DELETE SET NULL )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ObjectLabel` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ObjectLabel` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ObjectType` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ObjectType` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ViolateType` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `violateName` TEXT, `violateDescription` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `VideoEvent` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `RecordedVideoPath` TEXT, `TimeStart` INTEGER, `TimeEnd` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b0a3397cb1fe0cf41a66f3efea79435c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Event`");
        _db.execSQL("DROP TABLE IF EXISTS `Colour`");
        _db.execSQL("DROP TABLE IF EXISTS `Geo2D`");
        _db.execSQL("DROP TABLE IF EXISTS `ObjectLabel`");
        _db.execSQL("DROP TABLE IF EXISTS `ObjectType`");
        _db.execSQL("DROP TABLE IF EXISTS `ViolateType`");
        _db.execSQL("DROP TABLE IF EXISTS `VideoEvent`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEvent = new HashMap<String, TableInfo.Column>(10);
        _columnsEvent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("vehicleTypeId", new TableInfo.Column("vehicleTypeId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("colorId", new TableInfo.Column("colorId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("vehicleBrandId", new TableInfo.Column("vehicleBrandId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("violetTypeId", new TableInfo.Column("violetTypeId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("time", new TableInfo.Column("time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("LPLabel", new TableInfo.Column("LPLabel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("ImageFullPath", new TableInfo.Column("ImageFullPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("ImageCropVehiclePath", new TableInfo.Column("ImageCropVehiclePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvent.put("VideoId", new TableInfo.Column("VideoId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvent = new HashSet<TableInfo.ForeignKey>(5);
        _foreignKeysEvent.add(new TableInfo.ForeignKey("Colour", "SET NULL", "CASCADE",Arrays.asList("colorId"), Arrays.asList("id")));
        _foreignKeysEvent.add(new TableInfo.ForeignKey("ObjectType", "SET NULL", "CASCADE",Arrays.asList("vehicleTypeId"), Arrays.asList("id")));
        _foreignKeysEvent.add(new TableInfo.ForeignKey("ObjectLabel", "SET NULL", "CASCADE",Arrays.asList("vehicleBrandId"), Arrays.asList("id")));
        _foreignKeysEvent.add(new TableInfo.ForeignKey("ViolateType", "SET NULL", "CASCADE",Arrays.asList("violetTypeId"), Arrays.asList("id")));
        _foreignKeysEvent.add(new TableInfo.ForeignKey("VideoEvent", "SET NULL", "CASCADE",Arrays.asList("VideoId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesEvent = new HashSet<TableInfo.Index>(1);
        _indicesEvent.add(new TableInfo.Index("index_Event_time", false, Arrays.asList("time"), Arrays.asList("ASC")));
        final TableInfo _infoEvent = new TableInfo("Event", _columnsEvent, _foreignKeysEvent, _indicesEvent);
        final TableInfo _existingEvent = TableInfo.read(_db, "Event");
        if (! _infoEvent.equals(_existingEvent)) {
          return new RoomOpenHelper.ValidationResult(false, "Event(com.example.database.entity.Event).\n"
                  + " Expected:\n" + _infoEvent + "\n"
                  + " Found:\n" + _existingEvent);
        }
        final HashMap<String, TableInfo.Column> _columnsColour = new HashMap<String, TableInfo.Column>(3);
        _columnsColour.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsColour.put("ColorValue", new TableInfo.Column("ColorValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsColour.put("ColorName", new TableInfo.Column("ColorName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysColour = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesColour = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoColour = new TableInfo("Colour", _columnsColour, _foreignKeysColour, _indicesColour);
        final TableInfo _existingColour = TableInfo.read(_db, "Colour");
        if (! _infoColour.equals(_existingColour)) {
          return new RoomOpenHelper.ValidationResult(false, "Colour(com.example.database.entity.Colour).\n"
                  + " Expected:\n" + _infoColour + "\n"
                  + " Found:\n" + _existingColour);
        }
        final HashMap<String, TableInfo.Column> _columnsGeo2D = new HashMap<String, TableInfo.Column>(5);
        _columnsGeo2D.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeo2D.put("geoType", new TableInfo.Column("geoType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeo2D.put("pointList", new TableInfo.Column("pointList", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeo2D.put("colorId", new TableInfo.Column("colorId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeo2D.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeo2D = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysGeo2D.add(new TableInfo.ForeignKey("Colour", "SET NULL", "CASCADE",Arrays.asList("colorId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesGeo2D = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeo2D = new TableInfo("Geo2D", _columnsGeo2D, _foreignKeysGeo2D, _indicesGeo2D);
        final TableInfo _existingGeo2D = TableInfo.read(_db, "Geo2D");
        if (! _infoGeo2D.equals(_existingGeo2D)) {
          return new RoomOpenHelper.ValidationResult(false, "Geo2D(com.example.database.entity.Geo2D).\n"
                  + " Expected:\n" + _infoGeo2D + "\n"
                  + " Found:\n" + _existingGeo2D);
        }
        final HashMap<String, TableInfo.Column> _columnsObjectLabel = new HashMap<String, TableInfo.Column>(2);
        _columnsObjectLabel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsObjectLabel.put("ObjectLabel", new TableInfo.Column("ObjectLabel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysObjectLabel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesObjectLabel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoObjectLabel = new TableInfo("ObjectLabel", _columnsObjectLabel, _foreignKeysObjectLabel, _indicesObjectLabel);
        final TableInfo _existingObjectLabel = TableInfo.read(_db, "ObjectLabel");
        if (! _infoObjectLabel.equals(_existingObjectLabel)) {
          return new RoomOpenHelper.ValidationResult(false, "ObjectLabel(com.example.database.entity.ObjectLabel).\n"
                  + " Expected:\n" + _infoObjectLabel + "\n"
                  + " Found:\n" + _existingObjectLabel);
        }
        final HashMap<String, TableInfo.Column> _columnsObjectType = new HashMap<String, TableInfo.Column>(2);
        _columnsObjectType.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsObjectType.put("ObjectType", new TableInfo.Column("ObjectType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysObjectType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesObjectType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoObjectType = new TableInfo("ObjectType", _columnsObjectType, _foreignKeysObjectType, _indicesObjectType);
        final TableInfo _existingObjectType = TableInfo.read(_db, "ObjectType");
        if (! _infoObjectType.equals(_existingObjectType)) {
          return new RoomOpenHelper.ValidationResult(false, "ObjectType(com.example.database.entity.ObjectType).\n"
                  + " Expected:\n" + _infoObjectType + "\n"
                  + " Found:\n" + _existingObjectType);
        }
        final HashMap<String, TableInfo.Column> _columnsViolateType = new HashMap<String, TableInfo.Column>(3);
        _columnsViolateType.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsViolateType.put("violateName", new TableInfo.Column("violateName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsViolateType.put("violateDescription", new TableInfo.Column("violateDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysViolateType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesViolateType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoViolateType = new TableInfo("ViolateType", _columnsViolateType, _foreignKeysViolateType, _indicesViolateType);
        final TableInfo _existingViolateType = TableInfo.read(_db, "ViolateType");
        if (! _infoViolateType.equals(_existingViolateType)) {
          return new RoomOpenHelper.ValidationResult(false, "ViolateType(com.example.database.entity.ViolateType).\n"
                  + " Expected:\n" + _infoViolateType + "\n"
                  + " Found:\n" + _existingViolateType);
        }
        final HashMap<String, TableInfo.Column> _columnsVideoEvent = new HashMap<String, TableInfo.Column>(4);
        _columnsVideoEvent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoEvent.put("RecordedVideoPath", new TableInfo.Column("RecordedVideoPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoEvent.put("TimeStart", new TableInfo.Column("TimeStart", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoEvent.put("TimeEnd", new TableInfo.Column("TimeEnd", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVideoEvent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVideoEvent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVideoEvent = new TableInfo("VideoEvent", _columnsVideoEvent, _foreignKeysVideoEvent, _indicesVideoEvent);
        final TableInfo _existingVideoEvent = TableInfo.read(_db, "VideoEvent");
        if (! _infoVideoEvent.equals(_existingVideoEvent)) {
          return new RoomOpenHelper.ValidationResult(false, "VideoEvent(com.example.database.entity.VideoEvent).\n"
                  + " Expected:\n" + _infoVideoEvent + "\n"
                  + " Found:\n" + _existingVideoEvent);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "b0a3397cb1fe0cf41a66f3efea79435c", "d5e17c3da045f391907da3e882c857d0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Event","Colour","Geo2D","ObjectLabel","ObjectType","ViolateType","VideoEvent");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Event`");
      _db.execSQL("DELETE FROM `Colour`");
      _db.execSQL("DELETE FROM `Geo2D`");
      _db.execSQL("DELETE FROM `ObjectLabel`");
      _db.execSQL("DELETE FROM `ObjectType`");
      _db.execSQL("DELETE FROM `ViolateType`");
      _db.execSQL("DELETE FROM `VideoEvent`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DAOEvent.class, DAOEvent_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOColour.class, DAOColour_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOGeo2D.class, DAOGeo2D_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOObjectLabel.class, DAOObjectLabel_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOObjectType.class, DAOObjectType_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOViolateType.class, DAOViolateType_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOVideo.class, DAOVideo_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public DAOEvent useEvent() {
    if (_dAOEvent != null) {
      return _dAOEvent;
    } else {
      synchronized(this) {
        if(_dAOEvent == null) {
          _dAOEvent = new DAOEvent_Impl(this);
        }
        return _dAOEvent;
      }
    }
  }

  @Override
  public DAOColour useColour() {
    if (_dAOColour != null) {
      return _dAOColour;
    } else {
      synchronized(this) {
        if(_dAOColour == null) {
          _dAOColour = new DAOColour_Impl(this);
        }
        return _dAOColour;
      }
    }
  }

  @Override
  public DAOGeo2D useGeo2D() {
    if (_dAOGeo2D != null) {
      return _dAOGeo2D;
    } else {
      synchronized(this) {
        if(_dAOGeo2D == null) {
          _dAOGeo2D = new DAOGeo2D_Impl(this);
        }
        return _dAOGeo2D;
      }
    }
  }

  @Override
  public DAOObjectLabel useObjectLabel() {
    if (_dAOObjectLabel != null) {
      return _dAOObjectLabel;
    } else {
      synchronized(this) {
        if(_dAOObjectLabel == null) {
          _dAOObjectLabel = new DAOObjectLabel_Impl(this);
        }
        return _dAOObjectLabel;
      }
    }
  }

  @Override
  public DAOObjectType useObjectType() {
    if (_dAOObjectType != null) {
      return _dAOObjectType;
    } else {
      synchronized(this) {
        if(_dAOObjectType == null) {
          _dAOObjectType = new DAOObjectType_Impl(this);
        }
        return _dAOObjectType;
      }
    }
  }

  @Override
  public DAOViolateType useViolateType() {
    if (_dAOViolateType != null) {
      return _dAOViolateType;
    } else {
      synchronized(this) {
        if(_dAOViolateType == null) {
          _dAOViolateType = new DAOViolateType_Impl(this);
        }
        return _dAOViolateType;
      }
    }
  }

  @Override
  public DAOVideo useVideoEvent() {
    if (_dAOVideo != null) {
      return _dAOVideo;
    } else {
      synchronized(this) {
        if(_dAOVideo == null) {
          _dAOVideo = new DAOVideo_Impl(this);
        }
        return _dAOVideo;
      }
    }
  }
}
