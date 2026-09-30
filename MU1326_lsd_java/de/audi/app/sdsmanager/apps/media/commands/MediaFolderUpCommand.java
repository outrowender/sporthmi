/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaFolderUpCommand
extends AbstractSystemCallCommand {
    private final IMediaSDSService mediaSDSService;
    private final int[][] results = new int[][]{{0, 20000}, {3, 20011}, {4, 20011}};

    public MediaFolderUpCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMediaSDSService iMediaSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.mediaSDSService = iMediaSDSService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.mediaSDSService.folderUp();
    }

    public void sendFolderUpReply(int n) {
        this.logger.log(10000000, "%1#sendFolderUpReply folderUpReply=%2!", (Object)this.getName(), (long)n);
        int n2 = SDSUtils.translate(n, this.results);
        this.sendResult(n2 == Integer.MIN_VALUE ? 20001 : n2);
    }
}

