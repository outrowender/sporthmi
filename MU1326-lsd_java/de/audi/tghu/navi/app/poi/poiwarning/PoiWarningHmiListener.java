/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager;

public class PoiWarningHmiListener
implements ButtonListener,
BaseListModelListener,
ChoiceListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final PoiWarningManager poiWarningManager;

    public PoiWarningHmiListener(NavigationEnv navigationEnv, PoiWarningManager poiWarningManager) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPoiApproachWarningLogChannel();
        this.poiWarningManager = poiWarningManager;
        this.setupListeners();
    }

    private void setupListeners() {
        this.logChannel.log(14808325, "PoiWarningHmiListener#setupListeners");
        this.env.getButtonModel(-367065600).setButtonListener(this);
        this.env.getChoiceModel(-350288384).setButtonListener(this);
        this.env.getChoiceModel(-383842816).setButtonListener(this);
        this.env.getButtonModel(-316733952).setButtonListener(this);
        this.env.getBaseListModel(-333511168).setListener(this);
        this.env.getBaseListModel(-299956736).setListener(this);
        this.env.getButtonModel(-702347776).setButtonListener(this);
        this.env.getButtonModel(790889984).setButtonListener(this);
        this.env.getButtonModel(824444416).setButtonListener(this);
        this.env.getButtonModel(807667200).setButtonListener(this);
        this.env.getButtonModel(841221632).setButtonListener(this);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "PoiWarningHmiListener#keyPressed --> modelID: %1, keyID: %2", (long)n, (long)n2);
        switch (n) {
            case 401386: {
                this.poiWarningManager.screenEntered();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401389: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 402479: {
                this.poiWarningManager.toggleAll(0, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 402481: {
                this.poiWarningManager.toggleAll(0, 0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 402480: {
                this.poiWarningManager.toggleAll(1, 1);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 402482: {
                this.poiWarningManager.toggleAll(1, 0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "PoiWarningHmiListener#keyPressed() - Unknown Button pressed: %1", (long)n);
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected (BaseListModels) --> model: %1, index: %2", (long)n, (long)n2);
        if (n == -333511168) {
            this.logChannel.log(14808325, "   --> POI_WARNING_MAIN_LIST_BASE_LIST");
            int n5 = (int)evoListRow.getUniqueID();
            this.poiWarningManager.changePoiSelection(n5);
            this.env.fireModelEvent(n, n4);
        } else if (n == -299956736) {
            this.logChannel.log(14808325, "   --> PPOI_LIST_BASE_LIST");
            int n6 = (int)evoListRow.getUniqueID();
            this.poiWarningManager.changePpoiSelection(n6);
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected (ChoiceModels) --> modelID: %1, itemID: %2", (long)n, (long)n2);
        switch (n) {
            case 401387: {
                this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected - Show approach hint - pressed");
                this.poiWarningManager.toggleApproachHint();
                this.env.fireModelEvent(n, n4);
                break;
            }
            case 401385: {
                this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected - give Audiofeedback - pressed");
                this.poiWarningManager.toggleSpeachHint();
                this.env.fireModelEvent(n, n4);
                break;
            }
            case 402390: {
                this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected - SelectAll - pressed");
                this.poiWarningManager.toggleSelectAll();
                this.env.fireModelEvent(n, n4);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "PoiWarningHmiListener#itemSelected() - Unknown Button pressed: %1", (long)n);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

