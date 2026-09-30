/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap.commands;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.combi.bap.commands.CombiAddSpellerCharsCommand;
import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public final class CombiStartSpellerCommand
extends AbstractADBCommand {
    private String spellerChars;
    private CombiBAPServiceAddressBook combiService;
    private ADBApplication appAdr;
    private int searchMode;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$combi$bap$commands$CombiStartSpellerCommand;

    private CombiStartSpellerCommand(ADBApplication aDBApplication, String string, CombiBAPServiceAddressBook combiBAPServiceAddressBook, int n) {
        super(aDBApplication);
        this.appAdr = aDBApplication;
        this.spellerChars = string;
        this.combiService = combiBAPServiceAddressBook;
        this.searchMode = n;
    }

    public void execute() {
        this.logger.log(10000000, "CombiStartSpellerCommand#execute()");
        boolean bl = this.adbDSIAccess.startSpeller(1, 1, this.searchMode);
        if (!bl) {
            this.logger.log(10000, "CombiStartSpellerCommand#execute(): dsi call was not successful, finishing command.");
            this.combiService.pbSpellerResult(1, 0, 0);
            this.commandList.commandFinished();
        }
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(10000000, "CombiStartSpellerCommand#spellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            CombiAddSpellerCharsCommand.createCombiAddSpellerCharsCommand(this.appAdr, this.spellerChars, n2, this.combiService);
        } else {
            this.combiService.pbSpellerResult(1, 0, 0);
        }
        this.commandList.commandFinished();
    }

    public static void createCombiStartSpellerCommand(CombiADBHandler combiADBHandler, String string, CombiBAPServiceAddressBook combiBAPServiceAddressBook, int n) {
        CombiStartSpellerCommand combiStartSpellerCommand = new CombiStartSpellerCommand(combiADBHandler, string, combiBAPServiceAddressBook, n);
        CommandList commandList = new CommandList(combiADBHandler.getCommandListManager());
        commandList.add(combiStartSpellerCommand);
        commandList.execute((class$de$audi$app$addressbook$core$combi$bap$commands$CombiStartSpellerCommand == null ? (class$de$audi$app$addressbook$core$combi$bap$commands$CombiStartSpellerCommand = CombiStartSpellerCommand.class$("de.audi.app.addressbook.core.combi.bap.commands.CombiStartSpellerCommand")) : class$de$audi$app$addressbook$core$combi$bap$commands$CombiStartSpellerCommand).getName());
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

