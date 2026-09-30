/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tools.profiling;

import de.audi.atip.log.AbstractLogSink;
import de.audi.atip.log.LogEntry;
import de.esolutions.fw.util.tracing.TraceClient;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.util.ThreadCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class CommSink
extends AbstractLogSink
implements ITraceFrontendListener {
    private static final short LOG_CUTOFF_LEVEL = 0;
    private static final short LOG_COMMSINK_LEVEL = 4;
    private static final String LOG_COMMSINK_NAME = "Ext.CommSink";
    private final TraceFrontend frontend;
    private int commId = -1;
    private final Map channels = new HashMap(350);
    private final WeakHashMap threadName2threadIDMap = new WeakHashMap(100);
    private static final Integer DUMMY_INT = new Integer(0);
    private static final boolean DEBUG = false;
    private ThreadCache threadCache = null;

    CommSink(TraceFrontend traceFrontend) {
        Map map = this.getConfiguration();
        map.put(LOG_COMMSINK_NAME, new Integer(this.level2COMM(4)));
        this.setConfiguration(map);
        try {
            this.threadCache = TraceClient.getTraceClient().getThreadCache();
        }
        catch (NoSuchMethodError noSuchMethodError) {
            // empty catch block
        }
        this.frontend = traceFrontend;
        traceFrontend.registerListener(this);
    }

    private final int createChannel(String string, short s) {
        int n = 0;
        TraceEntityURIWithLevel traceEntityURIWithLevel = this.frontend.createChannelPath("hmi." + string, s);
        if (traceEntityURIWithLevel != null) {
            n = traceEntityURIWithLevel.getId();
            this.updateLogLevel(string, this.level2HMI(traceEntityURIWithLevel.getLevel()));
        }
        return n;
    }

    private void logInternal(short s, String string) {
        System.out.println("CommSink: " + string);
        if (this.commId >= 0) {
            this.frontend.log(this.commId, this.getThreadID(), s, (short)0, string);
        }
    }

    private int level2HMI(short s) {
        switch (s) {
            case 5: {
                return 1000;
            }
            case 4: {
                return 10000;
            }
            case 3: {
                return 100000;
            }
            case 2: {
                return 1000000;
            }
            case 1: {
                return 10000000;
            }
            case 0: {
                return 100000000;
            }
        }
        return 0;
    }

    private short level2COMM(int n) {
        switch (n) {
            case 1000: {
                return 5;
            }
            case 10000: {
                return 4;
            }
            case 100000: {
                return 3;
            }
            case 1000000: {
                return 2;
            }
            case 10000000: {
                return 1;
            }
            case 100000000: {
                return 0;
            }
        }
        return 7;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int lookupCid(String string) {
        Object object;
        Map map = this.channels;
        synchronized (map) {
            object = this.channels.get(string);
        }
        return object instanceof Integer ? (Integer)object : 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String lookupChannelName(int n) {
        Map map = this.channels;
        synchronized (map) {
            Iterator iterator = this.channels.keySet().iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                if (n != this.lookupCid(string)) continue;
                return string;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLogThreshold(String string) {
        Map map = this.channels;
        synchronized (map) {
            if (!this.channels.containsKey(string)) {
                this.channels.put(string, DUMMY_INT);
                int n = this.createChannel(string, (short)0);
                this.channels.put(string, new Integer(n));
            }
        }
        return super.getLogThreshold(string);
    }

    public void writeLog(LogEntry logEntry) {
        if (this.threadCache != null) {
            ThreadCache.Info info = this.threadCache.getThreadInfo(Thread.currentThread());
            this.frontend.log(this.lookupCid(logEntry.getChannelName()), info.id, this.level2COMM(logEntry.getLevel()), (short)0, logEntry.getLogMessage(info.msgPrefix));
        } else {
            this.frontend.log(this.lookupCid(logEntry.getChannelName()), this.getThreadID(), this.level2COMM(logEntry.getLevel()), (short)0, logEntry.getLogMessage(null));
        }
    }

    public void executeCallback(int n, byte[] byArray) {
    }

    public final void updateLogLevel(String string, int n) {
        Map map = this.getConfiguration();
        map.put(string, new Integer(n));
        this.updateConfiguration(map, string);
    }

    public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
        this.updateLogLevel(this.lookupChannelName(traceEntityURI.getId()), this.level2HMI(s));
        this.frontend.changeFilterLevel(traceEntityURI, s);
    }

    public void requestQuit() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getThreadID() {
        Thread thread = Thread.currentThread();
        WeakHashMap weakHashMap = this.threadName2threadIDMap;
        synchronized (weakHashMap) {
            Integer n = (Integer)this.threadName2threadIDMap.get(thread);
            if (n == null) {
                TraceEntityURIWithLevel traceEntityURIWithLevel = this.frontend.createThread("hmi." + thread.getName(), (short)0);
                n = new Integer(traceEntityURIWithLevel.getId());
                this.threadName2threadIDMap.put(thread, n);
            }
            return n;
        }
    }
}

