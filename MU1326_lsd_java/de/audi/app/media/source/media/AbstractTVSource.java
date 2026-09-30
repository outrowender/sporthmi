/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.source.AbstractSource;
import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.atip.interapp.tv.ITVService;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractTVSource
extends AbstractSource {
    private static final String LOGCLASS = "AbstractTVSource";
    protected final LogChannel logger;
    private ITVService tvService;
    private List slotList;
    private final ISourceStateUpdater updater;
    private final ISourceActivationCallbackHandler sourceActivationCallbackHandler;

    public AbstractTVSource(IMediaTerminal iMediaTerminal, ISourceStateUpdater iSourceStateUpdater, int n, String string, ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
        super(iMediaTerminal, n, string);
        this.logger = iMediaTerminal.getLogger().main();
        this.addUpdateType(12);
        this.addUpdateType(10);
        this.slotList = new ArrayList(0);
        this.sourceActivationCallbackHandler = iSourceActivationCallbackHandler;
        this.updater = iSourceStateUpdater;
    }

    public abstract int getExternalSourceType();

    public boolean pausePlaybackOnDeactivation() {
        return false;
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return 0;
    }

    public boolean isActivateable(ISourceSlot iSourceSlot) {
        return this.isAvailable();
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.setActiveState(1);
        this.sourceActivationCallbackHandler.sourceDeviceActivated(iSourceSlot, -1, true);
    }

    public void sourceActivated(ISourceSlot iSourceSlot) {
        this.setActiveState(2);
    }

    public void deactivateSourceDevice() {
        this.setActiveState(1);
        if (null != this.tvService) {
            this.tvService.deactivate();
        }
    }

    public List getSlots() {
        return this.slotList;
    }

    protected ISourceSlot getDefaultEmptySlot(int n) {
        return this.createSlot(0, 19);
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        if (10 == sourceStateUpdate.getType()) {
            this.tvService = (ITVService)sourceStateUpdate.getUpdate();
            return true;
        }
        if (1 == sourceStateUpdate.getType()) {
            this.slotList = (List)sourceStateUpdate.getUpdate();
            return true;
        }
        if (12 == sourceStateUpdate.getType()) {
            boolean bl = (Boolean)sourceStateUpdate.getUpdate();
            this.setAvailable(bl);
            List list = this.getSlots();
            if (!bl && list.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList(1);
            if (bl) {
                arrayList.add(this.createSlot(3, 0));
            } else {
                arrayList.add(this.createSlot(0, 19));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put(new Integer(this.getType()), arrayList);
            this.updater.updateSourceSlots(hashMap);
            return true;
        }
        return false;
    }

    protected abstract MediaSourceSlot createSlot(int var1, int var2);
}

