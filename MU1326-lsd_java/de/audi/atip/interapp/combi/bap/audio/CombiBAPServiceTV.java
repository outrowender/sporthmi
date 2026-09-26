/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;

public interface CombiBAPServiceTV
extends CombiBAPServiceAudio {
    default public void updateSourceListTv(CombiBAPAudioSource[] combiBAPAudioSourceArray) {
    }

    default public void updateStationListAutoUpdateInformation(boolean bl) {
    }

    default public void updateTVPresetList(CombiBAPPresetListEntry[] combiBAPPresetListEntryArray) {
    }

    default public void updateTVStationList(CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
    }

    default public void updateMuteState(boolean bl) {
    }
}

