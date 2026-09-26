/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.IPresetManager;
import java.io.Serializable;

public class DefinitionRequest {
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_NOT_POSSIBLE;
    public static final int RESULT_NOT_POSSIBLE_MAIN_ENTRY;
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
        return new StringBuffer().append("DefinitionRequest [type=").append(this.type).append(", modelId=").append(this.modelId).append(", rowId=").append(this.rowId).append(", smEvent=").append(this.smEvent).append(", preview=").append(this.preview).append("]").toString();
    }
}

