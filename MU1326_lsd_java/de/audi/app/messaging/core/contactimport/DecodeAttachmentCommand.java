/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.contactimport.DecodeAttachmentCommand$Result;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;

public final class DecodeAttachmentCommand
extends AbstractDsiMessagingCommand {
    private final AttachmentInformation attachmentInformation;

    public DecodeAttachmentCommand(AbstractMsgApplication abstractMsgApplication, ICommandCallback iCommandCallback, AttachmentInformation attachmentInformation) {
        super(abstractMsgApplication);
        this.setCommandCallback(iCommandCallback);
        this.attachmentInformation = attachmentInformation;
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[DecodeAttachmentCommand#execute]");
            this.dsiMessagingAccess.decodeAttachmentRequest(this.attachmentInformation);
        }
        catch (Exception exception) {
            this.logException("[DecodeAttachmentCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[DecodeAttachmentCommand#decodeAttachmentResponse] result = %1, resourceLocator = %2", (Object)String.valueOf(n), (Object)String.valueOf(resourceLocator));
        }
        this.setResult(new DecodeAttachmentCommand$Result(this, n, resourceLocator, null));
    }
}

