package MoneyManager.adapters.remote.requests.local;

import MoneyManager.adapters.databases.interfaces.models.BudgetIncome;
import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BudgetDao_Impl implements BudgetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBudgetIncome;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBudgetIncome;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBudgetIncome;

  public BudgetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBudgetIncome = new EntityInsertionAdapter<BudgetIncome>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `budget_income`(`title`,`amount`,`date`,`type`,`id`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BudgetIncome value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        stmt.bindDouble(2, value.getAmount());
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
      }
    };
    this.__deletionAdapterOfBudgetIncome = new EntityDeletionOrUpdateAdapter<BudgetIncome>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `budget_income` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BudgetIncome value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfBudgetIncome = new EntityDeletionOrUpdateAdapter<BudgetIncome>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `budget_income` SET `title` = ?,`amount` = ?,`date` = ?,`type` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BudgetIncome value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        stmt.bindDouble(2, value.getAmount());
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
        if (value.getId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getId());
        }
      }
    };
  }

  @Override
  public void addBudgetIncome(final BudgetIncome budgetIncome) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBudgetIncome.insert(budgetIncome);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteBudgetIncome(final BudgetIncome budgetIncome) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBudgetIncome.handle(budgetIncome);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBudgetIncome(final BudgetIncome budgetIncome) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBudgetIncome.handle(budgetIncome);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<BudgetIncome>> getAllBudgetIncome() {
    final String _sql = "select * from budget_income";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"budget_income"}, false, new Callable<List<BudgetIncome>>() {
      @Override
      public List<BudgetIncome> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<BudgetIncome> _result = new ArrayList<BudgetIncome>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BudgetIncome _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            _item = new BudgetIncome(_tmpTitle,_tmpAmount,_tmpDate,_tmpType);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
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
  public LiveData<Double> getAllIncome() {
    final String _sql = "select SUM(amount) as TOTAL from budget_income";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"budget_income"}, false, new Callable<Double>() {
      @Override
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final Double _result;
          if(_cursor.moveToFirst()) {
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
}
