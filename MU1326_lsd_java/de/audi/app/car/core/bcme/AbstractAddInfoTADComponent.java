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
    private static final String LOGCHANNEL_NAME;
    public static final short CODING_ID;
    protected volatile DynamicVehicleInfoHighFrequentViewOptions currentViewOptions;
    private NavDataListener navData = new NavDataListener(this.getMetricsModel(556599552), this.getMetricsModel(539822336), this.getMetricsModel(573376768), this.getLogChannel());
    private CarServiceProvider navDataServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$CarNavListener;

    public AbstractAddInfoTADComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma.HighFrequent");
    }

    @Override
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

    @Override
    public void deinit() {
        this.deinitNaviServiceProvider();
        super.deinit();
    }

    @Override
    public String getName() {
        return "Car Additional Info TAD";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{14})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAddInfoTADComponent#updateDynamicVehicleInfoHighFrequentViewOptions] vehicleInfoViewOptions='%1', valid='%2' ", (Object)(n == 1 ? this.formatViewOptionsLog(dynamicVehicleInfoHighFrequentViewOptions.toString()) : "invalid VOs"), (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = dynamicVehicleInfoHighFrequentViewOptions;
            this.updateMenuEntryVisibility(dynamicVehicleInfoHighFrequentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAddInfoTADComponent#updateDynamicVehicleInfoHighFrequent] dynamicVehicleInfoHighFrequent='%1' , valid='%2' ", (Object)dynamicVehicleInfoHighFrequent, (long)n);
        }
        if (n == 1) {
            int n2 = dynamicVehicleInfoHighFrequent.getWheelAngle();
            Buffer buffer = new Buffer(5);
            if (0 != n2) {
                buffer.append(0 < n2 ? "L " : "R ");
            }
            buffer.append(Math.abs(n2));
            buffer.append('\u00b0');
            this.getLabelModel(-1020655360).setText(buffer.toString());
            this.getChoiceModel(-2094135040).setValue(n2);
        }
    }

    protected abstract void updateMenuEntryVisibility(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions) {
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

