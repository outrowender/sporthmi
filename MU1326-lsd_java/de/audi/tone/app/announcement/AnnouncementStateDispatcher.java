/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.announcement;

import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import java.io.Serializable;
import java.util.HashMap;

public class AnnouncementStateDispatcher
implements IAnnouncementStateListener {
    private final HashMap listeners = new HashMap(5);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAnnouncementState(int n, int n2) {
        HashMap hashMap;
        Serializable serializable = this.listeners;
        synchronized (serializable) {
            hashMap = (HashMap)this.listeners.clone();
        }
        serializable = new Integer(n2);
        if (hashMap.containsKey(serializable)) {
            ((IAnnouncementStateListener)hashMap.get(serializable)).updateAnnouncementState(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener, int n) {
        HashMap hashMap = this.listeners;
        synchronized (hashMap) {
            Integer n2 = new Integer(n);
            if (!this.listeners.containsKey(n2)) {
                this.listeners.put(n2, iAnnouncementStateListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAnnouncementStateListener(int n) {
        HashMap hashMap = this.listeners;
        synchronized (hashMap) {
            Integer n2 = new Integer(n);
            if (this.listeners.containsKey(n2)) {
                this.listeners.remove(n2);
            }
        }
    }
}

