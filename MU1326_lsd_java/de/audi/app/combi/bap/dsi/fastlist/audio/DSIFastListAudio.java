/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import de.audi.app.combi.bap.dsi.fastlist.audio.NullDSIFastListScrollingAudio;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio;

public class DSIFastListAudio
implements IDSIFastListAudio {
    protected final LogChannel dsiLogChannel = CombiLogger.getFastListDSILog();
    protected DSIFastListScrollingAudio dsi = new NullDSIFastListScrollingAudio(this.dsiLogChannel);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio;

    public void setDSI(DSIBase dSIBase) throws IllegalArgumentException {
        if (!this.getDSIClass().isAssignableFrom(dSIBase.getClass())) {
            throw new IllegalArgumentException(new StringBuffer().append("dsi must be of class ").append(this.getDSIClass().getName()).toString());
        }
        this.dsiLogChannel.log(10000000, "[DSIFastListAudio#setDSI] called (dsi=%1)", (Object)dSIBase);
        this.dsi = (DSIFastListScrollingAudio)dSIBase;
    }

    public DSIBase getDSI() {
        return this.dsi;
    }

    public Class getDSIClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio = DSIFastListAudio.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio;
    }

    public void deregisterDSI() {
        this.dsi = new NullDSIFastListScrollingAudio(this.dsiLogChannel);
    }

    public final void pushMOSTOperationState(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListAudio#pushMOSTOperationStateAudio] opState=%1", (long)n);
        this.dsi.pushMOSTOperationStateAudio(n);
    }

    public final void pushFunctionAvailabilityAudio(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListAudio#pushFunctionAvailabilityAudio] functionAvailability=%1", (long)n);
        this.dsi.pushFunctionAvailabilityAudio(n);
    }

    public final void responseNotifyCurrentListSizeAudio(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListAudio#responseNotifyCurrentListSizeAudio] successful=%1", bl);
        this.dsi.responseNotifyCurrentListSizeAudio(bl);
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

