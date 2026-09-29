/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.DispatcherProxy$1$1;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class DispatcherProxy$1
implements InvocationHandler {
    private final /* synthetic */ DispatcherBase val$dispatcher;
    private final /* synthetic */ Object val$listener;

    DispatcherProxy$1(DispatcherBase dispatcherBase, Object object) {
        this.val$dispatcher = dispatcherBase;
        this.val$listener = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        if (method.getReturnType().equals(Void.TYPE)) {
            this.val$dispatcher.execute(new DispatcherProxy$1$1(this, method, objectArray));
            return null;
        }
        return method.invoke(this.val$listener, objectArray);
    }

    static /* synthetic */ Object access$000(DispatcherProxy$1 dispatcherProxy$1) {
        return dispatcherProxy$1.val$listener;
    }
}

