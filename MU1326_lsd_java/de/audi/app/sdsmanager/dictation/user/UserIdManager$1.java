/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.osgi.AbstractTrackerCustomizer;
import de.audi.app.sdsmanager.dictation.user.UserIdManager;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$DsiBluetoothListener;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$DsiTelephoneListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.telephone.DSITelephone;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class UserIdManager$1
extends AbstractTrackerCustomizer {
    private final /* synthetic */ UserIdManager this$0;

    UserIdManager$1(UserIdManager userIdManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = userIdManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        if (object != null) {
            if (object instanceof DSIBluetooth) {
                ((DSIBluetooth)object).setNotification(6, (DSIListener)new UserIdManager$DsiBluetoothListener(this.this$0, null));
            } else {
                ((DSITelephone)object).setNotification(20, (DSIListener)new UserIdManager$DsiTelephoneListener(this.this$0, null));
            }
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
    }
}

