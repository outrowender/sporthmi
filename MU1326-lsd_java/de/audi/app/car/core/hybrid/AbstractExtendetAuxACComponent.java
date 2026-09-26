/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.auxheater.AbstractDSICarAuxheaterCoolerAdapter;
import de.audi.app.car.core.hybrid.AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;

public abstract class AbstractExtendetAuxACComponent
extends AbstractDSICarAuxheaterCoolerAdapter {
    private static final String LOGCHANNEL_NAME;
    private final int CHECKBOX_SELECTED;
    private final int CHECKBOX_NOTSELECTED;
    protected volatile AuxHeaterCoolerViewOptions currViewOptions;

    public AbstractExtendetAuxACComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AuxAc");
        this.CHECKBOX_SELECTED = 1;
        this.CHECKBOX_NOTSELECTED = 0;
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{18, 20, 19})};
    }

    @Override
    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent:updateAuxHeaterCoolerViewOptions] (%1), valid:%2", (Object)auxHeaterCoolerViewOptions, (long)n);
        if (auxHeaterCoolerViewOptions != null && n == 1) {
            this.currViewOptions = auxHeaterCoolerViewOptions;
            this.updateMenuEntryVisibility(auxHeaterCoolerViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public String getName() {
        return "ExtendedAuxAC";
    }

    @Override
    protected void initModels() {
        AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO abstractExtendetAuxACComponent$AuxACChoiceListenerEVO = new AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO(this, null);
        this.getChoiceModel(1664223488).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
        this.getChoiceModel(1530005760).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
        this.getChoiceModel(1513228544).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
        this.getChoiceModel(1613891840).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
        this.getChoiceModel(1597114624).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
        this.getChoiceModel(1630669056).setChoiceListener(abstractExtendetAuxACComponent$AuxACChoiceListenerEVO);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(1664223488).resetListener();
        this.getChoiceModel(1530005760).resetListener();
        this.getChoiceModel(1513228544).resetListener();
        this.getChoiceModel(1613891840).resetListener();
        this.getChoiceModel(1597114624).resetListener();
        this.getChoiceModel(1630669056).resetListener();
    }

    @Override
    public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerWindowHeating] validFlag: %1", (long)n);
        if (n == 1) {
            this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerWindowHeating] setup: %1, state: %2", bl, bl2);
            this.getChoiceModel(1664223488).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerUnlockClimating] validFlag: %1", (long)n2);
        if (n2 == 1) {
            this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerUnlockClimating] setup: %1", (long)n);
            this.getChoiceModel(1530005760).setValue(n == 1 ? 1 : 0);
        }
    }

    @Override
    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerExtendedConditioning] validFlag: %1", (long)n);
        if (n == 1) {
            this.updateZ1rl(auxHeaterCoolerExtendedConditioning.z1rl, auxHeaterCoolerExtendedConditioning2.z1rl);
            this.updateZ1rr(auxHeaterCoolerExtendedConditioning.z1rr, auxHeaterCoolerExtendedConditioning2.z1rr);
            this.updateZ2rl(auxHeaterCoolerExtendedConditioning.z2rl, auxHeaterCoolerExtendedConditioning2.z2rl);
            this.updateZ2rr(auxHeaterCoolerExtendedConditioning.z2rr, auxHeaterCoolerExtendedConditioning2.z2rr);
        }
    }

    private void updateZ2rr(boolean bl, boolean bl2) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateZ2rr] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(1630669056).setValue(bl ? 1 : 0);
    }

    private void updateZ2rl(boolean bl, boolean bl2) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateZ2rl] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(1597114624).setValue(bl ? 1 : 0);
    }

    private void updateZ1rr(boolean bl, boolean bl2) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateZ1rr] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(1613891840).setValue(bl ? 1 : 0);
    }

    private void updateZ1rl(boolean bl, boolean bl2) {
        this.getLogChannel().log(1078071040, "[AbstractExtendetAuxACComponent#updateZ1rl] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(1513228544).setValue(bl ? 1 : 0);
    }

    public static boolean isQ5Coded(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 4 && iFrameworkAccess.getSysConst(469) == 2 && iFrameworkAccess.getSysConst(467) == 6;
    }

    static /* synthetic */ void access$100(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractExtendetAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$400(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$600(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$700(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, int n) {
        return abstractExtendetAuxACComponent.getChoiceModel(n);
    }
}

