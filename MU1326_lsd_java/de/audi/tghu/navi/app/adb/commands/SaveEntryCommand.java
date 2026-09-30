/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb.commands;

import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.organizer.AdbEntry;

public class SaveEntryCommand
extends AbstractADBCommand {
    private AdbEntry entry;
    private int profileNum;
    private NavCommand navCommand;

    protected SaveEntryCommand(NaviADBHandler naviADBHandler, AdbEntry adbEntry, int n, NavCommand navCommand) {
        super(naviADBHandler);
        this.entry = adbEntry;
        this.profileNum = n;
        this.navCommand = navCommand;
    }

    public void execute() {
        this.logger.log(10000000, "AbstractSaveEntryCommand#execute() entry : %1", (Object)this.entry);
        boolean bl = false;
        if (this.entry.entryId == 0L) {
            this.logger.log(1000000, "AbstractSaveEntryCommand#execute() insert entry : %1 , profileNum : %2", (Object)this.entry, (long)this.profileNum);
            bl = this.adbDSIAccess.insertEntry(this.entry, this.profileNum);
        } else {
            this.logger.log(1000000, "AbstractSaveEntryCommand#execute() change entry : %1, profileNum : %2", (Object)this.entry, (long)this.profileNum);
            bl = this.adbDSIAccess.changeEntry(this.entry, this.profileNum);
        }
        if (!bl) {
            this.logger.log(10000, "AbstractSaveEntryCommand#execute(): dsi call was not successful, finishing command.");
        }
        this.commandList.commandFinished();
        if (this.navCommand != null) {
            this.navCommand.getCommandList().commandFinished();
        }
    }

    public final void insertEntryResult(int n, AdbEntry adbEntry) {
        if (n != 0) {
            this.logger.log(10000, "AbstractSaveEntryCommand#insertEntryResult(): insert entry not successful, success: %1", (long)n);
        }
    }

    public final void changeEntryResult(int n, AdbEntry adbEntry) {
        if (n != 0) {
            this.logger.log(10000, "AbstractSaveEntryCommand#changeEntryResult(): change entry not successful, success: %1", (long)n);
        }
    }

    protected static int getProfileForSavingEntry(AdbEntry adbEntry, NaviADBHandler naviADBHandler) {
        return adbEntry.entryType == 4 ? 0 : naviADBHandler.getAdbStateHandler().getActiveProfile();
    }

    public static void createSaveEntryCommand(NaviADBHandler naviADBHandler, AdbEntry adbEntry, NavCommand navCommand) {
        SaveEntryCommand saveEntryCommand = new SaveEntryCommand(naviADBHandler, adbEntry, SaveEntryCommand.getProfileForSavingEntry(adbEntry, naviADBHandler), navCommand);
        CommandList commandList = new CommandList(naviADBHandler.getCommandListManager());
        commandList.add(saveEntryCommand);
        commandList.execute("Save Entry to AddressBook");
    }
}

