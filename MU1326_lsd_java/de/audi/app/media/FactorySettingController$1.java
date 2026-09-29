/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.FactorySettingController;
import de.audi.app.media.IMediaTerminal;

class FactorySettingController$1
implements Runnable {
    private final /* synthetic */ int val$resetmode;
    private final /* synthetic */ int val$dsiResetMode;
    private final /* synthetic */ FactorySettingController this$0;

    FactorySettingController$1(FactorySettingController factorySettingController, int n, int n2) {
        this.this$0 = factorySettingController;
        this.val$resetmode = n;
        this.val$dsiResetMode = n2;
    }

    @Override
    public void run() {
        if (this.val$resetmode != 3) {
            for (int i2 = 0; i2 < 8; ++i2) {
                IMediaTerminal iMediaTerminal = FactorySettingController.access$000(this.this$0)[i2];
                if (iMediaTerminal == null) continue;
                FactorySettingController.access$100(this.this$0).log(1078071040, "[%1.runResetFactorySettings] +++++ Reset terminal '%2' +++++.", (Object)"FactorySettingController", (Object)iMediaTerminal);
                try {
                    iMediaTerminal.resetSettings(this.val$resetmode == 2 ? 1 : 0);
                    continue;
                }
                catch (Exception exception) {
                    FactorySettingController.access$100(this.this$0).log(-1601830656, "[%1.runResetFactorySettings] Error: %2", (Object)"FactorySettingController", (Throwable)exception);
                }
            }
        }
        if (!FactorySettingController.access$200(this.this$0).requestResetFactorySettings(this.val$dsiResetMode)) {
            FactorySettingController.access$100(this.this$0).log(1078071040, "[%1.runResetFactorySettings] DSI reset fails.", (Object)"FactorySettingController");
            FactorySettingController.access$302(this.this$0, false);
        }
    }
}

