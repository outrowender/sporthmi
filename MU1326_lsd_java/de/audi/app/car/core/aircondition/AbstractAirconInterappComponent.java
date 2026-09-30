/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.atip.interapp.CarPhoneService;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractAirconInterappComponent
extends AbstractDSICarAirConditionAdapter
implements CarPhoneService {
    public static final short CODING_ID = 8;
    public static final String LOGCHANNEL_NAME = "App.Car.AirCondition";
    private final Object mutex = new Object();
    private CarServiceTracker sdsServiceTracker;
    private CarServiceProvider phoneServiceProvider;
    public volatile boolean sdsActive = false;
    private volatile boolean phoneCallActive = false;
    private volatile AirconMasterViewOptions currentViewOptionsMaster;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$CarPhoneService;

    public AbstractAirconInterappComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    private void updateAirBlowerCompensationState() {
        Object object;
        if (this.getLogChannel().isInfo()) {
            object = new Buffer(60);
            ((Buffer)object).append("sdsActive=").append(this.sdsActive).append(", callActive=").append(this.phoneCallActive).append("");
            this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent#updateAirBlowerCompensationState] %1", (Object)((Buffer)object).toString());
        }
        object = new AirconBlowerCompensation();
        ((AirconBlowerCompensation)object).sds = this.sdsActive;
        ((AirconBlowerCompensation)object).tel = this.phoneCallActive;
        if (null != this.getDSI()) {
            this.getLogChannel().log(1000000, "---> DSI.setAirconBlowerCompensation(%1)", object);
            this.getDSI().setAirconBlowerCompensation((AirconBlowerCompensation)object);
        } else {
            this.getLogChannel().log(100000, "[AbstractAirconInterappComponent#updateAirBlowerCompensationState] DSI not yet available.");
        }
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions var1);

    public String getName() {
        return "AirCondition Interapp Control";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92}, new int[]{20})};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master: ");
        buffer.append(null == this.currentViewOptionsMaster ? "No master view options received yet" : this.currentViewOptionsMaster.toString());
        return buffer.toString();
    }

    public void init() {
        super.init();
        this.phoneServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$CarPhoneService == null ? (class$de$audi$atip$interapp$CarPhoneService = AbstractAirconInterappComponent.class$("de.audi.atip.interapp.CarPhoneService")) : class$de$audi$atip$interapp$CarPhoneService).getName(), this, null, this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
        this.phoneServiceProvider.startService();
    }

    public void deinit() {
        this.phoneServiceProvider.stopService();
        if (this.sdsServiceTracker != null) {
            this.sdsServiceTracker.stopTracking();
        }
        super.deinit();
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        if (bl) {
            this.getLogChannel().log(1000000, "DSI available, starting Tracking SDS Service...");
            this.sdsServiceTracker = new CarServiceTracker(new SDSServiceHandler(), this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
            this.sdsServiceTracker.startTracking();
        }
    }

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent#updateAirconBlowerCompensation] blowerCompensation='%1', valid='%2', no action performed on this update", (Object)(null == airconBlowerCompensation ? "null" : airconBlowerCompensation.toString()), (long)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallStatus(boolean bl) {
        this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent#updateCallStatus] callActive=%1", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.phoneCallActive = bl;
            this.updateAirBlowerCompensationState();
        }
    }

    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
    }

    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class SDSServiceHandler
    implements CarServiceTrackerListener,
    ISDSServiceStatusListener {
        private SDSServiceHandler() {
        }

        public void serviceAvailable(Object object) {
            AbstractAirconInterappComponent.this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceAvailable] service received");
            try {
                ((SDSService)object).registerStatusListener(this);
            }
            catch (ClassCastException classCastException) {
                AbstractAirconInterappComponent.this.getLogChannel().log(1000, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceAvailable] sdsServiceTracker: cannot cast service");
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void serviceRemoved() {
            AbstractAirconInterappComponent.this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceRemoved] SDS Service has been removed");
            Object object = AbstractAirconInterappComponent.this.mutex;
            synchronized (object) {
                if (AbstractAirconInterappComponent.this.sdsActive) {
                    this.notifySDSDialogEnded();
                }
            }
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AbstractAirconInterappComponent.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName()};
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void notifySDSDialogStarted() {
            AbstractAirconInterappComponent.this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent.SDSServiceHandler#notifySDSDialogStarted] called");
            Object object = AbstractAirconInterappComponent.this.mutex;
            synchronized (object) {
                AbstractAirconInterappComponent.this.sdsActive = true;
                if (AbstractAirconInterappComponent.this.getDSI() == null) {
                    return;
                }
                AbstractAirconInterappComponent.this.updateAirBlowerCompensationState();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void notifySDSDialogEnded() {
            AbstractAirconInterappComponent.this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent.SDSServiceHandler#notifiySDSDialogEnded] called");
            Object object = AbstractAirconInterappComponent.this.mutex;
            synchronized (object) {
                AbstractAirconInterappComponent.this.sdsActive = false;
                if (AbstractAirconInterappComponent.this.getDSI() == null) {
                    return;
                }
                AbstractAirconInterappComponent.this.updateAirBlowerCompensationState();
            }
        }

        public void notifySDSDialogAborting() {
        }
    }
}

