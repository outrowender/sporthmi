/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.PortalADBEntry;

public class DownloadAddressListCommand
extends AbstractOnlineDestinationCommand {
    public static final int MAX_DOWNLOAD_SIZE = 100;
    private int availableEntries;
    private boolean isImport;
    private IDownloadAddressListResultListener listener;

    public DownloadAddressListCommand(LogChannel logChannel, boolean bl, IDownloadAddressListResultListener iDownloadAddressListResultListener) {
        this(logChannel, 100, bl, iDownloadAddressListResultListener);
    }

    public DownloadAddressListCommand(LogChannel logChannel, int n, boolean bl, IDownloadAddressListResultListener iDownloadAddressListResultListener) {
        this.logger = logChannel;
        this.availableEntries = n;
        this.isImport = bl;
        this.listener = iDownloadAddressListResultListener;
    }

    public void execute() {
        this.logger.log(1000000, "DownloadAddressListCommand#execute: try execute()");
        DSIDestinationImport dSIDestinationImport = this.getDSI();
        if (dSIDestinationImport == null) {
            this.logger.log(10000, "DownloadAddressListCommand#execute: no DSI!");
            return;
        }
        dSIDestinationImport.downloadAddressList(this.availableEntries, this.isImport);
    }

    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        int n3;
        if (portalADBEntryArray == null) {
            this.logger.log(100000, "DownloadAddressListCommand#downloadAddressListResult() error on southside. AddressList is null");
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(1000000, "DownloadAddressListCommand#downloadAddressListResult() length:%1, status:%2, remainingEntries:%3", (long)portalADBEntryArray.length, (long)n, (long)n2);
        switch (n) {
            case 0: 
            case 3001: 
            case 3002: {
                n3 = 1;
                break;
            }
            default: {
                n3 = 4;
            }
        }
        this.listener.downloadAddressListResult(portalADBEntryArray, n3, n2);
        this.getCommandList().commandFinished();
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(10000000, "[DownloadAddressListCommand#asyncException] Called, error message: %1, error code: %2, request type: %3 ", (Object)string, (long)n, (long)n2);
        this.downloadAddressListResult(new PortalADBEntry[0], 1000, 0);
    }

    public static interface IDownloadAddressListResultListener {
        public void downloadAddressListResult(PortalADBEntry[] var1, int var2, int var3);
    }
}

