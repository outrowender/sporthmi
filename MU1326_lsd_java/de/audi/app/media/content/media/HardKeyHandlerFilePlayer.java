/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.IPlayer;

public class HardKeyHandlerFilePlayer
extends HardKeyHandler {
    private static final String LOGCLASS = "HardKeyHandlerFilePlayer";

    public HardKeyHandlerFilePlayer(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal, iPlayer);
    }

    protected void mediaSkipPrevPressed() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipPrevPressed] HK_PREV", (Object)LOGCLASS);
        this.seekingBwdTimer.restart();
    }

    protected void mediaSkipNextPressed() {
        this.logger.hmi().log(1000000, "[%1.mediaSkipNextPressed] HK_NEXT", (Object)LOGCLASS);
        this.seekingFwdTimer.restart();
    }
}

