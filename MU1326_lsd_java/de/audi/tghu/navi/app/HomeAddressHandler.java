/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;

public class HomeAddressHandler
implements ButtonListener {
    protected static final int HOME_ADDRESS_AVAILABLE = 1;
    protected static final int HOME_ADDRESS_NOT_AVAILABLE = 0;
    protected LogChannel logger;
    private LocalPersistNavLocationHelper localPersistNavLocationHelper;
    private LocationSerializer locationSerializer;
    protected NavLocation currentHomeAddress;
    protected IStartGuidanceToDestinationSequence startGuidanceDependentSequence;
    private final INavigationInputModeManager inputModeManager;
    protected final ICommandListFactory commandListFactory;
    protected MapInterface mapInterface;
    protected final ButtonModelApp homeAddressModel;
    protected final ButtonModelApp deleteHomeAddressModel;
    protected final ChoiceModelApp homeAddressAvailableModel;
    private boolean homeButtonDeserialized = false;
    private final DispatcherBase dispatcher;
    protected final NavigationEnv env;

    public HomeAddressHandler(NavigationEnv navigationEnv, LocationSerializer locationSerializer, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, MapInterface mapInterface, LogChannel logChannel, DispatcherBase dispatcherBase, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ChoiceModelApp choiceModelApp, int n) {
        this.startGuidanceDependentSequence = iStartGuidanceToDestinationSequence;
        this.commandListFactory = iCommandListFactory;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.logger = logChannel;
        this.locationSerializer = locationSerializer;
        this.localPersistNavLocationHelper = new LocalPersistNavLocationHelper(navigationEnv, n);
        this.mapInterface = mapInterface;
        this.dispatcher = dispatcherBase;
        this.homeAddressModel = buttonModelApp;
        this.deleteHomeAddressModel = buttonModelApp2;
        this.homeAddressAvailableModel = choiceModelApp;
        this.env = navigationEnv;
        this.registerListeners();
    }

    public HomeAddressHandler(NavigationEnv navigationEnv, LocationSerializer locationSerializer, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, MapInterface mapInterface, LogChannel logChannel, DispatcherBase dispatcherBase) {
        this(navigationEnv, locationSerializer, iStartGuidanceToDestinationSequence, iCommandListFactory, mapInterface, logChannel, dispatcherBase, navigationEnv.getButtonModel(400356), navigationEnv.getButtonModel(401007), navigationEnv.getChoiceModel(400357), 940);
    }

    protected final void registerListeners() {
        this.homeAddressModel.setButtonListener(this);
        this.deleteHomeAddressModel.setButtonListener(this);
    }

    public void initHomeButtonState() {
        if (!this.homeButtonDeserialized) {
            this.logger.log(1000000, "HomeAddressHandler#initHomeButtonState()");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NavCommand("DeserializeHomeAddressCommand"){

                public void execute() {
                    byte[] byArray = HomeAddressHandler.this.localPersistNavLocationHelper.loadPersistentState();
                    if (byArray == null || byArray.length == 0) {
                        this.logger.log(10000000, "DeserializeHomeAddress#getPersistetHomeAddress() %1", (Object)byArray);
                        this.getCommandList().commandFinished();
                    } else {
                        this.getCommandList().commandFinishedWithPostCommand(new StreamToLocationCommand(byArray));
                    }
                }
            });
            commandList.add(new NavCommand("SaveDeserializedHomeAddressCommand"){

                public void execute() {
                    NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                    if (navLocation != null && navLocation.isPositionValid()) {
                        HomeAddressHandler.this.currentHomeAddress = navLocation;
                        HomeAddressHandler.this.updateHomeAddressAvailable();
                    }
                    HomeAddressHandler.this.homeButtonDeserialized = true;
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("HomeAddressHandler#DeserializeHomeAddressCommandList");
        }
    }

    public void onHomeButtonPressed(int n) {
        this.logger.log(1000000, "HomeAddressHandler#onHomeButtonPressed(), %1", (Object)LocationFormatter.formatLocationShort(this.currentHomeAddress));
        if (this.isHomeAddressAvailable() && this.currentHomeAddress != null) {
            this.startGuidanceDependentSequence.start(this.currentHomeAddress);
        }
    }

    public void onCreateEditHomeAddress(NavLocation navLocation) {
        this.logger.log(1000000, "HomeAddressHandler#onCreateEditHomeAddress() - newHomeAddress: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation == null || !navLocation.isPositionValid()) {
            this.logger.log(10000, "HomeAddressHandler#onCreateEditHomeAddress() - newHomeAddress is null! Don't change current Home address");
            return;
        }
        this.currentHomeAddress = navLocation;
        this.setPersistetHomeAddress(navLocation);
        this.updateHomeAddressAvailable();
    }

    public void onPrepareCreateEditHomeAddress() {
        this.logger.log(1000000, "HomeAddressHandler#onPrepareCreateEditHomeAddress()");
        this.inputModeManager.setInputMode(2, this.env);
    }

    public void onDeleteHomeAddress() {
        this.logger.log(1000000, "HomeAddressHandler#onDeleteHomeAddress()");
        this.currentHomeAddress = null;
        this.setPersistetHomeAddress(null);
        this.updateHomeAddressAvailable();
    }

    public void keyPressed(final int n, int n2, final int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("HomeButtonPressed"){

            public void execute() {
                if (n == HomeAddressHandler.this.homeAddressModel.getID()) {
                    this.logger.log(1000000, "HomeAddressHandler#keyPressed( %1 ) - NAV_FAVORITES_HOME_BUTTON", (long)n);
                    HomeAddressHandler.this.onHomeButtonPressed(n3);
                    HomeAddressHandler.this.homeAddressModel.fireEvent(n3);
                } else if (n == HomeAddressHandler.this.deleteHomeAddressModel.getID()) {
                    this.logger.log(1000000, "HomeAddressHandler#keyPressed( %1 ) - NAV_FAVORITES_DELETE_HOME_BUTTON", (long)n);
                    HomeAddressHandler.this.onDeleteHomeAddress();
                    HomeAddressHandler.this.deleteHomeAddressModel.fireEvent(n3);
                } else {
                    this.logger.log(1000000, "HomeAddressHandler#keyPressed( %1 ) - unknown modelID", (long)n);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("HomeAddressHandler#keyPressed");
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void setPersistetHomeAddress(final NavLocation navLocation) {
        Runnable runnable = new Runnable(){

            public void run() {
                HomeAddressHandler.this.logger.log(10000000, "HomeAddressHandler#setPersistetHomeAddress() - homeAddress: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                byte[] byArray = navLocation != null ? HomeAddressHandler.this.locationSerializer.locationToStream(navLocation) : new byte[]{};
                HomeAddressHandler.this.localPersistNavLocationHelper.savePersistentState(byArray);
            }
        };
        if (this.dispatcher != null) {
            this.dispatcher.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public boolean isHomeAddressAvailable() {
        return this.homeAddressAvailableModel.getValue() == 1;
    }

    protected void updateHomeAddressAvailable() {
        this.homeAddressAvailableModel.setValue(this.currentHomeAddress != null && this.currentHomeAddress.positionValid ? 1 : 0);
        this.updateMapAddress();
        this.handleHomeAddressFocus();
    }

    protected void updateMapAddress() {
        this.mapInterface.setHomeAddress(this.getCurrentHomeAddress());
    }

    public NavLocation getCurrentHomeAddress() {
        return this.currentHomeAddress;
    }

    public void handleHomeAddressFocus() {
        this.handleHomeAddressFocus(null);
    }

    public void handleHomeAddressFocus(final GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen) {
        CommandList commandList;
        block8: {
            this.logger.log(10000000, "HomeAddressHandler#handleHomeAddressFocus()");
            if (this.mapInterface == null) {
                return;
            }
            commandList = this.commandListFactory.createCommandList();
            final NavLocation navLocation = this.getCurrentHomeAddress();
            if (navLocation == null || !navLocation.isPositionValid()) {
                try {
                    if (this.env.getFramework().isAsia()) {
                        commandList.add(new NavCommand("HomeAddressHandler#previewAreaAroundCCP"){

                            public void execute() {
                                HomeAddressHandler.this.mapInterface.getPreviewMap().setPreviewAreaAroundCCP(12);
                                this.getCommandList().commandFinished();
                            }
                        });
                        break block8;
                    }
                    commandList.add(new HidePreviewMapCommand(this.mapInterface.getPreviewMap()));
                }
                catch (Exception exception) {
                    this.logger.log(10000, "HomeAddressHandler#handleHomeAddressFocus() - ERROR=%1", (Throwable)exception);
                }
            } else {
                try {
                    commandList.add(new NavCommand("HomeAddressHandler#previewHome"){

                        public void execute() {
                            GuiTooltipInformationContainer guiTooltipInformationContainer = null;
                            if (guiModelAccessForPreviewMapDetailScreen != null) {
                                guiTooltipInformationContainer = guiModelAccessForPreviewMapDetailScreen.createMapTooltipInformationContainer(navLocation, null);
                            }
                            HomeAddressHandler.this.mapInterface.getPreviewMap().setPreviewFavoriteHome(navLocation, 12, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
                            this.getCommandList().commandFinished();
                        }
                    });
                }
                catch (Exception exception) {
                    this.logger.log(10000, "HomeAddressHandler#handleHomeAddressFocus() - ERROR=%1", (Throwable)exception);
                }
            }
        }
        commandList.execute("HomeAddressHandler#PreviewMap");
    }

    public boolean isHomeAddressMenuItem(int n) {
        return n == this.homeAddressModel.getID() || n == 0;
    }

    protected void resetInputMode() {
        this.env.getChoiceModel(170).setValue(0);
    }
}

