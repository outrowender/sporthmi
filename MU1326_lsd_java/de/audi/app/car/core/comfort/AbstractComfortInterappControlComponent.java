/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.app.car.core.comfort.LGIDataDispatcher;
import de.audi.atip.interapp.navcar.ILGIServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import java.util.Vector;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.tmc.LocalHazardInformation;

public abstract class AbstractComfortInterappControlComponent
extends AbstractDSICarComfortAdapter {
    public static final String LOGCHANNEL_NAME = "App.Car.Comfort";
    private volatile RGSViewOptions currentViewOptions;
    private LGIDataDispatcher lgiDataDispatcher;
    private final ILGIServiceListener lgiDataListener = new ILGIServiceListener(){

        public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
            AbstractComfortInterappControlComponent.this.getLogChannel().log(1000000, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] called.");
            if (null == localHazardInformationArray) {
                AbstractComfortInterappControlComponent.this.getLogChannel().log(10000, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] Invalid parameter set.");
                return;
            }
            if (null == AbstractComfortInterappControlComponent.this.lgiDataDispatcher) {
                AbstractComfortInterappControlComponent.this.getLogChannel().log(10000, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] Dispatcher not yet initialized.");
                return;
            }
            LocalHazardInformation[] localHazardInformationArray2 = AbstractComfortInterappControlComponent.this.filterForRelevantWarnings(localHazardInformationArray);
            if (0 == localHazardInformationArray2.length) {
                AbstractComfortInterappControlComponent.this.lgiDataDispatcher.updateRGSLocalHazardInformation(AbstractComfortInterappControlComponent.this.createRGSLocalHazardInformation());
                return;
            }
            AbstractComfortInterappControlComponent.this.lgiDataDispatcher.updateRGSLocalHazardInformation(AbstractComfortInterappControlComponent.this.createRGSLocalHazardInformation(localHazardInformationArray2));
        }
    };
    private CarServiceProvider lgiDataServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$ILGIServiceListener;

    public AbstractComfortInterappControlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    private RGSLocalHazardInformation[] createRGSLocalHazardInformation() {
        RGSLocalHazardInformation rGSLocalHazardInformation = new RGSLocalHazardInformation();
        rGSLocalHazardInformation.eventID = 0;
        rGSLocalHazardInformation.eventType = 0;
        rGSLocalHazardInformation.eventQuality = 0;
        rGSLocalHazardInformation.approach = new CarBCDistance(0, 0.0, 0);
        return new RGSLocalHazardInformation[]{rGSLocalHazardInformation};
    }

    private RGSLocalHazardInformation[] createRGSLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
        if (null == localHazardInformationArray) {
            return null;
        }
        RGSLocalHazardInformation[] rGSLocalHazardInformationArray = new RGSLocalHazardInformation[localHazardInformationArray.length];
        for (int i2 = 0; i2 < localHazardInformationArray.length; ++i2) {
            RGSLocalHazardInformation rGSLocalHazardInformation = new RGSLocalHazardInformation();
            rGSLocalHazardInformation.eventID = (short)localHazardInformationArray[i2].getEventID();
            rGSLocalHazardInformation.eventType = localHazardInformationArray[i2].getEventType();
            rGSLocalHazardInformation.eventQuality = localHazardInformationArray[i2].getEventQuality();
            rGSLocalHazardInformation.approach = new CarBCDistance(1, (double)localHazardInformationArray[i2].getDistance() / 1000.0, 0);
            rGSLocalHazardInformationArray[i2] = rGSLocalHazardInformation;
        }
        return rGSLocalHazardInformationArray;
    }

    private LocalHazardInformation[] filterForRelevantWarnings(LocalHazardInformation[] localHazardInformationArray) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 < localHazardInformationArray.length; ++i2) {
            LocalHazardInformation localHazardInformation = localHazardInformationArray[i2];
            if (null == localHazardInformation || 0 == localHazardInformation.getEventType() || 4080L < localHazardInformation.getDistance()) continue;
            vector.add(localHazardInformation);
        }
        return (LocalHazardInformation[])vector.toArray(new LocalHazardInformation[vector.size()]);
    }

    private void initLGIServiceProvider() {
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navcar$ILGIServiceListener == null ? (class$de$audi$atip$interapp$navcar$ILGIServiceListener = AbstractComfortInterappControlComponent.class$("de.audi.atip.interapp.navcar.ILGIServiceListener")) : class$de$audi$atip$interapp$navcar$ILGIServiceListener).getName());
        this.lgiDataServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$navcar$ILGIServiceListener == null ? (class$de$audi$atip$interapp$navcar$ILGIServiceListener = AbstractComfortInterappControlComponent.class$("de.audi.atip.interapp.navcar.ILGIServiceListener")) : class$de$audi$atip$interapp$navcar$ILGIServiceListener).getName(), this.lgiDataListener, hashtable, this.getApplication().getBundleContext(), this.getLogChannel());
        this.lgiDataServiceProvider.startService();
    }

    private void deinitLGIServiceProvider() {
        if (this.lgiDataServiceProvider != null) {
            this.lgiDataServiceProvider.stopService();
            this.lgiDataServiceProvider = null;
        }
    }

    private void initLGIDataDispatcher() {
        this.lgiDataDispatcher = new LGIDataDispatcher(this.getApplication().getFrameworkAccess(), this.getLogChannel(), this.getDSI());
    }

    private void deinitLGIDataDispatcher() {
        if (this.lgiDataDispatcher != null) {
            this.lgiDataDispatcher.cleanUp();
            this.lgiDataDispatcher = null;
        }
    }

    public String getName() {
        return "Comfort Interapp Control";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[0])};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        if (bl) {
            if (null == this.lgiDataDispatcher) {
                this.initLGIDataDispatcher();
            }
            if (null == this.lgiDataServiceProvider) {
                this.initLGIServiceProvider();
            }
        } else {
            if (null != this.lgiDataDispatcher) {
                this.deinitLGIDataDispatcher();
            }
            if (null != this.lgiDataServiceProvider) {
                this.deinitLGIServiceProvider();
            }
        }
    }

    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconInterappComponent#updateAirconViewOptionsMaster] rGSViewOptions='%1', valid='%2'", (Object)(null != rGSViewOptions ? this.formatViewOptionsLog(rGSViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != rGSViewOptions) {
            this.currentViewOptions = rGSViewOptions;
            this.primaryAttributeFirstSetReceived();
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

