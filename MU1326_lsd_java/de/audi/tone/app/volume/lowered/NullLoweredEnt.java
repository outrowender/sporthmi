/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.lowered;

import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.lowered.AbstractLoweredEnt;

public class NullLoweredEnt
extends AbstractLoweredEnt {
    private static final int INVALID;
    private static final String LOGCLASS;

    public NullLoweredEnt(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, "NullLoweredEnt", 0, -1);
    }

    @Override
    public int getLoweringType() {
        return -1;
    }

    @Override
    int getModelID() {
        return -1;
    }

    @Override
    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    @Override
    protected String getName() {
        return "NullLoweredEnt";
    }

    @Override
    protected int getID() {
        return -1;
    }

    @Override
    void opened() {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.opened] called");
    }

    @Override
    void closed() {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.closed] called");
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.itemFocused] called");
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.itemSelected] called");
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.updateLoweringEntertainment] called");
    }

    @Override
    protected void limitVolumeToHmiLimits() {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.limitVolumeToHmiLimits] called");
    }

    @Override
    public void decrease(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.decrease] called");
    }

    @Override
    public void increase(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[NullLoweredEnt.increase] called");
    }
}

