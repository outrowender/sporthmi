/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCommonListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.MuteState;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullCombiBAPServiceTuner
extends NullService
implements CombiBAPServiceTuner {
    public NullCombiBAPServiceTuner(LogChannel logChannel) {
        super(logChannel, "CombiBAPServiceTuner");
    }

    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        this.log();
    }

    public void updateActiveSourceState(int n, int n2) {
        this.log();
    }

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.log();
    }

    public void updateActiveInfoState(int n) {
        this.log();
    }

    public void updateSourceListTuner(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
        this.log();
    }

    public void switchSourceResult(int n) {
        this.log();
    }

    public void selectListEntryResult(int n) {
        this.log();
    }

    public void skipResult(boolean bl) {
        this.log();
    }

    public void updateSeekStatus(boolean bl) {
        this.log();
    }

    public void updatePreferredList(int n) {
        this.log();
    }

    public void getNextListPosResult(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void updateReceptionListAutoUpdateInformation(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.log();
    }

    public void updateMuteState(MuteState muteState) {
        this.log();
    }

    public void updateReceptionList(int n, CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        this.log();
    }

    public void startStationListUpdateResult(int n) {
        this.log();
    }

    public void cancelStationListUpdateResult(int n) {
        this.log();
    }

    public void updateAnnouncementInfo(int n, String string) {
        this.log();
    }

    public void cancelAnnouncementResult(int n) {
        this.log();
    }

    public void updatePresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
        this.log();
    }

    public void updateProgramStringLength(boolean bl, boolean bl2) {
        this.log();
    }

    public void restoreInfoState(int n) {
        this.log();
    }

    public void activateSourceResult(int n) {
        this.log();
    }

    public void updateOnlineMusicState(int n, int n2) {
        this.log();
    }

    public void updateCommonList(CombiBAPCommonListEntry[] combiBAPCommonListEntryArray) {
        this.log();
    }
}

