/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import de.audi.app.messaging.core.util.Strings;
import org.dsi.ifc.messaging.AttachmentInformation;

public final class AttachmentUtil {
    private static final String MIME_TYPE_VCARD;
    private static final String MIME_TYPE_X_VCARD;
    private static final String VCARD_SUFFIX;

    public static boolean isVCardAttachment(AttachmentInformation attachmentInformation) {
        String string = attachmentInformation.getMimeType();
        boolean bl = false;
        if (!Strings.isNullOrEmpty(attachmentInformation.getName())) {
            bl = attachmentInformation.getName().endsWith(".vcf");
        }
        return "text/vcard".equals(string) || "text/x-vcard".equals(string) || bl;
    }

    public static boolean isSupportedAttachment(AttachmentInformation attachmentInformation) {
        return AttachmentUtil.isVCardAttachment(attachmentInformation);
    }

    public static AttachmentInformation[] getDownloadedAttachments(AttachmentInformation[] attachmentInformationArray) {
        AttachmentInformation[] attachmentInformationArray2;
        int n;
        int n2 = 0;
        for (n = 0; n < attachmentInformationArray.length; ++n) {
            if (!AttachmentUtil.isDownloadedAttachment(attachmentInformationArray[n])) continue;
            ++n2;
        }
        if (n2 == attachmentInformationArray.length) {
            attachmentInformationArray2 = attachmentInformationArray;
        } else {
            attachmentInformationArray2 = new AttachmentInformation[n2];
            n = 0;
            for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
                if (!AttachmentUtil.isDownloadedAttachment(attachmentInformationArray[i2])) continue;
                attachmentInformationArray2[n++] = attachmentInformationArray[i2];
            }
        }
        return attachmentInformationArray2;
    }

    public static boolean isAttachmentDownloadComplete(boolean bl, int n, AttachmentInformation[] attachmentInformationArray) {
        boolean bl2 = true;
        if (bl && n != 0) {
            if (attachmentInformationArray == null || attachmentInformationArray.length == 0) {
                bl2 = false;
            } else {
                boolean bl3 = false;
                boolean bl4 = n == 2;
                boolean bl5 = n == 1;
                for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
                    boolean bl6;
                    AttachmentInformation attachmentInformation = attachmentInformationArray[i2];
                    if (AttachmentUtil.isDownloadedAttachment(attachmentInformation)) continue;
                    boolean bl7 = bl6 = bl4 || bl5 && AttachmentUtil.isSupportedAttachment(attachmentInformation);
                    if (!bl6) continue;
                    bl3 = true;
                    break;
                }
                if (bl3) {
                    bl2 = false;
                }
            }
        }
        return bl2;
    }

    public static boolean isMimeEncoded(int n) {
        return n == 2;
    }

    private static boolean isDownloadedAttachment(AttachmentInformation attachmentInformation) {
        return attachmentInformation.getAttachmentPath().getUrl() != null;
    }
}

