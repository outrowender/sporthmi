/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;

class AbstractAddressInputMatchSpellerSequence$7
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ AbstractAddressInputMatchSpellerSequence this$0;

    AbstractAddressInputMatchSpellerSequence$7(AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = abstractAddressInputMatchSpellerSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        this.val$previewMap.setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

