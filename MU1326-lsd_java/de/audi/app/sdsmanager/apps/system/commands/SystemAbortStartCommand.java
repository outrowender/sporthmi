/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;

public class SystemAbortStartCommand
extends AbstractSystemCallCommand {
    private final AppSDSManager sdsManager;

    public SystemAbortStartCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, AppSDSManager appSDSManager) {
        super(logChannel, string, sDSHandlerService);
        this.sdsManager = appSDSManager;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: Setting flag for SDS aborting!", (Object)this.getName());
        this.sdsManager.setSDSAborting(true);
        SDSUtils.updateSDSNumbers(false);
        this.sendResult(3000);
    }

    @Override
    public boolean isSDSEndSequenceCommand() {
        return true;
    }
}

