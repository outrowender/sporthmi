/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import de.audi.app.combi.bap.dsi.fastlist.navi.NullDSIFastListScrollingNavigation;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;
import org.dsi.ifc.kombifastlist.DataInitials;

public class DSIFastListNavi
implements IDSIFastListNavi {
    protected final LogChannel dsiLogChannel = CombiLogger.getFastListDSILog();
    protected DSIFastListScrollingNavigation dsi = new NullDSIFastListScrollingNavigation(this.dsiLogChannel);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation;

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (!this.getDSIClass().isAssignableFrom(super.getClass())) {
            throw new IllegalArgumentException(new StringBuffer().append("dsi must be of class ").append(this.getDSIClass().getName()).toString());
        }
        this.dsiLogChannel.log(-2137614336, "[DSIFastListNavi#setDSI] called (dsi=%1)", (Object)dSIBase);
        this.dsi = (DSIFastListScrollingNavigation)dSIBase;
    }

    @Override
    public DSIBase getDSI() {
        return this.dsi;
    }

    @Override
    public Class getDSIClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation = DSIFastListNavi.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation;
    }

    @Override
    public void deregisterDSI() {
        this.dsi = new NullDSIFastListScrollingNavigation(this.dsiLogChannel);
    }

    @Override
    public void pushMOSTOperationState(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavi#pushMOSTOperationStateNavigation] opState=%1", (long)n);
        this.dsi.pushMOSTOperationStateNavigation(n);
    }

    @Override
    public void pushFunctionAvailabilityNavigation(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavi#pushFunctionAvailabilityNavigation] functionAvailability=%1", (long)n);
        this.dsi.pushFunctionAvailabilityNavigation(n);
    }

    @Override
    public void responseGetInitialsNavigation(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavi#responseGetInitialsNavigation] aSGID=%1, tAID=%2, ...", (long)n, (long)n2);
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavi#responseGetInitialsNavigation] requestedList=%1, data.length=%2, ...", (long)n3, (long)dataInitialsArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataInitialsArray.length; ++i2) {
                buffer.append(dataInitialsArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(14808325, "[DSIFastListNavi#responseGetInitialsNavigation] DataInitials[] {\n%1}", (Object)buffer);
        }
        this.dsi.responseGetInitialsNavigation(0, n, n2, n3, dataInitialsArray);
    }

    @Override
    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavi#responseNotifyCurrentListSizesNavigation] successful=%1", bl);
        this.dsi.responseNotifyCurrentListSizesNavigation(bl);
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

