/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.TerminalModeProxy;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;

public class CoMaCarplayHandler
implements ButtonListener {
    private final LogChannel log;
    private final IHMIServiceApp hmiService;
    private final ButtonModelApp carplayDisconnectButton;
    private final ButtonModelApp carplaySwitchButton;
    private final TerminalModeProxy smartphoneProxy;

    public CoMaCarplayHandler(IFrameworkAccess iFrameworkAccess, TerminalModeProxy terminalModeProxy) {
        this.log = iFrameworkAccess.getLogChannel("App.Connectivity.Main");
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.smartphoneProxy = terminalModeProxy;
        this.carplayDisconnectButton = this.hmiService.getButtonModel(2500431);
        this.carplaySwitchButton = this.hmiService.getButtonModel(2500432);
    }

    public void init() {
        this.carplayDisconnectButton.setButtonListener(this);
        this.carplaySwitchButton.setButtonListener(this);
    }

    public void deinit() {
        this.carplayDisconnectButton.resetListener();
        this.carplaySwitchButton.resetListener();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(10000000, "[CoMaCarplayHandler#keyTyped] id=%1, keyID=%2, terminalId = %3", (long)n, (long)n2, (long)n3);
        if (n == this.carplayDisconnectButton.getID()) {
            this.log.log(1000000, "CoMaCarplayHandler#keyTyped(): Disconnecting carplay service");
            this.carplayDisconnectButton.fireEvent(n3);
            this.disconnectCarplayService();
        } else if (n == this.carplaySwitchButton.getID()) {
            this.log.log(1000000, "CoMaCarplayHandler#keyTyped(): switch to carplay");
            ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(4095);
            choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
        }
    }

    private void disconnectCarplayService() {
        TerminalModeDevice terminalModeDevice = this.smartphoneProxy.getCarplayActiveDevice();
        if (terminalModeDevice != null) {
            this.smartphoneProxy.deactivateSmartphone(terminalModeDevice.getDeviceUniqueId());
        } else {
            this.log.log(100000, "CoMaCarplayHandler#disconnectCarplayService: carplayActiveDevice is null.");
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

