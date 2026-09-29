/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap.commands;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public class GetCombiViewSizeCommand
extends AbstractADBCommand {
    private CombiADBHandler adbHandler;
    private boolean sendPhonebookChanged;
    private boolean sortOrderChanged;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand;

    public GetCombiViewSizeCommand(CombiADBHandler combiADBHandler, boolean bl, boolean bl2) {
        super(combiADBHandler);
        this.adbHandler = combiADBHandler;
        this.sendPhonebookChanged = bl;
        this.sortOrderChanged = bl2;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "GetCombiViewSizeCommand#execute()");
        boolean bl = this.adbDSIAccess.getViewWindow(0L, 4, 1, 1);
        if (!bl) {
            this.logger.log(10000, "GetCombiViewSizeCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.logger.log(1078071040, "GetCombiViewSizeCommand#getViewWindowResult(): success: %1, totalEntries: %2, sendPhonebookChanged:%3 ", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)Integer.toString(n2), (Object)Boolean.toString(this.sendPhonebookChanged));
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "GetCombiViewSizeCommand#getViewWindowResult(): dataSetList: %1, success: %2; totalEntries: %3", (Object)dataSetArray, (Object)ADBDbgUtils.dbgSuccessFlag(n), (long)n2);
            this.logger.log(-2137614336, "GetCombiViewSizeCommand#getViewWindowResult(): dataSetList: %1", (Object)ADBDbgUtils.dbg(dataSetArray));
        }
        if (n == 0) {
            int n3 = this.adbHandler.getStateHandler().getEntryCount();
            if (this.sendPhonebookChanged && (n3 != n2 || this.sortOrderChanged)) {
                this.adbHandler.getStateHandler().setEntryCount(n2);
                this.adbHandler.getCombiService().phonebookChanged(n2);
            } else if (this.adbHandler.getStateHandler().computePbState() == 1) {
                this.adbHandler.getCombiService().updatePbState(1, n2);
                this.adbHandler.getCombiService().phonebookChanged(n2);
            }
        }
        this.commandList.commandFinished();
    }

    public static void createGetCombiViewSizeCommand(CombiADBHandler combiADBHandler, boolean bl, boolean bl2) {
        GetCombiViewSizeCommand getCombiViewSizeCommand = new GetCombiViewSizeCommand(combiADBHandler, bl, bl2);
        CommandList commandList = new CommandList(combiADBHandler.getCommandListManager());
        commandList.add(getCombiViewSizeCommand);
        commandList.execute((class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand == null ? (class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand = GetCombiViewSizeCommand.class$("de.audi.app.addressbook.core.combi.bap.commands.GetCombiViewSizeCommand")) : class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand).getName());
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

