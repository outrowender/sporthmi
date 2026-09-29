/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultValueConverterStrategy;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl$1;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl$DefaultStyleConverterStrategy;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl$InvertValueConverterStrategy;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleState;
import de.audi.app.car.core.aircondition.nozzle.IAirconNozzleCtrl;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleCtrl
extends AirconNozzleState
implements IAirconNozzleCtrl {
    private static final long TIMEOUT;
    private final DefaultTimerListener timerListener = new AirconNozzleCtrl$1(this);
    private final LogChannel logChannel;
    private final boolean[] syncPredictedDisplay = new boolean[4];
    private final boolean[] ctrlOverwrite = new boolean[4];
    private final Timer airflowTimer;
    private final Timer positionTimer;
    private final Timer styleTimer;
    private IValueConverterStrategy airflowConverterStrategy = new DefaultValueConverterStrategy();
    private IValueConverterStrategy horizontalConverterStrategy = new AirconNozzleCtrl$InvertValueConverterStrategy(this);
    private IValueConverterStrategy verticalConverterStrategy = new DefaultValueConverterStrategy();
    private IValueConverterStrategy styleConverterStrategy = new AirconNozzleCtrl$DefaultStyleConverterStrategy(this);
    private RangeModelApp airflowModel;
    private RangeModel2DApp positionModel;
    private ChoiceModelApp styleModel;
    private boolean airflowDirty;
    private boolean horizontalPositionDirty;
    private boolean verticalPositionDirty;
    private boolean styleDirty;

    public AirconNozzleCtrl(int n, String string, int n2, int n3, int n4, int n5, LogChannel logChannel) {
        super(n, string, n2, n3, n4, n5);
        this.logChannel = logChannel;
        this.airflowTimer = new Timer(new StringBuffer().append(string).append("_airflowTimer").toString(), 0, true, this.timerListener);
        this.positionTimer = new Timer(new StringBuffer().append(string).append("_positionTimer").toString(), 0, true, this.timerListener);
        this.styleTimer = new Timer(new StringBuffer().append(string).append("_styleTimer").toString(), 0, true, this.timerListener);
    }

    public void setConverterStrategy(int n, IValueConverterStrategy iValueConverterStrategy) {
        if (null != iValueConverterStrategy) {
            switch (n) {
                case 0: {
                    this.airflowConverterStrategy = iValueConverterStrategy;
                    break;
                }
                case 1: {
                    this.horizontalConverterStrategy = iValueConverterStrategy;
                    break;
                }
                case 2: {
                    this.verticalConverterStrategy = iValueConverterStrategy;
                    break;
                }
                case 3: {
                    this.styleConverterStrategy = iValueConverterStrategy;
                    break;
                }
            }
        }
    }

    public void setSyncPredictedDisplay(int n, boolean bl) {
        if (0 <= n && 4 > n) {
            this.syncPredictedDisplay[n] = bl;
        }
    }

    public boolean isCtrlOverwrite(int n) {
        if (0 <= n && 4 > n) {
            return this.ctrlOverwrite[n];
        }
        return false;
    }

    public void setCtrlOverwrite(int n, boolean bl) {
        if (0 <= n && 4 > n) {
            this.ctrlOverwrite[n] = bl;
        }
    }

    public int convertAirflowHMI2DSI(int n) {
        return (Integer)this.airflowConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertAirflowVerticalDSI2HMI(int n) {
        return (Integer)this.airflowConverterStrategy.getHMIValue(new Integer(n));
    }

    public int convertHorizontalPositionHMI2DSI(int n) {
        return (Integer)this.horizontalConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertHorizontalPositionDSI2HMI(int n) {
        return (Integer)this.horizontalConverterStrategy.getHMIValue(new Integer(n));
    }

    public int convertVerticalPositionHMI2DSI(int n) {
        return (Integer)this.verticalConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertVerticalPositionDSI2HMI(int n) {
        return (Integer)this.verticalConverterStrategy.getHMIValue(new Integer(n));
    }

    public AirconNozzleListStyles convertStyleHMI2DSI(int n) {
        return (AirconNozzleListStyles)this.styleConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertStyleDSI2HMI(AirconNozzleListStyles airconNozzleListStyles) {
        return (Integer)this.styleConverterStrategy.getHMIValue(airconNozzleListStyles);
    }

    private void updateAirflowModelData(boolean bl) {
        if (this.isCtrlOverwrite(0)) {
            this.airflowTimer.restart();
            return;
        }
        if (this.airflowDirty && !this.airflowTimer.isRunning() || bl) {
            int n;
            try {
                n = this.convertAirflowVerticalDSI2HMI(bl ? this.getCurrentAirflow() : this.getAirflow());
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.logChannel.log(10000, "[AirconNozzleCtrl(%1)#updateAirflowModelData] ValueConverterStrategyException occurred. Reason: '%2'", (Object)this.getName(), (long)valueConverterStrategyException.getReason());
                return;
            }
            if (null != this.airflowModel) {
                this.airflowModel.setValue(n);
            }
            this.airflowDirty = false;
        }
    }

    private void updatePositionModelData(boolean bl) {
        if (this.isCtrlOverwrite(2) || this.isCtrlOverwrite(1)) {
            this.positionTimer.restart();
            return;
        }
        if ((this.horizontalPositionDirty || this.verticalPositionDirty) && !this.positionTimer.isRunning() || bl) {
            int n;
            int n2;
            try {
                n2 = this.convertHorizontalPositionDSI2HMI(bl ? this.getCurrentHorizontalPosition() : this.getHorizontalPosition());
                n = this.convertVerticalPositionDSI2HMI(bl ? this.getCurrentVerticalPosition() : this.getVerticalPosition());
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.logChannel.log(10000, "[AirconNozzleCtrl(%1)#updatePositionModelData] ValueConverterStrategyException occurred. Reason: '%2'", (Object)this.getName(), (long)valueConverterStrategyException.getReason());
                return;
            }
            if (null != this.positionModel) {
                this.logChannel.log(14808325, "[AirconNozzleCtrl(%1)#updatePositionModelData] horizontal='%2', vertical='%3'", (Object)this.getName(), (long)n2, (long)n);
                this.positionModel.setValue(n, n2);
            }
            this.horizontalPositionDirty = false;
            this.verticalPositionDirty = false;
        }
    }

    private void updateStyleModelData(boolean bl) {
        if (this.isCtrlOverwrite(3)) {
            this.styleTimer.restart();
            return;
        }
        if (this.styleDirty && !this.styleTimer.isRunning() || bl) {
            int n;
            try {
                n = this.convertStyleDSI2HMI(bl ? this.getCurrentStyle() : this.getStyle());
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.logChannel.log(10000, "[AirconNozzleCtrl(%1)#updateStyleModelData] ValueConverterStrategyException occurred. Reason: '%2'", (Object)this.getName(), (long)valueConverterStrategyException.getReason());
                return;
            }
            if (null != this.styleModel) {
                this.styleModel.setValue(n);
            }
            this.styleDirty = false;
        }
    }

    @Override
    public void setModels(RangeModelApp rangeModelApp, RangeModel2DApp rangeModel2DApp, ChoiceModelApp choiceModelApp) {
        this.airflowModel = rangeModelApp;
        this.positionModel = rangeModel2DApp;
        this.styleModel = choiceModelApp;
    }

    @Override
    public final RangeModelApp getAirflowModel() {
        return this.airflowModel;
    }

    @Override
    public final RangeModel2DApp getPositionModel() {
        return this.positionModel;
    }

    @Override
    public final ChoiceModelApp getStyleModel() {
        return this.styleModel;
    }

    @Override
    public void setAirflow(int n, boolean bl) {
        this.setAirflow(n, bl, false);
    }

    public void setAirflow(int n, boolean bl, boolean bl2) {
        super.setAirflow(n, bl);
        this.airflowDirty = true;
        if (this.syncPredictedDisplay[0] && !this.isWaitingForAcknowledge(0)) {
            if (this.airflowTimer.isRunning() && !bl2) {
                this.logChannel.log(-2137614336, "[AirconNozzleCtrl(%1)#setAirflow] Timer is still running.", (Object)this.getName());
            } else {
                this.updateAirflowModelData(bl2);
            }
        } else if (this.syncPredictedDisplay[0]) {
            if (bl2) {
                this.updateAirflowModelData(bl2);
            }
            this.airflowTimer.restart();
        } else if (!this.isWaitingForAcknowledge(0) || bl2) {
            this.updateAirflowModelData(bl2);
        }
    }

    @Override
    public void setHorizontalPosition(int n, boolean bl) {
        this.setHorizontalPosition(n, bl, false);
    }

    public void setHorizontalPosition(int n, boolean bl, boolean bl2) {
        super.setHorizontalPosition(n, bl);
        this.horizontalPositionDirty = true;
        if (this.syncPredictedDisplay[1] && !this.isWaitingForAcknowledge(1)) {
            if (this.positionTimer.isRunning() && !bl2) {
                this.logChannel.log(-2137614336, "[AirconNozzleCtrl(%1)#setHorizontalPosition] Timer is still running.", (Object)this.getName());
            } else {
                this.updatePositionModelData(bl2);
            }
        } else if (this.syncPredictedDisplay[1]) {
            if (bl2) {
                this.updatePositionModelData(bl2);
            }
            this.positionTimer.restart();
        } else if (!this.isWaitingForAcknowledge(1) || bl2) {
            this.updatePositionModelData(bl2);
        }
    }

    @Override
    public void setVerticalPosition(int n, boolean bl) {
        this.setVerticalPosition(n, bl, false);
    }

    public void setVerticalPosition(int n, boolean bl, boolean bl2) {
        super.setVerticalPosition(n, bl);
        this.verticalPositionDirty = true;
        if (this.syncPredictedDisplay[2] && !this.isWaitingForAcknowledge(2)) {
            if (this.positionTimer.isRunning() && !bl2) {
                this.logChannel.log(-2137614336, "[AirconNozzleCtrl(%1)#setVerticalPosition] Timer is still running.", (Object)this.getName());
            } else {
                this.updatePositionModelData(bl2);
            }
        } else if (this.syncPredictedDisplay[2]) {
            if (bl2) {
                this.updatePositionModelData(bl2);
            }
            this.positionTimer.restart();
        } else if (!this.isWaitingForAcknowledge(2) || bl2) {
            this.updatePositionModelData(bl2);
        }
    }

    @Override
    public void setPosition(int n, int n2, boolean bl) {
        this.setPosition(n, n2, bl, false);
    }

    public void setPosition(int n, int n2, boolean bl, boolean bl2) {
        super.setPosition(n, n2, bl);
        this.horizontalPositionDirty = true;
        this.verticalPositionDirty = true;
        if (this.syncPredictedDisplay[1] != this.syncPredictedDisplay[2]) {
            this.logChannel.log(10000, "[AirconNozzleCtrl(%1)#setPosition] Invalid configuration.", (Object)this.getName());
            return;
        }
        boolean bl3 = this.syncPredictedDisplay[1];
        if (bl3 && !this.isWaitingForAcknowledge(1) && !this.isWaitingForAcknowledge(2)) {
            if (this.positionTimer.isRunning() && !bl2) {
                this.logChannel.log(-2137614336, "[AirconNozzleCtrl(%1)#setPosition] Timer is still running.", (Object)this.getName());
            } else {
                this.updatePositionModelData(bl2);
            }
        } else if (bl3) {
            if (bl2) {
                this.updatePositionModelData(bl2);
            }
            this.positionTimer.restart();
        } else if (!this.isWaitingForAcknowledge(1) && !this.isWaitingForAcknowledge(2) || bl2) {
            this.updatePositionModelData(bl2);
        }
    }

    @Override
    public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl) {
        this.setStyle(airconNozzleListStyles, bl, false);
    }

    public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl, boolean bl2) {
        super.setStyle(airconNozzleListStyles, bl);
        this.styleDirty = true;
        if (this.syncPredictedDisplay[3] && !this.isWaitingForAcknowledge(3)) {
            if (this.styleTimer.isRunning() && !bl2) {
                this.logChannel.log(-2137614336, "[AirconNozzleCtrl(%1)#setStyle] Timer is still running.", (Object)this.getName());
            } else {
                this.updateStyleModelData(bl2);
            }
        } else if (this.syncPredictedDisplay[3]) {
            if (bl2) {
                this.updateStyleModelData(bl2);
            }
            this.styleTimer.restart();
        } else if (!this.isWaitingForAcknowledge(3) || bl2) {
            this.updateStyleModelData(bl2);
        }
    }

    static /* synthetic */ Timer access$000(AirconNozzleCtrl airconNozzleCtrl) {
        return airconNozzleCtrl.airflowTimer;
    }

    static /* synthetic */ boolean access$102(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.airflowDirty = bl;
        return airconNozzleCtrl.airflowDirty;
    }

    static /* synthetic */ void access$200(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.updateAirflowModelData(bl);
    }

    static /* synthetic */ Timer access$300(AirconNozzleCtrl airconNozzleCtrl) {
        return airconNozzleCtrl.positionTimer;
    }

    static /* synthetic */ boolean access$402(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.horizontalPositionDirty = bl;
        return airconNozzleCtrl.horizontalPositionDirty;
    }

    static /* synthetic */ boolean access$502(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.verticalPositionDirty = bl;
        return airconNozzleCtrl.verticalPositionDirty;
    }

    static /* synthetic */ void access$600(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.updatePositionModelData(bl);
    }

    static /* synthetic */ Timer access$700(AirconNozzleCtrl airconNozzleCtrl) {
        return airconNozzleCtrl.styleTimer;
    }

    static /* synthetic */ boolean access$802(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.styleDirty = bl;
        return airconNozzleCtrl.styleDirty;
    }

    static /* synthetic */ void access$900(AirconNozzleCtrl airconNozzleCtrl, boolean bl) {
        airconNozzleCtrl.updateStyleModelData(bl);
    }
}

