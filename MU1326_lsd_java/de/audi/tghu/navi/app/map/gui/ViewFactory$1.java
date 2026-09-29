/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.gui.IMapContentView;
import de.audi.tghu.navi.app.map.gui.ViewFactory;

class ViewFactory$1
implements IMapContentView {
    private final /* synthetic */ ViewFactory this$0;

    ViewFactory$1(ViewFactory viewFactory) {
        this.this$0 = viewFactory;
    }

    @Override
    public BaseListModelApp getStandardList() {
        return this.this$0.env.getBaseListModel(-937490944);
    }

    @Override
    public BaseListModelApp getStandardListLevel2() {
        return this.this$0.env.getBaseListModel(1009059328);
    }

    @Override
    public BaseListModelApp getStandardListLevel3() {
        return this.this$0.env.getBaseListModel(1025836544);
    }

    @Override
    public ChoiceModelApp getCheckAllStandard() {
        return this.this$0.env.getChoiceModel(-1826814464);
    }

    @Override
    public BaseListModelApp getKMLLayersList() {
        return this.this$0.env.getBaseListModel(-1960573440);
    }

    @Override
    public BaseListModelApp getPPOIList() {
        return this.this$0.env.getBaseListModel(-971045376);
    }

    @Override
    public void setMyAudiAvailable(boolean bl) {
        this.this$0.env.getChoiceModel(-1491073536).setValue(bl ? 1 : 0);
    }
}

