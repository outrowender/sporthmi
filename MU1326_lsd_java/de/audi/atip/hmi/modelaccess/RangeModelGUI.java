/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface RangeModelGUI
extends ButtonModelGUI {
    default public int getMaximum() {
    }

    default public int getMinimum() {
    }

    default public int getStep() {
    }

    default public int getValue() {
    }

    default public int getMedialPosition() {
    }

    default public void decrement(int n, int n2) {
    }

    default public void increment(int n, int n2) {
    }

    default public void forceUpdate(boolean bl) {
    }

    default public boolean isForceUpdateEnabled() {
    }
}

