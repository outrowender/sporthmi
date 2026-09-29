/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.component;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MessagingComponentCollection {
    private final List components = new ArrayList();

    public synchronized void add(IMessagingComponent iMessagingComponent) {
        this.components.add(iMessagingComponent);
    }

    public synchronized void initAll(AbstractMsgApplication abstractMsgApplication) {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IMessagingComponent)iterator.next()).init(abstractMsgApplication);
        }
    }

    public synchronized void disposeAll() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IMessagingComponent)iterator.next()).dispose();
        }
    }

    public synchronized void connectAll(IServiceRegistry iServiceRegistry) {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IMessagingComponent)iterator.next()).connect(iServiceRegistry);
        }
    }

    public synchronized void disconnectAll() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IMessagingComponent)iterator.next()).disconnect();
        }
    }
}

