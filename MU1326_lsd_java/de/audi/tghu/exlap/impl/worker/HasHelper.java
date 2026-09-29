/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.app.IExlapWorker;
import de.audi.tghu.exlap.ifc.service.ExlapMediaService;
import de.audi.tghu.exlap.ifc.service.ExlapNavigationService;
import de.audi.tghu.exlap.ifc.service.ExlapRadioService;
import de.audi.tghu.exlap.ifc.service.ExlapSoundService;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.container.ContextStateContainer;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXDataContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXResultContainer;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.container.ListPageDataContainer;
import de.audi.tghu.exlap.impl.container.ListPageRequestContainer;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserEntryContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.container.MediaCapabilitiesContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.container.MediaSourceContainer;
import de.audi.tghu.exlap.impl.container.MediaSourceStateContainer;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.container.RadioBandContainer;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetIndexContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;
import de.audi.tghu.exlap.impl.container.StartGuidanceResultContainer;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import de.audi.tghu.exlap.impl.container.TrackPositionContainer;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;
import de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker;
import de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker;
import de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker;
import de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker;
import de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker;
import de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker;
import de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker;
import de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapLocationWorker;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker;
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker;
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker;
import de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker;
import de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker;
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker;
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker;
import de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker;
import de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.HASDataContainer;

public class HasHelper {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final Map workers = new HashMap();
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapMediaService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSoundService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapExlapService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapRadioService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSystemService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker;
    static /* synthetic */ Class class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker;

    public HasHelper(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("App.Exlap.HasHelper");
    }

