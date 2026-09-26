/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.app;

import de.audi.app.car.common.ap.ActionProxyDispatcher;
import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.car.common.app.CarVMOptions;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.ICarComponent;
import de.audi.app.car.common.dump.DumpRegistry;
import de.audi.app.car.common.dump.IDumpRegistry;
import de.audi.app.car.common.lang.ILanguageUpdateDispatcher;
import de.audi.app.car.common.lang.LanguageUpdateDispatcher;
import de.audi.app.car.common.md.IMessageDispatcher;
import de.audi.app.car.common.md.MessageDispatcher;
import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.MenuEntryRegistry;
import de.audi.app.car.common.power.IPowerEventDispatcher;
import de.audi.app.car.common.power.PowerEventDispatcher;
import de.audi.app.car.common.screenstate.IPopupStateDispatcher;
import de.audi.app.car.common.screenstate.PopupStateDispatcher;
import de.audi.app.car.common.sdis.ISDISConnector;
import de.audi.app.car.common.sdis.SDISConnector;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.BundleContext;

public abstract class AbstractCarApplication
implements ICarApplication,
HMIApplication,
ITestSupportHandlerNotification {
    public static final int BOOLEAN_OPERATOR_AND;
    public static final int BOOLEAN_OPERATOR_OR;
    private final LogChannel logChan;
    private final IFrameworkAccess frameworkAccess;
    private final BundleContext bundleContext;
    protected final IActionProxyDispatcher actionProxyDispatcher;
    private final IPowerEventDispatcher powerEventDispatcher;
    private final IPopupStateDispatcher popupStateDispatcher;
    private final IMessageDispatcher messageDispatcher;
    private final ILanguageUpdateDispatcher languageUpdateDispatcher;
    private MenuEntryRegistry menuEntryRegistry;
    private DispatcherBase jobDispatcher;
    private IDumpRegistry dumpRegistry;
    private final ArrayList components;
    private final HashMap startedDSIs;
    private final CarServiceProvider hmiAppServiceProvider;
    private ITestSupportHandler testSupportHandler;
    ISDISConnector sdisConnector;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractCarApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, String string) {
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.logChan = iFrameworkAccess.getLogChannel(string);
        this.sdisConnector = new SDISConnector(this, this.logChan);
        this.actionProxyDispatcher = new ActionProxyDispatcher(this.logChan);
        this.popupStateDispatcher = new PopupStateDispatcher(this.logChan);
        this.powerEventDispatcher = new PowerEventDispatcher(this, this.logChan, bundleContext);
        this.messageDispatcher = new MessageDispatcher(this.logChan, bundleContext);
        this.languageUpdateDispatcher = new LanguageUpdateDispatcher(this, bundleContext, this.logChan);
        this.components = new ArrayList();
        this.startedDSIs = new HashMap();
        this.hmiAppServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractCarApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), this, null, bundleContext, this.logChan);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void init() {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#init] called");
        this.jobDispatcher = this.frameworkAccess.getDispatcherManager().createDispatcher(this.getApplicationName(), new JobLogger(this.getLogChannel()));
        this.jobDispatcher.start();
        this.dumpRegistry = new DumpRegistry(this);
        this.dumpRegistry.init();
        this.sdisConnector.init();
        this.actionProxyDispatcher.init();
        this.popupStateDispatcher.init();
        this.powerEventDispatcher.init();
        this.messageDispatcher.init();
        this.languageUpdateDispatcher.init();
        this.registerServices();
        this.menuEntryRegistry = new MenuEntryRegistry(this, this.getMenuEntryStructure(), CarVMOptions.carMenusVisible());
        this.menuEntryRegistry.init();
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.components.size(); ++i2) {
                ICarComponent iCarComponent = (ICarComponent)this.components.get(i2);
                try {
                    this.getLogChannel().log(1078071040, "[AbstractCarApplication#init] initialize component '%1'", (long)iCarComponent.getID());
                    iCarComponent.init();
                    continue;
                }
                catch (Exception exception) {
                    this.getLogChannel().log(1000, "[AbstractCarApplication#init] error during init component '%1'", (long)iCarComponent.getID(), (Throwable)exception);
                }
            }
        }
        this.menuEntryRegistry.notifyComponentsInitialized();
        this.testSupportHandler = new TestSupportHandler(new StringBuffer().append(this.getApplicationName()).append(" - View Options").toString(), true, false, this, this.bundleContext, this.logChan);
        this.testSupportHandler.init();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#deinit] called");
        this.testSupportHandler.deinit();
        this.deregisterServices();
        this.sdisConnector.deinit();
        Cloneable cloneable = this.components;
        synchronized (cloneable) {
            for (int i2 = 0; i2 < this.components.size(); ++i2) {
                ICarComponent iCarComponent = (ICarComponent)this.components.get(i2);
                try {
                    this.getLogChannel().log(1078071040, "[AbstractCarApplication#deinit] de-initialize component '%1'", (long)iCarComponent.getID());
                    iCarComponent.deinit();
                    continue;
                }
                catch (Exception exception) {
                    this.getLogChannel().log(1000, "[AbstractCarApplication#deinit] error during de-init component '%1'", (long)iCarComponent.getID(), (Throwable)exception);
                }
            }
        }
        this.dumpRegistry.deinit();
        this.menuEntryRegistry.deinit();
        this.actionProxyDispatcher.deinit();
        this.popupStateDispatcher.deinit();
        this.powerEventDispatcher.deinit();
        this.messageDispatcher.deinit();
        this.languageUpdateDispatcher.deinit();
        this.jobDispatcher.stop();
        this.frameworkAccess.getDispatcherManager().destroyDispatcher(this.getApplicationName());
        this.jobDispatcher = null;
        cloneable = this.startedDSIs;
        synchronized (cloneable) {
            this.startedDSIs.clear();
        }
    }

    private void registerServices() {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#registerServices] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", this.getApplicationName());
        hashtable.put("moduleID", new Integer(this.getId()));
        this.hmiAppServiceProvider.setProperties(hashtable);
        this.hmiAppServiceProvider.startService();
    }

    private void deregisterServices() {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#deregisterServices] called");
        this.hmiAppServiceProvider.stopService();
    }

    public abstract IMenuEntryStructure getMenuEntryStructure() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startDSIServiceForComponent(String string, int n) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#startDSIServiceForComponent] className='%1', instance='%2'", (Object)string, (long)n);
        HashMap hashMap = this.startedDSIs;
        synchronized (hashMap) {
            Object object = this.startedDSIs.get(string);
            if (object == null) {
                this.getFrameworkAccess().getStartupMgr().logStartupEvent(new StringBuffer().append("starting DSI ").append(string).toString());
                this.getFrameworkAccess().startDSIService(string, n);
                this.startedDSIs.put(string, new Object());
            } else {
                this.getLogChannel().log(1078071040, "[AbstractCarApplication#startDSIServiceForComponent] dsi already started");
            }
        }
    }

    @Override
    public final BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public final IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    @Override
    public final IPowerEventDispatcher getPowerEventDispatcher() {
        return this.powerEventDispatcher;
    }

    @Override
    public final IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    @Override
    public final IMenuEntryRegistry getMenuEntryRegistry() {
        return this.menuEntryRegistry;
    }

    @Override
    public final IPopupStateDispatcher getScreenStateDispatcher() {
        return this.popupStateDispatcher;
    }

    @Override
    public final IMessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    @Override
    public final ILanguageUpdateDispatcher getLanguageUpdateDispatcher() {
        return this.languageUpdateDispatcher;
    }

    @Override
    public final LogChannel getLogChannel() {
        return this.logChan;
    }

    @Override
    public final ISDISConnector getSDISConnector() {
        return this.sdisConnector;
    }

    @Override
    public CarFuncAdap getCarMenuCoding() {
        return this.frameworkAccess.getSysConstManager().getCarFuncAdaptation();
    }

    @Override
    public IDumpRegistry getDumpRegistry() {
        return this.dumpRegistry;
    }

    @Override
    public final DispatcherBase getJobDispatcher() {
        return this.jobDispatcher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addCarComponent(ICarComponent iCarComponent) {
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            this.components.add(iCarComponent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final ICarComponent getComponent(int n) {
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            Iterator iterator = this.components.iterator();
            while (iterator.hasNext()) {
                ICarComponent iCarComponent = (ICarComponent)iterator.next();
                if (iCarComponent.getID() != n) continue;
                return iCarComponent;
            }
        }
        return null;
    }

    @Override
    public abstract String getApplicationName() {
    }

    public final boolean isComponentAvailable(short s, CarFuncAdap carFuncAdap) {
        return carFuncAdap.isMenuDisplayActivated(s);
    }

    public final boolean isComponentAvailable(short[] sArray, int n, CarFuncAdap carFuncAdap) {
        switch (n) {
            case 0: {
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    if (carFuncAdap.isMenuDisplayActivated(sArray[i2])) continue;
                    return false;
                }
                return true;
            }
            case 1: {
                for (int i3 = 0; i3 < sArray.length; ++i3) {
                    if (!carFuncAdap.isMenuDisplayActivated(sArray[i3])) continue;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public abstract int getId() {
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        if (n == 13) {
            return this.getFrameworkAccess().getHmiServiceApp().getButtonModel(-1859450624);
        }
        if (n == 39) {
            return this.getFrameworkAccess().getHmiServiceApp().getButtonModel(-1842673408);
        }
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#popupVisible] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyPopupVisible(n, n2);
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#popupHidden] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyPopupHidden(n, n2);
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#popupRemoved] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyPopupRemoved(n, n2);
    }

    @Override
    public void screenVisible(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#screenVisible] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyScreenVisible(n, n2);
    }

    @Override
    public void screenHidden(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#screenHidden] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyScreenHidden(n, n2);
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#screenFadedOut] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyScreenFadedOut(n, n2);
    }

    @Override
    public void screenConnected(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractCarApplication#screenConnected] id=%1, terminal=%2", (long)n, (long)n2);
        this.getScreenStateDispatcher().notifyScreenConnected(n, n2);
    }

    @Override
    public void debugDataVisible(boolean bl) {
        if (bl) {
            this.testSupportHandler.updateData(this.createAllViewOptionsAsArray());
        } else {
            this.testSupportHandler.updateData(new String[0]);
        }
    }

    @Override
    public void commandEntrySelected(int n) {
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String[] createAllViewOptionsAsArray() {
        ArrayList arrayList = new ArrayList(500);
        arrayList.add("Received ViewOptions - NO AUTO UPDATE");
        arrayList.add("---");
        ArrayList arrayList2 = this.components;
        synchronized (arrayList2) {
            for (int i2 = 0; i2 < this.components.size(); ++i2) {
                ICarComponent iCarComponent = (ICarComponent)this.components.get(i2);
                String string = iCarComponent.getName() != null ? iCarComponent.getName() : Integer.toString(iCarComponent.getID());
                arrayList.add(string);
                try {
                    String string2 = iCarComponent.getCurrentViewOptions();
                    if (string2 == null) {
                        string2 = "not available (null)";
                    }
                    int n = 0;
                    while (n < string2.length()) {
                        int n2;
                        int n3 = n;
                        n = n2 = n3 + 38 > string2.length() ? string2.length() : n3 + 38;
                        arrayList.add(string2.substring(n3, n2));
                    }
                }
                catch (Exception exception) {
                    arrayList.add("exception occured");
                }
                arrayList.add("---");
            }
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    protected boolean isDrivingSchoolActive() {
        return this.getFrameworkAccess().getSysConst(3858) == 1;
    }

    @Override
    public int getClimateSystemVariant() {
        boolean bl = this.getCarMenuCoding().isMenuDisplayActivated((short)9);
        boolean bl2 = this.getCarMenuCoding().isMenuDisplayActivated((short)46);
        if (bl && bl2) {
            return 3;
        }
        if (bl) {
            return 1;
        }
        if (bl2) {
            return 2;
        }
        return 0;
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

