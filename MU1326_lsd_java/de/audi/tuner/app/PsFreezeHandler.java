/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.PsFreezeHandler$ButtonListener;
import de.audi.tuner.app.PsFreezeHandler$OptionListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.ifc.IAMFMTuner;

public class PsFreezeHandler {
    private final Logger logger;
    private final TunerModels models;
    private IPSFreezeDB psFreezeDB;
    private final MemoryListHandler memory;
    private final HistoryTuner historyTuner;
    private final IAMFMTuner amFmTuner;
    private final IUnifiedTuner uniTuner;
    private AMFMStation stationToFreeze;
    private int band = 0;

    PsFreezeHandler(TunerBasics tunerBasics, MemoryListHandler memoryListHandler, HistoryTuner historyTuner, IPSFreezeDB iPSFreezeDB) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.memory = memoryListHandler;
        this.historyTuner = historyTuner;
        this.psFreezeDB = iPSFreezeDB;
        this.amFmTuner = TunerProxyManager.getInstance().getAmFmTuner();
        this.uniTuner = TunerProxyManager.getInstance().getUnifiedTuner();
        PsFreezeHandler$OptionListener psFreezeHandler$OptionListener = new PsFreezeHandler$OptionListener(this, null);
        this.models.getOptionModel(-1383661312).setListener(psFreezeHandler$OptionListener, -813235968);
        this.models.getOptionModel(-1383661312).setListener(psFreezeHandler$OptionListener, 1753743616);
        this.models.getOptionModel(-1383661312).setListener(psFreezeHandler$OptionListener, 1770520832);
        this.models.getOptionModel(-1383661312).setListener(psFreezeHandler$OptionListener, 1938292992);
        this.models.getOptionModel(-1383661312).setListener(psFreezeHandler$OptionListener, 1921515776);
        this.models.getButtonModel(847708416).setButtonListener(new PsFreezeHandler$ButtonListener(this, null));
        this.models.getSpellerModel(830996736).setMaxLength(16);
    }

    public void freezeDefreze() {
        this.band = this.models.getActiveTuner();
        switch (this.band) {
            case 11: {
                this.stationToFreeze = this.uniTuner.getActiveStation().getFmStation();
                break;
            }
            default: {
                this.stationToFreeze = this.amFmTuner.getActiveStation();
            }
        }
        if (this.stationToFreeze.isPsFreezed()) {
            this.deFreezeStation();
        } else {
            this.freezeStation();
        }
    }

    private void postFreezeAction() {
        this.memory.updatePSFreeze(this.stationToFreeze);
        if (this.historyTuner != null) {
            this.historyTuner.updatePSFreeze(this.stationToFreeze);
        }
        if (this.band == 4) {
            this.amFmTuner.setNotification(new int[]{1, 3});
        } else {
            this.amFmTuner.reNotification(1);
            this.amFmTuner.reNotification(2);
            this.uniTuner.reNotification(4);
            this.uniTuner.reNotification(3);
        }
        this.stationToFreeze = null;
    }

    private void freezeStation() {
        this.stationToFreeze.freezePs(this.stationToFreeze.name);
        this.psFreezeDB.add(this.stationToFreeze);
        this.postFreezeAction();
    }

    private void deFreezeStation() {
        this.logger.hmi.log(-2137614336, "[GUIHAMFM.psFreezePressed] unfreeze %1", (Object)this.stationToFreeze);
        this.stationToFreeze.unfreezePs();
        this.psFreezeDB.remove(this.stationToFreeze);
        this.postFreezeAction();
    }

    static /* synthetic */ TunerModels access$200(PsFreezeHandler psFreezeHandler) {
        return psFreezeHandler.models;
    }

    static /* synthetic */ AMFMStation access$302(PsFreezeHandler psFreezeHandler, AMFMStation aMFMStation) {
        psFreezeHandler.stationToFreeze = aMFMStation;
        return psFreezeHandler.stationToFreeze;
    }

    static /* synthetic */ int access$402(PsFreezeHandler psFreezeHandler, int n) {
        psFreezeHandler.band = n;
        return psFreezeHandler.band;
    }

    static /* synthetic */ AMFMStation access$300(PsFreezeHandler psFreezeHandler) {
        return psFreezeHandler.stationToFreeze;
    }

    static /* synthetic */ void access$500(PsFreezeHandler psFreezeHandler) {
        psFreezeHandler.deFreezeStation();
    }
}

