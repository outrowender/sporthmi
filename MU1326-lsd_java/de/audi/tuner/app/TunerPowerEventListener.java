/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.power.PowerEventListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.ifc.IPowerEvent;

class TunerPowerEventListener
implements PowerEventListener {
    private boolean firstOn = true;
    private final Logger logger;
    private final TunerModels models;
    private final TunerAudioMgmt audio;
    private IPowerEvent[] listeners = new IPowerEvent[0];

    public TunerPowerEventListener(TunerBasics tunerBasics, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.audio = tunerAudioMgmt;
    }

    void register(IPowerEvent iPowerEvent) {
        IPowerEvent[] iPowerEventArray = new IPowerEvent[this.listeners.length + 1];
        System.arraycopy((Object)this.listeners, 0, (Object)iPowerEventArray, 0, this.listeners.length);
        iPowerEventArray[this.listeners.length] = iPowerEvent;
        this.listeners = iPowerEventArray;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logger.hmi.log(1078071040, "PowerEvent received, event id is: %1 ", (long)n);
        this.models.getChoiceModel(-779616000).setValue(n == 0 ? 1 : 0);
        IPowerEvent[] iPowerEventArray = this.listeners;
        for (int i2 = 0; i2 < iPowerEventArray.length; ++i2) {
            iPowerEventArray[i2].notifyPowerEvent(n, n2);
        }
        block0 : switch (n) {
            case 0: {
                this.logger.main.log(-2137614336, "POWERSTATE_ON ");
                if (!this.firstOn) break;
                this.firstOn = false;
                switch (this.audio.getActiveAnnouncementConnection()) {
                    case 34: {
                        this.logger.main.log(-2137614336, "POWERSTATE_ON => Requesting AudioConnection.DAB_PTY31 ");
                        this.audio.requestAudioChannel(34, n2);
                        break block0;
                    }
                    case 32: {
                        this.logger.main.log(-2137614336, "POWERSTATE_ON => Requesting AudioConnection.DAB_TA ");
                        this.audio.requestAudioChannel(32, n2);
                        break block0;
                    }
                    case 33: {
                        this.logger.main.log(-2137614336, "POWERSTATE_ON => Requesting AudioConnection.AMFM_PTY31 ");
                        this.audio.requestAudioChannel(33, n2);
                        break block0;
                    }
                    case 31: {
                        this.logger.main.log(-2137614336, "POWERSTATE_ON => Requesting AudioConnection.AMFM_TA ");
                        this.audio.requestAudioChannel(31, n2);
                        break block0;
                    }
                }
                this.logger.main.log(-2137614336, "POWERSTATE_ON => Nothing to do ");
                break;
            }
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

