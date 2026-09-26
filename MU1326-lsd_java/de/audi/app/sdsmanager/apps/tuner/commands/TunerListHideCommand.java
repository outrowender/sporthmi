/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class TunerListHideCommand
extends AbstractSystemCallCommand {
    private final int listMode;
    private final ISDSPopupHelper popupHelper;

    public TunerListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.popupHelper = iSDSPopupHelper;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        int n = SDSUtils.translate(this.listMode, TunerSDSUtils.TUNER_LIST_MODE_TO_POPUP_MAPPING_ID);
        if (n == 128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled listMode %2!", (Object)this.getName(), (long)this.listMode);
            this.processingFinished();
            return;
        }
        this.popupHelper.triggerHapticalPopup(n, false);
        this.processingFinished();
    }
}

