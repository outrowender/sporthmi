/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationModelHandler;

public class OnlineDestinationHMIListener
implements ButtonListener {
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private OnlineDestinationModelHandler modelUpdater;
    private OnlineDestinationController handler;

    public OnlineDestinationHMIListener(LogChannel logChannel, IHMIServiceApp iHMIServiceApp, OnlineDestinationModelHandler onlineDestinationModelHandler, OnlineDestinationController onlineDestinationController) {
        this.log = logChannel;
        this.hmiService = iHMIServiceApp;
        this.handler = onlineDestinationController;
        this.modelUpdater = onlineDestinationModelHandler;
        this.initializeListeners();
        logChannel.log(1078071040, "OnlineDestinationHMIListener#OnlineDestinationHMIListener()");
    }

    private void initializeListeners() {
        this.log.log(1078071040, "OnlineDestinationHMIListener#initializeListeners()");
        this.hmiService.getButtonModel(-484760832).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(-2137614336, "OnlineDestinationHMIListener#keyPressed() model %1, key %2", (long)n, (long)n2);
        switch (n) {
            case 2300899: {
                this.modelUpdater.setImportMode(0);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 2300925: {
                this.handler.abortSearch();
                break;
            }
            default: {
                this.log.log(10000, "OnlineDestinationHMIListener#keyPressed(): unhandled modelID: %1", (long)n);
            }
        }
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

