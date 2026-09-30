/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.operatorcall.INaviOperatorCallService;
import de.audi.tghu.navi.app.util.Util;

public class NaviOperatorCallListener
implements ButtonListener {
    private static final int OPERATOR_CALL_BUTTON_ID = 402031;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final INaviOperatorCallService naviOperatorCallService;
    private final INavigationInputModeManager inputModeManager;

    public NaviOperatorCallListener(NavigationEnv navigationEnv, INaviOperatorCallService iNaviOperatorCallService) {
        this.env = navigationEnv;
        this.naviOperatorCallService = iNaviOperatorCallService;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.registerListeners();
    }

    private void registerListeners() {
        this.env.getButtonModel(402031).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyPressed - modelID=%2", (Object)this.CLASS_NAME, (long)n);
        if (n == 402031) {
            int n4 = this.inputModeManager.getInputMode();
            if (n4 == 2) {
                this.naviOperatorCallService.setContext(3);
            } else if (n4 == 1) {
                this.naviOperatorCallService.setContext(4);
            } else {
                this.logChannel.log(100000, "%1#keyPressed - no match found", (Object)this.CLASS_NAME);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

