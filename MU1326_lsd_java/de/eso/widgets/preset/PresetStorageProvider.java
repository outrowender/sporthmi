/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.Preset;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.eso.widgets.preset.PresetStorageProvider$PresetStorage;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class PresetStorageProvider {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private static final int PRESET_COUNT;
    private static final int NO_ICON;
    private PresetStorageProvider$PresetStorage[] presetStorages;
    private IStorageAccess storageManager;
    private IPresetPopupData[] presetPopupDataToStore = new PresetPopupData[8];
    private int[] defaultIconTypes = new int[]{99, 99, 99, 99, 99, 99, 99, 99};
    private int[] iconTypes = (int[])this.defaultIconTypes.clone();

    public PresetStorageProvider(IFrameworkAccess iFrameworkAccess) {
        this.storageManager = iFrameworkAccess.getStorageMgr();
        this.initializePresetStorages();
    }

    private void initializePresetStorages() {
        this.presetStorages = new PresetStorageProvider$PresetStorage[8];
        for (int i2 = 0; i2 < this.presetStorages.length; ++i2) {
            this.presetStorages[i2] = new PresetStorageProvider$PresetStorage(this, i2 + 1);
            this.presetStorages[i2].readAndDeserialize();
            this.iconTypes[i2] = this.presetStorages[i2].getData().getPreset().getIconType();
            this.presetPopupDataToStore[i2] = this.getNotStorablePopupData();
        }
    }

    public void saveToPersistence(int n) {
        if (0 <= n && n < 8) {
            lc.log(-2137614336, "PresetStorage#saveToPersistence presetIndex=%1", (long)n);
            this.presetStorages[n].setData(this.presetPopupDataToStore[n]);
            this.presetStorages[n].serializeAndWrite();
        } else {
            lc.log(10000, "PresetStorage#saveToPersistence presetIndex=%1 OUT OF BOUND!", (long)n);
        }
    }

    public IPresetPopupData getPersistedPresetPopupData(int n) {
        if (0 <= n && n < 8) {
            return this.presetStorages[n].getData();
        }
        lc.log(-1601830656, "PresetStorage#getPersistedPresetPopupData presetIndex=%1 OUT OF BOUND!", (long)n);
        return this.getNoEntryStoredPresetPopupData();
    }

    public IPresetPopupData getPresetPopupDataToStore(int n) {
        if (0 <= n && n < 8) {
            return this.presetPopupDataToStore[n];
        }
        lc.log(-1601830656, "PresetStorage#getPresetPopupDataToStore presetIndex=%1 OUT OF BOUND!", (long)n);
        return this.getNoEntryStoredPresetPopupData();
    }

    public void setPresetPopupDataToStore(int n, IPresetPopupData iPresetPopupData) {
        if (0 <= n && n < 8) {
            this.presetPopupDataToStore[n] = iPresetPopupData;
            this.iconTypes[n] = iPresetPopupData.getPreset().getIconType();
        } else {
            lc.log(-1601830656, "PresetStorage#setPresetPopupDataToStore presetIndex=%1 OUT OF BOUND!", (long)n);
        }
    }

    public int[] getSavedIconTypes() {
        return this.iconTypes;
    }

    public PresetPopupData getNoEntryStoredPresetPopupData() {
        return new PresetPopupData(7, -1, new Preset(-1, 0, 0, null, null, 99), null, null, -1, null);
    }

    public PresetPopupData getNotStorablePopupData() {
        return new PresetPopupData(8, -1, new Preset(-1, 0, 0, null, null, 99), null, null, -1, null);
    }

    public PresetPopupData getNoAppRegisteredPopupData() {
        return new PresetPopupData(10, -1, new Preset(-1, 0, 0, null, null, 99), null, null, -1, null);
    }

    public void reset() {
        this.iconTypes = (int[])this.defaultIconTypes.clone();
        for (int i2 = 0; i2 < this.presetStorages.length; ++i2) {
            this.presetPopupDataToStore[i2] = this.getNoEntryStoredPresetPopupData();
            this.saveToPersistence(i2);
        }
    }

    static /* synthetic */ IStorageAccess access$000(PresetStorageProvider presetStorageProvider) {
        return presetStorageProvider.storageManager;
    }

    static /* synthetic */ LogChannel access$100() {
        return lc;
    }
}

