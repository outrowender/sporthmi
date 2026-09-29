/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public class StartRouteGuidanceDependentHMIListener
implements ButtonListener,
AddSelectedDestinationAtIndexCommandListCreator {
    private NavigationEnv env;
    private IStartGuidanceManager routeManager;
    private DemoModeManager demoModeManager;
    private IDestinationHandler destinationHandler;
    public static final int SINGLE_DEST_MODE;
    public static final int STOP_OVER_MODE;
    public static final int REPLACE_STOP_OVER_MODE;
    public static final int REPLACE_ALL_DEST;
    public static final int INDEX_MODE;
    private IAlternativeRouteStateManager alternativeRouteStateManager;
    private MapInterface mapInterface;
    private IPoiService poiService;
    private final CombiBAPListener combiBAPListener;
    private static final int STOP_OVER_INDEX;
    private volatile int mode = 1;
    private volatile int destinationIndex;
    private volatile boolean replace;

    public StartRouteGuidanceDependentHMIListener(NavigationEnv navigationEnv, IStartGuidanceManager iStartGuidanceManager, DemoModeManager demoModeManager, MapInterface mapInterface, IAlternativeRouteStateManager iAlternativeRouteStateManager, CombiBAPListener combiBAPListener) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.alternativeRouteStateManager = iAlternativeRouteStateManager;
        this.routeManager = iStartGuidanceManager;
        this.combiBAPListener = combiBAPListener;
        this.destinationHandler = new DetailsDestionationHandler();
        this.demoModeManager = demoModeManager;
        this.initListeners();
    }

    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    public IDestinationHandler getDestinationHandler() {
        return this.destinationHandler;
    }

    public void cleanUp() {
        this.env.getButtonModel(-1927346688).setButtonListener(null);
        this.env.getButtonModel(1562314240).setButtonListener(null);
        this.env.getButtonModel(-1893792256).setButtonListener(null);
        this.env.getButtonModel(-1910569472).setButtonListener(null);
        this.env.getButtonModel(1780352512).setButtonListener(null);
        this.env.getButtonModel(1797129728).setButtonListener(null);
        this.env = null;
        this.destinationHandler = null;
        this.mapInterface = null;
        this.routeManager = null;
        this.demoModeManager = null;
    }

    private void initListeners() {
        this.env.getButtonModel(-1927346688).setButtonListener(this);
        this.env.getButtonModel(1562314240).setButtonListener(this);
        this.env.getButtonModel(-1893792256).setButtonListener(this);
        this.env.getButtonModel(-1910569472).setButtonListener(this);
        this.env.getButtonModel(1780352512).setButtonListener(this);
        this.env.getButtonModel(1797129728).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped. modelId: %1, keyId: %2", (long)n, (long)n2);
        if (this.poiService != null) {
            this.poiService.setRouteGuidanceStartedByUser(true);
        } else {
            this.env.getPOILogChannel().log(-1601830656, "StartRouteGuidanceDependentHMIListener#keyTyped - poiService is null!");
        }
        if (n == 1780352512) {
            if (this.destinationHandler.getDestinationType() == 0) {
                if (this.env.getContainer().isRgActive()) {
                    this.startGuidance(this.mode, false);
                } else {
                    this.startGuidance(1, false);
                }
            } else if (this.destinationHandler.getDestinationType() == 1) {
                this.startGuidance(this.destinationHandler.getRoute(), false);
            } else if (this.destinationHandler.getDestinationType() == 2) {
                this.startGuidance(this.destinationHandler.getSegmentID(), false);
            } else {
                this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped unknown DestinationType %1", (long)this.destinationHandler.getDestinationType());
            }
        } else if (n == 1797129728) {
            if (this.destinationHandler.getDestinationType() == 0) {
                if (this.env.getContainer().isRgActive()) {
                    this.startGuidance(this.mode, true);
                } else {
                    this.startGuidance(1, true);
                }
            } else if (this.destinationHandler.getDestinationType() == 1) {
                this.startGuidance(this.destinationHandler.getRoute(), true);
            } else if (this.destinationHandler.getDestinationType() == 2) {
                this.startGuidance(this.destinationHandler.getSegmentID(), true);
            } else {
                this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped unknown DestinationType %1", (long)this.destinationHandler.getDestinationType());
            }
        } else {
            if (n == -1927346688) {
                this.mode = 1;
            } else if (n == 1562314240) {
                this.mode = 2;
            } else if (n == -1893792256) {
                this.mode = 3;
            } else if (n == -1910569472) {
                this.mode = 1;
            } else {
                this.env.getLogChannel().log(-1601830656, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped() - unsupported modelID: %1", (long)n);
                return;
            }
            if (!this.env.getContainer().isEtcDemoMode()) {
                this.startGuidance(this.mode, false);
            }
        }
        this.combiBAPListener.popupButtonPressed();
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped. modelId: %1, keyId: %2 - fire model event", (long)n, (long)n2);
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void startGuidance(int n, boolean bl) {
        CommandList commandList;
        boolean bl2 = this.alternativeRouteStateManager.getAlternativeRouteState() == 0;
        NavLocation navLocation = this.destinationHandler.getLocation();
        CommandList commandList2 = null;
        if (bl) {
            commandList2 = this.demoModeManager.getCommandListToTurnDemoMode(false);
        }
        this.env.getLogChannel().log(-1601830656, "StartRouteGuidanceDependentHMIListener#startGuidance #### Starting Route Guidance in mode = %1, Demomode will be turned to = %2", (Object)new StringBuffer().append(n).append("").toString(), (Object)new StringBuffer().append(bl).append("").toString());
        switch (n) {
            case 3: {
                if (Util.alternativeRoutesWithStopOverAreDisabled(this.env.getFramework())) {
                    bl2 = true;
                }
                this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
                commandList = this.routeManager.getStartGuidanceWithReplacedDestinationSequence(this.destinationHandler.getLocation(), 0);
                break;
            }
            case 1: {
                this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
                commandList = this.routeManager.getStartRouteGuidanceToSingleDestinationSequence(this.destinationHandler.getLocation());
                break;
            }
            case 2: {
                this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
                commandList = this.routeManager.getStartGuidanceWithAddedStopOverSequence(this.destinationHandler.getLocation(), 0);
                break;
            }
            case 4: {
                this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
                commandList = this.routeManager.getStartRouteGuidanceToSingleDestinationSequence(this.destinationHandler.getLocation());
                break;
            }
            case 5: {
                this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
                commandList = this.routeManager.getStartGuidance(this.destinationHandler.getLocation(), this.destinationIndex, this.replace, false);
                break;
            }
            default: {
                this.env.getLogChannel().log(-1601830656, "StartRouteGuidanceDependentHMIListener#startGuidance- unknown mode: %1", (long)n);
                Object var6_7 = null;
                return;
            }
        }
        if (commandList2 == null) {
            commandList2 = commandList;
        } else {
            commandList2.add(commandList);
        }
        commandList2.execute("StartRouteGuidanceDependentHmiListener#startGuidance");
    }

    private void startGuidance(Route route, boolean bl) {
        CommandList commandList = null;
        if (bl) {
            commandList = this.demoModeManager.getCommandListToTurnDemoMode(false);
        }
        if (commandList == null) {
            commandList = this.routeManager.getStartGuidanceByRouteSequence(route);
        } else {
            commandList.add(this.routeManager.getStartGuidanceByRouteSequence(route));
        }
        commandList.execute("StartRouteGuidanceDependentHMIListener#startGuidance(Route, boolean)");
    }

    private void startGuidance(NavSegmentID navSegmentID, boolean bl) {
        CommandList commandList = null;
        if (bl) {
            commandList = this.demoModeManager.getCommandListToTurnDemoMode(false);
        }
        if (commandList == null) {
            commandList = this.routeManager.getStartGuidanceBySegmendIDSequence(navSegmentID, true);
        } else {
            commandList.add(this.routeManager.getStartGuidanceBySegmendIDSequence(navSegmentID, true));
        }
        commandList.execute("StartRouteGuidanceDependentHMIListener#startGuidanceToRoute(NavSegmentID, boolean)");
    }

    @Override
    public CommandList createAddSelectedDestinationAtIndexCommandList(int n, boolean bl) {
        this.mode = 5;
        this.destinationIndex = n;
        this.replace = bl;
        if (this.env.getContainer().isEtcDemoMode()) {
            return null;
        }
        boolean bl2 = this.alternativeRouteStateManager.getAlternativeRouteState() == 0;
        NavLocation navLocation = this.destinationHandler.getLocation();
        this.mapInterface.prepareStartRouteCalculation(bl2, navLocation);
        return this.routeManager.getStartGuidance(this.destinationHandler.getLocation(), n, bl, false);
    }

    @Override
    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList) {
        this.env.getLogChannel().log(-1601830656, "StartRouteGuidanceDependentHMIListener#addAsStopOver --> NOT IMPLEMENTED");
    }

    @Override
    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, CommandList commandList) {
        this.env.getLogChannel().log(-1601830656, "StartRouteGuidanceDependentHMIListener#addAsStopOver --> NOT IMPLEMENTED");
    }
}

