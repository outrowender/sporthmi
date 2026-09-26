/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.NaviDSIGeneralVehicleStatesListener;
import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DSIGeneralVehicleStatesController
implements IDSIClient,
BundleActivator {
    private final NaviDSIGeneralVehicleStatesListener dsiListener;
    private final DSIActivator dsiActivator;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public DSIGeneralVehicleStatesController(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        this.dsiListener = new NaviDSIGeneralVehicleStatesListener(logChannel);
        this.dsiActivator = new DSIActivator(iFrameworkAccess, (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DSIGeneralVehicleStatesController.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = DSIGeneralVehicleStatesController.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName(), new Integer(n), this.dsiListener, this);
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
    }

    @Override
    public int[] getAutoNotifications() {
        return this.dsiListener.getAutoNotifications();
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.dsiActivator.start(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(bundleContext);
            this.dsiListener.cleanUp();
        }
    }

    public IVehicleStatesEventsProvider getDsiCarKombiEventsProvider() {
        return this.dsiListener;
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

