/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;

public interface IPopupKeyConsuptionStrategy {
    default public int getPopupID() {
    }

    default public void setConsumeHKReturn(int n) {
    }

    default public void setConsumeDDSPress(int n) {
    }

    default public void setConsumeKeyTurned(int n) {
    }

    default public void setConsumeSKPress(int n) {
    }

    default public void setConsumeTouchPad(int n) {
    }

    default public void setConsumeGenericKeys(int n, int[] nArray) {
    }

    default public void setHKPressFilter(int[] nArray) {
    }

    default public int[] getHKPressFilter() {
    }

    default public void registerPopupKeyConsumptionListener(IPopupKeyConsumptionListener iPopupKeyConsumptionListener) {
    }

    default public boolean doesHKFilterContainsKey(int n) {
    }

    default public int getConsumeHKReturn() {
    }

    default public int getConsumeDDSPress() {
    }

    default public int getConsumeKeyTurned() {
    }

    default public int getConsumeSKPress() {
    }

    default public int getConsumeTouchPad() {
    }

    default public int getConsumeGenericStrategy() {
    }

    default public int[] getConsumeGenericKeys() {
    }
}

