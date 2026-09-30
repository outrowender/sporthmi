/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

import org.dsi.ifc.base.IFactory;

public interface IAdapterManager {
    public void registerFactories(IFactory var1);

    public void unregisterFactories(IFactory var1);

    public Object getFactory(Class var1);
}

