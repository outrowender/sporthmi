/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.NaviMyAudiImport$IMyAudiImportResultListener;
import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.destinationimport.INaviMyAudiSearchCallBack;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportContactDetailListener;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl$1;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl$2;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSearch;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;

public abstract class NaviMyAudiImportImpl
implements NaviMyAudiImport,
ITelServiceListener,
INaviMyAudiSearchCallBack {
    public static final int PROPERTY_COLUMN;
    public static final int TEXT_COLUMN;
    public static final int COLUMN_COUNT;
    protected static final int ADDITIONAL_INFO_NOT_AVAILABLE;
    protected static final int ADDITIONAL_INFO_AVAILABLE;
    protected static final PropertyListCell EMPTY_PROPERTY_LIST_CELL;
    protected static final int IMPORT_STATUS_IDLE;
    private static final int IMPORT_STATUS_OK;
    private static final int IMPORT_STATUS_MEMFULL;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected ADBHMIAppService adbHmiAppService = null;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected BaseListModelApp myAudiResultList;
    protected ChoiceModelApp businessAddressAvailableChoice;
    protected ChoiceModelApp privateAddressAvailableChoice;
    protected ListModelApp businessAddressListModel;
    protected ListModelApp privateAddressListModel;
    protected ListModelApp telephoneNumbersListModel;
    protected LabelModelApp additionalInfoLabel;
    protected LabelModelApp subTitleLabel;
    private ChoiceModelApp destOnlineDownloadResultChoice;
    private BaseListModelApp sdsMyAudiList;
    private LabelModelApp sdsMyAudiSubtitleLabel;
    private SpellerModelApp speller;
    private final ITelService telService;
    private NaviMyAudiImportContactDetailListener myAudiImportContactDetailListener;
    protected final ICommandListFactory commandListFactory;
    private final IStartGuidanceToDestinationSequence rgSequence;
    protected final IPreviewMap previewMap;
    protected List adbEntries = new ArrayList();
    protected byte[] currentSelectedBusinessDestination = null;
    protected byte[] currentSelectedPrivateDestination = null;
    private NaviMyAudiSearch search;
    private final DispatcherBase dispatcher;
    private List successfulImports;
    private List unsuccessfulImports;
    protected ArrayList importedAdbEntries;
    protected ArrayList notImportedAdbEntries;
    private NaviMyAudiImport$IMyAudiImportResultListener myAudiOnlineListener;
    private final INavigationInputModeManager inputModeManager;
    private final HomeAddressHandler homeAddressHandler;
    private final ADBInterAppService adbInterAppService;
    protected int importedEntries = 0;
    protected boolean memoryErrorAppeard;

    public NaviMyAudiImportImpl(NavigationEnv navigationEnv, ITelService iTelService, ICommandListFactory iCommandListFactory, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPreviewMap iPreviewMap, DispatcherBase dispatcherBase, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.telService = iTelService;
        this.commandListFactory = iCommandListFactory;
        this.rgSequence = iStartGuidanceToDestinationSequence;
        this.previewMap = iPreviewMap;
        this.dispatcher = dispatcherBase;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.homeAddressHandler = homeAddressHandler;
        this.adbInterAppService = aDBInterAppService;
        this.successfulImports = new ArrayList();
        this.unsuccessfulImports = new ArrayList();
        this.importedAdbEntries = new ArrayList();
        this.notImportedAdbEntries = new ArrayList();
        this.myAudiImportContactDetailListener = new NaviMyAudiImportContactDetailListener(navigationEnv, this, iPreviewMap, iCommandListFactory);
        this.initModels();
    }

    private void initModels() {
        this.myAudiResultList = this.env.getBaseListModel(1696663040);
        this.businessAddressListModel = this.env.getListModel(-1927215616);
        this.privateAddressListModel = this.env.getListModel(-1910438400);
        this.telephoneNumbersListModel = this.env.getListModel(-1860106752);
        this.businessAddressAvailableChoice = this.env.getChoiceModel(-1893661184);
        this.privateAddressAvailableChoice = this.env.getChoiceModel(-1876883968);
        this.destOnlineDownloadResultChoice = this.env.getChoiceModel(-1792997888);
        this.destOnlineDownloadResultChoice.setValue(0);
        this.additionalInfoLabel = this.env.getLabelModel(-1843329536);
        this.subTitleLabel = this.env.getLabelModel(-1826552320);
        this.sdsMyAudiList = this.env.getBaseListModel(-1776220672);
        this.sdsMyAudiSubtitleLabel = this.env.getLabelModel(-1759443456);
        this.speller = this.env.getSpellerModel(-551483904);
    }

    public void enterOnlineDestinationHandling() {
        this.logChannel.log(-2137614336, "%1#enterOnlineDestinationHandling", (Object)this.CLASS_NAME);
        this.resetResults();
        this.resetDownloadState();
    }

    public void setAdbHmiAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbHmiAppService = aDBHMIAppService;
    }

    protected void resetResults() {
        this.logChannel.log(-2137614336, "%1#resetResults", (Object)this.CLASS_NAME);
        this.myAudiResultList.removeAll();
        this.adbEntries.clear();
        this.speller.clear();
        this.successfulImports.clear();
        this.unsuccessfulImports.clear();
        this.importedAdbEntries.clear();
        this.notImportedAdbEntries.clear();
    }

    private void resetDownloadState() {
        this.logChannel.log(-2137614336, "%1#resetDownloadState", (Object)this.CLASS_NAME);
        this.destOnlineDownloadResultChoice.setValue(3);
        this.destOnlineDownloadResultChoice.setStatus(1);
    }

    public void portalEntrySelected(long l) {
        this.logChannel.log(-2137614336, "%1#portalEntrySelected - id=%2", (Object)this.CLASS_NAME, l);
        this.fillEntryDetailsModels(this.getAdbEntry(l));
    }

    protected void clearDetailsScreenData() {
        this.logChannel.log(-2137614336, "%1#clearDetailsScreenData()", (Object)this.CLASS_NAME);
        this.businessAddressAvailableChoice.setValue(0);
        this.privateAddressAvailableChoice.setValue(0);
        this.businessAddressListModel.clear();
        this.privateAddressListModel.clear();
        this.telephoneNumbersListModel.clear();
        this.currentSelectedBusinessDestination = null;
        this.currentSelectedPrivateDestination = null;
        this.subTitleLabel.setText("");
    }

    public abstract void fillEntryDetailsModels(OnlineAdbEntry onlineAdbEntry) {
    }

    protected abstract void fillResultListModel(OnlineAdbEntry[] onlineAdbEntryArray) {
    }

    @Override
    public abstract void updateAddressList(OnlineAdbEntry[] onlineAdbEntryArray) {
    }

    public abstract void saveInAddressBook() {
    }

    @Override
    public void storeAddressList(OnlineAdbEntry[] onlineAdbEntryArray, int n, NaviMyAudiImport$IMyAudiImportResultListener naviMyAudiImport$IMyAudiImportResultListener) {
        this.logChannel.log(-2137614336, "%1#storeAddressList - entries.length=%2 resultCode: %3", (Object)this.CLASS_NAME, (long)onlineAdbEntryArray.length, (long)n);
        this.myAudiOnlineListener = naviMyAudiImport$IMyAudiImportResultListener;
        this.previewMap.hidePreviewMap();
        this.resetResults();
        this.fillResultListModel(onlineAdbEntryArray);
        this.destOnlineDownloadResultChoice.setValue(n);
        this.destOnlineDownloadResultChoice.setStatus(1);
        this.search = new NaviMyAudiSearch(this.env, this.adbEntries, this.dispatcher);
    }

    @Override
    public void downloadStarted() {
        this.logChannel.log(1078071040, "%1#downloadStarted", (Object)this.CLASS_NAME);
        this.resetResults();
        this.destOnlineDownloadResultChoice.setValue(3);
        this.destOnlineDownloadResultChoice.setStatus(0);
    }

    public void startSearch(String string) {
        this.myAudiResultList.removeAll();
        this.search.getFilteredList(string, this);
    }

    protected void resultOkWithoutContacts() {
        this.env.getLabelModel(1344407040).setText("0");
        this.env.getLabelModel(1327629824).setText("0");
        this.env.getChoiceModel(1310852608).setValue(1);
    }

    public void checkCurrentImportStatus(long l, boolean bl, boolean bl2, boolean bl3) {
        this.logChannel.log(1078071040, "NaviMyAudiImportImpl#checkCurrentImportStatus %1, success: %2, lastOne: %3", (Object)new Long(l), (Object)new Boolean(bl), (Object)new Boolean(bl2));
        if (bl) {
            this.importedAdbEntries.add(new Long(l));
            ++this.importedEntries;
        } else {
            if (bl3) {
                this.memoryErrorAppeard = true;
            }
            this.notImportedAdbEntries.add(new Long(l));
        }
        if (bl2) {
            this.env.getLabelModel(1344407040).setText(String.valueOf(this.importedEntries));
            this.env.getLabelModel(1327629824).setText(String.valueOf(this.notImportedAdbEntries.size()));
            if (this.memoryErrorAppeard) {
                this.env.getChoiceModel(1310852608).setValue(2);
            } else {
                this.env.getChoiceModel(1310852608).setValue(1);
            }
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NaviMyAudiImportImpl$1(this, this.logChannel));
            commandList.execute("NaviMyAudiImportImpl-sending response to online");
        }
    }

    protected long[] convertyArrayListToArray(ArrayList arrayList) {
        long[] lArray = new long[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            lArray[i2] = (Long)arrayList.get(i2);
        }
        return lArray;
    }

    public OnlineAdbEntry getAdbEntry(long l) {
        this.logChannel.log(-2137614336, "%1#getAdbEntries - id=%2, arraySize=%3", (Object)this.CLASS_NAME, l, (long)this.adbEntries.size());
        if (l >= 0L && l < (long)this.adbEntries.size()) {
            return (OnlineAdbEntry)this.adbEntries.get((int)l);
        }
        return null;
    }

    public void callEntry(String string) {
        this.telService.dialNumber(string, this, true);
    }

    @Override
    public void dialNumberResponse(int n) {
        this.logChannel.log(-2137614336, "%1#dialNumberResponse - result=%2", (Object)this.CLASS_NAME, (long)n);
    }

    public byte[] getCurrentSelectedBusinessDestination() {
        return this.currentSelectedBusinessDestination;
    }

    public byte[] getCurrentSelectedPrivateDestination() {
        return this.currentSelectedPrivateDestination;
    }

    public void startActionToDestination(byte[] byArray) {
        if (byArray != null) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new StreamToLocationCommand(byArray));
            commandList.add(new NaviMyAudiImportImpl$2(this, "Decide if RG to destination / set as homeaddress / send to ADB", byArray));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startActionToDestination").toString());
        } else {
            this.logChannel.log(10000, "%1#startRgToAdbEntry - current destination is null!", (Object)this.CLASS_NAME);
        }
    }

    public NaviMyAudiImport setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        return null;
    }

    static /* synthetic */ NaviMyAudiImport$IMyAudiImportResultListener access$000(NaviMyAudiImportImpl naviMyAudiImportImpl) {
        return naviMyAudiImportImpl.myAudiOnlineListener;
    }

    static /* synthetic */ INavigationInputModeManager access$100(NaviMyAudiImportImpl naviMyAudiImportImpl) {
        return naviMyAudiImportImpl.inputModeManager;
    }

    static /* synthetic */ ADBInterAppService access$200(NaviMyAudiImportImpl naviMyAudiImportImpl) {
        return naviMyAudiImportImpl.adbInterAppService;
    }

    static /* synthetic */ HomeAddressHandler access$300(NaviMyAudiImportImpl naviMyAudiImportImpl) {
        return naviMyAudiImportImpl.homeAddressHandler;
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$400(NaviMyAudiImportImpl naviMyAudiImportImpl) {
        return naviMyAudiImportImpl.rgSequence;
    }

    static {
        EMPTY_PROPERTY_LIST_CELL = PropertyListCell.EMPTY_CELL;
    }
}

