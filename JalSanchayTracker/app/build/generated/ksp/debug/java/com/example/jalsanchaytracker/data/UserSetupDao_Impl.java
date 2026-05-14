package com.example.jalsanchaytracker.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserSetupDao_Impl implements UserSetupDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserSetup> __insertionAdapterOfUserSetup;

  private final SharedSQLiteStatement __preparedStmtOfClearSetup;

  public UserSetupDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserSetup = new EntityInsertionAdapter<UserSetup>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_setup` (`id`,`roofArea`,`tankCapacity`,`runoffCoefficient`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSetup entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getRoofArea());
        statement.bindDouble(3, entity.getTankCapacity());
        statement.bindDouble(4, entity.getRunoffCoefficient());
      }
    };
    this.__preparedStmtOfClearSetup = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM user_setup";
        return _query;
      }
    };
  }

  @Override
  public Object insertSetup(final UserSetup setup, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserSetup.insert(setup);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearSetup(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearSetup.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearSetup.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<UserSetup> getSetup() {
    final String _sql = "SELECT * FROM user_setup WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user_setup"}, new Callable<UserSetup>() {
      @Override
      @Nullable
      public UserSetup call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRoofArea = CursorUtil.getColumnIndexOrThrow(_cursor, "roofArea");
          final int _cursorIndexOfTankCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "tankCapacity");
          final int _cursorIndexOfRunoffCoefficient = CursorUtil.getColumnIndexOrThrow(_cursor, "runoffCoefficient");
          final UserSetup _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpRoofArea;
            _tmpRoofArea = _cursor.getDouble(_cursorIndexOfRoofArea);
            final double _tmpTankCapacity;
            _tmpTankCapacity = _cursor.getDouble(_cursorIndexOfTankCapacity);
            final double _tmpRunoffCoefficient;
            _tmpRunoffCoefficient = _cursor.getDouble(_cursorIndexOfRunoffCoefficient);
            _result = new UserSetup(_tmpId,_tmpRoofArea,_tmpTankCapacity,_tmpRunoffCoefficient);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
