/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandList;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import org.dsi.ifc.online.OperatorCallData;

public class OperatorCallCommandListManager
extends CommandListManager {
    OperatorCallCommandList cmdList;
    private DSIHandler dsiHandler;
    private TelephoneHandler telHandler;
    private String language;

    public OperatorCallCommandListManager(String string, IFrameworkAccess iFrameworkAccess, DSIHandler dSIHandler, TelephoneHandler telephoneHandler, String string2) {
        super(string, iFrameworkAccess, Online.getInstance().getOperatorCallLogChannel(), null, null);
        this.dsiHandler = dSIHandler;
        this.telHandler = telephoneHandler;
        this.language = string2;
        this.start();
    }

    public void startFullSequence(OperatorCallData operatorCallData, AbstractOperatorCall abstractOperatorCall) {
        this.getLogChannel().log(1000000, "OperatorCallCommandListManager#startFullSequence called");
        this.cmdList = new OperatorCallCommandList(this, this.dsiHandler, this.telHandler, abstractOperatorCall);
        this.cmdList.startFullSequence(operatorCallData);
    }

    public OperatorCallCommandList getCommandList() {
        return (OperatorCallCommandList)super.getActiveCommandList();
    }

    public void startDownloadPoi(AbstractOperatorCall abstractOperatorCall) {
        this.getLogChannel().log(1000000, "OperatorCallCommandListManager#startDownloadPoi called");
        this.cmdList = new OperatorCallCommandList(this, this.dsiHandler, abstractOperatorCall);
        this.cmdList.downloadOldResults();
    }

    public void startNewCall(OperatorCallData operatorCallData, AbstractOperatorCall abstractOperatorCall) {
        this.getLogChannel().log(1000000, "OperatorCallCommandListManager#startNewCall called");
        this.cmdList = new OperatorCallCommandList(this, this.dsiHandler, this.telHandler, abstractOperatorCall);
        this.cmdList.startNewCall(operatorCallData);
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String string) {
        this.language = string;
    }

    public void abortCall(AbstractOperatorCall abstractOperatorCall) {
        this.getLogChannel().log(1000000, "OperatorCallCommandListManager#abortCall called");
        this.cmdList = new OperatorCallCommandList(this, this.dsiHandler, this.telHandler, abstractOperatorCall);
        this.cmdList.abortCall();
    }

    public void hangupAndDownloadPoi(AbstractOperatorCall abstractOperatorCall) {
        this.getLogChannel().log(1000000, "OperatorCallCommandListManager#hangupAndDownloadPoi called");
        this.cmdList = new OperatorCallCommandList(this, this.dsiHandler, this.telHandler, abstractOperatorCall);
        this.cmdList.hangupAndDownloadPoi();
    }
}

