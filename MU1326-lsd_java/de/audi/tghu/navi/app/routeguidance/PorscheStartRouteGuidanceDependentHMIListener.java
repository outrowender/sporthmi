/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStopOverObserver;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$1;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$2;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener;
import org.dsi.ifc.global.NavLocation;

public class PorscheStartRouteGuidanceDependentHMIListener
implements AddSelectedDestinationAtIndexCommandListCreator {
    private static final int MAX_STOPOVERS;
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
        this.addAsStopOverInputCompleted = navigationEnv.getButtonModel(337380864);
        this.initListeners();
    }

    private void initListeners() {
        PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener porscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener = new PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener(this, null);
        this.addAsStopOverInputCompleted.setButtonListener(porscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener);
    }

    public void setObserver(IStopOverObserver iStopOverObserver) {
        this.observer = iStopOverObserver;
    }

    @Override
    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList) {
        this.addAsStopOver(navLocation, n, bl, bl2, commandList, false);
    }

    @Override
    public CommandList createAddSelectedDestinationAtIndexCommandList(int n, boolean bl) {
        if (this.env.getContainer().isEtcDemoMode()) {
            return null;
        }
        return this.routeManager.getStartGuidance(this.destinationHandler.getLocation(), n, bl, false);
    }

    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList, boolean bl3) {
        CommandList commandList2 = this.commandListFactory.createCommandList();
        commandList2.add(this.routeManager.getInsertAsStopOverCommandList(navLocation, n, bl, bl2));
        if (this.observer != null) {
            commandList2.add(new PorscheStartRouteGuidanceDependentHMIListener$1(this, "PorscheStartRouteGuidanceDependentHMIListener#addAsStopOver: inform observer about last added index"));
        }
        if (commandList != null) {
            commandList2.add(commandList);
        }
        CommandList commandList3 = this.commandListFactory.createCommandList(1);
        commandList3.add(new PorscheStartRouteGuidanceDependentHMIListener$2(this, "PorscheStartRouteGuidanceDependentHMIListener#addAsStopOver: check  number of stopover", bl3, bl2, commandList2));
        commandList3.execute("PorscheStartRouteGuidanceDependentHMIListener.addAsStopOver()");
    }

    @Override
    public void addAsStopOver(NavLocation navLocation, int n, boolean bl, CommandList commandList) {
        this.addAsStopOver(navLocation, n, bl, false, commandList);
    }

    static /* synthetic */ ButtonModelApp access$100(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        return porscheStartRouteGuidanceDependentHMIListener.addAsStopOverInputCompleted;
    }

    static /* synthetic */ ICommandListFactory access$200(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        return porscheStartRouteGuidanceDependentHMIListener.commandListFactory;
    }

    static /* synthetic */ IStopOverObserver access$300(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        return porscheStartRouteGuidanceDependentHMIListener.observer;
    }

    static /* synthetic */ IRouteManager access$400(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        return porscheStartRouteGuidanceDependentHMIListener.routeManager;
    }

    static /* synthetic */ int access$500(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        return porscheStartRouteGuidanceDependentHMIListener.partialPopupID;
    }
}

