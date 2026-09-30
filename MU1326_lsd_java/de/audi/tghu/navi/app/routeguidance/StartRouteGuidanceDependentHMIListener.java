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
    public static final int SINGLE_DEST_MODE = 1;
    public static final int STOP_OVER_MODE = 2;
    public static final int REPLACE_STOP_OVER_MODE = 3;
    public static final int REPLACE_ALL_DEST = 4;
    public static final int INDEX_MODE = 5;
    private IAlternativeRouteStateManager alternativeRouteStateManager;
    private MapInterface mapInterface;
    private IPoiService poiService;
    private final CombiBAPListener combiBAPListener;
    private static final int STOP_OVER_INDEX = 0;
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
        this.env.getButtonModel(401293).setButtonListener(null);
        this.env.getButtonModel(401245).setButtonListener(null);
        this.env.getButtonModel(401295).setButtonListener(null);
        this.env.getButtonModel(401294).setButtonListener(null);
        this.env.getButtonModel(401002).setButtonListener(null);
        this.env.getButtonModel(401003).setButtonListener(null);
        this.env = null;
        this.destinationHandler = null;
        this.mapInterface = null;
        this.routeManager = null;
        this.demoModeManager = null;
    }

    private void initListeners() {
        this.env.getButtonModel(401293).setButtonListener(this);
        this.env.getButtonModel(401245).setButtonListener(this);
        this.env.getButtonModel(401295).setButtonListener(this);
        this.env.getButtonModel(401294).setButtonListener(this);
        this.env.getButtonModel(401002).setButtonListener(this);
        this.env.getButtonModel(401003).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped. modelId: %1, keyId: %2", (long)n, (long)n2);
        if (this.poiService != null) {
            this.poiService.setRouteGuidanceStartedByUser(true);
        } else {
            this.env.getPOILogChannel().log(100000, "StartRouteGuidanceDependentHMIListener#keyTyped - poiService is null!");
        }
        if (n == 401002) {
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
                this.env.getLogChannel().log(10000000, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped unknown DestinationType %1", (long)this.destinationHandler.getDestinationType());
            }
        } else if (n == 401003) {
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
                this.env.getLogChannel().log(10000000, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped unknown DestinationType %1", (long)this.destinationHandler.getDestinationType());
            }
        } else {
            if (n == 401293) {
                this.mode = 1;
            } else if (n == 401245) {
                this.mode = 2;
            } else if (n == 401295) {
                this.mode = 3;
            } else if (n == 401294) {
                this.mode = 1;
            } else {
                this.env.getLogChannel().log(100000, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped() - unsupported modelID: %1", (long)n);
                return;
            }
            if (!this.env.getContainer().isEtcDemoMode()) {
                this.startGuidance(this.mode, false);
            }
        }
        this.combiBAPListener.popupButtonPressed();
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartRouteGuidanceDependentHMIListener#keyTyped. modelId: %1, keyId: %2 - fire model event", (long)n, (long)n2);
        this.env.fireModelEvent(n, n3);
    }

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
        this.env.getLogChannel().log(100000, "StartRouteGuidanceDependentHMIListener#startGuidance #### Starting Route Guidance in mode = %1, Demomode will be turned to = %2", (Object)(n + ""), (Object)(bl + ""));
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
                this.env.getLogChannel().log(100000, "StartRouteGuidanceDependentHMIListener#startGuidance- unknown mode: %1", (long)n);
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

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList) {
        this.env.getLogChannel().log(100000, "StartRouteGuidanceDependentHMIListener#addAsStopOver --> NOT IMPLEMENTED");
    }

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, CommandList commandList) {
        this.env.getLogChannel().log(100000, "StartRouteGuidanceDependentHMIListener#addAsStopOver --> NOT IMPLEMENTED");
    }
}

