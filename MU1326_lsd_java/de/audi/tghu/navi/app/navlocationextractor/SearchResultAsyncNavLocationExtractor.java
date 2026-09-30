/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.CreateTryMatchCommand;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache;
import de.audi.tghu.navi.app.rows.AdbEntryListRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class SearchResultAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private ICommandListFactory commandListFactory;
    private INaviFavoriteHandler naviFavoriteHandler;
    protected NavLocationsCache cache;
    private AdbEntryAsyncNavLocationExtractor adbExtractor;

    public SearchResultAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler) {
        this.adbExtractor = new AdbEntryAsyncNavLocationExtractor(iCommandListFactory);
        this.cache = new NavLocationsCache();
        this.commandListFactory = iCommandListFactory;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
    }

    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        if (evoListRow instanceof AdbEntryListRow) {
            return this.adbExtractor.getExtractNavLocationCL(evoListRow, n);
        }
        SearchResultListRow searchResultListRow = (SearchResultListRow)evoListRow;
        if (searchResultListRow.getNodeType() == 1) {
            return null;
        }
        SearchResult searchResult = searchResultListRow.getSearchResult();
        if (searchResult.getSource() == 14) {
            return null;
        }
        if (searchResult.getSource() == 5) {
            return this.getCLForFavorite(searchResult, n);
        }
        if (searchResult.getSource() == 4) {
            return this.getCLForHistory(searchResult, n);
        }
        if (searchResult.getSource() == 15) {
            return this.getCLForPoiCall(searchResult, n);
        }
        return this.getResolveNavLocationCL(searchResult, n);
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof SearchResultListRow) && !(evoListRow instanceof AdbEntryListRow)) {
            throw new IllegalArgumentException("This NavlocationExtractor works only with SearchResultListRow and AdbEntryListRow objects");
        }
    }

    private CommandList getCLForFavorite(SearchResult searchResult, int n) {
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new StreamToLocationCommand(this.naviFavoriteHandler.getFavoriteNavLocationStreamByUniqueId(searchResult.dataId)));
        commandList.add(this.getStoreDeserializedNavLocationInCmdListMapCommand());
        return commandList;
    }

    private CommandList getCLForHistory(SearchResult searchResult, int n) {
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new StreamToLocationCommand(searchResult.applicationData));
        commandList.add(this.getStoreDeserializedNavLocationInCmdListMapCommand());
        return commandList;
    }

    private NavCommand getStoreDeserializedNavLocationInCmdListMapCommand() {
        return new NavCommand("SearchResultAsyncNavLocationExtractor#StoreDeserializedNavLocationInCmdListMap"){

            public void execute() {
                Object object = this.getCommandList().get("STREAMED_LOCATION");
                SearchResultAsyncNavLocationExtractor.this.putResultInCommandListMap("navLocation", object, this.getCommandList(), this.logger);
                this.getCommandList().commandFinished();
            }
        };
    }

    private CommandList getCLForPoiCall(final SearchResult searchResult, int n) {
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new NavCommand("SearchResultAsyncNavLocationExtractor#ExtractNavLocationFromPoiCallSearchResult"){

            public void execute() {
                Token token = Util.extractTokenFromSearchresult(searchResult, 19);
                Token token2 = Util.extractTokenFromSearchresult(searchResult, 18);
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
        });
        commandList.add(new NavCommand("SearchResultAsyncNavLocationExtractor#StoreTransformedNavLocdationInCmdListMap"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
                Token token = Util.extractTokenFromSearchresult(searchResult, 5);
                Util.setOnlinePOINameOnLocation(navLocation, token.getToken());
                SearchResultAsyncNavLocationExtractor.this.putResultInCommandListMap("navLocation", navLocation, this.getCommandList(), this.logger);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private CommandList getResolveNavLocationCL(SearchResult searchResult, int n) {
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new CreateTryMatchCommand(searchResult, this.cache));
        commandList.add(new NavCommand(){

            public void execute() {
                SearchResultAsyncNavLocationExtractor.this.putResultInCommandListMap("navLocation", SearchResultAsyncNavLocationExtractor.this.getNavLocationFromLiTryMatchLocation(this.dsiResponseContainer), this.getCommandList(), this.logger);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private NavLocation getNavLocationFromLiTryMatchLocation(DSIResponseContainer dSIResponseContainer) {
        TryMatchLocationResultData[] tryMatchLocationResultDataArray = dSIResponseContainer.getTryMatchLocationResultData();
        if (tryMatchLocationResultDataArray == null || tryMatchLocationResultDataArray.length == 0 || tryMatchLocationResultDataArray[0].getLocation() == null) {
            return null;
        }
        return tryMatchLocationResultDataArray[0].getLocation();
    }
}

