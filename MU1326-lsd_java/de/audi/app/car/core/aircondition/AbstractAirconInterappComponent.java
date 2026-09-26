/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.core.aircondition.AbstractAirconInterappComponent$SDSServiceHandler;
import de.audi.atip.interapp.CarPhoneService;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractAirconInterappComponent
extends AbstractDSICarAirConditionAdapter
implements CarPhoneService {
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    private final Object mutex = new Object();
    private CarServiceTracker sdsServiceTracker;
    private CarServiceProvider phoneServiceProvider;
    public volatile boolean sdsActive = false;
    private volatile boolean phoneCallActive = false;
    private volatile AirconMasterViewOptions currentViewOptionsMaster;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$CarPhoneService;

    public AbstractAirconInterappComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AirCondition");
    }

    private void updateAirBlowerCompensationState() {
        Object object;
        if (this.getLogChannel().isInfo()) {
            object = new Buffer(60);
            ((Buffer)object).append("sdsActive=").append(this.sdsActive).append(", callActive=").append(this.phoneCallActive).append("");
            this.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent#updateAirBlowerCompensationState] %1", (Object)((Buffer)object).toString());
        }
        object = new AirconBlowerCompensation();
        ((AirconBlowerCompensation)object).sds = this.sdsActive;
        ((AirconBlowerCompensation)object).tel = this.phoneCallActive;
        if (null != this.getDSI()) {
            this.getLogChannel().log(1078071040, "---> DSI.setAirconBlowerCompensation(%1)", object);
            this.getDSI().setAirconBlowerCompensation((AirconBlowerCompensation)object);
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractAirconInterappComponent#updateAirBlowerCompensationState] DSI not yet available.");
        }
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
    }

    @Override
    public String getName() {
        return "AirCondition Interapp Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92}, new int[]{20})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master: ");
        buffer.append(null == this.currentViewOptionsMaster ? "No master view options received yet" : this.currentViewOptionsMaster.toString());
        return buffer.toString();
    }

    @Override
    public void init() {
        super.init();
        this.phoneServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$CarPhoneService == null ? (class$de$audi$atip$interapp$CarPhoneService = AbstractAirconInterappComponent.class$("de.audi.atip.interapp.CarPhoneService")) : class$de$audi$atip$interapp$CarPhoneService).getName(), this, null, this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel("App.Car.AirCondition"));
        this.phoneServiceProvider.startService();
    }

    @Override
    public void deinit() {
        this.phoneServiceProvider.stopService();
        if (this.sdsServiceTracker != null) {
            this.sdsServiceTracker.stopTracking();
        }
        super.deinit();
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        if (bl) {
            this.getLogChannel().log(1078071040, "DSI available, starting Tracking SDS Service...");
            this.sdsServiceTracker = new CarServiceTracker(new AbstractAirconInterappComponent$SDSServiceHandler(this, null), this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel("App.Car.AirCondition"));
            this.sdsServiceTracker.startTracking();
        }
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent#updateAirconBlowerCompensation] blowerCompensation='%1', valid='%2', no action performed on this update", (Object)(null == airconBlowerCompensation ? "null" : airconBlowerCompensation.toString()), (long)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateCallStatus(boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent#updateCallStatus] callActive=%1", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.phoneCallActive = bl;
            this.updateAirBlowerCompensationState();
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    static /* synthetic */ Object access$000(AbstractAirconInterappComponent abstractAirconInterappComponent) {
        return abstractAirconInterappComponent.mutex;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$100(AbstractAirconInterappComponent abstractAirconInterappComponent) {
        abstractAirconInterappComponent.updateAirBlowerCompensationState();
    }
}

