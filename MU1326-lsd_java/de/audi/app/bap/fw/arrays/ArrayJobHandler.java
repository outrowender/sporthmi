/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayJobList;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.GetArrayJob;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public class ArrayJobHandler {
    private final AbstractBAPModule module;
    private final ArrayHandler arrayHandler;
    private CommandListManager cmdListManager;

    public ArrayJobHandler(AbstractBAPModule abstractBAPModule, ArrayHandler arrayHandler) {
        this.module = abstractBAPModule;
        this.arrayHandler = arrayHandler;
        this.cmdListManager = new CommandListManager("ArrayJobHandlerCmdListManager", abstractBAPModule.getFrameworkAccess(), abstractBAPModule.getLogChannel(), null, null);
        this.cmdListManager.start();
    }

    public void addSingleJob(GetArrayIndication getArrayIndication) {
        this.addSingleJob(new GetArrayJob(this.module.getLogChannel(), this.arrayHandler, getArrayIndication));
    }

    private void addSingleJob(GetArrayJob getArrayJob) {
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(getArrayJob);
        commandList.execute("start single getArray job");
        this.cmdListManager.start();
    }

    public void addJobList(GetArrayIndication[] getArrayIndicationArray) {
        this.addJobList(getArrayIndicationArray, null);
    }

    public void addJobList(GetArrayIndication[] getArrayIndicationArray, AbstractArrayJobListMonitor abstractArrayJobListMonitor) {
        GetArrayJob[] getArrayJobArray = new GetArrayJob[getArrayIndicationArray.length];
        for (int i2 = 0; i2 < getArrayIndicationArray.length; ++i2) {
            getArrayJobArray[i2] = new GetArrayJob(this.module.getLogChannel(), this.arrayHandler, getArrayIndicationArray[i2]);
        }
        this.addJobList(getArrayJobArray, abstractArrayJobListMonitor);
    }

    public void addJobList(GetArrayJob[] getArrayJobArray) {
        this.addJobList(getArrayJobArray, null);
    }

    private void addJobList(GetArrayJob[] getArrayJobArray, AbstractArrayJobListMonitor abstractArrayJobListMonitor) {
        ArrayJobList arrayJobList = new ArrayJobList(this.cmdListManager);
        for (int i2 = 0; i2 < getArrayJobArray.length; ++i2) {
            arrayJobList.add(getArrayJobArray[i2]);
        }
        if (abstractArrayJobListMonitor != null) {
            ((CommandList)arrayJobList).addMonitor(abstractArrayJobListMonitor);
        }
        arrayJobList.execute("start getArray job list");
        this.cmdListManager.start();
    }

    public void notifyStatusReceived(GetArrayIndication getArrayIndication) {
        this.module.getLogChannel().log(-2137614336, "[ArrayJobHandler#notifyStatusReceived] %1", (Object)getArrayIndication);
        CommandList commandList = this.cmdListManager.getActiveCommandList();
        if (commandList != null) {
            GetArrayJob getArrayJob = (GetArrayJob)commandList.getActiveCommand();
            if (getArrayJob != null) {
                if (getArrayJob.getIndication().equals(getArrayIndication)) {
                    getArrayJob.notifyStatusReceived();
                } else {
                    this.module.getLogChannel().log(10000, "[JobListHandler#notifyStatusReceived] indication of received status doesn't match active getArray job");
                }
            } else {
                this.module.getLogChannel().log(-1601830656, "[ArrayJobHandler#notifyStatusReceived] no job active");
            }
        } else {
            this.module.getLogChannel().log(-1601830656, "[ArrayJobHandler#notifyStatusReceived] no CommandList active");
        }
    }

    public boolean isJobListActive() {
        return this.cmdListManager.getActiveCommandList() instanceof ArrayJobList;
    }
}

