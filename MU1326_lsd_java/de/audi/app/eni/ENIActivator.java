/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.AbstractENIActivator;
import de.audi.app.eni.ENIGateway;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices;
import de.audi.atip.interapp.eni.ENIMobileKeyListener;
import de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener;
import de.audi.atip.interapp.eni.ENIServiceEcallListener;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ENIActivator
extends AbstractENIActivator
implements ServiceTrackerCustomizer {
    private volatile DispatcherBase dispatcher;
    private volatile ServiceTracker serviceTracker;
    private final List trackedServices = Collections.synchronizedList(new ArrayList());
    private volatile BAPServiceENI bapServiceENI;
    private volatile BAPServiceRemoteServices remoteService;
    private volatile ENIServiceEcallListener eniServiceEcallListener;
    private volatile ENIServiceOnlineListener eniServiceOnlineListener;
    private volatile ENIMobileKeyListener eniMobileKeyListener;
    private volatile ENIMobileKeyStatusDisplayListener eniMobileKeyStatusDisplayListener;
    private final List providedServices = Collections.synchronizedList(new ArrayList());
    private ENIGateway eniGateway;
    private IFrameworkAccess frameworkAccess;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENI;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceEcallListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceOnlineListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIMobileKeyListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceEcall;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceOnline;

    public final void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.initCore();
        this.getLogMain().log(1000000, "ENIActivator#start: called");
        this.dispatcher = this.getFramework().getDispatcherManager().createDispatcher("App.ENI", new JobLogger(this.getLogMain()));
        this.dispatcher.start();
        this.eniGateway = new ENIGateway(this.dispatcher, this.getLogMain());
        try {
            String[] stringArray = new String[]{(class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = ENIActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName(), (class$de$audi$atip$interapp$bap$eni$BAPServiceENI == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENI = ENIActivator.class$("de.audi.atip.interapp.bap.eni.BAPServiceENI")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENI).getName(), (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices == null ? (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices = ENIActivator.class$("de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices")) : class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices).getName(), (class$de$audi$atip$interapp$eni$ENIServiceEcallListener == null ? (class$de$audi$atip$interapp$eni$ENIServiceEcallListener = ENIActivator.class$("de.audi.atip.interapp.eni.ENIServiceEcallListener")) : class$de$audi$atip$interapp$eni$ENIServiceEcallListener).getName(), (class$de$audi$atip$interapp$eni$ENIServiceOnlineListener == null ? (class$de$audi$atip$interapp$eni$ENIServiceOnlineListener = ENIActivator.class$("de.audi.atip.interapp.eni.ENIServiceOnlineListener")) : class$de$audi$atip$interapp$eni$ENIServiceOnlineListener).getName(), (class$de$audi$atip$interapp$eni$ENIMobileKeyListener == null ? (class$de$audi$atip$interapp$eni$ENIMobileKeyListener = ENIActivator.class$("de.audi.atip.interapp.eni.ENIMobileKeyListener")) : class$de$audi$atip$interapp$eni$ENIMobileKeyListener).getName(), (class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener == null ? (class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener = ENIActivator.class$("de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener")) : class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener).getName()};
            this.serviceTracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
            this.serviceTracker.open();
        }
        catch (Exception exception) {
            this.getLogMain().log(10000, "ENIActivator#start: %1", (Throwable)exception);
        }
    }

    public final void stop(BundleContext bundleContext) {
        Object object;
        this.getLogMain().log(1000000, "ENIActivator#stop: called");
        super.stop(bundleContext);
        this.serviceTracker.close();
        this.serviceTracker = null;
        Iterator iterator = this.trackedServices.iterator();
        while (iterator.hasNext()) {
            object = (ServiceReference)iterator.next();
            this.bundleContext.ungetService((ServiceReference)object);
            iterator.remove();
        }
        this.bapServiceENI = null;
        this.eniServiceEcallListener = null;
        this.eniServiceOnlineListener = null;
        iterator = this.providedServices.iterator();
        while (iterator.hasNext()) {
            object = (ServiceRegistration)iterator.next();
            object.unregister();
            iterator.remove();
        }
        this.dispatcher.suspend();
        this.dispatcher.stop();
        this.getFramework().getDispatcherManager().destroyDispatcher(this.dispatcher.getName());
        this.dispatcher = null;
        this.cleanupCore();
    }

    public final Object addingService(final ServiceReference serviceReference) {
        final Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IFrameworkAccess) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.frameworkAccess = (IFrameworkAccess)object;
                    ENIActivator.this.trackedServices.add(serviceReference);
                    ENIActivator.this.eniGateway.setFrameworkAccess(ENIActivator.this.frameworkAccess);
                }
            });
        }
        if (object instanceof BAPServiceENI) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.bapServiceENI = (BAPServiceENI)object;
                    ENIActivator.this.trackedServices.add(serviceReference);
                    ENIActivator.this.provideServices(ENIActivator.this.bapServiceENI);
                }
            });
            return object;
        }
        if (object instanceof BAPServiceRemoteServices) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.remoteService = (BAPServiceRemoteServices)object;
                    ENIActivator.this.trackedServices.add(serviceReference);
                    ENIActivator.this.eniGateway.setBAPServiceRemoteServices(ENIActivator.this.remoteService);
                }
            });
            return object;
        }
        if (object instanceof ENIServiceEcallListener) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.eniServiceEcallListener = (ENIServiceEcallListener)object;
                    ENIActivator.this.eniGateway.registerEcallListener(ENIActivator.this.eniServiceEcallListener);
                    ENIActivator.this.trackedServices.add(serviceReference);
                }
            });
            return object;
        }
        if (object instanceof ENIServiceOnlineListener) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.eniServiceOnlineListener = (ENIServiceOnlineListener)object;
                    ENIActivator.this.eniGateway.setEniServiceOnlineListener(ENIActivator.this.eniServiceOnlineListener);
                    ENIActivator.this.trackedServices.add(serviceReference);
                }
            });
            return object;
        }
        if (object instanceof ENIMobileKeyListener) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.eniMobileKeyListener = (ENIMobileKeyListener)object;
                    ENIActivator.this.eniGateway.registerMobileKeyListener(ENIActivator.this.eniMobileKeyListener);
                    ENIActivator.this.trackedServices.add(serviceReference);
                }
            });
            return object;
        }
        if (object instanceof ENIMobileKeyStatusDisplayListener) {
            this.getLogMain().log(1000000, "ENIActivator#addingService: received %1", object);
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    ENIActivator.this.eniMobileKeyStatusDisplayListener = (ENIMobileKeyStatusDisplayListener)object;
                    ENIActivator.this.eniGateway.registerMobileKeyStatusDisplayListener(ENIActivator.this.eniMobileKeyStatusDisplayListener);
                    ENIActivator.this.trackedServices.add(serviceReference);
                }
            });
            return object;
        }
        this.getLogMain().log(100000, "ENIActivator#addingService: unknown service: %1", object);
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    public final void modifiedService(ServiceReference serviceReference, Object object) {
        this.getLogMain().log(100000, "ENIActivator#modifiedService: ignored (%1)", object);
    }

    public final void removedService(final ServiceReference serviceReference, final Object object) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (ENIActivator.this.bapServiceENI.equals(object)) {
                    ENIActivator.this.bapServiceENI = null;
                    ENIActivator.this.trackedServices.remove(serviceReference);
                    ENIActivator.this.getLogMain().log(1000000, "ENIActivator#removedService: removed %1", object);
                } else if (ENIActivator.this.eniServiceEcallListener.equals(object)) {
                    ENIActivator.this.eniServiceEcallListener = null;
                    ENIActivator.this.trackedServices.remove(serviceReference);
                    ENIActivator.this.getLogMain().log(1000000, "ENIActivator#removedService: removed %1", object);
                } else if (ENIActivator.this.eniServiceOnlineListener.equals(object)) {
                    ENIActivator.this.eniServiceOnlineListener = null;
                    ENIActivator.this.trackedServices.remove(serviceReference);
                    ENIActivator.this.getLogMain().log(1000000, "ENIActivator#removedService: removed %1", object);
                } else {
                    ENIActivator.this.getLogMain().log(100000, "ENIActivator#removingService: unknown service: %1", object);
                    return;
                }
            }
        });
    }

    private void provideServices(BAPServiceENI bAPServiceENI) {
        this.provideService(class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener = ENIActivator.class$("de.audi.atip.interapp.bap.eni.BAPServiceENIListener")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener, this.eniGateway);
        this.provideService(class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener == null ? (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener = ENIActivator.class$("de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener")) : class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener, this.eniGateway);
        this.eniGateway.setBAPServiceENI(bAPServiceENI);
        this.eniGateway.setFrameworkAccess(this.frameworkAccess);
        this.provideService(class$de$audi$atip$interapp$eni$ENIServiceEcall == null ? (class$de$audi$atip$interapp$eni$ENIServiceEcall = ENIActivator.class$("de.audi.atip.interapp.eni.ENIServiceEcall")) : class$de$audi$atip$interapp$eni$ENIServiceEcall, this.eniGateway);
        this.provideService(class$de$audi$atip$interapp$eni$ENIServiceOnline == null ? (class$de$audi$atip$interapp$eni$ENIServiceOnline = ENIActivator.class$("de.audi.atip.interapp.eni.ENIServiceOnline")) : class$de$audi$atip$interapp$eni$ENIServiceOnline, this.eniGateway);
    }

    private void provideService(Class clazz, Object object) {
        Properties properties = new Properties();
        String string = clazz.getName();
        properties.put("DEVICE_NAME", string);
        this.providedServices.add(this.bundleContext.registerService(string, object, (Dictionary)properties));
        this.getLogMain().log(1000000, "ENIActivator#provideServices: provided %1", (Object)string);
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

