/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.swdl.ude.IEApplication;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.swap.DSISWaP;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class IEActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private static final boolean SIM_ACTIVE = Boolean.getBoolean("user.data.export.simulation");
    public static final boolean KEEP_TMP_FILES = Boolean.getBoolean("user.data.export.keep.tmp.files");
    private final EngineeringApp engApp;
    private final EngineeringEnv engineeringEnv;
    private IEApplication udeApp;
    private LogChannel lc;
    private ServiceTracker tracker;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaP;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBookmark;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaPListener;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserListener;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBookmarkListener;

    public IEActivator(EngineeringApp engineeringApp, EngineeringEnv engineeringEnv) {
        this.engApp = engineeringApp;
        this.engineeringEnv = engineeringEnv;
    }

    private EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    @Override
    public void start(BundleContext bundleContext) {
        int n;
        String[] stringArray;
        super.start(bundleContext);
        if (SIM_ACTIVE && this.framework.isSimulator()) {
            try {
                System.out.println("\n=== Starting User Data Export Simulation ===\n");
                stringArray = (String[])Class.forName("de.audi.tghu.swdl.ude.sim.UdeSimActivator").newInstance();
                stringArray.start(bundleContext);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.udeApp = new IEApplication(this.engApp, this.getEngineeringEnv());
        this.engApp.setUdeApp(this.udeApp);
        this.lc = this.framework.getLogChannel("App.Swdl.UDE");
        stringArray = new String[]{(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = IEActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = IEActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = IEActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), (class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = IEActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), (class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = IEActivator.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser).getName(), (class$org$dsi$ifc$browser$DSIBrowserBookmark == null ? (class$org$dsi$ifc$browser$DSIBrowserBookmark = IEActivator.class$("org.dsi.ifc.browser.DSIBrowserBookmark")) : class$org$dsi$ifc$browser$DSIBrowserBookmark).getName()};
        this.tracker = new ServiceTracker(bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = IEActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.soundHandler, (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = IEActivator.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = IEActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.addressbookHandler, (class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = IEActivator.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = IEActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.naviHandler, (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = IEActivator.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = IEActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.encHandler, (class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = IEActivator.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener).getName(), 0);
        for (n = 0; n < this.udeApp.browserHandlers.length; ++n) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? IEActivator.class$("org.dsi.ifc.base.DSIListener") : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.browserHandlers[n], (class$org$dsi$ifc$browser$DSIBrowserListener == null ? IEActivator.class$("org.dsi.ifc.browser.DSIBrowserListener") : class$org$dsi$ifc$browser$DSIBrowserListener).getName(), n);
        }
        for (n = 0; n < this.udeApp.browserBookmarkHandlers.length; ++n) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? IEActivator.class$("org.dsi.ifc.base.DSIListener") : class$org$dsi$ifc$base$DSIListener).getName(), this.udeApp.browserBookmarkHandlers[n], (class$org$dsi$ifc$browser$DSIBrowserBookmarkListener == null ? IEActivator.class$("org.dsi.ifc.browser.DSIBrowserBookmarkListener") : class$org$dsi$ifc$browser$DSIBrowserBookmarkListener).getName(), n);
        }
    }

    public void stop() {
        this.tracker = this.closeTracker(this.tracker);
        super.stop(this.getBundleContext());
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        if (object instanceof DSIAdbSetup) {
            if (n == 0) {
                this.lc.log(-2137614336, "[IEActivator.addingService] DSIAdbSetup:%1", object);
                this.udeApp.addressbookHandler.addService(object);
                this.udeApp.addClient(this.udeApp.addressbookHandler);
                return object;
            }
            return null;
        }
        if (object instanceof DSISound) {
            this.lc.log(-2137614336, "[IEActivator.addingService] DSISound:%1", object);
            this.udeApp.soundHandler.addService(object);
            this.udeApp.addClient(this.udeApp.soundHandler);
            return object;
        }
        if (object instanceof DSINavigation) {
            this.lc.log(-2137614336, "[IEActivator.addingService] DSINavigation:%1", object);
            this.udeApp.naviHandler.addService(object);
            this.udeApp.addClient(this.udeApp.hmiNaviHandler);
            this.udeApp.addClient(this.udeApp.naviHandler);
            return object;
        }
        if (object instanceof DSISWaP) {
            this.lc.log(-2137614336, "[IEActivator.addingService] DSISWaP:%1", object);
            this.udeApp.encHandler.registerDSI((DSISWaP)object);
            return object;
        }
        if (object instanceof DSIBrowser) {
            int n2 = n;
            if (n2 < this.udeApp.browserHandlers.length) {
                this.lc.log(-2137614336, "[IEActivator.addingService] deviceInstance:%2 DSIBrowser:%1", object, (Object)n);
                this.udeApp.browserHandlers[n2].addService(object);
                this.udeApp.addClient(this.udeApp.browserHandlers[n2]);
                return object;
            }
            this.lc.log(-2137614336, "[IEActivator.addingService] IGNORED deviceInstance:%2 DSIBrowser:%1", object, (Object)n);
            return null;
        }
        if (object instanceof DSIBrowserBookmark) {
            int n3 = n;
            if (n3 < this.udeApp.browserBookmarkHandlers.length) {
                this.lc.log(-2137614336, "[IEActivator.addingService] deviceInstance:%2 DSIBrowserBookmark:%1", object, (Object)n);
                this.udeApp.browserBookmarkHandlers[n3].addService(object);
                this.udeApp.addClient(this.udeApp.browserBookmarkHandlers[n3]);
                return object;
            }
            this.lc.log(-2137614336, "[IEActivator.addingService] IGNORED deviceInstance:%2 DSIBrowserBookmark:%1", object, (Object)n);
            return null;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        this.lc.log(-2137614336, "[IEActivator.removedService] deviceInstance:%1 service:%2", (Object)n, object);
        if (object instanceof DSISWaP) {
            this.udeApp.encHandler.removeDSI((DSISWaP)object);
        } else if (object instanceof DSISound) {
            this.udeApp.removeClient(this.udeApp.soundHandler);
            this.udeApp.soundHandler.removeService(object);
        } else if (object instanceof DSINavigation) {
            this.udeApp.removeClient(this.udeApp.hmiNaviHandler);
            this.udeApp.removeClient(this.udeApp.naviHandler);
            this.udeApp.naviHandler.removeService(object);
        } else if (object instanceof DSIAdbSetup) {
            this.udeApp.removeClient(this.udeApp.addressbookHandler);
            this.udeApp.addressbookHandler.removeService(object);
        } else if (object instanceof DSIBrowser) {
            int n2 = n;
            this.udeApp.removeClient(this.udeApp.browserHandlers[n2]);
            this.udeApp.browserHandlers[n2].removeService(object);
        } else if (object instanceof DSIBrowserBookmark) {
            int n3 = n;
            this.udeApp.removeClient(this.udeApp.browserBookmarkHandlers[n3]);
            this.udeApp.browserBookmarkHandlers[n3].removeService(object);
        } else {
            this.lc.log(10000, "[IEActivator.removedService] Unexpected service %1", object);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
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

