/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.listeners.AbstractAddressInputListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputMainScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$1;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$2;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$3;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$4;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$5;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$6;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$7;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputRightDrawerListenerNAR$8;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputRightDrawerListenerNAR
extends AbstractAddressInputListenerNAR
implements OptionModelListener {
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiNarStoreDestinationAsFavoriteOptionModel();
    private static final int PARKING_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiNarParkingNearDestinationOptionModel();
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiNarShowInMapOptionModel();
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiNarAddDestinationToContactOptionModel();
    private static final int CITY_ZIP_SCREEN_TILED_LIST = DIScreensEvo.getDiNarCityZipScreenTiledListModel();
    private static final int STREET_SCREEN_TILED_LIST = DIScreensEvo.getDiNarStreetScreenTiledListModel();
    private static final int STREET_REFINEMENT_SCREEN_TILED_LIST = DIScreensEvo.getDiNarStreetRefinementScreenTiledListModel();
    private static final int HOUSENUMBER_SCREEN_TILED_LIST = DIScreensEvo.getDiNarHousenumberScreenTiledListModel();
    private static final int JUNCTION_SCREEN_TILED_LIST = DIScreensEvo.getDiNarIntersectionScreenTiledListModel();
    private static final int[] optionListenerTargets = new int[]{CITY_ZIP_SCREEN_TILED_LIST, STREET_SCREEN_TILED_LIST, STREET_REFINEMENT_SCREEN_TILED_LIST, HOUSENUMBER_SCREEN_TILED_LIST, JUNCTION_SCREEN_TILED_LIST};
    private static final int WIDGET_ID;
    private final MapInterface mapInterface;
    private final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    private final AsyncNavLocationExtractor asyncLiCityStateStreetHistoryListNavLocationExtractor;
    private final AddressInputMainScreenListenerNAR mainScreenListener;

    public AddressInputRightDrawerListenerNAR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor, AsyncNavLocationExtractor asyncNavLocationExtractor2, AddressInputMainScreenListenerNAR addressInputMainScreenListenerNAR) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.mapInterface = mapInterface;
        this.asyncLiCityStateStreetHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.mainScreenListener = addressInputMainScreenListenerNAR;
        this.initListeners();
    }

    @Override
    public CommandList getStartCommandList() {
        return this.commandListFactory.createCommandList();
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.commandListFactory.createCommandList();
    }

    @Override
    protected void initListeners() {
        this.registerOptionListenersForOption(STORE_AS_FAVORITE_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(PARKING_NEAR_DESTINATION_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(SHOW_IN_MAP_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID);
    }

    private void registerOptionListenersForOption(int n) {
        OptionModelApp optionModelApp = this.env.getHMIService().getOptionModel(n);
        optionModelApp.setCustomIDListener(this, 1);
        for (int i2 = 0; i2 < optionListenerTargets.length; ++i2) {
            optionModelApp.setListener(this, optionListenerTargets[i2]);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#keyPressed - modelId=%2, targetModelId=%3, targetWidgetId=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (long)n4);
        if (n4 == 1) {
            this.handleKeyPressedForInputForm(n);
        } else {
            this.handleKeyPressedForList(n, n2, n3);
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    private void handleKeyPressedForInputForm(int n) {
        this.logChannel.log(-2137614336, "%1#handleKeyPressedForInputForm()", (Object)this.CLASS_NAME);
        this.mainScreenListener.resetPreviousLocation();
        if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
            this.inputManager.addAddressToFavorites(this.inputManager.getBackupLocation());
        } else if (n == PARKING_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (this.inputManager.getStartParkingNearDestination(this.inputManager.getBackupLocation()) != null) {
                this.inputManager.getStartParkingNearDestination(this.inputManager.getBackupLocation()).execute(new StringBuffer().append(this.CLASS_NAME).append("#Parking near destination").toString());
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            this.mapInterface.destOptShowInMap(this.inputManager.getBackupLocation());
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            this.inputManager.startStoringNavLocationOnAdbEntry(this.inputManager.getBackupLocation());
        }
    }

    private void handleKeyPressedForList(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#handleKeyPressedForList()", (Object)this.CLASS_NAME);
        EvoListRow evoListRow = this.env.getTiledListModel(n2).getRow(n3);
        if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$1(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityStateStreetHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$2(this));
            }
        } else if (n == PARKING_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$3(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityStateStreetHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$4(this));
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
                NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.longitude, lIValueListElement.latitude);
                this.mapInterface.onShowInMapClicked(navLocationWgs84);
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$5(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.mapInterface.onShowInMapClicked(null);
                this.asyncLiCityStateStreetHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$6(this));
            }
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$7(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityStateStreetHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerNAR$8(this));
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    static /* synthetic */ String access$000(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$100(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$200(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }

    static /* synthetic */ String access$300(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$400(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$500(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }

    static /* synthetic */ String access$600(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$700(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$800(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }

    static /* synthetic */ String access$900(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1000(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1100(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }

    static /* synthetic */ String access$1200(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1300(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ MapInterface access$1400(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.mapInterface;
    }

    static /* synthetic */ String access$1500(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1600(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ String access$1700(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1800(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1900(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }

    static /* synthetic */ String access$2000(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$2100(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$2200(AddressInputRightDrawerListenerNAR addressInputRightDrawerListenerNAR) {
        return addressInputRightDrawerListenerNAR.inputManager;
    }
}

