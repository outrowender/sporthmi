/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.DownloadAddressListCommand$IDownloadAddressListResultListener;
import org.dsi.ifc.online.PortalADBEntry;

class OnlineDestinationSequence$3
implements DownloadAddressListCommand$IDownloadAddressListResultListener {
    private final /* synthetic */ int val$importMode;
    private final /* synthetic */ OnlineDestinationSequence this$0;

    OnlineDestinationSequence$3(OnlineDestinationSequence onlineDestinationSequence, int n) {
        this.this$0 = onlineDestinationSequence;
        this.val$importMode = n;
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.this$0.log.log(1078071040, "OnlineDestinationSequence#downloadAddressListResult [allEntries]result: %3 importMode %1 length: %2", (long)this.val$importMode, (long)portalADBEntryArray.length, (long)n);
        if (n == 1 && portalADBEntryArray.length == 0) {
            this.this$0.log.log(1078071040, "OnlineDestinationModelUpdater#downloadAddressListResult(): no contacts available");
            n = 5;
        }
        this.this$0.application.getModelHandler().storeAllPortalEntries(portalADBEntryArray);
        this.this$0.application.getModelHandler().updateErrorStateModels(n);
    }
}

