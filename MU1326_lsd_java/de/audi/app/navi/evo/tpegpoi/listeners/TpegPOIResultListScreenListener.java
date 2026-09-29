/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.listeners;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegScreenListener;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIResultListScreenListener
extends AbstractTpegScreenListener
implements TiledListModelListener {
    private final TpegPOIResultListSequence sequence;
    private final TiledListModelApp resultList;
    private final HomeAddressHandler homeAddressHandler;

    public TpegPOIResultListScreenListener(NavigationEnv navigationEnv, TpegPOIResultListSequence tpegPOIResultListSequence, int n, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv);
        this.sequence = tpegPOIResultListSequence;
        this.resultList = navigationEnv.getTiledListModel(n);
        this.resultList.setListener(this);
        this.homeAddressHandler = homeAddressHandler;
    }

    public CommandList getStartCommandList(long l) {
        return this.sequence.getResultListCommandList(l);
    }

    public TpegPOIResultListSequence getTpegPOIResultSequence() {
        return this.sequence;
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused - list model - model=%2, index=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof LiValueListRow) {
            LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
            this.sequence.preparePreviewMap(lIValueListElement);
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected - list model - row=%1, model=%2, index=%3").toString(), (Object)evoListRow, (long)n, (long)n2);
        if (evoListRow instanceof LiValueListRow) {
            LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
            this.sequence.executeItemSelect(lIValueListElement, this.homeAddressHandler);
        }
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - was called with requestID=%2, startIndex=%3, model=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.sequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#unrequestItems - was called with startIndex=%2, length=%2", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.sequence.unrequestItems(n, n2);
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

