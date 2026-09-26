/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.tvtuner.DSITVTuner;

public class NullDSITVTuner
extends NullDSIBase
implements DSITVTuner {
    public NullDSITVTuner(LogChannel logChannel) {
        super(logChannel, -1601830656, "DSITVTuner");
    }

    @Override
    public void selectService(long l, int n, int n2) {
        this.log("selectService");
    }

    @Override
    public void selectNextService(int n, int n2) {
        this.log("selectNextService");
    }

    @Override
    public void switchSource(int n) {
        this.log("switchSource");
    }

    @Override
    public void setAudioChannel(int n) {
        this.log("setAudioChannel");
    }

    @Override
    public void setNormArea(int n) {
        this.log("setNormArea");
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        this.log("enableServiceLinking");
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        this.log("setTerminalMode");
    }

    @Override
    public void setNormAreaSubList(int[] nArray) {
        this.log("setNormAreaSubList");
    }

    @Override
    public void setAVNorm(int n) {
        this.log("setAVNorm");
    }

    @Override
    public void incMoved(byte by) {
        this.log("incMoved");
    }

    @Override
    public void setCoordinateRel(short s, short s2, short s3) {
        this.log("setCoordinateRel");
    }

    @Override
    public void setTMTVKeyPanel(short s, short s2) {
        this.log("setTMTVKeyPanel");
    }

    @Override
    public void enableSubtitle(boolean bl) {
        this.log("enableSubtitle");
    }

    @Override
    public void abortSeek() {
        this.log("abortSeek");
    }

    @Override
    public void setBrowserListSort(int n) {
        this.log("setBrowserListSort");
    }
}