    public void createWorkers(String string, ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapMediaService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapMediaService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapMediaService")) : class$de$audi$tghu$exlap$ifc$service$ExlapMediaService).getName())) {
            this.createCurrentTrackInfoWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createMediaPlayInfoWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createMediaPlayModeWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableMediaSourcesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createMediaBrowserListWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createMediaBrowserFollowModeWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createMediaBrowserFolderWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createCurrentTrackPathWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAppConnectDeviceWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSettingsService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService).getName())) {
            this.createExlapRestrictionModeWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSoundService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSoundService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSoundService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSoundService).getName())) {
            this.createSoundVolumeWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createSoundVolumeRangesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createBalanceFaderWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createBalanceFaderRangesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createEntertainmentContextWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapExlapService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapExlapService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapExlapService")) : class$de$audi$tghu$exlap$ifc$service$ExlapExlapService).getName())) {
            this.createContextStatesWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapRadioService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapRadioService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapRadioService")) : class$de$audi$tghu$exlap$ifc$service$ExlapRadioService).getName())) {
            this.createAvailableRadioBandsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableAMStationsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableFMStationsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableDABEnsemblesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableDABServicesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createAvailableDABServiceComponentsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioAMPresetsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioFMPresetsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioDABPresetsWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioTunerWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioFrequencyRangesWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createTrafficAnnouncementWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createRadioTextWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapNavigationService")) : class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService).getName())) {
            this.createLocationWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createGuidanceStateWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createGuidanceDestinationWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createGuidanceRemainingWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createLastDestinationsWorker(exlapService, exlapDispatcher, dSIHAS);
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSystemService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSystemService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSystemService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSystemService).getName())) {
            this.createSkinInfoWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createLanguageInfoWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createUnitDistanceWorker(exlapService, exlapDispatcher, dSIHAS);
            this.createEncodedVehicleTypeWorker(exlapService, exlapDispatcher, dSIHAS);
        }
    }

    public void stopWorkers(String string) {
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapMediaService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapMediaService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapMediaService")) : class$de$audi$tghu$exlap$ifc$service$ExlapMediaService).getName())) {
            this.stopCurrentTrackInfoWorker();
            this.stopMediaPlayInfoWorker();
            this.stopMediaPlayModeWorker();
            this.stopAvailableMediaSourcesWorker();
            this.stopMediaBrowserListWorker();
            this.stopMediaBrowserFollowModeWorker();
            this.stopMediaBrowserFolderWorker();
            this.stopCurrentTrackPathWorker();
            this.stopAppConnectDeviceWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSettingsService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService).getName())) {
            this.stopExlapRestrictionModeWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSoundService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSoundService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSoundService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSoundService).getName())) {
            this.stopSoundVolumeWorker();
            this.stopSoundVolumeRangesWorker();
            this.stopBalanceFaderWorker();
            this.stopBalanceFaderRangesWorker();
            this.stopEntertainmentContextWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapExlapService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapExlapService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapExlapService")) : class$de$audi$tghu$exlap$ifc$service$ExlapExlapService).getName())) {
            this.stopContextStatesWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapRadioService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapRadioService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapRadioService")) : class$de$audi$tghu$exlap$ifc$service$ExlapRadioService).getName())) {
            this.stopAvailableRadioBandsWorker();
            this.stopAvailableAMStationsWorker();
            this.stopAvailableFMStationsWorker();
            this.stopAvailableDABEnsemblesWorker();
            this.stopAvailableDABServicesWorker();
            this.stopAvailableDABServiceComponentsWorker();
            this.stopRadioAMPresetsWorker();
            this.stopRadioFMPresetsWorker();
            this.stopRadioDABPresetsWorker();
            this.stopRadioTunerWorker();
            this.stopRadioFrequencyRangesWorker();
            this.stopTrafficAnnouncementWorker();
            this.stopRadioTextWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapNavigationService")) : class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService).getName())) {
            this.stopLocationWorker();
            this.stopGuidanceStateWorker();
            this.stopGuidanceDestinationWorker();
            this.stopGuidanceRemainingWorker();
            this.stopLastDestinationsWorker();
        }
        if (string.equals((class$de$audi$tghu$exlap$ifc$service$ExlapSystemService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSystemService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSystemService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSystemService).getName())) {
            this.stopSkinInfoWorker();
            this.stopLanguageInfoWorker();
            this.stopUnitDistanceWorker();
            this.stopEncodedVehicleTypeWorker();
        }
    }

    public boolean subscribe(int n, int n2) {
        switch (n) {
            case 21: {
                return this.registerCurrentTrackInfo(n2);
            }
            case 22: {
                return this.registerMediaPlayInfo(n2);
            }
            case 23: {
                return this.registerMediaPlayMode(n2);
            }
            case 27: {
                return this.registerAvailableMediaSources(n2);
            }
            case 41: {
                return this.registerMediaBrowserList(n2);
            }
            case 43: {
                return this.registerMediaBrowserFollowMode(n2);
            }
            case 47: {
                return this.registerMediaBrowserFolder(n2);
            }
            case 50: {
                return this.registerCurrentTrackPath(n2);
            }
            case 57: {
                return this.registerAppConnectDevice(n2);
            }
            case 30: {
                return this.registerExlapRestrictionMode(n2);
            }
            case 25: {
                return this.registerSoundVolume(n2);
            }
            case 26: {
                return this.registerSoundVolumeRanges(n2);
            }
            case 45: {
                return this.registerBalanceFader(n2);
            }
            case 46: {
                return this.registerBalanceFaderRanges(n2);
            }
            case 58: {
                return this.registerEntertainmentContext(n2);
            }
            case 0x1000000: {
                return this.registerContextStates(n2);
            }
            case 28: {
                return this.registerAvailableRadioBands(n2);
            }
            case 31: {
                return this.registerAvailableAMStations(n2);
            }
            case 32: {
                return this.registerAvailableFMStations(n2);
            }
            case 33: {
                return this.registerAvailableDABEnsembles(n2);
            }
            case 34: {
                return this.registerAvailableDABServices(n2);
            }
            case 35: {
                return this.registerAvailableDABServiceComponents(n2);
            }
            case 36: {
                return this.registerRadioAMPresets(n2);
            }
            case 37: {
                return this.registerRadioFMPresets(n2);
            }
            case 38: {
                return this.registerRadioDABPresets(n2);
            }
            case 39: {
                return this.registerRadioTuner(n2);
            }
            case 40: {
                return this.registerRadioFrequencyRanges(n2);
            }
            case 48: {
                return this.registerTrafficAnnouncement(n2);
            }
            case 49: {
                return this.registerRadioText(n2);
            }
            case 1: {
                return this.registerLocation(n2);
            }
            case 7: {
                return this.registerGuidanceState(n2);
            }
            case 8: {
                return this.registerGuidanceDestination(n2);
            }
            case 24: {
                return this.registerGuidanceRemaining(n2);
            }
            case 29: {
                return this.registerLastDestinations(n2);
            }
            case 5: {
                return this.registerSkinInfo(n2);
            }
            case 6: {
                return this.registerLanguageInfo(n2);
            }
            case 13: {
                return this.registerUnitDistance(n2);
            }
            case 51: {
                return this.registerEncodedVehicleType(n2);
            }
        }
        this.log.log(-1601830656, "[HasHelper#subscribe] unknown property %1", (long)n);
        return false;
    }

    public void unsubscribe(int n) {
        switch (n) {
            case 21: {
                this.unregisterCurrentTrackInfo();
                break;
            }
            case 22: {
                this.unregisterMediaPlayInfo();
                break;
            }
            case 23: {
                this.unregisterMediaPlayMode();
                break;
            }
            case 27: {
                this.unregisterAvailableMediaSources();
                break;
            }
            case 41: {
                this.unregisterMediaBrowserList();
                break;
            }
            case 43: {
                this.unregisterMediaBrowserFollowMode();
                break;
            }
            case 47: {
                this.unregisterMediaBrowserFolder();
                break;
            }
            case 50: {
                this.unregisterCurrentTrackPath();
                break;
            }
            case 57: {
                this.unregisterAppConnectDevice();
                break;
            }
            case 30: {
                this.unregisterExlapRestrictionMode();
                break;
            }
            case 25: {
                this.unregisterSoundVolume();
                break;
            }
            case 26: {
                this.unregisterSoundVolumeRanges();
                break;
            }
            case 45: {
                this.unregisterBalanceFader();
                break;
            }
            case 46: {
                this.unregisterBalanceFaderRanges();
                break;
            }
            case 58: {
                this.unregisterEntertainmentContext();
                break;
            }
            case 0x1000000: {
                this.unregisterContextStates();
                break;
            }
            case 28: {
                this.unregisterAvailableRadioBands();
                break;
            }
            case 31: {
                this.unregisterAvailableAMStations();
                break;
            }
            case 32: {
                this.unregisterAvailableFMStations();
                break;
            }
            case 33: {
                this.unregisterAvailableDABEnsembles();
                break;
            }
            case 34: {
                this.unregisterAvailableDABServices();
                break;
            }
            case 35: {
                this.unregisterAvailableDABServiceComponents();
                break;
            }
            case 36: {
                this.unregisterRadioAMPresets();
                break;
            }
            case 37: {
                this.unregisterRadioFMPresets();
                break;
            }
            case 38: {
                this.unregisterRadioDABPresets();
                break;
            }
            case 39: {
                this.unregisterRadioTuner();
                break;
            }
            case 40: {
                this.unregisterRadioFrequencyRanges();
                break;
            }
            case 48: {
                this.unregisterTrafficAnnouncement();
                break;
            }
            case 49: {
                this.unregisterRadioText();
                break;
            }
            case 1: {
                this.unregisterLocation();
                break;
            }
            case 7: {
                this.unregisterGuidanceState();
                break;
            }
            case 8: {
                this.unregisterGuidanceDestination();
                break;
            }
            case 24: {
                this.unregisterGuidanceRemaining();
                break;
            }
            case 29: {
                this.unregisterLastDestinations();
                break;
            }
            case 5: {
                this.unregisterSkinInfo();
                break;
            }
            case 6: {
                this.unregisterLanguageInfo();
                break;
            }
            case 13: {
                this.unregisterUnitDistance();
                break;
            }
            case 51: {
                this.unregisterEncodedVehicleType();
                break;
            }
            default: {
                this.log.log(-2137614336, "[HasHelper#unsubscribe] unknown property %1", (long)n);
            }
        }
    }

    private boolean registerCurrentTrackInfo(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerCurrentTrackInfo] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerCurrentTrackInfo] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterCurrentTrackInfo() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerCurrentTrackInfo] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createCurrentTrackInfoWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerCurrentTrackInfo] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerCurrentTrackInfo] registering worker");
        ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker = new ExlapCurrentTrackInfoWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapCurrentTrackInfoWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker).getName(), exlapCurrentTrackInfoWorker);
        return true;
    }

    private void stopCurrentTrackInfoWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerCurrentTrackInfo] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerMediaPlayInfo(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerMediaPlayInfo] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaPlayInfo] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterMediaPlayInfo() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaPlayInfo] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createMediaPlayInfoWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerMediaPlayInfo] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaPlayInfo] registering worker");
        ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker = new ExlapMediaPlayInfoWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapMediaPlayInfoWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker).getName(), exlapMediaPlayInfoWorker);
        return true;
    }

    private void stopMediaPlayInfoWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaPlayInfo] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerMediaPlayMode(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerMediaPlayMode] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaPlayMode] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterMediaPlayMode() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaPlayMode] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createMediaPlayModeWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerMediaPlayMode] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaPlayMode] registering worker");
        ExlapMediaPlayModeWorker exlapMediaPlayModeWorker = new ExlapMediaPlayModeWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapMediaPlayModeWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker).getName(), exlapMediaPlayModeWorker);
        return true;
    }

    private void stopMediaPlayModeWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaPlayModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaPlayMode] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableMediaSources(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableMediaSources] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableMediaSources] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableMediaSources() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableMediaSources] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableMediaSourcesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableMediaSources] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableMediaSources] registering worker");
        ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker = new ExlapAvailableMediaSourcesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableMediaSourcesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker).getName(), exlapAvailableMediaSourcesWorker);
        return true;
    }

    private void stopAvailableMediaSourcesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableMediaSourcesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableMediaSources] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerMediaBrowserList(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserList] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserList] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterMediaBrowserList() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserList] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createMediaBrowserListWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserList] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserList] registering worker");
        ExlapMediaBrowserListWorker exlapMediaBrowserListWorker = new ExlapMediaBrowserListWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapMediaBrowserListWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker).getName(), exlapMediaBrowserListWorker);
        return true;
    }

    private void stopMediaBrowserListWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserListWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserList] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerMediaBrowserFollowMode(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserFollowMode] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFollowMode] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterMediaBrowserFollowMode() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFollowMode] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createMediaBrowserFollowModeWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserFollowMode] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFollowMode] registering worker");
        ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker = new ExlapMediaBrowserFollowModeWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapMediaBrowserFollowModeWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker).getName(), exlapMediaBrowserFollowModeWorker);
        return true;
    }

    private void stopMediaBrowserFollowModeWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFollowModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFollowMode] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerMediaBrowserFolder(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserFolder] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFolder] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterMediaBrowserFolder() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFolder] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createMediaBrowserFolderWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerMediaBrowserFolder] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFolder] registering worker");
        ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker = new ExlapMediaBrowserFolderWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapMediaBrowserFolderWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker).getName(), exlapMediaBrowserFolderWorker);
        return true;
    }

    private void stopMediaBrowserFolderWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapMediaBrowserFolderWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerMediaBrowserFolder] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerCurrentTrackPath(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerCurrentTrackPath] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerCurrentTrackPath] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterCurrentTrackPath() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerCurrentTrackPath] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createCurrentTrackPathWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerCurrentTrackPath] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerCurrentTrackPath] registering worker");
        ExlapCurrentTrackPathWorker exlapCurrentTrackPathWorker = new ExlapCurrentTrackPathWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapCurrentTrackPathWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker).getName(), exlapCurrentTrackPathWorker);
        return true;
    }

    private void stopCurrentTrackPathWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapCurrentTrackPathWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerCurrentTrackPath] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAppConnectDevice(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAppConnectDevice] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAppConnectDevice] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAppConnectDevice() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAppConnectDevice] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAppConnectDeviceWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAppConnectDevice] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAppConnectDevice] registering worker");
        ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker = new ExlapAppConnectDeviceWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAppConnectDeviceWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker).getName(), exlapAppConnectDeviceWorker);
        return true;
    }

    private void stopAppConnectDeviceWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAppConnectDeviceWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAppConnectDevice] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerExlapRestrictionMode(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerExlapRestrictionMode] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerExlapRestrictionMode] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterExlapRestrictionMode() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerExlapRestrictionMode] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createExlapRestrictionModeWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerExlapRestrictionMode] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerExlapRestrictionMode] registering worker");
        ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker = new ExlapExlapRestrictionModeWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapExlapRestrictionModeWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker).getName(), exlapExlapRestrictionModeWorker);
        return true;
    }

    private void stopExlapRestrictionModeWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapExlapRestrictionModeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerExlapRestrictionMode] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerSoundVolume(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerSoundVolume] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerSoundVolume] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterSoundVolume() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSoundVolume] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createSoundVolumeWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerSoundVolume] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerSoundVolume] registering worker");
        ExlapSoundVolumeWorker exlapSoundVolumeWorker = new ExlapSoundVolumeWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapSoundVolumeWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker).getName(), exlapSoundVolumeWorker);
        return true;
    }

    private void stopSoundVolumeWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSoundVolume] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerSoundVolumeRanges(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerSoundVolumeRanges] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerSoundVolumeRanges] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterSoundVolumeRanges() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSoundVolumeRanges] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createSoundVolumeRangesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerSoundVolumeRanges] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerSoundVolumeRanges] registering worker");
        ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker = new ExlapSoundVolumeRangesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapSoundVolumeRangesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker).getName(), exlapSoundVolumeRangesWorker);
        return true;
    }

    private void stopSoundVolumeRangesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSoundVolumeRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSoundVolumeRanges] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerBalanceFader(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerBalanceFader] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerBalanceFader] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterBalanceFader() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerBalanceFader] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createBalanceFaderWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerBalanceFader] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerBalanceFader] registering worker");
        ExlapBalanceFaderWorker exlapBalanceFaderWorker = new ExlapBalanceFaderWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapBalanceFaderWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker).getName(), exlapBalanceFaderWorker);
        return true;
    }

    private void stopBalanceFaderWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerBalanceFader] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerBalanceFaderRanges(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerBalanceFaderRanges] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerBalanceFaderRanges] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterBalanceFaderRanges() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerBalanceFaderRanges] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createBalanceFaderRangesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerBalanceFaderRanges] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerBalanceFaderRanges] registering worker");
        ExlapBalanceFaderRangesWorker exlapBalanceFaderRangesWorker = new ExlapBalanceFaderRangesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapBalanceFaderRangesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker).getName(), exlapBalanceFaderRangesWorker);
        return true;
    }

    private void stopBalanceFaderRangesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapBalanceFaderRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerBalanceFaderRanges] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerEntertainmentContext(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerEntertainmentContext] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerEntertainmentContext] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterEntertainmentContext() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerEntertainmentContext] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createEntertainmentContextWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerEntertainmentContext] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerEntertainmentContext] registering worker");
        ExlapEntertainmentContextWorker exlapEntertainmentContextWorker = new ExlapEntertainmentContextWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapEntertainmentContextWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker).getName(), exlapEntertainmentContextWorker);
        return true;
    }

    private void stopEntertainmentContextWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEntertainmentContextWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerEntertainmentContext] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerContextStates(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerContextStates] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerContextStates] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterContextStates() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerContextStates] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createContextStatesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerContextStates] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerContextStates] registering worker");
        ExlapContextStatesWorker exlapContextStatesWorker = new ExlapContextStatesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapContextStatesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker).getName(), exlapContextStatesWorker);
        return true;
    }

    private void stopContextStatesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapContextStatesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerContextStates] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableRadioBands(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableRadioBands] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableRadioBands] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableRadioBands() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableRadioBands] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableRadioBandsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableRadioBands] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableRadioBands] registering worker");
        ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker = new ExlapAvailableRadioBandsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableRadioBandsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker).getName(), exlapAvailableRadioBandsWorker);
        return true;
    }

    private void stopAvailableRadioBandsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableRadioBandsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableRadioBands] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableAMStations(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableAMStations] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableAMStations] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableAMStations() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableAMStations] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableAMStationsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableAMStations] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableAMStations] registering worker");
        ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker = new ExlapAvailableAMStationsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableAMStationsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker).getName(), exlapAvailableAMStationsWorker);
        return true;
    }

    private void stopAvailableAMStationsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableAMStationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableAMStations] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableFMStations(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableFMStations] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableFMStations] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableFMStations() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableFMStations] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableFMStationsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableFMStations] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableFMStations] registering worker");
        ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker = new ExlapAvailableFMStationsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableFMStationsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker).getName(), exlapAvailableFMStationsWorker);
        return true;
    }

    private void stopAvailableFMStationsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableFMStationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableFMStations] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableDABEnsembles(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABEnsembles] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABEnsembles] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableDABEnsembles() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABEnsembles] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableDABEnsemblesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABEnsembles] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABEnsembles] registering worker");
        ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker = new ExlapAvailableDABEnsemblesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableDABEnsemblesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker).getName(), exlapAvailableDABEnsemblesWorker);
        return true;
    }

    private void stopAvailableDABEnsemblesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABEnsemblesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABEnsembles] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableDABServices(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABServices] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABServices] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableDABServices() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABServices] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableDABServicesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABServices] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABServices] registering worker");
        ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker = new ExlapAvailableDABServicesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableDABServicesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker).getName(), exlapAvailableDABServicesWorker);
        return true;
    }

    private void stopAvailableDABServicesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServicesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABServices] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerAvailableDABServiceComponents(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABServiceComponents] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABServiceComponents] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterAvailableDABServiceComponents() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABServiceComponents] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createAvailableDABServiceComponentsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerAvailableDABServiceComponents] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerAvailableDABServiceComponents] registering worker");
        ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker = new ExlapAvailableDABServiceComponentsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapAvailableDABServiceComponentsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker).getName(), exlapAvailableDABServiceComponentsWorker);
        return true;
    }

    private void stopAvailableDABServiceComponentsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapAvailableDABServiceComponentsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerAvailableDABServiceComponents] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioAMPresets(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioAMPresets] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioAMPresets] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioAMPresets() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioAMPresets] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioAMPresetsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioAMPresets] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioAMPresets] registering worker");
        ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker = new ExlapRadioAMPresetsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioAMPresetsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker).getName(), exlapRadioAMPresetsWorker);
        return true;
    }

    private void stopRadioAMPresetsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioAMPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioAMPresets] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioFMPresets(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioFMPresets] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioFMPresets] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioFMPresets() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioFMPresets] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioFMPresetsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioFMPresets] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioFMPresets] registering worker");
        ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker = new ExlapRadioFMPresetsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioFMPresetsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker).getName(), exlapRadioFMPresetsWorker);
        return true;
    }

    private void stopRadioFMPresetsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFMPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioFMPresets] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioDABPresets(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioDABPresets] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioDABPresets] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioDABPresets() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioDABPresets] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioDABPresetsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioDABPresets] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioDABPresets] registering worker");
        ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker = new ExlapRadioDABPresetsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioDABPresetsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker).getName(), exlapRadioDABPresetsWorker);
        return true;
    }

    private void stopRadioDABPresetsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioDABPresetsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioDABPresets] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioTuner(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioTuner] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioTuner] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioTuner() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioTuner] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioTunerWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioTuner] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioTuner] registering worker");
        ExlapRadioTunerWorker exlapRadioTunerWorker = new ExlapRadioTunerWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioTunerWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker).getName(), exlapRadioTunerWorker);
        return true;
    }

    private void stopRadioTunerWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTunerWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioTuner] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioFrequencyRanges(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioFrequencyRanges] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioFrequencyRanges] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioFrequencyRanges() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioFrequencyRanges] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioFrequencyRangesWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioFrequencyRanges] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioFrequencyRanges] registering worker");
        ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker = new ExlapRadioFrequencyRangesWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioFrequencyRangesWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker).getName(), exlapRadioFrequencyRangesWorker);
        return true;
    }

    private void stopRadioFrequencyRangesWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioFrequencyRangesWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioFrequencyRanges] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerTrafficAnnouncement(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerTrafficAnnouncement] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerTrafficAnnouncement] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterTrafficAnnouncement() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerTrafficAnnouncement] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createTrafficAnnouncementWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerTrafficAnnouncement] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerTrafficAnnouncement] registering worker");
        ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker = new ExlapTrafficAnnouncementWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapTrafficAnnouncementWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker).getName(), exlapTrafficAnnouncementWorker);
        return true;
    }

    private void stopTrafficAnnouncementWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapTrafficAnnouncementWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerTrafficAnnouncement] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerRadioText(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerRadioText] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioText] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterRadioText() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioText] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createRadioTextWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerRadioText] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerRadioText] registering worker");
        ExlapRadioTextWorker exlapRadioTextWorker = new ExlapRadioTextWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapRadioTextWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker).getName(), exlapRadioTextWorker);
        return true;
    }

    private void stopRadioTextWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapRadioTextWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerRadioText] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerLocation(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLocationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerLocation] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerLocation] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterLocation() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLocationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLocation] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createLocationWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLocationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerLocation] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerLocation] registering worker");
        ExlapLocationWorker exlapLocationWorker = new ExlapLocationWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapLocationWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLocationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker).getName(), exlapLocationWorker);
        return true;
    }

    private void stopLocationWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLocationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLocationWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLocation] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerGuidanceState(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerGuidanceState] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceState] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterGuidanceState() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceState] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createGuidanceStateWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerGuidanceState] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceState] registering worker");
        ExlapGuidanceStateWorker exlapGuidanceStateWorker = new ExlapGuidanceStateWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapGuidanceStateWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker).getName(), exlapGuidanceStateWorker);
        return true;
    }

    private void stopGuidanceStateWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceStateWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceState] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerGuidanceDestination(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerGuidanceDestination] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceDestination] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterGuidanceDestination() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceDestination] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createGuidanceDestinationWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerGuidanceDestination] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceDestination] registering worker");
        ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker = new ExlapGuidanceDestinationWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapGuidanceDestinationWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker).getName(), exlapGuidanceDestinationWorker);
        return true;
    }

    private void stopGuidanceDestinationWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceDestinationWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceDestination] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerGuidanceRemaining(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerGuidanceRemaining] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceRemaining] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterGuidanceRemaining() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceRemaining] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createGuidanceRemainingWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerGuidanceRemaining] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerGuidanceRemaining] registering worker");
        ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker = new ExlapGuidanceRemainingWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapGuidanceRemainingWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker).getName(), exlapGuidanceRemainingWorker);
        return true;
    }

    private void stopGuidanceRemainingWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapGuidanceRemainingWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerGuidanceRemaining] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerLastDestinations(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerLastDestinations] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerLastDestinations] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterLastDestinations() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLastDestinations] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createLastDestinationsWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerLastDestinations] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerLastDestinations] registering worker");
        ExlapLastDestinationsWorker exlapLastDestinationsWorker = new ExlapLastDestinationsWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapLastDestinationsWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker).getName(), exlapLastDestinationsWorker);
        return true;
    }

    private void stopLastDestinationsWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLastDestinationsWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLastDestinations] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerSkinInfo(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerSkinInfo] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerSkinInfo] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterSkinInfo() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSkinInfo] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createSkinInfoWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerSkinInfo] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerSkinInfo] registering worker");
        ExlapSkinInfoWorker exlapSkinInfoWorker = new ExlapSkinInfoWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapSkinInfoWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker).getName(), exlapSkinInfoWorker);
        return true;
    }

    private void stopSkinInfoWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapSkinInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerSkinInfo] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerLanguageInfo(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerLanguageInfo] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerLanguageInfo] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterLanguageInfo() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLanguageInfo] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createLanguageInfoWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerLanguageInfo] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerLanguageInfo] registering worker");
        ExlapLanguageInfoWorker exlapLanguageInfoWorker = new ExlapLanguageInfoWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapLanguageInfoWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker).getName(), exlapLanguageInfoWorker);
        return true;
    }

    private void stopLanguageInfoWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapLanguageInfoWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerLanguageInfo] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerUnitDistance(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerUnitDistance] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerUnitDistance] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterUnitDistance() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerUnitDistance] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createUnitDistanceWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerUnitDistance] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerUnitDistance] registering worker");
        ExlapUnitDistanceWorker exlapUnitDistanceWorker = new ExlapUnitDistanceWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapUnitDistanceWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker).getName(), exlapUnitDistanceWorker);
        return true;
    }

    private void stopUnitDistanceWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapUnitDistanceWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerUnitDistance] unregistering worker");
            iExlapWorker.stop();
        }
    }

    private boolean registerEncodedVehicleType(int n) {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker).getName());
        if (iExlapWorker == null) {
            this.log.log(14808325, "[HasHelper#registerEncodedVehicleType] worker/service not available");
            return false;
        }
        this.log.log(-2137614336, "[HasHelper#registerEncodedVehicleType] registering worker");
        iExlapWorker.enable(n);
        return true;
    }

    private void unregisterEncodedVehicleType() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.get((class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerEncodedVehicleType] unregistering worker");
            iExlapWorker.disable();
        }
    }

    private boolean createEncodedVehicleTypeWorker(ExlapService exlapService, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        if (this.workers.containsKey((class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker).getName())) {
            this.log.log(14808325, "[HasHelper#registerEncodedVehicleType] worker already registered");
            return true;
        }
        this.log.log(-2137614336, "[HasHelper#registerEncodedVehicleType] registering worker");
        ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker = new ExlapEncodedVehicleTypeWorker(this.framework, exlapDispatcher, dSIHAS);
        exlapEncodedVehicleTypeWorker.init(exlapService);
        this.workers.put((class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker).getName(), exlapEncodedVehicleTypeWorker);
        return true;
    }

    private void stopEncodedVehicleTypeWorker() {
        IExlapWorker iExlapWorker = (IExlapWorker)this.workers.remove((class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker == null ? (class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker = HasHelper.class$("de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker")) : class$de$audi$tghu$exlap$impl$worker$ExlapEncodedVehicleTypeWorker).getName());
        if (iExlapWorker != null) {
            this.log.log(-2137614336, "[HasHelper#registerEncodedVehicleType] unregistering worker");
            iExlapWorker.stop();
        }
    }

    public String getClassForActionId(int n) {
        switch (n) {
            case 6: 
            case 7: 
            case 8: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 29: 
            case 32: 
            case 33: 
            case 35: 
            case 36: 
            case 39: {
                return (class$de$audi$tghu$exlap$ifc$service$ExlapMediaService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapMediaService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapMediaService")) : class$de$audi$tghu$exlap$ifc$service$ExlapMediaService).getName();
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 34: {
                return (class$de$audi$tghu$exlap$ifc$service$ExlapSoundService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSoundService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapSoundService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSoundService).getName();
            }
            case 14: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 30: 
            case 31: {
                return (class$de$audi$tghu$exlap$ifc$service$ExlapRadioService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapRadioService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapRadioService")) : class$de$audi$tghu$exlap$ifc$service$ExlapRadioService).getName();
            }
            case 2: 
            case 5: 
            case 9: 
            case 20: 
            case 38: {
                return (class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService = HasHelper.class$("de.audi.tghu.exlap.ifc.service.ExlapNavigationService")) : class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService).getName();
            }
        }
        this.log.log(-1601830656, "[HasHelper#getClassForActionId] no class for action id: %1", (long)n);
        return null;
    }

    private Container createContainer(HASDataContainer hASDataContainer) {
        switch (hASDataContainer.containerId) {
            case 1: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container AddressContainer");
                return new AddressContainer(hASDataContainer.dataElements);
            }
            case 5: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container SkinInfoContainer");
                return new SkinInfoContainer(hASDataContainer.dataElements);
            }
            case 6: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container LanguageInfoContainer");
                return new LanguageInfoContainer(hASDataContainer.dataElements);
            }
            case 7: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container GuidanceStateContainer");
                return new GuidanceStateContainer(hASDataContainer.dataElements);
            }
            case 14: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container UnitDistanceContainer");
                return new UnitDistanceContainer(hASDataContainer.dataElements);
            }
            case 21: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaBrowserEntryContainer");
                return new MediaBrowserEntryContainer(hASDataContainer.dataElements);
            }
            case 22: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container TrackInfoContainer");
                return new TrackInfoContainer(hASDataContainer.dataElements);
            }
            case 23: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaPlayInfoContainer");
                return new MediaPlayInfoContainer(hASDataContainer.dataElements);
            }
            case 24: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaPlayModeContainer");
                return new MediaPlayModeContainer(hASDataContainer.dataElements);
            }
            case 25: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container GuidanceRemainingContainer");
                return new GuidanceRemainingContainer(hASDataContainer.dataElements);
            }
            case 26: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioStationInfoContainer");
                return new RadioStationInfoContainer(hASDataContainer.dataElements);
            }
            case 27: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container SoundVolumeContainer");
                return new SoundVolumeContainer(hASDataContainer.dataElements);
            }
            case 28: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container SoundVolumeRangeContainer");
                return new SoundVolumeRangeContainer(hASDataContainer.dataElements);
            }
            case 29: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container SoundVolumeRangesContainer");
                return new SoundVolumeRangesContainer(hASDataContainer.dataElements);
            }
            case 30: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioBandContainer");
                return new RadioBandContainer(hASDataContainer.dataElements);
            }
            case 31: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container TrackPositionContainer");
                return new TrackPositionContainer(hASDataContainer.dataElements);
            }
            case 32: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaSourceStateContainer");
                return new MediaSourceStateContainer(hASDataContainer.dataElements);
            }
            case 33: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaSourcesContainer");
                return new MediaSourcesContainer(hASDataContainer.dataElements);
            }
            case 34: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaSourceContainer");
                return new MediaSourceContainer(hASDataContainer.dataElements);
            }
            case 35: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioBandsContainer");
                return new RadioBandsContainer(hASDataContainer.dataElements);
            }
            case 36: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container LastDestinationContainer");
                return new LastDestinationContainer(hASDataContainer.dataElements);
            }
            case 37: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container LastDestinationsContainer");
                return new LastDestinationsContainer(hASDataContainer.dataElements);
            }
            case 38: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ExlapRestrictionModeContainer");
                return new ExlapRestrictionModeContainer(hASDataContainer.dataElements);
            }
            case 39: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioStationsContainer");
                return new RadioStationsContainer(hASDataContainer.dataElements);
            }
            case 40: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioPresetContainer");
                return new RadioPresetContainer(hASDataContainer.dataElements);
            }
            case 41: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioPresetsContainer");
                return new RadioPresetsContainer(hASDataContainer.dataElements);
            }
            case 42: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioFrequencyRangesContainer");
                return new RadioFrequencyRangesContainer(hASDataContainer.dataElements);
            }
            case 43: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioFrequencyContainer");
                return new RadioFrequencyContainer(hASDataContainer.dataElements);
            }
            case 45: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioPresetIndexContainer");
                return new RadioPresetIndexContainer(hASDataContainer.dataElements);
            }
            case 46: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container FollowModeContainer");
                return new FollowModeContainer(hASDataContainer.dataElements);
            }
            case 48: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container BalanceFaderContainer");
                return new BalanceFaderContainer(hASDataContainer.dataElements);
            }
            case 49: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container BalanceFaderRangesContainer");
                return new BalanceFaderRangesContainer(hASDataContainer.dataElements);
            }
            case 50: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaBrowserPathContainer");
                return new MediaBrowserPathContainer(hASDataContainer.dataElements);
            }
            case 51: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container TrafficAnnouncementContainer");
                return new TrafficAnnouncementContainer(hASDataContainer.dataElements);
            }
            case 52: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container RadioTextContainer");
                return new RadioTextContainer(hASDataContainer.dataElements);
            }
            case 53: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container EncodedVehicleTypeContainer");
                return new EncodedVehicleTypeContainer(hASDataContainer.dataElements);
            }
            case 59: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ImportGPXDataContainer");
                return new ImportGPXDataContainer(hASDataContainer.dataElements);
            }
            case 60: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ImportGPXResultContainer");
                return new ImportGPXResultContainer(hASDataContainer.dataElements);
            }
            case 64: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container AppConnectDeviceContainer");
                return new AppConnectDeviceContainer(hASDataContainer.dataElements);
            }
            case 65: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container EntertainmentContextContainer");
                return new EntertainmentContextContainer(hASDataContainer.dataElements);
            }
            case 66: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container MediaCapabilitiesContainer");
                return new MediaCapabilitiesContainer(hASDataContainer.dataElements);
            }
            case 67: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container StartGuidanceResultContainer");
                return new StartGuidanceResultContainer(hASDataContainer.dataElements);
            }
            case 0x1000000: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ContextStateContainer");
                return new ContextStateContainer(hASDataContainer.dataElements);
            }
            case 0x1000001: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ContextStatesContainer");
                return new ContextStatesContainer(hASDataContainer.dataElements);
            }
            case 0x1000002: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ListStateContainer");
                return new ListStateContainer(hASDataContainer.dataElements);
            }
            case 0x1000003: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ListPageRequestContainer");
                return new ListPageRequestContainer(hASDataContainer.dataElements);
            }
            case 0x1000004: {
                this.log.log(14808325, "[HasHelper#createContainer] creating container ListPageDataContainer");
                return new ListPageDataContainer(hASDataContainer.dataElements);
            }
        }
        this.log.log(10000, "[HasHelper#createContainer] invalid container: %1", (Object)hASDataContainer.toString());
        return null;
    }

    private void setChild(int n, Container container, Container container2) {
        switch (n) {
            case 21: {
                ((MediaBrowserEntryContainer)container).setTrackInfo((TrackInfoContainer)container2);
                break;
            }
            case 29: {
                ((SoundVolumeRangesContainer)container).addVolumeRange((SoundVolumeRangeContainer)container2);
                break;
            }
            case 32: {
                ((MediaSourceStateContainer)container).setCapabilities((MediaCapabilitiesContainer)container2);
                break;
            }
            case 33: {
                ((MediaSourcesContainer)container).addSource((MediaSourceStateContainer)container2);
                break;
            }
            case 35: {
                ((RadioBandsContainer)container).addBand((RadioBandContainer)container2);
                break;
            }
            case 37: {
                ((LastDestinationsContainer)container).addDestination((LastDestinationContainer)container2);
                break;
            }
            case 39: {
                ((RadioStationsContainer)container).addStation((RadioStationInfoContainer)container2);
                break;
            }
            case 40: {
                ((RadioPresetContainer)container).setStation((RadioStationInfoContainer)container2);
                break;
            }
            case 41: {
                ((RadioPresetsContainer)container).addStation((RadioPresetContainer)container2);
                break;
            }
            case 50: {
                ((MediaBrowserPathContainer)container).addEntry((MediaBrowserEntryContainer)container2);
                break;
            }
            case 0x1000001: {
                ((ContextStatesContainer)container).addState((ContextStateContainer)container2);
                break;
            }
            case 0x1000004: {
                ((ListPageDataContainer)container).addPageData(container2);
                break;
            }
            default: {
                this.log.log(10000, "[HasHelper#setChild] invalid containerId: %1", (long)n);
            }
        }
    }

    public void callAction(int n, int n2, Container container, ExlapService exlapService) {
        switch (n2) {
            case 6: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: setPlayMode", (long)n2);
                ((ExlapMediaService)exlapService).setPlayMode(n, (MediaPlayModeContainer)container);
                return;
            }
            case 7: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: nextTrack", (long)n2);
                ((ExlapMediaService)exlapService).nextTrack(n);
                return;
            }
            case 8: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: previousTrack", (long)n2);
                ((ExlapMediaService)exlapService).previousTrack(n);
                return;
            }
            case 15: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: playMedia", (long)n2);
                ((ExlapMediaService)exlapService).playMedia(n);
                return;
            }
            case 16: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: pauseMedia", (long)n2);
                ((ExlapMediaService)exlapService).pauseMedia(n);
                return;
            }
            case 17: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: setTrackPosition", (long)n2);
                ((ExlapMediaService)exlapService).setTrackPosition(n, (TrackPositionContainer)container);
                return;
            }
            case 18: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: activateMediaSource", (long)n2);
                ((ExlapMediaService)exlapService).activateMediaSource(n, (MediaSourceContainer)container);
                return;
            }
            case 19: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: selectMediaBrowserSource", (long)n2);
                ((ExlapMediaService)exlapService).selectMediaBrowserSource(n, (MediaSourceContainer)container);
                return;
            }
            case 29: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: mediaBrowserList", (long)n2);
                ((ExlapMediaService)exlapService).mediaBrowserList(n, (ListPageRequestContainer)container);
                return;
            }
            case 32: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: enableMediaBrowserFollowMode", (long)n2);
                ((ExlapMediaService)exlapService).enableMediaBrowserFollowMode(n);
                return;
            }
            case 33: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: disableMediaBrowserFollowMode", (long)n2);
                ((ExlapMediaService)exlapService).disableMediaBrowserFollowMode(n);
                return;
            }
            case 35: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: changeMediaBrowserFolder", (long)n2);
                ((ExlapMediaService)exlapService).changeMediaBrowserFolder(n, (MediaBrowserPathContainer)container);
                return;
            }
            case 36: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: mediaBrowserPlay", (long)n2);
                ((ExlapMediaService)exlapService).mediaBrowserPlay(n, (MediaBrowserEntryContainer)container);
                return;
            }
            case 39: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: activateAppConnectAudio", (long)n2);
                ((ExlapMediaService)exlapService).activateAppConnectAudio(n);
                return;
            }
            case 10: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: increaseVolume", (long)n2);
                ((ExlapSoundService)exlapService).increaseVolume(n);
                return;
            }
            case 11: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: decreaseVolume", (long)n2);
                ((ExlapSoundService)exlapService).decreaseVolume(n);
                return;
            }
            case 12: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: muteEntertainment", (long)n2);
                ((ExlapSoundService)exlapService).muteEntertainment(n);
                return;
            }
            case 13: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: unmuteEntertainment", (long)n2);
                ((ExlapSoundService)exlapService).unmuteEntertainment(n);
                return;
            }
            case 34: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: setBalanceFader", (long)n2);
                ((ExlapSoundService)exlapService).setBalanceFader(n, (BalanceFaderContainer)container);
                return;
            }
            case 14: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: activateRadioBand", (long)n2);
                ((ExlapRadioService)exlapService).activateRadioBand(n, (RadioBandContainer)container);
                return;
            }
            case 21: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: tuneStation", (long)n2);
                ((ExlapRadioService)exlapService).tuneStation(n, (RadioStationInfoContainer)container);
                return;
            }
            case 22: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: tune", (long)n2);
                ((ExlapRadioService)exlapService).tune(n, (RadioFrequencyContainer)container);
                return;
            }
            case 23: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: nextRadioStation", (long)n2);
                ((ExlapRadioService)exlapService).nextRadioStation(n);
                return;
            }
            case 24: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: previousRadioStation", (long)n2);
                ((ExlapRadioService)exlapService).previousRadioStation(n);
                return;
            }
            case 25: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: seekForward", (long)n2);
                ((ExlapRadioService)exlapService).seekForward(n);
                return;
            }
            case 26: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: seekBackward", (long)n2);
                ((ExlapRadioService)exlapService).seekBackward(n);
                return;
            }
            case 27: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: increaseRadioFrequency", (long)n2);
                ((ExlapRadioService)exlapService).increaseRadioFrequency(n);
                return;
            }
            case 28: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: decreaseRadioFrequency", (long)n2);
                ((ExlapRadioService)exlapService).decreaseRadioFrequency(n);
                return;
            }
            case 30: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: storePreset", (long)n2);
                ((ExlapRadioService)exlapService).storePreset(n, (RadioPresetIndexContainer)container);
                return;
            }
            case 31: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: deletePreset", (long)n2);
                ((ExlapRadioService)exlapService).deletePreset(n, (RadioPresetIndexContainer)container);
                return;
            }
            case 2: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: startGuidance", (long)n2);
                ((ExlapNavigationService)exlapService).startGuidance(n, (AddressContainer)container);
                return;
            }
            case 5: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: resolveAddress", (long)n2);
                ((ExlapNavigationService)exlapService).resolveAddress(n, (AddressContainer)container);
                return;
            }
            case 9: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: stopGuidance", (long)n2);
                ((ExlapNavigationService)exlapService).stopGuidance(n);
                return;
            }
            case 20: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: resolveLastDestination", (long)n2);
                ((ExlapNavigationService)exlapService).resolveLastDestination(n, (LastDestinationContainer)container);
                return;
            }
            case 38: {
                this.log.log(14808325, "[HasHelper#callAction] calling action id %1: importGPX", (long)n2);
                ((ExlapNavigationService)exlapService).importGPX(n, (ImportGPXDataContainer)container);
                return;
            }
        }
        this.log.log(-1601830656, "[HasHelper#callAction] no action for id: %1", (long)n2);
    }

    public boolean isImmediateResult(int n) {
        switch (n) {
            case 6: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: setPlayMode immediate", (long)n);
                return true;
            }
            case 7: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: nextTrack immediate", (long)n);
                return true;
            }
            case 8: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: previousTrack immediate", (long)n);
                return true;
            }
            case 15: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: playMedia immediate", (long)n);
                return true;
            }
            case 16: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: pauseMedia immediate", (long)n);
                return true;
            }
            case 17: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: setTrackPosition immediate", (long)n);
                return true;
            }
            case 18: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: activateMediaSource immediate", (long)n);
                return true;
            }
            case 19: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: selectMediaBrowserSource immediate", (long)n);
                return true;
            }
            case 29: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: mediaBrowserList not immediate", (long)n);
                return false;
            }
            case 32: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: enableMediaBrowserFollowMode immediate", (long)n);
                return true;
            }
            case 33: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: disableMediaBrowserFollowMode immediate", (long)n);
                return true;
            }
            case 35: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: changeMediaBrowserFolder immediate", (long)n);
                return true;
            }
            case 36: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: mediaBrowserPlay immediate", (long)n);
                return true;
            }
            case 39: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: activateAppConnectAudio immediate", (long)n);
                return true;
            }
            case 10: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: increaseVolume immediate", (long)n);
                return true;
            }
            case 11: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: decreaseVolume immediate", (long)n);
                return true;
            }
            case 12: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: muteEntertainment immediate", (long)n);
                return true;
            }
            case 13: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: unmuteEntertainment immediate", (long)n);
                return true;
            }
            case 34: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: setBalanceFader immediate", (long)n);
                return true;
            }
            case 14: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: activateRadioBand immediate", (long)n);
                return true;
            }
            case 21: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: tuneStation immediate", (long)n);
                return true;
            }
            case 22: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: tune immediate", (long)n);
                return true;
            }
            case 23: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: nextRadioStation immediate", (long)n);
                return true;
            }
            case 24: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: previousRadioStation immediate", (long)n);
                return true;
            }
            case 25: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: seekForward immediate", (long)n);
                return true;
            }
            case 26: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: seekBackward immediate", (long)n);
                return true;
            }
            case 27: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: increaseRadioFrequency immediate", (long)n);
                return true;
            }
            case 28: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: decreaseRadioFrequency immediate", (long)n);
                return true;
            }
            case 30: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: storePreset immediate", (long)n);
                return true;
            }
            case 31: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: deletePreset immediate", (long)n);
                return true;
            }
            case 2: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: startGuidance not immediate", (long)n);
                return false;
            }
            case 5: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: resolveAddress not immediate", (long)n);
                return false;
            }
            case 9: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: stopGuidance immediate", (long)n);
                return true;
            }
            case 20: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: resolveLastDestination not immediate", (long)n);
                return false;
            }
            case 38: {
                this.log.log(14808325, "[HasHelper#isImmediateResult] action id %1: importGPX not immediate", (long)n);
                return false;
            }
        }
        this.log.log(-1601830656, "[HasHelper#callAction] no action for id: %1", (long)n);
        return true;
    }

    public Container createContainer(HASDataContainer[] hASDataContainerArray) {
        int n = this.getParentContainer(hASDataContainerArray);
        Container container = this.createContainer(hASDataContainerArray[n]);
        this.parseContainer(hASDataContainerArray[n].hierarchyId, hASDataContainerArray[n].containerId, container, hASDataContainerArray);
        return container;
    }

    private void parseContainer(int n, int n2, Container container, HASDataContainer[] hASDataContainerArray) {
        for (int i2 = 0; i2 < hASDataContainerArray.length; ++i2) {
            if (hASDataContainerArray[i2].parentId != n) continue;
            Container container2 = this.createContainer(hASDataContainerArray[i2]);
            this.setChild(n2, container, container2);
            this.parseContainer(hASDataContainerArray[i2].hierarchyId, hASDataContainerArray[i2].containerId, container2, hASDataContainerArray);
        }
    }

    private int getParentContainer(HASDataContainer[] hASDataContainerArray) {
        for (int i2 = 0; i2 < hASDataContainerArray.length; ++i2) {
            if (hASDataContainerArray[i2].parentId != -1) continue;
            return i2;
        }
        throw new IllegalArgumentException("no parent container found");
    }

    public void unsubscribeAll() {
        this.log.log(1078071040, "[HasHelper#unsubscribeAll] unsubscribing all workers");
        Iterator iterator = this.workers.values().iterator();
        while (iterator.hasNext()) {
            IExlapWorker iExlapWorker = (IExlapWorker)iterator.next();
            iExlapWorker.disable();
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
}

