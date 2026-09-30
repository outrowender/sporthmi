/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultValueConverterStrategy;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.common.util.ValueConverterCollection;
import de.audi.app.car.core.aircondition.AirconConfig;
import de.audi.app.car.core.aircondition.IAirconConstants;
import de.audi.app.car.core.app.IRangeModelSyncListener;
import de.audi.app.car.core.app.IRangeModelSyncParameterAccess;
import de.audi.app.car.core.app.RangeModelSynchronizer;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.Temperature;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconMasterConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractAirconComponent
extends AbstractDSICarAirConditionAdapter
implements IAirconConstants {
    public static final short CODING_ID = 8;
    public static final String LOGCHANNEL_NAME = "App.Car.AirCondition";
    public static final long RANGE_MODEL_SYNCHRONIZER_TIMEOUT = 1000L;
    protected static final int ATTR_AIR_DISTRIBUTION = 0;
    protected static final int ATTR_AIR_VOLUME = 1;
    private final RangeModelSyncListener rangeModelSyncListener;
    protected volatile AirconMasterViewOptions currentViewOptionsMaster;
    protected volatile AirconRowViewOptions currentViewOptionsRow1;
    protected volatile AirconRowViewOptions currentViewOptionsRow2;
    protected volatile AirconRowViewOptions currentViewOptionsRow3;
    private AirconSteeringWheelHeater currentSteeringWheelHeater;
    protected TemperatureHandler temperatureZone1;
    protected TemperatureHandler temperatureZone2;
    protected TemperatureHandler temperatureZone3;
    protected TemperatureHandler temperatureZone4;
    protected AirVolumeHandler airVolumeZone1;
    protected AirVolumeHandler airVolumeZone2;
    protected AirVolumeHandler airVolumeZone3;
    protected AirVolumeHandler airVolumeZone4;
    protected AirDistributionHandler airDistributionZone1;
    protected AirDistributionHandler airDistributionZone2;
    protected AirDistributionHandler airDistributionZone3;
    protected AirDistributionHandler airDistributionZone4;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone1;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone2;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone3;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone4;
    private final RangeModelSynchronizer airCirculationSensitivityModelSync;
    protected IValueConverterStrategy footwellTemperatureConverterStrategy = new DefaultFootwellTemperatureConverterStrategy();
    protected IValueConverterStrategy climateStyleConverterStrategy = new DefaultClimateStyleConverterStrategy();
    protected IValueConverterStrategy ionizerConverterStrategy = new DefaultIonizerConverterStrategy();
    protected IValueConverterStrategy airCirculationSensitivityConverterStrategy = new DefaultValueConverterStrategy();
    protected IValueConverterStrategy middleExhaustionConverterStrategy = new DefaultMiddleExhaustionConverterStrategy();
    protected boolean invertHMISystemOnOffState = false;
    protected boolean invertHMIIndirectVentilation = false;
    private final DefaultChoiceListener choiceListener = new DefaultChoiceListener(){

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractAirconComponent.this.getLogChannel().log(10000000, "[AbstractAirconComponent.DefaultChoiceListener#itemSelected] modelID=%1, itemID=%2", (long)n, (long)n2);
            boolean bl = 1 == n2;
            switch (n) {
                case 602126: {
                    AbstractAirconComponent.this.setStateAC(bl);
                    break;
                }
                case 602390: {
                    AbstractAirconComponent.this.setStateEcoAC(bl);
                    break;
                }
                case 602127: {
                    AbstractAirconComponent.this.setStateMaxAC(bl);
                    break;
                }
                case 600631: {
                    AbstractAirconComponent.this.setAirCirculationSensitivity(n2);
                    break;
                }
                case 601247: {
                    AbstractAirconComponent.this.setMiddleExhaustion(n2);
                    break;
                }
                case 602365: {
                    AbstractAirconComponent.this.setAirCirculationAuto(bl);
                    break;
                }
                case 602397: {
                    AbstractAirconComponent.this.setIndirectVentilation(AbstractAirconComponent.this.invertHMIIndirectVentilation ? !bl : bl);
                    break;
                }
                case 600629: {
                    AbstractAirconComponent.this.setHeater(bl);
                    break;
                }
                case 600644: {
                    AbstractAirconComponent.this.setFrontWindowHeaterAuto(bl);
                    break;
                }
                case 602129: {
                    AbstractAirconComponent.this.setSteeringWheelHeating(bl);
                    break;
                }
                case 600660: {
                    AbstractAirconComponent.this.setSolar(bl);
                    break;
                }
                case 602125: {
                    AbstractAirconComponent.this.setRearControlFondPlus(bl);
                    break;
                }
                case 602409: {
                    if (null == AbstractAirconComponent.this.currentViewOptionsRow1) break;
                    if (2 == AbstractAirconComponent.this.currentViewOptionsRow1.getZoneLeftViewOptions().getAirconIonisator().getState()) {
                        AbstractAirconComponent.this.setIonizerState(1, n2);
                    }
                    if (2 != AbstractAirconComponent.this.currentViewOptionsRow1.getZoneRightViewOptions().getAirconIonisator().getState()) break;
                    AbstractAirconComponent.this.setIonizerState(2, n2);
                    break;
                }
                case 602366: {
                    if (null == AbstractAirconComponent.this.currentViewOptionsMaster) break;
                    boolean bl2 = AbstractAirconComponent.this.currentViewOptionsMaster.getConfiguration().isCarDriverSide();
                    int n5 = bl ? (bl2 ? 2 : 1) : 0;
                    AbstractAirconComponent.this.setSynchronization(n5, bl);
                    break;
                }
                case 602408: {
                    AbstractAirconComponent.this.setSystemOnOff(1, AbstractAirconComponent.this.invertHMISystemOnOffState ? !bl : bl);
                    break;
                }
                case 602418: {
                    AbstractAirconComponent.this.setFootwellTemperature(1, n2);
                    AbstractAirconComponent.this.onFootwellTemperatureAction(1);
                    break;
                }
                case 602210: {
                    AbstractAirconComponent.this.setFootwellTemperature(2, n2);
                    AbstractAirconComponent.this.onFootwellTemperatureAction(2);
                    break;
                }
                case 602367: {
                    AbstractAirconComponent.this.setClimateStyle(1, n2);
                    AbstractAirconComponent.this.onClimateStyleAction(1);
                    break;
                }
                case 601969: {
                    AbstractAirconComponent.this.setClimateStyle(2, n2);
                    AbstractAirconComponent.this.onClimateStyleAction(2);
                    break;
                }
                case 602158: {
                    AbstractAirconComponent.this.airVolumeZone1.dsiSetVolumeAuto(n2);
                    break;
                }
                case 602161: {
                    AbstractAirconComponent.this.airVolumeZone2.dsiSetVolumeAuto(n2);
                    break;
                }
                case 602400: {
                    AbstractAirconComponent.this.airDistributionZone1.dsiSetUp(bl ? 12 : 0);
                    break;
                }
                case 602136: {
                    AbstractAirconComponent.this.airDistributionZone1.dsiSetBody(bl ? 12 : 0);
                    break;
                }
                case 602361: {
                    AbstractAirconComponent.this.airDistributionZone1.dsiSetFootwell(bl ? 12 : 0);
                    break;
                }
                case 602145: {
                    AbstractAirconComponent.this.airDistributionZone1.dsiSetAutomode(bl);
                    break;
                }
                case 602139: {
                    AbstractAirconComponent.this.airDistributionZone2.dsiSetUp(bl ? 12 : 0);
                    break;
                }
                case 602404: {
                    AbstractAirconComponent.this.airDistributionZone2.dsiSetBody(bl ? 12 : 0);
                    break;
                }
                case 602144: {
                    AbstractAirconComponent.this.airDistributionZone2.dsiSetFootwell(bl ? 12 : 0);
                    break;
                }
                case 602134: {
                    AbstractAirconComponent.this.airDistributionZone2.dsiSetAutomode(bl);
                    break;
                }
                case 602124: {
                    AbstractAirconComponent.this.setSystemOnOff(2, AbstractAirconComponent.this.invertHMISystemOnOffState ? !bl : bl);
                    break;
                }
                case 602209: {
                    AbstractAirconComponent.this.setFootwellTemperature(3, n2);
                    AbstractAirconComponent.this.onFootwellTemperatureAction(3);
                    break;
                }
                case 602207: {
                    AbstractAirconComponent.this.setFootwellTemperature(4, n2);
                    AbstractAirconComponent.this.onFootwellTemperatureAction(4);
                    break;
                }
                case 601966: {
                    AbstractAirconComponent.this.setClimateStyle(3, n2);
                    AbstractAirconComponent.this.onClimateStyleAction(3);
                    break;
                }
                case 601967: {
                    AbstractAirconComponent.this.setClimateStyle(4, n2);
                    AbstractAirconComponent.this.onClimateStyleAction(4);
                    break;
                }
                case 602159: {
                    AbstractAirconComponent.this.airVolumeZone3.dsiSetVolumeAuto(n2);
                    break;
                }
                case 602160: {
                    AbstractAirconComponent.this.airVolumeZone4.dsiSetVolumeAuto(n2);
                    break;
                }
                case 602132: {
                    AbstractAirconComponent.this.airDistributionZone3.dsiSetUp(bl ? 12 : 0);
                    break;
                }
                case 602374: {
                    AbstractAirconComponent.this.airDistributionZone3.dsiSetBody(bl ? 12 : 0);
                    break;
                }
                case 602417: {
                    AbstractAirconComponent.this.airDistributionZone3.dsiSetFootwell(bl ? 12 : 0);
                    break;
                }
                case 602140: {
                    AbstractAirconComponent.this.airDistributionZone3.dsiSetAutomode(bl);
                    break;
                }
                case 602138: {
                    AbstractAirconComponent.this.airDistributionZone4.dsiSetUp(bl ? 12 : 0);
                    break;
                }
                case 602384: {
                    AbstractAirconComponent.this.airDistributionZone4.dsiSetBody(bl ? 12 : 0);
                    break;
                }
                case 602401: {
                    AbstractAirconComponent.this.airDistributionZone4.dsiSetFootwell(bl ? 12 : 0);
                    break;
                }
                case 602141: {
                    AbstractAirconComponent.this.airDistributionZone4.dsiSetAutomode(bl);
                    break;
                }
                case 602130: {
                    AbstractAirconComponent.this.setSystemOnOff(3, AbstractAirconComponent.this.invertHMISystemOnOffState ? !bl : bl);
                    break;
                }
                default: {
                    AbstractAirconComponent.this.getLogChannel().log(100000, "[AbstractAirconComponent.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
                }
            }
        }
    };
    private final DefaultRangeListener rangeListener = new DefaultRangeListener(){

        public void keyPressed(int n, int n2, int n3) {
            AbstractAirconComponent.this.getLogChannel().log(1000000, "[AbstractAirConditionComponent#keyPressed] modelID='%1'", (long)n);
            switch (n) {
                case 601991: {
                    AbstractAirconComponent.this.getRangeModel(601991).fireEvent(n3);
                    break;
                }
                case 601990: {
                    AbstractAirconComponent.this.getRangeModel(601990).fireEvent(n3);
                    break;
                }
                case 601988: {
                    AbstractAirconComponent.this.getRangeModel(601988).fireEvent(n3);
                    break;
                }
                case 601989: {
                    AbstractAirconComponent.this.getRangeModel(601989).fireEvent(n3);
                    break;
                }
            }
        }

        public void decrement(int n, int n2, int n3) {
            AbstractAirconComponent.this.getLogChannel().log(10000000, "[AbstractAirconComponent.DefaultRangeListener#decrement] modelID=%1, steps=%2", (long)n, (long)n2);
            switch (n) {
                case 600630: {
                    AbstractAirconComponent.this.airCirculationSensitivityModelSync.notifyDecrement(5, n2);
                    break;
                }
                case 602187: {
                    AbstractAirconComponent.this.temperatureZone1.decrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(1);
                    break;
                }
                case 602192: {
                    AbstractAirconComponent.this.temperatureZone1.decrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(1);
                    break;
                }
                case 602195: {
                    AbstractAirconComponent.this.temperatureZone2.decrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(2);
                    break;
                }
                case 602194: {
                    AbstractAirconComponent.this.temperatureZone2.decrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(2);
                    break;
                }
                case 602162: {
                    AbstractAirconComponent.this.airVolumeZone1.decrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(1);
                    break;
                }
                case 602165: {
                    AbstractAirconComponent.this.airVolumeZone2.decrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(2);
                    break;
                }
                case 601991: {
                    AbstractAirconComponent.this.decrementFootwellTemperature(1, n2);
                    break;
                }
                case 601990: {
                    AbstractAirconComponent.this.decrementFootwellTemperature(2, n2);
                    break;
                }
                case 602186: {
                    AbstractAirconComponent.this.temperatureZone3.decrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(3);
                    break;
                }
                case 602403: {
                    AbstractAirconComponent.this.temperatureZone3.decrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(3);
                    break;
                }
                case 602197: {
                    AbstractAirconComponent.this.temperatureZone4.decrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(4);
                    break;
                }
                case 602413: {
                    AbstractAirconComponent.this.temperatureZone4.decrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(4);
                    break;
                }
                case 602416: {
                    AbstractAirconComponent.this.airVolumeZone3.decrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(3);
                    break;
                }
                case 602407: {
                    AbstractAirconComponent.this.airVolumeZone4.decrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(4);
                    break;
                }
                case 601988: {
                    AbstractAirconComponent.this.decrementFootwellTemperature(3, n2);
                    break;
                }
                case 601989: {
                    AbstractAirconComponent.this.decrementFootwellTemperature(4, n2);
                    break;
                }
                default: {
                    AbstractAirconComponent.this.getLogChannel().log(100000, "[AbstractAirconComponent.DefaultRangeListener#decrement] ModelID='%1' not supported.", (long)n);
                }
            }
        }

        public void increment(int n, int n2, int n3) {
            AbstractAirconComponent.this.getLogChannel().log(10000000, "[AbstractAirconComponent.DefaultRangeListener#increment] modelID=%1, steps=%2", (long)n, (long)n2);
            switch (n) {
                case 600630: {
                    AbstractAirconComponent.this.airCirculationSensitivityModelSync.notifyIncrement(5, n2);
                    break;
                }
                case 602187: {
                    AbstractAirconComponent.this.temperatureZone1.incrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(1);
                    break;
                }
                case 602192: {
                    AbstractAirconComponent.this.temperatureZone1.incrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(1);
                    break;
                }
                case 602195: {
                    AbstractAirconComponent.this.temperatureZone2.incrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(2);
                    break;
                }
                case 602194: {
                    AbstractAirconComponent.this.temperatureZone2.incrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(2);
                    break;
                }
                case 602162: {
                    AbstractAirconComponent.this.airVolumeZone1.incrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(1);
                    break;
                }
                case 602165: {
                    AbstractAirconComponent.this.airVolumeZone2.incrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(2);
                    break;
                }
                case 601991: {
                    AbstractAirconComponent.this.incrementFootwellTemperature(1, n2);
                    break;
                }
                case 601990: {
                    AbstractAirconComponent.this.incrementFootwellTemperature(2, n2);
                    break;
                }
                case 602186: {
                    AbstractAirconComponent.this.temperatureZone3.incrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(3);
                    break;
                }
                case 602403: {
                    AbstractAirconComponent.this.temperatureZone3.incrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(3);
                    break;
                }
                case 602197: {
                    AbstractAirconComponent.this.temperatureZone4.incrementTemperature(n2, 1);
                    AbstractAirconComponent.this.onTemperatureAction(4);
                    break;
                }
                case 602413: {
                    AbstractAirconComponent.this.temperatureZone4.incrementTemperature(n2, 2);
                    AbstractAirconComponent.this.onTemperatureAction(4);
                    break;
                }
                case 602416: {
                    AbstractAirconComponent.this.airVolumeZone3.incrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(3);
                    break;
                }
                case 602407: {
                    AbstractAirconComponent.this.airVolumeZone4.incrementVolume(n2);
                    AbstractAirconComponent.this.onVolumeAction(4);
                    break;
                }
                case 601988: {
                    AbstractAirconComponent.this.incrementFootwellTemperature(3, n2);
                    break;
                }
                case 601989: {
                    AbstractAirconComponent.this.incrementFootwellTemperature(4, n2);
                    break;
                }
                default: {
                    AbstractAirconComponent.this.getLogChannel().log(100000, "[AbstractAirconComponent.DefaultRangeListener#increment] ModelID='%1' not supported.", (long)n);
                }
            }
        }
    };

    public AbstractAirconComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.setLogChannelDSI(true);
        this.rangeModelSyncListener = new RangeModelSyncListener();
        this.footwellTempRangeModelSyncZone1 = new RangeModelSynchronizer("FootwellZone1", this.rangeModelSyncListener, 1000L, this.getLogChannel());
        this.footwellTempRangeModelSyncZone2 = new RangeModelSynchronizer("FootwellZone2", this.rangeModelSyncListener, 1000L, this.getLogChannel());
        this.footwellTempRangeModelSyncZone3 = new RangeModelSynchronizer("FootwellZone3", this.rangeModelSyncListener, 1000L, this.getLogChannel());
        this.footwellTempRangeModelSyncZone4 = new RangeModelSynchronizer("FootwellZone4", this.rangeModelSyncListener, 1000L, this.getLogChannel());
        this.airCirculationSensitivityModelSync = new RangeModelSynchronizer("AirCirculationSensitivity", this.rangeModelSyncListener, 1000L, this.getLogChannel());
    }

    private void initAirconCirculationSensitivity(AirconMasterViewOptions airconMasterViewOptions) {
        this.getRangeModel(600630).setLimits(this.isAirCirculationAutoAvailable() ? this.getConfig().getAirCirculationSensitivityRangeMinWithOff() : this.getConfig().getAirCirculationSensitivityRangeMin(), this.getConfig().getAirCirculationSensitivityRangeMax(), this.getConfig().getAirCirculationSensitivityRangeStep());
        this.getRangeModel(600630).setRangeListener(this.rangeListener);
        this.airCirculationSensitivityModelSync.addWatchedAttribute(5, true, this.getRangeModel(600630));
    }

    private boolean isAirCirculationAutoAvailable() {
        if (null != this.currentViewOptionsMaster) {
            boolean bl = 0 != this.currentViewOptionsMaster.getAirconAirCirculationAuto().getState();
            return bl;
        }
        return false;
    }

    private void setSystemOnOff(int n, boolean bl) {
        int n2 = this.convertRowHMI2DSI(n);
        if (-1 != n2) {
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconSystemOnOffRow(%1, %2)", (Object)Integer.toString(n2), (Object)(bl ? "true" : "false"));
            this.getDSI().setAirconSystemOnOffRow(n2, bl);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setSystemOnOff] Unsupported zone. DSI-Call not send.");
        }
    }

    private void setStateAC(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconAC(%1)", bl);
        this.getDSI().setAirconAC(bl);
    }

    private void setStateEcoAC(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconEcoAC(%1)", bl);
        this.getDSI().setAirconEcoAC(bl);
    }

    private void setStateMaxAC(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconMaxAC(%1)", bl);
        this.getDSI().setAirconMaxAC(bl);
    }

    private void setSynchronization(int n, boolean bl) {
        if (null != this.currentViewOptionsMaster) {
            AirconMasterConfiguration airconMasterConfiguration = this.currentViewOptionsMaster.getConfiguration();
            AirconSynchronisation airconSynchronisation = new AirconSynchronisation();
            if (bl && null != airconMasterConfiguration) {
                airconSynchronisation.master = n;
                airconSynchronisation.slaveZL1R = airconMasterConfiguration.isZl1r();
                airconSynchronisation.slaveZR1R = airconMasterConfiguration.isZr1r();
                airconSynchronisation.slaveZL2R = airconMasterConfiguration.isZl2r();
                airconSynchronisation.slaveZR2R = airconMasterConfiguration.isZr2r();
                airconSynchronisation.slaveZL3R = airconMasterConfiguration.isZl3r();
                airconSynchronisation.slaveZR3R = airconMasterConfiguration.isZr3r();
            } else {
                airconSynchronisation.master = 0;
                airconSynchronisation.slaveZL1R = false;
                airconSynchronisation.slaveZR1R = false;
                airconSynchronisation.slaveZL2R = false;
                airconSynchronisation.slaveZR2R = false;
                airconSynchronisation.slaveZL3R = false;
                airconSynchronisation.slaveZR3R = false;
            }
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconSynchronisation(%1)", (Object)airconSynchronisation);
            this.getDSI().setAirconSynchronisation(airconSynchronisation);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setSynchronization]: Couldn't get configuration. DSI-Call not send.");
        }
    }

    private void setAirCirculationSensitivity(int n) {
        int n2;
        try {
            n2 = this.convertCirculationSensitivityHMI2DSI(n);
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.getLogChannel().log(100000, "[AbstractAirconComponent#setAirCirculationSensitivity] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            return;
        }
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconAirCirculationSensitivity(%1)", (long)n2);
        this.getDSI().setAirconAirCirculationSensitivity(n2);
    }

    private void setMiddleExhaustion(int n) {
        int n2;
        try {
            n2 = this.convertMiddleExhaustionHMI2DSI(n);
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.getLogChannel().log(100000, "[AbstractAirconComponent#setMiddleExhaustion] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            return;
        }
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconMiddleExhaustion(%1)", (long)n2);
        this.getDSI().setAirconMiddleExhaustion(n2);
    }

    private void setAirCirculationAuto(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconAirCirculationAuto(%1)", bl);
        this.getDSI().setAirconAirCirculationAuto(bl);
    }

    private void setIndirectVentilation(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconIndirectVentilation(%1)", bl);
        this.getDSI().setAirconIndirectVentilation(bl);
    }

    private void setHeater(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconHeater(%1)", bl);
        this.getDSI().setAirconHeater(bl);
    }

    private void setFrontWindowHeaterAuto(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconFrontWindowHeaterAuto(%1)", bl);
        this.getDSI().setAirconFrontWindowHeaterAuto(bl);
    }

    private void setSteeringWheelHeating(boolean bl) {
        if (null != this.currentSteeringWheelHeater) {
            AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(bl, this.currentSteeringWheelHeater.currentState, this.currentSteeringWheelHeater.autoHeating, this.currentSteeringWheelHeater.adjustViaSeatHeating, this.currentSteeringWheelHeater.heatingStep);
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconSteeringWheelHeater(%1)", (Object)airconSteeringWheelHeater.toString());
            this.getDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setSteeringWheelHeating] No AirconSteeringWheelHeater-Information received yet. DSI-Call not send.");
        }
    }

    private void setSolar(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconSolar(%1)", bl);
        this.getDSI().setAirconSolar(bl);
    }

    private void setRearControlFondPlus(boolean bl) {
        this.getLogChannel(1).log(1000000, "---> DSI.setAirconRearControlFondPlus(%1)", bl);
        this.getDSI().setAirconRearControlFondPlus(bl);
    }

    private void setFootwellTemperature(int n, int n2) {
        int n3 = this.convertZoneHMI2DSI(n);
        if (-1 != n3) {
            int n4;
            try {
                n4 = this.convertFootwellTemperatureHMI2DSI(n2);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#setFootwellTemperature] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconFootwellTemp(%1, %2)", (long)n3, (long)n4);
            this.getDSI().setAirconFootwellTemp(n3, n4);
        }
    }

    private void incrementFootwellTemperature(int n, int n2) {
        switch (n) {
            case 1: {
                this.footwellTempRangeModelSyncZone1.notifyIncrement(27, n2);
                break;
            }
            case 2: {
                this.footwellTempRangeModelSyncZone2.notifyIncrement(33, n2);
                break;
            }
            case 3: {
                this.footwellTempRangeModelSyncZone3.notifyIncrement(39, n2);
                break;
            }
            case 4: {
                this.footwellTempRangeModelSyncZone4.notifyIncrement(45, n2);
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractAirconComponent#incrementFootwellTemperature] Unsupported zone. DSI-Call not send.");
                return;
            }
        }
    }

    private void decrementFootwellTemperature(int n, int n2) {
        switch (n) {
            case 1: {
                this.footwellTempRangeModelSyncZone1.notifyDecrement(27, n2);
                break;
            }
            case 2: {
                this.footwellTempRangeModelSyncZone2.notifyDecrement(33, n2);
                break;
            }
            case 3: {
                this.footwellTempRangeModelSyncZone3.notifyDecrement(39, n2);
                break;
            }
            case 4: {
                this.footwellTempRangeModelSyncZone4.notifyDecrement(45, n2);
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractAirconComponent#incrementFootwellTemperature] Unsupported zone. DSI-Call not send.");
                return;
            }
        }
    }

    private void setClimateStyle(int n, int n2) {
        int n3 = this.convertZoneHMI2DSI(n);
        if (-1 != n3) {
            int n4;
            try {
                n4 = this.convertClimateStyleHMI2DSI(n2);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractAirconComponent#setClimateStyle] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconClimateStyle(%1, %2)", (long)n3, (long)n4);
            this.getDSI().setAirconClimateStyle(n3, n4);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setFootwellTemperature] Unsupported zone. DSI-Call not send.");
        }
    }

    private void setIonizerState(int n, int n2) {
        int n3 = this.convertZoneHMI2DSI(n);
        if (-1 != n3) {
            int n4;
            try {
                n4 = this.convertIonizerStateHMI2DSI(n2);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractAirconComponent#setIonizerState] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getLogChannel(1).log(1000000, "---> DSI.setAirconIonisator(%1, %2)", (long)n3, (long)n4);
            this.getDSI().setAirconIonisator(n3, n4);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setIonizer] Unsupported zone. DSI-Call not send.");
        }
    }

    protected boolean isSystemOnOff(int n) {
        boolean bl;
        int n2 = this.invertHMISystemOnOffState ? 0 : 1;
        switch (n) {
            case 1: {
                bl = n2 == this.getChoiceModel(602408).getValue();
                break;
            }
            case 2: {
                bl = n2 == this.getChoiceModel(602124).getValue();
                break;
            }
            case 3: {
                bl = n2 == this.getChoiceModel(602130).getValue();
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.isSystemOnOff] Row('%1') not supported.", (long)n);
                bl = false;
            }
        }
        return bl;
    }

    protected boolean isAirVolumeAutoMode(int n) {
        boolean bl;
        switch (n) {
            case 1: {
                bl = null == this.airVolumeZone1.currentAirVolume ? false : this.airVolumeZone1.currentAirVolume.getAirVolumeAuto() != 0;
                break;
            }
            case 2: {
                bl = null == this.airVolumeZone2.currentAirVolume ? false : this.airVolumeZone2.currentAirVolume.getAirVolumeAuto() != 0;
                break;
            }
            case 3: {
                bl = null == this.airVolumeZone3.currentAirVolume ? false : this.airVolumeZone3.currentAirVolume.getAirVolumeAuto() != 0;
                break;
            }
            case 4: {
                bl = null == this.airVolumeZone4.currentAirVolume ? false : this.airVolumeZone4.currentAirVolume.getAirVolumeAuto() != 0;
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.isAirVolumeAutoMode] Zone('%1') not supported.", (long)n);
                return false;
            }
        }
        return bl;
    }

    protected boolean isAirDistributionAutoMode(int n) {
        boolean bl;
        switch (n) {
            case 1: {
                bl = null == this.airDistributionZone1.currentAirDistribution ? false : this.airDistributionZone1.currentAirDistribution.isAutomode();
                break;
            }
            case 2: {
                bl = null == this.airDistributionZone2.currentAirDistribution ? false : this.airDistributionZone2.currentAirDistribution.isAutomode();
                break;
            }
            case 3: {
                bl = null == this.airDistributionZone3.currentAirDistribution ? false : this.airDistributionZone3.currentAirDistribution.isAutomode();
                break;
            }
            case 4: {
                bl = null == this.airDistributionZone4.currentAirDistribution ? false : this.airDistributionZone4.currentAirDistribution.isAutomode();
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.isAirDistributionAutoMode] Zone('%1') not supported.", (long)n);
                return false;
            }
        }
        return bl;
    }

    protected void onAirconSyncChanged(boolean bl) {
    }

    protected void onTemperatureAction(int n) {
    }

    protected void onFootwellTemperatureAction(int n) {
    }

    protected void onClimateStyleAction(int n) {
    }

    protected void onVolumeAction(int n) {
    }

    protected abstract AirconConfig getConfig();

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions var1);

    protected abstract void updateMenuEntryVisibility(int var1, AirconRowViewOptions var2);

    protected abstract boolean isUpdateIonizer(int var1);

    protected abstract void notifySystemOnOff(int var1, boolean var2);

    protected abstract void notifyAutoModeStateChanged(int var1, int var2);

    public String getName() {
        return "AirCondition Control";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{152, 15, 83, 82, 21, 5, 6, 4, 8, 10, 19, 17, 14, 91, 24, 30, 25, 31, 26, 32, 27, 33, 110, 112, 140, 141}), new CarDSIAttributesSet(1, new int[]{92, 94}, new int[]{153, 36, 42, 37, 43, 38, 44, 39, 45, 114, 116, 142, 143}), new CarDSIAttributesSet(2, new int[]{92, 95}, new int[0])};
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
        buffer.append("Row 3: ");
        buffer.append(null == this.currentViewOptionsRow3 ? "No row (3) view options received yet" : this.currentViewOptionsRow3.toString());
        return buffer.toString();
    }

    protected void initModels() {
        this.getChoiceModel(602408).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602126).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602390).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602127).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602366).setChoiceListener(this.choiceListener);
        this.getChoiceModel(600631).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602365).setChoiceListener(this.choiceListener);
        this.getChoiceModel(601247).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602397).setChoiceListener(this.choiceListener);
        this.getChoiceModel(600629).setChoiceListener(this.choiceListener);
        this.getChoiceModel(600644).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602129).setChoiceListener(this.choiceListener);
        this.getChoiceModel(600660).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602125).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602409).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602367).setChoiceListener(this.choiceListener);
        this.getChoiceModel(601969).setChoiceListener(this.choiceListener);
        this.getRangeModel(602187).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(602187).setRangeListener(this.rangeListener);
        this.getRangeModel(602192).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(602192).setRangeListener(this.rangeListener);
        this.temperatureZone1 = new TemperatureHandler("Temperature Zone 1", 1, 602187, 602192, 602196, 602190);
        this.getRangeModel(602195).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(602195).setRangeListener(this.rangeListener);
        this.getRangeModel(602194).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(602194).setRangeListener(this.rangeListener);
        this.temperatureZone2 = new TemperatureHandler("Temperature Zone 2", 2, 602195, 602194, 602188, 602358);
        this.getRangeModel(602162).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(602162).setRangeListener(this.rangeListener);
        this.getChoiceModel(602158).setChoiceListener(this.choiceListener);
        this.airVolumeZone1 = new AirVolumeHandler("Volume Zone 1", 1, 25, 602162, 602158);
        this.getRangeModel(602165).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(602165).setRangeListener(this.rangeListener);
        this.getChoiceModel(602161).setChoiceListener(this.choiceListener);
        this.airVolumeZone2 = new AirVolumeHandler("Volume Zone 2", 2, 31, 602165, 602161);
        this.getChoiceModel(602400).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602136).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602361).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602145).setChoiceListener(this.choiceListener);
        this.airDistributionZone1 = new AirDistributionHandler("Distribution Zone 1", 1, 602400, 602136, 602361, 602145);
        this.getChoiceModel(602139).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602404).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602144).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602134).setChoiceListener(this.choiceListener);
        this.airDistributionZone2 = new AirDistributionHandler("Distribution Zone 2", 2, 602139, 602404, 602144, 602134);
        this.getRangeModel(601991).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(601991).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone1.addWatchedAttribute(27, true, this.getRangeModel(601991));
        this.getChoiceModel(602418).setChoiceListener(this.choiceListener);
        this.getRangeModel(601990).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(601990).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone2.addWatchedAttribute(33, true, this.getRangeModel(601990));
        this.getChoiceModel(602210).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602124).setChoiceListener(this.choiceListener);
        this.getChoiceModel(601966).setChoiceListener(this.choiceListener);
        this.getChoiceModel(601967).setChoiceListener(this.choiceListener);
        this.getRangeModel(602186).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(602186).setRangeListener(this.rangeListener);
        this.getRangeModel(602403).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(602403).setRangeListener(this.rangeListener);
        this.temperatureZone3 = new TemperatureHandler("Temperature Zone 3", 3, 602186, 602403, 602199, 602191);
        this.getRangeModel(602197).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(602197).setRangeListener(this.rangeListener);
        this.getRangeModel(602413).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(602413).setRangeListener(this.rangeListener);
        this.temperatureZone4 = new TemperatureHandler("Temperature Zone 4", 4, 602197, 602413, 602382, 602189);
        this.getRangeModel(602416).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(602416).setRangeListener(this.rangeListener);
        this.getChoiceModel(602159).setChoiceListener(this.choiceListener);
        this.airVolumeZone3 = new AirVolumeHandler("Volume Zone 3", 3, 37, 602416, 602159);
        this.getRangeModel(602407).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(602407).setRangeListener(this.rangeListener);
        this.getChoiceModel(602160).setChoiceListener(this.choiceListener);
        this.airVolumeZone4 = new AirVolumeHandler("Volume Zone 4", 4, 43, 602407, 602160);
        this.getChoiceModel(602132).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602374).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602417).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602140).setChoiceListener(this.choiceListener);
        this.airDistributionZone3 = new AirDistributionHandler("Distribution Zone 3", 3, 602132, 602374, 602417, 602140);
        this.getChoiceModel(602138).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602384).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602401).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602141).setChoiceListener(this.choiceListener);
        this.airDistributionZone4 = new AirDistributionHandler("Distribution Zone 4", 4, 602138, 602384, 602401, 602141);
        this.getRangeModel(601988).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(601988).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone3.addWatchedAttribute(39, true, this.getRangeModel(601988));
        this.getChoiceModel(602209).setChoiceListener(this.choiceListener);
        this.getRangeModel(601989).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(601989).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone4.addWatchedAttribute(45, true, this.getRangeModel(601989));
        this.getChoiceModel(602207).setChoiceListener(this.choiceListener);
        this.getChoiceModel(602130).setChoiceListener(this.choiceListener);
    }

    protected void deinitModels() {
        this.getChoiceModel(602408).resetListener();
        this.getChoiceModel(602126).resetListener();
        this.getChoiceModel(602390).resetListener();
        this.getChoiceModel(602127).resetListener();
        this.getChoiceModel(602366).resetListener();
        this.getChoiceModel(600631).resetListener();
        this.getChoiceModel(602365).resetListener();
        this.getChoiceModel(601247).resetListener();
        this.getChoiceModel(602397).resetListener();
        this.getChoiceModel(600629).resetListener();
        this.getChoiceModel(600644).resetListener();
        this.getChoiceModel(602129).resetListener();
        this.getChoiceModel(600660).resetListener();
        this.getChoiceModel(602125).resetListener();
        this.getChoiceModel(602409).resetListener();
        this.getRangeModel(602187).resetListener();
        this.getRangeModel(602192).resetListener();
        this.temperatureZone1 = null;
        this.getRangeModel(602195).resetListener();
        this.getRangeModel(602194).resetListener();
        this.temperatureZone2 = null;
        this.getRangeModel(602162).resetListener();
        this.getChoiceModel(602158).resetListener();
        this.airVolumeZone1 = null;
        this.getRangeModel(602165).resetListener();
        this.getChoiceModel(602161).resetListener();
        this.airVolumeZone2 = null;
        this.getChoiceModel(602367).resetListener();
        this.getChoiceModel(601969).resetListener();
        this.getChoiceModel(602400).resetListener();
        this.getChoiceModel(602136).resetListener();
        this.getChoiceModel(602361).resetListener();
        this.getChoiceModel(602145).resetListener();
        this.airDistributionZone1 = null;
        this.getChoiceModel(602139).resetListener();
        this.getChoiceModel(602404).resetListener();
        this.getChoiceModel(602144).resetListener();
        this.getChoiceModel(602134).resetListener();
        this.airDistributionZone2 = null;
        this.getRangeModel(601991).resetListener();
        this.footwellTempRangeModelSyncZone1.clear();
        this.getChoiceModel(602418).resetListener();
        this.getRangeModel(601990).resetListener();
        this.footwellTempRangeModelSyncZone2.clear();
        this.getChoiceModel(602210).resetListener();
        this.getChoiceModel(602124).resetListener();
        this.getChoiceModel(601966).resetListener();
        this.getChoiceModel(601967).resetListener();
        this.getRangeModel(602186).resetListener();
        this.getRangeModel(602403).resetListener();
        this.temperatureZone3 = null;
        this.getRangeModel(602197).resetListener();
        this.getRangeModel(602413).resetListener();
        this.temperatureZone4 = null;
        this.getRangeModel(602416).resetListener();
        this.getChoiceModel(602159).resetListener();
        this.airVolumeZone3 = null;
        this.getRangeModel(602407).resetListener();
        this.getChoiceModel(602160).resetListener();
        this.airVolumeZone4 = null;
        this.getChoiceModel(602132).resetListener();
        this.getChoiceModel(602374).resetListener();
        this.getChoiceModel(602417).resetListener();
        this.getChoiceModel(602140).resetListener();
        this.airDistributionZone3 = null;
        this.getChoiceModel(602138).resetListener();
        this.getChoiceModel(602384).resetListener();
        this.getChoiceModel(602401).resetListener();
        this.getChoiceModel(602141).resetListener();
        this.airDistributionZone4 = null;
        this.getRangeModel(601988).resetListener();
        this.footwellTempRangeModelSyncZone3.clear();
        this.getChoiceModel(602209).resetListener();
        this.getRangeModel(601989).resetListener();
        this.footwellTempRangeModelSyncZone4.clear();
        this.getChoiceModel(602207).resetListener();
        this.getChoiceModel(602130).resetListener();
    }

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeReceived(0, 92);
            this.primaryAttributeReceived(1, 92);
            this.primaryAttributeReceived(2, 92);
            this.initAirconCirculationSensitivity(this.currentViewOptionsMaster);
        }
    }

    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
            this.primaryAttributeReceived(0, 93);
        }
    }

    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsRow2] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow2 = airconRowViewOptions;
            this.updateMenuEntryVisibility(2, this.currentViewOptionsRow2);
            this.primaryAttributeReceived(1, 94);
        }
    }

    public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconComponent#updateAirconViewOptionsRow3] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow3 = airconRowViewOptions;
            this.updateMenuEntryVisibility(3, this.currentViewOptionsRow3);
            this.primaryAttributeReceived(2, 95);
        }
    }

    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSystemOnOffRow1] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(602408).setValue(n2);
            this.notifySystemOnOff(1, bl);
        }
    }

    public void updateAirconSystemOnOffRow2(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSystemOnOffRow2] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(602124).setValue(n2);
            this.notifySystemOnOff(2, bl);
        }
    }

    public void updateAirconSystemOnOffRow3(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSystemOnOffRow3] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(602130).setValue(n2);
            this.notifySystemOnOff(3, bl);
        }
    }

    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirCirculationAuto] airCirulationAuto='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(602365).setValue(bl ? 1 : 0);
            if (!bl && this.isAirCirculationAutoAvailable()) {
                this.getRangeModel(600630).setValue(this.getConfig().getAirCirculationSensitivityRangeMinWithOff());
            }
        }
    }

    public void updateAirconAirCirculationSensitivity(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirCirculationSensitivity] sensitivity='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.airCirculationSensitivityModelSync.notifyUpdateReceived(5, n);
            try {
                n3 = this.convertCirculationSensitivityDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconAirCirculationSensitivity] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(600631).setValue(n3);
        }
    }

    public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
        this.getLogChannel().log(1000000, "[AirConditionComponentPorsche#updateAirconAirCirculationMiddleExhaustion] middleExhaustion='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            int n3;
            try {
                n3 = this.convertMiddleExhaustionDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconAirCirculationMiddleExhaustion] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(601247).setValue(n3);
        }
    }

    public void updateAirconIndirectVentilation(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconIndirectVentilation] indirectVentilation='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            boolean bl2 = this.invertHMIIndirectVentilation ? !bl : bl;
            this.getChoiceModel(602397).setValue(bl2 ? 1 : 0);
        }
    }

    public void updateAirconHeater(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconHeater] heater='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(600629).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconSolar(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSolar] solar='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(600660).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconAC(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAC] ac='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(602126).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconEcoAC(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconEcoAC] ecoAc='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(602390).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconMaxAC(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconMaxAC] maxAc='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(602127).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSteeringWheelHeater] steeringWheelHeater='%1', valid='%2'", (Object)(null == airconSteeringWheelHeater ? "null" : airconSteeringWheelHeater.toString()), (long)n);
        if (1 == n) {
            this.currentSteeringWheelHeater = airconSteeringWheelHeater;
            this.getChoiceModel(602129).setValue(airconSteeringWheelHeater.isHeating() ? 1 : 0);
        }
    }

    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconFrontWindowHeaterAuto] frontWindowHeaterAuto='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(600644).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSynchronisation] synchronisation='%1', valid='%2'", (Object)(null == airconSynchronisation ? "null" : airconSynchronisation.toString()), (long)n);
        if (1 == n) {
            if (null != this.currentViewOptionsMaster) {
                boolean bl;
                AirconMasterConfiguration airconMasterConfiguration = this.currentViewOptionsMaster.getConfiguration();
                boolean bl2 = bl = 0 < airconMasterConfiguration.getNumberOfZones();
                boolean bl3 = airconMasterConfiguration.isZl1r() ? bl && airconSynchronisation.isSlaveZL1R() : (bl = bl);
                boolean bl4 = airconMasterConfiguration.isZr1r() ? bl && airconSynchronisation.isSlaveZR1R() : (bl = bl);
                boolean bl5 = airconMasterConfiguration.isZl2r() ? bl && airconSynchronisation.isSlaveZL2R() : (bl = bl);
                boolean bl6 = airconMasterConfiguration.isZr2r() ? bl && airconSynchronisation.isSlaveZR2R() : (bl = bl);
                boolean bl7 = airconMasterConfiguration.isZl3r() ? bl && airconSynchronisation.isSlaveZL3R() : (bl = bl);
                bl = airconMasterConfiguration.isZr3r() ? bl && airconSynchronisation.isSlaveZR3R() : bl;
                this.getChoiceModel(602366).setValue(bl ? 1 : 0);
                this.onAirconSyncChanged(bl);
            } else {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconSynchronisation]: Couldn't get configuration. Update ignored.");
            }
        }
    }

    public void updateAirconRearControlFondPlus(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconRearControlFondPlus] fondPlus='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(602125).setValue(bl ? 1 : 0);
        }
    }

    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconSynchronisation] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone1.updateTemperature(airconTemp);
        }
    }

    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconTempZone2] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone2.updateTemperature(airconTemp);
        }
    }

    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconTempZone3] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone3.updateTemperature(airconTemp);
        }
    }

    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconTempZone4] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone4.updateTemperature(airconTemp);
        }
    }

    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirVolumeZone1] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone1.updateAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirVolumeZone2] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone2.updateAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirVolumeZone3] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone3.updateAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirVolumeZone4] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone4.updateAirVolume(airconAirVolume);
        }
    }

    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirDistributionZone1] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone1.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirDistributionZone2] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone2.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirDistributionZone3] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone3.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconAirDistributionZone4] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone4.updateAirDistribution(airconAirDistribution);
        }
    }

    public void updateAirconFootwellTempZone1(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconFootwellTempZone1] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone1.notifyUpdateReceived(27, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconFootwellTempZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602418).setValue(n3);
        }
    }

    public void updateAirconFootwellTempZone2(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconFootwellTempZone2] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone2.notifyUpdateReceived(33, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconFootwellTempZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602210).setValue(n3);
        }
    }

    public void updateAirconFootwellTempZone3(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconFootwellTempZone3] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone3.notifyUpdateReceived(39, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconFootwellTempZone3] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602209).setValue(n3);
        }
    }

    public void updateAirconFootwellTempZone4(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconFootwellTempZone4] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone4.notifyUpdateReceived(45, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconFootwellTempZone4] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602207).setValue(n3);
        }
    }

    public void updateAirconClimateStyleZone1(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconClimateStyleZone1] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconClimateStyleZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602367).setValue(n3);
        }
    }

    public void updateAirconClimateStyleZone2(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconClimateStyleZone2] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconClimateStyleZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(601969).setValue(n3);
        }
    }

    public void updateAirconClimateStyleZone3(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconClimateStyleZone3] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconClimateStyleZone3] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(601966).setValue(n3);
        }
    }

    public void updateAirconClimateStyleZone4(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconClimateStyleZone4] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconClimateStyleZone4] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(601967).setValue(n3);
        }
    }

    public void updateAirconIonisatorZone1(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconIonisatorZone1] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2 && this.isUpdateIonizer(1)) {
            int n3;
            try {
                n3 = this.convertIonizerStateDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconIonisatorZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602409).setValue(n3);
        }
    }

    public void updateAirconIonisatorZone2(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconIonisatorZone2] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2 && this.isUpdateIonizer(2)) {
            int n3;
            try {
                n3 = this.convertIonizerStateDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "[AbstractAirconComponent#updateAirconIonisatorZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(602409).setValue(n3);
        }
    }

    public void updateAirconIonisatorZone3(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconIonisatorZone3] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            super.updateAirconIonisatorZone3(n, n2);
        }
    }

    public void updateAirconIonisatorZone4(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[AbstractAirconComponent#updateAirconIonisatorZone4] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            super.updateAirconIonisatorZone3(n, n2);
        }
    }

    private void setRangeModelValue(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        RangeModelApp rangeModelApp;
        if (this.getLogChannel().isInfo()) {
            this.logModelData("[AbstractAirconComponent#setRangeModelValue]", iRangeModelSyncParameterAccess.getRangeModelID(), iRangeModelSyncParameterAccess.getCurrentValue(), true);
        }
        if (null != (rangeModelApp = this.getRangeModel(iRangeModelSyncParameterAccess.getRangeModelID()))) {
            rangeModelApp.setValue(iRangeModelSyncParameterAccess.getCurrentValue());
        } else {
            this.getLogChannel().log(100000, "[AbstractAirconComponent#setRangeModelValue] Model with ID='%1' not available. Update ignored.", (long)iRangeModelSyncParameterAccess.getRangeModelID());
        }
    }

    private int convertFootwellTemperatureDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.footwellTemperatureConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertFootwellTemperatureHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.footwellTemperatureConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertClimateStyleDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.climateStyleConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertClimateStyleHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.climateStyleConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertIonizerStateDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.ionizerConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertIonizerStateHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.ionizerConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertCirculationSensitivityDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.airCirculationSensitivityConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertCirculationSensitivityHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.airCirculationSensitivityConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertMiddleExhaustionDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.middleExhaustionConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertMiddleExhaustionHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.middleExhaustionConverterStrategy.getDSIValue(new Integer(n));
    }

    protected int convertRowDSI2HMI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.convertRowDSI2HMI] Row('%1') not supported.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    protected int convertRowHMI2DSI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.convertRowHMI2DSI] Row('%1') not supported.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    protected int convertZoneDSI2HMI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            case 8: {
                n2 = 4;
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.convertZoneDSI2HMI] Zone('%1') not supported.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    protected int convertZoneHMI2DSI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirconComponent.convertZoneHMI2DSI] Zone('%1') not supported.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
    }

    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    public class AirVolumeHandler {
        private final String name;
        private final int hmiZone;
        private final int airVolumeAttributeID;
        private final RangeModelApp airVolumeModelValue;
        private final ChoiceModelApp airVolumeModelAuto;
        private boolean sendDefault = false;
        private AirconAirVolume currentAirVolume;
        private final RangeModelSynchronizer airVolumeRangeModelSync;

        public AirVolumeHandler(String string, int n, int n2, int n3, int n4) {
            this.name = string;
            this.hmiZone = n;
            this.airVolumeAttributeID = n2;
            this.airVolumeModelValue = AbstractAirconComponent.this.getRangeModel(n3);
            this.airVolumeModelAuto = AbstractAirconComponent.this.getChoiceModel(n4);
            this.airVolumeRangeModelSync = new RangeModelSynchronizer(string, AbstractAirconComponent.this.rangeModelSyncListener, 1000L, AbstractAirconComponent.this.getLogChannel());
            this.airVolumeRangeModelSync.addWatchedAttribute(n2, true, this.airVolumeModelValue);
        }

        private void callDSISetAirconAirVolume(AirconAirVolume airconAirVolume) {
            int n = AbstractAirconComponent.this.convertZoneHMI2DSI(this.hmiZone);
            if (-1 != n) {
                AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.callDSISetAirconAirVolume(%1, %2)", (Object)Integer.toString(n), (Object)airconAirVolume.toString());
                AbstractAirconComponent.this.getDSI().setAirconAirVolume(n, airconAirVolume);
            }
        }

        private AirconAirVolume copy(AirconAirVolume airconAirVolume) {
            return null == airconAirVolume ? new AirconAirVolume() : new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        }

        public void incrementVolume(int n) {
            this.airVolumeRangeModelSync.notifyIncrement(this.airVolumeAttributeID, n);
        }

        public void decrementVolume(int n) {
            this.airVolumeRangeModelSync.notifyDecrement(this.airVolumeAttributeID, n);
        }

        public void dsiSetVolume(int n) {
            if (null == this.currentAirVolume) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirVolumeHandler(%1)#dsiSetVolume] No AirVolume-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirVolume airconAirVolume = this.copy(this.currentAirVolume);
            airconAirVolume.airVolume = n;
            this.callDSISetAirconAirVolume(airconAirVolume);
        }

        public void dsiSetVolumeAuto(int n) {
            if (null == this.currentAirVolume) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirVolumeHandler(%1)#dsiSetVolumeAuto] No AirVolume-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirVolume airconAirVolume = this.copy(this.currentAirVolume);
            airconAirVolume.airVolumeAuto = n;
            this.callDSISetAirconAirVolume(airconAirVolume);
        }

        public void updateAirVolume(AirconAirVolume airconAirVolume) {
            if (null != airconAirVolume) {
                this.currentAirVolume = airconAirVolume;
                int n = airconAirVolume.getAirVolume();
                int n2 = airconAirVolume.getAirVolumeAuto();
                if (null != this.airVolumeRangeModelSync) {
                    this.airVolumeRangeModelSync.notifyUpdateReceived(this.airVolumeAttributeID, n);
                }
                if (null != this.airVolumeModelAuto) {
                    this.airVolumeModelAuto.setValue(n2);
                }
                AbstractAirconComponent.this.notifyAutoModeStateChanged(this.hmiZone, 1);
            }
        }
    }

    private class TemperatureModel {
        private static final int LABEL_TEMP_VALUE = 0;
        private static final int LABEL_LO_SYMBOL = 1;
        private static final int LABEL_HI_SYMBOL = 2;
        private final float tempStartCelsius;
        private final float tempEndCelsius;
        private final float tempStepCelsius;
        private final float tempStartFahrenheit;
        private final float tempEndFahrenheit;
        private final float tempStepFahrenheit;
        private RangeModelApp celsiusRange = null;
        private RangeModelApp fahrenheitRange = null;
        private ChoiceModelApp labelChoice = null;
        private MetricsModelApp tempMetric = null;
        private int currentTemperature = 0;

        public TemperatureModel(RangeModelApp rangeModelApp, RangeModelApp rangeModelApp2, ChoiceModelApp choiceModelApp, MetricsModelApp metricsModelApp, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.celsiusRange = rangeModelApp;
            this.fahrenheitRange = rangeModelApp2;
            this.labelChoice = choiceModelApp;
            this.tempMetric = metricsModelApp;
            this.tempStartCelsius = f2;
            this.tempEndCelsius = f3;
            this.tempStepCelsius = f4;
            this.tempStartFahrenheit = f5;
            this.tempEndFahrenheit = f6;
            this.tempStepFahrenheit = f7;
        }

        private float dsiToCelsius(int n) {
            float f2 = (n - this.celsiusRange.getMinimum()) / this.celsiusRange.getStep();
            float f3 = this.tempStartCelsius + f2 * this.tempStepCelsius;
            return AbstractCarComponent.clip(f3, this.tempStartCelsius, this.tempEndCelsius);
        }

        private float dsiToFahrenheit(int n) {
            float f2 = (n - this.fahrenheitRange.getMinimum()) / this.fahrenheitRange.getStep();
            float f3 = this.tempStartFahrenheit + f2 * this.tempStepFahrenheit;
            return AbstractCarComponent.clip(f3, this.tempStartFahrenheit, this.tempEndFahrenheit);
        }

        private void updateTemperatureModels(float f2, float f3, float f4, int n) {
            float f5 = AbstractCarComponent.clip(f2, f3, f4);
            int n2 = f5 == f3 ? 1 : (f5 == f4 ? 2 : 0);
            Temperature temperature = new Temperature(f2, n);
            this.labelChoice.setValue(n2);
            this.tempMetric.setMetric(temperature);
        }

        public int getCurrentTemperature() {
            return this.currentTemperature;
        }

        public void updateHMI(AirconTemp airconTemp) {
            switch (airconTemp.getTempUnit()) {
                case 0: {
                    this.currentTemperature = AbstractCarComponent.clip(airconTemp.getTempValue(), this.celsiusRange.getMinimum(), this.celsiusRange.getMaximum());
                    this.celsiusRange.setValue(this.currentTemperature);
                    this.updateTemperatureModels(this.dsiToCelsius(this.currentTemperature), this.tempStartCelsius, this.tempEndCelsius, 1);
                    break;
                }
                case 1: {
                    this.currentTemperature = AbstractCarComponent.clip(airconTemp.getTempValue(), this.fahrenheitRange.getMinimum(), this.fahrenheitRange.getMaximum());
                    this.fahrenheitRange.setValue(this.currentTemperature);
                    this.updateTemperatureModels(this.dsiToFahrenheit(this.currentTemperature), this.tempStartFahrenheit, this.tempEndFahrenheit, 2);
                    break;
                }
            }
        }
    }

    public class TemperatureHandler {
        private final String name;
        private final int hmiZone;
        private final TemperatureModel temperatureModel;

        public TemperatureHandler(String string, int n, int n2, int n3, int n4, int n5) {
            this.name = string;
            this.hmiZone = n;
            this.temperatureModel = new TemperatureModel(AbstractAirconComponent.this.getRangeModel(n2), AbstractAirconComponent.this.getRangeModel(n3), AbstractAirconComponent.this.getChoiceModel(n4), AbstractAirconComponent.this.getMetricsModel(n5), AbstractAirconComponent.this.getConfig().getTemperatureStartCelsius(), AbstractAirconComponent.this.getConfig().getTemperatureEndCelsius(), AbstractAirconComponent.this.getConfig().getTemperatureStepCelsius(), AbstractAirconComponent.this.getConfig().getTemperatureStartFahrenheit(), AbstractAirconComponent.this.getConfig().getTemperatureEndFahrenheit(), AbstractAirconComponent.this.getConfig().getTemperatureStepFahrenheit());
        }

        private void callDSISetAirconTempZone(AirconTemp airconTemp) {
            int n = AbstractAirconComponent.this.convertZoneHMI2DSI(this.hmiZone);
            if (-1 != n) {
                AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconTempZone(%1, %2)", (Object)Integer.toString(n), (Object)airconTemp.toString());
                AbstractAirconComponent.this.getDSI().setAirconTempZone(n, airconTemp);
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
                AbstractAirconComponent.this.getLogChannel().log(100000, "[TemperatureHandler(%1)#incrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'", (Object)this.name, (long)n3, (long)n4);
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
                AbstractAirconComponent.this.getLogChannel().log(100000, "[TemperatureHandler(%1)#decrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'", (Object)this.name, (long)n3, (long)n4);
            }
        }

        public void updateTemperature(AirconTemp airconTemp) {
            this.temperatureModel.updateHMI(airconTemp);
        }
    }

    public class AirDistributionHandler {
        private static final int DSI_DISTRIBUTION_ON = 12;
        private static final int DSI_DISTRIBUTION_OFF = 0;
        private final String name;
        private final int hmiZone;
        private final ChoiceModelApp airDistributionModelUp;
        private final ChoiceModelApp airDistributionModelIDMiddle;
        private final ChoiceModelApp airDistributionModelIDDown;
        private final ChoiceModelApp airDistributionModelIDAuto;
        private boolean sendDefault = false;
        private AirconAirDistribution currentAirDistribution;

        public AirDistributionHandler(String string, int n, int n2, int n3, int n4, int n5) {
            this.name = string;
            this.hmiZone = n;
            this.airDistributionModelUp = AbstractAirconComponent.this.getChoiceModel(n2);
            this.airDistributionModelIDMiddle = AbstractAirconComponent.this.getChoiceModel(n3);
            this.airDistributionModelIDDown = AbstractAirconComponent.this.getChoiceModel(n4);
            this.airDistributionModelIDAuto = AbstractAirconComponent.this.getChoiceModel(n5);
        }

        private void callDSISetAirconAirDistribution(AirconAirDistribution airconAirDistribution) {
            int n = AbstractAirconComponent.this.convertZoneHMI2DSI(this.hmiZone);
            if (-1 != n) {
                AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconAirDistribution(%1, %2)", (Object)Integer.toString(n), (Object)airconAirDistribution.toString());
                AbstractAirconComponent.this.getDSI().setAirconAirDistribution(n, airconAirDistribution);
            }
        }

        private AirconAirDistribution copy(AirconAirDistribution airconAirDistribution) {
            return null == airconAirDistribution ? new AirconAirDistribution() : new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, airconAirDistribution.side);
        }

        public void dsiSetUp(int n) {
            if (null == this.currentAirDistribution) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirDistributionHandler(%1)#setUp] No AirDistribution-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
            airconAirDistribution.up = n;
            this.callDSISetAirconAirDistribution(airconAirDistribution);
        }

        public void dsiSetBody(int n) {
            if (null == this.currentAirDistribution) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirDistributionHandler(%1)#setBody] No AirDistribution-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
            airconAirDistribution.body = n;
            this.callDSISetAirconAirDistribution(airconAirDistribution);
        }

        public void dsiSetFootwell(int n) {
            if (null == this.currentAirDistribution) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirDistributionHandler(%1)#setFootwell] No AirDistribution-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
            airconAirDistribution.footwell = n;
            this.callDSISetAirconAirDistribution(airconAirDistribution);
        }

        public void dsiSetAutomode(boolean bl) {
            if (null == this.currentAirDistribution) {
                AbstractAirconComponent.this.getLogChannel().log(100000, "[AirDistributionHandler(%1)#setAutomode] No AirDistribution-Information received yet.", (Object)this.name);
                if (!this.sendDefault) {
                    return;
                }
            }
            AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
            airconAirDistribution.automode = bl;
            this.callDSISetAirconAirDistribution(airconAirDistribution);
        }

        public void updateAirDistribution(AirconAirDistribution airconAirDistribution) {
            if (null != airconAirDistribution) {
                int n;
                this.currentAirDistribution = airconAirDistribution;
                int n2 = 12 == airconAirDistribution.getUp() ? 1 : 0;
                int n3 = 12 == airconAirDistribution.getBody() ? 1 : 0;
                int n4 = 12 == airconAirDistribution.getFootwell() ? 1 : 0;
                int n5 = n = airconAirDistribution.isAutomode() ? 1 : 0;
                if (null != this.airDistributionModelUp) {
                    this.airDistributionModelUp.setValue(n2);
                }
                if (null != this.airDistributionModelIDMiddle) {
                    this.airDistributionModelIDMiddle.setValue(n3);
                }
                if (null != this.airDistributionModelIDDown) {
                    this.airDistributionModelIDDown.setValue(n4);
                }
                if (null != this.airDistributionModelIDAuto) {
                    this.airDistributionModelIDAuto.setValue(n);
                }
                AbstractAirconComponent.this.notifyAutoModeStateChanged(this.hmiZone, 0);
            }
        }
    }

    private class RangeModelSyncListener
    implements IRangeModelSyncListener {
        private RangeModelSyncListener() {
        }

        public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            AbstractAirconComponent.this.getLogChannel().log(1000000, "[AbstractAirconComponent.RangeModelSyncListener#setDSIParameter] called with attribute ID: %1", (long)iRangeModelSyncParameterAccess.getRangeModelID());
            switch (iRangeModelSyncParameterAccess.getAttributeID()) {
                case 25: {
                    AbstractAirconComponent.this.airVolumeZone1.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 31: {
                    AbstractAirconComponent.this.airVolumeZone2.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 37: {
                    AbstractAirconComponent.this.airVolumeZone3.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 43: {
                    AbstractAirconComponent.this.airVolumeZone4.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 27: {
                    AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconFootwellTemp(%1, %2)", 1L, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                    AbstractAirconComponent.this.getDSI().setAirconFootwellTemp(1, iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 33: {
                    AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconFootwellTemp(%1, %2)", 2L, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                    AbstractAirconComponent.this.getDSI().setAirconFootwellTemp(2, iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 39: {
                    AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconFootwellTemp(%1, %2)", 4L, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                    AbstractAirconComponent.this.getDSI().setAirconFootwellTemp(4, iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 45: {
                    AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconFootwellTemp(%1, %2)", 8L, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                    AbstractAirconComponent.this.getDSI().setAirconFootwellTemp(8, iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                case 5: {
                    AbstractAirconComponent.this.getLogChannel(1).log(1000000, "---> DSI.setAirconAirCirculationSensitivity(%1)", (long)iRangeModelSyncParameterAccess.getCurrentValue());
                    AbstractAirconComponent.this.getDSI().setAirconAirCirculationSensitivity(iRangeModelSyncParameterAccess.getCurrentValue());
                    break;
                }
                default: {
                    AbstractAirconComponent.this.getLogChannel().log(100000, "[AbstractAirconComponent.RangeModelSyncListener#setDSIParameter] Unexpected attribute ID: %1", (long)iRangeModelSyncParameterAccess.getRangeModelID());
                }
            }
        }

        public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            AbstractAirconComponent.this.setRangeModelValue(iRangeModelSyncParameterAccess);
        }

        public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
            AbstractAirconComponent.this.setRangeModelValue(iRangeModelSyncParameterAccess);
        }
    }

    private class DefaultIonizerConverterStrategy
    implements IValueConverterStrategy {
        private static final int IONIZER_OFF = 0;
        private static final int IONIZER_ON = 1;
        private static final int IONIZER_AUTO = 2;

        private DefaultIonizerConverterStrategy() {
        }

        public Object getDSIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }

        public Object getHMIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }
    }

    private class DefaultClimateStyleConverterStrategy
    implements IValueConverterStrategy {
        private static final int CLIMATE_STYLE_WEAK = 0;
        private static final int CLIMATE_STYLE_MEDIUM = 1;
        private static final int CLIMATE_STYLE_STRONG = 2;

        private DefaultClimateStyleConverterStrategy() {
        }

        public Object getDSIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }

        public Object getHMIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }
    }

    private class DefaultMiddleExhaustionConverterStrategy
    implements IValueConverterStrategy {
        private static final int DSI_VALUE_OFF = 0;
        private static final int DSI_VALUE_ON = -1;
        private static final int HMI_VALUE_OFF = 0;
        private static final int HMI_VALUE_ON = 1;

        private DefaultMiddleExhaustionConverterStrategy() {
        }

        public Object getDSIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = -1;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }

        public Object getHMIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = 0;
                    break;
                }
                case -1: {
                    n = 1;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }
    }

    private class DefaultFootwellTemperatureConverterStrategy
    implements IValueConverterStrategy {
        private static final int FOOTWELL_TEMP_COLDER = 0;
        private static final int FOOTWELL_TEMP_NORMAL = 1;
        private static final int FOOTWELL_TEMP_WARMER = 2;

        private DefaultFootwellTemperatureConverterStrategy() {
        }

        public Object getDSIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case 0: {
                    n = -2;
                    break;
                }
                case 1: {
                    n = 0;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }

        public Object getHMIValue(Object object) throws ValueConverterStrategyException {
            int n;
            switch ((Integer)object) {
                case -2: {
                    n = 0;
                    break;
                }
                case 0: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    throw new ValueConverterStrategyException(1);
                }
            }
            return new Integer(n);
        }
    }
}

