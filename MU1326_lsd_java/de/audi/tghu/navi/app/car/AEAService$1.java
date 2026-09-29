/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.tghu.navi.app.car.AEAService;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;

class AEAService$1
extends SimpleChoiceListener {
    private final /* synthetic */ AEAService this$0;

    AEAService$1(AEAService aEAService) {
        this.this$0 = aEAService;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AEAService.access$000(this.this$0).log(-2137614336, "AEAService<ChoiceListener>#itemSelected() - itemID:%1", (long)n2);
        AEAService.access$100(this.this$0).setValue(n2);
        if (AEAService.access$200(this.this$0) != null) {
            try {
                AEAService.access$200(this.this$0).setAEASystemActive(n2 == 1);
            }
            catch (Exception exception) {
                AEAService.access$000(this.this$0).log(10000, "AEAService<ChoiceListener>#itemSelected() - ERROR=%1", (Throwable)exception);
            }
        } else {
            AEAService.access$000(this.this$0).log(-2137614336, "AEAService<ChoiceListener>#itemSelected() - Audi Energy Service is not available");
        }
    }
}

