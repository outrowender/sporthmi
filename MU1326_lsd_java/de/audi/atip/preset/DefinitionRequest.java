/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.IPresetManager;
import java.io.Serializable;

public class DefinitionRequest {
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR = 1;
    public static final int RESULT_NOT_POSSIBLE = 2;
    public static final int RESULT_NOT_POSSIBLE_MAIN_ENTRY = 3;
    private final int type;
    private final int modelId;
    private final int rowId;
    private final int smEvent;
    private final PresetListRow preview;
    private final IPresetManager manager;
    private int presetIndex;

    public DefinitionRequest(IPresetManager iPresetManager, int n, int n2, int n3, int n4, PresetListRow presetListRow) {
        this.manager = iPresetManager;
        this.type = n;
        this.modelId = n2;
        this.rowId = n3;
        this.smEvent = n4;
        this.preview = presetListRow;
    }

    public final int getType() {
        return this.type;
    }

    public final int getModelId() {
        return this.modelId;
    }

    public final int getRowId() {
        return this.rowId;
    }

    public final int getSMEvent() {
        return this.smEvent;
    }

    public final PresetListRow getPreview() {
        return this.preview;
    }

    public final void responseDefine(int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        this.manager.responseDefine(this, n, serializable, presetListRow, n2);
    }

    public int getPresetIndex() {
        return this.presetIndex;
    }

    public void setPresetIndex(int n) {
        this.presetIndex = n;
    }

    public String toString() {
        return "DefinitionRequest [type=" + this.type + ", modelId=" + this.modelId + ", rowId=" + this.rowId + ", smEvent=" + this.smEvent + ", preview=" + this.preview + "]";
    }
}

