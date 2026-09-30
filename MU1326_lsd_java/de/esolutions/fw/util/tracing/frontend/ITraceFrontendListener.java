/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.frontend;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceFrontendListener {
    public void executeCallback(int var1, byte[] var2);

    public void requestFilterLevel(TraceEntityURI var1, short var2);

    public void requestQuit();
}

