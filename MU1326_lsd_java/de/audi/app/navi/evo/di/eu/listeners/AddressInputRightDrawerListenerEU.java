/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$1;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$2;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$3;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$4;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$5;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$6;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$7;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputRightDrawerListenerEU$8;
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

public class AddressInputRightDrawerListenerEU
extends AbstractAddressInputListenerEU
implements OptionModelListener {
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiEuStoreDestinationAsFavoriteOptionModel();
    private static final int PARKING_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiEuParkingNearDestinationOptionModel();
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiEuShowInMapOptionModel();
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiEuAddDestinationToContactOptionModel();
    private static final int CITY_ZIP_SCREEN_TILED_LIST = DIScreensEvo.getDiEuCityZipScreenTiledListModel();
    private static final int STREET_SCREEN_TILED_LIST = DIScreensEvo.getDiEuStreetScreenTiledListModel();
    private static final int HOUSENUMBER_FREETEXT_SCREEN_TILED_LIST = DIScreensEvo.getDiEuHousenumberFreetextScreenTiledListModel();
    private static final int HOUSENUMBER_MATCHSPELLER_SCREEN_TILED_LIST = DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel();
    private static final int JUNCTION_SCREEN_TILED_LIST = DIScreensEvo.getDiEuJunctionScreenTiledListModel();
    private static final int REFINEMENT_SCREEN_TILED_LIST = DIScreensEvo.getDiEuRefinementScreenTiledListModel();
    private static final int[] optionListenerTargets = new int[]{CITY_ZIP_SCREEN_TILED_LIST, STREET_SCREEN_TILED_LIST, HOUSENUMBER_FREETEXT_SCREEN_TILED_LIST, HOUSENUMBER_MATCHSPELLER_SCREEN_TILED_LIST, JUNCTION_SCREEN_TILED_LIST, REFINEMENT_SCREEN_TILED_LIST};
    private static final int WIDGET_ID;
    private final MapInterface mapInterface;
    private final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    private final AsyncNavLocationExtractor asyncLiCityHistoryListNavLocationExtractor;
    private final AddressInputMainScreenListenerEU mainScreenListener;

    public AddressInputRightDrawerListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor, AsyncNavLocationExtractor asyncNavLocationExtractor2, AddressInputMainScreenListenerEU addressInputMainScreenListenerEU) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.mapInterface = mapInterface;
        this.asyncLiCityHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.mainScreenListener = addressInputMainScreenListenerEU;
        this.initListeners();
    }

    @Override
    public CommandList getStartCommandList() {
        return this.commandListFactory.createCommandList();
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
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
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$1(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$2(this));
            }
        } else if (n == PARKING_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$3(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$4(this));
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
                NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.longitude, lIValueListElement.latitude);
                this.mapInterface.onShowInMapClicked(navLocationWgs84);
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$5(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.mapInterface.onShowInMapClicked(null);
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$6(this));
            }
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$7(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerEU$8(this));
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

    static /* synthetic */ String access$000(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$100(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$200(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }

    static /* synthetic */ String access$300(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$400(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$500(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }

    static /* synthetic */ String access$600(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$700(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$800(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }

    static /* synthetic */ String access$900(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1000(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1100(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }

    static /* synthetic */ String access$1200(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1300(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ MapInterface access$1400(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.mapInterface;
    }

    static /* synthetic */ String access$1500(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1600(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ String access$1700(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1800(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1900(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }

    static /* synthetic */ String access$2000(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$2100(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$2200(AddressInputRightDrawerListenerEU addressInputRightDrawerListenerEU) {
        return addressInputRightDrawerListenerEU.inputManager;
    }
}

