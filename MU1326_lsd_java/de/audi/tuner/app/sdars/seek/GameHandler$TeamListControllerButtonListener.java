/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;
import de.audi.tuner.app.sdars.seek.TeamRow;

class GameHandler$TeamListControllerButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$TeamListControllerButtonListener(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100764: {
                this.setAllEntriesSelected(true);
                break;
            }
            case 100763: {
                this.setAllEntriesSelected(false);
                break;
            }
        }
    }

    private void setAllEntriesSelected(boolean bl) {
        int n = GameHandler.access$1300(this.this$0).getLength() - GameHandler.access$2300(this.this$0);
        if (bl && n > GameHandler.access$2400(this.this$0).getRemainingSpace(3)) {
            GameHandler.access$2500(this.this$0).showPartialPopup(18);
        } else {
            int n2 = bl ? 1 : 3;
            int n3 = bl ? n : GameHandler.access$2300(this.this$0);
            int n4 = bl ? 1 : 0;
            int[] nArray = new int[n3];
            int[] nArray2 = new int[n3];
            int n5 = 0;
            for (int i2 = 0; i2 < GameHandler.access$1300(this.this$0).getLength(); ++i2) {
                TeamRow teamRow = (TeamRow)GameHandler.access$1300(this.this$0).getRow(i2);
                if (teamRow.getActivationCheckBox() == n4) continue;
                nArray[n5] = teamRow.getTeamID();
                nArray2[n5] = teamRow.getLeagueId();
                ++n5;
            }
            GameHandler.access$2600(this.this$0).bulkManageSeek2(3, nArray, nArray2, n2);
        }
    }

    /* synthetic */ GameHandler$TeamListControllerButtonListener(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

