/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.contactimport.ParseVCardCommand$Result;
import de.audi.app.messaging.core.messagingservice.AdbHmiAppServiceDefaultListener;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import org.dsi.ifc.organizer.AdbEntry;

public final class ParseVCardCommand
extends AbstractMessagingCommand
implements ADBHMIAppServiceListener {
    private final AdbHmiAppServiceDefaultListener adbHmiAppServiceDefaultListener;
    private final String vCardAttachmentPath;

    public ParseVCardCommand(AbstractMsgApplication abstractMsgApplication, ICommandCallback iCommandCallback, String string) {
        super(abstractMsgApplication);
        this.adbHmiAppServiceDefaultListener = abstractMsgApplication.getMessagingService().getAdbHmiAppServiceDefaultListener();
        this.setCommandCallback(iCommandCallback);
        this.vCardAttachmentPath = string;
    }

    @Override
    public void execute() {
        try {
            this.logger.log(1078071040, "[ParseVCardCommand#execute] vCardAttachmentPath = %1", (Object)this.vCardAttachmentPath);
            this.msgApp.getAdbHmiAppService().requestParseVCards(this.vCardAttachmentPath, this.msgApp.getMessagingService());
        }
        catch (Exception exception) {
            this.logException("[ParseVCardCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    @Override
    public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "[ParseVCardCommand#responseParseVCards]: success: %1, entries: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbg(adbEntryArray));
        this.setResult(new ParseVCardCommand$Result(this, n, adbEntryArray, null));
    }

    @Override
    public void responseInsertEntry(int n) {
        this.adbHmiAppServiceDefaultListener.responseInsertEntry(n);
    }
}

