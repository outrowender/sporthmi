/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import org.osgi.framework.BundleContext;

public interface IListManager {
    default public void init(BundleContext bundleContext) {
    }

    default public void deinit() {
    }

    default public void setOperationState(int n) {
    }
}

