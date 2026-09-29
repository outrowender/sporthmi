/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent$1;

public class RemoteHMIBrowserComponent
extends AbstractRemoteHMIComponent {
    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(301, new RemoteHMIBrowserComponent$1(this, "browser-send-text"));
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
    }

    public void setBrowserFullscreenHandler(IBrowserHandler iBrowserHandler) {
    }

    public void sendMessageToBrowser(String string) {
    }

    public void checkWakeup() {
    }

    public void remoteHmiBrowserEntered(int n) {
    }

    public void remoteHmiBrowserLeft(int n) {
    }

    public void remoteHmiBrowserFullscreenEntered(int n) {
    }

    public void remoteHmiBrowserFullscreenLeft(int n) {
    }

    public void resetToFactorySettings() {
    }
}

