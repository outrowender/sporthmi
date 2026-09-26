/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCommonListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.MuteState;

public interface CombiBAPServiceTuner
extends CombiBAPServiceAudio {
    default public void updateReceptionListAutoUpdateInformation(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
    }

    default public void updateMuteState(MuteState muteState) {
    }

    default public void updateSourceListTuner(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
    }

    default public void updateReceptionList(int n, CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
    }

    default public void startStationListUpdateResult(int n) {
    }

    default public void cancelStationListUpdateResult(int n) {
    }

    default public void updateAnnouncementInfo(int n, String string) {
    }

    default public void cancelAnnouncementResult(int n) {
    }

    default public void updatePresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
    }

    default public void updateProgramStringLength(boolean bl, boolean bl2) {
    }

    default public void updateCommonList(CombiBAPCommonListEntry[] combiBAPCommonListEntryArray) {
    }
}

