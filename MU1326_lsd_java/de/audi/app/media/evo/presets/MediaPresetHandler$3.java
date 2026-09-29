/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.presets;

import de.audi.app.media.evo.presets.MediaPresetHandler;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IPresetManager;
import java.io.Serializable;

class MediaPresetHandler$3
implements IPresetManager {
    private final /* synthetic */ MediaPresetHandler this$0;

    MediaPresetHandler$3(MediaPresetHandler mediaPresetHandler) {
        this.this$0 = mediaPresetHandler;
    }

    @Override
    public void responseDefine(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        MediaPresetHandler.access$000(this.this$0).log(1078071040, "[%1.responseDefine]", (Object)"MediaPresetHandler");
    }

    @Override
    public void responseExecute(ExecuteRequest executeRequest, int n) {
        MediaPresetHandler.access$000(this.this$0).log(1078071040, "[%1.responseExecute]", (Object)"MediaPresetHandler");
    }

    @Override
    public void favoriteDefinitionChanged(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
    }
}

