/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener;
import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultListContentSupplier;
import de.audi.tv.app.lists.FocusHandler;
import de.audi.tv.app.lists.IListContentSupplier;

public class CombiBAPServiceTVListenerImpl
implements CombiBAPServiceTVListener {
    private final DSIHandler dsi;
    private final TVEnv env;
    private final CombiBAPServiceHandler serviceHandler;
    private final HardKeyListener hardKeyListener;
    private final AudioFocusClient audioFocus;
    private final FocusHandler listFocusHandler;
    private IListContentSupplier stationList = new DefaultListContentSupplier();
    private IListContentSupplier favoritesList = new DefaultListContentSupplier();
    private final ISourceActivator sourceActivator;
    private TvTunerStateTracker stateTracker;

    public CombiBAPServiceTVListenerImpl(TVEnv tVEnv, DSIHandler dSIHandler, CombiBAPServiceHandler combiBAPServiceHandler, HardKeyListener hardKeyListener, ISourceActivator iSourceActivator, AudioFocusClient audioFocusClient, FocusHandler focusHandler, TvTunerStateTracker tvTunerStateTracker) {
        this.dsi = dSIHandler;
        this.env = tVEnv;
        this.serviceHandler = combiBAPServiceHandler;
        this.hardKeyListener = hardKeyListener;
        this.sourceActivator = iSourceActivator;
        this.audioFocus = audioFocusClient;
        this.listFocusHandler = focusHandler;
        this.stateTracker = tvTunerStateTracker;
    }

    public void registerStationList(IListContentSupplier iListContentSupplier) {
        this.stationList = iListContentSupplier;
    }

    public void registerFavoritesList(IListContentSupplier iListContentSupplier) {
        this.favoritesList = iListContentSupplier;
    }

    @Override
    public void setActiveSourceState(int n, int n2) {
    }

    @Override
    public void selectListEntry(int n) {
        AbstractTVStationRow abstractTVStationRow = this.stationList.getRowByIndex(this.stationList.getIndexForUniqueID(n));
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.selectListEntry] [id: %2] %1", (Object)abstractTVStationRow, (long)n);
        this.serviceHandler.selectStation();
        if (abstractTVStationRow != null) {
            this.dsi.changeService(abstractTVStationRow.service, true);
        }
    }

    @Override
    public void selectListEntryPresetList(int n) {
        AbstractTVStationRow abstractTVStationRow = this.favoritesList.getRowByIndex(this.favoritesList.getIndexForUniqueID(n));
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.selectListEntryPresetList] [id: %2] %1", (Object)abstractTVStationRow, (long)n);
        this.serviceHandler.selectStation();
        if (abstractTVStationRow != null) {
            this.dsi.changeService(abstractTVStationRow.service, true);
        }
    }

    @Override
    public void skip(int n) {
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.skip] skipping %1 rows", (long)n);
        int n2 = n > 0 ? 1940662016 : 1957439232;
        try {
            for (int i2 = 0; i2 < Math.abs(n); ++i2) {
                this.hardKeyListener.keyTyped(n2, 0, 0);
            }
            this.serviceHandler.skip(true);
        }
        catch (Exception exception) {
            this.env.lcMain.log(10000, "[CombiBAPServiceTVListenerImpl.skip]", (Throwable)exception);
            this.serviceHandler.skip(false);
        }
    }

    @Override
    public void startSeek(int n) {
        int n2 = n == 0 ? 1 : 2;
        this.dsi.selectNextService(n2);
    }

    @Override
    public void cancelSeek() {
        this.dsi.abortSeek();
    }

    @Override
    public void setPreferredList(int n) {
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.setPreferredList] %1", (long)n);
        int n2 = n == 2 ? 1 : 0;
        this.listFocusHandler.changeFocus(n2);
    }

    @Override
    public void getNextListPos(int n, int n2) {
    }

    @Override
    public void switchSource(int n, int n2, int n3) {
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.switchSource] sourceType=%1, slotNumber=%2, partionNumber=%3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 9: {
                this.stateTracker.setPendingSource(0);
                this.audioFocus.activateTVAudio(0);
                this.sourceActivator.activate(0);
                this.serviceHandler.sendSwitchSourceResult(0);
                break;
            }
            case 32: {
                this.stateTracker.setPendingSource(1);
                this.audioFocus.activateTVAudio(0);
                this.sourceActivator.activate(1);
                this.serviceHandler.sendSwitchSourceResult(0);
                break;
            }
            default: {
                this.serviceHandler.sendSwitchSourceResult(1);
            }
        }
    }

    @Override
    public void activateSource(int n) {
        this.env.lcMain.log(-2137614336, "[CombiBAPServiceTVListenerImpl.activateSource] source=%1", (long)n);
    }
}

