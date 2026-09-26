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
    private static final int CONNECTION;
    private static final String LOGCLASS;

    public LoweredEntAps(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, "LoweredEntAps", 94, 4049);
        this.sampleplayer = new ApsSamplePlayer(volumeRangeManager.getEnv().lcMain);
    }

    @Override
    public int getLoweringType() {
        return 1;
    }

    @Override
    int getModelID() {
        return 4049;
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.sampleplayer;
    }

    @Override
    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        this.audioService.requestConnection(0, this.getForegroundConnection());
    }

    @Override
    protected void releaseMenuConnection() {
        this.audible(false);
        this.audioService.releaseConnection(0, this.getForegroundConnection());
    }

    @Override
    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    @Override
    protected String getName() {
        return "LoweredEntAps";
    }

    @Override
    protected int getID() {
        return 5;
    }

    @Override
    void opened() {
        this.env.lcMain.log(-2137614336, "[LoweredEntAps.opened]");
        this.volMenuManager.entered(this.getID(), 0);
    }
}

