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
    public void updateReceptionListAutoUpdateInformation(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6);

    public void updateMuteState(MuteState var1);

    public void updateSourceListTuner(CombiBAPAudioSource[] var1);

    public void updateReceptionList(int var1, CombiBAPReceptionListEntry[] var2);

    public void startStationListUpdateResult(int var1);

    public void cancelStationListUpdateResult(int var1);

    public void updateAnnouncementInfo(int var1, String var2);

    public void cancelAnnouncementResult(int var1);

    public void updatePresetList(CombiBAPPresetListEntry[] var1);

    public void updateProgramStringLength(boolean var1, boolean var2);

    public void updateCommonList(CombiBAPCommonListEntry[] var1);
}

