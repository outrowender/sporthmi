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
import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.destinationimport.INaviMyAudiSearchCallBack;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportContactDetailListener;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSearch;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;

public abstract class NaviMyAudiImportImpl
implements NaviMyAudiImport,
ITelServiceListener,
INaviMyAudiSearchCallBack {
    public static final int PROPERTY_COLUMN = 2;
    public static final int TEXT_COLUMN = 1;
    public static final int COLUMN_COUNT = 4;
    protected static final int ADDITIONAL_INFO_NOT_AVAILABLE = 0;
    protected static final int ADDITIONAL_INFO_AVAILABLE = 1;
    protected static final PropertyListCell EMPTY_PROPERTY_LIST_CELL = PropertyListCell.EMPTY_CELL;
    protected static final int IMPORT_STATUS_IDLE = 0;
    private static final int IMPORT_STATUS_OK = 1;
    private static final int IMPORT_STATUS_MEMFULL = 2;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
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
    private NaviMyAudiImport.IMyAudiImportResultListener myAudiOnlineListener;
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
        this.myAudiResultList = this.env.getBaseListModel(401765);
        this.businessAddressListModel = this.env.getListModel(401805);
        this.privateAddressListModel = this.env.getListModel(401806);
        this.telephoneNumbersListModel = this.env.getListModel(401809);
        this.businessAddressAvailableChoice = this.env.getChoiceModel(401807);
        this.privateAddressAvailableChoice = this.env.getChoiceModel(401808);
        this.destOnlineDownloadResultChoice = this.env.getChoiceModel(401813);
        this.destOnlineDownloadResultChoice.setValue(0);
        this.additionalInfoLabel = this.env.getLabelModel(401810);
        this.subTitleLabel = this.env.getLabelModel(401811);
        this.sdsMyAudiList = this.env.getBaseListModel(401814);
        this.sdsMyAudiSubtitleLabel = this.env.getLabelModel(401815);
        this.speller = this.env.getSpellerModel(401887);
    }

    public void enterOnlineDestinationHandling() {
        this.logChannel.log(10000000, "%1#enterOnlineDestinationHandling", (Object)this.CLASS_NAME);
        this.resetResults();
        this.resetDownloadState();
    }

    public void setAdbHmiAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbHmiAppService = aDBHMIAppService;
    }

    protected void resetResults() {
        this.logChannel.log(10000000, "%1#resetResults", (Object)this.CLASS_NAME);
        this.myAudiResultList.removeAll();
        this.adbEntries.clear();
        this.speller.clear();
        this.successfulImports.clear();
        this.unsuccessfulImports.clear();
        this.importedAdbEntries.clear();
        this.notImportedAdbEntries.clear();
    }

    private void resetDownloadState() {
        this.logChannel.log(10000000, "%1#resetDownloadState", (Object)this.CLASS_NAME);
        this.destOnlineDownloadResultChoice.setValue(3);
        this.destOnlineDownloadResultChoice.setStatus(1);
    }

    public void portalEntrySelected(long l) {
        this.logChannel.log(10000000, "%1#portalEntrySelected - id=%2", (Object)this.CLASS_NAME, l);
        this.fillEntryDetailsModels(this.getAdbEntry(l));
    }

    protected void clearDetailsScreenData() {
        this.logChannel.log(10000000, "%1#clearDetailsScreenData()", (Object)this.CLASS_NAME);
        this.businessAddressAvailableChoice.setValue(0);
        this.privateAddressAvailableChoice.setValue(0);
        this.businessAddressListModel.clear();
        this.privateAddressListModel.clear();
        this.telephoneNumbersListModel.clear();
        this.currentSelectedBusinessDestination = null;
        this.currentSelectedPrivateDestination = null;
        this.subTitleLabel.setText("");
    }

    public abstract void fillEntryDetailsModels(OnlineAdbEntry var1);

    protected abstract void fillResultListModel(OnlineAdbEntry[] var1);

    public abstract void updateAddressList(OnlineAdbEntry[] var1);

    public abstract void saveInAddressBook();

    public void storeAddressList(OnlineAdbEntry[] onlineAdbEntryArray, int n, NaviMyAudiImport.IMyAudiImportResultListener iMyAudiImportResultListener) {
        this.logChannel.log(10000000, "%1#storeAddressList - entries.length=%2 resultCode: %3", (Object)this.CLASS_NAME, (long)onlineAdbEntryArray.length, (long)n);
        this.myAudiOnlineListener = iMyAudiImportResultListener;
        this.previewMap.hidePreviewMap();
        this.resetResults();
        this.fillResultListModel(onlineAdbEntryArray);
        this.destOnlineDownloadResultChoice.setValue(n);
        this.destOnlineDownloadResultChoice.setStatus(1);
        this.search = new NaviMyAudiSearch(this.env, this.adbEntries, this.dispatcher);
    }

    public void downloadStarted() {
        this.logChannel.log(1000000, "%1#downloadStarted", (Object)this.CLASS_NAME);
        this.resetResults();
        this.destOnlineDownloadResultChoice.setValue(3);
        this.destOnlineDownloadResultChoice.setStatus(0);
    }

    public void startSearch(String string) {
        this.myAudiResultList.removeAll();
        this.search.getFilteredList(string, this);
    }

    protected void resultOkWithoutContacts() {
        this.env.getLabelModel(402000).setText("0");
        this.env.getLabelModel(401999).setText("0");
        this.env.getChoiceModel(401998).setValue(1);
    }

    public void checkCurrentImportStatus(long l, boolean bl, boolean bl2, boolean bl3) {
        this.logChannel.log(1000000, "NaviMyAudiImportImpl#checkCurrentImportStatus %1, success: %2, lastOne: %3", (Object)new Long(l), (Object)new Boolean(bl), (Object)new Boolean(bl2));
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
            this.env.getLabelModel(402000).setText(String.valueOf(this.importedEntries));
            this.env.getLabelModel(401999).setText(String.valueOf(this.notImportedAdbEntries.size()));
            if (this.memoryErrorAppeard) {
                this.env.getChoiceModel(401998).setValue(2);
            } else {
                this.env.getChoiceModel(401998).setValue(1);
            }
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new Command(this.logChannel){

                public void execute() {
                    this.logger.log(1000000, "NaviMyAudiImportImpl#checkCurrentImportStatus execute myAudiResponse");
                    if (NaviMyAudiImportImpl.this.myAudiOnlineListener == null) {
                        this.logger.log(1000000, "NaviMyAudiImportImpl#checkCurrentImportStatus execute myAudiResponse.Listener is null");
                        return;
                    }
                    long[] lArray = NaviMyAudiImportImpl.this.convertyArrayListToArray(NaviMyAudiImportImpl.this.importedAdbEntries);
                    long[] lArray2 = NaviMyAudiImportImpl.this.convertyArrayListToArray(NaviMyAudiImportImpl.this.notImportedAdbEntries);
                    NaviMyAudiImportImpl.this.myAudiOnlineListener.myAudiAdbImportResult(lArray, lArray2);
                    this.getCommandList().commandFinished();
                }
            });
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
        this.logChannel.log(10000000, "%1#getAdbEntries - id=%2, arraySize=%3", (Object)this.CLASS_NAME, l, (long)this.adbEntries.size());
        if (l >= 0L && l < (long)this.adbEntries.size()) {
            return (OnlineAdbEntry)this.adbEntries.get((int)l);
        }
        return null;
    }

    public void callEntry(String string) {
        this.telService.dialNumber(string, this, true);
    }

    public void dialNumberResponse(int n) {
        this.logChannel.log(10000000, "%1#dialNumberResponse - result=%2", (Object)this.CLASS_NAME, (long)n);
    }

    public byte[] getCurrentSelectedBusinessDestination() {
        return this.currentSelectedBusinessDestination;
    }

    public byte[] getCurrentSelectedPrivateDestination() {
        return this.currentSelectedPrivateDestination;
    }

    public void startActionToDestination(final byte[] byArray) {
        if (byArray != null) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new StreamToLocationCommand(byArray));
            commandList.add(new NavCommand("Decide if RG to destination / set as homeaddress / send to ADB"){

                public void execute() {
                    NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                    this.logger.log(10000000, "Streamed Location is %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                    if (NaviMyAudiImportImpl.this.inputModeManager.getInputMode() == 1) {
                        NaviMyAudiImportImpl.this.logChannel.log(10000000, "%1 - send to ADB", (Object)this.CLASS_NAME);
                        NaviMyAudiImportImpl.this.adbInterAppService.getCurrentLocationInputHandler().updateLocation(byArray);
                    } else if (NaviMyAudiImportImpl.this.inputModeManager.getInputMode() == 2) {
                        NaviMyAudiImportImpl.this.logChannel.log(10000000, "%1 - set as home address", (Object)this.CLASS_NAME);
                        NaviMyAudiImportImpl.this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
                    } else {
                        NaviMyAudiImportImpl.this.logChannel.log(10000000, "%1 - start RG", (Object)this.CLASS_NAME);
                        this.getCommandList().commandFinishedWithPostSequence(NaviMyAudiImportImpl.this.rgSequence.getStartSequence(navLocation));
                    }
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startActionToDestination").toString());
        } else {
            this.logChannel.log(10000, "%1#startRgToAdbEntry - current destination is null!", (Object)this.CLASS_NAME);
        }
    }

    public NaviMyAudiImport setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        return null;
    }
}

