/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

import de.audi.atip.hmi.combi.ddp2.ICombiSimulationDrawContext;
import de.audi.atip.hmi.event.CombiInfoEvent;

public class CombiSimulation {
    private static CombiSimulation instance = null;
    private ICombiSimulationDrawContext drawContext = null;

    public static final synchronized CombiSimulation getInstance() {
        if (instance == null) {
            instance = new CombiSimulation();
        }
        return instance;
    }

    public void update(CombiInfoEvent combiInfoEvent) {
        if (this.drawContext == null) {
            return;
        }
        switch (combiInfoEvent.getType()) {
            case 0: {
                this.drawContext.updateText(combiInfoEvent.getFrameID(), combiInfoEvent.getCellNo(), combiInfoEvent.getText(), combiInfoEvent.getTextStyle());
                break;
            }
            case 2: {
                this.drawContext.updateCursor(combiInfoEvent.getFrameID(), combiInfoEvent.getCursorPosition(), combiInfoEvent.getCursorStyle());
                break;
            }
            case 3: {
                this.drawContext.setFrameStatus(combiInfoEvent.getFrameID(), combiInfoEvent.getFrameRequest());
                break;
            }
            case 4: {
                this.drawContext.setActiveSubterminal(combiInfoEvent.getActiveApplication());
                break;
            }
        }
    }

    public void setDrawContext(ICombiSimulationDrawContext iCombiSimulationDrawContext) {
        this.drawContext = iCombiSimulationDrawContext;
    }

    public void screenConnected() {
        if (this.drawContext != null) {
            this.drawContext.screenConnected();
        }
    }
}

