/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.kombi.AbstractSpeedWarningManualComponent$SpeedWarningHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCViewOptions;

public abstract class AbstractSpeedWarningManualComponent
extends AbstractDSICarKombiAdapter
implements RangeListener,
ChoiceListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile BCViewOptions currentViewOptions;
    private final AbstractSpeedWarningManualComponent$SpeedWarningHandler handler = new AbstractSpeedWarningManualComponent$SpeedWarningHandler(this);

    public AbstractSpeedWarningManualComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.SpeedWarning.Manual");
    }

    @Override
    protected void initModels() {
        this.getRangeModel(-1423308544).setRangeListener(this);
        this.getChoiceModel(1647118592).setChoiceListener(this);
        this.handler.initModels();
    }

    @Override
    protected void deinitModels() {
        this.handler.deinitModels();
        this.getRangeModel(-1423308544).resetListener();
        this.getChoiceModel(1647118592).resetListener();
    }

    protected synchronized void saveCurrentSpeedSetting() {
        BCSpeedWarningSettings bCSpeedWarningSettings = this.handler.getChangedSpeedWarning();
        this.getLogChannel().log(1078071040, "dsi.setBCSpeedWarning(%1)", (Object)bCSpeedWarningSettings);
        this.getDSI().setBCSpeedWarning(bCSpeedWarningSettings);
    }

    protected synchronized void resetSpeedSetting() {
        this.handler.resetChangeSetting();
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateBCViewOptions: '%1', valid='%2'", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && bCViewOptions != null) {
            this.currentViewOptions = bCViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public synchronized void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateBCSpeedWarning: '%1', valid='%2'", (Object)bCSpeedWarningSettings, (long)n);
        }
        if (n == 1) {
            this.handler.setCurrentSpeedWarning(bCSpeedWarningSettings);
        }
    }

    @Override
    public void updateBCLifeTipsDisplay(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateBCLifeTipsDisplay: enable='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(1647118592).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "keyPressed: model='%1'", (long)n);
        switch (n) {
            case 600747: {
                this.getRangeModel(-1423308544).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1078071040, "itemSelected: model='%1' , itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 601442: {
                this.setBCLiveTips(n2 == 1);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "decrement: model=%1, steps=%2", (long)n, (long)n2);
        }
        if (n == -1423308544) {
            this.handler.changeSetting(-n2);
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "increment: model=%1, steps=%2", (long)n, (long)n2);
        }
        if (n == -1423308544) {
            this.handler.changeSetting(n2);
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{33, 21})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
    }

    @Override
    public String getName() {
        return "SpeedWarningManual";
    }

    private void setBCLiveTips(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setBCLifeTipsDisplay(%1)", bl);
        this.getDSI().setBCLifeTipsDisplay(bl);
    }

    static /* synthetic */ MetricsModelApp access$000(AbstractSpeedWarningManualComponent abstractSpeedWarningManualComponent, int n) {
        return abstractSpeedWarningManualComponent.getMetricsModel(n);
    }

    static /* synthetic */ RangeModelApp access$100(AbstractSpeedWarningManualComponent abstractSpeedWarningManualComponent, int n) {
        return abstractSpeedWarningManualComponent.getRangeModel(n);
    }

    static /* synthetic */ MetricsModelApp access$200(AbstractSpeedWarningManualComponent abstractSpeedWarningManualComponent, int n) {
        return abstractSpeedWarningManualComponent.getMetricsModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractSpeedWarningManualComponent abstractSpeedWarningManualComponent, int n) {
        return abstractSpeedWarningManualComponent.getChoiceModel(n);
    }
}

