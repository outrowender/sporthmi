/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiUrlHandler;

class RemoteHMIEfiUrlHandler$1
implements ITelServiceListener {
    private final /* synthetic */ String val$url;
    private final /* synthetic */ RemoteHMIEfiUrlHandler this$0;

    RemoteHMIEfiUrlHandler$1(RemoteHMIEfiUrlHandler remoteHMIEfiUrlHandler, String string) {
        this.this$0 = remoteHMIEfiUrlHandler;
        this.val$url = string;
    }

    @Override
    public void dialNumberResponse(int n) {
        int n2;
        RemoteHMIEfiUrlHandler.access$000(this.this$0).log(1078071040, "RemoteHMIEfiUrlHandler#dialNumberResponse: result: %1", (long)n);
        if (n == 0) {
            n2 = 1;
        } else {
            n2 = -1;
            RemoteHMIEfiUrlHandler.access$000(this.this$0).log(-1601830656, "RemoteHMIEfiUrlHandler#dialNumberResponse: failed to dial current phone number");
        }
        if (RemoteHMIEfiUrlHandler.access$100(this.this$0) != null) {
            RemoteHMIEfiUrlHandler.access$100(this.this$0).indicateEfiResult(n2, this.val$url);
        }
    }
}

