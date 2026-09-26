/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.evo.source.ToggleSourceHandler$1;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.source.AbstractToggleSourceHandler;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class ToggleSourceHandler
extends AbstractToggleSourceHandler
implements IActionProxyListener,
ChoiceListener {
    private static final String LOGCLASS;
    private volatile ISourceSlot currentFocusedSlot;
    private static final int[] SOURCE_ORDERING;

    public ToggleSourceHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal, SOURCE_ORDERING);
    }

    @Override
    public void init() {
        super.init();
        this.logger.main().log(1078071040, "[%1.init]", (Object)"ToggleSourceHandler");
        this.getTerminal().addActionProxyListener(new int[]{34, 33}, (IActionProxyListener)this);
        this.getChoiceModel(1712194304).setChoiceListener(this);
        this.getButtonModel(1728971520).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"ToggleSourceHandler");
        this.getTerminal().removeActionProxyListener(this);
        this.currentFocusedSlot = null;
        this.getChoiceModel(1712194304).setChoiceListener(null);
        this.getButtonModel(1728971520).setButtonListener(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void focusFirstSlot() {
        this.logger.hmi().log(1078071040, "[%1.focusFirstSlot]", (Object)"ToggleSourceHandler");
        Object object = this.listUpdateMutex;
        synchronized (object) {
            ISourceSlot iSourceSlot;
            this.currentFocusedSlot = iSourceSlot = this.getFirstEntry();
            if (iSourceSlot != null) {
                this.setIconForFocusedEntry();
            }
        }
        this.logger.hmi().log(1078071040, "[%1.focusFirstSlot] entry not found.", (Object)"ToggleSourceHandler");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void focusActiveSlot(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1078071040, "[%1.focusActiveSlot] '%2'", (Object)"ToggleSourceHandler", (Object)iSourceSlot);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.currentFocusedSlot = iSourceSlot;
            if (this.currentFocusedSlot == null) {
                this.focusFirstSlot();
            } else {
                this.setIconForFocusedEntry();
            }
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void focusNextSlot() {
        this.logger.hmi().log(1078071040, "[%1.focusNextSlot] currentFocus='%2'.", (Object)"ToggleSourceHandler", (Object)this.currentFocusedSlot);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            ISourceSlot iSourceSlot = this.getNextEntry(this.currentFocusedSlot);
            if (iSourceSlot != null) {
                this.currentFocusedSlot = iSourceSlot;
                this.setIconForFocusedEntry();
            }
        }
    }

    private void toggleFocusedEntry() {
        this.logger.hmi().log(1078071040, "[%1.toggleFocusedEntry] '%2'", (Object)"ToggleSourceHandler", (Object)this.currentFocusedSlot);
        ISourceSlot iSourceSlot = this.currentFocusedSlot;
        if (iSourceSlot == null) {
            this.logger.hmi().log(1078071040, "[%1.keyTyped] No focused row.", (Object)"ToggleSourceHandler");
            this.getChoiceModel(1712194304).fireEvent(this.getTerminal().getTerminalID());
            return;
        }
        if (!this.getTerminal().getAudioManager().hasAudioFocus()) {
            this.logger.hmi().log(1078071040, "[%1.keyTyped] No audio focus.", (Object)"ToggleSourceHandler");
            if (iSourceSlot.getSource().getType() != 8 && iSourceSlot.getSource().getType() != 7) {
                this.logger.hmi().log(1078071040, "[%1.toggleFocusedEntry] Request audio focus.", (Object)"ToggleSourceHandler");
                this.getTerminal().getAudioManager().requestAudioFocus();
            }
        }
        this.getTerminal().getDispatcher().execute(new ToggleSourceHandler$1(this, "ToggleSource.activateSource", iSourceSlot));
    }

    private void setIconForFocusedEntry() {
        int n = this.currentFocusedSlot.getLoadingIcon() == null ? MediaUtils.getHMISourceIcon(this.currentFocusedSlot) : -1;
        this.logger.hmi().log(1078071040, "[%1.setIconForFocusedEntry] slot=%2.", (Object)"ToggleSourceHandler", (Object)this.currentFocusedSlot);
        this.getResourceLocatorModel(1695417088).setResourceLocator(n, this.currentFocusedSlot.getLoadingIcon());
    }

    private void restartIdleTimer() {
        this.getChoiceModel(1712194304).setValue(-1);
        this.getChoiceModel(1712194304).setValue(0);
    }

    @Override
    public boolean isSlotPlayable(ISourceSlot iSourceSlot) {
        return MediaUtils.isSlotEnabledInHMISourceList(iSourceSlot);
    }

    @Override
    public boolean applyToggleFilter(ISourceSlot iSourceSlot) {
        return MediaUtils.isSlotEnabledInHMISourceList(iSourceSlot);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 34: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_TOGGLE_SOURCE.", (Object)"ToggleSourceHandler");
                this.restartIdleTimer();
                ISourceSlot iSourceSlot = this.currentFocusedSlot;
                if (iSourceSlot == null) {
                    this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] No focused row.", (Object)"ToggleSourceHandler");
                    return;
                }
                this.focusNextSlot();
                break;
            }
            case 33: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_TOGGLE_SOURCE_ENTERED.", (Object)"ToggleSourceHandler");
                HMIService hMIService = this.getTerminal().getFramework().getHMIService();
                DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 7);
                hMIService.getEventDispatcher().postEvent(drawerEvent);
                this.restartIdleTimer();
                ISourceSlot iSourceSlot = this.getActiveEntry();
                this.focusActiveSlot(iSourceSlot);
                break;
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200294: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] Toogle timer fired.", (Object)"ToggleSourceHandler");
                this.toggleFocusedEntry();
                break;
            }
            case 200295: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] DDS_ENTER pressed.", (Object)"ToggleSourceHandler");
                this.toggleFocusedEntry();
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("ToggleSourceHandler").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ IMediaLogger access$000(ToggleSourceHandler toggleSourceHandler) {
        return toggleSourceHandler.logger;
    }

    static {
        SOURCE_ORDERING = new int[]{6, 2, 0, 5, 1, 3, 10, 9, 11, 12, 7, 8, 13};
    }
}

