/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.joker;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.joker.JokerKeyHandler;
import de.audi.tv.app.joker.JokerKeyHandler$1;

class JokerKeyHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ JokerKeyHandler this$0;

    private JokerKeyHandler$ButtonListener(JokerKeyHandler jokerKeyHandler) {
        this.this$0 = jokerKeyHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        int n4 = JokerKeyHandler.access$100(this.this$0).getValue();
        boolean bl = JokerKeyHandler.access$200(this.this$0).hasAudioFocus(0);
        if (bl) {
            if (n4 == 9) {
                JokerKeyHandler.access$300(this.this$0).simulateHkNext(n3);
            } else if (n4 == 14) {
                JokerKeyHandler.access$300(this.this$0).simualteHkPrev(n3);
            }
        }
    }

    /* synthetic */ JokerKeyHandler$ButtonListener(JokerKeyHandler jokerKeyHandler, JokerKeyHandler$1 jokerKeyHandler$1) {
        this(jokerKeyHandler);
    }
}

