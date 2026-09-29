/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.IPlayer;

public class HardKeyHandlerFilePlayer
extends HardKeyHandler {
    private static final String LOGCLASS;

    public HardKeyHandlerFilePlayer(IMediaTerminal iMediaTerminal, IPlayer iPlayer) {
        super(iMediaTerminal, iPlayer);
    }

    @Override
    protected void mediaSkipPrevPressed() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipPrevPressed] HK_PREV", (Object)"HardKeyHandlerFilePlayer");
        this.seekingBwdTimer.restart();
    }

    @Override
    protected void mediaSkipNextPressed() {
        this.logger.hmi().log(1078071040, "[%1.mediaSkipNextPressed] HK_NEXT", (Object)"HardKeyHandlerFilePlayer");
        this.seekingFwdTimer.restart();
    }
}

