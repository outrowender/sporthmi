/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.combi.TerminalModeBapCombi;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$1;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;

class TerminalModeBapCombi$EventListener
extends DefaultEventListener {
    private final /* synthetic */ TerminalModeBapCombi this$0;

    private TerminalModeBapCombi$EventListener(TerminalModeBapCombi terminalModeBapCombi) {
        this.this$0 = terminalModeBapCombi;
    }

    @Override
    public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
        int n = trackDataChangedEvent.getTitle().length() > 0 ? 6 : 0;
        int n2 = trackDataChangedEvent.getArtist().length() > 0 ? 73 : 0;
        int n3 = trackDataChangedEvent.getAlbum().length() > 0 ? 74 : 0;
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo();
        combiBAPCurrentStationInfo.setPrimaryInformation(trackDataChangedEvent.getTitle(), n, 0);
        combiBAPCurrentStationInfo.setSecondaryInformation(trackDataChangedEvent.getArtist(), n2);
        combiBAPCurrentStationInfo.setTertiaryInformation(trackDataChangedEvent.getAlbum(), n3);
        TerminalModeBapCombi.access$700(this.this$0).log(1078071040, "[TerminalModeCombi.updateNowPlayingData] STATES_NO_ERROR!");
        TerminalModeBapCombi.access$500(this.this$0).updateCurrentStation(combiBAPCurrentStationInfo);
        TerminalModeBapCombi.access$500(this.this$0).updateActiveInfoState(0);
    }

    @Override
    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        if (trackPlayPositionEvent.getTotalTimeOfTrack() == 0) {
            TerminalModeBapCombi.access$500(this.this$0).updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(-65536)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(-65536)).build());
        } else {
            TerminalModeBapCombi.access$500(this.this$0).updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(trackPlayPositionEvent.getPlayTime())).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(trackPlayPositionEvent.getTotalTimeOfTrack())).build());
        }
    }

    /* synthetic */ TerminalModeBapCombi$EventListener(TerminalModeBapCombi terminalModeBapCombi, TerminalModeBapCombi$1 terminalModeBapCombi$1) {
        this(terminalModeBapCombi);
    }
}

