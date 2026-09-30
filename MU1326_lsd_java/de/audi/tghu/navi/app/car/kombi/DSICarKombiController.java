/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car.kombi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.car.kombi.ICarKombiEventsProvider;
import de.audi.tghu.navi.app.car.kombi.NaviDSICarKombiListener;
import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DSICarKombiController
implements IDSIClient,
BundleActivator {
    private final NaviDSICarKombiListener dsiCarKombiListener;
    private final int carKombiInstance;
    private final DSIActivator dsiActivator;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    public DSICarKombiController(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        this.carKombiInstance = n;
        this.dsiCarKombiListener = new NaviDSICarKombiListener(logChannel);
        this.dsiActivator = new DSIActivator(iFrameworkAccess, (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = DSICarKombiController.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName(), (class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = DSICarKombiController.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener).getName(), new Integer(this.carKombiInstance), this.dsiCarKombiListener, this);
    }

    public void setDSI(DSIBase dSIBase) {
    }

    public int[] getAutoNotifications() {
        return this.dsiCarKombiListener.getAutoNotifications();
    }

    public void start(BundleContext bundleContext) {
        this.dsiActivator.start(bundleContext);
    }

    public void stop(BundleContext bundleContext) {
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(bundleContext);
        }
    }

    public ICarKombiEventsProvider getDsiCarKombiEventsProvider() {
        return this.dsiCarKombiListener;
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

