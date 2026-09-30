/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface IExternalTraceEntity {
    public String getName();

    public TraceEntityURI getURI();

    public TraceEntityURI getParentURI();

    public short getFilterLevel();
}

