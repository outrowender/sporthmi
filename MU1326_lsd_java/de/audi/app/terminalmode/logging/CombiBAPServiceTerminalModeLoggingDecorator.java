/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.audi.atip.log.LogChannel;

public class CombiBAPServiceTerminalModeLoggingDecorator
implements CombiBAPServiceTerminalMode {
    private final CombiBAPServiceTerminalMode wrappee;
    private LogChannel lc;
    private int level;

    public CombiBAPServiceTerminalModeLoggingDecorator(CombiBAPServiceTerminalMode combiBAPServiceTerminalMode, LogChannel logChannel, int n) {
        this.wrappee = combiBAPServiceTerminalMode;
        this.lc = logChannel;
        this.level = n;
    }

    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateActiveSource] sourceType=%1, slotNumber=%2, %3, listState=%4", (Object)new Integer(n), (Object)new Integer(n2), (Object)(bl ? "listAvailable" : "not listAvailable"), (Object)Integer.toString(n4));
        this.wrappee.updateActiveSource(n, n2, n3, bl, bl2, n4);
    }

    public void updateActiveSourceState(int n, int n2) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateActiveSourceState] stateInfo=%1, stateInfoScope=%2", (long)n, (long)n2);
        this.wrappee.updateActiveSourceState(n, n2);
    }

    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateCurrentStation] %1", (Object)combiBAPCurrentStationInfo);
        this.wrappee.updateCurrentStation(combiBAPCurrentStationInfo);
    }

    public void updateActiveInfoState(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateActiveInfoState] %1", (long)n);
        this.wrappee.updateActiveInfoState(n);
    }

    public void updateSourceListTerminalMode(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateSourceList] %1, %2", (Object)Arrays2.toString(nArray), (Object)Arrays2.toString((Object[])combiBAPAudioSourceArray));
        this.wrappee.updateSourceListTerminalMode(nArray, combiBAPAudioSourceArray);
    }

    public void switchSourceResult(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.switchSourceResult] %1", (long)n);
        this.wrappee.switchSourceResult(n);
    }

    public void selectListEntryResult(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.selectListEntryResult] %1", (long)n);
        this.wrappee.selectListEntryResult(n);
    }

    public void skipResult(boolean bl) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.skipResult] %1", bl);
        this.wrappee.skipResult(bl);
    }

    public void updateSeekStatus(boolean bl) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateSeekStatus] %1", bl);
        this.wrappee.updateSeekStatus(bl);
    }

    public void updatePreferredList(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updatePreferredList] %1", (long)n);
        this.wrappee.updatePreferredList(n);
    }

    public void getNextListPosResult(int n, int n2, int n3, int n4) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.getNextListPosResult] result=%1, currentEntryID=%2, nextEntryID=%3, absoluteListPos=%4", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (Object)Integer.toString(n4));
        this.wrappee.getNextListPosResult(n, n2, n3, n4);
    }

    public void restoreInfoState(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.restoreInfoState] %1", (long)n);
        this.wrappee.restoreInfoState(n);
    }

    public void activateSourceResult(int n) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.activateSourceResult] %1", (long)n);
        this.wrappee.activateSourceResult(n);
    }

    public void updateOnlineMusicState(int n, int n2) {
        this.lc.log(this.level, "-> [CombiBAPServiceTerminalMode.updateOnlineMusicState] %1, buffered=%2", (long)n, (long)n2);
        this.wrappee.updateOnlineMusicState(n, n2);
    }

    public void updatePlayPosition(PlayPosition playPosition) {
        this.wrappee.updatePlayPosition(playPosition);
    }
}

