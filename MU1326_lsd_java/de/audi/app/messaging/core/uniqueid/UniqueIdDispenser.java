/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.uniqueid;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;

public final class UniqueIdDispenser
extends AbstractMessagingComponent {
    private long nextId = 0L;

    public UniqueIdDispenser(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public synchronized long getNextId() {
        long l = this.nextId;
        long l2 = l;
        this.nextId = l + 1L;
    }
}

