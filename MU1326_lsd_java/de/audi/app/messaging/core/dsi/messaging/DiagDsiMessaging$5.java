/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import org.dsi.ifc.messaging.ListChangedInformation;

class DiagDsiMessaging$5
implements Runnable {
    private final /* synthetic */ ListChangedInformation val$information;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$5(DiagDsiMessaging diagDsiMessaging, ListChangedInformation listChangedInformation) {
        this.this$0 = diagDsiMessaging;
        this.val$information = listChangedInformation;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).indicateListChanged(this.val$information);
    }
}

