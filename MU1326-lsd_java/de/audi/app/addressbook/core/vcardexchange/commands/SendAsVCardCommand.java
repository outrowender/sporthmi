/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.commands;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.interapp.MessagingGateway;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;

public class SendAsVCardCommand
extends AbstractADBCommand {
    private long entryId;
    private MessagingGateway messaging;
    private HMIModelApp syncModel;
    private int msgType;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$vcardexchange$commands$SendAsVCardCommand;

    public SendAsVCardCommand(VCardExchangeADBHandler vCardExchangeADBHandler, long l, MessagingGateway messagingGateway, HMIModelApp hMIModelApp, int n) {
        super(vCardExchangeADBHandler);
        this.entryId = l;
        this.messaging = messagingGateway;
        this.syncModel = hMIModelApp;
        this.msgType = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SendAsVCardCommand#execute()");
        boolean bl = this.adbDSIAccess.createVCard(0, new long[]{this.entryId}, 0);
        if (!bl) {
            this.logger.log(10000, "SendAsVCardCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void createVCardResult(int n, long[] lArray, int n2, String string) {
        this.logger.log(-2137614336, "SendAsVCardCommand#createVCardResult(): success: %2, fullPathToVCards: %1", (Object)string, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.messaging.sendAsMessage(this.entryId, this.msgType, string);
            this.syncModel.setStatus(1);
        } else {
            this.syncModel.setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createSendAsVCardCommand(VCardExchangeADBHandler vCardExchangeADBHandler, long l, MessagingGateway messagingGateway, HMIModelApp hMIModelApp, int n) {
        hMIModelApp.setStatus(0);
        SendAsVCardCommand sendAsVCardCommand = new SendAsVCardCommand(vCardExchangeADBHandler, l, messagingGateway, hMIModelApp, n);
        CommandList commandList = new CommandList(vCardExchangeADBHandler.getCommandListManager());
        commandList.add(sendAsVCardCommand);
        commandList.execute((class$de$audi$app$addressbook$core$vcardexchange$commands$SendAsVCardCommand == null ? (class$de$audi$app$addressbook$core$vcardexchange$commands$SendAsVCardCommand = SendAsVCardCommand.class$("de.audi.app.addressbook.core.vcardexchange.commands.SendAsVCardCommand")) : class$de$audi$app$addressbook$core$vcardexchange$commands$SendAsVCardCommand).getName());
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

