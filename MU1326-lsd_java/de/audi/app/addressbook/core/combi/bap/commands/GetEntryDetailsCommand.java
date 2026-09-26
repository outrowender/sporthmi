/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap.commands;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetEntryDetailsCommand
extends AbstractADBCommand {
    private CombiADBHandler adbHandler;
    private long entryId;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$combi$bap$commands$GetEntryDetailsCommand;

    public GetEntryDetailsCommand(CombiADBHandler combiADBHandler, long l) {
        super(combiADBHandler);
        this.adbHandler = combiADBHandler;
        this.entryId = l;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetEntryDetailsCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryDetailsCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "GetEntryDetailsCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                int n2;
                this.logger.log(-2137614336, "GetEntryDetailsCommand#getEntriesResult(): got entry: %1", (Object)adbEntryArray[0]);
                int n3 = 0;
                for (n2 = 0; n2 < adbEntryArray[0].phoneData.length; ++n2) {
                    if (ADBUtils.isEmpty(adbEntryArray[0].phoneData[n2].number)) continue;
                    ++n3;
                }
                n2 = 0;
                CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray = new CombiBAPPhonebookEntryDetails[n3];
                for (int i2 = 0; i2 < adbEntryArray[0].phoneData.length; ++i2) {
                    if (ADBUtils.isEmpty(adbEntryArray[0].phoneData[i2].number)) continue;
                    combiBAPPhonebookEntryDetailsArray[n2] = new CombiBAPPhonebookEntryDetails(adbEntryArray[0].phoneData[i2].number, CombiADBUtils.getCombiPhoneType(adbEntryArray[0].phoneData[i2].numberType));
                    ++n2;
                }
                this.adbHandler.getCombiService().responsePhonebookEntryDetails(this.entryId, combiBAPPhonebookEntryDetailsArray);
            } else {
                this.logger.log(10000, "GetEntryDetailsCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
            }
        }
        this.commandList.commandFinished();
    }

    public static void createGetEntryDetailsCommand(CombiADBHandler combiADBHandler, long l) {
        GetEntryDetailsCommand getEntryDetailsCommand = new GetEntryDetailsCommand(combiADBHandler, l);
        CommandList commandList = new CommandList(combiADBHandler.getCommandListManager());
        commandList.add(getEntryDetailsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$combi$bap$commands$GetEntryDetailsCommand == null ? (class$de$audi$app$addressbook$core$combi$bap$commands$GetEntryDetailsCommand = GetEntryDetailsCommand.class$("de.audi.app.addressbook.core.combi.bap.commands.GetEntryDetailsCommand")) : class$de$audi$app$addressbook$core$combi$bap$commands$GetEntryDetailsCommand).getName());
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

