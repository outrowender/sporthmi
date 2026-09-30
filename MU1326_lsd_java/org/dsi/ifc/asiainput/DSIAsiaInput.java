/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiainput;

import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;
import org.dsi.ifc.base.DSIBase;

public interface DSIAsiaInput
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int IN_INDICATEERRORSTATUS = 3000;
    public static final int IN_INDICATEDATAINVALIDATED = 3001;
    public static final int RP_INITIALIZED = 2000;
    public static final int RP_GETVERSIONINFO = 2001;
    public static final int RP_BUILTCANDIDATES = 2002;
    public static final int RP_GETSPELLING = 2003;
    public static final int RP_GETCANDIDATES = 2004;
    public static final int RP_GETINTPARAMETER = 2007;
    public static final int RP_GETBOOLEANPARAMETER = 2008;
    public static final int RP_SETBOOLEANPARAMETERRESULT = 2009;
    public static final int RP_SETINTPARAMETERRESULT = 2010;
    public static final int RP_SETSTRINGPARAMETERRESULT = 2011;
    public static final int RP_GETSTRINGPARAMETER = 2012;
    public static final int RP_SELECTEDCANDIDATE = 2014;
    public static final int RP_SETADDITIONALWORDDATABASESRESULT = 2015;
    public static final int RP_SETUSERDATABASESTATERESULT = 2016;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT = 2017;
    public static final int RP_GETSEGMENTATION = 2018;
    public static final int RP_RESPONSESEGMENTATIONFORTRUFFLES = 2019;
    public static final int RT_INITIALIZE = 1000;
    public static final int RT_ADDSYMBOL = 1001;
    public static final int RT_ADDSYMBOLS = 1002;
    public static final int RT_REMOVESYMBOL = 1003;
    public static final int RT_REMOVEALLSYMBOLS = 1004;
    public static final int RT_CLEAR = 1005;
    public static final int RT_BUILDCANDIDATES = 1006;
    public static final int RT_GETSPELLING = 1007;
    public static final int RT_GETCANDIDATES = 1008;
    public static final int RT_SELECTCANDIDATE = 1009;
    public static final int RT_SETBOOLEANPARAMETER = 1015;
    public static final int RT_SETINTPARAMETER = 1016;
    public static final int RT_GETBOOLEANPARAMETER = 1017;
    public static final int RT_GETINTPARAMETER = 1018;
    public static final int RT_GETVERSIONINFO = 1019;
    public static final int RT_SETSTRINGPARAMETER = 1020;
    public static final int RT_GETSTRINGPARAMETER = 1021;
    public static final int RT_SETPREDICTIONCONTEXT = 1022;
    public static final int RT_CLEARPREDICTIONCONTEXT = 1023;
    public static final int RT_SETADDITIONALWORDDATABASES = 1024;
    public static final int RT_ADDUSERDEFINEDENTRY = 1025;
    public static final int RT_SETUSERDATABASESTATE = 1026;
    public static final int RT_RESETTOFACTORYSETTINGS = 1027;
    public static final int RT_GETSEGMENTATION = 1028;
    public static final int RT_REQUESTSEGMENTATIONFORTRUFFLES = 1029;

    public void initialize(int var1);

    public void addSymbol(char var1);

    public void addSymbols(String var1);

    public void removeSymbol();

    public void removeAllSymbols();

    public void clear();

    public void buildCandidates();

    public void getSpelling();

    public void getCandidates(int var1);

    public void selectCandidate(int var1);

    public void setBooleanParameter(int var1, boolean var2);

    public void setIntParameter(int var1, int var2);

    public void getBooleanParameter(int var1);

    public void getIntParameter(int var1);

    public void getVersionInfo();

    public void setStringParameter(int var1, String var2);

    public void getStringParameter(int var1);

    public void setPredictionContext(String var1);

    public void clearPredictionContext();

    public void addUserDefinedEntry(UserDefinedEntry var1);

    public void setAdditionalWordDatabases(WordDatabase[] var1);

    public void setUserDatabaseState(int var1, int var2);

    public void resetToFactorySettings();

    public void getSegmentation(String var1);

    public void requestSegmentationForTruffles(String var1);
}

