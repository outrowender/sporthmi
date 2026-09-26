/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler;

class AbstractMiniAppHandler$1
implements TimerListener {
    private final /* synthetic */ AbstractMiniAppHandler this$0;

    AbstractMiniAppHandler$1(AbstractMiniAppHandler abstractMiniAppHandler) {
        this.this$0 = abstractMiniAppHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.logChannel.log(-2137614336, "RemoteHMIAppsBaseListener#errorOccured#Timer#fireTimer: Called");
        ChoiceModelApp choiceModelApp = this.this$0.env.getChoiceModel(1847403264);
        if (choiceModelApp.getStatus() == 2) {
            this.this$0.configureModelsMiniApps(3, 0);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

