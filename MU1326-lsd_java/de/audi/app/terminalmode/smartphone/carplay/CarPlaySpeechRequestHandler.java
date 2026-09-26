/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;

public class CarPlaySpeechRequestHandler
implements ISpeechRequestHandler {
    private final ICarplayDSIController dioDSIController;

    public CarPlaySpeechRequestHandler(IContext iContext, ICarplayDSIController iCarplayDSIController) {
        this.dioDSIController = iCarplayDSIController;
    }

    @Override
    public void prewarm() {
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_PREWARM);
    }

    @Override
    public void cancelPrewarm() {
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_STOP);
    }

    @Override
    public void startSpeechSession() {
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_START);
    }

    @Override
    public void abortActiveSpeechSession() {
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_START);
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_STOP);
    }

    @Override
    public void pttReleasedAfterLongPress() {
        this.dioDSIController.requestSIRIAction(SiriAction.SIRIACTION_STOP);
    }
}

