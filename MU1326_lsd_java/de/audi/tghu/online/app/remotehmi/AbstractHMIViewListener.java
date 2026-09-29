/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$RRDListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IPageHistory;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener$1;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener$SoftkeyButtonListener;
import de.audi.tghu.online.app.remotehmi.ArrayUtilities;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.PageHistory;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.UpdateRrdTask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractHMIViewListener
implements ButtonListener,
NaviOnlineService$RRDListener {
    public static final int INVISIBLE;
    public static final int VISIBLE;
    private static final int MAX_TEXT_LENGTH;
    protected final LogChannel logChannel;
    protected final ModelGroup mainModelGroup;
    protected final OnlineModelBankAccess modelBank;
    protected final HMIService hmiService;
    protected VirtualButtonListener hkReturnVirtualButtonListener;
    private ButtonModelApp[] skButtonModels = null;
    protected String[] selectedIds = null;
    protected String[] skIds;
    private String returnId;
    protected final RemoteHMIService remoteHmiService;
    private boolean subtitleChangedInUpdate = false;
    private int lastSelectedSK = 0;
    private boolean receiveMediaUpdates = false;
    private boolean takeScreenshotFor3D = false;
    private AbstractHMIViewListener$SoftkeyButtonListener softkeyButtonListener;
    private List viewDataTypes;
    private ICursor defaultCursor;

    public AbstractHMIViewListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.mainModelGroup = modelGroup;
        this.modelBank = onlineModelBankAccess;
        this.hmiService = hMIService;
        this.remoteHmiService = remoteHMIService;
        this.hkReturnVirtualButtonListener = new AbstractHMIViewListener$1(this);
    }

    protected VirtualButtonModelApp getVirtualButton() {
        return this.modelBank.getVirtualButtonModel(-954719488);
    }

    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        Object object;
        Object object2;
        VirtualButtonModelApp virtualButtonModelApp = this.modelBank.getVirtualButtonModel(-954719488);
        virtualButtonModelApp.setVirtualButtonListener(this.hkReturnVirtualButtonListener);
        if (hMIProperties.contains("colorChoice")) {
            this.modelBank.getChoiceModel(-1525144832).setValue(hMIProperties.getInt("colorChoice"));
        }
        if (hMIProperties.contains("npsConfiguration")) {
            object2 = (int[])hMIProperties.get("npsConfiguration");
            if (object2 == null || ((int[])object2).length == 0) {
                this.logChannel.log(-1601830656, "AbstractHMIViewListener##updateViewProperties npsLineTextOrder is null or empty so can't replace the default order");
                return;
            }
            object = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
            if (object == null) {
                this.logChannel.log(-1601830656, "AbstractHMIViewListener##updateViewProperties viewNpsListener is null or empty, so can't replace the given order");
                return;
            }
            this.logChannel.log(1078071040, "AbstractHMIViewListener##updateViewProperties: order recieved for nps is %1", object2);
            object.getMediaValues().setTextLineOrder((int[])object2);
            object.updateMetadataValues();
        }
        if (hMIProperties.contains("efiLink")) {
            object2 = hMIProperties.getString("efiLink");
            this.remoteHmiService.getEfiComponent().updateEfiLink((String)object2);
        }
        this.returnId = hMIProperties.contains("returnId") ? hMIProperties.getString("returnId") : null;
        if (hMIProperties.contains("openMedia")) {
            object2 = hMIProperties.getString("openMedia");
            if ("bluetooth".equals(object2)) {
                this.activateBluetoothAudio();
            } else {
                Object object3;
                object = hMIProperties.getString("openMediaType");
                if (object == null || ((String)object).length() == 0 || !((String)object).equals("video") && !((String)object).equals("audio")) {
                    object = "audio";
                }
                if (((String)(object3 = object2)).length() == 0) {
                    this.stopMediaFile();
                } else {
                    this.playMediaFile((String)object3, (String)object);
                }
            }
        }
        if (hMIProperties.contains("tts")) {
            boolean bl2 = false;
            if (hMIProperties.contains("ttsStop")) {
                bl2 = hMIProperties.getBoolean("ttsStop");
            }
            if ((object = this.getTextMaxLen("tts", hMIProperties)) == null || ((String)object).length() == 0) {
                bl2 = true;
            }
            this.remoteHmiService.getTTS().startTts((String)object, bl2, bl);
        }
        this.setUpdatingIconVisible(hMIProperties.getBoolean("updating"), remoteHMIContext.getContextName());
        this.showProviderLogo(hMIProperties);
        this.setScrollIndex(hMIProperties);
        this.receiveMediaUpdates = hMIProperties.contains("mediaProcessPosition") ? hMIProperties.getBoolean("mediaProcessPosition") : false;
        this.takeScreenshotFor3D = hMIProperties.contains("mibTakeScreenshot") ? hMIProperties.getBoolean("mibTakeScreenshot") : false;
    }

    public int setScrollIndex(HMIProperties hMIProperties) {
        int n = hMIProperties.getInt("scrollIndex");
        this.logChannel.log(1078071040, "AbstractHMIViewListener#setScrollIndex() was called with index %1.", (long)n);
        return n;
    }

    public void showProviderLogo(HMIProperties hMIProperties) {
        String string = hMIProperties.getString("providerLogo");
        this.remoteHmiService.getContextManagerComponent().showProviderLogo(string);
    }

    public void setUpdatingIconVisible(boolean bl, String string) {
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("updating", bl);
        hMIProperties.put("appContextName", string);
        hMIProperties.put("actionData", "updateView");
        this.remoteHmiService.indicateCommand(570, hMIProperties);
    }

    protected void setTitles(LabelModelApp labelModelApp, LabelModelApp labelModelApp2, HMIProperties hMIProperties) {
        this.setTitles(null, null, labelModelApp, labelModelApp2, hMIProperties);
    }

    protected void setTitles(int n, int n2, int n3, int n4, HMIProperties hMIProperties) {
        LabelModelApp labelModelApp = n > 0 ? this.modelBank.getLabelModel(n) : null;
        ResourceLocatorModelApp resourceLocatorModelApp = n2 > 0 ? this.modelBank.getResourceLocatorModel(n2) : null;
        LabelModelApp labelModelApp2 = n3 > 0 ? this.modelBank.getLabelModel(n3) : null;
        LabelModelApp labelModelApp3 = n4 > 0 ? this.modelBank.getLabelModel(n4) : null;
        this.setTitles(labelModelApp, resourceLocatorModelApp, labelModelApp2, labelModelApp3, hMIProperties);
    }

    protected void setTitles(LabelModelApp labelModelApp, ResourceLocatorModelApp resourceLocatorModelApp, LabelModelApp labelModelApp2, LabelModelApp labelModelApp3, HMIProperties hMIProperties) {
        String[] stringArray;
        if (labelModelApp != null) {
            stringArray = hMIProperties.contains("title") ? hMIProperties.getString("title") : "";
            labelModelApp.setText((String)stringArray);
            this.logChannel.log(1078071040, "AbstractHMIViewListene#setTitles: update title: %1", (Object)stringArray);
        }
        if (resourceLocatorModelApp != null) {
            stringArray = hMIProperties.contains("titleIcon") ? hMIProperties.getString("titleIcon") : "";
            resourceLocatorModelApp.setResourceLocator(-1, (String)stringArray);
            int n = stringArray != null && stringArray.length() > 0 ? 1 : 0;
            resourceLocatorModelApp.setStatus(n);
            this.logChannel.log(-2137614336, "AbstractHMIViewListene#setTitles: update icon: %1", (long)n);
        }
        stringArray = hMIProperties.getStringArray("subtitle");
        String string = ArrayUtilities.getSafeArrayValue(stringArray, 0);
        String string2 = ArrayUtilities.getSafeArrayValue(stringArray, 1);
        if (labelModelApp2 != null) {
            this.logChannel.log(1078071040, "AbstractHMIViewListene#setTitles: subtitle: '%1'", (Object)string);
            labelModelApp2.setText(string);
        } else {
            this.logChannel.log(1078071040, "AbstractHMIViewListene#setTitles: subtitlemodel is null! subtitle: '%1'", (Object)string);
        }
        if (labelModelApp3 != null) {
            labelModelApp3.setText(string2);
        }
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(-1491590400);
        int n = choiceModelApp.getValue();
        int n2 = string.length() == 0 ? 0 : 1;
        boolean bl = this.subtitleChangedInUpdate = n2 != n;
        if (this.subtitleChangedInUpdate) {
            choiceModelApp.setValue(n2);
        }
    }

    protected void showPartialPopup(HMIProperties hMIProperties) {
        if (hMIProperties.contains("pptexts")) {
            String[] stringArray = hMIProperties.getStringArray("pptexts");
            if (stringArray.length > 0 && stringArray[0] != null && stringArray[0].length() > 0) {
                String string = stringArray[0];
                this.modelBank.getLabelModel(214).setText(string);
                if (stringArray.length > 1) {
                    this.modelBank.getLabelModel(215).setText(stringArray[1]);
                } else {
                    this.modelBank.getLabelModel(215).setText("");
                }
                this.logChannel.log(1078071040, "AbstractHMIViewListener#showPartialPopup: showing partial popup");
            } else {
                this.logChannel.log(-1601830656, "AbstractHMIViewListener#showPartialPopup: not showing partial popup, because text1 is empty.");
            }
        }
    }

    public void keyPressedVirtualButton(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#keyPressedVirtualButton keyID '%1' modelID '%2'", (long)n2, (long)n);
        RemoteHMIAction remoteHMIAction = null;
        int n4 = this.isDefaultCursorAvailable() ? this.getOldCursor().getFocus().getIndex() : -1;
        String string = this.getSelectedId(n4);
        if (n2 == 15) {
            String string2 = this.getReturnId();
            this.invokeAction(104, n4, string, string2);
            return;
        }
        if (n2 == 17) {
            this.invokeAction(300, n4, string, string);
            return;
        }
        switch (n) {
            case 2300103: {
                this.invokeAction(remoteHMIAction);
                this.logChannel.log(-2137614336, "AbstractHMIViewListener#keyPressedVirtualButton DSIRemoteHMI.action('%1')", remoteHMIAction);
                break;
            }
        }
    }

    protected String getReturnId() {
        if (this.returnId == null) {
            return "";
        }
        return this.returnId;
    }

    protected void stopMediaFile() {
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#stopMediaFile: called");
        this.remoteHmiService.getMediaHandler().abort();
    }

    protected void playMediaFile(String string, String string2) {
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#playMediaFile file '%1'", (Object)string);
        this.remoteHmiService.getMediaHandler().abort();
        try {
            this.remoteHmiService.getMediaHandler().play(string, string2, this);
        }
        catch (Exception exception) {
            this.logChannel.log(-2137614336, "AbstractHMIViewListener#playMediaFile Exception (%1)", (Throwable)exception);
        }
    }

    public void activateBluetoothAudio() {
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#activateBluetoothAudio");
        this.remoteHmiService.getMediaHandler().activateBluetooth();
    }

    protected void invokeAction(RemoteHMIAction remoteHMIAction) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "AbstractHMIViewListener#invokeAction: RemoteHMIContext is null! Last action cannot be saved!");
        } else {
            remoteHMIContext.setLastAction(remoteHMIAction);
        }
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    public void onExit() {
    }

    protected void setSoftkeys(int[] nArray, int n, HMIProperties hMIProperties) {
        int n2;
        Object[] objectArray;
        int n3;
        this.lastSelectedSK = n3 = hMIProperties.getInt("softkeyHighlighted");
        if (nArray != null) {
            if (hMIProperties.getStringArray("softkey").length > 3) {
                objectArray = hMIProperties.getStringArray("softkey");
                for (n2 = 0; n2 < 4; ++n2) {
                    this.modelBank.getLabelModel(nArray[n2]).setText(objectArray[n2]);
                }
                if (n > 0) {
                    this.modelBank.getChoiceModel(n).setValue(n3);
                }
            } else {
                for (int i2 = 0; i2 < 4; ++i2) {
                    this.modelBank.getLabelModel(nArray[i2]).setText("");
                }
                if (n > 0) {
                    this.modelBank.getChoiceModel(n).setValue(0);
                }
            }
        } else if (n != -1) {
            this.modelBank.getChoiceModel(n).setValue(0);
        }
        if (this.skButtonModels != null) {
            objectArray = hMIProperties.getBooleanArray("softkeyEnabled");
            for (n2 = 0; n2 < this.skButtonModels.length; ++n2) {
                if (this.skButtonModels.length > n2 && this.skButtonModels[n2] != null && objectArray != null && objectArray.length > n2) {
                    this.skButtonModels[n2].setStatus(objectArray[n2] != false ? 1 : 0);
                    continue;
                }
                this.skButtonModels[n2].setStatus(1);
            }
        }
        this.skIds = null;
        if (hMIProperties.getStringArray("softkeyIds") != null) {
            this.skIds = hMIProperties.getStringArray("softkeyIds");
        }
        if (this.skIds == null || this.skIds.length != 4) {
            this.skIds = new String[4];
        }
    }

    protected void configureSoftkeyModels(int[] nArray) {
        this.softkeyButtonListener = new AbstractHMIViewListener$SoftkeyButtonListener(this, nArray);
        this.skButtonModels = new ButtonModelApp[4];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            ButtonModelApp buttonModelApp;
            this.skButtonModels[i2] = buttonModelApp = this.modelBank.getButtonModel(nArray[i2]);
            buttonModelApp.setButtonListener(this.softkeyButtonListener);
        }
    }

    public String getSelectedSkID(int n) {
        return this.softkeyButtonListener.getSelectedSkID(n);
    }

    public void invokeSoftkeyAction(int n, String string) {
        int n2 = this.isDefaultCursorAvailable() ? this.getOldCursor().getFocus().getIndex() : -1;
        this.invokeAction(n, n2, this.getSelectedId(n2), string);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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

    protected String getTextMaxLen(String string, HMIProperties hMIProperties) {
        String string2 = hMIProperties.getString(string);
        if (string2 == null) {
            string2 = "";
        } else if (string2.length() > 2000) {
            string2 = string2.substring(0, 2000);
        }
        return string2;
    }

    protected void setSelectedIds(String[] stringArray) {
        this.selectedIds = stringArray;
    }

    protected String getSelectedId(int n) {
        if (n < 0) {
            return "";
        }
        if (this.selectedIds == null || n >= this.selectedIds.length || this.selectedIds[n] == null) {
            return "";
        }
        return this.selectedIds[n];
    }

    public String[] getSkIDs() {
        return this.skIds;
    }

    public boolean isSubtitleChangedInUpdate() {
        return this.subtitleChangedInUpdate;
    }

    public int getSelectedSoftkey() {
        return this.lastSelectedSK;
    }

    public synchronized boolean getReceiveMediaUpdates() {
        return this.receiveMediaUpdates;
    }

    protected void invokeActionItemSelected(int n) {
        this.invokeAction(300, n, this.getSelectedId(n), this.getSelectedId(n));
    }

    protected RemoteHMIAction createAction(int n, int n2, String string, String string2) {
        return this.createAction(n, n2, string, 0, string2);
    }

    protected RemoteHMIAction createAction(int n, int n2, String string, int n3, String string2) {
        RemoteHMIAction remoteHMIAction = this.getAction(n);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putInt("selectedNumber", n2);
        hMIProperties.putString("selectedId", string);
        hMIProperties.putInt("selectedPullDownElementNr", n3);
        hMIProperties.putString("actionId", string2);
        return remoteHMIAction;
    }

    protected void invokeAction(int n, int n2, String string, String string2) {
        this.logChannel.log(1078071040, "AbstractHMIViewListener#invokeAction: create action with actionType=%1, selectedNr=%2, selectedId=%3, actionId=%2", (Object)new Integer(n), (Object)new Integer(n2), (Object)string, (Object)string2);
        RemoteHMIAction remoteHMIAction = this.createAction(n, n2, string, string2);
        this.invokeAction(remoteHMIAction);
    }

    protected void enableSDSLineNumbers(HMIProperties hMIProperties, ChoiceModelApp choiceModelApp) {
        int n = 0;
        if (hMIProperties != null && hMIProperties.contains("lineNumbers")) {
            n = hMIProperties.getBoolean("lineNumbers") ? 1 : 0;
        }
        choiceModelApp.setValue(n);
    }

    public synchronized boolean isTakeScreenshotView() {
        return this.takeScreenshotFor3D;
    }

    protected void checkNaviOperable(NaviOnlineService naviOnlineService) {
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(303768320);
        if (naviOnlineService == null || !naviOnlineService.getIsNaviFullyOperable()) {
            this.logChannel.log(1078071040, "AbstractHMIViewListener#checkNaviOperable: navigation NOT fully operable, show ERROR screen");
            choiceModelApp.setValue(0);
        } else {
            this.logChannel.log(1078071040, "AbstractHMIViewListener#checkNaviOperable: navigation fully operable");
            choiceModelApp.setValue(1);
        }
        ButtonModelApp buttonModelApp = this.modelBank.getButtonModel(320545536);
        buttonModelApp.setButtonListener(this);
    }

    public ICursor getOldCursor() {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1000, "AbstractHMIViewListener#getOldCursor: RemoteHMIContext is null! Cursor position cannot be determined!");
            return this.getDefaultCursor();
        }
        ICursor iCursor = remoteHMIContext.getOldCursor();
        return iCursor == null ? this.getDefaultCursor() : iCursor;
    }

    public void setNewCursor(ICursor iCursor) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1000, "AbstractHMIViewListener#setNewCursor: RemoteHMIContext is null! Cursor position cannot be changed!");
            return;
        }
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#setNewCursor: cursor=%1 context = %2", (Object)iCursor, (Object)remoteHMIContext);
        remoteHMIContext.setNewCursor(iCursor);
    }

    public boolean hasCursor() {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1000, "AbstractHMIViewListener#hasCursor: RemoteHMIContext is null! Cursor position cannot be determined!");
            return false;
        }
        return remoteHMIContext.hasCursor();
    }

    public ICursor getDefaultCursor() {
        if (this.defaultCursor == null) {
            throw new IllegalStateException("You must set the default cursor first before you can retrieve it!");
        }
        return this.defaultCursor;
    }

    public void setDefaultCursor(ICursor iCursor) {
        this.defaultCursor = iCursor;
    }

    public boolean isDefaultCursorAvailable() {
        return this.defaultCursor != null;
    }

    public int getLastActionType() {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1000, "AbstractHMIViewListener#getLastActionType: RemoteHMIContext is null! Last action cannot be determined!");
            return 0;
        }
        return remoteHMIContext.getLastActionType();
    }

    public void onApplicationExit(RemoteHMIContext remoteHMIContext) {
    }

    public List getViewDataTypes() {
        return this.viewDataTypes;
    }

    public void setViewDataTypes(List list) {
        this.viewDataTypes = list;
    }

    public void renderGridList(int n, int n2) {
    }

    public IGridList getCurrentGridList() {
        return null;
    }

    public boolean isTriggerScreenChange() {
        return true;
    }

    public boolean isModelGroupLockEnabled() {
        return false;
    }

    protected void setNowPlayingScreenMode(int n) {
        this.hmiService.getChoiceModel(-2011421952).setValue(n);
    }

    @Override
    public void updateRrdItems(List list) {
        this.logChannel.log(1078071040, "AbstractHMIViewListener#updateRrdItems: received list %1", (long)((Object)list).hashCode());
        this.remoteHmiService.execute(new UpdateRrdTask(list, false, this));
    }

    protected ICursor correctListState(IGridList iGridList, boolean bl, RemoteHMIContext remoteHMIContext, ContextManagerComponent contextManagerComponent, IGridFactory iGridFactory) {
        ICursor iCursor;
        ICursor iCursor2 = iGridList.getInitialCursor();
        int n = remoteHMIContext.getLastActionType();
        boolean bl2 = n == 104 || n == 400 || n == -2104059904;
        boolean bl3 = remoteHMIContext.hasCursor() && (!bl || bl2);
        boolean bl4 = iCursor2.isForceUpdate() || contextManagerComponent.isTransitionToInclude();
        String string = remoteHMIContext.getContextName();
        if (bl3 && !bl4) {
            iCursor = remoteHMIContext.getOldCursor();
            this.logChannel.log(1078071040, "AbstractHMIViewListener#correctListState: (%1) restoring old cursor %2, (actionType %3, %4)", (Object)string, (Object)iCursor, (Object)new Integer(n), (Object)(bl ? "initial list " : "not initial list"));
            if (remoteHMIContext.hasPageHistory() && iGridList.isRestoreHistoryDataActive()) {
                iGridList = this.restorePageHistory(iGridList);
            }
        } else {
            if (bl3 && bl4) {
                this.logChannel.log(1078071040, "AbstractHMIViewListener#correctListState: (%1) veto: %2, %3", (Object)string, (Object)(iCursor2.isForceUpdate() ? "initial cursor force update" : "-"), (Object)(contextManagerComponent.isTransitionToInclude() ? "transition to include" : "-"));
            }
            if (iGridList.isRestoreHistoryDataActive()) {
                remoteHMIContext.setPageHistory(this.getNewPageHistory(iGridList));
            }
            iCursor = iGridList.getInitialCursor();
            this.logChannel.log(1078071040, "AbstractHMIViewListener#correctListState: (%1) restoring initial cursor %2 (actionType %3, %4)", (Object)string, (Object)iCursor, (Object)Util.createInteger(n), (Object)(bl4 ? "veto" : "no veto"));
        }
        ICursorComponent iCursorComponent = iGridList.getCorrectedFocus(iCursor.getFocus());
        ICursorComponent iCursorComponent2 = iGridList.getCorrectedSelection(iCursor.getSelection());
        ICursor iCursor3 = iGridFactory.createCursor(iCursorComponent, iCursorComponent2);
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#correctListState: (%1) correcting cursor to %2", (Object)string, (Object)iCursor);
        return iCursor3;
    }

    protected IPageHistory getNewPageHistory(IGridList iGridList) {
        PageHistory pageHistory = new PageHistory(this.logChannel);
        if (iGridList == null) {
            this.logChannel.log(10000, "AbstractHMIViewListener#getNewPageHistory: The given grid list should not be NULL");
            return pageHistory;
        }
        this.logChannel.log(1078071040, "AbstractHMIViewListener#getNewPageHistory: creating new PageHistory!");
        ListIterator listIterator = iGridList.listIterator();
        while (listIterator.hasNext()) {
            IGrid iGrid = (IGrid)listIterator.next();
            pageHistory.setExpansionState(iGrid.getId(), listIterator.previousIndex(), iGrid.isExpanded());
        }
        return pageHistory;
    }

    protected IPageHistory getOldPageHistory() {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "AbstractHMIViewListener#getOldPageHistory: RemoteHMIContext is null! Cursor position cannot be determined!");
            return new PageHistory(this.logChannel);
        }
        IPageHistory iPageHistory = remoteHMIContext.getPageHistory();
        return iPageHistory == null ? new PageHistory(this.logChannel) : iPageHistory;
    }

    protected void updatePageHistory(String string, int n, boolean bl) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "AbstractHMIViewListener#updatePageHistory: RemoteHMIContext is null! Cursor position cannot be determined!");
            return;
        }
        this.logChannel.log(1078071040, "AbstractHMIViewListener#updatePageHistory: Updating expansion state!");
        IPageHistory iPageHistory = remoteHMIContext.getPageHistory();
        iPageHistory.setExpansionState(string, n, bl);
        remoteHMIContext.setPageHistory(iPageHistory);
    }

    protected IGridList restorePageHistory(IGridList iGridList) {
        IPageHistory iPageHistory = this.getOldPageHistory();
        this.logChannel.log(1078071040, "AbstractHMIViewListener#restorePageHistory: restoring PageHistory!");
        iPageHistory.restoreToGrid(iGridList);
        return iGridList;
    }

    public void updateLockingState(boolean bl) {
        this.logChannel.log(1078071040, "AbstractHMIViewListener#updateLockingState: not implemented. locking: %1", bl);
    }
}

