/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.seek;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.seek.SeekHandler$ButtonListener;

public class SeekHandler {
    private final DSIHandler dsi;
    private final LogChannel logChannel;

    public SeekHandler(TVEnv tVEnv, DSIHandler dSIHandler, LogChannel logChannel) {
        this.dsi = dSIHandler;
        this.logChannel = logChannel;
        SeekHandler$ButtonListener seekHandler$ButtonListener = new SeekHandler$ButtonListener(this, null);
        tVEnv.getButtonModel(-1364449536).setButtonListener(seekHandler$ButtonListener);
        tVEnv.getButtonModel(-1347672320).setButtonListener(seekHandler$ButtonListener);
    }

    public void abortSeek() {
        this.logChannel.log(-2137614336, "[SeekHandler.abortSeek] seek abortion requested.");
        this.dsi.abortSeek();
    }

    static /* synthetic */ LogChannel access$100(SeekHandler seekHandler) {
        return seekHandler.logChannel;
    }

    static /* synthetic */ DSIHandler access$200(SeekHandler seekHandler) {
        return seekHandler.dsi;
    }
}

