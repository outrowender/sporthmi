/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.setup;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.setup.SetupManager;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class SetupManager$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ SetupManager this$0;

    SetupManager$1(SetupManager setupManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = setupManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        DSIBluetooth dSIBluetooth = (DSIBluetooth)object;
        if (dSIBluetooth != null) {
            dSIBluetooth.setNotification(6, (DSIListener)this.this$0);
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
    }
}

