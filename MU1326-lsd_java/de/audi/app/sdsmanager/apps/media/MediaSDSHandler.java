/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.interapp.media.IMediaSDSService;
import java.util.List;

public interface MediaSDSHandler
extends ISDSApplication {
    public static final byte LEVEL_1;
    public static final byte LEVEL_2;
    public static final byte LEVEL_3;
    public static final byte MAX_LEVEL_SIZE;

    default public void setMediaSDSService(IMediaSDSService iMediaSDSService) {
    }

    default public void unsetMediaSDSService() {
    }

    default public void ignoreMediaDeviceChanges() {
    }

    default public int getIPodSlotIndex() {
    }

    default public List getUSBSlotIndexes() {
    }

    default public IMediaSDSService getMediaSDSService() {
    }

    default public OneshotHandler initializeOneshotHandler(int n) {
    }

    default public OneshotHandler getOneshotHandler() {
    }
}

