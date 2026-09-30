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
            this.logChannel.log(1000000, "DSIHandler#setDSI: removing dsi");
            this.dsi = dSIOperatorCall;
        } else if (this.dsi != null) {
            this.logChannel.log(100000, "DSIHandler#setDSI: a dsi already exists. The new dsi is ignored!");
        } else {
            this.logChannel.log(10000000, "DSIHandler#setDSI: a new dsi is available!");
            this.dsi = dSIOperatorCall;
        }
    }

    public void changeDSI(DSIOperatorCall dSIOperatorCall) {
        this.logChannel.log(1000000, "DSIHandler#changeDSI ");
        if (dSIOperatorCall != null) {
            this.logChannel.log(1000000, "DSIHandler#changeDSI: dsi already exists, change it");
        }
        this.dsi = dSIOperatorCall;
        this.dsi.setNotification(this);
    }

    public boolean isDSIAvailable() {
        boolean bl = this.dsi != null;
        boolean bl2 = TestHandler.isDsiSimulation();
        this.logChannel.log(10000000, "DSIHandler#isDSIAvailable: real = %1, simulation = %2", bl, bl2);
        return this.dsi != null || TestHandler.isDsiSimulation();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.distributor.getCommandListManager().getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public void setLanguage(String string) {
        this.dsi.setLanguage(string);
    }

    public void requestOperatorCallResult(String string, int n) {
        Buffer buffer = new Buffer("DSIHandler#requestOperatorCallResult: serviceId = ");
        buffer.append(string);
        buffer.append(", serviceType = ");
        buffer.append(n);
        this.logChannel.log(1000000, buffer.toString());
        this.dsi.requestOperatorCallResult(string, n);
    }

    public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
        Buffer buffer = new Buffer("DSIHandler#requestOperatorPhoneNumber: serviceType = ");
        buffer.append(n);
        buffer.append(", operatorCallData = ");
        buffer.append(operatorCallData.toString());
        buffer.append(", ignoreOldSession = ");
        buffer.append(bl);
        this.logChannel.log(1000000, buffer.toString());
        this.dsi.requestOperatorPhoneNumber(n, operatorCallData, bl);
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.dsi.setNotification(nArray, dSIListener);
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.dsi.setNotification(n, dSIListener);
    }

    public void setNotification(DSIListener dSIListener) {
        this.dsi.setNotification(dSIListener);
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.dsi.clearNotification(nArray, dSIListener);
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.dsi.clearNotification(n, dSIListener);
    }

    public void clearNotification(DSIListener dSIListener) {
        this.dsi.clearNotification(dSIListener);
    }

    public void responseOperatorCallResult(final int n, final OperatorCallResult[] operatorCallResultArray) {
        this.logChannel.log(1000000, "DSIHandler#responseOperatorCallResult() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOperatorCallListener)dSIListener).responseOperatorCallResult(n, operatorCallResultArray);
            }
        });
    }

    public void responseOperatorPhoneNumber(final int n, final String string, final String[] stringArray, final int n2) {
        this.logChannel.log(1000000, "DSIHandler#responseOperatorPhoneNumber() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOperatorCallListener)dSIListener).responseOperatorPhoneNumber(n, string, stringArray, n2);
            }
        });
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.logChannel.log(1000000, "DSIHandler#asyncException() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOperatorCallListener)dSIListener).asyncException(n, string, n2);
            }
        });
    }
}

