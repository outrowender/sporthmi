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
    public void updateSourceListTv(CombiBAPAudioSource[] var1);

    public void updateStationListAutoUpdateInformation(boolean var1);

    public void updateTVPresetList(CombiBAPPresetListEntry[] var1);

    public void updateTVStationList(CombiBAPReceptionListEntry[] var1);

    public void updateMuteState(boolean var1);
}

