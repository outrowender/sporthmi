/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;

public class IntelliDestSearchTimerAsia
implements IIntelliDestSearchTimer {
    private static final int ASIA_SEARCH_BUTTON_TIMERDELAY = 10000;
    private static final int SHOW = 1;
    protected Timer timerAsia;
    public NavigationEnv env;
    public LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia;

    protected IntelliDestSearchTimerAsia(NavigationEnv navigationEnv, final LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        TimerListener timerListener = new TimerListener(){

            public void fireTimer(Timer timer) {
                if (logChannel != null) {
                    logChannel.log(10000000, "%1#fireTimer() -> displayOnlineSearchButton()", (Object)(class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia == null ? (class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia = IntelliDestSearchTimerAsia.class$("de.audi.app.navi.evo.search.IntelliDestSearchTimerAsia")) : class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia).getName());
                }
                IntelliDestSearchTimerAsia.this.displayOnlineSearchButton();
            }

            public void cancelTimer(Timer timer) {
            }
        };
        this.timerAsia = new Timer("IntelliDestSearchTimerAsia", 5, logChannel, timerListener, 10000L, false);
    }

    public void restart() {
        this.timerAsia.restart();
        this.env.getChoiceModel(402354).setValue(0);
    }

    public void stop() {
        this.timerAsia.cancel();
    }

    private void displayOnlineSearchButton() {
        this.env.getChoiceModel(402354).setValue(1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

