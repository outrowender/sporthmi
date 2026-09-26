/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.sdis.AudioContextControllerImpl;

class AudioContextControllerImpl$InternalA2LSState {
    static final String NO_DEVICE;
    private volatile String requestingDevice = "";
    private volatile String currentDevice = "";
    private final /* synthetic */ AudioContextControllerImpl this$0;

    public AudioContextControllerImpl$InternalA2LSState(AudioContextControllerImpl audioContextControllerImpl) {
        this.this$0 = audioContextControllerImpl;
    }

    public String getRequestingDevice() {
        return this.requestingDevice;
    }

    public void setRequestingDevice(String string) {
        this.requestingDevice = string;
    }

    public String getCurrentDevice() {
        return this.currentDevice;
    }

    public void setCurrentDevice(String string) {
        this.currentDevice = string;
    }
}

