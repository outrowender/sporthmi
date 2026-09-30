/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.DirectSuspendResumeBrowserHandler;

public class LicenseBrowserHandler
extends DirectSuspendResumeBrowserHandler {
    public LicenseBrowserHandler(IFrameworkAccess iFrameworkAccess, int n, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, n, logChannel, logChannel2);
    }

    public void updateBrowserState(int n, int n2) {
        if (n2 == 1 && n == 4) {
            this.logChannelDSI.log(1000000, "LicenseBrowserHandler#updateBrowserState: showing browser layer");
            this.modelHandler.setDisplayContextSwitchChoiceValue(4);
        }
        super.updateBrowserState(n, n2);
    }
}

