/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.connectivity.bundled;

import de.audi.app.online.evo.connectivity.bundled.BundledConnectivityPopupConfigEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.AbstractBundledConnectivityHandler;

public class BundledConnectivityHandlerEvo
extends AbstractBundledConnectivityHandler {
    public BundledConnectivityHandlerEvo(String string, LogChannel logChannel, RemoteHMIService remoteHMIService, BundledConnectivityPopupConfigEvo bundledConnectivityPopupConfigEvo) {
        super(string, logChannel, remoteHMIService, bundledConnectivityPopupConfigEvo);
    }

    @Override
    protected void indicateCommandInternal() {
        int n = this.getInternalPopupType(this.payload.getPopupServiceType());
        if (n != -1) {
            this.indicatePopupType(n);
            this.indicateAppAvailability();
            this.showPopup(((BundledConnectivityPopupConfigEvo)this.popupConfig).getDefaultPopupId());
        }
    }

    private int getInternalPopupType(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "BundledConnectivityHandlerEvo#indicatePopupType ignoring the popup due unknown popup type: %1", (long)n);
            }
        }
        return n2;
    }

    private void indicatePopupType(int n) {
        int n2 = ((BundledConnectivityPopupConfigEvo)this.popupConfig).getPopupTypeChoiceModelId();
        ChoiceModelApp choiceModelApp = this.getModel(n2);
        choiceModelApp.setValue(n);
        this.logChannel.log(1078071040, "BundledConnectivityHandlerEvo#indicatePopupType type of popup to be shown is %1", (long)n);
    }

    private void indicateAppAvailability() {
        int n = ((BundledConnectivityPopupConfigEvo)this.popupConfig).getServiceAvailableChoiceModelId();
        ChoiceModelApp choiceModelApp = this.getModel(n);
        int n2 = 1;
        if (this.payload.getServiceContext() != null) {
            n2 = 0;
        }
        choiceModelApp.setValue(n2);
        this.logChannel.log(1078071040, "BundledConnectivityHandlerEvo#indicatePopupType app availability is %1", (long)n2);
    }
}

