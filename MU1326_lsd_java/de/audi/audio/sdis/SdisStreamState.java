/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.log.LogChannel;
import de.audi.audio.sdis.SdisStreamState$MediaRouterConfig;

public class SdisStreamState {
    public static final String LOGCLASS;
    public static final int MEDIA_STREAM_STATUS_UNKNOWN;
    public static final int MEDIA_STREAM_STATUS_START_REQUESTED;
    public static final int MEDIA_STREAM_STATUS_STARTED;
    public static final int MEDIA_STREAM_STATUS_STOP_REQUESTED;
    public static final int MEDIA_STREAM_STATUS_STOPPED;
    public static final int MEDIA_STREAM_STATUS_STOPPED_WITH_ERROR;
    public static final int MEDIA_STREAM_STATUS_STREAM_CHANGED;
    private int curStreamStatus;
    private final LogChannel lc;
    private SdisStreamState$MediaRouterConfig requestedMediaRouterConfig;
    private SdisStreamState$MediaRouterConfig requiredMediaRouterConfig;

    SdisStreamState(LogChannel logChannel) {
        this.lc = logChannel;
        this.curStreamStatus = 0;
    }

    public void setStreamStatus(int n) {
        this.lc.log(1078071040, "[%1.setStreamStatus] cur='%2' new='%3'", (Object)"SdisStreamState", (long)this.curStreamStatus, (long)n);
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
                this.lc.log(-1601830656, "[%1.getHMIStreamStatus] Unknown DSI stream status '%2'.", (Object)"SdisStreamState", (long)n);
            }
        }
        return n2;
    }

    public boolean isCurrentStreamStatusNotStarted() {
        return this.curStreamStatus != 2;
    }

    public void setRequiredMediaRouterConfig(int n, int n2, int n3) {
        this.requiredMediaRouterConfig = new SdisStreamState$MediaRouterConfig(this, n, n2, n3);
    }

    public void setRequestedMediaRouterConfig(int n, int n2, int n3) {
        this.requestedMediaRouterConfig = new SdisStreamState$MediaRouterConfig(this, n, n2, n3);
    }

    public boolean reconfigureMediaRouterNecessary() {
        return this.requiredMediaRouterConfig != null && !this.requiredMediaRouterConfig.equals(this.requestedMediaRouterConfig);
    }
}

