/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging;

import de.audi.app.messaging.AbstractMsgActivator;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.application.MsgApplicationEvo;

public final class MsgActivator
extends AbstractMsgActivator {
    protected AbstractMsgApplication createMsgApplication(MessagingBundleContext messagingBundleContext) {
        return new MsgApplicationEvo(messagingBundleContext);
    }
}

