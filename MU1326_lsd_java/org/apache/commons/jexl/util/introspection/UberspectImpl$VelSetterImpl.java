/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.util.ArrayList;
import org.apache.commons.jexl.util.introspection.UberspectImpl;
import org.apache.commons.jexl.util.introspection.VelMethod;
import org.apache.commons.jexl.util.introspection.VelPropertySet;

public class UberspectImpl$VelSetterImpl
implements VelPropertySet {
    protected VelMethod vm = null;
    protected String putKey = null;
    private final /* synthetic */ UberspectImpl this$0;

    public UberspectImpl$VelSetterImpl(UberspectImpl uberspectImpl, VelMethod velMethod) {
        this.this$0 = uberspectImpl;
        this.vm = velMethod;
    }

    public UberspectImpl$VelSetterImpl(UberspectImpl uberspectImpl, VelMethod velMethod, String string) {
        this.this$0 = uberspectImpl;
        this.vm = velMethod;
        this.putKey = string;
    }

    @Override
    public Object invoke(Object object, Object object2) {
        ArrayList arrayList = new ArrayList();
        if (this.putKey == null) {
            arrayList.add(object2);
        } else {
            arrayList.add(this.putKey);
            arrayList.add(object2);
        }
        return this.vm.invoke(object, arrayList.toArray());
    }

    @Override
    public boolean isCacheable() {
        return true;
    }

    @Override
    public String getMethodName() {
        return this.vm.getMethodName();
    }
}

