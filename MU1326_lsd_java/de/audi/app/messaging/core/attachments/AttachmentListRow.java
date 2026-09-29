/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.AttachmentInformation;

final class AttachmentListRow
extends EvoListRow {
    public static final int COLUMN_COUNT;
    private static final int CELL_IDX_RECORDSET;
    private static final int CELL_IDX_ICON;
    private static final int CELL_IDX_ATTACHMENT_NAME;
    private static final int RECORDSET_COLLAPSED;
    private static final int RECORDSET_EXPANDED;
    private static final int ICON_UNSUPPORTED_ATTACHMENT;
    private static final int ICON_SUPPORTED_ATTACHMENT;
    private static volatile long nextRowId;
    private final AttachmentInformation attachmentInformation;

    AttachmentListRow(AttachmentInformation attachmentInformation, boolean bl) {
        super(nextRowId++, 3);
        this.attachmentInformation = attachmentInformation;
        int n = bl ? 1 : 0;
        int n2 = AttachmentUtil.isSupportedAttachment(attachmentInformation) ? 1 : 0;
        this.setInteger(0, n);
        this.setInteger(1, n2);
        this.setText(2, attachmentInformation.getName());
    }

    AttachmentInformation getAttachmentInformation() {
        return this.attachmentInformation;
    }

    AttachmentListRow toggleLayout() {
        return new AttachmentListRow(this.attachmentInformation, !this.isExpanded());
    }

    private boolean isExpanded() {
        int n = this.getInteger(0);
        return n == 1;
    }

    @Override
    public EvoListRow copy() {
        return new AttachmentListRow(this.attachmentInformation, this.isExpanded());
    }

    static {
        nextRowId = 0L;
    }
}

