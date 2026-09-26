/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.util.NaviCellPropsContainer;
import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class SearchResultFormatterNavDb
extends AbstractSearchResultFormatter {
    private final InterAppService naviInterAppService;
    protected final LogChannel lc;
    private final IconHandler iconHandler;
    private final INaviFavoriteHandler naviFavoriteHandler;
    private final NavigationEnv env;

    public SearchResultFormatterNavDb(InterAppService interAppService, IconHandler iconHandler, LogChannel logChannel, INaviFavoriteHandler iNaviFavoriteHandler, NavigationEnv navigationEnv) {
        this.naviInterAppService = interAppService;
        this.iconHandler = iconHandler;
        this.lc = logChannel;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.env = navigationEnv;
    }

    @Override
    public SearchResultListRow formatResult(SearchResult searchResult) {
        if (null == searchResult) {
            this.lc.log(10000, "SearchResultFormatterNavDb#formatResult - Search-result parameter is null");
            return null;
        }
        NaviSearchResultListRow naviSearchResultListRow = new NaviSearchResultListRow(searchResult);
        this.setGeoData(naviSearchResultListRow, searchResult);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(searchResult, this.env);
        this.configureLayout(searchResult, naviSearchResultListRow);
        naviSearchResultListRow.setTextLine1Column(new TextListCellHighlightText(locationFormattingResponse.getFirstLineForTruffles().getText(), locationFormattingResponse.getFirstLineForTruffles().getTextHighlightIndices()));
        naviSearchResultListRow.setTextLine2Column(new TextListCellHighlightText(locationFormattingResponse.getSecondLineForTruffles().getText(), locationFormattingResponse.getSecondLineForTruffles().getTextHighlightIndices()));
        this.setPropertyCell(naviSearchResultListRow, searchResult);
        return naviSearchResultListRow;
    }

    protected void setPropertyCell(NaviSearchResultListRow naviSearchResultListRow, SearchResult searchResult) {
        NaviCellPropsContainer naviCellPropsContainer = new NaviCellPropsContainer();
        if (searchResult.getSource() == 5) {
            naviCellPropsContainer.setCategory(160082217);
            naviCellPropsContainer.addProperty(633713380);
        } else if (searchResult.entryType == 2) {
            naviCellPropsContainer.setCategory(819717694);
        } else {
            naviCellPropsContainer.setCategory(160082217);
        }
        if (searchResult.getSource() == 4) {
            naviCellPropsContainer.addProperty(-1251985266);
        }
        PropertyListCell propertyListCell = new PropertyListCell(naviCellPropsContainer.getCategory(), naviCellPropsContainer.getProperties());
        naviSearchResultListRow.setPropertiesColumn(propertyListCell);
    }

    protected void configureLayout(SearchResult searchResult, NaviSearchResultListRow naviSearchResultListRow) {
        if (searchResult.source == 14) {
            naviSearchResultListRow.setLayout(1);
            naviSearchResultListRow.setStaticIcon(5);
        } else if (searchResult.source == 4 && searchResult.entryType == 2) {
            naviSearchResultListRow.setLayout(4);
        } else if (searchResult.source == 4 && searchResult.entryType == 260) {
            naviSearchResultListRow.setLayout(4);
        } else if (searchResult.source == 5) {
            naviSearchResultListRow.setLayout(8);
            naviSearchResultListRow.setStaticIcon(4);
        } else if (searchResult.entryType == 2) {
            int n = -1;
            if (this.iconHandler == null) {
                this.lc.log(-1601830656, "SearchResultFormatterNavDb#configureLayout iconHandler is null");
            } else {
                n = this.iconHandler.resolvePOIIconFromRawData(searchResult.country.countryID, searchResult.poiType);
            }
            IconCell iconCell = new IconCell(new HMIResourceLocator(n));
            if (n != -1) {
                naviSearchResultListRow.setLayout(2);
                naviSearchResultListRow.setDynamicIcon(iconCell);
            } else {
                naviSearchResultListRow.setLayout(5);
            }
        } else if (searchResult.source == 3) {
            naviSearchResultListRow.setLayout(3);
        } else if (searchResult.entryType == 16 || searchResult.entryType == 64) {
            if (searchResult.source == 4) {
                naviSearchResultListRow.setLayout(8);
                naviSearchResultListRow.setStaticIcon(2);
            } else {
                naviSearchResultListRow.setLayout(1);
                naviSearchResultListRow.setStaticIcon(3);
            }
        } else if (searchResult.source == 4) {
            naviSearchResultListRow.setLayout(8);
            naviSearchResultListRow.setStaticIcon(2);
        } else if (searchResult.entryType == 32) {
            naviSearchResultListRow.setLayout(1);
            naviSearchResultListRow.setStaticIcon(6);
        } else {
            naviSearchResultListRow.setLayout(1);
            naviSearchResultListRow.setStaticIcon(1);
        }
    }

    private void setGeoData(NaviSearchResultListRow naviSearchResultListRow, SearchResult searchResult) {
        if (this.naviInterAppService == null) {
            this.lc.log(-1601830656, "SearchResultFormatterNavDb#setGeoData naviInterAppService is null");
            return;
        }
        if (searchResult.getSource() == 5) {
            if (this.naviFavoriteHandler == null) {
                this.lc.log(-1601830656, "SearchResultFormatterNavDb#formatFavorite naviFavoriteHandler is null");
                return;
            }
            naviSearchResultListRow.setHasGeoCoordinates(true);
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)this.naviFavoriteHandler.getFavoriteRow(searchResult.dataId);
            naviSearchResultListRow.setLatitude(naviFavoriteEvoRow.getLatitude());
            naviSearchResultListRow.setLongitude(naviFavoriteEvoRow.getLongitude());
            naviSearchResultListRow.setDistanceColumn(new Distance(this.naviInterAppService.computeRelativeAirDistance(naviFavoriteEvoRow.getLongitude(), naviFavoriteEvoRow.getLatitude()), 5));
            naviSearchResultListRow.setArrowColumn(this.naviInterAppService.computeRelativeDirection(naviFavoriteEvoRow.getLongitude(), naviFavoriteEvoRow.getLatitude()));
        } else if (searchResult.getSource() == 4) {
            naviSearchResultListRow.setHasGeoCoordinates(true);
            int n = Util.degreeStringToWgs84(String.valueOf(searchResult.position.lat));
            int n2 = Util.degreeStringToWgs84(String.valueOf(searchResult.position.lon));
            naviSearchResultListRow.setLatitude(n);
            naviSearchResultListRow.setLongitude(n2);
            naviSearchResultListRow.setDistanceColumn(new Distance(this.naviInterAppService.computeRelativeAirDistance(n2, n), 5));
            naviSearchResultListRow.setArrowColumn(this.naviInterAppService.computeRelativeDirection(n2, n));
        } else if (searchResult.entryType == 2) {
            naviSearchResultListRow.setHasGeoCoordinates(true);
            int n = Util.degreeStringToWgs84(String.valueOf(searchResult.position.lat));
            int n3 = Util.degreeStringToWgs84(String.valueOf(searchResult.position.lon));
            naviSearchResultListRow.setLatitude(n);
            naviSearchResultListRow.setLongitude(n3);
            naviSearchResultListRow.setDistanceColumn(new Distance(searchResult.distanceMeters, 5));
            naviSearchResultListRow.setArrowColumn(this.naviInterAppService.computeRelativeDirection(n3, n));
        } else {
            naviSearchResultListRow.setHasGeoCoordinates(false);
        }
    }

    public static String getTokenForType(SearchResult searchResult, int n) {
        Token token = SearchResultFormatterNavDb.getTokenForType(searchResult.getTokens(), n);
        if (!SearchResultFormatterNavDb.isEmpty(token)) {
            return token.getToken();
        }
        return "";
    }
}

