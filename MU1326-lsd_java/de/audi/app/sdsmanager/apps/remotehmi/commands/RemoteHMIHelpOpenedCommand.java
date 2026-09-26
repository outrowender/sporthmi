/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;

public class RemoteHMIHelpOpenedCommand
extends AbstractSystemCallCommand {
    private static final byte ONLINE_HELP_TYPE_TOPICS;
    private static final byte ONLINE_HELP_TYPE_SUBTOPIC;
    private final OnlineService onlineService;
    private final byte helpType;

    public RemoteHMIHelpOpenedCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, OnlineService onlineService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.onlineService = onlineService;
        this.helpType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: helpType=%2", (Object)this.getName(), (long)this.helpType);
        int n = 0;
        switch (this.helpType) {
            case 1: {
                n = 2;
                break;
            }
            case 0: {
                n = 1;
                break;
            }
            default: {
                this.logger.log(-1601830656, "RemoteHMIHelpOpenedCommand#execute: Unhandled helpType %1!", (long)this.helpType);
            }
        }
        this.logger.log(-2137614336, "RemoteHMIHelpOpenedCommand#execute: helpTypeOnline=%1", (long)n);
        this.onlineService.helpOpened(n);
        this.sendResult(3000);
    }
}

