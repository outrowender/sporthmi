/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.phone;

import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.phone.TelServiceController;
import de.audi.tghu.navi.app.phone.TelServiceController$IOperation;

class TelServiceController$3
implements TelServiceController$IOperation {
    private final /* synthetic */ String val$number;
    private final /* synthetic */ ITelServiceListener val$responseListener;
    private final /* synthetic */ TelServiceController this$0;

    TelServiceController$3(TelServiceController telServiceController, String string, ITelServiceListener iTelServiceListener) {
        this.this$0 = telServiceController;
        this.val$number = string;
        this.val$responseListener = iTelServiceListener;
    }

    @Override
    public void execute(ITelService iTelService) {
        iTelService.prepareDialing(this.val$number, this.val$responseListener);
    }
}

