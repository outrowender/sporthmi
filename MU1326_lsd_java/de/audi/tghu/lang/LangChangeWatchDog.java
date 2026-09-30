/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang;

import de.audi.atip.i18n.ILanguageUIHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class LangChangeWatchDog
implements TimerListener {
    private final ILanguageUIHandler langMngrUI;
    private final Timer timer;

    public LangChangeWatchDog(ILanguageUIHandler iLanguageUIHandler) {
        this.langMngrUI = iLanguageUIHandler;
        this.timer = new Timer("LangChangeWatchDog", 15000L, true, this);
    }

    public void start() {
        this.timer.start();
    }

    public void stop() {
        this.timer.cancel();
    }

    public void fireTimer(Timer timer) {
        this.langMngrUI.langChangeFinished();
    }

    public void cancelTimer(Timer timer) {
    }
}

