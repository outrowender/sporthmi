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
        this.rhmiDistributedServiceChoice = hMIService.getChoiceModel(-1273289984);
        this.switchToMyAudiDestinationButton = hMIService.getButtonModel(1226777344);
        this.switchToMyAudiDestinationButton.setButtonListener(this);
        this.logChannel = logChannel;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "OnlineDestinationButtonListener#keyPressed modelID: %1, keyID: %2, terminal ID: %3", (long)n, (long)n2, (long)n3);
        if (n == 1226777344) {
            this.logChannel.log(-2137614336, "OnlineDestinationButtonListener#keyPressed transitioning to myAudi");
            this.rhmiDistributedServiceChoice.setValue(1);
            this.switchToMyAudiDestinationButton.fireEvent(n3);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(-1601830656, "OnlineDestinationButtonListener#keyReleased not implemented");
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-1601830656, "OnlineDestinationButtonListener#keyTyped not implemented");
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        this.logChannel.log(-1601830656, "OnlineDestinationButtonListener#keyLongTyped not implemented");
    }
}

