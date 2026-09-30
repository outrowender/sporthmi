/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;

public class NavigationBrowserCallbackHandler
implements IBrowserCallbackHandler {
    private NavigationEnv env;
    private LogChannel logChannel;

    public NavigationBrowserCallbackHandler(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(1000000, "NavigationBrowserCallbackHandler#updateBrowserStateBusy busy=%1", bl);
        int n = bl ? 0 : 1;
        this.env.getChoiceModel(402710).setStatus(n);
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
    }

    public void exceedsUpperThreshold(int n) {
    }

    public void indicateBoardbookAvailable(boolean bl) {
    }

    public void updateBrowserState(int n) {
        int n2 = this.env.getChoiceModel(402280).getValue();
        this.logChannel.log(1000000, "NavigationBrowserCallbackHandler#updateBrowserState browserState : %1 currentHMIState: %2", (long)n, (long)n2);
        int n3 = -1;
        if (n == 0) {
            n3 = 1;
        } else if (n == 6 && n2 == 1) {
            n3 = 2;
        } else if (n != 1 && n != 4) {
            n3 = 0;
        }
        if (n3 >= 0) {
            this.logChannel.log(1000000, "NavigationBrowserCallbackHandler#updateBrowserState hmiState chnaged to %1", (long)n3);
            this.env.getChoiceModel(402280).setValue(n3);
        }
    }

    public void virtualButtonBack() {
        int n = 0;
        this.env.getChoiceModel(402280).setValue(n);
    }
}

