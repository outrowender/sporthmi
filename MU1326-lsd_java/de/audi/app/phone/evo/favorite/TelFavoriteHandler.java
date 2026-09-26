/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.adb.ITelADBHandlerListener;
import de.audi.app.phone.core.interapp.TelMessagingServiceHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.favorite.ITelFavoriteHandler;
import de.audi.app.phone.evo.favorite.TelEvoFavoriteListRow;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler$FactoryResetHandler;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler$TelFavoritesDiag;
import de.audi.app.phone.evo.favorite.TelFavoriteListHandler;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchDataProvider;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchModelHandler;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchResultRow;
import de.audi.atip.favorite.FavoritePersistenceHandlerBase;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.PhoneServiceListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import de.audi.atip.phone.ITelServiceSDSListener$TelFavoriteSDSListEntry;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.ProfileInfo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelFavoriteHandler
extends AbstractEvoPhoneComponent
implements IPhoneDiagComponent,
ITelFavoriteHandler,
OptionModelListener,
ButtonListener,
ITelADBHandlerListener,
SpellerListener,
ServiceTrackerCustomizer {
    private static final int PERSISTENCE_CONTAINER_VERSION;
    private static final int SPELLER_STATUS_ENABLE;
    private static final int SPELLER_STATUS_DISABLE;
    private static long nextUniqueID;
    private static final int PROFILE_ID_UNKNOWN;
    private static final int MAX_PROFILES;
    private final TelFavoriteListHandler[] listHandlers = new TelFavoriteListHandler[5];
    private volatile TelFavoriteListHandler activeListHandler;
    private volatile TelFavoriteStruct favoriteToSave;
    private volatile int activeProfileID = -1;
    private volatile TelFavoriteSearchDataProvider searchProvider;
    private volatile PhoneServiceListener sdsPhoneServiceListener;
    private volatile PhoneServiceTracker sdsPhoneServiceListenerTracker;
    private volatile CombiBAPServicePhone combiService;
    private volatile PhoneServiceTracker combiServiceTracker;
    private volatile EvoListRow favoriteToBeRenamed;
    private final TelMessagingServiceHandler messagingServiceHandler;
    private final TelFavoriteSearchModelHandler searchModelHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone;

    static synchronized long getNextUniqueID() {
        long l = nextUniqueID;
        long l2 = l;
        nextUniqueID = l + 1L;
    }

    public TelFavoriteHandler(ITelEvoApplication iTelEvoApplication, ITelDSISearchAccess iTelDSISearchAccess) {
        super(iTelEvoApplication, "App.Phone.Main");
        this.messagingServiceHandler = new TelMessagingServiceHandler(iTelEvoApplication);
        this.addSubPhoneComponent(this.messagingServiceHandler);
        this.searchModelHandler = new TelFavoriteSearchModelHandler((ITelApplication)iTelEvoApplication, iTelDSISearchAccess);
        this.addSubPhoneComponent(this.searchModelHandler);
        this.addSubPhoneComponent(new TelFavoriteHandler$FactoryResetHandler(this, iTelEvoApplication));
    }

    private void initListHandlers(ITelEvoApplication iTelEvoApplication) {
        this.listHandlers[0] = new TelFavoriteListHandler(iTelEvoApplication, new FavoritePersistenceHandlerBase(iTelEvoApplication.getFrameworkAccess().getStorageMgr(), 0, 1003, 2305, this.log), this.getBaseListModel(-1533672448), this.log, this);
        this.listHandlers[1] = new TelFavoriteListHandler(iTelEvoApplication, new FavoritePersistenceHandlerBase(iTelEvoApplication.getFrameworkAccess().getStorageMgr(), 0, 1003, 257, this.log), this.getBaseListModel(-1516895232), this.log, this);
        this.listHandlers[2] = new TelFavoriteListHandler(iTelEvoApplication, new FavoritePersistenceHandlerBase(iTelEvoApplication.getFrameworkAccess().getStorageMgr(), 0, 1003, 769, this.log), this.getBaseListModel(-1500118016), this.log, this);
        this.listHandlers[3] = new TelFavoriteListHandler(iTelEvoApplication, new FavoritePersistenceHandlerBase(iTelEvoApplication.getFrameworkAccess().getStorageMgr(), 0, 1003, 1281, this.log), this.getBaseListModel(-1483340800), this.log, this);
        this.listHandlers[4] = new TelFavoriteListHandler(iTelEvoApplication, new FavoritePersistenceHandlerBase(iTelEvoApplication.getFrameworkAccess().getStorageMgr(), 0, 1003, 1793, this.log), this.getBaseListModel(-1466563584), this.log, this);
    }

    @Override
    public void init() {
        super.init();
        if (this.getApplication().getFrameworkAccess().getSysConst(523) == 1) {
            this.searchProvider = new TelFavoriteSearchDataProvider(this.getApplication());
            this.searchProvider.init();
        }
        this.initListHandlers(this.getEvoApplication());
        this.getApplication().addDiagnosisComponent(new TelFavoriteHandler$TelFavoritesDiag(this, null));
        this.getApplication().getADBHandler().registerListener(this);
        this.getOptionModel(-1734999040).setListener(this, -1533672448);
        this.getOptionModel(-1734999040).setListener(this, -1516895232);
        this.getOptionModel(-1734999040).setListener(this, -1500118016);
        this.getOptionModel(-1734999040).setListener(this, -1483340800);
        this.getOptionModel(-1734999040).setListener(this, -1466563584);
        this.getOptionModel(-1734999040).setListener(this, -1349123072);
        this.getButtonModel(-728366080).setButtonListener(this);
        this.getOptionModel(-795474944).setListener(this, -1533672448);
        this.getOptionModel(-795474944).setListener(this, -1516895232);
        this.getOptionModel(-795474944).setListener(this, -1500118016);
        this.getOptionModel(-795474944).setListener(this, -1483340800);
        this.getOptionModel(-795474944).setListener(this, -1466563584);
        this.getOptionModel(-795474944).setListener(this, -1349123072);
        this.getOptionModel(680985600).setListener(this, -1533672448);
        this.getOptionModel(680985600).setListener(this, -1516895232);
        this.getOptionModel(680985600).setListener(this, -1500118016);
        this.getOptionModel(680985600).setListener(this, -1483340800);
        this.getOptionModel(680985600).setListener(this, -1466563584);
        this.getOptionModel(680985600).setListener(this, -1349123072);
        this.getOptionModel(-1936391168).setListener(this, -1533672448);
        this.getOptionModel(-1936391168).setListener(this, -1516895232);
        this.getOptionModel(-1936391168).setListener(this, -1500118016);
        this.getOptionModel(-1936391168).setListener(this, -1483340800);
        this.getOptionModel(-1936391168).setListener(this, -1466563584);
        this.getOptionModel(-1936391168).setListener(this, -1349123072);
        this.getSpellerModel(-1617558528).setSpellerListener(this);
        this.getButtonModel(-1600781312).setButtonListener(this);
        this.getButtonModel(-241826816).setButtonListener(this);
        this.sdsPhoneServiceListenerTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$PhoneServiceListener == null ? (class$de$audi$atip$interapp$PhoneServiceListener = TelFavoriteHandler.class$("de.audi.atip.interapp.PhoneServiceListener")) : class$de$audi$atip$interapp$PhoneServiceListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.sdsPhoneServiceListenerTracker.openTracker();
        this.combiServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = TelFavoriteHandler.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.combiServiceTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        nextUniqueID = 0L;
        this.searchProvider.deinit();
        this.getApplication().getADBHandler().removeListener(this);
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.deinit();
        }
        this.getButtonModel(-1600781312).resetListener();
        this.getBaseListModel(-1634335744).resetListener();
        this.getOptionModel(-1734999040).removeListener(-1533672448);
        this.getOptionModel(-1734999040).removeListener(-1516895232);
        this.getOptionModel(-1734999040).removeListener(-1500118016);
        this.getOptionModel(-1734999040).removeListener(-1483340800);
        this.getOptionModel(-1734999040).removeListener(-1466563584);
        this.getOptionModel(-1734999040).removeListener(-1349123072);
        this.getButtonModel(-728366080).resetListener();
        this.getOptionModel(-795474944).removeListener(-1533672448);
        this.getOptionModel(-795474944).removeListener(-1516895232);
        this.getOptionModel(-795474944).removeListener(-1500118016);
        this.getOptionModel(-795474944).removeListener(-1483340800);
        this.getOptionModel(-795474944).removeListener(-1466563584);
        this.getOptionModel(-795474944).removeListener(-1349123072);
        this.getOptionModel(680985600).removeListener(-1533672448);
        this.getOptionModel(680985600).removeListener(-1516895232);
        this.getOptionModel(680985600).removeListener(-1500118016);
        this.getOptionModel(680985600).removeListener(-1483340800);
        this.getOptionModel(680985600).removeListener(-1466563584);
        this.getOptionModel(680985600).removeListener(-1349123072);
        this.getOptionModel(-1936391168).removeListener(-1533672448);
        this.getOptionModel(-1936391168).removeListener(-1516895232);
        this.getOptionModel(-1936391168).removeListener(-1500118016);
        this.getOptionModel(-1936391168).removeListener(-1483340800);
        this.getOptionModel(-1936391168).removeListener(-1466563584);
        this.getOptionModel(-1936391168).removeListener(-1349123072);
        this.getSpellerModel(-1617558528).resetListener();
        this.getButtonModel(-241826816).resetListener();
        if (this.sdsPhoneServiceListenerTracker != null) {
            this.sdsPhoneServiceListenerTracker.closeTracker();
        }
        if (this.combiServiceTracker != null) {
            this.combiServiceTracker.closeTracker();
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof PhoneServiceListener) {
            this.sdsPhoneServiceListener = (PhoneServiceListener)object;
            this.updateSDS();
            return object;
        }
        if (object instanceof CombiBAPServicePhone) {
            this.combiService = (CombiBAPServicePhone)object;
            this.updateCluster();
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof PhoneServiceListener) {
            this.sdsPhoneServiceListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        } else if (object instanceof CombiBAPServicePhone) {
            this.combiService = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void addToFavorites(TelFavoriteStruct telFavoriteStruct) {
        if (telFavoriteStruct == null) {
            this.log.log(-1601830656, "[TelFavoriteHandler#addToFavorites] favorite is null!! NOP!");
            return;
        }
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelFavoriteHandler#addToFavorites] favorite=%1", (Object)telFavoriteStruct);
        }
        this.favoriteToSave = telFavoriteStruct;
        this.getSpellerModel(-1617558528).setText(telFavoriteStruct.getName());
        this.updateSpellerStatus();
        this.getChoiceModel(-1651112960).setStatus(1);
    }

    private void updateSpellerStatus() {
        SpellerModelApp spellerModelApp;
        spellerModelApp.setStatus((spellerModelApp = this.getSpellerModel(-1617558528)).getText().length() > 0 ? 0 : 1);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelFavoriteHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        EvoListRow evoListRow = this.getBaseListModel(n2).getRow(n3);
        switch (n) {
            case 300696: {
                this.deleteFavorite(evoListRow);
                break;
            }
            case 300428: {
                this.dialFavorite(evoListRow, n5);
                break;
            }
            case 300752: {
                this.editFavorite(evoListRow, n, n5);
                break;
            }
            case 300840: {
                this.prepareSendSMS(evoListRow);
                this.getOptionModel(n).fireEvent(n5);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelFavoriteHandler#keyTyped] unhandled Model-ID %1", (long)n);
            }
        }
    }

    private void prepareSendSMS(EvoListRow evoListRow) {
        if (evoListRow instanceof TelEvoFavoriteListRow) {
            this.messagingServiceHandler.prepareSendSMS(((TelEvoFavoriteListRow)evoListRow).getNumber());
        } else if (evoListRow instanceof TelFavoriteSearchResultRow) {
            this.messagingServiceHandler.prepareSendSMS(((TelFavoriteSearchResultRow)evoListRow).getTelephoneNumber());
        }
    }

    protected void deleteAllFavorites() {
        this.log.log(1078071040, "[TelFavoriteHandler#deleteAllFavorites] deleting all favorites.");
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.deleteAll();
        }
    }

    protected void editFavorite(EvoListRow evoListRow, int n, int n2) {
        if (evoListRow != null) {
            this.favoriteToBeRenamed = evoListRow;
            String string = null;
            if (evoListRow instanceof TelEvoFavoriteListRow) {
                string = ((TelEvoFavoriteListRow)evoListRow).getName();
            } else if (evoListRow instanceof TelFavoriteSearchResultRow) {
                string = ((TelFavoriteSearchResultRow)evoListRow).getName();
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#editFavorite] row is unknown type %1", (Object)evoListRow);
            }
            if (string != null) {
                this.log.log(-2137614336, "[TelFavoriteHandler#editFavorite] favorite=%1, currentName=%1", (Object)evoListRow, (Object)string);
                this.getSpellerModel(-1617558528).setText(string);
                this.updateSpellerStatus();
                this.getOptionModel(n).fireEvent(n2);
            }
        }
    }

    private void renameFavorite(EvoListRow evoListRow, String string) {
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null && evoListRow != null) {
            if (evoListRow instanceof TelEvoFavoriteListRow) {
                TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)evoListRow;
                long l = telEvoFavoriteListRow.getUniqueID();
                int n = telFavoriteListHandler.getIndexForUniqueID(l);
                if (this.log.isDebug()) {
                    this.log.log(-2137614336, "[TelFavoriteHandler#renameFavorite] rename favorite with id=%1: currentName=%2, newName=%3", (Object)String.valueOf(l), (Object)telEvoFavoriteListRow.getName(), (Object)string);
                }
                telFavoriteListHandler.renameFavorite(n, string);
            } else if (evoListRow instanceof TelFavoriteSearchResultRow) {
                TelFavoriteSearchResultRow telFavoriteSearchResultRow = (TelFavoriteSearchResultRow)evoListRow;
                long l = telFavoriteSearchResultRow.getDataID();
                int n = telFavoriteListHandler.getIndexForUniqueID(l);
                if (this.log.isDebug()) {
                    this.log.log(-2137614336, "[TelFavoriteHandler#renameFavorite] rename favorite with id=%1: currentName=%2, newName=%3", (Object)String.valueOf(l), (Object)telFavoriteSearchResultRow.getName(), (Object)string);
                }
                telFavoriteListHandler.renameFavorite(n, string);
                this.searchModelHandler.updateRenamedEntry(telFavoriteSearchResultRow, string);
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#renameFavorite] row is not a favorite: %1", (Object)evoListRow);
            }
        } else {
            this.log.log(-1601830656, "[TelFavoriteHandler#renameFavorite] row is null! NOP!");
        }
    }

    private void deleteFavorite(EvoListRow evoListRow) {
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null && evoListRow != null) {
            if (evoListRow instanceof TelEvoFavoriteListRow) {
                long l = ((TelEvoFavoriteListRow)evoListRow).getUniqueID();
                this.log.log(-2137614336, "[TelFavoriteHandler#deleteFavorite] deleting favorite with id=%1", l);
                telFavoriteListHandler.removeFavorite(l);
            } else if (evoListRow instanceof TelFavoriteSearchResultRow) {
                long l = ((TelFavoriteSearchResultRow)evoListRow).getDataID();
                this.log.log(-2137614336, "[TelFavoriteHandler#deleteFavorite] deleting favorite with id=%1", l);
                telFavoriteListHandler.removeFavorite(l);
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#deleteFavorite] row is not a favorite: %1", (Object)evoListRow);
            }
        } else {
            this.log.log(-1601830656, "[TelFavoriteHandler#deleteFavorite] row is null! NOP!");
        }
    }

    private void dialFavorite(EvoListRow evoListRow, int n) {
        if (evoListRow != null) {
            String string = null;
            String string2 = null;
            int n2 = 0;
            if (evoListRow instanceof TelEvoFavoriteListRow) {
                string = ((TelEvoFavoriteListRow)evoListRow).getNumber();
                string2 = ((TelEvoFavoriteListRow)evoListRow).getName();
                n2 = ((TelEvoFavoriteListRow)evoListRow).getPhoneNumberType();
            } else if (evoListRow instanceof TelFavoriteSearchResultRow) {
                string = ((TelFavoriteSearchResultRow)evoListRow).getTelephoneNumber();
                string2 = ((TelFavoriteSearchResultRow)evoListRow).getName();
                n2 = ((TelFavoriteSearchResultRow)evoListRow).getPhoneNumberType();
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#dialFavorite] row is not a favorite: %1", (Object)evoListRow);
            }
            if (string != null && string.length() > 0) {
                if (string2 != null) {
                    this.log.log(-2137614336, "[TelFavoriteHandler#dialFavorite] number=%1, name=%2", (Object)string, (Object)string2);
                    this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(string, 0L, string2, (short)n2, (short)0, null, 0, 0, n);
                } else {
                    this.log.log(-2137614336, "[TelFavoriteHandler#dialFavorite] number=%1", (Object)string);
                    this.getApplication().getTelephoneDSIAccess().dialNumber(string, n);
                }
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#dialFavorite] no number available! NOP!");
            }
        } else {
            this.log.log(-1601830656, "[TelFavoriteHandler#dialFavorite] row is null! NOP!");
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelFavoriteHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        if (n == -1600781312) {
            String string = this.getSpellerModel(-1617558528).getText();
            TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
            if (telFavoriteListHandler != null) {
                telFavoriteListHandler.addToFavorites(string, this.favoriteToSave.getNumber(), this.favoriteToSave.getPhoneNumberType());
            }
            this.getButtonModel(-1600781312).fireEvent(n3);
            this.getChoiceModel(-1651112960).setStatus(0);
        } else if (n == -728366080) {
            String string = this.getSpellerModel(-1617558528).getText();
            this.renameFavorite(this.favoriteToBeRenamed, string);
            this.getButtonModel(n).fireEvent(n3);
        } else if (n == -241826816) {
            this.deleteAllFavorites();
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void updateActiveProfile(ProfileInfo profileInfo) {
        this.log.log(1078071040, "[TelFavoriteHandler#updateActiveProfile] profileInfo=%1", (Object)profileInfo);
        int n = profileInfo.getNum();
        this.getChoiceModel(-1550449664).setValue(n);
        if (n != this.activeProfileID) {
            if (this.activeProfileID != -1) {
                this.listHandlers[this.activeProfileID].deinit();
            }
            if (n >= 0 && n < this.listHandlers.length) {
                this.activeListHandler = this.listHandlers[n];
                this.activeListHandler.init();
                TelFavoriteSearchDataProvider telFavoriteSearchDataProvider = this.searchProvider;
                if (telFavoriteSearchDataProvider != null) {
                    telFavoriteSearchDataProvider.setActiveListHandler(this.activeListHandler);
                }
                this.activeProfileID = n;
            } else {
                this.log.log(-1601830656, "[TelFavoriteHandler#updateActiveProfile] profileId %1 not in valid range", (long)n);
            }
        } else {
            this.log.log(-2137614336, "[TelFavoriteHandler#updateActiveProfile] profile has not changed --> NOP!");
        }
    }

    @Override
    public void profileDeleted(int n) {
        this.log.log(-2137614336, "[TelFavoriteHandler#profileDeleted] profileId=%1", (long)n);
        if (n >= 0 && n < this.listHandlers.length) {
            this.listHandlers[n].deleteAll();
        }
    }

    void favoritesListUpdated() {
        TelFavoriteSearchDataProvider telFavoriteSearchDataProvider = this.searchProvider;
        if (telFavoriteSearchDataProvider != null) {
            telFavoriteSearchDataProvider.invalidateData();
        }
        this.updateSDS();
        this.updateCluster();
    }

    private void updateCluster() {
        CombiBAPServicePhone combiBAPServicePhone = this.combiService;
        if (combiBAPServicePhone != null) {
            CombiBAPFavoriteNumberEntry[] combiBAPFavoriteNumberEntryArray = this.createClusterFavoritesArray();
            if (combiBAPFavoriteNumberEntryArray != null) {
                this.log.log(1078071040, "[TelFavoriteHandler#updateCluster] favorites=%1", (Object)Converter.array2String(combiBAPFavoriteNumberEntryArray));
                combiBAPServicePhone.updateFavoriteList(combiBAPFavoriteNumberEntryArray);
            } else {
                this.log.log(1078071040, "[TelFavoriteHandler#updateCluster] favorites is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[TelFavoriteHandler#updateCluster] CombiBAPServicePhone not available --> NOP!");
        }
    }

    private CombiBAPFavoriteNumberEntry[] createClusterFavoritesArray() {
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null) {
            BaseListModelApp baseListModelApp = telFavoriteListHandler.getListModelCopy();
            List list = baseListModelApp.asList();
            Iterator iterator = list.iterator();
            CombiBAPFavoriteNumberEntry[] combiBAPFavoriteNumberEntryArray = new CombiBAPFavoriteNumberEntry[list.size()];
            int n = 0;
            while (iterator.hasNext()) {
                TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)iterator.next();
                int n2 = CombiADBUtils.getCombiPhoneType(telEvoFavoriteListRow.getPhoneNumberType());
                combiBAPFavoriteNumberEntryArray[n] = new CombiBAPFavoriteNumberEntry(n, telEvoFavoriteListRow.getName(), telEvoFavoriteListRow.getNumber(), n2);
                ++n;
            }
            return combiBAPFavoriteNumberEntryArray;
        }
        return null;
    }

    private void updateSDS() {
        PhoneServiceListener phoneServiceListener = this.sdsPhoneServiceListener;
        if (phoneServiceListener != null) {
            ITelServiceSDSListener$TelFavoriteSDSListEntry[] iTelServiceSDSListener$TelFavoriteSDSListEntryArray = this.createSDSFavoritesArray();
            if (iTelServiceSDSListener$TelFavoriteSDSListEntryArray != null) {
                this.log.log(1078071040, "[TelFavoriteHandler#updateSDS] favorites=%1", (Object)Converter.array2String(iTelServiceSDSListener$TelFavoriteSDSListEntryArray));
                phoneServiceListener.updateFavorites(iTelServiceSDSListener$TelFavoriteSDSListEntryArray);
            } else {
                this.log.log(1078071040, "[TelFavoriteHandler#updateSDS] favorites is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[TelFavoriteHandler#updateSDS] PhoneServiceListener not available --> NOP!");
        }
    }

    private ITelServiceSDSListener$TelFavoriteSDSListEntry[] createSDSFavoritesArray() {
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null) {
            BaseListModelApp baseListModelApp = telFavoriteListHandler.getListModelCopy();
            List list = baseListModelApp.asList();
            Iterator iterator = list.iterator();
            ITelServiceSDSListener$TelFavoriteSDSListEntry[] iTelServiceSDSListener$TelFavoriteSDSListEntryArray = new ITelServiceSDSListener$TelFavoriteSDSListEntry[list.size()];
            int n = 0;
            while (iterator.hasNext()) {
                TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)iterator.next();
                iTelServiceSDSListener$TelFavoriteSDSListEntryArray[n++] = new ITelServiceSDSListener$TelFavoriteSDSListEntry(telEvoFavoriteListRow.getName(), telEvoFavoriteListRow.getUniqueID(), telEvoFavoriteListRow.getNumber());
            }
            return iTelServiceSDSListener$TelFavoriteSDSListEntryArray;
        }
        return null;
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.updateSpellerStatus();
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("model=");
            buffer.append(n);
            buffer.append(", text=");
            buffer.append(string);
            buffer.append(", latestChar=");
            buffer.append(c2);
            buffer.append(", terminal=");
            buffer.append(n2);
            this.log.log(1078071040, "[TelFavoriteHandler#textChanged] %1", (Object)buffer);
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void updateSortOrder(int n, int n2) {
    }

    @Override
    public void setAdbReady(boolean bl) {
    }

    @Override
    public void handleInvalidData(int n, boolean bl) {
    }

    public void onADBEntrySelected(AdbEntry adbEntry) {
    }

    @Override
    public void onEntrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
    }

    @Override
    public void onDetailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ TelFavoriteListHandler access$100(TelFavoriteHandler telFavoriteHandler) {
        return telFavoriteHandler.activeListHandler;
    }

    static /* synthetic */ TelFavoriteListHandler[] access$200(TelFavoriteHandler telFavoriteHandler) {
        return telFavoriteHandler.listHandlers;
    }

    static {
        nextUniqueID = 0L;
    }
}

