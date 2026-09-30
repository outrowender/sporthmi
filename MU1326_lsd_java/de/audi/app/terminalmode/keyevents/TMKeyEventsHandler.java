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
    private static final String LOGCLASS = "TMKeyEventsHandler";
    private final LogChannel logger;
    private final TMDSIKeyPanelControllerImpl dsiKeyPanelController;
    private final ITerminalModeDSIKeyEventsController nullKeyEventController;
    private volatile ITerminalModeDSIKeyEventsController dsiKeyEventController;

    public TMKeyEventsHandler(ITerminalLogger iTerminalLogger, TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl) {
        this.logger = iTerminalLogger.keypanel();
        this.dsiKeyPanelController = tMDSIKeyPanelControllerImpl;
        this.dsiKeyEventController = this.nullKeyEventController = new NullTerminalModeDSIKeyEventsController(this.logger);
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiKeyPanelController.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.dsiKeyPanelController.deinit();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.dsiKeyPanelController.addTMKeyPanelListener(this);
        this.dsiKeyPanelController.activate();
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.dsiKeyPanelController.deactivate();
        this.dsiKeyPanelController.removeTMKeyPanelListener();
    }

    public void updateRecognizerLanguage2(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.updateRecognizerLanguage2]", (Object)LOGCLASS);
    }

    public void updateRecognizerMode(int n, int n2) {
        this.logger.log(1000000, "[%1.updateRecognizerMode]", (Object)LOGCLASS);
    }

    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray) {
        this.logger.log(1000000, "[%1.updateCharacterEvent2]", (Object)LOGCLASS);
        this.dsiKeyEventController.updateCharacterEvent(stringArray, nArray);
    }

    public void setCharacterRecognition(int n, boolean bl) {
        this.logger.log(1000000, "[%1.setCharacterRecognition]", (Object)LOGCLASS);
        this.dsiKeyPanelController.setTextInputActive(n, bl);
    }

    public void setDSIKeyEventController(ITerminalModeDSIKeyEventsController iTerminalModeDSIKeyEventsController) {
        this.dsiKeyEventController = iTerminalModeDSIKeyEventsController;
    }
}

