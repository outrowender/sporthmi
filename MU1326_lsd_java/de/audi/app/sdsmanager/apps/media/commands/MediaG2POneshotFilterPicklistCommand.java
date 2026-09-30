/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class MediaG2POneshotFilterPicklistCommand
extends AbstractSystemCallCommand {
    private final int slot;
    private static final int MEDIA_G2P_ARTIST_SLOT = 0;
    private static final int MEDIA_G2P_ALBUM_SLOT = 1;
    private static final int MEDIA_G2P_TITLE_SLOT = 2;
    private final int[][] mediaG2PSlotToListMode = new int[][]{{0, 5}, {1, 7}, {2, 6}};
    private OneshotHandler oneshotHandler;

    public MediaG2POneshotFilterPicklistCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.slot = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.oneshotHandler = mediaSDSHandler.getOneshotHandler();
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: slot=%2", (Object)this.getName(), (long)this.slot);
        if (this.slot < 0 || this.slot > 2) {
            this.logger.log(10000000, "%1#execute", (Object)this.getName());
            this.sendResult(20001);
            return;
        }
        if (this.oneshotHandler == null) {
            this.logger.log(10000000, "%1#execute oneshot handler is null!", (Object)this.getName());
            this.sendResult(20001);
            return;
        }
        byte by = this.oneshotHandler.filterPicklist(SDSUtils.translate(this.slot, this.mediaG2PSlotToListMode));
        this.handleAnswer(by);
    }

    protected void handleAnswer(int n) {
        if (n == -1) {
            this.logger.log(100000, "%1#execute: Filtered picklist length error %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(20001);
        } else {
            this.sendResult(20000);
        }
    }
}

