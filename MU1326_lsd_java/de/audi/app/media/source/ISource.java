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
    public static final int SOURCES;
    public static final int SOURCE_UNDEFINED;
    public static final int CD_DRIVE;
    public static final int CD_CHANGER;
    public static final int DVD_DRIVE;
    public static final int DVD_CHANGER;
    public static final int FILEPLAYER;
    public static final int SDCARD;
    public static final int HDD;
    public static final int TVTUNER;
    public static final int AVIN;
    public static final int AUX;
    public static final int USB;
    public static final int BLUETOOTH;
    public static final int WLAN;
    public static final int ONLINEPLAYER;

    default public void deinit() {
    }

    default public int getType() {
    }

    default public String getName() {
    }

    default public boolean isActive() {
    }

    default public boolean isDeviceActivated() {
    }

    default public boolean isActivateable(ISourceSlot iSourceSlot) {
    }

    default public void activate(ISourceSlot iSourceSlot) {
    }

    default public void deactivate(boolean bl) {
    }

    default public void deactivateSourceDevice() {
    }

    default public void sourceActivated(ISourceSlot iSourceSlot) {
    }

    default public boolean pausePlaybackOnDeactivation() {
    }

    default public boolean isAvailable() {
    }

    default public int getAudioConnection(ISourceSlot iSourceSlot) {
    }

    default public List getSlots() {
    }

    default public ISourceSlot getSlot(int n) {
    }

    default public ISourceSlot getSlot(ISourceSlot iSourceSlot) {
    }

    default public boolean isEmpty() {
    }

    default public void addSourceListener(ISourceListener iSourceListener) {
    }

    default public void removeSourceListener(ISourceListener iSourceListener) {
    }

    default public void addSlotListener(ISourceSlotListener iSourceSlotListener, boolean bl) {
    }

    default public void removeSlotListener(ISourceSlotListener iSourceSlotListener) {
    }

    default public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
    }

    default public Collection getUpdateTypes() {
    }

    default public int getSlotNumberByPartition(int n, int n2) {
    }

    default public ISourceSlot getActivatableSlot(ISourceSlot iSourceSlot) {
    }

    default public boolean isLastSelectedSlot(ISourceSlot iSourceSlot) {
    }

    default public int getNumberOfSlots() {
    }
}

