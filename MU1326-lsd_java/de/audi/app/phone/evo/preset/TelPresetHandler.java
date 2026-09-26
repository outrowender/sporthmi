/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.preset;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.callstacks.TelEvoCallStackRow;
import de.audi.app.phone.evo.favorite.TelEvoFavoriteListRow;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.app.phone.evo.preset.TelPresetDefinitionContainer;
import de.audi.app.phone.evo.preset.TelPresetHandler$TelPresetServiceImpl;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import java.io.Serializable;
import java.util.Hashtable;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelPresetHandler
extends AbstractPhoneComponent
implements IAppPresetDefinitionHandler,
IAppPresetExecutionHandler {
    private final int[] modelIDs = new int[]{-1365900288, -1718287360, -1349123072, -1533672448, -1516895232, -1500118016, -1483340800, -1466563584, 1402340352};
    private volatile PhoneServiceProvider presetDefinitionHandlerServiceProvider;
    private volatile PhoneServiceProvider presetExecutionHandlerServiceProvider;
    private volatile PhoneServiceProvider telPresetServiceProvider;
    private volatile String mailboxNumber;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelPresetService;

    private static String getMainLabel(String string, String string2) {
        if (string != null && string.length() > 0) {
            return string;
        }
        return string2;
    }

    private static String getSubLabel(String string, String string2) {
        String string3 = TelPresetHandler.getMainLabel(string, string2);
        if (string3 != null && !string3.equals(string2)) {
            return string2;
        }
        return null;
    }

    public TelPresetHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(0x10000100, (IGlobalTelephoneStateListener)this);
        this.presetDefinitionHandlerServiceProvider = new PhoneServiceProvider((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = TelPresetHandler.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.presetDefinitionHandlerServiceProvider.startService();
        this.presetExecutionHandlerServiceProvider = new PhoneServiceProvider((class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = TelPresetHandler.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.presetExecutionHandlerServiceProvider.startService();
        this.telPresetServiceProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelPresetService == null ? (class$de$audi$atip$interapp$phone$ITelPresetService = TelPresetHandler.class$("de.audi.atip.interapp.phone.ITelPresetService")) : class$de$audi$atip$interapp$phone$ITelPresetService).getName(), new TelPresetHandler$TelPresetServiceImpl(this, null), hashtable, this.getApplication().getBundleContext(), this.log);
        this.telPresetServiceProvider.startService();
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(0x10000100, (IGlobalTelephoneStateListener)this);
        if (this.presetDefinitionHandlerServiceProvider != null) {
            this.presetDefinitionHandlerServiceProvider.stopService();
            this.presetDefinitionHandlerServiceProvider = null;
        }
        if (this.presetExecutionHandlerServiceProvider != null) {
            this.presetExecutionHandlerServiceProvider.stopService();
            this.presetExecutionHandlerServiceProvider = null;
        }
        if (this.telPresetServiceProvider != null) {
            this.telPresetServiceProvider.stopService();
            this.telPresetServiceProvider = null;
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x10000100) {
            this.mailboxNumber = iGlobalTelephoneStateStruct.getMailboxNumber();
        } else {
            this.log.log(-1601830656, "[TelPresetHandler#updateGlobalTelephoneStateProperty] unexpected update %1", (Object)GlobalTelephoneState.getAttributeName(n));
        }
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int[] getModelIds() {
        return this.modelIDs;
    }

    @Override
    public int getExecutionType() {
        return 3;
    }

    @Override
    public void requestDefinition(DefinitionRequest definitionRequest) {
        this.log.log(1078071040, "[TelPresetHandler#requestDefinition] request=%1", (Object)definitionRequest);
        int n = definitionRequest.getModelId();
        int n2 = definitionRequest.getRowId();
        switch (n) {
            case 300627: {
                this.requestDefinitionMailbox(definitionRequest, n);
                break;
            }
            case 300718: {
                this.requestDefinitionIntellicallSearchList(definitionRequest, n2);
                break;
            }
            case 300441: {
                this.requestDefinitionCombinedCallStackList(definitionRequest, n2);
                break;
            }
            case 300719: {
                this.requestDefinitionFavoriteSearchList(definitionRequest, n2);
                break;
            }
            case 300708: 
            case 300709: 
            case 300710: 
            case 300711: 
            case 300712: {
                this.requestDefinitionFavoriteList(definitionRequest, n, n2);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelPresetHandler#requestDefinition] unhandled model id %1", (long)n);
            }
        }
    }

    private void requestDefinitionMailbox(DefinitionRequest definitionRequest, int n) {
        String string = this.mailboxNumber;
        if (string != null && string.length() > 0) {
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionMailbox] mailboxNumber=%1", (Object)string);
            this.responseDefinitionOK(definitionRequest, this.getApplication().getTextFactory().getText(0), string, (short)0);
        } else {
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionMailbox] no mailbox number available - preset not possible!");
            this.requestDefinitionNotPossible(definitionRequest);
        }
    }

    private void requestDefinitionFavoriteList(DefinitionRequest definitionRequest, int n, int n2) {
        EvoListRow evoListRow = this.getBaseListModel(n).getRow(n2);
        if (evoListRow != null) {
            TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionFavoriteList] row=%1", (Object)telEvoFavoriteListRow);
            this.responseDefinitionOK(definitionRequest, telEvoFavoriteListRow.getName(), telEvoFavoriteListRow.getNumber(), (short)telEvoFavoriteListRow.getPhoneNumberType());
        } else {
            this.log.log(10000, "[TelPresetHandler#requestDefinitionFavoriteList] row is null, modelId=%1, rowId=%2", (long)n, (long)n2);
        }
    }

    private void responseDefinitionOK(DefinitionRequest definitionRequest, String string, String string2, short s) {
        TelPresetDefinitionContainer telPresetDefinitionContainer = new TelPresetDefinitionContainer(string2, string, s);
        PresetListRow presetListRow = new PresetListRow();
        presetListRow.setMainLabel(TelPresetHandler.getMainLabel(string, string2));
        presetListRow.setSubLabel(TelPresetHandler.getSubLabel(string, string2));
        presetListRow.setSubIconIndex(ADBModelUtils.getIconTypeForPhoneNumber(s));
        definitionRequest.responseDefine(0, telPresetDefinitionContainer, presetListRow, 3);
    }

    private void requestDefinitionFavoriteSearchList(DefinitionRequest definitionRequest, int n) {
        EvoListRow evoListRow = this.getBaseListModel(-1349123072).getRow(n);
        if (evoListRow != null) {
            TelFavoriteSearchResultRow telFavoriteSearchResultRow = (TelFavoriteSearchResultRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionFavoriteSearchList] row=%1", (Object)telFavoriteSearchResultRow);
            this.responseDefinitionOK(definitionRequest, telFavoriteSearchResultRow.getName(), telFavoriteSearchResultRow.getTelephoneNumber(), (short)telFavoriteSearchResultRow.getPhoneNumberType());
        } else {
            this.log.log(10000, "[TelPresetHandler#requestDefinitionFavoriteSearchList] row is null, rowId=%1", (long)n);
        }
    }

    private void requestDefinitionCombinedCallStackList(DefinitionRequest definitionRequest, int n) {
        BaseListRow baseListRow = this.getListModel(-1718287360).getRow(n);
        if (baseListRow != null) {
            TelEvoCallStackRow telEvoCallStackRow = (TelEvoCallStackRow)baseListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionCombinedCallStackList] row=%1", (Object)telEvoCallStackRow);
            CallStackEntry callStackEntry = telEvoCallStackRow.getCallStackEntry();
            this.responseDefinitionOK(definitionRequest, telEvoCallStackRow.getDisplayName(), callStackEntry.getClNumber(), (short)callStackEntry.getAdbNumberType());
        } else {
            this.log.log(10000, "[TelPresetHandler#requestDefinitionCombinedCallStackList] row is null, rowId=%1", (long)n);
        }
    }

    private void requestDefinitionIntellicallSearchList(DefinitionRequest definitionRequest, int n) {
        EvoListRow evoListRow = this.getBaseListModel(-1365900288).getRow(n);
        if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionIntellicallSearchList] row=%1", (Object)intellicallCallStackSearchResultRow);
            CallStackEntry callStackEntry = intellicallCallStackSearchResultRow.getCallStackEntry();
            this.responseDefinitionOK(definitionRequest, callStackEntry.getClName(), callStackEntry.getClNumber(), (short)callStackEntry.getAdbNumberType());
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionIntellicallSearchList] row=%1", (Object)intellicallADBEntryDetailsResultRow);
            this.responseDefinitionOK(definitionRequest, intellicallADBEntryDetailsResultRow.getName(), intellicallADBEntryDetailsResultRow.getNumber(), intellicallADBEntryDetailsResultRow.getPhoneNumberType());
        } else if (evoListRow instanceof IntellicallADBSearchResultRow) {
            IntellicallADBSearchResultRow intellicallADBSearchResultRow = (IntellicallADBSearchResultRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionIntellicallSearchList] row=%1", (Object)intellicallADBSearchResultRow);
            definitionRequest.responseDefine(3, null, null, 3);
        } else if (evoListRow instanceof IntellicallFavoriteSearchResultRow) {
            IntellicallFavoriteSearchResultRow intellicallFavoriteSearchResultRow = (IntellicallFavoriteSearchResultRow)evoListRow;
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionIntellicallSearchList] row=%1", (Object)intellicallFavoriteSearchResultRow);
            this.responseDefinitionOK(definitionRequest, intellicallFavoriteSearchResultRow.getName(), intellicallFavoriteSearchResultRow.getTelephoneNumber(), (short)intellicallFavoriteSearchResultRow.getPhoneNumberType());
        } else {
            this.log.log(1078071040, "[TelPresetHandler#requestDefinitionIntellicallSearchList] not possible for row %1", (Object)evoListRow);
            this.requestDefinitionNotPossible(definitionRequest);
        }
    }

    public void requestDefinitionNotPossible(DefinitionRequest definitionRequest) {
        definitionRequest.responseDefine(2, null, null, 3);
    }

    @Override
    public void requestExecute(ExecuteRequest executeRequest) {
        this.log.log(1078071040, "[TelPresetHandler#requestExecute] request=%1", (Object)executeRequest);
        Serializable serializable = executeRequest.getPreset().getData();
        if (serializable instanceof TelPresetDefinitionContainer) {
            TelPresetDefinitionContainer telPresetDefinitionContainer = (TelPresetDefinitionContainer)serializable;
            this.log.log(1078071040, "[TelPresetHandler#requestExecute] dialing container=%1", (Object)telPresetDefinitionContainer);
            this.getApplication().getTelephoneDSIAccess().dialNumber(telPresetDefinitionContainer.getNumber(), 0);
        } else {
            this.log.log(-1601830656, "[TelPresetHandler#requestExecute] container format unknown: %1", (Object)serializable);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$100(TelPresetHandler telPresetHandler) {
        return telPresetHandler.log;
    }

    static /* synthetic */ LogChannel access$200(TelPresetHandler telPresetHandler) {
        return telPresetHandler.log;
    }

    static /* synthetic */ void access$300(TelPresetHandler telPresetHandler, DefinitionRequest definitionRequest, String string, String string2, short s) {
        telPresetHandler.responseDefinitionOK(definitionRequest, string, string2, s);
    }
}

