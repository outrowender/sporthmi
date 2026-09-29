/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.tghu.browser.app.ContextSwitchBrowserHandler;

class ContextSwitchBrowserHandler$1
implements ChoiceListener {
    private final /* synthetic */ ContextSwitchBrowserHandler this$0;

    ContextSwitchBrowserHandler$1(ContextSwitchBrowserHandler contextSwitchBrowserHandler) {
        this.this$0 = contextSwitchBrowserHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n2 == -2) {
            this.this$0.internalResumeBrowser();
        } else if (n2 == -3) {
            this.this$0.internalSuspendBrowser();
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

