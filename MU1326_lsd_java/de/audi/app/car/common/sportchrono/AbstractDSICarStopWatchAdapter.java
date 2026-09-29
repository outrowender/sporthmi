/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sportchrono;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carstopwatch.DSICarStopWatch;
import org.dsi.ifc.carstopwatch.DSICarStopWatchListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public abstract class AbstractDSICarStopWatchAdapter
extends AbstractCarComponent
implements DSICarStopWatchListener {
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener;
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$DSICarStopWatch;

    public AbstractDSICarStopWatchAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarStopWatch getDSI() {
        return (DSICarStopWatch)this.getBaseDSI();
    }

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener == null ? (class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener = AbstractDSICarStopWatchAdapter.class$("org.dsi.ifc.carstopwatch.DSICarStopWatchListener")) : class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carstopwatch$DSICarStopWatch == null ? (class$org$dsi$ifc$carstopwatch$DSICarStopWatch = AbstractDSICarStopWatchAdapter.class$("org.dsi.ifc.carstopwatch.DSICarStopWatch")) : class$org$dsi$ifc$carstopwatch$DSICarStopWatch).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    @Override
    public void updateStopWatchViewOptions(StopWatchViewOptions stopWatchViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateStopWatchState(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateStopWatchCurrentLapNumber(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateStopWatchTotalTime(StopWatchTime stopWatchTime, int n) {
        this.logStub();
    }

    @Override
    public void updateStopWatchLastSplitTime(int n, StopWatchTime stopWatchTime, int n2) {
        this.logStub();
    }

    @Override
    public void updateStopWatchCurrentLapTime(StopWatchTime stopWatchTime, int n) {
        this.logStub();
    }

    @Override
    public void updateStopWatchLastLapTime(StopWatchTime stopWatchTime, int n) {
        this.logStub();
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

