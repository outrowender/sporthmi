/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.atip.preset.IOnlinePresetHandler;
import de.audi.atip.preset.IPresetManager;
import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.BeepHandler;
import de.eso.widgets.preset.IPresetLayoutFactory;
import de.eso.widgets.preset.PresetDefinitionHandlerRegistry;
import de.eso.widgets.preset.PresetExecutionHandlerRegistry;
import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetInputHandler;
import de.eso.widgets.preset.PresetPopupData;
import de.eso.widgets.preset.PresetStorageProvider;
import de.eso.widgets.preset.PresetTimerHandler;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.PresetPopupController;
import java.io.Serializable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PresetManager
implements IPresetManager,
WidgetConstants,
MsgListener {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    public static final int PRESET_NONE;
    public static final int PRESET_1;
    public static final int PRESET_2;
    public static final int PRESET_3;
    public static final int PRESET_4;
    public static final int PRESET_5;
    public static final int PRESET_6;
    public static final int PRESET_7;
    public static final int PRESET_8;
    protected HMITerminalEvo terminal;
    protected PresetDefinitionHandlerRegistry presetDefinitionReg;
    private PresetExecutionHandlerRegistry presetExecutionReg;
    private IFrameworkAccess framework;
    private PresetPopupController presetPopupController;
    private boolean presetPopupVisible = false;
    private BundleContext bundleContext;
    private PresetInputHandler presetInputHandler;
    private PresetStorageProvider presetStorageProvider;
    private ServiceRegistration msgListenerRegisterService;
    private PresetFSM presetFSM;
    private PresetTimerHandler presetTimerHandler;
    private IPresetLayoutFactory presetLayoutFactory;
    private BeepHandler beepHandler;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public PresetManager(HMITerminalEvo hMITerminalEvo, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.terminal = hMITerminalEvo;
        this.framework = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.presetDefinitionReg = new PresetDefinitionHandlerRegistry(this);
        this.presetDefinitionReg.startTracker(bundleContext);
        this.presetExecutionReg = new PresetExecutionHandlerRegistry();
        this.presetExecutionReg.startTracker(bundleContext);
        this.presetStorageProvider = new PresetStorageProvider(iFrameworkAccess);
    }

    public void initialize() {
        this.msgListenerRegisterService = this.bundleContext.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = PresetManager.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this, null);
        this.presetInputHandler = new PresetInputHandler(this);
        this.presetTimerHandler = new PresetTimerHandler(this, this.framework);
        this.presetFSM = new PresetFSM(this);
        this.beepHandler = new BeepHandler(this.bundleContext);
    }

    public IPresetInputHandler getPresetInputHandler() {
        return this.presetInputHandler;
    }

    public BeepHandler getBeepHandler() {
        return this.beepHandler;
    }

    public PresetFSM getPresetFSM() {
        return this.presetFSM;
    }

    public PresetTimerHandler getPresetTimerHandler() {
        return this.presetTimerHandler;
    }

    public PresetStorageProvider getPresetStorageProvider() {
        return this.presetStorageProvider;
    }

    public PresetPopupController getPresetPopupController() {
        if (this.presetPopupController == null) {
            this.presetPopupController = (PresetPopupController)((IPartialPopupManagerEvo)this.terminal.getPartialPopupManager()).getPartialPopup(85);
        }
        return this.presetPopupController;
    }

    void triggerRepaint() {
        if (this.presetPopupController != null) {
            this.presetPopupController.triggerRepaint();
        }
    }

    public void sendDefinitionRequest(int n) {
        lc.log(-2137614336, "PresetManager#sendDefinitionRequest()");
        PresetPopupData presetPopupData = (PresetPopupData)this.terminal.getDrawerFocusManager().getPresetPopupData();
        if (presetPopupData == null) {
            lc.log(1078071040, "PresetManager#sendDefinitionRequest entry is not storable - no request is sent to application, responseDefine is called directly");
            this.setNotStorablePreset(n);
        } else {
            Preset preset = presetPopupData.getPreset();
            switch (preset.getType()) {
                case -1: {
                    lc.log(-2137614336, "PresetManager#sendDefinitionRequest presetType: TYPE_UNDEFINED, cannot store preset");
                    break;
                }
                case 1: {
                    int n2 = preset.getModelId();
                    if (n2 != -1) {
                        Object object;
                        IAppPresetDefinitionHandler iAppPresetDefinitionHandler = this.presetDefinitionReg.getPresetDefinitionHandler(1, n2);
                        if (iAppPresetDefinitionHandler == null && (object = this.presetDefinitionReg.getOnlinePresetHandler()) != null && object.isDynmaicOnlineModel(n2)) {
                            iAppPresetDefinitionHandler = object;
                        }
                        if (iAppPresetDefinitionHandler != null) {
                            this.presetStorageProvider.setPresetPopupDataToStore(n, presetPopupData);
                            object = new DefinitionRequest(this, 1, n2, presetPopupData.getRowID(), 0, null);
                            ((DefinitionRequest)object).setPresetIndex(n);
                            iAppPresetDefinitionHandler.requestDefinition((DefinitionRequest)object);
                            break;
                        }
                        lc.log(1078071040, "PresetManager#sendDefinitionRequest no app preset handler registered for modelID: %1, cannot store preset", (long)n2);
                        this.setNotStorablePreset(n);
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#sendDefinitionRequest presetType: TYPE_APPLICATION, cannot determine model, cannot store preset");
                    this.setNotStorablePreset(n);
                    break;
                }
                case 2: {
                    if (preset.getModelId() != -1) {
                        IAppPresetDefinitionHandler iAppPresetDefinitionHandler = this.presetDefinitionReg.getPresetDefinitionHandler(2, 0);
                        if (iAppPresetDefinitionHandler != null) {
                            DefinitionRequest definitionRequest = new DefinitionRequest(this, 2, 0, 0, 0, null);
                            definitionRequest.setPresetIndex(n);
                            iAppPresetDefinitionHandler.requestDefinition(definitionRequest);
                            break;
                        }
                        lc.log(10000, "PresetManager#sendDefinitionRequest registered for smEventID: %1, cannot store preset", (Object)iAppPresetDefinitionHandler);
                        this.setNotStorablePreset(n);
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#sendDefinitionRequest presetType: TYPE_SETTING, no modelID set, cannot store preset");
                    this.setNotStorablePreset(n);
                    break;
                }
                case 3: {
                    if (preset.getModelId() != -1) {
                        DefinitionRequest definitionRequest = new DefinitionRequest(this, 3, 0, 0, 0, null);
                        definitionRequest.setPresetIndex(n);
                        this.presetDefinitionReg.getPresetDefinitionHandler(3, 0).requestDefinition(definitionRequest);
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#sendDefinitionRequest presetType: TYPE_DIRECT_ACCESS, no modelID set, cannot store preset");
                    break;
                }
                default: {
                    lc.log(-1601830656, "PresetManager#sendDefinitionRequest unknown presetType: %1 ", (long)preset.getType());
                }
            }
        }
    }

    private void setNotStorablePreset(int n) {
        PresetPopupData presetPopupData = this.presetStorageProvider.getNotStorablePopupData();
        this.presetStorageProvider.setPresetPopupDataToStore(n, presetPopupData);
        DefinitionRequest definitionRequest = new DefinitionRequest(this, 0, 0, 0, 0, null);
        definitionRequest.setPresetIndex(n);
        this.responseDefineEvent(definitionRequest, 2, null, presetPopupData.getPreset().getPreview(), 99);
    }

    protected void responseDefineEvent(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        lc.log(-2137614336, "PresetManager#responseDefineEvent called - request=%1, result=%2", (Object)definitionRequest, (long)n);
        if (n == 3) {
            PresetPopupData presetPopupData = this.getPresetStorageProvider().getNotStorablePopupData();
            presetPopupData.setResult(n);
            presetPopupData.setLayoutType(9);
            this.getPresetStorageProvider().setPresetPopupDataToStore(definitionRequest.getPresetIndex(), presetPopupData);
            return;
        }
        if (n == 1 || n == 2) {
            PresetPopupData presetPopupData = this.getPresetStorageProvider().getNotStorablePopupData();
            presetPopupData.setResult(n);
            this.getPresetStorageProvider().setPresetPopupDataToStore(definitionRequest.getPresetIndex(), presetPopupData);
            return;
        }
        PresetPopupData presetPopupData = (PresetPopupData)this.getPresetStorageProvider().getPresetPopupDataToStore(definitionRequest.getPresetIndex());
        if (presetPopupData == null) {
            lc.log(10000, "PresetManager#responseDefineEvent entryToStore is null - response received for unknown preset popup data - preset is not storable");
            return;
        }
        Preset preset = new Preset(definitionRequest.getType(), definitionRequest.getModelId(), definitionRequest.getSMEvent(), presetListRow, serializable, n2);
        presetPopupData.setPreset(preset);
        presetPopupData.setResult(n);
        this.presetStorageProvider.setPresetPopupDataToStore(definitionRequest.getPresetIndex(), presetPopupData);
        presetPopupData.setLayoutType(0);
    }

    boolean handleExecution(int n) {
        IPresetPopupData iPresetPopupData = this.presetStorageProvider.getPersistedPresetPopupData(n);
        if (iPresetPopupData == null || iPresetPopupData.getPreset() == null) {
            lc.log(-1601830656, "PresetManager#handleExecution storedEntryPopupData: %1 or preset is null or presetType is undefined, cannot execute preset", (Object)iPresetPopupData);
            return true;
        }
        Preset preset = iPresetPopupData.getPreset();
        int n2 = preset.getExecutionType();
        IAppPresetExecutionHandler iAppPresetExecutionHandler = this.presetExecutionReg.getPresetExecutionHandler(n2);
        switch (preset.getType()) {
            case -1: {
                lc.log(-2137614336, "PresetManager#handleExecution presetType: TYPE_UNDEFINED, cannot execute preset");
                break;
            }
            case 1: {
                if (n2 != 99) {
                    if (iAppPresetExecutionHandler != null) {
                        iAppPresetExecutionHandler.requestExecute(new ExecuteRequest(this, preset));
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#handleExecution no app preset handler registered for modelID: %1, cannot execute preset", (long)n2);
                    this.setNoAppRegisteredPreset(n);
                    return false;
                }
                lc.log(-1601830656, "PresetManager#handleExecution presetType: TYPE_LIST, cannot determine model, cannot execute preset");
                break;
            }
            case 0: {
                if (preset.getSMEvent() != 0) {
                    if (iAppPresetExecutionHandler != null) {
                        iAppPresetExecutionHandler.requestExecute(new ExecuteRequest(this, preset));
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#handleExecution no statemachine preset handler registered for smEventID: %1, cannot execute preset", (Object)iAppPresetExecutionHandler);
                    break;
                }
                lc.log(-1601830656, "PresetManager#handleExecution presetType: TYPE_SMI, no event set, cannot execute preset");
                break;
            }
            case 2: {
                if (preset.getModelId() != -1) {
                    if (iAppPresetExecutionHandler != null) {
                        iAppPresetExecutionHandler.requestExecute(new ExecuteRequest(this, preset));
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#handleExecution registered for smEventID: %1, cannot execute preset", (Object)iAppPresetExecutionHandler);
                    break;
                }
                lc.log(-1601830656, "PresetManager#handleExecution presetType: TYPE_MAP, no modelID set, cannot execute preset");
                break;
            }
            case 3: {
                if (preset.getModelId() != -1) {
                    if (iAppPresetExecutionHandler != null) {
                        iAppPresetExecutionHandler.requestExecute(new ExecuteRequest(this, preset));
                        break;
                    }
                    lc.log(-1601830656, "PresetManager#handleExecution registered for smEventID: %1, cannot execute preset", (Object)iAppPresetExecutionHandler);
                    break;
                }
                lc.log(-1601830656, "PresetManager#handleExecution presetType: TYPE_CHECKBOX, no modelID set, cannot execute preset");
                break;
            }
            default: {
                lc.log(-1601830656, "PresetManager#handleExecution unknown presetType: %1 ", (long)preset.getType());
            }
        }
        return true;
    }

    private void setNoAppRegisteredPreset(int n) {
        PresetPopupData presetPopupData = this.presetStorageProvider.getNoAppRegisteredPopupData();
        this.presetStorageProvider.setPresetPopupDataToStore(n, presetPopupData);
    }

    private void notifyTouchInputManager(boolean bl) {
        ITouchInputManager iTouchInputManager = this.terminal.getTouchInputManager();
        if (iTouchInputManager != null) {
            iTouchInputManager.presetPopupActive(bl);
        }
    }

    public void showPresetPopup(boolean bl) {
        if (bl) {
            this.terminal.getPartialPopupManager().showPopup(85);
        } else {
            this.terminal.getPartialPopupManager().hidePopup(85);
        }
        this.triggerRepaint();
    }

    public void presetPopupVisible(boolean bl) {
        this.presetPopupVisible = bl;
        if (!this.presetPopupVisible) {
            this.presetTimerHandler.cancelHideDelayTimer();
        }
        this.notifyTouchInputManager(bl);
    }

    @Override
    public void responseDefine(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        if (AbstractWidget.hmiService.getEventDispatcher().isDispatchThread()) {
            this.responseDefineEvent(definitionRequest, n, serializable, presetListRow, n2);
        } else {
            lc.log(10000, "PresetManager#responseExecute callback is not from event-thread! result: %1", (long)n);
        }
    }

    @Override
    public void responseExecute(ExecuteRequest executeRequest, int n) {
        if (AbstractWidget.hmiService.getEventDispatcher().isDispatchThread()) {
            lc.log(-2137614336, "PresetManager#responseExecute result: %1", (long)n);
        } else {
            lc.log(10000, "PresetManager#responseExecute callback is not from event-thread! result: %1", (long)n);
        }
    }

    @Override
    public void favoriteDefinitionChanged(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
    }

    @Override
    public void processMsg(int n) {
        if (n == 34) {
            this.doFactoryReset();
        }
    }

    protected void doFactoryReset() {
        lc.log(1078071040, "PresetManager#doFactoryReset");
        this.presetStorageProvider.reset();
        this.getPresetPopupController();
        if (this.presetPopupController != null) {
            this.presetPopupController.setIconTypes();
        }
    }

    public IPresetLayoutFactory getPresetLayoutFactory() {
        return this.presetLayoutFactory;
    }

    public void setPresetLayoutFactory(IPresetLayoutFactory iPresetLayoutFactory) {
        this.presetLayoutFactory = iPresetLayoutFactory;
    }

    public void saveToPersistence(int n) {
        this.getPresetStorageProvider().saveToPersistence(n);
    }

    public IPresetPopupData updatePreviewIfOnlinePreset(int n) {
        IOnlinePresetHandler iOnlinePresetHandler;
        Preset preset;
        IPresetPopupData iPresetPopupData = this.presetStorageProvider.getPersistedPresetPopupData(n);
        if (iPresetPopupData != null && (preset = iPresetPopupData.getPreset()) != null && PresetManager.isOnlinePreset(preset) && (iOnlinePresetHandler = this.presetDefinitionReg.getOnlinePresetHandler()) != null) {
            preset = iOnlinePresetHandler.updatePresetPreview(preset);
            iPresetPopupData.setPreset(preset);
        }
        return iPresetPopupData;
    }

    protected static boolean isOnlinePreset(Preset preset) {
        return preset.getExecutionType() == 6;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

