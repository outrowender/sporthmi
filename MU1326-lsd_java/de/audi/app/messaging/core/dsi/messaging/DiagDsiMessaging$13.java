/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;
import org.dsi.ifc.messaging.Template;

class DiagDsiMessaging$13
implements Runnable {
    private final /* synthetic */ int val$templateID;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$13(DiagDsiMessaging diagDsiMessaging, int n) {
        this.this$0 = diagDsiMessaging;
        this.val$templateID = n;
    }

    @Override
    public void run() {
        int n = 2;
        Template template = null;
        for (int i2 = 0; i2 < DiagDsiMessagingData.templates.length; ++i2) {
            if (DiagDsiMessagingData.templates[i2].getId() != this.val$templateID) continue;
            n = 0;
            template = DiagDsiMessagingData.templates[i2];
        }
        DiagDsiMessaging.access$000(this.this$0).getTemplateResponse(n, template);
    }
}

