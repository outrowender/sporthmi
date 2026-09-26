/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.viewmessage.IMessagePropertyFactory;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public final class IMessagePropertyFactory$NullFactory
implements IMessagePropertyFactory {
    @Override
    public PropertyListCell create(MessageListEntry messageListEntry, MessageDetails messageDetails, AdbEntry adbEntry, boolean bl, boolean bl2) {
        return PropertyListCell.EMPTY_CELL;
    }
}

