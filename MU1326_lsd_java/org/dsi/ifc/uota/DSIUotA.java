/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.uota;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIUotA
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int ATTR_DOWNLOADSTATE = 1;
    public static final int ATTR_DOWNLOADPROGRESS = 2;
    public static final int ATTR_PACKAGESAVAILABLE = 3;
    public static final int ATTR_SERVCIEREADY = 4;
    public static final int STATE_DOWNLOAD_NOT_ACTIVE = 0;
    public static final int STATE_DOWNLOAD_ACTIVE = 1;
    public static final int STATE_DOWNLOAD_FINISHED = 2;
    public static final int STATE_DOWNLOAD_ERROR_CANCELED_BY_USER = 3;
    public static final int STATE_DOWNLOAD_WAIT_FOR_PDD = 4;
    public static final int STATE_ERROR = 10;
    public static final int STATE_DOWNLOAD_ERROR = 11;
    public static final int STATE_DOWNLOAD_ERROR_RETRY_POSSIBLE = 12;
    public static final int STATE_ERROR_CONNECTION_FAILURE = 13;
    public static final int STATE_DOWNLOAD_PREPARE_APP = 14;
    public static final int STATE_APP_SIGNAL = 15;
    public static final int STATE_DOWNLOAD_ACTIVE_APP = 16;
    public static final int STATE_WAIT_APP = 17;
    public static final int STATE_AUTH_ABORTED = 22;
    public static final int STATE_AUTH_ERROR = 23;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR = 1;
    public static final int RESULT_ERROR_INVALID_SESSION = 2;
    public static final int RESULT_ERROR_UNSUPPORTED = 3;
    public static final int RESULT_ERROR_INVALID_SYNTAX = 4;
    public static final int RESULT_ERROR_SERVICE_NOT_READY = 5;
    public static final int RESULT_CANCELLED = 6;
    public static final int ACTION_FACTORY_RESET = 1;
    public static final int ACTION_RESTART_DOWNLOAD = 2;
    public static final int ACTION_TRIGGER_SYSTEM_PROPOSAL = 3;
    public static final int ACTION_TRIGGER_FINAL_POPUP = 4;
    public static final int ACTION_FINAL_POPUP_CONFIRMED = 5;
    public static final int ACTION_CUSTOMER_DETAILS = 6;
    public static final int KIND_UNSPECIFIED_LOCALIZED_INFO = 0;
    public static final int KIND_DOWNLOADING = 1;
    public static final int KIND_VERIFYING = 2;
    public static final int KIND_INSTALLING = 3;
    public static final int KIND_PREPARING = 4;
    public static final int KIND_POSTPROCESSING = 5;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_BUSINESS = 0;
    public static final int TYPE_TECHNICAL = 1;
    public static final int ATTRIBUTE_SOURCE_PATH_FOR_SWDL = 1;
    public static final String FEATURE_MULTIPLE_SESSIONS = "DSIUotA/feature/multiple-sessions";
    public static final String FEATURE_FINAL_POPUP_CONFIRMATION = "DSIUotA/feature/final-popup-confirmation";
    public static final String FEATURE_TRIGGER_CUSTOMER_DOWNLOAD_DETAILS = "DSIUotA/feature/customer-download-details";
    public static final int ADDINFO_SELECTED = 1;
    public static final int ADDINFO_UPTODATE = 2;
    public static final int ADDINFO_AUTOSELECT = 4;
    public static final int ADDINFO_HIDDEN = 8;
    public static final int RT_GETSERVERLIST = 1002;
    public static final int RT_GETUPDATEPACKAGES = 1003;
    public static final int RT_TOGGLESELECTION = 1005;
    public static final int RT_STARTDOWNLOAD = 1006;
    public static final int RT_ABORTDOWNLOAD = 1007;
    public static final int RT_TRIGGERACTION = 1008;
    public static final int RT_GETATTRIBUTE = 1009;
    public static final int RT_SETFEATURE = 1010;
    public static final int RT_GETFEATURE = 1011;
    public static final int RT_SETLANGUAGE = 1012;
    public static final int RT_CUSTOMERDOWNLOADFINISHED = 1013;
    public static final int RT_SETSELECTION = 1014;
    public static final int RT_GETUPDATEPACKAGESFORDESTINATIONS = 1015;
    public static final int RT_APPAVAILABLE = 1016;
    public static final int RT_STARTDOWNLOADVIAAPP = 1017;
    public static final int RT_TRANSFERDATAFROMAPP = 1018;
    public static final int RP_GETSERVERLIST = 2000;
    public static final int RP_TOGGLESELECTION = 2003;
    public static final int RP_STARTDOWNLOAD = 2004;
    public static final int RP_FEATURERESULT = 2005;
    public static final int RP_GETUPDATEPACKAGESFORDESTINATIONS = 2006;
    public static final int RP_ABORTDOWNLOAD = 2007;
    public static final int RP_CUSTOMERDOWNLOADFINISHED = 2008;
    public static final int IN_TRIGGERACTION = 3000;
    public static final int IN_GETUPDATEPACKAGES = 3001;
    public static final int IN_ATTRIBUTERESULT = 3002;
    public static final int IN_GETUPDATEPACKAGESVIAAPP = 3003;

    public void getServerList();

    public void getUpdatePackages(int var1, String var2, String var3);

    public void toggleSelection(int var1, int var2);

    public void startDownload(int var1);

    public void abortDownload(int var1);

    public void triggerAction(int var1, int var2, String var3);

    public void getAttribute(int var1, int var2);

    public void setFeature(String var1, boolean var2);

    public void getFeature(String var1);

    public void setLanguage(String var1);

    public void customerDownloadFinished(int var1, int var2, boolean var3);

    public void setSelection(int var1, int[] var2);

    public void getUpdatePackagesForDestinations(int var1, NavLocationWgs84[] var2, int var3);

    public void appAvailable(int var1, String var2, int var3, int var4, long var5);

    public void startDownloadViaApp(int var1);

    public void transferDataFromApp(int var1);
}

