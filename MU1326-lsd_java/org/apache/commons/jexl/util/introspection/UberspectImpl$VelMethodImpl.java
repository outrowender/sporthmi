/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.jexl.util.introspection.UberspectImpl;
import org.apache.commons.jexl.util.introspection.VelMethod;

public class UberspectImpl$VelMethodImpl
implements VelMethod {
    protected Method method = null;
    private final /* synthetic */ UberspectImpl this$0;

    public UberspectImpl$VelMethodImpl(UberspectImpl uberspectImpl, Method method) {
        this.this$0 = uberspectImpl;
        this.method = method;
    }

    @Override
    public Object invoke(Object object, Object[] objectArray) {
        try {
            return this.method.invoke(object, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof Exception) {
                throw (Exception)throwable;
            }
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw invocationTargetException;
        }
    }

    @Override
    public boolean isCacheable() {
        return true;
    }

    @Override
    public String getMethodName() {
        return this.method.getName();
    }

    @Override
    public Class getReturnType() {
        return this.method.getReturnType();
    }
}

