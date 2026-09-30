/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.base.TVEnv;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SettingsStorage {
    private static final int VERSION = 3;
    private final LogChannel lc;
    private final StorageDataContainer container;
    private final SettingsData settingsData = new SettingsData();
    private final TVEnv env;

    SettingsStorage(TVEnv tVEnv) {
        this.env = tVEnv;
        this.lc = tVEnv.lcMain;
        this.container = new StorageDataContainer(tVEnv.framework.getStorageMgr());
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
        this.lc.log(10000000, "[SettingsStorage.loadParentalPassword] trying to load password.");
        return this.env.framework.getStorageMgr().getString(1002, 19, string);
    }

    public void saveParentalPassword(String string) {
        this.lc.log(10000000, "[SettingsStorage.saveParentalPassword] %1.", (Object)string);
        this.env.framework.getStorageMgr().setString(1002, 19, string);
    }

    private static class SettingsData {
        volatile boolean subtitle = false;
        volatile boolean serviceLinking = true;
        volatile boolean visualAudio = true;
        volatile boolean ews = true;
        volatile int tvNorm = 100;
        volatile int avNorm = 0;
        volatile int tvAspectRatio = 0;
        volatile int avAspectRatio = 1;
        volatile int channelSorting = 0;
        volatile int parentalLevel = 0;
        volatile int tvBrightness = 0;
        volatile int tvColor = 0;
        volatile int tvContrast = 0;
        volatile int tvTint = 0;
        volatile int avBrightness = 0;
        volatile int avColor = 0;
        volatile int avContrast = 0;
        volatile int avTint = 0;
        volatile int[] viewSettings = new int[0];

        private SettingsData() {
        }
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        StorageDataContainer(IStorageAccess iStorageAccess) {
            super(iStorageAccess, 3, 1007, 39);
        }

        protected void handleCRC32Error() {
            SettingsStorage.this.lc.log(10000, "[SettingsStorage.handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
            SettingsStorage.this.lc.log(100000, "[SettingsStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            SettingsStorage.this.lc.log(1000000, "[SettingsStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
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

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] subtitle:%1 serviceLinking:%2", ((SettingsStorage)SettingsStorage.this).settingsData.subtitle, ((SettingsStorage)SettingsStorage.this).settingsData.serviceLinking);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] visualAudio:%1 ews:%2", ((SettingsStorage)SettingsStorage.this).settingsData.visualAudio, ((SettingsStorage)SettingsStorage.this).settingsData.ews);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] tvNorm:%1 avNorm:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvNorm, (long)((SettingsStorage)SettingsStorage.this).settingsData.avNorm);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] tvAspectRatio:%1 avAspectRatio:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvAspectRatio, (long)((SettingsStorage)SettingsStorage.this).settingsData.avAspectRatio);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] channelSorting:%1 parentalLevel:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.channelSorting, (long)((SettingsStorage)SettingsStorage.this).settingsData.parentalLevel);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] tvBrighness:%1 tvColor:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvBrightness, (long)((SettingsStorage)SettingsStorage.this).settingsData.tvColor);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] tvContrast:%1 tvTint:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvContrast, (long)((SettingsStorage)SettingsStorage.this).settingsData.tvTint);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] avBrighness:%1 avColor:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.avBrightness, (long)((SettingsStorage)SettingsStorage.this).settingsData.avColor);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] avContrast:%1 avTint:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.avContrast, (long)((SettingsStorage)SettingsStorage.this).settingsData.avTint);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.serialize] viewSettings: %1", (Object)((SettingsStorage)SettingsStorage.this).settingsData.viewSettings);
            dataOutputStream.writeBoolean(((SettingsStorage)SettingsStorage.this).settingsData.subtitle);
            dataOutputStream.writeBoolean(((SettingsStorage)SettingsStorage.this).settingsData.serviceLinking);
            dataOutputStream.writeBoolean(((SettingsStorage)SettingsStorage.this).settingsData.visualAudio);
            dataOutputStream.writeBoolean(((SettingsStorage)SettingsStorage.this).settingsData.ews);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvNorm);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avNorm);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvAspectRatio);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avAspectRatio);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.channelSorting);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.parentalLevel);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvBrightness);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvColor);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvContrast);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.tvTint);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avBrightness);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avColor);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avContrast);
            dataOutputStream.writeInt(((SettingsStorage)SettingsStorage.this).settingsData.avTint);
            this.serializeIntArray(((SettingsStorage)SettingsStorage.this).settingsData.viewSettings, dataOutputStream);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserialize]");
            this.deserializeV3(dataInputStream);
        }

        private void deserializeV3(DataInputStream dataInputStream) throws IOException {
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV3]");
            this.deserializeV2(dataInputStream);
            ((SettingsStorage)SettingsStorage.this).settingsData.viewSettings = this.deserializeIntArray(dataInputStream);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV3] viewSettings: %1", (Object)((SettingsStorage)SettingsStorage.this).settingsData.viewSettings);
        }

        private void deserializeV2(DataInputStream dataInputStream) throws IOException {
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2]");
            ((SettingsStorage)SettingsStorage.this).settingsData.subtitle = dataInputStream.readBoolean();
            ((SettingsStorage)SettingsStorage.this).settingsData.serviceLinking = dataInputStream.readBoolean();
            ((SettingsStorage)SettingsStorage.this).settingsData.visualAudio = dataInputStream.readBoolean();
            ((SettingsStorage)SettingsStorage.this).settingsData.ews = dataInputStream.readBoolean();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvNorm = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avNorm = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvAspectRatio = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avAspectRatio = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.channelSorting = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.parentalLevel = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvBrightness = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvColor = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvContrast = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.tvTint = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avBrightness = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avColor = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avContrast = dataInputStream.readInt();
            ((SettingsStorage)SettingsStorage.this).settingsData.avTint = dataInputStream.readInt();
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] subtitle:%1 serviceLinking:%2", ((SettingsStorage)SettingsStorage.this).settingsData.subtitle, ((SettingsStorage)SettingsStorage.this).settingsData.serviceLinking);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] visualAudio:%1 ews:%2", ((SettingsStorage)SettingsStorage.this).settingsData.visualAudio, ((SettingsStorage)SettingsStorage.this).settingsData.ews);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] tvNorm:%1 avNorm:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvNorm, (long)((SettingsStorage)SettingsStorage.this).settingsData.avNorm);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] tvAspectRatio:%1 avAspectRatio:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvAspectRatio, (long)((SettingsStorage)SettingsStorage.this).settingsData.avAspectRatio);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] channelSorting:%1 parentalLevel:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.channelSorting, (long)((SettingsStorage)SettingsStorage.this).settingsData.parentalLevel);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] tvBrighness:%1 tvColor:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvBrightness, (long)((SettingsStorage)SettingsStorage.this).settingsData.tvColor);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] tvContrast:%1 tvTint:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.tvContrast, (long)((SettingsStorage)SettingsStorage.this).settingsData.tvTint);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] avBrighness:%1 avColor:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.avBrightness, (long)((SettingsStorage)SettingsStorage.this).settingsData.avColor);
            SettingsStorage.this.lc.log(10000000, "[SettingsStorage.deserializeV2] avContrast:%1 avTint:%2", (long)((SettingsStorage)SettingsStorage.this).settingsData.avContrast, (long)((SettingsStorage)SettingsStorage.this).settingsData.avTint);
        }
    }
}

