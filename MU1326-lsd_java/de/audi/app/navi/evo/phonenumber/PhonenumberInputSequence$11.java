/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$11
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$11(PhonenumberInputSequence phonenumberInputSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = phonenumberInputSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        this.val$previewMap.setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

