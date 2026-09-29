/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.DirectSuspendResumeBrowserHandler;

public class BOSBrowserHandler
extends DirectSuspendResumeBrowserHandler {
    public BOSBrowserHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, 3, logChannel, logChannel2);
        this.setUseTimeoutHandling(true);
    }
}

