/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import org.apache.commons.jexl.util.AbstractExecutor;
import org.apache.commons.jexl.util.introspection.UberspectImpl;
import org.apache.commons.jexl.util.introspection.VelPropertyGet;

public class UberspectImpl$VelGetterImpl
implements VelPropertyGet {
    protected AbstractExecutor ae = null;
    private final /* synthetic */ UberspectImpl this$0;

    public UberspectImpl$VelGetterImpl(UberspectImpl uberspectImpl, AbstractExecutor abstractExecutor) {
        this.this$0 = uberspectImpl;
        this.ae = abstractExecutor;
    }

    @Override
    public Object invoke(Object object) {
        return this.ae.execute(object);
    }

    @Override
    public boolean isCacheable() {
        return true;
    }

    @Override
    public String getMethodName() {
        return this.ae.getMethod().getName();
    }
}

