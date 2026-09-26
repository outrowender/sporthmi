/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.model.HMIResourceLocator;

public class AsyncBitmapEvent
extends ATIPEvent {
    private static final int EVENT_ID;
    public static final int ERROR_CODE_NONE;
    public static final int ERROR_CODE_ERROR;
    public static final int ERROR_CODE_INVALID_DATA;
    private HMIResourceLocator hmiResourceLocator = null;
    private int errorCode = 0;

    public AsyncBitmapEvent(ATIPEventListener aTIPEventListener, HMIResourceLocator hMIResourceLocator) {
        super(aTIPEventListener, 19001);
        this.hmiResourceLocator = hMIResourceLocator;
    }

    public void setResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.hmiResourceLocator = hMIResourceLocator;
    }

    public HMIResourceLocator getResourceLocator() {
        return this.hmiResourceLocator;
    }

    public void setErrorCode(int n) {
        this.errorCode = n;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}

