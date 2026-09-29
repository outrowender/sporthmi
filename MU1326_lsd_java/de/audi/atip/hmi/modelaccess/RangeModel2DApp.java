/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.RangeListener2D;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface RangeModel2DApp
extends ButtonModelApp {
    default public void setLimitsX(int n, int n2, int n3) {
    }

    default public void setLimitsY(int n, int n2, int n3) {
    }

    default public void setLimitsX(int n, int n2, int n3, int n4) {
    }

    default public void setLimitsY(int n, int n2, int n3, int n4) {
    }

    default public void setLimitsXY(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void setLimitsXY(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void setMedialPositionX(int n) {
    }

    default public void setMedialPositionY(int n) {
    }

    default public int getMaximumX() {
    }

    default public int getMaximumY() {
    }

    default public int getMinimumX() {
    }

    default public int getMinimumY() {
    }

    default public void setRangeListener(RangeListener2D rangeListener2D) {
    }

    default public int getStepX() {
    }

    default public int getStepY() {
    }

    default public void setValue(int n, int n2) {
    }

    default public int getValueX() {
    }

    default public int getValueY() {
    }

    default public int getMedialPositionX() {
    }

    default public int getMedialPositionY() {
    }

    default public void forceUpdate(boolean bl) {
    }
}

