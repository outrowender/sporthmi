/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface RangeModel2DGUI
extends ButtonModelGUI {
    default public int getMaximumX() {
    }

    default public int getMaximumY() {
    }

    default public int getMinimumX() {
    }

    default public int getMinimumY() {
    }

    default public int getStepX() {
    }

    default public int getStepY() {
    }

    default public int getValueX() {
    }

    default public int getValueY() {
    }

    default public int getMedialPositionX() {
    }

    default public int getMedialPositionY() {
    }

    default public void setValueHit(int n, int n2, int n3) {
    }

    default public void forceUpdate(boolean bl) {
    }

    default public boolean isForceUpdateEnabled() {
    }
}

