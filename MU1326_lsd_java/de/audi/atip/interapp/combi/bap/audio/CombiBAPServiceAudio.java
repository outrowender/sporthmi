/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;

public interface CombiBAPServiceAudio
extends CombiBAPService {
    public void updateActiveSource(int var1, int var2, int var3, boolean var4, boolean var5, int var6);

    public void updateActiveSourceState(int var1, int var2);

    public void updateCurrentStation(CombiBAPCurrentStationInfo var1);

    public void updateActiveInfoState(int var1);

    public void switchSourceResult(int var1);

    public void selectListEntryResult(int var1);

    public void skipResult(boolean var1);

    public void updateSeekStatus(boolean var1);

    public void updatePreferredList(int var1);

    public void getNextListPosResult(int var1, int var2, int var3, int var4);

    public void restoreInfoState(int var1);

    public void activateSourceResult(int var1);

    public void updateOnlineMusicState(int var1, int var2);
}

