/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

class SearchResultAsyncNavLocationExtractor$2
extends NavCommand {
    private final /* synthetic */ SearchResult val$searchResult;
    private final /* synthetic */ SearchResultAsyncNavLocationExtractor this$0;

    SearchResultAsyncNavLocationExtractor$2(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, String string, SearchResult searchResult) {
        this.this$0 = searchResultAsyncNavLocationExtractor;
        this.val$searchResult = searchResult;
        super(string);
    }

    @Override
    public void execute() {
        Token token = Util.extractTokenFromSearchresult(this.val$searchResult, 19);
        Token token2 = Util.extractTokenFromSearchresult(this.val$searchResult, 18);
        try {
            int n = Integer.parseInt(token.token);
            int n2 = Integer.parseInt(token2.token);
            NavLocation navLocation = Util.getLocationFromGeoPos(n, n2);
            this.getCommandList().commandFinishedWithPostCommand(new LIGetLocationDescriptionTransformCommand(navLocation));
        }
        catch (NumberFormatException numberFormatException) {
            this.getCommandList().commandAborted(new StringBuffer().append("No valid longitude/latitude from SearchResult extractable: ").append(numberFormatException).toString());
        }
    }
}

