/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;

public interface IConnectionFrontendListener {
    public void configureHandler(ConnectionFrontendHandler var1);

    public void registerConnection(ConnectionFrontendHandler var1);

    public void unregisterConnection(ConnectionFrontendHandler var1);

    public void handleMessage(ConnectionFrontendHandler var1, AbstractMessage var2);
}

