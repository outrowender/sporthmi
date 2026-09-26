/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;

class SearchResultAsyncNavLocationExtractor$1
extends NavCommand {
    private final /* synthetic */ SearchResultAsyncNavLocationExtractor this$0;

    SearchResultAsyncNavLocationExtractor$1(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, String string) {
        this.this$0 = searchResultAsyncNavLocationExtractor;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("STREAMED_LOCATION");
        this.this$0.putResultInCommandListMap("navLocation", object, this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

