/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStopOverObserver;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public class PorscheStartRouteGuidanceDependentHMIListener
implements AddSelectedDestinationAtIndexCommandListCreator {
    private static final int MAX_STOPOVERS = 9;
    protected NavigationEnv env;
    private ButtonModelApp addAsStopOverInputCompleted;
    private IRouteManager routeManager;
    private ICommandListFactory commandListFactory;
    private IStopOverObserver observer;
    private DetailsDestionationHandler destinationHandler;
    private int partialPopupID;

    public PorscheStartRouteGuidanceDependentHMIListener(NavigationEnv navigationEnv, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory, int n) {
        this.env = navigationEnv;
        this.routeManager = iRouteManager;
        this.commandListFactory = iCommandListFactory;
        this.partialPopupID = n;
        this.destinationHandler = new DetailsDestionationHandler();
        this.addAsStopOverInputCompleted = navigationEnv.getButtonModel(400404);
        this.initListeners();
    }

    private void initListeners() {
        StartRouteGuidanceDependentButtonListener startRouteGuidanceDependentButtonListener = new StartRouteGuidanceDependentButtonListener();
        this.addAsStopOverInputCompleted.setButtonListener(startRouteGuidanceDependentButtonListener);
    }

    public void setObserver(IStopOverObserver iStopOverObserver) {
        this.observer = iStopOverObserver;
    }

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList) {
        this.addAsStopOver(navLocation, n, bl, bl2, commandList, false);
    }

    public CommandList createAddSelectedDestinationAtIndexCommandList(int n, boolean bl) {
        if (this.env.getContainer().isEtcDemoMode()) {
            return null;
        }
        return this.routeManager.getStartGuidance(this.destinationHandler.getLocation(), n, bl, false);
    }

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, final boolean bl2, CommandList commandList, final boolean bl3) {
        final CommandList commandList2 = this.commandListFactory.createCommandList();
        commandList2.add(this.routeManager.getInsertAsStopOverCommandList(navLocation, n, bl, bl2));
        if (this.observer != null) {
            commandList2.add(new NavCommand("PorscheStartRouteGuidanceDependentHMIListener#addAsStopOver: inform observer about last added index"){

                public void execute() {
                    Integer n = (Integer)this.getCommandList().get(StartRouteGuidanceSequences.TRANSFORMED_INSERT_POS);
                    PorscheStartRouteGuidanceDependentHMIListener.this.observer.setLastAddedIndex(n);
                    this.getCommandList().commandFinished();
                }
            });
        }
        if (commandList != null) {
            commandList2.add(commandList);
        }
        CommandList commandList3 = this.commandListFactory.createCommandList(1);
        commandList3.add(new NavCommand("PorscheStartRouteGuidanceDependentHMIListener#addAsStopOver: check  number of stopover"){

            public void execute() {
                int n;
                Route route = PorscheStartRouteGuidanceDependentHMIListener.this.routeManager.getRoute();
                int n2 = n = bl3 ? 1 : 0;
                if (bl2 || RouteUtil.getRouteLength(route) < 9 + n) {
                    this.getCommandList().commandFinishedWithPostSequence(commandList2);
                } else {
                    if (PorscheStartRouteGuidanceDependentHMIListener.this.partialPopupID != 0) {
                        this.env.getLogChannel().log(10000000, "PorscheStartRouteGuidanceDependentHMIListener.addAsStopOver - maximum number of stopovers reached - showPopup = %1", (long)PorscheStartRouteGuidanceDependentHMIListener.this.partialPopupID);
                        this.env.getHMIService().showPartialPopup(0, PorscheStartRouteGuidanceDependentHMIListener.this.partialPopupID);
                    }
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList3.execute("PorscheStartRouteGuidanceDependentHMIListener.addAsStopOver()");
    }

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, CommandList commandList) {
        this.addAsStopOver(navLocation, n, bl, false, commandList);
    }

    private class StartRouteGuidanceDependentButtonListener
    extends DefaultButtonListener {
        private StartRouteGuidanceDependentButtonListener() {
        }

        public void keyTyped(final int n, int n2, final int n3) {
            if (n == PorscheStartRouteGuidanceDependentHMIListener.this.addAsStopOverInputCompleted.getID()) {
                CommandList commandList = PorscheStartRouteGuidanceDependentHMIListener.this.commandListFactory.createCommandList();
                commandList.add(new NavCommand(){

                    public void execute() {
                        this.env.fireModelEvent(n, n3);
                        this.getCommandList().commandFinished();
                    }
                });
                PorscheStartRouteGuidanceDependentHMIListener.this.addAsStopOver(PorscheStartRouteGuidanceDependentHMIListener.this.env.getContainer().getLiCurrentLD(), -1, true, false, commandList);
            }
        }
    }
}

