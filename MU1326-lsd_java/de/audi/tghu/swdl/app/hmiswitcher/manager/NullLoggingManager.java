/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;

public class NullLoggingManager
implements ILoggingManager {
    @Override
    public void doGetHistory() {
    }

    @Override
    public void updateHistory(String[] stringArray, int[] nArray) {
    }

    @Override
    public void setUpdate(int n) {
    }

    @Override
    public void updateGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
    }

    @Override
    public void doGetUnusualEvents() {
    }

    @Override
    public void updateUnusualEvents(String[] stringArray, String[] stringArray2) {
    }

    @Override
    public void doGetUnusualEvent(int n) {
    }

    @Override
    public void updateUnusualEvent(String string, int n, String string2, String string3, String string4, byte by, int n2) {
    }

    @Override
    public void selectHistory(int n) {
    }

    @Override
    public void selectUnusualEvent(int n) {
    }
}

