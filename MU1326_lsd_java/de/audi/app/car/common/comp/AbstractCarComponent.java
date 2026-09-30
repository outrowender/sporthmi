/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.comp;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.comp.ICarComponent;
import de.audi.app.car.common.sdis.ISDISConnector;
import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.BrowserModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.CarViewOption;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractCarComponent
implements ICarComponent,
ServiceTrackerCustomizer,
DSIListener {
    private final ICarApplication application;
    private final LogChannel logChannel;
    private LogChannel logChannelDSI;
    private LogChannel logChannelMSC;
    private LogChannel logChannelFrequent;
    private volatile DSIBase dsi = null;
    private volatile ServiceRegistration serviceRegistration = null;
    private volatile ServiceTracker serviceTracker = null;
    protected CarDSIAttributesSet[] dsiSet = new CarDSIAttributesSet[0];
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public AbstractCarComponent(ICarApplication iCarApplication, String string) {
        this.application = iCarApplication;
        this.logChannel = this.application.getFrameworkAccess().getLogChannel(string);
    }

    public void init() {
        this.logChannel.log(1000000, "[AbstractCarComponent#init] called for '%1'", (Object)this.getName());
        this.dsiSet = this.getDSIAttributesSets();
        this.initModels();
        this.initVisibility();
        if (this.isUsingDSI()) {
            this.registerDSI();
        }
    }

    public void deinit() {
        this.logChannel.log(1000000, "[AbstractCarComponent#deinit] called for '%1'", (Object)this.getName());
        this.deinitVisibility();
        if (this.isUsingDSI()) {
            this.deRegisterDSI();
        }
        this.deinitModels();
    }

    protected abstract void initModels();

    protected abstract void deinitModels();

    protected abstract void initVisibility();

    protected void initBusiness() {
    }

    protected abstract void deinitVisibility();

    private void registerDSI() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", this.getDSIListenerClassName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.serviceRegistration = this.application.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractCarComponent.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, (Dictionary)hashtable);
        this.serviceTracker = new ServiceTracker(this.application.getBundleContext(), this.getDSIClassName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.getApplication().startDSIServiceForComponent(this.getDSIClassName(), 0);
    }

    private void deRegisterDSI() {
        if (this.dsi != null) {
            this.dsi.clearNotification(this);
        }
        if (this.serviceRegistration != null) {
            this.serviceRegistration.unregister();
            this.serviceRegistration = null;
        }
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
            this.serviceTracker = null;
        }
        this.dsi = null;
        CarDSIAttributesSet[] carDSIAttributesSetArray = this.dsiSet;
        for (int i2 = 0; i2 < carDSIAttributesSetArray.length; ++i2) {
            if (carDSIAttributesSetArray[i2] == null) continue;
            carDSIAttributesSetArray[i2].reset();
        }
    }

    private void setDSIAttributeNotification() {
        CarDSIAttributesSet[] carDSIAttributesSetArray = this.dsiSet;
        if (this.dsi != null) {
            for (int i2 = 0; i2 < carDSIAttributesSetArray.length; ++i2) {
                this.getLogChannel().log(1000000, "[AbstractCarComponent#setDSIAttributeNotification] for component '%2', attribute set '%1'", (long)carDSIAttributesSetArray[i2].getID(), (long)this.getID());
                CarDSIAttributesSet carDSIAttributesSet = carDSIAttributesSetArray[i2];
                if (carDSIAttributesSet.hasPrimaryAttributes()) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1000000, "[AbstractCarComponent#setDSIAttributeNotification] for component '%1', set notification for primaryAttributes for set '%2'", (Object)Integer.toString(this.getID()), (Object)carDSIAttributesSet.toString());
                    }
                    this.dsi.setNotification(carDSIAttributesSet.getPrimaryAttributes(), (DSIListener)this);
                    continue;
                }
                if (carDSIAttributesSetArray[i2].hasSecondaryAttributes()) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1000000, "[AbstractCarComponent#setDSIAttributeNotification] for component '%1', set '%2' has no primary attributes, set notification for secondary attributes", (Object)Integer.toString(this.getID()), (Object)carDSIAttributesSet.toString());
                    }
                    this.dsi.setNotification(carDSIAttributesSet.getSecondaryAttributes(), (DSIListener)this);
                    carDSIAttributesSet.setSecondaryAttributesRequested();
                    continue;
                }
                if (!this.getLogChannel().isInfo()) continue;
                this.getLogChannel().log(100000, "[AbstractCarComponent#setDSIAttributeNotification] for component '%1', set '%2' has no primary or secondary attributes", (Object)Integer.toString(this.getID()), (Object)carDSIAttributesSet.toString());
            }
        }
    }

    public final void primaryAttributeReceived(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractCarComponent#primaryAttributeReceived] attribute '%3' for component '%2', attribute set '%1'", (long)n, (long)this.getID(), (long)n2);
        }
        CarDSIAttributesSet[] carDSIAttributesSetArray = this.dsiSet;
        for (int i2 = 0; i2 < carDSIAttributesSetArray.length; ++i2) {
            CarDSIAttributesSet carDSIAttributesSet = carDSIAttributesSetArray[i2];
            if (carDSIAttributesSet == null || carDSIAttributesSet.getID() != n || carDSIAttributesSet.areSecondaryAttributesRequested()) continue;
            carDSIAttributesSet.setPrimaryAttributeReceived(n2);
            if (!carDSIAttributesSet.allPrimaryAttributesReceived()) continue;
            if (carDSIAttributesSet.hasSecondaryAttributes()) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[AbstractCarComponent#primaryAttributeReceived] all primary attributes for component '%2' (set '%1') received, set notification for secondary attributes", (Object)carDSIAttributesSet.toString(), (long)this.getID(), (long)n2);
                }
                carDSIAttributesSet.setSecondaryAttributesRequested();
                this.dsi.setNotification(carDSIAttributesSet.getSecondaryAttributes(), (DSIListener)this);
                continue;
            }
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractCarComponent#primaryAttributeReceived] all primary attributes for component '%2' (set '%1') received, no secondary attributes available, nothing more to do", (Object)carDSIAttributesSet.toString(), (long)this.getID(), (long)n2);
            }
            carDSIAttributesSet.setSecondaryAttributesRequested();
        }
    }

    public final void primaryAttributeFirstSetReceived() {
        try {
            if (this.dsiSet[0] != null) {
                this.primaryAttributeReceived(0, this.dsiSet[0].getPrimaryAttributes()[0]);
            } else {
                this.getLogChannel().log(1000, "[AbstractCarComponent#primaryAttributeFirstSetReceived] component='%1', dsiSet[0] = null", (long)this.getID());
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getLogChannel().log(1000, "[AbstractCarComponent#primaryAttributeFirstSetReceived] component='%1', AIOOB exception occured", (long)this.getID(), (Throwable)arrayIndexOutOfBoundsException);
        }
    }

    public final LogChannel getLogChannel() {
        return this.logChannel;
    }

    public final LogChannel getLogChannel(int n) {
        switch (n) {
            case 1: {
                return null == this.logChannelDSI ? this.logChannel : this.logChannelDSI;
            }
            case 2: {
                return null == this.logChannelMSC ? this.logChannel : this.logChannelMSC;
            }
            case 3: {
                return null == this.logChannelFrequent ? this.logChannel : this.logChannelFrequent;
            }
        }
        return this.logChannel;
    }

    public void setLogChannelDSI(boolean bl) {
        if (bl) {
            Buffer buffer = new Buffer();
            buffer.append(this.logChannel.name).append(".DSI");
            this.logChannelDSI = this.application.getFrameworkAccess().getLogChannel(buffer.toString());
        } else {
            this.logChannelDSI = null;
        }
    }

    public void setLogChannelMSC(boolean bl) {
        if (bl) {
            Buffer buffer = new Buffer();
            buffer.append(this.logChannel.name).append(".MSC");
            this.logChannelMSC = this.application.getFrameworkAccess().getLogChannel(buffer.toString());
        } else {
            this.logChannelMSC = null;
        }
    }

    public void setLogChannelFrequent(boolean bl) {
        if (bl) {
            Buffer buffer = new Buffer();
            buffer.append(this.logChannel.name).append(".Frequent");
            this.logChannelFrequent = this.application.getFrameworkAccess().getLogChannel(buffer.toString());
        } else {
            this.logChannelFrequent = null;
        }
    }

    protected ICarApplication getApplication() {
        return this.application;
    }

    protected boolean showHybridVehicleContent() {
        return this.application.getCarMenuCoding().isMenuDisplayActivated((short)24);
    }

    protected DSIBase getBaseDSI() {
        return this.dsi;
    }

    public abstract int getID();

    public CarDSIAttributesSet[] getLifeAttributesSets() {
        return this.dsiSet;
    }

    protected int getMenuEntryVisibilityState(CarViewOption carViewOption) {
        int n;
        if (carViewOption == null) {
            this.getLogChannel().log(1000, "[AbstractCarComponent#getMenuEntryVisibilityState] viewOption in component '%1' (ID '%2') is null", (Object)this.getName(), (long)this.getID());
            return 1;
        }
        switch (carViewOption.getState()) {
            case 2: {
                n = 0;
                break;
            }
            case 1: {
                n = this.getMenuEntryStateDisabled(carViewOption.getReason());
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    protected int getMenuEntryVisibilityState(CarViewOption[] carViewOptionArray) {
        int n = 0;
        block5: for (int i2 = 0; i2 < carViewOptionArray.length; ++i2) {
            int n2 = this.getMenuEntryVisibilityState(carViewOptionArray[i2]);
            switch (n2) {
                case 0: {
                    continue block5;
                }
                case 1: {
                    n = n2;
                    continue block5;
                }
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: {
                    if (n == 1) continue block5;
                    n = this.getMaxState(n, n2);
                    continue block5;
                }
            }
        }
        return n;
    }

    private int getMaxState(int n, int n2) {
        if (n == 1 || n2 == 1) {
            return 1;
        }
        if (n == 9 || n2 == 9) {
            return 9;
        }
        if (n == 2 || n2 == 2) {
            return 2;
        }
        if (n == 3 || n2 == 3) {
            return 3;
        }
        if (n == 5 || n2 == 5) {
            return 5;
        }
        if (n == 4 || n2 == 4) {
            return 4;
        }
        if (n == 7 || n2 == 7) {
            return 7;
        }
        if (n == 8 || n2 == 8) {
            return 8;
        }
        if (n == 6 || n2 == 6) {
            return 6;
        }
        if (n == 10 || n2 == 10) {
            return 10;
        }
        if (n == 11 || n2 == 11) {
            return 11;
        }
        if (n == 12 || n2 == 12) {
            return 12;
        }
        if (n == 13 || n2 == 13) {
            return 13;
        }
        if (n == 14 || n2 == 14) {
            return 14;
        }
        if (n == 15 || n2 == 15) {
            return 15;
        }
        if (n == 16 || n2 == 16) {
            return 16;
        }
        if (n == 17 || n2 == 17) {
            return 17;
        }
        if (n == 18 || n2 == 18) {
            return 18;
        }
        if (n == 19 || n2 == 19) {
            return 19;
        }
        return 0;
    }

    private int getMenuEntryStateDisabled(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 5;
                break;
            }
            case 5: {
                n2 = 2;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 13: {
                n2 = 6;
                break;
            }
            case 6: {
                n2 = 7;
                break;
            }
            case 11: {
                n2 = 10;
                break;
            }
            default: {
                n2 = 2;
            }
        }
        return n2;
    }

    public Object addingService(ServiceReference serviceReference) {
        this.logChannel.log(1000000, "[AbstractCarComponent#addingService] called for component '%1', DSI available", (Object)this.getName());
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.dsi = (DSIBase)object;
        this.dsiAvailable(true);
        this.initBusiness();
        this.setDSIAttributeNotification();
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(1000000, "[AbstractCarComponent#removedService] called for component '%1', DSI removed", (Object)this.getName());
        this.dsiAvailable(false);
        this.dsi = null;
        this.getApplication().getBundleContext().ungetService(serviceReference);
    }

    protected void dsiAvailable(boolean bl) {
        this.logChannel.log(1000000, "[AbstractCarComponent#dsiAvailable] available='%1' for component '%2'", bl, (Object)this.getName());
    }

    public void setSimulatedDSI(DSIBase dSIBase) {
        this.logChannel.log(1000000, "[AbstractCarComponent#setSimulatedDSI] called, mode='%1'", dSIBase != null);
        this.dsi = dSIBase;
    }

    public abstract String getDSIListenerClassName();

    public abstract String getDSIClassName();

    public abstract boolean isUsingDSI();

    protected BrowserModelApp getBrowserModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getBrowserModel(n);
    }

    protected ChoiceModelApp getChoiceModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(n);
    }

    protected VirtualButtonModelApp getVirtualButtonModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getVirtualButtonModel(n);
    }

    protected LabelModelApp getLabelModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getLabelModel(n);
    }

    protected MenuModelApp getMenuModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getMenuModel(n);
    }

    protected RangeModelApp getRangeModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getRangeModel(n);
    }

    protected RangeModel2DApp getRange2DModel(int n) {
        return (RangeModel2DApp)this.application.getFrameworkAccess().getHmiServiceApp().getModelApp(n);
    }

    protected ListModelApp getListModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getListModel(n);
    }

    protected SpellerModelApp getSpellerModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getSpellerModel(n);
    }

    protected ButtonModelApp getButtonModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(n);
    }

    protected MetricsModelApp getMetricsModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getMetricsModel(n);
    }

    protected AbstractMetrics getMetric(int n) {
        return this.getMetricsModel(n).getMetric();
    }

    protected DateMetric getDateMetric(int n) {
        return (DateMetric)this.application.getFrameworkAccess().getHmiServiceApp().getMetricsModel(n).getMetric();
    }

    protected BaseListModelApp getBaseListModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getBaseListModel(n);
    }

    protected PropertyModelApp getPropertyModel(int n) {
        return this.application.getFrameworkAccess().getHmiServiceApp().getPropertyModel(n);
    }

    public void asyncException(int n, String string, int n2) {
        this.getLogChannel().log(1000, "[AbstractCarComponent#asyncException] componentID='%4', errorCode='%1', message='%2', requestType='%3'", (Object)Integer.toString(n), (Object)string, (Object)Integer.toString(n2), (Object)Integer.toString(this.getID()));
    }

    protected void logStub() {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
            String string = "??";
            if (stackTraceElementArray.length > 1) {
                StackTraceElement stackTraceElement = stackTraceElementArray[1];
                string = new StringBuffer().append(stackTraceElement.getClassName()).append(".").append(stackTraceElementArray[1].getMethodName()).toString();
            }
            this.getLogChannel().log(1000000, "%1 not implemented", (Object)string);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "Exception: ", (Throwable)exception);
        }
    }

    protected void logModelData(String string, int n, int n2, boolean bl) {
        if (bl) {
            this.getLogChannel().log(1000000, "%1 modelID:(MODELID#%2), data:%3", (Object)string, (long)n, (long)n2);
        } else {
            this.getLogChannel().log(100000, "%1 invalid modelID:(MODELID#%2), data:%3", (Object)string, (long)n, (long)n2);
        }
    }

    protected void sendContentToSDIS(int n, Object object) {
        if (this.getApplication().getSDISConnector() == null) {
            return;
        }
        ISDISCarInfoDistributor iSDISCarInfoDistributor = this.getApplication().getSDISConnector().getSDISCarInfoDistributor();
        if (iSDISCarInfoDistributor != null) {
            this.getLogChannel().log(1000000, "sendContentToSDIS: send content %2 (%1)", object, (long)n);
            iSDISCarInfoDistributor.sendContent(n, object);
        } else {
            this.getLogChannel().log(1000000, "sendContentToSDIS: store content %2 (%1)", object, (long)n);
            ISDISConnector iSDISConnector = this.getApplication().getSDISConnector();
            iSDISConnector.storeValue(n, object);
        }
    }

    public static int clip(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    public static float clip(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : (f2 > f4 ? f4 : f2);
    }

    protected String formatViewOptionsLog(String string) {
        Buffer buffer = new Buffer(100);
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            int n3;
            if (string.charAt(i2) == ',') {
                if (bl) continue;
                for (n3 = 0; n3 < n; ++n3) {
                    buffer.append("\t");
                }
                buffer.append(string.substring(n2, i2 + 1));
                buffer.append("\n");
                n2 = i2 + 1;
            }
            if (string.charAt(i2) == '(') {
                if (string.substring(i2 - "ViewOption".length(), i2).equals("ViewOption")) {
                    bl = true;
                    continue;
                }
                for (n3 = 0; n3 < n; ++n3) {
                    buffer.append("\t");
                }
                ++n;
                buffer.append(string.substring(n2, i2 + 1));
                buffer.append("\n");
                n2 = i2 + 1;
                continue;
            }
            if (string.charAt(i2) != ')') continue;
            if (bl) {
                bl = false;
                continue;
            }
            for (n3 = 0; n3 < n; ++n3) {
                buffer.append("\t");
            }
            --n;
            buffer.append(string.substring(n2, i2 + 1));
            buffer.append("\n");
            n2 = i2 + 1;
        }
        buffer.append(string.substring(n2, string.length()));
        return buffer.toString();
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

