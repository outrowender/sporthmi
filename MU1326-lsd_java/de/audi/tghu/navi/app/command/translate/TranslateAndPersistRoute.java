/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.translate;

import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.command.translate.TranslateRouteCommand;
import org.dsi.ifc.navigation.Route;

public class TranslateAndPersistRoute
extends TranslateRouteCommand {
    public TranslateAndPersistRoute(Route route) {
        super(route);
    }

    @Override
    public void translateRouteResult(Route route) {
        if (this.handleTranslatedRoute(route)) {
            this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(route));
        } else {
            this.getCommandList().commandAborted("translation not successful");
        }
    }
}

