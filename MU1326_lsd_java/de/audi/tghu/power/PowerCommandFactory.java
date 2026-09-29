/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerCommandFactory$1;
import de.audi.tghu.power.PowerCommandFactory$10;
import de.audi.tghu.power.PowerCommandFactory$11;
import de.audi.tghu.power.PowerCommandFactory$12;
import de.audi.tghu.power.PowerCommandFactory$13;
import de.audi.tghu.power.PowerCommandFactory$14;
import de.audi.tghu.power.PowerCommandFactory$15;
import de.audi.tghu.power.PowerCommandFactory$16;
import de.audi.tghu.power.PowerCommandFactory$17;
import de.audi.tghu.power.PowerCommandFactory$2;
import de.audi.tghu.power.PowerCommandFactory$3;
import de.audi.tghu.power.PowerCommandFactory$4;
import de.audi.tghu.power.PowerCommandFactory$5;
import de.audi.tghu.power.PowerCommandFactory$6;
import de.audi.tghu.power.PowerCommandFactory$7;
import de.audi.tghu.power.PowerCommandFactory$8;
import de.audi.tghu.power.PowerCommandFactory$9;
import de.audi.tghu.power.PowerManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.displaycontroller.DSIDisplayController;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

final class PowerCommandFactory {
    private final PowerManager pwrMgr;
    private DispatcherBase pwrEventDispatcher;
    private DSIKeyPanelListener kbdListener;

    PowerCommandFactory(PowerManager powerManager, LogChannel logChannel) {
        this.pwrMgr = powerManager;
        this.pwrEventDispatcher = powerManager.getFramework().getDispatcherManager().createDispatcher("PowerJobs", new JobLogger(logChannel));
        this.pwrEventDispatcher.start();
    }

    protected void setPwrStateCmd(int n, int n2, int n3) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$1(this, n, n2, n3));
    }

    private int getMainWizardAppId() {
        return this.pwrMgr.getFramework().isEvoHighMMIKombi() ? 36 : 41;
    }

    private void updateKeyIfWakeupReason(int n, int n2, int n3) {
        ChoiceModelApp choiceModelApp;
        if (n != 1) {
            return;
        }
        int n4 = -1;
        HMIService hMIService = this.pwrMgr.getFramework().getHMIService();
        if (hMIService != null && (choiceModelApp = hMIService.getChoiceModel(8)) != null) {
            n4 = choiceModelApp.getValue();
        }
        if (n2 == 13 && n4 != 7) {
            this.updateKey(6, 7, n3);
        } else if (n2 == 9 && n4 != 2) {
            this.updateKey(1, 2, n3);
        } else if (n2 == 12 && n4 != this.getMainWizardAppId()) {
            this.updateKey(78, 30, n3);
        } else if (n2 == 11 && n4 != 5) {
            this.updateKey(4, 5, n3);
        } else if (n2 == 8 && n4 != 1) {
            this.updateKey(15, 1, n3);
        } else if (n2 == 10 && n4 != 4) {
            this.updateKey(3, 4, n3);
        } else if (n2 == 14 && n4 != 9) {
            this.updateKey(86, 35, n3);
        } else if (n2 == 15 && n4 != 39) {
            this.updateKey(104, 82, n3);
        } else if (n2 == 16) {
            this.updateKey(103, 83, n3);
        }
    }

    private void updateKey(int n, int n2, int n3) {
        if (this.pwrMgr.getFwServices().checkHMIService() && this.kbdListener != null) {
            this.kbdListener.updateKey2(1, n, 1, 0, 1);
            this.kbdListener.updateKey2(1, n, 0, 0, 1);
        } else {
            this.pwrMgr.getFwServices().getStartupManager().requestAppStartByHMIKey(n2);
        }
    }

    protected void setExtPwrStateCmd(int n, int n2) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$2(this, n2, n));
    }

    protected void setRegListenerCmd(PowerEventListener powerEventListener) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$3(this, powerEventListener));
    }

    protected void setUnregListenerCmd(PowerEventListener powerEventListener) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$4(this, powerEventListener));
    }

    protected void setClampSStateCmd(ClampSignal clampSignal) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$5(this, clampSignal));
    }

    protected void setAudioDeviceServiceCmd(HMIAudioService hMIAudioService) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$6(this, hMIAudioService));
    }

    protected void setPowerDeviceServiceCmd(DSIPowerManagement dSIPowerManagement) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$7(this, dSIPowerManagement));
    }

    protected void setHMIReadyCmd() {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$8(this));
    }

    protected void releaseStandbyMuteCmd() {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$9(this));
    }

    public void setDispButtonTypedCmd(int n, int n2) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$10(this, n2, n));
    }

    public void setHardKeyTypedCmd(int n, int n2) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$11(this, n2, n));
    }

    public void setDSIDisplayManagement(DSIDisplayManagement dSIDisplayManagement) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$12(this, dSIDisplayManagement));
    }

    public void setDSIDisplayController(DSIDisplayController dSIDisplayController) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$13(this, dSIDisplayController));
    }

    public void setDSIKeyPanel(DSIKeyPanel dSIKeyPanel) {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$14(this, dSIKeyPanel));
    }

    public void setKeyPTTPressedCmd() {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$15(this));
    }

    public void notifyListenersOnClampStateChangeCmd() {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$16(this));
    }

    public void setAMAvailableCmd() {
        this.pwrEventDispatcher.execute(new PowerCommandFactory$17(this));
    }

    public void freezeDispatcher() {
        this.pwrEventDispatcher.suspend();
    }

    public void unfreezeDispatcher() {
        this.pwrEventDispatcher.resume();
    }

    static /* synthetic */ void access$000(PowerCommandFactory powerCommandFactory, int n, int n2, int n3) {
        powerCommandFactory.updateKeyIfWakeupReason(n, n2, n3);
    }

    static /* synthetic */ PowerManager access$100(PowerCommandFactory powerCommandFactory) {
        return powerCommandFactory.pwrMgr;
    }

    static /* synthetic */ DSIKeyPanelListener access$202(PowerCommandFactory powerCommandFactory, DSIKeyPanelListener dSIKeyPanelListener) {
        powerCommandFactory.kbdListener = dSIKeyPanelListener;
        return powerCommandFactory.kbdListener;
    }
}

