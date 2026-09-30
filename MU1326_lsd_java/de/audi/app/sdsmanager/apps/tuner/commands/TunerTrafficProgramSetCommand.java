/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerTrafficProgramSetCommand
extends AbstractSystemCallCommand {
    private final boolean tpSettingMode;
    private final TunerService tunerService;

    public TunerTrafficProgramSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, TunerService tunerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.tunerService = tunerService;
        this.tpSettingMode = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: tpSettingMode=%2", (Object)this.getName(), (Object)this.tpSettingMode);
        byte by = this.tunerService.switchTrafficAnnouncements(this.tpSettingMode);
        this.logger.log(10000000, "%1#execute: trafficSetReply=%2!", (Object)this.getName(), (long)by);
        this.sendResult(by == 0 ? 10005 : 10008);
    }
}

