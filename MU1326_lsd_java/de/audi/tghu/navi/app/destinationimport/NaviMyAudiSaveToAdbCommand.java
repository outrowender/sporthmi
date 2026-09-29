/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSaveToAdbCommand$IAdbImportListener;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviMyAudiSaveToAdbCommand
extends Command
implements ADBHMIAppServiceListener {
    private ADBHMIAppService adbHmiAppService;
    private NaviMyAudiSaveToAdbCommand$IAdbImportListener listener;
    private AdbEntry entry;

    public NaviMyAudiSaveToAdbCommand(LogChannel logChannel, AdbEntry adbEntry, ADBHMIAppService aDBHMIAppService, NaviMyAudiSaveToAdbCommand$IAdbImportListener naviMyAudiSaveToAdbCommand$IAdbImportListener) {
        super(logChannel);
        this.listener = naviMyAudiSaveToAdbCommand$IAdbImportListener;
        this.entry = adbEntry;
        this.adbHmiAppService = aDBHMIAppService;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "NaviMyAudiSaveToAdbCommand#responseInsertEntry execute");
        if (this.adbHmiAppService == null) {
            this.logger.log(1078071040, "NaviMyAudiSaveToAdbCommand#responseInsertEntry execute. adbHmiAppService is null. ignoring");
            this.getCommandList().commandFinished();
            return;
        }
        if (this.entry == null) {
            this.logger.log(1078071040, "NaviMyAudiSaveToAdbCommand#responseInsertEntry execute. Entry is null. ignoring");
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(1078071040, "NaviMyAudiSaveToAdbCommand#responseInsertEntry execute for entry [%1]%2", (Object)new Long(this.entry.getEntryId()), (Object)this.entry.getCombinedName());
        this.adbHmiAppService.requestInsertEntry(this.entry, this);
    }

    @Override
    public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
    }

    @Override
    public void responseInsertEntry(int n) {
        boolean bl;
        boolean bl2 = n == 0;
        boolean bl3 = n == 5 || n == 6;
        long l = this.entry.getEntryId();
        this.logger.log(1078071040, "NaviMyAudiSaveToAdbCommand#responseInsertEntry for contact: [%1]%2: %3", (Object)new Long(l), (Object)this.entry.getCombinedName(), (Object)new Boolean(bl2));
        boolean bl4 = bl = this.getCommandList().getPos() >= this.getCommandList().size() - 1;
        if (this.listener != null) {
            this.listener.adbImportResult(l, bl2, bl, bl3);
        }
        this.getCommandList().commandFinished();
    }
}

