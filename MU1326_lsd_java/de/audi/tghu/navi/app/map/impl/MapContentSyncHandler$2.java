/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$2
extends SimpleChoiceListener {
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$2(MapContentSyncHandler mapContentSyncHandler) {
        this.this$0 = mapContentSyncHandler;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogger().log(1078071040, "MapContentSyncHandler#itemSelected() - modelID:%1, itemID:%2", (long)n, (long)n2);
        this.this$0.env.getChoiceModel(n).setValue(n2);
        switch (n) {
            case 401834: 
            case 402138: {
                this.this$0.naviMap.getSetup().setProperty(5, n2);
                this.this$0.refreshAsiaTrafficFlow();
                this.this$0.refreshAsiaOptions();
                break;
            }
            case 401831: 
            case 402137: {
                this.this$0.naviMap.getSetup().setProperty(0, n2);
                this.this$0.naviMap.getActiveContext().showTMC(this.this$0.naviMap.getSetup().getTMCSymbols(0));
                break;
            }
            case 401832: {
                this.this$0.naviMap.getSetup().setProperty(1, n2);
                break;
            }
            case 401833: 
            case 402143: {
                this.this$0.naviMap.getSetup().setProperty(2, n2);
                this.this$0.refreshAsiaTrafficFlow();
                this.this$0.refreshAsiaOptions();
                break;
            }
            case 401836: 
            case 402142: {
                this.this$0.naviMap.getSetup().setProperty(4, n2);
                this.this$0.naviMap.getMapFlagHandler().refresh(true);
                break;
            }
            case 402154: 
            case 402155: {
                this.this$0.naviMap.getSetup().setProperty(6, n2);
                break;
            }
            default: {
                this.this$0.getLogger().log(-1601830656, "MapContentSyncHandler#itemSelected() - unhandeled Model:%1", (long)n);
            }
        }
    }
}

