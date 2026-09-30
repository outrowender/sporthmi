/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import de.audi.tghu.online.app.onlinedest.util.OnlineDestinationAddressUtility;
import org.dsi.ifc.online.PortalADBEntry;

public class StoreAddressListInNavigation
extends AbstractOnlineDestinationCommand {
    private NaviMyAudiImport.IMyAudiImportResultListener callback;

    public StoreAddressListInNavigation(LogChannel logChannel, NaviMyAudiImport.IMyAudiImportResultListener iMyAudiImportResultListener) {
        this.logger = logChannel;
        this.callback = iMyAudiImportResultListener;
    }

    public void execute() {
        this.logger.log(1000000, "StoreAddressListInNavigation#execute()");
        NaviMyAudiImport naviMyAudiImport = this.getNaviMyAudiService();
        if (naviMyAudiImport == null) {
            this.logger.log(10000, "StoreAddressListInNavigation#execute(): no NaviMyAudiImport Service tracked!!");
            this.getCommandList().commandFinished();
            return;
        }
        PortalADBEntry[] portalADBEntryArray = this.getAllPortalEntrtiesList();
        PortalADBEntry[] portalADBEntryArray2 = this.getImportPortalEntrtiesList();
        OnlineAdbEntry[] onlineAdbEntryArray = OnlineDestinationAddressUtility.convertPortalEntriesToOnlineAdbEntry(portalADBEntryArray, this.application.getNaviADBService());
        onlineAdbEntryArray = OnlineDestinationAddressUtility.setOnlineAdbEntryImportState(onlineAdbEntryArray, portalADBEntryArray2);
        naviMyAudiImport.storeAddressList(onlineAdbEntryArray, this.getDownloadResult(), this.callback);
        this.getCommandList().commandFinished();
    }
}

