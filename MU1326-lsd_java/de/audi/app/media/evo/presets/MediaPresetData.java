/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.presets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MediaPresetData
implements Serializable {
    private static final long serialVersionUID;
    private static final int CURRENT_VERSION;
    private int version = 0;
    private int sourceType;
    private String mediaUniqueId;
    private int broweMode;
    private String path;
    private String preset;

    public MediaPresetData(int n, String string, String string2, int n2, String string3) {
        this.broweMode = n;
        this.path = string;
        this.preset = string2;
        this.sourceType = n2;
        this.mediaUniqueId = string3;
    }

    protected int getSourceType() {
        return this.sourceType;
    }

    protected String getMediaUniqueId() {
        return this.mediaUniqueId;
    }

    protected int getBroweMode() {
        return this.broweMode;
    }

    protected String getPath() {
        return this.path;
    }

    protected String getPreset() {
        return this.preset;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.version);
        objectOutputStream.writeInt(this.sourceType);
        objectOutputStream.writeUTF(this.mediaUniqueId);
        objectOutputStream.writeInt(this.broweMode);
        objectOutputStream.writeUTF(this.preset);
        objectOutputStream.writeUTF(this.path);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.version = objectInputStream.readInt();
        this.sourceType = objectInputStream.readInt();
        this.mediaUniqueId = objectInputStream.readUTF();
        this.broweMode = objectInputStream.readInt();
        this.preset = objectInputStream.readUTF();
        this.path = objectInputStream.readUTF();
    }
}

