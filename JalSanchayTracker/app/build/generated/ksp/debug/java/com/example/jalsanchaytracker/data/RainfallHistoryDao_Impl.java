package com.example.jalsanchaytracker.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RainfallHistoryDao_Impl implements RainfallHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RainfallHistory> __insertionAdapterOfRainfallHistory;

  private final EntityDeletionOrUpdateAdapter<RainfallHistory> __deletionAdapterOfRainfallHistory;

  public RainfallHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRainfallHistory = new EntityInsertionAdapter<RainfallHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `rainfall_history` (`id`,`rainfallMM`,`litersSaved`,`date`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RainfallHistory entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getRainfallMM());
        statement.bindDouble(3, entity.getLitersSaved());
        statement.bindLong(4, entity.getDate());
      }
    };
    this.__deletionAdapterOfRainfallHistory = new EntityDeletionOrUpdateAdapter<RainfallHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `rainfall_history` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RainfallHistory entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertRainfall(final RainfallHistory history,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRainfallHistory.insert(history);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRainfall(final RainfallHistory history,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRainfallHistory.handle(history);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<RainfallHistory>> getAllHistory() {
    final String _sql = "SELECT * FROM rainfall_history ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"rainfall_history"}, new Callable<List<RainfallHistory>>() {
      @Override
      @NonNull
      public List<RainfallHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRainfallMM = CursorUtil.getColumnIndexOrThrow(_cursor, "rainfallMM");
          final int _cursorIndexOfLitersSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "litersSaved");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<RainfallHistory> _result = new ArrayList<RainfallHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RainfallHistory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpRainfallMM;
            _tmpRainfallMM = _cursor.getDouble(_cursorIndexOfRainfallMM);
            final double _tmpLitersSaved;
            _tmpLitersSaved = _cursor.getDouble(_cursorIndexOfLitersSaved);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            _item = new RainfallHistory(_tmpId,_tmpRainfallMM,_tmpLitersSaved,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Double> getTotalLitersSaved() {
    final String _sql = "SELECT SUM(litersSaved) FROM rainfall_history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"rainfall_history"}, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<RainfallHistory>> getHistoryBetweenDates(final long startDate,
      final long endDate) {
    final String _sql = "SELECT * FROM rainfall_history WHERE date >= ? AND date <= ? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"rainfall_history"}, new Callable<List<RainfallHistory>>() {
      @Override
      @NonNull
      public List<RainfallHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRainfallMM = CursorUtil.getColumnIndexOrThrow(_cursor, "rainfallMM");
          final int _cursorIndexOfLitersSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "litersSaved");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<RainfallHistory> _result = new ArrayList<RainfallHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RainfallHistory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpRainfallMM;
            _tmpRainfallMM = _cursor.getDouble(_cursorIndexOfRainfallMM);
            final double _tmpLitersSaved;
            _tmpLitersSaved = _cursor.getDouble(_cursorIndexOfLitersSaved);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            _item = new RainfallHistory(_tmpId,_tmpRainfallMM,_tmpLitersSaved,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
