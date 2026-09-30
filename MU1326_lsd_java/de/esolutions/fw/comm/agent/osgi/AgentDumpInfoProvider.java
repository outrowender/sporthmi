/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.osgi.MuteableOutputStream;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

public class AgentDumpInfoProvider
implements DumpInfoProvider {
    private Thread dumperThread;
    private boolean doDump = false;
    private boolean doDumpReady = false;
    private PrintStream printStream;
    private int timeout;
    private Object syncWaitForDump = new Object();
    private Object syncWaitForDumpReady = new Object();

    private int readTimeoutFromProperty() {
        int n = 1000;
        String string = System.getProperty("ipl.errordump.timeout");
        try {
            n = Integer.parseInt(string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return n;
    }

    public AgentDumpInfoProvider() {
        this.dumperThread = new Thread(new DumperRunnable(), "commAgentDumpInfoProvider");
        this.dumperThread.start();
        this.timeout = this.readTimeoutFromProperty();
        this.doDump = false;
        this.doDumpReady = false;
    }

    public String getName() {
        return "commAgent";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dump(PrintStream printStream, String string) {
        MuteableOutputStream muteableOutputStream;
        Object object = this.syncWaitForDump;
        synchronized (object) {
            muteableOutputStream = new MuteableOutputStream(printStream);
            this.printStream = new PrintStream(muteableOutputStream);
            this.doDump = true;
            this.doDumpReady = false;
            this.syncWaitForDump.notifyAll();
        }
        object = this.syncWaitForDumpReady;
        synchronized (object) {
            try {
                if (!this.doDumpReady) {
                    this.syncWaitForDumpReady.wait(this.timeout);
                    if (!this.doDumpReady) {
                        printStream.println("dump report aborted, timeout");
                    }
                    muteableOutputStream.disableWrites();
                }
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    private class DumperRunnable
    implements Runnable {
        private DumperRunnable() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            while (true) {
                Object object = AgentDumpInfoProvider.this.syncWaitForDump;
                synchronized (object) {
                    while (!AgentDumpInfoProvider.this.doDump) {
                        try {
                            AgentDumpInfoProvider.this.syncWaitForDump.wait();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
                object = Agent.getAgent();
                if (object == null) {
                    AgentDumpInfoProvider.this.printStream.println("FATAL: No Agent found!");
                } else {
                    ((Agent)object).writeDiagnosisReport(AgentDumpInfoProvider.this.printStream);
                }
                Object object2 = AgentDumpInfoProvider.this.syncWaitForDumpReady;
                synchronized (object2) {
                    AgentDumpInfoProvider.this.doDumpReady = true;
                    AgentDumpInfoProvider.this.doDump = false;
                    AgentDumpInfoProvider.this.syncWaitForDumpReady.notifyAll();
                }
            }
        }
    }
}

