/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis;

import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;

public interface ISDISConnector {
    public void init();

    public void deinit();

    public void storeValue(int var1, Object var2);

    public ISDISCarInfoDistributor getSDISCarInfoDistributor();
}

