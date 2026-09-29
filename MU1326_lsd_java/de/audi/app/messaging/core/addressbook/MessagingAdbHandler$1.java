/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MessagingAdbHandler$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MessagingAdbHandler this$0;

    MessagingAdbHandler$1(MessagingAdbHandler messagingAdbHandler, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = messagingAdbHandler;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIAdbEdit) {
            ADBDSIAccess aDBDSIAccess = this.this$0.getADBDSIAccess();
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            aDBDSIAccess.setDSIAdbEdit((DSIAdbEdit)object, aDBDSIListener);
        } else if (object instanceof DSIAdbList) {
            ADBDSIAccess aDBDSIAccess = this.this$0.getADBDSIAccess();
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            aDBDSIAccess.setDSIAdbList((DSIAdbList)object, aDBDSIListener);
        } else if (object instanceof DSIAdbUserProfile) {
            ADBDSIAccess aDBDSIAccess = this.this$0.getADBDSIAccess();
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            aDBDSIAccess.setDSIAdbUserProfile((DSIAdbUserProfile)object, aDBDSIListener);
        } else if (object instanceof DSIAdbSetup) {
            ADBDSIAccess aDBDSIAccess = this.this$0.getADBDSIAccess();
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            aDBDSIAccess.setDSIAdbSetup((DSIAdbSetup)object, aDBDSIListener);
        } else {
            this.this$0.setADBNaviService((NaviADBService)object);
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIAdbEdit) {
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            this.this$0.getADBDSIAccess().clearDSIAdbEdit(aDBDSIListener);
        } else if (object instanceof DSIAdbList) {
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            this.this$0.getADBDSIAccess().clearDSIAdbList(aDBDSIListener);
        } else if (object instanceof DSIAdbUserProfile) {
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            this.this$0.getADBDSIAccess().clearDSIAdbUserProfile(aDBDSIListener);
        } else if (object instanceof DSIAdbSetup) {
            ADBDSIListener aDBDSIListener = this.this$0.getADBDSIListener();
            this.this$0.getADBDSIAccess().clearDSIAdbSetup(aDBDSIListener);
        } else {
            this.this$0.setADBNaviService(null);
        }
    }
}

