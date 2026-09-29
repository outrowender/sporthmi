/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallResult;

public class DownloadPoiCommand
extends AbstractCommand
implements DSIOperatorCallListener {
    private DSIHandler dsiHandler;

    public DownloadPoiCommand(DSIHandler dSIHandler, AbstractOperatorCall abstractOperatorCall) {
        super(abstractOperatorCall, "DownloadPOI");
        this.dsiHandler = dSIHandler;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "DownloadPoiCommand#execute: entered");
        if (this.dsiHandler.isDSIAvailable()) {
            this.logger.log(1078071040, "DownloadPoiCommand#execute: dsi is available");
            if (TestHandler.isDsiSimulation()) {
                this.logger.log(-1601830656, "DownloadPoiCommand#execute: DSISimulation is running!");
                if (TestHandler.usePoiTimeout()) {
                    for (int i2 = 0; i2 < TestHandler.getTimer(); ++i2) {
                        if (i2 % TestHandler.getTimerMod() != 0) continue;
                        this.logger.log(1078071040, "DownloadPoiCommand#execute: timer = %1", (long)i2);
                    }
                }
                this.logger.log(-2137614336, "DownloadPoiCommand#execute: serviceType is %1", (long)this.listener.getServiceType());
                OperatorCallResult[] operatorCallResultArray = TestHandler.getPOI(this.listener.getServiceType());
                this.dsiHandler.responseOperatorCallResult(TestHandler.getPOIResult(), operatorCallResultArray);
            } else {
                String string = this.listener.getServiceId();
                int n = this.listener.getServiceType();
                this.logger.log(1078071040, "DownloadPoiCommand#execute: requestOperatorCallResult(serviceId = %1, serviceType = %2)", (Object)string, (long)n);
                this.dsiHandler.requestOperatorCallResult(string, n);
            }
        } else {
            this.listener.setDownloadRunning(false);
            this.listener.replyToSDS(8);
            this.getCmdList().commandAborted("DownloadPoiCommand#execute: dsi is not available!", "DownloadPoiCommand#execute: dsi is not available!");
        }
    }

    @Override
    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        int n2 = 0;
        if (operatorCallResultArray != null) {
            n2 = operatorCallResultArray.length;
        }
        this.logger.log(1078071040, "DownloadPoiCommand#responseOperatorCallResult: resultType = %1, results.length = %2", (long)n, (long)n2);
        this.getCommandList().commandFinished();
        this.listener.responseOperatorCallResult(n, operatorCallResultArray);
    }

    @Override
    public long getTimeout() {
        return -1L;
    }
}

