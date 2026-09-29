/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$1;
import de.audi.app.car.core.app.IRangeModelSyncListener;
import de.audi.app.car.core.app.IRangeModelSyncParameterAccess;

class AbstractAirconComponent$RangeModelSyncListener
implements IRangeModelSyncListener {
    private final /* synthetic */ AbstractAirconComponent this$0;

    private AbstractAirconComponent$RangeModelSyncListener(AbstractAirconComponent abstractAirconComponent) {
        this.this$0 = abstractAirconComponent;
    }

    @Override
    public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirconComponent.RangeModelSyncListener#setDSIParameter] called with attribute ID: %1", (long)iRangeModelSyncParameterAccess.getRangeModelID());
        switch (iRangeModelSyncParameterAccess.getAttributeID()) {
            case 25: {
                this.this$0.airVolumeZone1.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 31: {
                this.this$0.airVolumeZone2.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 37: {
                this.this$0.airVolumeZone3.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 43: {
                this.this$0.airVolumeZone4.dsiSetVolume(iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 27: {
                this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconFootwellTemp(%1, %2)", 1L, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                this.this$0.getDSI().setAirconFootwellTemp(1, iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 33: {
                this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconFootwellTemp(%1, %2)", (long)0, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                this.this$0.getDSI().setAirconFootwellTemp(2, iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 39: {
                this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconFootwellTemp(%1, %2)", (long)0, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                this.this$0.getDSI().setAirconFootwellTemp(4, iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 45: {
                this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconFootwellTemp(%1, %2)", (long)0, (long)iRangeModelSyncParameterAccess.getCurrentValue());
                this.this$0.getDSI().setAirconFootwellTemp(8, iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            case 5: {
                this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconAirCirculationSensitivity(%1)", (long)iRangeModelSyncParameterAccess.getCurrentValue());
                this.this$0.getDSI().setAirconAirCirculationSensitivity(iRangeModelSyncParameterAccess.getCurrentValue());
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AbstractAirconComponent.RangeModelSyncListener#setDSIParameter] Unexpected attribute ID: %1", (long)iRangeModelSyncParameterAccess.getRangeModelID());
            }
        }
    }

    @Override
    public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        AbstractAirconComponent.access$1100(this.this$0, iRangeModelSyncParameterAccess);
    }

    @Override
    public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        AbstractAirconComponent.access$1100(this.this$0, iRangeModelSyncParameterAccess);
    }

    /* synthetic */ AbstractAirconComponent$RangeModelSyncListener(AbstractAirconComponent abstractAirconComponent, AbstractAirconComponent$1 abstractAirconComponent$1) {
        this(abstractAirconComponent);
    }
}

