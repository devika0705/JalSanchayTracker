package com.example.jalsanchaytracker.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserSetupDao _userSetupDao;

  private volatile RainfallHistoryDao _rainfallHistoryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_setup` (`id` INTEGER NOT NULL, `roofArea` REAL NOT NULL, `tankCapacity` REAL NOT NULL, `runoffCoefficient` REAL NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `rainfall_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rainfallMM` REAL NOT NULL, `litersSaved` REAL NOT NULL, `date` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ae460f13a35f3ce18cc2e91052979139')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `user_setup`");
        db.execSQL("DROP TABLE IF EXISTS `rainfall_history`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUserSetup = new HashMap<String, TableInfo.Column>(4);
        _columnsUserSetup.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSetup.put("roofArea", new TableInfo.Column("roofArea", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSetup.put("tankCapacity", new TableInfo.Column("tankCapacity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSetup.put("runoffCoefficient", new TableInfo.Column("runoffCoefficient", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSetup = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserSetup = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSetup = new TableInfo("user_setup", _columnsUserSetup, _foreignKeysUserSetup, _indicesUserSetup);
        final TableInfo _existingUserSetup = TableInfo.read(db, "user_setup");
        if (!_infoUserSetup.equals(_existingUserSetup)) {
          return new RoomOpenHelper.ValidationResult(false, "user_setup(com.example.jalsanchaytracker.data.UserSetup).\n"
                  + " Expected:\n" + _infoUserSetup + "\n"
                  + " Found:\n" + _existingUserSetup);
        }
        final HashMap<String, TableInfo.Column> _columnsRainfallHistory = new HashMap<String, TableInfo.Column>(4);
        _columnsRainfallHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRainfallHistory.put("rainfallMM", new TableInfo.Column("rainfallMM", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRainfallHistory.put("litersSaved", new TableInfo.Column("litersSaved", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRainfallHistory.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRainfallHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRainfallHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRainfallHistory = new TableInfo("rainfall_history", _columnsRainfallHistory, _foreignKeysRainfallHistory, _indicesRainfallHistory);
        final TableInfo _existingRainfallHistory = TableInfo.read(db, "rainfall_history");
        if (!_infoRainfallHistory.equals(_existingRainfallHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "rainfall_history(com.example.jalsanchaytracker.data.RainfallHistory).\n"
                  + " Expected:\n" + _infoRainfallHistory + "\n"
                  + " Found:\n" + _existingRainfallHistory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ae460f13a35f3ce18cc2e91052979139", "de5a635ad458c6208ef49906893dcbde");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_setup","rainfall_history");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user_setup`");
      _db.execSQL("DELETE FROM `rainfall_history`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserSetupDao.class, UserSetupDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RainfallHistoryDao.class, RainfallHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserSetupDao userSetupDao() {
    if (_userSetupDao != null) {
      return _userSetupDao;
    } else {
      synchronized(this) {
        if(_userSetupDao == null) {
          _userSetupDao = new UserSetupDao_Impl(this);
        }
        return _userSetupDao;
      }
    }
  }

  @Override
  public RainfallHistoryDao rainfallHistoryDao() {
    if (_rainfallHistoryDao != null) {
      return _rainfallHistoryDao;
    } else {
      synchronized(this) {
        if(_rainfallHistoryDao == null) {
          _rainfallHistoryDao = new RainfallHistoryDao_Impl(this);
        }
        return _rainfallHistoryDao;
      }
    }
  }
}
