/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.IRowProperties;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.StationStatus;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVSearchListRow
extends SearchResultListRow {
    static final int COL_COUNT = 5;
    private static final int COL_SERVICE_NAME = 0;
    private static final int COL_PROPERTIES = 1;
    private static final int COL_ERROR_ICON = 2;
    private static final int COL_STATION_ICON = 3;
    private static final int COL_IS_FAVORITE = 4;
    private final IRowProperties properties;
    private final ITVRowFactory rowFactory;
    final ServiceInfo service;
    private StationStatus status = new StationStatus(0, 0);

    protected TVSearchListRow(SearchResult searchResult, IFavoritesList iFavoritesList, IStationList iStationList, ITVRowFactory iTVRowFactory) {
        super(searchResult, 5, searchResult.dataId);
        this.rowFactory = iTVRowFactory;
        long l = StationMapper.getPureUniqueID(searchResult.dataId);
        this.setHighlightTextCell(0, this.formatEntryLine(searchResult));
        this.setInteger(2, 0);
        boolean bl = StationMapper.isFavorite(searchResult.dataId);
        this.service = bl ? iFavoritesList.getServiceForUniqueID(l) : iStationList.getServiceForUniqueID(l);
        if (this.service == null) {
            throw new IllegalArgumentException("[TVSearchListRow] service was null but available in truffle search.");
        }
        this.setInteger(3, TVUtil.getChannelType(this.service.sType));
        this.properties = iTVRowFactory.createProperties(this.service);
        this.setDefaultProperties();
        this.makeFavorite(bl);
    }

    protected TVSearchListRow(TVSearchListRow tVSearchListRow) {
        super(tVSearchListRow);
        this.rowFactory = tVSearchListRow.rowFactory;
        this.service = tVSearchListRow.service;
        this.properties = tVSearchListRow.properties;
        this.status = tVSearchListRow.getState();
    }

    private TextListCellHighlightText formatEntryLine(SearchResult searchResult) {
        Token[] tokenArray = searchResult.getTokens();
        if (tokenArray == null || tokenArray.length == 0) {
            return new TextListCellHighlightText("", new int[0]);
        }
        TextLineList textLineList = new TextLineList();
        if (tokenArray[0].wordType == 22) {
            textLineList.addToken(tokenArray[0]);
        }
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    private void setDefaultProperties() {
        this.properties.setDatabroadcastIsCheckingOrUnavailable(true);
        this.properties.setVisualAudioIsUnavailable(true);
        this.properties.setTeletextIsUnavailable(true);
        this.setPropertyCell(1, new PropertyListCell(this.properties.getCategory(), this.properties.toArray()));
    }

    public final synchronized void makeFavorite(boolean bl) {
        this.setInteger(4, bl ? 1 : 0);
        this.properties.setElementIsFavorite(bl);
        this.setPropertyCell(1, new PropertyListCell(this.properties.getCategory(), this.properties.toArray()));
    }

    public synchronized void setStationStatus(StationStatus stationStatus) {
        this.status = stationStatus;
        int n = TVUtil.getCasStatus(stationStatus.casState);
        if (n == 0) {
            n = TVUtil.getMuteStatus(stationStatus.muteState);
        }
        this.setInteger(2, n);
    }

    public synchronized StationStatus getState() {
        return this.status;
    }

    public EvoListRow copy() {
        return new TVSearchListRow(this);
    }
}

