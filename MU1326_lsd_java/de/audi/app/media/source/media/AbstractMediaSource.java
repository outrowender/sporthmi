/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.AbstractSource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.state.SourceStateUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMediaSource
extends AbstractSource {
    private static final String LOGCLASS = "AbstractMediaSource";
    protected final IMediaDSIPlayerController dsiPlayerController;
    protected volatile List slotInfoList;
    private int numberOfSlots;

    public AbstractMediaSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, String string) {
        super(iMediaTerminal, n, string);
        this.dsiPlayerController = iMediaDSIPlayerController;
        this.slotInfoList = new ArrayList(0);
        this.numberOfSlots = 0;
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)this);
        this.slotInfoList.clear();
    }

    public List getSlots() {
        return this.slotInfoList;
    }

    protected final void updateSlotList(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add(new MediaSourceSlot(this, (MediaSlot)iterator.next()));
        }
        this.slotInfoList = arrayList;
    }

    public boolean pausePlaybackOnDeactivation() {
        return true;
    }

    protected IMediaDSIPlayerController getDSIPlayerController() {
        return this.dsiPlayerController;
    }

    public void deactivate(boolean bl) {
        this.logger.main().log(1000000, "[%2.deactivate] [%3] '%1'", bl, (Object)LOGCLASS, (Object)this);
        if (bl) {
            this.freeDevice();
        }
        super.deactivate(bl);
    }

    public void activate(ISourceSlot iSourceSlot) {
        if (this.getActiveState() == 2) {
            this.logger.main().log(1000000, "[%1.activate] [%2] Already active.", (Object)LOGCLASS, (Object)this);
            return;
        }
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iSourceSlot;
        this.logger.main().log(1000000, "[%1.activate] [%2] slotIdx='%3'", (Object)LOGCLASS, (Object)this, (long)mediaSourceSlot.getIndex());
        if (this.isActivateable(mediaSourceSlot)) {
            this.dsiPlayerController.activate(mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID());
            this.setActiveState(2);
        } else {
            this.logger.main().log(1000000, "[%1.activate] [%2] Device not activateable.", (Object)LOGCLASS, (Object)this);
            this.setActiveState(1);
        }
    }

    public void sourceActivated(ISourceSlot iSourceSlot) {
        if (iSourceSlot.getSource().getType() == this.getType()) {
            this.setActiveState(2);
        }
    }

    public final void deactivateSourceDevice() {
        this.logger.main().log(1000000, "[%1.deactivateSourceDevice] [%2]", (Object)LOGCLASS, (Object)this);
        if (this.freeDevice()) {
            this.setActiveState(1);
        }
    }

    private boolean freeDevice() {
        if (this.getActiveState() == 2) {
            this.logger.main().log(1000000, "[%1.freeDevice] [%2]", (Object)LOGCLASS, (Object)this);
            this.dsiPlayerController.deactivate();
            return true;
        }
        this.logger.main().log(1000000, "[%1.freeDevice] [%2] Device not activated.", (Object)LOGCLASS, (Object)this);
        return false;
    }

    public boolean isActivateable(ISourceSlot iSourceSlot) {
        ISourceSlot iSourceSlot2 = this.getSlot(iSourceSlot);
        return iSourceSlot2.isLoaded() && iSourceSlot2.getError() == 0;
    }

    protected ISourceSlot getDefaultEmptySlot(int n) {
        return new MediaSourceSlot(this, 0, n, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 19, -1, "");
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        switch (sourceStateUpdate.getType()) {
            case 1: {
                this.logger.main().log(10000000, "[%1.processSourceStateUpdate] [%2] UPDATE_TYPE_SLOTS_LIST", (Object)LOGCLASS, (Object)this);
                this.updateSlotList((List)sourceStateUpdate.getUpdate());
                return true;
            }
            case 15: {
                this.numberOfSlots = (Integer)sourceStateUpdate.getUpdate();
                this.logger.main().log(10000000, "[%1.processSourceStateUpdate] [%2] UPDATE_TYPE_NUMBER_OF_MEDIA_SLOTS %3", (Object)LOGCLASS, (Object)this, (long)this.numberOfSlots);
                return true;
            }
        }
        return super.processSourceStateUpdate(sourceStateUpdate);
    }

    public int getNumberOfSlots() {
        return this.numberOfSlots;
    }
}

