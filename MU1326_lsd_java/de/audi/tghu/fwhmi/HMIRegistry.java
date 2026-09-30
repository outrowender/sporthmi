/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIModelBank;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.cc.ComponentConditionManager;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.view.IKeyBoardManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.FwHMI;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class HMIRegistry {
    private static final boolean DEBUG = false;
    protected final LogChannel log;
    protected final BundleContext bc;
    protected final FwHMI fwHMI;
    private HMIApplication[] hmiApps;
    private HMIBundle[] hmiBundles;
    private HMIModelBank[] hmiModelBanks;
    private final String[] trackedKeyBoardServices = new String[]{(class$de$audi$atip$hmi$IFocusManager == null ? (class$de$audi$atip$hmi$IFocusManager = HMIRegistry.class$("de.audi.atip.hmi.IFocusManager")) : class$de$audi$atip$hmi$IFocusManager).getName(), (class$de$audi$atip$hmi$view$IKeyBoardManager == null ? (class$de$audi$atip$hmi$view$IKeyBoardManager = HMIRegistry.class$("de.audi.atip.hmi.view.IKeyBoardManager")) : class$de$audi$atip$hmi$view$IKeyBoardManager).getName()};
    private Hashtable allHmiBundles = new Hashtable();
    private String currentSkin = null;
    private final ComponentConditionManager conditionsObserver;
    static /* synthetic */ Class class$de$audi$atip$hmi$IFocusManager;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IKeyBoardManager;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIModelBank;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIBundle;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    protected HMIRegistry(BundleContext bundleContext, FwHMI fwHMI) {
        this.fwHMI = fwHMI;
        this.bc = bundleContext;
        this.log = this.getFramework().getLogChannel("Fw.HMIService.Registry");
        this.log.log(1000000, "HMIRegistry: create Registry");
        this.conditionsObserver = new ComponentConditionManager(this.getFramework());
        this.initTrackers();
    }

    protected final IFrameworkAccess getFramework() {
        return this.fwHMI.getFramework();
    }

    private void initTrackers() {
        this.log.log(10000000, "HMIRegistry.initTrackers() setting up HMIModelBank, tracker");
        ServiceTracker serviceTracker = new ServiceTracker(this.bc, (class$de$audi$atip$hmi$HMIModelBank == null ? (class$de$audi$atip$hmi$HMIModelBank = HMIRegistry.class$("de.audi.atip.hmi.HMIModelBank")) : class$de$audi$atip$hmi$HMIModelBank).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = HMIRegistry.this.bc.getService(serviceReference);
                HMIRegistry.this.registerHMIModelBank((HMIModelBank)object);
                ((HMIModelBank)object).isRegistered(true);
                HMIRegistry.this.log.log(1000000, "HMIRegistry: adding HMIModelBank: service: %1,", object);
                HMIRegistry.this.dumpTables();
                return object;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                HMIRegistry.this.log.log(10000000, "HMIRegistry: removed HMIModelBank: service: %1", object);
                HMIRegistry.this.unregisterHMIModelBank((HMIModelBank)object, serviceReference);
            }
        });
        serviceTracker.open();
        this.log.log(10000000, "HMIRegistry.initTrackers() setting up HMIBundle tracker");
        ServiceTracker serviceTracker2 = new ServiceTracker(this.bc, (class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = HMIRegistry.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = null;
                Object object2 = serviceReference.getProperty("Skin");
                if (object2 != null) {
                    object = HMIRegistry.this.bc.getService(serviceReference);
                    HMIRegistry.this.registerHMIBundle((String)object2, (HMIBundle)object);
                    HMIRegistry.this.conditionsObserver.add((HMIBundle)object);
                    HMIRegistry.this.log.log(1000000, "HMIRegistry: adding HMIBundle: service: %1, skin: %2", object, object2);
                    HMIRegistry.this.dumpTables();
                } else {
                    HMIRegistry.this.log.log(100000, "HMIRegistry: adding HMIBundle failed: service: %1, no skin given!", object);
                }
                return object;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                Object object2 = serviceReference.getProperty("Skin");
                HMIRegistry.this.log.log(10000000, "HMIRegistry: removed HMIBundle: service: %1 skin: %2", object, object2);
                if (object2 != null) {
                    HMIRegistry.this.conditionsObserver.remove((HMIBundle)object);
                    HMIRegistry.this.unregisterHMIBundle((String)object2, (HMIBundle)object, serviceReference);
                } else {
                    HMIRegistry.this.log.log(100000, "HMIRegistry: removed HMIBundle failed: service: %1, no skin given!", object);
                }
            }
        });
        serviceTracker2.open();
        this.log.log(10000000, "HMIRegistry.initTrackers() setting up HMIApplication tracker");
        ServiceTracker serviceTracker3 = new ServiceTracker(this.bc, (class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = HMIRegistry.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = HMIRegistry.this.bc.getService(serviceReference);
                String string = (String)serviceReference.getProperty("ApplicationName");
                HMIRegistry.this.log.log(10000000, "HMIRegistry: adding HMIApplication: service: %1 name: %2", object, (Object)string);
                HMIRegistry.this.registerHMIApp((HMIApplication)object);
                HMIRegistry.this.dumpTables();
                HMIRegistry.this.fwHMI.checkForPostConnecting((HMIApplication)object);
                return object;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
                HMIRegistry.this.log.log(10000000, "HMIRegistry: modified HMIApplication (ignored): service: %1", object);
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                Object object2 = serviceReference.getProperty("ApplicationName");
                HMIRegistry.this.log.log(10000000, "HMIRegistry: removed HMIApplication: service: %1 applicationName: %2", object, object2);
                HMIRegistry.this.unregisterHMIApp((HMIApplication)object, serviceReference);
            }
        });
        serviceTracker3.open();
        this.log.log(10000000, "HMIRegistry.initTrackers() setting up IFocusManager tracker");
        ServiceTracker serviceTracker4 = new ServiceTracker(this.bc, this.trackedKeyBoardServices, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = HMIRegistry.this.bc.getService(serviceReference);
                if (object == null) {
                    return null;
                }
                if (object instanceof IFocusManager) {
                    HMIRegistry.this.log.log(10000000, "HMIRegistry: adding IFocusManager: service: %1 ", object);
                    HMIRegistry.this.fwHMI.setFocusManager((IFocusManager)object);
                    return object;
                }
                if (object instanceof IKeyBoardManager) {
                    HMIRegistry.this.log.log(10000000, "HMIRegistry: adding IKeyBoardManager: service: %1 ", object);
                    HMIRegistry.this.fwHMI.setKeyBoardManager((IKeyBoardManager)object);
                    return object;
                }
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof IFocusManager) {
                    HMIRegistry.this.log.log(10000000, "HMIRegistry: removed IFocusManager service: %1", object);
                    HMIRegistry.this.fwHMI.setFocusManager(null);
                } else if (object instanceof IKeyBoardManager) {
                    HMIRegistry.this.log.log(10000000, "HMIRegistry: removed IKeyBoardManager: service: %1 ", object);
                    HMIRegistry.this.fwHMI.setKeyBoardManager(null);
                }
                HMIRegistry.this.bc.ungetService(serviceReference);
                HMIRegistry.this.dumpTables();
            }
        });
        serviceTracker4.open();
    }

    private void ensureHMIModelBanksCapacity(int n) {
        if (n <= 0) {
            return;
        }
        if (this.hmiModelBanks == null) {
            this.hmiModelBanks = new HMIModelBank[n + 31 & 0xFFFFFFE0];
        } else if (this.hmiModelBanks.length < n) {
            HMIModelBank[] hMIModelBankArray = new HMIModelBank[n + 31 & 0xFFFFFFE0];
            System.arraycopy((Object)this.hmiModelBanks, 0, (Object)hMIModelBankArray, 0, this.hmiModelBanks.length);
            this.hmiModelBanks = hMIModelBankArray;
        }
    }

    private void registerHMIModelBank(HMIModelBank hMIModelBank) {
        this.ensureHMIModelBanksCapacity(hMIModelBank.getId() + 1);
        if (this.hmiModelBanks[hMIModelBank.getId()] != null) {
            this.log.log(10000000, "HMIRegistry: registerHMIModelBank(): overwriting existing ModelBank existing modelbank: %1", (Object)this.hmiModelBanks[hMIModelBank.getId()]);
        }
        this.hmiModelBanks[hMIModelBank.getId()] = hMIModelBank;
    }

    private void unregisterHMIModelBank(HMIModelBank hMIModelBank, ServiceReference serviceReference) {
        this.ensureHMIAppsCapacity(hMIModelBank.getId() + 1);
        if (hMIModelBank == this.hmiModelBanks[hMIModelBank.getId()]) {
            hMIModelBank.isRegistered(false);
            this.hmiModelBanks[hMIModelBank.getId()] = null;
        } else {
            this.log.log(10000000, "HMIRegistry: getHMIModelBank(id = %2) called; do NOT remove more recent modelbank!  serviceToRemove == %1 serviceInRegistry == %2", (Object)hMIModelBank, (Object)this.hmiModelBanks[hMIModelBank.getId()]);
        }
        this.dumpTables();
        this.bc.ungetService(serviceReference);
    }

    public HMIModelBank getHMIModelBank(int n) {
        int n2 = n / 100000;
        this.log.log(10000000, "HMIRegistry: getHMIModelBank(id = %2) called; moduleId == %1", (long)n2, (long)n);
        return null != this.hmiModelBanks && n2 >= 0 && this.hmiModelBanks.length > n2 ? this.hmiModelBanks[n2] : null;
    }

    private void ensureHMIAppsCapacity(int n) {
        if (n <= 0) {
            return;
        }
        if (this.hmiApps == null) {
            this.hmiApps = new HMIApplication[n + 31 & 0xFFFFFFE0];
        } else if (this.hmiApps.length < n) {
            HMIApplication[] hMIApplicationArray = new HMIApplication[n + 31 & 0xFFFFFFE0];
            System.arraycopy((Object)this.hmiApps, 0, (Object)hMIApplicationArray, 0, this.hmiApps.length);
            this.hmiApps = hMIApplicationArray;
        }
    }

    private void registerHMIApp(HMIApplication hMIApplication) {
        this.ensureHMIAppsCapacity(hMIApplication.getId() + 1);
        if (this.hmiApps[hMIApplication.getId()] != null) {
            this.log.log(10000000, "HMIRegistry: registerHMIApp(): overwriting existing HMIApplication: existing app: %1", (Object)this.hmiApps[hMIApplication.getId()]);
        }
        this.hmiApps[hMIApplication.getId()] = hMIApplication;
    }

    private void unregisterHMIApp(HMIApplication hMIApplication, ServiceReference serviceReference) {
        this.ensureHMIAppsCapacity(hMIApplication.getId() + 1);
        if (this.hmiApps[hMIApplication.getId()] == hMIApplication) {
            this.hmiApps[hMIApplication.getId()] = null;
        } else {
            this.log.log(10000000, "HMIRegistry: unregisterHMIApp(): do NOT remove more recent HMIApp! service to unregister: %1 actual service: %2", (Object)hMIApplication, (Object)this.hmiApps[hMIApplication.getId()]);
        }
        this.dumpTables();
        this.bc.ungetService(serviceReference);
    }

    public HMIApplication getHMIApplication(int n) {
        int n2 = n / 100000;
        this.log.log(10000000, "HMIRegistry: getHMIApplication(id = %2) called; moduleId == %1", (long)n2, (long)n);
        if (this.hmiApps == null) {
            return null;
        }
        if (n2 < 0 || this.hmiApps.length <= n2) {
            return null;
        }
        return this.hmiApps[n2];
    }

    public Screen getScreen(int n, int n2) {
        Screen screen = null;
        HMIBundle hMIBundle = this.getHMIBundle(n2);
        if (hMIBundle != null) {
            this.log.log(10000000, "HMIRegistry.getScreen(): hmiBundle == %1", (Object)hMIBundle);
            long l = this.getFramework().getMonotonicTime();
            screen = hMIBundle.getScreen(n2, n);
            this.log.log(10000000, "HMIRegistry.getScreen(%1) creating screen took: %2", (long)n2, this.getFramework().getMonotonicTime() - l);
            if (screen == null) {
                this.log.log(10000000, "HMIRegistry.getScreen(): Screen (%1) not found ", (long)n2);
            }
        } else {
            this.log.log(10000000, "HMIRegistry.getScreen(): No HMIBundle for Screen %1 ", (long)n2);
        }
        this.log.log(10000000, "HMIRegistry.getScreen(): returning %1 ", screen);
        return screen;
    }

    public final HMIModel getModel(int n, int n2) {
        try {
            HMIModel hMIModel = null;
            HMIModelBank hMIModelBank = this.getHMIModelBank(n2);
            if (hMIModelBank != null) {
                this.log.log(10000000, "HMIRegistry.getModel(): modelBank = %1, model ID = %2", (Object)hMIModelBank, (long)n2);
                hMIModel = hMIModelBank.getModel(n, n2);
                if (hMIModel == null) {
                    this.log.log(10000, "HMIRegistry.getModel(): model with id = %1 not found !!!", (long)n2);
                }
            } else {
                this.log.log(100000, "HMIRegistry.getModel(): modelBank for id=%1 not found yet !!!", (long)n2);
            }
            return hMIModel;
        }
        catch (Exception exception) {
            this.log.log(10000, "HMIRegistry.getModel(%1): failed with exception", (long)n2, (Throwable)exception);
            return null;
        }
    }

    private HMIBundle[] getHMIBundleList(String string) {
        if (string != null) {
            return (HMIBundle[])this.allHmiBundles.get(string);
        }
        return null;
    }

    private void setHMIBundleList(String string, HMIBundle[] hMIBundleArray) {
        if (string != null) {
            this.allHmiBundles.put(string, hMIBundleArray);
            if (string.equals(this.currentSkin)) {
                this.hmiBundles = hMIBundleArray;
            }
        }
    }

    private void ensureHMIBundlesCapacity(String string, int n) {
        if (n <= 0 && string != null) {
            return;
        }
        HMIBundle[] hMIBundleArray = this.getHMIBundleList(string);
        if (hMIBundleArray == null) {
            hMIBundleArray = new HMIBundle[n + 31 & 0xFFFFFFE0];
            this.setHMIBundleList(string, hMIBundleArray);
        } else if (hMIBundleArray.length < n) {
            HMIBundle[] hMIBundleArray2 = new HMIBundle[n + 31 & 0xFFFFFFE0];
            System.arraycopy((Object)hMIBundleArray, 0, (Object)hMIBundleArray2, 0, hMIBundleArray.length);
            hMIBundleArray = hMIBundleArray2;
            this.setHMIBundleList(string, hMIBundleArray);
        }
    }

    private void registerHMIBundle(String string, HMIBundle hMIBundle) {
        this.ensureHMIBundlesCapacity(string, hMIBundle.getId() + 1);
        if (this.getHMIBundleList(string)[hMIBundle.getId()] != null) {
            this.log.log(10000000, "HMIRegistry: registerHMIBundle(): overwriting existing HMIBundle skin: existing bundle: %1", (Object)this.getHMIBundleList(string)[hMIBundle.getId()]);
        }
        this.getHMIBundleList((String)string)[hMIBundle.getId()] = hMIBundle;
        this.log.log(10000000, "HMIRegistry: registerHMIBundle(): skin: %2 moduleId: %3 service: %1", (Object)hMIBundle, (Object)string, (long)hMIBundle.getId());
    }

    private void unregisterHMIBundle(String string, HMIBundle hMIBundle, ServiceReference serviceReference) {
        int n = hMIBundle.getId();
        this.ensureHMIBundlesCapacity(string, n + 1);
        if (this.getHMIBundleList(string)[n] == hMIBundle) {
            this.getHMIBundleList((String)string)[n] = null;
            this.fwHMI.getHMITerminal(0).getScreenCache().clear(n);
            this.log.log(10000000, "HMIRegistry: unregisterHMIBundle(): skin: %2 moduleId: %3 service: %1", (Object)hMIBundle, (Object)string, (long)n);
        } else {
            this.log.log(10000000, "HMIRegistry: unregisterHMIBundle(): do NOT remove more recent HMIBundle! skin: %2 moduleId: %3 service to remove: %1", (Object)hMIBundle, (Object)string, (long)n);
        }
        this.dumpTables();
        this.bc.ungetService(serviceReference);
    }

    public HMIBundle getHMIBundle(int n) {
        int n2 = n / 100000;
        this.log.log(10000000, "HMIRegistry: getHMIBundle(id = %2) called; moduleId == %1", (long)n2, (long)n);
        if (this.hmiBundles == null) {
            this.hmiBundles = this.getHMIBundleList(this.currentSkin);
        }
        if (this.hmiBundles == null) {
            this.log.log(10000, "HMIRegistry: getHMIBundle( %2 ): no HMIBundles for current skin %1!", (Object)this.currentSkin, (long)n2);
            return null;
        }
        HMIBundle hMIBundle = null;
        if (n2 >= 0 && n2 < this.hmiBundles.length) {
            hMIBundle = this.hmiBundles[n2];
        }
        if (hMIBundle == null) {
            this.log.log(10000, "HMIRegistry: getHMIBundle( %1 ): no bundle registered!", (long)n2);
        } else {
            this.log.log(10000000, "HMIRegistry: getHMIBundle(): returning %1!", hMIBundle);
        }
        return hMIBundle;
    }

    public String getText(int n) {
        this.log.log(10000000, "HMIRegistry.getText(id=%1)", (long)n);
        HMIBundle hMIBundle = this.getHMIBundle(n);
        String string = hMIBundle != null ? hMIBundle.getText(n) : "<ERROR>";
        this.log.log(10000000, "HMIRegistry.getText(id=%2): returning: '%1'", (Object)string, (long)n);
        return string;
    }

    void setSkin(String string) {
        this.log.log(10000000, "HMIRegistry: setSkin(%1) starting ...", (Object)string);
        HMIBundle[] hMIBundleArray = this.getHMIBundleList(string);
        if (hMIBundleArray != null) {
            this.hmiBundles = hMIBundleArray;
        }
        this.currentSkin = string;
        this.log.log(10000000, "HMIRegistry: setSkin(%1) finished", (Object)string);
    }

    private void dumpTables() {
    }

    public ComponentConditionManager getConditionsObserver() {
        return this.conditionsObserver;
    }

    public Screen getPartialPopup(int n, int n2) {
        Screen screen = null;
        HMIBundle hMIBundle = this.getHMIBundle(n2);
        if (hMIBundle != null) {
            this.log.log(10000000, "HMIRegistry.getPartialPopup(): hmiBundle == %1", (Object)hMIBundle);
            long l = this.getFramework().getMonotonicTime();
            screen = (Screen)((Object)hMIBundle.getPartialPopup(n2, n));
            this.log.log(10000000, "HMIRegistry.getPartialPopup(%1) creating screen took: %2", (long)n2, this.getFramework().getMonotonicTime() - l);
            if (screen == null) {
                this.log.log(10000, "HMIRegistry.getPartialPopup(): PartialPopup (%1) not found ", (long)n2);
            }
        } else {
            this.log.log(10000, "HMIRegistry.getPartialPopup(): No HMIBundle for PartialPopup %1 ", (long)n2);
        }
        this.log.log(10000000, "HMIRegistry.getPartialPopup(): returning %1 ", screen);
        return screen;
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

