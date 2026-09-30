/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.Preset;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PresetStorageProvider {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private static final int PRESET_COUNT = 8;
    private static final int NO_ICON = 99;
    private PresetStorage[] presetStorages;
    private IStorageAccess storageManager;
    private IPresetPopupData[] presetPopupDataToStore = new PresetPopupData[8];
    private int[] defaultIconTypes = new int[]{99, 99, 99, 99, 99, 99, 99, 99};
    private int[] iconTypes = (int[])this.defaultIconTypes.clone();

    public PresetStorageProvider(IFrameworkAccess iFrameworkAccess) {
        this.storageManager = iFrameworkAccess.getStorageMgr();
        this.initializePresetStorages();
    }

    private void initializePresetStorages() {
        this.presetStorages = new PresetStorage[8];
        for (int i2 = 0; i2 < this.presetStorages.length; ++i2) {
            this.presetStorages[i2] = new PresetStorage(i2 + 1);
            this.presetStorages[i2].readAndDeserialize();
            this.iconTypes[i2] = this.presetStorages[i2].getData().getPreset().getIconType();
            this.presetPopupDataToStore[i2] = this.getNotStorablePopupData();
        }
    }

    public void saveToPersistence(int n) {
        if (0 <= n && n < 8) {
            lc.log(10000000, "PresetStorage#saveToPersistence presetIndex=%1", (long)n);
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
        lc.log(100000, "PresetStorage#getPersistedPresetPopupData presetIndex=%1 OUT OF BOUND!", (long)n);
        return this.getNoEntryStoredPresetPopupData();
    }

    public IPresetPopupData getPresetPopupDataToStore(int n) {
        if (0 <= n && n < 8) {
            return this.presetPopupDataToStore[n];
        }
        lc.log(100000, "PresetStorage#getPresetPopupDataToStore presetIndex=%1 OUT OF BOUND!", (long)n);
        return this.getNoEntryStoredPresetPopupData();
    }

    public void setPresetPopupDataToStore(int n, IPresetPopupData iPresetPopupData) {
        if (0 <= n && n < 8) {
            this.presetPopupDataToStore[n] = iPresetPopupData;
            this.iconTypes[n] = iPresetPopupData.getPreset().getIconType();
        } else {
            lc.log(100000, "PresetStorage#setPresetPopupDataToStore presetIndex=%1 OUT OF BOUND!", (long)n);
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

    private class PresetStorage
    extends AbstractStorageDataContainer {
        private static final int VERSION = 3;
        private IPresetPopupData presetPopupData;

        public PresetStorage(int n) {
            super(PresetStorageProvider.this.storageManager, 3, 1011, n);
            this.presetPopupData = PresetStorageProvider.this.getNoEntryStoredPresetPopupData();
        }

        public void setData(IPresetPopupData iPresetPopupData) {
            this.presetPopupData = iPresetPopupData;
        }

        public IPresetPopupData getData() {
            return this.presetPopupData;
        }

        protected void handleCRC32Error() {
            lc.log(10000, "PresetStorage#handleCRC32Error");
        }

        protected void handleStorageReadError(Exception exception) {
            lc.log(100000, "PresetStorage#handleStorageReadError error reading preset, cannot read preset, %1", (Throwable)exception);
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            lc.log(1000000, "PresetStorage#convertContainer versions are different presisted version: %1 container version: %2", (long)n, (long)n2);
            this.presetPopupData = new PresetPopupData(8, -1, new Preset(-1, 0, 0, null, null, 99), null, null, -1, null);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            lc.log(10000000, "PresetStorage#serialize");
            if (this.presetPopupData == null || this.presetPopupData.getPreset() == null) {
                return;
            }
            Preset preset = this.presetPopupData.getPreset();
            PresetListRow presetListRow = preset.getPreview();
            dataOutputStream.writeInt(preset.getType());
            dataOutputStream.writeInt(this.presetPopupData.getLayoutType());
            dataOutputStream.writeInt(this.presetPopupData.getCursorColor());
            dataOutputStream.writeInt(preset.getModelId());
            dataOutputStream.writeInt(preset.getSMEvent());
            String string = "Default Main Label";
            if (presetListRow != null) {
                string = presetListRow.getText(2);
            }
            dataOutputStream.writeUTF(string);
            String string2 = "<Sub Label>";
            if (presetListRow != null) {
                string2 = presetListRow.getText(4);
            }
            dataOutputStream.writeUTF(string2 == null ? "" : string2);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
                objectOutputStream.writeObject(preset.getData());
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            dataOutputStream.writeInt(preset.getExecutionType());
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            lc.log(10000000, "PresetStorage#deserialize");
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            int n4 = dataInputStream.readInt();
            int n5 = dataInputStream.readInt();
            int n6 = 0;
            String string = dataInputStream.readUTF();
            String string2 = dataInputStream.readUTF();
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            Serializable serializable = null;
            try {
                serializable = (Serializable)objectInputStream.readObject();
            }
            catch (Exception exception) {
                lc.log(10000, "PresetStorage#deserialize Exception occured, preset data cannot be read. %1", (Throwable)exception);
            }
            finally {
                objectInputStream.close();
            }
            int n7 = dataInputStream.readInt();
            PresetListRow presetListRow = new PresetListRow();
            presetListRow.setRecordSet(n6);
            presetListRow.setMainLabel(string);
            presetListRow.setSubLabel(string2);
            Preset preset = new Preset(n, n4, n5, presetListRow, serializable, n7);
            this.presetPopupData = new PresetPopupData(n2, n3, preset, null, null, -1, null);
        }
    }
}

