/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.JokerKeyHandler;

public class JokerKeyHandlerEvo
extends JokerKeyHandler {
    public JokerKeyHandlerEvo(IFrameworkAccess iFrameworkAccess, AbstractOnlineActivator abstractOnlineActivator) {
        super(iFrameworkAccess, abstractOnlineActivator);
    }

    protected void removePopup() {
        this.framework.getHmiServiceApp().removePopup(500001);
    }
}

