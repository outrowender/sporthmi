/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneSiriActivateCommand;
import de.audi.app.sdsmanager.apps.terminalmode.ITerminalModeSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener;

public class MobileSpeechRecognitionListener
implements DSIMobileSpeechRecognitionListener {
    private final LogChannel lc = Logger.getDSIASRLog();
    private final MobileSpeechRecognitionHandler handler;
    private final ITerminalModeSDSHandler terminalModeSDSHandler;

    public MobileSpeechRecognitionListener(MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, ITerminalModeSDSHandler iTerminalModeSDSHandler) {
        this.handler = mobileSpeechRecognitionHandler;
        this.terminalModeSDSHandler = iTerminalModeSDSHandler;
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener initialized.");
    }

    public void setDSI(DSIMobileSpeechRecognition dSIMobileSpeechRecognition) {
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#setDSI: called");
        this.handler.setDSI(dSIMobileSpeechRecognition);
        dSIMobileSpeechRecognition.setNotification(new int[]{2, 1, 3}, (DSIListener)this);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(-1601830656, "MobileSpeechRecognitionListener#asyncException called: %2 %1 %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        if (!Boolean.getBoolean("externalSDS")) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionAvailable: VM-option for external SDS not set -> NOP!");
            return;
        }
        if (n2 == 2) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionAvailable: Called, invalid update.");
            return;
        }
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionAvailable: available=%1", (long)n);
        SDSModelAccess.setExternalSDSPossible(n == 1 ? 1 : 0);
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
        if (!Boolean.getBoolean("externalSDS")) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionAvailable: VM-option for external SDS not set => NOP!");
            return;
        }
        if (n2 == 2) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionActive: Called with invalid update!");
            return;
        }
        if (this.terminalModeSDSHandler.isTerminalModeDeviceActive() && n == 1) {
            this.lc.log(-1601830656, "MobileSpeechRecognitionListener#updateSpeechRecognitionActive: Terminal-Mode device active => Ignore incorrect activation of external SDS!");
            return;
        }
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionActive: active=%1", (long)n);
        SDSModelAccess.setExternalSDSStatus(n == 1 ? 1 : 0);
        this.handler.setMobileSpeechRecognitionActive(n == 1);
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
        if (n2 == 2) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionType: Called, invalid update.");
            return;
        }
        String string = "";
        switch (n) {
            case 1: {
                string = "GENERIC";
                break;
            }
            case 3: {
                string = "GOOGLE_NOW";
                break;
            }
            case 2: {
                string = "SIRI";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#updateSpeechRecognitionType: mobileSpeechRecType=%1, type=%2", (Object)string, (long)n);
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#responseStartSpeechRecognition: result=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(-2137614336, "MobileSpeechRecognitionListener#responseStartSpeechRecognition: No command active, assuming recognition restart!");
            return;
        }
        if (abstractSystemCallCommand instanceof PhoneSiriActivateCommand) {
            ((PhoneSiriActivateCommand)SDSUtils.getActiveSystemCall()).responseStartSpeechRecognition(n);
        } else {
            this.lc.log(10000, "NaviServiceListenerImpl#responseSetDestination: Active command is not PhoneSiriActivateCommand!");
        }
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
        this.lc.log(-2137614336, "MobileSpeechRecognitionListener#responseStopSpeechRecognition: result=%1", (long)n);
    }
}

