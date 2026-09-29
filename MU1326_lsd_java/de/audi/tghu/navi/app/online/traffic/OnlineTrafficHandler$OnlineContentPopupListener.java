/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;

class OnlineTrafficHandler$OnlineContentPopupListener
extends SimpleButtonListener {
    private NavigationEnv env;
    private final int ONLINE_OK_BUTTON_ID;
    private final int ONLINE_CANCEL_BUTTON_ID;
    private final int ONLINE_SHOWED_CHOICE_ID;
    private final /* synthetic */ OnlineTrafficHandler this$0;

    public OnlineTrafficHandler$OnlineContentPopupListener(OnlineTrafficHandler onlineTrafficHandler, NavigationEnv navigationEnv) {
        this.this$0 = onlineTrafficHandler;
        this.ONLINE_OK_BUTTON_ID = 1478624768;
        this.ONLINE_CANCEL_BUTTON_ID = 1512179200;
        this.ONLINE_SHOWED_CHOICE_ID = 1847723520;
        this.env = navigationEnv;
        navigationEnv.getButtonModel(1478624768).setButtonListener(this);
        navigationEnv.getButtonModel(1512179200).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.logChannel.log(-2137614336, "%1 -- OnlineContentPopupListener#keyPressed(%2, %3, %4)", (Object)this.this$0.CLASS_NAME, (Object)new StringBuffer().append(n).append("").toString(), (Object)new StringBuffer().append(n2).append("").toString(), (long)n3);
        if (n == 1478624768) {
            this.env.getChoiceModel(1847723520).setValue(1);
            this.env.fireModelEvent(n, n3);
        } else if (n == 1512179200) {
            this.env.getChoiceModel(1847723520).setValue(0);
            this.this$0.setOnlineTrafficCheckBoxState(false, true);
            this.env.fireModelEvent(n, n3);
        }
    }
}

