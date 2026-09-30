/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.source.AbstractToggleSourceHandler;
import de.audi.app.media.source.ActivationContext;
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
    private static final String LOGCLASS = "ToggleSourceHandler";
    private volatile ISourceSlot currentFocusedSlot;
    private static final int[] SOURCE_ORDERING = new int[]{6, 2, 0, 5, 1, 3, 10, 9, 11, 12, 7, 8, 13};

    public ToggleSourceHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal, SOURCE_ORDERING);
    }

    public void init() {
        super.init();
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getTerminal().addActionProxyListener(new int[]{34, 33}, (IActionProxyListener)this);
        this.getChoiceModel(200294).setChoiceListener(this);
        this.getButtonModel(200295).setButtonListener(this);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().removeActionProxyListener(this);
        this.currentFocusedSlot = null;
        this.getChoiceModel(200294).setChoiceListener(null);
        this.getButtonModel(200295).setButtonListener(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void focusFirstSlot() {
        this.logger.hmi().log(1000000, "[%1.focusFirstSlot]", (Object)LOGCLASS);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            ISourceSlot iSourceSlot;
            this.currentFocusedSlot = iSourceSlot = this.getFirstEntry();
            if (iSourceSlot != null) {
                this.setIconForFocusedEntry();
            }
        }
        this.logger.hmi().log(1000000, "[%1.focusFirstSlot] entry not found.", (Object)LOGCLASS);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void focusActiveSlot(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1000000, "[%1.focusActiveSlot] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
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
        this.logger.hmi().log(1000000, "[%1.focusNextSlot] currentFocus='%2'.", (Object)LOGCLASS, (Object)this.currentFocusedSlot);
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
        this.logger.hmi().log(1000000, "[%1.toggleFocusedEntry] '%2'", (Object)LOGCLASS, (Object)this.currentFocusedSlot);
        final ISourceSlot iSourceSlot = this.currentFocusedSlot;
        if (iSourceSlot == null) {
            this.logger.hmi().log(1000000, "[%1.keyTyped] No focused row.", (Object)LOGCLASS);
            this.getChoiceModel(200294).fireEvent(this.getTerminal().getTerminalID());
            return;
        }
        if (!this.getTerminal().getAudioManager().hasAudioFocus()) {
            this.logger.hmi().log(1000000, "[%1.keyTyped] No audio focus.", (Object)LOGCLASS);
            if (iSourceSlot.getSource().getType() != 8 && iSourceSlot.getSource().getType() != 7) {
                this.logger.hmi().log(1000000, "[%1.toggleFocusedEntry] Request audio focus.", (Object)LOGCLASS);
                this.getTerminal().getAudioManager().requestAudioFocus();
            }
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("ToggleSource.activateSource"){

            public void run() {
                boolean bl;
                ToggleSourceHandler.this.logger.hmi().log(1000000, "[%1.toggleFocusedEntry] Activate source.", (Object)ToggleSourceHandler.LOGCLASS);
                boolean bl2 = bl = !((Object)iSourceSlot).equals(ToggleSourceHandler.this.getTerminal().getSourceController().getSelectedSlot());
                if (bl) {
                    ToggleSourceHandler.this.getChoiceModel(200822).setValue(1);
                } else {
                    ToggleSourceHandler.this.getChoiceModel(200822).setValue(0);
                }
                ToggleSourceHandler.this.getTerminal().getSourceController().activateSource(new ActivationContext(iSourceSlot));
                ToggleSourceHandler.this.getChoiceModel(200294).fireEvent(ToggleSourceHandler.this.getTerminal().getTerminalID());
            }
        });
    }

    private void setIconForFocusedEntry() {
        int n = this.currentFocusedSlot.getLoadingIcon() == null ? MediaUtils.getHMISourceIcon(this.currentFocusedSlot) : -1;
        this.logger.hmi().log(1000000, "[%1.setIconForFocusedEntry] slot=%2.", (Object)LOGCLASS, (Object)this.currentFocusedSlot);
        this.getResourceLocatorModel(200293).setResourceLocator(n, this.currentFocusedSlot.getLoadingIcon());
    }

    private void restartIdleTimer() {
        this.getChoiceModel(200294).setValue(-1);
        this.getChoiceModel(200294).setValue(0);
    }

    public boolean isSlotPlayable(ISourceSlot iSourceSlot) {
        return MediaUtils.isSlotEnabledInHMISourceList(iSourceSlot);
    }

    public boolean applyToggleFilter(ISourceSlot iSourceSlot) {
        return MediaUtils.isSlotEnabledInHMISourceList(iSourceSlot);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 34: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_TOGGLE_SOURCE.", (Object)LOGCLASS);
                this.restartIdleTimer();
                ISourceSlot iSourceSlot = this.currentFocusedSlot;
                if (iSourceSlot == null) {
                    this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] No focused row.", (Object)LOGCLASS);
                    return;
                }
                this.focusNextSlot();
                break;
            }
            case 33: {
                this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_TOGGLE_SOURCE_ENTERED.", (Object)LOGCLASS);
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

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200294: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] Toogle timer fired.", (Object)LOGCLASS);
                this.toggleFocusedEntry();
                break;
            }
            case 200295: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] DDS_ENTER pressed.", (Object)LOGCLASS);
                this.toggleFocusedEntry();
                break;
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

