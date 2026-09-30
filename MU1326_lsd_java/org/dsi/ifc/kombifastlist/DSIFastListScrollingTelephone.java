/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface DSIFastListScrollingTelephone
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int IN_INDICATIONPHONEBOOK = 3000;
    public static final int IN_INDICATIONGETINITIALSTELEPHONE = 3001;
    public static final int IN_INDICATIONNOTIFYFAVORITELISTPUSH = 3002;
    public static final int IN_INDICATIONNOTIFYCOMBINEDNUMBERSPUSH = 3003;
    public static final int IN_INDICATIONNOTIFYCURRENTLISTSIZETELEPHONE = 3004;
    public static final int IN_INDICATIONPHONEBOOKJOBS = 3005;
    public static final int RT_PUSHFUNCTIONAVAILABILITYTELEPHONE = 1000;
    public static final int RT_PUSHMOSTOPERATIONSTATETELEPHONE = 1001;
    public static final int RT_RESPONSEPHONEBOOK = 1002;
    public static final int RT_RESPONSEPHONEBOOKARRAY = 1003;
    public static final int RT_RESPONSEGETINITIALSTELEPHONE = 1004;
    public static final int RT_PUSHUPDATEFAVORITELIST = 1005;
    public static final int RT_PUSHCOMBINEDNUMBERS = 1006;
    public static final int RT_PUSHCURRENTLISTSIZETELEPHONE = 1007;
    public static final int RT_RESPONSEPHONEBOOKJOBS = 1008;
    public static final int RT_RESPONSENOTIFYCOMBINEDNUMBERSPUSH = 1009;
    public static final int RT_RESPONSENOTIFYCURRENTLISTSIZES = 1010;
    public static final int RT_RESPONSENOTIFYFAVORITELISTPUSH = 1011;
    public static final int FUNCTIONAVAILABILITY_PHONEBOOK = 0;
    public static final int FUNCTIONAVAILABILITY_GETINITIALS = 1;
    public static final int FUNCTIONAVAILABILITY_FAVORITELISTPUSH = 2;
    public static final int FUNCTIONAVAILABILITY_COMBINEDNUMBERSPUSH = 3;
    public static final int FUNCTIONAVAILABILITY_PHONEBOOKJOBS = 4;
    public static final int OPSTATE_NORMAL = 0;
    public static final int OPSTATE_OFFSTBY = 1;
    public static final int OPSTATE_INITIALISING = 3;
    public static final int OPSTATE_DEFECTIVE = 15;
    public static final int ASGID_DEFAULT = 0;
    public static final int ASGID_INSTRUMENTCLUSTER = 1;
    public static final int ASGID_HEADUPDISPLAY = 2;
    public static final int RECORDADDRESSPHONEBOOK_FULL = 0;
    public static final int RECORDADDRESSPHONEBOOK_PBNAMESTORAGEANYVOICETAGTELNUMBERQUANTITYADDRESSINDICATION = 1;
    public static final int RECORDADDRESSPHONEBOOK_TELNUMBERNVOICETAGNRESERVENNUMBERTYPEN = 2;
    public static final int RECORDADDRESSPHONEBOOK_PBNAMEANYVOICETAGTELNUMBERQUANTITYVOICETAGNRESERVENNUMBERTYPEN = 3;
    public static final int RECORDADDRESSPHONEBOOK_ANYVOICETAGTELNUMBERQUANTITYTELNUMBERNVOICETAGNRESERVENNUMBERTYPEN = 4;
    public static final int RECORDADDRESSPHONEBOOK_POS = 15;
    public static final int JOBMODIFICATION_NEW = 0;
    public static final int JOBMODIFICATION_CHANGE = 1;
    public static final int JOBMODIFICATION_CANCEL = 2;
    public static final int REQUESTEDLIST_PHONEBOOK = 0;
    public static final int REQUESTEDLIST_COMBINEDNUMBERS = 1;
    public static final int REQUESTEDLIST_DIALEDNUMBERS = 2;
    public static final int REQUESTEDLIST_FAVORITELIST = 3;
    public static final int REQUESTEDLIST_MISSEDCALLS = 4;
    public static final int REQUESTEDLIST_RECEIVEDCALLS = 5;
    public static final int MODE_SHIFT = 0;
    public static final int MODE_ARRAYDIRECTION = 1;
    public static final int MODE_ARRAYPOSTRANSMITTED = 2;
    public static final int MODE_INDEXSIZE = 3;
    public static final int MODE_CENTERPOSITION = 4;
    public static final int MODE_INDEXSIZE64BIT = 5;
    public static final int SENDREASON_REQUESTED = 0;
    public static final int SENDREASON_CHANGEDARRAY = 1;
    public static final int SENDREASON_JOBLIST = 2;
    public static final int JOBSRESULT_JOBEXECUTEDSUCCESSFULLY = 0;
    public static final int JOBSRESULT_JOBCANCELLEDDUETOERRORSINREQUEST = 1;
    public static final int JOBSRESULT_JOBCANCELLEDBYFSG = 2;
    public static final int JOBSRESULT_JOBCANCELLEDSUCCESSFULLYBZASG = 3;
    public static final int JOBSRESULT_JOBCANCELLEDUNSUCCESSFULLYALREADYINEXECUTION = 4;
    public static final int JOBSRESULT_ALLJOBSEXECUTEDSUCCESSFULLY = 10;
    public static final int JOBSRESULT_ALLJOBSCANCELLED = 11;
    public static final int STORAGEPB_UNDEFINED = 0;
    public static final int STORAGEPB_SIM = 1;
    public static final int STORAGEPB_MOBILEEQUIPMENT = 2;
    public static final int STORAGEPB_LOCALPUBLIC = 3;
    public static final int STORAGEPB_LOCALPRIVATE = 4;
    public static final int ANYVOICETAG_AVAILABILITY = 0;
    public static final int ANYVOICETAG_AVAILABLEFORSTANDARDNUMBER = 17;
    public static final int VOICETAG_AVAILABLE = 0;
    public static final int NUMBERTYPE_UNKNOWNNUMBERTYPE = 0;
    public static final int NUMBERTYPE_GENERAL = 1;
    public static final int NUMBERTYPE_MOBILE = 2;
    public static final int NUMBERTYPE_OFFICE = 3;
    public static final int NUMBERTYPE_HOME = 4;
    public static final int NUMBERTYPE_FAX = 5;
    public static final int NUMBERTYPE_PAGER = 6;
    public static final int NUMBERTYPE_CAR = 7;
    public static final int NUMBERTYPE_SIM = 8;
    public static final int NUMBERTYPE_MAINOFFICE = 9;
    public static final int NUMBERTYPE_MAINHOME = 10;
    public static final int NUMBERTYPE_CELLOFFICE = 11;
    public static final int NUMBERTYPE_CELLHOME = 12;
    public static final int NUMBERTYPE_FAXOFFICE = 13;
    public static final int NUMBERTYPE_FAXHOME = 14;
    public static final int CALLMODE_UNKNOWNCALLMODE = 0;
    public static final int CALLMODE_MISSEDCALL = 1;
    public static final int CALLMODE_RECEIVEDCALL = 2;
    public static final int CALLMODE_DIALEDNUMBER = 3;

    public void pushFunctionAvailabilityTelephone(int var1);

    public void pushMOSTOperationStateTelephone(short var1);

    public void responsePhonebook(int var1, int var2, int var3, int var4, int var5, long var6, int var8, int var9, int var10, int var11, int var12, int var13, int var14);

    public void responsePhonebookArray(int var1, int var2, DataPhonebook[] var3);

    public void responseGetInitialsTelephone(int var1, int var2, int var3, int var4, DataInitials[] var5);

    public void pushupdateFavoriteList(int var1, int var2, DataFavoriteList[] var3);

    public void pushCombinedNumbers(int var1, int var2, DataCombinedNumbers[] var3);

    public void pushCurrentListSizeTelephone(int var1, int var2, int var3);

    public void responsePhonebookJobs(int var1, int var2, int var3);

    public void responseNotifyCombinedNumbersPush(boolean var1);

    public void responseNotifyCurrentListSizes(boolean var1);

    public void responseNotifyFavoriteListPush(boolean var1);
}

