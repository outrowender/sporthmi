/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.model.TelDataUpdateMediator;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler$1;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler$2;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler$3;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler$TelNetworkModelLanguageUpdateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceProvider;

public abstract class AbstractTelNetworkSetupHandler
extends AbstractPhoneComponent
implements ButtonListener,
ChoiceListener,
ListListener {
    private static final String[][] TRANSLATE_THESE = new String[][]{{"chinamobile", "46000"}, {"chinaunicom", "chnunicom", "chncugsm", "46001"}, {"chinatelecom", "ctgsm", "chnct", "46011"}, {"cmcc"}};
    private static final int[] TRANSLATION_IDS = new int[]{9, 11, 10, 12};
    public static final int NWSEARCH_AUTOMATIC;
    public static final int NWSEARCH_MANUAL;
    private NetworkProvider[] nwProviders;
    private static final SimpleIntIntMap DSI_2_HMI_NW_STATES;
    private final int PROVIDERS_LIST_COLUMNS_COUNT;
    private final TelDataUpdateMediator searchStatusChoiceUpdateMediator;
    private final TelDataUpdateMediator registerStatusChoiceUpdateMediator;
    private volatile String serviceProvider;
    private volatile IGlobalTelephoneStateStruct globalTelState;
    private int networkRegMode;
    private String networkNameDisplayLabel;

    public AbstractTelNetworkSetupHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.PROVIDERS_LIST_COLUMNS_COUNT = 3;
        this.searchStatusChoiceUpdateMediator = new TelDataUpdateMediator(this.getChoiceModel(this.modelIDNWSearchStatusChoice()), this.log);
        this.registerStatusChoiceUpdateMediator = new TelDataUpdateMediator(this.getChoiceModel(this.modelIDNWRegisterStatusChoice()), this.log);
        this.getApplication().addDiagnosisComponent(new AbstractTelNetworkSetupHandler$1(this));
        this.addSubPhoneComponent(new AbstractTelNetworkSetupHandler$TelNetworkModelLanguageUpdateListener(this, iTelApplication));
    }

    protected abstract int modelIDNetworkSelectionButton() {
    }

    protected abstract int modelIDNetworkRegistrationType() {
    }

    protected abstract int modelIDNetworkSelectionList() {
    }

    protected abstract int modelIDNWSearchStatusChoice() {
    }

    protected abstract int modelIDNWSelectedLabel() {
    }

    protected abstract int modelIDNWRegisterStatusChoice() {
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getButtonModel(this.modelIDNetworkSelectionButton()).setButtonListener(this);
        this.getNetworkRegistrationTypeChoiceModel().setChoiceListener(this);
        this.getListModel(this.modelIDNetworkSelectionList()).setListListener(this);
        this.getCancelNetworkSearchBM().setButtonListener(this);
    }

    private ButtonModelApp getCancelNetworkSearchBM() {
        return this.getButtonModel(613811200);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getButtonModel(this.modelIDNetworkSelectionButton()).resetListener();
        this.getNetworkRegistrationTypeChoiceModel().resetListener();
        this.getListModel(this.modelIDNetworkSelectionList()).resetListener();
        this.getCancelNetworkSearchBM().resetListener();
    }

    private ChoiceModelApp getNetworkRegistrationTypeChoiceModel() {
        return this.getChoiceModel(this.modelIDNetworkRegistrationType());
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.globalTelState = iGlobalTelephoneStateStruct;
        this.getLabelModel(3900).setText(this.getDisplayProviderName(iGlobalTelephoneStateStruct.getNadInstanceState()));
        if (n == 0x3000400) {
            this.setupNetworkRegistrationType(iGlobalTelephoneStateStruct);
        } else if (n == 369099520 || n == 0x13000300 || n == 452985600) {
            this.setupNetworkRegistrationType(iGlobalTelephoneStateStruct);
            this.resolveNetworkLabel(iGlobalTelephoneStateStruct.getRegisterStateDSINAD());
            if (iGlobalTelephoneStateStruct.getNadMode() == 2) {
                this.serviceProvider = this.getDisplayProviderName(iGlobalTelephoneStateStruct.getDataOnlyNadDeviceState());
                this.networkNameDisplayLabel = iGlobalTelephoneStateStruct.getDisplayNetworkNameDSINAD();
                this.setNetworkNameDisplayLabel(this.networkNameDisplayLabel);
            }
        } else if (n == 0x16000100 || n == 0x13000100 || n == 0x1B000100 || n == 369099264 || n == 318767616 || n == 452985344) {
            this.setupNetworkRegistrationType(iGlobalTelephoneStateStruct);
            String string = this.getDisplayProviderName(iGlobalTelephoneStateStruct.getPrimaryDeviceState());
            this.setProviderNameDisplayLabel(string);
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNadInstanceState();
            if (iTelDSIMobileEquipmentDeviceState != null) {
                this.resolveNetworkLabel(iTelDSIMobileEquipmentDeviceState.getRegisterState());
                this.setupNetworkNameAndProvider(iGlobalTelephoneStateStruct, iTelDSIMobileEquipmentDeviceState);
            }
        }
    }

    private void setupNetworkNameAndProvider(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iGlobalTelephoneStateStruct.getNadMode() != 2) {
            this.serviceProvider = this.getDisplayProviderName(iTelDSIMobileEquipmentDeviceState);
            this.networkNameDisplayLabel = iTelDSIMobileEquipmentDeviceState.getDisplayNetworkName();
            this.setNetworkNameDisplayLabel(this.networkNameDisplayLabel);
        }
    }

    private String getDisplayProviderName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return this.getDisplayProviderName(this.getApplication().getFrameworkAccess(), this.getApplication().getTextFactory(), iTelDSIMobileEquipmentDeviceState);
    }

    private String getDisplayProviderName(IFrameworkAccess iFrameworkAccess, ITelTextFactory iTelTextFactory, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            RegisterStateStruct registerStateStruct = iTelDSIMobileEquipmentDeviceState.getRegisterState();
            ServiceProvider serviceProvider = iTelDSIMobileEquipmentDeviceState.getServiceProvider();
            if (registerStateStruct != null) {
                String string;
                if (serviceProvider != null && serviceProvider.displayConditionServiceProviderName && (string = serviceProvider.getTelServiceProviderName()) != null && string.length() > 0) {
                    return this.getCustomProviderName(iFrameworkAccess, iTelTextFactory, string);
                }
                string = registerStateStruct.getTelLongProviderName();
                String string2 = registerStateStruct.getTelNumProviderName();
                if (string != null && string.length() > 0) {
                    return this.getCustomProviderName(iFrameworkAccess, iTelTextFactory, string);
                }
                if (string2 != null && string2.length() > 0) {
                    return string2;
                }
            }
        }
        return "";
    }

    private String getCustomProviderName(IFrameworkAccess iFrameworkAccess, ITelTextFactory iTelTextFactory, String string) {
        if (iFrameworkAccess.getSysConst(442) == 2) {
            String string2 = this.sanitizeProviderName(string);
            this.log.log(-2137614336, "[AbstractTelNetworkSetupHandler#getCustomProviderName] HU_REGION is CN, providerName=%1, compareString=%2", (Object)string, (Object)string2);
            for (int i2 = 0; i2 < TRANSLATION_IDS.length; ++i2) {
                for (int i3 = 0; i3 < TRANSLATE_THESE[i2].length; ++i3) {
                    if (!TRANSLATE_THESE[i2][i3].equals(string2)) continue;
                    String string3 = iTelTextFactory.getText(TRANSLATION_IDS[i2]);
                    this.log.log(-2137614336, "[AbstractTelNetworkSetupHandler#getCustomProviderName] returning %1 for %2", (Object)string3, (Object)string2);
                    return string3;
                }
            }
            this.log.log(-1601830656, "[AbstractTelNetworkSetupHandler#getCustomProviderName] no translation found for %1", (Object)string2);
        }
        this.log.log(-2137614336, "[AbstractTelNetworkSetupHandler#getCustomProviderName] HU_REGION is not CN, returning unchanged provider name %1", (Object)string);
        return string;
    }

    private String sanitizeProviderName(String string) {
        return PhoneUtils.removeSeparators(string.trim().toLowerCase());
    }

    private void setupNetworkRegistrationType(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n = iGlobalTelephoneStateStruct.getNadMode();
        switch (n) {
            case 1: {
                this.setRegisterStateTypeChoice(iGlobalTelephoneStateStruct.getNadInstanceState().getRegisterState());
                break;
            }
            case 2: {
                this.setRegisterStateTypeChoice(iGlobalTelephoneStateStruct.getRegisterStateDSINAD());
                break;
            }
            default: {
                this.log.log(-2137614336, "[AbstractTelNetworkSetupHandler#updateGlobalTelephoneStateProperty] nadMode=%1 --> NOP", (long)n);
            }
        }
    }

    private ChoiceModelApp getNetworkStatusChoiceModel() {
        return this.getChoiceModel(187);
    }

    private void resolveNetworkLabel(RegisterStateStruct registerStateStruct) {
        if (registerStateStruct == null) {
            return;
        }
        switch (registerStateStruct.getTelRegisterState()) {
            case 5: {
                this.getNetworkStatusChoiceModel().setValue(4);
                break;
            }
            case 2: {
                this.getNetworkStatusChoiceModel().setValue(2);
                break;
            }
            default: {
                this.getNetworkStatusChoiceModel().setValue(1);
            }
        }
    }

    private void setProviderNameDisplayLabel(String string) {
        this.getLabelModel(506).setText(string);
    }

    private void setNetworkNameDisplayLabel(String string) {
        String string2 = this.prepareProviderNameWithServiceProvider(string);
        this.getLabelModel(-1433140224).setText(string2);
    }

    private void setRegisterStateTypeChoice(RegisterStateStruct registerStateStruct) {
        if (registerStateStruct != null) {
            int n;
            this.networkRegMode = n = registerStateStruct.getTelRegMode();
            int n2 = this.getUIRegisterMode(n);
            this.log.log(1078071040, "AbstractTelNetworkSetupHandler#setRegisterStateTypeChoice(): registrationTypeModel = %1", (long)n2);
            this.getNetworkRegistrationTypeChoiceModel().setValue(n2);
        }
    }

    private int getUIRegisterMode(int n) {
        return n == 1 ? 0 : 1;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#keyTyped: id=%1 ", (long)n);
        if (n == this.modelIDNetworkSelectionButton()) {
            this.log.log(1078071040, "AbstractTelNetworkSetupHandler#keyTyped: launching networks search ", (long)n);
            this.launchNetworkSearchFromTelSetupMain(this.getButtonModel(this.modelIDNetworkSelectionButton()), n3);
        } else if (n == 613811200) {
            this.cancelNetworkSearch();
        } else {
            this.log.log(-1601830656, "AbstractTelNetworkSetupHandler#keyTyped: Unhandled id %1! ", (long)n);
        }
    }

    protected void cancelNetworkSearch() {
        this.log.log(1078071040, "[AbstractTelNetworkSetupHandler#cancelNetworkSearch]");
        this.getApplication().getTelephoneDSIAccess().requestAbortNetworkSearch();
    }

    protected void cancelNetworkRegistration() {
        this.log.log(1078071040, "[AbstractTelNetworkSetupHandler#cancelNetworkRegistration]");
        this.getApplication().getTelephoneDSIAccess().requestAbortNetworkRegistration();
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[AbstractTelNetworkSetupHandler#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedChoice(n, n2, n3, n4));
        }
        if (n == this.modelIDNetworkRegistrationType()) {
            this.itemSelectedNetworkRegistrationTypeChoice(n2, n4);
        } else if (n == this.modelIDNetworkSelectionList()) {
            this.itemSelectedNetworkSelectionList(n2, n4);
        } else {
            this.log.log(-1601830656, "AbstractTelNetworkSetupHandler#itemSelected: Unhandled id %1! ", (long)n);
        }
    }

    private void requestNetworkSearch() {
        this.log.log(1078071040, "[AbstractTelNetworkSetupHandler#requestNetworkSearch] enter, calling DSI");
        this.getApplication().getTelephoneDSIAccess().requestNetworkSearch(0, false, new AbstractTelNetworkSetupHandler$2(this));
    }

    protected void setUIRegMode() {
        this.getNetworkRegistrationTypeChoiceModel().setValue(this.getUIRegisterMode(this.networkRegMode));
    }

    public void requestNetworkRegistration(String string, int n, int n2) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#requestNetworkRegistration: called");
        this.getApplication().getTelephoneDSIAccess().requestNetworkRegistration(string, n, n2, true, new AbstractTelNetworkSetupHandler$3(this));
    }

    private void itemSelectedNetworkSelectionList(int n, int n2) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#itemSelectedNetworkSelectionList: index=%1 ", (long)n);
        this.registerStatusChoiceUpdateMediator.setUpdate();
        ListModelApp listModelApp = this.getListModel(this.modelIDNetworkSelectionList());
        listModelApp.fireEvent(n2);
        this.requestNetworkRegistration(this.nwProviders[n].getTelNumProviderName(), 0, n2);
    }

    protected void itemSelectedNetworkRegistrationTypeChoice(int n, int n2) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#itemSelectedNetworkRegistrationTypeChoice: index=%1 ", (long)n);
        switch (n) {
            case 0: {
                this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#itemSelectedNetworkRegistrationTypeChoice: Network registration type is automatic! ");
                this.launchAutoRegFromSetupNetMain(n2);
                break;
            }
            case 1: {
                this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#itemSelectedNetworkRegistrationTypeChoice: Network registration type is manual, searching for network! ");
                this.launchNetworkSearchFromTelSetupMain(this.getButtonModel(this.modelIDNetworkSelectionButton()), n2);
                break;
            }
            default: {
                this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#itemSelectedNetworkRegistrationTypeChoice: Unhandled index %1! ", (long)n);
                return;
            }
        }
    }

    protected void launchAutoRegFromSetupNetMain(int n) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#launchAutoRegFromSetupNetMain: call. Source networkRegMode=%1", (long)this.networkRegMode);
        this.getChoiceModel(1184302080).setValue(0);
        this.getNetworkRegistrationTypeChoiceModel().setValue(0);
        this.getNetworkRegistrationTypeChoiceModel().fireEvent(n);
        this.requestNetworkRegistration("", 1, n);
    }

    protected void launchNetworkSearchFromTelSetupMain(HMIModelApp hMIModelApp, int n) {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#launchNetworkSearchFromTelSetupMain: call. Source networkRegMode=%1", (long)this.networkRegMode);
        this.searchStatusChoiceUpdateMediator.setUpdate();
        this.getNetworkRegistrationTypeChoiceModel().setValue(1);
        this.getChoiceModel(1184302080).setValue(1);
        hMIModelApp.fireEvent(n);
        this.requestNetworkSearch();
    }

    private void prepareNetworkListForShowing() {
        this.log.log(-2137614336, "AbstractTelNetworkSetupHandler#pullSelectedNWtoTop] called");
        for (int i2 = 0; i2 < this.nwProviders.length; ++i2) {
            if (this.nwProviders[i2].getTelProviderState() != 1) continue;
            NetworkProvider networkProvider = this.nwProviders[i2];
            networkProvider.telLongProviderName = this.prepareProviderNameWithServiceProvider(networkProvider.telLongProviderName);
            this.nwProviders[i2] = this.nwProviders[0];
            this.nwProviders[0] = networkProvider;
            return;
        }
    }

    private String prepareProviderNameWithServiceProvider(String string) {
        if (StringUtilities.isNullOrEmpty(this.serviceProvider) || string.equals(this.serviceProvider)) {
            return string;
        }
        ITelTextFactory iTelTextFactory = this.getApplication().getTextFactory();
        String string2 = this.getCustomProviderName(this.getApplication().getFrameworkAccess(), iTelTextFactory, string);
        String string3 = this.getCustomProviderName(this.getApplication().getFrameworkAccess(), iTelTextFactory, this.serviceProvider);
        if (string2 != null && string3 != null && this.sanitizeProviderName(string2).equals(this.sanitizeProviderName(string3))) {
            return string2;
        }
        return StringUtilities.formatMessage("%1 (%2)", new String[]{string2, string3});
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    static /* synthetic */ LogChannel access$000(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ int access$100(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.networkRegMode;
    }

    static /* synthetic */ int access$200(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, int n) {
        return abstractTelNetworkSetupHandler.getUIRegisterMode(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.getNetworkRegistrationTypeChoiceModel();
    }

    static /* synthetic */ TelDataUpdateMediator access$400(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.searchStatusChoiceUpdateMediator;
    }

    static /* synthetic */ LogChannel access$500(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$600(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ ButtonModelApp access$700(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, int n) {
        return abstractTelNetworkSetupHandler.getButtonModel(n);
    }

    static /* synthetic */ LogChannel access$800(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$900(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$1000(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ NetworkProvider[] access$1102(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, NetworkProvider[] networkProviderArray) {
        abstractTelNetworkSetupHandler.nwProviders = networkProviderArray;
        return networkProviderArray;
    }

    static /* synthetic */ void access$1200(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        abstractTelNetworkSetupHandler.prepareNetworkListForShowing();
    }

    static /* synthetic */ ListModelApp access$1300(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, int n) {
        return abstractTelNetworkSetupHandler.getListModel(n);
    }

    static /* synthetic */ NetworkProvider[] access$1100(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.nwProviders;
    }

    static /* synthetic */ LogChannel access$1400(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ ITelApplication access$1500(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1600(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.getApplication();
    }

    static /* synthetic */ String access$1700(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, IFrameworkAccess iFrameworkAccess, ITelTextFactory iTelTextFactory, String string) {
        return abstractTelNetworkSetupHandler.getCustomProviderName(iFrameworkAccess, iTelTextFactory, string);
    }

    static /* synthetic */ SimpleIntIntMap access$1800() {
        return DSI_2_HMI_NW_STATES;
    }

    static /* synthetic */ LogChannel access$1900(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ ButtonModelApp access$2000(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.getCancelNetworkSearchBM();
    }

    static /* synthetic */ TelDataUpdateMediator access$2100(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.registerStatusChoiceUpdateMediator;
    }

    static /* synthetic */ LogChannel access$2200(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2300(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2400(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2500(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2600(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2700(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ LogChannel access$2800(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.log;
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$2900(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.globalTelState;
    }

    static /* synthetic */ String access$3000(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return abstractTelNetworkSetupHandler.getDisplayProviderName(iTelDSIMobileEquipmentDeviceState);
    }

    static /* synthetic */ void access$3100(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, String string) {
        abstractTelNetworkSetupHandler.setProviderNameDisplayLabel(string);
    }

    static /* synthetic */ String access$3200(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        return abstractTelNetworkSetupHandler.networkNameDisplayLabel;
    }

    static /* synthetic */ void access$3300(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, String string) {
        abstractTelNetworkSetupHandler.setNetworkNameDisplayLabel(string);
    }

    static {
        DSI_2_HMI_NW_STATES = new SimpleIntIntMap();
        DSI_2_HMI_NW_STATES.add(1, 0);
        DSI_2_HMI_NW_STATES.add(3, 1);
        DSI_2_HMI_NW_STATES.add(2, 2);
    }
}

