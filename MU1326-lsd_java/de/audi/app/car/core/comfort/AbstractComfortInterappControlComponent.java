/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.comfort.AbstractComfortInterappControlComponent$1;
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
    public static final String LOGCHANNEL_NAME;
    private volatile RGSViewOptions currentViewOptions;
    private LGIDataDispatcher lgiDataDispatcher;
    private final ILGIServiceListener lgiDataListener = new AbstractComfortInterappControlComponent$1(this);
    private CarServiceProvider lgiDataServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$ILGIServiceListener;

    public AbstractComfortInterappControlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Comfort");
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
            if (null == localHazardInformation || 0 == localHazardInformation.getEventType() || 0 < localHazardInformation.getDistance()) continue;
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

    @Override
    public String getName() {
        return "Comfort Interapp Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[0])};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
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

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent#updateAirconViewOptionsMaster] rGSViewOptions='%1', valid='%2'", (Object)(null != rGSViewOptions ? this.formatViewOptionsLog(rGSViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != rGSViewOptions) {
            this.currentViewOptions = rGSViewOptions;
            this.primaryAttributeFirstSetReceived();
        }
    }

    static /* synthetic */ LGIDataDispatcher access$000(AbstractComfortInterappControlComponent abstractComfortInterappControlComponent) {
        return abstractComfortInterappControlComponent.lgiDataDispatcher;
    }

    static /* synthetic */ LocalHazardInformation[] access$100(AbstractComfortInterappControlComponent abstractComfortInterappControlComponent, LocalHazardInformation[] localHazardInformationArray) {
        return abstractComfortInterappControlComponent.filterForRelevantWarnings(localHazardInformationArray);
    }

    static /* synthetic */ RGSLocalHazardInformation[] access$200(AbstractComfortInterappControlComponent abstractComfortInterappControlComponent) {
        return abstractComfortInterappControlComponent.createRGSLocalHazardInformation();
    }

    static /* synthetic */ RGSLocalHazardInformation[] access$300(AbstractComfortInterappControlComponent abstractComfortInterappControlComponent, LocalHazardInformation[] localHazardInformationArray) {
        return abstractComfortInterappControlComponent.createRGSLocalHazardInformation(localHazardInformationArray);
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

