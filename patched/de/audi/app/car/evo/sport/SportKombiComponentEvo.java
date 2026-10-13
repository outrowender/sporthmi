/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.sport;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public class SportKombiComponentEvo
extends AbstractDSICarKombiAdapter {
    public static /*final*/ short CODING_ID = 52;
    private volatile BCViewOptions currentBCViewOptions;
    private volatile CarBCTemperature currentOilTemp;
    private volatile int currentOilTempValid;
    private static /*final*/ String LOGCHANNEL_NAME = "App.Car.Sport";

    public SportKombiComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getLabelModel(602124).setText("kombi debug ready");
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(607, (short)52);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(607);
    }

    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        this.getLogChannel().log(1000, "updateBCOilTemperatureValue:%1, valid:%2", (Object)carBCTemperature, (long)n);
        this.currentOilTemp = carBCTemperature;
        this.currentOilTempValid = n;
        this.getLabelModel(602124).setText(this.buildKombiDebug());

        if (carBCTemperature.state == 0) {
            //Temperature temperature = new Temperature(100.0f, Temperature.CELSIUS);
            Temperature temperature = new Temperature(100.0f, carBCTemperature.temperatureUnit == 0 ? 1 : 2);
            temperature.setUseInstanceUnit(true);
            this.getMetricsModel(602117).setMetric(temperature);
        } else {
            Temperature temperature = new Temperature(120.0f, carBCTemperature.temperatureUnit == 0 ? 1 : 2);
            temperature.setUseInstanceUnit(true);
            this.getMetricsModel(602117).setMetric(temperature);
        }
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCViewOptions:%1, valid:%2", (Object)bCViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentBCViewOptions = bCViewOptions;
            this.getLabelModel(602124).setText(this.buildKombiDebug());
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(607, this.getMenuEntryVisibilityState(bCViewOptions.oilTemperatureValue));
            this.primaryAttributeFirstSetReceived();
        }
    }

    private String buildKombiDebug() {
        StringBuffer b = new StringBuffer(256);
        CarBCTemperature t = this.currentOilTemp;
        if (t != null) {
            b.append("--oilState=").append(t.state).append('\n');
            b.append("--oilValue=").append(t.temperatureValue).append('\n');
            b.append("oilTemUnit=").append(t.temperatureUnit).append('\n');
        } else {
            b.append("oilTempera=null\n");
        }
            b.append("oilTpValid=").append(this.currentOilTempValid).append('\n');
        BCViewOptions vo = this.currentBCViewOptions;
        if (vo != null) {
            b.append("voOilTempe=").append(String.valueOf(vo.oilTemperatureValue));
        } else {
            b.append("viewOption=null");
        }
        return b.toString();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{64})};
    }

    public String getCurrentViewOptions() {
        if (this.currentBCViewOptions != null) {
            return this.currentBCViewOptions.toString();
        }
        return "not yet received";
    }

    public String getName() {
        return "SportHMI-Kombi";
    }

    public int getID() {
        return 53;
    }
}

