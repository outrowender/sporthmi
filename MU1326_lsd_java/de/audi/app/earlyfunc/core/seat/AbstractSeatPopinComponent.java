/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.seat.AbstractDSICarSeatAdapter;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopinComponent;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent$MassageProgram;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinModel;
import de.audi.app.earlyfunc.core.seat.SeatPopinSettingsHandler;
import de.audi.app.earlyfunc.core.seat.popin.SeatPartialPopupFactory;
import de.audi.app.earlyfunc.core.seat.popup.SeatPopupFactory;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import java.util.HashMap;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public abstract class AbstractSeatPopinComponent
extends AbstractDSICarSeatAdapter
implements ISeatPopinComponent,
BaseListModelListener {
    private static final String LOGCHANNEL_NAME;
    private final SeatPopinConfigurationHandler configurationHandler;
    protected final SeatPopinSettingsHandler settingsHandler;
    private volatile SeatViewOptions currentViewOptions;
    private ISeatMainController mainPopupController;
    protected final BaseListModelApp seatPopupBaseListModelLeft = this.getBaseListModel(1141645312);
    protected final BaseListModelApp seatPopupBaseListModelRight = this.getBaseListModel(1158422528);
    private boolean isFirstStart = true;
    private HashMap switcherDataMap = new HashMap();
    MassageData seatMassageData1RL = null;
    MassageData seatMassageData1RR = null;

    public AbstractSeatPopinComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Seat");
        SeatPopinModel seatPopinModel = new SeatPopinModel(this.getLogChannel(), this.seatPopupBaseListModelLeft);
        SeatPopinModel seatPopinModel2 = new SeatPopinModel(this.getLogChannel(), this.seatPopupBaseListModelRight);
        this.configurationHandler = new SeatPopinConfigurationHandler(this.getLogChannel(), seatPopinModel, seatPopinModel2, this.getChoiceModel(1913397248));
        this.settingsHandler = new SeatPopinSettingsHandler(this.getLogChannel(), this.configurationHandler);
    }

    @Override
    public void init() {
        this.initMainController();
        super.init();
        this.getBaseListModel(1141645312).setListener(this);
        this.getBaseListModel(1158422528).setListener(this);
    }

    private void initMainController() {
        AbstractSeatPopupFactory abstractSeatPopupFactory = null;
        int n = this.getApplication().getFrameworkAccess().getSysConst(4010);
        abstractSeatPopupFactory = n == 1 ? new SeatPopupFactory(this.getApplication(), this.getLogChannel(), this) : new SeatPartialPopupFactory(this.getApplication(), this.getLogChannel(), this);
        abstractSeatPopupFactory.init();
        this.mainPopupController = abstractSeatPopupFactory.createInstanceMainController();
        this.mainPopupController.init();
    }

    @Override
    public void deinit() {
        if (this.mainPopupController != null) {
            this.mainPopupController.deinit();
        }
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.configurationHandler.init();
    }

    @Override
    protected void deinitModels() {
        this.configurationHandler.deinit();
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatViewOptions] viewOptions='%1', valid='%2'", (Object)(seatViewOptions != null ? this.formatViewOptionsLog(seatViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && seatViewOptions != null) {
            this.currentViewOptions = seatViewOptions;
            this.mainPopupController.updateConfigurationHandler(this.currentViewOptions);
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeReceived(0, 1);
            this.primaryAttributeReceived(0, 23);
        }
    }

    @Override
    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticViewOptions] viewOptions='%1', valid='%2'", (Object)(seatPneumaticViewOptions != null ? this.formatViewOptionsLog(seatPneumaticViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && seatPneumaticViewOptions != null) {
            this.mainPopupController.updateConfigurationHandler(seatPneumaticViewOptions);
            this.primaryAttributeReceived(0, 23);
            this.primaryAttributeReceived(0, 1);
        }
    }

    @Override
    public void updateSeatContent(SeatContent seatContent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatContent] seatContent='%1' , valid='%2'", (Object)seatContent, (long)n);
        }
        if (n == 1 && seatContent != null) {
            this.mainPopupController.updateSeatContent(seatContent);
        }
    }

    @Override
    public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticContent] content='%1' , valid='%2'", (Object)seatPneumaticContent, (long)n);
        }
        if (n == 1 && seatPneumaticContent != null) {
            this.mainPopupController.updateSeatContent(seatPneumaticContent);
        }
    }

    @Override
    public void requestSeatPopup(SeatContent seatContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#requestSeatPopup] content='%1'", (Object)seatContent);
        }
        this.mainPopupController.requestSeatPopin(seatContent);
    }

    @Override
    public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#requestSeatPneumaticPopup] content='%1'", (Object)seatPneumaticContent);
        }
        this.mainPopupController.requestSeatPopin(seatPneumaticContent);
    }

    @Override
    public void acknowledgeSeatPopup(SeatContent seatContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#acknowledgeSeatPopup] content='%1'", (Object)seatContent);
        }
        if (this.isFirstStart) {
            this.isFirstStart = false;
            this.updateSwitcherData();
        }
        this.mainPopupController.acknowledgeSeatPopup(seatContent);
    }

    private void updateSwitcherData() {
        if (this.switcherDataMap != null) {
            if (this.switcherDataMap.containsKey("DataUp1RL")) {
                this.updateSeatSwitcherDataUp1RL((SwitcherDataUpDown)this.switcherDataMap.get("DataUp1RL"), 1);
            }
            if (this.switcherDataMap.containsKey("DataUp1RR")) {
                this.updateSeatSwitcherDataUp1RR((SwitcherDataUpDown)this.switcherDataMap.get("DataUp1RR"), 1);
            }
            if (this.switcherDataMap.containsKey("DataDown1RR")) {
                this.updateSeatSwitcherDataDown1RR((SwitcherDataUpDown)this.switcherDataMap.get("DataDown1RR"), 1);
            }
            if (this.switcherDataMap.containsKey("DataDown1RL")) {
                this.updateSeatSwitcherDataDown1RL((SwitcherDataUpDown)this.switcherDataMap.get("DataDown1RL"), 1);
            }
            if (this.switcherDataMap.containsKey("DataForward1RR")) {
                this.updateSeatSwitcherDataForward1RR((SwitcherDataBackForward)this.switcherDataMap.get("DataForward1RR"), 1);
            }
            if (this.switcherDataMap.containsKey("DataForward1RL")) {
                this.updateSeatSwitcherDataForward1RL((SwitcherDataBackForward)this.switcherDataMap.get("DataForward1RL"), 1);
            }
            if (this.switcherDataMap.containsKey("DataBack1RR")) {
                this.updateSeatSwitcherDataBack1RR((SwitcherDataBackForward)this.switcherDataMap.get("DataBack1RR"), 1);
            }
            if (this.switcherDataMap.containsKey("DataBack1RL")) {
                this.updateSeatSwitcherDataBack1RL((SwitcherDataBackForward)this.switcherDataMap.get("DataBack1RL"), 1);
            }
        }
    }

    @Override
    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#acknowledgeSeatPneumaticPopup] content='%1'", (Object)seatPneumaticContent);
        }
        this.mainPopupController.acknowledgeSeatPopup(seatPneumaticContent);
    }

    @Override
    public void updateSeatMassageData1RL(MassageData massageData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatMassageData1RL] massageData='%1', valid='%2'", (Object)massageData, (long)n);
        }
        if (n == 1 && massageData != null) {
            this.settingsHandler.updateSeatMassageData1RL(massageData);
            this.seatMassageData1RL = massageData;
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticMassageData1RL] massageData='%1', valid='%2'", (Object)massageData, (long)n);
        }
        if (n == 1 && massageData != null) {
            this.settingsHandler.updateSeatMassageData1RL(massageData);
            this.seatMassageData1RL = massageData;
        }
    }

    @Override
    public void updateSeatMassageData1RR(MassageData massageData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatMassageData1RR] massageData='%1', valid='%2'", (Object)massageData, (long)n);
        }
        if (n == 1 && massageData != null) {
            this.settingsHandler.updateSeatMassageData1RR(massageData);
            this.seatMassageData1RR = massageData;
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticMassageData1RR] massageData='%1', valid='%2'", (Object)massageData, (long)n);
        }
        if (n == 1 && massageData != null) {
            this.settingsHandler.updateSeatMassageData1RR(massageData);
            this.seatMassageData1RR = massageData;
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataUp1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.switcherDataMap.put("DataUp1RL", switcherDataUpDown);
            this.settingsHandler.updateSeatSwitcherDataUp1RL(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataUp1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.settingsHandler.updateSeatSwitcherDataUp1RL(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataUp1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.switcherDataMap.put("DataUp1RR", switcherDataUpDown);
            this.settingsHandler.updateSeatSwitcherDataUp1RR(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataUp1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.settingsHandler.updateSeatSwitcherDataUp1RR(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataDown1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.switcherDataMap.put("DataDown1RL", switcherDataUpDown);
            this.settingsHandler.updateSeatSwitcherDataDown1RL(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataDown1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.settingsHandler.updateSeatSwitcherDataDown1RL(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataDown1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.switcherDataMap.put("DataDown1RR", switcherDataUpDown);
            this.settingsHandler.updateSeatSwitcherDataDown1RR(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataDown1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataUpDown, (long)n);
        }
        if (n == 1 && switcherDataUpDown != null) {
            this.settingsHandler.updateSeatSwitcherDataDown1RR(switcherDataUpDown);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataForward1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.switcherDataMap.put("DataForward1RL", switcherDataBackForward);
            this.settingsHandler.updateSeatSwitcherDataForward1RL(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataForward1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.settingsHandler.updateSeatSwitcherDataForward1RL(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataForward1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.switcherDataMap.put("DataForward1RR", switcherDataBackForward);
            this.settingsHandler.updateSeatSwitcherDataForward1RR(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataForward1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.settingsHandler.updateSeatSwitcherDataForward1RR(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataBack1RL] seatSwitchDataBack1RL='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.switcherDataMap.put("DataBack1RL", switcherDataBackForward);
            this.settingsHandler.updateSeatSwitcherDataBack1RL(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataBack1RL] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.settingsHandler.updateSeatSwitcherDataBack1RL(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatSwitcherDataBack1RR] seatSwitchDataBack1RL='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.switcherDataMap.put("DataBack1RR", switcherDataBackForward);
            this.settingsHandler.updateSeatSwitcherDataBack1RR(switcherDataBackForward);
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#updateSeatPneumaticSwitcherDataBack1RR] seatSwitchData='%1', valid='%2'", (Object)switcherDataBackForward, (long)n);
        }
        if (n == 1 && switcherDataBackForward != null) {
            this.settingsHandler.updateSeatSwitcherDataBack1RR(switcherDataBackForward);
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1, 23}, new int[]{18, 8, 9, 13, 17, 11, 15, 12, 16, 10, 14, 35, 25, 26, 30, 34, 28, 32, 29, 33, 27, 31})};
    }

    protected abstract void updateMenuEntryVisibility(SeatViewOptions seatViewOptions) {
    }

    public abstract int getFrontLeftHMIPartialPopinID() {
    }

    public abstract int getFrontRightHMIPartialPopinID() {
    }

    public abstract int getFrontRightMemoryHMIPartialPopinID() {
    }

    public abstract int getFrontLeftMemoryHMIPartialPopinID() {
    }

    public abstract int getHMISeatPopupID() {
    }

    public abstract int getStandbyPopupID() {
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#dsiAvailable] DSISeat.setSeatHMIIsReady('%1')", bl);
        this.getDSI().setSeatHMIIsReady(bl);
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "viewOptions not received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    public String getName() {
        return "SeatPopin";
    }

    public SeatPopinConfigurationHandler getConfigurationHandler() {
        return this.configurationHandler;
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected]: ('%1')", (long)n);
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        if (n == 1141645312) {
            n5 = this.seatMassageData1RL.intensity;
            n6 = this.seatMassageData1RL.speed;
            n7 = 1;
        } else if (n == 1158422528) {
            n5 = this.seatMassageData1RR.intensity;
            n6 = this.seatMassageData1RR.speed;
            n7 = 2;
        }
        this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] index: ('%1')", (long)n2);
        switch ((int)evoListRow.getUniqueID()) {
            case 102: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 107: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KNETEN.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 106: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_STRETCH.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 103: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_RUECKEN.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 104: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_SCHULTER.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 105: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_WELLE.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
            case 101: {
                this.getDSI().setSeatMassageData(n7, new MassageData(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE.getDsiProgramNr(), n5, n6));
                this.getLogChannel().log(1078071040, "[AbstractSeatPopinComponent#itemSelected] DSI.setSeatMassageData: ('%1')", (Object)new StringBuffer().append(MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_KLOPFEN.getDsiProgramNr()).append(", ").append(", ").append(n5).append(",").append(n6).toString());
                break;
            }
        }
    }

    public void setSeatMassageIntensity(boolean bl, boolean bl2) {
        int n = bl ? 1 : 2;
        MassageData massageData = bl ? this.seatMassageData1RL : this.seatMassageData1RR;
        int n2 = massageData.program;
        massageData.intensity = bl2 ? ++massageData.intensity : --massageData.intensity;
        massageData.program = n2;
        this.getDSI().setSeatMassageData(n, massageData);
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

