/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public final class CombiAddSpellerCharsCommand
extends AbstractADBCommand {
    private ADBApplication appAdr;
    private String spellerChars;
    private int spellerHandle;
    private CombiBAPServiceAddressBook combiService;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$combi$bap$commands$CombiAddSpellerCharsCommand;

    private CombiAddSpellerCharsCommand(ADBApplication aDBApplication, String string, int n, CombiBAPServiceAddressBook combiBAPServiceAddressBook) {
        super(aDBApplication);
        this.appAdr = aDBApplication;
        this.spellerChars = string;
        this.spellerHandle = n;
        this.combiService = combiBAPServiceAddressBook;
    }

    public void execute() {
        this.logger.log(10000000, "CombiAddSpellerCharsCommand#execute()");
        boolean bl = this.appAdr.getADBDSIAccess().addSpellerChars(this.spellerHandle, this.spellerChars);
        if (!bl) {
            this.logger.log(10000000, "CombiAddSpellerCharsCommand#execute(): dsi call was not successful, finishing command.");
            this.combiService.pbSpellerResult(1, 0, 0);
            this.commandList.commandFinished();
        }
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(10000000, "CombiAddSpellerCharsCommand#spellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0 && dataSetArray != null) {
            if (dataSetArray.length == 0) {
                this.logger.log(10000000, "CombiAddSpellerCharsCommand#spellerResult(): dataSetList.length == 0");
                this.combiService.pbSpellerResult(0, n3, 0);
            } else {
                this.logger.log(10000000, "CombiAddSpellerCharsCommand#spellerResult(): totalHits: %2, dataSetList[1]: %2", (Object)dataSetArray[0], (long)n3);
                this.combiService.pbSpellerResult(0, n3, dataSetArray[0].entryPosition);
            }
        } else {
            this.combiService.pbSpellerResult(1, 0, 0);
        }
        boolean bl = this.appAdr.getADBDSIAccess().stopSpeller(n2);
        if (!bl) {
            this.logger.log(10000, "CombiAddSpellerCharsCommand#spellerResult(): dsi call for stopping the speller was NOT successful.");
            this.commandList.commandFinished();
        }
    }

    public void stopSpellerResult(int n, int n2) {
        this.logger.log(10000000, "CombiAddSpellerCharsCommand#stopSpellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createCombiAddSpellerCharsCommand(ADBApplication aDBApplication, String string, int n, CombiBAPServiceAddressBook combiBAPServiceAddressBook) {
        CombiAddSpellerCharsCommand combiAddSpellerCharsCommand = new CombiAddSpellerCharsCommand(aDBApplication, string, n, combiBAPServiceAddressBook);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(combiAddSpellerCharsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$combi$bap$commands$CombiAddSpellerCharsCommand == null ? (class$de$audi$app$addressbook$core$combi$bap$commands$CombiAddSpellerCharsCommand = CombiAddSpellerCharsCommand.class$("de.audi.app.addressbook.core.combi.bap.commands.CombiAddSpellerCharsCommand")) : class$de$audi$app$addressbook$core$combi$bap$commands$CombiAddSpellerCharsCommand).getName());
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

