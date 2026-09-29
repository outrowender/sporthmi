/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultValueConverterStrategy;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$1;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$2;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$AirDistributionHandler;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$AirVolumeHandler;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$DefaultClimateStyleConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$DefaultFootwellTemperatureConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$DefaultIonizerConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$DefaultMiddleExhaustionConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$RangeModelSyncListener;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$TemperatureHandler;
import de.audi.app.car.core.aircondition.AirconConfig;
import de.audi.app.car.core.aircondition.IAirconConstants;
import de.audi.app.car.core.app.IRangeModelSyncParameterAccess;
import de.audi.app.car.core.app.RangeModelSynchronizer;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
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
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    public static final long RANGE_MODEL_SYNCHRONIZER_TIMEOUT;
    protected static final int ATTR_AIR_DISTRIBUTION;
    protected static final int ATTR_AIR_VOLUME;
    private final AbstractAirconComponent$RangeModelSyncListener rangeModelSyncListener;
    protected volatile AirconMasterViewOptions currentViewOptionsMaster;
    protected volatile AirconRowViewOptions currentViewOptionsRow1;
    protected volatile AirconRowViewOptions currentViewOptionsRow2;
    protected volatile AirconRowViewOptions currentViewOptionsRow3;
    private AirconSteeringWheelHeater currentSteeringWheelHeater;
    protected AbstractAirconComponent$TemperatureHandler temperatureZone1;
    protected AbstractAirconComponent$TemperatureHandler temperatureZone2;
    protected AbstractAirconComponent$TemperatureHandler temperatureZone3;
    protected AbstractAirconComponent$TemperatureHandler temperatureZone4;
    protected AbstractAirconComponent$AirVolumeHandler airVolumeZone1;
    protected AbstractAirconComponent$AirVolumeHandler airVolumeZone2;
    protected AbstractAirconComponent$AirVolumeHandler airVolumeZone3;
    protected AbstractAirconComponent$AirVolumeHandler airVolumeZone4;
    protected AbstractAirconComponent$AirDistributionHandler airDistributionZone1;
    protected AbstractAirconComponent$AirDistributionHandler airDistributionZone2;
    protected AbstractAirconComponent$AirDistributionHandler airDistributionZone3;
    protected AbstractAirconComponent$AirDistributionHandler airDistributionZone4;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone1;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone2;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone3;
    private final RangeModelSynchronizer footwellTempRangeModelSyncZone4;
    private final RangeModelSynchronizer airCirculationSensitivityModelSync;
    protected IValueConverterStrategy footwellTemperatureConverterStrategy = new AbstractAirconComponent$DefaultFootwellTemperatureConverterStrategy(this, null);
    protected IValueConverterStrategy climateStyleConverterStrategy = new AbstractAirconComponent$DefaultClimateStyleConverterStrategy(this, null);
    protected IValueConverterStrategy ionizerConverterStrategy = new AbstractAirconComponent$DefaultIonizerConverterStrategy(this, null);
    protected IValueConverterStrategy airCirculationSensitivityConverterStrategy = new DefaultValueConverterStrategy();
    protected IValueConverterStrategy middleExhaustionConverterStrategy = new AbstractAirconComponent$DefaultMiddleExhaustionConverterStrategy(this, null);
    protected boolean invertHMISystemOnOffState = false;
    protected boolean invertHMIIndirectVentilation = false;
    private final DefaultChoiceListener choiceListener = new AbstractAirconComponent$1(this);
    private final DefaultRangeListener rangeListener = new AbstractAirconComponent$2(this);

    public AbstractAirconComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AirCondition");
        this.setLogChannelDSI(true);
        this.rangeModelSyncListener = new AbstractAirconComponent$RangeModelSyncListener(this, null);
        this.footwellTempRangeModelSyncZone1 = new RangeModelSynchronizer("FootwellZone1", this.rangeModelSyncListener, 0, this.getLogChannel());
        this.footwellTempRangeModelSyncZone2 = new RangeModelSynchronizer("FootwellZone2", this.rangeModelSyncListener, 0, this.getLogChannel());
        this.footwellTempRangeModelSyncZone3 = new RangeModelSynchronizer("FootwellZone3", this.rangeModelSyncListener, 0, this.getLogChannel());
        this.footwellTempRangeModelSyncZone4 = new RangeModelSynchronizer("FootwellZone4", this.rangeModelSyncListener, 0, this.getLogChannel());
        this.airCirculationSensitivityModelSync = new RangeModelSynchronizer("AirCirculationSensitivity", this.rangeModelSyncListener, 0, this.getLogChannel());
    }

    private void initAirconCirculationSensitivity(AirconMasterViewOptions airconMasterViewOptions) {
        this.getRangeModel(908724480).setLimits(this.isAirCirculationAutoAvailable() ? this.getConfig().getAirCirculationSensitivityRangeMinWithOff() : this.getConfig().getAirCirculationSensitivityRangeMin(), this.getConfig().getAirCirculationSensitivityRangeMax(), this.getConfig().getAirCirculationSensitivityRangeStep());
        this.getRangeModel(908724480).setRangeListener(this.rangeListener);
        this.airCirculationSensitivityModelSync.addWatchedAttribute(5, true, this.getRangeModel(908724480));
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
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconSystemOnOffRow(%1, %2)", (Object)Integer.toString(n2), (Object)(bl ? "true" : "false"));
            this.getDSI().setAirconSystemOnOffRow(n2, bl);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setSystemOnOff] Unsupported zone. DSI-Call not send.");
        }
    }

    private void setStateAC(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconAC(%1)", bl);
        this.getDSI().setAirconAC(bl);
    }

    private void setStateEcoAC(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconEcoAC(%1)", bl);
        this.getDSI().setAirconEcoAC(bl);
    }

    private void setStateMaxAC(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconMaxAC(%1)", bl);
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
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconSynchronisation(%1)", (Object)airconSynchronisation);
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
            this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#setAirCirculationSensitivity] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            return;
        }
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconAirCirculationSensitivity(%1)", (long)n2);
        this.getDSI().setAirconAirCirculationSensitivity(n2);
    }

    private void setMiddleExhaustion(int n) {
        int n2;
        try {
            n2 = this.convertMiddleExhaustionHMI2DSI(n);
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#setMiddleExhaustion] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            return;
        }
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconMiddleExhaustion(%1)", (long)n2);
        this.getDSI().setAirconMiddleExhaustion(n2);
    }

    private void setAirCirculationAuto(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconAirCirculationAuto(%1)", bl);
        this.getDSI().setAirconAirCirculationAuto(bl);
    }

    private void setIndirectVentilation(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconIndirectVentilation(%1)", bl);
        this.getDSI().setAirconIndirectVentilation(bl);
    }

    private void setHeater(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconHeater(%1)", bl);
        this.getDSI().setAirconHeater(bl);
    }

    private void setFrontWindowHeaterAuto(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconFrontWindowHeaterAuto(%1)", bl);
        this.getDSI().setAirconFrontWindowHeaterAuto(bl);
    }

    private void setSteeringWheelHeating(boolean bl) {
        if (null != this.currentSteeringWheelHeater) {
            AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(bl, this.currentSteeringWheelHeater.currentState, this.currentSteeringWheelHeater.autoHeating, this.currentSteeringWheelHeater.adjustViaSeatHeating, this.currentSteeringWheelHeater.heatingStep);
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconSteeringWheelHeater(%1)", (Object)airconSteeringWheelHeater.toString());
            this.getDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
        } else {
            this.getLogChannel().log(10000, "[AbstractAirconComponent#setSteeringWheelHeating] No AirconSteeringWheelHeater-Information received yet. DSI-Call not send.");
        }
    }

    private void setSolar(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconSolar(%1)", bl);
        this.getDSI().setAirconSolar(bl);
    }

    private void setRearControlFondPlus(boolean bl) {
        this.getLogChannel(1).log(1078071040, "---> DSI.setAirconRearControlFondPlus(%1)", bl);
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
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#setFootwellTemperature] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconFootwellTemp(%1, %2)", (long)n3, (long)n4);
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
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconClimateStyle(%1, %2)", (long)n3, (long)n4);
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
            this.getLogChannel(1).log(1078071040, "---> DSI.setAirconIonisator(%1, %2)", (long)n3, (long)n4);
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
                bl = n2 == this.getChoiceModel(674302208).getValue();
                break;
            }
            case 2: {
                bl = n2 == this.getChoiceModel(204474624).getValue();
                break;
            }
            case 3: {
                bl = n2 == this.getChoiceModel(305137920).getValue();
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.isSystemOnOff] Row('%1') not supported.", (long)n);
                bl = false;
            }
        }
        return bl;
    }

    protected boolean isAirVolumeAutoMode(int n) {
        boolean bl;
        switch (n) {
            case 1: {
                bl = null == AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone1) ? false : AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone1).getAirVolumeAuto() != 0;
                break;
            }
            case 2: {
                bl = null == AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone2) ? false : AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone2).getAirVolumeAuto() != 0;
                break;
            }
            case 3: {
                bl = null == AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone3) ? false : AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone3).getAirVolumeAuto() != 0;
                break;
            }
            case 4: {
                bl = null == AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone4) ? false : AbstractAirconComponent$AirVolumeHandler.access$4100(this.airVolumeZone4).getAirVolumeAuto() != 0;
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.isAirVolumeAutoMode] Zone('%1') not supported.", (long)n);
                return false;
            }
        }
        return bl;
    }

    protected boolean isAirDistributionAutoMode(int n) {
        boolean bl;
        switch (n) {
            case 1: {
                bl = null == AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone1) ? false : AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone1).isAutomode();
                break;
            }
            case 2: {
                bl = null == AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone2) ? false : AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone2).isAutomode();
                break;
            }
            case 3: {
                bl = null == AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone3) ? false : AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone3).isAutomode();
                break;
            }
            case 4: {
                bl = null == AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone4) ? false : AbstractAirconComponent$AirDistributionHandler.access$4200(this.airDistributionZone4).isAutomode();
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.isAirDistributionAutoMode] Zone('%1') not supported.", (long)n);
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

    protected abstract AirconConfig getConfig() {
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
    }

    protected abstract void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
    }

    protected abstract boolean isUpdateIonizer(int n) {
    }

    protected abstract void notifySystemOnOff(int n, boolean bl) {
    }

    protected abstract void notifyAutoModeStateChanged(int n, int n2) {
    }

    @Override
    public String getName() {
        return "AirCondition Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{152, 15, 83, 82, 21, 5, 6, 4, 8, 10, 19, 17, 14, 91, 24, 30, 25, 31, 26, 32, 27, 33, 110, 112, 140, 141}), new CarDSIAttributesSet(1, new int[]{92, 94}, new int[]{153, 36, 42, 37, 43, 38, 44, 39, 45, 114, 116, 142, 143}), new CarDSIAttributesSet(2, new int[]{92, 95}, new int[0])};
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
        buffer.append("Row 3: ");
        buffer.append(null == this.currentViewOptionsRow3 ? "No row (3) view options received yet" : this.currentViewOptionsRow3.toString());
        return buffer.toString();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(674302208).setChoiceListener(this.choiceListener);
        this.getChoiceModel(238029056).setChoiceListener(this.choiceListener);
        this.getChoiceModel(372312320).setChoiceListener(this.choiceListener);
        this.getChoiceModel(254806272).setChoiceListener(this.choiceListener);
        this.getChoiceModel(-30406400).setChoiceListener(this.choiceListener);
        this.getChoiceModel(925501696).setChoiceListener(this.choiceListener);
        this.getChoiceModel(-47183616).setChoiceListener(this.choiceListener);
        this.getChoiceModel(-1624504064).setChoiceListener(this.choiceListener);
        this.getChoiceModel(489752832).setChoiceListener(this.choiceListener);
        this.getChoiceModel(891947264).setChoiceListener(this.choiceListener);
        this.getChoiceModel(1143605504).setChoiceListener(this.choiceListener);
        this.getChoiceModel(288360704).setChoiceListener(this.choiceListener);
        this.getChoiceModel(1412040960).setChoiceListener(this.choiceListener);
        this.getChoiceModel(221251840).setChoiceListener(this.choiceListener);
        this.getChoiceModel(691079424).setChoiceListener(this.choiceListener);
        this.getChoiceModel(-13629184).setChoiceListener(this.choiceListener);
        this.getChoiceModel(1898907904).setChoiceListener(this.choiceListener);
        this.getRangeModel(1261439232).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(1261439232).setRangeListener(this.rangeListener);
        this.getRangeModel(1345325312).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(1345325312).setRangeListener(this.rangeListener);
        this.temperatureZone1 = new AbstractAirconComponent$TemperatureHandler(this, "Temperature Zone 1", 1, 1261439232, 1345325312, 1412434176, 1311770880);
        this.getRangeModel(1395656960).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(1395656960).setRangeListener(this.rangeListener);
        this.getRangeModel(1378879744).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(1378879744).setRangeListener(this.rangeListener);
        this.temperatureZone2 = new AbstractAirconComponent$TemperatureHandler(this, "Temperature Zone 2", 2, 1395656960, 1378879744, 1278216448, -164624128);
        this.getRangeModel(842008832).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(842008832).setRangeListener(this.rangeListener);
        this.getChoiceModel(774899968).setChoiceListener(this.choiceListener);
        this.airVolumeZone1 = new AbstractAirconComponent$AirVolumeHandler(this, "Volume Zone 1", 1, 25, 842008832, 774899968);
        this.getRangeModel(892340480).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(892340480).setRangeListener(this.rangeListener);
        this.getChoiceModel(825231616).setChoiceListener(this.choiceListener);
        this.airVolumeZone2 = new AbstractAirconComponent$AirVolumeHandler(this, "Volume Zone 2", 2, 31, 892340480, 825231616);
        this.getChoiceModel(540084480).setChoiceListener(this.choiceListener);
        this.getChoiceModel(405801216).setChoiceListener(this.choiceListener);
        this.getChoiceModel(-114292480).setChoiceListener(this.choiceListener);
        this.getChoiceModel(556796160).setChoiceListener(this.choiceListener);
        this.airDistributionZone1 = new AbstractAirconComponent$AirDistributionHandler(this, "Distribution Zone 1", 1, 540084480, 405801216, -114292480, 556796160);
        this.getChoiceModel(456132864).setChoiceListener(this.choiceListener);
        this.getChoiceModel(607193344).setChoiceListener(this.choiceListener);
        this.getChoiceModel(540018944).setChoiceListener(this.choiceListener);
        this.getChoiceModel(372246784).setChoiceListener(this.choiceListener);
        this.airDistributionZone2 = new AbstractAirconComponent$AirDistributionHandler(this, "Distribution Zone 2", 2, 456132864, 607193344, 540018944, 372246784);
        this.getRangeModel(-2026960640).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(-2026960640).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone1.addWatchedAttribute(27, true, this.getRangeModel(-2026960640));
        this.getChoiceModel(842074368).setChoiceListener(this.choiceListener);
        this.getRangeModel(-2043737856).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(-2043737856).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone2.addWatchedAttribute(33, true, this.getRangeModel(-2043737856));
        this.getChoiceModel(1647315200).setChoiceListener(this.choiceListener);
        this.getChoiceModel(204474624).setChoiceListener(this.choiceListener);
        this.getChoiceModel(1848576256).setChoiceListener(this.choiceListener);
        this.getChoiceModel(1865353472).setChoiceListener(this.choiceListener);
        this.getRangeModel(1244662016).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(1244662016).setRangeListener(this.rangeListener);
        this.getRangeModel(590416128).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(590416128).setRangeListener(this.rangeListener);
        this.temperatureZone3 = new AbstractAirconComponent$TemperatureHandler(this, "Temperature Zone 3", 3, 1244662016, 590416128, 1462765824, 1328548096);
        this.getRangeModel(1429211392).setLimits(this.getConfig().getTemperatureRangeMinCelsius(), this.getConfig().getTemperatureRangeMaxCelsius(), this.getConfig().getTemperatureRangeStepCelsius());
        this.getRangeModel(1429211392).setRangeListener(this.rangeListener);
        this.getRangeModel(758188288).setLimits(this.getConfig().getTemperatureRangeMinFahrenheit(), this.getConfig().getTemperatureRangeMaxFahrenheit(), this.getConfig().getTemperatureRangeStepFahrenheit());
        this.getRangeModel(758188288).setRangeListener(this.rangeListener);
        this.temperatureZone4 = new AbstractAirconComponent$TemperatureHandler(this, "Temperature Zone 4", 4, 1429211392, 758188288, 238094592, 1294993664);
        this.getRangeModel(808519936).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(808519936).setRangeListener(this.rangeListener);
        this.getChoiceModel(791677184).setChoiceListener(this.choiceListener);
        this.airVolumeZone3 = new AbstractAirconComponent$AirVolumeHandler(this, "Volume Zone 3", 3, 37, 808519936, 791677184);
        this.getRangeModel(657524992).setLimits(this.getConfig().getAirVolumeRangeMin(), this.getConfig().getAirVolumeRangeMax(), this.getConfig().getAirVolumeRangeStep());
        this.getRangeModel(657524992).setRangeListener(this.rangeListener);
        this.getChoiceModel(0x30300900).setChoiceListener(this.choiceListener);
        this.airVolumeZone4 = new AbstractAirconComponent$AirVolumeHandler(this, "Volume Zone 4", 4, 43, 657524992, 0x30300900);
        this.getChoiceModel(338692352).setChoiceListener(this.choiceListener);
        this.getChoiceModel(103876864).setChoiceListener(this.choiceListener);
        this.getChoiceModel(825297152).setChoiceListener(this.choiceListener);
        this.getChoiceModel(472910080).setChoiceListener(this.choiceListener);
        this.airDistributionZone3 = new AbstractAirconComponent$AirDistributionHandler(this, "Distribution Zone 3", 3, 338692352, 103876864, 825297152, 472910080);
        this.getChoiceModel(439355648).setChoiceListener(this.choiceListener);
        this.getChoiceModel(271649024).setChoiceListener(this.choiceListener);
        this.getChoiceModel(556861696).setChoiceListener(this.choiceListener);
        this.getChoiceModel(489687296).setChoiceListener(this.choiceListener);
        this.airDistributionZone4 = new AbstractAirconComponent$AirDistributionHandler(this, "Distribution Zone 4", 4, 439355648, 271649024, 556861696, 489687296);
        this.getRangeModel(-2077292288).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(-2077292288).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone3.addWatchedAttribute(39, true, this.getRangeModel(-2077292288));
        this.getChoiceModel(1630537984).setChoiceListener(this.choiceListener);
        this.getRangeModel(-2060515072).setLimits(this.getConfig().getFootwellTemperatureRangeMin(), this.getConfig().getFootwellTemperatureRangeMax(), this.getConfig().getFootwellTemperatureRangeStep());
        this.getRangeModel(-2060515072).setRangeListener(this.rangeListener);
        this.footwellTempRangeModelSyncZone4.addWatchedAttribute(45, true, this.getRangeModel(-2060515072));
        this.getChoiceModel(1596983552).setChoiceListener(this.choiceListener);
        this.getChoiceModel(305137920).setChoiceListener(this.choiceListener);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(674302208).resetListener();
        this.getChoiceModel(238029056).resetListener();
        this.getChoiceModel(372312320).resetListener();
        this.getChoiceModel(254806272).resetListener();
        this.getChoiceModel(-30406400).resetListener();
        this.getChoiceModel(925501696).resetListener();
        this.getChoiceModel(-47183616).resetListener();
        this.getChoiceModel(-1624504064).resetListener();
        this.getChoiceModel(489752832).resetListener();
        this.getChoiceModel(891947264).resetListener();
        this.getChoiceModel(1143605504).resetListener();
        this.getChoiceModel(288360704).resetListener();
        this.getChoiceModel(1412040960).resetListener();
        this.getChoiceModel(221251840).resetListener();
        this.getChoiceModel(691079424).resetListener();
        this.getRangeModel(1261439232).resetListener();
        this.getRangeModel(1345325312).resetListener();
        this.temperatureZone1 = null;
        this.getRangeModel(1395656960).resetListener();
        this.getRangeModel(1378879744).resetListener();
        this.temperatureZone2 = null;
        this.getRangeModel(842008832).resetListener();
        this.getChoiceModel(774899968).resetListener();
        this.airVolumeZone1 = null;
        this.getRangeModel(892340480).resetListener();
        this.getChoiceModel(825231616).resetListener();
        this.airVolumeZone2 = null;
        this.getChoiceModel(-13629184).resetListener();
        this.getChoiceModel(1898907904).resetListener();
        this.getChoiceModel(540084480).resetListener();
        this.getChoiceModel(405801216).resetListener();
        this.getChoiceModel(-114292480).resetListener();
        this.getChoiceModel(556796160).resetListener();
        this.airDistributionZone1 = null;
        this.getChoiceModel(456132864).resetListener();
        this.getChoiceModel(607193344).resetListener();
        this.getChoiceModel(540018944).resetListener();
        this.getChoiceModel(372246784).resetListener();
        this.airDistributionZone2 = null;
        this.getRangeModel(-2026960640).resetListener();
        this.footwellTempRangeModelSyncZone1.clear();
        this.getChoiceModel(842074368).resetListener();
        this.getRangeModel(-2043737856).resetListener();
        this.footwellTempRangeModelSyncZone2.clear();
        this.getChoiceModel(1647315200).resetListener();
        this.getChoiceModel(204474624).resetListener();
        this.getChoiceModel(1848576256).resetListener();
        this.getChoiceModel(1865353472).resetListener();
        this.getRangeModel(1244662016).resetListener();
        this.getRangeModel(590416128).resetListener();
        this.temperatureZone3 = null;
        this.getRangeModel(1429211392).resetListener();
        this.getRangeModel(758188288).resetListener();
        this.temperatureZone4 = null;
        this.getRangeModel(808519936).resetListener();
        this.getChoiceModel(791677184).resetListener();
        this.airVolumeZone3 = null;
        this.getRangeModel(657524992).resetListener();
        this.getChoiceModel(0x30300900).resetListener();
        this.airVolumeZone4 = null;
        this.getChoiceModel(338692352).resetListener();
        this.getChoiceModel(103876864).resetListener();
        this.getChoiceModel(825297152).resetListener();
        this.getChoiceModel(472910080).resetListener();
        this.airDistributionZone3 = null;
        this.getChoiceModel(439355648).resetListener();
        this.getChoiceModel(271649024).resetListener();
        this.getChoiceModel(556861696).resetListener();
        this.getChoiceModel(489687296).resetListener();
        this.airDistributionZone4 = null;
        this.getRangeModel(-2077292288).resetListener();
        this.footwellTempRangeModelSyncZone3.clear();
        this.getChoiceModel(1630537984).resetListener();
        this.getRangeModel(-2060515072).resetListener();
        this.footwellTempRangeModelSyncZone4.clear();
        this.getChoiceModel(1596983552).resetListener();
        this.getChoiceModel(305137920).resetListener();
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
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

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
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
            this.updateMenuEntryVisibility(2, this.currentViewOptionsRow2);
            this.primaryAttributeReceived(1, 94);
        }
    }

    @Override
    public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconComponent#updateAirconViewOptionsRow3] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow3 = airconRowViewOptions;
            this.updateMenuEntryVisibility(3, this.currentViewOptionsRow3);
            this.primaryAttributeReceived(2, 95);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSystemOnOffRow1] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(674302208).setValue(n2);
            this.notifySystemOnOff(1, bl);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow2(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSystemOnOffRow2] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(204474624).setValue(n2);
            this.notifySystemOnOff(2, bl);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow3(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSystemOnOffRow3] systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            int n2 = this.invertHMISystemOnOffState ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(305137920).setValue(n2);
            this.notifySystemOnOff(3, bl);
        }
    }

    @Override
    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirCirculationAuto] airCirulationAuto='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(-47183616).setValue(bl ? 1 : 0);
            if (!bl && this.isAirCirculationAutoAvailable()) {
                this.getRangeModel(908724480).setValue(this.getConfig().getAirCirculationSensitivityRangeMinWithOff());
            }
        }
    }

    @Override
    public void updateAirconAirCirculationSensitivity(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirCirculationSensitivity] sensitivity='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.airCirculationSensitivityModelSync.notifyUpdateReceived(5, n);
            try {
                n3 = this.convertCirculationSensitivityDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconAirCirculationSensitivity] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(925501696).setValue(n3);
        }
    }

    @Override
    public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AirConditionComponentPorsche#updateAirconAirCirculationMiddleExhaustion] middleExhaustion='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            int n3;
            try {
                n3 = this.convertMiddleExhaustionDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconAirCirculationMiddleExhaustion] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(-1624504064).setValue(n3);
        }
    }

    @Override
    public void updateAirconIndirectVentilation(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconIndirectVentilation] indirectVentilation='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            boolean bl2 = this.invertHMIIndirectVentilation ? !bl : bl;
            this.getChoiceModel(489752832).setValue(bl2 ? 1 : 0);
        }
    }

    @Override
    public void updateAirconHeater(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconHeater] heater='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(891947264).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconSolar(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSolar] solar='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(1412040960).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconAC(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAC] ac='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(238029056).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconEcoAC(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconEcoAC] ecoAc='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(372312320).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconMaxAC(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconMaxAC] maxAc='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(254806272).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSteeringWheelHeater] steeringWheelHeater='%1', valid='%2'", (Object)(null == airconSteeringWheelHeater ? "null" : airconSteeringWheelHeater.toString()), (long)n);
        if (1 == n) {
            this.currentSteeringWheelHeater = airconSteeringWheelHeater;
            this.getChoiceModel(288360704).setValue(airconSteeringWheelHeater.isHeating() ? 1 : 0);
        }
    }

    @Override
    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconFrontWindowHeaterAuto] frontWindowHeaterAuto='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(1143605504).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSynchronisation] synchronisation='%1', valid='%2'", (Object)(null == airconSynchronisation ? "null" : airconSynchronisation.toString()), (long)n);
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
                this.getChoiceModel(-30406400).setValue(bl ? 1 : 0);
                this.onAirconSyncChanged(bl);
            } else {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconSynchronisation]: Couldn't get configuration. Update ignored.");
            }
        }
    }

    @Override
    public void updateAirconRearControlFondPlus(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconRearControlFondPlus] fondPlus='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(221251840).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconSynchronisation] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone1.updateTemperature(airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconTempZone2] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone2.updateTemperature(airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconTempZone3] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone3.updateTemperature(airconTemp);
        }
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconTempZone4] temp='%1', valid='%2'", (Object)(null == airconTemp ? "null" : airconTemp.toString()), (long)n);
        if (1 == n) {
            this.temperatureZone4.updateTemperature(airconTemp);
        }
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirVolumeZone1] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone1.updateAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirVolumeZone2] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone2.updateAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirVolumeZone3] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone3.updateAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirVolumeZone4] airVolume='%1', valid='%2'", (Object)(null == airconAirVolume ? "null" : airconAirVolume.toString()), (long)n);
        if (1 == n) {
            this.airVolumeZone4.updateAirVolume(airconAirVolume);
        }
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirDistributionZone1] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone1.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirDistributionZone2] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone2.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirDistributionZone3] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone3.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconAirDistributionZone4] airDistribution='%1', valid='%2'", (Object)(null == airconAirDistribution ? "null" : airconAirDistribution.toString()), (long)n);
        if (1 == n) {
            this.airDistributionZone4.updateAirDistribution(airconAirDistribution);
        }
    }

    @Override
    public void updateAirconFootwellTempZone1(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconFootwellTempZone1] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone1.notifyUpdateReceived(27, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconFootwellTempZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(842074368).setValue(n3);
        }
    }

    @Override
    public void updateAirconFootwellTempZone2(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconFootwellTempZone2] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone2.notifyUpdateReceived(33, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconFootwellTempZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1647315200).setValue(n3);
        }
    }

    @Override
    public void updateAirconFootwellTempZone3(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconFootwellTempZone3] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone3.notifyUpdateReceived(39, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconFootwellTempZone3] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1630537984).setValue(n3);
        }
    }

    @Override
    public void updateAirconFootwellTempZone4(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconFootwellTempZone4] footwellTemp='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            this.footwellTempRangeModelSyncZone4.notifyUpdateReceived(45, n);
            try {
                n3 = this.convertFootwellTemperatureDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconFootwellTempZone4] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1596983552).setValue(n3);
        }
    }

    @Override
    public void updateAirconClimateStyleZone1(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconClimateStyleZone1] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconClimateStyleZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(-13629184).setValue(n3);
        }
    }

    @Override
    public void updateAirconClimateStyleZone2(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconClimateStyleZone2] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconClimateStyleZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1898907904).setValue(n3);
        }
    }

    @Override
    public void updateAirconClimateStyleZone3(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconClimateStyleZone3] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconClimateStyleZone3] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1848576256).setValue(n3);
        }
    }

    @Override
    public void updateAirconClimateStyleZone4(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconClimateStyleZone4] style='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            int n3;
            try {
                n3 = this.convertClimateStyleDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconClimateStyleZone4] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(1865353472).setValue(n3);
        }
    }

    @Override
    public void updateAirconIonisatorZone1(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconIonisatorZone1] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2 && this.isUpdateIonizer(1)) {
            int n3;
            try {
                n3 = this.convertIonizerStateDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconIonisatorZone1] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(691079424).setValue(n3);
        }
    }

    @Override
    public void updateAirconIonisatorZone2(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconIonisatorZone2] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2 && this.isUpdateIonizer(2)) {
            int n3;
            try {
                n3 = this.convertIonizerStateDSI2HMI(n);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#updateAirconIonisatorZone2] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                return;
            }
            this.getChoiceModel(691079424).setValue(n3);
        }
    }

    @Override
    public void updateAirconIonisatorZone3(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconIonisatorZone3] state='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            super.updateAirconIonisatorZone3(n, n2);
        }
    }

    @Override
    public void updateAirconIonisatorZone4(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[AbstractAirconComponent#updateAirconIonisatorZone4] state='%1', valid='%2'", (long)n, (long)n2);
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
            this.getLogChannel().log(-1601830656, "[AbstractAirconComponent#setRangeModelValue] Model with ID='%1' not available. Update ignored.", (long)iRangeModelSyncParameterAccess.getRangeModelID());
        }
    }

    private int convertFootwellTemperatureDSI2HMI(int n) {
        return (Integer)this.footwellTemperatureConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertFootwellTemperatureHMI2DSI(int n) {
        return (Integer)this.footwellTemperatureConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertClimateStyleDSI2HMI(int n) {
        return (Integer)this.climateStyleConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertClimateStyleHMI2DSI(int n) {
        return (Integer)this.climateStyleConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertIonizerStateDSI2HMI(int n) {
        return (Integer)this.ionizerConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertIonizerStateHMI2DSI(int n) {
        return (Integer)this.ionizerConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertCirculationSensitivityDSI2HMI(int n) {
        return (Integer)this.airCirculationSensitivityConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertCirculationSensitivityHMI2DSI(int n) {
        return (Integer)this.airCirculationSensitivityConverterStrategy.getDSIValue(new Integer(n));
    }

    private int convertMiddleExhaustionDSI2HMI(int n) {
        return (Integer)this.middleExhaustionConverterStrategy.getHMIValue(new Integer(n));
    }

    private int convertMiddleExhaustionHMI2DSI(int n) {
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
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.convertRowDSI2HMI] Row('%1') not supported.", (long)n);
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
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.convertRowHMI2DSI] Row('%1') not supported.", (long)n);
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
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.convertZoneDSI2HMI] Zone('%1') not supported.", (long)n);
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
                this.getLogChannel().log(-1601830656, "[AbstractAirconComponent.convertZoneHMI2DSI] Zone('%1') not supported.", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    static /* synthetic */ RangeModelApp access$000(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$100(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ MetricsModelApp access$300(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getMetricsModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$400(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$600(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$700(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$800(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$900(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getChoiceModel(n);
    }

    static /* synthetic */ AbstractAirconComponent$RangeModelSyncListener access$1000(AbstractAirconComponent abstractAirconComponent) {
        return abstractAirconComponent.rangeModelSyncListener;
    }

    static /* synthetic */ void access$1100(AbstractAirconComponent abstractAirconComponent, IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        abstractAirconComponent.setRangeModelValue(iRangeModelSyncParameterAccess);
    }

    static /* synthetic */ void access$1600(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setStateAC(bl);
    }

    static /* synthetic */ void access$1700(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setStateEcoAC(bl);
    }

    static /* synthetic */ void access$1800(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setStateMaxAC(bl);
    }

    static /* synthetic */ void access$1900(AbstractAirconComponent abstractAirconComponent, int n) {
        abstractAirconComponent.setAirCirculationSensitivity(n);
    }

    static /* synthetic */ void access$2000(AbstractAirconComponent abstractAirconComponent, int n) {
        abstractAirconComponent.setMiddleExhaustion(n);
    }

    static /* synthetic */ void access$2100(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setAirCirculationAuto(bl);
    }

    static /* synthetic */ void access$2200(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setIndirectVentilation(bl);
    }

    static /* synthetic */ void access$2300(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setHeater(bl);
    }

    static /* synthetic */ void access$2400(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setFrontWindowHeaterAuto(bl);
    }

    static /* synthetic */ void access$2500(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setSteeringWheelHeating(bl);
    }

    static /* synthetic */ void access$2600(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setSolar(bl);
    }

    static /* synthetic */ void access$2700(AbstractAirconComponent abstractAirconComponent, boolean bl) {
        abstractAirconComponent.setRearControlFondPlus(bl);
    }

    static /* synthetic */ void access$2800(AbstractAirconComponent abstractAirconComponent, int n, int n2) {
        abstractAirconComponent.setIonizerState(n, n2);
    }

    static /* synthetic */ void access$2900(AbstractAirconComponent abstractAirconComponent, int n, boolean bl) {
        abstractAirconComponent.setSynchronization(n, bl);
    }

    static /* synthetic */ void access$3000(AbstractAirconComponent abstractAirconComponent, int n, boolean bl) {
        abstractAirconComponent.setSystemOnOff(n, bl);
    }

    static /* synthetic */ void access$3100(AbstractAirconComponent abstractAirconComponent, int n, int n2) {
        abstractAirconComponent.setFootwellTemperature(n, n2);
    }

    static /* synthetic */ void access$3200(AbstractAirconComponent abstractAirconComponent, int n, int n2) {
        abstractAirconComponent.setClimateStyle(n, n2);
    }

    static /* synthetic */ RangeModelApp access$3300(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$3400(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$3500(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$3600(AbstractAirconComponent abstractAirconComponent, int n) {
        return abstractAirconComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelSynchronizer access$3700(AbstractAirconComponent abstractAirconComponent) {
        return abstractAirconComponent.airCirculationSensitivityModelSync;
    }

    static /* synthetic */ void access$3800(AbstractAirconComponent abstractAirconComponent, int n, int n2) {
        abstractAirconComponent.decrementFootwellTemperature(n, n2);
    }

    static /* synthetic */ void access$3900(AbstractAirconComponent abstractAirconComponent, int n, int n2) {
        abstractAirconComponent.incrementFootwellTemperature(n, n2);
    }
}

