/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.apps.system.ISDSScreenConnectedUpdatable;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NaviListShowCommand
extends AbstractSystemCallCommand
implements ISDSScreenConnectedUpdatable {
    protected final NaviSDSHandlerImpl sdsHandler;
    private final SDSAppFactory appFactory;
    private final HMIService hmi;
    protected final ISDSPopupHelper sdsPopupHelper;
    private final NaviService naviService;
    private final ADBSDSService adbService;
    protected final NBestStorageAccess nBestStorage;
    protected final byte listMode;
    protected int popupMappingID;
    private NaviService.NaviSUIDetails[] naviSUIDetails;
    private List adbEntryIDsRequestList = new LinkedList();
    private volatile int requestCounter = 2;
    private static final int[][] listMode2titleValue2titleModel = new int[][]{{4, 1, 3833}, {1, 1, 3833}, {6, 0, 3833}, {0, 0, 3833}, {38, 7, 3833}, {7, 7, 3833}, {2, 2, 3833}, {3, 7, 3833}, {8, 2, 3833}, {9, 2, 3833}, {11, 3, 3833}, {14, 4, 3833}, {16, 5, 3833}, {30, 8, 3833}, {13, 1, 3831}, {17, 0, 3831}, {15, 0, 3830}, {27, 0, 3831}, {18, 1, 3830}, {19, 0, 3831}, {20, 1, 3833}, {21, 6, 3833}, {12, 9, 3833}, {33, 0, 3833}, {34, 10, 3833}, {35, 11, 3833}, {36, 12, 3833}, {37, 13, 3833}, {40, 8, 3833}, {41, 14, 3833}, {42, 15, 3833}, {43, 16, 3833}, {44, 17, 3833}, {45, 18, 3833}, {46, 19, 3833}};

    public NaviListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandlerImpl naviSDSHandlerImpl, SDSAppFactory sDSAppFactory, HMIService hMIService, ISDSPopupHelper iSDSPopupHelper, NaviService naviService, ADBSDSService aDBSDSService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.appFactory = sDSAppFactory;
        this.hmi = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.naviService = naviService;
        this.adbService = aDBSDSService;
        this.nBestStorage = nBestStorageAccess;
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute() {
        this.logger.log(10000000, "%1#execute: listModeID=%2", (Object)this.getName(), (long)this.listMode);
        this.sdsHandler.setPickListMode(this.listMode);
        if (!NaviSDSUtils.isOneshotPickListMode(this.listMode)) {
            this.nBestStorage.resetPicklistsWithHistory();
        }
        this.popupMappingID = SDSUtils.translate((int)this.listMode, NaviSDSUtils.listMode2PopupMappingID);
        this.logger.log(10000000, "%1#execute: popupMappingID=%2", (Object)this.getName(), (long)this.popupMappingID);
        if (this.popupMappingID == Integer.MIN_VALUE) {
            this.logger.log(10000, "%1#execute: no mapping for listmode %2", (Object)this.getName(), (long)this.listMode);
            this.sendResult(3001);
            return;
        }
        int n = SDSManagerBaseActivator.getMapping().getPopupMappingID(this.hmi.getCurrentPopup());
        if (n == this.popupMappingID) {
            NaviListShowCommand naviListShowCommand = this;
            synchronized (naviListShowCommand) {
                --this.requestCounter;
            }
        }
        switch (this.listMode) {
            case 15: {
                this.logger.log(10000000, "%1#execute: POI result mode active, showing POI result list!", (Object)this.getName());
                this.showPOIResultScreen();
                break;
            }
            case 19: {
                this.showPOIOneshotPicklistPoi();
                break;
            }
            case 20: {
                this.showPOIOneshotPicklistCity();
                break;
            }
            case 13: 
            case 17: 
            case 27: {
                this.logger.log(10000000, "%1#execute: POI picklist mode active, showing POI picklist!", (Object)this.getName());
                this.showPOIPickList();
                break;
            }
            case 25: 
            case 26: 
            case 29: {
                this.showPartialPopup();
                this.sendResult(3000);
                return;
            }
            case 22: 
            case 24: 
            case 31: 
            case 39: 
            case 47: {
                this.showNonPicklistScreen();
                this.sendResult(3000);
                return;
            }
            case 23: {
                this.showNonPicklistScreen();
                this.checkSystemcallFinished();
                break;
            }
            case 34: 
            case 40: {
                this.showNaviPicklistScreen();
                break;
            }
            default: {
                this.logger.log(10000000, "%1#execute: No POI picklist mode active, assuming VDE!", (Object)this.getName());
                this.showNaviPickList();
            }
        }
    }

    private void showPOIOneshotPicklistCity() {
        this.logger.log(10000000, "%1#showPOIOneshotPicklist: listMode=%2", (Object)this.getName(), (long)this.listMode);
        SDSListEntry[] sDSListEntryArray = SDSUtils.convertFirstSlotContentToSDSListEntryArray(this.sdsHandler.getEntryPicklist().getElements());
        SDSModelAccess.setDisambiguationLabel(sDSListEntryArray);
        this.logger.log(10000000, "%1#showPOIOneshotPicklist: -> fillNaviPicklist!", (Object)this.getName());
        byte by = this.naviService.fillNaviPickList(sDSListEntryArray);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(10000000, "%1#showPOIOneshotPicklist: sdsResult=%2!", (Object)this.getName(), (long)n);
        if (n == 3000) {
            this.showNaviPicklistScreen();
        } else {
            this.sendResult(n);
        }
    }

    private void showPOIOneshotPicklistPoi() {
        this.logger.log(10000000, "%1#showPOIOneshotPicklist: listMode=%2", (Object)this.getName(), (long)this.listMode);
        this.showPOIPickListHelper(SDSUtils.convertFirstSlotContentToSDSListEntryArray(this.sdsHandler.getEntryPicklist().getElements()));
    }

    private void showPOIPickList() {
        this.logger.log(10000000, "%1#showPOIPickList: listMode=%2", (Object)this.getName(), (long)this.listMode);
        this.showPOIPickListHelper(SDSUtils.createSDSListFromPicklist(this.nBestStorage.getMatchingPicklist((byte)1)));
    }

    private void showPOIPickListHelper(SDSListEntry[] sDSListEntryArray) {
        this.logger.log(10000000, "%1#showPOIPickListHelper: entries=%2!", (Object)this.getName(), (Object)sDSListEntryArray);
        SDSModelAccess.setDisambiguationLabel(sDSListEntryArray);
        byte by = this.naviService.fillPOIPickList(sDSListEntryArray);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(10000000, "%1#showPOIPickListHelper: result=%2, sdsResult=%3!", (Object)this.getName(), (long)by, (long)n);
        if (n == 3000) {
            this.showPOIPicklistScreen();
        } else {
            this.sendResult(n);
        }
    }

    protected void showNaviPickList() {
        this.logger.log(10000000, "%1#showNaviPickList: listMode=%2", (Object)this.getName(), (long)this.listMode);
        byte by = 1;
        if (this.listMode != 18) {
            by = this.retrieveNaviResult();
            this.showPopupOrSendErrorResult(by);
            return;
        }
        this.logger.log(10000000, "%1#showNaviPickList: is AllInOneShot/SUI.", (Object)this.getName());
        this.handleNaviSUI();
        if (this.adbEntryIDsRequestList.size() > 0) {
            this.logger.log(10000000, "%1#showNaviPickList: resolve #%2 ADB contacts", (Object)this.getName(), (long)this.adbEntryIDsRequestList.size());
            long[] lArray = new long[this.adbEntryIDsRequestList.size()];
            Iterator iterator = this.adbEntryIDsRequestList.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                lArray[n++] = (Long)iterator.next();
            }
            this.logger.log(10000000, "%1#showNaviPickList: start asynchronous ADB contacts resolution of ObjIDs=%2.", (Object)this.getName(), (Object)SDSUtils.toString(lArray));
            this.adbService.getEntryNames(lArray);
            return;
        }
        this.logger.log(10000000, "%1#showNaviPickList: naviSUIDetails=%2!", (Object)this.getName(), (Object)SDSUtils.toString((Object[])this.naviSUIDetails, true));
        by = this.naviService.fillNaviSUIList(this.naviSUIDetails);
        this.logger.log(10000000, "%1#showNaviPickList: result=%2!", (Object)this.getName(), (long)by);
        this.showPopupOrSendErrorResult(by);
    }

    public void responseGetEntryNames(String[] stringArray) {
        byte by;
        this.logger.log(10000000, "%1#responseGetEntryNames: called. with entryNames.length = %2!", (Object)this.getName(), (long)stringArray.length);
        if (SDSUtils.isEmpty(stringArray) || stringArray.length != this.adbEntryIDsRequestList.size()) {
            this.logger.log(100000, "%1#responseGetEntryNames: entryNames is empty or has invalid length!", (Object)this.getName());
        } else {
            by = 0;
            for (int i2 = 0; i2 < this.naviSUIDetails.length && by < stringArray.length; ++i2) {
                NaviService.NaviSUIDetails naviSUIDetails = this.naviSUIDetails[i2];
                if (naviSUIDetails.adbID == -1L) continue;
                String string = naviSUIDetails.adbName;
                naviSUIDetails.adbName = stringArray[by++];
                if (i2 == 0 || i2 == 1) {
                    SDSModelAccess.setDisambiguationLineLabel(naviSUIDetails.adbName, i2);
                }
                this.logger.log(10000000, "%1#responseGetEntryNames: replaced ADB contact %2 with %3!", (Object)this.getName(), (Object)string, (Object)naviSUIDetails.adbName);
            }
        }
        this.logger.log(10000000, "%1#responseGetEntryNames: naviSUIDetails=%2!", (Object)this.getName(), (Object)SDSUtils.toString((Object[])this.naviSUIDetails, true));
        by = this.naviService.fillNaviSUIList(this.naviSUIDetails);
        this.logger.log(10000000, "%1#responseGetEntryNames: result=%2!", (Object)this.getName(), (long)by);
        this.showPopupOrSendErrorResult(by);
    }

    protected void showPopupOrSendErrorResult(byte by) {
        this.logger.log(10000000, "%1#showPopupAndSendResult: result=%2!", (Object)this.getName(), (long)by);
        if (by != 2 && by != 0) {
            this.logger.log(100000, "%1#showPopupAndSendResult: Error occurred, NOT showing popup!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        if (this.listMode == 18) {
            this.showNaviResultScreen();
        } else {
            this.showNaviPicklistScreen();
        }
    }

    private void handleNaviSUI() {
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        this.sdsHandler.setEntryPicklist(iPicklist);
        Object[] objectArray = SDSUtils.convertFirstSlotContentToSDSListEntryArray(iPicklist.getElements());
        this.logger.log(10000000, "%1#handleNaviSUI: entries=%2!", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
        this.appFactory.getSDSHandlerADB().setEntryIDs(NaviListShowCommand.getEntryIDs((SDSListEntry[])objectArray));
        SDSUtils.handleDisambiguationLabels(iPicklist);
        this.logger.log(10000000, "%1#handleNaviSUI: entries=%2!", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
        int n = iPicklist.getSize();
        this.logger.log(10000000, "%1#handleNaviSUI: size=%2", (Object)this.getName(), (long)n);
        this.naviSUIDetails = new NaviService.NaviSUIDetails[n];
        for (int i2 = 0; i2 < n; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement == null) {
                this.logger.log(100000, "%1#handleNaviSUI: Empty element #%2!", (Object)this.getName(), (long)i2);
                continue;
            }
            int n2 = iPicklistElement.getRuleID();
            int n3 = SDSManagerBaseActivator.getMapping().getSUITypeForRule(n2);
            this.logger.log(10000000, "%1#handleNaviSUI: ruleID=%2, suiMappingType=%3!", (Object)this.getName(), (long)n2, (long)n3);
            this.naviSUIDetails[i2] = this.createNaviSUIDetails(i2, n3, iPicklistElement.getSlots());
        }
    }

    private NaviService.NaviSUIDetails createNaviSUIDetails(int n, int n2, IPicklistSlot[] iPicklistSlotArray) {
        NaviService.NaviSUIDetails naviSUIDetails = new NaviService.NaviSUIDetails();
        if (SDSUtils.isEmpty(iPicklistSlotArray)) {
            this.logger.log(100000, "%1#createNaviSUIDetails: Empty slots for element %2!", (Object)this.getName(), (long)n);
            return naviSUIDetails;
        }
        IPicklistSlot iPicklistSlot = iPicklistSlotArray[0];
        if (iPicklistSlot == null) {
            this.logger.log(100000, "%1#createNaviSUIDetails: Empty first slot for element %2!", (Object)this.getName(), (long)n);
            return naviSUIDetails;
        }
        switch (n2) {
            case 2: {
                naviSUIDetails.adbID = iPicklistSlot.getObjID();
                naviSUIDetails.adbName = iPicklistSlot.getText();
                this.adbEntryIDsRequestList.add(new Long(iPicklistSlot.getObjID()));
                naviSUIDetails.poiID = -1L;
                naviSUIDetails.poiIconID = -1L;
                break;
            }
            case 3: {
                naviSUIDetails.poiID = iPicklistSlot.getObjID();
                naviSUIDetails.poiName = iPicklistSlot.getText();
                naviSUIDetails.adbID = -1L;
                break;
            }
            case 4: {
                naviSUIDetails.poiID = iPicklistSlot.getObjID();
                naviSUIDetails.poiName = iPicklistSlot.getText();
                naviSUIDetails.adbID = -1L;
                if (iPicklistSlotArray.length <= 1) break;
                naviSUIDetails.city = iPicklistSlotArray[1].getText();
                naviSUIDetails.cityStringID = iPicklistSlotArray[1].getObjectStringID();
                break;
            }
            case 1: {
                if (this.sdsHandlerService.getFramework().isJp() || this.sdsHandlerService.getFramework().isKorea()) {
                    NaviListShowCommand.fillAddressDataJpKr(naviSUIDetails, iPicklistSlotArray);
                } else {
                    naviSUIDetails.city = iPicklistSlot.getText();
                    naviSUIDetails.cityStringID = iPicklistSlot.getObjectStringID();
                    NaviListShowCommand.fillRemainingAddressData(naviSUIDetails, iPicklistSlotArray);
                }
            }
            default: {
                naviSUIDetails.adbID = -1L;
                naviSUIDetails.poiID = -1L;
                naviSUIDetails.poiIconID = -1L;
            }
        }
        return naviSUIDetails;
    }

    /*
     * Enabled aggressive block sorting
     */
    private byte retrieveNaviResult() {
        Object[] objectArray;
        this.logger.log(10000000, "%1#retrieveNaviResult: called", (Object)this.getName());
        boolean bl = this.listMode == 14 || this.listMode == 16 || this.listMode == 33;
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist(bl ? (byte)0 : 1);
        if (NaviSDSUtils.isOneshotPickListMode(this.listMode)) {
            IPicklist iPicklist2;
            this.logger.log(10000000, "%1#retrieveNaviResult: Oneshot mode requested!", (Object)this.getName());
            NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
            IPicklist iPicklist3 = iPicklist2 = naviOneshotHandler == null ? this.sdsHandler.getEntryPicklist() : naviOneshotHandler.getCurrentPicklist();
            if (iPicklist2 == null) {
                this.logger.log(10000, "%1#retrieveNaviResult: picklist null", (Object)this.getName());
                return 1;
            }
            objectArray = SDSUtils.convertFirstSlotContentToSDSListEntryArray(iPicklist2.getElements());
        } else {
            this.logger.log(10000000, "%1#retrieveNaviResult: Picklist with n-best list requested!", (Object)this.getName());
            this.sdsHandler.setEntryPicklist(iPicklist);
            objectArray = this.listMode == 33 ? SDSUtils.convertHighestAvailableSlotContentToSDSListEntryArray(iPicklist.getElements()) : SDSUtils.convertFirstSlotContentToSDSListEntryArray(iPicklist.getElements());
            this.appFactory.getSDSHandlerADB().setEntryIDs(NaviListShowCommand.getEntryIDs((SDSListEntry[])objectArray));
        }
        SDSModelAccess.setDisambiguationLabel((SDSListEntry[])objectArray);
        this.logger.log(10000000, "%1#retrieveNaviResult: entries=%2!", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
        switch (this.listMode) {
            case 16: {
                return this.naviService.fillLastDestinationPickList((SDSListEntry[])objectArray);
            }
            case 14: {
                return this.naviService.fillNaviFavoritePickList((SDSListEntry[])objectArray);
            }
        }
        return this.naviService.fillNaviPickList((SDSListEntry[])objectArray);
    }

    private static long[] getEntryIDs(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray == null) {
            return new long[0];
        }
        int n = sDSListEntryArray.length;
        long[] lArray = new long[n];
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) continue;
            lArray[i2] = sDSListEntry.getId();
        }
        return lArray;
    }

    private static void fillRemainingAddressData(NaviService.NaviSUIDetails naviSUIDetails, IPicklistSlot[] iPicklistSlotArray) {
        IPicklistSlot iPicklistSlot;
        int n = iPicklistSlotArray.length;
        if (n > 1 && (iPicklistSlot = iPicklistSlotArray[1]) != null) {
            naviSUIDetails.street = iPicklistSlot.getText();
            naviSUIDetails.streetStringID = iPicklistSlot.getObjectStringID();
        }
        if (n > 2 && (iPicklistSlot = iPicklistSlotArray[2]) != null) {
            naviSUIDetails.houseNumber = iPicklistSlot.getText();
            naviSUIDetails.houseNumberStringID = iPicklistSlot.getObjectStringID();
        }
    }

    private static void fillAddressDataJpKr(NaviService.NaviSUIDetails naviSUIDetails, IPicklistSlot[] iPicklistSlotArray) {
        IPicklistSlot iPicklistSlot;
        naviSUIDetails.provinceOrPrefecture = iPicklistSlotArray[0].getText();
        naviSUIDetails.provinceOrPrefectureStringID = iPicklistSlotArray[0].getObjectStringID();
        int n = iPicklistSlotArray.length;
        if (n > 1 && (iPicklistSlot = iPicklistSlotArray[1]) != null) {
            naviSUIDetails.city = iPicklistSlot.getText();
            naviSUIDetails.cityStringID = iPicklistSlot.getObjectStringID();
        }
        if (n > 2 && (iPicklistSlot = iPicklistSlotArray[2]) != null) {
            naviSUIDetails.placeName = iPicklistSlot.getText();
            naviSUIDetails.placeNameStringID = iPicklistSlot.getObjectStringID();
        }
        if (n > 3 && (iPicklistSlot = iPicklistSlotArray[3]) != null) {
            naviSUIDetails.street = iPicklistSlot.getText();
            naviSUIDetails.streetStringID = iPicklistSlot.getObjectStringID();
        }
        if (n > 4 && (iPicklistSlot = iPicklistSlotArray[4]) != null) {
            naviSUIDetails.houseNumber = iPicklistSlot.getText();
            naviSUIDetails.houseNumberStringID = iPicklistSlot.getObjectStringID();
        }
    }

    private boolean setCorrectPicklistTitle() {
        this.logger.log(10000000, "%1#setCorrectPicklistTitle: listMode=%2", (Object)this.getName(), (long)this.listMode);
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        if (NaviSDSUtils.isOneshotPickListMode(this.listMode) && naviOneshotHandler != null) {
            naviOneshotHandler.handlePicklistTitle(this.listMode);
            return true;
        }
        int[] nArray = SDSUtils.translateMulti(this.listMode, listMode2titleValue2titleModel);
        int n = nArray[0];
        int n2 = nArray[1];
        if (n == Integer.MIN_VALUE || n2 == Integer.MIN_VALUE) {
            this.logger.log(100000, "%1#setCorrectPicklistTitle: Unsupported listMode %2!", (Object)this.getName(), (long)this.listMode);
            return false;
        }
        this.logger.log(10000000, "%1#setCorrectPicklistTitle: Setting %2 for model %3!", (Object)this.getName(), (long)n, (long)n2);
        this.hmi.getChoiceModel(n2).setValue(n);
        return true;
    }

    private void showNonPicklistScreen() {
        this.logger.log(10000000, "%1#showNonPicklistScreen called!", (Object)this.getName());
        this.sdsPopupHelper.triggerHapticalPopup(this.popupMappingID, true);
    }

    private void showPartialPopup() {
        this.logger.log(10000000, "%1#showPartialPopup called!", (Object)this.getName());
        this.sdsPopupHelper.triggerHapticalPartialPopup(this.popupMappingID, true);
    }

    private void displayPopup(int n, int n2) {
        this.logger.log(10000000, "%1#displayPopup: popupID=%2, modelID=%3", (Object)this.getName(), (long)n, (long)n2);
        SDSUtils.unlockPicklistModel(n2, this.hmi, this.logger);
        this.setCorrectPicklistTitle();
        this.sdsPopupHelper.triggerHapticalPopup(n, true);
        this.checkSystemcallFinished();
    }

    private void showNaviPicklistScreen() {
        this.displayPopup(this.popupMappingID, 3869);
    }

    private void showNaviResultScreen() {
        this.displayPopup(this.popupMappingID, 3871);
    }

    private void showPOIResultScreen() {
        this.displayPopup(this.popupMappingID, 3901);
    }

    private void showPOIPicklistScreen() {
        this.displayPopup(this.popupMappingID, 3870);
    }

    public void updateSDSScreenConnected(int n) {
        this.logger.log(10000000, "%1#updateSDSScreenConnected: screenID=%2", (Object)this.getName(), (long)n);
        this.checkSystemcallFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkSystemcallFinished() {
        this.logger.log(10000000, "%1#checkSystemcallFinished: requestCounter=%2", (Object)this.getName(), (long)this.requestCounter);
        boolean bl = false;
        NaviListShowCommand naviListShowCommand = this;
        synchronized (naviListShowCommand) {
            --this.requestCounter;
            bl = this.requestCounter == 0;
        }
        if (bl) {
            this.logger.log(10000000, "%1#checkSystemcallFinished: requestCounter is 0 => system call is done!", (Object)this.getName());
            this.sendResult(3000);
        } else {
            this.logger.log(10000000, "%1#checkSystemcallFinished: system call is not yet done!", (Object)this.getName());
        }
    }
}

