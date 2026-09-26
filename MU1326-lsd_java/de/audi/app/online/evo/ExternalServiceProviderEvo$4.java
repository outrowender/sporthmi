/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

class ExternalServiceProviderEvo$4
implements LogAppender {
    private final /* synthetic */ String val$applicationContext;
    private final /* synthetic */ boolean val$startMediaAppInBackground;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$4(ExternalServiceProviderEvo externalServiceProviderEvo, String string, boolean bl) {
        this.this$0 = externalServiceProviderEvo;
        this.val$applicationContext = string;
        this.val$startMediaAppInBackground = bl;
    }

    @Override
    public void appendTo(Buffer buffer) {
        buffer.append(this.val$applicationContext);
        if (this.val$startMediaAppInBackground) {
            buffer.append(" (startMediaAppInBackground)");
        }
    }

    @Override
    public int getEstimatedLength() {
        return 32;
    }
}

