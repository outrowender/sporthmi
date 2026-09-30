/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.ListRowFactoryEvo;
import de.audi.app.tuner.storage.MemListStorageEvo;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.app.AppTunerTextConstants;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.combi.CombiBAPServiceElementFactoryEvo;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.DefaultAlertListBuilder;
import de.audi.tuner.app.sdars.seek.IAlertListBuilder;
import de.audi.tuner.app.sdars.seek.SeekListSizeRestrictionHandlerSimple;
import de.audi.tuner.app.storage.IMemListStorage;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ICombiBAPServiceElementFactory;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class TunerVariantExt
implements ITunerVariantExt {
    private static final SimpleIntIntMap CUSTOMID_TO_EXTERNALID = new SimpleIntIntMap(10);
    private final AbstractListRowFactory listRowFactory = new ListRowFactoryEvo();
    private CombiBAPServiceElementFactoryEvo combiBapServiceElementFactory = new CombiBAPServiceElementFactoryEvo();

    public AbstractListRowFactory getListRowFactory() {
        return this.listRowFactory;
    }

    public IMemListStorage getMemListStorage(IStorageAccess iStorageAccess, LogChannel logChannel, AbstractListRowFactory abstractListRowFactory) {
        return new MemListStorageEvo(iStorageAccess, logChannel, abstractListRowFactory);
    }

    public void showPartialPopup(int n) {
        int n2 = CUSTOMID_TO_EXTERNALID.get(n);
        if (n2 != -1) {
            Utilities.getFramework().getHmiServiceApp().showPartialPopup(0, n2);
        }
    }

    public void hidePartialPopup(int n) {
        int n2 = CUSTOMID_TO_EXTERNALID.get(n);
        if (n2 != -1) {
            Utilities.getFramework().getHmiServiceApp().removePartialPopup(0, n2);
        }
    }

    public int getPopupId(int n) {
        int n2 = CUSTOMID_TO_EXTERNALID.get(n);
        if (n2 == -1) {
            throw new IllegalArgumentException();
        }
        return n2;
    }

    public int getFavoriteScreenId() {
        return 100028;
    }

    public String getBandString(int n) {
        return Utilities.getHMIServiceApp().getText(AppTunerTextConstants.TEXT_CONST_TUNER_BANDS[n]);
    }

    public SDARSStationListHandler getSDARSStationListHandler(SDARSTuner sDARSTuner, TunerBasics tunerBasics, IStoreHandler iStoreHandler, LanguageManager languageManager, AbstractListRowFactory abstractListRowFactory, IScanHandler iScanHandler, TunerStorage tunerStorage) {
        return new SDARSStationListHandler(sDARSTuner, tunerBasics, iStoreHandler, languageManager, abstractListRowFactory, iScanHandler, tunerStorage);
    }

    public HMIResourceLocator getDefaultImage(int n) {
        int n2 = -1;
        switch (n) {
            case 4: {
                n2 = HMIImageConstantsSystem.tuner_staticImage_stationLogo_AM;
                break;
            }
            case 1: {
                n2 = HMIImageConstantsSystem.tuner_staticImage_stationLogo_FM;
                break;
            }
            case 5: {
                n2 = HMIImageConstantsSystem.tuner_staticImage_stationLogo_DAB;
                break;
            }
            case 11: {
                n2 = HMIImageConstantsSystem.tuner_staticImage_stationLogo_UNIFIED;
                break;
            }
            case 7: {
                n2 = HMIImageConstantsSystem.tuner_staticImage_stationLogo_SIRIUS;
                break;
            }
        }
        HMIBundle hMIBundle = Utilities.getHMIService().getHMIBundle(n2);
        if (n2 == -1 || hMIBundle == null) {
            return ISimpleTuner.EMPTY_RL;
        }
        String string = hMIBundle.getImagePath(n2, 0);
        Buffer buffer = new Buffer();
        buffer.append(System.getProperty("ImageRoot", "/images"));
        buffer.append('/');
        buffer.append(string);
        return new HMIResourceLocator(buffer.toString());
    }

    public int getVirtualButtonModel(int n) {
        return -1;
    }

    public AbstractSeekListSizeRistrictionHandler getSeekListRestriction(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager) {
        return new SeekListSizeRestrictionHandlerSimple(tunerBasics, sDARSDSISeekDownManager);
    }

    public IAlertListBuilder getSdarsAlertListBuilder() {
        return new DefaultAlertListBuilder();
    }

    public ICombiBAPServiceElementFactory getCombiBAPServiceElementFactory() {
        return this.combiBapServiceElementFactory;
    }

    static {
        CUSTOMID_TO_EXTERNALID.add(1, 100107);
        CUSTOMID_TO_EXTERNALID.add(2, 100154);
        CUSTOMID_TO_EXTERNALID.add(3, 100108);
        CUSTOMID_TO_EXTERNALID.add(6, 23);
        CUSTOMID_TO_EXTERNALID.add(9, 100155);
        CUSTOMID_TO_EXTERNALID.add(10, 100152);
        CUSTOMID_TO_EXTERNALID.add(11, 100153);
        CUSTOMID_TO_EXTERNALID.add(13, 100156);
        CUSTOMID_TO_EXTERNALID.add(14, 100156);
        CUSTOMID_TO_EXTERNALID.add(15, 100157);
        CUSTOMID_TO_EXTERNALID.add(16, 100160);
        CUSTOMID_TO_EXTERNALID.add(17, 100160);
    }
}

