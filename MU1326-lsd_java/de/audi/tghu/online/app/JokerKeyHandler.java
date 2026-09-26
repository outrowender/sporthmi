/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.Online;

public class JokerKeyHandler
implements ButtonListener {
    protected AbstractOnlineActivator online;
    protected IFrameworkAccess framework;
    protected LogChannel logger = Online.getInstance().getLogChannel();

    public JokerKeyHandler(IFrameworkAccess iFrameworkAccess, AbstractOnlineActivator abstractOnlineActivator) {
        this.framework = iFrameworkAccess;
        this.online = abstractOnlineActivator;
        this.registerButtons();
    }

    private void registerButtons() {
        this.framework.getHMIService().getButtonModel(1209869056).setButtonListener(this);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (n == 1209869056) {
            int n4 = this.framework.getHMIService().getChoiceModel(395).getValue();
            if (n4 == 11 && this.online.isPoiCallCoded()) {
                this.online.startOperatorCallByJokerKey(2, n, n2, n3);
                this.removePopup();
            } else if (n4 == 11 && this.online.isConciergeCallCoded()) {
                this.online.startOperatorCallByJokerKey(1, n, n2, n3);
                this.removePopup();
            }
        }
    }

    protected void removePopup() {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    public void sendMessage(int n) {
        this.framework.getMsgDistrib().sendMessage(n);
    }
}

