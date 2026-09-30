/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.IMediaPlayModeStrategy;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaPlaymodeSetCommand
extends AbstractSystemCallCommand {
    private final int mediaPlaymode;
    private final IMediaSDSService mediaSDSService;
    private final IMediaPlayModeStrategy mediaPlayModeStrategy;

    public MediaPlaymodeSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IMediaSDSService iMediaSDSService, IMediaPlayModeStrategy iMediaPlayModeStrategy) {
        super(logChannel, string, sDSHandlerService);
        this.mediaPlaymode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.mediaSDSService = iMediaSDSService;
        this.mediaPlayModeStrategy = iMediaPlayModeStrategy;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: mediaPlaymode=%2", (Object)this.getName(), (long)this.mediaPlaymode);
        if (!this.mediaPlayModeStrategy.executePlayMode(this.mediaPlaymode, this.mediaSDSService)) {
            this.logger.log(100000, "%1#execute: Unhandled mediaPlaymode %2!", (Object)this.getName(), (long)this.mediaPlaymode);
            this.sendResult(20001);
            return;
        }
    }

    public void sendPlaymodeReply(int n) {
        this.logger.log(10000000, "%1#sendPlaymodeReply: playmodeReply=%2!", (Object)this.getName(), (long)n);
        int n2 = 20001;
        switch (n) {
            case 0: 
            case 2: 
            case 4: {
                n2 = 20000;
                break;
            }
            default: {
                this.logger.log(100000, "%1#sendPlaymodeReply: Unhandled state %2!", (Object)this.getName(), (long)n);
            }
        }
        this.sendResult(n2);
    }
}

