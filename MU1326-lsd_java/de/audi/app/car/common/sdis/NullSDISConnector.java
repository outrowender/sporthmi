/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis;

import de.audi.app.car.common.sdis.ISDISConnector;
import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;
import java.util.HashMap;

public class NullSDISConnector
implements ISDISConnector,
ISDISCarInfoDistributor {
    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void serviceAvailable(Object object) {
    }

    @Override
    public void serviceRemoved() {
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return null;
    }

    @Override
    public void init(HashMap hashMap) {
    }

    @Override
    public void storeValue(int n, Object object) {
    }

    @Override
    public void sendContent(int n, Object object) {
    }

    @Override
    public ISDISCarInfoDistributor getSDISCarInfoDistributor() {
        return null;
    }
}

