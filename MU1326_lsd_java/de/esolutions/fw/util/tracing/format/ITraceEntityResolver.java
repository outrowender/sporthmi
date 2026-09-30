/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceEntityResolver {
    public String resolveName(TraceEntityURI var1);

    public String resolvePath(TraceEntityURI var1, boolean var2);

    public String resolveParentName(TraceEntityURI var1, short var2);
}

