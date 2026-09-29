/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.BrowserDiag
 */
package de.audi.tghu.browser.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.AbstractBrowserHandler;
import de.audi.tghu.browser.app.BOSBrowserHandler;
import de.audi.tghu.browser.app.BoardbookBrowserHandler;
import de.audi.tghu.browser.app.ContextSwitchBrowserHandler;
import de.audi.tghu.browser.app.DirectSuspendResumeBrowserHandler;
import de.audi.tghu.browser.app.LicenseBrowserHandler;
import de.mib.swdiagnosis.BrowserDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.DSIBrowserBoardbook;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class BrowserActivator
extends AbstractActivator
implements BundleActivator,
ServiceTrackerCustomizer {
    private BrowserDiag diag;
    private LogChannel logChannelActivator;
    private LogChannel logChannelBrowser;
    private LogChannel logChannelBrowserDSI;
    private ServiceTracker serviceTracker;
    private ServiceReference[] serviceReferenceDSIBrowser = new ServiceReference[8];
    private AbstractBrowserHandler[] browserHandlers = new AbstractBrowserHandler[8];
    private static final String PROPERTY_USE_BROWSER_SCROLLBAR;
    private static final int[] BROWSER_ATTRIBUTES_REMOTEHMI_WITH_SCROLLBAR;
    private static final int[] BROWSER_ATTRIBUTES_REMOTEHMI_WITHOUT_SCROLLBAR;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBoardbook;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$browser$IBrowserHandler;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBoardbookListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChannelActivator = this.framework.getLogChannel("Fw.Browser.Activator");
        this.logChannelBrowser = this.framework.getLogChannel("Fw.Browser.Main");
        this.logChannelBrowserDSI = this.framework.getLogChannel("Fw.Browser.DSI");
        this.registerServices();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser).getName(), (class$org$dsi$ifc$browser$DSIBrowserBoardbook == null ? (class$org$dsi$ifc$browser$DSIBrowserBoardbook = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowserBoardbook")) : class$org$dsi$ifc$browser$DSIBrowserBoardbook).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = BrowserActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    private void registerServices() {
        this.createAndRegisterBrowserHandler(7);
        this.createAndRegisterBrowserHandler(1);
        if (this.framework.getSysConst(459) == 1) {
            this.createAndRegisterBrowserHandler(2);
            if (this.framework.getSysConst(487) == 1) {
                this.createAndRegisterBrowserHandler(3);
            }
            if (this.framework.getSysConst(479) == 1) {
                this.createAndRegisterBrowserHandler(4);
            }
        }
        this.createAndRegisterBrowserHandler(5);
        this.createAndRegisterBrowserHandler(6);
    }

    private void createAndRegisterBrowserHandler(int n) {
        if (this.browserHandlers[n] == null) {
            Object object;
            switch (n) {
                case 0: {
                    this.browserHandlers[n] = new DirectSuspendResumeBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    break;
                }
                case 7: {
                    this.browserHandlers[n] = new BoardbookBrowserHandler(this.framework, this.logChannelBrowser, this.logChannelBrowserDSI);
                    break;
                }
                case 1: {
                    this.browserHandlers[n] = new LicenseBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    this.browserHandlers[n].setAttributes(BROWSER_ATTRIBUTES_REMOTEHMI_WITH_SCROLLBAR);
                    break;
                }
                case 2: {
                    this.browserHandlers[n] = new ContextSwitchBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    break;
                }
                case 3: {
                    this.browserHandlers[n] = new BOSBrowserHandler(this.framework, this.logChannelBrowser, this.logChannelBrowserDSI);
                    break;
                }
                case 4: {
                    this.browserHandlers[n] = new ContextSwitchBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    break;
                }
                case 5: {
                    object = new ContextSwitchBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    ((AbstractBrowserHandler)object).setAttributes(BROWSER_ATTRIBUTES_REMOTEHMI_WITH_SCROLLBAR);
                    this.browserHandlers[n] = object;
                    break;
                }
                case 6: {
                    ContextSwitchBrowserHandler contextSwitchBrowserHandler = new ContextSwitchBrowserHandler(this.framework, n, this.logChannelBrowser, this.logChannelBrowserDSI);
                    if (System.getProperty("RemoteHMIUseBrowserScrollbar") == null || Boolean.getBoolean("RemoteHMIUseBrowserScrollbar")) {
                        contextSwitchBrowserHandler.setAttributes(BROWSER_ATTRIBUTES_REMOTEHMI_WITHOUT_SCROLLBAR);
                    } else {
                        contextSwitchBrowserHandler.setAttributes(BROWSER_ATTRIBUTES_REMOTEHMI_WITH_SCROLLBAR);
                    }
                    this.browserHandlers[n] = contextSwitchBrowserHandler;
                    break;
                }
            }
            this.logChannelActivator.log(-2137614336, "BrowserActivator::createAndRegisterBrowserHandler() - registering handler for instance %1", (long)n);
            object = new Hashtable();
            ((Hashtable)object).put("DEVICE_NAME", (class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = BrowserActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName());
            ((Hashtable)object).put("DEVICE_INSTANCE", new Integer(n));
            this.registerService((class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = BrowserActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName(), (Object)this.browserHandlers[n], (Dictionary)object);
            object = new Hashtable();
            ((Hashtable)object).put("DEVICE_NAME", (class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = BrowserActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName());
            ((Hashtable)object).put("DEVICE_INSTANCE", new Integer(n));
            ((Hashtable)object).put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = BrowserActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.browserHandlers[n], (Dictionary)object);
        }
    }

    private void registerDSIBrowserListener(int n) {
        if (this.browserHandlers[n] != null) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$browser$DSIBrowserListener == null ? (class$org$dsi$ifc$browser$DSIBrowserListener = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowserListener")) : class$org$dsi$ifc$browser$DSIBrowserListener).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(n));
            this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = BrowserActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.browserHandlers[n], (Dictionary)hashtable);
        }
    }

    private void registerDSIBrowserBoardbookListener() {
        if (this.browserHandlers[7] != null) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$browser$DSIBrowserBoardbookListener == null ? (class$org$dsi$ifc$browser$DSIBrowserBoardbookListener = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowserBoardbookListener")) : class$org$dsi$ifc$browser$DSIBrowserBoardbookListener).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = BrowserActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.browserHandlers[7], (Dictionary)hashtable);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.serviceTracker = this.closeTracker(this.serviceTracker);
        for (int i2 = 0; i2 < this.serviceReferenceDSIBrowser.length; ++i2) {
            if (this.serviceReferenceDSIBrowser[i2] == null) continue;
            this.bundleContext.ungetService(this.serviceReferenceDSIBrowser[i2]);
            this.serviceReferenceDSIBrowser[i2] = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.logChannelActivator.log(-2137614336, "BrowserActivator::addingService(%1)", object2);
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.getBrowserDiag());
        } else {
            if ((class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser).getName().equals(object2)) {
                return this.addDSIBrowser(serviceReference, object3);
            }
            if ((class$org$dsi$ifc$browser$DSIBrowserBoardbook == null ? (class$org$dsi$ifc$browser$DSIBrowserBoardbook = BrowserActivator.class$("org.dsi.ifc.browser.DSIBrowserBoardbook")) : class$org$dsi$ifc$browser$DSIBrowserBoardbook).getName().equals(object2)) {
                return this.addDSIBrowserBoardbook(serviceReference, object3);
            }
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIBrowser) {
            Object object2 = serviceReference.getProperty("DEVICE_INSTANCE");
            this.removeDSIBrowser(object2);
        }
    }

    private Object addDSIBrowser(ServiceReference serviceReference, Object object) {
        DSIBrowser dSIBrowser = null;
        int n = -1;
        if (!IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_TEST.equals(object)) {
            if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_POI.equals(object)) {
                n = 2;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_POI)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOS.equals(object)) {
                n = 3;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_BOS)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_GE.equals(object)) {
                n = 4;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_GE)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOARDBOOK.equals(object)) {
                n = 7;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_BOARDBOOK)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_DAB.equals(object)) {
                n = 1;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_DAB)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI.equals(object)) {
                n = 5;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_REMOTEHMI)");
            } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN.equals(object)) {
                n = 6;
                this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowser(INSTANCE_REMOTEHMI_FULLSCREEN)");
            } else {
                this.logChannelActivator.log(10000, "BrowserActivator::addDSIBrowser() - unknown service: %1", object);
            }
        }
        if (n != -1) {
            this.serviceReferenceDSIBrowser[n] = serviceReference;
            dSIBrowser = (DSIBrowser)this.bundleContext.getService(serviceReference);
            if (this.browserHandlers[n] != null) {
                this.browserHandlers[n].setDSIBrowser(dSIBrowser);
                this.registerDSIBrowserListener(n);
            }
        }
        return dSIBrowser;
    }

    private Object addDSIBrowserBoardbook(ServiceReference serviceReference, Object object) {
        DSIBrowserBoardbook dSIBrowserBoardbook = null;
        this.logChannelActivator.log(-2137614336, "BrowserActivator::addDSIBrowserBoardbook (%1)", object);
        dSIBrowserBoardbook = (DSIBrowserBoardbook)this.bundleContext.getService(serviceReference);
        if (this.browserHandlers[7] != null) {
            ((BoardbookBrowserHandler)this.browserHandlers[7]).setDSIBrowserBoardbook(dSIBrowserBoardbook);
            this.registerDSIBrowserBoardbookListener();
        }
        return dSIBrowserBoardbook;
    }

    private void removeDSIBrowser(Object object) {
        int n = -1;
        if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_TEST.equals(object)) {
            n = 0;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_POI.equals(object)) {
            n = 2;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOS.equals(object)) {
            n = 3;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_GE.equals(object)) {
            n = 4;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOARDBOOK.equals(object)) {
            n = 7;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_DAB.equals(object)) {
            n = 1;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI.equals(object)) {
            n = 5;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN.equals(object)) {
            n = 6;
        }
        if (n != -1) {
            this.logChannelActivator.log(-2137614336, "BrowserActivator::removeDSIBrowser (%1)", (long)n);
            this.browserHandlers[n].setDSIBrowser(null);
            this.browserHandlers[n] = null;
        }
    }

    private BrowserDiag getBrowserDiag() {
        if (this.diag == null) {
            this.diag = new BrowserDiag((IBrowserHandler)this.browserHandlers[7]);
        }
        return this.diag;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        BROWSER_ATTRIBUTES_REMOTEHMI_WITH_SCROLLBAR = new int[]{3, 1, 2, 4, 10, 7, 13};
        BROWSER_ATTRIBUTES_REMOTEHMI_WITHOUT_SCROLLBAR = new int[]{3, 1, 2, 4, 10, 7};
    }
}

