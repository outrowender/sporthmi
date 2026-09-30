/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.LIDisambiguateLocationCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class LocationDisambiguatorSequence
implements ILocationDisambiguatorSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final IStartGuidanceToDestinationSequence routeGuidanceSequence;
    protected final INaviFavoriteHandler favHandler;
    private final NaviADBHandler naviADBHandler;
    private final HomeAddressHandler homeAddressHandler;
    private IPoiService poiService = null;
    private final ICommandListFactory commandListFactory;

    public LocationDisambiguatorSequence(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, INaviFavoriteHandler iNaviFavoriteHandler, NaviADBHandler naviADBHandler, HomeAddressHandler homeAddressHandler, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.routeGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.favHandler = iNaviFavoriteHandler;
        this.naviADBHandler = naviADBHandler;
        this.homeAddressHandler = homeAddressHandler;
        this.commandListFactory = iCommandListFactory;
    }

    public void startDisambiguationForNavLocation(NavLocation navLocation, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#startDisambiguationForNavLocation - action=%2, location=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getDisambiguationForNavLocationCommandList(navLocation, iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForNavLocation").toString());
    }

    public void startDisambiguationForLiValueListElement(LIValueListElement lIValueListElement, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#startDisambiguationForLiValueListElement - action=%2, element=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)lIValueListElement);
        this.getDisambiguationForLiValueListElementCommandList(lIValueListElement, iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForLiValueListElement").toString());
    }

    public void startDisambiguationForMapCode(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.getDisambigationForMapCodeCommandList(iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForMapCode").toString());
    }

    public void startDisambiguationForMapCodeBySds(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
        this.getDisambiguationForNavLocationBySdsCommandList(iLocationDisambiguationCallback, n, -1, 0, notifyNaviServiceListenerCommand).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForMapCodeBySds").toString());
    }

    private CommandList getDisambiguationForNavLocationBySdsCommandList(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
        CommandList commandList = this.getDisambigationForMapCodeCommandList(iLocationDisambiguationCallback, n, n2, n3);
        commandList.setErrorCommand(notifyNaviServiceListenerCommand);
        return commandList;
    }

    private CommandList getDisambiguationForNavLocationCommandList(final NavLocation navLocation, final ILocationDisambiguationCallback iLocationDisambiguationCallback, final int n, final int n2, final int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isNormalPoi(navLocation)) {
            commandList.add(new NavCommand("Result is normal POI -> no further actions necessary"){

                public void execute() {
                    LocationDisambiguationWrapper locationDisambiguationWrapper = LocationDisambiguationWrapper.newBuilder().addDisambiguatedLocations(new DisambiguatedNavLocation[]{new DisambiguatedNavLocation(0, navLocation)}).addAction(n).addModelId(n2).addTerminalId(n3).build();
                    iLocationDisambiguationCallback.locationDisambiguationCallback(locationDisambiguationWrapper);
                    this.getCommandList().commandFinished();
                }
            });
        } else {
            commandList.add(new LIDisambiguateLocationCommand(navLocation));
            commandList.add(new NavCommand("Get results and start disambiguation"){

                public void execute() {
                    LocationDisambiguationWrapper locationDisambiguationWrapper = LocationDisambiguationWrapper.newBuilder().addDisambiguatedLocations(this.dsiResponseContainer.getDisambiguatedNavLocations()).addAction(n).addModelId(n2).addTerminalId(n3).build();
                    iLocationDisambiguationCallback.locationDisambiguationCallback(locationDisambiguationWrapper);
                    this.getCommandList().commandFinished();
                }
            });
        }
        return commandList;
    }

    private CommandList getDisambiguationForLiValueListElementCommandList(LIValueListElement lIValueListElement, final ILocationDisambiguationCallback iLocationDisambiguationCallback, final int n, final int n2, final int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Use transformed value list element for follow up command list"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostSequence(LocationDisambiguatorSequence.this.getDisambiguationForNavLocationCommandList(this.dsiResponseContainer.getSelectedLocation(), iLocationDisambiguationCallback, n, n2, n3));
            }
        });
        return commandList;
    }

    private CommandList getDisambigationForMapCodeCommandList(final ILocationDisambiguationCallback iLocationDisambiguationCallback, final int n, final int n2, final int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(67);
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), spellerContext));
        commandList.add(new NavCommand("Based on the LIValueList from south side, update selectedLocation"){

            public void execute() {
                LIValueList lIValueList = this.env.getContainer().getLispValueList();
                if (Util.isListValid(lIValueList) && lIValueList.getList().length == 1) {
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
                        this.getCommandList().commandFinishedWithPostCommand(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
                    } else {
                        this.dsiResponseContainer.setSelectedLocation(null);
                        this.getCommandList().commandAborted("LIValueListElement from south side contains invalid Geographic information, setSelectedLocation to null");
                    }
                } else {
                    this.dsiResponseContainer.setSelectedLocation(null);
                    this.getCommandList().commandAborted("LIValueList from south side is empty or invalid, setSelectedLocation to null");
                }
            }
        });
        commandList.add(new NavCommand("Start Disambiguation with resolved Location"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostSequence(LocationDisambiguatorSequence.this.getDisambiguationForNavLocationCommandList(this.dsiResponseContainer.getSelectedLocation(), iLocationDisambiguationCallback, n, n2, n3));
            }
        });
        return commandList;
    }

    public void startRouteGuidance(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#startRouteGuidance() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.routeGuidanceSequence.start(navLocation);
    }

    public void setLocationAsCurrentLdForSds(final int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand2) {
        this.logChannel.log(10000000, "%1#setLocationAsCurrentLdForSds() - index=%2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Get location for SDS based on index and set as currentLd"){

            public void execute() {
                try {
                    NavLocation navLocation = this.dsiResponseContainer.getDisambiguatedNavLocations()[n].getLocation();
                    LocationDisambiguatorSequence.this.logChannel.log(10000000, "%1#setLocationAsCurrentLdForSds() - set currentLD hard to the selected destination", (Object)this.CLASS_NAME);
                    this.dsiResponseContainer.setLiCurrentState(navLocation, new int[0], new int[0]);
                    this.getCommandList().commandFinished();
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    this.getCommandList().commandAborted("Invalid index provided for selecting the location!");
                }
            }
        });
        commandList.add(notifyNaviServiceListenerCommand);
        commandList.setErrorCommand(notifyNaviServiceListenerCommand2);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setLocationAsCurrentLdForSds").toString());
    }

    public boolean setAsFavorite(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#setAsFavorite() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.favHandler.addToFavorites(navLocation);
        return true;
    }

    public void setAsContact(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#setAsContact() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.naviADBHandler.startStoringAddress(navLocation);
    }

    public void setAsContactFromAdb(NavLocation navLocation) {
        ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(this.commandListFactory);
        returnNavLocationToAddressbookSequence.startWithLocation(navLocation);
    }

    public void setAsHomeAddress(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#setAsHomeAddress() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
    }

    public void setForPoiAtThisLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#setForPoiAtThisLocation() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (this.poiService != null) {
            this.poiService.startPoiWithSearchContext(4, navLocation, false, true);
        } else {
            this.logChannel.log(10000, "%1#setForPoiAtThisLocation - POI Service is null!", (Object)this.CLASS_NAME);
        }
    }

    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }
}

