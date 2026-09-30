/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;

public final class DsiMessagingMappings {
    public static ListEntry[] mmsToSms(LogChannel logChannel, ListEntry[] listEntryArray) {
        if (listEntryArray != null) {
            ArrayList arrayList = new ArrayList(listEntryArray.length);
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                ListEntry listEntry = listEntryArray[i2];
                MessageListEntry messageListEntry = listEntry.getMessageListEntry();
                if (!ListEntries.isMessage(listEntry) || messageListEntry.getType() != 5) continue;
                messageListEntry.type = 1;
                arrayList.add(messageListEntry.getMessageID());
            }
            if (logChannel != null && logChannel.isInfo() && !arrayList.isEmpty()) {
                logChannel.log(1000000, "[DsiMessagingMappings#mmsToSms] Mapped MessageListEntry instances from MMS to SMS, list of affected message IDs: %1", (Object)Collections.toString(arrayList));
            }
        }
        return listEntryArray;
    }

    public static MessageDetails mmsToSms(LogChannel logChannel, MessageDetails messageDetails) {
        if (messageDetails != null && messageDetails.getType() == 5) {
            messageDetails.type = 1;
            if (logChannel != null && logChannel.isInfo()) {
                logChannel.log(1000000, "[DsiMessagingMappings#mmsToSms] Mapped MessageDetails instance from MMS to SMS, affected message ID: %1", (Object)messageDetails.getMessageID());
            }
        }
        return messageDetails;
    }
}

