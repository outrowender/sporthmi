/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.IAlertListBuilder;
import de.audi.tuner.app.storage.IMemListStorage;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ICombiBAPServiceElementFactory;
import de.audi.tuner.ifc.IScanHandler;

public interface ITunerVariantExt {
    public static final int POPUPID_FAVORITE_STORED;
    public static final int POPUPID_FAVORITE_STORED_NAR;
    public static final int POPUPID_ALL_FAVORITE_DELETED;
    public static final int POPUPID_ALL_SDARS_FAVORITE_DELETED;
    public static final int POPUPID_LISTUPDATE_RUNNING;
    public static final int POPUP_POPUP_ANNOUNCEMENT_G24_ID;
    public static final int POPUPID_TRAFFICPROGRAMM_DISABLED;
    public static final int POPUPID_TRAFFICPROGRAMM_ENABLED;
    public static final int POPUPID_ITUNES_TAGTRANSFER_MAIN;
    public static final int POPUPID_ITUNES_TAGTRANSFER_SUCCEEDED;
    public static final int POPUPID_ITUNES_TAGTRANSFER_FAILED;
    public static final int POPUPID_SDARS_ADD_SEEK;
    public static final int POPUPID_SDARS_ARTIST_SEEK_SAVED;
    public static final int POPUPID_SDARS_TITLE_SEEK_SAVED;
    public static final int POPUPID_SDARS_ALERT_SAVED;
    public static final int POPUPID_SDARS_SEEK_LIST_FULL;
    public static final int POPUPID_SDARS_SEEK_LIST_FULL_REPLACE;
    public static final int POPUPID_SDARS_SEEK_TOO_MANY_SELECTED;
    public static final int POPUPID_SDARS_SEEK_REPLACE_SONGARTIST;
    public static final int POPUPID_SDARS_SEEK_REPLACE_TEAMLEAGUE;
    public static final int POPUPID_AUTOSTORE_FINISHED;
    public static final int POPUPID_DABEPG_PROGRAM_DETAILS;
    public static final int POPUPID_SDARSEPG_PROGRAM_DETAILS;
    public static final int POPUPID_SDARS_MANAGESEEK_ALREADYADDED;
    public static final int POPUPID_SCAN_ACTIVE;
    public static final int POPUPID_TA;
    public static final int VIRTUALBUTTON_NONE;

    default public AbstractListRowFactory getListRowFactory() {
    }

    default public IMemListStorage getMemListStorage(IStorageAccess iStorageAccess, LogChannel logChannel, AbstractListRowFactory abstractListRowFactory) {
    }

    default public void showPartialPopup(int n) {
    }

    default public void hidePartialPopup(int n) {
    }

    default public int getPopupId(int n) {
    }

    default public int getFavoriteScreenId() {
    }

    default public String getBandString(int n) {
    }

    default public SDARSStationListHandler getSDARSStationListHandler(SDARSTuner sDARSTuner, TunerBasics tunerBasics, IStoreHandler iStoreHandler, LanguageManager languageManager, AbstractListRowFactory abstractListRowFactory, IScanHandler iScanHandler, TunerStorage tunerStorage) {
    }

    default public HMIResourceLocator getDefaultImage(int n) {
    }

    default public int getVirtualButtonModel(int n) {
    }

    default public AbstractSeekListSizeRistrictionHandler getSeekListRestriction(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager) {
    }

    default public IAlertListBuilder getSdarsAlertListBuilder() {
    }

    default public ICombiBAPServiceElementFactory getCombiBAPServiceElementFactory() {
    }
}

