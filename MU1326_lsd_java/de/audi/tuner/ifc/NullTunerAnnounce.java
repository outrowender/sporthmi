/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.ITunerAnnounce;

public class NullTunerAnnounce
implements ITunerAnnounce {
    @Override
    public int getActiveAnnouncement() {
        return 20;
    }

    @Override
    public void setAudioAvailable(boolean bl) {
    }
}

