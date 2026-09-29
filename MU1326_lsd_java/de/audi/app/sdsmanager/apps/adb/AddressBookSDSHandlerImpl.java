/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils;
import de.audi.app.sdsmanager.apps.adb.AddressBookPicklistHandler;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler$TelNumberInfo;
import de.audi.app.sdsmanager.apps.adb.IAddressBookPicklistHandler;
import de.audi.app.sdsmanager.apps.adb.commands.ADBCategorySetCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBContactListLineSetCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBDestByIDOpenCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBDestSetCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBDetailListLineTypeGetCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBEntrySelectionInterruptCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBListHideCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBListShowCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBMailByIDOpenCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBNavigateToRecogCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBNumberByIDOpenCommand;
import de.audi.app.sdsmanager.apps.adb.commands.ADBTopRecEntryOpenCommand;
import de.audi.app.sdsmanager.apps.adb.commands.IADBNumberCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviListShowCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.interapp.ADBSDSServiceListener;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NullADBSDSService;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.ResourceLocator;

public class AddressBookSDSHandlerImpl
extends AbstractSDSApplication
implements AddressBookSDSHandler,
ADBSDSServiceListener {
    private static final int SOURCE_CURRENT;
    private static final int SOURCE_NBEST;
    private static final int SOURCE_PICKLIST;
    private static final int SOURCE_REDIAL;
    private static final int SOURCE_CALLSTACK_NBEST;
    private static final int SOURCE_CALLSTACK_PICKLIST;
    private static final int SOURCE_LINE_SELECTION;
    private static final int SOURCE_STORED;
    private static final int[] commands;
    private final LogChannel lc = Logger.getAppADBLog();
    private ADBSDSService adbService = new NullADBSDSService(this.lc);
    private NaviService naviService = new NullNaviService(this.lc);
    private final HMIService hmi;
    private final IAddressBookPicklistHandler pickListHandler;
    private final SDSAppFactory factory;
    private int phoneNumberTypes = 0;
    private long[] entryIDs = new long[0];
    private long selectedEntryID;
    private long currentEntryID;
    private int[] navLocations = new int[0];
    private long adbEntrySelectionInterruptID;
    private AddressBookSDSHandler$TelNumberInfo telNumInfo = new AddressBookSDSHandler$TelNumberInfo();

    public AddressBookSDSHandlerImpl(HMIService hMIService, SDSHandlerService sDSHandlerService, SDSAppFactory sDSAppFactory, NBestStorageAccess nBestStorageAccess, ISDSPopupHelper iSDSPopupHelper) {
        super(sDSHandlerService, nBestStorageAccess);
        this.hmi = hMIService;
        this.factory = sDSAppFactory;
        this.pickListHandler = new AddressBookPicklistHandler(this, hMIService, iSDSPopupHelper);
        this.telNumInfo.setTelNumDetails(new ADBSDSService$TelNumberDetails());
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl initialized.");
    }

    @Override
    public void setADBService(ADBSDSService aDBSDSService) {
        if (aDBSDSService == null) {
            return;
        }
        this.adbService = aDBSDSService;
    }

    @Override
    public ADBSDSService getADBService() {
        return this.adbService;
    }

    @Override
    public void setNaviService(NaviService naviService) {
        if (naviService == null) {
            return;
        }
        this.naviService = naviService;
    }

    @Override
    public void unsetADBService() {
        this.adbService = new NullADBSDSService(this.lc);
    }

    @Override
    public void unsetNaviService() {
        this.naviService = new NullNaviService(this.lc);
    }

    @Override
    public int getProfileID() {
        return this.adbService.getAdbProfileID();
    }

    @Override
    public int[] getCommands() {
        return commands;
    }

    @Override
    public boolean freezeLists() {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#freezeLists: called");
        return this.adbService.freezeDynamicLists() == 0;
    }

    @Override
    public boolean unfreezeLists() {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#unfreezeLists: called");
        return this.adbService.unfreezeDynamicLists() == 0;
    }

    @Override
    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#processCommand: name=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 70007: {
                commandList.add(new ADBCategorySetCommand(this.lc, "ADB_CATEGORYSET", this.sdsHandlerService, iSystemCallParameterArray, this));
                commandList.execute("SYSTEMCALL ADB_CATEGORYSET");
                break;
            }
            case 70000: {
                commandList.add(new ADBDestByIDOpenCommand(this.lc, "ADB_DESTBYIDOPEN", this.sdsHandlerService, iSystemCallParameterArray, this, this.adbService));
                commandList.execute("SYSTEMCALL ADB_DESTBYIDOPEN");
                break;
            }
            case 70001: {
                commandList.add(new ADBDestSetCommand(this.lc, "ADB_DESTSET", this.sdsHandlerService, iSystemCallParameterArray, this.adbService, this.naviService, this.nBestStorage, this, this.factory.getSDSHandlerNavi()));
                commandList.execute("SYSTEMCALL ADB_DESTSET");
                break;
            }
            case 70002: {
                commandList.add(new ADBListHideCommand(this.lc, "ADB_LISTHIDE", this.sdsHandlerService, iSystemCallParameterArray, this.pickListHandler));
                commandList.execute("SYSTEMCALL ADB_LISTHIDE");
                break;
            }
            case 70003: {
                commandList.add(new ADBListShowCommand(this.lc, "ADB_LISTSHOW", this.sdsHandlerService, iSystemCallParameterArray, this.pickListHandler, this, this.adbService, this.factory.getSDSHandlerPhone(), this.factory.getSDSHandlerMessageDictation(), this.nBestStorage));
                commandList.execute("SYSTEMCALL ADB_LISTSHOW");
                break;
            }
            case 70005: {
                commandList.add(new ADBNavigateToRecogCommand(this.lc, "ADB_NAVIGATE_TO_RECOG", this.sdsHandlerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL ADB_NAVIGATE_TO_RECOG");
                break;
            }
            case 70006: {
                commandList.add(new ADBNumberByIDOpenCommand(this.lc, "ADB_NUMBERBYIDOPEN", this.sdsHandlerService, iSystemCallParameterArray, this, this.adbService));
                commandList.execute("SYSTEMCALL ADB_NUMBERBYIDOPEN");
                break;
            }
            case 70009: {
                commandList.add(new ADBMailByIDOpenCommand(this.lc, "ADB_MAILBYIDOPEN", this.sdsHandlerService, iSystemCallParameterArray, this, this.adbService, this.factory.getSDSHandlerMessageDictation()));
                commandList.execute("SYSTEMCALL ADB_MAILBYIDOPEN");
                break;
            }
            case 70008: {
                commandList.add(new ADBTopRecEntryOpenCommand(this.lc, "ADB_TOPRECENTRYOPEN", this.sdsHandlerService, iSystemCallParameterArray, this, this.adbService));
                commandList.execute("SYSTEMCALL ADB_TOPRECENTRYOPEN");
                break;
            }
            case 70004: {
                commandList.add(new ADBEntrySelectionInterruptCommand(this.lc, "ADB_ENTRYSELECTIONINTERRUPT", this.sdsHandlerService, iSystemCallParameterArray, this, this.nBestStorage));
                commandList.execute("SYSTEMCALL ADB_ENTRYSELECTIONINTERRUPT");
                break;
            }
            case 70010: {
                commandList.add(new ADBListLineDataGetCommand(this.lc, "ADB_LISTLINEDATAGET", this.sdsHandlerService, this.hmi, this, this.nBestStorage, this.adbService, this.factory.getSDSHandlerPhone(), this.factory.getSDSHandlerMessageDictation()));
                commandList.execute("SYSTEMCALL ADB_LISTLINEDATAGET");
                break;
            }
            case 70011: {
                commandList.add(new ADBDetailListLineTypeGetCommand(this.lc, "ADB_DETAILLISTLINETYPEGET", this.sdsHandlerService));
                commandList.execute("SYSTEMCALL ADB_DETAILLISTLINETYPEGET");
                break;
            }
            case 70012: {
                commandList.add(new ADBContactListLineSetCommand(this.lc, "ADB_CONTACTLISTLINESET", this.hmi, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL ADB_CONTACTLISTLINESET");
                break;
            }
            default: {
                this.lc.log(10000, "AddressBookSDSHandlerImpl#processCommand: Unhandled command ID %1!", (long)n);
            }
        }
    }

    @Override
    public long getADBID(int n) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#getADBID: ID for ADB entry requested, entrySource=%1!", (long)n);
        switch (n) {
            case 0: {
                long l = this.adbService.getCurrentEntryId();
                this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#getADBID: Current entry requested, returning adbDetailsID %1!", l);
                return l;
            }
            case 7: {
                this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#getADBID: Stored entry requested, returning currentHandlerID %1!", this.currentEntryID);
                return this.currentEntryID;
            }
            case 1: {
                long l = this.handleNBestRecogForPicklist();
                return l == -1L ? 0L : l;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#getADBID: returning selectedID %1!", this.selectedEntryID);
                return this.selectedEntryID;
            }
        }
        this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#getADBID: Unhandled source %1, returning 0!", (long)n);
        return 0L;
    }

    private long handleNBestRecogForPicklist() {
        long l;
        IPicklistElement iPicklistElement = this.nBestStorage.getMatchingPicklist((byte)0).get(0);
        if (iPicklistElement == null) {
            this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleNBestRecogForPicklist: element is null -> return -1!");
            return -1L;
        }
        IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
        if (iPicklistSlot == null) {
            this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleNBestRecogForPicklist: slot is null -> return -1!");
            return -1L;
        }
        long l2 = iPicklistSlot.getObjID();
        if (l2 != -1L) {
            this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleNBestRecogForPicklist: Valid slotObjID %1 found!", l2);
            return l2;
        }
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)2);
        if (SDSUtils.isEmpty(iPicklist)) {
            this.nBestStorage.resetPicklistsWithHistory();
            iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        }
        if ((l = SDSUtils.getSlotObjIDForSlotIndex(iPicklistSlot, iPicklist, this.lc)) != -1L) {
            this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleNBestRecogForPicklist: Valid slotObjID %1 via slot index found!", l);
            return l;
        }
        l = SDSUtils.getSlotObjIDForGGIndex(iPicklist, iPicklistElement.getGraphGroupIndex(), this.lc);
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleNBestRecogForPicklist: slotObjID %1 via GG index found!", l);
        return l;
    }

    @Override
    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof ADBListLineDataGetCommand;
    }

    @Override
    public void sdsListLineDataGet(int n, int n2) {
        try {
            ((ADBListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n, n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#sdsListLineDataGet: Active command is no ADBListLineDataGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#sdsListLineDataGet: NullpointerException. No command active!");
        }
    }

    @Override
    public void responseFillTelNumberList(int n, String string, int n2, String string2, int[] nArray) {
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand instanceof IADBNumberCommand) {
                ((IADBNumberCommand)((Object)abstractSystemCallCommand)).responseFillTelNumberList(n, string, n2, string2, nArray);
            } else if (abstractSystemCallCommand instanceof ADBListShowCommand) {
                ((ADBListShowCommand)abstractSystemCallCommand).responseFillTelNumberList(n, string, n2, string2, nArray.length);
            } else {
                this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillTelNumberList: Active command is no ADBNumberByIDOpenCommand and no ADBListShowCommand!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillTelNumberList: NullpointerException. No command active!");
        }
    }

    @Override
    public void responseFillEmailList(int n, String string, int n2, String string2, int n3) {
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand instanceof ADBMailByIDOpenCommand) {
                ((ADBMailByIDOpenCommand)abstractSystemCallCommand).responseFillEmailList(n, string, n3);
            } else {
                this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillMailAddressList: Active command is no ADBMailByIDOpenCommand!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillMailAddressList: NullpointerException. No command active!");
        }
    }

    @Override
    public void responseShowAddresses(int n, int[] nArray, String string) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#responseShowAddresses: resultCode=%3, availableAddresses=%1, combinedName=%2", (Object)nArray, (Object)string, (long)n);
        try {
            ((ADBDestByIDOpenCommand)SDSUtils.getActiveSystemCall()).responseShowAddresses(n, nArray, string);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseShowAddresses: Active command is no ADBDestByIDOpenCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseShowAddresses: NullpointerException. No command active!");
        }
    }

    @Override
    public void responseFillAdbPickList(int n) {
        try {
            ((ADBListShowCommand)SDSUtils.getActiveSystemCall()).responseFillAdbPickList(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillAdbPickList: Active command is no ADBListShowCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseFillAdbPickList: NullpointerException. No command active!");
        }
    }

    @Override
    public void responseOpenEntryDetails(int n, String string) {
        try {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand instanceof ADBTopRecEntryOpenCommand) {
                ((ADBTopRecEntryOpenCommand)abstractSystemCallCommand).responseOpenEntryDetails(n, string);
            } else if (abstractSystemCallCommand instanceof ADBListShowCommand) {
                ((ADBListShowCommand)abstractSystemCallCommand).responseOpenEntryDetails(n, string);
            } else {
                this.lc.log(10000, "AddressBookSDSHandlerImpl#responseOpenEntryDetails: Active command is no ADBTopRecEntryOpenCommand and no ADBListShowCommand!");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseOpenEntryDetails: NullpointerException. No command active!");
        }
    }

    @Override
    public long getCurrentEntryID() {
        return this.currentEntryID;
    }

    @Override
    public void setTelNumberDetails(ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setTelNumberDetails: value=%1", (Object)aDBSDSService$TelNumberDetails);
        this.telNumInfo.setTelNumDetails(aDBSDSService$TelNumberDetails);
    }

    @Override
    public void setCurrentEntryID(long l) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setCurrentEntryID: adbID=%1", l);
        this.currentEntryID = l;
    }

    @Override
    public AddressBookSDSHandler$TelNumberInfo getTelNumberInfo() {
        return this.telNumInfo;
    }

    @Override
    public int getPhoneNumberTypes() {
        return this.phoneNumberTypes;
    }

    @Override
    public void setPhoneNumberTypes(int n) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setPhoneNumberTypes: types=%1", (long)n);
        this.phoneNumberTypes = n;
    }

    @Override
    public long getADBEntrySelectionInterruptID() {
        return this.adbEntrySelectionInterruptID;
    }

    @Override
    public long getSelectedEntryID() {
        return this.selectedEntryID;
    }

    @Override
    public void setSelectedEntryID(long l) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setSelectedEntryID: id=%1", l);
        this.selectedEntryID = l;
    }

    @Override
    public void setNavLocations(int[] nArray) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setNavLocations: availableNavLocations=%1", (Object)nArray);
        this.navLocations = nArray;
    }

    @Override
    public long[] getEntryIDs() {
        return this.entryIDs;
    }

    @Override
    public void setEntryIDs(long[] lArray) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#setEntryIDs: ids=%1", (Object)lArray);
        this.entryIDs = lArray;
    }

    @Override
    public void setADBEntrySelectionInterruptID(long l) {
        this.adbEntrySelectionInterruptID = l;
    }

    @Override
    public int getNavLocationSize() {
        return SDSUtils.isEmpty(this.navLocations) ? 0 : this.navLocations.length;
    }

    @Override
    public int getNavLocationType(int n) {
        if (SDSUtils.isEmpty(this.navLocations) || n >= this.navLocations.length) {
            this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#getNavLocationType: Unhandled index %1, returning -1!", (long)n);
            return -1;
        }
        return this.navLocations[n];
    }

    @Override
    public int getNavLocationTypeByCategory(int n) {
        for (int i2 = 0; i2 < this.navLocations.length; ++i2) {
            int n2 = this.navLocations[i2];
            if (n == 2 && ADBSDSUtils.isWorkLocationAddressType(n2)) {
                return n2;
            }
            if (n != 1 || !ADBSDSUtils.isPrivateLocationAddressType(n2)) continue;
            return n2;
        }
        this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#getNavLocationType: Unhandled category %1, returning -1!", (long)n);
        return -1;
    }

    @Override
    public void handleItemSelectionInAdbList(int n, int n2) {
        BaseListModelApp baseListModelApp;
        try {
            baseListModelApp = this.hmi.getBaseListModel(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#handleItemSelectionInAdbList: failed to get ListModel modelID=%2 - %1", (Object)classCastException.getMessage(), (long)n);
            return;
        }
        if (baseListModelApp == null) {
            this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#handleItemSelectionInAdbList: model not found!");
            return;
        }
        EvoListRow evoListRow = baseListModelApp.getRow(n2);
        if (evoListRow == null) {
            this.lc.log(-1601830656, "AddressBookSDSHandlerImpl#handleItemSelectionInAdbList: EvoListRow not found!");
            return;
        }
        long l = this.adbService.getEntryIDFromListRow(evoListRow);
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#handleItemSelectionInAdbList: modelID=%1, row=%2, entryID=%3!", (long)n, (long)n2, l);
        this.selectedEntryID = l;
    }

    public String toString() {
        return "AddressBookSDSHandlerImpl";
    }

    @Override
    public void responseGetEntryNames(String[] stringArray) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#responseGetEntryNames: entryNames=%1!", (Object)SDSUtils.toString(stringArray, false));
        try {
            ((NaviListShowCommand)SDSUtils.getActiveSystemCall()).responseGetEntryNames(stringArray);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseGetEntryNames: Active command is no NaviListShowCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "AddressBookSDSHandlerImpl#responseGetEntryNames: NullpointerException. No active command!");
        }
    }

    @Override
    public ADBSDSService$TelNumberDetails getTelNumberDetails(int n) {
        return this.adbService != null ? this.adbService.getTelNumberDetails(n) : null;
    }

    @Override
    public void updateTelNumberInfo(int n, int n2, String string) {
        this.lc.log(-2137614336, "AddressBookSDSHandlerImpl#updateTelNumberInfo: contactPictureRlUrl=%1, contactPictureRlId=%2, totalNumPhoneNumbers=%3", (Object)string, (long)n2, (long)n);
        ResourceLocator resourceLocator = n2 == -1 && SDSUtils.isEmpty(string) ? null : new ResourceLocator(n2, string);
        this.telNumInfo.setResourceLocator(resourceLocator);
        this.telNumInfo.setPhoneNumCount(n);
    }

    static {
        commands = new int[]{0x77110100, 0x70110100, 0x71110100, 1947271424, 1913716992, 2047934720, 2064711936, 1930494208, 1964048640, 1980825856, 2014380288, 2031157504, 2081489152};
    }
}

