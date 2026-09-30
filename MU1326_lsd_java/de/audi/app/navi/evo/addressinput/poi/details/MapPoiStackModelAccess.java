/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.details;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiBaseListModelAccess;
import org.dsi.ifc.navigation.LIValueListElement;

public class MapPoiStackModelAccess
extends AbstractPoiBaseListModelAccess {
    public MapPoiStackModelAccess(NavigationEnv navigationEnv, BaseListModelListener baseListModelListener, IEvoListRowBuilder iEvoListRowBuilder, int n) {
        super(navigationEnv, baseListModelListener, iEvoListRowBuilder, n);
    }

    public void onElementSelected(LIValueListElement lIValueListElement) {
    }
}

