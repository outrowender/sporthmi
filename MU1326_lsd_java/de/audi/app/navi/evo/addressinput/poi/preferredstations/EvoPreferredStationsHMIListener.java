/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.preferredstations;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.IPreferredStations;
import de.audi.tghu.navi.app.command.NavCommand;

public class EvoPreferredStationsHMIListener
implements ButtonListener,
BaseListModelListener {
    private final NavigationEnv env;
    private final IPreferredStations handler;
    private final LogChannel logChannel;
    private static final int PREFERRED_BUTTON = 401331;
    private static final int PREFERRED_LIST = 401332;

    public EvoPreferredStationsHMIListener(NavigationEnv navigationEnv, IPreferredStations iPreferredStations) {
        this.env = navigationEnv;
        this.handler = iPreferredStations;
        this.logChannel = navigationEnv.getLogChannel();
        this.setupListeners();
    }

    private void setupListeners() {
        this.env.getButtonModel(401331).setButtonListener(this);
        this.env.getBaseListModel(401332).setListener(this);
    }

    public void keyPressed(final int n, int n2, final int n3) {
        this.logChannel.log(10000000, "EvoPreferredStationsHMIListener#keyPressed - modelID: %1; keyID: %2", (long)n, (long)n2);
        if (n == 401331) {
            NavCommand navCommand = new NavCommand(){

                public void execute() {
                    this.env.fireModelEvent(n, n3);
                    this.getCommandList().commandFinished();
                }
            };
            this.handler.onStart(0, 101, navCommand);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "EvoPreferredStationsHMIListener#itemSelected - row: %1, model: %2, index: %3", (Object)evoListRow, (long)n, (long)n2);
        if (n == 401332) {
            int n5 = (int)evoListRow.getUniqueID();
            this.handler.toggleBrandPreferrence(n5);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

