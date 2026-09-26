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
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.LIDisambiguateLocationCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$1;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$2;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$3;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$4;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$5;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence$6;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class LocationDisambiguatorSequence
implements ILocationDisambiguatorSequence {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
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

    @Override
    public void startDisambiguationForNavLocation(NavLocation navLocation, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#startDisambiguationForNavLocation - action=%2, location=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getDisambiguationForNavLocationCommandList(navLocation, iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForNavLocation").toString());
    }

    @Override
    public void startDisambiguationForLiValueListElement(LIValueListElement lIValueListElement, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#startDisambiguationForLiValueListElement - action=%2, element=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)lIValueListElement);
        this.getDisambiguationForLiValueListElementCommandList(lIValueListElement, iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForLiValueListElement").toString());
    }

    @Override
    public void startDisambiguationForMapCode(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        this.getDisambigationForMapCodeCommandList(iLocationDisambiguationCallback, n, n2, n3).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForMapCode").toString());
    }

    @Override
    public void startDisambiguationForMapCodeBySds(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
        this.getDisambiguationForNavLocationBySdsCommandList(iLocationDisambiguationCallback, n, -1, 0, notifyNaviServiceListenerCommand).execute(new StringBuffer().append(this.CLASS_NAME).append("#startDisambiguationForMapCodeBySds").toString());
    }

    private CommandList getDisambiguationForNavLocationBySdsCommandList(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
        CommandList commandList = this.getDisambigationForMapCodeCommandList(iLocationDisambiguationCallback, n, n2, n3);
        commandList.setErrorCommand(notifyNaviServiceListenerCommand);
        return commandList;
    }

    private CommandList getDisambiguationForNavLocationCommandList(NavLocation navLocation, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isNormalPoi(navLocation)) {
            commandList.add(new LocationDisambiguatorSequence$1(this, "Result is normal POI -> no further actions necessary", navLocation, n, n2, n3, iLocationDisambiguationCallback));
        } else {
            commandList.add(new LIDisambiguateLocationCommand(navLocation));
            commandList.add(new LocationDisambiguatorSequence$2(this, "Get results and start disambiguation", n, n2, n3, iLocationDisambiguationCallback));
        }
        return commandList;
    }

    private CommandList getDisambiguationForLiValueListElementCommandList(LIValueListElement lIValueListElement, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new LocationDisambiguatorSequence$3(this, "Use transformed value list element for follow up command list", iLocationDisambiguationCallback, n, n2, n3));
        return commandList;
    }

    private CommandList getDisambigationForMapCodeCommandList(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        SpellerContext spellerContext = SpellerContextManager.getSpellerContext(67);
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), spellerContext));
        commandList.add(new LocationDisambiguatorSequence$4(this, "Based on the LIValueList from south side, update selectedLocation"));
        commandList.add(new LocationDisambiguatorSequence$5(this, "Start Disambiguation with resolved Location", iLocationDisambiguationCallback, n, n2, n3));
        return commandList;
    }

    @Override
    public void startRouteGuidance(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#startRouteGuidance() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.routeGuidanceSequence.start(navLocation);
    }

    @Override
    public void setLocationAsCurrentLdForSds(int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand2) {
        this.logChannel.log(-2137614336, "%1#setLocationAsCurrentLdForSds() - index=%2", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationDisambiguatorSequence$6(this, "Get location for SDS based on index and set as currentLd", n));
        commandList.add(notifyNaviServiceListenerCommand);
        commandList.setErrorCommand(notifyNaviServiceListenerCommand2);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setLocationAsCurrentLdForSds").toString());
    }

    @Override
    public boolean setAsFavorite(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#setAsFavorite() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.favHandler.addToFavorites(navLocation);
        return true;
    }

    @Override
    public void setAsContact(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#setAsContact() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.naviADBHandler.startStoringAddress(navLocation);
    }

    @Override
    public void setAsContactFromAdb(NavLocation navLocation) {
        ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(this.commandListFactory);
        returnNavLocationToAddressbookSequence.startWithLocation(navLocation);
    }

    @Override
    public void setAsHomeAddress(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#setAsHomeAddress() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
    }

    @Override
    public void setForPoiAtThisLocation(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#setForPoiAtThisLocation() - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (this.poiService != null) {
            this.poiService.startPoiWithSearchContext(4, navLocation, false, true);
        } else {
            this.logChannel.log(10000, "%1#setForPoiAtThisLocation - POI Service is null!", (Object)this.CLASS_NAME);
        }
    }

    @Override
    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    static /* synthetic */ CommandList access$000(LocationDisambiguatorSequence locationDisambiguatorSequence, NavLocation navLocation, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
        return locationDisambiguatorSequence.getDisambiguationForNavLocationCommandList(navLocation, iLocationDisambiguationCallback, n, n2, n3);
    }
}

