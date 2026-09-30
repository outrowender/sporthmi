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
        super(logChannel, 100000, "DSITVTuner");
    }

    public void selectService(long l, int n, int n2) {
        this.log("selectService");
    }

    public void selectNextService(int n, int n2) {
        this.log("selectNextService");
    }

    public void switchSource(int n) {
        this.log("switchSource");
    }

    public void setAudioChannel(int n) {
        this.log("setAudioChannel");
    }

    public void setNormArea(int n) {
        this.log("setNormArea");
    }

    public void enableServiceLinking(boolean bl) {
        this.log("enableServiceLinking");
    }

    public void setTerminalMode(int n, int n2) {
        this.log("setTerminalMode");
    }

    public void setNormAreaSubList(int[] nArray) {
        this.log("setNormAreaSubList");
    }

    public void setAVNorm(int n) {
        this.log("setAVNorm");
    }

    public void incMoved(byte by) {
        this.log("incMoved");
    }

    public void setCoordinateRel(short s, short s2, short s3) {
        this.log("setCoordinateRel");
    }

    public void setTMTVKeyPanel(short s, short s2) {
        this.log("setTMTVKeyPanel");
    }

    public void enableSubtitle(boolean bl) {
        this.log("enableSubtitle");
    }

    public void abortSeek() {
        this.log("abortSeek");
    }

    public void setBrowserListSort(int n) {
        this.log("setBrowserListSort");
    }
}

