/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestSearchTimerAsia$1;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;

public class IntelliDestSearchTimerAsia
implements IIntelliDestSearchTimer {
    private static final int ASIA_SEARCH_BUTTON_TIMERDELAY;
    private static final int SHOW;
    protected Timer timerAsia;
    public NavigationEnv env;
    public LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia;

    protected IntelliDestSearchTimerAsia(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        IntelliDestSearchTimerAsia$1 intelliDestSearchTimerAsia$1 = new IntelliDestSearchTimerAsia$1(this, logChannel);
        this.timerAsia = new Timer("IntelliDestSearchTimerAsia", 5, logChannel, intelliDestSearchTimerAsia$1, 0, false);
    }

    @Override
    public void restart() {
        this.timerAsia.restart();
        this.env.getChoiceModel(-1306327552).setValue(0);
    }

    @Override
    public void stop() {
        this.timerAsia.cancel();
    }

    private void displayOnlineSearchButton() {
        this.env.getChoiceModel(-1306327552).setValue(1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(IntelliDestSearchTimerAsia intelliDestSearchTimerAsia) {
        intelliDestSearchTimerAsia.displayOnlineSearchButton();
    }
}

