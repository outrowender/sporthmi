/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService;
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

    public byte fillNaviSUIList(NaviService.NaviSUIDetails[] naviSUIDetailsArray) {
        BaseListModelApp baseListModelApp = this.vdeSUIListModel.getEmptyCopy();
        if (naviSUIDetailsArray == null) {
            this.logChannel.log(100000, "SUIModelAccess#fillNaviSUIList() - No entries available, clearing list! ");
            this.vdeSUIListModel.update(baseListModelApp);
            return 1;
        }
        this.logChannel.log(10000000, "SUIModelAccess#fillNaviSUIList( length: %1 )", (long)naviSUIDetailsArray.length);
        int n = naviSUIDetailsArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            NaviService.NaviSUIDetails naviSUIDetails = naviSUIDetailsArray[i2];
            this.logChannel.log(10000000, "SUIModelAccess#fillNaviSUIList() - naviSUIDetails: %1 ", (Object)naviSUIDetails);
            baseListModelApp.append(this.suiListRowBuilder.buildEvoListRow(naviSUIDetails, i2));
        }
        this.vdeSUIListModel.update(baseListModelApp);
        return 0;
    }
}

