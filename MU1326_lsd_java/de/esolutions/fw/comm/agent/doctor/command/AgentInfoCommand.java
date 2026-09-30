/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.diag.info.WorkerInfo;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentSnapshotCommand;
import java.io.PrintStream;

public class AgentInfoCommand
extends AbstractAgentSnapshotCommand {
    public String[] getNames() {
        return new String[]{"agent_info", "ai"};
    }

    public String getDescription() {
        return "summarize state information of the COMM Agent";
    }

    public void handleWithAgentSnapshot(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAgentSnapshot iAgentSnapshot = this.getSnapshot();
        IInfoBase[] iInfoBaseArray = iAgentSnapshot.getAllProxies();
        IInfoBase[] iInfoBaseArray2 = iAgentSnapshot.getAllStubs();
        IInfoBase[] iInfoBaseArray3 = iAgentSnapshot.getAllClients();
        IInfoBase[] iInfoBaseArray4 = iAgentSnapshot.getAllServiceHandlers();
        ServiceLocatorInfo[] serviceLocatorInfoArray = iAgentSnapshot.getAllServiceLocators();
        WorkerInfo workerInfo = iAgentSnapshot.getWorker();
        if (iInfoBaseArray != null) {
            printStream.println("Proxies: " + iInfoBaseArray.length);
            InfoUtils.printInfoIDs(iInfoBaseArray, printStream);
        }
        if (iInfoBaseArray2 != null) {
            printStream.println("Stubs:   " + iInfoBaseArray2.length);
            InfoUtils.printInfoIDs(iInfoBaseArray2, printStream);
        }
        if (iInfoBaseArray3 != null) {
            printStream.println("Clients: " + iInfoBaseArray3.length);
            InfoUtils.printInfoIDs(iInfoBaseArray3, printStream);
        }
        if (iInfoBaseArray4 != null) {
            printStream.println("ServiceHandlers: " + iInfoBaseArray4.length);
            InfoUtils.printInfoIDs(iInfoBaseArray4, printStream);
        }
        if (serviceLocatorInfoArray != null) {
            printStream.println("ServiceLocators: " + serviceLocatorInfoArray.length);
        }
        if (workerInfo != null) {
            InfoStream infoStream = new InfoStream(printStream);
            workerInfo.write(infoStream);
        }
    }
}

