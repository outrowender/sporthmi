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
    private static final int CONNECTION = 83;
    private static final String LOGCLASS = "LoweredEntNav";

    public LoweredEntNav(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, LOGCLASS, 83, 1000056);
        this.samplePlayer = new NaviSamplePlayer(this.env.lcMain);
    }

    public int getLoweringType() {
        return 0;
    }

    int getModelID() {
        return 1000056;
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    protected String getName() {
        return LOGCLASS;
    }

    protected int getID() {
        return 4;
    }
}

