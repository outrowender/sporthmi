/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tone.app.volume.NaviVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;

public class LoweredEntertainmentNaviRange
extends NaviVolumeRange {
    LoweredEntertainmentNaviRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000021);
    }

    protected String getName() {
        return "LoweredEntertainmentNaviRange";
    }

    protected int getID() {
        return -1;
    }

    protected void init() {
        this.env.lcMain.log(10000000, "LoweredEntertainmentNaviRange.init()");
        int n = this.audioService.getActiveEntertainmentConnection(0);
        if (n != 0) {
            this.dsiSound.getVolume(0, n);
        }
    }

    protected int getLimitsConnection() {
        return 0;
    }

    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    public void increase(int n, int n2) {
        this.env.lcMain.log(10000000, "[LoweredEntertainmentNaviRange.increase] steps:%1 HT:%2", (long)n2, (long)n);
        this.dsiSound.changeLoweringEntertainment(0, n2, n);
    }

    public void decrease(int n, int n2) {
        this.env.lcMain.log(10000000, "[LoweredEntertainmentNaviRange.decrease] steps:%1 HT:%2", (long)n2, (long)n);
        this.dsiSound.changeLoweringEntertainment(0, -n2, n);
    }

    protected void setMedialPosition(int n) {
        this.env.lcDSI.log(10000000, "LoweredEntertainmentNaviRange.setMedialPosition(%1)", (long)n);
        this.model.setLimits(this.model.getMinimum(), this.model.getMaximum(), 1, n);
    }

    protected void limitVolumeToHmiLimits() {
    }
}

