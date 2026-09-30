/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.onlinedest;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class OnlineDestinationButtonListener
implements ButtonListener {
    private ChoiceModelApp rhmiDistributedServiceChoice;
    private ButtonModelApp switchToMyAudiDestinationButton;
    private LogChannel logChannel;

    public OnlineDestinationButtonListener(HMIService hMIService, LogChannel logChannel) {
        this.rhmiDistributedServiceChoice = hMIService.getChoiceModel(2300852);
        this.switchToMyAudiDestinationButton = hMIService.getButtonModel(2301769);
        this.switchToMyAudiDestinationButton.setButtonListener(this);
        this.logChannel = logChannel;
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineDestinationButtonListener#keyPressed modelID: %1, keyID: %2, terminal ID: %3", (long)n, (long)n2, (long)n3);
        if (n == 2301769) {
            this.logChannel.log(10000000, "OnlineDestinationButtonListener#keyPressed transitioning to myAudi");
            this.rhmiDistributedServiceChoice.setValue(1);
            this.switchToMyAudiDestinationButton.fireEvent(n3);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(100000, "OnlineDestinationButtonListener#keyReleased not implemented");
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(100000, "OnlineDestinationButtonListener#keyTyped not implemented");
    }

    public void keyLongTyped(int n, int n2, int n3) {
        this.logChannel.log(100000, "OnlineDestinationButtonListener#keyLongTyped not implemented");
    }
}

