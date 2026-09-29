/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import java.util.Map;

class UotaModelListener$4
extends DefaultBaseListModelListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$4(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.NaviCountriesListListener].itemSelected(): Country selected: %1", (Object)evoListRow);
        AbstractPkgListRow abstractPkgListRow = (AbstractPkgListRow)evoListRow;
        UotaModelListener.access$200(this.this$0).getSelectedCountryLabelModel().setText(abstractPkgListRow.getNode().getDisplayName());
        UotaModelListener.access$100(this.this$0).packageSelected(abstractPkgListRow, UotaModelListener.access$200(this.this$0).getNaviCountriesListModel(), n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Map map;
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.NaviCountriesListListener].itemFocused(): Country focused: %1", (Object)evoListRow);
        AbstractPkgListRow abstractPkgListRow = (AbstractPkgListRow)evoListRow;
        UotaPkgInfoWrapper uotaPkgInfoWrapper = null;
        PkgNode pkgNode = abstractPkgListRow.getNode();
        while (null != pkgNode && null == (uotaPkgInfoWrapper = pkgNode.getPackageInfo()) && null != (map = abstractPkgListRow.getNode().getChildNodes()) && !map.isEmpty()) {
            pkgNode = (PkgNode)map.values().iterator().next();
        }
        if (null == uotaPkgInfoWrapper) {
            UotaModelListener.access$000(this.this$0).log(10000, "[UotaModelListener.NaviCountriesListListener].itemFocused(): Could not find package info for country focused: %1", (Object)evoListRow);
        }
    }
}

