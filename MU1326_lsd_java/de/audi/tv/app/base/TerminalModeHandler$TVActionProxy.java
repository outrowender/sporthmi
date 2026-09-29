/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.ap.TVActionProxyDefaultListenerEvo;
import de.audi.tv.app.base.TerminalModeHandler;
import de.audi.tv.app.base.TerminalModeHandler$1;

class TerminalModeHandler$TVActionProxy
extends TVActionProxyDefaultListenerEvo {
    private final /* synthetic */ TerminalModeHandler this$0;

    private TerminalModeHandler$TVActionProxy(TerminalModeHandler terminalModeHandler) {
        this.this$0 = terminalModeHandler;
    }

    @Override
    public void tvDataBroadcastEntered(int n) {
        Integer n2 = (Integer)TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).correctDataBroadcastTerminalMode.get();
        if (n2 != null) {
            TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(n2);
        }
    }

    @Override
    public void tvEPGEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(13));
    }

    @Override
    public void tvTeletextEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(1));
    }

    @Override
    public void tvEngineeringEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(15));
    }

    @Override
    public void tvCasDisclaimerEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(12));
    }

    @Override
    public void tvVisualAudioEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(14));
    }

    @Override
    public void avFullscreenEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(0));
    }

    @Override
    public void tvParentalRatingLeft(int n) {
    }

    @Override
    public void tvTxtEntered(int n) {
        TerminalModeHandler.access$100((TerminalModeHandler)this.this$0).desiredTerminalMode.accept(new Integer(11));
    }

    /* synthetic */ TerminalModeHandler$TVActionProxy(TerminalModeHandler terminalModeHandler, TerminalModeHandler$1 terminalModeHandler$1) {
        this(terminalModeHandler);
    }
}

