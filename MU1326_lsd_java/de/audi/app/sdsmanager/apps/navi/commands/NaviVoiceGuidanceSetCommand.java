/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviVoiceGuidanceSetCommand
extends AbstractSystemCallCommand {
    private static final byte VOICE_GUIDANCE_COMPLETE = 0;
    private static final byte VOICE_GUIDANCE_OFF = 1;
    private static final byte VOICE_GUIDANCE_SHORT = 2;
    private static final byte VOICE_GUIDANCE_TRAFFIC = 3;
    private final byte guidanceType;
    private final NaviService service;
    private static byte[][] guidanceTypeToGuidanceMode = new byte[][]{{0, 1}, {1, 3}, {2, 0}, {3, 2}};

    public NaviVoiceGuidanceSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.guidanceType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.service = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: guidanceType=%2", (Object)this.getName(), (long)this.guidanceType);
        byte by = SDSUtils.translate(this.guidanceType, guidanceTypeToGuidanceMode);
        if (by == -128) {
            this.logger.log(10000000, "%1#execute: Unhandled guidanceType %2, assuming COMPLETE!");
            by = 1;
        }
        this.logger.log(10000000, "%1#execute: guidanceMode=%2", (Object)this.getName(), (long)by);
        this.service.setGuidanceMode(by);
        this.sendResult(3000);
    }
}

