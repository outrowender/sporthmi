/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALStatistics;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import java.util.ArrayList;
import java.util.List;

class EALStatistics$Slot {
    private final IWrappedNode3D node;
    private List textNodes;
    private final /* synthetic */ EALStatistics this$0;

    public EALStatistics$Slot(EALStatistics eALStatistics) {
        this.this$0 = eALStatistics;
        float f2 = EALStatistics.access$100(eALStatistics) / EALStatistics.access$200(eALStatistics);
        float f3 = EALStatistics.access$300(eALStatistics) / EALStatistics.access$400(eALStatistics);
        this.node = EALStatistics.access$500(eALStatistics).createNode3D(EALStatistics.access$500(eALStatistics).getStatisticsNode(), "statistics", f2, f3);
    }

    public void setInfo(String[] stringArray) {
        IWrappedNode3DText iWrappedNode3DText;
        int n;
        if (this.textNodes == null) {
            this.textNodes = new ArrayList(stringArray.length);
        }
        while (this.textNodes.size() < stringArray.length) {
            IWrappedNode3DText iWrappedNode3DText2 = EALStatistics.access$500(this.this$0).createText3D(this.node, "statisticstext", " ", EALStatistics.access$600(this.this$0));
            long l = EALManager.createColorCode(65535);
            iWrappedNode3DText2.getInterfaceText().setColor(l);
            int n2 = this.textNodes.size();
            iWrappedNode3DText2.setPosition(41024, n2 * (EALStatistics.access$700(this.this$0) + 2) + EALStatistics.access$700(this.this$0), 0.0f);
            this.textNodes.add(iWrappedNode3DText2);
        }
        for (n = 0; n < stringArray.length; ++n) {
            iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(n);
            iWrappedNode3DText.setText(stringArray[n], EALStatistics.access$600(this.this$0));
            iWrappedNode3DText.setVisible(true);
        }
        for (n = stringArray.length; n < this.textNodes.size(); ++n) {
            iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(n);
            iWrappedNode3DText.setVisible(false);
        }
    }

    public void remove() {
        for (int i2 = 0; i2 < this.textNodes.size(); ++i2) {
            IWrappedNode3DText iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(i2);
            EALStatistics.access$500(this.this$0).destroy(iWrappedNode3DText);
        }
        EALStatistics.access$500(this.this$0).destroy(this.node);
    }

    public void setPosition(int n, int n2) {
        this.node.setPosition(n, n2, 0.0f);
    }

    static /* synthetic */ List access$000(EALStatistics$Slot eALStatistics$Slot) {
        return eALStatistics$Slot.textNodes;
    }
}

