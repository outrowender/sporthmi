/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.presentationmode;

import de.audi.app.navi.evo.presentationmode.DemoModeHmiListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

class DemoModeHmiListener$1
extends SimpleButtonListener {
    private final /* synthetic */ NavigationEnv val$env;
    private final /* synthetic */ DemoModeManager val$demoModeManager;
    private final /* synthetic */ DemoModeHmiListener this$0;

    DemoModeHmiListener$1(DemoModeHmiListener demoModeHmiListener, NavigationEnv navigationEnv, DemoModeManager demoModeManager) {
        this.this$0 = demoModeHmiListener;
        this.val$env = navigationEnv;
        this.val$demoModeManager = demoModeManager;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        DemoModeHmiListener.access$000(this.this$0).fireEvent(DemoModeHmiListener.access$000(this.this$0).getTerminalID());
        this.val$env.getChoiceModel(1579091456).setValue(1);
        DemoModeHmiListener.access$100(this.this$0).crosshairEnterInMap(this.val$demoModeManager.getStartPosition());
    }
}

