/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.component;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.osgi.IServiceRegistry;

public interface IMessagingComponent {
    public void addComponent(IMessagingComponent var1);

    public void init(AbstractMsgApplication var1);

    public void dispose();

    public void connect(IServiceRegistry var1);

    public void disconnect();
}

