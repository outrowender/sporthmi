/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.onlinedest.commands.AbortDownloadCommand;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import de.audi.tghu.online.app.onlinedest.commands.DownloadAddressListCommand;
import de.audi.tghu.online.app.onlinedest.commands.StoreAddressListInNavigation;
import de.audi.tghu.online.app.onlinedest.commands.UpdateSdsServiceCommand;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationSequence
implements NaviMyAudiImport.IMyAudiImportResultListener {
    OnlineDestinationController application;
    LogChannel log;

    public OnlineDestinationSequence(LogChannel logChannel, OnlineDestinationController onlineDestinationController) {
        this.application = onlineDestinationController;
        this.log = logChannel;
    }

    public void clearSDSList() {
        CommandList commandList = this.application.createCommandList();
        commandList.add(new UpdateSdsServiceCommand(new SDSListEntry[0]));
        commandList.execute("OnlineDestinationSequence-clear-SDS-Command");
    }

    public void startDestinationImport(final int n) {
        this.log.log(1000000, "OnlineDestinationSequence#startDestinationImport() importMode:%1", (long)n);
        CommandList commandList = this.application.createCommandList();
        commandList.setErrorCommand(new AbstractOnlineDestinationCommand(){

            public void execute() {
                OnlineDestinationSequence.this.log.log(10000, "OnlineDestinationSequence#errorCommand() an unknown error occured");
                OnlineDestinationSequence.this.application.getModelHandler().updateErrorStateModels(4);
                CommandList commandList = OnlineDestinationSequence.this.application.createCommandList();
                commandList.add(new StoreAddressListInNavigation(OnlineDestinationSequence.this.log, null));
                commandList.execute("OnlineDestinationSequence execute error command. empty list to navigation");
            }
        });
        commandList.add(new DownloadAddressListCommand(this.log, true, new DownloadAddressListCommand.IDownloadAddressListResultListener(){

            public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n3, int n2) {
                OnlineDestinationSequence.this.log.log(1000000, "OnlineDestinationSequence#downloadAddressListResult [import] importMode %1 length: %2", (long)n, (long)portalADBEntryArray.length);
                if (n3 == 1) {
                    if (portalADBEntryArray.length == 0) {
                        OnlineDestinationSequence.this.log.log(1000000, "OnlineDestinationModelUpdater#downloadAddressListResult(): no contacts available");
                        n3 = 5;
                    } else if (OnlineDestinationSequence.this.application.getNewDistinationsAvailablePopupId() != -1) {
                        OnlineDestinationSequence.this.application.getFramework().getHMIService().showPopup(OnlineDestinationSequence.this.application.getNewDistinationsAvailablePopupId());
                    }
                }
                OnlineDestinationSequence.this.application.getModelHandler().storePortalEntriesToImport(portalADBEntryArray);
            }
        }));
        commandList.add(new DownloadAddressListCommand(this.log, false, new DownloadAddressListCommand.IDownloadAddressListResultListener(){

            public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n3, int n2) {
                OnlineDestinationSequence.this.log.log(1000000, "OnlineDestinationSequence#downloadAddressListResult [allEntries]result: %3 importMode %1 length: %2", (long)n, (long)portalADBEntryArray.length, (long)n3);
                if (n3 == 1 && portalADBEntryArray.length == 0) {
                    OnlineDestinationSequence.this.log.log(1000000, "OnlineDestinationModelUpdater#downloadAddressListResult(): no contacts available");
                    n3 = 5;
                }
                OnlineDestinationSequence.this.application.getModelHandler().storeAllPortalEntries(portalADBEntryArray);
                OnlineDestinationSequence.this.application.getModelHandler().updateErrorStateModels(n3);
            }
        }));
        commandList.add(new StoreAddressListInNavigation(this.log, this));
        commandList.execute("OnlineDestinationSequence-startDestinationImport");
    }

    public void abortSearch() {
        CommandList commandList = this.application.createCommandList();
        commandList.add(new AbortDownloadCommand());
        commandList.execute("OnlineDestinationSequence-abort-Search-Command");
    }

    public void myAudiAdbImportResult(final long[] lArray, long[] lArray2) {
        CommandList commandList = this.application.createCommandList();
        commandList.add(new AbstractOnlineDestinationCommand(){

            public void execute() {
                this.getDSI().setADBImportStatus(lArray, 3002);
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new AbstractOnlineDestinationCommand(){

            public void execute() {
                this.getDSI().setADBImportStatus(lArray, 3004);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("OnlineDestinationSequence - setOnline");
    }
}

