/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerFSM;
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

    protected void setPwrStateCmd(final int n, final int n2, final int n3) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                try {
                    PowerCommandFactory.this.updateKeyIfWakeupReason(n, n2, n3);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(n3);
                if (powerFSM != null) {
                    powerFSM.triggerPowerState(n, n2);
                }
            }

            public final String toString() {
                return new StringBuffer().append("setPwrStateCmd: state=").append(n).append(" powerEvent=").append(n2).toString();
            }
        });
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

    protected void setExtPwrStateCmd(final int n, final int n2) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(n2);
                if (powerFSM != null) {
                    powerFSM.triggerExtendedPowerState(n);
                }
            }

            public final String toString() {
                return new StringBuffer().append("setExtPwrStateCmd: state=").append(n).toString();
            }
        });
    }

    protected void setRegListenerCmd(final PowerEventListener powerEventListener) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                if (powerEventListener instanceof DSIKeyPanelListener) {
                    PowerCommandFactory.this.kbdListener = (DSIKeyPanelListener)((Object)powerEventListener);
                }
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).addListener(powerEventListener);
            }

            public final String toString() {
                return new StringBuffer().append("setRegListenerCmd: peListener=").append(powerEventListener).toString();
            }
        });
    }

    protected void setUnregListenerCmd(final PowerEventListener powerEventListener) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).removeListener(powerEventListener);
            }

            public final String toString() {
                return new StringBuffer().append("setUnregListenerCmd peListener=").append(powerEventListener).toString();
            }
        });
    }

    protected void setClampSStateCmd(final ClampSignal clampSignal) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).setClampState(clampSignal);
            }

            public final String toString() {
                return new StringBuffer().append("setClampSStateCmd(").append(clampSignal).toString();
            }
        });
    }

    protected void setAudioDeviceServiceCmd(final HMIAudioService hMIAudioService) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getPwrAudioHandler().setAudioDeviceService(hMIAudioService);
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).setAudioDeviceService();
            }

            public final String toString() {
                return new StringBuffer().append("setAudioDeviceServiceCmd: hmiAM=").append(hMIAudioService).toString();
            }
        });
    }

    protected void setPowerDeviceServiceCmd(final DSIPowerManagement dSIPowerManagement) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getPwrDSIHandler().setPwrMgmtDsi(dSIPowerManagement);
            }

            public final String toString() {
                return new StringBuffer().append("setPowerDeviceServiceCmd: powerManagement=").append(dSIPowerManagement).toString();
            }
        });
    }

    protected void setHMIReadyCmd() {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                try {
                    IFrameworkAccess iFrameworkAccess = PowerCommandFactory.this.pwrMgr.getFramework();
                    int n = iFrameworkAccess.getLastmodeHandler().getLastmodeStorage().getBrightness();
                    IDisplayManager iDisplayManager = iFrameworkAccess.getHMIService().getDisplayManager();
                    iDisplayManager.setDisplayBrightness(0, n);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).setHMIReady();
            }

            public final String toString() {
                return "setHMIReadyCmd";
            }
        });
    }

    protected void releaseStandbyMuteCmd() {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getPowerFSM(0).releaseStanbyMute();
            }

            public final String toString() {
                return "releaseStanbyMuteCmd";
            }
        });
    }

    public void setDispButtonTypedCmd(final int n, final int n2) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(n2);
                if (powerFSM != null) {
                    powerFSM.displayButtonTyped(n);
                }
            }

            public final String toString() {
                return new StringBuffer().append("setDispButtonTypedCmd: keyEvent=").append(n).toString();
            }
        });
    }

    public void setHardKeyTypedCmd(final int n, final int n2) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(n2);
                if (powerFSM != null) {
                    powerFSM.hardKeyTyped(n);
                }
            }

            public final String toString() {
                return new StringBuffer().append("setHardKeyTypedCmd: keyEvent=").append(n).toString();
            }
        });
    }

    public void setDSIDisplayManagement(final DSIDisplayManagement dSIDisplayManagement) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getNativeDisplayHandler().setDSIDisplayManagement(dSIDisplayManagement);
            }

            public final String toString() {
                return new StringBuffer().append("setDSIDisplayManagement: displayManagement=").append(dSIDisplayManagement).toString();
            }
        });
    }

    public void setDSIDisplayController(final DSIDisplayController dSIDisplayController) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getNativeDisplayHandler().setDSIDisplayController(dSIDisplayController);
            }

            public final String toString() {
                return new StringBuffer().append("setDSIDisplayManagement: displayManagement=").append(dSIDisplayController).toString();
            }
        });
    }

    public void setDSIKeyPanel(final DSIKeyPanel dSIKeyPanel) {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerCommandFactory.this.pwrMgr.getNativeDisplayHandler().setDSIKeyPanel(dSIKeyPanel);
            }

            public final String toString() {
                return new StringBuffer().append("setDSIKeyPanel: keyPanel=").append(dSIKeyPanel).toString();
            }
        });
    }

    public void setKeyPTTPressedCmd() {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(0);
                if (powerFSM != null) {
                    powerFSM.keyPTTPressed();
                }
            }

            public final String toString() {
                return "setKeyPTTPressedCmd";
            }
        });
    }

    public void notifyListenersOnClampStateChangeCmd() {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(0);
                if (powerFSM != null) {
                    powerFSM.notifyListenersOnClampStateChange();
                }
            }

            public final String toString() {
                return "notifyListenersOnClampStateChangeCmd";
            }
        });
    }

    public void setAMAvailableCmd() {
        this.pwrEventDispatcher.execute(new Runnable(){

            public final void run() {
                PowerFSM powerFSM = PowerCommandFactory.this.pwrMgr.getPowerFSM(0);
                if (powerFSM != null) {
                    powerFSM.setAMAvailable();
                }
            }

            public final String toString() {
                return "setAMAvailable";
            }
        });
    }

    public void freezeDispatcher() {
        this.pwrEventDispatcher.suspend();
    }

    public void unfreezeDispatcher() {
        this.pwrEventDispatcher.resume();
    }
}

