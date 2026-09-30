/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.NullScanHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

public class DefaultButtonHandler
extends DefaultButtonListener {
    private IPrevNext nullPrevNext = new IPrevNext(){

        public void handlePrevNext(boolean bl) {
            throw new IllegalArgumentException("no handler registered");
        }
    };
    private IPrevNext[] prevNexts = new IPrevNext[16];
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerAudioMgmt audio;
    private IScanHandler scanHandler;

    DefaultButtonHandler(KeyHandlerBasics keyHandlerBasics) {
        this.logger = keyHandlerBasics.getBasics().getLogger();
        this.models = keyHandlerBasics.getBasics().getModels();
        this.status = keyHandlerBasics.getBasics().getStatus();
        this.audio = keyHandlerBasics.getAudio();
        this.scanHandler = new NullScanHandler(keyHandlerBasics.getBasics().getLogger().hmi);
        this.models.getButtonModel(100428).setButtonListener(this);
        this.models.getButtonModel(100429).setButtonListener(this);
        this.models.getButtonModel(100545).setButtonListener(this);
        for (int i2 = 0; i2 < this.prevNexts.length; ++i2) {
            this.prevNexts[i2] = this.nullPrevNext;
        }
    }

    public void register(IPrevNext iPrevNext, int n) {
        this.prevNexts[n] = iPrevNext;
    }

    public void register(IScanHandler iScanHandler) {
        this.scanHandler = iScanHandler;
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.audio.isActive(201)) {
            return;
        }
        this.logger.hmi.log(10000000, "[DefaultButtonHandler.keyTyped] %1 %2", (long)n, (long)n2);
        switch (n) {
            case 100428: 
            case 100429: {
                if (this.scanHandler.handleHkPrevHkNext(n == 100428)) break;
                this.handleHkPrevHkNext(n, n2, n3);
                break;
            }
            case 100545: {
                TunerProxyManager.getInstance().getActiveTuner().forceStationListUpdate(false);
                break;
            }
            default: {
                this.logger.main.log(100000, "keyTyped event not handled, modelID: %1 ", (long)n);
            }
        }
    }

    private void handleHkPrevHkNext(int n, int n2, int n3) {
        this.logger.hmi.log(10000000, "[DefaultButtonHandler.handleHkPrevHkNext] prev:%1 active screen:%2", n == 100429, (long)this.models.getActiveList());
        if (this.status.getPowerState(n3) == 2) {
            this.logger.hmi.log(10000000, "Handle HK_NEXT_PREV blocked by PowerEvent ");
            return;
        }
        if (!this.audio.isTunerActiveAudioSrc(n3)) {
            this.logger.audio.log(1000000, "Active Entertainment Connection is not AM or FM or DAB or SDARS - returning ... ");
            return;
        }
        this.models.getChoiceModel(100172).setValue(this.status.getSleepScreenActivationTime());
        this.prevNexts[this.models.getActiveList()].handlePrevNext(n == 100428);
    }
}

