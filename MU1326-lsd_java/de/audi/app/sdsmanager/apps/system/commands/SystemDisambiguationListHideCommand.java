/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemDisambiguationListHideCommand
extends AbstractSystemCallCommand {
    private ISDSPopupHelper sdsPopupHelper;
    private int listMode;

    public SystemDisambiguationListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listmode=%2", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 0: {
                this.sdsPopupHelper.triggerHapticalPopup(101, false);
                break;
            }
            case 1: {
                this.sdsPopupHelper.triggerHapticalPopup(113, false);
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: unhandled listmode!", (Object)this.getName());
            }
        }
        this.processingFinished();
    }
}

