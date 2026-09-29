/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi.bap;

import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.dsi.bap.NullDSIBAPService;
import de.audi.app.bap.utils.DataTypes;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.LoggingUtils;
import de.audi.app.bap.utils.RequestTypes;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.base.DSIBase;

public final class DSIBAPController
implements IDSIBAPController {
    private static final String LOG_CLASS;
    private final LogChannel dsiLogChannel;
    private final DSIBAP nullDsiBap;
    private volatile DSIBAP dsiBAP;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAP;

    public DSIBAPController(LogChannel logChannel) {
        this.dsiLogChannel = logChannel;
        this.dsiBAP = this.nullDsiBap = new NullDSIBAPService(this.dsiLogChannel);
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsiLogChannel.log(14808325, "[%1#setDSI] called (dsi=%2)", (Object)"DSIBAPController", (Object)dSIBase);
        if (dSIBase == null) {
            this.dsiLogChannel.log(14808325, "[%1#setDSI] DSI is being deregistered", (Object)"DSIBAPController");
            this.dsiBAP = this.nullDsiBap;
        } else {
            this.dsiBAP = (DSIBAP)dSIBase;
        }
    }

    @Override
    public boolean isDSIBAPAvailable() {
        return !this.dsiBAP.equals(this.nullDsiBap);
    }

    @Override
    public DSIBase getDSI() {
        return this.dsiBAP;
    }

    @Override
    public void deregisterDSI() {
        this.dsiBAP = this.nullDsiBap;
    }

    @Override
    public Class getDSIClass() {
        return class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = DSIBAPController.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP;
    }

    @Override
    public void getBAPState(int n) {
        this.dsiLogChannel.log(14808325, "[%1#getBAPState] lsgID: %2", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n));
        this.dsiBAP.getBAPState(n);
    }

    @Override
    public void request(int n, int n2, int n3, int n4, int n5) {
        this.dsiLogChannel.log(14808325, "[%1#request] lsgID: %2, fctID: %3", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
        this.dsiLogChannel.log(14808325, "[%1#request] ... dataType: %2, requestType: %3", (Object)"DSIBAPController", (Object)DataTypes.getDescription(n3), (Object)RequestTypes.getDescription(n4));
        this.dsiLogChannel.log(14808325, "[%1#request] ... data: %2", (Object)"DSIBAPController", (long)n5);
        this.dsiBAP.request(n, n2, n3, n4, n5);
    }

    @Override
    public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
        this.dsiLogChannel.log(14808325, "[%1#requestByteSequence] lsgID: %2, fctID: %3", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
        this.dsiLogChannel.log(14808325, "[%1#requestByteSequence] ... requestType: %2", (Object)"DSIBAPController", (Object)RequestTypes.getDescription(n3));
        this.dsiLogChannel.log(14808325, "[%1#requestByteSequence] ... data[%2 byte(s)]: %3", (Object)"DSIBAPController", (Object)new Integer(byArray.length), (Object)byArray);
        this.dsiBAP.requestByteSequence(n, n2, n3, byArray);
    }

    @Override
    public void requestError(int n, int n2, int n3) {
        this.dsiLogChannel.log(14808325, "[%1#requestError] lsgID: %2, fctID: %3, errorCode: %4", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)ErrorCodes.getDescription(n, n3));
        this.dsiBAP.requestError(n, n2, n3);
    }

    @Override
    public void requestVoid(int n, int n2, int n3) {
        this.dsiLogChannel.log(14808325, "[%1#requestVoid] lsgID: %2, fctID: %3", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
        this.dsiLogChannel.log(14808325, "[%1#requestVoid] ... requestType: %2", (Object)"DSIBAPController", (Object)RequestTypes.getDescription(n3));
        this.dsiBAP.requestVoid(n, n2, n3);
    }

    @Override
    public void setHMIState(int n, int n2) {
        this.dsiLogChannel.log(14808325, "[%1#setHMIState] lsgID: %2, hmiState: %3", (Object)"DSIBAPController", (Object)LSGIDs.getDescription(n), (Object)LoggingUtils.getHMIStateDescription(n2));
        this.dsiBAP.setHMIState(n, n2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

