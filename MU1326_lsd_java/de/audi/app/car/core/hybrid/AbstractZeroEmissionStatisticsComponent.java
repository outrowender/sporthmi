/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.sdis.interapp.ISDISZeroEmissionAccess;
import de.audi.app.car.core.hybrid.IMemoryBuffer;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.app.car.core.hybrid.StatisticsMemoryBuffer;
import de.audi.app.car.core.hybrid.StatisticsZeroEmissionEntry;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.car.Car2XObjectCollection;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCTime;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractZeroEmissionStatisticsComponent
extends AbstractDSICarKombiAdapter {
    public static final short[] CODING_IDS = new short[]{24, 41};
    private static final String LOGCHANNEL_NAME = "App.Car.Hybrid.Statistics";
    private static final String BUFFER_NAME = "ZeroEmissionBuffer";
    private static final long ZERO_EMISSION_UPDATE_RATE = 1000L;
    private static final long ZERO_EMISSION_INTERVAL_TIMEFRAME = 300000L;
    private static final int MIN_TIME = 0;
    private static final int MAX_TIME = 600000;
    private static final float MIN_CONSUMPTION = -3276.0f;
    private static final float MAX_CONSUMPTION = 3276.0f;
    private static final int BARGRAPH_MODEL_COLUMN_VALUE = 0;
    private static final int BARGRAPH_MODEL_COLUMN_STATE = 1;
    private final ZeroEmissionStatisticsSubComponentHybrid subComponentHybrid;
    protected final Object mutex = new Object();
    protected SDISInterface sdisInterface;
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
    private final Timer zeroEmissionTimer = new Timer("ZeroEmissionStatisticsTmer", 1000L, false, new TimerListener(){
        private long intervalTimeCounter;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            if (timer.equals(AbstractZeroEmissionStatisticsComponent.this.zeroEmissionTimer)) {
                Object object = AbstractZeroEmissionStatisticsComponent.this.mutex;
                synchronized (object) {
                    this.intervalTimeCounter += 1000L;
                    if (AbstractZeroEmissionStatisticsComponent.this.isEngineZeroEmission()) {
                        double d2 = AbstractZeroEmissionStatisticsComponent.this.currentZeroEmissionInterval.getZeroEmissionValue() + 1000.0;
                        AbstractZeroEmissionStatisticsComponent.this.updateStatisticsCurrentIntervalZE(d2);
                    }
                    if (300000L <= this.intervalTimeCounter) {
                        AbstractZeroEmissionStatisticsComponent.this.swapStatisticsCurrentIntervalZE();
                        this.intervalTimeCounter = 0L;
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void cancelTimer(Timer timer) {
            if (timer.equals(AbstractZeroEmissionStatisticsComponent.this.zeroEmissionTimer)) {
                Object object = AbstractZeroEmissionStatisticsComponent.this.mutex;
                synchronized (object) {
                    this.intervalTimeCounter = 0L;
                }
            }
        }
    });

    public AbstractZeroEmissionStatisticsComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.subComponentHybrid = new ZeroEmissionStatisticsSubComponentHybrid(iCarApplication);
        this.currentZeroEmissionInterval = new StatisticsZeroEmissionEntry();
        this.zeroEmissionHistoryBuffer = new StatisticsMemoryBuffer(BUFFER_NAME);
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
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#resetZeroEmissionStatistics] called.");
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
                this.getLogChannel().log(10000000, "[AbstractZeroEmissionStatisticsComponent#initBuffer] Buffer (%1) already initialized!", (Object)iMemoryBuffer.getName());
                if (iMemoryBuffer.maxSize() == n) {
                    bl = iMemoryBuffer.reset();
                } else {
                    String string = iMemoryBuffer.getName();
                    iMemoryBuffer = new StatisticsMemoryBuffer(string);
                    bl = iMemoryBuffer.init(2, n);
                }
            }
        } else {
            iMemoryBuffer = new StatisticsMemoryBuffer(BUFFER_NAME);
            bl = iMemoryBuffer.init(2, n);
        }
        if (bl) {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#initBuffer] Buffer (%1) initialized.", (Object)iMemoryBuffer.getName());
        } else {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#initSTSBuffer] Buffer (%1) not initialized.", (Object)iMemoryBuffer.getName());
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

    public String getName() {
        return "ZeroEmissionStatistics";
    }

    public String getCurrentViewOptions() {
        return this.getViewOptions();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{11, 12, 71, 77})};
    }

    public void init() {
        super.init();
        this.subComponentHybrid.init();
        this.zeroEmissionHistoryBuffer = this.initBuffer(this.zeroEmissionHistoryBuffer, this.getNumOfHistoricalIntervals());
        this.zeroEmissionTimer.restart();
        if (this.isSDISSupported()) {
            this.sdisInterface = new SDISInterface();
            this.sendContentToSDIS(4200, this.sdisInterface);
        }
    }

    public void deinit() {
        this.sdisInterface = null;
        this.zeroEmissionTimer.cancel();
        this.subComponentHybrid.deinit();
        super.deinit();
    }

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
        this.hZEScBarGraphModel = this.getBaseListModel(602046);
        this.hZEScBarGraphModel.setLength(1);
        this.hZESxBarGraphModel = this.getBaseListModel(602406);
        this.hZESxBarGraphModel.setLength(this.getNumOfHistoricalIntervals());
        this.hZESAverageConsumptionModel1 = this.getMetricsModel(602053);
        this.hZESAverageConsumptionModel2 = this.getMetricsModel(602364);
        this.hZESZeroEmissionTimeModel = this.getMetricsModel(602405);
        this.hZESResetTimeStampModel = this.getMetricsModel(602398);
    }

    protected void deinitModels() {
        this.subComponentHybrid.deinitModels();
    }

    protected abstract void updateMenuEntryVisibility();

    protected abstract int getNumOfHistoricalIntervals();

    protected abstract int getSubComponentHybridID();

    protected abstract boolean isSDISSupported();

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#updateBCViewOptions] viewOptions='%1', valid='%2'", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
            }
            if (1 == n && bCViewOptions != null) {
                this.currentBCViewOptions = bCViewOptions;
                this.updateMenuEntryVisibility();
                this.primaryAttributeFirstSetReceived();
            }
        }
    }

    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#updateBCShortTermAverageConsumption1] averageConsumption=%1, validFlag='%2'", (Object)(null == carBCConsumption ? "null" : carBCConsumption.toString()), (long)n);
        }
        if (1 == n && null != carBCConsumption) {
            float f2 = carBCConsumption.getConsumptionValue();
            int n2 = this.convertConsumptionUnit(carBCConsumption.getConsumptionUnit());
            this.metricAverageConsumption1 = new Consumption(f2, n2);
            this.metricAverageConsumption1.setMetricValid(3276.0f > f2 && -3276.0f < f2);
            this.metricAverageConsumption1.setZeroValueFormat(1);
            this.metricAverageConsumption1.setNumberOfMajorPlacesMax(2);
            this.metricAverageConsumption1.setUseInstanceUnit(true);
            this.hZESAverageConsumptionModel1.setMetric(this.metricAverageConsumption1);
        }
    }

    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#updateBCShortTermAverageConsumption2] averageConsumption=%1, validFlag='%2'", (Object)(null == carBCConsumption ? "null" : carBCConsumption.toString()), (long)n);
        }
        if (1 == n && null != carBCConsumption) {
            float f2 = carBCConsumption.getConsumptionValue();
            int n2 = this.convertConsumptionUnit(carBCConsumption.getConsumptionUnit());
            this.metricAverageConsumption2 = new Consumption(f2, n2);
            this.metricAverageConsumption2.setMetricValid(3276.0f > f2 && -3276.0f < f2);
            this.metricAverageConsumption2.setZeroValueFormat(1);
            this.metricAverageConsumption2.setNumberOfMajorPlacesMax(2);
            this.metricAverageConsumption2.setUseInstanceUnit(true);
            this.hZESAverageConsumptionModel2.setMetric(this.metricAverageConsumption2);
        }
    }

    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#updateBCZeroEmissionTimeST] time=%1, validFlag='%2'", (Object)(null == carBCTime ? "null" : carBCTime.toString()), (long)n);
        }
        if (1 == n && null != carBCTime) {
            int n2 = carBCTime.getTimeValue();
            Calendar calendar = Calendar.getInstance();
            long l = n2 * 60 * 1000;
            calendar.setTimeInMillis(l);
            this.metricZeroEmissionTime = new DateMetric(calendar.getTime(), 3);
            this.metricZeroEmissionTime.setDateValid(600000 > n2 && 0 < n2);
            this.hZESZeroEmissionTimeModel.setMetric(this.metricZeroEmissionTime);
        }
    }

    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractZeroEmissionStatisticsComponent#updateBCResetTimeStampST] timeStamp=%1, validFlag='%2'", (Object)(null == bCResetTimeStamp ? "null" : bCResetTimeStamp.toString()), (long)n);
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

    private Car2XObjectCollection.CarZeroEmissionEntry[] convertBarGraphModelToSDISEntry(BaseListModelApp baseListModelApp) {
        int n = baseListModelApp.getLength();
        Car2XObjectCollection.CarZeroEmissionEntry[] carZeroEmissionEntryArray = new Car2XObjectCollection.CarZeroEmissionEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            long l = baseListModelApp.getRow(i2).getLong(0);
            int n2 = baseListModelApp.getRow(i2).getInteger(1);
            carZeroEmissionEntryArray[i2] = new Car2XObjectCollection.CarZeroEmissionEntry();
            carZeroEmissionEntryArray[i2].setValues(new short[]{(short)l});
            carZeroEmissionEntryArray[i2].setState((byte)n2);
        }
        return carZeroEmissionEntryArray;
    }

    public class SDISInterface
    implements ISDISZeroEmissionAccess {
        public void sendVisibilityStates(CarViewOption carViewOption) {
            if (null != carViewOption) {
                AbstractZeroEmissionStatisticsComponent.this.sendContentToSDIS(102, carViewOption);
            }
        }

        public void sendCurrentBarGraphUpdate(Car2XObjectCollection.CarZeroEmissionEntry carZeroEmissionEntry) {
            if (null != carZeroEmissionEntry) {
                AbstractZeroEmissionStatisticsComponent.this.sendContentToSDIS(4201, carZeroEmissionEntry);
            }
        }

        public void sendHistoryBarGraphUpdate(Car2XObjectCollection.CarZeroEmissionEntry[] carZeroEmissionEntryArray) {
            if (null != carZeroEmissionEntryArray) {
                AbstractZeroEmissionStatisticsComponent.this.sendContentToSDIS(4202, carZeroEmissionEntryArray);
            }
        }
    }

    public class ZeroEmissionStatisticsSubComponentHybrid
    extends AbstractDSICarHybridAdapter {
        public ZeroEmissionStatisticsSubComponentHybrid(ICarApplication iCarApplication) {
            super(iCarApplication, AbstractZeroEmissionStatisticsComponent.LOGCHANNEL_NAME);
        }

        public String getName() {
            return "ZeroEmissionStatistics | Hybrid";
        }

        public CarDSIAttributesSet[] getDSIAttributesSets() {
            return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{3})};
        }

        public String getCurrentViewOptions() {
            return AbstractZeroEmissionStatisticsComponent.this.getViewOptions();
        }

        protected void initModels() {
        }

        protected void deinitModels() {
        }

        protected void initVisibility() {
        }

        protected void deinitVisibility() {
        }

        public int getID() {
            return AbstractZeroEmissionStatisticsComponent.this.getSubComponentHybridID();
        }

        public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[ZeroEmissionStatisticsSubComponentHybrid#updateHybridViewOptions] viewOptions='%1', valid='%2'", (Object)(hybridViewOptions != null ? this.formatViewOptionsLog(hybridViewOptions.toString()) : "null"), (long)n);
            }
            if (1 == n && null != hybridViewOptions) {
                AbstractZeroEmissionStatisticsComponent.this.currentHybridViewOptions = hybridViewOptions;
                AbstractZeroEmissionStatisticsComponent.this.updateMenuEntryVisibility();
                this.primaryAttributeFirstSetReceived();
                if (AbstractZeroEmissionStatisticsComponent.this.isSDISSupported() && null != AbstractZeroEmissionStatisticsComponent.this.sdisInterface) {
                    AbstractZeroEmissionStatisticsComponent.this.sdisInterface.sendVisibilityStates(AbstractZeroEmissionStatisticsComponent.this.currentHybridViewOptions.getHybridEnergyFlowState());
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
            this.getLogChannel().log(1000000, "[ZeroEmissionStatisticsSubComponentHybrid#updateHybridEnergyFlowState] viewOptions='%1', valid='%2'", (Object)(hybridEnergyFlowState != null ? hybridEnergyFlowState.toString() : "null"), (long)n);
            if (1 == n) {
                Object object = AbstractZeroEmissionStatisticsComponent.this.mutex;
                synchronized (object) {
                    AbstractZeroEmissionStatisticsComponent.this.currentEnergyFlowState = hybridEnergyFlowState;
                }
            }
        }
    }
}

