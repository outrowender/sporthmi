/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;

public interface CombiBAPServiceAudio
extends CombiBAPService {
    default public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
    }

    default public void updateActiveSourceState(int n, int n2) {
    }

    default public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
    }

    default public void updateActiveInfoState(int n) {
    }

    default public void switchSourceResult(int n) {
    }

    default public void selectListEntryResult(int n) {
    }

    default public void skipResult(boolean bl) {
    }

    default public void updateSeekStatus(boolean bl) {
    }

    default public void updatePreferredList(int n) {
    }

    default public void getNextListPosResult(int n, int n2, int n3, int n4) {
    }

    default public void restoreInfoState(int n) {
    }

    default public void activateSourceResult(int n) {
    }

    default public void updateOnlineMusicState(int n, int n2) {
    }
}

