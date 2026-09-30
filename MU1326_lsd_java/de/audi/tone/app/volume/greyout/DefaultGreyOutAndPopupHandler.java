/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.greyout;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.IGreyOutAndPopupHandler;

public class DefaultGreyOutAndPopupHandler
implements IGreyOutAndPopupHandler {
    protected volatile int activeConnection;
    protected volatile int activeEntertainmentConnection;
    protected final int[] greyOutConnections;
    protected ChoiceModelApp popupTriggerModel;
    protected final String label;
    protected LogChannel log;

    public DefaultGreyOutAndPopupHandler(ChoiceModelApp choiceModelApp, int[] nArray, LogChannel logChannel, String string) {
        this.popupTriggerModel = choiceModelApp;
        this.log = logChannel;
        this.label = string;
        this.greyOutConnections = nArray;
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.log.log(10000000, "[DefaultGreyOutAndPopupHandler.updateActiveEntertainmentConnection][%1] connection: %2, hmiTerminal: %3", (Object)this.label, (long)n, (long)n2);
        this.activeEntertainmentConnection = n;
    }

    public void updateActiveConnection(int n, int n2) {
        this.log.log(10000000, "[DefaultGreyOutAndPopupHandler.updateActiveConnection][%1] connection: %2, hmiTerminal: %3", (Object)this.label, (long)n, (long)n2);
        this.activeConnection = n;
        this.updateGreyOutState();
    }

    protected void updateGreyOutState() {
        if (AudioConnection.contains(this.greyOutConnections, this.activeConnection)) {
            this.log.log(10000000, "[DefaultGreyOutAndPopupHandler.updateGreyOutState] [%1] show popup modelID:%2", (Object)this.label, (long)this.popupTriggerModel.getID());
            this.popupTriggerModel.setValue(1);
        } else {
            this.log.log(10000000, "[DefaultGreyOutAndPopupHandler.updateGreyOutState] [%1] hide popup modelID:%2", (Object)this.label, (long)this.popupTriggerModel.getID());
            this.popupTriggerModel.setValue(0);
        }
    }

    public int getGreyOutState() {
        return this.popupTriggerModel.getValue();
    }
}

