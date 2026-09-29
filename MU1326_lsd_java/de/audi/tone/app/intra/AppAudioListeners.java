/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

import de.audi.tone.app.intra.IAppAudioListener;
import java.util.ArrayList;

public class AppAudioListeners {
    private final ArrayList listeners = new ArrayList(20);

    public synchronized void add(IAppAudioListener iAppAudioListener) {
        this.listeners.add(iAppAudioListener);
    }

    public synchronized IAppAudioListener[] toArray() {
        return (IAppAudioListener[])this.listeners.toArray(new IAppAudioListener[this.listeners.size()]);
    }
}

