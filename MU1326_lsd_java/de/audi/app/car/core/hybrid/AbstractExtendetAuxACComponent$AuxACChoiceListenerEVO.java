/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractExtendetAuxACComponent;
import de.audi.app.car.core.hybrid.AbstractExtendetAuxACComponent$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;

final class AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractExtendetAuxACComponent this$0;

    private AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent) {
        this.this$0 = abstractExtendetAuxACComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AbstractExtendetAuxACComponent.access$100(this.this$0, "[AuxACChoiceListenerEVO#itemSelected] ", n, n2, true);
        switch (n) {
            case 602723: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_WINDOWS_CHOICE selected.");
                if (AbstractExtendetAuxACComponent.access$200(this.this$0, 1664223488).getValue() == 1) {
                    this.this$0.getDSI().setAuxHeaterCoolerWindowHeating(false);
                    break;
                }
                this.this$0.getDSI().setAuxHeaterCoolerWindowHeating(true);
                break;
            }
            case 602715: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_KEY_ACTIVATION_CHOICE selected.");
                if (AbstractExtendetAuxACComponent.access$300(this.this$0, 1530005760).getValue() == 1) {
                    this.this$0.getDSI().setAuxHeaterCoolerUnlockClimating(0);
                    break;
                }
                this.this$0.getDSI().setAuxHeaterCoolerUnlockClimating(1);
                break;
            }
            case 602714: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_DRIVERZONE_CHOICE selected.");
                this.sendAuxHeaterCoolerExtendedConditioningSetup(1513228544);
                break;
            }
            case 602720: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_CODRIVERZONE_CHOICE selected.");
                this.sendAuxHeaterCoolerExtendedConditioningSetup(1613891840);
                break;
            }
            case 602719: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_BACK_LEFT_ZONE_CHOICE selected.");
                this.sendAuxHeaterCoolerExtendedConditioningSetup(1597114624);
                break;
            }
            case 602721: {
                this.this$0.getLogChannel().log(1078071040, "[AuxACChoiceListenerEVO#itemSelected] AUX_AC_ALLOW_BACK_RIGHT_ZONE_CHOICE selected.");
                this.sendAuxHeaterCoolerExtendedConditioningSetup(1630669056);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(10000, "[AuxheaterChoiceListenerEVO#itemSelected] invalid modelID=%1", (long)n);
            }
        }
    }

    private void sendAuxHeaterCoolerExtendedConditioningSetup(int n) {
        boolean bl = AbstractExtendetAuxACComponent.access$400(this.this$0, 1513228544).getValue() == 1;
        boolean bl2 = AbstractExtendetAuxACComponent.access$500(this.this$0, 1613891840).getValue() == 1;
        boolean bl3 = AbstractExtendetAuxACComponent.access$600(this.this$0, 1597114624).getValue() == 1;
        boolean bl4 = AbstractExtendetAuxACComponent.access$700(this.this$0, 1630669056).getValue() == 1;
        switch (n) {
            case 602714: {
                this.this$0.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(!bl, bl2, bl3, bl4));
                break;
            }
            case 602720: {
                this.this$0.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, !bl2, bl3, bl4));
                break;
            }
            case 602719: {
                this.this$0.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, bl2, !bl3, bl4));
                break;
            }
            case 602721: {
                this.this$0.getDSI().setAuxHeaterCoolerExtendedConditioning(new AuxHeaterCoolerExtendedConditioning(bl, bl2, bl3, !bl4));
                break;
            }
            default: {
                this.this$0.getLogChannel().log(10000, "[AuxheaterChoiceListenerEVO#sendAuxHeaterCoolerExtendedConditioningSetup] invalid modelID=%1", (long)n);
            }
        }
    }

    /* synthetic */ AbstractExtendetAuxACComponent$AuxACChoiceListenerEVO(AbstractExtendetAuxACComponent abstractExtendetAuxACComponent, AbstractExtendetAuxACComponent$1 abstractExtendetAuxACComponent$1) {
        this(abstractExtendetAuxACComponent);
    }
}

