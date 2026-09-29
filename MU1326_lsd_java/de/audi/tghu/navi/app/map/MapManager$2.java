/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;

class MapManager$2
extends SimpleChoiceListener {
    private final /* synthetic */ MapManager this$0;

    MapManager$2(MapManager mapManager) {
        this.this$0 = mapManager;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 != 1;
        try {
            this.this$0.getLogChannel().log(1078071040, "MapManager# - panorama changed to %1 (0=MMI, 1=FPK)", (long)n2);
            this.this$0.getSetupMain().setPanorama(bl, true);
            ISetupHandler iSetupHandler = this.this$0.getSetupKombi();
            if (this.this$0.getMapKombi() != null && iSetupHandler != null) {
                iSetupHandler.setPanorama(!bl, true);
            }
            this.this$0.env.getChoiceModel(-1843526144).setValue(n2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

