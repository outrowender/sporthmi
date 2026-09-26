/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;

public interface CombiBAPServiceMediaListener
extends CombiBAPServiceAudioListener {
    default public void goTo(int n, int n2) {
    }

    default public void requestMediaBrowserListByID(int n, int n2, int n3) {
    }

    default public void requestMediaBrowserListByIndex(int n, int n2, int n3) {
    }

    default public void requestCoverArt(long l, int n) {
    }
}

