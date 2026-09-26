/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.AbstractBrowserHandler;
import org.dsi.ifc.browser.KeyboardInfo;

public class DirectSuspendResumeBrowserHandler
extends AbstractBrowserHandler {
    public DirectSuspendResumeBrowserHandler(IFrameworkAccess iFrameworkAccess, int n, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, n, logChannel, logChannel2);
    }

    @Override
    protected void internalResumeBrowser() {
        this.logChannelDSI.log(1078071040, "DirectSuspendResumeBrowserHandler#internalResumeBrowser: ignoring");
    }

    @Override
    protected void internalSuspendBrowser() {
        this.logChannelDSI.log(1078071040, "DirectSuspendResumeBrowserHandler#internalSuspendBrowser: ignoring");
    }

    @Override
    public void suspendBrowser() {
        this.logChannelDSI.log(1078071040, "DirectSuspendResumeBrowserHandler#suspendBrowser: calling doSuspendBrowser");
        this.doSuspendBrowser();
    }

    @Override
    public void resumeBrowserResult(int n) {
        this.logChannelDSI.log(1078071040, "DirectSuspendResumeBrowserHandler#resumeBrowserResult: showing HMI layer");
        this.modelHandler.setDisplayContextSwitchChoiceValue(4);
    }

    @Override
    public void resumeBrowser() {
        this.logChannelDSI.log(1078071040, "DirectSuspendResumeBrowserHandler#resumeBrowser: calling doResumeBrowser");
        this.doResumeBrowser();
    }

    public void setDisplayContextChoice(int n) {
        this.modelHandler.setDisplayContextSwitchChoiceValue(n);
    }

    @Override
    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

