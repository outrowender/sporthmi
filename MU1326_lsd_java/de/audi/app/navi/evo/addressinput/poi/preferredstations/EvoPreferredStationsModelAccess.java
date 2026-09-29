/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.preferredstations;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.IPreferredStationsModelAccess;
import org.dsi.ifc.navigation.Brand;

public class EvoPreferredStationsModelAccess
implements IPreferredStationsModelAccess {
    private static final int PREFERRED_LIST;
    private static final int COLUMNS;
    private static final int COL_ICON;
    private static final int COL_TEXT;
    private static final int COL_SELECTED;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IconHandler iconHandler;

    public EvoPreferredStationsModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.iconHandler = iconHandler;
    }

    @Override
    public void preferrBrand(long l, boolean bl) {
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(-1273035264);
        int n = baseListModelApp.getIndexForUniqueID(l);
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        evoListRow.setInteger(3, bl ? 1 : 0);
        baseListModelApp.setRow(n, evoListRow);
    }

    @Override
    public void brandsUpdated(Brand[] brandArray) {
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(-1273035264);
        baseListModelApp.removeAll();
        for (int i2 = 0; i2 < brandArray.length; ++i2) {
            EvoListRow evoListRow = new EvoListRow(brandArray[i2].getBrandUid(), 4);
            this.logChannel.log(-2137614336, "EvoPreferredStationsModelAccess#brandsUpdated - getIconIndex(): %1 - getSubIconIndex(): %2", (long)brandArray[i2].getIconIndex(), (long)brandArray[i2].getSubIconIndex());
            int n = this.iconHandler.resolvePOIIconResourceID(brandArray[i2].getIconIndex(), brandArray[i2].getSubIconIndex());
            HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(n);
            this.logChannel.log(-2137614336, "EvoPreferredStationsModelAccess#brandsUpdated - iconResourceID: %1 - status: %2", (long)n, (long)hMIResourceLocator.getStatus());
            IconCell iconCell = new IconCell(hMIResourceLocator);
            evoListRow.setIconCell(1, iconCell);
            evoListRow.setText(2, brandArray[i2].getDescription());
            evoListRow.setInteger(3, brandArray[i2].isPreferred() ? 1 : 0);
            baseListModelApp.append(evoListRow);
        }
    }
}

