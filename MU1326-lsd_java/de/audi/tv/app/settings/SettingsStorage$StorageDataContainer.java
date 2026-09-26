/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.settings.SettingsStorage;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class SettingsStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private final /* synthetic */ SettingsStorage this$0;

    SettingsStorage$StorageDataContainer(SettingsStorage settingsStorage, IStorageAccess iStorageAccess) {
        this.this$0 = settingsStorage;
        super(iStorageAccess, 3, 1007, 39);
    }

    @Override
    protected void handleCRC32Error() {
        SettingsStorage.access$100(this.this$0).log(10000, "[SettingsStorage.handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        SettingsStorage.access$100(this.this$0).log(-1601830656, "[SettingsStorage.handleStorageReadError] %1", (Object)exception.getMessage());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        SettingsStorage.access$100(this.this$0).log(1078071040, "[SettingsStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        switch (n) {
            case 3: {
                this.deserializeV3(dataInputStream);
                break;
            }
            case 2: {
                this.deserializeV2(dataInputStream);
                break;
            }
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] subtitle:%1 serviceLinking:%2", SettingsStorage.access$200((SettingsStorage)this.this$0).subtitle, SettingsStorage.access$200((SettingsStorage)this.this$0).serviceLinking);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] visualAudio:%1 ews:%2", SettingsStorage.access$200((SettingsStorage)this.this$0).visualAudio, SettingsStorage.access$200((SettingsStorage)this.this$0).ews);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] tvNorm:%1 avNorm:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvNorm, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avNorm);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] tvAspectRatio:%1 avAspectRatio:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvAspectRatio, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avAspectRatio);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] channelSorting:%1 parentalLevel:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).channelSorting, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).parentalLevel);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] tvBrighness:%1 tvColor:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvBrightness, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvColor);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] tvContrast:%1 tvTint:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvContrast, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvTint);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] avBrighness:%1 avColor:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avBrightness, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avColor);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] avContrast:%1 avTint:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avContrast, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avTint);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.serialize] viewSettings: %1", (Object)SettingsStorage.access$200((SettingsStorage)this.this$0).viewSettings);
        dataOutputStream.writeBoolean(SettingsStorage.access$200((SettingsStorage)this.this$0).subtitle);
        dataOutputStream.writeBoolean(SettingsStorage.access$200((SettingsStorage)this.this$0).serviceLinking);
        dataOutputStream.writeBoolean(SettingsStorage.access$200((SettingsStorage)this.this$0).visualAudio);
        dataOutputStream.writeBoolean(SettingsStorage.access$200((SettingsStorage)this.this$0).ews);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvNorm);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avNorm);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvAspectRatio);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avAspectRatio);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).channelSorting);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).parentalLevel);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvBrightness);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvColor);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvContrast);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).tvTint);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avBrightness);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avColor);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avContrast);
        dataOutputStream.writeInt(SettingsStorage.access$200((SettingsStorage)this.this$0).avTint);
        this.serializeIntArray(SettingsStorage.access$200((SettingsStorage)this.this$0).viewSettings, dataOutputStream);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserialize]");
        this.deserializeV3(dataInputStream);
    }

    private void deserializeV3(DataInputStream dataInputStream) {
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV3]");
        this.deserializeV2(dataInputStream);
        SettingsStorage.access$200((SettingsStorage)this.this$0).viewSettings = this.deserializeIntArray(dataInputStream);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV3] viewSettings: %1", (Object)SettingsStorage.access$200((SettingsStorage)this.this$0).viewSettings);
    }

    private void deserializeV2(DataInputStream dataInputStream) {
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2]");
        SettingsStorage.access$200((SettingsStorage)this.this$0).subtitle = dataInputStream.readBoolean();
        SettingsStorage.access$200((SettingsStorage)this.this$0).serviceLinking = dataInputStream.readBoolean();
        SettingsStorage.access$200((SettingsStorage)this.this$0).visualAudio = dataInputStream.readBoolean();
        SettingsStorage.access$200((SettingsStorage)this.this$0).ews = dataInputStream.readBoolean();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvNorm = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avNorm = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvAspectRatio = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avAspectRatio = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).channelSorting = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).parentalLevel = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvBrightness = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvColor = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvContrast = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).tvTint = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avBrightness = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avColor = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avContrast = dataInputStream.readInt();
        SettingsStorage.access$200((SettingsStorage)this.this$0).avTint = dataInputStream.readInt();
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] subtitle:%1 serviceLinking:%2", SettingsStorage.access$200((SettingsStorage)this.this$0).subtitle, SettingsStorage.access$200((SettingsStorage)this.this$0).serviceLinking);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] visualAudio:%1 ews:%2", SettingsStorage.access$200((SettingsStorage)this.this$0).visualAudio, SettingsStorage.access$200((SettingsStorage)this.this$0).ews);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] tvNorm:%1 avNorm:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvNorm, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avNorm);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] tvAspectRatio:%1 avAspectRatio:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvAspectRatio, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avAspectRatio);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] channelSorting:%1 parentalLevel:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).channelSorting, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).parentalLevel);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] tvBrighness:%1 tvColor:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvBrightness, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvColor);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] tvContrast:%1 tvTint:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvContrast, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).tvTint);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] avBrighness:%1 avColor:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avBrightness, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avColor);
        SettingsStorage.access$100(this.this$0).log(-2137614336, "[SettingsStorage.deserializeV2] avContrast:%1 avTint:%2", (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avContrast, (long)SettingsStorage.access$200((SettingsStorage)this.this$0).avTint);
    }
}

