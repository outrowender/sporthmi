/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sds;

import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public class GuiModelAccessDetailsSds
extends GuiModelAccessDetailsLocationPoi {
    private final IPreviewMap previewMap;

    public GuiModelAccessDetailsSds(NavigationEnv navigationEnv, IconHandler iconHandler, IDestinationHandler iDestinationHandler, IPreviewMap iPreviewMap) {
        super(navigationEnv, iconHandler, iDestinationHandler);
        this.previewMap = iPreviewMap;
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation) {
        super.onUpdateLocation(navLocation);
        this.previewMap.setStoreFocusForEnterOnce(true);
    }

    @Override
    public void onUpdateLocation(OperatorCallResult operatorCallResult) {
        super.onUpdateLocation(operatorCallResult);
        this.previewMap.setStoreFocusForEnterOnce(true);
    }
}

