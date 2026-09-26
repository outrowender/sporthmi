/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class LocationDisambiguatorPopupHandler
implements ButtonListener,
ILocationDisambiguatorPopupHandler {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private static final int FIRST_LOCATION;
    private static final int SECOND_LOCATION;
    private static final int BRIDGE_POPUP_ID;
    private static final int FERRY_POPUP_ID;
    private static final int MOTORWAY_POPUP_ID;
    private static final int TOLLROAD_POPUP_ID;
    private static final int TUNNEL_POPUP_ID;
    private static final int NO_POPUP_POSSIBLE_ID;
    private static final int SELECT_THIS_ROAD_BUTTON_ID;
    private static final int SELECT_OTHER_ROAD_BUTTON_ID;
    private final NavigationEnv env;
    private final ILocationDisambiguatorSequence sequence;
    private final LogChannel logChannel;
    private final IHMIServiceApp hmiServiceApp;
    private DisambiguatedNavLocation thisRoadButtonLocation = null;
    private DisambiguatedNavLocation otherRoadButtonLocation = null;
    private int currentModelId = -1;
    private int currentTerminalId = -1;
    private int currentAction = -1;

    public LocationDisambiguatorPopupHandler(NavigationEnv navigationEnv, ILocationDisambiguatorSequence iLocationDisambiguatorSequence) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.sequence = iLocationDisambiguatorSequence;
        this.hmiServiceApp = navigationEnv.getFramework().getHmiServiceApp();
        navigationEnv.getButtonModel(-1658780160).setButtonListener(this);
        navigationEnv.getButtonModel(-1642002944).setButtonListener(this);
    }

    @Override
    public void startPopupHandlingForSds(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.startPopupHandlingAndMapLocationsToPopupButtons(locationDisambiguationWrapper, false);
    }

    @Override
    public void startPopupHandling(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.startPopupHandlingAndMapLocationsToPopupButtons(locationDisambiguationWrapper, true);
    }

    private void startPopupHandlingAndMapLocationsToPopupButtons(LocationDisambiguationWrapper locationDisambiguationWrapper, boolean bl) {
        this.currentAction = locationDisambiguationWrapper.getAction();
        this.currentModelId = locationDisambiguationWrapper.getModelId();
        this.currentTerminalId = locationDisambiguationWrapper.getTerminalId();
        if (this.isPopupHandlingNeeded(locationDisambiguationWrapper.getLocations())) {
            int n = this.mapDisambiguatedLocationsToButtons(locationDisambiguationWrapper.getLocations());
            if (bl) {
                this.hmiServiceApp.showPartialPopup(locationDisambiguationWrapper.getTerminalId(), n);
            }
        } else if (bl) {
            this.performAction(locationDisambiguationWrapper.getLocations()[0].getLocation());
        }
    }

    private int mapDisambiguatedLocationsToButtons(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        this.logChannel.log(-2137614336, "%1#mapDisambiguatedLocationsToButtons - locations.length=%2", (Object)this.CLASS_NAME, (long)disambiguatedNavLocationArray.length);
        int n = this.matchTypeToPopupId(disambiguatedNavLocationArray[0].getType());
        if (n != -1) {
            this.logChannel.log(-2137614336, "%1#mapDisambiguatedLocationsToButtons - first location is mapped to thisRoadButton.", (Object)this.CLASS_NAME);
            this.thisRoadButtonLocation = disambiguatedNavLocationArray[0];
            this.otherRoadButtonLocation = disambiguatedNavLocationArray[1];
            return n;
        }
        n = this.matchTypeToPopupId(disambiguatedNavLocationArray[1].getType());
        if (n != -1) {
            this.logChannel.log(-2137614336, "%1#mapDisambiguatedLocationsToButtons - second location is mapped to thisRoadButton.", (Object)this.CLASS_NAME);
            this.thisRoadButtonLocation = disambiguatedNavLocationArray[1];
            this.otherRoadButtonLocation = disambiguatedNavLocationArray[0];
            return n;
        }
        this.logChannel.log(10000, "%1#mapDisambiguatedLocationsToButtons - not valid type provided for the disambiguated locations!", (Object)this.CLASS_NAME);
        return -1;
    }

    private int matchTypeToPopupId(int n) {
        this.logChannel.log(-2137614336, "%1#matchTypeAndShowPopup - type=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 5: {
                return -1759836672;
            }
            case 3: {
                return -1743059456;
            }
            case 1: {
                return -1793391104;
            }
            case 4: {
                return -1776613888;
            }
            case 2: {
                return -1726282240;
            }
        }
        this.logChannel.log(-2137614336, "%1#matchTypeAndShowPopup - no matching for type=%2", (Object)this.CLASS_NAME, (long)n);
        return -1;
    }

    private void performAction(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#performAction - currentAction=%2, location=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(this.currentAction), (Object)LocationFormatter.formatLocationShort(navLocation));
        switch (this.currentAction) {
            case 2: {
                this.sequence.setAsContact(navLocation);
                break;
            }
            case 3: {
                this.sequence.setAsContactFromAdb(navLocation);
                break;
            }
            case 1: {
                this.sequence.setAsFavorite(navLocation);
                break;
            }
            case 4: {
                this.sequence.setAsHomeAddress(navLocation);
                break;
            }
            case 5: {
                this.sequence.setForPoiAtThisLocation(navLocation);
                break;
            }
            case 0: {
                this.sequence.startRouteGuidance(navLocation);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#performAction - invalid action received!", (Object)this.CLASS_NAME);
            }
        }
        this.env.fireModelEvent(this.currentModelId, this.currentTerminalId);
    }

    private boolean isPopupHandlingNeeded(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        return disambiguatedNavLocationArray.length > 1;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed() - modelID=%2, keyID=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == -1658780160) {
            this.performAction(this.thisRoadButtonLocation.getLocation());
        } else if (n == -1642002944) {
            this.performAction(this.otherRoadButtonLocation.getLocation());
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

