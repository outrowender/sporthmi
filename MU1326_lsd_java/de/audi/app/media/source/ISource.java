/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.state.SourceStateUpdate;
import java.util.Collection;
import java.util.List;

public interface ISource {
    public static final int SOURCES = 14;
    public static final int SOURCE_UNDEFINED = -1;
    public static final int CD_DRIVE = 0;
    public static final int CD_CHANGER = 1;
    public static final int DVD_DRIVE = 2;
    public static final int DVD_CHANGER = 3;
    public static final int FILEPLAYER = 4;
    public static final int SDCARD = 5;
    public static final int HDD = 6;
    public static final int TVTUNER = 7;
    public static final int AVIN = 8;
    public static final int AUX = 9;
    public static final int USB = 10;
    public static final int BLUETOOTH = 11;
    public static final int WLAN = 12;
    public static final int ONLINEPLAYER = 13;

    public void deinit();

    public int getType();

    public String getName();

    public boolean isActive();

    public boolean isDeviceActivated();

    public boolean isActivateable(ISourceSlot var1);

    public void activate(ISourceSlot var1);

    public void deactivate(boolean var1);

    public void deactivateSourceDevice();

    public void sourceActivated(ISourceSlot var1);

    public boolean pausePlaybackOnDeactivation();

    public boolean isAvailable();

    public int getAudioConnection(ISourceSlot var1);

    public List getSlots();

    public ISourceSlot getSlot(int var1);

    public ISourceSlot getSlot(ISourceSlot var1);

    public boolean isEmpty();

    public void addSourceListener(ISourceListener var1);

    public void removeSourceListener(ISourceListener var1);

    public void addSlotListener(ISourceSlotListener var1, boolean var2);

    public void removeSlotListener(ISourceSlotListener var1);

    public boolean processSourceStateUpdate(SourceStateUpdate var1);

    public Collection getUpdateTypes();

    public int getSlotNumberByPartition(int var1, int var2);

    public ISourceSlot getActivatableSlot(ISourceSlot var1);

    public boolean isLastSelectedSlot(ISourceSlot var1);

    public int getNumberOfSlots();
}

