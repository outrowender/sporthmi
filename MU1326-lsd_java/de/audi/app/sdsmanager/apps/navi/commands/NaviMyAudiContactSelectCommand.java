/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviMyAudiContactSelectCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private final IOnlineSDSMyAudiService onlineService;
    private final NBestStorageAccess nBestStorage;
    private final byte source;

    public NaviMyAudiContactSelectCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandler naviSDSHandler, IOnlineSDSMyAudiService iOnlineSDSMyAudiService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.onlineService = iOnlineSDSMyAudiService;
        this.nBestStorage = nBestStorageAccess;
        this.source = (byte)Math.max(SDSUtils.retrieveInteger(iSystemCallParameterArray, 0), 0);
    }

    @Override
    public void execute() {
        SDSListEntry sDSListEntry;
        this.logger.log(-2137614336, "[%1#execute] source=%2", (Object)this.getName(), (long)this.source);
        switch (this.source) {
            case 2: 
            case 3: {
                this.selectAddressOfContact();
                return;
            }
            case 0: {
                sDSListEntry = this.selectFromNBest();
                break;
            }
            case 1: {
                sDSListEntry = this.selectFromLine();
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#execute] Unhandled source %2!", (Object)this.getName(), (long)this.source);
                this.sendResult(1100742656);
                return;
            }
        }
        if (sDSListEntry == null) {
            this.logger.log(-1601830656, "[%1#execute] selected contact is null!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        AdbEntry adbEntry = this.selectEntry(sDSListEntry.getId(), sDSListEntry.getName());
        if (adbEntry == null) {
            this.logger.log(-1601830656, "[%1#execute] selected entry is null!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        this.sdsHandler.storeMyAudiContact(adbEntry);
        this.sendSpecficResult(adbEntry);
    }

    private void selectAddressOfContact() {
        int n = this.source == 2 ? 1 : 0;
        this.logger.log(-2137614336, "[%1#selectAddressOfContact], navLocationIndex=%2", (Object)this.getName(), (long)n);
        this.sdsHandlerService.setSelectedRow(n);
        AdbEntry adbEntry = this.sdsHandler.getCurrentMyAudiContact();
        Object[] objectArray = adbEntry.getAddressData();
        if (SDSUtils.isEmpty(objectArray) || objectArray.length < n - 1 || objectArray[n] == null) {
            this.sendResult(1234960384);
            return;
        }
        this.sendResult(1083965440);
    }

    private void sendSpecficResult(AdbEntry adbEntry) {
        this.logger.log(-2137614336, "[%1#sendSpecficResult]", (Object)this.getName());
        Object[] objectArray = adbEntry.getAddressData();
        if (SDSUtils.isEmpty(objectArray)) {
            this.sendResult(1234960384);
            return;
        }
        if (objectArray.length == 1) {
            this.sdsHandlerService.setSelectedRow(0);
            this.sendResult(1083965440);
            return;
        }
        this.sendResult(1251737600);
    }

    private SDSListEntry selectFromLine() {
        this.logger.log(-2137614336, "[%1#selectFromLine] called", (Object)this.getName());
        int n = SDSModelAccess.getEnumerationNumberStatus();
        this.logger.log(-2137614336, "[%1#selectFromLine] index of selected contact=%2", (Object)this.getName(), (long)n);
        return this.sdsHandler.getMyAudiContactByIndex(n);
    }

    private SDSListEntry selectFromNBest() {
        this.logger.log(-2137614336, "[%1#selectFromNBest] called", (Object)this.getName());
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(this.nBestStorage, this.logger, 0);
        if (iPicklistSlot == null) {
            return null;
        }
        long l = iPicklistSlot.getObjID();
        String string = iPicklistSlot.getText();
        this.logger.log(-2137614336, "[%1#selectFromNBest] selected contact=%2 (%3)", (Object)this.getName(), (Object)string, l);
        return this.sdsHandler.getMyAudiContactById(l);
    }

    private AdbEntry selectEntry(long l, String string) {
        try {
            this.logger.log(-2137614336, "[%1#selectEntry] called", (Object)this.getName());
            SDSModelAccess.setListLineDataGetModel(string);
            SDSModelAccess.setADBEntryNameModel(string);
            SDSModelAccess.setTelSDSNumLabel(string);
            return this.onlineService.selectContactById(l);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1#selectEntry Exception (%2): STACKTRACE:", (Object)this.getName(), (Object)exception.getMessage());
            StackTraceElement[] stackTraceElementArray = exception.getStackTrace();
            for (int i2 = 0; i2 < stackTraceElementArray.length; ++i2) {
                this.logger.log(10000, new StringBuffer().append("  ").append(stackTraceElementArray[i2].toString()).toString());
            }
            return null;
        }
    }
}

