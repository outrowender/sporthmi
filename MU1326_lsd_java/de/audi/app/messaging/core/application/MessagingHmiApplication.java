/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.application;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

final class MessagingHmiApplication
extends AbstractMessagingComponent
implements HMIApplication {
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    MessagingHmiApplication(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = MessagingHmiApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)this, ServiceProperties.createServiceProperties());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingHmiApplication#connect] An error occurred: ", (Throwable)exception);
        }
    }

    @Override
    public int getId() {
        return 22;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
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

