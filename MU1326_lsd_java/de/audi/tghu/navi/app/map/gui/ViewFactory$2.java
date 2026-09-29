/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.gui.IMapContentView;
import de.audi.tghu.navi.app.map.gui.ViewFactory;

class ViewFactory$2
implements IMapContentView {
    private final /* synthetic */ ViewFactory this$0;

    ViewFactory$2(ViewFactory viewFactory) {
        this.this$0 = viewFactory;
    }

    @Override
    public BaseListModelApp getStandardList() {
        return this.this$0.env.getBaseListModel(-400685568);
    }

    @Override
    public BaseListModelApp getStandardListLevel2() {
        return this.this$0.env.getBaseListModel(1042613760);
    }

    @Override
    public BaseListModelApp getStandardListLevel3() {
        return this.this$0.env.getBaseListModel(1059390976);
    }

    @Override
    public ChoiceModelApp getCheckAllStandard() {
        return this.this$0.env.getChoiceModel(-417462784);
    }

    @Override
    public BaseListModelApp getKMLLayersList() {
        return this.this$0.env.getBaseListModel(-987822592);
    }

    @Override
    public BaseListModelApp getPPOIList() {
        return this.this$0.env.getBaseListModel(-954268160);
    }

    @Override
    public void setMyAudiAvailable(boolean bl) {
        this.this$0.env.getChoiceModel(-1474296320).setValue(bl ? 1 : 0);
    }
}

