/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.rse.NullIHMISyncRadioReplies;
import de.audi.tuner.app.rse.TabletServiceHandler$DsiUpListener;
import de.audi.tuner.app.rse.TabletServiceHandler$ParentalEnforcementListener;
import de.audi.tuner.app.rse.TabletServiceHandler$PdtListener;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.IRadioInterappListener;
import de.audi.tuner.ifc.IRadioInterappListener$RadioStation;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import java.util.ArrayList;
import org.dsi.ifc.radio.WavebandInfo;

public class TabletServiceHandler
extends DefaultUpdateListener
implements IUpdateListener {
    public final TabletServiceHandler$DsiUpListener amfmDsiUpListener = new TabletServiceHandler$DsiUpListener(this, null);
    private final TabletServiceHandler$PdtListener pdtListener = new TabletServiceHandler$PdtListener(this, null);
    private final Logger logger;
    private final TunerModels models;
    private final TunerStorage storage;
    private PdtInfoHandler pdtInfoHandler;
    private int activeBand;
    private TunerObjectContainer activeStation = TunerObjectContainer.EMPTY_CONTAINER;
    private WavebandInfo[] wavebandInfo = new WavebandInfo[0];
    private IRadioInterappListener tabletService;
    private int[] bands = new int[0];
    private final SDARSStationDescriptions stationDescriptions;

    public TabletServiceHandler(TunerBasics tunerBasics, TunerStorage tunerStorage, SDARSStationDescriptions sDARSStationDescriptions) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.storage = tunerStorage;
        this.stationDescriptions = sDARSStationDescriptions;
        this.tabletService = new NullIHMISyncRadioReplies(this.logger.rse);
        this.models.getButtonModel(-1584922368).setButtonListener(new TabletServiceHandler$ParentalEnforcementListener(this, null));
    }

    public void register(IRadioInterappListener iRadioInterappListener) {
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#register] service: %1", (Object)iRadioInterappListener);
        IRadioInterappListener iRadioInterappListener2 = this.tabletService = iRadioInterappListener != null ? iRadioInterappListener : new NullIHMISyncRadioReplies(this.logger.rse);
        if (!(this.tabletService instanceof NullIHMISyncRadioReplies)) {
            this.initConnection();
        }
    }

    public void setPdtInfoHandler(PdtInfoHandler pdtInfoHandler) {
        this.pdtInfoHandler = pdtInfoHandler;
    }

    @Override
    public void updatedStationList(int n) {
        if (n == this.activeBand) {
            this.sendReceptionList(n);
            this.updatedActiveStation(n);
        }
    }

    @Override
    public void updatedActiveStation(int n) {
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedActiveStation] component: %1", (long)n);
        if (n != this.models.getActiveTuner()) {
            this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedActiveStation] component not active tuner (%1)", (long)this.models.getActiveTuner());
            return;
        }
        if (n != this.activeBand) {
            this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedActiveStation] ignore activeStation -> send bandchange fisrt");
            return;
        }
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler == null) {
            this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedActiveStation] ITunerGUIHandler is null.");
            return;
        }
        if (this.activeStation.getBand() == 7 && this.pdtInfoHandler != null) {
            this.pdtInfoHandler.removeListener(this.activeStation.getSDARSService().sID, this.pdtListener);
            this.pdtListener.reset();
        }
        this.activeStation = iTunerGUIHandler.getCurrentStation();
        if (this.activeStation.getBand() == 7 && this.pdtInfoHandler != null) {
            this.pdtInfoHandler.addListener(this.activeStation.getSDARSService().sID, this.pdtListener, 0);
        } else {
            int n2 = Utilities.isBentley() ? 2 : this.storage.loadPreferredImageType();
            this.tabletService.updateActiveStation(this.createRSEStation(this.activeStation, n2, true));
        }
    }

    @Override
    public void updatedWaveband(int n) {
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedWaveband], component: %1", (long)n);
        if (n != 0) {
            this.activeBand = n;
            this.tabletService.updateActiveBand(n);
            this.sendReceptionList(n);
            this.updatedActiveStation(n);
        }
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#updateWavebandInfoList]: size %1", (long)wavebandInfoArray.length);
        this.wavebandInfo = wavebandInfoArray;
        this.tabletService.updateWavebandInfoList(wavebandInfoArray);
    }

    void initConnection() {
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#initConnection]");
        if (this.activeBand == 0) {
            this.activeBand = this.models.getActiveTuner();
        }
        this.sendBandList(this.bands);
        this.updatedWaveband(this.activeBand);
        this.tabletService.updateWavebandInfoList(this.wavebandInfo);
    }

    @Override
    public void updatedBandList(int[] nArray) {
        this.bands = nArray;
        this.sendBandList(nArray);
    }

    private void sendBandList(int[] nArray) {
        this.tabletService.updateBandList(nArray);
    }

    private boolean sendReceptionList(int n) {
        IRadioInterappListener$RadioStation[] iRadioInterappListener$RadioStationArray;
        this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedStationList] component:%1", (long)n);
        if (n != this.models.getActiveTuner()) {
            this.logger.rse.log(-2137614336, "[TabletServiceHandler#updatedStationList] component not active tuner (%1)", (long)this.models.getActiveTuner());
            return false;
        }
        if (n != this.activeBand) {
            this.logger.rse.log(-2137614336, "[TabletServiceHandler#sendReceptionList] ignore component -> send bandchange fisrt");
            return false;
        }
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler == null) {
            this.logger.rse.log(10000, "[TabletServiceHandler#updatedStationList] guiHandler is null!");
            return false;
        }
        TunerObjectContainer[] tunerObjectContainerArray = iTunerGUIHandler.getStationList();
        if (tunerObjectContainerArray == null) {
            this.logger.rse.log(10000, "[TabletServiceHandler#updatedStationList] station list is null!");
            return false;
        }
        switch (n) {
            case 1: 
            case 4: 
            case 5: 
            case 7: 
            case 10: 
            case 11: {
                iRadioInterappListener$RadioStationArray = this.createRSEList(tunerObjectContainerArray, this.storage.loadPreferredImageType());
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unexpected component: ").append(n).toString());
            }
        }
        this.tabletService.updateRadioStationList(iRadioInterappListener$RadioStationArray);
        return true;
    }

    private IRadioInterappListener$RadioStation[] createRSEList(TunerObjectContainer[] tunerObjectContainerArray, int n) {
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            if (!this.isStationValidForTabletStationList(tunerObjectContainerArray[i2])) continue;
            arrayList.add(this.createRSEStation(tunerObjectContainerArray[i2], n, false));
        }
        Object[] objectArray = new IRadioInterappListener$RadioStation[arrayList.size()];
        return (IRadioInterappListener$RadioStation[])arrayList.toArray(objectArray);
    }

    private boolean isStationValidForTabletStationList(TunerObjectContainer tunerObjectContainer) {
        if (tunerObjectContainer == null) {
            return false;
        }
        if (tunerObjectContainer.getType() == 5) {
            return tunerObjectContainer.getSDARSService().getSubscription() == 2;
        }
        return true;
    }

    private IRadioInterappListener$RadioStation createRSEStation(TunerObjectContainer tunerObjectContainer, int n, boolean bl) {
        ArtistAndTitlePair artistAndTitlePair = tunerObjectContainer.getArtistAndTitlePair();
        String string = tunerObjectContainer.getTag(2);
        if (tunerObjectContainer.getBand() == 7) {
            SdarsRadioText sdarsRadioText = TabletServiceHandler$PdtListener.access$300(this.pdtListener);
            if (sdarsRadioText.sID == tunerObjectContainer.getSDARSService().sID) {
                artistAndTitlePair = new ArtistAndTitlePair(sdarsRadioText.getLongestAvailableArtistName(), sdarsRadioText.getLongestAvailableProgramTitle());
            }
        }
        int n2 = 1;
        if (tunerObjectContainer.getBand() == 5) {
            if (tunerObjectContainer.getDABStation().isEnsemble()) {
                n2 = 0;
            } else if (tunerObjectContainer.getDABStation().isComponent()) {
                n2 = 2;
            }
        }
        String string2 = "";
        if (tunerObjectContainer.getBand() == 4 || tunerObjectContainer.getBand() == 1) {
            string2 = tunerObjectContainer.getAMFMService().getRtPlus().getPlainRadioText();
        } else if (tunerObjectContainer.getBand() == 5) {
            string2 = tunerObjectContainer.getDABStation().getRtPlus().getPlainRadioText();
        } else if (tunerObjectContainer.getBand() == 11) {
            string2 = tunerObjectContainer.getUniStation().getRtPlus().getPlainRadioText();
        } else if (tunerObjectContainer.getBand() == 7) {
            string2 = this.stationDescriptions.getLongDescription(tunerObjectContainer.getSDARSService().getSID());
        }
        string2 = string2 == null ? "" : string2;
        HMIResourceLocator hMIResourceLocator = tunerObjectContainer.getImage(0);
        String string3 = hMIResourceLocator.getResourceURI();
        int n3 = this.getRSEReceptionStatus(tunerObjectContainer, bl);
        return new IRadioInterappListener$RadioStation(tunerObjectContainer.getListID(), tunerObjectContainer.getStationName(false, true), tunerObjectContainer.getStationName(true, true), artistAndTitlePair.artistString, 0, artistAndTitlePair.titleString, 0, tunerObjectContainer.getImage(n).getResourceURI(), n3, n2, string, string2, tunerObjectContainer.getFrequency(), string3);
    }

    public int getCurrentWaveBand() {
        return this.activeBand;
    }

    int getRSEReceptionStatus(TunerObjectContainer tunerObjectContainer, boolean bl) {
        int n = 2;
        block0 : switch (tunerObjectContainer.getType()) {
            case 3: {
                AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
                if (!bl) {
                    n = aMFMStation.hd ? 2 : 1;
                    break;
                }
                if (aMFMStation.getAudioStatus() == 2) {
                    n = 2;
                    break;
                }
                if (aMFMStation.getAudioStatus() == 4) {
                    n = 4;
                    break;
                }
                if (aMFMStation.getAudioStatus() == 3 || aMFMStation.getAudioStatus() == 0) {
                    n = 3;
                    break;
                }
                n = 1;
                break;
            }
            case 5: {
                StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
                n = stationInfoExt.isAudioOk() ? 2 : 3;
                break;
            }
            case 7: {
                UnifiedStationExt unifiedStationExt = tunerObjectContainer.getUniStation();
                if (!bl) {
                    n = unifiedStationExt.isFM() ? 1 : 2;
                    break;
                }
                if (unifiedStationExt.getAudioStatus() == 2) {
                    n = 2;
                    break;
                }
                if (unifiedStationExt.getAudioStatus() == 3) {
                    n = 3;
                    break;
                }
                n = 1;
                break;
            }
            case 6: {
                if (!bl) {
                    if (tunerObjectContainer.getReceptionStatus() == 2) {
                        n = 3;
                        break;
                    }
                    n = 2;
                    break;
                }
                switch (tunerObjectContainer.getReceptionStatus()) {
                    case 1: {
                        n = 1;
                        break block0;
                    }
                    case 2: {
                        n = 3;
                        break block0;
                    }
                }
                n = 2;
                break;
            }
            default: {
                n = 2;
            }
        }
        return n;
    }

    static /* synthetic */ Logger access$400(TabletServiceHandler tabletServiceHandler) {
        return tabletServiceHandler.logger;
    }

    static /* synthetic */ IRadioInterappListener access$500(TabletServiceHandler tabletServiceHandler) {
        return tabletServiceHandler.tabletService;
    }

    static /* synthetic */ TunerObjectContainer access$600(TabletServiceHandler tabletServiceHandler) {
        return tabletServiceHandler.activeStation;
    }

    static /* synthetic */ TunerStorage access$700(TabletServiceHandler tabletServiceHandler) {
        return tabletServiceHandler.storage;
    }

    static /* synthetic */ IRadioInterappListener$RadioStation access$800(TabletServiceHandler tabletServiceHandler, TunerObjectContainer tunerObjectContainer, int n, boolean bl) {
        return tabletServiceHandler.createRSEStation(tunerObjectContainer, n, bl);
    }
}

