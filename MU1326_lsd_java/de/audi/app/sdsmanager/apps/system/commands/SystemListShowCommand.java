/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenConnectedUpdatable;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemListShowCommand
extends AbstractSystemCallCommand
implements ISDSScreenConnectedUpdatable {
    private final ISDSPopupHelper popupHelper;
    private final ISystemVBIHandler systemVBIHandler;
    private final int listMode;

    public SystemListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, ISDSPopupHelper iSDSPopupHelper, ISystemVBIHandler iSystemVBIHandler) {
        super(logChannel, string, sDSHandlerService);
        this.popupHelper = iSDSPopupHelper;
        this.systemVBIHandler = iSystemVBIHandler;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        int n = this.popupHelper.getHelpScreenPopupMapping(this.listMode);
        if (n == -1) {
            this.logger.log(-1601830656, "%1#execute: Unhandled listMode %2!", (Object)this.getName(), (long)this.listMode);
            this.sendResult(3001);
        }
        this.popupHelper.removeFurtherCommandDisplay();
        SDSModelAccess.setCommandType(3);
        this.systemVBIHandler.sendTTSFinishAtPromptEnd(true);
        if (n == this.popupHelper.getCurrentHelpScreenPopupMappingID()) {
            this.logger.log(-2137614336, "%1#execute: help popup %2 already visible -> sending OK!", (Object)this.getName(), (long)n);
            this.sendResult(3000);
            return;
        }
        this.popupHelper.setCurrentHelpScreenPopupMappingID(n);
        this.popupHelper.triggerHapticalPopup(n, true);
    }

    @Override
    public void updateSDSScreenConnected(int n) {
        this.logger.log(-2137614336, "%1#updateSDSScreenConnected: screenID=%2", (Object)this.getName(), (long)n);
        SDSModelAccess.setSmallCommandDisplayVisible(1);
        this.sendResult(3000);
    }
}

