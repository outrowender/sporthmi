/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceAudioListener
extends CombiBAPServiceListener {
    public static final int SEEK_FORWARD;
    public static final int SEEK_BACKWARD;

    default public void switchSource(int n, int n2, int n3) {
    }

    default public void setActiveSourceState(int n, int n2) {
    }

    default public void selectListEntry(int n) {
    }

    default public void selectListEntryPresetList(int n) {
    }

    default public void skip(int n) {
    }

    default public void startSeek(int n) {
    }

    default public void cancelSeek() {
    }

    default public void setPreferredList(int n) {
    }

    default public void getNextListPos(int n, int n2) {
    }

    default public void activateSource(int n) {
    }
}

