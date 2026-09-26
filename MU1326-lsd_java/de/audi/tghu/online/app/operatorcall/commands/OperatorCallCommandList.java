/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.DefaultErrorCommand;
import de.audi.tghu.online.app.operatorcall.commands.DialNumberCommand;
import de.audi.tghu.online.app.operatorcall.commands.DownloadPhoneNumberCommand;
import de.audi.tghu.online.app.operatorcall.commands.DownloadPoiCommand;
import de.audi.tghu.online.app.operatorcall.commands.HangupCommand;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.commands.PhoneCallCommand;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import org.dsi.ifc.online.OperatorCallData;

public class OperatorCallCommandList
extends CommandList {
    private AbstractOperatorCall listener;
    public DSIHandler dsiHandler;
    public TelephoneHandler telHandler;

    public OperatorCallCommandList(OperatorCallCommandListManager operatorCallCommandListManager, DSIHandler dSIHandler, TelephoneHandler telephoneHandler, AbstractOperatorCall abstractOperatorCall) {
        super(operatorCallCommandListManager);
        this.dsiHandler = dSIHandler;
        this.telHandler = telephoneHandler;
        this.listener = abstractOperatorCall;
    }

    public OperatorCallCommandList(OperatorCallCommandListManager operatorCallCommandListManager, DSIHandler dSIHandler, AbstractOperatorCall abstractOperatorCall) {
        super(operatorCallCommandListManager);
        this.dsiHandler = dSIHandler;
        this.listener = abstractOperatorCall;
    }

    public void startFullSequence(OperatorCallData operatorCallData) {
        this.add(this.createDownloadPhoneNumberCommand(false, this.listener.getLastCallAborted(), operatorCallData));
        this.add(this.createDialNumberCommand());
        this.add(this.createPhoneCallCommand());
        this.add(this.createDownloadPoiCommand());
        this.setErrorCommand(new DefaultErrorCommand(this.listener.getModelHandler()));
        this.execute("OperatorCallCommandList - start full sequence");
    }

    public void downloadOldResults() {
        this.add(this.createDownloadPoiCommand());
        this.setErrorCommand(new DefaultErrorCommand(this.listener.getModelHandler()));
        this.execute("OperatorCallCommandList -  download old results");
    }

    public void startNewCall(OperatorCallData operatorCallData) {
        this.add(this.createDownloadPhoneNumberCommand(true, this.listener.getLastCallAborted(), operatorCallData));
        this.add(this.createDialNumberCommand());
        this.add(this.createPhoneCallCommand());
        this.add(this.createDownloadPoiCommand());
        this.setErrorCommand(new DefaultErrorCommand(this.listener.getModelHandler()));
        this.execute("CallcenterCallCommandList - start new call");
    }

    public void abortCall() {
        this.add(this.createHangupCommand());
        this.setErrorCommand(new DefaultErrorCommand(this.listener.getModelHandler()));
        this.execute("OperatorCallCommandList - start hangup command");
    }

    public void hangupAndDownloadPoi() {
        this.add(this.createHangupCommand());
        this.add(this.createDownloadPoiCommand());
        this.setErrorCommand(new DefaultErrorCommand(this.listener.getModelHandler()));
        this.execute("OperatorCallCommandList - start hangupAndDownloadPoi");
    }

    protected DownloadPhoneNumberCommand createDownloadPhoneNumberCommand(boolean bl, boolean bl2, OperatorCallData operatorCallData) {
        boolean bl3 = bl || bl2;
        return new DownloadPhoneNumberCommand(this.dsiHandler, this.listener, bl3, operatorCallData);
    }

    protected DialNumberCommand createDialNumberCommand() {
        return new DialNumberCommand(this.telHandler, this.listener);
    }

    protected PhoneCallCommand createPhoneCallCommand() {
        return new PhoneCallCommand(this.listener, "Calling");
    }

    protected HangupCommand createHangupCommand() {
        return new HangupCommand(this.telHandler, this.listener);
    }

    protected DownloadPoiCommand createDownloadPoiCommand() {
        return new DownloadPoiCommand(this.dsiHandler, this.listener);
    }

    public AbstractOperatorCall getListener() {
        return this.listener;
    }
}

