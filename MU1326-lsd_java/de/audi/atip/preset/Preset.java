/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.hmi.model.PresetListRow;
import java.io.Serializable;

public final class Preset {
    public static final int NUMBER_OF_TYPES;
    public static final String[] TYPE_NAMES;
    public static final int TYPE_UNDEFINED;
    public static final int TYPE_SMI;
    public static final int TYPE_LIST;
    public static final int TYPE_MAP;
    public static final int TYPE_CHECKBOX;
    public static final int NUMBER_OF_EXECUTION_TYPES;
    public static final int EXECUTION_TYPE_UNDEFINED;
    public static final int EXECUTION_TYPE_RADIO;
    public static final int EXECUTION_TYPE_MEDIA;
    public static final int EXECUTION_TYPE_TELEPHONE;
    public static final int EXECUTION_TYPE_NAVI;
    public static final int EXECUTION_TYPE_MAP;
    public static final int EXECUTION_TYPE_ONLINE;
    public static final int EXECUTION_TYPE_TV;
    private static final int NO_ICON;
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
        return new StringBuffer().append("Preset [type=").append(this.type).append(", modelId=").append(this.modelId).append(", smEvent=").append(this.smEvent).append(", preview=").append(this.preview).append("]").toString();
    }

    static {
        TYPE_NAMES = new String[]{"SMI", "LIST", "MAP", "CHECKBOX"};
    }
}

