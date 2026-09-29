/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$ChoiceListener;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$LocalMsgListener;
import de.audi.app.car.core.eco.AbstractDSICarEcoAdapter;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.careco.EAViewOptions;

public abstract class AbstractCharismaEcoComponent
extends AbstractDSICarEcoAdapter {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    public static final int DISABLED;
    public static final int ENABLED;
    private final AbstractCharismaEcoComponent$ChoiceListener modelListener = new AbstractCharismaEcoComponent$ChoiceListener(this, null);
    private final AbstractCharismaEcoComponent$LocalMsgListener msgListener = new AbstractCharismaEcoComponent$LocalMsgListener(this, null);
    protected volatile EAViewOptions currentViewOptions;
    protected boolean invertHMIStartStop = false;

    public AbstractCharismaEcoComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma.Eco");
    }

    protected void dsiSetStartStop(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setEAStartStop(%1)", bl);
        this.getDSI().setEAStartStop(bl);
    }

    protected void dsiSetFreeRolling(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setEAFreeWheeling(%1)", bl);
        this.getDSI().setEAFreeWheeling(bl);
    }

    protected boolean getStartStopStatus() {
        boolean bl;
        int n = this.getChoiceModel(1949174016).getValue();
        boolean bl2 = bl = 1 == n;
        return this.invertHMIStartStop ? !bl : bl;
    }

    public abstract void updateMenuEntryVisibility(EAViewOptions eAViewOptions) {
    }

    @Override
    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(1949174016).setChoiceListener(this.modelListener);
        this.getChoiceModel(1798179072).setChoiceListener(this.modelListener);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(1949174016).resetListener();
        this.getChoiceModel(1798179072).resetListener();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{42}, new int[]{48, 47})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions != null) {
            return this.currentViewOptions.toString();
        }
        return "not yet received";
    }

    @Override
    public String getName() {
        return "Charisma Eco";
    }

    @Override
    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CharismaEcoComponentPorscheGen2#updateEAViewOptions] '%1', valid:%2", (Object)eAViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = eAViewOptions;
            this.updateMenuEntryVisibility(eAViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateEAFreeWheeling(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CharismaEcoComponentPorscheGen2#updateEAFreeWheeling] '%1', valid:%2", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(1798179072).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateEAStartStop(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CharismaEcoComponentPorscheGen2#updateEAStartStop] '%1', valid:%2", bl, (long)n);
        }
        if (n == 1) {
            int n2 = this.invertHMIStartStop ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(1949174016).setValue(n2);
        }
    }

    static /* synthetic */ void access$000(AbstractCharismaEcoComponent abstractCharismaEcoComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaEcoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$100(AbstractCharismaEcoComponent abstractCharismaEcoComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaEcoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractCharismaEcoComponent abstractCharismaEcoComponent, int n) {
        return abstractCharismaEcoComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractCharismaEcoComponent abstractCharismaEcoComponent, int n) {
        return abstractCharismaEcoComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$400(AbstractCharismaEcoComponent abstractCharismaEcoComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaEcoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$500(AbstractCharismaEcoComponent abstractCharismaEcoComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaEcoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$600(AbstractCharismaEcoComponent abstractCharismaEcoComponent, int n) {
        return abstractCharismaEcoComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$700(AbstractCharismaEcoComponent abstractCharismaEcoComponent, int n) {
        return abstractCharismaEcoComponent.getButtonModel(n);
    }
}

