/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.connectivity.bundled;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.remoteinterface.IRemoteHMIBundledConnectivityPayload;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.AbstractBundledConnectivityHandler;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.IBundledConnectivityPopupConfig;

public class BundledConnectivityComponent
extends AbstractRemoteHMIComponent
implements ButtonListener {
    private IBundledConnectivityPopupConfig popupConfig;
    private AbstractBundledConnectivityHandler popupHandler;
    private HMIService hmiService;

    public BundledConnectivityComponent(IBundledConnectivityPopupConfig iBundledConnectivityPopupConfig, AbstractBundledConnectivityHandler abstractBundledConnectivityHandler) {
        this.popupConfig = iBundledConnectivityPopupConfig;
        this.popupHandler = abstractBundledConnectivityHandler;
    }

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(Online.getInstance().getBundledConnectivityLogChannel(), remoteHMIService);
        this.hmiService = remoteHMIService.getFrameworkAccess().getHMIService();
        this.initPopupButtons();
    }

    private void initPopupButtons() {
        this.registerAsButtonListener(this.popupConfig.getBuyNewDataPlanButtonModelId());
        this.registerAsButtonListener(this.popupConfig.getShowDashboardButtonModelId());
    }

    private void registerAsButtonListener(int n) {
        if (n != -1) {
            ButtonModelApp buttonModelApp = this.hmiService.getButtonModel(n);
            buttonModelApp.setButtonListener(this);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.handlePopupButtons(n);
        this.popupHandler.hideCurrentPopup();
    }

    private void handlePopupButtons(int n) {
        int n2 = 0;
        if (n == this.popupConfig.getBuyNewDataPlanButtonModelId()) {
            n2 = 2;
        } else if (n == this.popupConfig.getShowDashboardButtonModelId()) {
            n2 = 1;
        } else {
            this.logChannel.log(100000, "BundledConnectivityComponent#keyPressed component %1 doesn't process events on model with ID %2", (Object)this.getClass().getName(), (long)n);
        }
        if (n2 != 0) {
            RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(100089418);
            IRemoteHMIBundledConnectivityPayload iRemoteHMIBundledConnectivityPayload = this.popupHandler.getLastPayload();
            iRemoteHMIBundledConnectivityPayload.setAppServiceType(n2);
            HMIProperties hMIProperties = remoteHMIAction.getParameters();
            hMIProperties.put("payload", iRemoteHMIBundledConnectivityPayload);
            this.remoteHmiService.invokeAction(remoteHMIAction);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

