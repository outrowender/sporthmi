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
    public static final byte LEVEL_1 = 0;
    public static final byte LEVEL_2 = 1;
    public static final byte LEVEL_3 = 2;
    public static final byte MAX_LEVEL_SIZE = 3;

    public void setMediaSDSService(IMediaSDSService var1);

    public void unsetMediaSDSService();

    public void ignoreMediaDeviceChanges();

    public int getIPodSlotIndex();

    public List getUSBSlotIndexes();

    public IMediaSDSService getMediaSDSService();

    public OneshotHandler initializeOneshotHandler(int var1);

    public OneshotHandler getOneshotHandler();
}

