/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class PhoneListEntrySelectCommand
extends AbstractSystemCallCommand {
    private final int mode;
    private final NBestStorageAccess nBest;
    private final PhoneSDSHandler phoneHandler;

    public PhoneListEntrySelectCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, PhoneSDSHandler phoneSDSHandler, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.phoneHandler = phoneSDSHandler;
        this.mode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.nBest = nBestStorageAccess;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: mode=%2", (Object)this.getName(), (long)this.mode);
        boolean bl = false;
        switch (this.mode) {
            case 7: {
                this.sdsHandlerService.setSelectedRow(-1);
                SDSModelAccess.setSlotModel(1, "1");
                SDSModelAccess.setEnumerationNumberStatus(0);
                SDSModelAccess.setEnumerationNumberValue(1);
                SDSModelAccess.setADBEntryNameModel("");
                SDSModelAccess.setTelSDSNumLabel("");
                bl = true;
                break;
            }
            case 8: {
                this.sdsHandlerService.setSelectedRow(0);
                SDSModelAccess.setSlotModel(1, "2");
                SDSModelAccess.setEnumerationNumberStatus(1);
                SDSModelAccess.setEnumerationNumberValue(2);
                this.setPromptAndTextLabel();
                bl = true;
                break;
            }
            default: {
                bl = this.setSelectedEntryFromPicklist();
            }
        }
        this.sendResult(bl ? 30000 : 30001);
    }

    private void setPromptAndTextLabel() {
        int n = this.phoneHandler.getFavoritesLength();
        String string = "";
        string = n == 1 ? this.phoneHandler.getFavoriteName(0) : this.phoneHandler.getCallStackName(0);
        SDSModelAccess.setADBEntryNameModel(string);
        SDSModelAccess.setTelSDSNumLabel(string);
    }

    private boolean setSelectedEntryFromPicklist() {
        this.logger.log(-2137614336, "%1#setSelectedEntryFromPicklist: called", (Object)this.getName());
        long l = SDSUtils.getSelectedObjectId(this.nBest, this.logger, 0);
        this.logger.log(-2137614336, "%1#setSelectedEntryFromPicklist: id=%2!", (Object)this.getName(), l);
        int n = -1;
        String string = "";
        switch (this.mode) {
            case 0: {
                n = this.phoneHandler.getCallStackIndexByADBId(l);
                string = this.phoneHandler.getCallStackName(n);
                break;
            }
            case 3: {
                n = this.phoneHandler.getFavoriteIndexById(l);
                string = this.phoneHandler.getFavoriteName(n);
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#setSelectedEntryFromPicklist: Unhandled mode=%2", (Object)this.getName(), (long)this.mode);
                return false;
            }
        }
        this.logger.log(-2137614336, "%1#setSelectedEntryFromPicklist: index=%3, entryName=%2!", (Object)this.getName(), (Object)string, (long)n);
        if (n == -1) {
            this.logger.log(-1601830656, "%1#setSelectedEntryFromPicklist: No valid index found!", (Object)this.getName());
            return false;
        }
        SDSModelAccess.setADBEntryNameModel(string);
        this.sdsHandlerService.setSelectedRow(n);
        return true;
    }
}

