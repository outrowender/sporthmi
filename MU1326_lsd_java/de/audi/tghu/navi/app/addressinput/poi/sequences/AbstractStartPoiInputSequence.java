/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractStartPoiInputSequence
extends AbstractPoiSequence {
    protected final PoiSearchArea searchArea;
    protected final int spellerType;

    public AbstractStartPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, iDetailsScreen);
        this.searchArea = poiSearchArea;
        this.spellerType = n;
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                AbstractStartPoiInputSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand("AbstractStartPoiInputSequence#SpellerType"){

            public void execute() {
                if (AbstractStartPoiInputSequence.this.searchArea.getSearchContext() == 1) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(AbstractStartPoiInputSequence.this.spellerType, Util.isHURegionNAR()));
                } else if (AbstractStartPoiInputSequence.this.searchArea.getSearchContext() == 5 && AbstractStartPoiInputSequence.this.spellerType == 32778) {
                    CommandList commandList = AbstractStartPoiInputSequence.this.createStartSpellerCommandList(32771);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    CommandList commandList = AbstractStartPoiInputSequence.this.createStartSpellerCommandList(AbstractStartPoiInputSequence.this.spellerType);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListWithWaitCommand(this.modelAccess, this.commandListFactory, -1, 0, 1));
        }
        return commandList;
    }

    protected CommandList createStartSpellerCommandList(int n) {
        NavLocation navLocation = this.getLocation(this.searchArea);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new LIStartSpellerCommand(n, false, false, false));
        return commandList;
    }

    protected NavLocation getLocation(PoiSearchArea poiSearchArea) {
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractStartPoiInputSequence#getLocation() - searchContext: %1", (long)poiSearchArea.getSearchContext());
        NavLocation navLocation = null;
        switch (poiSearchArea.getSearchContext()) {
            case 0: {
                navLocation = Util.getDynamicVicinityLocation();
                navLocation = this.transformLocationBySurrounding(navLocation);
                break;
            }
            case 1: {
                navLocation = null;
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                navLocation = poiSearchArea.getLocation();
                if (navLocation == null || !navLocation.isPositionValid()) {
                    navLocation = null;
                    this.env.getLogChannel().log(10000, "[PoiInput] AbstractStartPoiInputSequence#getLocation() - failed to resolve navigable destination: %1!", (Object)LocationFormatter.formatLocationShort(navLocation));
                    break;
                }
                navLocation = this.transformLocationBySurrounding(navLocation);
                break;
            }
            case 5: {
                navLocation = poiSearchArea.getLocation();
                if (navLocation != null && !Util.isEmpty(navLocation.getCountry())) break;
                navLocation = null;
                this.env.getLogChannel().log(10000, "[PoiInput] AbstractStartPoiInputSequence#getLocation() - failed to resolve navigable destination: %1!", (Object)LocationFormatter.formatLocationShort(navLocation));
                break;
            }
            default: {
                this.env.getLogChannel().log(10000, "[PoiInput] AbstractStartPoiInputSequence#getLocation() - failed to resolve PoiSearchArea: %1!", (long)poiSearchArea.getSearchContext());
                navLocation = null;
            }
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractStartPoiInputSequence#getLocation() - location: %1", (Object)navLocation);
        return navLocation;
    }

    private NavLocation transformLocationBySurrounding(NavLocation navLocation) {
        int n = navLocation.getLongitude();
        int n2 = navLocation.getLatitude();
        navLocation = Util.getLocationFromGeoPos(n, n2);
        return navLocation;
    }
}

