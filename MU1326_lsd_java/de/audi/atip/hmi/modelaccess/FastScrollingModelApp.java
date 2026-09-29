/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.FastScrollingListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public interface FastScrollingModelApp
extends RangeModelApp {
    default public void setFastScrollingListener(FastScrollingListener fastScrollingListener) {
    }
}

