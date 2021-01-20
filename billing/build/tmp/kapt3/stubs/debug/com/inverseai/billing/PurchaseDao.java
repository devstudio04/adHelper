package com.inverseai.billing;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\'J\b\u0010\u000b\u001a\u00020\u0003H\'J\b\u0010\f\u001a\u00020\u0003H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u000fH\'J\u001f\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/inverseai/billing/PurchaseDao;", "", "addAllProduct", "", "items", "", "Lcom/inverseai/billing/ProductItem;", "addAllPurchases", "Lcom/inverseai/billing/PurchasedItemModel;", "addPurchaseItem", "productItem", "clearItems", "clearPurchaseItems", "deletePurchaseItem", "getAllProducts", "Landroidx/lifecycle/LiveData;", "getAllPurchases", "onPurchaseListFetched", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserSubscriptions", "purchaseList", "billing_debug"})
public abstract interface PurchaseDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addPurchaseItem(@org.jetbrains.annotations.NotNull()
    com.inverseai.billing.ProductItem productItem);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object onPurchaseListFetched(@org.jetbrains.annotations.NotNull()
    java.util.List<com.inverseai.billing.ProductItem> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addAllProduct(@org.jetbrains.annotations.NotNull()
    java.util.List<com.inverseai.billing.ProductItem> items);
    
    @androidx.room.Query(value = "DELETE FROM product_table WHERE 1")
    public abstract void clearItems();
    
    @androidx.room.Delete()
    public abstract void deletePurchaseItem(@org.jetbrains.annotations.NotNull()
    com.inverseai.billing.ProductItem productItem);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM product_table ORDER BY id ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.ProductItem>> getAllProducts();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserSubscriptions(@org.jetbrains.annotations.NotNull()
    java.util.List<com.inverseai.billing.PurchasedItemModel> purchaseList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addAllPurchases(@org.jetbrains.annotations.NotNull()
    java.util.List<com.inverseai.billing.PurchasedItemModel> items);
    
    @androidx.room.Query(value = "DELETE FROM purchase_table WHERE 1")
    public abstract void clearPurchaseItems();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM purchase_table  ORDER BY purchaseTime ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.PurchasedItemModel>> getAllPurchases();
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object onPurchaseListFetched(com.inverseai.billing.PurchaseDao $this, @org.jetbrains.annotations.NotNull()
        java.util.List<com.inverseai.billing.ProductItem> list, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object updateUserSubscriptions(com.inverseai.billing.PurchaseDao $this, @org.jetbrains.annotations.NotNull()
        java.util.List<com.inverseai.billing.PurchasedItemModel> purchaseList, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
    }
}