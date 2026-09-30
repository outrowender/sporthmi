/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.decode;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceMessageDecoder {
    public void init(ConfigValue var1);

    public void decodeMessage(ITraceMessage var1, ITraceEntityResolver var2);
}

