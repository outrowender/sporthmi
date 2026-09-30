/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap.commands;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public class GetPhonebookListElementsCommand
extends AbstractADBCommand {
    private CombiADBHandler adbHandler;
    private int startPos;
    private int numberOfElements;
    private int taID;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$combi$bap$commands$GetPhonebookListElementsCommand;

    public GetPhonebookListElementsCommand(CombiADBHandler combiADBHandler, int n, int n2, int n3) {
        super(combiADBHandler);
        this.adbHandler = combiADBHandler;
        this.startPos = n;
        this.numberOfElements = n2;
        this.taID = n3;
    }

    public void execute() {
        this.logger.log(10000000, "GetPhonebookListElementsCommand#execute()");
        boolean bl = this.adbDSIAccess.getViewWindow(this.startPos, 6, 1, this.numberOfElements);
        if (!bl) {
            this.logger.log(10000, "GetPhonebookListElementsCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "GetPhonebookListElementsCommand#getViewWindowResult(): dataSetList: %1, success: %2; totalEntries: %3", (Object)dataSetArray, (Object)ADBDbgUtils.dbgSuccessFlag(n), (long)n2);
            this.logger.log(10000000, "GetPhonebookListElementsCommand#getViewWindowResult(): dataSetList: %1", (Object)ADBDbgUtils.dbg(dataSetArray));
        }
        if (n == 0) {
            CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray = new CombiBAPPhonebookEntry[dataSetArray.length];
            for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                boolean bl = dataSetArray[i2].contactPicture != null;
                combiBAPPhonebookEntryArray[i2] = new CombiBAPPhonebookEntry(dataSetArray[i2].entryId, dataSetArray[i2].entryPosition, dataSetArray[i2].generalDescription1, CombiADBUtils.getCombiStorageType(dataSetArray[i2].entryType), dataSetArray[i2].phoneCount, bl ? dataSetArray[i2].contactPicture.url : null, bl ? dataSetArray[i2].contactPicture.id : -1);
            }
            this.adbHandler.getCombiService().responsePhonebookListElements(combiBAPPhonebookEntryArray, this.taID);
        } else {
            this.adbHandler.getCombiService().responsePhonebookListElements(new CombiBAPPhonebookEntry[0], this.taID);
        }
        this.commandList.commandFinished();
    }

    public static void createGetPhonebookListElementsCommand(CombiADBHandler combiADBHandler, int n, int n2, int n3) {
        GetPhonebookListElementsCommand getPhonebookListElementsCommand = new GetPhonebookListElementsCommand(combiADBHandler, n, n2, n3);
        CommandList commandList = new CommandList(combiADBHandler.getCommandListManager());
        commandList.add(getPhonebookListElementsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$combi$bap$commands$GetPhonebookListElementsCommand == null ? (class$de$audi$app$addressbook$core$combi$bap$commands$GetPhonebookListElementsCommand = GetPhonebookListElementsCommand.class$("de.audi.app.addressbook.core.combi.bap.commands.GetPhonebookListElementsCommand")) : class$de$audi$app$addressbook$core$combi$bap$commands$GetPhonebookListElementsCommand).getName());
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

