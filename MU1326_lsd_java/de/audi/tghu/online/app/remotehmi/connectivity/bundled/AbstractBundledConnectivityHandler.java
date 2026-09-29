/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.connectivity.bundled;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.remoteinterface.IRemoteHMIBundledConnectivityPayload;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.IBundledConnectivityPopupConfig;

public abstract class AbstractBundledConnectivityHandler
extends AbstractCommandHandler {
    public static final int ESIM_DATA_BALANCE_DEFAULT_HMI_INTERNAL;
    public static final int ESIM_DATA_BALANCE_LOW_HMI_INTERNAL;
    public static final int ESIM_DATA_BALANCE_EMPTY_HMI_INTERNAL;
    public static final int ESIM_SERVICE_AVAILABLE;
    public static final int ESIM_SERVICE_INACCESSIBLE;
    protected LogChannel logChannel;
    private RemoteHMIService remoteHmiService;
    protected HMIService hmiService;
    protected IBundledConnectivityPopupConfig popupConfig;
    protected IRemoteHMIBundledConnectivityPayload payload = null;
    private int currentPopupId = -1;

    public AbstractBundledConnectivityHandler(String string, LogChannel logChannel, RemoteHMIService remoteHMIService, IBundledConnectivityPopupConfig iBundledConnectivityPopupConfig) {
        super(string);
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
        this.remoteHmiService.addCommandHandler(835620929, this);
        this.hmiService = this.remoteHmiService.getFrameworkAccess().getHMIService();
        this.popupConfig = iBundledConnectivityPopupConfig;
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (object instanceof IRemoteHMIBundledConnectivityPayload) {
            this.payload = (IRemoteHMIBundledConnectivityPayload)object;
            this.indicateCommandInternal();
        } else {
            this.logChannel.log(-1601830656, "AbstractBundledConnectivityHandler#indicateCommand encountered unexpected payload %1", object);
        }
    }

    public IRemoteHMIBundledConnectivityPayload getLastPayload() {
        return this.payload;
    }

    protected abstract void indicateCommandInternal() {
    }

    protected void showPopup(int n) {
        if (n != -1) {
            this.hideCurrentPopup();
            this.showPopupInternal(n);
            this.currentPopupId = n;
        }
    }

    public void hideCurrentPopup() {
        if (this.currentPopupId != -1) {
            this.removePopup(this.currentPopupId);
            this.currentPopupId = -1;
        }
    }

    protected void removePopup(int n) {
        this.hmiService.removePopup(n);
    }

    protected void showPopupInternal(int n) {
        this.hmiService.showPopup(n);
    }

    protected ChoiceModelApp getModel(int n) {
        return this.remoteHmiService.getModelBankAccess().getChoiceModel(n);
    }
}

