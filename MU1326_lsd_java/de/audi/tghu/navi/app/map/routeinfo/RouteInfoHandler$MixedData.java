/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedList;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemPOI;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemTMC;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemTurn;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class RouteInfoHandler$MixedData {
    MixedList mTurnList = new MixedList();
    MixedList mPOIList = new MixedList();
    MixedList mTMCList = new MixedList();
    private MixedList data = new MixedList();
    private final /* synthetic */ RouteInfoHandler this$0;

    public RouteInfoHandler$MixedData(RouteInfoHandler routeInfoHandler) {
        this.this$0 = routeInfoHandler;
        this.rebuild();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(RouteInfoHandler.access$100(this.this$0)).append("\n");
        for (int i2 = 0; i2 < this.data.size(); ++i2) {
            buffer.append(this.data.getItem(i2)).append("\n");
        }
        return buffer.toString();
    }

    public MixedListItem getItem(int n) {
        return this.data.getItem(n);
    }

    public void removeItem(int n) {
        MixedListItem mixedListItem = this.data.getItem(n);
        if (this.mTMCList.containsItem(mixedListItem)) {
            this.mTMCList.removeItem(mixedListItem);
        } else if (this.mPOIList.containsItem(mixedListItem)) {
            this.mPOIList.removeItem(mixedListItem);
        } else if (this.mTurnList.containsItem(mixedListItem)) {
            this.mTurnList.removeItem(mixedListItem);
        }
        this.data.removeItem(mixedListItem);
    }

    public int size() {
        return this.data.size();
    }

    public void updateTurn(TurnListElement[] turnListElementArray) {
        this.mTurnList.clear();
        long l = RouteInfoHandler.access$1200(this.this$0);
        long l2 = RouteInfoHandler.access$1300(this.this$0);
        for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
            try {
                MixedListItemTurn mixedListItemTurn = new MixedListItemTurn(turnListElementArray[i2], RouteInfoHandler.access$100(this.this$0), this.this$0.createMixedListRow(RouteInfoHandler.access$1400(this.this$0), this.this$0.getLogger()), l, l2, RouteInfoHandler.access$000(this.this$0));
                this.mTurnList.add(mixedListItemTurn);
                if (mixedListItemTurn.mMixedListRow.name == null || mixedListItemTurn.mMixedListRow.name.equals(RouteInfoHandler.access$000(this.this$0).getDisplayName(turnListElementArray[i2]))) continue;
                this.this$0.getLogger().log(-1601830656, "RouteInfoHandler#MixedData#updateTurn() - name = %1", (Object)RouteInfoHandler.access$000(this.this$0).getDisplayName(turnListElementArray[i2]));
                continue;
            }
            catch (Exception exception) {
                this.this$0.getLogger().log(10000, "RouteInfoHandler#MixedData#updateTurn() - %1", (Throwable)exception);
            }
        }
        this.rebuild();
    }

    public void updatePOI(NavPoiInfo[] navPoiInfoArray) {
        this.mPOIList.clear();
        long l = RouteInfoHandler.access$1200(this.this$0);
        long l2 = RouteInfoHandler.access$1300(this.this$0);
        if (l < 0L) {
            this.this$0.getLogger().log(-1601830656, "RouteInfoHandler#MixedData#updatePOI() negative distCarToFinalDest: %1", l);
            RouteInfoHandler.access$1502(this.this$0, navPoiInfoArray);
            return;
        }
        RouteInfoHandler.access$1502(this.this$0, null);
        for (int i2 = 0; i2 < navPoiInfoArray.length; ++i2) {
            try {
                MixedListItemPOI mixedListItemPOI = new MixedListItemPOI(navPoiInfoArray[i2], RouteInfoHandler.access$100(this.this$0), this.this$0.createMixedListRow(RouteInfoHandler.access$1400(this.this$0), this.this$0.getLogger()), l, l2, RouteInfoHandler.access$000(this.this$0));
                this.mPOIList.add(mixedListItemPOI);
                if (mixedListItemPOI.mMixedListRow.name == null || mixedListItemPOI.mMixedListRow.name.equals(RouteInfoHandler.access$000(this.this$0).getDisplayName(navPoiInfoArray[i2]))) continue;
                this.this$0.getLogger().log(-1601830656, "RouteInfoHandler#MixedData#updatePOI() - name = %1", (Object)RouteInfoHandler.access$000(this.this$0).getDisplayName(navPoiInfoArray[i2]));
                continue;
            }
            catch (Exception exception) {
                this.this$0.getLogger().log(10000, "RouteInfoHandler#MixedData#updatePOI() - %1", (Throwable)exception);
            }
        }
        this.rebuild();
    }

    public void updateTMC(TmcMessage[] tmcMessageArray) {
        this.mTMCList.clear();
        long l = RouteInfoHandler.access$1200(this.this$0);
        long l2 = RouteInfoHandler.access$1300(this.this$0);
        for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
            try {
                MixedListItemTMC mixedListItemTMC = new MixedListItemTMC(tmcMessageArray[i2], RouteInfoHandler.access$100(this.this$0), this.this$0.createMixedListRow(RouteInfoHandler.access$1400(this.this$0), this.this$0.getLogger()), l, l2, RouteInfoHandler.access$000(this.this$0));
                this.mTMCList.add(mixedListItemTMC);
                String string = RouteInfoHandler.access$000(this.this$0).getDisplayName(tmcMessageArray[i2]);
                if (mixedListItemTMC.mMixedListRow.name == null || mixedListItemTMC.mMixedListRow.name.equals(string)) continue;
                this.this$0.getLogger().log(-1601830656, "RouteInfoHandler#MixedData#updateTMC() - name = %1", (Object)string);
                continue;
            }
            catch (Exception exception) {
                this.this$0.getLogger().log(10000, "RouteInfoHandler#MixedData#updateTMC() - %1", (Throwable)exception);
            }
        }
        this.rebuild();
    }

    protected final void rebuild() {
        this.data.clear();
        this.data.add(this.mPOIList).add(this.mTMCList);
        this.data.add(this.mTurnList).sort();
    }

    public void clear() {
        this.mTurnList.clear();
        this.mPOIList.clear();
        this.mTMCList.clear();
        this.data.clear();
        RouteInfoHandler.access$1502(this.this$0, null);
    }

    public void clearOldItems() {
    }

    public boolean hasTurnListElement() {
        return this.mTurnList.size() > 0;
    }
}

