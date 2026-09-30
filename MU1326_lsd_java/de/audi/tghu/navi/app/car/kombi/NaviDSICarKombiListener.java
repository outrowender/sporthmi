/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car.kombi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.car.kombi.AbstractNaviDSICarKombiListner;
import de.audi.tghu.navi.app.car.kombi.ICarKombiEventsProvider;
import de.audi.tghu.navi.app.car.kombi.ICarKombiObserver;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.carkombi.BCViewOptions;

public class NaviDSICarKombiListener
extends AbstractNaviDSICarKombiListner
implements ICarKombiEventsProvider {
    private final LogChannel logChannel;
    private final ArrayList observersList;
    private BCViewOptions lastBCViewOptions = null;

    public NaviDSICarKombiListener(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.observersList = new ArrayList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        this.logChannel.log(1000000, "NaviDSICarKombiListener#updateBCViewOptions( %1, %2 )", (Object)bCViewOptions, (long)n);
        if (n != 1) {
            this.logChannel.log(1000000, "NaviDSICarKombiListener#updateBCViewOptions() - update is invalid");
            return;
        }
        if (bCViewOptions == null) {
            this.logChannel.log(1000000, "NaviDSICarKombiListener#updateBCViewOptions() - options are null");
            return;
        }
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            Iterator iterator = this.observersList.iterator();
            while (iterator.hasNext()) {
                try {
                    ICarKombiObserver iCarKombiObserver = (ICarKombiObserver)iterator.next();
                    iCarKombiObserver.updateBCViewOptions(bCViewOptions);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviDSICarKombiListener#updateBCViewOptions() - observer failed", (Throwable)exception);
                }
            }
            this.lastBCViewOptions = bCViewOptions;
        }
    }

    public int[] getAutoNotifications() {
        return new int[]{4};
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListener(ICarKombiObserver iCarKombiObserver) {
        ArrayList arrayList = this.observersList;
        synchronized (arrayList) {
            if (iCarKombiObserver == null) {
                throw new IllegalArgumentException();
            }
            this.observersList.add(iCarKombiObserver);
            if (this.lastBCViewOptions != null) {
                try {
                    iCarKombiObserver.updateBCViewOptions(this.lastBCViewOptions);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviDSICarKombiListener#registerListener() - observer failed", (Throwable)exception);
                }
            }
        }
    }

    public void unregisterListener(ICarKombiObserver iCarKombiObserver) {
    }
}

