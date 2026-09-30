/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.utils.generics.GList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IEventListener {
    public void updateNowPlayingData(TrackDataChangedEvent var1);

    public void updatePlaybackInfo(PlaybackInfoChangedEvent var1);

    public void updatePlayPosition(TrackPlayPositionEvent var1);

    public void requestUserDecision(TMDevice var1);

    public void readyForActivation(TMDevice var1);

    public void startupFinished();

    public void deviceActivated(TMDevice var1);

    public void mediaAudioAvailable(boolean var1);

    public void updateKombiStage(boolean var1);

    public void triggerBigStage();

    public void updatePhoneState(PhoneStateChangedEvent var1);

    public void updateCallState(GList<CallStateChangedEvent> var1);

    public void callNumber(String var1);

    public void endCall();
}

