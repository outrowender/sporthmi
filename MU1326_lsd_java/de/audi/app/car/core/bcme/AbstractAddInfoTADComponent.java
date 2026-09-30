/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.bcme.NavDataListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;

public abstract class AbstractAddInfoTADComponent
extends AbstractDSICarVehicleStatesAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.Charisma.HighFrequent";
    public static final short CODING_ID = 40;
    protected volatile DynamicVehicleInfoHighFrequentViewOptions currentViewOptions;
    private NavDataListener navData = new NavDataListener(this.getMetricsModel(601377), this.getMetricsModel(601376), this.getMetricsModel(601378), this.getLogChannel());
    private CarServiceProvider navDataServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$CarNavListener;

    public AbstractAddInfoTADComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initBusiness() {
        this.initNaviServiceProvider();
    }

    private void initNaviServiceProvider() {
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = AbstractAddInfoTADComponent.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName());
        this.navDataServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = AbstractAddInfoTADComponent.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName(), this.navData, hashtable, this.getApplication().getBundleContext(), this.getLogChannel());
        this.navDataServiceProvider.startService();
    }

    private void deinitNaviServiceProvider() {
        if (this.navDataServiceProvider != null) {
            this.navDataServiceProvider.stopService();
        }
    }

    public void deinit() {
        this.deinitNaviServiceProvider();
        super.deinit();
    }

    public String getName() {
        return "Car Additional Info TAD";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{14})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAddInfoTADComponent#updateDynamicVehicleInfoHighFrequentViewOptions] vehicleInfoViewOptions='%1', valid='%2' ", (Object)(n == 1 ? this.formatViewOptionsLog(dynamicVehicleInfoHighFrequentViewOptions.toString()) : "invalid VOs"), (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = dynamicVehicleInfoHighFrequentViewOptions;
            this.updateMenuEntryVisibility(dynamicVehicleInfoHighFrequentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAddInfoTADComponent#updateDynamicVehicleInfoHighFrequent] dynamicVehicleInfoHighFrequent='%1' , valid='%2' ", (Object)dynamicVehicleInfoHighFrequent, (long)n);
        }
        if (n == 1) {
            int n2 = dynamicVehicleInfoHighFrequent.getWheelAngle();
            Buffer buffer = new Buffer(5);
            if (0 != n2) {
                buffer.append(0 < n2 ? "L " : "R ");
            }
            buffer.append(Math.abs(n2));
            buffer.append('\u00b0');
            this.getLabelModel(600771).setText(buffer.toString());
            this.getChoiceModel(601731).setValue(n2);
        }
    }

    protected abstract void updateMenuEntryVisibility(DynamicVehicleInfoHighFrequentViewOptions var1);

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

