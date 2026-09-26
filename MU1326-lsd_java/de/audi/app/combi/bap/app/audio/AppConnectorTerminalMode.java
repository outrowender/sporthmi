/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.combi.bap.app.audio.AbstractAppConnectorAudio;
import de.audi.app.combi.bap.app.audio.CombiBAPAudioListStates;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.vw.mib.bap.generated.audiosd.serializer.PlayPosition_Status;

public class AppConnectorTerminalMode
extends AbstractAppConnectorAudio
implements CombiBAPServiceTerminalMode {
    protected AppConnectorTerminalMode(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    @Override
    protected int getAudioApplication() {
        return 3;
    }

    @Override
    protected String getAudioApplicationName() {
        return "TerminalMode";
    }

    @Override
    protected boolean isAudioApplicationInFocus() {
        return ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().isTerminalModeInFocus();
    }

    @Override
    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        CombiBAPAudioSource combiBAPAudioSource = new CombiBAPAudioSource();
        combiBAPAudioSource.setSourceType(n);
        combiBAPAudioSource.setSlotNumber(n2);
        combiBAPAudioSource.setPartitionNumber(n3);
        CombiBAPAudioListStates combiBAPAudioListStates = new CombiBAPAudioListStates();
        combiBAPAudioListStates.setMediaBrowserListAvailable(bl);
        combiBAPAudioListStates.setPresetListAvailable(bl2);
        combiBAPAudioListStates.setListState(n4);
        this.updateActiveSource(combiBAPAudioSource, combiBAPAudioListStates);
    }

    @Override
    public void updateSourceListTerminalMode(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.logChannel.log(1078071040, "[AppConnectorTerminalMode#updateSourceListTerminalMode] called (specified sourceTypes)");
        BAPFunctionArrayFSG bAPFunctionArrayFSG = this.moduleFsg.getBAPFunctionArrayFSG(32);
        ((SourceListHandler)bAPFunctionArrayFSG.getArrayHandler()).updateSources(3, nArray, combiBAPAudioSourceArray);
    }

    @Override
    public void updatePlayPosition(PlayPosition playPosition) {
        this.logChannel.log(-2137614336, "[AppConnectorTerminalMode#updatePlayPosition] %1", (Object)playPosition);
        if (this.isAudioApplicationInFocus()) {
            PlayPosition_Status playPosition_Status = new PlayPosition_Status();
            playPosition_Status.timePosition = playPosition.getTimePosition().getTimeInSeconds();
            playPosition_Status.totalPlayTime = playPosition.getTotalPlayTime().getTimeInSeconds();
            playPosition_Status.attributes.variableBitRateActive = playPosition.isVariableBitRate();
            this.moduleFsg.getBAPFunctionPropertyFSG(52).sendStatusIfChanged(playPosition_Status);
        } else {
            this.logChannel.log(-2137614336, "[AppConnectorTerminalMode#updatePlayPosition] application not in focus; don't send playPosition");
        }
    }
}

