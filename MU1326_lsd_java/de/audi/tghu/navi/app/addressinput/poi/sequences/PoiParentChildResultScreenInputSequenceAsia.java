/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildResultScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequence;
import de.audi.tghu.navi.app.command.CmdNaviPreviewMapPrepare;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class PoiParentChildResultScreenInputSequenceAsia
extends PoiParentChildResultScreenInputSequence {
    public PoiParentChildResultScreenInputSequenceAsia(IPoiParentChildResultScreenModelAccess iPoiParentChildResultScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iPoiParentChildResultScreenModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, iPoiManager);
    }

    public void focusPreviewMap(IPreviewMap iPreviewMap, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.poiSearchArea.getLocation());
        int n = this.poiSearchArea.getSearchContext();
        this.logChannel.log(10000000, "%1#focusPreviewMap() - searchContext: %2", (Object)this.CLASS_NAME, (long)n);
        CmdNaviPreviewMapPrepare cmdNaviPreviewMapPrepare = new CmdNaviPreviewMapPrepare(iPreviewMap, new NavLocation[]{navLocation}, navLocationWgs84, -1);
        commandList.add(cmdNaviPreviewMapPrepare);
        commandList.execute(this.CLASS_NAME + "#focusPreviewMap");
    }
}

