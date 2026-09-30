/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.plugin;

import de.esolutions.fw.util.tracing.config.TraceConfigPlugin;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;

public interface ITracePlugin {
    public void start(TraceFrontend var1, TraceConfigPlugin var2);

    public void stop();
}

