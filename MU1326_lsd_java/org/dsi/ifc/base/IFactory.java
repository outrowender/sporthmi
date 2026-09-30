/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

public interface IFactory {
    public Object getFactory(Class var1);

    public Class[] getFactoryList();

    public boolean shouldOverride(IFactory var1);
}

