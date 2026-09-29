/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import org.osgi.framework.BundleContext;

public interface IListAdapterFastList {
    default public void init(BundleContext bundleContext) {
    }

    default public void deinit() {
    }

    default public int[] getDSINotifications() {
    }
}

