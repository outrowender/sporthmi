/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceToneListener
extends CombiBAPServiceListener {
    public void setMuteState(boolean var1);

    public void setVolume(int var1, int var2);
}

