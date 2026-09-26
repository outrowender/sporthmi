/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.lowered;

import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.lowered.AbstractLoweredEnt;
import de.audi.tone.app.volume.samples.ISamplePlayer;
import de.audi.tone.app.volume.samples.NaviSamplePlayer;

public class LoweredEntNav
extends AbstractLoweredEnt {
    private final NaviSamplePlayer samplePlayer;
    private static final int CONNECTION;
    private static final String LOGCLASS;

    public LoweredEntNav(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, "LoweredEntNav", 83, 2017595136);
        this.samplePlayer = new NaviSamplePlayer(this.env.lcMain);
    }

    @Override
    public int getLoweringType() {
        return 0;
    }

    @Override
    int getModelID() {
        return 2017595136;
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    @Override
    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    @Override
    protected String getName() {
        return "LoweredEntNav";
    }

    @Override
    protected int getID() {
        return 4;
    }
}

