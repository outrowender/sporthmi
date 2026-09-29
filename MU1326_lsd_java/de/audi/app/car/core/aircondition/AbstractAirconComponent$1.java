/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class AbstractAirconComponent$1
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractAirconComponent this$0;

    AbstractAirconComponent$1(AbstractAirconComponent abstractAirconComponent) {
        this.this$0 = abstractAirconComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractAirconComponent.DefaultChoiceListener#itemSelected] modelID=%1, itemID=%2", (long)n, (long)n2);
        boolean bl = 1 == n2;
        switch (n) {
            case 602126: {
                AbstractAirconComponent.access$1600(this.this$0, bl);
                break;
            }
            case 602390: {
                AbstractAirconComponent.access$1700(this.this$0, bl);
                break;
            }
            case 602127: {
                AbstractAirconComponent.access$1800(this.this$0, bl);
                break;
            }
            case 600631: {
                AbstractAirconComponent.access$1900(this.this$0, n2);
                break;
            }
            case 601247: {
                AbstractAirconComponent.access$2000(this.this$0, n2);
                break;
            }
            case 602365: {
                AbstractAirconComponent.access$2100(this.this$0, bl);
                break;
            }
            case 602397: {
                AbstractAirconComponent.access$2200(this.this$0, this.this$0.invertHMIIndirectVentilation ? !bl : bl);
                break;
            }
            case 600629: {
                AbstractAirconComponent.access$2300(this.this$0, bl);
                break;
            }
            case 600644: {
                AbstractAirconComponent.access$2400(this.this$0, bl);
                break;
            }
            case 602129: {
                AbstractAirconComponent.access$2500(this.this$0, bl);
                break;
            }
            case 600660: {
                AbstractAirconComponent.access$2600(this.this$0, bl);
                break;
            }
            case 602125: {
                AbstractAirconComponent.access$2700(this.this$0, bl);
                break;
            }
            case 602409: {
                if (null == this.this$0.currentViewOptionsRow1) break;
                if (2 == this.this$0.currentViewOptionsRow1.getZoneLeftViewOptions().getAirconIonisator().getState()) {
                    AbstractAirconComponent.access$2800(this.this$0, 1, n2);
                }
                if (2 != this.this$0.currentViewOptionsRow1.getZoneRightViewOptions().getAirconIonisator().getState()) break;
                AbstractAirconComponent.access$2800(this.this$0, 2, n2);
                break;
            }
            case 602366: {
                if (null == this.this$0.currentViewOptionsMaster) break;
                boolean bl2 = this.this$0.currentViewOptionsMaster.getConfiguration().isCarDriverSide();
                int n5 = bl ? (bl2 ? 2 : 1) : 0;
                AbstractAirconComponent.access$2900(this.this$0, n5, bl);
                break;
            }
            case 602408: {
                AbstractAirconComponent.access$3000(this.this$0, 1, this.this$0.invertHMISystemOnOffState ? !bl : bl);
                break;
            }
            case 602418: {
                AbstractAirconComponent.access$3100(this.this$0, 1, n2);
                this.this$0.onFootwellTemperatureAction(1);
                break;
            }
            case 602210: {
                AbstractAirconComponent.access$3100(this.this$0, 2, n2);
                this.this$0.onFootwellTemperatureAction(2);
                break;
            }
            case 602367: {
                AbstractAirconComponent.access$3200(this.this$0, 1, n2);
                this.this$0.onClimateStyleAction(1);
                break;
            }
            case 601969: {
                AbstractAirconComponent.access$3200(this.this$0, 2, n2);
                this.this$0.onClimateStyleAction(2);
                break;
            }
            case 602158: {
                this.this$0.airVolumeZone1.dsiSetVolumeAuto(n2);
                break;
            }
            case 602161: {
                this.this$0.airVolumeZone2.dsiSetVolumeAuto(n2);
                break;
            }
            case 602400: {
                this.this$0.airDistributionZone1.dsiSetUp(bl ? 12 : 0);
                break;
            }
            case 602136: {
                this.this$0.airDistributionZone1.dsiSetBody(bl ? 12 : 0);
                break;
            }
            case 602361: {
                this.this$0.airDistributionZone1.dsiSetFootwell(bl ? 12 : 0);
                break;
            }
            case 602145: {
                this.this$0.airDistributionZone1.dsiSetAutomode(bl);
                break;
            }
            case 602139: {
                this.this$0.airDistributionZone2.dsiSetUp(bl ? 12 : 0);
                break;
            }
            case 602404: {
                this.this$0.airDistributionZone2.dsiSetBody(bl ? 12 : 0);
                break;
            }
            case 602144: {
                this.this$0.airDistributionZone2.dsiSetFootwell(bl ? 12 : 0);
                break;
            }
            case 602134: {
                this.this$0.airDistributionZone2.dsiSetAutomode(bl);
                break;
            }
            case 602124: {
                AbstractAirconComponent.access$3000(this.this$0, 2, this.this$0.invertHMISystemOnOffState ? !bl : bl);
                break;
            }
            case 602209: {
                AbstractAirconComponent.access$3100(this.this$0, 3, n2);
                this.this$0.onFootwellTemperatureAction(3);
                break;
            }
            case 602207: {
                AbstractAirconComponent.access$3100(this.this$0, 4, n2);
                this.this$0.onFootwellTemperatureAction(4);
                break;
            }
            case 601966: {
                AbstractAirconComponent.access$3200(this.this$0, 3, n2);
                this.this$0.onClimateStyleAction(3);
                break;
            }
            case 601967: {
                AbstractAirconComponent.access$3200(this.this$0, 4, n2);
                this.this$0.onClimateStyleAction(4);
                break;
            }
            case 602159: {
                this.this$0.airVolumeZone3.dsiSetVolumeAuto(n2);
                break;
            }
            case 602160: {
                this.this$0.airVolumeZone4.dsiSetVolumeAuto(n2);
                break;
            }
            case 602132: {
                this.this$0.airDistributionZone3.dsiSetUp(bl ? 12 : 0);
                break;
            }
            case 602374: {
                this.this$0.airDistributionZone3.dsiSetBody(bl ? 12 : 0);
                break;
            }
            case 602417: {
                this.this$0.airDistributionZone3.dsiSetFootwell(bl ? 12 : 0);
                break;
            }
            case 602140: {
                this.this$0.airDistributionZone3.dsiSetAutomode(bl);
                break;
            }
            case 602138: {
                this.this$0.airDistributionZone4.dsiSetUp(bl ? 12 : 0);
                break;
            }
            case 602384: {
                this.this$0.airDistributionZone4.dsiSetBody(bl ? 12 : 0);
                break;
            }
            case 602401: {
                this.this$0.airDistributionZone4.dsiSetFootwell(bl ? 12 : 0);
                break;
            }
            case 602141: {
                this.this$0.airDistributionZone4.dsiSetAutomode(bl);
                break;
            }
            case 602130: {
                AbstractAirconComponent.access$3000(this.this$0, 3, this.this$0.invertHMISystemOnOffState ? !bl : bl);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AbstractAirconComponent.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
            }
        }
    }
}

