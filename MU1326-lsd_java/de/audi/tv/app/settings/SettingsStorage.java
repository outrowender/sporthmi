/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.SettingsStorage$SettingsData;
import de.audi.tv.app.settings.SettingsStorage$StorageDataContainer;

public class SettingsStorage {
    private static final int VERSION;
    private final LogChannel lc;
    private final SettingsStorage$StorageDataContainer container;
    private final SettingsStorage$SettingsData settingsData = new SettingsStorage$SettingsData(null);
    private final TVEnv env;

    SettingsStorage(TVEnv tVEnv) {
        this.env = tVEnv;
        this.lc = tVEnv.lcMain;
        this.container = new SettingsStorage$StorageDataContainer(this, tVEnv.framework.getStorageMgr());
        this.container.readAndDeserialize();
    }

    boolean loadSubtitle() {
        return this.settingsData.subtitle;
    }

    void saveSubtitle(boolean bl) {
        if (bl != this.settingsData.subtitle) {
            this.settingsData.subtitle = bl;
            this.container.serializeAndWrite();
        }
    }

    boolean loadServiceLinking() {
        return this.settingsData.serviceLinking;
    }

    void saveServiceLinking(boolean bl) {
        if (bl != this.settingsData.serviceLinking) {
            this.settingsData.serviceLinking = bl;
            this.container.serializeAndWrite();
        }
    }

    boolean loadVisualAudio() {
        return this.settingsData.visualAudio;
    }

    void saveVisualAudio(boolean bl) {
        if (bl != this.settingsData.visualAudio) {
            this.settingsData.visualAudio = bl;
            this.container.serializeAndWrite();
        }
    }

    public int[] loadViewSettings() {
        return this.settingsData.viewSettings;
    }

    public void saveViewSettings(int[] nArray) {
        this.settingsData.viewSettings = nArray;
        this.container.serializeAndWrite();
    }

    boolean loadEWS() {
        return this.settingsData.ews;
    }

    void saveEWS(boolean bl) {
        if (bl != this.settingsData.ews) {
            this.settingsData.ews = bl;
            this.container.serializeAndWrite();
        }
    }

    int loadAspectRatioTV() {
        return this.settingsData.tvAspectRatio;
    }

    void saveAspectRatioTV(int n) {
        if (n != this.settingsData.tvAspectRatio) {
            this.settingsData.tvAspectRatio = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAspectRatioAV() {
        return this.settingsData.avAspectRatio;
    }

    void saveAspectRatioAV(int n) {
        if (n != this.settingsData.avAspectRatio) {
            this.settingsData.avAspectRatio = n;
            this.container.serializeAndWrite();
        }
    }

    int loadTVNorm() {
        return this.settingsData.tvNorm;
    }

    void saveTVNorm(int n) {
        if (n != this.settingsData.tvNorm) {
            this.settingsData.tvNorm = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAVNorm() {
        return this.settingsData.avNorm;
    }

    void saveAVNorm(int n) {
        if (n != this.settingsData.avNorm) {
            this.settingsData.avNorm = n;
            this.container.serializeAndWrite();
        }
    }

    public int loadParentalLevel() {
        return this.settingsData.parentalLevel;
    }

    public void saveParentalLevel(int n) {
        if (n != this.settingsData.parentalLevel) {
            this.settingsData.parentalLevel = n;
            this.container.serializeAndWrite();
        }
    }

    int loadChannelSorting() {
        return this.settingsData.channelSorting;
    }

    void saveChannelSorting(int n) {
        if (n != this.settingsData.channelSorting) {
            this.settingsData.channelSorting = n;
            this.container.serializeAndWrite();
        }
    }

    int loadTVBrightness() {
        return this.settingsData.tvBrightness;
    }

    void saveTVBrightness(int n) {
        if (n != this.settingsData.tvBrightness) {
            this.settingsData.tvBrightness = n;
            this.container.serializeAndWrite();
        }
    }

    int loadTVColor() {
        return this.settingsData.tvColor;
    }

    void saveTVColor(int n) {
        if (n != this.settingsData.tvColor) {
            this.settingsData.tvColor = n;
            this.container.serializeAndWrite();
        }
    }

    int loadTVContrast() {
        return this.settingsData.tvContrast;
    }

    void saveTVContrast(int n) {
        if (n != this.settingsData.tvContrast) {
            this.settingsData.tvContrast = n;
            this.container.serializeAndWrite();
        }
    }

    int loadTVTint() {
        return this.settingsData.tvTint;
    }

    void saveTVTint(int n) {
        if (n != this.settingsData.tvTint) {
            this.settingsData.tvTint = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAVBrightness() {
        return this.settingsData.avBrightness;
    }

    void saveAVBrightness(int n) {
        if (n != this.settingsData.avBrightness) {
            this.settingsData.avBrightness = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAVColor() {
        return this.settingsData.avColor;
    }

    void saveAVColor(int n) {
        if (n != this.settingsData.avColor) {
            this.settingsData.avColor = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAVContrast() {
        return this.settingsData.avContrast;
    }

    void saveAVContrast(int n) {
        if (n != this.settingsData.avContrast) {
            this.settingsData.avContrast = n;
            this.container.serializeAndWrite();
        }
    }

    int loadAVTint() {
        return this.settingsData.avTint;
    }

    void saveAVTint(int n) {
        if (n != this.settingsData.avTint) {
            this.settingsData.avTint = n;
            this.container.serializeAndWrite();
        }
    }

    public String loadParentalPassword(String string) {
        this.lc.log(-2137614336, "[SettingsStorage.loadParentalPassword] trying to load password.");
        return this.env.framework.getStorageMgr().getString(1002, 19, string);
    }

    public void saveParentalPassword(String string) {
        this.lc.log(-2137614336, "[SettingsStorage.saveParentalPassword] %1.", (Object)string);
        this.env.framework.getStorageMgr().setString(1002, 19, string);
    }

    static /* synthetic */ LogChannel access$100(SettingsStorage settingsStorage) {
        return settingsStorage.lc;
    }

    static /* synthetic */ SettingsStorage$SettingsData access$200(SettingsStorage settingsStorage) {
        return settingsStorage.settingsData;
    }
}

