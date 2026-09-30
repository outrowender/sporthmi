/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info;

import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.InfoActionProxy;
import de.audi.tghu.info.app.InfoAPImpl;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;

public class InfoActionProxyImplEvo
extends InfoAPImpl
implements InfoActionProxy {
    public InfoActionProxyImplEvo(InfoEnv infoEnv, AppTMC appTMC, LogChannel logChannel) {
        super(infoEnv, appTMC, logChannel);
    }

    public void tmcEnterMainScreen(int n) {
        this.logger.log(10000000, "[InfoActionProxyImplEvo#tmcEnterMainScreen] Called");
        this.env.getMenuModel(500141).resetFocusedItem();
        this.tmcApp.listManager.resetAnchor();
        this.tmcApp.tmcScreenVisible();
        this.tmcApp.getPreviewMap().previewMapScreenEntering(0, 0, 0, 0, true);
        this.tmcApp.requestInitialTMCWindow();
    }

    public void tmcExitMainScreen(int n) {
        this.logger.log(10000000, "[InfoActionProxyImplEvo#tmcExitMainScreen] Called");
    }

    public void tmcEnterScreens(int n) {
        this.tmcApp.tmcScreenVisible();
    }

    public void tmcExitScreens(int n) {
        this.tmcApp.tmcScreenHidden();
        this.env.getChoiceModel(500192).setValue(0);
    }

    public void tmcEnterDetailsScreen(int n) {
        this.logger.log(10000000, "[InfoActionProxyImplEvo#tmcEnterDetailsScreen] Called");
        this.tmcApp.getPreviewMap().previewMapScreenEntering(0, 0, 0, 0);
        this.tmcApp.detailsScreenEntered();
    }

    public void tmcExitDetailsScreen(int n) {
        this.logger.log(10000000, "[InfoActionProxyImplEvo#tmcExitDetailsScreen] Called");
        this.tmcApp.getPreviewMap().previewMapScreenExited();
        this.tmcApp.listManager.setFocusedRowIndex(-1);
        WidgetFocusAdvice widgetFocusAdvice = this.tmcApp.listManager.getLastWidgetFocusAdvice();
        TMCAbstractListRow tMCAbstractListRow = this.tmcApp.listManager.getLastSelectedRow();
        if (widgetFocusAdvice != null && tMCAbstractListRow != null) {
            this.env.getMenuModel(500141).setFocusedItem(500129, widgetFocusAdvice, tMCAbstractListRow.getUniqueID());
        }
    }
}

