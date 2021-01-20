package com.inverseai.billing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/inverseai/billing/BillingClientInfoCallbacks;", "", "getBase64Key", "", "getInAppSkuIds", "", "getSubscriptionSkuIds", "billing_debug"})
public abstract interface BillingClientInfoCallbacks {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getSubscriptionSkuIds();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getInAppSkuIds();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getBase64Key();
}