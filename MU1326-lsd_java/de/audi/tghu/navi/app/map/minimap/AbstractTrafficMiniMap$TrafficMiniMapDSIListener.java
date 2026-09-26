/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.DSIAsiaTrafficInfoMenuListenerAdapter;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class AbstractTrafficMiniMap$TrafficMiniMapDSIListener
extends DSIAsiaTrafficInfoMenuListenerAdapter {
    private final /* synthetic */ AbstractTrafficMiniMap this$0;

    protected AbstractTrafficMiniMap$TrafficMiniMapDSIListener(AbstractTrafficMiniMap abstractTrafficMiniMap) {
        this.this$0 = abstractTrafficMiniMap;
    }

    @Override
    public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
        this.this$0.logChannel.log(1078071040, "TrafficMiniMapDSIListener#updateActiveInterrupts interrupts=%1 with valid=%2", (Object)interruptArray, (long)n);
        if (1 != n) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Invalid flag!");
            return;
        }
        if (!AbstractTrafficMiniMap.access$100(this.this$0)) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts No cruise mode!");
            return;
        }
        if (!this.this$0.isActive()) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Not active!");
            return;
        }
        if (null == interruptArray) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-array is null!");
            return;
        }
        if (interruptArray.length < 1) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-len < 1!");
            return;
        }
        Interrupt[] interruptArray2 = AbstractTrafficMiniMap.access$200(this.this$0).getNewInterrupts(interruptArray);
        if (0 == interruptArray2.length) {
            this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts received no new interrupts out of %1", (long)interruptArray.length);
        }
        Interrupt interrupt = null;
        for (int i2 = 0; i2 < interruptArray2.length; ++i2) {
            this.this$0.logChannel.log(1078071040, "TrafficMiniMapDSIListener#updateActiveInterrupts %1/%2", (long)(1 + i2), (long)interruptArray2.length);
            interrupt = interruptArray2[i2];
            if (null == interrupt) {
                this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt[%1] is null!", (long)i2);
                return;
            }
            this.this$0.logChannel.log(1078071040, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt[%1] id=%2.", (long)i2, (long)interrupt.getInterruptId());
            if (!AbstractTrafficMiniMap.access$300(this.this$0, interrupt.getInterruptType())) {
                this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Bad interrupt type=%1! -> continue", (long)interrupt.getInterruptType());
                continue;
            }
            if (interrupt.getInterruptId() == this.this$0.getCurrentlyDisplayedID()) {
                this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-id already known/displayed %1!", (long)interrupt.getInterruptId());
                return;
            }
            AbstractTrafficMiniMap.access$402(this.this$0, interrupt.getInterruptId());
            int[] nArray = interrupt.getContentID();
            if (null == nArray) {
                this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts contentIDs nulled! - > continue");
                continue;
            }
            if (0 == nArray.length) {
                this.this$0.logChannel.log(-1601830656, "TrafficMiniMapDSIListener#updateActiveInterrupts contentIDs is empty array! - > continue");
                continue;
            }
            this.this$0.requestResourceInformation(nArray[0]);
            break;
        }
    }

    @Override
    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.this$0.logChannel.log(1078071040, "TrafficMiniMap#requestResourceInformationResponse resourceInformation = %1", (Object)resourceInformation);
        this.this$0.view.displayMiniMap(resourceInformation);
    }
}

