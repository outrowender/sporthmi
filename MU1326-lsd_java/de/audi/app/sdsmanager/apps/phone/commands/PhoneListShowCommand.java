/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils$TelNumberTypeToModelValueMapping;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.TelServiceCallStackEntry;
import java.util.ArrayList;

public class PhoneListShowCommand
extends AbstractSystemCallCommand {
    private static final int PHONE_TITLE_REDIAL;
    private static final int PHONE_TITLE_CALL;
    private final int listMode;
    private final NBestStorageAccess nBestStorage;
    private final HMIService hmi;
    private final ISDSPopupHelper popupHelper;
    private final ITelServiceSDS phoneService;
    private final PhoneSDSHandler phoneHandler;

    public PhoneListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NBestStorageAccess nBestStorageAccess, ISDSPopupHelper iSDSPopupHelper, ITelServiceSDS iTelServiceSDS, PhoneSDSHandler phoneSDSHandler, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.hmi = hMIService;
        this.popupHelper = iSDSPopupHelper;
        this.phoneService = iTelServiceSDS;
        this.phoneHandler = phoneSDSHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2!", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 5: {
                this.getLastDialed();
                return;
            }
            case 2: 
            case 4: {
                this.getCallstackFavoriteEntry();
                return;
            }
            case 0: 
            case 3: {
                this.showPicklist();
                return;
            }
        }
        this.logger.log(-1601830656, "%1#execute: unhandled list mode %2", (Object)this.getName(), (long)this.listMode);
        this.sendResult(30001);
    }

    private void showPicklist() {
        this.logger.log(-2137614336, "%1#showPicklist!", (Object)this.getName());
        boolean bl = this.triggerPicklist();
        if (!bl) {
            this.logger.log(-1601830656, "%1#execute: filling of picklist failed", (Object)this.getName());
            this.sendResult(30001);
            return;
        }
        if (this.listMode == 3) {
            SDSModelAccess.setPhonePicklistTitle(1);
        } else {
            SDSModelAccess.setPhonePicklistTitle(0);
        }
        SDSUtils.unlockPicklistModel(3938, this.hmi, this.logger);
        this.popupHelper.triggerHapticalPopup(30, true);
        this.sendResult(30000);
    }

    private void getCallstackFavoriteEntry() {
        int n;
        this.logger.log(-2137614336, "%1#fillNumScreen!", (Object)this.getName());
        long l = SDSUtils.getSelectedObjectId(this.nBestStorage, this.logger, 0);
        if (l == -1L) {
            this.logger.log(-1601830656, "PhoneListShowCommand#fillNumScreen: no slot id found!");
            this.sendResult(30001);
            return;
        }
        int n2 = n = this.listMode == 4 ? this.phoneHandler.getFavoriteIndexById(l) : this.phoneHandler.getCallStackIndexById(l);
        if (n == -1) {
            this.logger.log(-1601830656, "PhoneListShowCommand#fillNumScreen: id %1 not found in list!", (long)n);
            this.sendResult(30001);
            return;
        }
        String string = this.listMode == 4 ? this.phoneHandler.getFavoriteName(n) : this.phoneHandler.getCallStackName(n);
        String string2 = this.listMode == 4 ? this.phoneHandler.getFavoriteNumber(n) : this.phoneHandler.getCallStackNumber(n);
        this.fillNumScreen(string2, string, 1);
        this.sendResult(30000);
    }

    private void getLastDialed() {
        this.logger.log(-2137614336, "PhoneListShowCommand#getLastDialed");
        TelServiceCallStackEntry telServiceCallStackEntry = this.phoneService.getLastDialedNumber();
        if (telServiceCallStackEntry == null) {
            this.logger.log(-1601830656, "PhoneListShowCommand#getLastDialed -> last dialed number is null");
            this.sendResult(30001);
            return;
        }
        this.fillNumScreen(telServiceCallStackEntry.getNumber(), telServiceCallStackEntry.getName(), 0);
        SDSModelAccess.setADBSelectedNumberTypeModel(ADBSDSUtils$TelNumberTypeToModelValueMapping.getModelValueForTelNumberType(telServiceCallStackEntry.getPhoneType()));
        this.sendResult(30000);
    }

    private void fillNumScreen(String string, String string2, int n) {
        this.logger.log(-2137614336, "PhoneListShowCommand#fillNumScreen: index=%3, name=%1, title=%2!", (Object)string2, (Object)string, (long)n);
        SDSModelAccess.setPhoneCompleteNumberModel(string);
        this.phoneService.setNumberSpeller(string);
        SDSModelAccess.setTelSDSNumLabel(string2);
        SDSModelAccess.setADBEntryNameModel(string2);
        SDSModelAccess.setPhoneNumScreenTitle(n);
        this.popupHelper.triggerHapticalPopup(74, true);
    }

    private boolean triggerPicklist() {
        this.logger.log(-2137614336, "%1#triggerPicklist: called", (Object)this.getName());
        this.nBestStorage.resetPicklistsWithHistory();
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        if (SDSUtils.isEmpty(iPicklist)) {
            return false;
        }
        this.logger.log(-2137614336, "%1#triggerPicklist: picklist=%2!", (Object)this.getName(), (Object)iPicklist.toString());
        SDSListEntry[] sDSListEntryArray = SDSUtils.createSDSListFromPicklist(iPicklist);
        int n = 4;
        switch (this.listMode) {
            case 0: {
                ArrayList arrayList = new ArrayList();
                if (this.phoneHandler.getAdbToCallStackMapping() != null) {
                    for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
                        if (!this.phoneHandler.getAdbToCallStackMapping().containsKey(new Long(sDSListEntryArray[i2].getId()))) continue;
                        arrayList.add(this.phoneHandler.getAdbToCallStackMapping().get(new Long(sDSListEntryArray[i2].getId())));
                    }
                    sDSListEntryArray = (SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]);
                } else {
                    this.logger.log(-1601830656, "%1#triggerPicklist: available call stack entries=NULL, using original picklist entries", (Object)this.getName());
                }
                n = this.phoneService.fillCallstackPickList(sDSListEntryArray);
                break;
            }
            case 3: {
                n = this.phoneService.fillFavoritePickList(sDSListEntryArray);
                break;
            }
        }
        this.logger.log(-2137614336, "%1#triggerPicklist: response=%2", (Object)this.getName(), (long)n);
        return n == 0;
    }
}

