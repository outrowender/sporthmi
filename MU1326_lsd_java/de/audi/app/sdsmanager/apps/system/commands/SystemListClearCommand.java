/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.atip.log.LogChannel;

public class SystemListClearCommand
extends AbstractSystemCallCommand {
    private final ISDSPopupHelper sdsPopupHelper;
    private AppSDSManager appSDSManager;

    public SystemListClearCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper, AppSDSManager appSDSManager) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
        this.appSDSManager = appSDSManager;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.sdsPopupHelper.removeSmallCommandDisplay();
        this.sdsPopupHelper.setCurrentBigCommandScreenPopupMapping(-1);
        this.sdsPopupHelper.removeAllBigCommandPopups();
        this.sdsPopupHelper.removeAllFurtherCommandPopups();
        this.sendResult(3000);
    }

    public boolean isSDSEndSequenceCommand() {
        return this.appSDSManager.isSDSAborting();
    }
}

