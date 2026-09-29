/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.joker;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.joker.AbstractJokerKeyVisibilityClient$1;
import de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityClient;
import de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityProxy;
import de.audi.atip.log.LogChannel;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractJokerKeyVisibilityClient
implements ICarJokerKeyVisibilityClient {
    protected final ICarApplication application;
    protected final LogChannel logChannel;
    protected ServiceTracker serviceTracker;
    protected ICarJokerKeyVisibilityProxy proxy;
    static /* synthetic */ Class class$de$audi$atip$interapp$car$jokerkey$ICarJokerKeyVisibilityProxy;

    public AbstractJokerKeyVisibilityClient(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    public void initTracker() {
        this.serviceTracker = new ServiceTracker(this.application.getBundleContext(), (class$de$audi$atip$interapp$car$jokerkey$ICarJokerKeyVisibilityProxy == null ? (class$de$audi$atip$interapp$car$jokerkey$ICarJokerKeyVisibilityProxy = AbstractJokerKeyVisibilityClient.class$("de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityProxy")) : class$de$audi$atip$interapp$car$jokerkey$ICarJokerKeyVisibilityProxy).getName(), (ServiceTrackerCustomizer)new AbstractJokerKeyVisibilityClient$1(this));
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

