/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.audi.tv.app.tm.KeyPanelHandler$1;

class KeyPanelHandler$ChoiceListenerImpl
extends DefaultChoiceListener {
    private final /* synthetic */ KeyPanelHandler this$0;

    private KeyPanelHandler$ChoiceListenerImpl(KeyPanelHandler keyPanelHandler) {
        this.this$0 = keyPanelHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        KeyPanelHandler.access$400((KeyPanelHandler)this.this$0).lcHMI.log(-2137614336, "[KeyPanelHandler.keyPressed] keyID:0x%1", (long)n2);
        KeyPanelHandler.access$600(this.this$0, (short)n2, (short)1);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        KeyPanelHandler.access$400((KeyPanelHandler)this.this$0).lcHMI.log(-2137614336, "[KeyPanelHandler.keyReleased] keyID:0x%1", (long)n2);
        KeyPanelHandler.access$600(this.this$0, (short)n2, (short)0);
    }

    /* synthetic */ KeyPanelHandler$ChoiceListenerImpl(KeyPanelHandler keyPanelHandler, KeyPanelHandler$1 keyPanelHandler$1) {
        this(keyPanelHandler);
    }
}

