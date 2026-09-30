/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.listeners;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.tpegpoi.TpegPOIManager;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegScreenListener;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOICategoryListSequence;

public class TpegPOICategoryScreenListener
extends AbstractTpegScreenListener
implements BaseListModelListener,
ButtonListener {
    private final BaseListModelApp baseList;
    private final LabelModelApp resultListScreenTitleLable;
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiOPTSelectTpegPOIButton();
    private final IPreviewMap previewMap;
    private final TpegPOICategoryListSequence poiSequence;
    private final TpegPOIManager tpegPOIManager;

    public TpegPOICategoryScreenListener(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, TpegPOICategoryListSequence tpegPOICategoryListSequence, TpegPOIManager tpegPOIManager, int n) {
        super(navigationEnv);
        this.previewMap = iPreviewMap;
        this.poiSequence = tpegPOICategoryListSequence;
        this.tpegPOIManager = tpegPOIManager;
        this.baseList = navigationEnv.getBaseListModel(n);
        this.baseList.setListener(this);
        this.resultListScreenTitleLable = navigationEnv.getLabelModel(402071);
        navigationEnv.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
    }

    public CommandList getStartCommandList() {
        return this.poiSequence.getStartTpegPOICommandList();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        this.resultListScreenTitleLable.setText(evoListRow.getText(1));
        CommandList commandList = this.tpegPOIManager.getResultListListener().getStartCommandList(evoListRow.getUniqueID());
        if (commandList != null) {
            commandList.execute(this.CLASS_NAME + "#itemSelected");
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused was called with model=%2, index=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Long.toString(n2));
        if (this.previewMap != null) {
            this.previewMap.setPreviewAreaAroundCCP(5);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        if (n == DEST_OPT_METHODS_BUTTON_ID) {
            this.getStartCommandList().execute(this.CLASS_NAME + "#Start Tpeg POI Input");
            this.env.fireModelEvent(n, n3);
        } else {
            this.logChannel.log(10000, "%1#keyTyped() -- typed modelID is an invalid id.", (Object)this.CLASS_NAME);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

