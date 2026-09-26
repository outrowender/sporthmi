/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tone.app.volume.NaviVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;

public class LoweredEntertainmentNaviRange
extends NaviVolumeRange {
    LoweredEntertainmentNaviRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1430392576);
    }

    @Override
    protected String getName() {
        return "LoweredEntertainmentNaviRange";
    }

    @Override
    protected int getID() {
        return -1;
    }

    @Override
    protected void init() {
        this.env.lcMain.log(-2137614336, "LoweredEntertainmentNaviRange.init()");
        int n = this.audioService.getActiveEntertainmentConnection(0);
        if (n != 0) {
            this.dsiSound.getVolume(0, n);
        }
    }

    @Override
    protected int getLimitsConnection() {
        return 0;
    }

    @Override
    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    @Override
    public void increase(int n, int n2) {
        this.env.lcMain.log(-2137614336, "[LoweredEntertainmentNaviRange.increase] steps:%1 HT:%2", (long)n2, (long)n);
        this.dsiSound.changeLoweringEntertainment(0, n2, n);
    }

    @Override
    public void decrease(int n, int n2) {
        this.env.lcMain.log(-2137614336, "[LoweredEntertainmentNaviRange.decrease] steps:%1 HT:%2", (long)n2, (long)n);
        this.dsiSound.changeLoweringEntertainment(0, -n2, n);
    }

    @Override
    protected void setMedialPosition(int n) {
        this.env.lcDSI.log(-2137614336, "LoweredEntertainmentNaviRange.setMedialPosition(%1)", (long)n);
        this.model.setLimits(this.model.getMinimum(), this.model.getMaximum(), 1, n);
    }

    @Override
    protected void limitVolumeToHmiLimits() {
    }
}

