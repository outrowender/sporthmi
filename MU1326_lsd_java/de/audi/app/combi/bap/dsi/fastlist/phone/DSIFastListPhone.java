/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import de.audi.app.combi.bap.dsi.fastlist.phone.NullDSIFastListScrollingTelephone;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;
import org.dsi.ifc.kombifastlist.DataInitials;

public class DSIFastListPhone
implements IDSIFastListPhone {
    protected final LogChannel dsiLogChannel = CombiLogger.getFastListDSILog();
    protected DSIFastListScrollingTelephone dsi = new NullDSIFastListScrollingTelephone(this.dsiLogChannel);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone;

    public void setDSI(DSIBase dSIBase) {
        if (!this.getDSIClass().isAssignableFrom(dSIBase.getClass())) {
            throw new IllegalArgumentException(new StringBuffer().append("dsi must be of class ").append(this.getDSIClass().getName()).toString());
        }
        this.dsiLogChannel.log(10000000, "[DSIFastListPhone#setDSI] called (dsi=%1)", (Object)dSIBase);
        this.dsi = (DSIFastListScrollingTelephone)dSIBase;
    }

    public DSIBase getDSI() {
        return this.dsi;
    }

    public void deregisterDSI() {
        this.dsi = new NullDSIFastListScrollingTelephone(this.dsiLogChannel);
    }

    public Class getDSIClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone = DSIFastListPhone.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone;
    }

    public final void pushMOSTOperationState(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhone#pushMOSTOperationStateTelephone] opState=%1", (long)n);
        this.dsi.pushMOSTOperationStateTelephone((short)n);
    }

    public final void pushFunctionAvailabilityTelephone(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhone#pushFunctionAvailabilityTelephone] functionAvailability=%1", (long)n);
        this.dsi.pushFunctionAvailabilityTelephone(n);
    }

    public final void responseGetInitialsTelephone(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhone#responseGetInitialsTelephone] aSGID=%1, tAID=%2, ...", (long)n, (long)n2);
        this.dsiLogChannel.log(1000000, "[DSIFastListPhone#responseGetInitialsTelephone] requestedList=%1, data.length=%2, ...", (long)n3, (long)dataInitialsArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataInitialsArray.length; ++i2) {
                buffer.append(dataInitialsArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(100000000, "[DSIFastListPhone#responseGetInitialsTelephone] DataInitials[] {\n%1}", (Object)buffer);
        }
        this.dsi.responseGetInitialsTelephone(0, n, n2, n3, dataInitialsArray);
    }

    public final void responseNotifyCurrentListSizesTelephone(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhone#responseNotifyCurrentListSizesTelephone] successful=%1", bl);
        this.dsi.responseNotifyCurrentListSizes(bl);
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

