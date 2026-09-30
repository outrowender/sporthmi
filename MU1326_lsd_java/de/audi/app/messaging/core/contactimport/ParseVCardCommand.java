/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.commands.ICommandCallback;
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

    public void execute() {
        try {
            this.logger.log(1000000, "[ParseVCardCommand#execute] vCardAttachmentPath = %1", (Object)this.vCardAttachmentPath);
            this.msgApp.getAdbHmiAppService().requestParseVCards(this.vCardAttachmentPath, this.msgApp.getMessagingService());
        }
        catch (Exception exception) {
            this.logException("[ParseVCardCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(10000000, "[ParseVCardCommand#responseParseVCards]: success: %1, entries: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (Object)ADBDbgUtils.dbg(adbEntryArray));
        this.setResult(new Result(n, adbEntryArray));
    }

    public void responseInsertEntry(int n) {
        this.adbHmiAppServiceDefaultListener.responseInsertEntry(n);
    }

    public final class Result {
        private final int resultCode;
        private final AdbEntry[] entries;

        private Result(int n, AdbEntry[] adbEntryArray) {
            this.resultCode = n;
            this.entries = adbEntryArray;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public AdbEntry[] getEntries() {
            return this.entries;
        }
    }
}

