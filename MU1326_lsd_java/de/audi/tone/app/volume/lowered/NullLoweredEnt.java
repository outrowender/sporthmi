/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.lowered;

import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.lowered.AbstractLoweredEnt;

public class NullLoweredEnt
extends AbstractLoweredEnt {
    private static final int INVALID = -1;
    private static final String LOGCLASS = "NullLoweredEnt";

    public NullLoweredEnt(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler) {
        super(volumeRangeManager, iDSISoundHandler, LOGCLASS, 0, -1);
    }

    public int getLoweringType() {
        return -1;
    }

    int getModelID() {
        return -1;
    }

    protected int[] getVolumeConnections() {
        return NO_CONNECTIONS;
    }

    protected String getName() {
        return LOGCLASS;
    }

    protected int getID() {
        return -1;
    }

    void opened() {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.opened] called");
    }

    void closed() {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.closed] called");
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.itemFocused] called");
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.itemSelected] called");
    }

    public void updateLoweringEntertainment(int n, int n2) {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.updateLoweringEntertainment] called");
    }

    protected void limitVolumeToHmiLimits() {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.limitVolumeToHmiLimits] called");
    }

    public void decrease(int n, int n2) {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.decrease] called");
    }

    public void increase(int n, int n2) {
        this.env.lcHMI.log(10000000, "[NullLoweredEnt.increase] called");
    }
}

