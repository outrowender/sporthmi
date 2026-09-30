/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiUrlHandler;

public class RemoteHMIEfiComponent
extends AbstractRemoteHMIComponent
implements RemoteHMIEfiUrlHandler.IEfiUrlListener {
    RemoteHMIEfiUrlHandler efiHandler;

    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.efiHandler = new RemoteHMIEfiUrlHandler(logChannel, remoteHMIService, this.getFrameworkAccess().getHMIService(), this);
        remoteHMIService.addCommandHandler(251, new AbstractCommandHandler("RemoteHMIEfiComponent - indicateEFI Url"){

            public void indicateCommand(int n, Object object) {
                if (!(object instanceof String)) {
                    logChannel.log(10000, "RemoteHMIEfiComponent#indicateCommand: invalid bayload. String expected");
                    return;
                }
                RemoteHMIEfiComponent.this.updateEfiLink((String)object);
            }
        });
    }

    public void updateEfiLink(String string) {
        byte by = this.efiHandler.updateEfiUrl(string);
        this.logChannel.log(10000000, "RemoteHMIEfiComponent#updateEfiLink: direct result %1", (Object)Integer.toString(by));
        if (by != 3) {
            this.indicateEfiResult(by, string);
        }
    }

    public void indicateEfiResult(int n, String string) {
        this.logChannel.log(1000000, "RemoteHMIEfiComponent#indicateEfiResult: result %1 ", (long)n);
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(n == 1 ? 1500 : 1501);
        remoteHMIAction.getParameters().put("loc", string);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }
}

