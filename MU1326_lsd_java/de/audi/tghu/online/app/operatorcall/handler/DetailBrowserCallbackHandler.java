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

    @Override
    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(1078071040, "DetailBrowserCallbackHandler#updateBrowserStateBusy busy=%1", bl);
        int n = this.browserLoadingState = bl ? 0 : 1;
        if (this.browserLoadingState == 1 && this.browserProgressState == 1 || this.browserProgressState == 2) {
            this.hmiService.getModelBankAccess().getChoiceModel(1092945408).setStatus(this.browserLoadingState);
        }
        this.hmiService.getModelBankAccess().getChoiceModel(1092945408).setStatus(0);
    }

    @Override
    public void updateBrowserState(int n) {
        int n2 = this.hmiService.getModelBankAccess().getChoiceModel(1160054272).getStatus();
        this.logChannel.log(1078071040, "DetailBrowserCallbackHandler#updateBrowserState browserState : %1 currentHMIState: %2", (long)n, (long)n2);
        this.browserProgressState = n == 0 || n == 1 ? 0 : (n == 6 || n == 4 ? 1 : 2);
        if (this.browserProgressState >= 0) {
            this.logChannel.log(1078071040, "DetailBrowserCallbackHandler#updateBrowserState hmiState chnaged to %1", (long)this.browserProgressState);
            this.hmiService.getModelBankAccess().getChoiceModel(1160054272).setStatus(this.browserProgressState);
        }
        if (this.browserLoadingState == 1 && this.browserProgressState == 1 || this.browserProgressState == 2) {
            this.hmiService.getModelBankAccess().getChoiceModel(1092945408).setStatus(this.browserLoadingState);
        }
    }

    @Override
    public boolean scrollDown(int n) {
        return false;
    }

    @Override
    public boolean scrollUp(int n) {
        return false;
    }

    @Override
    public void indicateBrowserStateNotFound() {
    }

    @Override
    public void indicateBrowserStateComplete() {
    }

    @Override
    public void indicateBrowserStateTimeout() {
    }

    @Override
    public void javascriptAlert(String string) {
    }

    @Override
    public boolean press() {
        return false;
    }

    @Override
    public boolean indicateEfiUrl(String string) {
        return false;
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.logChannel.log(1078071040, "DetailBrowserCallbackHandler#belowLowerThreshold is recieved from browser handler.");
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1078071040, "DetailBrowserCallbackHandler#exceedsUpperThreshold is recieved from browser handler.");
    }

    @Override
    public void indicateBoardbookAvailable(boolean bl) {
    }

    @Override
    public void virtualButtonBack() {
    }
}

