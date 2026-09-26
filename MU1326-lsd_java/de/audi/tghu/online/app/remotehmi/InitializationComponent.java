/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.InitializationComponent$1;
import de.audi.tghu.online.app.remotehmi.InitializationComponent$2;
import de.audi.tghu.online.app.remotehmi.InitializationComponent$3;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class InitializationComponent
extends AbstractRemoteHMIComponent
implements ButtonListener {
    private ButtonModelApp disclaimerButton;
    private boolean isInitialized = false;
    private static final int APPLIST_SHOW;
    private static final int APPLIST_DONT_SHOW;
    private int statusShowApplist = 0;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.disclaimerButton = this.getModelBank().getButtonModel(-1458035968);
        this.disclaimerButton.setStatus(1);
        this.disclaimerButton.setButtonListener(this);
        remoteHMIService.addCommandHandler(402, new InitializationComponent$1(this, "remotehmi-enabled", logChannel));
        remoteHMIService.addCommandHandler(403, new InitializationComponent$2(this, "remotehmi-disabled", logChannel));
        remoteHMIService.addCommandHandler(10, new InitializationComponent$3(this, "remotehmi-initialization-finished", logChannel));
        this.checkRemoteHMIEnabled();
        this.setupCoreServiceEnabled();
    }

    public void setupCoreServiceEnabled() {
    }

    public void processDisclaimerResult(boolean bl) {
        if (bl) {
            this.disclaimerButton.setStatus(2);
            this.disclaimerButton.fireEvent(0);
        } else {
            this.disclaimerButton.setStatus(0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2300073: {
                this.logChannel.log(1078071040, "InitializationComponent#keyPressed: disclaimer button was pressed");
                this.processDisclaimerResult(true);
                if (this.remoteHmiService.getSDSService() == null) break;
                this.remoteHmiService.getSDSService().keyTyped(-1458035968, -1);
                break;
            }
        }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setInitialized(boolean bl) {
        this.logChannel.log(1078071040, "InitializationComponent#setInitialized: setting isInitialized %1", bl);
        InitializationComponent initializationComponent = this;
        synchronized (initializationComponent) {
            this.isInitialized = bl;
        }
        this.checkRemoteHMIEnabled();
    }

    private final synchronized void checkRemoteHMIEnabled() {
        ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(-1441258752);
        if (choiceModelApp.getValue() != 1) {
            choiceModelApp.setValue(1);
        }
        this.setAvailable(this.isInitialized);
        this.logChannel.log(1078071040, "InitializationComponent#checkRemoteHMIEnabled: status for showing applist %1 (0 = don't show applist)", (long)this.statusShowApplist);
        if (this.statusShowApplist == 0) {
            this.logChannel.log(-1601830656, "InitializationComponent#checkRemoteHMIEnabled: status of core services unknown");
        } else {
            this.logChannel.log(1078071040, "InitializationComponent#checkRemoteHMIEnabled: skipping core service waiting screen");
        }
        this.getModelBank().getChoiceModel(286991104).setValue(this.statusShowApplist);
        boolean bl = Online.getInstance().isRemoteHMISDSCoded();
    }

    private void setAvailable(boolean bl) {
        int n;
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(204);
        int n2 = n = bl ? 1 : 0;
        if (choiceModelApp.getValue() != n) {
            this.logChannel.log(1078071040, "InitializationComponent#setAvailable: set available value to %1", (long)n);
            choiceModelApp.setValue(n);
        }
    }

    public void setCoreServicesEnabled(boolean bl) {
        this.statusShowApplist = 1;
        this.checkRemoteHMIEnabled();
    }
}

