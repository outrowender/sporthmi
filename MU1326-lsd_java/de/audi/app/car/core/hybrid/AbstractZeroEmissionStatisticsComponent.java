/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent$1;
import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent$SDISInterface;
import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent$ZeroEmissionStatisticsSubComponentHybrid;
import de.audi.app.car.core.hybrid.IMemoryBuffer;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.app.car.core.hybrid.StatisticsMemoryBuffer;
import de.audi.app.car.core.hybrid.StatisticsZeroEmissionEntry;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.car.Car2XObjectCollection$CarZeroEmissionEntry;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCTime;

public abstract class AbstractZeroEmissionStatisticsComponent
extends AbstractDSICarKombiAdapter {
    public static final short[] CODING_IDS = new short[]{24, 41};
    private static final String LOGCHANNEL_NAME;
    private static final String BUFFER_NAME;
    private static final long ZERO_EMISSION_UPDATE_RATE;
    private static final long ZERO_EMISSION_INTERVAL_TIMEFRAME;
    private static final int MIN_TIME;
    private static final int MAX_TIME;
    private static final float MIN_CONSUMPTION;
    private static final float MAX_CONSUMPTION;
    private static final int BARGRAPH_MODEL_COLUMN_VALUE;
    private static final int BARGRAPH_MODEL_COLUMN_STATE;
    private final AbstractZeroEmissionStatisticsComponent$ZeroEmissionStatisticsSubComponentHybrid subComponentHybrid;
    protected final Object mutex = new Object();
    protected AbstractZeroEmissionStatisticsComponent$SDISInterface sdisInterface;
    protected volatile BCViewOptions currentBCViewOptions;
    protected volatile HybridViewOptions currentHybridViewOptions;
    protected volatile HybridEnergyFlowState currentEnergyFlowState;
    protected StatisticsZeroEmissionEntry currentZeroEmissionInterval;
    protected IMemoryBuffer zeroEmissionHistoryBuffer;
    private Consumption metricAverageConsumption1;
    private Consumption metricAverageConsumption2;
    private DateMetric metricZeroEmissionTime;
    private DateMetric metricResetTimeStamp;
    private BaseListModelApp hZEScBarGraphModel;
    private BaseListModelApp hZESxBarGraphModel;
    private MetricsModelApp hZESAverageConsumptionModel1;
    private MetricsModelApp hZESAverageConsumptionModel2;
    private MetricsModelApp hZESZeroEmissionTimeModel;
    private MetricsModelApp hZESResetTimeStampModel;
    private final Timer zeroEmissionTimer = new Timer("ZeroEmissionStatisticsTmer", 0, false, new AbstractZeroEmissionStatisticsComponent$1(this));

    public AbstractZeroEmissionStatisticsComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Hybrid.Statistics");
        this.subComponentHybrid = new AbstractZeroEmissionStatisticsComponent$ZeroEmissionStatisticsSubComponentHybrid(this, iCarApplication);
        this.currentZeroEmissionInterval = new StatisticsZeroEmissionEntry();
        this.zeroEmissionHistoryBuffer = new StatisticsMemoryBuffer("ZeroEmissionBuffer");
    }

    private boolean isEnergyFlowStateAvailable() {
        return null != this.currentEnergyFlowState;
    }

    private boolean isEngineZeroEmission() {
        if (this.isEnergyFlowStateAvailable()) {
            boolean bl = 2 != this.currentEnergyFlowState.getEe1State() && 2 == this.currentEnergyFlowState.getICEState();
            return bl;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void resetZeroEmissionStatistics() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#resetZeroEmissionStatistics] called.");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.zeroEmissionTimer.cancel();
            this.currentZeroEmissionInterval = new StatisticsZeroEmissionEntry();
            if (this.zeroEmissionHistoryBuffer.isInitialized()) {
                this.zeroEmissionHistoryBuffer.reset();
            }
            this.resetBarGraphModels();
            this.zeroEmissionTimer.restart();
        }
    }

    private IMemoryBuffer initBuffer(IMemoryBuffer iMemoryBuffer, int n) {
        boolean bl;
        if (null != iMemoryBuffer && 0 < n) {
            if (!iMemoryBuffer.isInitialized()) {
                bl = iMemoryBuffer.init(2, n);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractZeroEmissionStatisticsComponent#initBuffer] Buffer (%1) already initialized!", (Object)iMemoryBuffer.getName());
                if (iMemoryBuffer.maxSize() == n) {
                    bl = iMemoryBuffer.reset();
                } else {
                    String string = iMemoryBuffer.getName();
                    iMemoryBuffer = new StatisticsMemoryBuffer(string);
                    bl = iMemoryBuffer.init(2, n);
                }
            }
        } else {
            iMemoryBuffer = new StatisticsMemoryBuffer("ZeroEmissionBuffer");
            bl = iMemoryBuffer.init(2, n);
        }
        if (bl) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#initBuffer] Buffer (%1) initialized.", (Object)iMemoryBuffer.getName());
        } else {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#initSTSBuffer] Buffer (%1) not initialized.", (Object)iMemoryBuffer.getName());
        }
        return iMemoryBuffer;
    }

    private synchronized void updateStatisticsCurrentIntervalZE(double d2) {
        this.currentZeroEmissionInterval.setZeroEmissionValue(d2);
        this.currentZeroEmissionInterval.setZeroEmissionState(1);
        this.setBarGraphCurrentModels(this.currentZeroEmissionInterval);
    }

    private synchronized void swapStatisticsCurrentIntervalZE() {
        this.zeroEmissionHistoryBuffer.enqueue(this.currentZeroEmissionInterval);
        this.currentZeroEmissionInterval = new StatisticsZeroEmissionEntry();
        this.setBarGraphCurrentModels(this.currentZeroEmissionInterval);
        this.setBarGraphHistoryModels(this.zeroEmissionHistoryBuffer.toArray(), this.zeroEmissionHistoryBuffer.size());
    }

    private void setBarGraphCurrentModels(StatisticsZeroEmissionEntry statisticsZeroEmissionEntry) {
        if (null != statisticsZeroEmissionEntry) {
            this.hZEScBarGraphModel.setStatus(0);
            EvoListRow evoListRow = this.getZeroEmissionBarGraphListRow(statisticsZeroEmissionEntry.getZeroEmissionValue(), statisticsZeroEmissionEntry.getZeroEmissionState());
            this.hZEScBarGraphModel.setRow(0, evoListRow);
            this.hZEScBarGraphModel.setStatus(1);
        }
        if (this.isSDISSupported() && null != this.sdisInterface) {
            this.sdisInterface.sendCurrentBarGraphUpdate(this.convertBarGraphModelToSDISEntry(this.hZEScBarGraphModel)[0]);
        }
    }

    private void setBarGraphHistoryModels(IMemoryBufferEntry[] iMemoryBufferEntryArray, int n) {
        if (null != iMemoryBufferEntryArray && iMemoryBufferEntryArray.length >= n) {
            this.hZESxBarGraphModel.setStatus(0);
            int n2 = 0;
            int n3 = n - 1;
            while (n2 < iMemoryBufferEntryArray.length) {
                EvoListRow evoListRow = new EvoListRow(-1L, 2);
                evoListRow.setLong(0, 0L);
                evoListRow.setInteger(1, 0);
                if (n2 + 1 <= n) {
                    IMemoryBufferEntry iMemoryBufferEntry = iMemoryBufferEntryArray[n2];
                    if (iMemoryBufferEntry instanceof StatisticsZeroEmissionEntry) {
                        evoListRow = this.getZeroEmissionBarGraphListRow(((StatisticsZeroEmissionEntry)iMemoryBufferEntry).getZeroEmissionValue(), ((StatisticsZeroEmissionEntry)iMemoryBufferEntry).getZeroEmissionState());
                    }
                    this.hZESxBarGraphModel.setRow(n3, evoListRow);
                } else {
                    this.hZESxBarGraphModel.setRow(n2, evoListRow);
                }
                ++n2;
                --n3;
            }
            this.hZESxBarGraphModel.setStatus(1);
        }
        if (this.isSDISSupported() && null != this.sdisInterface) {
            this.sdisInterface.sendHistoryBarGraphUpdate(this.convertBarGraphModelToSDISEntry(this.hZESxBarGraphModel));
        }
    }

    private void resetBarGraphModels() {
        EvoListRow evoListRow = new EvoListRow(-1L, 2);
        evoListRow.setLong(0, 0L);
        evoListRow.setInteger(1, 0);
        this.hZEScBarGraphModel.setStatus(0);
        this.hZESxBarGraphModel.setStatus(0);
        this.hZEScBarGraphModel.setRow(0, evoListRow);
        for (int i2 = 0; i2 < this.hZESxBarGraphModel.getLength(); ++i2) {
            this.hZESxBarGraphModel.setRow(i2, evoListRow);
        }
        this.hZESxBarGraphModel.setStatus(1);
        this.hZEScBarGraphModel.setStatus(1);
        if (this.isSDISSupported() && null != this.sdisInterface) {
            this.sdisInterface.sendCurrentBarGraphUpdate(this.convertBarGraphModelToSDISEntry(this.hZEScBarGraphModel)[0]);
            this.sdisInterface.sendHistoryBarGraphUpdate(this.convertBarGraphModelToSDISEntry(this.hZESxBarGraphModel));
        }
    }

    private String getViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master (Bord Computer): ");
        buffer.append(null == this.currentBCViewOptions ? "No bord computer view options received yet" : this.currentBCViewOptions.toString());
        buffer.append("\n");
        buffer.append("Sub-Component Hybrid: ");
        buffer.append(null == this.currentHybridViewOptions ? "No hybrid view options received yet" : this.currentHybridViewOptions.toString());
        return buffer.toString();
    }

    @Override
    public String getName() {
        return "ZeroEmissionStatistics";
    }

    @Override
    public String getCurrentViewOptions() {
        return this.getViewOptions();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{11, 12, 71, 77})};
    }

    @Override
    public void init() {
        super.init();
        this.subComponentHybrid.init();
        this.zeroEmissionHistoryBuffer = this.initBuffer(this.zeroEmissionHistoryBuffer, this.getNumOfHistoricalIntervals());
        this.zeroEmissionTimer.restart();
        if (this.isSDISSupported()) {
            this.sdisInterface = new AbstractZeroEmissionStatisticsComponent$SDISInterface(this);
            this.sendContentToSDIS(4200, this.sdisInterface);
        }
    }

    @Override
    public void deinit() {
        this.sdisInterface = null;
        this.zeroEmissionTimer.cancel();
        this.subComponentHybrid.deinit();
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.subComponentHybrid.initModels();
        this.metricAverageConsumption1 = new Consumption(0.0f, Consumption.getSystemUnit());
        this.metricAverageConsumption1.setZeroValueFormat(1);
        this.metricAverageConsumption1.setNumberOfMajorPlacesMax(2);
        this.metricAverageConsumption1.setUseInstanceUnit(true);
        this.metricAverageConsumption1.setMetricValid(false);
        this.metricAverageConsumption2 = new Consumption(0.0f, Consumption.getSystemUnit());
        this.metricAverageConsumption2.setZeroValueFormat(1);
        this.metricAverageConsumption2.setNumberOfMajorPlacesMax(2);
        this.metricAverageConsumption2.setUseInstanceUnit(true);
        this.metricAverageConsumption2.setMetricValid(false);
        this.metricZeroEmissionTime = new DateMetric(new Date(), 3);
        this.metricZeroEmissionTime.setMetricValid(false);
        this.metricResetTimeStamp = new DateMetric(new Date(), 1);
        this.metricResetTimeStamp.setMetricValid(false);
        this.hZEScBarGraphModel = this.getBaseListModel(-1104213760);
        this.hZEScBarGraphModel.setLength(1);
        this.hZESxBarGraphModel = this.getBaseListModel(640747776);
        this.hZESxBarGraphModel.setLength(this.getNumOfHistoricalIntervals());
        this.hZESAverageConsumptionModel1 = this.getMetricsModel(-986773248);
        this.hZESAverageConsumptionModel2 = this.getMetricsModel(-63960832);
        this.hZESZeroEmissionTimeModel = this.getMetricsModel(623970560);
        this.hZESResetTimeStampModel = this.getMetricsModel(506530048);
    }

    @Override
    protected void deinitModels() {
        this.subComponentHybrid.deinitModels();
    }

    protected abstract void updateMenuEntryVisibility() {
    }

    protected abstract int getNumOfHistoricalIntervals() {
    }

    protected abstract int getSubComponentHybridID() {
    }

    protected abstract boolean isSDISSupported() {
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#updateBCViewOptions] viewOptions='%1', valid='%2'", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
            }
            if (1 == n && bCViewOptions != null) {
                this.currentBCViewOptions = bCViewOptions;
                this.updateMenuEntryVisibility();
                this.primaryAttributeFirstSetReceived();
            }
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#updateBCShortTermAverageConsumption1] averageConsumption=%1, validFlag='%2'", (Object)(null == carBCConsumption ? "null" : carBCConsumption.toString()), (long)n);
        }
        if (1 == n && null != carBCConsumption) {
            float f2 = carBCConsumption.getConsumptionValue();
            int n2 = this.convertConsumptionUnit(carBCConsumption.getConsumptionUnit());
            this.metricAverageConsumption1 = new Consumption(f2, n2);
            this.metricAverageConsumption1.setMetricValid(12602437 > f2 && 12602565 < f2);
            this.metricAverageConsumption1.setZeroValueFormat(1);
            this.metricAverageConsumption1.setNumberOfMajorPlacesMax(2);
            this.metricAverageConsumption1.setUseInstanceUnit(true);
            this.hZESAverageConsumptionModel1.setMetric(this.metricAverageConsumption1);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#updateBCShortTermAverageConsumption2] averageConsumption=%1, validFlag='%2'", (Object)(null == carBCConsumption ? "null" : carBCConsumption.toString()), (long)n);
        }
        if (1 == n && null != carBCConsumption) {
            float f2 = carBCConsumption.getConsumptionValue();
            int n2 = this.convertConsumptionUnit(carBCConsumption.getConsumptionUnit());
            this.metricAverageConsumption2 = new Consumption(f2, n2);
            this.metricAverageConsumption2.setMetricValid(12602437 > f2 && 12602565 < f2);
            this.metricAverageConsumption2.setZeroValueFormat(1);
            this.metricAverageConsumption2.setNumberOfMajorPlacesMax(2);
            this.metricAverageConsumption2.setUseInstanceUnit(true);
            this.hZESAverageConsumptionModel2.setMetric(this.metricAverageConsumption2);
        }
    }

    @Override
    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#updateBCZeroEmissionTimeST] time=%1, validFlag='%2'", (Object)(null == carBCTime ? "null" : carBCTime.toString()), (long)n);
        }
        if (1 == n && null != carBCTime) {
            int n2 = carBCTime.getTimeValue();
            Calendar calendar = Calendar.getInstance();
            long l = n2 * 60 * 1000;
            calendar.setTimeInMillis(l);
            this.metricZeroEmissionTime = new DateMetric(calendar.getTime(), 3);
            this.metricZeroEmissionTime.setDateValid(-1071183616 > n2 && 0 < n2);
            this.hZESZeroEmissionTimeModel.setMetric(this.metricZeroEmissionTime);
        }
    }

    @Override
    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractZeroEmissionStatisticsComponent#updateBCResetTimeStampST] timeStamp=%1, validFlag='%2'", (Object)(null == bCResetTimeStamp ? "null" : bCResetTimeStamp.toString()), (long)n);
        }
        if (1 == n && null != bCResetTimeStamp) {
            this.resetZeroEmissionStatistics();
            Calendar calendar = Calendar.getInstance();
            calendar.set(bCResetTimeStamp.getYear(), bCResetTimeStamp.getMonth(), bCResetTimeStamp.getDay(), bCResetTimeStamp.getHours(), bCResetTimeStamp.getMinutes());
            this.metricResetTimeStamp = new DateMetric(calendar.getTime(), 1);
            this.hZESResetTimeStampModel.setMetric(this.metricResetTimeStamp);
        }
    }

    private EvoListRow getZeroEmissionBarGraphListRow(double d2, int n) {
        double d3 = Math.round(1000.0 * (d2 / 300000.0));
        d3 = 0.0 > d3 ? 0.0 : (1000.0 < d3 ? 1000.0 : d3);
        EvoListRow evoListRow = new EvoListRow(-1L, 2);
        evoListRow.setLong(0, (long)d3);
        evoListRow.setInteger(1, n);
        return evoListRow;
    }

    private int convertConsumptionUnit(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 18: {
                return 6;
            }
            case 20: {
                return 5;
            }
            case 19: {
                return 7;
            }
            case 21: {
                return 8;
            }
            case 2: {
                return 9;
            }
            case 5: {
                return 10;
            }
            case 8: {
                return 11;
            }
            case 22: {
                return 12;
            }
        }
        this.getLogChannel().log(10000, "[AbstractZeroEmissionStatisticsComponent#convertConsumptionUnit] unsupported unit: %1", (long)n);
        return 1;
    }

    private Car2XObjectCollection$CarZeroEmissionEntry[] convertBarGraphModelToSDISEntry(BaseListModelApp baseListModelApp) {
        int n = baseListModelApp.getLength();
        Car2XObjectCollection$CarZeroEmissionEntry[] car2XObjectCollection$CarZeroEmissionEntryArray = new Car2XObjectCollection$CarZeroEmissionEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            long l = baseListModelApp.getRow(i2).getLong(0);
            int n2 = baseListModelApp.getRow(i2).getInteger(1);
            car2XObjectCollection$CarZeroEmissionEntryArray[i2] = new Car2XObjectCollection$CarZeroEmissionEntry();
            car2XObjectCollection$CarZeroEmissionEntryArray[i2].setValues(new short[]{(short)l});
            car2XObjectCollection$CarZeroEmissionEntryArray[i2].setState((byte)n2);
        }
        return car2XObjectCollection$CarZeroEmissionEntryArray;
    }

    static /* synthetic */ void access$000(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent, int n, Object object) {
        abstractZeroEmissionStatisticsComponent.sendContentToSDIS(n, object);
    }

    static /* synthetic */ void access$100(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent, int n, Object object) {
        abstractZeroEmissionStatisticsComponent.sendContentToSDIS(n, object);
    }

    static /* synthetic */ void access$200(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent, int n, Object object) {
        abstractZeroEmissionStatisticsComponent.sendContentToSDIS(n, object);
    }

    static /* synthetic */ String access$300(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        return abstractZeroEmissionStatisticsComponent.getViewOptions();
    }

    static /* synthetic */ Timer access$400(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        return abstractZeroEmissionStatisticsComponent.zeroEmissionTimer;
    }

    static /* synthetic */ boolean access$500(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        return abstractZeroEmissionStatisticsComponent.isEngineZeroEmission();
    }

    static /* synthetic */ void access$600(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent, double d2) {
        abstractZeroEmissionStatisticsComponent.updateStatisticsCurrentIntervalZE(d2);
    }

    static /* synthetic */ void access$700(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        abstractZeroEmissionStatisticsComponent.swapStatisticsCurrentIntervalZE();
    }
}

