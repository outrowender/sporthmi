/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.ude.IEApplication;
import de.audi.tghu.swdl.ude.IEApplication$1;

class IEApplication$ImportOrExportButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ IEApplication this$0;

    private IEApplication$ImportOrExportButtonListener(IEApplication iEApplication) {
        this.this$0 = iEApplication;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 1300060: {
                IEApplication.access$300(this.this$0).log(-2137614336, "[IEApplication.keyTyped] model:%1 -> IMPORT", (long)n);
                this.this$0.getChoiceModel(1607865088).setValue(0);
                this.this$0.getButtonModel(1557533440).fireEvent(n3);
                break;
            }
            case 1300059: {
                IEApplication.access$300(this.this$0).log(-2137614336, "[IEApplication.keyTyped] model:%1 -> EXPORT", (long)n);
                this.this$0.getChoiceModel(1607865088).setValue(1);
                this.this$0.getButtonModel(1540756224).fireEvent(n3);
                break;
            }
            default: {
                IEApplication.access$300(this.this$0).log(10000, "[IEApplication.keyTyped] Unknown model %1!", (long)n);
            }
        }
    }

    /* synthetic */ IEApplication$ImportOrExportButtonListener(IEApplication iEApplication, IEApplication$1 iEApplication$1) {
        this(iEApplication);
    }
}

