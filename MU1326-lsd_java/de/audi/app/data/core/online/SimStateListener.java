/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.bluetooth.core.online.IConnectAppSetup;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.online.AbstractSimStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SimStateListener
extends AbstractSimStateListener
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private ServiceTracker serviceTracker;
    private IConnectAppSetup connectAppSetup;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$online$IConnectAppSetup;

    public SimStateListener(IDataApplication iDataApplication) {
        super(iDataApplication, iDataApplication.getFramework().getHmiServiceApp());
        this.bundleContext = iDataApplication.getBundleContext();
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        super.updateMESlotInfo(iTelMESlotState, iTelMESlotState2, iTelMESlotState3);
        if (this.connectAppSetup == null) {
            return;
        }
        boolean bl = iTelMESlotState3 != null && iTelMESlotState3.isSim() && iTelMESlotState3.isDevicePossiblyAvailable();
        this.connectAppSetup.updateSimState(bl);
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
        super.updateESIMInfo(string, string2, bl, bl2);
        if (this.connectAppSetup == null) {
            return;
        }
        this.connectAppSetup.updateESimState(bl);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IConnectAppSetup) {
            this.connectAppSetup = (IConnectAppSetup)object;
            return object;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectAppSetup) {
            this.connectAppSetup = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectAppSetup) {
            this.connectAppSetup = (IConnectAppSetup)object;
        }
    }

    @Override
    public void init() {
        super.init();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$app$bluetooth$core$online$IConnectAppSetup == null ? (class$de$audi$app$bluetooth$core$online$IConnectAppSetup = SimStateListener.class$("de.audi.app.bluetooth.core.online.IConnectAppSetup")) : class$de$audi$app$bluetooth$core$online$IConnectAppSetup).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    @Override
    public void deinit() {
        this.serviceTracker.close();
        this.serviceTracker = null;
        super.deinit();
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

