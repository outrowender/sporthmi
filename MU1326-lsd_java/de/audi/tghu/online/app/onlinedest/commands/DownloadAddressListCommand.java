/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import de.audi.tghu.online.app.onlinedest.commands.DownloadAddressListCommand$IDownloadAddressListResultListener;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.PortalADBEntry;

public class DownloadAddressListCommand
extends AbstractOnlineDestinationCommand {
    public static final int MAX_DOWNLOAD_SIZE;
    private int availableEntries;
    private boolean isImport;
    private DownloadAddressListCommand$IDownloadAddressListResultListener listener;

    public DownloadAddressListCommand(LogChannel logChannel, boolean bl, DownloadAddressListCommand$IDownloadAddressListResultListener downloadAddressListCommand$IDownloadAddressListResultListener) {
        this(logChannel, 100, bl, downloadAddressListCommand$IDownloadAddressListResultListener);
    }

    public DownloadAddressListCommand(LogChannel logChannel, int n, boolean bl, DownloadAddressListCommand$IDownloadAddressListResultListener downloadAddressListCommand$IDownloadAddressListResultListener) {
        this.logger = logChannel;
        this.availableEntries = n;
        this.isImport = bl;
        this.listener = downloadAddressListCommand$IDownloadAddressListResultListener;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "DownloadAddressListCommand#execute: try execute()");
        DSIDestinationImport dSIDestinationImport = this.getDSI();
        if (dSIDestinationImport == null) {
            this.logger.log(10000, "DownloadAddressListCommand#execute: no DSI!");
            return;
        }
        dSIDestinationImport.downloadAddressList(this.availableEntries, this.isImport);
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        int n3;
        if (portalADBEntryArray == null) {
            this.logger.log(-1601830656, "DownloadAddressListCommand#downloadAddressListResult() error on southside. AddressList is null");
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(1078071040, "DownloadAddressListCommand#downloadAddressListResult() length:%1, status:%2, remainingEntries:%3", (long)portalADBEntryArray.length, (long)n, (long)n2);
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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(-2137614336, "[DownloadAddressListCommand#asyncException] Called, error message: %1, error code: %2, request type: %3 ", (Object)string, (long)n, (long)n2);
        this.downloadAddressListResult(new PortalADBEntry[0], 1000, 0);
    }
}

