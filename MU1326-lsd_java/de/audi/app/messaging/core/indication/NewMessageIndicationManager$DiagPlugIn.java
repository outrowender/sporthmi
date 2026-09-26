/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class NewMessageIndicationManager$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ NewMessageIndicationManager this$0;

    NewMessageIndicationManager$DiagPlugIn(NewMessageIndicationManager newMessageIndicationManager) {
        this.this$0 = newMessageIndicationManager;
    }

    public Object getNewMessageIndicationManager() {
        return this.this$0;
    }
}

