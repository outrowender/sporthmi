/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.details;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsForMap;
import de.audi.app.navi.evo.details.DetailsHMIListener$1;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.DetailsDestinationHandlerAsia;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.details.IDetailsHMIListener;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.tmc.TmcMessage;

public class DetailsHMIListener
implements IDetailsHMIListener {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final LogChannel logChannel;
    protected final NavigationEnv env;
    protected final IDestinationHandler detailsHandler;
    protected final IconHandler iconHandler;
    protected final ITelService telService;
    protected final MapInterface mapInterface;
    protected final NavigationBrowser navigationBrowser;
    protected final NaviInterface naviInterface;
    protected DemoModeManager demoModeManager;
    protected NavLocation destinationLocation;
    protected TmcMessage tmcmsg;
    protected NavLocation lastLocation = null;
    protected boolean isFocused = false;
    protected final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;

    public DetailsHMIListener(NavigationEnv navigationEnv, NaviInterface naviInterface, MapInterface mapInterface, NavigationBrowser navigationBrowser, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IconHandler iconHandler, ITelService iTelService, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.detailsHandler = Util.isHURegionAsia() ? new DetailsDestinationHandlerAsia(iCommandListFactory) : new DetailsDestionationHandler();
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.iconHandler = iconHandler;
        this.telService = iTelService;
        this.logChannel = navigationEnv.getLogChannel();
        this.navigationBrowser = navigationBrowser;
        this.naviInterface = naviInterface;
        this.initListeners();
    }

    @Override
    public void setDemoModeManager(DemoModeManager demoModeManager) {
        this.demoModeManager = demoModeManager;
    }

    @Override
    public IDestinationHandler getDestinationHandler() {
        return this.detailsHandler;
    }

    @Override
    public void enterDetailsScreen(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#enterDetailsScreen", (Object)this.CLASS_NAME);
        this.resetPreviousLocation();
        this.destinationLocation = navLocation;
        GuiModelAccessDetailsForMap guiModelAccessDetailsForMap = new GuiModelAccessDetailsForMap(this.env, this.iconHandler, this.detailsHandler);
        guiModelAccessDetailsForMap.onUpdateLocation(navLocation);
    }

    @Override
    public void enterDetailsScreenTmc(TmcMessage tmcMessage) {
        this.logChannel.log(-2137614336, "%1#enterDetailsScreenTmc", (Object)this.CLASS_NAME);
        this.destinationLocation = null;
        this.resetPreviousLocation();
        this.tmcmsg = tmcMessage;
    }

    @Override
    public void enterDetailsScreenOperatorCall(OperatorCallResult operatorCallResult) {
        this.resetPreviousLocation();
    }

    protected void initListeners() {
        this.env.getButtonModel(-2128673280).setButtonListener(this);
        this.env.getButtonModel(2133067264).setButtonListener(this);
        this.env.getButtonModel(-618658304).setButtonListener(this);
        this.env.getButtonModel(-1088485888).setButtonListener(this);
        this.env.getMenuModel(2099185152).setListener(this);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped. modelId: %2, keyId: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.resetPreviousLocation();
        if (n == -2128673280) {
            this.startGuidanceToDestinationSequence.start(this.detailsHandler.getLocation());
            this.logChannel.log(-2137614336, "%1#keyTyped. modelId: %2, keyId: %3 - fire model event", (Object)this.CLASS_NAME, (long)n, (long)n2);
            this.env.fireModelEvent(n, n3);
        } else if (n == 2133067264) {
            this.logChannel.log(-2137614336, "%1#keyTyped - call number", (Object)this.CLASS_NAME);
            if (Util.isEmpty(this.detailsHandler.getNumber())) {
                this.logChannel.log(-1601830656, "%1#keyTyped. modelId: %2, keyId: %3 - Phone number is empty, but button was enabled.", (Object)this.CLASS_NAME, (long)n, (long)n2);
                return;
            }
            this.telService.dialNumber(this.detailsHandler.getNumber(), new DetailsHMIListener$1(this, n), true);
            this.logChannel.log(-2137614336, "%1#keyTyped. modelId: %2, keyId: %3 - fire model event", (Object)this.CLASS_NAME, (long)n, (long)n2);
            this.env.fireModelEvent(n, n3);
        } else if (n == -618658304) {
            this.env.fireModelEvent(n, n3);
            String string = LocationFormatter.getURLAddress(this.detailsHandler.getLocation());
            this.logChannel.log(1078071040, "%1#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - loading URL: '%2' ", (Object)this.CLASS_NAME, (Object)string);
            boolean bl = this.navigationBrowser.loadURL(2, string, true);
            if (!bl) {
                this.logChannel.log(10000, "%1#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - failed to load url: '%2' ", (Object)this.CLASS_NAME, (Object)string);
            }
        } else if (n == -1088485888) {
            this.logChannel.log(-2137614336, "%1#keyTyped - save selected address", (Object)this.CLASS_NAME);
            if (this.env.getChoiceModel(1579091456).getValue() == 1) {
                this.demoModeManager.setDemoModeLocation(this.detailsHandler.getLocation());
            } else {
                this.logChannel.log(10000, "%1#keyTyped - save selected address - unexpected call", (Object)this.CLASS_NAME);
            }
            this.env.fireModelEvent(n, n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == 2099185152) {
            NavLocation navLocation = this.detailsHandler.getLocation();
            if (!this.isFocused || this.lastLocation == null || !this.areLocationsEqual(navLocation)) {
                this.isFocused = true;
                this.mapInterface.getPreviewMap().setPreviewMapCallbackHandler(this);
                this.logChannel.log(-2137614336, "%1#itemFocused tempLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                this.logChannel.log(-2137614336, "%1#itemFocused lastLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.lastLocation));
                if (!Util.isEmpty(LocationFormatter.formatPOIName(navLocation))) {
                    try {
                        this.mapInterface.getPreviewMap().setPreviewPOIsOnboardDistant(new NavLocation[]{navLocation}, 1, null, null);
                    }
                    catch (Exception exception) {
                        this.logChannel.log(10000, "DetailsHMIListener#itemFocused() - ERROR=%1", (Throwable)exception);
                    }
                    this.logChannel.log(-2137614336, "%1#itemFocused setting preview map as POI to location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                } else {
                    try {
                        this.mapInterface.getPreviewMap().setPreviewLocationDistant(navLocation, 1, null, null);
                    }
                    catch (Exception exception) {
                        this.logChannel.log(10000, "DetailsHMIListener#itemFocused() - ERROR=%1", (Throwable)exception);
                    }
                    this.logChannel.log(-2137614336, "%1#itemFocused setting preview map as single event to location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                }
                this.lastLocation = navLocation;
            }
        }
    }

    private boolean areLocationsEqual(NavLocation navLocation) {
        if (navLocation != null && this.lastLocation != null) {
            return navLocation.longitude == this.lastLocation.longitude && navLocation.latitude == this.lastLocation.latitude;
        }
        return false;
    }

    @Override
    public void onPreviewMapEntered() {
        this.logChannel.log(-2137614336, "%1#onPreviewMapEntered()", (Object)this.CLASS_NAME);
        if (!this.isFocused && this.destinationLocation != null) {
            if (!Util.isEmpty(LocationFormatter.formatPOIName(this.destinationLocation))) {
                try {
                    this.mapInterface.getPreviewMap().setPreviewPOIsOnboardDistant(new NavLocation[]{this.destinationLocation}, 1, null, null);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "DetailsHMIListener#onPreviewMapEntered() - ERROR=%1", (Throwable)exception);
                }
                this.destinationLocation = null;
            } else if (this.destinationLocation != null) {
                try {
                    this.mapInterface.getPreviewMap().setPreviewLocationDistant(this.destinationLocation, 1, null, null);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "DetailsHMIListener#onPreviewMapEntered() - ERROR=%1", (Throwable)exception);
                }
            } else {
                this.logChannel.log(-1601830656, "%1#onPreviewMapEntered() - received NULL location. Setting no preview map.", (Object)this.CLASS_NAME);
            }
        }
    }

    @Override
    public void onPreviewMapLeft() {
        this.resetPreviousLocation();
    }

    protected void resetPreviousLocation() {
        this.isFocused = false;
    }
}

