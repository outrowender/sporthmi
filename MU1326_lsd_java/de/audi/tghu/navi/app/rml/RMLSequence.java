/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.rml.IRMLListener;
import de.audi.tghu.navi.app.rml.IRMLModelAccess;
import de.audi.tghu.navi.app.rml.IRMLSequence;
import de.audi.tghu.navi.app.rml.RMLSequence$1;
import de.audi.tghu.navi.app.rml.RMLSequence$10;
import de.audi.tghu.navi.app.rml.RMLSequence$11;
import de.audi.tghu.navi.app.rml.RMLSequence$12;
import de.audi.tghu.navi.app.rml.RMLSequence$13;
import de.audi.tghu.navi.app.rml.RMLSequence$14;
import de.audi.tghu.navi.app.rml.RMLSequence$15;
import de.audi.tghu.navi.app.rml.RMLSequence$16;
import de.audi.tghu.navi.app.rml.RMLSequence$17;
import de.audi.tghu.navi.app.rml.RMLSequence$18;
import de.audi.tghu.navi.app.rml.RMLSequence$2;
import de.audi.tghu.navi.app.rml.RMLSequence$3;
import de.audi.tghu.navi.app.rml.RMLSequence$4;
import de.audi.tghu.navi.app.rml.RMLSequence$5;
import de.audi.tghu.navi.app.rml.RMLSequence$6;
import de.audi.tghu.navi.app.rml.RMLSequence$7;
import de.audi.tghu.navi.app.rml.RMLSequence$8;
import de.audi.tghu.navi.app.rml.RMLSequence$9;
import de.audi.tghu.navi.app.rml.RequestCombinedRouteListCommand;
import de.audi.tghu.navi.app.rml.RequestNavRectangleForCombinedRouteListElement;
import de.audi.tghu.navi.app.rml.RequestRMLPOIInformationCommand;
import de.audi.tghu.navi.app.rml.UpdateCombinedRouteListCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLSequence
implements IRMLSequence {
    private static final int MAXIMUM_REPEAT_REQUEST;
    private static final int HIDE_LOADING_ICON;
    private static final int SHOW_LOADING_ICON;
    public static final int DEFAULT_OFFSET;
    public static final int DEFAULT_WINDOW_SIZE;
    public static final long[] DEFAULT_ANCHOR_ID;
    public static final int NO_PENDING_REQUEST_ID;
    public static final int START_INDEX_ZERO;
    protected static final Object OPENEDANCHOR;
    protected final IRMLModelAccess modelAccess;
    private final ICommandListFactory commandListFactory;
    private final IRouteManager routeManager;
    private final GuiModelAccessDetailsNavi poiDetailModelAccess;
    private final ICountryInfoHandler countryHandler;
    private volatile boolean isRoutelistActive = false;
    private final LogChannel logChannel;
    private Monitor ledMonitor;
    private IRMLListener rmlListener;
    protected final NavigationEnv env;

    public RMLSequence(IRMLModelAccess iRMLModelAccess, ICommandListFactory iCommandListFactory, IRouteManager iRouteManager, ICountryInfoHandler iCountryInfoHandler, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavigationEnv navigationEnv) {
        this.poiDetailModelAccess = guiModelAccessDetailsNavi;
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iRMLModelAccess;
        this.routeManager = iRouteManager;
        this.countryHandler = iCountryInfoHandler;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getRMLLogChannel();
        this.ledMonitor = new Monitor(this.logChannel);
    }

    @Override
    public synchronized void start() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.isRoutelistActive) {
            return;
        }
        commandList.addMonitor(this.ledMonitor);
        this.isRoutelistActive = true;
        this.modelAccess.onStart();
        commandList.add(new RMLSequence$1(this, "Check RG-Active"));
        commandList.add(new RequestCombinedRouteListCommand(21, 10, DEFAULT_ANCHOR_ID, -1L, 10));
        commandList.add(new UpdateCombinedRouteListCommand(this.modelAccess, -1, -1L, this.routeManager.getRoute()));
        commandList.setErrorCommand(new RMLSequence$2(this, "RMLSequence#start --> ERRORCommand reset isRouteListActive"));
        commandList.execute("RMLSequence#start");
    }

    public synchronized boolean isRoutelistActive() {
        return this.isRoutelistActive;
    }

    public Monitor getRunningRequestMonitor() {
        return this.ledMonitor;
    }

    @Override
    public synchronized void requestCombinedRouteList(long[] lArray, long l, int n, int n2, boolean bl) {
        this.logChannel.log(-2137614336, "RMLSequence#requestCombinedRouteList() - anchorIds = %1 \n openedListAnchorID = %2 \n requestID = %3, startIndex = %4 ", (Object)lArray, (Object)Long.toString(l), (Object)Integer.toString(n), (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.ledMonitor);
        if (this.ledMonitor.isActive()) {
            this.logChannel.log(1078071040, "RMLSequence#requestCombinedRouteList() - Detected a running CommandList in the RMLSequence figure out if its from user or widget");
            if (n == -1) {
                this.logChannel.log(1078071040, "RMLSequence#requestCombinedRouteList() - Detected user event with a already running request --> ignore userupdate");
                return;
            }
        }
        if (bl) {
            this.setWaitingIcon(1);
            commandList.add(this.createWaitingIconCommand(1));
        }
        commandList.add(new RMLSequence$3(this, "RMLSequence#requestCombinedRouteList - get the latest opened element", lArray, l));
        commandList.add(new RMLSequence$4(this, n));
        if (bl) {
            commandList.add(this.createWaitingIconCommand(0));
        }
        commandList.execute("RMLSequence#requestCombinedRouteList");
    }

    private NavCommand createWaitingIconCommand(int n) {
        return new RMLSequence$5(this, new StringBuffer().append("RMLSequence#requestCombinedRouteList - set value = ").append(n).append(" for waiting icon").toString(), n);
    }

    private void setWaitingIcon(int n) {
        this.env.getChoiceModel(-417331712).setValue(n);
    }

    @Override
    public void stop() {
        this.isRoutelistActive = false;
        this.ledMonitor.stopMonitoredLists("RMLSequence#stop - RML was stopped");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RMLSequence$6(this, "RMLSequence#stop - modelAccess stop"));
        commandList.add(new RequestCombinedRouteListCommand(0, 0, new long[]{-1L}, -1L));
        commandList.execute("RMLSequence#stop");
    }

    public void windowChanged(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.ledMonitor);
        if (bl) {
            commandList.add(new RMLSequence$7(this, "RMLSequence#windowChanged - modelAccess.onStart()"));
        }
        commandList.add(new RequestCombinedRouteListCommand(21, 10, DEFAULT_ANCHOR_ID, -1L, 10));
        commandList.add(new UpdateCombinedRouteListCommand(this.modelAccess, -1, -1L, this.routeManager.getRoute()));
        commandList.execute("RMLSequence#windowChanged");
    }

    public void updateInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        if (this.isRoutelistActive) {
            this.modelAccess.updateInfoForNextDestination(rgInfoForNextDestination);
        }
    }

    public void updateElementsTotal(long l) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.addMonitor(this.ledMonitor);
        commandList.add(new RMLSequence$8(this, "RMLSequence#updateElementsTotal - update Model listlength", l));
        commandList.execute("RMLSequence#updateElementsTotal");
    }

    public void selectForCountryInfo(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new RMLSequence$9(this));
        commandList.add(new RMLSequence$10(this));
        commandList.execute("RMLSequence#selectForCountryInfo");
    }

    public void selectForTrafficDetails(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RMLSequence$11(this));
        commandList.execute("RMLSequence#selectForTrafficDetails");
    }

    public void selectForAddressDetails(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RMLSequence$12(this, "Set ModelAccess for FollowUp"));
        commandList.add(new RMLSequence$13(this, "Set NavLocation for Popup", combinedRouteListElement));
        commandList.execute("RMLSequence#selectForAddressDetails");
    }

    public void selectForPOIDetails(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new RMLSequence$14(this, "Set ModelAccess for FollowUp"));
        commandList.add(new RMLSequence$15(this, "Set NavLocation for Popup"));
        commandList.execute("RMLSequence#selectForPOIDetails");
    }

    public void selectNoDetails() {
        this.modelAccess.onNoDetailsSelected();
    }

    public void focusPOI(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new RMLSequence$16(this, "RMLSequence#focusPOI#modelAccess#onPOIFocus", combinedRouteListElement));
        commandList.execute("RMLSequence#focusPOI");
    }

    public void focusTMC(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestNavRectangleForCombinedRouteListElement(combinedRouteListElement));
        commandList.add(new RMLSequence$17(this, "Forward NavRectangle to variant specific model access"));
        commandList.execute("RMLSequence#focusTMC");
    }

    public void itemFocused(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestNavRectangleForCombinedRouteListElement(combinedRouteListElement));
        commandList.add(new RMLSequence$18(this, "Forward NavRectangle to variant specific model access", combinedRouteListElement));
        commandList.execute("RMLSequence#itemFocused");
    }

    private IRMLListener getRMLListener() {
        return this.rmlListener;
    }

    public void setRMLListener(IRMLListener iRMLListener) {
        this.rmlListener = iRMLListener;
    }

    static /* synthetic */ boolean access$002(RMLSequence rMLSequence, boolean bl) {
        rMLSequence.isRoutelistActive = bl;
        return rMLSequence.isRoutelistActive;
    }

    static /* synthetic */ IRMLListener access$100(RMLSequence rMLSequence) {
        return rMLSequence.getRMLListener();
    }

    static /* synthetic */ IRouteManager access$200(RMLSequence rMLSequence) {
        return rMLSequence.routeManager;
    }

    static /* synthetic */ void access$300(RMLSequence rMLSequence, int n) {
        rMLSequence.setWaitingIcon(n);
    }

    static /* synthetic */ ICountryInfoHandler access$400(RMLSequence rMLSequence) {
        return rMLSequence.countryHandler;
    }

    static /* synthetic */ GuiModelAccessDetailsNavi access$500(RMLSequence rMLSequence) {
        return rMLSequence.poiDetailModelAccess;
    }

    static {
        DEFAULT_ANCHOR_ID = new long[]{-1L};
        OPENEDANCHOR = "OPENED ANCHOR";
    }
}

