package MoneyManager.adapters.remote;

import MoneyManager.adapters.remote.requests.local.BudgetDao;
import MoneyManager.adapters.remote.requests.local.BudgetDao_Impl;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BudgetRoomDatabase_Impl extends BudgetRoomDatabase {
  private volatile BudgetDao _budgetDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `budget_income` (`title` TEXT NOT NULL, `amount` REAL NOT NULL, `date` TEXT NOT NULL, `type` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6b0be32158ca851c47feb6de7fd35edf')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `budget_income`");
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
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBudgetIncome = new HashMap<String, TableInfo.Column>(5);
        _columnsBudgetIncome.put("title", new TableInfo.Column("title", "TEXT", true, 0));
        _columnsBudgetIncome.put("amount", new TableInfo.Column("amount", "REAL", true, 0));
        _columnsBudgetIncome.put("date", new TableInfo.Column("date", "TEXT", true, 0));
        _columnsBudgetIncome.put("type", new TableInfo.Column("type", "TEXT", true, 0));
        _columnsBudgetIncome.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBudgetIncome = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBudgetIncome = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBudgetIncome = new TableInfo("budget_income", _columnsBudgetIncome, _foreignKeysBudgetIncome, _indicesBudgetIncome);
        final TableInfo _existingBudgetIncome = TableInfo.read(_db, "budget_income");
        if (! _infoBudgetIncome.equals(_existingBudgetIncome)) {
          throw new IllegalStateException("Migration didn't properly handle budget_income(MoneyManager.adapters.databases.interfaces.models.BudgetIncome).\n"
                  + " Expected:\n" + _infoBudgetIncome + "\n"
                  + " Found:\n" + _existingBudgetIncome);
        }
      }
    }, "6b0be32158ca851c47feb6de7fd35edf", "e722a4090cc075a57a6fab8e742f5143");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "budget_income");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `budget_income`");
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
  public BudgetDao getTaskDao() {
    if (_budgetDao != null) {
      return _budgetDao;
    } else {
      synchronized(this) {
        if(_budgetDao == null) {
          _budgetDao = new BudgetDao_Impl(this);
        }
        return _budgetDao;
      }
    }
  }
}
