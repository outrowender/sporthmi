/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates$Predicate;

class Handler$1
implements Predicates$Predicate {
    private final /* synthetic */ int val$messageCode;
    private final /* synthetic */ Handler this$0;

    Handler$1(Handler handler, int n) {
        this.this$0 = handler;
        this.val$messageCode = n;
    }

    @Override
    public boolean apply(Object object) {
        return ((Message)object).getCode() == this.val$messageCode;
    }
}

