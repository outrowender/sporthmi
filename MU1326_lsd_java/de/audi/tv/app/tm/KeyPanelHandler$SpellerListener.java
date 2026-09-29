/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.audi.tv.app.tm.KeyPanelHandler$1;

class KeyPanelHandler$SpellerListener
extends DefaultSpellerListener {
    private final /* synthetic */ KeyPanelHandler this$0;

    private KeyPanelHandler$SpellerListener(KeyPanelHandler keyPanelHandler) {
        this.this$0 = keyPanelHandler;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        KeyPanelHandler.access$400((KeyPanelHandler)this.this$0).lcHMI.log(-2137614336, "[KeyPanelHandler.SpellerListener.keyReleased] key:0x%1", (long)n2);
        if (n2 >= 0 && n2 <= 9) {
            short s = TVUtil.KEYPANEL_NUMBER_CODES[n2];
            KeyPanelHandler.access$600(this.this$0, s, (short)1);
            KeyPanelHandler.access$600(this.this$0, s, (short)0);
        }
    }

    /* synthetic */ KeyPanelHandler$SpellerListener(KeyPanelHandler keyPanelHandler, KeyPanelHandler$1 keyPanelHandler$1) {
        this(keyPanelHandler);
    }
}

