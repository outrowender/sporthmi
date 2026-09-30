/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import java.util.ArrayList;
import java.util.Arrays;

public class AudioListenerDistributor {
    private final Object mutex = new Object();
    private final LogChannel lc;
    private volatile ListEntry[] distributionList = new ListEntry[0];

    public AudioListenerDistributor(LogChannel logChannel) {
        this.lc = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            ListEntry[] listEntryArray = new ListEntry[this.distributionList.length + 1];
            listEntryArray[0] = new ListEntry(n, hMIAudioServiceListener);
            System.arraycopy((Object)this.distributionList, 0, (Object)listEntryArray, 1, this.distributionList.length);
            this.distributionList = listEntryArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.distributionList));
            boolean bl = arrayList.remove(new ListEntry(n, hMIAudioServiceListener));
            if (bl) {
                Object[] objectArray = new ListEntry[arrayList.size()];
                arrayList.toArray(objectArray);
                this.distributionList = objectArray;
            }
        }
    }

    public void callUpdateAMAvailable(int n, boolean bl) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                if (listEntryArray[i2].clientID != n) continue;
                listEntryArray[i2].listener.updateAMAvailable(bl);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callUpdateAMAvailable] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callStartConnection(int n, int n2) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.startConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callStartConnection] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callStopConnection(int n, int n2) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.stopConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callStopConnection] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callPauseConnection(int n, int n2) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.pauseConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callPauseConnection] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callErrorConnection(int n, int n2, int n3) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.errorConnection(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callErrorConnection] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callFadedIn(int n, int n2) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.fadedIn(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callFadedIn] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callUpdateVolumeLock(int n, int n2, boolean bl) {
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            try {
                listEntryArray[i2].listener.updateVolumeLock(n, n2, bl);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callUpdateVolumeLock] Failed! %1", (Object)listEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public int[] getClientIDs() {
        ListEntry[] listEntryArray = this.distributionList;
        IntList intList = new IntList(listEntryArray.length);
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            if (intList.contains(listEntryArray[i2].clientID)) continue;
            intList.add(listEntryArray[i2].clientID);
        }
        return intList.toArray();
    }

    public String toString() {
        Buffer buffer = new Buffer(1000);
        ListEntry[] listEntryArray = this.distributionList;
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            buffer.append("\n[").append(i2).append("] ").append(listEntryArray[i2]);
        }
        return buffer.toString();
    }

    private static class ListEntry {
        final int clientID;
        final HMIAudioServiceListener listener;

        ListEntry(int n, HMIAudioServiceListener hMIAudioServiceListener) {
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
            if (!(object instanceof ListEntry)) {
                return false;
            }
            ListEntry listEntry = (ListEntry)object;
            return this.clientID == listEntry.clientID && this.listener.equals(listEntry.listener);
        }

        public String toString() {
            return new Buffer("client:").append(this.clientID).append(", ").append(this.listener).toString();
        }
    }
}

