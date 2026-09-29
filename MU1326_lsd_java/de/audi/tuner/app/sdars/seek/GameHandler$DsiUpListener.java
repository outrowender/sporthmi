/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TeamEntry;

class GameHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$DsiUpListener(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
        GameHandler.access$900(this.this$0, leagueEntryArray);
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        GameHandler.access$1000(this.this$0, teamEntryArray);
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        GameHandler.access$1100(this.this$0, seekEntryArray);
    }

    @Override
    public void updateAvailability(int n) {
        if (n == 1) {
            GameHandler.access$1200(this.this$0).fireEvent(0);
            GameHandler.access$1300(this.this$0).fireEvent(0);
        }
    }

    /* synthetic */ GameHandler$DsiUpListener(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

