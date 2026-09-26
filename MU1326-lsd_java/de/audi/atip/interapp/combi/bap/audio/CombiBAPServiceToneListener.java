/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceToneListener
extends CombiBAPServiceListener {
    default public void setMuteState(boolean bl) {
    }

    default public void setVolume(int n, int n2) {
    }
}

