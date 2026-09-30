/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class InitializationComponent
extends AbstractRemoteHMIComponent
implements ButtonListener {
    private ButtonModelApp disclaimerButton;
    private boolean isInitialized = false;
    private static final int APPLIST_SHOW = 1;
    private static final int APPLIST_DONT_SHOW = 0;
    private int statusShowApplist = 0;

    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.disclaimerButton = this.getModelBank().getButtonModel(2300073);
        this.disclaimerButton.setStatus(1);
        this.disclaimerButton.setButtonListener(this);
        remoteHMIService.addCommandHandler(402, new AbstractCommandHandler("remotehmi-enabled"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "InitializationComponent#indicateCommand: state STATE_REMOTEHMI_ENABLED");
                InitializationComponent.this.setCoreServicesEnabled(true);
            }
        });
        remoteHMIService.addCommandHandler(403, new AbstractCommandHandler("remotehmi-disabled"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "InitializationComponent#indicateCommand: state STATE_REMOTEHMI_DISABLED");
                InitializationComponent.this.setCoreServicesEnabled(false);
            }
        });
        remoteHMIService.addCommandHandler(10, new AbstractCommandHandler("remotehmi-initialization-finished"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "InitializationComponent#indicateCommand: state CommandsCore.INITIALIZATION_FINISHED");
                InitializationComponent.this.setInitialized(true);
            }
        });
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

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2300073: {
                this.logChannel.log(1000000, "InitializationComponent#keyPressed: disclaimer button was pressed");
                this.processDisclaimerResult(true);
                if (this.remoteHmiService.getSDSService() == null) break;
                this.remoteHmiService.getSDSService().keyTyped(2300073, -1);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setInitialized(boolean bl) {
        this.logChannel.log(1000000, "InitializationComponent#setInitialized: setting isInitialized %1", bl);
        InitializationComponent initializationComponent = this;
        synchronized (initializationComponent) {
            this.isInitialized = bl;
        }
        this.checkRemoteHMIEnabled();
    }

    private final synchronized void checkRemoteHMIEnabled() {
        ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(2300074);
        if (choiceModelApp.getValue() != 1) {
            choiceModelApp.setValue(1);
        }
        this.setAvailable(this.isInitialized);
        this.logChannel.log(1000000, "InitializationComponent#checkRemoteHMIEnabled: status for showing applist %1 (0 = don't show applist)", (long)this.statusShowApplist);
        if (this.statusShowApplist == 0) {
            this.logChannel.log(100000, "InitializationComponent#checkRemoteHMIEnabled: status of core services unknown");
        } else {
            this.logChannel.log(1000000, "InitializationComponent#checkRemoteHMIEnabled: skipping core service waiting screen");
        }
        this.getModelBank().getChoiceModel(2300689).setValue(this.statusShowApplist);
        boolean bl = Online.getInstance().isRemoteHMISDSCoded();
    }

    private void setAvailable(boolean bl) {
        int n;
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(204);
        int n2 = n = bl ? 1 : 0;
        if (choiceModelApp.getValue() != n) {
            this.logChannel.log(1000000, "InitializationComponent#setAvailable: set available value to %1", (long)n);
            choiceModelApp.setValue(n);
        }
    }

    public void setCoreServicesEnabled(boolean bl) {
        this.statusShowApplist = 1;
        this.checkRemoteHMIEnabled();
    }
}

