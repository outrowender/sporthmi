/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;

public class NullCombiBAPServiceTV
implements CombiBAPServiceTV {
    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
    }

    public void updateActiveSourceState(int n, int n2) {
    }

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
    }

    public void updateActiveInfoState(int n) {
    }

    public void updateSourceListTv(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
    }

    public void switchSourceResult(int n) {
    }

    public void selectListEntryResult(int n) {
    }

    public void skipResult(boolean bl) {
    }

    public void updateSeekStatus(boolean bl) {
    }

    public void updatePreferredList(int n) {
    }

    public void getNextListPosResult(int n, int n2, int n3, int n4) {
    }

    public void restoreInfoState(int n) {
    }

    public void activateSourceResult(int n) {
    }

    public void updateOnlineMusicState(int n, int n2) {
    }

    public void updateStationListAutoUpdateInformation(boolean bl) {
    }

    public void updateTVPresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
    }

    public void updateTVStationList(CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
    }

    public void updateMuteState(boolean bl) {
    }
}

