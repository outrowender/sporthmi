/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.tghu.navi.app.command.CreateTryMatchCommand$1;
import de.audi.tghu.navi.app.command.LITryMatchLocationCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class CreateTryMatchCommand
extends NavCommand {
    private final NavLocationsCache cache;
    private final SearchResult result;

    public CreateTryMatchCommand(SearchResult searchResult, NavLocationsCache navLocationsCache) {
        this.result = searchResult;
        this.cache = navLocationsCache;
    }

    @Override
    public void execute() {
        TryMatchLocationResultData[] tryMatchLocationResultDataArray;
        Token[] tokenArray = this.result.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 6);
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 4);
        Token token3 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 1);
        Token token4 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 2);
        Token token5 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 3);
        Token token6 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 103);
        Token token7 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7);
        Token token8 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
        TryMatchLocationData tryMatchLocationData = new TryMatchLocationData(Util.degreeStringToWgs84(String.valueOf(this.result.getPosition().getLat())), Util.degreeStringToWgs84(String.valueOf(this.result.getPosition().getLon())), token7 != null ? token7.getToken() : null, null, token5 != null ? token5.getToken() : null, token3 != null ? token3.getToken() : null, this.result.getCountry() != null ? this.result.getCountry().getName() : null, null, token != null ? token.getToken() : null, token8 != null ? token8.getToken() : null, this.result.poiType, token2 != null ? token2.getToken() : null, null, 0, null, token4 != null ? token4.getToken() : null);
        if (token6 != null) {
            tryMatchLocationData.junction = token6.getToken();
        }
        if ((tryMatchLocationResultDataArray = this.cache.getCachedData(tryMatchLocationData)) != null && tryMatchLocationResultDataArray.length > 0) {
            CreateTryMatchCommand$1 createTryMatchCommand$1 = new CreateTryMatchCommand$1(this, "SearchResultAsyncNavLocationExtractor#GetCachedTryMatchLocationResultDataCommand", tryMatchLocationResultDataArray);
            this.getCommandList().commandFinishedWithPostCommand(createTryMatchCommand$1);
            return;
        }
        this.getCommandList().commandFinishedWithPostCommand(new LITryMatchLocationCommand(tryMatchLocationData, this.cache));
    }
}

