/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.tghu.navi.app.command.LITryMatchLocationCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache;
import de.audi.tghu.navi.app.util.LocationFormatter;
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
            NavCommand navCommand = new NavCommand("SearchResultAsyncNavLocationExtractor#GetCachedTryMatchLocationResultDataCommand"){

                public void execute() {
                    this.logger.log(1000000, "SearchResultAsyncNavLocationExtractor#GetCachedLiTryMatchLocationResultDataCommand#execute() cachedResponse[0].matchLevel: %2, cachedResponse.length: %3, cachedResponse[0].getLocation(): %1", (Object)LocationFormatter.formatLocationShort(tryMatchLocationResultDataArray[0].getLocation()), (long)tryMatchLocationResultDataArray[0].matchLevel, (long)tryMatchLocationResultDataArray.length);
                    this.dsiResponseContainer.setTryMatchLocationResultData(tryMatchLocationResultDataArray);
                    this.getCommandList().commandFinished();
                }
            };
            this.getCommandList().commandFinishedWithPostCommand(navCommand);
            return;
        }
        this.getCommandList().commandFinishedWithPostCommand(new LITryMatchLocationCommand(tryMatchLocationData, this.cache));
    }
}

