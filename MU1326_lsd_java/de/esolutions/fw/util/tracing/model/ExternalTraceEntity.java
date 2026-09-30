/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.model;

import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public class ExternalTraceEntity
implements IExternalTraceEntity {
    private final String name;
    private final TraceEntityURI uri;
    private final short filter;
    private final TraceEntityURI parentUri;

    public ExternalTraceEntity(String string, TraceEntityURI traceEntityURI, short s, TraceEntityURI traceEntityURI2) {
        this.name = string;
        this.uri = traceEntityURI;
        this.filter = s;
        this.parentUri = traceEntityURI2;
    }

    public String getName() {
        return this.name;
    }

    public TraceEntityURI getURI() {
        return this.uri;
    }

    public short getFilterLevel() {
        return this.filter;
    }

    public TraceEntityURI getParentURI() {
        return this.parentUri;
    }
}

