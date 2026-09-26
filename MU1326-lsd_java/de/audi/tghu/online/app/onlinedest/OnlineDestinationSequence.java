/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.interapp.NaviMyAudiImport$IMyAudiImportResultListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence$1;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence$2;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence$3;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence$4;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence$5;
import de.audi.tghu.online.app.onlinedest.commands.AbortDownloadCommand;
import de.audi.tghu.online.app.onlinedest.commands.DownloadAddressListCommand;
import de.audi.tghu.online.app.onlinedest.commands.StoreAddressListInNavigation;
import de.audi.tghu.online.app.onlinedest.commands.UpdateSdsServiceCommand;

public class OnlineDestinationSequence
implements NaviMyAudiImport$IMyAudiImportResultListener {
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

    public void startDestinationImport(int n) {
        this.log.log(1078071040, "OnlineDestinationSequence#startDestinationImport() importMode:%1", (long)n);
        CommandList commandList = this.application.createCommandList();
        commandList.setErrorCommand(new OnlineDestinationSequence$1(this));
        commandList.add(new DownloadAddressListCommand(this.log, true, new OnlineDestinationSequence$2(this, n)));
        commandList.add(new DownloadAddressListCommand(this.log, false, new OnlineDestinationSequence$3(this, n)));
        commandList.add(new StoreAddressListInNavigation(this.log, this));
        commandList.execute("OnlineDestinationSequence-startDestinationImport");
    }

    public void abortSearch() {
        CommandList commandList = this.application.createCommandList();
        commandList.add(new AbortDownloadCommand());
        commandList.execute("OnlineDestinationSequence-abort-Search-Command");
    }

    @Override
    public void myAudiAdbImportResult(long[] lArray, long[] lArray2) {
        CommandList commandList = this.application.createCommandList();
        commandList.add(new OnlineDestinationSequence$4(this, lArray));
        commandList.add(new OnlineDestinationSequence$5(this, lArray));
        commandList.execute("OnlineDestinationSequence - setOnline");
    }
}

