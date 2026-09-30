/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public interface IMessagePropertyFactory {
    public PropertyListCell create(MessageListEntry var1, MessageDetails var2, AdbEntry var3, boolean var4, boolean var5);

    public static final class NullFactory
    implements IMessagePropertyFactory {
        public PropertyListCell create(MessageListEntry messageListEntry, MessageDetails messageDetails, AdbEntry adbEntry, boolean bl, boolean bl2) {
            return PropertyListCell.EMPTY_CELL;
        }
    }
}

