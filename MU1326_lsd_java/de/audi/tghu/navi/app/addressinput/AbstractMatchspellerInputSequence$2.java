/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractMatchspellerInputSequence$2
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ AbstractMatchspellerInputSequence this$0;

    AbstractMatchspellerInputSequence$2(AbstractMatchspellerInputSequence abstractMatchspellerInputSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = abstractMatchspellerInputSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        this.val$previewMap.setPreviewLocation(navLocation, 1, null, null);
        this.getCommandList().commandFinished();
    }
}

