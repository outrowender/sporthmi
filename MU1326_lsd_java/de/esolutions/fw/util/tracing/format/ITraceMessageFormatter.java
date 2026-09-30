/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceMessageFormatter {
    public void init(TraceConfigFormatter var1);

    public String[] formatMessage(ITraceMessage var1, ITraceEntityResolver var2);
}

