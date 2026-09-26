/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.Preset;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.eso.widgets.preset.PresetStorageProvider;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class PresetStorageProvider$PresetStorage
extends AbstractStorageDataContainer {
    private static final int VERSION;
    private IPresetPopupData presetPopupData;
    private final /* synthetic */ PresetStorageProvider this$0;

    public PresetStorageProvider$PresetStorage(PresetStorageProvider presetStorageProvider, int n) {
        this.this$0 = presetStorageProvider;
        super(PresetStorageProvider.access$000(presetStorageProvider), 3, 1011, n);
        this.presetPopupData = this.this$0.getNoEntryStoredPresetPopupData();
    }

    public void setData(IPresetPopupData iPresetPopupData) {
        this.presetPopupData = iPresetPopupData;
    }

    public IPresetPopupData getData() {
        return this.presetPopupData;
    }

    @Override
    protected void handleCRC32Error() {
        PresetStorageProvider.access$100().log(10000, "PresetStorage#handleCRC32Error");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        PresetStorageProvider.access$100().log(-1601830656, "PresetStorage#handleStorageReadError error reading preset, cannot read preset, %1", (Throwable)exception);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        PresetStorageProvider.access$100().log(1078071040, "PresetStorage#convertContainer versions are different presisted version: %1 container version: %2", (long)n, (long)n2);
        this.presetPopupData = new PresetPopupData(8, -1, new Preset(-1, 0, 0, null, null, 99), null, null, -1, null);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        PresetStorageProvider.access$100().log(-2137614336, "PresetStorage#serialize");
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
    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        PresetStorageProvider.access$100().log(-2137614336, "PresetStorage#deserialize");
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
            PresetStorageProvider.access$100().log(10000, "PresetStorage#deserialize Exception occured, preset data cannot be read. %1", (Throwable)exception);
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

