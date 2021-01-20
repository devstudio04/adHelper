package com.inverseai.billing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001>B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\t2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J \u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u000102H\u0016J\u0011\u00103\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J\b\u00105\u001a\u00020\u001cH\u0002J\u0006\u00106\u001a\u00020\u001cJ\u0019\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020!H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/inverseai/billing/BillingManager;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "purchaseDao", "Lcom/inverseai/billing/PurchaseDao;", "clientSecret", "Lcom/inverseai/billing/BillingClientInfoCallbacks;", "(Lcom/inverseai/billing/PurchaseDao;Lcom/inverseai/billing/BillingClientInfoCallbacks;)V", "_products", "Landroidx/lifecycle/LiveData;", "", "Lcom/inverseai/billing/ProductItem;", "_purchases", "Lcom/inverseai/billing/PurchasedItemModel;", "availableProducts", "getAvailableProducts", "()Landroidx/lifecycle/LiveData;", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "billingConnectionInProgress", "", "needToStartConnection", "purchaseQueryRuning", "queryOnGoing", "retryJob", "Lkotlinx/coroutines/Job;", "userPurchases", "getUserPurchases", "callForBillingConnection", "", "consumePurchase", "purchase", "Lcom/android/billingclient/api/Purchase;", "getBase64Key", "", "getSkuList", "skuType", "Lcom/inverseai/billing/ProductType;", "handlePurchase", "initializeBilling", "context", "Landroid/content/Context;", "initiatePurchase", "activity", "Landroid/app/Activity;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "onPurchasesUpdated", "result", "Lcom/android/billingclient/api/BillingResult;", "purchaseList", "", "queryProducts", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchases", "refreshAgain", "retryAfterDelay", "delay", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyValidSignature", "signedData", "signature", "Companion", "billing_debug"})
public final class BillingManager implements com.android.billingclient.api.PurchasesUpdatedListener {
    private boolean billingConnectionInProgress = false;
    private boolean needToStartConnection = false;
    private com.android.billingclient.api.BillingClient billingClient;
    private kotlinx.coroutines.Job retryJob;
    private boolean queryOnGoing = false;
    private boolean purchaseQueryRuning = false;
    private final androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.ProductItem>> _products = null;
    private final androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.PurchasedItemModel>> _purchases = null;
    private final com.inverseai.billing.PurchaseDao purchaseDao = null;
    private final com.inverseai.billing.BillingClientInfoCallbacks clientSecret = null;
    private static final java.lang.String TAG = "BillingManager";
    private static final long RETRY_DELAY = 3000L;
    private static boolean initialized = false;
    private static com.inverseai.billing.BillingManager billingManager;
    public static final com.inverseai.billing.BillingManager.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.ProductItem>> getAvailableProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.inverseai.billing.PurchasedItemModel>> getUserPurchases() {
        return null;
    }
    
    private final void initializeBilling(android.content.Context context) {
    }
    
    public final void refreshAgain() {
    }
    
    /**
     * Billing Manager needs to be first establish connection to its server before querying any purchases
     */
    private final void callForBillingConnection() {
    }
    
    private final void queryPurchases() {
    }
    
    public final boolean initiatePurchase(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.android.billingclient.api.SkuDetails skuDetails) {
        return false;
    }
    
    /**
     * This is the place where callback reaches when the users purchase list is finished querying or any update occurred to the list
     */
    @java.lang.Override()
    public void onPurchasesUpdated(@org.jetbrains.annotations.NotNull()
    com.android.billingclient.api.BillingResult result, @org.jetbrains.annotations.Nullable()
    java.util.List<com.android.billingclient.api.Purchase> purchaseList) {
    }
    
    public final void consumePurchase(@org.jetbrains.annotations.NotNull()
    com.android.billingclient.api.Purchase purchase) {
    }
    
    private final void handlePurchase(com.android.billingclient.api.Purchase purchase) {
    }
    
    private final boolean verifyValidSignature(java.lang.String signedData, java.lang.String signature) {
        return false;
    }
    
    /**
     * Sku-details contains the information that play store need when we make a query to the play server
     */
    private final java.util.List<java.lang.String> getSkuList(com.inverseai.billing.ProductType skuType) {
        return null;
    }
    
    /**
     * base 64 key is provided by the play console and used to verify the products
     */
    private final java.lang.String getBase64Key() {
        return null;
    }
    
    public BillingManager(@org.jetbrains.annotations.NotNull()
    com.inverseai.billing.PurchaseDao purchaseDao, @org.jetbrains.annotations.NotNull()
    com.inverseai.billing.BillingClientInfoCallbacks clientSecret) {
        super();
    }
    
    /**
     * constants value
     * made this class singleton as we may need it from multiple screens
     * it's not wise to initialize a frequently used utility class every time we use it in a new place
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/inverseai/billing/BillingManager$Companion;", "", "()V", "RETRY_DELAY", "", "TAG", "", "billingManager", "Lcom/inverseai/billing/BillingManager;", "initialized", "", "getInstance", "initialize", "", "context", "Landroid/content/Context;", "clientSecret", "Lcom/inverseai/billing/BillingClientInfoCallbacks;", "billing_debug"})
    public static final class Companion {
        
        /**
         * This is the function to creating the singleton class from your apps Application class on-create
         * Please don't use it frequently outside of application class
         */
        public final void initialize(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.inverseai.billing.BillingClientInfoCallbacks clientSecret) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.inverseai.billing.BillingManager getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}