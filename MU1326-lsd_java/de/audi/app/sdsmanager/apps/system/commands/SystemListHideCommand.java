/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemListHideCommand
extends AbstractSystemCallCommand {
    private final ISDSPopupHelper popupHelper;
    private final ISystemVBIHandler systemVBIHandler;
    private int listMode;

    public SystemListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, ISDSPopupHelper iSDSPopupHelper, ISystemVBIHandler iSystemVBIHandler) {
        super(logChannel, string, sDSHandlerService);
        this.popupHelper = iSDSPopupHelper;
        this.systemVBIHandler = iSystemVBIHandler;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        int n = this.popupHelper.getHelpScreenPopupMapping(this.listMode);
        this.logger.log(-2137614336, "%1#execute: popupMappingID=%1", (Object)this.getName(), (long)n);
        if (n == -1) {
            this.logger.log(-1601830656, "%1#execute: Unhandled listMode %2!", (Object)this.getName(), (long)this.listMode);
            this.processingFinished();
            return;
        }
        if (n == this.popupHelper.getCurrentHelpScreenPopupMappingID()) {
            if (SDSModelAccess.getCommandScreen() == 0) {
                SDSModelAccess.setSmallCommandDisplayVisible(0);
            }
            this.popupHelper.setCurrentHelpScreenPopupMappingID(-1);
            this.systemVBIHandler.sendTTSFinishAtPromptEnd(false);
        }
        this.popupHelper.triggerHapticalPopup(n, false);
        this.processingFinished();
    }
}

