/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;
import org.dsi.ifc.messaging.Template;

class DiagDsiMessaging$15
implements Runnable {
    private final /* synthetic */ int[] val$templateIDs;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$15(DiagDsiMessaging diagDsiMessaging, int[] nArray) {
        this.this$0 = diagDsiMessaging;
        this.val$templateIDs = nArray;
    }

    @Override
    public void run() {
        Template[] templateArray = new Template[DiagDsiMessagingData.templates.length - this.val$templateIDs.length];
        int n = 0;
        for (int i2 = 0; i2 < DiagDsiMessagingData.templates.length; ++i2) {
            boolean bl = false;
            for (int i3 = 0; i3 < this.val$templateIDs.length; ++i3) {
                if (DiagDsiMessagingData.templates[i2].id != this.val$templateIDs[i3]) continue;
                bl = true;
            }
            if (bl) continue;
            templateArray[n++] = DiagDsiMessagingData.templates[i2];
        }
        DiagDsiMessagingData.templates = templateArray;
        DiagDsiMessaging.access$000(this.this$0).deleteTemplateResponse(0);
    }
}

