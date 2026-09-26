/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.views;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IView;

public class RubberbandView
implements IView {
    private LogChannel logger;
    private BaseListModelApp blmRubberband;

    public RubberbandView(NavigationEnv navigationEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.GUI.Main");
        this.blmRubberband = navigationEnv.getBaseListModel(-1256258048);
        EvoListRow evoListRow = new EvoListRow(0L, 2);
        EvoListRow evoListRow2 = new EvoListRow(1L, 2);
        evoListRow.setInteger(0, 0);
        evoListRow.setLong(1, 0L);
        evoListRow2.setInteger(0, 0);
        evoListRow2.setLong(1, 0L);
        this.blmRubberband.append(evoListRow);
        this.blmRubberband.append(evoListRow2);
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void update(int n, long l, int n2, long l2) {
        this.getLogger().log(-2137614336, "RubberbandView#update( ) - distOld: %1, etaOld: %2", (long)n, l);
        this.getLogger().log(-2137614336, "RubberbandView#update( ) - new dist : %1, new eta : %2 )", (long)n2, l2);
        EvoListRow evoListRow = this.blmRubberband.getRow(0);
        evoListRow.setInteger(0, n);
        evoListRow.setLong(1, l);
        EvoListRow evoListRow2 = this.blmRubberband.getRow(1);
        evoListRow2.setInteger(0, n2);
        evoListRow2.setLong(1, l2);
        this.blmRubberband.setRow(0, evoListRow);
        this.blmRubberband.setRow(1, evoListRow2);
    }

    public void updateDraggedRoute(int n, long l) {
        this.getLogger().log(-2137614336, "RubberbandView#updateDraggedRoute( ) - new dist : %1, new eta : %2 )", (long)n, l);
        EvoListRow evoListRow = this.blmRubberband.getRow(1);
        evoListRow.setInteger(0, n);
        evoListRow.setLong(1, l);
        this.blmRubberband.setRow(1, evoListRow);
    }
}

