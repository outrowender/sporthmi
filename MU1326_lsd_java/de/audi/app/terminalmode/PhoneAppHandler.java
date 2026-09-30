/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.terminalmode.ITerminalModeService;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.Generics;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PhoneAppHandler
implements ITerminalModeComponent {
    private static final String LOGCLASS = "PhoneAppHandler";
    private volatile IServiceTracker createServiceTracker;
    private volatile IServiceTracker updateListenerServiceTracker;
    private final GCopyOnWriteList<ITerminalModeService> terminalModeServiceList;
    private final GCopyOnWriteList<ITerminalModeUpdateListener> terminalModeUpdateListenerList;
    private volatile boolean videoFocus;
    private final IContext context;
    private final LogChannel logger;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeService;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public PhoneAppHandler(IContext iContext) {
        this.context = Preconditions.checkNotNull(iContext);
        this.logger = Preconditions.checkNotNull(iContext.getLogger().main());
        this.terminalModeServiceList = Generics.newCopyOnWriteArrayList();
        this.terminalModeUpdateListenerList = Generics.newCopyOnWriteArrayList();
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.videoFocus = false;
        this.createServiceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$terminalmode$ITerminalModeService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeService = PhoneAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                PhoneAppHandler.this.logger.log(1000000, "[%1.removedService]", (Object)PhoneAppHandler.LOGCLASS);
                if (object instanceof ITerminalModeService) {
                    PhoneAppHandler.this.logger.log(1000000, "[%1.addingService] removed service", (Object)PhoneAppHandler.LOGCLASS);
                    PhoneAppHandler.this.terminalModeServiceList.remove((ITerminalModeService)object);
                }
                PhoneAppHandler.this.context.getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = PhoneAppHandler.this.context.getServiceManager().getService(serviceReference);
                if (!(object instanceof ITerminalModeService)) {
                    PhoneAppHandler.this.logger.log(1000000, "[%1.addingService] unwanted service", (Object)PhoneAppHandler.LOGCLASS);
                    PhoneAppHandler.this.context.getServiceManager().releaseService(serviceReference);
                    return object;
                }
                ITerminalModeService iTerminalModeService = (ITerminalModeService)object;
                iTerminalModeService.updateTMVideoFocus(PhoneAppHandler.this.videoFocus);
                PhoneAppHandler.this.terminalModeServiceList.add(iTerminalModeService);
                return iTerminalModeService;
            }
        });
        this.updateListenerServiceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = PhoneAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                PhoneAppHandler.this.logger.log(1000000, "[%1.removedService]", (Object)PhoneAppHandler.LOGCLASS);
                if (object instanceof ITerminalModeUpdateListener) {
                    PhoneAppHandler.this.logger.log(1000000, "[%1.addingService] removed service", (Object)PhoneAppHandler.LOGCLASS);
                    PhoneAppHandler.this.terminalModeUpdateListenerList.remove((ITerminalModeUpdateListener)object);
                }
                PhoneAppHandler.this.context.getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = PhoneAppHandler.this.context.getServiceManager().getService(serviceReference);
                if (!(object instanceof ITerminalModeUpdateListener)) {
                    PhoneAppHandler.this.logger.log(1000000, "[%1.addingService] unwanted service", (Object)PhoneAppHandler.LOGCLASS);
                    PhoneAppHandler.this.context.getServiceManager().releaseService(serviceReference);
                    return object;
                }
                ITerminalModeUpdateListener iTerminalModeUpdateListener = (ITerminalModeUpdateListener)object;
                iTerminalModeUpdateListener.updateTMVideoFocus(PhoneAppHandler.this.videoFocus);
                PhoneAppHandler.this.terminalModeUpdateListenerList.add(iTerminalModeUpdateListener);
                return iTerminalModeUpdateListener;
            }
        });
        this.createServiceTracker.open();
        this.updateListenerServiceTracker.open();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.createServiceTracker.close();
        this.updateListenerServiceTracker.close();
    }

    public void updateVideoFocus(boolean bl) {
        this.logger.log(1000000, "[%1.updateVideoFocus] videoFocus=%2", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.videoFocus = bl;
        this.notifyTerminalModeServices(bl);
    }

    private void notifyTerminalModeServices(boolean bl) {
        this.logger.log(1000000, "[%1.notifyTerminalModeServices]", (Object)LOGCLASS);
        GIterator gIterator = this.terminalModeUpdateListenerList.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeUpdateListener)gIterator.next()).updateTMVideoFocus(bl);
        }
        gIterator = this.terminalModeServiceList.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeService)gIterator.next()).updateTMVideoFocus(bl);
        }
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

