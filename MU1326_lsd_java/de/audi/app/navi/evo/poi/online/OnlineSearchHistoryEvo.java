/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.OnlineSearchHistory;
import de.audi.tghu.navi.app.util.Util;

public class OnlineSearchHistoryEvo
extends OnlineSearchHistory {
    public OnlineSearchHistoryEvo(NavigationEnv navigationEnv, ListModelApp listModelApp, ListModelApp listModelApp2, SpellerModelApp spellerModelApp) {
        super(navigationEnv, listModelApp, listModelApp2, spellerModelApp);
    }

    @Override
    protected void refreshHistoryAccess() {
        if (!this.SDSSearch) {
            int n = this.historyList.getLength();
            boolean bl = Util.isEmpty(this.searchSpeller.getText());
            int n2 = Util.isEmpty(this.searchSpeller.getText()) ? 0 : 1;
            switch (n) {
                case 0: {
                    this.searchSpeller.setExitButtonText(0);
                    this.searchSpeller.setControlButtonStates(-1, n2);
                    break;
                }
                case 1: {
                    this.searchSpeller.setExitButtonText(0);
                    this.searchSpeller.setControlButtonStates(-1, n2);
                    break;
                }
                default: {
                    if (bl) {
                        this.searchSpeller.setExitButtonText(1);
                        this.searchSpeller.setControlButtonStates(-1, 1);
                        break;
                    }
                    this.searchSpeller.setExitButtonText(1);
                    this.searchSpeller.setControlButtonStates(-1, n2);
                    break;
                }
            }
        } else {
            this.searchSpeller.setExitButtonText(1);
            this.searchSpeller.setControlButtonStates(-1, 1);
        }
    }
}

