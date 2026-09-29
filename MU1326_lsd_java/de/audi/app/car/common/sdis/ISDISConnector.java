/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis;

import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;

public interface ISDISConnector {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void storeValue(int n, Object object) {
    }

    default public ISDISCarInfoDistributor getSDISCarInfoDistributor() {
    }
}

