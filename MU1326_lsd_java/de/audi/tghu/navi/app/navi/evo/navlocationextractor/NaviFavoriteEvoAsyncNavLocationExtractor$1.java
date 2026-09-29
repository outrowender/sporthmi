/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navi.evo.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navi.evo.navlocationextractor.NaviFavoriteEvoAsyncNavLocationExtractor;

class NaviFavoriteEvoAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ NaviFavoriteEvoAsyncNavLocationExtractor this$0;

    NaviFavoriteEvoAsyncNavLocationExtractor$1(NaviFavoriteEvoAsyncNavLocationExtractor naviFavoriteEvoAsyncNavLocationExtractor, String string) {
        this.this$0 = naviFavoriteEvoAsyncNavLocationExtractor;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("STREAMED_LOCATION");
        NaviFavoriteEvoAsyncNavLocationExtractor.access$000(this.this$0, "navLocation", object, this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

