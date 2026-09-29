/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler$1;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler$2;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler$3;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.audi.tghu.online.app.operatorcall.listener.OperatorCallDefaultListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCall;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallData;
import org.dsi.ifc.online.OperatorCallResult;

public class DSIHandler
implements ICommandResponseSupplier,
DSIOperatorCall,
DSIOperatorCallListener {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private DSIOperatorCall dsi;
    private OperatorCallDefaultListener defaultListener;
    private AbstractOperatorCallMain distributor;

    public DSIHandler(AbstractOperatorCallMain abstractOperatorCallMain) {
        this.distributor = abstractOperatorCallMain;
        this.defaultListener = new OperatorCallDefaultListener();
    }

    public void setDSI(DSIOperatorCall dSIOperatorCall) {
        if (dSIOperatorCall == null) {
            this.logChannel.log(1078071040, "DSIHandler#setDSI: removing dsi");
            this.dsi = dSIOperatorCall;
        } else if (this.dsi != null) {
            this.logChannel.log(-1601830656, "DSIHandler#setDSI: a dsi already exists. The new dsi is ignored!");
        } else {
            this.logChannel.log(-2137614336, "DSIHandler#setDSI: a new dsi is available!");
            this.dsi = dSIOperatorCall;
        }
    }

    public void changeDSI(DSIOperatorCall dSIOperatorCall) {
        this.logChannel.log(1078071040, "DSIHandler#changeDSI ");
        if (dSIOperatorCall != null) {
            this.logChannel.log(1078071040, "DSIHandler#changeDSI: dsi already exists, change it");
        }
        this.dsi = dSIOperatorCall;
        this.dsi.setNotification(this);
    }

    public boolean isDSIAvailable() {
        boolean bl = this.dsi != null;
        boolean bl2 = TestHandler.isDsiSimulation();
        this.logChannel.log(-2137614336, "DSIHandler#isDSIAvailable: real = %1, simulation = %2", bl, bl2);
        return this.dsi != null || TestHandler.isDsiSimulation();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.distributor.getCommandListManager().getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public void setLanguage(String string) {
        this.dsi.setLanguage(string);
    }

    @Override
    public void requestOperatorCallResult(String string, int n) {
        Buffer buffer = new Buffer("DSIHandler#requestOperatorCallResult: serviceId = ");
        buffer.append(string);
        buffer.append(", serviceType = ");
        buffer.append(n);
        this.logChannel.log(1078071040, buffer.toString());
        this.dsi.requestOperatorCallResult(string, n);
    }

    @Override
    public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
        Buffer buffer = new Buffer("DSIHandler#requestOperatorPhoneNumber: serviceType = ");
        buffer.append(n);
        buffer.append(", operatorCallData = ");
        buffer.append(operatorCallData.toString());
        buffer.append(", ignoreOldSession = ");
        buffer.append(bl);
        this.logChannel.log(1078071040, buffer.toString());
        this.dsi.requestOperatorPhoneNumber(n, operatorCallData, bl);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.dsi.setNotification(nArray, dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.dsi.setNotification(n, dSIListener);
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.dsi.setNotification(dSIListener);
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.dsi.clearNotification(nArray, dSIListener);
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.dsi.clearNotification(n, dSIListener);
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.dsi.clearNotification(dSIListener);
    }

    @Override
    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.logChannel.log(1078071040, "DSIHandler#responseOperatorCallResult() passing forward...");
        CommandResponse.execute(this, new DSIHandler$1(this, n, operatorCallResultArray));
    }

    @Override
    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.logChannel.log(1078071040, "DSIHandler#responseOperatorPhoneNumber() passing forward...");
        CommandResponse.execute(this, new DSIHandler$2(this, n, string, stringArray, n2));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1078071040, "DSIHandler#asyncException() passing forward...");
        CommandResponse.execute(this, new DSIHandler$3(this, n, string, n2));
    }
}

