/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.profile.TraceProfiler;

public class ProfilerBackend
extends AbstractTraceBackend {
    private long beginTime;
    private long endTime;
    private int connects;
    private int disconnects;
    private int numEntities;
    private int[] numEntitiesPerType;
    private TraceProfiler profiler;

    public ProfilerBackend() {
        super("Profiling");
    }

    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        System.out.println("Enabled trace profiling...");
        this.profiler = new TraceProfiler();
        this.numEntitiesPerType = new int[6];
        this.resetStats();
    }

    private void resetStats() {
        this.connects = 0;
        this.disconnects = 0;
        this.numEntities = 0;
        for (int i2 = 0; i2 < 6; ++i2) {
            this.numEntitiesPerType[i2] = 0;
        }
        this.beginTime = System.currentTimeMillis();
        this.profiler.reset();
    }

    public void exit() {
        super.exit();
        this.endTime = System.currentTimeMillis();
        this.dumpStats();
    }

    public void handleBreak() {
        super.handleBreak();
        this.dumpStats();
    }

    public boolean connect() {
        boolean bl = super.connect();
        ++this.connects;
        return bl;
    }

    public void disconnect() {
        super.disconnect();
        ++this.disconnects;
    }

    public boolean createEntity(ITraceEntity iTraceEntity) {
        boolean bl = super.createEntity(iTraceEntity);
        ++this.numEntities;
        short s = iTraceEntity.getURI().getType();
        this.numEntitiesPerType[s] = this.numEntitiesPerType[s] + 1;
        return bl;
    }

    private void dumpStats() {
        System.out.println("--- Profiling Results ---");
        long l = this.endTime - this.beginTime;
        System.out.println("Duration:  " + l + " ms");
        System.out.println("Connect:   got=" + this.connects + ", lost=" + this.disconnects);
        System.out.print("Entities:  created=" + this.numEntities);
        for (int i2 = 0; i2 < 6; ++i2) {
            System.out.print(", " + TraceEntityType.names[i2] + ": " + this.numEntitiesPerType[i2]);
        }
        System.out.println();
        this.profiler.report(System.out);
    }

    public boolean log(ITraceMessage iTraceMessage) {
        this.profiler.accountMessage(iTraceMessage);
        return true;
    }

    public boolean droppedMessages(int n) {
        this.profiler.accountDrop(n);
        return true;
    }
}

