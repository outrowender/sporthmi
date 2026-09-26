/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

class SearchResultAsyncNavLocationExtractor$3
extends NavCommand {
    private final /* synthetic */ SearchResult val$searchResult;
    private final /* synthetic */ SearchResultAsyncNavLocationExtractor this$0;

    SearchResultAsyncNavLocationExtractor$3(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, String string, SearchResult searchResult) {
        this.this$0 = searchResultAsyncNavLocationExtractor;
        this.val$searchResult = searchResult;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        Token token = Util.extractTokenFromSearchresult(this.val$searchResult, 5);
        Util.setOnlinePOINameOnLocation(navLocation, token.getToken());
        this.this$0.putResultInCommandListMap("navLocation", navLocation, this.getCommandList(), this.logger);
        this.getCommandList().commandFinished();
    }
}

