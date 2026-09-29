/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.audio.AudioListenerDistributor$ListEntry;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import java.util.ArrayList;
import java.util.Arrays;

public class AudioListenerDistributor {
    private final Object mutex = new Object();
    private final LogChannel lc;
    private volatile AudioListenerDistributor$ListEntry[] distributionList = new AudioListenerDistributor$ListEntry[0];

    public AudioListenerDistributor(LogChannel logChannel) {
        this.lc = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = new AudioListenerDistributor$ListEntry[this.distributionList.length + 1];
            audioListenerDistributor$ListEntryArray[0] = new AudioListenerDistributor$ListEntry(n, hMIAudioServiceListener);
            System.arraycopy((Object)this.distributionList, 0, (Object)audioListenerDistributor$ListEntryArray, 1, this.distributionList.length);
            this.distributionList = audioListenerDistributor$ListEntryArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.distributionList));
            boolean bl = arrayList.remove(new AudioListenerDistributor$ListEntry(n, hMIAudioServiceListener));
            if (bl) {
                Object[] objectArray = new AudioListenerDistributor$ListEntry[arrayList.size()];
                arrayList.toArray(objectArray);
                this.distributionList = objectArray;
            }
        }
    }

    public void callUpdateAMAvailable(int n, boolean bl) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                if (audioListenerDistributor$ListEntryArray[i2].clientID != n) continue;
                audioListenerDistributor$ListEntryArray[i2].listener.updateAMAvailable(bl);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callUpdateAMAvailable] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callStartConnection(int n, int n2) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.startConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callStartConnection] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callStopConnection(int n, int n2) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.stopConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callStopConnection] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callPauseConnection(int n, int n2) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.pauseConnection(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callPauseConnection] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callErrorConnection(int n, int n2, int n3) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.errorConnection(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callErrorConnection] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callFadedIn(int n, int n2) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.fadedIn(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callFadedIn] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public void callUpdateVolumeLock(int n, int n2, boolean bl) {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            try {
                audioListenerDistributor$ListEntryArray[i2].listener.updateVolumeLock(n, n2, bl);
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000, "[AudioListenerDistributor.callUpdateVolumeLock] Failed! %1", (Object)audioListenerDistributor$ListEntryArray[i2], (Throwable)exception);
            }
        }
    }

    public int[] getClientIDs() {
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        IntList intList = new IntList(audioListenerDistributor$ListEntryArray.length);
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            if (intList.contains(audioListenerDistributor$ListEntryArray[i2].clientID)) continue;
            intList.add(audioListenerDistributor$ListEntryArray[i2].clientID);
        }
        return intList.toArray();
    }

    public String toString() {
        Buffer buffer = new Buffer(1000);
        AudioListenerDistributor$ListEntry[] audioListenerDistributor$ListEntryArray = this.distributionList;
        for (int i2 = 0; i2 < audioListenerDistributor$ListEntryArray.length; ++i2) {
            buffer.append("\n[").append(i2).append("] ").append(audioListenerDistributor$ListEntryArray[i2]);
        }
        return buffer.toString();
    }
}

