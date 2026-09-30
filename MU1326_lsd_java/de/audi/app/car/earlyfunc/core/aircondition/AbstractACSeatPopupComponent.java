/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.sync.IRangeModelSyncListener;
import de.audi.app.car.common.sync.IRangeModelSyncParameterAccess;
import de.audi.app.car.common.sync.RangeModelSynchronizer;
import de.audi.app.car.earlyfunc.core.aircondition.ACSeatPartialPopupHandler;
import de.audi.app.car.earlyfunc.core.aircondition.ACSeatPopupConfigurationHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.timer.DefaultTimerListener;
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
    public static final short CODING_ID = 8;
    private static final int RANGE_SEAT_DIST_MIN = -3;
    private static final int RANGE_SEAT_DIST_MAX = 3;
    private static final int RANGE_SEAT_DIST_STEP = 3;
    private static final int RANGE_SEAT_LEVEL_MIN = 0;
    private static final int RANGE_SEAT_LEVEL_MAX = 3;
    private static final int RANGE_SEAT_LEVEL_STEP = 1;
    private static final int TEMPERATURE_MIN = 2;
    private static final int TEMPERATURE_MAX = 26;
    private static final float FAHRENHEIT_STEP = 0.25f;
    private static final float CELSIUS_STEP = 0.1f;
    private static final float FAHRENHEIT_MIN_TEMPERATURE = 50.0f;
    private static final float FAHRENHEIT_MAX_TEMPERATURE = 97.0f;
    private static final float CELSIUS_MIN_TEMPERATURE = 10.0f;
    private static final float CELSIUS_MAX_TEMPERATURE = 35.5f;
    private static final int CELSIUS_MIN_TEMPERATURE_DSI_VALUE = 60;
    private static final int CELSIUS_MAX_TEMPERATURE_DSI_VALUE = 180;
    private static final int FAHRENHEIT_MIN_TEMPERATURE_DSI_VALUE = 40;
    private static final int FAHRENHEIT_MAX_TEMPERATURE_DSI_VALUE = 136;
    private static final int LABEL_LO = 0;
    private static final int LABEL_TEMP = 1;
    private static final int LABEL_HI = 2;
    private static final int AIRCON_SEAT_AUTO_LEVEL = 255;
    protected static final int ZONES_ZONE1 = 1;
    protected static final int ZONES_ZONE2 = 2;
    protected static final int ZONES_ZONE3 = 4;
    protected static final int ZONES_ZONE4 = 8;
    private final ACSeatPopupConfigurationHandler configurationHandler;
    private volatile AirconMasterViewOptions currentViewOptionsMaster;
    private volatile AirconRowViewOptions currentViewOptionsRow1;
    private volatile AirconRowViewOptions currentViewOptionsRow2;
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.AirCondition.Seat";
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
    private ACSeatVentilationRangeListener ventilationZone1;
    private ACSeatVentilationRangeListener ventilationZone2;
    private ACSeatVentilationRangeListener ventilationZone3;
    private ACSeatVentilationRangeListener ventilationZone4;
    private ACSeatVentilationDistributionRangeListener ventilationDistributionZone1;
    private ACSeatVentilationDistributionRangeListener ventilationDistributionZone2;
    private ACSeatVentilationDistributionRangeListener ventilationDistributionZone3;
    private ACSeatVentilationDistributionRangeListener ventilationDistributionZone4;
    private ACSeatHeaterRangeListener heaterZone1;
    private ACSeatHeaterRangeListener heaterZone2;
    private ACSeatHeaterRangeListener heaterZone3;
    private ACSeatHeaterRangeListener heaterZone4;
    private ACSeatHeaterDistributionRangeListener heaterDistributionZone1;
    private ACSeatHeaterDistributionRangeListener heaterDistributionZone2;
    private ACSeatHeaterDistributionRangeListener heaterDistributionZone3;
    private ACSeatHeaterDistributionRangeListener heaterDistributionZone4;
    private ACFanSpeedRangeListener fanSpeedZone1;
    private ACFanSpeedRangeListener fanSpeedZone2;
    private ACFanSpeedRangeListener fanSpeedZone3;
    private ACFanSpeedRangeListener fanSpeedZone4;
    private ACAirDistributionChoiceListener airDistributionZone1;
    private ACAirDistributionChoiceListener airDistributionZone2;
    private ACAirDistributionChoiceListener airDistributionZone3;
    private ACAirDistributionChoiceListener airDistributionZone4;
    private LogChannel logMSC;
    private ACSeatPartialPopupHandler partialPopupHandler;
    private IPowerManager powerManager;
    private volatile boolean systemOnOffRow1 = false;
    private ArrayList pendingRequestTypes = new ArrayList();
    private ArrayList pendingRequests = new ArrayList();
    private Timer timerNoResponse;
    private static final int QUEUE_BEGIN = 0;
    private static final int ACTION_INVALID = -1;
    private static final int ACTION_REQUEST = 0;
    private static final int ACTION_UPDATE = 1;

    public AbstractACSeatPopupComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.EarlyFunc.AirCondition.Seat.MSC");
        this.configurationHandler = new ACSeatPopupConfigurationHandler(this.getLogChannel());
        this.partialPopupHandler = new ACSeatPartialPopupHandler(iCarApplication, this, this.getLogChannel());
        this.powerManager = this.getApplication().getFrameworkAccess().getPowerMgr();
        this.timerNoResponse = new Timer("TimerNoResponse", 4000L, true, new NoResponseTimerListener());
    }

    public void init() {
        super.init();
        this.partialPopupHandler.init(this.getPPIDs());
    }

    public void deinit() {
        super.deinit();
        this.partialPopupHandler.deinit();
        this.powerManager.setExtendedPowerState(102, 0);
    }

    protected void dsiAvailable(boolean bl) {
        if (!bl) {
            this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#dsiAvailable] dsi not available, reset the extended power state");
            this.powerManager.setExtendedPowerState(102, 0);
        }
    }

    public String getName() {
        return "AirConditionSeatPopup";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{2, 152, 168, 170, 69, 70, 167, 169, 63, 64, 25, 31, 26, 32, 24, 30}), new CarDSIAttributesSet(1, new int[]{92, 94}, new int[]{172, 174, 71, 72, 171, 173, 65, 66, 37, 43, 38, 44, 36, 42}), new CarDSIAttributesSet(2, new int[]{92, 95}, new int[0])};
    }

    protected void initModels() {
        this.tempMetricsModelZone1 = this.getMetricsModel(0x200C00);
        this.tempMetricsModelZone2 = this.getMetricsModel(2100227);
        this.tempMetricsModelZone3 = this.getMetricsModel(2100230);
        this.tempMetricsModelZone4 = this.getMetricsModel(2100233);
        this.tempMetricsModelZone1.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone2.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone3.setMetric(new Temperature(0.0f, 1));
        this.tempMetricsModelZone4.setMetric(new Temperature(0.0f, 1));
        this.tempLimitModelZone1 = this.getRangeModel(2100223);
        this.tempLimitModelZone2 = this.getRangeModel(0x200C02);
        this.tempLimitModelZone3 = this.getRangeModel(2100229);
        this.tempLimitModelZone4 = this.getRangeModel(2100232);
        this.tempLimitModelZone1.setLimits(2, 26, 1);
        this.tempLimitModelZone2.setLimits(2, 26, 1);
        this.tempLimitModelZone3.setLimits(2, 26, 1);
        this.tempLimitModelZone4.setLimits(2, 26, 1);
        this.tempLabelModelZone1 = this.getChoiceModel(2100556);
        this.tempLabelModelZone2 = this.getChoiceModel(2100554);
        this.tempLabelModelZone3 = this.getChoiceModel(2100557);
        this.tempLabelModelZone4 = this.getChoiceModel(2100555);
        this.tempLabelModelZone1.setValue(1);
        this.tempLabelModelZone2.setValue(1);
        this.tempLabelModelZone3.setValue(1);
        this.tempLabelModelZone4.setValue(1);
        this.initACRangeListener();
    }

    private void initACRangeListener() {
        this.ventilationZone1 = new ACSeatVentilationRangeListener(this.getRangeModel(2100219), this.getChoiceModel(2100705), 1);
        this.ventilationZone2 = new ACSeatVentilationRangeListener(this.getRangeModel(2100220), this.getChoiceModel(2100696), 2);
        this.ventilationZone3 = new ACSeatVentilationRangeListener(this.getRangeModel(2100221), this.getChoiceModel(2100520), 4);
        this.ventilationZone4 = new ACSeatVentilationRangeListener(this.getRangeModel(2100222), this.getChoiceModel(2100518), 8);
        this.ventilationDistributionZone1 = new ACSeatVentilationDistributionRangeListener(this.getRangeModel(2100342), 1);
        this.ventilationDistributionZone2 = new ACSeatVentilationDistributionRangeListener(this.getRangeModel(2100341), 2);
        this.ventilationDistributionZone3 = new ACSeatVentilationDistributionRangeListener(this.getRangeModel(0x200D22), 4);
        this.ventilationDistributionZone4 = new ACSeatVentilationDistributionRangeListener(this.getRangeModel(2100515), 8);
        this.heaterZone1 = new ACSeatHeaterRangeListener(this.getRangeModel(2100215), this.getChoiceModel(2100519), 1);
        this.heaterZone2 = new ACSeatHeaterRangeListener(this.getRangeModel(2100216), this.getChoiceModel(2100695), 2);
        this.heaterZone3 = new ACSeatHeaterRangeListener(this.getRangeModel(2100217), this.getChoiceModel(2100517), 4);
        this.heaterZone4 = new ACSeatHeaterRangeListener(this.getRangeModel(2100218), this.getChoiceModel(2100523), 8);
        this.heaterDistributionZone1 = new ACSeatHeaterDistributionRangeListener(this.getRangeModel(2100339), 1);
        this.heaterDistributionZone2 = new ACSeatHeaterDistributionRangeListener(this.getRangeModel(2100340), 2);
        this.heaterDistributionZone3 = new ACSeatHeaterDistributionRangeListener(this.getRangeModel(2100513), 4);
        this.heaterDistributionZone4 = new ACSeatHeaterDistributionRangeListener(this.getRangeModel(2100516), 8);
        this.fanSpeedZone1 = new ACFanSpeedRangeListener(1, 25, this.getChoiceModel(2100350), this.getRangeModel(2100203));
        this.fanSpeedZone2 = new ACFanSpeedRangeListener(2, 31, this.getChoiceModel(2100349), this.getRangeModel(2100205));
        this.fanSpeedZone3 = new ACFanSpeedRangeListener(4, 37, this.getChoiceModel(2100208), this.getRangeModel(2100207));
        this.fanSpeedZone4 = new ACFanSpeedRangeListener(8, 43, this.getChoiceModel(2100210), this.getRangeModel(2100209));
        this.airDistributionZone1 = new ACAirDistributionChoiceListener(this.getChoiceModel(2100211), this.getChoiceModel(0x200D20), 1);
        this.airDistributionZone2 = new ACAirDistributionChoiceListener(this.getChoiceModel(2100212), this.getChoiceModel(2100511), 2);
        this.airDistributionZone3 = new ACAirDistributionChoiceListener(this.getChoiceModel(2100213), this.getChoiceModel(2100561), 4);
        this.airDistributionZone4 = new ACAirDistributionChoiceListener(this.getChoiceModel(2100214), this.getChoiceModel(2100560), 8);
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
        this.getChoiceModel(2100705).resetListener();
        this.getChoiceModel(2100696).resetListener();
        this.getChoiceModel(2100520).resetListener();
        this.getChoiceModel(2100518).resetListener();
        this.getChoiceModel(2100519).resetListener();
        this.getChoiceModel(2100695).resetListener();
        this.getChoiceModel(2100517).resetListener();
        this.getChoiceModel(2100523).resetListener();
    }

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.configurationHandler.updateConfiguration(airconMasterViewOptions);
            this.primaryAttributeReceived(0, 92);
            this.primaryAttributeReceived(1, 92);
            this.primaryAttributeReceived(2, 92);
        }
    }

    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.primaryAttributeReceived(0, 93);
        }
    }

    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsRow2] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow2 = airconRowViewOptions;
            this.primaryAttributeReceived(1, 94);
        }
    }

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

    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconTempZone1] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone1, this.tempLabelModelZone1, airconTemp);
        }
    }

    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconTempZone2] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone2, this.tempLabelModelZone2, airconTemp);
        }
    }

    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconTempZone3] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            this.updateAirconTemp(this.tempMetricsModelZone3, this.tempLabelModelZone3, airconTemp);
        }
    }

    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconTempZone4] temp='%1', valid='%2'", (Object)airconTemp, (long)n);
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
        float f2 = 10.0f;
        float f3 = 35.5f;
        float f4 = 0.1f;
        if (n2 == 1) {
            f2 = 50.0f;
            f3 = 97.0f;
            f4 = 0.25f;
        }
        float f5 = (float)n * f4 + f2;
        return AbstractACSeatPopupComponent.clip(f5, f2, f3);
    }

    private int mapToMetricsTemperatureUnit(int n) {
        if (n == 1) {
            return 2;
        }
        return 1;
    }

    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone1] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone1.updateAirconAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone2] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone2.updateAirconAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone3] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone3.updateAirconAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirVolumeZone4] airVolume='%1', valid='%2'", (Object)airconAirVolume, (long)n);
        if (n == 1) {
            this.fanSpeedZone4.updateAirconAirVolume(airconAirVolume);
        }
    }

    public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone1] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone1.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone2] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone2.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone3] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone3.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterZone4] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.heaterZone4.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone1.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone2.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone3.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.heaterDistributionZone4.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone1] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone1.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone2] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone2.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone3] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone3.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationZone4] state='%1' seatVentilation='%2', valid='%3'", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.ventilationZone4.updateACSeatSetting(n, n2);
        }
    }

    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone1.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone2.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone3.updateACSeatSetting(n);
        }
    }

    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSeatVentilationDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.ventilationDistributionZone4.updateACSeatSetting(n);
        }
    }

    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone1] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone1.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone2] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone2.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone3] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone3.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconAirDistributionZone4] distribution='%1', valid='%2'", (Object)airconAirDistribution, (long)n);
        if (n == 1) {
            this.airDistributionZone4.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#updateAirconSystemOnOffRow1] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.systemOnOffRow1 = bl;
        }
    }

    public void requestAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1000000, "<--- requestAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        if (!this.isPopupEmpty(airconContent)) {
            this.powerManager.setExtendedPowerState(102, 0);
        }
        this.enqueRequest(0, airconContent);
    }

    public void updateAirconContent(AirconContent airconContent, int n) {
        this.logMSC.log(1000000, "<--- updateAirconContent(%1)", (Object)this.printAirconContent(airconContent));
        this.enqueRequest(1, airconContent);
    }

    public void acknowlegdeAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1000000, "<--- acknowlegdeAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        if (this.isPopupEmpty(airconContent)) {
            this.powerManager.setExtendedPowerState(103, 0);
        }
    }

    public void showAirconPopup(AirconContent airconContent) {
        this.logMSC.log(1000000, "---> showAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
        this.getDSI().showAirconPopup(airconContent);
    }

    public void cancelAirconPopup(AirconContent airconContent, int n) {
        this.logMSC.log(1000000, "---> cancelAirconPopup(%1)", (Object)this.printAirconContent(airconContent));
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

    public abstract Integer getPPIDfromContent(Integer var1, int var2);

    public abstract int getDSIIdFromPPID(int var1);

    public abstract int getZoneFromPPID(int var1);

    public abstract int[] getPPIDs();

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
            this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#processNextRequest] Requests in queue: %1", (long)this.pendingRequests.size());
            if (!this.pendingRequests.isEmpty()) {
                this.pendingRequestTypes.remove(0);
                this.pendingRequests.remove(0);
            } else {
                this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#processNextRequest] Stop Remove - Empty queue");
            }
            if (!this.pendingRequests.isEmpty()) {
                n = (Integer)this.pendingRequestTypes.get(0);
                airconContent = (AirconContent)this.pendingRequests.get(0);
            } else {
                this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#processNextRequest] Stop Process - Empty queue");
            }
        }
        this.doRequest(n, airconContent);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void enqueRequest(int n, AirconContent airconContent) {
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#enqueRequest] Requests in queue: %1", (long)this.pendingRequests.size());
        ArrayList arrayList = this.pendingRequests;
        synchronized (arrayList) {
            if (!this.isPopupEmpty(airconContent)) {
                this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#enqueRequest] Added to pending request queue");
                this.pendingRequests.add(airconContent);
                this.pendingRequestTypes.add(new Integer(n));
                if (this.pendingRequests.size() == 1) {
                    this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#enqueRequest] Triggered processing");
                    this.doRequest(n, airconContent);
                }
            } else if (n == 0) {
                if (this.pendingRequests.size() > 1) {
                    this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#enqueRequest] Flush queue, added request, waiting for Handler to finish");
                    int n2 = (Integer)this.pendingRequestTypes.get(0);
                    AirconContent airconContent2 = (AirconContent)this.pendingRequests.get(0);
                    this.pendingRequests.clear();
                    this.pendingRequestTypes.clear();
                    this.pendingRequests.add(airconContent2);
                    this.pendingRequestTypes.add(new Integer(n2));
                    this.pendingRequests.add(airconContent);
                    this.pendingRequestTypes.add(new Integer(n));
                } else {
                    this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#enqueRequest] First request in queue, triggered processing");
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
        this.getLogChannel().log(1000000, "[AbstractACSeatPopupComponent#doRequest]  %1", (Object)stringBuffer.toString());
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
                this.getLogChannel().log(100000, "[AbstractACSeatPopupComponent#doRequest] Unknown action type");
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
            this.getLogChannel().log(100000, "[AbstractACSeatPopupComponent#triggerEmergencyFlush] Flushing queues");
            if (!this.pendingRequests.isEmpty()) {
                this.showAirconPopup(new AirconContent());
                this.pendingRequests.clear();
                this.pendingRequestTypes.clear();
            }
            this.partialPopupHandler.triggerEmergencyFlush();
        }
    }

    private class ACFanSpeedRangeListener
    extends DefaultRangeListener
    implements IRangeModelSyncListener,
    ChoiceListener {
        private final int dsiZone;
        private final int dsiAttribute;
        private final ChoiceModelApp autoChoiceModel;
        private final RangeModelApp rangeModel;
        private RangeModelSynchronizer rangeModelSynchronizer;
        private int airVolumeAuto = 0;
        private int airVolume = 0;
        private static final int FAN_SPEED_MIN = 0;
        private static final int FAN_SPEED_MAX = 10;
        private static final int FAN_SPEED_STEP = 1;
        private final Object mutex = new Object();

        public ACFanSpeedRangeListener(int n, int n2, ChoiceModelApp choiceModelApp, RangeModelApp rangeModelApp) {
            this.dsiZone = n;
            this.dsiAttribute = n2;
            this.autoChoiceModel = choiceModelApp;
            this.rangeModel = rangeModelApp;
        }

        public void init() {
            this.autoChoiceModel.setChoiceListener(this);
            this.rangeModel.setLimits(0, 10, 1);
            this.rangeModel.setRangeListener(this);
            String string = new StringBuffer().append("fanSpeedSynchronizerZone").append(Integer.toString(this.dsiZone)).toString();
            this.rangeModelSynchronizer = new RangeModelSynchronizer(string, this, 1000L, AbstractACSeatPopupComponent.this.getLogChannel());
            this.rangeModelSynchronizer.addWatchedAttribute(this.dsiAttribute, true, this.rangeModel);
        }

        public void deinit() {
            this.autoChoiceModel.resetListener();
            this.rangeModelSynchronizer.clear();
        }

        public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            AirconAirVolume airconAirVolume = this.createAirVolume(iRangeModelSyncParameterAccess.getCurrentValue(), this.airVolumeAuto);
            this.sendACSeatSettingToDSI(airconAirVolume);
        }

        public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            this.updateRangeModel(iRangeModelSyncParameterAccess);
        }

        public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            this.updateRangeModel(iRangeModelSyncParameterAccess);
        }

        private void updateRangeModel(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            if (AbstractACSeatPopupComponent.this.getLogChannel().isInfo()) {
                AbstractACSeatPopupComponent.this.logModelData("[ACFanSpeedRangeListener#updateRangeModel]", iRangeModelSyncParameterAccess.getRangeModelID(), iRangeModelSyncParameterAccess.getCurrentValue(), true);
            }
            AbstractACSeatPopupComponent.this.getRangeModel(iRangeModelSyncParameterAccess.getRangeModelID()).setValue(iRangeModelSyncParameterAccess.getCurrentValue());
        }

        public void decrement(int n, int n2, int n3) {
            this.setAirVolumeAuto(false);
            this.rangeModelSynchronizer.notifyDecrement(this.dsiAttribute, n2);
        }

        public void increment(int n, int n2, int n3) {
            this.setAirVolumeAuto(false);
            this.rangeModelSynchronizer.notifyIncrement(this.dsiAttribute, n2);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            if (n == this.autoChoiceModel.getID()) {
                AbstractACSeatPopupComponent.this.logModelData("[ACFanSpeedRangeListener#itemSelected]", n, n2, true);
                this.setAirVolumeAuto(n2 == 1);
                this.sendACSeatSettingToDSI(this.createAirVolume());
            } else {
                AbstractACSeatPopupComponent.this.logModelData("[ACFanSpeedRangeListener#itemSelected]", n, n2, false);
            }
        }

        public void itemFocused(int n, int n2, int n3, int n4) {
        }

        private void setAirVolumeAuto(boolean bl) {
            this.airVolumeAuto = bl ? 1 : 0;
        }

        protected void sendACSeatSettingToDSI(AirconAirVolume airconAirVolume) {
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACFanSpeedRangeListener#sendACSeatSettingToDSI] dsi.setAirconAirVolume() : zone='%1' , airVolume='%2'", (Object)new Integer(this.dsiZone), (Object)airconAirVolume);
            AbstractACSeatPopupComponent.this.getDSI().setAirconAirVolume(this.dsiZone, airconAirVolume);
            if ((this.dsiZone == 1 && AbstractACSeatPopupComponent.this.configurationHandler.isDriverSideLeft() || this.dsiZone == 2 && !AbstractACSeatPopupComponent.this.configurationHandler.isDriverSideLeft()) && AbstractACSeatPopupComponent.this.systemOnOffRow1 && airconAirVolume.getAirVolume() == 0) {
                AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACFanSpeedRangeListener#sendACSeatSettingToDSI] dsi.setAirconSystemOnOffRow(ROW1) state=false");
                AbstractACSeatPopupComponent.this.getDSI().setAirconSystemOnOffRow(1, false);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private AirconAirVolume createAirVolume() {
            Object object = this.mutex;
            synchronized (object) {
                return this.createAirVolume(this.airVolume, this.airVolumeAuto);
            }
        }

        private AirconAirVolume createAirVolume(int n, int n2) {
            AirconAirVolume airconAirVolume = new AirconAirVolume();
            airconAirVolume.airVolume = n;
            airconAirVolume.airVolumeAuto = n2;
            return airconAirVolume;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateAirconAirVolume(AirconAirVolume airconAirVolume) {
            this.autoChoiceModel.setValue(airconAirVolume.getAirVolumeAuto());
            this.rangeModelSynchronizer.notifyUpdateReceived(this.dsiAttribute, airconAirVolume.getAirVolume());
            Object object = this.mutex;
            synchronized (object) {
                this.airVolume = airconAirVolume.getAirVolume();
                this.airVolumeAuto = airconAirVolume.getAirVolumeAuto();
            }
        }
    }

    class NoResponseTimerListener
    extends DefaultTimerListener {
        NoResponseTimerListener() {
        }

        public void fireTimer(Timer timer) {
            AbstractACSeatPopupComponent.this.getLogChannel().log(100000, "[NoResponseTimerListener##fireTimer]: no response after 4 sec, flushing all queues");
            AbstractACSeatPopupComponent.this.triggerEmergencyFlush();
        }

        public void cancelTimer(Timer timer) {
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[NoResponseTimerListener#cancelTimer]: got response, cancel timer");
        }
    }

    private class ACSeatHeaterRangeListener
    extends AbstractDefaultACSeatRangeListener {
        public ACSeatHeaterRangeListener(RangeModelApp rangeModelApp, ChoiceModelApp choiceModelApp, int n) {
            super(rangeModelApp, choiceModelApp, n);
        }

        protected void sendACSeatSettingToDSI(int n, int n2) {
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACSeatHeaterRangeListener#sendACSeatSettingToDSI] dsi.setAirconSeatHeater zone=%1 ventilationState=%2 ventilationLevel=%3", (long)this.getDSIZone(), (long)n, (long)n2);
            AbstractACSeatPopupComponent.this.getDSI().setAirconSeatHeater(this.getDSIZone(), n, n2);
        }
    }

    private class ACSeatVentilationRangeListener
    extends AbstractDefaultACSeatRangeListener {
        public ACSeatVentilationRangeListener(RangeModelApp rangeModelApp, ChoiceModelApp choiceModelApp, int n) {
            super(rangeModelApp, choiceModelApp, n);
        }

        protected void sendACSeatSettingToDSI(int n, int n2) {
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACSeatVentilationRangeListener#sendACSeatSettingToDSI] dsi.setAirconSeatVentilation zone=%1 ventilationState=%2 ventilationLevel=%3", (long)this.getDSIZone(), (long)n, (long)n2);
            AbstractACSeatPopupComponent.this.getDSI().setAirconSeatVentilation(this.getDSIZone(), n, n2);
        }
    }

    private class ACAirDistributionChoiceListener
    extends DefaultChoiceListener {
        private static final int HMI_DISTRIBUTION_BITMASK_TOP = 1;
        private static final int HMI_DISTRIBUTION_BITMASK_MIDDLE = 2;
        private static final int HMI_DISTRIBUTION_BITMASK_BOTTOM = 4;
        private static final int DSI_ZONE_INACTIVE = 0;
        private static final int DSI_ZONE_ACTIVE = 12;
        private static final int AUTO_OFF = 0;
        private static final int AUTO_ON = 1;
        private final ChoiceModelApp distributionModel;
        private final ChoiceModelApp distributionAutoModel;
        private final int zone;
        private volatile boolean distributionAuto = false;

        public ACAirDistributionChoiceListener(ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, int n) {
            this.distributionModel = choiceModelApp;
            this.distributionAutoModel = choiceModelApp2;
            choiceModelApp2.setValue(0);
            this.zone = n;
        }

        public void init() {
            this.distributionModel.setChoiceListener(this);
        }

        public void deinit() {
            this.distributionModel.resetListener();
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            if (n == this.distributionModel.getID()) {
                AbstractACSeatPopupComponent.this.logModelData("[ACAirDistributionChoiceListener#itemSelected]", n, n2, true);
                int n5 = this.zone;
                AirconAirDistribution airconAirDistribution = new AirconAirDistribution();
                airconAirDistribution.footwell = this.calculateZoneState(n2, 4);
                airconAirDistribution.body = this.calculateZoneState(n2, 2);
                airconAirDistribution.up = this.calculateZoneState(n2, 1);
                airconAirDistribution.automode = this.distributionAuto;
                AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACAirDistributionChoiceListener#itemSelected] dsi.setAirconAirDistribution() : zone='%1' , airDistribution='%2'", (Object)new Integer(n5), (Object)airconAirDistribution);
                AbstractACSeatPopupComponent.this.getDSI().setAirconAirDistribution(n5, airconAirDistribution);
            } else {
                AbstractACSeatPopupComponent.this.logModelData("[ACAirDistributionChoiceListener#itemSelected]", n, n2, false);
            }
        }

        public void updateAirDistribution(AirconAirDistribution airconAirDistribution) {
            int n = 0;
            n = airconAirDistribution.footwell > 0 ? n | 4 : n;
            n = airconAirDistribution.body > 0 ? n | 2 : n;
            n = airconAirDistribution.up > 0 ? n | 1 : n;
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[ACAirDistributionChoiceListener#updateAirDistribution] update air distribution model : hmiDistribution='%1' , modelID='%2'", (long)n, (long)this.distributionModel.getID());
            this.distributionModel.setValue(n);
            this.distributionAutoModel.setValue(airconAirDistribution.isAutomode() ? 1 : 0);
            this.distributionAuto = airconAirDistribution.isAutomode();
        }

        private int calculateZoneState(int n, int n2) {
            return (n & n2) == n2 ? 12 : 0;
        }
    }

    private abstract class AbstractACSeatSettingRangeListener
    extends DefaultRangeListener {
        private final RangeModelApp acSeatSettingRangeModel;
        private final int zone;
        private int min;
        private int max;
        private int stepWidth;

        public AbstractACSeatSettingRangeListener(RangeModelApp rangeModelApp, int n) {
            this.acSeatSettingRangeModel = rangeModelApp;
            this.zone = n;
        }

        public void init(int n, int n2, int n3) {
            this.initRange(n, n2, n3);
            this.getAcSeatSettingRangeModel().setLimits(n, n2, n3);
            this.getAcSeatSettingRangeModel().setRangeListener(this);
        }

        private void initRange(int n, int n2, int n3) {
            this.min = n;
            this.max = n2;
            this.stepWidth = n3;
        }

        public void deinit() {
            this.getAcSeatSettingRangeModel().resetListener();
        }

        public void decrement(int n, int n2, int n3) {
            AbstractACSeatPopupComponent.this.logModelData("[AbstractACSeatSettingRangeListener#decrement]", n, n2, true);
            this.modifyACSeatSetting(-n2);
        }

        public void increment(int n, int n2, int n3) {
            AbstractACSeatPopupComponent.this.logModelData("[AbstractACSeatSettingRangeListener#increment]", n, n2, true);
            this.modifyACSeatSetting(n2);
        }

        private void modifyACSeatSetting(int n) {
            int n2 = this.getAcSeatSettingRangeModel().getValue() + n;
            n2 = AbstractCarComponent.clip(n2, this.min, this.max);
            this.sendACSeatSettingToDSI(n2);
        }

        protected abstract void sendACSeatSettingToDSI(int var1);

        public void updateACSeatSetting(int n, int n2) {
            int n3 = AbstractCarComponent.clip(n2, this.min, this.max);
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[AbstractACSeatSettingRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n2, (long)this.getAcSeatSettingRangeModel().getID());
            this.getAcSeatSettingRangeModel().setValue(n3);
        }

        public void updateACSeatSetting(int n) {
            int n2 = AbstractCarComponent.clip(n, this.min, this.max);
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[AbstractACSeatSettingRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n, (long)this.getAcSeatSettingRangeModel().getID());
            this.getAcSeatSettingRangeModel().setValue(n2);
        }

        protected RangeModelApp getAcSeatSettingRangeModel() {
            return this.acSeatSettingRangeModel;
        }

        public int getDSIZone() {
            return this.zone;
        }
    }

    private abstract class AbstractDefaultACSeatRangeListener
    extends AbstractACSeatSettingRangeListener
    implements ChoiceListener {
        private static final int DSI_MIN = 0;
        private static final int DSI_MAX = 6;
        private static final int HMI_MIN = 0;
        private static final int HMI_MAX = 3;
        private static final int HMI_AUTO_LEVEL_OFF = 0;
        private static final int HMI_AUTO_LEVEL_ON = 1;
        private int currentVentilationLevelDSI;
        private ChoiceModelApp autoChoiceModel;

        public AbstractDefaultACSeatRangeListener(RangeModelApp rangeModelApp, ChoiceModelApp choiceModelApp, int n) {
            super(rangeModelApp, n);
            this.currentVentilationLevelDSI = 0;
            this.autoChoiceModel = choiceModelApp;
        }

        public void init(int n, int n2, int n3) {
            super.init(n, n2, n3);
            this.autoChoiceModel.setChoiceListener(this);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            int n5;
            AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[AbstractDefaultACSeatRangeListener#itemSelected] modelID=%1 itemID=%2", (long)n, (long)n2);
            int n6 = n5 = n2 == 1 ? 255 : this.currentVentilationLevelDSI;
            int n7 = n2 == 1 ? 2 : (n5 == 0 ? 0 : 1);
            this.sendACSeatSettingToDSI(n7, n5);
        }

        public void itemFocused(int n, int n2, int n3, int n4) {
        }

        protected void sendACSeatSettingToDSI(int n) {
            int n2 = AbstractCarComponent.clip(n * 2, 0, 6);
            int n3 = n2 == 0 ? 0 : 1;
            this.sendACSeatSettingToDSI(n3, n2);
        }

        protected abstract void sendACSeatSettingToDSI(int var1, int var2);

        public void updateACSeatSetting(int n, int n2) {
            if (n == 2 || n2 == 255) {
                this.autoChoiceModel.setValue(1);
                AbstractACSeatPopupComponent.this.getLogChannel().log(1000000, "[AbstractDefaultACSeatRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n, (long)this.getAcSeatSettingRangeModel().getID());
                this.getAcSeatSettingRangeModel().setValue(0);
            } else {
                this.autoChoiceModel.setValue(0);
                this.currentVentilationLevelDSI = n2;
                super.updateACSeatSetting(AbstractCarComponent.clip(n2 / 2, 0, 3));
            }
        }
    }

    private class ACSeatHeaterDistributionRangeListener
    extends AbstractACSeatSettingRangeListener {
        public ACSeatHeaterDistributionRangeListener(RangeModelApp rangeModelApp, int n) {
            super(rangeModelApp, n);
        }

        protected void sendACSeatSettingToDSI(int n) {
            AbstractACSeatPopupComponent.this.getDSI().setAirconSeatHeaterDistribution(this.getDSIZone(), n);
        }
    }

    private class ACSeatVentilationDistributionRangeListener
    extends AbstractACSeatSettingRangeListener {
        public ACSeatVentilationDistributionRangeListener(RangeModelApp rangeModelApp, int n) {
            super(rangeModelApp, n);
        }

        protected void sendACSeatSettingToDSI(int n) {
            AbstractACSeatPopupComponent.this.getDSI().setAirconSeatVentilationDistribution(this.getDSIZone(), n);
        }
    }
}

