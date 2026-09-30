/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaPlayAllTracksCommand
extends AbstractSystemCallCommand {
    private IMediaSDSService mediaSDSService;

    public MediaPlayAllTracksCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMediaSDSService iMediaSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.mediaSDSService = iMediaSDSService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] start", (Object)this.getName());
        this.mediaSDSService.playAllTracks();
    }

    public void playAllTracksResult(byte by) {
        this.logger.log(10000000, "[%1#playAllTracksResult] successful=%2", (Object)this.getName(), (long)by);
        int n = by == 0 ? 20000 : 20001;
        this.sendResult(n);
    }
}

