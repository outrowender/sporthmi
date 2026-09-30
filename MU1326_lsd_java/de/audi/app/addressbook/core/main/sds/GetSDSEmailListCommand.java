/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;

public class GetSDSEmailListCommand
extends AbstractADBCommand {
    private AbstractAddressBookApplication appAdr;
    private long entryId;
    private ADBSDSHandler sdsHandler;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$GetSDSEmailListCommand;

    public GetSDSEmailListCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.entryId = l;
        this.sdsHandler = aDBSDSHandler;
    }

    public void execute() {
        this.logger.log(10000000, "GetSDSEmailListCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetSDSEmailListCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
            this.sdsHandler.fillEmailListResult(1, "", null, 0);
        }
    }

    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(10000000, "GetSDSEmailListCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                this.logger.log(10000000, "GetSDSEmailListCommand#getEntriesResult(): got entry: %1", (Object)adbEntryArray[0]);
                ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.appAdr.getFramework());
                this.appAdr.getHMIService().getLabelModel(700493).setText(adbEntryArray[0].combinedName);
                AbstractADBEntryDetailsListRowBuilder.fillEmailList(adbEntryArray[0], this.appAdr.getHMIService().getBaseListModel(4276), this.sdsHandler.getRowBuilder());
                ResourceLocator resourceLocator = adbEntryArray[0].personalData != null ? adbEntryArray[0].personalData.contactPicture : null;
                int n2 = ADBUtils.countEmailAddresses(adbEntryArray[0]);
                this.sdsHandler.fillEmailListResult(0, adbEntryArray[0].combinedName, resourceLocator, n2);
            } else {
                this.logger.log(10000, "GetSDSEmailListCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
                this.sdsHandler.fillEmailListResult(1, "", null, 0);
            }
        } else {
            this.sdsHandler.fillEmailListResult(1, "", null, 0);
        }
        this.commandList.commandFinished();
    }

    public static void createGetSDSEmailListCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler) {
        GetSDSEmailListCommand getSDSEmailListCommand = new GetSDSEmailListCommand(abstractAddressBookApplication, l, aDBSDSHandler);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(getSDSEmailListCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$GetSDSEmailListCommand == null ? (class$de$audi$app$addressbook$core$main$sds$GetSDSEmailListCommand = GetSDSEmailListCommand.class$("de.audi.app.addressbook.core.main.sds.GetSDSEmailListCommand")) : class$de$audi$app$addressbook$core$main$sds$GetSDSEmailListCommand).getName());
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

