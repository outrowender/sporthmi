/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public interface IMessagePropertyFactory {
    default public PropertyListCell create(MessageListEntry messageListEntry, MessageDetails messageDetails, AdbEntry adbEntry, boolean bl, boolean bl2) {
    }
}

