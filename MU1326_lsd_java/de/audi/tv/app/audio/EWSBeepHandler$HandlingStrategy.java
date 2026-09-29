/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.EWSBeepHandler;
import de.audi.tv.app.audio.EWSBeepHandler$1;
import de.audi.tv.app.util.Handler$IHandlingStrategy;
import de.audi.tv.app.util.Message;

final class EWSBeepHandler$HandlingStrategy
implements Handler$IHandlingStrategy {
    private final /* synthetic */ EWSBeepHandler this$0;

    private EWSBeepHandler$HandlingStrategy(EWSBeepHandler eWSBeepHandler) {
        this.this$0 = eWSBeepHandler;
    }

    @Override
    public void handleMessage(Message message) {
        EWSBeepHandler.access$400(this.this$0).releaseConnection(121);
    }

    /* synthetic */ EWSBeepHandler$HandlingStrategy(EWSBeepHandler eWSBeepHandler, EWSBeepHandler$1 eWSBeepHandler$1) {
        this(eWSBeepHandler);
    }
}

