/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioConnection;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.atip.utils.collections.Optional;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GALAudioConnection
implements IAudioConnection {
    private final ATIPAudioRoute GAL_ANNOUNCEMENT = new ATIPAudioRouteImpl(14, 3, 0);
    private final ATIPAudioRoute INT_ANNOUNCEMENT = new ATIPAudioRouteImpl(9, 3, 0);
    private final ATIPAudioRoute GAL_SPEECH_INPUT = new ATIPAudioRouteImpl(26, 24, 0);
    private final ATIPAudioRoute GAL_SPEECH_OUTPUT = new ATIPAudioRouteImpl(15, 4, 0);
    private final ATIPAudioRoute INT_SPEECH_INPUT = new ATIPAudioRouteImpl(26, 22, 0);
    private final ATIPAudioRoute INT_SPEECH_OUTPUT = new ATIPAudioRouteImpl(10, 4, 0);
    private final ATIPAudioRoute GAL_MEDIA = new ATIPAudioRouteImpl(5, 1, 0);
    private final ATIPAudioRoute INT_MEDIA = new ATIPAudioRouteImpl(1, 1, 0);

    @Override
    public Optional<Integer> getAudioConnection(TMAudioConnection tMAudioConnection) {
        return GALAudioConnection.getAndroidAutoAudioConnection(tMAudioConnection);
    }

    public static Optional<Integer> getAndroidAutoAudioConnection(TMAudioConnection tMAudioConnection) {
        if (tMAudioConnection.is(TMAudioConnection.ANNOUNCEMENT)) {
            return new Optional<Integer>(new Integer(160));
        }
        if (tMAudioConnection.is(TMAudioConnection.LOWERING)) {
            return new Optional<Integer>(new Integer(161));
        }
        if (tMAudioConnection.is(TMAudioConnection.MEDIA)) {
            return new Optional<Integer>(new Integer(156));
        }
        if (tMAudioConnection.is(TMAudioConnection.PHONE)) {
            return new Optional<Object>(null);
        }
        if (tMAudioConnection.is(TMAudioConnection.PHONE_INPUT)) {
            return new Optional<Object>(null);
        }
        if (tMAudioConnection.is(TMAudioConnection.SPEECH_GUIDANCE)) {
            return new Optional<Integer>(new Integer(158));
        }
        if (tMAudioConnection.is(TMAudioConnection.SPEECH_INPUT)) {
            return new Optional<Integer>(new Integer(159));
        }
        if (tMAudioConnection.is(TMAudioConnection.SPEECH)) {
            return new Optional<Object>(null);
        }
        return new Optional<Object>(null);
    }

    @Override
    public ATIPAudioRoute[] getAudioRoutes(AudioConnectionState audioConnectionState) {
        ATIPAudioRoute[] aTIPAudioRouteArray = null;
        switch (audioConnectionState.getConnection()) {
            case 160: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.GAL_ANNOUNCEMENT, this.INT_ANNOUNCEMENT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_ANNOUNCEMENT};
                break;
            }
            case 161: {
                break;
            }
            case 156: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.GAL_MEDIA};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_MEDIA};
                break;
            }
            case 157: {
                break;
            }
            case 158: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.GAL_SPEECH_OUTPUT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_SPEECH_OUTPUT};
                break;
            }
            case 159: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.GAL_SPEECH_INPUT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_SPEECH_INPUT};
                break;
            }
        }
        return aTIPAudioRouteArray != null ? aTIPAudioRouteArray : new ATIPAudioRoute[]{};
    }

    @Override
    public boolean isActiveAudioConnection(int n) {
        switch (n) {
            case 156: 
            case 157: 
            case 158: 
            case 159: 
            case 160: 
            case 161: {
                return true;
            }
        }
        return false;
    }
}

