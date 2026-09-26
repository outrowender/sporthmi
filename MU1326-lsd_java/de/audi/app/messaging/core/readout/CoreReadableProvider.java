/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.readout.EppMarkup;
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.IReadableProvider;
import de.audi.app.messaging.core.readout.Readable;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import org.dsi.ifc.messaging.MessageDetails;

final class CoreReadableProvider
extends AbstractMessagingComponent
implements IReadableProvider {
    public CoreReadableProvider(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public IReadable getReadable() {
        Readable readable = null;
        try {
            MessageDetails messageDetails = this.msgApp.getSelectedMessage().getMessageDetails();
            if (messageDetails == null) {
                this.log.log(10000, "[CoreReadableProvider#getReadable] No message details available for readout.");
            } else if (!Messages.isSms(messageDetails) && !Messages.isEmail(messageDetails)) {
                this.log.log(10000, "[CoreReadableProvider#getReadable] Unsupported message type, messageDetails = %1.", (Object)messageDetails);
            } else {
                String string = EppMarkup.getText(messageDetails, false);
                if (Strings.isNullOrEmpty(string)) {
                    this.log.log(10000, "[CoreReadableProvider#getReadable] Empty text: messageSpeakTask = %1", (Object)string);
                } else {
                    readable = new Readable(string);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[CoreReadableProvider#getReadable]");
        }
        return readable;
    }
}

