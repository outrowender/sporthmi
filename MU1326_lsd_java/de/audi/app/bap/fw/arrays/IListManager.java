/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import org.osgi.framework.BundleContext;

public interface IListManager {
    public void init(BundleContext var1);

    public void deinit();

    public void setOperationState(int var1);
}

