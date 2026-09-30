/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceEntity {
    public String getName();

    public TraceEntityURI getURI();

    public TraceEntityURI getParentURI();

    public short getFrontendFilterLevel();

    public ITraceEntity getParent();

    public int getCreateEpoch();

    public short getCoreFilterLevel();

    public IExternalTraceEntity createExternalCoreEntity();
}

