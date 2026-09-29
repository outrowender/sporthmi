/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.EulaManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class EulaManager$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ EulaManager this$0;

    EulaManager$1(EulaManager eulaManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = eulaManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        DSIAdbUserProfile dSIAdbUserProfile = (DSIAdbUserProfile)object;
        if (dSIAdbUserProfile != null) {
            dSIAdbUserProfile.setNotification(2, (DSIListener)this.this$0);
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
    }
}

