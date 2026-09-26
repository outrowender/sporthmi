/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.util.ValueConverterCollection;
import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$TemperatureModel;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.caraircondition.AirconTemp;

public class AbstractAirconComponent$TemperatureHandler {
    private final String name;
    private final int hmiZone;
    private final AbstractAirconComponent$TemperatureModel temperatureModel;
    private final /* synthetic */ AbstractAirconComponent this$0;

    public AbstractAirconComponent$TemperatureHandler(AbstractAirconComponent abstractAirconComponent, String string, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = abstractAirconComponent;
        this.name = string;
        this.hmiZone = n;
        this.temperatureModel = new AbstractAirconComponent$TemperatureModel(abstractAirconComponent, AbstractAirconComponent.access$000(abstractAirconComponent, n2), AbstractAirconComponent.access$100(abstractAirconComponent, n3), AbstractAirconComponent.access$200(abstractAirconComponent, n4), AbstractAirconComponent.access$300(abstractAirconComponent, n5), abstractAirconComponent.getConfig().getTemperatureStartCelsius(), abstractAirconComponent.getConfig().getTemperatureEndCelsius(), abstractAirconComponent.getConfig().getTemperatureStepCelsius(), abstractAirconComponent.getConfig().getTemperatureStartFahrenheit(), abstractAirconComponent.getConfig().getTemperatureEndFahrenheit(), abstractAirconComponent.getConfig().getTemperatureStepFahrenheit());
    }

    private void callDSISetAirconTempZone(AirconTemp airconTemp) {
        int n = this.this$0.convertZoneHMI2DSI(this.hmiZone);
        if (-1 != n) {
            this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconTempZone(%1, %2)", (Object)Integer.toString(n), (Object)airconTemp.toString());
            this.this$0.getDSI().setAirconTempZone(n, airconTemp);
        }
    }

    public void incrementTemperature(int n, int n2) {
        int n3 = ValueConverterCollection.convertTemperatureUnitHMI2DSI(Temperature.getSystemUnit());
        int n4 = ValueConverterCollection.convertTemperatureUnitHMI2DSI(n2);
        if (-1 != n3 && n3 == n4) {
            AirconTemp airconTemp = new AirconTemp();
            airconTemp.tempValue = this.temperatureModel.getCurrentTemperature() + n;
            airconTemp.tempUnit = n4;
            this.callDSISetAirconTempZone(airconTemp);
        } else {
            this.this$0.getLogChannel().log(-1601830656, "[TemperatureHandler(%1)#incrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'", (Object)this.name, (long)n3, (long)n4);
        }
    }

    public void decrementTemperature(int n, int n2) {
        int n3 = ValueConverterCollection.convertTemperatureUnitHMI2DSI(Temperature.getSystemUnit());
        int n4 = ValueConverterCollection.convertTemperatureUnitHMI2DSI(n2);
        if (-1 != n3 && n3 == n4) {
            AirconTemp airconTemp = new AirconTemp();
            airconTemp.tempValue = this.temperatureModel.getCurrentTemperature() - n;
            airconTemp.tempUnit = n4;
            this.callDSISetAirconTempZone(airconTemp);
        } else {
            this.this$0.getLogChannel().log(-1601830656, "[TemperatureHandler(%1)#decrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'", (Object)this.name, (long)n3, (long)n4);
        }
    }

    public void updateTemperature(AirconTemp airconTemp) {
        this.temperatureModel.updateHMI(airconTemp);
    }
}

