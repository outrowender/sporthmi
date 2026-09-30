/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class NaviSpellingModeCommand
extends AbstractSystemCallCommand {
    private final boolean isSpellingRecog;

    public NaviSpellingModeCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.isSpellingRecog = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] Setting spelling to %2!", (Object)this.getName(), (Object)this.isSpellingRecog);
        SDSModelAccess.setNavSpellingModel(this.isSpellingRecog);
        this.processingFinished();
    }
}

