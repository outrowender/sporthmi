/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.car.AbstractNaviDSIGeneralVehicleStatesListener;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.IVehicleStatesObserver;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.generalvehiclestates.TankInfo;

public class NaviDSIGeneralVehicleStatesListener
extends AbstractNaviDSIGeneralVehicleStatesListener
implements IVehicleStatesEventsProvider {
    private final LogChannel logChannel;
    private ArrayList observersList;

    public NaviDSIGeneralVehicleStatesListener(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.observersList = new ArrayList();
    }

    public void cleanUp() {
        this.observersList.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTankInfo(TankInfo tankInfo, int n) {
        this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateTankInfo( %1, %2 )", (Object)tankInfo, (long)n);
        if (n != 1) {
            this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateTankInfo() - update is invalid");
            return;
        }
        if (tankInfo == null) {
            this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateTankInfo() - tankInfo are null");
            return;
        }
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            Iterator iterator = this.observersList.iterator();
            while (iterator.hasNext()) {
                try {
                    IVehicleStatesObserver iVehicleStatesObserver = (IVehicleStatesObserver)iterator.next();
                    iVehicleStatesObserver.updateTankInfo(tankInfo);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviDSIGeneralVehicleStatesListener#updateBCViewOptions() - observer failed");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign( %1, %2 )", bl, (long)n);
        if (n != 1) {
            this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign() - update is invalid");
            return;
        }
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            Iterator iterator = this.observersList.iterator();
            while (iterator.hasNext()) {
                try {
                    IVehicleStatesObserver iVehicleStatesObserver = (IVehicleStatesObserver)iterator.next();
                    iVehicleStatesObserver.updateDisplayDayNightDesign(bl);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign() - observer failed");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateVehicleStandstill(boolean bl, int n) {
        this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill( %1, %2 )", bl, (long)n);
        if (n != 1) {
            this.logChannel.log(1000000, "NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill() - update is invalid");
            return;
        }
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            Iterator iterator = this.observersList.iterator();
            while (iterator.hasNext()) {
                try {
                    IVehicleStatesObserver iVehicleStatesObserver = (IVehicleStatesObserver)iterator.next();
                    iVehicleStatesObserver.updateVehicleStandstill(bl);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill() - observer failed");
                }
            }
        }
    }

    public int[] getAutoNotifications() {
        return new int[]{4, 16, 22};
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void registerListener(IVehicleStatesObserver iVehicleStatesObserver) {
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            if (iVehicleStatesObserver == null) {
                throw new IllegalArgumentException();
            }
            this.observersList.add(iVehicleStatesObserver);
        }
    }

    public void unregisterListener(IVehicleStatesObserver iVehicleStatesObserver) {
    }
}

