/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetEntryCommand
extends AbstractGetEntryCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand;

    public GetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        super(abstractAddressBookApplication, l, hMIModelApp);
    }

    public GetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        super(abstractAddressBookApplication, l);
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        this.logger.log(1000000, "GetEntryCommand#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        return true;
    }

    public static void createGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, HMIModelApp hMIModelApp) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetEntryCommand(abstractAddressBookApplication, l, hMIModelApp));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand = GetEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand).getName());
    }

    public static void createGetEntryCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetEntryCommand(abstractAddressBookApplication, l));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand = GetEntryCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetEntryCommand).getName());
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

