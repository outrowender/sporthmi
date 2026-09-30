/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.sds.IPickListModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.sds.ISDSListRowBuilder;

public class PoiSDSPickListModelAccess
implements IPickListModelAccess {
    private final NavigationEnv env;
    private final BaseListModelApp pickListModelApp;
    private final ISDSListRowBuilder listRowBuilder;

    public PoiSDSPickListModelAccess(NavigationEnv navigationEnv, ISDSListRowBuilder iSDSListRowBuilder, int n) {
        this.env = navigationEnv;
        this.listRowBuilder = iSDSListRowBuilder;
        this.pickListModelApp = navigationEnv.getBaseListModel(n);
    }

    public void onStart() {
        this.pickListModelApp.removeAll();
    }

    public void onUpdateResultList(SDSListEntry[] sDSListEntryArray) {
        this.env.getSDSLogChannel().log(10000000, "[PoiSDS]PoiSDSPickListModelAccess#onUpdateResultList(%1)", (Object)sDSListEntryArray);
        if (sDSListEntryArray == null || sDSListEntryArray.length == 0) {
            this.pickListModelApp.removeAll();
            return;
        }
        int n = sDSListEntryArray.length;
        BaseListModelApp baseListModelApp = this.pickListModelApp.getEmptyCopy();
        try {
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = this.listRowBuilder.buildEvoListRow(sDSListEntryArray[i2].getId(), sDSListEntryArray[i2].getName(), i2);
                baseListModelApp.append(evoListRow);
            }
        }
        catch (Exception exception) {
            this.env.getSDSLogChannel().log(10000, exception.getMessage());
        }
        this.pickListModelApp.update(baseListModelApp);
    }
}

