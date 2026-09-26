/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.MediaDSIBrowserControllerImpl;
import de.audi.app.media.evo.content.IImplicitRepeatHandler;
import de.audi.app.media.evo.content.data.DataBrowser;
import de.audi.app.media.evo.content.data.DataBrowserLastSelectionHandler;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.sds.g2p.DataG2PController;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class DataContent
extends AbstractMediaContent
implements TimerListener,
IActionProxyListener,
IActiveSourceListener {
    private static final String LOGCLASS;
    private final DataPlayer dataPlayer;
    private final DataBrowser dataBrowser;
    private final IFavoritesController favoritesController;
    private final DataG2PController g2pController;
    private final Timer gracenoteTimer;
    private final DataBrowserLastSelectionHandler lastSelectionHandler;
    private volatile MediaCapabilities mediaCapabilities;

    public DataContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, IImplicitRepeatHandler iImplicitRepeatHandler, IFavoritesController iFavoritesController) {
        super(1, iContentContext, iMediaTerminal);
        this.dataPlayer = new DataPlayer(iMediaTerminal, this, iMediaDSIPlayerController);
        MediaDSIBrowserControllerImpl mediaDSIBrowserControllerImpl = new MediaDSIBrowserControllerImpl(0, this.getTerminal().getServiceManager(), this.getTerminal().getFramework(), this.getTerminal().getDispatcher(), this.logger.dsi());
        this.favoritesController = iFavoritesController;
        this.favoritesController.setPlayer(this.dataPlayer);
        this.lastSelectionHandler = new DataBrowserLastSelectionHandler(iMediaTerminal);
        this.dataBrowser = new DataBrowser(iMediaTerminal, this, this.dataPlayer, mediaDSIBrowserControllerImpl, this.favoritesController, iImplicitRepeatHandler, this.lastSelectionHandler);
        this.g2pController = new DataG2PController(iMediaTerminal, this.dataPlayer, this.lastSelectionHandler);
        this.gracenoteTimer = new Timer("Gracenote", 0, true, this);
        this.mediaCapabilities = MediaCapabilities.EMPTY_CAPABILITIES;
    }

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DataContent");
        this.dataPlayer.init();
        this.lastSelectionHandler.init();
        this.dataBrowser.init();
        this.g2pController.init();
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DataContent");
        this.dataPlayer.deinit();
        this.dataBrowser.deinit();
        this.g2pController.deinit();
        this.lastSelectionHandler.deinit();
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"DataContent");
        super.activate(iActivationContext);
        this.getTerminal().getSourceController().addActiveSourceListener(this);
        this.getTerminal().addActionProxyListener(36, (IActionProxyListener)this);
        this.getTerminal().addActionProxyListener(40, (IActionProxyListener)this);
        ISourceSlot iSourceSlot = iActivationContext.getSlot();
        this.dataPlayer.activate(iActivationContext);
        this.dataBrowser.activate(iSourceSlot);
        this.dataBrowser.setRestoreLastSelectionPossible((Boolean)iActivationContext.getParameter("RESTORE_BROWSER_PATH_POSSIBLE"));
        this.favoritesController.activate(iSourceSlot);
        this.g2pController.activate(iSourceSlot);
        this.mediaCapabilities = iSourceSlot.getCapabilities();
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"DataContent");
        this.getChoiceModel(3941).setValue(0);
        super.deactivate();
        this.getTerminal().getSourceController().removeActiveSourceListener(this);
        this.getTerminal().removeActionProxyListener(this);
        this.dataPlayer.deactivate();
        this.dataBrowser.deactivate();
        this.favoritesController.deactivate();
        this.g2pController.deactivate();
        this.mediaCapabilities = MediaCapabilities.EMPTY_CAPABILITIES;
    }

    @Override
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.main().log(1078071040, "[%1.activeSourceChanged]", (Object)"DataContent");
        MediaCapabilities mediaCapabilities = activeSourceState.getSlot().getCapabilities();
        MediaCapabilities mediaCapabilities2 = this.mediaCapabilities;
        if (mediaCapabilities2 != null && mediaCapabilities2.equals(mediaCapabilities)) {
            return;
        }
        byte by = MediaUtils.getUpgradeTypeBrowser(mediaCapabilities2, mediaCapabilities);
        if (0 == by) {
            return;
        }
        this.mediaCapabilities = mediaCapabilities;
        this.dataBrowser.update(by, activeSourceState.getSlot());
        this.favoritesController.update(by, activeSourceState.getSlot());
    }

    @Override
    public void sourceDeactivated() {
    }

    @Override
    public IPlayer getPlayer() {
        return this.dataPlayer;
    }

    @Override
    public void resetSettings() {
        this.dataPlayer.resetSettings();
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return this.dataPlayer.getHardKeyListener();
    }

    @Override
    public void vehicleMoving(boolean bl) {
        this.dataPlayer.vehicleMoving(bl);
    }

    @Override
    public void diagResetBrowser() {
        this.dataBrowser.diagResetBrowser();
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (36 == n) {
            this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed]", (Object)"DataContent");
            if (this.getTerminal().getConfiguration().isGracenoteEnabled()) {
                this.getChoiceModel(3941).setValue(1);
                this.gracenoteTimer.start();
            } else {
                this.logger.main().log(-2137614336, "[%1.actionProxyCallPerformed] Gracenote is not coded", (Object)"DataContent");
            }
        } else if (40 == n) {
            Integer n2 = (Integer)map.get(new Integer(40));
            this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_SET_OPTION_OPEN_IN_NEXT_SCREEN", (Object)"DataContent");
            this.getChoiceModel(-1659829504).setValue(n2);
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.main().log(1078071040, "[%1.fireTimer] Remove gracenote icon.", (Object)"DataContent");
        this.getChoiceModel(3941).setValue(0);
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.main().log(1078071040, "[%1.cancelTimer]", (Object)"DataContent");
        this.getChoiceModel(3941).setValue(0);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DataContent").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

