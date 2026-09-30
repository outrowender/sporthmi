/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.navi.data.FormattedDestination;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import de.audi.tghu.navi.app.search.ILastDestUpdated;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;
import org.osgi.framework.BundleContext;

public class LastDestSearch
extends AbstractSearch
implements ILastDestHandler {
    private List lastDestinations = new ArrayList(50);
    private List lastDestinationsBuffer = new ArrayList(0);
    private final CombiBAPListener combiListener;
    private final NaviServiceListener naviServiceListener;
    private static final int LAST_DEST_NOT_AVAILABLE = 0;
    private static final int LAST_DEST_AVAILABLE = 1;
    private static final String LOGCLASS = "LastDestSearch";
    private final NavigationEnv env;
    private final SearchResultNavLocationExtractor searchResultNavLocationExtractor;
    private ILastDestUpdated lastDestFive;
    private Object lock = new Object();

    public LastDestSearch(BundleContext bundleContext, NavigationEnv navigationEnv, int n, LogChannel logChannel, CombiBAPListener combiBAPListener, NaviServiceListener naviServiceListener, ILastDestUpdated iLastDestUpdated, SearchResultNavLocationExtractor searchResultNavLocationExtractor) {
        this(bundleContext, navigationEnv, n, logChannel, combiBAPListener, naviServiceListener, searchResultNavLocationExtractor);
        this.lastDestFive = iLastDestUpdated;
    }

    public LastDestSearch(BundleContext bundleContext, NavigationEnv navigationEnv, int n, LogChannel logChannel, CombiBAPListener combiBAPListener, NaviServiceListener naviServiceListener, SearchResultNavLocationExtractor searchResultNavLocationExtractor) {
        super(bundleContext, navigationEnv.getFramework(), logChannel, n);
        this.env = navigationEnv;
        this.combiListener = combiBAPListener;
        this.naviServiceListener = naviServiceListener;
        this.searchResultNavLocationExtractor = searchResultNavLocationExtractor;
    }

    protected void initDSI() {
        super.initDSI();
        this.setActiveProfile(0);
        this.performQuery("");
    }

    public void refreshList() {
        this.cancelQuery();
        this.clearCache();
        this.performQuery("");
    }

    public NavLocation getLastDestNavLocation(long l) {
        SearchResult searchResult = null;
        try {
            searchResult = (SearchResult)this.lastDestinations.get((int)l);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#getLastDestNavLocation %2", (Object)LOGCLASS, (Throwable)exception);
        }
        if (searchResult != null) {
            SearchResultListRow searchResultListRow = new SearchResultListRow(searchResult, 0, 0L){

                public EvoListRow copy() {
                    return null;
                }
            };
            return this.searchResultNavLocationExtractor.extractNavLocationFromRow(searchResultListRow);
        }
        return null;
    }

    public byte[] getLastDestByteStream(int n) {
        byte[] byArray = null;
        try {
            byArray = ((SearchResult)this.lastDestinations.get((int)n)).applicationData;
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#getLastDestByteStream %2", (Object)LOGCLASS, (Throwable)exception);
        }
        return byArray;
    }

    public SearchResult getLastDest(long l) {
        SearchResult searchResult = null;
        try {
            searchResult = (SearchResult)this.lastDestinations.get((int)l);
        }
        catch (Exception exception) {
            this.logChannel.log(100000, "%1#getLastDestNavLocation %2", (Object)LOGCLASS, (Throwable)exception);
        }
        return searchResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchResult(int n, SearchResult searchResult) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#searchResult # success=%2", (Object)LOGCLASS, (long)n);
        }
        super.searchResult(n, searchResult);
        if (searchResult.getQueryId() == this.getLastQueryID()) {
            Object object = this.lock;
            synchronized (object) {
                this.lastDestinationsBuffer.add(searchResult);
            }
        }
    }

    public void notifyObservers() {
        if (this.lastDestinations == null) {
            this.logChannel.log(100000, "%1#notifyObservers: lastDestinations is null", (Object)LOGCLASS);
            return;
        }
        this.notifyClusterService();
        this.notifyLastFive();
        this.naviServiceListener.updateLastDestinations(this.getLastDestListForSDS());
    }

    protected void notifyLastFive() {
        if (this.lastDestinations == null || this.lastDestFive == null) {
            this.logChannel.log(100000, "%1#notifyClusterService: lastDestinations or lastDestFive is null", (Object)LOGCLASS);
            return;
        }
        ArrayList arrayList = new ArrayList(50);
        arrayList.addAll(this.lastDestinations);
        this.lastDestFive.updateLastDest(arrayList);
    }

    protected void notifyClusterService() {
        ArrayList arrayList = new ArrayList(50);
        if (this.lastDestinations == null) {
            this.logChannel.log(100000, "%1#notifyClusterService: lastDestinations is null", (Object)LOGCLASS);
            return;
        }
        for (int i2 = 0; i2 < this.lastDestinations.size(); ++i2) {
            arrayList.add(this.lastDestinations.get(i2));
        }
        this.logChannel.log(10000000, "%1#notifyClusterService - %2 last destinations", (Object)LOGCLASS, (long)arrayList.size());
        CombiBAPNaviDestination[] combiBAPNaviDestinationArray = new CombiBAPNaviDestination[arrayList.size()];
        String[] stringArray = new String[this.lastDestinations.size()];
        FormattedDestination[] formattedDestinationArray = new FormattedDestination[this.lastDestinations.size()];
        for (int i3 = 0; i3 < arrayList.size(); ++i3) {
            String string;
            SearchResult searchResult = (SearchResult)arrayList.get(i3);
            Token[] tokenArray = searchResult.tokens;
            float f2 = searchResult.position.lat;
            float f3 = searchResult.position.lon;
            Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 4);
            Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 1);
            Token token3 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 2);
            Token token4 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 3);
            Token token5 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7);
            Token token6 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
            Token token7 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 12);
            Token token8 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 6);
            Token token9 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 17);
            Token token10 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
            if (Util.isHURegionAsia()) {
                f2 = Float.NaN;
                f3 = Float.NaN;
            }
            String string2 = string = token4 != null ? token4.getToken() : null;
            if (Util.isEmpty(string)) {
                if (searchResult.getEntryType() == 16) {
                    string = this.env.getTranslatedText(5);
                } else if (token3 != null && searchResult.getEntryType() == 64) {
                    string = token3.getToken();
                }
            }
            String string3 = token5 != null ? token5.getToken() : null;
            string = Util.appendHouseNumberForFPK(string, string3, this.env.getFramework());
            CombiBAPNaviDestination combiBAPNaviDestination = new CombiBAPNaviDestination(token10 != null ? token10.getToken() : null, null, string, string3, token2 != null ? token2.getToken() : null, token3 != null ? token3.getToken() : null, token8 != null ? token8.getToken() : null, token != null ? token.getToken() : null, token9 != null ? token9.getToken() : null, f2, f3, searchResult.getEntryType() == 2 ? 255 : 0, token6 != null ? token6.getToken() : null, token7 != null ? token7.getToken() : null, searchResult.entryType);
            combiBAPNaviDestination.setNaviType(1);
            combiBAPNaviDestination.setNaviID(i3);
            combiBAPNaviDestinationArray[i3] = combiBAPNaviDestination;
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatOneLine(searchResult, this.env);
            stringArray[i3] = locationFormattingResponse != null ? locationFormattingResponse.getFirstLineAsText() : "";
            LocationFormattingResponse locationFormattingResponse2 = AddressFormatter.formatTwoLines(searchResult, this.env);
            formattedDestinationArray[i3] = locationFormattingResponse2 != null ? new FormattedDestination(locationFormattingResponse2.getFirstLineAsText(), locationFormattingResponse2.getSecondLineAsText()) : null;
        }
        this.combiListener.setLastDestinationsList(combiBAPNaviDestinationArray, stringArray, formattedDestinationArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearCache() {
        Object object = this.lock;
        synchronized (object) {
            this.lastDestinationsBuffer = new ArrayList(50);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SDSListEntry[] getLastDestListForSDS() {
        this.logChannel.log(10000000, "LastDestSearch#getLastDestListForSDS() - creating SDSList with Phonetic entrys");
        SDSListEntry[] sDSListEntryArray = this.lock;
        synchronized (this.lock) {
            Object[] objectArray = this.lastDestinations.toArray();
            // ** MonitorExit[var2_1] (shouldn't be in output)
            sDSListEntryArray = new SDSListEntry[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                SearchResult searchResult = (SearchResult)objectArray[i2];
                if (searchResult == null) {
                    this.logChannel.log(100000, "LastDestSearch#getLastDestListForSDS() - lastDestination at index = %1 is null. This shouldn't happen!", (long)i2);
                    sDSListEntryArray[i2] = new SDSListEntry("", i2);
                    continue;
                }
                Token[] tokenArray = searchResult.getTokens();
                Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 23);
                sDSListEntryArray[i2] = null != token && null != token.getToken() ? new SDSListEntry(token.getToken(), i2) : new SDSListEntry("", i2);
            }
            return sDSListEntryArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onSearchEnded() {
        this.logChannel.log(10000000, this.getClass().getName() + "#onSearchEnded() last destinations size was %1", (Object)(this.lastDestinations == null ? "null" : "" + this.lastDestinations.size()));
        Object object = this.lock;
        synchronized (object) {
            this.lastDestinations = this.lastDestinationsBuffer;
            this.lastDestinationsBuffer = new ArrayList(0);
        }
        this.logChannel.log(10000000, this.getClass().getName() + "#onSearchEnded() last destinations size is now %1", (Object)(this.lastDestinations == null ? "null" : "" + this.lastDestinations.size()));
        if (this.lastDestinations.size() == 0) {
            this.env.getChoiceModel(401890).setValue(0);
        } else {
            this.env.getChoiceModel(401890).setValue(1);
        }
    }

    public void languageChanged() {
        this.notifyClusterService();
    }

    public NavCommand getLanguageChangedCommand() {
        return new NavCommand(){

            public void execute() {
                LastDestSearch.this.languageChanged();
                this.getCommandList().commandFinished();
            }
        };
    }
}

