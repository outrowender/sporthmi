/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.ifc.AbstractRadioListRow;
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
        OptionListener optionListener = new OptionListener();
        this.models.getOptionModel(100269).setListener(optionListener, 100303);
        this.models.getOptionModel(100269).setListener(optionListener, 100456);
        this.models.getOptionModel(100269).setListener(optionListener, 100457);
        this.models.getOptionModel(100269).setListener(optionListener, 100467);
        this.models.getOptionModel(100269).setListener(optionListener, 100466);
        this.models.getButtonModel(100146).setButtonListener(new ButtonListener());
        this.models.getSpellerModel(100401).setMaxLength(16);
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
        this.logger.hmi.log(10000000, "[GUIHAMFM.psFreezePressed] unfreeze %1", (Object)this.stationToFreeze);
        this.stationToFreeze.unfreezePs();
        this.psFreezeDB.remove(this.stationToFreeze);
        this.postFreezeAction();
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            PsFreezeHandler.this.freezeDefreze();
        }
    }

    private class OptionListener
    extends DefaultOptionListener {
        private OptionListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            TunerObjectContainer tunerObjectContainer = ((AbstractRadioListRow)PsFreezeHandler.this.models.getBaseListModel(n2).getRow(n3)).getTOContainer();
            if (tunerObjectContainer.getType() == 3) {
                PsFreezeHandler.this.stationToFreeze = tunerObjectContainer.getAMFMService();
                PsFreezeHandler.this.band = Utilities.getBandIdByWaveband(((PsFreezeHandler)PsFreezeHandler.this).stationToFreeze.waveband);
            } else {
                PsFreezeHandler.this.stationToFreeze = tunerObjectContainer.getUniStation().getFmStation();
                PsFreezeHandler.this.band = 11;
            }
            if (PsFreezeHandler.this.stationToFreeze.isPsFreezed()) {
                PsFreezeHandler.this.deFreezeStation();
            } else {
                String string = ((PsFreezeHandler)PsFreezeHandler.this).stationToFreeze.name;
                if (string.length() == 0) {
                    string = PsFreezeHandler.this.stationToFreeze.getFrequencyString();
                }
                int n6 = Utilities.isEmpty(string) ? 0 : 1;
                PsFreezeHandler.this.models.getButtonModel(100146).setStatus(n6);
                PsFreezeHandler.this.models.getSpellerModel(100401).setText(string);
                PsFreezeHandler.this.models.getOptionModel(100269).fireEvent(n5);
            }
        }
    }
}

