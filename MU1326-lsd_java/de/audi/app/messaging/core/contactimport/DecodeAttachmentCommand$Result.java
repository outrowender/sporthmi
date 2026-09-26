/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.contactimport.DecodeAttachmentCommand;
import de.audi.app.messaging.core.contactimport.DecodeAttachmentCommand$1;
import org.dsi.ifc.global.ResourceLocator;

public final class DecodeAttachmentCommand$Result {
    private final int resultCode;
    private final ResourceLocator resourceLocator;
    private final /* synthetic */ DecodeAttachmentCommand this$0;

    private DecodeAttachmentCommand$Result(DecodeAttachmentCommand decodeAttachmentCommand, int n, ResourceLocator resourceLocator) {
        this.this$0 = decodeAttachmentCommand;
        this.resultCode = n;
        this.resourceLocator = resourceLocator;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    /* synthetic */ DecodeAttachmentCommand$Result(DecodeAttachmentCommand decodeAttachmentCommand, int n, ResourceLocator resourceLocator, DecodeAttachmentCommand$1 decodeAttachmentCommand$1) {
        this(decodeAttachmentCommand, n, resourceLocator);
    }
}

