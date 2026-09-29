/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

import de.audi.tone.app.intra.IAppSoundListener;
import java.util.ArrayList;
import java.util.List;

public class AppSoundListeners {
    private final List listeners = new ArrayList(10);

    public synchronized void add(IAppSoundListener iAppSoundListener) {
        this.listeners.add(iAppSoundListener);
    }

    public synchronized int size() {
        return this.listeners.size();
    }

    public synchronized IAppSoundListener get(int n) {
        return (IAppSoundListener)this.listeners.get(n);
    }
}

