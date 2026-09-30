/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;

public class NullVolumeRange
extends AbstractVolumeRange {
    private final int[] connections = new int[0];

    NullVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, -1, -1);
    }

    protected String getName() {
        return "NullVolumeRange";
    }

    protected int getID() {
        return -1;
    }

    protected void init() {
    }

    protected int[] getVolumeConnections() {
        return this.connections;
    }

    protected void audible(boolean bl) {
    }
}

