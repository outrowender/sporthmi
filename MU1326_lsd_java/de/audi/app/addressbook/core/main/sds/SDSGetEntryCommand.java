/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class SDSGetEntryCommand
extends GetEntryCommand {
    private ADBSDSHandler sdsHandler;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$SDSGetEntryCommand;

    private SDSGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp, ADBSDSHandler aDBSDSHandler) {
        super(abstractAddressBookApplication, l, hMIModelApp);
        this.sdsHandler = aDBSDSHandler;
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(10000000, "SDSGetEntryCommand#getEntriesResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        super.getEntriesResult(n, adbEntryArray);
        String string = "";
        if (n == 0 && adbEntryArray != null && adbEntryArray.length > 0) {
            string = adbEntryArray[0].combinedName;
        }
        this.sdsHandler.openEntryDetailsResult(n == 0 ? 0 : 1, string);
    }

    public static void createSDSGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp, ADBSDSHandler aDBSDSHandler) {
        hMIModelApp.setStatus(0);
        SDSGetEntryCommand sDSGetEntryCommand = new SDSGetEntryCommand(abstractAddressBookApplication, l, hMIModelApp, aDBSDSHandler);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(sDSGetEntryCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$SDSGetEntryCommand == null ? (class$de$audi$app$addressbook$core$main$sds$SDSGetEntryCommand = SDSGetEntryCommand.class$("de.audi.app.addressbook.core.main.sds.SDSGetEntryCommand")) : class$de$audi$app$addressbook$core$main$sds$SDSGetEntryCommand).getName());
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

