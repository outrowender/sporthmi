/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigLevels;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.model.TraceEntity;

public abstract class AbstractTraceBackend
implements ITraceBackend {
    protected ITraceBackendListener listener;
    protected TraceConfigBackend config;
    protected TraceConfigLevels levels;
    protected String backendName;
    protected short bid;

    public AbstractTraceBackend(String string) {
        this.backendName = string;
        this.bid = (short)-1;
    }

    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        this.listener = iTraceBackendListener;
        this.bid = s;
        this.config = traceConfigBackend;
        if (this.config != null) {
            this.levels = this.config.getLevels();
        }
    }

    public void exit() {
    }

    public String getName() {
        return this.backendName;
    }

    public int getFlags() {
        return 1;
    }

    public boolean adjustToChangeLevel(ITraceEntity iTraceEntity) {
        return false;
    }

    public short backendFilterLevel(ITraceEntity iTraceEntity) {
        if (this.levels != null) {
            TraceEntity traceEntity = (TraceEntity)iTraceEntity;
            String string = traceEntity.getPath(true);
            return this.levels.getTraceLevel(iTraceEntity.getURI().getType(), string);
        }
        return 7;
    }

    public short backendDefaultFilterLevel(short s) {
        if (this.levels != null) {
            return this.levels.getDefaultTraceLevel(s);
        }
        return 7;
    }

    public boolean createEntity(ITraceEntity iTraceEntity) {
        this.listener.logMessage(this.bid, "createEntity uri=" + iTraceEntity.getURI() + " name=" + iTraceEntity.getName() + " level=" + TraceLevels.levelNames[iTraceEntity.getCoreFilterLevel()]);
        return true;
    }

    public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
        this.listener.logMessage(this.bid, "changeFilterLevel: uri=" + traceEntityURI + " level=" + s);
        return true;
    }

    public boolean connect() {
        this.listener.logMessage(this.bid, "--- connect ---");
        this.listener.connected(this.bid, true);
        return true;
    }

    public void disconnect() {
        this.listener.logMessage(this.bid, "--- disconnect ---");
        this.listener.disconnected(this.bid);
    }

    public boolean droppedMessages(int n) {
        this.listener.logMessage(this.bid, "DROPPED " + n + " MESSAGES");
        return true;
    }

    public void handleBreak() {
        this.listener.logMessage(this.bid, "*** BREAK ***");
    }

    public boolean registerTimeZone(int n, int n2, String string) {
        this.listener.logMessage(this.bid, "registerTimeZone: id=" + n + " res=" + n2 + " name=" + string);
        return true;
    }

    public boolean updateTimeZone(int n, long l, long l2) {
        this.listener.logMessage(this.bid, "updateTimeZone: id=" + n + " tz=" + l + " core=" + l2);
        return true;
    }

    public ITraceMessage logBulk(ITraceMessage[] iTraceMessageArray) {
        this.listener.logMessage(this.bid, "logBulk: num=" + iTraceMessageArray.length);
        return null;
    }

    public boolean createEntityBulk(ITraceEntity[] iTraceEntityArray) {
        this.listener.logMessage(this.bid, "createEntityBulk: num=" + iTraceEntityArray.length);
        return true;
    }

    public boolean changeFilterLevelBulk(ITraceEntity[] iTraceEntityArray) {
        this.listener.logMessage(this.bid, "changeFilterLevelBulk: num=" + iTraceEntityArray.length);
        return true;
    }
}

