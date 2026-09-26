/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.sds.ISUIListRowBuilder;
import de.audi.tghu.navi.app.sds.ISUIModelAccess;

public class SUIModelAccess
implements ISUIModelAccess {
    private final LogChannel logChannel;
    private final BaseListModelApp vdeSUIListModel;
    private final ISUIListRowBuilder suiListRowBuilder;

    public SUIModelAccess(NavigationEnv navigationEnv, ISUIListRowBuilder iSUIListRowBuilder) {
        this.logChannel = navigationEnv.getSDSLogChannel();
        this.vdeSUIListModel = navigationEnv.getBaseListModel(3871);
        this.suiListRowBuilder = iSUIListRowBuilder;
    }

    @Override
    public byte fillNaviSUIList(NaviService$NaviSUIDetails[] naviService$NaviSUIDetailsArray) {
        BaseListModelApp baseListModelApp = this.vdeSUIListModel.getEmptyCopy();
        if (naviService$NaviSUIDetailsArray == null) {
            this.logChannel.log(-1601830656, "SUIModelAccess#fillNaviSUIList() - No entries available, clearing list! ");
            this.vdeSUIListModel.update(baseListModelApp);
            return 1;
        }
        this.logChannel.log(-2137614336, "SUIModelAccess#fillNaviSUIList( length: %1 )", (long)naviService$NaviSUIDetailsArray.length);
        int n = naviService$NaviSUIDetailsArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            NaviService$NaviSUIDetails naviService$NaviSUIDetails = naviService$NaviSUIDetailsArray[i2];
            this.logChannel.log(-2137614336, "SUIModelAccess#fillNaviSUIList() - naviSUIDetails: %1 ", (Object)naviService$NaviSUIDetails);
            baseListModelApp.append(this.suiListRowBuilder.buildEvoListRow(naviService$NaviSUIDetails, i2));
        }
        this.vdeSUIListModel.update(baseListModelApp);
        return 0;
    }
}

