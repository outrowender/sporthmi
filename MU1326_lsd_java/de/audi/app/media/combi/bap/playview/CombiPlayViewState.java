/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class CombiPlayViewState {
    private static final String LOGCLASS = "CombiPlayViewState";
    private static final int INVALID = -1;
    private final LogChannel logger;
    private volatile int absolutePositionCurrentTrack = -1;
    private volatile MediaDetailInfo currentDetailInfo;
    private volatile ResourceLocator currentCoverart;
    private volatile boolean coverUpdateBlocked;
    private volatile Capabilities currentCapabilites;

    public CombiPlayViewState(LogChannel logChannel) {
        this.logger = logChannel;
        this.resetValues();
    }

    public void reset() {
        this.resetValues();
    }

    private void resetValues() {
        this.logger.log(10000000, "[%1.resetValues]", (Object)LOGCLASS);
        this.absolutePositionCurrentTrack = -1;
        this.currentDetailInfo = null;
        this.currentCoverart = null;
        this.coverUpdateBlocked = false;
        this.currentCapabilites = null;
    }

    public int getAbsolutePositionCurrentTrack() {
        return this.absolutePositionCurrentTrack;
    }

    protected boolean setAbsolutePositionCurrentTrack(int n) {
        this.logger.log(10000000, "[%1.setAbsolutePositionCurrentTrack] '%2'", (Object)LOGCLASS, (long)n);
        boolean bl = this.absolutePositionCurrentTrack != n;
        this.absolutePositionCurrentTrack = n < 0 ? 0 : n;
        return bl;
    }

    public MediaDetailInfo getCurrentDetailInfo() {
        return this.currentDetailInfo;
    }

    public void setCurrentDetailInfo(MediaDetailInfo mediaDetailInfo) {
        this.currentDetailInfo = mediaDetailInfo;
    }

    public ResourceLocator getCurrentCoverart() {
        return this.currentCoverart;
    }

    public void setCurrentCoverart(ResourceLocator resourceLocator) {
        this.currentCoverart = resourceLocator;
    }

    public void setCoverUpdateBlocked(boolean bl) {
        this.logger.log(10000000, "[%1.setCoverUpdateBlocked] '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.coverUpdateBlocked = bl;
    }

    public boolean isCoverUpdateBlocked() {
        return this.coverUpdateBlocked;
    }

    public void setCurrentCapabilites(Capabilities capabilities) {
        this.currentCapabilites = capabilities;
    }

    public boolean isPlayViewSupported() {
        return this.currentCapabilites != null && this.currentCapabilites.isPlayView();
    }
}

