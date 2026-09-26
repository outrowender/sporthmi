/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;

class SearchResultAsyncNavLocationExtractor$4
extends NavCommand {
    private final /* synthetic */ SearchResultAsyncNavLocationExtractor this$0;

    SearchResultAsyncNavLocationExtractor$4(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor) {
        this.this$0 = searchResultAsyncNavLocationExtractor;
    }

    @Override
    public void execute() {
        this.this$0.putResultInCommandListMap("navLocation", SearchResultAsyncNavLocationExtractor.access$000(this.this$0, this.dsiResponseContainer), this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

