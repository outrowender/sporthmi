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
    public static final int POPUPID_FAVORITE_STORED = 1;
    public static final int POPUPID_FAVORITE_STORED_NAR = 2;
    public static final int POPUPID_ALL_FAVORITE_DELETED = 3;
    public static final int POPUPID_ALL_SDARS_FAVORITE_DELETED = 4;
    public static final int POPUPID_LISTUPDATE_RUNNING = 5;
    public static final int POPUP_POPUP_ANNOUNCEMENT_G24_ID = 6;
    public static final int POPUPID_TRAFFICPROGRAMM_DISABLED = 7;
    public static final int POPUPID_TRAFFICPROGRAMM_ENABLED = 8;
    public static final int POPUPID_ITUNES_TAGTRANSFER_MAIN = 9;
    public static final int POPUPID_ITUNES_TAGTRANSFER_SUCCEEDED = 10;
    public static final int POPUPID_ITUNES_TAGTRANSFER_FAILED = 11;
    public static final int POPUPID_SDARS_ADD_SEEK = 12;
    public static final int POPUPID_SDARS_ARTIST_SEEK_SAVED = 13;
    public static final int POPUPID_SDARS_TITLE_SEEK_SAVED = 14;
    public static final int POPUPID_SDARS_ALERT_SAVED = 15;
    public static final int POPUPID_SDARS_SEEK_LIST_FULL = 16;
    public static final int POPUPID_SDARS_SEEK_LIST_FULL_REPLACE = 17;
    public static final int POPUPID_SDARS_SEEK_TOO_MANY_SELECTED = 18;
    public static final int POPUPID_SDARS_SEEK_REPLACE_SONGARTIST = 19;
    public static final int POPUPID_SDARS_SEEK_REPLACE_TEAMLEAGUE = 20;
    public static final int POPUPID_AUTOSTORE_FINISHED = 21;
    public static final int POPUPID_DABEPG_PROGRAM_DETAILS = 22;
    public static final int POPUPID_SDARSEPG_PROGRAM_DETAILS = 23;
    public static final int POPUPID_SDARS_MANAGESEEK_ALREADYADDED = 24;
    public static final int POPUPID_SCAN_ACTIVE = 25;
    public static final int POPUPID_TA = 26;
    public static final int VIRTUALBUTTON_NONE = -1;

    public AbstractListRowFactory getListRowFactory();

    public IMemListStorage getMemListStorage(IStorageAccess var1, LogChannel var2, AbstractListRowFactory var3);

    public void showPartialPopup(int var1);

    public void hidePartialPopup(int var1);

    public int getPopupId(int var1);

    public int getFavoriteScreenId();

    public String getBandString(int var1);

    public SDARSStationListHandler getSDARSStationListHandler(SDARSTuner var1, TunerBasics var2, IStoreHandler var3, LanguageManager var4, AbstractListRowFactory var5, IScanHandler var6, TunerStorage var7);

    public HMIResourceLocator getDefaultImage(int var1);

    public int getVirtualButtonModel(int var1);

    public AbstractSeekListSizeRistrictionHandler getSeekListRestriction(TunerBasics var1, SDARSDSISeekDownManager var2);

    public IAlertListBuilder getSdarsAlertListBuilder();

    public ICombiBAPServiceElementFactory getCombiBAPServiceElementFactory();
}

