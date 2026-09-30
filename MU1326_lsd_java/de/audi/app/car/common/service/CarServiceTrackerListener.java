/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.service;

public interface CarServiceTrackerListener {
    public void serviceAvailable(Object var1);

    public void serviceRemoved();

    public String[] getTrackedServiceClazzName();
}

