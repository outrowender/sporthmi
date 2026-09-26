/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.Preset;
import de.eso.widgets.preset.PresetManagerNAR;
import de.eso.widgets.preset.PresetPopupData;
import java.io.Serializable;

class PresetManagerNAR$1
implements Runnable {
    private final /* synthetic */ DefinitionRequest val$request;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ Serializable val$data;
    private final /* synthetic */ PresetListRow val$preview;
    private final /* synthetic */ int val$executionType;
    private final /* synthetic */ PresetManagerNAR this$0;

    PresetManagerNAR$1(PresetManagerNAR presetManagerNAR, DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        this.this$0 = presetManagerNAR;
        this.val$request = definitionRequest;
        this.val$result = n;
        this.val$data = serializable;
        this.val$preview = presetListRow;
        this.val$executionType = n2;
    }

    @Override
    public void run() {
        int n = this.val$request.getPresetIndex();
        Preset preset = new Preset(1, -1, 0, null, null, 1);
        PresetPopupData presetPopupData = new PresetPopupData(0, -19456, preset, null, null, -1, null);
        this.this$0.getPresetStorageProvider().setPresetPopupDataToStore(n, presetPopupData);
        this.this$0.responseDefineEvent(this.val$request, this.val$result, this.val$data, this.val$preview, this.val$executionType);
        this.this$0.getPresetStorageProvider().saveToPersistence(n);
    }
}

