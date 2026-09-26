/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;

public class CoreEditorModeController
extends AbstractMessagingComponent {
    protected CoreEditorModeController(MessagingBundleContext messagingBundleContext, String string) {
        super(messagingBundleContext, string);
    }

    protected boolean isLockingAvailable() {
        int n = this.framework.getHMIService().getChoiceModel(5583).getValue();
        int n2 = this.framework.getHMIService().getChoiceModel(5602).getValue();
        int n3 = this.framework.getHMIService().getChoiceModel(5606).getValue();
        return n == 1 && (n2 == 1 || n3 == 1);
    }
}

