/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.earlyfunc.core.aircondition.ACSeatPartialPopupHandler;
import de.audi.app.car.earlyfunc.core.aircondition.ACSeatPopupConfigurationHandler;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACAirDistributionChoiceListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACFanSpeedRangeListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACSeatHeaterRangeListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$ACSeatVentilationRangeListener;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$NoResponseTimerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconTemp;

public abstract class AbstractACSeatPopupComponent
extends AbstractDSICarAirConditionAdapter {
    public static final short CODING_ID;
    private static final int RANGE_SEAT_DIST_MIN;
    private static final int RANGE_SEAT_DIST_MAX;
    private static final int RANGE_SEAT_DIST_STEP;
    private static final int RANGE_SEAT_LEVEL_MIN;
    private static final int RANGE_SEAT_LEVEL_MAX;
    private static final int RANGE_SEAT_LEVEL_STEP;
    private static final int TEMPERATURE_MIN;
    private static final int TEMPERATURE_MAX;
    private static final float FAHRENHEIT_STEP;
    private static final float CELSIUS_STEP;
    private static final float FAHRENHEIT_MIN_TEMPERATURE;
    private static final float FAHRENHEIT_MAX_TEMPERATURE;
    private static final float CELSIUS_MIN_TEMPERATURE;
    private static final float CELSIUS_MAX_TEMPERATURE;
    private static final int CELSIUS_MIN_TEMPERATURE_DSI_VALUE;
    private static final int CELSIUS_MAX_TEMPERATURE_DSI_VALUE;
    private static final int FAHRENHEIT_MIN_TEMPERATURE_DSI_VALUE;
    private static final int FAHRENHEIT_MAX_TEMPERATURE_DSI_VALUE;
    private static final int LABEL_LO;
    private static final int LABEL_TEMP;
    private static final int LABEL_HI;
    private static final int AIRCON_SEAT_AUTO_LEVEL;
    protected static final int ZONES_ZONE1;
    protected static final int ZONES_ZONE2;
    protected static final int ZONES_ZONE3;
    protected static final int ZONES_ZONE4;
    private final ACSeatPopupConfigurationHandler configurationHandler;
    private volatile AirconMasterViewOptions currentViewOptionsMaster;
    private volatile AirconRowViewOptions currentViewOptionsRow1;
    private volatile AirconRowViewOptions currentViewOptionsRow2;
    private static final String LOGCHANNEL_NAME;
    private MetricsModelApp tempMetricsModelZone1;
    private MetricsModelApp tempMetricsModelZone2;
    private MetricsModelApp tempMetricsModelZone3;
    private MetricsModelApp tempMetricsModelZone4;
    private RangeModelApp tempLimitModelZone1;
    private RangeModelApp tempLimitModelZone2;
    private RangeModelApp tempLimitModelZone3;
    private RangeModelApp tempLimitModelZone4;
    private ChoiceModelApp tempLabelModelZone1;
    private ChoiceModelApp tempLabelModelZone2;
    private ChoiceModelApp tempLabelModelZone3;
    private ChoiceModelApp tempLabelModelZone4;
    private AbstractACSeatPopupComponent$ACSeatVentilationRangeListener ventilationZone1;
    private AbstractACSeatPopupComponent$ACSeatVentilationRangeListener ventilationZone2;
    private AbstractACSeatPopupComponent$ACSeatVentilationRangeListener ventilationZone3;
    private AbstractACSeatPopupComponent$ACSeatVentilationRangeListener ventilationZone4;
    private AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener ventilationDistributionZone1;
    private AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener ventilationDistributionZone2;
    private AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener ventilationDistributionZone3;
    private AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener ventilationDistributionZone4;
    private AbstractACSeatPopupComponent$ACSeatHeaterRangeListener heaterZone1;
    private AbstractACSeatPopupComponent$ACSeatHeaterRangeListener heaterZone2;
    private AbstractACSeatPopupComponent$ACSeatHeaterRangeListener heaterZone3;
    private AbstractACSeatPopupComponent$ACSeatHeaterRangeListener heaterZone4;
    private AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener heaterDistributionZone1;
    private AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener heaterDistributionZone2;
    private AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener heaterDistributionZone3;
    private AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener heaterDistributionZone4;
    private AbstractACSeatPopupComponent$ACFanSpeedRangeListener fanSpeedZone1;
    private AbstractACSeatPopupComponent$ACFanSpeedRangeListener fanSpeedZone2;
    private AbstractACSeatPopupComponent$ACFanSpeedRangeListener fanSpeedZone3;
    private AbstractACSeatPopupComponent$ACFanSpeedRangeListener fanSpeedZone4;
    private AbstractACSeatPopupComponent$ACAirDistributionChoiceListener airDistributionZone1;
    private AbstractACSeatPopupComponent$ACAirDistributionChoiceListener airDistributionZone2;
    private AbstractACSeatPopupComponent$ACAirDistributionChoiceListener airDistributionZone3;
    private AbstractACSeatPopupComponent$ACAirDistributionChoiceListener airDistributionZone4;
    private LogChannel logMSC;
    private ACSeatPartialPopupHandler partialPopupHandler;
    private IPowerManager powerManager;
    private volatile boolean systemOnOffRow1 = false;
    private ArrayList pendingRequestTypes = new ArrayList();
    private ArrayList pendingRequests = new ArrayList();
    private Timer timerNoResponse;
    private static final int QUEUE_BEGIN;
    private static final int ACTION_INVALID;
    private static final int ACTION_REQUEST;
    private static final int ACTION_UPDATE;

    public AbstractACSeatPopupComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.AirCondition.Seat");
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.EarlyFunc.AirCondition.Seat.MSC");
        this.configurationHandler = new ACSeatPopupConfigurationHandler(this.getLogChannel());
        this.partialPopupHandler = new ACSeatPartialPopupHandler(iCarApplication, this, this.getLogChannel());
        this.powerManager = this.getApplication().getFrameworkAccess().getPowerMgr();
        this.timerNoResponse = new Timer("TimerNoResponse", 0, true, new AbstractACSeatPopupComponent$NoResponseTimerListener(this));
    }

    @Override
    public void init() {
        super.init();
        this.partialPopupHandler.init(this.getPPIDs());
    }

    @Override
    public void deinit() {
        super.deinit();
        this.partialPopupHandler.deinit();
        this.powerManager.setExtendedPowerState(102, 0);
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        if (!bl) {
            this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#dsiAvailable] dsi not available, reset the extended power state");
            this.powerManager.setExtendedPowerState(102, 0);
        }
    }

    @Override
    public String getName() {
        return "AirConditionSeatPopup";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{2, 152, 168, 170, 69, 70, 167, 169, 63, 64, 25, 31, 26, 32, 24, 30}), new CarDSIAttributesSet(1, new int[]{92, 94}, new int[]{172, 174, 71, 72, 171, 173, 65, 66, 37, 43, 38, 44, 36, 42}), new CarDSIAttributesSet(2, new int[]{92, 95}, new int[0])};
    }

    @Override
    protected void initModels() {
        this.tempMetricsModelZone1 = this.getMetricsModel(794624);
        this.tempMetricsModelZone2 = this.getMetricsModel(51126272);
        this.tempMetricsModelZone3 = this.getMetricsModel(101457920);
        this.tempMetricsModelZone4 = this.getMetricsModel(151789568);
        this.tempMetricsModelZone1.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone2.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone3.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone4.setMetric(new Temperature(0.0f, 1));
        this.tempLimitModelZone1 = this.getRangeModel(-16048128);
        this.tempLimitModelZone2 = this.getRangeModel(0x20C2000);
        this.tempLimitModelZone3 = this.getRangeModel(84680704);
        this.tempLimitModelZone4 = this.getRangeModel(135012352);
        this.tempLimitModelZone1.setLimits(2, 26, 1);
        this.tempLimitModelZone2.setLimits(2, 26, 1);
        this.tempLimitModelZone3.setLimits(2, 26, 1);
        this.tempLimitModelZone4.setLimits(2, 26, 1);
        this.tempLabelModelZone1 = this.getChoiceModel(1275928576);
        this.tempLabelModelZone2 = this.getChoiceModel(1242374144);
        this.tempLabelModelZone3 = this.getChoiceModel(1292705792);
        this.tempLabelModelZone4 = this.getChoiceModel(1259151360);
        this.tempLabelModelZone1.setValue(1);
        this.tempLabelModelZone2.setValue(1);
        this.tempLabelModelZone3.setValue(1);
        this.tempLabelModelZone4.setValue(1);
        this.initACRangeListener();
    }

    private void initACRangeListener() {
        this.ventilationZone1 = new AbstractACSeatPopupComponent$ACSeatVentilationRangeListener(this, this.getRangeModel(-83156992), this.getChoiceModel(-519233536), 1);
        this.ventilationZone2 = new AbstractACSeatPopupComponent$ACSeatVentilationRangeListener(this, this.getRangeModel(-66379776), this.getChoiceModel(-670228480), 2);
        this.ventilationZone3 = new AbstractACSeatPopupComponent$ACSeatVentilationRangeListener(this, this.getRangeModel(-49602560), this.getChoiceModel(671948800), 4);
        this.ventilationZone4 = new AbstractACSeatPopupComponent$ACSeatVentilationRangeListener(this, this.getRangeModel(-32825344), this.getChoiceModel(638394368), 8);
        this.ventilationDistributionZone1 = new AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener(this, this.getRangeModel(1980506112), 1);
        this.ventilationDistributionZone2 = new AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener(this, this.getRangeModel(1963728896), 2);
        this.ventilationDistributionZone3 = new AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener(this, this.getRangeModel(0x220D2000), 4);
        this.ventilationDistributionZone4 = new AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener(this, this.getRangeModel(588062720), 8);
        this.heaterZone1 = new AbstractACSeatPopupComponent$ACSeatHeaterRangeListener(this, this.getRangeModel(-150265856), this.getChoiceModel(655171584), 1);
        this.heaterZone2 = new AbstractACSeatPopupComponent$ACSeatHeaterRangeListener(this, this.getRangeModel(-133488640), this.getChoiceModel(-687005696), 2);
        this.heaterZone3 = new AbstractACSeatPopupComponent$ACSeatHeaterRangeListener(this, this.getRangeModel(-116711424), this.getChoiceModel(621617152), 4);
        this.heaterZone4 = new AbstractACSeatPopupComponent$ACSeatHeaterRangeListener(this, this.getRangeModel(-99934208), this.getChoiceModel(722280448), 8);
        this.heaterDistributionZone1 = new AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener(this, this.getRangeModel(1930174464), 1);
        this.heaterDistributionZone2 = new AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener(this, this.getRangeModel(1946951680), 2);
        this.heaterDistributionZone3 = new AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener(this, this.getRangeModel(554508288), 4);
        this.heaterDistributionZone4 = new AbstractACSeatPopupComponent$ACSeatHeaterDistributionRangeListener(this, this.getRangeModel(604839936), 8);
        this.fanSpeedZone1 = new AbstractACSeatPopupComponent$ACFanSpeedRangeListener(this, 1, 25, this.getChoiceModel(2114723840), this.getRangeModel(-351592448));
        this.fanSpeedZone2 = new AbstractACSeatPopupComponent$ACFanSpeedRangeListener(this, 2, 31, this.getChoiceModel(2097946624), this.getRangeModel(-318038016));
        this.fanSpeedZone3 = new AbstractACSeatPopupComponent$ACFanSpeedRangeListener(this, 4, 37, this.getChoiceModel(-267706368), this.getRangeModel(-284483584));
        this.fanSpeedZone4 = new AbstractACSeatPopupComponent$ACFanSpeedRangeListener(this, 8, 43, this.getChoiceModel(-234151936), this.getRangeModel(-250929152));
        this.airDistributionZone1 = new AbstractACSeatPopupComponent$ACAirDistributionChoiceListener(this, this.getChoiceModel(-217374720), this.getChoiceModel(0x200D2000), 1);
        this.airDistributionZone2 = new AbstractACSeatPopupComponent$ACAirDistributionChoiceListener(this, this.getChoiceModel(-200597504), this.getChoiceModel(520953856), 2);
        this.airDistributionZone3 = new AbstractACSeatPopupComponent$ACAirDistributionChoiceListener(this, this.getChoiceModel(-183820288), this.getChoiceModel(1359814656), 4);
        this.airDistributionZone4 = new AbstractACSeatPopupComponent$ACAirDistributionChoiceListener(this, this.getChoiceModel(-167043072), this.getChoiceModel(1343037440), 8);
        this.ventilationZone1.init(0, 3, 1);
        this.ventilationZone2.init(0, 3, 1);
        this.ventilationZone3.init(0, 3, 1);
        this.ventilationZone4.init(0, 3, 1);
        this.ventilationDistributionZone1.init(-3, 3, 3);
        this.ventilationDistributionZone2.init(-3, 3, 3);
        this.ventilationDistributionZone3.init(-3, 3, 3);
        this.ventilationDistributionZone4.init(-3, 3, 3);
        this.heaterZone1.init(0, 3, 1);
        this.heaterZone2.init(0, 3, 1);
        this.heaterZone3.init(0, 3, 1);
        this.heaterZone4.init(0, 3, 1);
        this.heaterDistributionZone1.init(-3, 3, 3);
        this.heaterDistributionZone2.init(-3, 3, 3);
        this.heaterDistributionZone3.init(-3, 3, 3);
        this.heaterDistributionZone4.init(-3, 3, 3);
        this.fanSpeedZone1.init();
        this.fanSpeedZone2.init();
        this.fanSpeedZone3.init();
        this.fanSpeedZone4.init();
        this.airDistributionZone1.init();
        this.airDistributionZone2.init();
        this.airDistributionZone3.init();
        this.airDistributionZone4.init();
    }

    @Override
    protected void deinitModels() {
        this.ventilationZone1.deinit();
        this.ventilationZone2.deinit();
        this.ventilationZone3.deinit();
        this.ventilationZone4.deinit();
        this.heaterDistributionZone1.deinit();
        this.heaterDistributionZone2.deinit();
        this.heaterDistributionZone3.deinit();
        this.heaterDistributionZone4.deinit();
        this.heaterZone1.deinit();
        this.heaterZone2.deinit();
        this.heaterZone3.deinit();
        this.heaterZone4.deinit();
        this.ventilationDistributionZone1.deinit();
        this.ventilationDistributionZone2.deinit();
        this.ventilationDistributionZone3.deinit();
        this.ventilationDistributionZone4.deinit();
        this.fanSpeedZone1.deinit();
        this.fanSpeedZone2.deinit();
        this.fanSpeedZone3.deinit();
        this.fanSpeedZone4.deinit();
        this.airDistributionZone1.deinit();
        this.airDistributionZone2.deinit();
        this.airDistributionZone3.deinit();
        this.airDistributionZone4.deinit();
        this.getChoiceModel(-519233536).resetListener();
        this.getChoiceModel(-670228480).resetListener();
        this.getChoiceModel(671948800).resetListener();
        this.getChoiceModel(638394368).resetListener();
        this.getChoiceModel(655171584).resetListener();
        this.getChoiceModel(-687005696).resetListener();
        this.getChoiceModel(621617152).resetListener();
        this.getChoiceModel(722280448).resetListener();
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.configurationHandler.updateConfiguration(airconMasterViewOptions);
            this.primaryAttributeReceived(0, 92);
            this.primaryAttributeReceived(1, 92);
            this.primaryAttributeReceived(2, 92);
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.primaryAttributeReceived(0, 93);
        }
    }

    @Override
    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsRow2] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow2 = airconRowViewOptions;
            this.primaryAttributeReceived(1, 94);
        }
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master: ");
        buffer.append(null == this.currentViewOptionsMaster ? "No master view options received yet" : this.currentViewOptionsMaster.toString());
        buffer.append("\n");
        buffer.append("Row 1: ");
        buffer.append(null == this.currentViewOptionsRow1 ? "No row (1) view options received yet" : this.currentViewOptionsRow1.toString());
        buffer.append("\n");
        buffer.append("Row 2: ");
        buffer.append(null == this.currentViewOptionsRow2 ? "No row (2) view options received yet" : this.currentViewOptionsRow2.toString());
        buffer.append("\n");
        return buffer.toString();
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconTempZone1] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone1, this.tempLabelModelZone1, airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconTempZone2] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone2, this.tempLabelModelZone2, airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconTempZone3] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone3, this.tempLabelModelZone3, airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconTempZone4] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone4, this.tempLabelModelZone4, airconTemp);
        }
    }

    private void updateAirconTemp(MetricsModelApp metricsModelApp, ChoiceModelApp choiceModelApp, AirconTemp airconTemp) {
        Temperature temperature = new Temperature(this.mapToMetricsTemperatureValue(airconTemp.getTempValue(), airconTemp.getTempUnit()), this.mapToMetricsTemperatureUnit(airconTemp.getTempUnit()));
        temperature.setUseInstanceUnit(true);
        metricsModelApp.setMetric(temperature);
        metricsModelApp.formatChanged();
        int n = 60;
        int n2 = 180;
        int n3 = 1;
        if (airconTemp.getTempUnit() == 1) {
            n = 40;
            n2 = 136;
        }
        if (airconTemp.getTempValue() < n) {
            n3 = 0;
        } else if (airconTemp.getTempValue() > n2) {
            n3 = 2;
        }
        choiceModelApp.setValue(n3);
    }

    private float mapToMetricsTemperatureValue(int n, int n2) {
        int n3 = 8257;
        int n4 = 3650;
        int n5 = -842216387;
        if (n2 == 1) {
            n3 = 18498;
            n4 = 49730;
            n5 = 32830;
        }
        float f2 = (float)n * n5 + n3;
        return AbstractACSeatPopupComponent.clip(f2, (float)n3, (float)n4);
    }

    private int mapToMetricsTemperatureUnit(int n) {
        if (n == 1) {
            return 2;
        }
        return 1;
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone1] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone1.updateAirconAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone2] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone2.updateAirconAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone3] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone3.updateAirconAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone4] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone4.updateAirconAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone1] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone1.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone2] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone2.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone3] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone3.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone4] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone4.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone1.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone2.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone3.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone4.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone1] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone1.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone2] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone2.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone3] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone3.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone4] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone4.updateACSeatSetting(n, n2);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone1.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone2.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone3.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone4.updateACSeatSetting(n);
        }
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone1] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone1.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone2] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone2.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone3] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone3.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone4] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone4.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#updateAirconSystemOnOffRow1] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.systemOnOffRow1 = bl;
        }
    }

    @Override
    public void requestAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1078071040, "<--- requestAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        if (!this.isPopupEmpty(airconContent)) {
            this.powerManager.setExtendedPowerState(102, 0);
        }
        this.enqueRequest(0, airconContent);
    }

    @Override
    public void updateAirconContent(AirconContent airconContent, int n) {
        this.logMSC.log(1078071040, "<--- updateAirconContent(%1)", (Object)this.printAirconContent(airconContent));
        this.enqueRequest(1, airconContent);
    }

    @Override
    public void acknowlegdeAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1078071040, "<--- acknowlegdeAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        if (this.isPopupEmpty(airconContent)) {
            this.powerManager.setExtendedPowerState(103, 0);
        }
    }

    public void showAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1078071040, "---> showAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        this.getDSI().showAirconPopup(airconContent);
    }

    public void cancelAirconPopup(AirconContent airconContent, int n) {
        this.logMSC.log(1078071040, "---> cancelAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        this.getDSI().cancelAirconPopup(airconContent, n);
    }

    private boolean isPopupEmpty(AirconContent airconContent) {
        return airconContent.getZone1() == 0 && airconContent.getZone2() == 0 && airconContent.getZone3() == 0 && airconContent.getZone4() == 0;
    }

    private String printAirconContent(AirconContent airconContent) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(airconContent.zone1);
        stringBuffer.append(' ');
        stringBuffer.append(airconContent.zone2);
        stringBuffer.append(' ');
        stringBuffer.append(airconContent.zone3);
        stringBuffer.append(' ');
        stringBuffer.append(airconContent.zone4);
        return stringBuffer.toString();
    }

    public abstract Integer getPPIDfromContent(Integer n, int n2) {
    }

    public abstract int getDSIIdFromPPID(int n) {
    }

    public abstract int getZoneFromPPID(int n) {
    }

    public abstract int[] getPPIDs() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void processNextRequest() {
        int n = -1;
        AirconContent airconContent = null;
        ArrayList arrayList = this.pendingRequests;
        synchronized (arrayList) {
            if (this.timerNoResponse.isRunning()) {
                this.timerNoResponse.cancel();
            }
            this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#processNextRequest] Requests in queue: %1", (long)this.pendingRequests.size());
            if (!this.pendingRequests.isEmpty()) {
                this.pendingRequestTypes.remove(0);
                this.pendingRequests.remove(0);
            } else {
                this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#processNextRequest] Stop Remove - Empty queue");
            }
            if (!this.pendingRequests.isEmpty()) {
                n = (Integer)this.pendingRequestTypes.get(0);
                airconContent = (AirconContent)this.pendingRequests.get(0);
            } else {
                this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#processNextRequest] Stop Process - Empty queue");
            }
        }
        this.doRequest(n, airconContent);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void enqueRequest(int n, AirconContent airconContent) {
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#enqueRequest] Requests in queue: %1", (long)this.pendingRequests.size());
        ArrayList arrayList = this.pendingRequests;
        synchronized (arrayList) {
            if (!this.isPopupEmpty(airconContent)) {
                this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#enqueRequest] Added to pending request queue");
                this.pendingRequests.add(airconContent);
                this.pendingRequestTypes.add(new Integer(n));
                if (this.pendingRequests.size() == 1) {
                    this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#enqueRequest] Triggered processing");
                    this.doRequest(n, airconContent);
                }
            } else if (n == 0) {
                if (this.pendingRequests.size() > 1) {
                    this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#enqueRequest] Flush queue, added request, waiting for Handler to finish");
                    int n2 = (Integer)this.pendingRequestTypes.get(0);
                    AirconContent airconContent2 = (AirconContent)this.pendingRequests.get(0);
                    this.pendingRequests.clear();
                    this.pendingRequestTypes.clear();
                    this.pendingRequests.add(airconContent2);
                    this.pendingRequestTypes.add(new Integer(n2));
                    this.pendingRequests.add(airconContent);
                    this.pendingRequestTypes.add(new Integer(n));
                } else {
                    this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#enqueRequest] First request in queue, triggered processing");
                    this.pendingRequests.add(airconContent);
                    this.pendingRequestTypes.add(new Integer(n));
                    this.doRequest(n, airconContent);
                }
            }
        }
    }

    private void doRequest(int n, AirconContent airconContent) {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("Request Type = ");
        stringBuffer.append(n);
        stringBuffer.append(" Request = ");
        stringBuffer.append(airconContent == null ? "null" : airconContent.toString());
        this.getLogChannel().log(1078071040, "[AbstractACSeatPopupComponent#doRequest]  %1", (Object)stringBuffer.toString());
        switch (n) {
            case -1: {
                break;
            }
            case 0: {
                this.startTimerIfNotRunning();
                this.partialPopupHandler.requestACPopup(airconContent);
                break;
            }
            case 1: {
                this.startTimerIfNotRunning();
                this.partialPopupHandler.updateACPopup(airconContent);
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[AbstractACSeatPopupComponent#doRequest] Unknown action type");
            }
        }
    }

    private void startTimerIfNotRunning() {
        if (!this.timerNoResponse.isRunning()) {
            this.timerNoResponse.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void triggerEmergencyFlush() {
        ArrayList arrayList = this.pendingRequests;
        synchronized (arrayList) {
            this.getLogChannel().log(-1601830656, "[AbstractACSeatPopupComponent#triggerEmergencyFlush] Flushing queues");
            if (!this.pendingRequests.isEmpty()) {
                this.showAirconPopup(new AirconContent());
                this.pendingRequests.clear();
                this.pendingRequestTypes.clear();
            }
            this.partialPopupHandler.triggerEmergencyFlush();
        }
    }

    static /* synthetic */ void access$000(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$100(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$200(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$300(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$400(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ RangeModelApp access$500(AbstractACSeatPopupComponent abstractACSeatPopupComponent, int n) {
        return abstractACSeatPopupComponent.getRangeModel(n);
    }

    static /* synthetic */ void access$600(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$700(AbstractACSeatPopupComponent abstractACSeatPopupComponent, String string, int n, int n2, boolean bl) {
        abstractACSeatPopupComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ACSeatPopupConfigurationHandler access$800(AbstractACSeatPopupComponent abstractACSeatPopupComponent) {
        return abstractACSeatPopupComponent.configurationHandler;
    }

    static /* synthetic */ boolean access$900(AbstractACSeatPopupComponent abstractACSeatPopupComponent) {
        return abstractACSeatPopupComponent.systemOnOffRow1;
    }

    static /* synthetic */ void access$1000(AbstractACSeatPopupComponent abstractACSeatPopupComponent) {
        abstractACSeatPopupComponent.triggerEmergencyFlush();
    }
}

