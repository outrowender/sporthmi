/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tghu.swdl.ude.IEApplication;
import de.audi.tghu.swdl.ude.IEApplication$1;
import de.audi.tghu.swdl.ude.IEClient;

class IEApplication$SDorUSBChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ IEApplication this$0;

    private IEApplication$SDorUSBChoiceListener(IEApplication iEApplication) {
        this.this$0 = iEApplication;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 1300064: {
                IEApplication.access$300(this.this$0).log(-2137614336, "[IEApplication.itemSelected] model:%1 -> USB", (long)n);
                IEApplication.access$402(this.this$0, 0);
                break;
            }
            case 1300062: {
                IEApplication.access$300(this.this$0).log(-2137614336, "[IEApplication.itemSelected] model:%1 -> SD", (long)n);
                IEApplication.access$402(this.this$0, 1);
                break;
            }
            default: {
                IEApplication.access$300(this.this$0).log(10000, "[IEApplication.itemSelected] Unknown model %1! ", (long)n);
                return;
            }
        }
        this.this$0.getChoiceModel(1574310656).setStatus(0);
        this.this$0.getChoiceModel(1624642304).fireEvent(n4);
        IEClient.WORKING_DIR.mkdirs();
        if (IEApplication.access$500(this.this$0)) {
            IEApplication.access$600(this.this$0);
        } else {
            IEApplication.access$700(this.this$0);
        }
    }

    /* synthetic */ IEApplication$SDorUSBChoiceListener(IEApplication iEApplication, IEApplication$1 iEApplication$1) {
        this(iEApplication);
    }
}

