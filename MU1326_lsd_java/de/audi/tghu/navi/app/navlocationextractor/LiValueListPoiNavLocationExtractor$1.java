/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor;

class LiValueListPoiNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ LiValueListPoiNavLocationExtractor this$0;

    LiValueListPoiNavLocationExtractor$1(LiValueListPoiNavLocationExtractor liValueListPoiNavLocationExtractor) {
        this.this$0 = liValueListPoiNavLocationExtractor;
    }

    @Override
    public void execute() {
        this.getCommandList().put("tempSpellerState", this.dsiResponseContainer.getSpellerState());
        this.getCommandList().commandFinished();
    }
}

