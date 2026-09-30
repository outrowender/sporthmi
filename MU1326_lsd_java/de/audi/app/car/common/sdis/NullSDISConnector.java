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
    public void init() {
    }

    public void deinit() {
    }

    public void serviceAvailable(Object object) {
    }

    public void serviceRemoved() {
    }

    public String[] getTrackedServiceClazzName() {
        return null;
    }

    public void init(HashMap hashMap) {
    }

    public void storeValue(int n, Object object) {
    }

    public void sendContent(int n, Object object) {
    }

    public ISDISCarInfoDistributor getSDISCarInfoDistributor() {
        return null;
    }
}

