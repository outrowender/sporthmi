/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class AudioConnectionState {
    private final AudioState state;
    private final int connection;
    private final TMAudioConnection tmAudioConnection;

    public AudioConnectionState(int n, AudioState audioState) {
        this.connection = n;
        this.state = audioState;
        this.tmAudioConnection = this.mapAudioConnection2TMAudioConnection(n);
    }

    private TMAudioConnection mapAudioConnection2TMAudioConnection(int n) {
        switch (n) {
            case 154: {
                return TMAudioConnection.ANNOUNCEMENT;
            }
            case 155: {
                return TMAudioConnection.LOWERING;
            }
            case 162: {
                return TMAudioConnection.MEDIA;
            }
            case 151: {
                return TMAudioConnection.PHONE;
            }
            case 163: {
                return TMAudioConnection.PHONE_INPUT;
            }
            case 152: {
                return TMAudioConnection.SPEECH;
            }
            case 153: {
                return TMAudioConnection.SPEECH_INPUT;
            }
            case 95: {
                return TMAudioConnection.RINGTONE;
            }
            case 160: {
                return TMAudioConnection.ANNOUNCEMENT;
            }
            case 161: {
                return TMAudioConnection.LOWERING;
            }
            case 156: {
                return TMAudioConnection.MEDIA;
            }
            case 157: {
                return TMAudioConnection.PHONE;
            }
            case 164: {
                return TMAudioConnection.PHONE_INPUT;
            }
            case 158: {
                return TMAudioConnection.SPEECH_GUIDANCE;
            }
            case 159: {
                return TMAudioConnection.SPEECH_INPUT;
            }
        }
        return TMAudioConnection.INVALID;
    }

    public AudioConnectionState(int n) {
        this(n, AudioState.UNDEFINED);
    }

    public AudioState getState() {
        return this.state;
    }

    public TMAudioConnection getTMConnection() {
        return this.tmAudioConnection;
    }

    int getConnection() {
        return Util.createInteger(this.connection);
    }

    public boolean isAudible() {
        return this.state.is((T[])new AudioState[]{AudioState.FADEDIN, AudioState.STARTED});
    }

    public boolean isAtAMActive() {
        return this.state.isOneOf(AudioState.FADEDIN, AudioState.STARTED, AudioState.PAUSED, AudioState.RELEASED);
    }

    public boolean equals(Object object) {
        try {
            return ((AudioConnectionState)object).connection == this.connection && ((AudioConnectionState)object).state == this.state;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return this.connection;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("'").append(this.connection).append("','").append(this.state.toString()).append("'");
        return buffer.toString();
    }
}

