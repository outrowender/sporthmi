/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.edit.AbstractSaveEntryCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class SaveEntryCommand
extends AbstractSaveEntryCommand {
    private AbstractAddressBookApplication appAdr;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand;

    public SaveEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n) {
        super(abstractAddressBookApplication, adbEntry, n, abstractAddressBookApplication.getHMIService().getModelApp(700497));
        this.appAdr = abstractAddressBookApplication;
    }

    public void handleInsertEntryResult(int n, AdbEntry adbEntry) {
        this.logger.log(1000000, "SaveEntryCommand#handleInsertEntryResult(): adbEntry: %1, success: %2", (Object)adbEntry, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.appAdr.setFocusedEntryId(adbEntry.entryId);
            this.appAdr.setFocusedEntryType(adbEntry.entryType);
            this.appAdr.setCurrentEntry(adbEntry);
            this.appAdr.getSelectedEntryDetails().updateEntryDetails(adbEntry);
            this.appAdr.getADBOrganizerSearch().refreshByEntryId(adbEntry.entryId);
        }
    }

    public void handleChangeEntryResult(int n, AdbEntry adbEntry) {
        this.logger.log(1000000, "SaveEntryCommand#handleChangeEntryResult(): adbEntry: %1, success: %2", (Object)adbEntry, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.appAdr.setCurrentEntry(adbEntry);
            this.appAdr.getSelectedEntryDetails().updateEntryDetails(adbEntry);
            this.appAdr.getADBOrganizerSearch().refresh();
        }
    }

    protected static int getProfileForSavingEntry(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry) {
        return adbEntry.entryType == 4 ? 0 : abstractAddressBookApplication.getAdbStateHandler().getActiveProfile();
    }

    public static void createSaveEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication) {
        SaveEntryCommand.createSaveEntryCommand(abstractAddressBookApplication, abstractAddressBookApplication.getCurrentEntry());
    }

    public static void createSaveEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry) {
        SaveEntryCommand saveEntryCommand = new SaveEntryCommand(abstractAddressBookApplication, adbEntry, SaveEntryCommand.getProfileForSavingEntry(abstractAddressBookApplication, adbEntry));
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(saveEntryCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand = SaveEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.SaveEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$SaveEntryCommand).getName());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

