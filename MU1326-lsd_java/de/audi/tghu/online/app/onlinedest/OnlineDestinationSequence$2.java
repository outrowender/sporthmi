/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.DownloadAddressListCommand$IDownloadAddressListResultListener;
import org.dsi.ifc.online.PortalADBEntry;

class OnlineDestinationSequence$2
implements DownloadAddressListCommand$IDownloadAddressListResultListener {
    private final /* synthetic */ int val$importMode;
    private final /* synthetic */ OnlineDestinationSequence this$0;

    OnlineDestinationSequence$2(OnlineDestinationSequence onlineDestinationSequence, int n) {
        this.this$0 = onlineDestinationSequence;
        this.val$importMode = n;
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.this$0.log.log(1078071040, "OnlineDestinationSequence#downloadAddressListResult [import] importMode %1 length: %2", (long)this.val$importMode, (long)portalADBEntryArray.length);
        if (n == 1) {
            if (portalADBEntryArray.length == 0) {
                this.this$0.log.log(1078071040, "OnlineDestinationModelUpdater#downloadAddressListResult(): no contacts available");
                n = 5;
            } else if (this.this$0.application.getNewDistinationsAvailablePopupId() != -1) {
                this.this$0.application.getFramework().getHMIService().showPopup(this.this$0.application.getNewDistinationsAvailablePopupId());
            }
        }
        this.this$0.application.getModelHandler().storePortalEntriesToImport(portalADBEntryArray);
    }
}

