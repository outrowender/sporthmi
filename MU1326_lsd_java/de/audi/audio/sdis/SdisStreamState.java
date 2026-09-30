/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.log.LogChannel;

public class SdisStreamState {
    public static final String LOGCLASS = "SdisStreamState";
    public static final int MEDIA_STREAM_STATUS_UNKNOWN = 0;
    public static final int MEDIA_STREAM_STATUS_START_REQUESTED = 1;
    public static final int MEDIA_STREAM_STATUS_STARTED = 2;
    public static final int MEDIA_STREAM_STATUS_STOP_REQUESTED = 3;
    public static final int MEDIA_STREAM_STATUS_STOPPED = 4;
    public static final int MEDIA_STREAM_STATUS_STOPPED_WITH_ERROR = 5;
    public static final int MEDIA_STREAM_STATUS_STREAM_CHANGED = 6;
    private int curStreamStatus;
    private final LogChannel lc;
    private MediaRouterConfig requestedMediaRouterConfig;
    private MediaRouterConfig requiredMediaRouterConfig;

    SdisStreamState(LogChannel logChannel) {
        this.lc = logChannel;
        this.curStreamStatus = 0;
    }

    public void setStreamStatus(int n) {
        this.lc.log(1000000, "[%1.setStreamStatus] cur='%2' new='%3'", (Object)LOGCLASS, (long)this.curStreamStatus, (long)n);
        this.curStreamStatus = n;
    }

    public int getCurrentStreamStatus() {
        return this.curStreamStatus;
    }

    public int getHMIStreamStatus(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            default: {
                this.lc.log(100000, "[%1.getHMIStreamStatus] Unknown DSI stream status '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
        return n2;
    }

    public boolean isCurrentStreamStatusNotStarted() {
        return this.curStreamStatus != 2;
    }

    public void setRequiredMediaRouterConfig(int n, int n2, int n3) {
        this.requiredMediaRouterConfig = new MediaRouterConfig(n, n2, n3);
    }

    public void setRequestedMediaRouterConfig(int n, int n2, int n3) {
        this.requestedMediaRouterConfig = new MediaRouterConfig(n, n2, n3);
    }

    public boolean reconfigureMediaRouterNecessary() {
        return this.requiredMediaRouterConfig != null && !this.requiredMediaRouterConfig.equals(this.requestedMediaRouterConfig);
    }

    private class MediaRouterConfig {
        private int audioSource;
        private int videoSource;
        private int sink;

        MediaRouterConfig(int n, int n2, int n3) {
            this.audioSource = n;
            this.videoSource = n2;
            this.sink = n3;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.getOuterType().hashCode();
            n = 31 * n + this.audioSource;
            n = 31 * n + this.sink;
            n = 31 * n + this.videoSource;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            MediaRouterConfig mediaRouterConfig = (MediaRouterConfig)object;
            if (!this.getOuterType().equals(mediaRouterConfig.getOuterType())) {
                return false;
            }
            if (this.audioSource != mediaRouterConfig.audioSource) {
                return false;
            }
            if (this.sink != mediaRouterConfig.sink) {
                return false;
            }
            return this.videoSource == mediaRouterConfig.videoSource;
        }

        private SdisStreamState getOuterType() {
            return SdisStreamState.this;
        }
    }
}

