/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import org.dsi.ifc.messaging.AttachmentInformation;

public interface IAttachmentObserver {
    public static final int DOWNLOAD_SUCCESSFUL = 0;
    public static final int DOWNLOAD_SEMISUCCESSFUL = 1;
    public static final int DOWNLOAD_FAILED = 2;
    public static final int DOWNLOAD_STARTED = 3;

    public void downloadComplete(int var1);

    public void attachmentSelected(AttachmentInformation var1);

    public static class DefaultAttachmentObserver
    implements IAttachmentObserver {
        public void downloadComplete(int n) {
        }

        public void attachmentSelected(AttachmentInformation attachmentInformation) {
        }
    }
}

