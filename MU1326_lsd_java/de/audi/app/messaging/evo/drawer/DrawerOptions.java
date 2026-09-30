/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.drawer;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.util.Util;
import java.util.Collection;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public final class DrawerOptions {
    public static final int CATEGORY_NONE = 0;
    public static final int PROPERTY_NONE = 0;

    public static int getCategory(ListEntry listEntry) {
        int n = 0;
        n = ListEntries.isFolder(listEntry) ? -705043314 : DrawerOptions.getCategory(listEntry.getMessageListEntry());
        return n;
    }

    public static int getCategory(MessageListEntry messageListEntry) {
        boolean bl;
        int n = 0;
        boolean bl2 = messageListEntry.getType() == 1;
        boolean bl3 = bl = messageListEntry.getType() == 2;
        if (bl2) {
            n = -25252172;
        } else if (bl) {
            n = -1959818898;
        }
        return n;
    }

    public static void tryAddPropertyPhoneNumbersAvailable(Collection collection, MessageListEntry messageListEntry, AdbEntry adbEntry) {
        boolean bl = false;
        if (messageListEntry.getType() == 1) {
            String string = messageListEntry.getMatchedAddress().getAddress();
            bl = !Strings.isNullOrEmpty(string);
        } else {
            boolean bl2 = bl = ADBUtils.countPhoneNumbers(adbEntry) > 0;
        }
        if (bl) {
            collection.add(Util.createInteger(2070395121));
        }
    }

    public static void tryAddPropertyFolderType(Collection collection, int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 25539472;
                break;
            }
            case 3: {
                n2 = -1408914058;
                break;
            }
            case 4: {
                n2 = -1341359564;
                break;
            }
            case 5: {
                n2 = 312818803;
                break;
            }
            case 1: {
                n2 = 990153224;
                break;
            }
            case 6: {
                n2 = 1989006837;
                break;
            }
            case 7: {
                n2 = 1456061872;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (n2 != 0) {
            collection.add(Util.createInteger(n2));
        }
    }

    public static void tryAddPropertyNavLocAvailable(Collection collection, AdbEntry adbEntry) {
        if (ADBAddressUtils.hasNavLocation(adbEntry)) {
            collection.add(Util.createInteger(499923312));
        }
    }

    public static void tryAddPropertyAttachmentsAvailable(Collection collection, MessageDetails messageDetails, MessageListEntry messageListEntry) {
        if (messageListEntry != null && messageListEntry.attachmentSize > 0) {
            collection.add(Util.createInteger(582254409));
        }
        if (messageDetails != null) {
            AttachmentInformation[] attachmentInformationArray = messageDetails.getAttachments();
            boolean bl = false;
            if (attachmentInformationArray != null && attachmentInformationArray.length > 0) {
                for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
                    if (!AttachmentUtil.isVCardAttachment(attachmentInformationArray[i2])) continue;
                    bl = true;
                }
                if (bl) {
                    collection.add(Util.createInteger(1888106672));
                }
            }
        }
    }

    public static void tryAddPropertyTtsReadable(Collection collection, int n) {
        collection.add(Util.createInteger(1883863251));
    }

    public static void tryAddPropertyExtractedPhoneNumbersAvailable(Collection collection, boolean bl) {
        if (bl) {
            collection.add(Util.createInteger(-1803623840));
        }
    }

    public static void tryAddPropertyExtractedEmailAddressesAvailable(Collection collection, boolean bl) {
        if (bl) {
            collection.add(Util.createInteger(-9880764));
        }
    }

    public static PropertyListCell createPropertyListCell(int n, Collection collection) {
        int[] nArray = Collections.toPrimitiveArray(collection);
        return PropertyListCell.create(n, nArray);
    }
}

