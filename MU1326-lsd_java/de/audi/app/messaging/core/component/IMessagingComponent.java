/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.component;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.osgi.IServiceRegistry;

public interface IMessagingComponent {
    default public void addComponent(IMessagingComponent iMessagingComponent) {
    }

    default public void init(AbstractMsgApplication abstractMsgApplication) {
    }

    default public void dispose() {
    }

    default public void connect(IServiceRegistry iServiceRegistry) {
    }

    default public void disconnect() {
    }
}

