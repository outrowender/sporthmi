/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.preferredstations;

import de.audi.app.navi.evo.addressinput.poi.preferredstations.EvoPreferredStationsHMIListener$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.IPreferredStations;

public class EvoPreferredStationsHMIListener
implements ButtonListener,
BaseListModelListener {
    private final NavigationEnv env;
    private final IPreferredStations handler;
    private final LogChannel logChannel;
    private static final int PREFERRED_BUTTON;
    private static final int PREFERRED_LIST;

    public EvoPreferredStationsHMIListener(NavigationEnv navigationEnv, IPreferredStations iPreferredStations) {
        this.env = navigationEnv;
        this.handler = iPreferredStations;
        this.logChannel = navigationEnv.getLogChannel();
        this.setupListeners();
    }

    private void setupListeners() {
        this.env.getButtonModel(-1289812480).setButtonListener(this);
        this.env.getBaseListModel(-1273035264).setListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "EvoPreferredStationsHMIListener#keyPressed - modelID: %1; keyID: %2", (long)n, (long)n2);
        if (n == -1289812480) {
            EvoPreferredStationsHMIListener$1 evoPreferredStationsHMIListener$1 = new EvoPreferredStationsHMIListener$1(this, n, n3);
            this.handler.onStart(0, 101, evoPreferredStationsHMIListener$1);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "EvoPreferredStationsHMIListener#itemSelected - row: %1, model: %2, index: %3", (Object)evoListRow, (long)n, (long)n2);
        if (n == -1273035264) {
            int n5 = (int)evoListRow.getUniqueID();
            this.handler.toggleBrandPreferrence(n5);
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

