package com.inverseai.billing;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PurchaseDb_Impl extends PurchaseDb {
  private volatile PurchaseDao _purchaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `product_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT NOT NULL, `type` TEXT NOT NULL, `sku` TEXT NOT NULL, `freeTrialPeriod` TEXT NOT NULL, `subscriptionPeriod` TEXT NOT NULL, `price` TEXT NOT NULL, `originalPRice` TEXT NOT NULL, `priceCurrencyCode` TEXT NOT NULL, `introductoryPrice` TEXT NOT NULL, `introductoryPricePeriod` TEXT NOT NULL, `introductoryPriceCycle` INTEGER NOT NULL, `originalPriceAmountMicros` INTEGER NOT NULL, `introductoryPriceAmountMacros` INTEGER NOT NULL, `originalJson` TEXT NOT NULL, `iconUrl` TEXT NOT NULL, `description` TEXT NOT NULL, `selected` INTEGER NOT NULL, `skuDetails` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `purchase_table` (`orderId` TEXT NOT NULL, `packageName` TEXT NOT NULL, `productId` TEXT NOT NULL, `purchaseTime` INTEGER NOT NULL, `purchaseState` INTEGER NOT NULL, `purchaseToken` TEXT NOT NULL, `autoRenewing` INTEGER NOT NULL, `acknowledged` INTEGER NOT NULL, `originalJson` TEXT, PRIMARY KEY(`purchaseToken`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9f59fe43ebbd6dd9562bb03efce93bc4')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `product_table`");
        _db.execSQL("DROP TABLE IF EXISTS `purchase_table`");
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
        final HashMap<String, TableInfo.Column> _columnsProductTable = new HashMap<String, TableInfo.Column>(19);
        _columnsProductTable.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("sku", new TableInfo.Column("sku", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("freeTrialPeriod", new TableInfo.Column("freeTrialPeriod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("subscriptionPeriod", new TableInfo.Column("subscriptionPeriod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("price", new TableInfo.Column("price", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("originalPRice", new TableInfo.Column("originalPRice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("priceCurrencyCode", new TableInfo.Column("priceCurrencyCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("introductoryPrice", new TableInfo.Column("introductoryPrice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("introductoryPricePeriod", new TableInfo.Column("introductoryPricePeriod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("introductoryPriceCycle", new TableInfo.Column("introductoryPriceCycle", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("originalPriceAmountMicros", new TableInfo.Column("originalPriceAmountMicros", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("introductoryPriceAmountMacros", new TableInfo.Column("introductoryPriceAmountMacros", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("originalJson", new TableInfo.Column("originalJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("iconUrl", new TableInfo.Column("iconUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("selected", new TableInfo.Column("selected", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("skuDetails", new TableInfo.Column("skuDetails", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductTable = new TableInfo("product_table", _columnsProductTable, _foreignKeysProductTable, _indicesProductTable);
        final TableInfo _existingProductTable = TableInfo.read(_db, "product_table");
        if (! _infoProductTable.equals(_existingProductTable)) {
          return new RoomOpenHelper.ValidationResult(false, "product_table(com.inverseai.billing.ProductItem).\n"
                  + " Expected:\n" + _infoProductTable + "\n"
                  + " Found:\n" + _existingProductTable);
        }
        final HashMap<String, TableInfo.Column> _columnsPurchaseTable = new HashMap<String, TableInfo.Column>(9);
        _columnsPurchaseTable.put("orderId", new TableInfo.Column("orderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("purchaseTime", new TableInfo.Column("purchaseTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("purchaseState", new TableInfo.Column("purchaseState", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("purchaseToken", new TableInfo.Column("purchaseToken", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("autoRenewing", new TableInfo.Column("autoRenewing", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("acknowledged", new TableInfo.Column("acknowledged", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPurchaseTable.put("originalJson", new TableInfo.Column("originalJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPurchaseTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPurchaseTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPurchaseTable = new TableInfo("purchase_table", _columnsPurchaseTable, _foreignKeysPurchaseTable, _indicesPurchaseTable);
        final TableInfo _existingPurchaseTable = TableInfo.read(_db, "purchase_table");
        if (! _infoPurchaseTable.equals(_existingPurchaseTable)) {
          return new RoomOpenHelper.ValidationResult(false, "purchase_table(com.inverseai.billing.PurchasedItemModel).\n"
                  + " Expected:\n" + _infoPurchaseTable + "\n"
                  + " Found:\n" + _existingPurchaseTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9f59fe43ebbd6dd9562bb03efce93bc4", "c893e346fd8b8023407793d696ef3789");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "product_table","purchase_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `product_table`");
      _db.execSQL("DELETE FROM `purchase_table`");
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
  public PurchaseDao getPurchaseDao() {
    if (_purchaseDao != null) {
      return _purchaseDao;
    } else {
      synchronized(this) {
        if(_purchaseDao == null) {
          _purchaseDao = new PurchaseDao_Impl(this);
        }
        return _purchaseDao;
      }
    }
  }
}
