/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.esolutions.fw.util.commons.Buffer;

class AudioListenerDistributor$ListEntry {
    final int clientID;
    final HMIAudioServiceListener listener;

    AudioListenerDistributor$ListEntry(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        this.clientID = n;
        this.listener = hMIAudioServiceListener;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.clientID;
        n = 31 * n + (this.listener == null ? 0 : this.listener.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AudioListenerDistributor$ListEntry)) {
            return false;
        }
        AudioListenerDistributor$ListEntry audioListenerDistributor$ListEntry = (AudioListenerDistributor$ListEntry)object;
        return this.clientID == audioListenerDistributor$ListEntry.clientID && this.listener.equals(audioListenerDistributor$ListEntry.listener);
    }

    public String toString() {
        return new Buffer("client:").append(this.clientID).append(", ").append(this.listener).toString();
    }
}

