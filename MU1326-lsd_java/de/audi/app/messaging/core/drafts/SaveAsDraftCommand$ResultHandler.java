/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.compose.Message;

public interface SaveAsDraftCommand$ResultHandler {
    default public void handleResult(int n, String string, Message message) {
    }
}

