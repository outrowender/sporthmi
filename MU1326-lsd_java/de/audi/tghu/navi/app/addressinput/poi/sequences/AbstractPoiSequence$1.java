/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractPoiSequence$1
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMapInterface;
    private final /* synthetic */ AbstractPoiSequence this$0;

    AbstractPoiSequence$1(AbstractPoiSequence abstractPoiSequence, IPreviewMap iPreviewMap) {
        this.this$0 = abstractPoiSequence;
        this.val$previewMapInterface = iPreviewMap;
    }

    @Override
    public void execute() {
        this.val$previewMapInterface.setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 1, null, null);
        this.getCommandList().commandFinished();
    }
}

