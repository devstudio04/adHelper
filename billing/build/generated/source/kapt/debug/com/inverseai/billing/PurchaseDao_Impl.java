package com.inverseai.billing;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PurchaseDao_Impl implements PurchaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProductItem> __insertionAdapterOfProductItem;

  private final EntityInsertionAdapter<PurchasedItemModel> __insertionAdapterOfPurchasedItemModel;

  private final EntityDeletionOrUpdateAdapter<ProductItem> __deletionAdapterOfProductItem;

  private final SharedSQLiteStatement __preparedStmtOfClearItems;

  private final SharedSQLiteStatement __preparedStmtOfClearPurchaseItems;

  public PurchaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductItem = new EntityInsertionAdapter<ProductItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `product_table` (`id`,`title`,`type`,`sku`,`freeTrialPeriod`,`subscriptionPeriod`,`price`,`originalPRice`,`priceCurrencyCode`,`introductoryPrice`,`introductoryPricePeriod`,`introductoryPriceCycle`,`originalPriceAmountMicros`,`introductoryPriceAmountMacros`,`originalJson`,`iconUrl`,`description`,`selected`,`skuDetails`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductItem value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getSku() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSku());
        }
        if (value.getFreeTrialPeriod() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFreeTrialPeriod());
        }
        if (value.getSubscriptionPeriod() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSubscriptionPeriod());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPrice());
        }
        if (value.getOriginalPRice() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOriginalPRice());
        }
        if (value.getPriceCurrencyCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPriceCurrencyCode());
        }
        if (value.getIntroductoryPrice() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getIntroductoryPrice());
        }
        if (value.getIntroductoryPricePeriod() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getIntroductoryPricePeriod());
        }
        stmt.bindLong(12, value.getIntroductoryPriceCycle());
        stmt.bindLong(13, value.getOriginalPriceAmountMicros());
        stmt.bindLong(14, value.getIntroductoryPriceAmountMacros());
        if (value.getOriginalJson() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getOriginalJson());
        }
        if (value.getIconUrl() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getIconUrl());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getDescription());
        }
        final int _tmp;
        _tmp = value.getSelected() ? 1 : 0;
        stmt.bindLong(18, _tmp);
        if (value.getSkuDetails() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSkuDetails());
        }
      }
    };
    this.__insertionAdapterOfPurchasedItemModel = new EntityInsertionAdapter<PurchasedItemModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `purchase_table` (`orderId`,`packageName`,`productId`,`purchaseTime`,`purchaseState`,`purchaseToken`,`autoRenewing`,`acknowledged`,`originalJson`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PurchasedItemModel value) {
        if (value.getOrderId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getOrderId());
        }
        if (value.getPackageName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPackageName());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductId());
        }
        stmt.bindLong(4, value.getPurchaseTime());
        stmt.bindLong(5, value.getPurchaseState());
        if (value.getPurchaseToken() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPurchaseToken());
        }
        final int _tmp;
        _tmp = value.getAutoRenewing() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getAcknowledged() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        if (value.getOriginalJson() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getOriginalJson());
        }
      }
    };
    this.__deletionAdapterOfProductItem = new EntityDeletionOrUpdateAdapter<ProductItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `product_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductItem value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfClearItems = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM product_table WHERE 1";
        return _query;
      }
    };
    this.__preparedStmtOfClearPurchaseItems = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM purchase_table WHERE 1";
        return _query;
      }
    };
  }

  @Override
  public void addPurchaseItem(final ProductItem productItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductItem.insert(productItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAllProduct(final List<ProductItem> items) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductItem.insert(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAllPurchases(final List<PurchasedItemModel> items) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPurchasedItemModel.insert(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePurchaseItem(final ProductItem productItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProductItem.handle(productItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearItems() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearItems.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearItems.release(_stmt);
    }
  }

  @Override
  public void clearPurchaseItems() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearPurchaseItems.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearPurchaseItems.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ProductItem>> getAllProducts() {
    final String _sql = "SELECT * FROM product_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"product_table"}, false, new Callable<List<ProductItem>>() {
      @Override
      public List<ProductItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfFreeTrialPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "freeTrialPeriod");
          final int _cursorIndexOfSubscriptionPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionPeriod");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfOriginalPRice = CursorUtil.getColumnIndexOrThrow(_cursor, "originalPRice");
          final int _cursorIndexOfPriceCurrencyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "priceCurrencyCode");
          final int _cursorIndexOfIntroductoryPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "introductoryPrice");
          final int _cursorIndexOfIntroductoryPricePeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "introductoryPricePeriod");
          final int _cursorIndexOfIntroductoryPriceCycle = CursorUtil.getColumnIndexOrThrow(_cursor, "introductoryPriceCycle");
          final int _cursorIndexOfOriginalPriceAmountMicros = CursorUtil.getColumnIndexOrThrow(_cursor, "originalPriceAmountMicros");
          final int _cursorIndexOfIntroductoryPriceAmountMacros = CursorUtil.getColumnIndexOrThrow(_cursor, "introductoryPriceAmountMacros");
          final int _cursorIndexOfOriginalJson = CursorUtil.getColumnIndexOrThrow(_cursor, "originalJson");
          final int _cursorIndexOfIconUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "iconUrl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
          final int _cursorIndexOfSkuDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "skuDetails");
          final List<ProductItem> _result = new ArrayList<ProductItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductItem _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpSku;
            _tmpSku = _cursor.getString(_cursorIndexOfSku);
            final String _tmpFreeTrialPeriod;
            _tmpFreeTrialPeriod = _cursor.getString(_cursorIndexOfFreeTrialPeriod);
            final String _tmpSubscriptionPeriod;
            _tmpSubscriptionPeriod = _cursor.getString(_cursorIndexOfSubscriptionPeriod);
            final String _tmpPrice;
            _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            final String _tmpOriginalPRice;
            _tmpOriginalPRice = _cursor.getString(_cursorIndexOfOriginalPRice);
            final String _tmpPriceCurrencyCode;
            _tmpPriceCurrencyCode = _cursor.getString(_cursorIndexOfPriceCurrencyCode);
            final String _tmpIntroductoryPrice;
            _tmpIntroductoryPrice = _cursor.getString(_cursorIndexOfIntroductoryPrice);
            final String _tmpIntroductoryPricePeriod;
            _tmpIntroductoryPricePeriod = _cursor.getString(_cursorIndexOfIntroductoryPricePeriod);
            final int _tmpIntroductoryPriceCycle;
            _tmpIntroductoryPriceCycle = _cursor.getInt(_cursorIndexOfIntroductoryPriceCycle);
            final long _tmpOriginalPriceAmountMicros;
            _tmpOriginalPriceAmountMicros = _cursor.getLong(_cursorIndexOfOriginalPriceAmountMicros);
            final long _tmpIntroductoryPriceAmountMacros;
            _tmpIntroductoryPriceAmountMacros = _cursor.getLong(_cursorIndexOfIntroductoryPriceAmountMacros);
            final String _tmpOriginalJson;
            _tmpOriginalJson = _cursor.getString(_cursorIndexOfOriginalJson);
            final String _tmpIconUrl;
            _tmpIconUrl = _cursor.getString(_cursorIndexOfIconUrl);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final boolean _tmpSelected;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSelected);
            _tmpSelected = _tmp != 0;
            final String _tmpSkuDetails;
            _tmpSkuDetails = _cursor.getString(_cursorIndexOfSkuDetails);
            _item = new ProductItem(_tmpTitle,_tmpType,_tmpSku,_tmpFreeTrialPeriod,_tmpSubscriptionPeriod,_tmpPrice,_tmpOriginalPRice,_tmpPriceCurrencyCode,_tmpIntroductoryPrice,_tmpIntroductoryPricePeriod,_tmpIntroductoryPriceCycle,_tmpOriginalPriceAmountMicros,_tmpIntroductoryPriceAmountMacros,_tmpOriginalJson,_tmpIconUrl,_tmpDescription,_tmpSelected,_tmpSkuDetails);
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
  public LiveData<List<PurchasedItemModel>> getAllPurchases() {
    final String _sql = "SELECT * FROM purchase_table  ORDER BY purchaseTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"purchase_table"}, false, new Callable<List<PurchasedItemModel>>() {
      @Override
      public List<PurchasedItemModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "packageName");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfPurchaseTime = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseTime");
          final int _cursorIndexOfPurchaseState = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseState");
          final int _cursorIndexOfPurchaseToken = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseToken");
          final int _cursorIndexOfAutoRenewing = CursorUtil.getColumnIndexOrThrow(_cursor, "autoRenewing");
          final int _cursorIndexOfAcknowledged = CursorUtil.getColumnIndexOrThrow(_cursor, "acknowledged");
          final int _cursorIndexOfOriginalJson = CursorUtil.getColumnIndexOrThrow(_cursor, "originalJson");
          final List<PurchasedItemModel> _result = new ArrayList<PurchasedItemModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PurchasedItemModel _item;
            final String _tmpOrderId;
            _tmpOrderId = _cursor.getString(_cursorIndexOfOrderId);
            final String _tmpPackageName;
            _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
            final String _tmpProductId;
            _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            final long _tmpPurchaseTime;
            _tmpPurchaseTime = _cursor.getLong(_cursorIndexOfPurchaseTime);
            final int _tmpPurchaseState;
            _tmpPurchaseState = _cursor.getInt(_cursorIndexOfPurchaseState);
            final String _tmpPurchaseToken;
            _tmpPurchaseToken = _cursor.getString(_cursorIndexOfPurchaseToken);
            final boolean _tmpAutoRenewing;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAutoRenewing);
            _tmpAutoRenewing = _tmp != 0;
            final boolean _tmpAcknowledged;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAcknowledged);
            _tmpAcknowledged = _tmp_1 != 0;
            final String _tmpOriginalJson;
            _tmpOriginalJson = _cursor.getString(_cursorIndexOfOriginalJson);
            _item = new PurchasedItemModel(_tmpOrderId,_tmpPackageName,_tmpProductId,_tmpPurchaseTime,_tmpPurchaseState,_tmpPurchaseToken,_tmpAutoRenewing,_tmpAcknowledged,_tmpOriginalJson);
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
  public Object onPurchaseListFetched(final List<ProductItem> list,
      final Continuation<? super Unit> p1) {
    return PurchaseDao.DefaultImpls.onPurchaseListFetched(PurchaseDao_Impl.this, list, p1);
  }

  @Override
  public Object updateUserSubscriptions(final List<PurchasedItemModel> purchaseList,
      final Continuation<? super Unit> p1) {
    return PurchaseDao.DefaultImpls.updateUserSubscriptions(PurchaseDao_Impl.this, purchaseList, p1);
  }
}
