/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;

public interface CombiBAPServiceMediaListener
extends CombiBAPServiceAudioListener {
    public void goTo(int var1, int var2);

    public void requestMediaBrowserListByID(int var1, int var2, int var3);

    public void requestMediaBrowserListByIndex(int var1, int var2, int var3);

    public void requestCoverArt(long var1, int var3);
}

