/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultValueConverterStrategy;
import de.audi.app.car.common.util.IValueConverterStrategy;
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
    private static final long TIMEOUT = 1000L;
    private final DefaultTimerListener timerListener = new DefaultTimerListener(){

        public void fireTimer(Timer timer) {
            if (timer.equals(AirconNozzleCtrl.this.airflowTimer)) {
                if (!AirconNozzleCtrl.this.isCtrlOverwrite(0)) {
                    AirconNozzleCtrl.this.airflowDirty = true;
                    AirconNozzleCtrl.this.updateAirflowModelData(false);
                } else {
                    AirconNozzleCtrl.this.airflowTimer.restart();
                }
            } else if (timer.equals(AirconNozzleCtrl.this.positionTimer)) {
                if (!AirconNozzleCtrl.this.isCtrlOverwrite(1) && !AirconNozzleCtrl.this.isCtrlOverwrite(2)) {
                    AirconNozzleCtrl.this.horizontalPositionDirty = true;
                    AirconNozzleCtrl.this.verticalPositionDirty = true;
                    AirconNozzleCtrl.this.updatePositionModelData(false);
                } else {
                    AirconNozzleCtrl.this.positionTimer.restart();
                }
            } else if (timer.equals(AirconNozzleCtrl.this.styleTimer)) {
                if (!AirconNozzleCtrl.this.isCtrlOverwrite(3)) {
                    AirconNozzleCtrl.this.styleDirty = true;
                    AirconNozzleCtrl.this.updateStyleModelData(false);
                } else {
                    AirconNozzleCtrl.this.styleTimer.restart();
                }
            }
        }
    };
    private final LogChannel logChannel;
    private final boolean[] syncPredictedDisplay = new boolean[4];
    private final boolean[] ctrlOverwrite = new boolean[4];
    private final Timer airflowTimer;
    private final Timer positionTimer;
    private final Timer styleTimer;
    private IValueConverterStrategy airflowConverterStrategy = new DefaultValueConverterStrategy();
    private IValueConverterStrategy horizontalConverterStrategy = new InvertValueConverterStrategy();
    private IValueConverterStrategy verticalConverterStrategy = new DefaultValueConverterStrategy();
    private IValueConverterStrategy styleConverterStrategy = new DefaultStyleConverterStrategy();
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
        this.airflowTimer = new Timer(new StringBuffer().append(string).append("_airflowTimer").toString(), 1000L, true, this.timerListener);
        this.positionTimer = new Timer(new StringBuffer().append(string).append("_positionTimer").toString(), 1000L, true, this.timerListener);
        this.styleTimer = new Timer(new StringBuffer().append(string).append("_styleTimer").toString(), 1000L, true, this.timerListener);
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

    public int convertAirflowHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.airflowConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertAirflowVerticalDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.airflowConverterStrategy.getHMIValue(new Integer(n));
    }

    public int convertHorizontalPositionHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.horizontalConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertHorizontalPositionDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.horizontalConverterStrategy.getHMIValue(new Integer(n));
    }

    public int convertVerticalPositionHMI2DSI(int n) throws ValueConverterStrategyException {
        return (Integer)this.verticalConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertVerticalPositionDSI2HMI(int n) throws ValueConverterStrategyException {
        return (Integer)this.verticalConverterStrategy.getHMIValue(new Integer(n));
    }

    public AirconNozzleListStyles convertStyleHMI2DSI(int n) throws ValueConverterStrategyException {
        return (AirconNozzleListStyles)this.styleConverterStrategy.getDSIValue(new Integer(n));
    }

    public int convertStyleDSI2HMI(AirconNozzleListStyles airconNozzleListStyles) throws ValueConverterStrategyException {
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
                this.logChannel.log(100000000, "[AirconNozzleCtrl(%1)#updatePositionModelData] horizontal='%2', vertical='%3'", (Object)this.getName(), (long)n2, (long)n);
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

    public void setModels(RangeModelApp rangeModelApp, RangeModel2DApp rangeModel2DApp, ChoiceModelApp choiceModelApp) {
        this.airflowModel = rangeModelApp;
        this.positionModel = rangeModel2DApp;
        this.styleModel = choiceModelApp;
    }

    public final RangeModelApp getAirflowModel() {
        return this.airflowModel;
    }

    public final RangeModel2DApp getPositionModel() {
        return this.positionModel;
    }

    public final ChoiceModelApp getStyleModel() {
        return this.styleModel;
    }

    public void setAirflow(int n, boolean bl) {
        this.setAirflow(n, bl, false);
    }

    public void setAirflow(int n, boolean bl, boolean bl2) {
        super.setAirflow(n, bl);
        this.airflowDirty = true;
        if (this.syncPredictedDisplay[0] && !this.isWaitingForAcknowledge(0)) {
            if (this.airflowTimer.isRunning() && !bl2) {
                this.logChannel.log(10000000, "[AirconNozzleCtrl(%1)#setAirflow] Timer is still running.", (Object)this.getName());
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

    public void setHorizontalPosition(int n, boolean bl) {
        this.setHorizontalPosition(n, bl, false);
    }

    public void setHorizontalPosition(int n, boolean bl, boolean bl2) {
        super.setHorizontalPosition(n, bl);
        this.horizontalPositionDirty = true;
        if (this.syncPredictedDisplay[1] && !this.isWaitingForAcknowledge(1)) {
            if (this.positionTimer.isRunning() && !bl2) {
                this.logChannel.log(10000000, "[AirconNozzleCtrl(%1)#setHorizontalPosition] Timer is still running.", (Object)this.getName());
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

    public void setVerticalPosition(int n, boolean bl) {
        this.setVerticalPosition(n, bl, false);
    }

    public void setVerticalPosition(int n, boolean bl, boolean bl2) {
        super.setVerticalPosition(n, bl);
        this.verticalPositionDirty = true;
        if (this.syncPredictedDisplay[2] && !this.isWaitingForAcknowledge(2)) {
            if (this.positionTimer.isRunning() && !bl2) {
                this.logChannel.log(10000000, "[AirconNozzleCtrl(%1)#setVerticalPosition] Timer is still running.", (Object)this.getName());
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
                this.logChannel.log(10000000, "[AirconNozzleCtrl(%1)#setPosition] Timer is still running.", (Object)this.getName());
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

    public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl) {
        this.setStyle(airconNozzleListStyles, bl, false);
    }

    public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl, boolean bl2) {
        super.setStyle(airconNozzleListStyles, bl);
        this.styleDirty = true;
        if (this.syncPredictedDisplay[3] && !this.isWaitingForAcknowledge(3)) {
            if (this.styleTimer.isRunning() && !bl2) {
                this.logChannel.log(10000000, "[AirconNozzleCtrl(%1)#setStyle] Timer is still running.", (Object)this.getName());
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

    public class InvertValueConverterStrategy
    implements IValueConverterStrategy {
        public Object getDSIValue(Object object) {
            return new Integer(-((Integer)object).intValue());
        }

        public Object getHMIValue(Object object) {
            return new Integer(-((Integer)object).intValue());
        }
    }

    public class DefaultStyleConverterStrategy
    implements IValueConverterStrategy {
        public Object getDSIValue(Object object) {
            switch ((Integer)object) {
                case 0: {
                    return new AirconNozzleListStyles(false, false, false, true);
                }
                case 1: {
                    return new AirconNozzleListStyles(false, false, true, false);
                }
                case 2: {
                    return new AirconNozzleListStyles(false, true, false, false);
                }
                case 3: {
                    return new AirconNozzleListStyles(true, false, false, false);
                }
            }
            return new AirconNozzleListStyles();
        }

        public Object getHMIValue(Object object) {
            AirconNozzleListStyles airconNozzleListStyles = (AirconNozzleListStyles)object;
            if (!airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && airconNozzleListStyles.isManual()) {
                return new Integer(0);
            }
            if (!airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
                return new Integer(1);
            }
            if (!airconNozzleListStyles.isInterval() && airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
                return new Integer(2);
            }
            if (airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
                return new Integer(3);
            }
            return new Integer(-1);
        }
    }
}

