/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler$1;
import de.audi.tghu.navi.app.HomeAddressHandler$2;
import de.audi.tghu.navi.app.HomeAddressHandler$3;
import de.audi.tghu.navi.app.HomeAddressHandler$4;
import de.audi.tghu.navi.app.HomeAddressHandler$5;
import de.audi.tghu.navi.app.HomeAddressHandler$6;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;

public class HomeAddressHandler
implements ButtonListener {
    protected static final int HOME_ADDRESS_AVAILABLE;
    protected static final int HOME_ADDRESS_NOT_AVAILABLE;
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
        this(navigationEnv, locationSerializer, iStartGuidanceToDestinationSequence, iCommandListFactory, mapInterface, logChannel, dispatcherBase, navigationEnv.getButtonModel(-467991040), navigationEnv.getButtonModel(1864238592), navigationEnv.getChoiceModel(-451213824), 940);
    }

    protected final void registerListeners() {
        this.homeAddressModel.setButtonListener(this);
        this.deleteHomeAddressModel.setButtonListener(this);
    }

    public void initHomeButtonState() {
        if (!this.homeButtonDeserialized) {
            this.logger.log(1078071040, "HomeAddressHandler#initHomeButtonState()");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new HomeAddressHandler$1(this, "DeserializeHomeAddressCommand"));
            commandList.add(new HomeAddressHandler$2(this, "SaveDeserializedHomeAddressCommand"));
            commandList.execute("HomeAddressHandler#DeserializeHomeAddressCommandList");
        }
    }

    public void onHomeButtonPressed(int n) {
        this.logger.log(1078071040, "HomeAddressHandler#onHomeButtonPressed(), %1", (Object)LocationFormatter.formatLocationShort(this.currentHomeAddress));
        if (this.isHomeAddressAvailable() && this.currentHomeAddress != null) {
            this.startGuidanceDependentSequence.start(this.currentHomeAddress);
        }
    }

    public void onCreateEditHomeAddress(NavLocation navLocation) {
        this.logger.log(1078071040, "HomeAddressHandler#onCreateEditHomeAddress() - newHomeAddress: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation == null || !navLocation.isPositionValid()) {
            this.logger.log(10000, "HomeAddressHandler#onCreateEditHomeAddress() - newHomeAddress is null! Don't change current Home address");
            return;
        }
        this.currentHomeAddress = navLocation;
        this.setPersistetHomeAddress(navLocation);
        this.updateHomeAddressAvailable();
    }

    public void onPrepareCreateEditHomeAddress() {
        this.logger.log(1078071040, "HomeAddressHandler#onPrepareCreateEditHomeAddress()");
        this.inputModeManager.setInputMode(2, this.env);
    }

    public void onDeleteHomeAddress() {
        this.logger.log(1078071040, "HomeAddressHandler#onDeleteHomeAddress()");
        this.currentHomeAddress = null;
        this.setPersistetHomeAddress(null);
        this.updateHomeAddressAvailable();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new HomeAddressHandler$3(this, "HomeButtonPressed", n, n3));
        commandList.execute("HomeAddressHandler#keyPressed");
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

    private void setPersistetHomeAddress(NavLocation navLocation) {
        HomeAddressHandler$4 homeAddressHandler$4 = new HomeAddressHandler$4(this, navLocation);
        if (this.dispatcher != null) {
            this.dispatcher.execute(homeAddressHandler$4);
        } else {
            homeAddressHandler$4.run();
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

    public void handleHomeAddressFocus(GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen) {
        CommandList commandList;
        block8: {
            this.logger.log(-2137614336, "HomeAddressHandler#handleHomeAddressFocus()");
            if (this.mapInterface == null) {
                return;
            }
            commandList = this.commandListFactory.createCommandList();
            NavLocation navLocation = this.getCurrentHomeAddress();
            if (navLocation == null || !navLocation.isPositionValid()) {
                try {
                    if (this.env.getFramework().isAsia()) {
                        commandList.add(new HomeAddressHandler$5(this, "HomeAddressHandler#previewAreaAroundCCP"));
                        break block8;
                    }
                    commandList.add(new HidePreviewMapCommand(this.mapInterface.getPreviewMap()));
                }
                catch (Exception exception) {
                    this.logger.log(10000, "HomeAddressHandler#handleHomeAddressFocus() - ERROR=%1", (Throwable)exception);
                }
            } else {
                try {
                    commandList.add(new HomeAddressHandler$6(this, "HomeAddressHandler#previewHome", guiModelAccessForPreviewMapDetailScreen, navLocation));
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

    static /* synthetic */ LocalPersistNavLocationHelper access$000(HomeAddressHandler homeAddressHandler) {
        return homeAddressHandler.localPersistNavLocationHelper;
    }

    static /* synthetic */ boolean access$102(HomeAddressHandler homeAddressHandler, boolean bl) {
        homeAddressHandler.homeButtonDeserialized = bl;
        return homeAddressHandler.homeButtonDeserialized;
    }

    static /* synthetic */ LocationSerializer access$200(HomeAddressHandler homeAddressHandler) {
        return homeAddressHandler.locationSerializer;
    }
}

