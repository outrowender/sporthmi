/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

public interface ILoggingManager {
    default public void doGetHistory() {
    }

    default public void updateHistory(String[] stringArray, int[] nArray) {
    }

    default public void setUpdate(int n) {
    }

    default public void updateGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
    }

    default public void doGetUnusualEvents() {
    }

    default public void updateUnusualEvents(String[] stringArray, String[] stringArray2) {
    }

    default public void doGetUnusualEvent(int n) {
    }

    default public void updateUnusualEvent(String string, int n, String string2, String string3, String string4, byte by, int n2) {
    }

    default public void selectHistory(int n) {
    }

    default public void selectUnusualEvent(int n) {
    }
}

