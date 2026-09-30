/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioContextStateNotifier;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.esolutions.fw.util.commons.Buffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AudioContext {
    private static final String LOGCLASS = "AudioContext";
    private final LogChannel logger;
    private final GMap<TMAudioConnection, Property<AudioConnectionState>> audioConnectionStateProperty;
    private final GMap<Integer, AudioConnectionState> audioConnections;
    private final IAudioContextStateNotifier notifier;
    private final Object audioConnectionMutex = new Object();
    private final LoggingPropertyFactory audioStatePropertyFactory;

    public AudioContext(IAudioContextStateNotifier iAudioContextStateNotifier, LogChannel logChannel) {
        this.logger = logChannel;
        this.audioConnectionStateProperty = Generics.newHashMap();
        this.audioConnections = Generics.newHashMap();
        this.audioStatePropertyFactory = LoggingPropertyFactory.create(logChannel, 1000000);
        this.initProperty(TMAudioConnection.ANNOUNCEMENT);
        this.initProperty(TMAudioConnection.LOWERING);
        this.initProperty(TMAudioConnection.MEDIA);
        this.initProperty(TMAudioConnection.PHONE);
        this.initProperty(TMAudioConnection.PHONE_INPUT);
        this.initProperty(TMAudioConnection.RINGTONE);
        this.initProperty(TMAudioConnection.SPEECH);
        this.initProperty(TMAudioConnection.SPEECH_GUIDANCE);
        this.initProperty(TMAudioConnection.SPEECH_INPUT);
        this.notifier = iAudioContextStateNotifier;
    }

    private void initProperty(TMAudioConnection tMAudioConnection) {
        Property<AudioConnectionState> property = this.audioStatePropertyFactory.createProperty(tMAudioConnection.name());
        property.accept(new AudioConnectionState(0));
        this.audioConnectionStateProperty.put(tMAudioConnection, property);
    }

    public AudioState getState(int n) {
        AudioConnectionState audioConnectionState = this.getAudioConnectionState(n);
        if (null == audioConnectionState) {
            return AudioState.UNDEFINED;
        }
        return audioConnectionState.getState();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AudioConnectionState getAudioConnectionState(int n) {
        Object object = this.audioConnectionMutex;
        synchronized (object) {
            return this.audioConnections.get(Util.createInteger(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAudioConnectionState(AudioConnectionState audioConnectionState) {
        Object object = this.audioConnectionMutex;
        synchronized (object) {
            Property<AudioConnectionState> property = this.audioConnectionStateProperty.get(audioConnectionState.getTMConnection());
            property.accept(audioConnectionState);
            AudioConnectionState audioConnectionState2 = this.audioConnections.get(new Integer(audioConnectionState.getConnection()));
            if (null != audioConnectionState2 && audioConnectionState2.getState() == audioConnectionState.getState()) {
                return;
            }
            if (null == audioConnectionState2 && audioConnectionState.getState().is(AudioState.STOPPED)) {
                return;
            }
            this.logger.log(100000000, "[%1.setAudioConnectionState] put %2", (Object)LOGCLASS, (long)audioConnectionState.getConnection());
            this.audioConnections.put(new Integer(audioConnectionState.getConnection()), audioConnectionState);
        }
        this.notifier.notifyAudioStateChanged(audioConnectionState);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseConnection(int n) {
        Object object = this.audioConnectionMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.setAudioConnectionState] remove %2", (Object)LOGCLASS, (long)n);
            this.audioConnections.remove(Util.createInteger(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public GCollection<AudioConnectionState> getActiveAudioConnections() {
        Object object = this.audioConnectionMutex;
        synchronized (object) {
            return this.audioConnections.values();
        }
    }

    public boolean isAudible() {
        GCollection<AudioConnectionState> gCollection = this.getActiveAudioConnections();
        if (gCollection.isEmpty()) {
            return false;
        }
        GIterator<AudioConnectionState> gIterator = gCollection.iterator();
        while (gIterator.hasNext()) {
            AudioConnectionState audioConnectionState = gIterator.next();
            if (audioConnectionState.isAudible()) continue;
            return false;
        }
        return true;
    }

    public boolean isActiveAudioConnection(int n) {
        AudioConnectionState audioConnectionState = this.getAudioConnectionState(n);
        if (audioConnectionState == null || audioConnectionState.getState().isOneOf(AudioState.UNKNOWN, AudioState.STOPPED, AudioState.RELEASED)) {
            return false;
        }
        if (audioConnectionState.getState().isOneOf(AudioState.UNDEFINED, AudioState.STARTED, AudioState.PAUSED, AudioState.FADEDIN, AudioState.ERROR)) {
            return true;
        }
        throw new IllegalStateException(new StringBuffer().append("Audio connection is in an unknown state ").append(audioConnectionState.getState()).toString());
    }

    public ReadOnlyProperty<AudioConnectionState> getAudioObservableForAudioConnection(TMAudioConnection tMAudioConnection) {
        ReadOnlyProperty readOnlyProperty = this.audioConnectionStateProperty.get(tMAudioConnection);
        return readOnlyProperty;
    }

    public String toString() {
        Buffer buffer = new Buffer(500);
        GCollection<AudioConnectionState> gCollection = this.getActiveAudioConnections();
        if (gCollection.isEmpty()) {
            return "no active audio connection";
        }
        GIterator<AudioConnectionState> gIterator = gCollection.iterator();
        while (gIterator.hasNext()) {
            AudioConnectionState audioConnectionState = gIterator.next();
            buffer.append(audioConnectionState.toString());
        }
        return buffer.toString();
    }
}

