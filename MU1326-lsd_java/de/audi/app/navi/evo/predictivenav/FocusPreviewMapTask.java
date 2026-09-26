/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavListRow;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class FocusPreviewMapTask
implements Runnable {
    private final PredictiveNavListRow row;
    private final IPreviewMap previewMap;
    private final LogChannel logChannel;
    private static final String LOGCLASS;

    public FocusPreviewMapTask(IPreviewMap iPreviewMap, PredictiveNavListRow predictiveNavListRow, LogChannel logChannel) {
        this.row = predictiveNavListRow;
        this.previewMap = iPreviewMap;
        this.logChannel = logChannel;
    }

    @Override
    public void run() {
        LikelyDestination likelyDestination = this.row.getLikelyDestination();
        NavSegmentID navSegmentID = likelyDestination.getSegmentId();
        this.focusPreviewMapOnNavSegmentID(navSegmentID);
    }

    private void focusPreviewMapOnNavSegmentID(NavSegmentID navSegmentID) {
        if (navSegmentID != null) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#focusPreviewMapOnNavSegmentID()", (Object)"FocusPreviewMapTask");
            }
            this.previewMap.setPreviewPredictiveNavigationRoute(navSegmentID, 1, null, null);
        } else {
            this.logChannel.log(-2137614336, "%1#focusPreviewMapOnNavSegmentID() - no NavSegmentID", (Object)"FocusPreviewMapTask");
        }
    }
}

