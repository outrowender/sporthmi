/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface RangeModelApp
extends ButtonModelApp {
    default public void setLimits(int n, int n2, int n3) {
    }

    default public void setLimits(int n, int n2, int n3, int n4) {
    }

    default public void setMedialPosition(int n) {
    }

    default public int getMaximum() {
    }

    default public int getMinimum() {
    }

    default public void setRangeListener(RangeListener rangeListener2) {
    }

    default public int getStep() {
    }

    default public void setValue(int n) {
    }

    default public int getValue() {
    }

    default public int getMedialPosition() {
    }

    default public void forceUpdate(boolean bl) {
    }
}

