/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class PhoneListHideCommand
extends AbstractSystemCallCommand {
    private int listMode;
    private final ISDSPopupHelper popupHelper;
    private static final int LIST_MODE_SDS_PHONE_PICKLIST = 0;
    private static final int LIST_MODE_TEL_SDS_NUM = 1;

    public PhoneListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.popupHelper = iSDSPopupHelper;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called, listmode=%2", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 0: {
                this.popupHelper.triggerHapticalPopup(30, false);
                break;
            }
            case 1: {
                this.popupHelper.triggerHapticalPopup(74, false);
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: called, unhandled listmode=%2", (Object)this.getName(), (long)this.listMode);
            }
        }
        this.processingFinished();
    }
}

