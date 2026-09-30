/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.transport;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.debug.TransportDebugTool;

public class TransportDebugAdapter
implements ITransportDebug {
    private final MyQueueWorker worker;

    public TransportDebugAdapter(TraceChannel traceChannel, int n) {
        this.worker = new MyQueueWorker(traceChannel, n);
    }

    public void start(int n) {
        this.worker.start(n);
    }

    public void stop() {
        this.worker.stop();
    }

    public void log(long l, int n, int n2, Object object) {
        this.worker.add(new Entry(Thread.currentThread(), l, n, n2, object));
    }

    private static class Entry {
        public final Thread t;
        public final long ts;
        public final int state;
        public final int value;
        public final Object tag;

        public Entry(Thread thread, long l, int n, int n2, Object object) {
            this.t = thread;
            this.ts = l;
            this.state = n;
            this.value = n2;
            this.tag = object;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append(this.t.getName());
            buffer.append(": ");
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(this.ts);
            buffer.append(traceTimeStamp.toUTCTimeString(false));
            buffer.append(' ');
            TransportDebugTool.decodeState(this.state, buffer);
            buffer.append(' ');
            buffer.append(this.value);
            if (this.tag != null) {
                buffer.append(' ');
                buffer.append(this.tag);
            }
            return buffer.toString();
        }
    }

    private static class MyQueueWorker
    extends QueueWorker {
        private TraceChannel channel;

        public MyQueueWorker(TraceChannel traceChannel, int n) {
            super("fwTpDebug", n);
            this.channel = traceChannel;
        }

        protected void handleQueuedObject(Object object) {
            Entry entry = (Entry)object;
            this.channel.log((short)2, "%1", entry);
        }

        public void add(Entry entry) {
            try {
                this.addToQueue(entry);
            }
            catch (QueueShutdownException queueShutdownException) {
                // empty catch block
            }
        }
    }
}

