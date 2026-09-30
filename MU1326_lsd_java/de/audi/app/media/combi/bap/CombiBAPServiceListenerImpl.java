/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.DiagnosisCommandCombiSourceSwitch;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.log.LogChannel;

public class CombiBAPServiceListenerImpl
extends AbstractMediaTerminalComponent
implements CombiBAPServiceMediaListener {
    private static final String LOGCLASS = "CombiBAPServiceListenerImpl";
    private final CombiBAPController combiController;
    private final LogChannel logCombi;

    public CombiBAPServiceListenerImpl(IMediaTerminal iMediaTerminal, CombiBAPController combiBAPController) {
        super(iMediaTerminal);
        this.combiController = combiBAPController;
        this.logCombi = this.combiController.getLogChannel();
        iMediaTerminal.getDiagnosisManager().addCommandProvider(iMediaTerminal.getTerminalID(), new DiagnosisCommandCombiSourceSwitch(this));
    }

    public void selectListEntry(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.selectListEntry"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.selectListEntry] combiID='%2'", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n);
                CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.this.combiController.getIdMapper().getEntry(n);
                if (combiBAPMediaEntry == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.selectListEntry] No entryInfo found for ID '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n);
                    CombiBAPServiceListenerImpl.this.combiController.selectListEntryResult(false);
                    return;
                }
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.setActiveSourceState] No content adapter active.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.selectListEntryResult(false);
                    return;
                }
                if (!MediaUtils.isFileContentType(combiBAPMediaEntry.getEntryContentType())) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.setActiveSourceState] No file selected.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.selectListEntryResult(false);
                    return;
                }
                if (combiBAPMediaEntry.isCorrupt() || combiBAPMediaEntry.isDeadLink() || combiBAPMediaEntry.isImportPending() || combiBAPMediaEntry.isNoPlaybackDuringImport() || combiBAPMediaEntry.isProtected()) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.setActiveSourceState] File not selectable.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.selectListEntryResult(false);
                    return;
                }
                iCombiBAPContentAdapter.selectListEntry(combiBAPMediaEntry);
            }
        });
    }

    public void selectListEntryPresetList(int n) {
    }

    public void setActiveSourceState(final int n, final int n2) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.setActiveSourceState"){

            public void run() {
                int n3;
                boolean bl;
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.setActiveSourceState] PlayMode='%2',playScope='%3'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n, (long)n2);
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.setActiveSourceState] No content adapter active. Ignore.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    return;
                }
                switch (n) {
                    case 2: 
                    case 4: {
                        bl = true;
                        break;
                    }
                    default: {
                        bl = false;
                    }
                }
                switch (n2) {
                    case 2: {
                        n3 = 0;
                        break;
                    }
                    case 3: {
                        n3 = 1;
                        break;
                    }
                    case 5: {
                        n3 = 2;
                        break;
                    }
                    case 1: {
                        n3 = 3;
                        break;
                    }
                    case 4: {
                        n3 = 4;
                        break;
                    }
                    default: {
                        CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.setActiveSourceState] Scope '%2' not supported. Ignored.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n2);
                        CombiBAPServiceListenerImpl.this.combiController.updateActiveRepeatScope(iCombiBAPContentAdapter.getCurrentRepeatScope(), iCombiBAPContentAdapter.isMixActive());
                        return;
                    }
                }
                if (!iCombiBAPContentAdapter.setRepeatScope(n3, bl)) {
                    CombiBAPServiceListenerImpl.this.combiController.updateActiveRepeatScope(iCombiBAPContentAdapter.getCurrentRepeatScope(), iCombiBAPContentAdapter.isMixActive());
                }
            }
        });
    }

    public void skip(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.skip"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.skip] skipCount='%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n);
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.skip] No content adapter active. Ignore.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.skipResult(false);
                    return;
                }
                CombiBAPServiceListenerImpl.this.combiController.skipResult(iCombiBAPContentAdapter.skip(n > 0, Math.abs(n)));
            }
        });
    }

    public void switchSource(final int n, int n2, final int n3) {
        int n4;
        if (n2 == -1 && n == 11) {
            this.logCombi.log(1000000, "[%1.switchSource] Special handling for the single SD-Card slot of the STD Systems: Setting slotNumber from -1 to 0.", (Object)LOGCLASS);
            n4 = 0;
        } else {
            n4 = n2;
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.switchSource"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.switchSource] sourceType='%2',slotNumber='%3', partitionNumber='%4'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)Integer.toString(n), (Object)Integer.toString(n4), (Object)Integer.toString(n3));
                int n5 = CombiBAPUtils.getMediaSourceTypeOfCombiSourceType(n);
                CombiBAPServiceListenerImpl.this.logCombi.log(10000000, "[%1.switchSource] mediaSourceType='%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n5);
                if (n5 == -1) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.switchSource] No source type found for '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n);
                    CombiBAPServiceListenerImpl.this.combiController.switchSourceResult(false);
                    return;
                }
                ISourceController iSourceController = CombiBAPServiceListenerImpl.this.getTerminal().getSourceController();
                ISourceSlot iSourceSlot = iSourceController.getSelectedSlot();
                if (iSourceSlot != null && iSourceSlot.getSource().getType() == 4) {
                    CombiBAPServiceListenerImpl.this.logger.hmi().log(1000000, "[%1.onSwitchSource] FilePlayer currently active. Ingore.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.switchSourceResult(false);
                    return;
                }
                ISource iSource = iSourceController.getSource(n5);
                if (iSource == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.switchSource] [%2] Not supported", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)LogUtil.getSourceTypeStr(n5));
                    CombiBAPServiceListenerImpl.this.combiController.switchSourceResult(false);
                    return;
                }
                int n2 = iSource.getSlotNumberByPartition(n4, n3);
                ActivationContext activationContext = new ActivationContext(iSource.getSlot(n2));
                activationContext.addParameter("CLOSE_DRAWER", Boolean.TRUE);
                activationContext.addParameter("REQUEST_AUDIO_IN_ADVANCE", Boolean.TRUE);
                int n32 = CombiBAPServiceListenerImpl.this.getTerminal().getSourceController().activateSource(activationContext);
                if (n32 != 1 && n32 != 2) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.onSwitchSource] Source activation failed.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.switchSourceResult(false);
                    return;
                }
                CombiBAPServiceListenerImpl.this.getTerminal().getAudioManager().requestAudioFocus();
                CombiBAPServiceListenerImpl.this.combiController.switchSourceResult(true);
            }
        });
    }

    public void getNextListPos(final int n, final int n2) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.getNextListPos"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.getNextListPos] combiID='%2',offset='%3'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n, (long)n2);
                CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.this.combiController.getIdMapper().getEntry(n);
                if (combiBAPMediaEntry == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.getNextListPos] No entryInfo found for combiID '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n);
                    try {
                        CombiBAPServiceListenerImpl.this.combiController.getCombiBAPService().getNextListPosResult(1, n, -1, -1);
                    }
                    catch (Exception exception) {
                        CombiBAPServiceListenerImpl.this.logCombi.log(10000, "[%1.getNextListPos] Combi failed: %2", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Throwable)exception);
                    }
                    return;
                }
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.getNextListPos] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    try {
                        CombiBAPServiceListenerImpl.this.combiController.getCombiBAPService().getNextListPosResult(1, n, -1, -1);
                    }
                    catch (Exception exception) {
                        CombiBAPServiceListenerImpl.this.logCombi.log(10000, "[%1.getNextListPos] Combi failed: %2", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Throwable)exception);
                    }
                    return;
                }
                iCombiBAPContentAdapter.getNextListPos(combiBAPMediaEntry, n2);
            }
        });
    }

    public void goTo(final int n, final int n2) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.goTo"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.goTo] locationType='%2',combiID='%3'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n, (long)n2);
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.goTo] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    switch (n) {
                        case 0: {
                            CombiBAPServiceListenerImpl.this.combiController.gotoCurrentPlayingTrackResult(false);
                            break;
                        }
                        case 2: {
                            CombiBAPServiceListenerImpl.this.combiController.gotoParentFolderResult(false);
                            break;
                        }
                        case 1: {
                            CombiBAPServiceListenerImpl.this.combiController.gotoRootFolderResult(false);
                            break;
                        }
                        case 4: {
                            CombiBAPServiceListenerImpl.this.combiController.gotoSubFolderResult(false);
                            break;
                        }
                    }
                    return;
                }
                switch (n) {
                    case 0: {
                        iCombiBAPContentAdapter.gotoCurrentPlayingTrack();
                        break;
                    }
                    case 2: {
                        iCombiBAPContentAdapter.gotoParentFolder();
                        break;
                    }
                    case 1: {
                        iCombiBAPContentAdapter.gotoRootFolder();
                        break;
                    }
                    case 4: {
                        CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.this.combiController.getIdMapper().getEntry(n2);
                        if (combiBAPMediaEntry == null) {
                            CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.goTo] No entryInfo found for combiID '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n2);
                            CombiBAPServiceListenerImpl.this.combiController.gotoSubFolderResult(false);
                            return;
                        }
                        if (!MediaUtils.isFolderContentType(combiBAPMediaEntry.getEntryContentType())) {
                            CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.goTo] '%2' is no folder ('%3').", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)new Integer(n2), (Object)combiBAPMediaEntry);
                            CombiBAPServiceListenerImpl.this.combiController.gotoSubFolderResult(false);
                            return;
                        }
                        iCombiBAPContentAdapter.gotoSubFolder(combiBAPMediaEntry);
                        break;
                    }
                }
            }
        });
    }

    public void requestMediaBrowserListByID(final int n, final int n2, final int n3) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.requestMediaBrowserListByID"){

            public void run() {
                CombiBAPMediaEntry combiBAPMediaEntry;
                if (CombiBAPServiceListenerImpl.this.logCombi.isInfo()) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.requestMediaBrowserListByID] transactionID='%2',combiID='%3',numberOfEntries='%4'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
                }
                if ((combiBAPMediaEntry = CombiBAPServiceListenerImpl.this.combiController.getIdMapper().getEntry(n2)) == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(100000, "[%1.requestMediaBrowserListByID] No entryInfo found for combiID '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (long)n2);
                    CombiBAPServiceListenerImpl.this.combiController.responseList(n, 0, 0, new MediaListEntry[0]);
                    return;
                }
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.requestMediaBrowserListByID] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.responseList(n, 0, 0, new MediaListEntry[0]);
                    return;
                }
                iCombiBAPContentAdapter.requestListByEntryID(n, combiBAPMediaEntry, n3);
            }
        });
    }

    public void requestMediaBrowserListByIndex(final int n, final int n2, final int n3) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.requestMediaBrowserListByIndex"){

            public void run() {
                ICombiBAPContentAdapter iCombiBAPContentAdapter;
                if (CombiBAPServiceListenerImpl.this.logCombi.isInfo()) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.requestMediaBrowserListByIndex] transactionID='%2',startIndex='%3',numberOfEntries='%4'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
                }
                if ((iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter()) == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.requestMediaBrowserListByIndex] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.responseList(n, 0, 0, new MediaListEntry[0]);
                    return;
                }
                iCombiBAPContentAdapter.requestListByIndex(n, n2, n3);
            }
        });
    }

    public void startSeek(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.startSeek"){

            public void run() {
                ICombiBAPContentAdapter iCombiBAPContentAdapter;
                if (CombiBAPServiceListenerImpl.this.logCombi.isInfo()) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.startSeek] '%2'.", (Object)CombiBAPServiceListenerImpl.LOGCLASS, (Object)(n == 0 ? "FORWARD" : "BACKWARD"));
                }
                if ((iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter()) == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.startSeek] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.updateSeekState(false);
                    return;
                }
                iCombiBAPContentAdapter.startSeek(n == 0);
            }
        });
    }

    public void cancelSeek() {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CombiBAP.cancelSeek"){

            public void run() {
                CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.cancelSeek]", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.this.combiController.getActiveCombiContentAdapter();
                if (iCombiBAPContentAdapter == null) {
                    CombiBAPServiceListenerImpl.this.logCombi.log(1000000, "[%1.cancelSeek] No active combi content adapter.", (Object)CombiBAPServiceListenerImpl.LOGCLASS);
                    CombiBAPServiceListenerImpl.this.combiController.updateSeekState(false);
                    return;
                }
                iCombiBAPContentAdapter.stopSeek();
            }
        });
    }

    public void setPreferredList(int n) {
        this.combiController.updatePreferredList(n);
    }

    public void activateSource(int n) {
        this.logCombi.log(1000000, "[%1.activateSource] '%2'", (Object)LOGCLASS, (long)n);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (n != 1 || iSourceSlot == null) {
            this.combiController.updateActivateSourceResult(false);
        } else {
            boolean bl;
            this.combiController.updateActiveSource(iSourceSlot);
            this.combiController.updateActivateSourceResult(true);
            int n2 = iSourceSlot.getSource().getType();
            boolean bl2 = bl = n2 == 7 || n2 == 8;
            if (bl) {
                this.logCombi.log(1000000, "[%1.activateSource] 'TV/AV'", (Object)LOGCLASS);
                this.getTerminal().getAudioManager().switchAudioFocusToTV();
            } else {
                this.logCombi.log(1000000, "[%1.activateSource] 'MEDIA'", (Object)LOGCLASS);
                this.getTerminal().getAudioManager().requestAudioFocus();
            }
        }
    }

    public void requestCoverArt(long l, int n) {
    }
}

