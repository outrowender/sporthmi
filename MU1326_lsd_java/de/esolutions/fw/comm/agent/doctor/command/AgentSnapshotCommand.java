/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentDiagnosisCommand;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.PrintStream;

public class AgentSnapshotCommand
extends AbstractAgentDiagnosisCommand {
    public String[] getNames() {
        return new String[]{"agent_snapshot", "as"};
    }

    public String getDescription() {
        return "take an agent snapshot for info commands";
    }

    protected void handleWithAgentDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAgentDiagnosis iAgentDiagnosis = this.getDiagnosis();
        IAgentSnapshot iAgentSnapshot = iAgentDiagnosis.createSnapshot();
        if (iAgentSnapshot != null) {
            doctorShell.getState().setSnapshot(iAgentSnapshot);
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(iAgentSnapshot.getTimeStamp());
            printStream.println("Snapshot taken: " + traceTimeStamp.toUTCTimeString(true));
        } else {
            printStream.println("Error taking snapshot!");
        }
    }
}

