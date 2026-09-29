/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputMainScreenListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$1;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$2;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$3;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$4;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$5;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$6;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$7;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputRightDrawerListenerCN$8;
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

public class AddressInputRightDrawerListenerCN
extends AbstractAddressInputListenerEvo
implements OptionModelListener {
    private static final int WIDGET_ID;
    private final MapInterface mapInterface;
    private final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    private final AsyncNavLocationExtractor asyncLiCityHistoryListNavLocationExtractor;
    private final AddressInputMainScreenListenerCN mainScreenListener;
    private static final int CITY_ZIP_SCREEN_TILED_LIST;
    private static final int STREET_SCREEN_TILED_LIST;
    private static final int HOUSENUMBER_SCREEN_TILED_LIST;
    private static final int INTERSECTION_SCREEN_TILED_LIST;
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID;
    private static final int POI_NEAR_DESTINATION_OPTION_MODEL_ID;
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID;
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID;
    private static final int[] optionListenerTargets;

    public AddressInputRightDrawerListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor, AsyncNavLocationExtractor asyncNavLocationExtractor2, AddressInputMainScreenListenerCN addressInputMainScreenListenerCN) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.asyncLiCityHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.mapInterface = mapInterface;
        this.mainScreenListener = addressInputMainScreenListenerCN;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.registerOptionListenersForOption(STORE_AS_FAVORITE_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(POI_NEAR_DESTINATION_OPTION_MODEL_ID);
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
        } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
            this.inputManager.startPoiNearDestination(this.inputManager.getBackupLocation());
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
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$1(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$2(this));
            }
        } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$3(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$4(this));
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
                NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.longitude, lIValueListElement.latitude);
                this.mapInterface.onShowInMapClicked(navLocationWgs84);
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$5(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.mapInterface.onShowInMapClicked(null);
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$6(this));
            }
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$7(this));
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressInputRightDrawerListenerCN$8(this));
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

    @Override
    public CommandList getStartCommandList() {
        return null;
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return null;
    }

    static /* synthetic */ String access$000(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$100(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$200(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static /* synthetic */ String access$300(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$400(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$500(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static /* synthetic */ String access$600(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$700(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$800(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static /* synthetic */ String access$900(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1000(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1100(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static /* synthetic */ String access$1200(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1300(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ MapInterface access$1400(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.mapInterface;
    }

    static /* synthetic */ String access$1500(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1600(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ String access$1700(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$1800(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$1900(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static /* synthetic */ String access$2000(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$2100(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.logChannel;
    }

    static /* synthetic */ IAddressInputManager access$2200(AddressInputRightDrawerListenerCN addressInputRightDrawerListenerCN) {
        return addressInputRightDrawerListenerCN.inputManager;
    }

    static {
        CITY_ZIP_SCREEN_TILED_LIST = DIScreensEvo.getDiCnCityScreenTiledListModel();
        STREET_SCREEN_TILED_LIST = DIScreensEvo.getDiCnStreetScreenTiledListModel();
        HOUSENUMBER_SCREEN_TILED_LIST = DIScreensEvo.getDiCnHousenumberScreenTiledListModel();
        INTERSECTION_SCREEN_TILED_LIST = DIScreensEvo.getDiCnIntersectionScreenTiledListModel();
        STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiCnStoreDestinationAsFavoriteOptionModel();
        POI_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiCnPoiNearDestinationOptionModel();
        SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiCnShowInMapOptionModel();
        ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiCnAddDestinationToContactOptionModel();
        optionListenerTargets = new int[]{CITY_ZIP_SCREEN_TILED_LIST, STREET_SCREEN_TILED_LIST, HOUSENUMBER_SCREEN_TILED_LIST, INTERSECTION_SCREEN_TILED_LIST};
    }
}

