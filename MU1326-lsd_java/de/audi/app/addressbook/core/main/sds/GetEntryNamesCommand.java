/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public class GetEntryNamesCommand
extends AbstractADBCommand {
    private long[] entryIDs;
    private ADBSDSHandler sdsHandler;
    private static final String[] RESULT_ERROR = new String[0];
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$GetEntryNamesCommand;

    public GetEntryNamesCommand(AbstractAddressBookApplication abstractAddressBookApplication, long[] lArray, ADBSDSHandler aDBSDSHandler) {
        super(abstractAddressBookApplication);
        this.entryIDs = lArray;
        this.sdsHandler = aDBSDSHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetEntryNamesCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntryDataSets(this.entryIDs, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetEntryNamesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
            this.sdsHandler.getEntryNamesResult(RESULT_ERROR);
        }
    }

    @Override
    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "GetEntryNamesCommand#getEntryDataSetsResult(): entryDataSetList: %1, success: %2", (Object)ADBDbgUtils.dbg(dataSetArray), (Object)ADBDbgUtils.dbgSuccessFlag(n));
        }
        if (n == 0 && dataSetArray != null && dataSetArray.length > 0) {
            String[] stringArray = new String[dataSetArray.length];
            block0: for (int i2 = 0; i2 < this.entryIDs.length; ++i2) {
                for (int i3 = 0; i3 < dataSetArray.length; ++i3) {
                    if (this.entryIDs[i2] != dataSetArray[i3].entryId) continue;
                    stringArray[i2] = dataSetArray[i3].generalDescription1;
                    continue block0;
                }
                this.logger.log(10000, "GetEntryNamesCommand#getEntryDataSetsResult(): entryID %1 could not be found in entryDataSetList!", this.entryIDs[i2]);
            }
            this.sdsHandler.getEntryNamesResult(stringArray);
        } else {
            this.sdsHandler.getEntryNamesResult(RESULT_ERROR);
        }
        this.commandList.commandFinished();
    }

    public static void createGetEntryNamesCommand(AbstractAddressBookApplication abstractAddressBookApplication, long[] lArray, ADBSDSHandler aDBSDSHandler) {
        GetEntryNamesCommand getEntryNamesCommand = new GetEntryNamesCommand(abstractAddressBookApplication, lArray, aDBSDSHandler);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(getEntryNamesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$GetEntryNamesCommand == null ? (class$de$audi$app$addressbook$core$main$sds$GetEntryNamesCommand = GetEntryNamesCommand.class$("de.audi.app.addressbook.core.main.sds.GetEntryNamesCommand")) : class$de$audi$app$addressbook$core$main$sds$GetEntryNamesCommand).getName());
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

