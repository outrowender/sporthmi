/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PhonenumberInputSequence$10
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$10(PhonenumberInputSequence phonenumberInputSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = phonenumberInputSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        this.val$previewMap.setPreviewPOIsOnboardDistant(new NavLocation[]{navLocation}, 1, null, null);
        this.getCommandList().commandFinished();
    }
}

