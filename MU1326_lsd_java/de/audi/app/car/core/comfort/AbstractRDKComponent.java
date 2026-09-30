/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.app.car.core.comfort.IRDKTireDisplay;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;

public abstract class AbstractRDKComponent
extends AbstractDSICarComfortAdapter
implements TimerListener {
    private static final byte RKA_SAVE_PROCESSING = 0;
    private static final byte RKA_SAVE_COMPLETED_WITH_ERROR = 1;
    private static final byte RKA_SAVE_COMPLETED_SUCCESSFULLY = 2;
    private static final String LOGCHANNEL_NAME = "App.Car.RDK";
    public static final String LOGCHANNEL_NAME_HIGH_FREQUENT = "App.Car.RDK.Frequent";
    public static final short CODING_ID = 11;
    public volatile RDKViewOptions currentViewOptions;
    protected final IRDKTireDisplay rdkTireDisplay;
    private final Timer rdkSavePressureResponseTimer;
    private static final long RDK_SAVE_PRESSURE_RESPONSE_TIMER_TIME = 3000L;
    private final Object mutex = new Object();

    public AbstractRDKComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.setLogChannelFrequent(true);
        this.rdkTireDisplay = this.getRDKTireDisplayInstance();
        this.rdkSavePressureResponseTimer = new Timer("RDKSavePressureResponseTimer", 3000L, true, this);
    }

    protected void initModels() {
        RDKButtonListener rDKButtonListener = new RDKButtonListener();
        RDKChoiceListener rDKChoiceListener = new RDKChoiceListener();
        RDKBaseListModelListener rDKBaseListModelListener = new RDKBaseListModelListener();
        this.getButtonModel(600358).setButtonListener(rDKButtonListener);
        this.getButtonModel(600362).setButtonListener(rDKButtonListener);
        this.getChoiceModel(602152).setChoiceListener(rDKChoiceListener);
        this.getChoiceModel(601686).setChoiceListener(rDKChoiceListener);
        this.getBaseListModel(601718).setListener(rDKBaseListModelListener);
        this.rdkTireDisplay.initialize();
    }

    protected void deinitModels() {
        this.getButtonModel(600358).resetListener();
        this.getButtonModel(600362).resetListener();
        this.getChoiceModel(602152).resetListener();
        this.getChoiceModel(601686).resetListener();
        this.getBaseListModel(601718).resetListener();
    }

    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKViewOptions] '%1', valid:%2", (Object)rDKViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = rDKViewOptions;
            this.updateMenuEntryVisibility(rDKViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKTireSetupTireList] tireList='%1', valid:%2", (Object)rDKTireInfoArray, (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateTireSetupTireList(rDKTireInfoArray);
        }
    }

    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKTireSetupSelectedTire] selectedTire='%1', valid:%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rdkTireDisplay.updateTireSetupSelectedTire(n);
        }
    }

    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKTireDisplay] '%1'', valid:%2", (Object)rDKTireDisplayData, (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateDisplayData(rDKTireDisplayData);
        }
    }

    public void updateRDKSpeedLimit(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKSpeedLimit] speedLimit='%1', valid='%2'", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rdkTireDisplay.updateSpeedLimit(n);
            try {
                int n3 = (Integer)this.getRdkSpeedLimitConverterStrategy().getHMIValue(new Integer(n));
                this.getChoiceModel(602152).setValue(n3);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractRDKComponent#updateRDKPressureLevel] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKDifferentialPressure] wheelPressures='%1', valid='%2'", (Object)(null == rDKWheelPressures ? "null" : rDKWheelPressures.toString()), (long)n);
        }
        if (n == 1) {
            this.rdkTireDisplay.updateDifferentialPressure(rDKWheelPressures);
        }
    }

    public void updateRDKPressureLevel(byte by, int n) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#updateRDKPressureLevel] level='%1', valid='%2'", (long)by, (long)n);
        if (1 == n) {
            try {
                int n2 = (Integer)this.getRdkPressureLevelConverterStrategy().getHMIValue(new Byte(by));
                this.getChoiceModel(601686).setValue(n2);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractRDKComponent#updateRDKPressureLevel] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseRDKPressureChanged(int n) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#responseRDKPressureChanged] state='%1'", (long)n);
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

    public void responseRDKLifeMonitoring() {
        this.getLogChannel(3).log(1000000, "[AbstractRDComponent#responseRDKLifeMonitoring] Answering with DSI-Call.");
        this.getDSI().requestRDKLifeMonitoring();
    }

    private void savePressurePressed(int n) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#savePressurePressed] -> DSI.setRDKPressureChanged()");
        this.setRKASaveState((byte)0);
        this.getButtonModel(600358).fireEvent(n);
        this.getDSI().setRDKPressureChanged();
        this.rdkSavePressureResponseTimer.start();
    }

    private void setRDKTireProfile(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractRDKComponent#setRDKTireProfile] ---> DSI.setRDKTireSetupSelectedTire(position='%1') called.", (long)n);
        }
        this.getDSI().setRDKTireSetupSelectedTire(n);
    }

    private void setRDKSpeedLimit(int n) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#setRDKSpeedLimit] ---> DSI.setRDKSpeedLimit(speedLimit='%1') called.", (long)n);
        this.getDSI().setRDKSpeedLimit(n);
    }

    private void setRDKPressureLevel(byte by) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#setRDKPressureLevel] ---> DSI.setRDKPressureLevel(level='%1') called.", (long)by);
        this.getDSI().setRDKPressureLevel(by);
    }

    private void tireChangePressed(int n) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#tireChangePressed] ---> DSI.setRDKTireChanged()");
        this.getDSI().setRDKTireChanged();
        this.getButtonModel(600362).fireEvent(n);
    }

    private void setRKASaveState(byte by) {
        this.getLogChannel().log(1000000, "[AbstractRDKComponent#setRKASaveState] state='%1'", (long)by);
        switch (by) {
            case 0: {
                this.getChoiceModel(600359).setStatus(0);
                this.getChoiceModel(600359).setValue(0);
                break;
            }
            case 1: {
                this.getChoiceModel(600359).setStatus(1);
                this.getChoiceModel(600359).setValue(-1);
                break;
            }
            case 2: {
                this.getChoiceModel(600359).setStatus(1);
                this.getChoiceModel(600359).setValue(0);
                break;
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{33}, new int[]{35, 36, 37, 38, 62, 63})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(RDKViewOptions var1);

    protected abstract IRDKTireDisplay getRDKTireDisplayInstance();

    protected abstract IValueConverterStrategy getRdkSpeedLimitConverterStrategy() throws ValueConverterStrategyException;

    protected abstract IValueConverterStrategy getRdkPressureLevelConverterStrategy() throws ValueConverterStrategyException;

    public String getName() {
        return "RDK";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            this.setRKASaveState((byte)1);
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private final class RDKButtonListener
    extends DefaultButtonListener {
        private RDKButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AbstractRDKComponent.this.getLogChannel().log(10000000, "[AbstractRDKComponent#keyPressed] modelID='%1', keyID='%2'", (long)n, (long)n2);
            switch (n) {
                case 600358: {
                    AbstractRDKComponent.this.savePressurePressed(n3);
                    break;
                }
                case 600362: {
                    AbstractRDKComponent.this.tireChangePressed(n3);
                    break;
                }
            }
        }
    }

    private final class RDKChoiceListener
    extends DefaultChoiceListener {
        private RDKChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractRDKComponent.this.getLogChannel().log(10000000, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] modelID='%1', itemID='%2', col='%3'", (long)n, (long)n2, (long)n3);
            Integer n5 = new Integer(n2);
            switch (n) {
                case 602152: {
                    try {
                        int n6 = (Integer)AbstractRDKComponent.this.getRdkSpeedLimitConverterStrategy().getDSIValue(n5);
                        AbstractRDKComponent.this.setRDKSpeedLimit(n6);
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractRDKComponent.this.getLogChannel().log(10000, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                    }
                    break;
                }
                case 601686: {
                    try {
                        byte by = (Byte)AbstractRDKComponent.this.getRdkPressureLevelConverterStrategy().getDSIValue(n5);
                        AbstractRDKComponent.this.setRDKPressureLevel(by);
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractRDKComponent.this.getLogChannel().log(10000, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                    }
                    break;
                }
            }
        }
    }

    private final class RDKBaseListModelListener
    extends DefaultBaseListModelListener {
        private RDKBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            AbstractRDKComponent.this.getLogChannel().log(10000000, "[AbstractRDKComponent#itemSelected] modelID='%1', index='%2', col='%3'", (long)n, (long)n2, (long)n3);
            switch (n) {
                case 601718: {
                    if (evoListRow == null) break;
                    int n5 = evoListRow.getInteger(0);
                    AbstractRDKComponent.this.setRDKTireProfile(n5);
                    break;
                }
            }
        }
    }
}

