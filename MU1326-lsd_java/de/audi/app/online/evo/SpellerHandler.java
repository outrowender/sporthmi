/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.search.AbstractSpellerHandler;
import de.audi.tghu.online.app.remotehmi.search.ITruffleSearchHandler;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.search.Token;

public class SpellerHandler
extends AbstractSpellerHandler {
    private HMIViewGridListener gridListener;

    public SpellerHandler(LogChannel logChannel, OnlineModelBankAccess onlineModelBankAccess, RemoteHMIService remoteHMIService, HMIViewGridListener hMIViewGridListener, ModelGroup modelGroup) {
        super(logChannel, remoteHMIService);
        this.gridListener = hMIViewGridListener;
        this.spellerModel = onlineModelBankAccess.getSpellerModel(1578836736);
        this.spellerModel.setSpellerListener(this);
        modelGroup.add(this.spellerModel);
        this.spellerBarVisibilityChoice = onlineModelBankAccess.getChoiceModel(1595613952);
        modelGroup.add(this.spellerBarVisibilityChoice);
    }

    @Override
    public void setTruffleComponent(ITruffleSearchHandler iTruffleSearchHandler) {
        this.truffleSearchHandler = iTruffleSearchHandler;
    }

    public void updateViewProperties(ISpeller iSpeller, IGridList iGridList, boolean bl, boolean bl2, boolean bl3) {
        String string;
        super.updateViewProperties(iSpeller, bl3);
        iGridList.setSpeller(iSpeller);
        if (bl) {
            this.clearSpeller();
            this.spellerValues = new HashMap();
            if (bl2 && iSpeller.getType() == 0) {
                iGridList.restoreInitialGridVisibility();
                iGridList.deleteGridHighlight();
            }
        }
        if ((string = iSpeller.getText()) != null) {
            this.spellerModel.setText(string);
        }
    }

    @Override
    protected void triggerSpellerAction(RemoteHMIAction remoteHMIAction, int n, String string) {
        String string2;
        int n2;
        IGridList iGridList = this.gridListener.getCurrentGridList();
        IGrid iGrid = iGridList.getGridOfWidgetId(n);
        if (iGrid == null) {
            n2 = -1;
            string2 = "";
        } else {
            n2 = iGrid.getXmlSourceRow();
            string2 = iGrid.getId();
        }
        this.invokeAction(remoteHMIAction, string, n2, string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void applySearchFilter(int n, Token[] tokenArray) {
        IGridList iGridList = this.gridListener.getCurrentGridList();
        ArrayList arrayList = this.createHighlightList(tokenArray);
        IGridList iGridList2 = iGridList;
        synchronized (iGridList2) {
            iGridList.setRendered(false);
            iGridList.applySearchFilter(n, arrayList);
        }
        this.gridListener.renderGridList(5, false, 3);
    }

    @Override
    protected void processTextChanged(int n, String string, char c2, int n2) {
        this.spellerValues.put(new Integer(n), string);
        if (this.type == 0) {
            if (this.truffleSearchHandler != null) {
                this.truffleSearchHandler.cancelQuery();
                this.truffleSearchHandler.performQuery(string, this.gridListener.getCurrentGridList(), this);
                this.gridListener.renderGridList(5, false, 3);
            } else {
                this.logChannel.log(-1601830656, "AbstractSpellerHandler#textChanged: truffleSearchHandler is null, no search will be executed!");
            }
        } else {
            this.triggerSpellerAction(this.service.getAction(-985329920), n, string);
        }
    }

    @Override
    protected void spellerBandVisibilityCallback(boolean bl) {
        this.gridListener.spellerBandVisibilityCallback(bl);
    }
}

