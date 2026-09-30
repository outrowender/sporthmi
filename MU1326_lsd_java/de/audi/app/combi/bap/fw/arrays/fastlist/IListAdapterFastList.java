/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import org.osgi.framework.BundleContext;

public interface IListAdapterFastList {
    public void init(BundleContext var1);

    public void deinit();

    public int[] getDSINotifications();
}

