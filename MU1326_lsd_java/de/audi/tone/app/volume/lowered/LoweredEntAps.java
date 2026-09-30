/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.lowered;

import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.lowered.AbstractLoweredEnt;
import de.audi.tone.app.volume.samples.ApsSamplePlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class LoweredEntAps
extends AbstractLoweredEnt {
    private final ISamplePlayer sampleplayer;
    private static final int CONNECTION = 94;
    private static final String LOGCLASS = "LoweredEntAps";

    public LoweredEntAps(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, LOGCLASS, 94, 4049);
        this.sampleplayer = new ApsSamplePlayer(volumeRangeManager.getEnv().lcMain);
    }

    public int getLoweringType() {
        return 1;
    }

    int getModelID() {
        return 4049;
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.sampleplayer;
    }

    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        this.audioService.requestConnection(0, this.getForegroundConnection());
    }

    protected void releaseMenuConnection() {
        this.audible(false);
        this.audioService.releaseConnection(0, this.getForegroundConnection());
    }

    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    protected String getName() {
        return LOGCLASS;
    }

    protected int getID() {
        return 5;
    }

    void opened() {
        this.env.lcMain.log(10000000, "[LoweredEntAps.opened]");
        this.volMenuManager.entered(this.getID(), 0);
    }
}

