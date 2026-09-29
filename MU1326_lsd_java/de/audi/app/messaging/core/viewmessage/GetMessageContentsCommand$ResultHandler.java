/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import org.dsi.ifc.messaging.MessageDetails;

public interface GetMessageContentsCommand$ResultHandler {
    default public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
    }
}

