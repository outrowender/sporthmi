/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.app.car.core.comfort.AbstractRDKComponent$RDKBaseListModelListener;
import de.audi.app.car.core.comfort.AbstractRDKComponent$RDKButtonListener;
import de.audi.app.car.core.comfort.AbstractRDKComponent$RDKChoiceListener;
import de.audi.app.car.core.comfort.IRDKTireDisplay;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;

public abstract class AbstractRDKComponent
extends AbstractDSICarComfortAdapter
implements TimerListener {
    private static final byte RKA_SAVE_PROCESSING;
    private static final byte RKA_SAVE_COMPLETED_WITH_ERROR;
    private static final byte RKA_SAVE_COMPLETED_SUCCESSFULLY;
    private static final String LOGCHANNEL_NAME;
    public static final String LOGCHANNEL_NAME_HIGH_FREQUENT;
    public static final short CODING_ID;
    public volatile RDKViewOptions currentViewOptions;
    protected final IRDKTireDisplay rdkTireDisplay;
    private final Timer rdkSavePressureResponseTimer;
    private static final long RDK_SAVE_PRESSURE_RESPONSE_TIMER_TIME;
    private final Object mutex = new Object();

    public AbstractRDKComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.RDK");
        this.setLogChannelFrequent(true);
        this.rdkTireDisplay = this.getRDKTireDisplayInstance();
        this.rdkSavePressureResponseTimer = new Timer("RDKSavePressureResponseTimer", 0, true, this);
    }

    @Override
    protected void initModels() {
        AbstractRDKComponent$RDKButtonListener abstractRDKComponent$RDKButtonListener = new AbstractRDKComponent$RDKButtonListener(this, null);
        AbstractRDKComponent$RDKChoiceListener abstractRDKComponent$RDKChoiceListener = new AbstractRDKComponent$RDKChoiceListener(this, null);
        AbstractRDKComponent$RDKBaseListModelListener abstractRDKComponent$RDKBaseListModelListener = new AbstractRDKComponent$RDKBaseListModelListener(this, null);
        this.getButtonModel(640223488).setButtonListener(abstractRDKComponent$RDKButtonListener);
        this.getButtonModel(707332352).setButtonListener(abstractRDKComponent$RDKButtonListener);
        this.getChoiceModel(674236672).setChoiceListener(abstractRDKComponent$RDKChoiceListener);
        this.getChoiceModel(1445857536).setChoiceListener(abstractRDKComponent$RDKChoiceListener);
        this.getBaseListModel(1982728448).setListener(abstractRDKComponent$RDKBaseListModelListener);
        this.rdkTireDisplay.initialize();
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(640223488).resetListener();
        this.getButtonModel(707332352).resetListener();
        this.getChoiceModel(674236672).resetListener();
        this.getChoiceModel(1445857536).resetListener();
        this.getBaseListModel(1982728448).resetListener();
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKViewOptions] '%1', valid:%2", (Object)rDKViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = rDKViewOptions;
            this.updateMenuEntryVisibility(rDKViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKTireSetupTireList] tireList='%1', valid:%2", (Object)rDKTireInfoArray, (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateTireSetupTireList(rDKTireInfoArray);
        }
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKTireSetupSelectedTire] selectedTire='%1', valid:%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rdkTireDisplay.updateTireSetupSelectedTire(n);
        }
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKTireDisplay] '%1'', valid:%2", (Object)rDKTireDisplayData, (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateDisplayData(rDKTireDisplayData);
        }
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKSpeedLimit] speedLimit='%1', valid='%2'", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rdkTireDisplay.updateSpeedLimit(n);
            try {
                int n3 = (Integer)this.getRdkSpeedLimitConverterStrategy().getHMIValue(new Integer(n));
                this.getChoiceModel(674236672).setValue(n3);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractRDKComponent#updateRDKPressureLevel] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKDifferentialPressure] wheelPressures='%1', valid='%2'", (Object)(null == rDKWheelPressures ? "null" : rDKWheelPressures.toString()), (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateDifferentialPressure(rDKWheelPressures);
        }
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#updateRDKPressureLevel] level='%1', valid='%2'", (long)by, (long)n);
        if (1 == n) {
            try {
                int n2 = (Integer)this.getRdkPressureLevelConverterStrategy().getHMIValue(new Byte(by));
                this.getChoiceModel(1445857536).setValue(n2);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractRDKComponent#updateRDKPressureLevel] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseRDKPressureChanged(int n) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#responseRDKPressureChanged] state='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (n == 3) {
                this.rdkSavePressureResponseTimer.cancel();
                this.setRKASaveState((byte)1);
            } else if (n == 2) {
                this.rdkSavePressureResponseTimer.cancel();
                this.setRKASaveState((byte)2);
            }
        }
    }

    @Override
    public void responseRDKLifeMonitoring() {
        this.getLogChannel(3).log(1078071040, "[AbstractRDComponent#responseRDKLifeMonitoring] Answering with DSI-Call.");
        this.getDSI().requestRDKLifeMonitoring();
    }

    private void savePressurePressed(int n) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#savePressurePressed] -> DSI.setRDKPressureChanged()");
        this.setRKASaveState((byte)0);
        this.getButtonModel(640223488).fireEvent(n);
        this.getDSI().setRDKPressureChanged();
        this.rdkSavePressureResponseTimer.start();
    }

    private void setRDKTireProfile(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractRDKComponent#setRDKTireProfile] ---> DSI.setRDKTireSetupSelectedTire(position='%1') called.", (long)n);
        }
        this.getDSI().setRDKTireSetupSelectedTire(n);
    }

    private void setRDKSpeedLimit(int n) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#setRDKSpeedLimit] ---> DSI.setRDKSpeedLimit(speedLimit='%1') called.", (long)n);
        this.getDSI().setRDKSpeedLimit(n);
    }

    private void setRDKPressureLevel(byte by) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#setRDKPressureLevel] ---> DSI.setRDKPressureLevel(level='%1') called.", (long)by);
        this.getDSI().setRDKPressureLevel(by);
    }

    private void tireChangePressed(int n) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#tireChangePressed] ---> DSI.setRDKTireChanged()");
        this.getDSI().setRDKTireChanged();
        this.getButtonModel(707332352).fireEvent(n);
    }

    private void setRKASaveState(byte by) {
        this.getLogChannel().log(1078071040, "[AbstractRDKComponent#setRKASaveState] state='%1'", (long)by);
        switch (by) {
            case 0: {
                this.getChoiceModel(657000704).setStatus(0);
                this.getChoiceModel(657000704).setValue(0);
                break;
            }
            case 1: {
                this.getChoiceModel(657000704).setStatus(1);
                this.getChoiceModel(657000704).setValue(-1);
                break;
            }
            case 2: {
                this.getChoiceModel(657000704).setStatus(1);
                this.getChoiceModel(657000704).setValue(0);
                break;
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{33}, new int[]{35, 36, 37, 38, 62, 63})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(RDKViewOptions rDKViewOptions) {
    }

    protected abstract IRDKTireDisplay getRDKTireDisplayInstance() {
    }

    protected abstract IValueConverterStrategy getRdkSpeedLimitConverterStrategy() {
    }

    protected abstract IValueConverterStrategy getRdkPressureLevelConverterStrategy() {
    }

    @Override
    public String getName() {
        return "RDK";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            this.setRKASaveState((byte)1);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    static /* synthetic */ void access$300(AbstractRDKComponent abstractRDKComponent, int n) {
        abstractRDKComponent.savePressurePressed(n);
    }

    static /* synthetic */ void access$400(AbstractRDKComponent abstractRDKComponent, int n) {
        abstractRDKComponent.tireChangePressed(n);
    }

    static /* synthetic */ void access$500(AbstractRDKComponent abstractRDKComponent, int n) {
        abstractRDKComponent.setRDKSpeedLimit(n);
    }

    static /* synthetic */ void access$600(AbstractRDKComponent abstractRDKComponent, byte by) {
        abstractRDKComponent.setRDKPressureLevel(by);
    }

    static /* synthetic */ void access$700(AbstractRDKComponent abstractRDKComponent, int n) {
        abstractRDKComponent.setRDKTireProfile(n);
    }
}

