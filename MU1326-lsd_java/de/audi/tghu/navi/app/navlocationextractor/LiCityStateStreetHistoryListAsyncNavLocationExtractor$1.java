/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiCityStateStreetHistoryListAsyncNavLocationExtractor;

class LiCityStateStreetHistoryListAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ LiCityStateStreetHistoryListAsyncNavLocationExtractor this$0;

    LiCityStateStreetHistoryListAsyncNavLocationExtractor$1(LiCityStateStreetHistoryListAsyncNavLocationExtractor liCityStateStreetHistoryListAsyncNavLocationExtractor) {
        this.this$0 = liCityStateStreetHistoryListAsyncNavLocationExtractor;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        this.this$0.putResultInCommandListMap("navLocation", object, this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

