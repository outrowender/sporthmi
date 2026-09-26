/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;
import de.audi.app.terminalmode.keyevents.ITMKeyPanelHandler;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.NullTerminalModeDSIKeyEventsController;
import de.audi.atip.log.LogChannel;

public class TMKeyEventsHandler
implements TMDSIKeyPanelListener,
ITMKeyPanelHandler,
ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final TMDSIKeyPanelControllerImpl dsiKeyPanelController;
    private final ITerminalModeDSIKeyEventsController nullKeyEventController;
    private volatile ITerminalModeDSIKeyEventsController dsiKeyEventController;

    public TMKeyEventsHandler(ITerminalLogger iTerminalLogger, TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl) {
        this.logger = iTerminalLogger.keypanel();
        this.dsiKeyPanelController = tMDSIKeyPanelControllerImpl;
        this.dsiKeyEventController = this.nullKeyEventController = new NullTerminalModeDSIKeyEventsController(this.logger);
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"TMKeyEventsHandler");
        this.dsiKeyPanelController.init();
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"TMKeyEventsHandler");
        this.dsiKeyPanelController.deinit();
    }

    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"TMKeyEventsHandler");
        this.dsiKeyPanelController.addTMKeyPanelListener(this);
        this.dsiKeyPanelController.activate();
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"TMKeyEventsHandler");
        this.dsiKeyPanelController.deactivate();
        this.dsiKeyPanelController.removeTMKeyPanelListener();
    }

    @Override
    public void updateRecognizerLanguage2(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.updateRecognizerLanguage2]", (Object)"TMKeyEventsHandler");
    }

    @Override
    public void updateRecognizerMode(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateRecognizerMode]", (Object)"TMKeyEventsHandler");
    }

    @Override
    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray) {
        this.logger.log(1078071040, "[%1.updateCharacterEvent2]", (Object)"TMKeyEventsHandler");
        this.dsiKeyEventController.updateCharacterEvent(stringArray, nArray);
    }

    @Override
    public void setCharacterRecognition(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.setCharacterRecognition]", (Object)"TMKeyEventsHandler");
        this.dsiKeyPanelController.setTextInputActive(n, bl);
    }

    public void setDSIKeyEventController(ITerminalModeDSIKeyEventsController iTerminalModeDSIKeyEventsController) {
        this.dsiKeyEventController = iTerminalModeDSIKeyEventsController;
    }
}

