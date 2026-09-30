/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.utils.generics.GList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DefaultEventListener
implements IEventListener {
    @Override
    public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
    }

    @Override
    public void updatePlaybackInfo(PlaybackInfoChangedEvent playbackInfoChangedEvent) {
    }

    @Override
    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
    }

    @Override
    public void requestUserDecision(TMDevice tMDevice) {
    }

    @Override
    public void readyForActivation(TMDevice tMDevice) {
    }

    @Override
    public void startupFinished() {
    }

    @Override
    public void deviceActivated(TMDevice tMDevice) {
    }

    @Override
    public void mediaAudioAvailable(boolean bl) {
    }

    @Override
    public void updateKombiStage(boolean bl) {
    }

    @Override
    public void triggerBigStage() {
    }

    @Override
    public void updatePhoneState(PhoneStateChangedEvent phoneStateChangedEvent) {
    }

    @Override
    public void callNumber(String string) {
    }

    @Override
    public void updateCallState(GList<CallStateChangedEvent> gList) {
    }

    @Override
    public void endCall() {
    }
}

