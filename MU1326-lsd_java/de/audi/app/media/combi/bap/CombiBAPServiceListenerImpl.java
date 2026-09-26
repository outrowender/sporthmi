/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$1;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$10;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$2;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$3;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$4;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$5;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$6;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$7;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$8;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl$9;
import de.audi.app.media.combi.bap.DiagnosisCommandCombiSourceSwitch;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.log.LogChannel;

public class CombiBAPServiceListenerImpl
extends AbstractMediaTerminalComponent
implements CombiBAPServiceMediaListener {
    private static final String LOGCLASS;
    private final CombiBAPController combiController;
    private final LogChannel logCombi;

    public CombiBAPServiceListenerImpl(IMediaTerminal iMediaTerminal, CombiBAPController combiBAPController) {
        super(iMediaTerminal);
        this.combiController = combiBAPController;
        this.logCombi = this.combiController.getLogChannel();
        iMediaTerminal.getDiagnosisManager().addCommandProvider(iMediaTerminal.getTerminalID(), new DiagnosisCommandCombiSourceSwitch(this));
    }

    @Override
    public void selectListEntry(int n) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$1(this, "CombiBAP.selectListEntry", n));
    }

    @Override
    public void selectListEntryPresetList(int n) {
    }

    @Override
    public void setActiveSourceState(int n, int n2) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$2(this, "CombiBAP.setActiveSourceState", n, n2));
    }

    @Override
    public void skip(int n) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$3(this, "CombiBAP.skip", n));
    }

    @Override
    public void switchSource(int n, int n2, int n3) {
        int n4;
        if (n2 == -1 && n == 11) {
            this.logCombi.log(1078071040, "[%1.switchSource] Special handling for the single SD-Card slot of the STD Systems: Setting slotNumber from -1 to 0.", (Object)"CombiBAPServiceListenerImpl");
            n4 = 0;
        } else {
            n4 = n2;
        }
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$4(this, "CombiBAP.switchSource", n, n4, n3));
    }

    @Override
    public void getNextListPos(int n, int n2) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$5(this, "CombiBAP.getNextListPos", n, n2));
    }

    @Override
    public void goTo(int n, int n2) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$6(this, "CombiBAP.goTo", n, n2));
    }

    @Override
    public void requestMediaBrowserListByID(int n, int n2, int n3) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$7(this, "CombiBAP.requestMediaBrowserListByID", n, n2, n3));
    }

    @Override
    public void requestMediaBrowserListByIndex(int n, int n2, int n3) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$8(this, "CombiBAP.requestMediaBrowserListByIndex", n, n2, n3));
    }

    @Override
    public void startSeek(int n) {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$9(this, "CombiBAP.startSeek", n));
    }

    @Override
    public void cancelSeek() {
        this.getTerminal().getDispatcher().execute(new CombiBAPServiceListenerImpl$10(this, "CombiBAP.cancelSeek"));
    }

    @Override
    public void setPreferredList(int n) {
        this.combiController.updatePreferredList(n);
    }

    @Override
    public void activateSource(int n) {
        this.logCombi.log(1078071040, "[%1.activateSource] '%2'", (Object)"CombiBAPServiceListenerImpl", (long)n);
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
                this.logCombi.log(1078071040, "[%1.activateSource] 'TV/AV'", (Object)"CombiBAPServiceListenerImpl");
                this.getTerminal().getAudioManager().switchAudioFocusToTV();
            } else {
                this.logCombi.log(1078071040, "[%1.activateSource] 'MEDIA'", (Object)"CombiBAPServiceListenerImpl");
                this.getTerminal().getAudioManager().requestAudioFocus();
            }
        }
    }

    @Override
    public void requestCoverArt(long l, int n) {
    }

    static /* synthetic */ LogChannel access$000(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl) {
        return combiBAPServiceListenerImpl.logCombi;
    }

    static /* synthetic */ CombiBAPController access$100(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl) {
        return combiBAPServiceListenerImpl.combiController;
    }

    static /* synthetic */ IMediaLogger access$200(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl) {
        return combiBAPServiceListenerImpl.logger;
    }
}

