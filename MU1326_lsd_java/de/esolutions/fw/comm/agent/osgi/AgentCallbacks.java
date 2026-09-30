/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.error.Floater;
import de.esolutions.fw.util.commons.os.Slayer;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class AgentCallbacks {
    private static TraceChannel channel = new TraceChannel("comm.agent.Callback");
    private int disconnectPeerId;
    private int tracePeerId;
    private int diagReportId;
    private int doctorCallId;
    private int suicideId;
    private int floaterWasteCallId;
    private int floaterFlushCallId;
    private int pingControlCallId;
    private final DoctorShell shell = new DoctorShell();
    private final Floater floater = new Floater();

    public void register() {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            DisconnectPeer disconnectPeer = new DisconnectPeer();
            this.disconnectPeerId = traceClient.registerCallback("comm_disconnectPeer", disconnectPeer);
            TracePeer tracePeer = new TracePeer();
            this.tracePeerId = traceClient.registerCallback("comm_tracePeer", tracePeer);
            DiagnosisReport diagnosisReport = new DiagnosisReport();
            this.diagReportId = traceClient.registerCallback("comm_diagnosis", diagnosisReport);
            DoctorShellCommand doctorShellCommand = new DoctorShellCommand();
            this.doctorCallId = traceClient.registerCallback("comm_doctor", doctorShellCommand);
            SuicideCommand suicideCommand = new SuicideCommand();
            this.suicideId = traceClient.registerCallback("vm_suicide", suicideCommand);
            FloaterWasteCommand floaterWasteCommand = new FloaterWasteCommand();
            this.floaterWasteCallId = traceClient.registerCallback("floater_waste", floaterWasteCommand);
            FloaterFlushCommand floaterFlushCommand = new FloaterFlushCommand();
            this.floaterFlushCallId = traceClient.registerCallback("floater_flush", floaterFlushCommand);
            PingControlCallback pingControlCallback = new PingControlCallback();
            this.pingControlCallId = traceClient.registerCallback("ping_control", pingControlCallback);
        }
    }

    public void unregister() {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.unregisterCallback(this.disconnectPeerId);
            traceClient.unregisterCallback(this.tracePeerId);
            traceClient.unregisterCallback(this.diagReportId);
            traceClient.unregisterCallback(this.doctorCallId);
            traceClient.unregisterCallback(this.suicideId);
            traceClient.unregisterCallback(this.pingControlCallId);
            traceClient.unregisterCallback(this.floaterWasteCallId);
            traceClient.unregisterCallback(this.floaterFlushCallId);
        }
    }

    private static class TracePeer
    implements ITraceCallback {
        private TracePeer() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            try {
                String string = new String(byArray, "UTF-8");
                short s = Short.parseShort(string);
                Agent agent = Agent.getAgent();
                if (agent != null) {
                    channel.log((short)2, "Trace Peer: %1", new Short(s));
                    agent.setTracePeer(s);
                }
            }
            catch (Exception exception) {
                channel.log((short)4, "Invalid TracePeer call! Reason: %1 ", exception);
            }
        }
    }

    private static class DisconnectPeer
    implements ITraceCallback {
        private DisconnectPeer() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            try {
                String string = new String(byArray, "UTF-8");
                short s = Short.parseShort(string);
                Agent agent = Agent.getAgent();
                if (agent != null) {
                    channel.log((short)2, "Force disconnect to peer: %1", new Short(s));
                    agent.forceDisconnect(s);
                }
            }
            catch (Exception exception) {
                channel.log((short)4, new StringBuffer().append("Invalid DisconnectPeer call! Reason: %1 ").append(exception).toString());
            }
        }
    }

    private class SuicideCommand
    implements ITraceCallback {
        private SuicideCommand() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            Slayer slayer = new Slayer();
            slayer.suicide();
        }
    }

    private static class DiagnosisReport
    implements ITraceCallback {
        private DiagnosisReport() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            String string;
            Agent agent = Agent.getAgent();
            if (agent != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                agent.writeDiagnosisReport(printStream);
                try {
                    string = byteArrayOutputStream.toString("UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    string = byteArrayOutputStream.toString();
                    channel.log((short)4, "DiagnosisReport executeTraceCallback found UnsupportedEncodingException");
                }
            } else {
                string = "DiagnosisReport failed: NO AGENT FOUND!";
            }
            channel.log((short)2, string);
        }
    }

    private class DoctorShellCommand
    implements ITraceCallback {
        private DoctorShellCommand() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            String string;
            String string2 = new String(byArray);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            printStream.println(new StringBuffer().append(AgentCallbacks.this.shell.getPrompt()).append(string2).toString());
            AgentCallbacks.this.shell.handleCommand(string2, printStream);
            try {
                string = byteArrayOutputStream.toString("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string = byteArrayOutputStream.toString();
                channel.log((short)4, "DoctorShellCommand executeTraceCallback found UnsupportedEncodingException");
            }
            CommAgentTracing.DOCTOR.log((short)2, string);
        }
    }

    private class FloaterFlushCommand
    implements ITraceCallback {
        private FloaterFlushCommand() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            AgentCallbacks.this.floater.flush();
        }
    }

    private class FloaterWasteCommand
    implements ITraceCallback {
        private FloaterWasteCommand() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            int n2 = 256;
            if (byArray != null) {
                try {
                    String string = new String(byArray, "UTF-8");
                    n2 = Integer.parseInt(string);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            AgentCallbacks.this.floater.waste(n2);
        }
    }

    private static class PingControlCallback
    implements ITraceCallback {
        private PingControlCallback() {
        }

        public void executeTraceCallback(int n, byte[] byArray) {
            try {
                String string = new String(byArray, "UTF-8");
                Agent agent = Agent.getAgent();
                if (agent != null) {
                    channel.log((short)2, "Ping control command=%1", new Short(string));
                    agent.pingControl(string);
                }
            }
            catch (Exception exception) {
                channel.log((short)4, new StringBuffer().append("Invalid Ping control call! Reason: %1 ").append(exception).toString());
            }
        }
    }
}

