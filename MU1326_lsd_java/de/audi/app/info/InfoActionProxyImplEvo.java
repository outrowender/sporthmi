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

    @Override
    public void tmcEnterMainScreen(int n) {
        this.logger.log(-2137614336, "[InfoActionProxyImplEvo#tmcEnterMainScreen] Called");
        this.env.getMenuModel(-1381955840).resetFocusedItem();
        this.tmcApp.listManager.resetAnchor();
        this.tmcApp.tmcScreenVisible();
        this.tmcApp.getPreviewMap().previewMapScreenEntering(0, 0, 0, 0, true);
        this.tmcApp.requestInitialTMCWindow();
    }

    @Override
    public void tmcExitMainScreen(int n) {
        this.logger.log(-2137614336, "[InfoActionProxyImplEvo#tmcExitMainScreen] Called");
    }

    @Override
    public void tmcEnterScreens(int n) {
        this.tmcApp.tmcScreenVisible();
    }

    @Override
    public void tmcExitScreens(int n) {
        this.tmcApp.tmcScreenHidden();
        this.env.getChoiceModel(-526317824).setValue(0);
    }

    @Override
    public void tmcEnterDetailsScreen(int n) {
        this.logger.log(-2137614336, "[InfoActionProxyImplEvo#tmcEnterDetailsScreen] Called");
        this.tmcApp.getPreviewMap().previewMapScreenEntering(0, 0, 0, 0);
        this.tmcApp.detailsScreenEntered();
    }

    @Override
    public void tmcExitDetailsScreen(int n) {
        this.logger.log(-2137614336, "[InfoActionProxyImplEvo#tmcExitDetailsScreen] Called");
        this.tmcApp.getPreviewMap().previewMapScreenExited();
        this.tmcApp.listManager.setFocusedRowIndex(-1);
        WidgetFocusAdvice widgetFocusAdvice = this.tmcApp.listManager.getLastWidgetFocusAdvice();
        TMCAbstractListRow tMCAbstractListRow = this.tmcApp.listManager.getLastSelectedRow();
        if (widgetFocusAdvice != null && tMCAbstractListRow != null) {
            this.env.getMenuModel(-1381955840).setFocusedItem(-1583282432, widgetFocusAdvice, tMCAbstractListRow.getUniqueID());
        }
    }
}

