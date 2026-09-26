/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler;

class AbstractMiniAppHandler$2
implements TransitionCallback {
    private final /* synthetic */ AbstractMiniAppHandler this$0;

    AbstractMiniAppHandler$2(AbstractMiniAppHandler abstractMiniAppHandler) {
        this.this$0 = abstractMiniAppHandler;
    }

    @Override
    public void triggerTransition() {
        this.this$0.modelHandler.fireOptionEvent();
    }
}

