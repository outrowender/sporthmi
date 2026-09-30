/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullCombiBAPService
extends NullService
implements CombiBAPServiceTerminalMode {
    public NullCombiBAPService(LogChannel logChannel) {
        super(logChannel, "CombiBAPServiceTerminalMode");
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

    public void updateSourceListTerminalMode(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
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

    public void restoreInfoState(int n) {
        this.log();
    }

    public void activateSourceResult(int n) {
        this.log();
    }

    public void updateOnlineMusicState(int n, int n2) {
        this.log();
    }

    public void updatePlayPosition(PlayPosition playPosition) {
        this.log();
    }
}

