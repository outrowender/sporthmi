/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.auxheater.AbstractDSICarAuxheaterCoolerAdapter;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;

public abstract class AbstractExtendetAuxACComponent
extends AbstractDSICarAuxheaterCoolerAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.AuxAc";
    private final int CHECKBOX_SELECTED;
    private final int CHECKBOX_NOTSELECTED;
    protected volatile AuxHeaterCoolerViewOptions currViewOptions;

    public AbstractExtendetAuxACComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.CHECKBOX_SELECTED = 1;
        this.CHECKBOX_NOTSELECTED = 0;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{18, 20, 19})};
    }

    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent:updateAuxHeaterCoolerViewOptions] (%1), valid:%2", (Object)auxHeaterCoolerViewOptions, (long)n);
        if (auxHeaterCoolerViewOptions != null && n == 1) {
            this.currViewOptions = auxHeaterCoolerViewOptions;
            this.updateMenuEntryVisibility(auxHeaterCoolerViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions var1);

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public String getName() {
        return "ExtendedAuxAC";
    }

    protected void initModels() {
        AuxACChoiceListenerEVO auxACChoiceListenerEVO = new AuxACChoiceListenerEVO();
        this.getChoiceModel(602723).setChoiceListener(auxACChoiceListenerEVO);
        this.getChoiceModel(602715).setChoiceListener(auxACChoiceListenerEVO);
        this.getChoiceModel(602714).setChoiceListener(auxACChoiceListenerEVO);
        this.getChoiceModel(602720).setChoiceListener(auxACChoiceListenerEVO);
        this.getChoiceModel(602719).setChoiceListener(auxACChoiceListenerEVO);
        this.getChoiceModel(602721).setChoiceListener(auxACChoiceListenerEVO);
    }

    protected void deinitModels() {
        this.getChoiceModel(602723).resetListener();
        this.getChoiceModel(602715).resetListener();
        this.getChoiceModel(602714).resetListener();
        this.getChoiceModel(602720).resetListener();
        this.getChoiceModel(602719).resetListener();
        this.getChoiceModel(602721).resetListener();
    }

    public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerWindowHeating] validFlag: %1", (long)n);
        if (n == 1) {
            this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerWindowHeating] setup: %1, state: %2", bl, bl2);
            this.getChoiceModel(602723).setValue(bl ? 1 : 0);
        }
    }

    public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerUnlockClimating] validFlag: %1", (long)n2);
        if (n2 == 1) {
            this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerUnlockClimating] setup: %1", (long)n);
            this.getChoiceModel(602715).setValue(n == 1 ? 1 : 0);
        }
    }

    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateAuxHeaterCoolerExtendedConditioning] validFlag: %1", (long)n);
        if (n == 1) {
            this.updateZ1rl(auxHeaterCoolerExtendedConditioning.z1rl, auxHeaterCoolerExtendedConditioning2.z1rl);
            this.updateZ1rr(auxHeaterCoolerExtendedConditioning.z1rr, auxHeaterCoolerExtendedConditioning2.z1rr);
            this.updateZ2rl(auxHeaterCoolerExtendedConditioning.z2rl, auxHeaterCoolerExtendedConditioning2.z2rl);
            this.updateZ2rr(auxHeaterCoolerExtendedConditioning.z2rr, auxHeaterCoolerExtendedConditioning2.z2rr);
        }
    }

    private void updateZ2rr(boolean bl, boolean bl2) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateZ2rr] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(602721).setValue(bl ? 1 : 0);
    }

    private void updateZ2rl(boolean bl, boolean bl2) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateZ2rl] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(602719).setValue(bl ? 1 : 0);
    }

    private void updateZ1rr(boolean bl, boolean bl2) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateZ1rr] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(602720).setValue(bl ? 1 : 0);
    }

    private void updateZ1rl(boolean bl, boolean bl2) {
        this.getLogChannel().log(1000000, "[AbstractExtendetAuxACComponent#updateZ1rl] setup: %1, state: %2", bl, bl2);
        this.getChoiceModel(602714).setValue(bl ? 1 : 0);
    }

    public static boolean isQ5Coded(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 4 && iFrameworkAccess.getSysConst(469) == 2 && iFrameworkAccess.getSysConst(467) == 6;
    }

    private final class AuxACChoiceListenerEVO
    extends DefaultChoiceListener {
        private AuxACChoiceListenerEVO() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractExtendetAuxACComponent.this.logModelData("[AuxACChoiceListenerEVO#itemSelected] ", n, n2, true);
            switch (n) {
                case 602723: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_WINDOWS_CHOICE selected.");
                    if (AbstractExtendetAuxACComponent.this.getChoiceModel(602723).getValue() == 1) {
                        AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerWindowHeating(false);
                        break;
                    }
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerWindowHeating(true);
                    break;
                }
                case 602715: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_KEY_ACTIVATION_CHOICE selected.");
                    if (AbstractExtendetAuxACComponent.this.getChoiceModel(602715).getValue() == 1) {
                        AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerUnlockClimating(0);
                        break;
                    }
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerUnlockClimating(1);
                    break;
                }
                case 602714: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_DRIVERZONE_CHOICE selected.");
                    this.sendAuxHeaterCoolerExtendedConditioningSetup(602714);
                    break;
                }
                case 602720: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_CODRIVERZONE_CHOICE selected.");
                    this.sendAuxHeaterCoolerExtendedConditioningSetup(602720);
                    break;
                }
                case 602719: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_BACK_LEFT_ZONE_CHOICE selected.");
                    this.sendAuxHeaterCoolerExtendedConditioningSetup(602719);
                    break;
                }
                case 602721: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(1000000, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_BACK_RIGHT_ZONE_CHOICE selected.");
                    this.sendAuxHeaterCoolerExtendedConditioningSetup(602721);
                    break;
                }
                default: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(10000, "[AuxheaterChoiceListenerEVO#itemSelected] invalid modelID=%1", (long)n);
                }
            }
        }

        private void sendAuxHeaterCoolerExtendedConditioningSetup(int n) {
            boolean bl = AbstractExtendetAuxACComponent.this.getChoiceModel(602714).getValue() == 1;
            boolean bl2 = AbstractExtendetAuxACComponent.this.getChoiceModel(602720).getValue() == 1;
            boolean bl3 = AbstractExtendetAuxACComponent.this.getChoiceModel(602719).getValue() == 1;
            boolean bl4 = AbstractExtendetAuxACComponent.this.getChoiceModel(602721).getValue() == 1;
            switch (n) {
                case 602714: {
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(!bl, bl2, bl3, bl4));
                    break;
                }
                case 602720: {
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, !bl2, bl3, bl4));
                    break;
                }
                case 602719: {
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, bl2, !bl3, bl4));
                    break;
                }
                case 602721: {
                    AbstractExtendetAuxACComponent.this.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, bl2, bl3, !bl4));
                    break;
                }
                default: {
                    AbstractExtendetAuxACComponent.this.getLogChannel().log(10000, "[AuxheaterChoiceListenerEVO#sendAuxHeaterCoolerExtendedConditioningSetup] invalid modelID=%1", (long)n);
                }
            }
        }
    }
}

