/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavModelAccess;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavListRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public abstract class PredictiveNavModelAccess
implements IPredictiveNavModelAccess {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected NavigationEnv env;
    protected final LogChannel logChannel;
    protected BaseListModelApp likelyDestinationsList;

    public PredictiveNavModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPredictiveNavigationLogChannel();
    }

    public void updateSelection(LikelyDestination[] likelyDestinationArray) {
        if (likelyDestinationArray == null) {
            this.likelyDestinationsList.removeAll();
            return;
        }
        BaseListModelApp baseListModelApp = this.likelyDestinationsList.getEmptyCopy();
        for (int i2 = 0; i2 < likelyDestinationArray.length; ++i2) {
            if (likelyDestinationArray[i2].getSegmentId().elements == null) continue;
            PredictiveNavListRow predictiveNavListRow = this.getListRow(likelyDestinationArray[i2]);
            baseListModelApp.append(predictiveNavListRow);
        }
        this.likelyDestinationsList.update(baseListModelApp);
    }

    private PredictiveNavListRow getListRow(LikelyDestination likelyDestination) {
        for (int i2 = 0; i2 < this.likelyDestinationsList.getLength(); ++i2) {
            PredictiveNavListRow predictiveNavListRow = (PredictiveNavListRow)this.likelyDestinationsList.getRow(i2);
            if (!this.compareLikelyDestinationRoutes(likelyDestination, predictiveNavListRow.likelyDestination)) continue;
            predictiveNavListRow.updateInformation(likelyDestination);
            return predictiveNavListRow;
        }
        return this.createNewListRow(likelyDestination);
    }

    public void clearLikelyDestinations() {
        this.logChannel.log(10000000, "%1#clearLikelyDestinations", (Object)this.CLASS_NAME);
        this.likelyDestinationsList.removeAll();
    }

    private boolean compareLikelyDestinationRoutes(LikelyDestination likelyDestination, LikelyDestination likelyDestination2) {
        boolean bl = true;
        int[] nArray = likelyDestination.getSegmentId().getElements();
        int[] nArray2 = likelyDestination2.getSegmentId().getElements();
        if (nArray == null || nArray2 == null) {
            return false;
        }
        if (nArray.length == nArray2.length) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == nArray2[i2]) continue;
                bl = false;
                break;
            }
        } else {
            bl = false;
        }
        return bl;
    }

    public int getPredictiveRouteListLength() {
        return this.likelyDestinationsList.getLength();
    }

    protected abstract PredictiveNavListRow createNewListRow(LikelyDestination var1);
}

