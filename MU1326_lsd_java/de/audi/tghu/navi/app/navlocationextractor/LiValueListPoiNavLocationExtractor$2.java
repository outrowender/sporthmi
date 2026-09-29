/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor;
import org.dsi.ifc.navigation.LISpellerData;

class LiValueListPoiNavLocationExtractor$2
extends NavCommand {
    private final /* synthetic */ LiValueListPoiNavLocationExtractor this$0;

    LiValueListPoiNavLocationExtractor$2(LiValueListPoiNavLocationExtractor liValueListPoiNavLocationExtractor) {
        this.this$0 = liValueListPoiNavLocationExtractor;
    }

    @Override
    public void execute() {
        LISpellerData lISpellerData = (LISpellerData)this.getCommandList().get("tempSpellerState");
        this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(lISpellerData));
    }
}

