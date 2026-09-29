/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.drawer.DrawerOptions;
import de.audi.atip.hmi.model.PropertyListCell;
import java.util.ArrayList;
import org.dsi.ifc.messaging.ListEntry;

public final class EntryPropertyFactoryEvo
extends AbstractMessagingComponent
implements IEntryPropertyFactory {
    public EntryPropertyFactoryEvo(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public PropertyListCell create(ListEntry listEntry) {
        int n = this.msgApp.getFolderNavigator().getCurrentFolder().getHmiFolderType();
        int n2 = DrawerOptions.getCategory(listEntry);
        ArrayList arrayList = new ArrayList();
        DrawerOptions.tryAddPropertyFolderType(arrayList, n);
        DrawerOptions.tryAddPropertyAttachmentsAvailable(arrayList, null, listEntry.getMessageListEntry());
        return DrawerOptions.createPropertyListCell(n2, arrayList);
    }
}

