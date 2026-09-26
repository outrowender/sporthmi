/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent$CombinedDistance;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent$HybridStatisticsButtonListener;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent$HybridStatisticsRotationListener;
import de.audi.app.car.core.hybrid.HybridStatisticsConfigLTS;
import de.audi.app.car.core.hybrid.HybridStatisticsConfigSTS;
import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager;
import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.audi.app.car.core.hybrid.IMemoryBuffer;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.app.car.core.hybrid.StatisticsLongTermEntry;
import de.audi.app.car.core.hybrid.StatisticsMemoryBuffer;
import de.audi.app.car.core.hybrid.StatisticsShortTermEntry;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.Distance;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;

public abstract class AbstractHybridStatisticsComponent
extends AbstractDSICarKombiAdapter
implements MsgListener {
    public static final short[] CODING_ID = new short[]{24, 41};
    private static final String LOGCHANNEL_NAME;
    private static final String STS_BUFFER_NAME;
    private static final String LTS_BUFFER_NAME;
    private static final int VALUE_COUNTER_CHECK_INVALID;
    private static final int VALUE_COUNTER_CHECK_VALID_NEXT;
    private static final int VALUE_COUNTER_CHECK_VALID_OVERRIDE;
    private static final int VALUE_COUNTER_RESET;
    private static final int LONG_TERM_RESET_RESULT_UNDEFINED;
    private static final int LONG_TERM_RESET_RESULT_SUCCESS;
    private static final int LONG_TERM_RESET_RESULT_ERROR;
    private static final int HIDE_SHORT_TERM_HISTORY_BAR;
    private static final int HIDE_SHORT_TERM_CURRENT_BAR;
    private static final int ZERO_EMMISSION_DEFAULT_VALVE;
    private int systemDistanceUnitAsCarConstant = 0;
    private final HybridStatisticsPersistenceManager persistenceMgr;
    private IMemoryBuffer shortTermBuffer;
    private IMemoryBuffer longTermBufferKM;
    private IMemoryBuffer longTermBufferMLS;
    private volatile BCViewOptions currentViewOptions;
    private volatile BCStatisticsConfig currentConfig;
    private BaseListModelApp hSTScModel;
    private BaseListModelApp hSTSxModel;
    private BaseListModelApp hLTSWidgetModel;
    private LabelModelApp hLTSCombustionPercentModel;
    private LabelModelApp hLTSElectricalPercentModel;
    private MetricsModelApp hLTSCombustionModel;
    private MetricsModelApp hLTSElectricalModel;
    private MetricsModelApp hLTSTotalModel;

    public AbstractHybridStatisticsComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Hybrid.Statistics");
        this.persistenceMgr = new HybridStatisticsPersistenceManager(iCarApplication, this.getLogChannel());
        this.shortTermBuffer = new StatisticsMemoryBuffer("ShortTermBuffer");
        this.longTermBufferKM = new StatisticsMemoryBuffer("LongTermBufferKM");
        this.longTermBufferMLS = new StatisticsMemoryBuffer("LongTermBufferMLS");
        this.currentConfig = null;
        this.systemDistanceUnitAsCarConstant = this.getSystemDistanceUnit(true);
    }

    public BCViewOptions getViewOptions() {
        return this.currentViewOptions;
    }

    protected IMemoryBuffer getLTSBuffer(int n) {
        switch (n) {
            case 0: {
                return this.longTermBufferKM;
            }
            case 1: {
                return this.longTermBufferMLS;
            }
        }
        return null;
    }

    protected int getSystemDistanceUnit(boolean bl) {
        int n = Distance.getSystemUnit();
        if (bl) {
            switch (n) {
                case 1: {
                    n = 0;
                    break;
                }
                case 2: {
                    n = 1;
                    break;
                }
            }
        }
        return n;
    }

    private IMemoryBuffer initSTSBuffer(IMemoryBuffer iMemoryBuffer, int n) {
        boolean bl;
        if (null != iMemoryBuffer && 0 < n) {
            if (!iMemoryBuffer.isInitialized()) {
                bl = iMemoryBuffer.init(0, n);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractHybridStatisticsComponent#initSTSBuffer] Short term buffer (%1) already initialized!", (Object)iMemoryBuffer.getName());
                if (iMemoryBuffer.maxSize() == n) {
                    bl = iMemoryBuffer.reset();
                } else {
                    String string = iMemoryBuffer.getName();
                    iMemoryBuffer = new StatisticsMemoryBuffer(string);
                    bl = iMemoryBuffer.init(0, n);
                }
            }
        } else {
            iMemoryBuffer = new StatisticsMemoryBuffer("ShortTermBuffer");
            bl = iMemoryBuffer.init(0, n);
        }
        if (bl) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#initSTSBuffer] Short term buffer (%1) initialized.", (Object)iMemoryBuffer.getName());
        } else {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#initSTSBuffer] Short term buffer (%1) not initialized.", (Object)iMemoryBuffer.getName());
        }
        return iMemoryBuffer;
    }

    private IMemoryBuffer initLTSBuffer(IMemoryBuffer iMemoryBuffer, int n) {
        boolean bl;
        if (null != iMemoryBuffer && 0 < n) {
            if (!iMemoryBuffer.isInitialized()) {
                bl = iMemoryBuffer.init(1, n);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractHybridStatisticsComponent#initLTSBuffer] Long term buffer (%1) already initialized!", (Object)iMemoryBuffer.getName());
                if (iMemoryBuffer.maxSize() == n) {
                    bl = iMemoryBuffer.reset();
                } else {
                    String string = iMemoryBuffer.getName();
                    iMemoryBuffer = new StatisticsMemoryBuffer(string);
                    bl = iMemoryBuffer.init(1, n);
                }
            }
        } else {
            iMemoryBuffer = new StatisticsMemoryBuffer("LongTermBuffer");
            bl = iMemoryBuffer.init(1, n);
        }
        if (bl) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#initLTSBuffer] Long term buffer (%1) initialized.", (Object)iMemoryBuffer.getName());
        } else {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#initLTSBuffer] Long term buffer (%1) not initialized.", (Object)iMemoryBuffer.getName());
        }
        return iMemoryBuffer;
    }

    private AbstractHybridStatisticsComponent$CombinedDistance getAccumulatedDistance(IMemoryBuffer iMemoryBuffer) {
        if (iMemoryBuffer.isInitialized()) {
            Iterator iterator = iMemoryBuffer.iterator();
            AbstractHybridStatisticsComponent$CombinedDistance abstractHybridStatisticsComponent$CombinedDistance = new AbstractHybridStatisticsComponent$CombinedDistance(this);
            while (iterator.hasNext()) {
                StatisticsLongTermEntry statisticsLongTermEntry = (StatisticsLongTermEntry)iterator.next();
                abstractHybridStatisticsComponent$CombinedDistance.setDistanceCombustion(statisticsLongTermEntry.getDistanceCombustion(), true);
                abstractHybridStatisticsComponent$CombinedDistance.setDistanceElectrical(statisticsLongTermEntry.getDistanceElectrical(), true);
                abstractHybridStatisticsComponent$CombinedDistance.setDistanceEfficiency(statisticsLongTermEntry.getDistanceEfficiency(), true);
            }
            return abstractHybridStatisticsComponent$CombinedDistance;
        }
        this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#getAccumulatedDistance] Buffer (%1) not initialized!", (Object)iMemoryBuffer.getName());
        return null;
    }

    private int calculateBufferSize(int n) {
        float f2 = this.getHistoryValue(n);
        if (0.0f >= f2) {
            this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#calculateBufferSize] Invalid history value!");
            return 0;
        }
        if (null == this.currentConfig) {
            this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#calculateBufferSize] No configuration available!");
            return 0;
        }
        float f3 = this.currentConfig.getStatisticsIntervalValue();
        if (0.0f < f3) {
            return (int)Math.ceil(f2 / f3);
        }
        this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#calculateBufferSize] Interval value not set or invalid.");
        return 0;
    }

    private void updateShortTermStatisticsCurrent(BCZeroEmissionRelative bCZeroEmissionRelative) {
        if (null != bCZeroEmissionRelative) {
            this.hSTScModel.setStatus(0);
            EvoListRow evoListRow = new EvoListRow(-1L, 2);
            if (bCZeroEmissionRelative.getState() == 1) {
                evoListRow.setInteger(0, bCZeroEmissionRelative.getState());
                evoListRow.setLong(1, bCZeroEmissionRelative.getValue());
            } else {
                evoListRow.setInteger(0, 3);
                evoListRow.setLong(1, 0);
            }
            this.hSTScModel.setRow(0, evoListRow);
            this.hSTScModel.setStatus(1);
        }
    }

    private void updateShortTermStatisticsHistory(BCStatisticsZE bCStatisticsZE) {
        if (bCStatisticsZE != null && bCStatisticsZE.getZeroEmissionRelative() != null) {
            StatisticsShortTermEntry statisticsShortTermEntry;
            int n;
            int n2 = bCStatisticsZE.getValueCounter().getValue();
            if (this.shortTermBuffer.isEmpty() && 1 == n2) {
                n = 1;
            } else if (this.shortTermBuffer.isEmpty() && 1 != n2) {
                n = 0;
            } else {
                statisticsShortTermEntry = (StatisticsShortTermEntry)this.shortTermBuffer.get(this.shortTermBuffer.getIndexOfLatest());
                n = this.checkValueCounter(n2, statisticsShortTermEntry.getValueCounter());
            }
            int n3 = 3;
            double d2 = 255.0;
            if (bCStatisticsZE.getZeroEmissionRelative().getState() == 1) {
                n3 = bCStatisticsZE.getZeroEmissionRelative().getState();
                d2 = bCStatisticsZE.getZeroEmissionRelative().getValue();
            }
            switch (n) {
                case 1: {
                    statisticsShortTermEntry = new StatisticsShortTermEntry(n2, this.getSystemDistanceUnit(true), n3, d2);
                    this.shortTermBuffer.enqueue(statisticsShortTermEntry);
                    break;
                }
                case 2: {
                    statisticsShortTermEntry = (StatisticsShortTermEntry)this.shortTermBuffer.get(this.shortTermBuffer.getIndexOfLatest());
                    statisticsShortTermEntry.setZeroEmissionState(n3);
                    statisticsShortTermEntry.setZeroEmissionValue(d2);
                    this.shortTermBuffer.update(statisticsShortTermEntry);
                    break;
                }
                case 0: {
                    this.resetShortTermStatistics();
                    statisticsShortTermEntry = new StatisticsShortTermEntry(n2, this.getSystemDistanceUnit(true), n3, d2);
                    this.shortTermBuffer.enqueue(statisticsShortTermEntry);
                    break;
                }
                default: {
                    return;
                }
            }
            if (this.getLogChannel().isDebug2()) {
                this.getLogChannel().log(14808325, "[AbstractHybridStatisticsComponent#updateShortTermStatisticsHistory] %1", (Object)this.shortTermBuffer.toString());
            }
            this.saveSTSData();
            this.setSTSHistoryModels(this.shortTermBuffer.toArray(), this.shortTermBuffer.size());
        }
    }

    private void updateLongTermStatistics(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        Object object;
        int n2;
        double d2;
        double d3;
        if (this.currentViewOptions == null) {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#updateLongTermStatistic] No view options received yet! Update ignored.");
            return;
        }
        BCConfiguration bCConfiguration = this.currentViewOptions.getConfiguration();
        if (null == bCConfiguration) {
            this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#updateLongTermStatistic] No statistics configuration available.");
            return;
        }
        if (3 == bCConfiguration.getPrimaryEngineType()) {
            d3 = bCStatisticsDistanceEU.getDistanceSecondary().getDistanceValue();
            d2 = bCStatisticsDistanceEU.getDistancePrimary().getDistanceValue();
        } else if (3 == bCConfiguration.getSecondaryEngineType()) {
            d3 = bCStatisticsDistanceEU.getDistancePrimary().getDistanceValue();
            d2 = bCStatisticsDistanceEU.getDistanceSecondary().getDistanceValue();
        } else {
            this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#updateLongTermStatistic] Invalid statistics configuration.");
            return;
        }
        double d4 = bCStatisticsDistanceEU.getDistanceEfficiency().getDistanceValue();
        int n3 = bCStatisticsDistanceEU.getValueCounter().getValue();
        IMemoryBuffer iMemoryBuffer = this.getLTSBuffer(n);
        if (iMemoryBuffer.isEmpty() && 1 == n3) {
            n2 = 1;
        } else if (iMemoryBuffer.isEmpty() && 1 != n3) {
            n2 = 0;
        } else {
            object = (StatisticsLongTermEntry)iMemoryBuffer.get(iMemoryBuffer.getIndexOfLatest());
            n2 = this.checkValueCounter(n3, ((StatisticsLongTermEntry)object).getValueCounter());
        }
        if (0 == n2) {
            this.resetLongTermStatistics();
            this.fireLongTermStatisticsReset();
        } else if (n2 == 1) {
            int n4;
            object = new double[]{d3, d2, d4};
            double d5 = this.currentConfig.getStatisticsIntervalValue();
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                if (object[n4] > d5) {
                    object[n4] = d5;
                    d5 = 0.0;
                    continue;
                }
                d5 -= object[n4];
            }
            n4 = this.addToLTSBuffer(iMemoryBuffer, n, bCStatisticsDistanceEU.getValueCounter().getValue(), (double)object[0], (double)object[1], (double)object[2]) ? 1 : 0;
            this.saveLTSData();
            if (n4 != 0 && this.getSystemDistanceUnit(true) == n) {
                this.setLTSModels(n);
            }
        }
    }

    private boolean addToLTSBuffer(IMemoryBuffer iMemoryBuffer, int n, int n2, double d2, double d3, double d4) {
        if (null != iMemoryBuffer) {
            if (iMemoryBuffer.isInitialized()) {
                iMemoryBuffer.enqueue(new StatisticsLongTermEntry(n2, n, d2, d3, d4));
                if (this.getLogChannel().isDebug2()) {
                    this.getLogChannel().log(14808325, "[AbstractHybridStatisticsComponent#updateLTSBuffer] %1", (Object)iMemoryBuffer.toString());
                }
                return true;
            }
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#updateLTSBuffer] Buffer not initialized. Update ignored.");
        }
        return false;
    }

    protected void fireShortTermStatisticsReset() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#fireShortTermStatisticsReset] Not specified yet!");
        }
    }

    private void resetShortTermStatistics() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#resetShortTermStatistics] called.");
        }
        if (this.shortTermBuffer.isInitialized()) {
            this.shortTermBuffer.reset();
        }
        this.saveSTSData();
        this.resetSTSModels();
    }

    protected void fireLongTermStatisticsReset() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "---> resetBCStatistics( BCStatisticsReset[time='false', distance='true'] )");
        }
        this.getDSI().resetBCStatistics(new BCStatisticsReset(false, true));
    }

    private void resetLongTermStatistics() {
        this.resetLongTermStatistics(0);
        this.resetLongTermStatistics(1);
    }

    private void resetLongTermStatistics(int n) {
        IMemoryBuffer iMemoryBuffer;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#resetLongTermStatistics] called.");
        }
        if (null != (iMemoryBuffer = this.getLTSBuffer(n)) && iMemoryBuffer.isInitialized()) {
            iMemoryBuffer.reset();
        }
        this.saveLTSData();
        if (this.getSystemDistanceUnit(true) == n) {
            this.resetLTSModels();
        }
    }

    protected int checkValueCounter(int n, int n2) {
        if (n == n2) {
            return 2;
        }
        if (0 < n2 && 254 > n2 ? n - n2 == 1 : n2 == 254 && n == 1) {
            return 1;
        }
        return 0;
    }

    private void setSTSHistoryModels(IMemoryBufferEntry[] iMemoryBufferEntryArray, int n) {
        if (null != iMemoryBufferEntryArray && iMemoryBufferEntryArray.length >= n) {
            this.hSTSxModel.setStatus(0);
            int n2 = 0;
            int n3 = n - 1;
            while (n2 < iMemoryBufferEntryArray.length) {
                EvoListRow evoListRow = new EvoListRow(-1L, 2);
                evoListRow.setInteger(0, 3);
                evoListRow.setLong(1, 0L);
                if (n2 + 1 <= n) {
                    IMemoryBufferEntry iMemoryBufferEntry = iMemoryBufferEntryArray[n2];
                    if (iMemoryBufferEntry instanceof StatisticsShortTermEntry) {
                        int n4 = ((StatisticsShortTermEntry)iMemoryBufferEntryArray[n2]).getZeroEmissionState();
                        long l = (long)((StatisticsShortTermEntry)iMemoryBufferEntryArray[n2]).getZeroEmissionValue();
                        evoListRow.setInteger(0, n4);
                        evoListRow.setLong(1, l);
                    }
                    this.hSTSxModel.setRow(n3, evoListRow);
                } else {
                    this.hSTSxModel.setRow(n2, evoListRow);
                }
                ++n2;
                --n3;
            }
            this.hSTSxModel.setStatus(1);
        }
    }

    private void resetSTSModels() {
        EvoListRow evoListRow = new EvoListRow(-1L, 2);
        evoListRow.setInteger(0, 3);
        evoListRow.setLong(1, 0L);
        this.hSTSxModel.setStatus(0);
        for (int i2 = 0; i2 < this.hSTSxModel.getLength(); ++i2) {
            this.hSTSxModel.setRow(i2, evoListRow);
        }
        this.hSTSxModel.setStatus(1);
    }

    private void setLTSModels(int n) {
        AbstractHybridStatisticsComponent$CombinedDistance abstractHybridStatisticsComponent$CombinedDistance = null;
        int n2 = 6;
        switch (n) {
            case 0: {
                abstractHybridStatisticsComponent$CombinedDistance = this.getAccumulatedDistance(this.longTermBufferKM);
                n2 = 1;
                break;
            }
            case 1: {
                abstractHybridStatisticsComponent$CombinedDistance = this.getAccumulatedDistance(this.longTermBufferMLS);
                n2 = 2;
                break;
            }
        }
        if (null != abstractHybridStatisticsComponent$CombinedDistance) {
            this.getLogChannel().log(-2137614336, "[AbstractHybridStatisticsComponent#setLTSModels] with distance unit %1", (long)n2);
            this.hLTSCombustionModel.setStatus(0);
            this.hLTSElectricalModel.setStatus(0);
            this.hLTSTotalModel.setStatus(0);
            this.hLTSWidgetModel.setStatus(0);
            this.hLTSCombustionModel.setMetric(new Distance(abstractHybridStatisticsComponent$CombinedDistance.getDistanceCombustionDisp(), n2));
            this.hLTSElectricalModel.setMetric(new Distance(abstractHybridStatisticsComponent$CombinedDistance.getDistanceElectricalDisp() + abstractHybridStatisticsComponent$CombinedDistance.getDistanceEfficiencyDisp(), n2));
            this.hLTSTotalModel.setMetric(new Distance(abstractHybridStatisticsComponent$CombinedDistance.getTotalDistanceDisp(), n2));
            EvoListRow evoListRow = new EvoListRow(-1L, 1);
            evoListRow.setInteger(0, abstractHybridStatisticsComponent$CombinedDistance.getDistanceCombustionAsPercent());
            this.hLTSWidgetModel.setRow(0, evoListRow);
            evoListRow.setInteger(0, abstractHybridStatisticsComponent$CombinedDistance.getDistanceElectricalAsPercent());
            this.hLTSWidgetModel.setRow(1, evoListRow);
            evoListRow.setInteger(0, abstractHybridStatisticsComponent$CombinedDistance.getDistanceEfficiencyAsPercent());
            this.hLTSWidgetModel.setRow(2, evoListRow);
            this.hLTSCombustionPercentModel.setText(Integer.toString(abstractHybridStatisticsComponent$CombinedDistance.getDistanceCombustionAsPercent()));
            this.hLTSElectricalPercentModel.setText(Integer.toString(abstractHybridStatisticsComponent$CombinedDistance.getDistanceElectricalAsPercent() + abstractHybridStatisticsComponent$CombinedDistance.getDistanceEfficiencyAsPercent()));
            this.hLTSWidgetModel.setStatus(1);
            this.hLTSCombustionModel.setStatus(1);
            this.hLTSElectricalModel.setStatus(1);
            this.hLTSTotalModel.setStatus(1);
        }
    }

    private void resetLTSModels() {
        int n = this.getSystemDistanceUnit(false);
        this.hLTSCombustionModel.setStatus(0);
        this.hLTSCombustionPercentModel.setStatus(0);
        this.hLTSElectricalModel.setStatus(0);
        this.hLTSElectricalPercentModel.setStatus(0);
        this.hLTSTotalModel.setStatus(0);
        this.hLTSWidgetModel.setStatus(0);
        this.hLTSCombustionModel.setMetric(new Distance(0.0f, n));
        this.hLTSCombustionPercentModel.setText("--");
        this.hLTSElectricalModel.setMetric(new Distance(0.0f, n));
        this.hLTSElectricalPercentModel.setText("--");
        this.hLTSTotalModel.setMetric(new Distance(0.0f, n));
        EvoListRow evoListRow = new EvoListRow(-1L, 1);
        evoListRow.setInteger(0, 0);
        this.hLTSWidgetModel.setRow(0, evoListRow);
        this.hLTSWidgetModel.setRow(1, evoListRow);
        this.hLTSWidgetModel.setRow(2, evoListRow);
        this.hLTSWidgetModel.setStatus(1);
        this.hLTSCombustionModel.setStatus(1);
        this.hLTSCombustionPercentModel.setStatus(1);
        this.hLTSElectricalModel.setStatus(1);
        this.hLTSElectricalPercentModel.setStatus(1);
        this.hLTSTotalModel.setStatus(1);
    }

    private boolean saveSTSData() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#saveSTSData] Save short term statistics into persistent storage.");
        }
        boolean bl = false;
        if (null != this.currentConfig && this.shortTermBuffer.isInitialized()) {
            bl = this.persistenceMgr.saveConfig(100, new HybridStatisticsConfigSTS(this.getSystemDistanceUnit(true), this.currentConfig.getStatisticsIntervalValue(), this.shortTermBuffer.size()));
            boolean bl2 = bl = bl && this.persistenceMgr.saveHistory(102, this.shortTermBuffer.toArray());
        }
        if (!bl) {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#saveSTSData] Couldn't save short term statistics into persistent storage.");
        }
        return bl;
    }

    private boolean loadSTSData() {
        IHybridStatisticsConfig iHybridStatisticsConfig;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#loadSTSData] Load short term statistics from persistent storage.");
        }
        if (!((iHybridStatisticsConfig = this.persistenceMgr.loadConfig(100)) instanceof HybridStatisticsConfigSTS)) {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#loadSTSData] Couldn't load the configuration of the short term statistics from persistent storage.");
            return false;
        }
        IMemoryBufferEntry[] iMemoryBufferEntryArray = (IMemoryBufferEntry[])iHybridStatisticsConfig;
        if (!(0.0f < iMemoryBufferEntryArray.getIntervalValue())) {
            return false;
        }
        this.currentConfig = new BCStatisticsConfig(false, false, false, true, 0, iMemoryBufferEntryArray.getIntervalValue());
        iMemoryBufferEntryArray = this.persistenceMgr.loadHistory(102);
        if (0 < iMemoryBufferEntryArray.length && iMemoryBufferEntryArray.length == this.calculateBufferSize(0)) {
            this.shortTermBuffer = this.initSTSBuffer(this.shortTermBuffer, iMemoryBufferEntryArray.length);
            for (int i2 = 0; i2 < iMemoryBufferEntryArray.length; ++i2) {
                if (255 == ((StatisticsShortTermEntry)iMemoryBufferEntryArray[i2]).getValueCounter()) continue;
                this.shortTermBuffer.enqueue(iMemoryBufferEntryArray[i2]);
            }
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#loadSTSData] Couldn't load short term statistics from persistent storage.");
            return false;
        }
        return true;
    }

    private boolean saveLTSData() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#saveLTSData] Save long term statistics into persistent storage.");
        }
        boolean bl = false;
        if (null != this.currentConfig && this.longTermBufferKM.isInitialized() && this.longTermBufferMLS.isInitialized()) {
            bl = this.persistenceMgr.saveConfig(101, new HybridStatisticsConfigLTS(this.getSystemDistanceUnit(true), this.currentConfig.getStatisticsIntervalValue()));
            bl = bl && this.persistenceMgr.saveHistory(103, this.longTermBufferKM.toArray());
            boolean bl2 = bl = bl && this.persistenceMgr.saveHistory(104, this.longTermBufferMLS.toArray());
        }
        if (!bl) {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#saveLTSData] Couldn't save long term statistics into persistent storage.");
        }
        return bl;
    }

    private boolean loadLTSData() {
        int n;
        IHybridStatisticsConfig iHybridStatisticsConfig;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#loadLTSData] Load long term statistics from persistent storage.");
        }
        if (!((iHybridStatisticsConfig = this.persistenceMgr.loadConfig(101)) instanceof HybridStatisticsConfigLTS)) {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#loadLTSData] Couldn't load the configuration of the long term statistics from persistent storage.");
            return false;
        }
        IMemoryBufferEntry[] iMemoryBufferEntryArray = (IMemoryBufferEntry[])iHybridStatisticsConfig;
        if (!(0.0f < iMemoryBufferEntryArray.getIntervalValue())) {
            return false;
        }
        this.currentConfig = new BCStatisticsConfig(false, false, false, true, 0, iMemoryBufferEntryArray.getIntervalValue());
        iMemoryBufferEntryArray = this.persistenceMgr.loadHistory(103);
        if (0 < iMemoryBufferEntryArray.length && iMemoryBufferEntryArray.length == this.calculateBufferSize(1)) {
            this.longTermBufferKM = this.initLTSBuffer(this.longTermBufferKM, iMemoryBufferEntryArray.length);
            for (n = 0; n < iMemoryBufferEntryArray.length; ++n) {
                if (255 == ((StatisticsLongTermEntry)iMemoryBufferEntryArray[n]).getValueCounter()) continue;
                this.longTermBufferKM.enqueue(iMemoryBufferEntryArray[n]);
            }
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#loadLTSData] (%1) Couldn't load long term statistics from persistent storage.", (Object)this.longTermBufferKM.getName());
            return false;
        }
        iMemoryBufferEntryArray = this.persistenceMgr.loadHistory(104);
        if (0 < iMemoryBufferEntryArray.length && iMemoryBufferEntryArray.length == this.calculateBufferSize(1)) {
            this.longTermBufferMLS = this.initLTSBuffer(this.longTermBufferMLS, iMemoryBufferEntryArray.length);
            for (n = 0; n < iMemoryBufferEntryArray.length; ++n) {
                if (255 == ((StatisticsLongTermEntry)iMemoryBufferEntryArray[n]).getValueCounter()) continue;
                this.longTermBufferMLS.enqueue(iMemoryBufferEntryArray[n]);
            }
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractHybridStatisticsComponent#loadLTSData] (%1) Couldn't load long term statistics from persistent storage.", (Object)this.longTermBufferMLS.getName());
            return false;
        }
        return true;
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 11: {
                if (this.systemDistanceUnitAsCarConstant == this.getSystemDistanceUnit(true)) break;
                this.systemDistanceUnitAsCarConstant = this.getSystemDistanceUnit(true);
                if (!this.getLTSBuffer(this.systemDistanceUnitAsCarConstant).isEmpty()) {
                    this.setLTSModels(this.systemDistanceUnitAsCarConstant);
                } else {
                    this.resetLTSModels();
                }
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#processMsg] UNITS_CHANGED: Distance %1", (long)this.systemDistanceUnitAsCarConstant);
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "HybridStatistics";
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Bord Computer: ");
        buffer.append(this.currentViewOptions != null ? this.currentViewOptions.toString() : "No view options received yet!").append('\n');
        return buffer.toString();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{2008, 45, 67, 68, 58, 54})};
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(11, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(11, this);
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.getButtonModel(1764624640).setButtonListener(new AbstractHybridStatisticsComponent$HybridStatisticsButtonListener(this, null));
        this.getRangeModel(-2010183424).setRangeListener(new AbstractHybridStatisticsComponent$HybridStatisticsRotationListener(this, null));
        this.hSTScModel = this.getBaseListModel(2066614528);
        this.hSTScModel.setLength(1);
        this.hSTSxModel = this.getBaseListModel(2133723392);
        this.hSTSxModel.setLength(30);
        this.hLTSWidgetModel = this.getBaseListModel(-2144466688);
        this.hLTSWidgetModel.setLength(3);
        this.hLTSCombustionPercentModel = this.getLabelModel(-1590818560);
        this.hLTSElectricalPercentModel = this.getLabelModel(-1574041344);
        this.hLTSCombustionModel = this.getMetricsModel(2049837312);
        this.hLTSElectricalModel = this.getMetricsModel(2083391744);
        this.hLTSTotalModel = this.getMetricsModel(2100168960);
        if (this.loadSTSData()) {
            this.setSTSHistoryModels(this.shortTermBuffer.toArray(), this.shortTermBuffer.size());
        } else {
            this.resetShortTermStatistics();
        }
        if (this.loadLTSData()) {
            this.setLTSModels(this.systemDistanceUnitAsCarConstant);
        } else {
            this.resetLongTermStatistics();
        }
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(1764624640).resetListener();
        this.getRangeModel(-2010183424).resetListener();
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent(%1)#updateBCViewOptions] viewOptions='%2', valid='%3'", (Object)this.getName(), (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
            }
            if (1 == n && bCViewOptions != null) {
                this.currentViewOptions = bCViewOptions;
                this.updateMenuEntryVisibility(bCViewOptions);
                this.primaryAttributeFirstSetReceived();
            }
        }
    }

    @Override
    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
        if (n == 1) {
            int n2;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticsConfig] %1, validFlag='%2'", (Object)bCStatisticsConfig, (long)n);
            }
            boolean bl = null == this.currentConfig ? true : bCStatisticsConfig.getStatisticsIntervalValue() != this.currentConfig.getStatisticsIntervalValue();
            this.currentConfig = bCStatisticsConfig;
            int n3 = this.calculateBufferSize(0);
            if (0 < n3 && (bl || !this.shortTermBuffer.isInitialized())) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticsConfig] Trying to initialize STS buffer(size='%1') ...", (long)n3);
                }
                this.shortTermBuffer = this.initSTSBuffer(this.shortTermBuffer, n3);
                this.hSTSxModel.setLength(n3);
                this.resetSTSModels();
            }
            if (!(0 >= (n2 = this.calculateBufferSize(1)) || !bl && this.longTermBufferKM.isInitialized() && this.longTermBufferKM.isInitialized())) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticsConfig] Trying to initialize LTS buffer(size='%1') ...", (long)n2);
                }
                this.longTermBufferKM = this.initLTSBuffer(this.longTermBufferKM, n2);
                this.longTermBufferMLS = this.initLTSBuffer(this.longTermBufferMLS, n2);
                this.resetLTSModels();
            }
        }
    }

    @Override
    public void acknowledgeBcStatisticsReset(int n) {
        int n2;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "<--- acknowledgeBcStatisticsReset(%1)", (long)n);
        }
        if (0 == n) {
            this.resetLongTermStatistics();
            n2 = 1;
        } else {
            n2 = 2;
        }
        this.getChoiceModel(-718403328).setValue(n2);
        this.getChoiceModel(-718403328).setStatus(1);
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticsDistanceCurrentIntervalZE] %1, validFlag='%2'", (Object)bCZeroEmissionRelative, (long)n);
            }
            this.updateShortTermStatisticsCurrent(bCZeroEmissionRelative);
        }
    }

    @Override
    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticsDistanceZE] %1, validFlag='%2'", (Object)bCStatisticsZE, (long)n);
            }
            int n2 = bCStatisticsZE.getValueCounter().getState();
            switch (n2) {
                case 0: {
                    this.resetShortTermStatistics();
                    break;
                }
                case 1: {
                    this.updateShortTermStatisticsHistory(bCStatisticsZE);
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#updateBCStatisticsDistanceZE] Invalid value counter state: ", (long)n2);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        if (n == 1) {
            int n2;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticDistanceEUkm] %1, validFlag='%2'", (Object)bCStatisticsDistanceEU, (long)n);
            }
            if (0 == (n2 = bCStatisticsDistanceEU.getValueCounter().getValue())) {
                this.resetLongTermStatistics(0);
            }
            int n3 = bCStatisticsDistanceEU.getValueCounter().getState();
            switch (n3) {
                case 0: {
                    this.resetLongTermStatistics(0);
                    break;
                }
                case 1: {
                    this.updateLongTermStatistics(bCStatisticsDistanceEU, 0);
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#updateBCStatisticDistanceEUkm] Invalid value counter state: ", (long)n3);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        if (n == 1) {
            int n2;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractHybridStatisticsComponent#updateBCStatisticDistanceEUmls] %1, validFlag='%2'", (Object)bCStatisticsDistanceEU, (long)n);
            }
            if (0 == (n2 = bCStatisticsDistanceEU.getValueCounter().getValue())) {
                this.resetLongTermStatistics(1);
            }
            int n3 = bCStatisticsDistanceEU.valueCounter.getState();
            switch (n3) {
                case 0: {
                    this.resetLongTermStatistics(1);
                    break;
                }
                case 1: {
                    this.updateLongTermStatistics(bCStatisticsDistanceEU, 1);
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    this.getLogChannel().log(10000, "[AbstractHybridStatisticsComponent#updateBCStatisticDistanceEUmls] Invalid value counter state: ", (long)n3);
                }
            }
        }
    }

    protected abstract void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
    }

    protected abstract float getHistoryValue(int n) {
    }

    public String getSTSDataDump() {
        if (null != this.shortTermBuffer && this.shortTermBuffer.isInitialized()) {
            Buffer buffer = new Buffer();
            buffer.append("STS Buffer: ").append(this.shortTermBuffer.getName());
            buffer.append('\n').append(" --- ").append('\n');
            buffer.append(this.shortTermBuffer.toString());
            return buffer.toString();
        }
        return "No data available!";
    }

    public String getLTSDataDump() {
        if (null != this.longTermBufferKM && null != this.longTermBufferMLS && this.longTermBufferKM.isInitialized() && this.longTermBufferMLS.isInitialized()) {
            Buffer buffer = new Buffer();
            buffer.append("LTS Buffer: ").append(this.longTermBufferKM.getName());
            buffer.append('\n').append(" --- ").append('\n');
            buffer.append(this.longTermBufferKM.toString()).append('\n').append('\n');
            buffer.append("LTS Buffer: ").append(this.longTermBufferMLS.getName());
            buffer.append('\n').append(" --- ").append('\n');
            buffer.append(this.longTermBufferMLS.toString());
            return buffer.toString();
        }
        return "No data available!";
    }

    public void diagResetDataBufferSTS() {
        if (null != this.shortTermBuffer && this.shortTermBuffer.isInitialized()) {
            this.resetShortTermStatistics();
        }
    }

    public void diagResetDataBufferLTS() {
        if (null != this.longTermBufferKM && null != this.longTermBufferMLS && this.longTermBufferKM.isInitialized() && this.longTermBufferMLS.isInitialized()) {
            this.resetLongTermStatistics();
        }
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, int n) {
        return abstractHybridStatisticsComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, int n) {
        return abstractHybridStatisticsComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$400(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, int n) {
        return abstractHybridStatisticsComponent.getButtonModel(n);
    }

    static /* synthetic */ RangeModelApp access$500(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, int n) {
        return abstractHybridStatisticsComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$600(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, int n) {
        return abstractHybridStatisticsComponent.getRangeModel(n);
    }
}

