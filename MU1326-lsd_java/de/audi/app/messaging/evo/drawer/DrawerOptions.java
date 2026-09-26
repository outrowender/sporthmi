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
    public static final int CATEGORY_NONE;
    public static final int PROPERTY_NONE;

    public static int getCategory(ListEntry listEntry) {
        int n = 0;
        n = ListEntries.isFolder(listEntry) ? -1897596459 : DrawerOptions.getCategory(listEntry.getMessageListEntry());
        return n;
    }

    public static int getCategory(MessageListEntry messageListEntry) {
        boolean bl;
        int n = 0;
        boolean bl2 = messageListEntry.getType() == 1;
        boolean bl3 = bl = messageListEntry.getType() == 2;
        if (bl2) {
            n = -1263632642;
        } else if (bl) {
            n = 1854484363;
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
            collection.add(Util.createInteger(-239573125));
        }
    }

    public static void tryAddPropertyFolderType(Collection collection, int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = -1867283199;
                break;
            }
            case 3: {
                n2 = 1991050668;
                break;
            }
            case 4: {
                n2 = 880413872;
                break;
            }
            case 5: {
                n2 = 1933354258;
                break;
            }
            case 1: {
                n2 = 143262779;
                break;
            }
            case 6: {
                n2 = -170553994;
                break;
            }
            case 7: {
                n2 = -1329739434;
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
            collection.add(Util.createInteger(1882835997));
        }
    }

    public static void tryAddPropertyAttachmentsAvailable(Collection collection, MessageDetails messageDetails, MessageListEntry messageListEntry) {
        if (messageListEntry != null && messageListEntry.attachmentSize > 0) {
            collection.add(Util.createInteger(1233105954));
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
                    collection.add(Util.createInteger(-1338471824));
                }
            }
        }
    }

    public static void tryAddPropertyTtsReadable(Collection collection, int n) {
        collection.add(Util.createInteger(-747091600));
    }

    public static void tryAddPropertyExtractedPhoneNumbersAvailable(Collection collection, boolean bl) {
        if (bl) {
            collection.add(Util.createInteger(1625456276));
        }
    }

    public static void tryAddPropertyExtractedEmailAddressesAvailable(Collection collection, boolean bl) {
        if (bl) {
            collection.add(Util.createInteger(1144744447));
        }
    }

    public static PropertyListCell createPropertyListCell(int n, Collection collection) {
        int[] nArray = Collections.toPrimitiveArray(collection);
        return PropertyListCell.create(n, nArray);
    }
}

