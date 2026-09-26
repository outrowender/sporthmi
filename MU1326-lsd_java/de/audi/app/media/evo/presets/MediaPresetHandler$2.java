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

class MediaPresetHandler$2
implements IPresetManager {
    private final /* synthetic */ String[] val$parameters;
    private final /* synthetic */ MediaPresetHandler this$0;

    MediaPresetHandler$2(MediaPresetHandler mediaPresetHandler, String[] stringArray) {
        this.this$0 = mediaPresetHandler;
        this.val$parameters = stringArray;
    }

    @Override
    public void responseExecute(ExecuteRequest executeRequest, int n) {
    }

    @Override
    public void responseDefine(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        MediaPresetHandler.access$000(this.this$0).log(1078071040, "[%1.executeDiagCommand]", (Object)"MediaPresetHandler");
        MediaPresetHandler.access$200(this.this$0).put(this.val$parameters[0], serializable);
    }

    @Override
    public void favoriteDefinitionChanged(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
    }
}

