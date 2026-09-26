/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import org.dsi.ifc.messaging.AttachmentInformation;

public interface IAttachmentObserver {
    public static final int DOWNLOAD_SUCCESSFUL;
    public static final int DOWNLOAD_SEMISUCCESSFUL;
    public static final int DOWNLOAD_FAILED;
    public static final int DOWNLOAD_STARTED;

    default public void downloadComplete(int n) {
    }

    default public void attachmentSelected(AttachmentInformation attachmentInformation) {
    }
}

