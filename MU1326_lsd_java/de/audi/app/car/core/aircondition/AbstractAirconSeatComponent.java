/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.aircondition.AbstractAirconSeatComponent$1;
import de.audi.app.car.core.aircondition.AirconConfig;
import de.audi.app.car.core.aircondition.IAirconConstants;
import de.audi.app.car.core.aircondition.SeatACRotaryToGraphicMapper;
import de.audi.app.car.core.app.AbstractRangeToChoiceModelMapper;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;

public abstract class AbstractAirconSeatComponent
extends AbstractDSICarAirConditionAdapter
implements IAirconConstants {
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    public static final String DSI_LOGCHANNEL_NAME;
    private static final int FUNCTIONTYPE_VENTILATION;
    private static final int FUNCTIONTYPE_HEATING;
    private final LogChannel dsiLogChannel;
    protected AirconConfig config = new AirconConfig();
    private final RangeListener rangeListener = new AbstractAirconSeatComponent$1(this);
    protected volatile AirconMasterViewOptions currentViewOptionsMaster;
    protected volatile AirconRowViewOptions currentViewOptionsRow1;
    protected volatile AirconRowViewOptions currentViewOptionsRow2;
    private volatile boolean driverSideRight = false;
    private RangeModelWatcherTimer driverSeatRangeWatcherVentilation;
    private RangeModelWatcherTimer codriverSeatRangeWatcherVentilation;
    private RangeModelWatcherTimer driverRearSeatRangeWatcherVentilation;
    private RangeModelWatcherTimer codriverRearSeatRangeWatcherVentilation;
    private AbstractRangeToChoiceModelMapper driverSeatRangeWatcherVentilationMapper;
    private AbstractRangeToChoiceModelMapper codriverSeatRangeWatcherVentilationMapper;
    private AbstractRangeToChoiceModelMapper driverRearSeatRangeWatcherVentilationMapper;
    private AbstractRangeToChoiceModelMapper codriverRearSeatRangeWatcherVentilationMapper;
    private RangeModelWatcherTimer driverSeatRangeWatcherHeating;
    private RangeModelWatcherTimer codriverSeatRangeWatcherHeating;
    private RangeModelWatcherTimer driverRearSeatRangeWatcherHeating;
    private RangeModelWatcherTimer codriverRearSeatRangeWatcherHeating;
    private AbstractRangeToChoiceModelMapper driverSeatRangeWatcherHeatingMapper;
    private AbstractRangeToChoiceModelMapper codriverSeatRangeWatcherHeatingMapper;
    private AbstractRangeToChoiceModelMapper driverRearSeatRangeWatcherHeatingMapper;
    private AbstractRangeToChoiceModelMapper codriverRearSeatRangeWatcherHeatingMapper;

    public AbstractAirconSeatComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AirCondition.Seat");
        this.dsiLogChannel = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.AirCondition.DSI");
    }

    public LogChannel getLogChannelDSI() {
        return this.dsiLogChannel;
    }

    public boolean isDriverSideRight() {
        return this.driverSideRight;
    }

    public void setDriverSideRight(boolean bl) {
        this.driverSideRight = bl;
    }

    private void modifyRange(int n, int n2, int n3) {
        if (this.isSupportedRangeModel(n)) {
            RangeModelApp rangeModelApp = this.getRangeModel(n);
            int n4 = AbstractAirconSeatComponent.clip(rangeModelApp.getValue() + n2, rangeModelApp.getMinimum(), rangeModelApp.getMaximum());
            int n5 = this.convertModelID2DSIZone(n);
            int n6 = this.getType(n);
            if (-1 != n5 && -1 != n6) {
                switch (n6) {
                    case 1: {
                        this.getLogChannelDSI().log(1078071040, "---> DSI.setAirconSeatVentilationDistribution(%1, %2)", (long)n5, (long)n4);
                        this.getDSI().setAirconSeatVentilationDistribution(n5, n4);
                        break;
                    }
                    case 2: {
                        this.getLogChannelDSI().log(1078071040, "---> DSI.setAirconSeatHeaterDistribution(%1, %2)", (long)n5, (long)n4);
                        this.getDSI().setAirconSeatHeaterDistribution(n5, n4);
                        break;
                    }
                    default: {
                        this.getLogChannel().log(1000, "[AbstractAirconSeatComponent#modifyRange] Unexpected error for modelID='%1'", (long)n);
                        return;
                    }
                }
                RangeModelWatcherTimer rangeModelWatcherTimer = this.getRangeModelWatcherTimer(n);
                if (null != rangeModelWatcherTimer) {
                    rangeModelWatcherTimer.setTempValue(n4);
                } else {
                    this.getLogChannel().log(1000, "[AbstractAirconSeatComponent#modifyRange] Could not get RangeModelWatcherTimer for modelID='%1'", (long)n);
                }
            } else {
                this.getLogChannel().log(1000, "[AbstractAirconSeatComponent#modifyRange] Could not determine all data for modelID='%1'", (long)n);
            }
        } else {
            this.logModelData("increment or decrement:", n, n2, false);
        }
    }

    private boolean isSupportedRangeModel(int n) {
        switch (n) {
            case 600651: 
            case 600652: 
            case 600653: 
            case 600654: 
            case 600655: 
            case 600656: 
            case 600657: 
            case 600658: {
                return true;
            }
        }
        return false;
    }

    private RangeModelWatcherTimer getRangeModelWatcherTimer(int n) {
        switch (n) {
            case 600652: {
                return this.driverSeatRangeWatcherVentilation;
            }
            case 600651: {
                return this.codriverSeatRangeWatcherVentilation;
            }
            case 600654: {
                return this.driverRearSeatRangeWatcherVentilation;
            }
            case 600653: {
                return this.codriverRearSeatRangeWatcherVentilation;
            }
            case 600656: {
                return this.driverSeatRangeWatcherHeating;
            }
            case 600655: {
                return this.codriverSeatRangeWatcherHeating;
            }
            case 600658: {
                return this.driverRearSeatRangeWatcherHeating;
            }
            case 600657: {
                return this.codriverRearSeatRangeWatcherHeating;
            }
        }
        return null;
    }

    private int convertModelID2DSIZone(int n) {
        switch (n) {
            case 600652: {
                return this.isDriverSideRight() ? 2 : 1;
            }
            case 600651: {
                return this.isDriverSideRight() ? 1 : 2;
            }
            case 600654: {
                return this.isDriverSideRight() ? 8 : 4;
            }
            case 600653: {
                return this.isDriverSideRight() ? 4 : 8;
            }
            case 600656: {
                return this.isDriverSideRight() ? 2 : 1;
            }
            case 600655: {
                return this.isDriverSideRight() ? 1 : 2;
            }
            case 600658: {
                return this.isDriverSideRight() ? 8 : 4;
            }
            case 600657: {
                return this.isDriverSideRight() ? 4 : 8;
            }
        }
        return -1;
    }

    private int getType(int n) {
        switch (n) {
            case 600651: 
            case 600652: 
            case 600653: 
            case 600654: {
                return 1;
            }
            case 600655: 
            case 600656: 
            case 600657: 
            case 600658: {
                return 2;
            }
        }
        return -1;
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
    }

    protected abstract void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
    }

    @Override
    public String getName() {
        return "AirCondition Seat Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{69, 70, 63, 64}), new CarDSIAttributesSet(1, new int[]{92, 94}, new int[]{71, 72, 65, 66})};
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
        return buffer.toString();
    }

    @Override
    protected void initModels() {
        this.driverSeatRangeWatcherVentilationMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(523110656), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.codriverSeatRangeWatcherVentilationMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(456001792), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.driverRearSeatRangeWatcherVentilationMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(422447360), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.codriverRearSeatRangeWatcherVentilationMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(439224576), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.driverSeatRangeWatcherVentilation = new RangeModelWatcherTimer("AC_SEAT_AC_VENTILATION_DRIVER_RANGE", this.getRangeModel(1277823232), 0, this.driverSeatRangeWatcherVentilationMapper, this.getLogChannel());
        this.codriverSeatRangeWatcherVentilation = new RangeModelWatcherTimer("AC_SEAT_AC_VENTILATION_CO_DRIVER_RANGE", this.getRangeModel(1261046016), 0, this.codriverSeatRangeWatcherVentilationMapper, this.getLogChannel());
        this.driverRearSeatRangeWatcherVentilation = new RangeModelWatcherTimer("AC_SEAT_AC_VENTILATION_REAR_DRIVER_RANGE", this.getRangeModel(1311377664), 0, this.driverRearSeatRangeWatcherVentilationMapper, this.getLogChannel());
        this.codriverRearSeatRangeWatcherVentilation = new RangeModelWatcherTimer("AC_SEAT_AC_VENTILATION_REAR_CODRIVER_RANGE", this.getRangeModel(1294600448), 0, this.codriverRearSeatRangeWatcherVentilationMapper, this.getLogChannel());
        this.getRangeModel(1277823232).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1277823232).setRangeListener(this.rangeListener);
        this.getRangeModel(1261046016).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1261046016).setRangeListener(this.rangeListener);
        this.getRangeModel(1311377664).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1311377664).setRangeListener(this.rangeListener);
        this.getRangeModel(1294600448).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1294600448).setRangeListener(this.rangeListener);
        this.driverSeatRangeWatcherHeatingMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(472779008), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.codriverSeatRangeWatcherHeatingMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(489556224), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.driverRearSeatRangeWatcherHeatingMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(506333440), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.codriverRearSeatRangeWatcherHeatingMapper = new SeatACRotaryToGraphicMapper(this.getChoiceModel(405670144), this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.driverSeatRangeWatcherHeating = new RangeModelWatcherTimer("AC_SEATHEATING_DRIVER_RANGE", this.getRangeModel(1344932096), 0, this.driverSeatRangeWatcherHeatingMapper, this.getLogChannel());
        this.codriverSeatRangeWatcherHeating = new RangeModelWatcherTimer("AC_SEATHEATING_CODRIVER_RANGE", this.getRangeModel(1328154880), 0, this.codriverSeatRangeWatcherHeatingMapper, this.getLogChannel());
        this.driverRearSeatRangeWatcherHeating = new RangeModelWatcherTimer("AC_SEATHEATING_REAR_DRIVER_RANGE", this.getRangeModel(1378486528), 0, this.driverRearSeatRangeWatcherHeatingMapper, this.getLogChannel());
        this.codriverRearSeatRangeWatcherHeating = new RangeModelWatcherTimer("AC_SEATHEATING_REAR_CODRIVER_RANGE", this.getRangeModel(1361709312), 0, this.codriverRearSeatRangeWatcherHeatingMapper, this.getLogChannel());
        this.getRangeModel(1344932096).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1344932096).setRangeListener(this.rangeListener);
        this.getRangeModel(1328154880).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1328154880).setRangeListener(this.rangeListener);
        this.getRangeModel(1378486528).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1378486528).setRangeListener(this.rangeListener);
        this.getRangeModel(1361709312).setLimits(this.config.getSeatDistributionRangeMin(), this.config.getSeatDistributionRangeMax(), this.config.getSeatDistributionRangeStep());
        this.getRangeModel(1361709312).setRangeListener(this.rangeListener);
    }

    @Override
    protected void deinitModels() {
        this.getRangeModel(1277823232).resetListener();
        this.getRangeModel(1261046016).resetListener();
        this.getRangeModel(1311377664).resetListener();
        this.getRangeModel(1294600448).resetListener();
        this.getRangeModel(1344932096).resetListener();
        this.getRangeModel(1328154880).resetListener();
        this.getRangeModel(1378486528).resetListener();
        this.getRangeModel(1361709312).resetListener();
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeReceived(0, 92);
            this.primaryAttributeReceived(1, 92);
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
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
    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatHeaterDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            if (!this.isDriverSideRight()) {
                this.driverSeatRangeWatcherHeating.setValidValue(n);
            } else {
                this.codriverSeatRangeWatcherHeating.setValidValue(n);
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatHeaterDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (this.isDriverSideRight()) {
            this.driverSeatRangeWatcherHeating.setValidValue(n);
        } else {
            this.codriverSeatRangeWatcherHeating.setValidValue(n);
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatHeaterDistributionZone3] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            if (!this.isDriverSideRight()) {
                this.driverRearSeatRangeWatcherHeating.setValidValue(n);
            } else {
                this.codriverRearSeatRangeWatcherHeating.setValidValue(n);
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatHeaterDistributionZone4] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (this.isDriverSideRight()) {
            this.driverRearSeatRangeWatcherHeating.setValidValue(n);
        } else {
            this.codriverRearSeatRangeWatcherHeating.setValidValue(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatVentilationDistributionZone1] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (!this.isDriverSideRight()) {
            this.driverSeatRangeWatcherVentilation.setValidValue(n);
        } else {
            this.codriverSeatRangeWatcherVentilation.setValidValue(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatVentilationDistributionZone2] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (this.isDriverSideRight()) {
            this.driverSeatRangeWatcherVentilation.setValidValue(n);
        } else {
            this.codriverSeatRangeWatcherVentilation.setValidValue(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatVentilationDistributionZone3] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (!this.isDriverSideRight()) {
            this.driverRearSeatRangeWatcherVentilation.setValidValue(n);
        } else {
            this.codriverRearSeatRangeWatcherVentilation.setValidValue(n);
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirconSeatComponent#updateAirconSeatVentilationDistributionZone4] distribution='%1', valid='%2'", (long)n, (long)n2);
        if (this.isDriverSideRight()) {
            this.driverRearSeatRangeWatcherVentilation.setValidValue(n);
        } else {
            this.codriverRearSeatRangeWatcherVentilation.setValidValue(n);
        }
    }

    static /* synthetic */ RangeModelApp access$000(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$100(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$200(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$300(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$400(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$500(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$600(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$700(AbstractAirconSeatComponent abstractAirconSeatComponent, int n) {
        return abstractAirconSeatComponent.getRangeModel(n);
    }

    static /* synthetic */ void access$800(AbstractAirconSeatComponent abstractAirconSeatComponent, int n, int n2, int n3) {
        abstractAirconSeatComponent.modifyRange(n, n2, n3);
    }
}

