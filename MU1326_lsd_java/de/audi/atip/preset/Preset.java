/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.hmi.model.PresetListRow;
import java.io.Serializable;

public final class Preset {
    public static final int NUMBER_OF_TYPES = 4;
    public static final String[] TYPE_NAMES = new String[]{"SMI", "LIST", "MAP", "CHECKBOX"};
    public static final int TYPE_UNDEFINED = -1;
    public static final int TYPE_SMI = 0;
    public static final int TYPE_LIST = 1;
    public static final int TYPE_MAP = 2;
    public static final int TYPE_CHECKBOX = 3;
    public static final int NUMBER_OF_EXECUTION_TYPES = 7;
    public static final int EXECUTION_TYPE_UNDEFINED = 99;
    public static final int EXECUTION_TYPE_RADIO = 1;
    public static final int EXECUTION_TYPE_MEDIA = 2;
    public static final int EXECUTION_TYPE_TELEPHONE = 3;
    public static final int EXECUTION_TYPE_NAVI = 4;
    public static final int EXECUTION_TYPE_MAP = 5;
    public static final int EXECUTION_TYPE_ONLINE = 6;
    public static final int EXECUTION_TYPE_TV = 7;
    private static final int NO_ICON = 99;
    private final int type;
    private int modelId = -1;
    private int iconType = 99;
    private int smEvent = -1;
    private final PresetListRow preview;
    private final Serializable data;
    private final int executionType;

    public static Preset deserialize(byte[] byArray) {
        return null;
    }

    public Preset(int n, int n2, int n3, PresetListRow presetListRow, Serializable serializable, int n4) {
        this.type = n;
        this.modelId = n2;
        this.smEvent = n3;
        this.preview = presetListRow;
        this.data = serializable;
        this.executionType = n4;
        this.iconType = n4;
    }

    public int getType() {
        return this.type;
    }

    public int getModelId() {
        return this.modelId;
    }

    public int getIconType() {
        return this.iconType;
    }

    public int getSMEvent() {
        return this.smEvent;
    }

    public int getExecutionType() {
        return this.executionType;
    }

    public PresetListRow getPreview() {
        return this.preview;
    }

    public Serializable getData() {
        return this.data;
    }

    public byte[] serialize() {
        return null;
    }

    public String toString() {
        return "Preset [type=" + this.type + ", modelId=" + this.modelId + ", smEvent=" + this.smEvent + ", preview=" + this.preview + "]";
    }
}

