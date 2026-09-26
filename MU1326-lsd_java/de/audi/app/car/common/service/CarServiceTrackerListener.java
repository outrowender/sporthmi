/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.service;

public interface CarServiceTrackerListener {
    default public void serviceAvailable(Object object) {
    }

    default public void serviceRemoved() {
    }

    default public String[] getTrackedServiceClazzName() {
    }
}

