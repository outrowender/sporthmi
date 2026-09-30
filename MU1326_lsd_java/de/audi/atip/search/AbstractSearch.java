/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.NullDSISearch;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.util.commons.Converter;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractSearch
implements DSISearchListener,
I18NTarget {
    private static final int DSI_SEARCHQUERY_BLOCKSIZE = 4;
    private int dsiMaxResultsReturned = 100;
    protected boolean conflictMode = false;
    public static final int INSTANCEID_DSISEARCH_NAV = 0;
    public static final int INSTANCEID_DSISEARCH_TUNER = 1;
    public static final int INSTANCEID_DSISEARCH_MEDIA = 2;
    public static final int INSTANCEID_DSISEARCH_CAR = 3;
    public static final int INSTANCEID_DSISEARCH_PHONE = 4;
    public static final int INSTANCEID_DSISEARCH_ADB = 5;
    public static final int INSTANCEID_DSISEARCH_MSG = 6;
    public static final int INSTANCEID_DSISEARCH_NAV_LAST_DEST = 7;
    public static final int INSTANCEID_DSISEARCH_RHMI = 8;
    public static final int INSTANCEID_DSISEARCH_TV = 10;
    protected final LogChannel logChannel;
    protected DSIActivator dsiActivator = null;
    protected DSISearch dsi;
    protected BundleContext context;
    private ServiceRegistration i18nService;
    protected IFrameworkAccess framework;
    private int lastQueryID = 0;
    private static int queryidentifier = 1;
    protected AbstractGuiSearchHandler activeGuiSearchHandler;
    protected int instanceID = 0;
    private Language currentLanguage;
    private final Object lock;
    protected ConflictMatch lastConflictMatch;
    private int[] maxCountPerSource = new int[0];
    private int lastSearchStartIndex = 0;
    private int lastListPosition = 0;
    private SearchQuery lastQuery;
    private boolean firstPage = true;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public AbstractSearch(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        this.lock = new Object();
        this.context = bundleContext;
        this.framework = iFrameworkAccess;
        this.instanceID = n;
        this.logChannel = logChannel;
        this.setDSISearch(null);
    }

    protected void initDSI() {
        if (this.dsi != null) {
            this.logChannel.log(10000000, "AbstractSearch#initDSI()");
            try {
                this.dsi.setNotification(this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#initDSI() = %1", (Throwable)exception);
            }
            if (this.activeGuiSearchHandler != null && this.activeGuiSearchHandler.getSources() != null) {
                try {
                    this.dsi.prepareSources(this.activeGuiSearchHandler.getSources());
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "AbstractSearch#initDSI() = %1", (Throwable)exception);
                }
            }
        } else {
            this.logChannel.log(10000, "AbstractSearch#initDSI() - dsi is NULL");
        }
    }

    protected final void deinitDSI() {
        this.logChannel.log(10000000, "AbstractSearch#deinit()");
        if (this.dsi != null) {
            try {
                this.dsi.clearNotification(this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#deinitDSI() = %1", (Throwable)exception);
            }
        }
    }

    public void startDSI() {
        this.getDSIActivator().start(this.context);
        this.registerI18NListener();
    }

    public void stopDSI() {
        this.getDSIActivator().stop(this.context);
        if (this.i18nService != null) {
            this.i18nService.unregister();
        }
    }

    public void stopDSI(BundleContext bundleContext) {
        this.getDSIActivator().stop(bundleContext);
        this.context = bundleContext;
        if (this.i18nService != null) {
            this.i18nService.unregister();
        }
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            IDSIClient iDSIClient = new IDSIClient(){

                public void setDSI(DSIBase dSIBase) {
                    AbstractSearch.this.setDSISearch((DSISearch)dSIBase);
                    if (AbstractSearch.this.currentLanguage != null) {
                        AbstractSearch.this.setLanguage(AbstractSearch.this.currentLanguage);
                    }
                }

                public int[] getAutoNotifications() {
                    return null;
                }
            };
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = AbstractSearch.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), (class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = AbstractSearch.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener).getName(), new Integer(this.instanceID), this, iDSIClient);
        }
        return this.dsiActivator;
    }

    protected final void setMaxCountPerSource(int[] nArray) {
        this.maxCountPerSource = nArray;
    }

    private int getMatchingMode() {
        if (this.framework.isAsia() && this.currentLanguage != null) {
            if (this.currentLanguage.getLanguageCode().equals("en_KR") || this.currentLanguage.getLanguageCode().equals("en_CN") || this.currentLanguage.getLanguageCode().equals("en_JP") || this.currentLanguage.getLanguageCode().equals("en_TW") || this.currentLanguage.getLanguageCode().equals("en_US")) {
                return 0;
            }
            return 1;
        }
        return 0;
    }

    private void registerI18NListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.i18nService = this.context.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractSearch.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this, (Dictionary)hashtable);
    }

    public void setDsiMaxResultsReturned(int n) {
        this.dsiMaxResultsReturned = n;
    }

    public AbstractGuiSearchHandler getActiveGuiSearchHandler() {
        return this.activeGuiSearchHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setActiveGuiSearchHandler(AbstractGuiSearchHandler abstractGuiSearchHandler) {
        Object object = this.lock;
        synchronized (object) {
            this.activeGuiSearchHandler = abstractGuiSearchHandler;
        }
    }

    private final void setDSISearch(DSISearch dSISearch) {
        this.logChannel.log(10000000, "AbstractSearch#setDSI # dsi=%1", (Object)this.dsi);
        if (dSISearch == null) {
            this.deinitDSI();
        }
        DSISearch dSISearch2 = this.dsi = dSISearch != null ? dSISearch : new NullDSISearch(this.logChannel);
        if (dSISearch != null) {
            this.initDSI();
        }
    }

    protected int incrementAndGetQueryID() {
        return ++queryidentifier;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLastQueryID() {
        Object object = this.lock;
        synchronized (object) {
            return this.lastQueryID;
        }
    }

    public void performQuery(String string) {
        this.performQuery(string, new String[0]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void performQuery(String string, String[] stringArray) {
        Object object = this.lock;
        synchronized (object) {
            if (this.activeGuiSearchHandler == null) {
                this.logChannel.log(100000, "AbstractSearch#performQuery called but activeGuiSearchHandler is null! call will be ignored!");
                return;
            }
            this.lastSearchStartIndex = 0;
            this.lastListPosition = 0;
            this.lastQuery = new SearchQuery(this.lastQueryID, this.activeGuiSearchHandler.getSources(), string, stringArray, this.lastSearchStartIndex, 4, this.conflictMode, this.lastConflictMatch != null ? this.lastConflictMatch.type : 0, this.getMatchingMode(), this.getMaxCountPerSource(string));
            this.logChannel.log(10000000, "AbstractSearch#performQuery query=%1, instanceID=%2", (Object)this.lastQuery, (long)this.instanceID);
            this.requestSuggestion(this.lastQuery);
            if (this.dsi != null) {
                try {
                    this.dsi.search(this.lastQuery);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "AbstractSearch#performQuery() = %1", (Throwable)exception);
                }
            }
        }
    }

    private boolean nextQuery() {
        this.logChannel.log(10000000, "AbstractSearch#nextQuery lastSearchStartIndex=%1, lastListPosition=%2, instanceID=%3", (long)this.lastSearchStartIndex, (long)this.lastListPosition, (long)this.instanceID);
        if (this.lastListPosition < this.dsiMaxResultsReturned && this.lastListPosition >= this.lastSearchStartIndex + 4 - 1) {
            this.lastSearchStartIndex += 4;
            this.lastQuery.offset = this.lastSearchStartIndex;
            if (this.dsi != null) {
                try {
                    this.dsi.search(this.lastQuery);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "AbstractSearch#nextQuery() = %1", (Throwable)exception);
                }
            }
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resumeQuery() {
        Object object = this.lock;
        synchronized (object) {
            this.activeGuiSearchHandler.flushSearchResultBuffer();
            this.cancelQuery();
            this.lastSearchStartIndex = this.activeGuiSearchHandler.mdlListSearchResults.getLength();
            if (this.lastSearchStartIndex >= this.dsiMaxResultsReturned) {
                this.logChannel.log(10000000, "AbstractSearch#resumeQuery lastSearchStartIndex=%1, do not resume", (long)this.lastSearchStartIndex);
                return;
            }
            this.logChannel.log(10000000, "AbstractSearch#resumeQuery lastSearchStartIndex=%1, instanceID=%2", (long)this.lastSearchStartIndex, (long)this.instanceID);
            String[] stringArray = this.lastQuery.alternativeNeedles;
            this.lastQuery = new SearchQuery(this.lastQueryID, this.activeGuiSearchHandler.getSources(), this.activeGuiSearchHandler.mdlSpellerSearchText.getText(), stringArray, this.lastSearchStartIndex, 4, this.conflictMode, this.lastConflictMatch != null ? this.lastConflictMatch.type : 0, this.getMatchingMode(), this.getMaxCountPerSource(this.activeGuiSearchHandler.mdlSpellerSearchText.getText()));
            if (this.dsi != null) {
                try {
                    this.dsi.search(this.lastQuery);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "AbstractSearch#nextQuery() = %1", (Throwable)exception);
                }
            }
        }
    }

    private int[] getMaxCountPerSource(String string) {
        if (string == null || string.length() == 0) {
            return new int[0];
        }
        return this.maxCountPerSource;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean cancelQuery() {
        this.logChannel.log(10000000, "AbstractSearch#cancelQuery() lastQueryID=%1, instanceID=%2", (long)this.lastQueryID, (long)this.instanceID);
        boolean bl = false;
        Object object = this.lock;
        synchronized (object) {
            if (this.lastQueryID != 0 && this.dsi != null) {
                try {
                    this.dsi.cancelQuery(this.lastQueryID);
                    bl = true;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "AbstractSearch#cancelQuery() = %1", (Throwable)exception);
                }
            }
            this.lastQueryID = this.incrementAndGetQueryID();
        }
        return bl;
    }

    public void setSearchFilter(int n, SearchFilter searchFilter) {
        this.logChannel.log(10000000, "AbstractSearch#setSearchFilter() source=%1 filter=%2, instanceID=%3", (Object)Integer.toString(n), (Object)searchFilter, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setSearchFilter(n, searchFilter);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setSearchFilter() = %1", (Throwable)exception);
            }
        }
    }

    public void requestSupportedCountries() {
        this.logChannel.log(10000000, "AbstractSearch#requestSupportedCountries() instanceID=%1", (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.requestSupportedCountries();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#requestSupportedCountries() = %1", (Throwable)exception);
            }
        }
    }

    public void requestSuggestion(SearchQuery searchQuery) {
        this.logChannel.log(10000000, "AbstractSearch#requestSuggestion() query=%1 instanceID=%2", (Object)searchQuery, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.requestSuggestion(searchQuery);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#requestSuggestion() = %1", (Throwable)exception);
            }
        }
    }

    public void setActiveSearchCountries(String[] stringArray) {
        this.logChannel.log(10000000, "AbstractSearch#setActiveSearchCountries() countryIDs=%1, instanceID=%2", (Object)stringArray, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setActiveSearchCountries(stringArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setActiveSearchCountries() = %1", (Throwable)exception);
            }
        }
    }

    public void addToHistory(SearchResult searchResult) {
        this.logChannel.log(10000000, "AbstractSearch#addToHistory() entry=%1, instanceID=%2", (Object)searchResult, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.addToHistory(searchResult);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#addToHistory() = %1", (Throwable)exception);
            }
        }
    }

    public void setCurrentPosition(NavPosition navPosition) {
        this.logChannel.log(10000000, "AbstractSearch#setCurrentPosition() pos=%1, instanceID=%2", (Object)navPosition, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setCurrentPosition(navPosition);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setCurrentPosition() = %1", (Throwable)exception);
            }
        }
    }

    public void setRoutePoints(NavPosition[] navPositionArray) {
        this.logChannel.log(10000000, "AbstractSearch#setRoutePoints() routePoints=%1, instanceID=%2", (Object)navPositionArray, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setRoutePoints(navPositionArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setRoutePoints() = %1", (Throwable)exception);
            }
        }
    }

    public void setActiveProfile(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setActiveProfile() profileNumber=%1, instanceID=%2", (long)n, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setActiveProfile(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setActiveProfile() = %1", (Throwable)exception);
            }
        }
    }

    public void setCarFunctionStates(CarFunction[] carFunctionArray) {
        this.logChannel.log(10000000, "AbstractSearch#setCarFunctionStates() carfunctions=%1, instanceID=%2", (Object)carFunctionArray, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setCarFunctionStates(carFunctionArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setCarFunctionStates() = %1", (Throwable)exception);
            }
        }
    }

    public void setRadioStations(int n, RadioStation[] radioStationArray) {
        this.logChannel.log(10000000, "AbstractSearch#setRadioStations() source=%1, instanceID=%2", (long)n, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setRadioStations(n, radioStationArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setRadioStations() = %1", (Throwable)exception);
            }
        }
    }

    public void prepareSources(int[] nArray) {
        this.logChannel.log(10000000, "AbstractSearch#prepareSources() sources=%1, instanceID=%2", (Object)nArray, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.prepareSources(nArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#prepareSources() = %1", (Throwable)exception);
            }
        }
    }

    public void resetSettings() {
        this.logChannel.log(10000000, "AbstractSearch#resetSettings instanceID=%1", (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.resetToFactorySettings();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#resetSettings() = %1", (Throwable)exception);
            }
        }
    }

    public void removeFromHistory(long l) {
        this.logChannel.log(10000000, "AbstractSearch#removeFromHistory id=%1, instanceID=%2", l, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.removeFromHistory(l);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#removeFromHistory() = %1", (Throwable)exception);
            }
        }
    }

    public void removeAllFromHistory() {
        this.logChannel.log(10000000, "AbstractSearch#removeAllFromHistory() instanceID=%1", (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.removeAllFromHistory();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#removeAllFromHistory() = %1", (Throwable)exception);
            }
        }
    }

    public void resetAutocompletion(int n) {
        this.logChannel.log(10000000, "AbstractSearch#resetAutocompletion() source=%1, instanceID=%2", (long)n, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.resetAutocompletion(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#resetAutocompletion() = %1", (Throwable)exception);
            }
        }
    }

    public void createBackupFile(String string) {
        this.logChannel.log(10000000, "AbstractSearch#createBackupFile() path=%1, instanceID=%2", (Object)string, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.createBackupFile(string);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#createBackupFile() = %1", (Throwable)exception);
            }
        }
    }

    public void importBackupFile(String string) {
        this.logChannel.log(10000000, "AbstractSearch#importBackupFile() fullPath=%1, instanceID=%2", (Object)string, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.importBackupFile(string);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#importBackupFile() = %1", (Throwable)exception);
            }
        }
    }

    public void setEnvironment(Environment environment) {
        this.logChannel.log(10000000, "AbstractSearch#setEnvironment() environment=%1, instanceID=%2", (Object)environment, (long)this.instanceID);
        if (this.dsi != null) {
            try {
                this.dsi.setEnvironment(environment);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "AbstractSearch#setEnvironment() = %1", (Throwable)exception);
            }
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000, "AbstractSearch#asyncException # errorMsg=%1, errorCode=%2, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "AbstractSearch#requestSupportedCountriesResult # success=%2, countries=%1, instanceID=%3", (Object)Converter.array2String(countryArray), (long)n, (long)this.instanceID);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchResult(int n, SearchResult searchResult) {
        Object object = this.lock;
        synchronized (object) {
            if (this.logChannel.isDebug2()) {
                String string = searchResult != null ? String.valueOf(searchResult.listPosition) : "null";
                this.logChannel.log(100000000, "AbstractSearch#searchResult # searchResult=%2, instanceID=%3, searchResult.listPosition=%1", (Object)string, (Object)searchResult, (long)this.instanceID);
            }
            if (searchResult == null || searchResult.getQueryId() != this.lastQueryID) {
                return;
            }
            int n2 = searchResult.getListPosition();
            this.activeGuiSearchHandler.setListRow(n2, searchResult);
            this.lastListPosition = n2;
        }
    }

    public void addToHistoryResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#addToHistoryResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        this.logChannel.log(10000000, "AbstractSearch#requestSuggestionResult # success=%1, queryID=%2, instanceID=%3", (long)n, (long)n2, (long)this.instanceID);
        this.activeGuiSearchHandler.setFastGuess(suggestionArray, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelQueryResult(int n) {
        if (this.activeGuiSearchHandler == null) {
            this.logChannel.log(100000, "AbstractSearch#cancelQueryResult activeGuiSearchHandler is null");
            return;
        }
        Object object = this.lock;
        synchronized (object) {
            this.logChannel.log(10000000, "AbstractSearch#cancelQueryResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
            this.activeGuiSearchHandler.cancelQueryResult();
        }
    }

    public void setCurrentPositionResult(int n) {
        this.logChannel.log(100000000, "AbstractSearch#setCurrentPositionResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void setRoutePointsResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setRoutePointsResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void setLanguageResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setLanguageResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSearchIsActive(boolean bl, int n) {
        Object object = this.lock;
        synchronized (object) {
            this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive # isActive=%1, validFlag=%2, instanceID=%3", (Object)Boolean.toString(bl), (long)n, (long)this.instanceID);
            if (n != 1) {
                this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive # invalid");
                return;
            }
            if (bl) {
                if (this.firstPage) {
                    this.activeGuiSearchHandler.searchStarted();
                    this.firstPage = false;
                }
            } else if (!this.nextQuery()) {
                this.firstPage = true;
                this.activeGuiSearchHandler.searchEnded();
            }
        }
    }

    public void setCarFunctionStatesResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setCarFunctionStatesResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void setRadioStationsResult(int n, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#setRadioStationsResult # success=%1, source=%2, instanceID=%3", (long)n, (long)n2, (long)this.instanceID);
    }

    public void setActiveProfileResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setActiveProfileResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void setActiveSearchCountriesResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setActiveSearchCountriesResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void resetToFactorySettingsResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#resetToFactorySettingsResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void setSearchFilterResult(int n, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#setSearchFilterResult # success=%1 source=%2, instanceID=%3", (Object)this.resultTypeToString(n), (long)n2, (long)this.instanceID);
    }

    public void invalidateData(int[] nArray) {
        this.logChannel.log(10000000, "AbstractSearch#invalidateData # sources=%1, instanceID=%2", (Object)nArray, (long)this.instanceID);
        if (nArray == null || this.activeGuiSearchHandler == null || this.activeGuiSearchHandler.getSources() == null) {
            return;
        }
        int[] nArray2 = this.activeGuiSearchHandler.getSources();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                if (nArray[i2] != nArray2[i3]) continue;
                this.activeGuiSearchHandler.refreshQuery();
                return;
            }
        }
    }

    public void prepareSourcesResult(int n) {
        this.logChannel.log(100000000, "AbstractSearch#prepareSourcesResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void removeFromHistoryResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#removeFromHistoryResult # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void resetAutocompletionResult(int n, int n2) {
        this.logChannel.log(100000000, "AbstractSearch#resetAutocompletionResult # success=%1, source=%2, instanceID=%3", (long)n, (long)n2, (long)this.instanceID);
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.logChannel.log(100000000, "AbstractSearch#sourceDataAvailabilityChanged # source=%2, dataAvailable=%1, instanceID=%3", (Object)Boolean.toString(bl), (long)n, (long)this.instanceID);
    }

    public void removeAllFromHistoryResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#removeAllFromHistoryResult() # success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void createBackupFileResult(int n, String string) {
        this.logChannel.log(100000000, "AbstractSearch#createBackupFileResult()");
    }

    public void importBackupFileResult(int n, String string) {
        this.logChannel.log(100000000, "AbstractSearch#importBackupFileResult()");
    }

    public void setEnvironmentResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#setEnvironmentResult() success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    public void removeAllFromHistoryBySourceResult(int n) {
        this.logChannel.log(10000000, "AbstractSearch#removeAllFromHistoryBySourceResult() success=%1, instanceID=%2", (long)n, (long)this.instanceID);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelQueryResult(int n, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#cancelQueryResult( %1 )", (long)n);
        if (this.activeGuiSearchHandler == null) {
            this.logChannel.log(100000, "AbstractSearch#cancelQueryResult activeGuiSearchHandler is null");
            return;
        }
        Object object = this.lock;
        synchronized (object) {
            this.logChannel.log(10000000, "AbstractSearch#cancelQueryResult # success=%1, instanceID=%2", (long)n2, (long)this.instanceID);
            this.activeGuiSearchHandler.cancelQueryResult();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSearchIsActive(int n, boolean bl, int n2) {
        Object object = this.lock;
        synchronized (object) {
            this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive(%1, %2, %3)", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (long)n2);
            if (n2 != 1) {
                this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive # invalid");
                return;
            }
            if (n != this.lastQueryID) {
                this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive() ignore update for olf queryID %1 current id %2 ", (Object)Integer.toString(n), (Object)Integer.toString(this.lastQueryID));
                return;
            }
            if (bl) {
                if (this.firstPage) {
                    this.activeGuiSearchHandler.searchStarted();
                    this.firstPage = false;
                }
            } else if (!this.nextQuery()) {
                this.logChannel.log(10000000, "AbstractSearch#updateSearchIsActive() search has ended, queryId=%1", (long)n);
                this.firstPage = true;
                this.activeGuiSearchHandler.searchEnded();
            }
        }
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#updatePotentialConflict()");
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractSearch#updateProfileState()");
    }

    public void profileChanged(int n, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#profileChanged()");
    }

    public void profileCopied(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractSearch#profileCopied()");
    }

    public void profileReset(int n, int n2) {
        this.logChannel.log(10000000, "AbstractSearch#profileReset()");
    }

    public void profileResetAll(int n) {
        this.logChannel.log(10000000, "AbstractSearch#profileResetAll()");
    }

    public void setLanguage(Language language) {
        this.logChannel.log(10000000, "AbstractSearch#setLanguage # dsi=%1 # lang=%2, instanceID=%3", (Object)this.dsi, (Object)language, (long)this.instanceID);
        this.currentLanguage = language;
        if (this.dsi != null) {
            this.dsi.setLanguage(language.getLanguageCode());
        }
    }

    private String resultTypeToString(int n) {
        switch (n) {
            case 0: {
                return "OK";
            }
            case 1: {
                return "NOK_INTERNAL_ERROR";
            }
            case 4: {
                return "NOK_ERROR_IN_SOURCE";
            }
            case 2: {
                return "NOK_WRONG_PARAMETER";
            }
            case 3: {
                return "NOK__WRONG_STATE";
            }
        }
        return "UNKNOWN";
    }

    protected Object getLock() {
        return this.lock;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

