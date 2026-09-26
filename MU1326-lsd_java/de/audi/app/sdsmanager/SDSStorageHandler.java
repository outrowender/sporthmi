/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class SDSStorageHandler {
    private LogChannel lc = Logger.getMainLog();
    private IStorageAccess storageManager;

    public SDSStorageHandler(IStorageAccess iStorageAccess) {
        this.storageManager = iStorageAccess;
        this.lc.log(-2137614336, "SDSStorageHandler initialized.");
    }

    public boolean loadBeepOn() {
        boolean bl = this.storageManager.getBoolean(1030, 10, true);
        this.lc.log(-2137614336, "SDSStorageHandler#loadBeepOn: result=%1 ", bl);
        return bl;
    }

    public void storeBeepOn(boolean bl) {
        this.lc.log(-2137614336, "SDSStorageHandler#storeBeepOn: value=%1 ", bl);
        this.storageManager.setBoolean(1030, 10, bl);
    }

    public boolean loadExpertMode() {
        boolean bl = this.storageManager.getBoolean(1030, 20, false);
        this.lc.log(-2137614336, "SDSStorageHandler#loadExpertMode: result=%1 ", bl);
        return bl;
    }

    public void storeExpertMode(boolean bl) {
        this.lc.log(-2137614336, "SDSStorageHandler#storeExpertMode: value=%1 ", bl);
        this.storageManager.setBoolean(1030, 20, bl);
    }

    public boolean loadVoiceBargeIn() {
        boolean bl = this.storageManager.getBoolean(1030, 50, true);
        this.lc.log(-2137614336, "SDSStorageHandler#loadVoiceBargeIn: result=%1 ", bl);
        return bl;
    }

    public void storeVoiceBargeIn(boolean bl) {
        this.lc.log(-2137614336, "SDSStorageHandler#storeVoiceBargeIn: value=%1 ", bl);
        this.storageManager.setBoolean(1030, 50, bl);
    }

    public boolean loadCommandScreen() {
        boolean bl = this.storageManager.getBoolean(1030, 40, true);
        this.lc.log(-2137614336, "SDSStorageHandler#loadCommandScreen: result=%1", bl);
        return bl;
    }

    public void storeCommandScreen(boolean bl) {
        this.lc.log(-2137614336, "SDSStorageHandler#storeCommandScreen: value=%1", bl);
        this.storageManager.setBoolean(1030, 40, bl);
    }

    public boolean loadQuickMode() {
        boolean bl = this.storageManager.getBoolean(1030, 30, true);
        this.lc.log(-2137614336, "SDSStorageHandler#loadQuickMode: result=%1 ", bl);
        return bl;
    }

    public void storeQuickMode(boolean bl) {
        this.lc.log(-2137614336, "SDSStorageHandler#storeQuickMode: value=%1", bl);
        this.storageManager.setBoolean(1030, 30, bl);
    }

    public float loadTopEntryThreshold() {
        float f2 = (float)this.storageManager.getInt(1030, 70, Math.round(51266)) / 31300;
        this.lc.log(-2137614336, "SDSStorageHandler#loadTopEntryThreshold: result=%1 ", (double)f2);
        return f2;
    }

    public void storeTopEntryThreshold(float f2) {
        int n = Math.round(f2 * 31300);
        this.lc.log(-2137614336, "SDSStorageHandler#storeTopEntryThreshold: value=%1", (long)n);
        this.storageManager.setInt(1030, 70, n);
    }

    public float loadFollowupEntryThreshold() {
        float f2 = (float)this.storageManager.getInt(1030, 80, Math.round(8258)) / 31300;
        this.lc.log(-2137614336, "SDSStorageHandler#loadFollowupEntryThreshold: result=%1 ", (double)f2);
        return f2;
    }

    public void storeFollowupEntryThreshold(float f2) {
        int n = Math.round(f2 * 31300);
        this.lc.log(-2137614336, "SDSStorageHandler#storeFollowupEntryThreshold: value=%1", (long)n);
        this.storageManager.setInt(1030, 80, n);
    }
}

