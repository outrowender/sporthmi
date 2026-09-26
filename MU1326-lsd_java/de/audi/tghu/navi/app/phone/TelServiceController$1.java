/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.phone;

import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.phone.TelServiceController;
import de.audi.tghu.navi.app.phone.TelServiceController$IOperation;

class TelServiceController$1
implements TelServiceController$IOperation {
    private final /* synthetic */ String val$number;
    private final /* synthetic */ ITelServiceListener val$responseListener;
    private final /* synthetic */ boolean val$jumpToPhone;
    private final /* synthetic */ TelServiceController this$0;

    TelServiceController$1(TelServiceController telServiceController, String string, ITelServiceListener iTelServiceListener, boolean bl) {
        this.this$0 = telServiceController;
        this.val$number = string;
        this.val$responseListener = iTelServiceListener;
        this.val$jumpToPhone = bl;
    }

    @Override
    public void execute(ITelService iTelService) {
        iTelService.dialNumber(this.val$number, this.val$responseListener, this.val$jumpToPhone);
    }
}

