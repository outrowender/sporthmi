/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.combi.bap.app.phone.InitializationManagerPhone;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;

class InitializationManagerPhone$1
implements Callable {
    private final /* synthetic */ InitializationManagerPhone this$0;

    InitializationManagerPhone$1(InitializationManagerPhone initializationManagerPhone) {
        this.this$0 = initializationManagerPhone;
    }

    @Override
    public Object call() {
        InitializationManagerPhone.access$000(this.this$0).log(1078071040, "[InitializationManagerPhone#notifyDataValidChanged] call state transmission not pending; resend op state");
        InitializationManagerPhone.access$100(this.this$0).resendLastStatus();
        return null;
    }
}

