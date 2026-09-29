/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.core.boardbook.BoardbookHandler;
import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.FunctionalLink;
import de.audi.atip.log.LogChannel;

public class BoardbookEfiUrlHandler
implements EfiUrlHandler {
    private static final String REPLACE_BBROOT;
    private static final String REPLACE_BBROOT_VALUE;
    private final LogChannel logChannel;
    private final BoardbookHandler handler;

    public BoardbookEfiUrlHandler(LogChannel logChannel, BoardbookHandler boardbookHandler) {
        this.logChannel = logChannel;
        this.handler = boardbookHandler;
    }

    @Override
    public void updateActiveUrl(String string) {
    }

    @Override
    public byte updateEfiUrl(String string) {
        String string2 = string;
        FunctionalLink functionalLink = new FunctionalLink(this.logChannel, string2);
        String string3 = functionalLink.getCommand();
        this.logChannel.log(1078071040, "BoardbookEfiUrlHandler#updateEfiUrl %1, command %2", (Object)string2, (Object)string3);
        byte by = -1;
        if (string3.equals("play_video")) {
            this.logChannel.log(1078071040, "BoardbookEfiUrlHandler#updateEfiUrl playing video", (Object)string2, (Object)string3);
            String string4 = functionalLink.getValue("desc");
            String string5 = functionalLink.getValue("file");
            this.handler.handleVideo(string5, string4);
            by = 1;
        }
        return by;
    }

    @Override
    public void gotoHomeURL() {
    }

    @Override
    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    @Override
    public boolean goForward() {
        return false;
    }

    @Override
    public boolean goBack() {
        return false;
    }
}

