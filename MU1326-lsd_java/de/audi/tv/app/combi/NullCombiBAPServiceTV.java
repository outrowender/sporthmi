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
    @Override
    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
    }

    @Override
    public void updateActiveSourceState(int n, int n2) {
    }

    @Override
    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
    }

    @Override
    public void updateActiveInfoState(int n) {
    }

    @Override
    public void updateSourceListTv(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
    }

    @Override
    public void switchSourceResult(int n) {
    }

    @Override
    public void selectListEntryResult(int n) {
    }

    @Override
    public void skipResult(boolean bl) {
    }

    @Override
    public void updateSeekStatus(boolean bl) {
    }

    @Override
    public void updatePreferredList(int n) {
    }

    @Override
    public void getNextListPosResult(int n, int n2, int n3, int n4) {
    }

    @Override
    public void restoreInfoState(int n) {
    }

    @Override
    public void activateSourceResult(int n) {
    }

    @Override
    public void updateOnlineMusicState(int n, int n2) {
    }

    @Override
    public void updateStationListAutoUpdateInformation(boolean bl) {
    }

    @Override
    public void updateTVPresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
    }

    @Override
    public void updateTVStationList(CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
    }

    @Override
    public void updateMuteState(boolean bl) {
    }
}

