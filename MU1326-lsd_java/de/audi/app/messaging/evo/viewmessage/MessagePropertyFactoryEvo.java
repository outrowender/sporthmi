/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.viewmessage;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.viewmessage.IMessagePropertyFactory;
import de.audi.app.messaging.evo.drawer.DrawerOptions;
import de.audi.atip.hmi.model.PropertyListCell;
import java.util.ArrayList;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public final class MessagePropertyFactoryEvo
extends AbstractMessagingComponent
implements IMessagePropertyFactory {
    public MessagePropertyFactoryEvo(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public PropertyListCell create(MessageListEntry messageListEntry, MessageDetails messageDetails, AdbEntry adbEntry, boolean bl, boolean bl2) {
        int n = this.msgApp.getFolderNavigator().getCurrentFolder().getHmiFolderType();
        int n2 = DrawerOptions.getCategory(messageListEntry);
        ArrayList arrayList = new ArrayList();
        DrawerOptions.tryAddPropertyFolderType(arrayList, n);
        DrawerOptions.tryAddPropertyPhoneNumbersAvailable(arrayList, messageListEntry, adbEntry);
        DrawerOptions.tryAddPropertyAttachmentsAvailable(arrayList, messageDetails, messageListEntry);
        DrawerOptions.tryAddPropertyNavLocAvailable(arrayList, adbEntry);
        DrawerOptions.tryAddPropertyTtsReadable(arrayList, n);
        DrawerOptions.tryAddPropertyExtractedPhoneNumbersAvailable(arrayList, bl);
        DrawerOptions.tryAddPropertyExtractedEmailAddressesAvailable(arrayList, bl2);
        return DrawerOptions.createPropertyListCell(n2, arrayList);
    }
}

