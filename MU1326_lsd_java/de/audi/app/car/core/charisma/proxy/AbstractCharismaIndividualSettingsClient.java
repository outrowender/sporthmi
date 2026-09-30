/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsClient;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractCharismaIndividualSettingsClient
implements ICharismaIndividualSettingsClient {
    protected final ICarApplication application;
    protected final LogChannel logChannel;
    protected ServiceTracker serviceTracker;
    protected ICharismaIndividualSettingsProxy proxy;
    static /* synthetic */ Class class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy;

    public AbstractCharismaIndividualSettingsClient(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    public void initTracker() {
        this.serviceTracker = new ServiceTracker(this.application.getBundleContext(), (class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy == null ? (class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy = AbstractCharismaIndividualSettingsClient.class$("de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy")) : class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = AbstractCharismaIndividualSettingsClient.this.application.getBundleContext().getService(serviceReference);
                if (object instanceof ICharismaIndividualSettingsProxy) {
                    AbstractCharismaIndividualSettingsClient.this.proxy = (ICharismaIndividualSettingsProxy)object;
                    AbstractCharismaIndividualSettingsClient.this.proxy.registerClient(AbstractCharismaIndividualSettingsClient.this);
                }
                return object;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AbstractCharismaIndividualSettingsClient.this.proxy = null;
                AbstractCharismaIndividualSettingsClient.this.application.getBundleContext().ungetService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.serviceTracker.open();
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

