/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.DispatcherProxy$1;
import java.lang.reflect.Method;

class DispatcherProxy$1$1
implements Runnable {
    private final /* synthetic */ Method val$method;
    private final /* synthetic */ Object[] val$args;
    private final /* synthetic */ DispatcherProxy$1 this$0;

    DispatcherProxy$1$1(DispatcherProxy$1 dispatcherProxy$1, Method method, Object[] objectArray) {
        this.this$0 = dispatcherProxy$1;
        this.val$method = method;
        this.val$args = objectArray;
    }

    @Override
    public void run() {
        try {
            this.val$method.invoke(DispatcherProxy$1.access$000(this.this$0), this.val$args);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

