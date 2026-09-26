/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class ConnectivityOverrideListener
implements ButtonListener {
    private final OnlineModelBankAccess modelBankAccess;
    private final LogChannel logChannel;
    private final RemoteHMIService remotehmiService;

    public ConnectivityOverrideListener(OnlineModelBankAccess onlineModelBankAccess, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.modelBankAccess = onlineModelBankAccess;
        this.logChannel = logChannel;
        this.remotehmiService = remoteHMIService;
        ButtonModelApp buttonModelApp = onlineModelBankAccess.getButtonModel(874324736);
        buttonModelApp.setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConnectivityOverrideListener#keyPressed: called for modelID %1, keyID %2", (long)n, (long)n2);
        RemoteHMIAction remoteHMIAction = this.remotehmiService.getAction(1195308805);
        this.remotehmiService.invokeAction(remoteHMIAction);
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(907813632);
        choiceModelApp.setValue(1);
        ButtonModelApp buttonModelApp = this.modelBankAccess.getButtonModel(874324736);
        buttonModelApp.fireEvent(0);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConnectivityOverrideListener#keyReleased: called for modelID %1, keyID %2", (long)n, (long)n2);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConnectivityOverrideListener#keyTyped: called for modelID %1, keyID %2", (long)n, (long)n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConnectivityOverrideListener#keyLongTyped: called for modelID %1, keyID %2", (long)n, (long)n2);
    }
}

