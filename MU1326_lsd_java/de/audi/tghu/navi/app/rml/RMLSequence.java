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
import de.audi.tghu.navi.app.rml.RequestCombinedRouteListCommand;
import de.audi.tghu.navi.app.rml.RequestNavRectangleForCombinedRouteListElement;
import de.audi.tghu.navi.app.rml.RequestRMLPOIInformationCommand;
import de.audi.tghu.navi.app.rml.UpdateCombinedRouteListCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLSequence
implements IRMLSequence {
    private static final int MAXIMUM_REPEAT_REQUEST = 10;
    private static final int HIDE_LOADING_ICON = 0;
    private static final int SHOW_LOADING_ICON = 1;
    public static final int DEFAULT_OFFSET = 10;
    public static final int DEFAULT_WINDOW_SIZE = 21;
    public static final long[] DEFAULT_ANCHOR_ID = new long[]{-1L};
    public static final int NO_PENDING_REQUEST_ID = -1;
    public static final int START_INDEX_ZERO = 0;
    protected static final Object OPENEDANCHOR = "OPENED ANCHOR";
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

    public synchronized void start() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.isRoutelistActive) {
            return;
        }
        commandList.addMonitor(this.ledMonitor);
        this.isRoutelistActive = true;
        this.modelAccess.onStart();
        commandList.add(new NavCommand("Check RG-Active"){

            public void execute() {
                boolean bl = this.dsiResponseContainer.isRgActive();
                this.logger.log(10000000, "RMLSequence#start()#execute() - %1 ", bl);
                if (!bl) {
                    this.getCommandList().commandAborted("RouteGuidance is not active");
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new RequestCombinedRouteListCommand(21, 10, DEFAULT_ANCHOR_ID, -1L, 10));
        commandList.add(new UpdateCombinedRouteListCommand(this.modelAccess, -1, -1L, this.routeManager.getRoute()));
        commandList.setErrorCommand(new NavCommand("RMLSequence#start --> ERRORCommand reset isRouteListActive"){

            public void execute() {
                this.logger.log(10000000, "%1#execute() - isRouteListActive will be set to false because there appeared an error in the running CommandList RMLSequence#start", (Object)this.CLASS_NAME);
                RMLSequence.this.isRoutelistActive = false;
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#start");
    }

    public synchronized boolean isRoutelistActive() {
        return this.isRoutelistActive;
    }

    public Monitor getRunningRequestMonitor() {
        return this.ledMonitor;
    }

    public synchronized void requestCombinedRouteList(final long[] lArray, final long l, final int n, int n2, boolean bl) {
        this.logChannel.log(10000000, "RMLSequence#requestCombinedRouteList() - anchorIds = %1 \n openedListAnchorID = %2 \n requestID = %3, startIndex = %4 ", (Object)lArray, (Object)Long.toString(l), (Object)Integer.toString(n), (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.ledMonitor);
        if (this.ledMonitor.isActive()) {
            this.logChannel.log(1000000, "RMLSequence#requestCombinedRouteList() - Detected a running CommandList in the RMLSequence figure out if its from user or widget");
            if (n == -1) {
                this.logChannel.log(1000000, "RMLSequence#requestCombinedRouteList() - Detected user event with a already running request --> ignore userupdate");
                return;
            }
        }
        if (bl) {
            this.setWaitingIcon(1);
            commandList.add(this.createWaitingIconCommand(1));
        }
        commandList.add(new NavCommand("RMLSequence#requestCombinedRouteList - get the latest opened element"){

            public void execute() {
                CombinedRouteListElement combinedRouteListElement;
                IRMLListener iRMLListener = RMLSequence.this.getRMLListener();
                if (iRMLListener != null && (combinedRouteListElement = iRMLListener.getOpenedElement()) != null) {
                    this.getCommandList().put(OPENEDANCHOR, new Long(combinedRouteListElement.getUid()));
                    this.getCommandList().commandFinishedWithPostCommand(new RequestCombinedRouteListCommand(21, 10, lArray, combinedRouteListElement.getUid(), 10));
                    return;
                }
                this.getCommandList().put(OPENEDANCHOR, new Long(l));
                this.getCommandList().commandFinishedWithPostCommand(new RequestCombinedRouteListCommand(21, 10, lArray, l, 10));
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                long l = (Long)this.getCommandList().get(OPENEDANCHOR);
                this.getCommandList().commandFinishedWithPostCommand(new UpdateCombinedRouteListCommand(RMLSequence.this.modelAccess, n, l, RMLSequence.this.routeManager.getRoute()));
            }
        });
        if (bl) {
            commandList.add(this.createWaitingIconCommand(0));
        }
        commandList.execute("RMLSequence#requestCombinedRouteList");
    }

    private NavCommand createWaitingIconCommand(final int n) {
        return new NavCommand(new StringBuffer().append("RMLSequence#requestCombinedRouteList - set value = ").append(n).append(" for waiting icon").toString()){

            public void execute() {
                RMLSequence.this.setWaitingIcon(n);
                this.getCommandList().commandFinished();
            }
        };
    }

    private void setWaitingIcon(int n) {
        this.env.getChoiceModel(401639).setValue(n);
    }

    public void stop() {
        this.isRoutelistActive = false;
        this.ledMonitor.stopMonitoredLists("RMLSequence#stop - RML was stopped");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("RMLSequence#stop - modelAccess stop"){

            public void execute() {
                RMLSequence.this.modelAccess.onStop();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new RequestCombinedRouteListCommand(0, 0, new long[]{-1L}, -1L));
        commandList.execute("RMLSequence#stop");
    }

    public void windowChanged(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.ledMonitor);
        if (bl) {
            commandList.add(new NavCommand("RMLSequence#windowChanged - modelAccess.onStart()"){

                public void execute() {
                    RMLSequence.this.modelAccess.onStart();
                    this.getCommandList().commandFinished();
                }
            });
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

    public void updateElementsTotal(final long l) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.addMonitor(this.ledMonitor);
        commandList.add(new NavCommand("RMLSequence#updateElementsTotal - update Model listlength"){

            public void execute() {
                RMLSequence.this.modelAccess.onUpdateListLength(l);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#updateElementsTotal");
    }

    public void selectForCountryInfo(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new NavCommand(){

            public void execute() {
                RMLSequence.this.countryHandler.startCountryInput(true);
                RMLSequence.this.countryHandler.setCountry(this.dsiResponseContainer.getRMLPOILocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                RMLSequence.this.modelAccess.onCountryInfoSelected();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#selectForCountryInfo");
    }

    public void selectForTrafficDetails(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                RMLSequence.this.modelAccess.onTrafficInfoSelected();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#selectForTrafficDetails");
    }

    public void selectForAddressDetails(final CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Set ModelAccess for FollowUp"){

            public void execute() {
                RMLSequence.this.modelAccess.onDetailsSelected();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Set NavLocation for Popup"){

            public void execute() {
                NavLocation navLocation = RMLSequence.this.routeManager.getRoute().getRoutelist()[combinedRouteListElement.getDestinationIndex()].getRouteLocation();
                RMLSequence.this.poiDetailModelAccess.onUpdateLocation(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#selectForAddressDetails");
    }

    public void selectForPOIDetails(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new NavCommand("Set ModelAccess for FollowUp"){

            public void execute() {
                RMLSequence.this.modelAccess.onDetailsSelected();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("Set NavLocation for Popup"){

            public void execute() {
                RMLSequence.this.poiDetailModelAccess.onUpdateLocation(this.dsiResponseContainer.getRMLPOILocation());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#selectForPOIDetails");
    }

    public void selectNoDetails() {
        this.modelAccess.onNoDetailsSelected();
    }

    public void focusPOI(final CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestRMLPOIInformationCommand(combinedRouteListElement));
        commandList.add(new NavCommand("RMLSequence#focusPOI#modelAccess#onPOIFocus"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getRMLPOILocation();
                this.logger.log(10000000, "RMLSequence#focusPOI rmlpoiLocation = %1", (Object)navLocation);
                RMLSequence.this.modelAccess.onPoiFocused(navLocation, combinedRouteListElement);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#focusPOI");
    }

    public void focusTMC(CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestNavRectangleForCombinedRouteListElement(combinedRouteListElement));
        commandList.add(new NavCommand("Forward NavRectangle to variant specific model access"){

            public void execute() {
                NavRectangle navRectangle = (NavRectangle)this.getCommandList().get(RequestNavRectangleForCombinedRouteListElement.NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE);
                this.navigation.getMapInterface().getPreviewMap().setPreviewTrafficInfoTmcEventsForRouteList(navRectangle, 13, null, null);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#focusTMC");
    }

    public void itemFocused(final CombinedRouteListElement combinedRouteListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RequestNavRectangleForCombinedRouteListElement(combinedRouteListElement));
        commandList.add(new NavCommand("Forward NavRectangle to variant specific model access"){

            public void execute() {
                NavRectangle navRectangle = (NavRectangle)this.getCommandList().get(RequestNavRectangleForCombinedRouteListElement.NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE);
                RMLSequence.this.modelAccess.onElementFocused(navRectangle, combinedRouteListElement);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RMLSequence#itemFocused");
    }

    private IRMLListener getRMLListener() {
        return this.rmlListener;
    }

    public void setRMLListener(IRMLListener iRMLListener) {
        this.rmlListener = iRMLListener;
    }
}

