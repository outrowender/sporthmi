/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence$1;
import de.audi.tghu.navi.app.command.CmdNaviPreviewMapPrepare;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractPoiScreenInputSequence {
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea poiSearchArea;
    protected final NavigationEnv env;
    protected final SpellerStack spellerStack;
    protected int spellerType;
    protected final SpellerContext spellerContext;
    protected final LogChannel logChannel;
    protected final IPoiManager poiManager;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private boolean isSpellerOpen;

    public AbstractPoiScreenInputSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, SpellerContext spellerContext, IPoiManager iPoiManager) {
        this.commandListFactory = iCommandListFactory;
        this.poiSearchArea = poiSearchArea;
        this.env = navigationEnv;
        this.spellerStack = spellerStack;
        this.spellerContext = spellerContext;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.poiManager = iPoiManager;
    }

    public abstract CommandList getStartCommandList() {
    }

    public int getSpellerContextId() {
        return this.spellerContext.getContextID();
    }

    public void focusPreviewMap(IPreviewMap iPreviewMap, NavLocation navLocation) {
        if (navLocation.isPositionValid()) {
            this.focusPreviewMap(this.commandListFactory.createCommandList(1), iPreviewMap, new NavLocation[]{navLocation});
        }
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        this.logChannel.log(-2137614336, "%1#hidePreviewMap() - enter", (Object)this.CLASS_NAME);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new HidePreviewMapCommand(iPreviewMap));
        commandList.execute("AbstractPoiScreenInputSequence hidePreviewMap");
    }

    public void preparePreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        LIValueListElement[] lIValueListElementArray = new LIValueListElement[]{lIValueListElement};
        this.preparePreviewMap(iPreviewMap, lIValueListElementArray);
    }

    public CmdNaviPreviewMapPrepare preparePreviewMap(IPreviewMap iPreviewMap, LIValueListElement[] lIValueListElementArray) {
        this.logChannel.log(-2137614336, "%1#preparePreviewMap() - enter", (Object)this.CLASS_NAME);
        if (!this.isSpellerOpen()) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            NavLocation[] navLocationArray = new NavLocation[lIValueListElementArray.length];
            for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                int n = i2;
                LIValueListElement lIValueListElement = lIValueListElementArray[i2];
                commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
                commandList.add(new AbstractPoiScreenInputSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append(" - Getting NavLocation").toString(), navLocationArray, n));
            }
            return this.focusPreviewMap(commandList, iPreviewMap, navLocationArray);
        }
        return null;
    }

    private CmdNaviPreviewMapPrepare focusPreviewMap(CommandList commandList, IPreviewMap iPreviewMap, NavLocation[] navLocationArray) {
        if (commandList == null) {
            commandList = this.commandListFactory.createCommandList(1);
        }
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.poiSearchArea.getLocation());
        int n = this.poiSearchArea.getSearchContext();
        this.logChannel.log(-2137614336, "%1#focusPreviewMap() - searchContext: %2", (Object)this.CLASS_NAME, (long)n);
        CmdNaviPreviewMapPrepare cmdNaviPreviewMapPrepare = new CmdNaviPreviewMapPrepare(iPreviewMap, navLocationArray, navLocationWgs84, n);
        commandList.add(cmdNaviPreviewMapPrepare);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#preparePreviewMap").toString());
        return cmdNaviPreviewMapPrepare;
    }

    public void setSpellerOpen(boolean bl) {
        this.isSpellerOpen = bl;
    }

    public boolean isSpellerOpen() {
        return this.isSpellerOpen;
    }
}

