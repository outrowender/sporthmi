/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.as;

import de.audi.app.phone.evo.as.TelInitPhoneNotFuncAssociatedHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelInitPhoneNotFuncAssociatedHandler$1
implements IPhoneDiagComponent {
    private final /* synthetic */ TelInitPhoneNotFuncAssociatedHandler this$0;

    TelInitPhoneNotFuncAssociatedHandler$1(TelInitPhoneNotFuncAssociatedHandler telInitPhoneNotFuncAssociatedHandler) {
        this.this$0 = telInitPhoneNotFuncAssociatedHandler;
    }

    public void cmdShowTelInitPhoneNotFuncAssociatedPopup(boolean bl) {
        if (bl) {
            TelInitPhoneNotFuncAssociatedHandler.access$000(this.this$0).requestShowPopup();
        } else {
            TelInitPhoneNotFuncAssociatedHandler.access$000(this.this$0).requestRemovePopup();
        }
    }
}

