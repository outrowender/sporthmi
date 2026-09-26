/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;

class OnlineDestinationListener$2
extends CommandResponse {
    private final /* synthetic */ PortalADBEntry[] val$anAddressList;
    private final /* synthetic */ int val$aStatus;
    private final /* synthetic */ int val$aNumberEntriesRemaining;
    private final /* synthetic */ OnlineDestinationListener this$0;

    OnlineDestinationListener$2(OnlineDestinationListener onlineDestinationListener, PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.this$0 = onlineDestinationListener;
        this.val$anAddressList = portalADBEntryArray;
        this.val$aStatus = n;
        this.val$aNumberEntriesRemaining = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDestinationImportListener)dSIListener).downloadAddressListResult(this.val$anAddressList, this.val$aStatus, this.val$aNumberEntriesRemaining);
    }
}

