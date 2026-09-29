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

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (!this.getDSIClass().isAssignableFrom(super.getClass())) {
            throw new IllegalArgumentException(new StringBuffer().append("dsi must be of class ").append(this.getDSIClass().getName()).toString());
        }
        this.dsiLogChannel.log(-2137614336, "[DSIFastListAudio#setDSI] called (dsi=%1)", (Object)dSIBase);
        this.dsi = (DSIFastListScrollingAudio)dSIBase;
    }

    @Override
    public DSIBase getDSI() {
        return this.dsi;
    }

    @Override
    public Class getDSIClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio = DSIFastListAudio.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio;
    }

    @Override
    public void deregisterDSI() {
        this.dsi = new NullDSIFastListScrollingAudio(this.dsiLogChannel);
    }

    @Override
    public final void pushMOSTOperationState(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListAudio#pushMOSTOperationStateAudio] opState=%1", (long)n);
        this.dsi.pushMOSTOperationStateAudio(n);
    }

    @Override
    public final void pushFunctionAvailabilityAudio(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListAudio#pushFunctionAvailabilityAudio] functionAvailability=%1", (long)n);
        this.dsi.pushFunctionAvailabilityAudio(n);
    }

    @Override
    public final void responseNotifyCurrentListSizeAudio(boolean bl) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListAudio#responseNotifyCurrentListSizeAudio] successful=%1", bl);
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

