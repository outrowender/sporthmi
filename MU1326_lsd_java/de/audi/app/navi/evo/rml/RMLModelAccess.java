/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml;

import de.audi.app.navi.evo.rml.listrow.RMLListRowFactory;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.rml.IRMLModelAccess;
import de.audi.tghu.navi.app.rml.RMLCoreModelAccess;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class RMLModelAccess
extends RMLCoreModelAccess
implements IRMLModelAccess {
    static final int BLOCK_MODE_NONE = 0;
    static final int BLOCK_MODE_START = 1;
    static final int BLOCK_MODE_END = 2;
    static final boolean VALUE_NOT_READY = false;
    static final boolean VALUE_READY = true;
    private static final int NO_DETAILS = 0;
    private static final int TRAFFIC = 1;
    private static final int COUNTRYINFO = 2;
    private static final int DETAILS = 3;
    private final int readyChoiceModelId;
    private final int listModelId;
    private final int followDetailScreenChoiceModel;
    protected final NavigationEnv env;
    private final LogChannel logChannel;
    private final IconHandler iconHandler;
    protected final IPreviewMap previewMap;
    private volatile boolean needsUpdates = false;
    private final IRouteManager routeManager;
    private long openedAnchorId;

    public RMLModelAccess(NavigationEnv navigationEnv, int n, int n2, int n3, IconHandler iconHandler, IPreviewMap iPreviewMap, IRouteManager iRouteManager) {
        super(navigationEnv);
        this.previewMap = iPreviewMap;
        this.followDetailScreenChoiceModel = n3;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.logChannel = navigationEnv.getRMLLogChannel();
        this.env = navigationEnv;
        this.readyChoiceModelId = n;
        this.listModelId = n2;
    }

    protected int countFirstLinesWithoutDistance() {
        return 0;
    }

    protected String getCCPText() {
        return null;
    }

    public synchronized void onStart() {
        super.onStart();
        this.onUpdateReadyStatus(false);
        this.needsUpdates = false;
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(this.listModelId);
        tiledListModelApp.removeAll();
        tiledListModelApp.fireEvent(0);
    }

    public synchronized void onStop() {
        this.needsUpdates = false;
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(this.listModelId);
        tiledListModelApp.removeAll();
        tiledListModelApp.fireEvent(0);
    }

    public void onElementFocused(NavRectangle navRectangle, CombinedRouteListElement combinedRouteListElement) {
        this.previewMap.setPreviewRoadSegment(navRectangle.xLeft, navRectangle.xRight, navRectangle.yBottom, navRectangle.yUp, combinedRouteListElement.startDistance, combinedRouteListElement.endDistance, 1, null, null);
    }

    public void onPoiFocused(NavLocation navLocation, CombinedRouteListElement combinedRouteListElement) {
        this.previewMap.setPreviewPOIsOnboard(new NavLocation[]{navLocation}, 1, null, null);
    }

    public synchronized void onUpdateList(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n, long l2, Route route) {
        int n2;
        this.openedAnchorId = l2;
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(this.listModelId);
        BaseListModelApp baseListModelApp = tiledListModelApp.getCopy();
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - CombinedROuteListElement[] - Length = %1", (long)combinedRouteListElementArray.length);
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - requestId = %1, ResultAnchorId = %2", (Object)(n + ""), (Object)(l + ""));
        if (baseListModelApp == null) {
            this.logChannel.log(100000, "RMLModelAccess#updateCombinedRouteList() - no model");
            return;
        }
        if (combinedRouteListElementArray == null || combinedRouteListElementArray.length <= 0) {
            this.onUpdateReadyStatus(false);
            this.logChannel.log(100000, "RMLModelAccess#updateCombinedRouteList() - empty list or no route data!");
            baseListModelApp.removeAll();
            baseListModelApp.clearAll();
            return;
        }
        this.adjustListLength(combinedRouteListElementArray, baseListModelApp, l);
        int n3 = 0;
        int n4 = 0;
        if (l != -1L) {
            n3 = this.findIndexOfUsedAnchorIdInArray(l, combinedRouteListElementArray);
            n4 = this.findIndexOfUsedAnchorIdInList(l, baseListModelApp);
        }
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - indexOfUsedAnchorIndList = %1, indexOfUsedAnchorInArray = %2", (long)n4, (long)n3);
        RMLListRowFactory rMLListRowFactory = new RMLListRowFactory(this.logChannel);
        int n5 = combinedRouteListElementArray.length + this.countFirstLinesWithoutDistance();
        EvoListRow[] evoListRowArray = new AbstractRMLListRow[n5];
        for (n2 = 0; n2 < combinedRouteListElementArray.length; ++n2) {
            if (combinedRouteListElementArray[n2].startDistance == -1L && !this.checkForListEnd(combinedRouteListElementArray) && n2 != 0) {
                this.logChannel.log(10000000, "RMLModelAccess#onUpdateList stopped filling list with index %1", (long)n2);
                break;
            }
            AbstractRMLListRow abstractRMLListRow = rMLListRowFactory.createRMLListRow(combinedRouteListElementArray[n2], this.iconHandler, l2, this.env, route, this.routeManager);
            if (n2 == 0 && abstractRMLListRow != null) {
                TripHandler.TripData tripData = this.routeManager.getTripDataAuto();
                long l3 = (long)tripData.distanceToFinalDestination - combinedRouteListElementArray[n2].getEndDistance();
                abstractRMLListRow.setText(2, Util.formatDistance((int)l3, 1));
            }
            evoListRowArray[n2 + this.countFirstLinesWithoutDistance()] = abstractRMLListRow;
        }
        n2 = 0;
        if (n4 != -1) {
            if (this.checkForListStart(combinedRouteListElementArray)) {
                n2 = 0;
            } else if (n4 - n3 >= 0) {
                n2 = n4 - n3;
            }
        } else {
            n2 = 0;
        }
        if (baseListModelApp.getLength() == n5) {
            this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - no data needs to be cleared");
        } else {
            if (n2 != 0) {
                this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - clearRows(0 , %1", (long)n2);
                baseListModelApp.clearRows(0, n2);
            }
            if (!this.checkForListEnd(combinedRouteListElementArray)) {
                this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - clearRows(%1 , %2", (long)(n2 + n5), (long)(baseListModelApp.getLength() - (n2 + n5)));
                baseListModelApp.clearRows(n2 + n5, baseListModelApp.getLength() - (n2 + n5));
            }
        }
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - model was cleared, adjustedStartIndex = %1", (long)n2);
        baseListModelApp.setRows(n, n2, evoListRowArray);
        tiledListModelApp.update(baseListModelApp);
        this.onUpdateReadyStatus(true);
        this.needsUpdates = true;
    }

    private void onUpdateReadyStatus(boolean bl) {
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateReadyStatus(%1)", bl);
        this.env.getChoiceModel(this.readyChoiceModelId).setValue(bl ? 1 : 0);
    }

    public synchronized void updateInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        Object object;
        if (!this.needsUpdates) {
            this.logChannel.log(10000000, "RMLModelAccess#updateInfoForNextDestination - No Update needed");
            return;
        }
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(this.listModelId);
        BaseListModelApp baseListModelApp = tiledListModelApp.getCopy();
        EvoListRow evoListRow = baseListModelApp.getRow(this.countFirstLinesWithoutDistance());
        for (int i2 = 0; i2 < tiledListModelApp.getLength(); ++i2) {
            object = baseListModelApp.getRow(i2);
            if (object == null || !(object instanceof AbstractRMLListRow)) continue;
            AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)object;
            abstractRMLListRow.updateRgInfoForNextDestination(rgInfoForNextDestination);
            baseListModelApp.setRow(i2, abstractRMLListRow);
        }
        if (evoListRow != null) {
            AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)evoListRow;
            object = this.routeManager.getTripDataAuto();
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "RMLModelAccess#updateRGInfoForNextDestination - distance to nextDest rgInfo = %1 ; distanceToNextDest_Element = %2 ; tripData.toFinalDest: %3", rgInfoForNextDestination.distanceToNextDest, abstractRMLListRow.getCombinedRouteListElement().getEndDistance(), (long)((TripHandler.TripData)object).distanceToFinalDestination);
            }
            long l = (long)((TripHandler.TripData)object).distanceToFinalDestination - abstractRMLListRow.getCombinedRouteListElement().getEndDistance();
            long l2 = abstractRMLListRow.getUniqueID();
            String string = Util.formatDistance((int)l, 1);
            if (l <= 0L) {
                this.logChannel.log(10000000, "RMLModelAccess#updateRGInfoForNextDestination - distance to nextDest is below 0 remove top entry");
                baseListModelApp.remove(abstractRMLListRow);
            } else {
                int n = baseListModelApp.getIndexForUniqueID(l2);
                abstractRMLListRow.setText(2, string);
                this.removeChildIfNessesary(baseListModelApp, abstractRMLListRow, ((TripHandler.TripData)object).distanceToFinalDestination);
                this.closeParentElementIfNessesary(baseListModelApp, this.openedAnchorId);
                baseListModelApp.setRow(n, evoListRow);
            }
            tiledListModelApp.update(baseListModelApp);
            this.logChannel.log(10000000, "RMLModelAccess#updateInfoForNextDestination - Update the text to formatedDistance = %1", (Object)string);
        } else {
            this.logChannel.log(10000000, "RMLModelAccess#updateRGInfoForNextDestination - Row is null no update of distance");
        }
    }

    private void closeParentElementIfNessesary(BaseListModelApp baseListModelApp, long l) {
        AbstractRMLListRow abstractRMLListRow;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "RMLModelAccess#closeParentElementIfNessesary - openedAnchorId = %1", l);
        }
        if ((abstractRMLListRow = (AbstractRMLListRow)baseListModelApp.getRowByUniqueID(l)) == null) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "RMLModelAccess#closeParentElementIfNessesary - PARENT IS NULL");
            }
            return;
        }
        this.logChannel.log(10000000, "RMLModelAccess#closeParentElementIfNessesary - PARENT TRY TO CLOSE");
        if (abstractRMLListRow.getInteger(1) == 2) {
            AbstractRMLListRow abstractRMLListRow2 = (AbstractRMLListRow)baseListModelApp.getRow(baseListModelApp.getIndexForUniqueID(l) + 1);
            if (abstractRMLListRow2.getCombinedRouteListElement().parent != abstractRMLListRow.getCombinedRouteListElement().getUid()) {
                abstractRMLListRow.setInteger(1, 0);
                baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(abstractRMLListRow.getUniqueID()), abstractRMLListRow);
            }
        }
    }

    private void removeChildIfNessesary(BaseListModelApp baseListModelApp, AbstractRMLListRow abstractRMLListRow, long l) {
        EvoListRow evoListRow;
        int n;
        ArrayList arrayList = new ArrayList(1);
        for (n = 0; n < baseListModelApp.getLength(); ++n) {
            evoListRow = baseListModelApp.getRow(n);
            if (evoListRow == null || !(evoListRow instanceof AbstractRMLListRow)) continue;
            AbstractRMLListRow abstractRMLListRow2 = (AbstractRMLListRow)evoListRow;
            CombinedRouteListElement combinedRouteListElement = abstractRMLListRow2.getCombinedRouteListElement();
            if (combinedRouteListElement == null) {
                this.logChannel.log(100000, "RMLModelAccess#removeChildIfNessesary - Row in line with index %1 has no combinedRouteList element. this shouldn't happen", (long)n);
                continue;
            }
            long l2 = l - combinedRouteListElement.getEndDistance();
            if (l2 > 0L) continue;
            arrayList.add(abstractRMLListRow2);
        }
        for (n = 0; n < arrayList.size(); ++n) {
            evoListRow = (AbstractRMLListRow)arrayList.get(n);
            baseListModelApp.remove(evoListRow.getUniqueID());
            this.logChannel.log(10000000, "RMLModelAccess#removeChildIfNessesary - CHILD REMOVED UID = %1", evoListRow.getUniqueID());
        }
    }

    public synchronized void onUpdateListLength(long l) {
        if (!this.needsUpdates) {
            this.logChannel.log(10000000, "RMLModelAccess#onUpdateListLength - No Update needed");
            return;
        }
        this.logChannel.log(10000000, "RMLModelAccess#onUpdateListLength - listLength will be set to %1", l);
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(this.listModelId);
        tiledListModelApp.setLength((int)l);
        tiledListModelApp.fireEvent(0);
    }

    public void adjustListLength(CombinedRouteListElement[] combinedRouteListElementArray, BaseListModelApp baseListModelApp, long l) {
        if (baseListModelApp.getLength() == 0) {
            if (this.checkForListEnd(combinedRouteListElementArray)) {
                this.logChannel.log(10000000, "RMLModelAccess#adjustListLength - 1 List length set to ResultListLength = %1", (long)combinedRouteListElementArray.length);
                baseListModelApp.setLength(combinedRouteListElementArray.length);
            } else {
                this.logChannel.log(10000000, "RMLModelAccess#adjustListLength - 1 List length set to ResultListLength + 1 = %1", (long)(combinedRouteListElementArray.length + 1));
                baseListModelApp.setLength(combinedRouteListElementArray.length + 1);
            }
            return;
        }
        if (this.checkForListStart(combinedRouteListElementArray) && this.checkForListEnd(combinedRouteListElementArray)) {
            this.logChannel.log(10000000, "RMLModelAccess#adjustListLength - 2 List length set to ResultListLength = %1", (long)combinedRouteListElementArray.length);
            baseListModelApp.setLength(combinedRouteListElementArray.length);
            baseListModelApp.clearAll();
            return;
        }
        int n = this.findIndexOfUsedAnchorIdInList(l, baseListModelApp);
        int n2 = this.findIndexOfUsedAnchorIdInArray(l, combinedRouteListElementArray);
        if (n == -1) {
            this.logChannel.log(10000, "RMLModelAccess#adjustListLength - The used Anchor ID cant be found in the List");
            return;
        }
        int n3 = 0;
        n3 = n + combinedRouteListElementArray.length - n2;
        if (!this.checkForListEnd(combinedRouteListElementArray)) {
            this.logChannel.log(10000000, "RMLModelAccess#adjustListLength - newLength = %1 + 1", (long)n3);
            ++n3;
        }
        if (n3 > baseListModelApp.getLength() || this.checkForListEnd(combinedRouteListElementArray)) {
            this.logChannel.log(10000000, "RMLModelAccess#adjustListLength - List length set to newLength = %1", (long)n3);
            baseListModelApp.setLength(n3);
        }
    }

    private boolean checkForListStart(CombinedRouteListElement[] combinedRouteListElementArray) {
        if (combinedRouteListElementArray != null && combinedRouteListElementArray.length > 0) {
            CombinedRouteListElement combinedRouteListElement = combinedRouteListElementArray[0];
            for (int i2 = 0; i2 < combinedRouteListElement.getType().length; ++i2) {
                if (combinedRouteListElement.getType()[i2] != -1) continue;
                this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - The First Element of the Resultlist is aswell the Start of the List");
                return true;
            }
        }
        return false;
    }

    private boolean checkForListEnd(CombinedRouteListElement[] combinedRouteListElementArray) {
        if (combinedRouteListElementArray != null && combinedRouteListElementArray.length > 0) {
            CombinedRouteListElement combinedRouteListElement = combinedRouteListElementArray[combinedRouteListElementArray.length - 1];
            for (int i2 = 0; i2 < combinedRouteListElement.getType().length; ++i2) {
                if (combinedRouteListElement.getType()[i2] != -2) continue;
                this.logChannel.log(10000000, "RMLModelAccess#onUpdateList - The Last Element of the Resultlist is aswell the End of the List - No More Elements available");
                return true;
            }
        }
        return false;
    }

    private int findIndexOfUsedAnchorIdInList(long l, BaseListModelApp baseListModelApp) {
        return baseListModelApp.getIndexForUniqueID(l);
    }

    private int findIndexOfUsedAnchorIdInArray(long l, CombinedRouteListElement[] combinedRouteListElementArray) {
        if (combinedRouteListElementArray.length == 21 && combinedRouteListElementArray[10].getUid() == l) {
            this.logChannel.log(10000000, "RMLModelAccess#findIndexOfUsedAnchorIdInArray the anchor is the Middle of the List!");
            return 10;
        }
        for (int i2 = 0; i2 < combinedRouteListElementArray.length; ++i2) {
            if (combinedRouteListElementArray[i2].getUid() != l) continue;
            this.logChannel.log(10000000, "RMLModelAccess#findIndexOfUsedAnchorIdInArray the anchor is index %1", (long)i2);
            return i2;
        }
        this.logChannel.log(10000, "RMLModelAccess#findIndexOfUsedAnchorIdInArray unexpected behaviour no anchor has been found. But there should be one.. Used Anchor Id is %1", l);
        return 0;
    }

    public void onDetailsSelected() {
        this.env.getChoiceModel(this.followDetailScreenChoiceModel).setValue(3);
    }

    public void onCountryInfoSelected() {
        this.env.getChoiceModel(this.followDetailScreenChoiceModel).setValue(2);
    }

    public void onTrafficInfoSelected() {
        this.env.getChoiceModel(this.followDetailScreenChoiceModel).setValue(1);
    }

    public void onNoDetailsSelected() {
        this.env.getChoiceModel(this.followDetailScreenChoiceModel).setValue(0);
    }
}

