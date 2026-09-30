/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioConnection;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.atip.utils.collections.Optional;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DIOAudioConnection
implements IAudioConnection {
    private final ATIPAudioRoute IOS_ANNOUNCEMENT = new ATIPAudioRouteImpl(11, 3, 0);
    private final ATIPAudioRoute INT_ANNOUNCEMENT = new ATIPAudioRouteImpl(9, 3, 0);
    private final ATIPAudioRoute IOS_SPEECH_INPUT = new ATIPAudioRouteImpl(26, 23, 0);
    private final ATIPAudioRoute IOS_SPEECH_OUTPUT = new ATIPAudioRouteImpl(12, 4, 0);
    private final ATIPAudioRoute INT_SPEECH_INPUT = new ATIPAudioRouteImpl(26, 22, 0);
    private final ATIPAudioRoute INT_SPEECH_OUTPUT = new ATIPAudioRouteImpl(10, 4, 0);
    private final ATIPAudioRoute IOS_MEDIA = new ATIPAudioRouteImpl(4, 1, 0);
    private final ATIPAudioRoute INT_MEDIA = new ATIPAudioRouteImpl(1, 1, 0);
    private final ATIPAudioRoute IOS_PHONE = new ATIPAudioRouteImpl(19, 5, 0);
    private final ATIPAudioRoute IOS_PHONE_INPUT = new ATIPAudioRouteImpl(26, 23, 0);
    private final ATIPAudioRoute INT_PHONE = new ATIPAudioRouteImpl(18, 5, 0);
    private final ATIPAudioRoute INT_PHONE_INPUT = new ATIPAudioRouteImpl(26, 22, 0);
    private final ATIPAudioRoute IOS_RINGTONE = new ATIPAudioRouteImpl(4, 1, 0);
    private final ATIPAudioRoute INT_RINGTONE = new ATIPAudioRouteImpl(1, 1, 0);

    @Override
    public Optional<Integer> getAudioConnection(TMAudioConnection tMAudioConnection) {
        return DIOAudioConnection.getCarplayAudioConnection(tMAudioConnection);
    }

    public static Optional<Integer> getCarplayAudioConnection(TMAudioConnection tMAudioConnection) {
        if (tMAudioConnection.is(TMAudioConnection.ANNOUNCEMENT)) {
            return new Optional<Integer>(new Integer(154));
        }
        if (tMAudioConnection.is(TMAudioConnection.LOWERING)) {
            return new Optional<Integer>(new Integer(155));
        }
        if (tMAudioConnection.is(TMAudioConnection.MEDIA)) {
            return new Optional<Integer>(new Integer(162));
        }
        if (tMAudioConnection.is(TMAudioConnection.PHONE)) {
            return new Optional<Integer>(new Integer(151));
        }
        if (tMAudioConnection.is(TMAudioConnection.PHONE_INPUT)) {
            return new Optional<Integer>(new Integer(163));
        }
        if (tMAudioConnection.is(TMAudioConnection.SPEECH)) {
            return new Optional<Integer>(new Integer(152));
        }
        if (tMAudioConnection.is(TMAudioConnection.SPEECH_INPUT)) {
            return new Optional<Integer>(new Integer(153));
        }
        if (tMAudioConnection.is(TMAudioConnection.RINGTONE)) {
            return new Optional<Integer>(new Integer(95));
        }
        return new Optional<Object>(null);
    }

    @Override
    public ATIPAudioRoute[] getAudioRoutes(AudioConnectionState audioConnectionState) {
        ATIPAudioRoute[] aTIPAudioRouteArray = null;
        switch (audioConnectionState.getConnection()) {
            case 154: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_ANNOUNCEMENT, this.INT_ANNOUNCEMENT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_ANNOUNCEMENT};
                break;
            }
            case 155: {
                break;
            }
            case 162: {
                if (audioConnectionState.isAudible() || audioConnectionState.getState().is(AudioState.PAUSED)) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_MEDIA};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_MEDIA};
                break;
            }
            case 151: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_PHONE};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_PHONE};
                break;
            }
            case 163: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_PHONE_INPUT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_PHONE_INPUT};
                break;
            }
            case 152: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_SPEECH_OUTPUT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_SPEECH_OUTPUT};
                break;
            }
            case 153: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_SPEECH_INPUT};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_SPEECH_INPUT};
                break;
            }
            case 95: {
                if (audioConnectionState.isAudible()) {
                    aTIPAudioRouteArray = new ATIPAudioRoute[]{this.IOS_RINGTONE};
                    break;
                }
                aTIPAudioRouteArray = new ATIPAudioRoute[]{this.INT_RINGTONE};
                break;
            }
        }
        return aTIPAudioRouteArray != null ? aTIPAudioRouteArray : new ATIPAudioRoute[]{};
    }

    @Override
    public boolean isActiveAudioConnection(int n) {
        switch (n) {
            case 151: 
            case 152: 
            case 153: 
            case 154: 
            case 155: 
            case 162: {
                return true;
            }
        }
        return false;
    }
}

