package com.inverseai.billing;

import java.lang.System;

@androidx.room.Database(entities = {com.inverseai.billing.ProductItem.class, com.inverseai.billing.PurchasedItemModel.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/inverseai/billing/PurchaseDb;", "Landroidx/room/RoomDatabase;", "()V", "getPurchaseDao", "Lcom/inverseai/billing/PurchaseDao;", "Companion", "billing_debug"})
public abstract class PurchaseDb extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DB_NAME = "purchases.db";
    private static volatile com.inverseai.billing.PurchaseDb INSTANCE;
    public static final com.inverseai.billing.PurchaseDb.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.inverseai.billing.PurchaseDao getPurchaseDao();
    
    public PurchaseDb() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/inverseai/billing/PurchaseDb$Companion;", "", "()V", "DB_NAME", "", "getDB_NAME", "()Ljava/lang/String;", "INSTANCE", "Lcom/inverseai/billing/PurchaseDb;", "getDatabse", "context", "Landroid/content/Context;", "billing_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDB_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.inverseai.billing.PurchaseDb getDatabse(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}