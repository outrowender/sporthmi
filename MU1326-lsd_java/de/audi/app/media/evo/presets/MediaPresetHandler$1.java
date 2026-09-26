/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.presets;

import de.audi.app.media.evo.presets.MediaPresetHandler;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

class MediaPresetHandler$1
implements IFavoritePlayerSelectionListener {
    private final /* synthetic */ MediaPresetHandler this$0;

    MediaPresetHandler$1(MediaPresetHandler mediaPresetHandler) {
        this.this$0 = mediaPresetHandler;
    }

    @Override
    public void playFavoriteSelectionDone(boolean bl) {
        MediaPresetHandler.access$000(this.this$0).log(1078071040, "[%1.playFavoriteSelectionDone] %2", (Object)"MediaPresetHandler", (Object)(bl ? "OK" : "NOK"));
        this.this$0.getTerminal().getAudioManager().requestAudioFocus();
        ChoiceModelApp choiceModelApp = this.this$0.getChoiceModel(-1089469696);
        choiceModelApp.setValue(0);
        if (!bl) {
            choiceModelApp.setValue(1);
            this.this$0.getChoiceModel(873530112).setStatus(1);
        }
        MediaPresetHandler.access$100(this.this$0).responseExecute(bl ? 0 : 1);
    }
}

