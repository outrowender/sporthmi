/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;

class LiValueListAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ LiValueListAsyncNavLocationExtractor this$0;

    LiValueListAsyncNavLocationExtractor$1(LiValueListAsyncNavLocationExtractor liValueListAsyncNavLocationExtractor) {
        this.this$0 = liValueListAsyncNavLocationExtractor;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation != null && navLocation.isPositionValid()) {
            this.this$0.putResultInCommandListMap("navLocation", navLocation, this.getCommandList(), this.logger);
        } else {
            this.logger.log(10000, "LiValueListAsyncNavLocationExtractor#execute - no valid position");
        }
        this.getCommandList().commandFinished();
    }
}

