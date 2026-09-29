/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.data.PhoneResult;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallData;

public class DownloadPhoneNumberCommand
extends AbstractCommand
implements DSIOperatorCallListener {
    private boolean ignoreOldSession;
    private DSIHandler dsiHandler;
    private OperatorCallData currentPositionInfo;

    public DownloadPhoneNumberCommand(DSIHandler dSIHandler, AbstractOperatorCall abstractOperatorCall, boolean bl, OperatorCallData operatorCallData) {
        super(abstractOperatorCall, "DownloadNumber");
        this.ignoreOldSession = bl;
        this.dsiHandler = dSIHandler;
        this.currentPositionInfo = operatorCallData;
    }

    @Override
    public void execute() {
        this.listener.setCurrentCallStatus(0);
        this.logger.log(1078071040, "DownloadPhoneNumberCommand#execute: entered");
        if (this.dsiHandler.isDSIAvailable()) {
            this.logger.log(1078071040, "DownloadPhoneNumberCommand#execute: dsi is available");
            int n = this.listener.getServiceType();
            Buffer buffer = new Buffer("serviceType =");
            buffer.append(n);
            buffer.append(", currentPosition = ");
            buffer.append(this.currentPositionInfo);
            buffer.append(", ignoreOldSession = ");
            buffer.append(this.ignoreOldSession);
            this.logger.log(1078071040, "DownloadPhoneNumberCommand#execute: requestOperatorPhoneNumber(%1)", (Object)buffer.toString());
            if (TestHandler.isDsiSimulation()) {
                int n2;
                this.logger.log(-1601830656, "DownloadPhoneNumberCommand#execute: DSISimulation is running!");
                if (TestHandler.usePhoneTimeout()) {
                    for (n2 = 0; n2 < TestHandler.getTimer(); ++n2) {
                        if (n2 % TestHandler.getTimerMod() != 0) continue;
                        this.logger.log(1078071040, "DownloadPhoneNumberCommand#execute: timer = %1", (long)n2);
                    }
                }
                PhoneResult phoneResult = TestHandler.getPhoneResults();
                n2 = !this.ignoreOldSession ? TestHandler.getFirstReqTelResult() : TestHandler.getSecReqTelResult();
                this.dsiHandler.responseOperatorPhoneNumber(n2, phoneResult.getServiceId(), phoneResult.getPhoneNumber(), phoneResult.getTransferType());
            } else {
                CommandListManager commandListManager = this.getCmdList().getManager();
                OperatorCallCommandListManager operatorCallCommandListManager = (OperatorCallCommandListManager)commandListManager;
                String string = operatorCallCommandListManager.getLanguage();
                this.logger.log(1078071040, "DownloadPhoneNumberCommand#execute: setLanguage(%1)", (Object)string);
                this.dsiHandler.setLanguage(string);
                this.dsiHandler.requestOperatorPhoneNumber(n, this.currentPositionInfo, this.ignoreOldSession);
            }
        } else {
            this.listener.setCallStarted(false);
            this.listener.replyToSDS(8);
            this.getCmdList().commandAborted("DownloadPhoneNumberCommand#execute: dsi is not available!", "DownloadPhoneNumberCommand#execute: dsi is not available!");
        }
    }

    @Override
    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.logger.log(1078071040, "DownloadPhoneNumberCommand#responseOperatorPhoneNumber: got response!");
        Buffer buffer = new Buffer("DownloadPhoneNumberCommand#responseOperatorPhoneNumber: resultType = ");
        buffer.append(n);
        buffer.append(", serviceId = ");
        buffer.append(string);
        buffer.append(", operatorPhoneNumberLength = ");
        if (stringArray != null) {
            buffer.append(stringArray.length);
        } else {
            buffer.append("0");
        }
        buffer.append(", transferType = ");
        buffer.append(n2);
        this.logger.log(-2137614336, buffer.toString());
        this.listener.responseOperatorPhoneNumber(n, string, stringArray, n2, this.getCmdList(), this.ignoreOldSession);
    }
}

