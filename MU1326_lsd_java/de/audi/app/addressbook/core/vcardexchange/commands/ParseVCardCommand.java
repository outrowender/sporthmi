/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public final class ParseVCardCommand
extends AbstractADBCommand {
    private final String fullPathToVCards;
    private final ADBHMIAppServiceListener adbHmiAppServiceListener;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$vcardexchange$commands$ParseVCardCommand;

    private ParseVCardCommand(VCardExchangeADBHandler vCardExchangeADBHandler, String string, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        super(vCardExchangeADBHandler);
        this.fullPathToVCards = string;
        this.adbHmiAppServiceListener = aDBHMIAppServiceListener;
    }

    public void execute() {
        this.logger.log(10000000, "ParseVCardCommand#execute()");
        boolean bl = this.adbDSIAccess.parseVCard(this.fullPathToVCards);
        if (!bl) {
            this.logger.log(10000, "ParseVCardCommand#execute(): DSI call was not successful, finishing command.");
            this.adbHmiAppServiceListener.responseParseVCards(1, new AdbEntry[0]);
            this.commandList.commandFinished();
        }
    }

    public void parseVCardResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(10000000, "ParseVCardCommand#parseVCardResult(): success: %1, entries: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbg(adbEntryArray));
        this.adbHmiAppServiceListener.responseParseVCards(n, adbEntryArray);
        this.commandList.commandFinished();
    }

    public static void createParseVCardCommand(VCardExchangeADBHandler vCardExchangeADBHandler, String string, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
        ParseVCardCommand parseVCardCommand = new ParseVCardCommand(vCardExchangeADBHandler, string, aDBHMIAppServiceListener);
        CommandList commandList = new CommandList(vCardExchangeADBHandler.getCommandListManager());
        commandList.add(parseVCardCommand);
        commandList.execute((class$de$audi$app$addressbook$core$vcardexchange$commands$ParseVCardCommand == null ? (class$de$audi$app$addressbook$core$vcardexchange$commands$ParseVCardCommand = ParseVCardCommand.class$("de.audi.app.addressbook.core.vcardexchange.commands.ParseVCardCommand")) : class$de$audi$app$addressbook$core$vcardexchange$commands$ParseVCardCommand).getName());
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

