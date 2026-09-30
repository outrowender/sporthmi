/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiClassScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiClassScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiClassScreenModelAccess modelAccess;

    public PoiClassScreenInputSequence(IPoiClassScreenModelAccess iPoiClassScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(12), iPoiManager);
        this.spellerType = 32769;
        this.modelAccess = iPoiClassScreenModelAccess;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        if (this.modelAccess != null) {
            commandList.add(new PoiModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand(this.CLASS_NAME + "#ChooseSpellerTypeDependentOnSearchContext"){

            public void execute() {
                if (PoiClassScreenInputSequence.this.poiSearchArea.getSearchContext() == 1) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(PoiClassScreenInputSequence.this.spellerType, Util.isHURegionNAR()));
                } else {
                    CommandList commandList = PoiClassScreenInputSequence.this.createStartSpellerCommandList(PoiClassScreenInputSequence.this.spellerType);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    public CommandList getStartSearchByName() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartCategories(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    protected CommandList createStartSpellerCommandList(int n) {
        NavLocation navLocation = PoiUtil.getLocation(this.poiSearchArea, this.env);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new LIStartSpellerCommand(n, false, false, false));
        return commandList;
    }

    private int getSortOrder() {
        return 0;
    }
}

