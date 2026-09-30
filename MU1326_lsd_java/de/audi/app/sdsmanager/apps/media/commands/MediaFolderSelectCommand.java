/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaFolderSelectCommand
extends AbstractSystemCallCommand {
    private static final byte[][] FOLDER_TYPES_TO_BROWSE_TYPES = new byte[][]{{0, 4}, {1, 2}, {2, 3}, {3, 10}, {4, 6}, {5, 5}, {12, 8}, {13, 9}, {14, 7}, {18, 11}};
    private final IMediaSDSService mediaSDSService;
    private final byte folderType;

    public MediaFolderSelectCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMediaSDSService iMediaSDSService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.mediaSDSService = iMediaSDSService;
        this.folderType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] folderType=%2!", (Object)this.getName(), (long)this.folderType);
        if (this.folderType == 17) {
            this.mediaSDSService.playMoreLikeThis();
        } else {
            byte by = SDSUtils.translate(this.folderType, FOLDER_TYPES_TO_BROWSE_TYPES);
            this.logger.log(10000000, "[%1#execute] folderType=%2, browseTypeID=%3!", (Object)this.getName(), (long)this.folderType, (long)by);
            if (by == -128) {
                this.logger.log(100000, "[%1#execute] Unexpected folderType %2, sending ERROR!", (Object)this.getName(), (long)this.folderType);
                this.sendResult(20001);
                return;
            }
            this.mediaSDSService.startBrowsing(by);
        }
    }

    public void sendStartBrowsingReply(int n) {
        this.logger.log(10000000, "[%1#sendStartBrowsingReply] folderType=%2, state=%3!", (Object)this.getName(), (long)this.folderType, (long)n);
        int n2 = 20001;
        if (n == 0) {
            n2 = 20000;
        }
        this.sendResult(n2);
    }

    public void sendPlayMoreLikeThisReply(int n) {
        this.logger.log(10000000, "[%1#sendPlayMoreLikeThisReply] folderType=%2, state=%3!", (Object)this.getName(), (long)this.folderType, (long)n);
        this.sendResult(this.getPlayMoreLikeThisResultCode(n));
    }

    protected int getPlayMoreLikeThisResultCode(int n) {
        if (n == 0) {
            return 20000;
        }
        return 20001;
    }
}

