/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class DetailBrowserCallbackHandler
implements IBrowserCallbackHandler {
    RemoteHMIService hmiService;
    private LogChannel logChannel;
    private int browserLoadingState = 0;
    private int browserProgressState = 0;

    public DetailBrowserCallbackHandler(RemoteHMIService remoteHMIService, LogChannel logChannel) {
        this.hmiService = remoteHMIService;
        this.logChannel = logChannel;
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(1000000, "DetailBrowserCallbackHandler#updateBrowserStateBusy busy=%1", bl);
        int n = this.browserLoadingState = bl ? 0 : 1;
        if (this.browserLoadingState == 1 && this.browserProgressState == 1 || this.browserProgressState == 2) {
            this.hmiService.getModelBankAccess().getChoiceModel(402753).setStatus(this.browserLoadingState);
        }
        this.hmiService.getModelBankAccess().getChoiceModel(402753).setStatus(0);
    }

    public void updateBrowserState(int n) {
        int n2 = this.hmiService.getModelBankAccess().getChoiceModel(402757).getStatus();
        this.logChannel.log(1000000, "DetailBrowserCallbackHandler#updateBrowserState browserState : %1 currentHMIState: %2", (long)n, (long)n2);
        this.browserProgressState = n == 0 || n == 1 ? 0 : (n == 6 || n == 4 ? 1 : 2);
        if (this.browserProgressState >= 0) {
            this.logChannel.log(1000000, "DetailBrowserCallbackHandler#updateBrowserState hmiState chnaged to %1", (long)this.browserProgressState);
            this.hmiService.getModelBankAccess().getChoiceModel(402757).setStatus(this.browserProgressState);
        }
        if (this.browserLoadingState == 1 && this.browserProgressState == 1 || this.browserProgressState == 2) {
            this.hmiService.getModelBankAccess().getChoiceModel(402753).setStatus(this.browserLoadingState);
        }
    }

    public boolean scrollDown(int n) {
        return false;
    }

    public boolean scrollUp(int n) {
        return false;
    }

    public void indicateBrowserStateNotFound() {
    }

    public void indicateBrowserStateComplete() {
    }

    public void indicateBrowserStateTimeout() {
    }

    public void javascriptAlert(String string) {
    }

    public boolean press() {
        return false;
    }

    public boolean indicateEfiUrl(String string) {
        return false;
    }

    public void belowLowerThreshold(int n) {
        this.logChannel.log(1000000, "DetailBrowserCallbackHandler#belowLowerThreshold is recieved from browser handler.");
    }

    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1000000, "DetailBrowserCallbackHandler#exceedsUpperThreshold is recieved from browser handler.");
    }

    public void indicateBoardbookAvailable(boolean bl) {
    }

    public void virtualButtonBack() {
    }
}

