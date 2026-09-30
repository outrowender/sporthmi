/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.util.CarDistance;
import de.audi.app.car.core.bcme.CarBCmEConsumption;
import de.audi.app.car.core.bcme.ConsumerListHandler;
import de.audi.app.car.core.eco.AbstractDSICarEcoAdapter;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmEViewOptions;

public abstract class AbstractConsumerDisplayComponent
extends AbstractDSICarEcoAdapter {
    public static final short CODING_ID = 36;
    private static final String LOGCHANNEL_NAME = "App.Car.Consumer";
    private BCmEViewOptions currViewOptions;
    private ConsumerListHandler consumerListHandler;
    private ConsumerListHandler consumerListOldHandler;
    private static final int BCME_CONSUMPTION_VALUE_DSI_INVALID = 65535;
    private static final int BCME_CONSUMPTION_VALUE_HMI_INVALID = -1;
    private CarBCmEConsumption currentMaxConsumption = new CarBCmEConsumption(9);
    private int currentConsumptionValue = -1;
    private int convertedMaxConsumption = -1;
    private static final int RANGE_BCME_CONSUMPTION_MIN = 0;
    public static final int RANGE_BCME_CONSUMPTION_STEP = 1;
    private ModelGroup consumptionBarGraphGroup;
    private MetricsModelApp maxConsumptionMetricsModel;
    private MetricsModelApp halfMaxConsumptionMetricsModel;
    private RangeModelApp consumptionRange;
    private static final int MIN_WIDGET_SHOWN_VALUE = 4;
    private static final int BCME_RANGE_MAX = 65533;
    private static final int SPECIAL_VALUE_INVALID = 0;
    private static final int SPECIAL_VALUE_NO_SIGN = 1;
    private static final int SPECIAL_VALUE_SMALLER = 2;
    private static final int SPECIAL_VALUE_PLUS = 3;
    private volatile int currentElectricRange = 65533;
    private volatile int currentElectricRangeGain = 65533;
    private volatile int currentElectricRangeCatalogue = 65533;
    private boolean isOldSystem = false;

    public AbstractConsumerDisplayComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(602242);
        ChoiceModelApp choiceModelApp2 = this.getChoiceModel(602243);
        ChoiceModelApp choiceModelApp3 = this.getChoiceModel(602241);
        this.consumptionBarGraphGroup = new ModelGroup();
        this.maxConsumptionMetricsModel = this.getMetricsModel(601470);
        this.halfMaxConsumptionMetricsModel = this.getMetricsModel(601580);
        this.consumptionRange = this.getRangeModel(601544);
        this.consumerListHandler = new ConsumerListHandler(this.getLogChannel(), this.getBaseListModel(602235), this, 2, new ChoiceModelApp[]{choiceModelApp, choiceModelApp2, choiceModelApp3});
        this.consumerListOldHandler = new ConsumerListHandler(this.getLogChannel(), this.getBaseListModel(602235), this, 0);
        this.getMaxConsumptionMetricsModel().setMetric(this.getCurrentMaxConsumption());
        this.getMaxConsumptionMetricsModel().formatChanged();
        this.getConsumptionRangeModel().setLimits(0, 10, 1);
        this.getConsumptionRangeModel().setValue(0);
        this.consumptionBarGraphGroup.add(this.getMaxConsumptionMetricsModel());
        this.consumptionBarGraphGroup.add(this.getHalfMaxConsumptionMetricsModel());
        this.consumptionBarGraphGroup.add(this.getConsumptionRangeModel());
        EvoListRow evoListRow = new EvoListRow(0L, 1);
        evoListRow.setInteger(0, 0);
        EvoListRow evoListRow2 = new EvoListRow(1L, 1);
        evoListRow2.setInteger(0, 0);
        this.getBaseListModel(602230).append(evoListRow);
        this.getBaseListModel(602230).append(evoListRow2);
    }

    protected void deinitModels() {
    }

    public String getName() {
        return "Consumer Display";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{38, 46, 3, 2, 39, 37, 41})};
    }

    private ConsumerListHandler getConsumerListHandler() {
        return this.isOldSystem ? this.consumerListOldHandler : this.consumerListHandler;
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCmEViewOptions: %1 ", (Object)(bCmEViewOptions != null ? this.formatViewOptionsLog(bCmEViewOptions.toString()) : "null"));
        }
        if (n == 1 && bCmEViewOptions != null) {
            this.currViewOptions = bCmEViewOptions;
            this.getConsumerListHandler().prepareBCmEListRequestUpdateInfo(bCmEViewOptions);
            this.updateMenuEntryVisibility(bCmEViewOptions);
            this.updateMaxConsumptionMetric(this.currentMaxConsumption.getUnit());
            this.consumptionBarGraphGroup.flush();
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        this.getLogChannel().log(1000000, "updateBCmECurrentRange: %1 ", (Object)(bCmECurrentRange != null ? bCmECurrentRange.toString() : "null"));
        if (n == 1 && bCmECurrentRange != null) {
            this.currentElectricRange = bCmECurrentRange.getRangeValueSecondary();
            this.currentElectricRangeGain = bCmECurrentRange.getRangeGainValueSecondary();
            int n2 = bCmECurrentRange.getRangeUnit() == 0 ? 1 : 2;
            CarDistance carDistance = null;
            CarDistance carDistance2 = null;
            if (this.currentElectricRange > 65533) {
                carDistance = new CarDistance(0.0f, n2);
                this.getChoiceModel(602232).setValue(0);
            } else {
                carDistance = new CarDistance(Math.round(0.1f * (float)this.currentElectricRange), n2);
                this.getChoiceModel(602232).setValue(1);
            }
            carDistance.setUseInstanceUnit(true);
            this.getMetricsModel(602228).setMetric(carDistance);
            if (this.currentElectricRangeGain > 65533) {
                carDistance2 = new CarDistance(0.0f, n2);
                this.getChoiceModel(602231).setValue(0);
            } else if (this.currentElectricRangeGain == 0) {
                carDistance2 = new CarDistance(0.0f, n2);
                this.getChoiceModel(602231).setValue(1);
            } else if (this.currentElectricRangeGain > 0 && this.currentElectricRangeGain < 10) {
                carDistance2 = new CarDistance(1.0f, n2);
                this.getChoiceModel(602231).setValue(2);
            } else {
                carDistance2 = new CarDistance(Math.round(0.1f * (float)this.currentElectricRangeGain), n2);
                this.getChoiceModel(602231).setValue(3);
            }
            carDistance2.setUseInstanceUnit(true);
            this.getMetricsModel(602229).setMetric(carDistance2);
            this.setRangeBaseListModel(this.currentElectricRange, this.currentElectricRangeGain, this.currentElectricRangeCatalogue);
        }
    }

    public void updateBCmECatalogueRange(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "updateBCmECatalogueRange: catalogueRangeElectrical=%1 rangeUnit=%2", (long)n, (long)n2);
        if (n4 == 1) {
            this.currentElectricRangeCatalogue = n;
            this.setRangeBaseListModel(this.currentElectricRange, this.currentElectricRangeGain, this.currentElectricRangeCatalogue);
        }
    }

    private void setRangeBaseListModel(int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        if (this.currViewOptions != null && this.getMenuEntryVisibilityState(this.currViewOptions.getCatalogueRange()) != 1 && this.getMenuEntryVisibilityState(this.currViewOptions.getCurrentRange()) != 1 && n3 <= 65533 && n <= 65533 && n2 <= 65533) {
            n4 = this.getRangePercent(n2, n3);
            n5 = this.getRangePercent(n, n3);
            if (n + n2 > n3) {
                this.getLogChannel().log(1000000, "setRangeBaseListModel: detected range greater than catalogue range!");
                n5 = 100 - n4;
                n5 = n5 < 0 ? 0 : n5;
            }
        }
        this.getLogChannel().log(1000000, "setRangeBaseListModel: setting rangeValuePercent=%1 rangeGainPercent=%2", (long)n5, (long)n4);
        EvoListRow evoListRow = new EvoListRow(0L, 1);
        evoListRow.setInteger(0, n5);
        EvoListRow evoListRow2 = new EvoListRow(1L, 1);
        evoListRow2.setInteger(0, n4);
        this.getBaseListModel(602230).setRow(0, evoListRow);
        this.getBaseListModel(602230).setRow(1, evoListRow2);
        this.getBaseListModel(602230).setSelectedIndex(-1);
    }

    private int getRangePercent(int n, int n2) {
        if (n == 0 || n2 == 0) {
            return 0;
        }
        int n3 = (int)((float)n * 100.0f / (float)n2);
        int n4 = n3 = n3 > 100 ? 100 : n3;
        if (n3 < 4) {
            return 4;
        }
        return n3;
    }

    public void updateBCmEConsumption(int n, int n2, int n3, int n4) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCmEConsumption: consumptionValue='%1' , maxConsuptionValue='%2' , consumptionUnit='%3' , validFlag='%4'", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (long)n4);
        }
        if (n4 == 1) {
            int n5 = this.convertConsumptionValue(n);
            int n6 = this.convertConsumptionValue(n2);
            if (n5 == -1 || n6 == -1) {
                n5 = -1;
                n6 = -1;
            }
            this.setCurrentConsumptionValue(n5);
            this.convertedMaxConsumption = n6;
            this.updateConsumptionBarGraph(n6, n5);
            this.updateMaxConsumptionMetric(this.mapDSIConsumptionUnitToHMIUnit(n3));
            this.getConsumptionBarGraphGroup().flush();
            this.updateMenuEntryVisibility(this.currViewOptions);
        }
    }

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCmEListUpdateInfo: %1 ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        }
        if (n == 1 && bCmEListUpdateInfo != null) {
            this.getConsumerListHandler().updateConsumerListUpdateInfo(bCmEListUpdateInfo);
        }
    }

    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "responseBCmEConsumerList: listUpdateInfo='%1' ", (Object)bCmEListUpdateInfo.toString());
        }
        if (bCmEConsumerListArray != null) {
            this.getConsumerListHandler().responseConsumerList(bCmEListUpdateInfo, bCmEConsumerListArray);
        } else {
            this.getLogChannel().log(100000, "responseBCmEConsumerList: updated data is NULL!");
        }
    }

    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCmEConsumerListTotalNumberOfElements: totalNumListElements='%1' , validFlag='%2'", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.getConsumerListHandler().setTotalNrOfConsumers(n);
        }
    }

    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.getLogChannel().log(1000000, "updateBCmEConsumerListRangeUpdateInfo: %1 ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        if (n == 1 && bCmEListUpdateInfo != null) {
            this.getConsumerListHandler().updateConsumerListUpdateInfo(bCmEListUpdateInfo);
        }
    }

    public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
        this.getLogChannel().log(1000000, "updateBCmEConsumerListRangeTotalNumberOfElements: totalNumListElements='%1' , validFlag='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.getConsumerListHandler().setTotalNrOfConsumers(n);
        }
    }

    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        this.getLogChannel().log(1000000, "responseBCmEConsumerListRangeRA0: listUpdateInfo='%1' ", (Object)bCmEListUpdateInfo.toString());
        if (bCmEConsumerListRangeRA0Array != null) {
            this.getConsumerListHandler().responseConsumerList(bCmEListUpdateInfo, bCmEConsumerListRangeRA0Array);
        } else {
            this.getLogChannel().log(100000, "responseBCmEConsumerListRangeRA0: updated data is NULL!");
        }
    }

    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        this.getLogChannel().log(1000000, "responseBCmEConsumerListRangeRA2: listUpdateInfo='%1' ", (Object)bCmEListUpdateInfo.toString());
        if (bCmEConsumerListRangeRA2Array != null) {
            this.getConsumerListHandler().responseConsumerList(bCmEListUpdateInfo, bCmEConsumerListRangeRA2Array);
        } else {
            this.getLogChannel().log(100000, "responseBCmEConsumerListRangeRA2: updated data is NULL!");
        }
    }

    private void updateConsumptionBarGraph(int n, int n2) {
        this.getLogChannel().log(1000000, "updateConsumptionBarGraph: set RangeModel('%1'):  maxConsumption='%2' , consumption='%3'", (long)this.getConsumptionRangeModel().getID(), (long)n, (long)n2);
        this.getConsumptionRangeModel().setLimits(0, n, 1, n / 2);
        this.getConsumptionRangeModel().setValue(n2);
    }

    private void updateMaxConsumptionMetric(int n) {
        float f2 = -1.0f;
        if (this.convertedMaxConsumption > 0 && !this.isConsumptionDisabledByVO()) {
            f2 = this.convertedMaxConsumption / 100;
        }
        if (this.getCurrentMaxConsumption().getValue(this.getCurrentMaxConsumption().getUnit()) != f2 || this.getCurrentMaxConsumption().getUnit() != n) {
            this.setCurrentMaxConsumptionMetric(f2, n);
            this.getLogChannel().log(1000000, "updateMaxConsumptionMetric: modelID='%1' , maxConsumptionValue='%2' , maxConsumptionUnit='%3'", (double)this.getMaxConsumptionMetricsModel().getID(), (double)this.getCurrentMaxConsumption().getValue(this.getCurrentMaxConsumption().getUnit()), (double)this.getCurrentMaxConsumption().getUnit());
            this.getMaxConsumptionMetricsModel().setMetric(this.getCurrentMaxConsumption());
            this.getMaxConsumptionMetricsModel().formatChanged();
            this.getHalfMaxConsumptionMetricsModel().setMetric(new CarBCmEConsumption(f2 == -1.0f ? f2 : f2 / 2.0f, n));
            this.getMaxConsumptionMetricsModel().formatChanged();
        }
    }

    private boolean isConsumptionDisabledByVO() {
        if (this.currViewOptions != null && this.currViewOptions.getConsumption() != null) {
            return this.currViewOptions.getConsumption().getState() != 2;
        }
        return true;
    }

    private void setCurrentMaxConsumptionMetric(float f2, int n) {
        this.setCurrentMaxConsumption(new CarBCmEConsumption(f2, n));
        this.getCurrentMaxConsumption().setUseInstanceUnit(true);
    }

    private int mapDSIConsumptionUnitToHMIUnit(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "mapDSIConsumptionUnitToHMIUnit: dsiConsumptionUnit='%1'", (long)n);
        }
        if (n == 5) {
            return 10;
        }
        if (n == 8) {
            return 11;
        }
        if (n == 22) {
            return 12;
        }
        if (n == 2) {
            return 9;
        }
        return 9;
    }

    private int convertConsumptionValue(int n) {
        if (n > 0 && n != 65535) {
            return Math.round((float)n / 10.0f);
        }
        return -1;
    }

    private int getCurrentConsumptionValue() {
        return this.currentConsumptionValue;
    }

    private void setCurrentConsumptionValue(int n) {
        this.currentConsumptionValue = n;
    }

    private CarBCmEConsumption getCurrentMaxConsumption() {
        return this.currentMaxConsumption;
    }

    private void setCurrentMaxConsumption(CarBCmEConsumption carBCmEConsumption) {
        this.currentMaxConsumption = carBCmEConsumption;
    }

    private MetricsModelApp getMaxConsumptionMetricsModel() {
        return this.maxConsumptionMetricsModel;
    }

    private MetricsModelApp getHalfMaxConsumptionMetricsModel() {
        return this.halfMaxConsumptionMetricsModel;
    }

    protected boolean isCurrentConsumptionInvalid() {
        return this.getCurrentConsumptionValue() == -1;
    }

    private ModelGroup getConsumptionBarGraphGroup() {
        return this.consumptionBarGraphGroup;
    }

    private RangeModelApp getConsumptionRangeModel() {
        return this.consumptionRange;
    }

    public void requestConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, String string) {
        this.getLogChannel().log(1000000, "%1: dsi.requestBCmEConsumerListRange('%2')", (Object)string, (Object)bCmEListUpdateInfo.toString());
        if (this.isOldSystem) {
            this.getDSI().requestBCmEConsumerList(bCmEListUpdateInfo);
        } else {
            this.getDSI().requestBCmEConsumerListRange(bCmEListUpdateInfo);
        }
    }

    public boolean isConsumerListInvisible(BCmEViewOptions bCmEViewOptions) {
        return this.getMenuEntryVisibilityState(bCmEViewOptions.getConsumerListRange()) == 1;
    }

    protected boolean isConsumerListRequestBlocked() {
        return this.getConsumerListHandler().isConsumerListRequestBlocked();
    }

    protected abstract void updateMenuEntryVisibility(BCmEViewOptions var1);

    protected abstract int getMaxNrDisplayableConsumers();
}

