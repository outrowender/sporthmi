/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi.bap;

import de.audi.app.bap.utils.DataTypes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.RequestTypes;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.base.DSIListener;

public class NullDSIBAPService
extends NullService
implements DSIBAP {
    public NullDSIBAPService(LogChannel logChannel) {
        super(logChannel, "DSIBAP");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void getBAPState(int n) {
        Buffer buffer = new Buffer();
        buffer.append("getBAPState( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(" )");
        this.log(buffer.toString());
    }

    public void setHMIState(int n, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("setHMIState( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(", hmiState=");
        buffer.append(n2);
        buffer.append(" )");
        this.log(buffer.toString());
    }

    public void request(int n, int n2, int n3, int n4, int n5) {
        Buffer buffer = new Buffer();
        buffer.append("request( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(", fctID=");
        buffer.append(FunctionIDs.getDescription(n, n2));
        buffer.append(", dataType=");
        buffer.append(DataTypes.getDescription(n3));
        buffer.append(", requestType=");
        buffer.append(RequestTypes.getDescription(n4));
        buffer.append(" )");
        this.log(buffer.toString());
    }

    public void requestVoid(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("requestVoid( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(", fctID=");
        buffer.append(FunctionIDs.getDescription(n, n2));
        buffer.append(", requestType=");
        buffer.append(RequestTypes.getDescription(n3));
        buffer.append(" )");
        this.log(buffer.toString());
    }

    public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
        Buffer buffer = new Buffer();
        buffer.append("requestByteSequence( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(", fctID=");
        buffer.append(FunctionIDs.getDescription(n, n2));
        buffer.append(", requestType=");
        buffer.append(RequestTypes.getDescription(n3));
        buffer.append(" )");
        this.log(buffer.toString());
    }

    public void requestError(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("requestError( lsgID=");
        buffer.append(LSGIDs.getDescription(n));
        buffer.append(", fctID=");
        buffer.append(FunctionIDs.getDescription(n, n2));
        buffer.append(", errorCode=");
        buffer.append(n3);
        buffer.append(" )");
        this.log(buffer.toString());
    }
}

