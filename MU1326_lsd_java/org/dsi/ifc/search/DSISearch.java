/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public interface DSISearch
extends DSIBase {
    public static final String VERSION = "2.11.25";
    public static final int IN_INVALIDATEDATA = 3000;
    public static final int IN_SOURCEDATAAVAILABILITYCHANGED = 3001;
    public static final int ATTR_SEARCHISACTIVE = 1;
    public static final int ATTR_POTENTIALCONFLICT = 2;
    public static final int ATTR_PROFILESTATE = 3;
    public static final int RP_REQUESTSUPPORTEDCOUNTRIESRESULT = 2000;
    public static final int RP_SEARCHRESULT = 2001;
    public static final int RP_ADDTOHISTORYRESULT = 2002;
    public static final int RP_CANCELQUERYRESULT = 2004;
    public static final int RP_SETCURRENTPOSITIONRESULT = 2005;
    public static final int RP_SETROUTEPOINTSRESULT = 2006;
    public static final int RP_SETLANGUAGERESULT = 2007;
    public static final int RP_SETCARFUNCTIONSTATESRESULT = 2008;
    public static final int RP_SETRADIOSTATIONSRESULT = 2009;
    public static final int RP_SETACTIVEPROFILERESULT = 2010;
    public static final int RP_SETACTIVESEARCHCOUNTRIESRESULT = 2011;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT = 2012;
    public static final int RP_PREPARESOURCESRESULT = 2013;
    public static final int RP_SETSEARCHFILTERRESULT = 2014;
    public static final int RP_REMOVEFROMHISTORYRESULT = 2015;
    public static final int RP_RESETAUTOCOMPLETIONRESULT = 2016;
    public static final int RP_REMOVEALLFROMHISTORYRESULT = 2017;
    public static final int RP_CREATEBACKUPFILERESULT = 2018;
    public static final int RP_IMPORTBACKUPFILERESULT = 2019;
    public static final int RP_SETENVIRONMENTRESULT = 2020;
    public static final int RP_REQUESTSUGGESTIONRESULT = 2021;
    public static final int RP_REMOVEALLFROMHISTORYBYSOURCERESULT = 2022;
    public static final int RP_PROFILECHANGED = 2023;
    public static final int RP_PROFILECOPIED = 2024;
    public static final int RP_PROFILERESET = 2025;
    public static final int RP_PROFILERESETALL = 2026;
    public static final int RT_SETACTIVEPROFILE = 1000;
    public static final int RT_REQUESTSUPPORTEDCOUNTRIES = 1001;
    public static final int RT_SETACTIVESEARCHCOUNTRIES = 1002;
    public static final int RT_SEARCH = 1003;
    public static final int RT_ADDTOHISTORY = 1004;
    public static final int RT_REQUESTSUGGESTION = 1005;
    public static final int RT_CANCELQUERY = 1006;
    public static final int RT_SETCURRENTPOSITION = 1007;
    public static final int RT_SETROUTEPOINTS = 1008;
    public static final int RT_SETLANGUAGE = 1009;
    public static final int RT_SETCARFUNCTIONSTATES = 1010;
    public static final int RT_SETRADIOSTATIONS = 1011;
    public static final int RT_RESETTOFACTORYSETTINGS = 1012;
    public static final int RT_PREPARESOURCES = 1014;
    public static final int RT_SETSEARCHFILTER = 1015;
    public static final int RT_REMOVEFROMHISTORY = 1016;
    public static final int RT_RESETAUTOCOMPLETION = 1017;
    public static final int RT_REMOVEALLFROMHISTORY = 1018;
    public static final int RT_CREATEBACKUPFILE = 1019;
    public static final int RT_IMPORTBACKUPFILE = 1020;
    public static final int RT_SETENVIRONMENT = 1021;
    public static final int RT_REMOVEALLFROMHISTORYBYSOURCE = 1022;
    public static final int RT_PROFILECHANGE = 1023;
    public static final int RT_PROFILECOPY = 1024;
    public static final int RT_PROFILERESET = 1025;
    public static final int RT_PROFILERESETALL = 1026;

    public void requestSupportedCountries();

    public void setActiveSearchCountries(String[] var1);

    public void search(SearchQuery var1);

    public void addToHistory(SearchResult var1);

    public void requestSuggestion(SearchQuery var1);

    public void cancelQuery(int var1);

    public void setCurrentPosition(NavPosition var1);

    public void setRoutePoints(NavPosition[] var1);

    public void setLanguage(String var1);

    public void setActiveProfile(int var1);

    public void setCarFunctionStates(CarFunction[] var1);

    public void setRadioStations(int var1, RadioStation[] var2);

    public void setSearchFilter(int var1, SearchFilter var2);

    public void prepareSources(int[] var1);

    public void resetToFactorySettings();

    public void removeFromHistory(long var1);

    public void removeAllFromHistory();

    public void removeAllFromHistoryBySource(int var1);

    public void resetAutocompletion(int var1);

    public void createBackupFile(String var1);

    public void importBackupFile(String var1);

    public void setEnvironment(Environment var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

