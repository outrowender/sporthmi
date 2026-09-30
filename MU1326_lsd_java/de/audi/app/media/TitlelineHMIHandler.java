/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.ITitlelineHMIHandler;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ModelGroup;

public class TitlelineHMIHandler
extends AbstractMediaTerminalComponent
implements ITitlelineHMIHandler,
IActiveSourceListener {
    private static final String LOGCLASS = "TitlelineHMIHandler";
    private final ModelGroup modelGroup = new ModelGroup();
    private static final int BT_STATE_OTHER = 0;
    private static final int BT_STATE_NOT_READY = 1;
    private static final int BT_STATE_PLAYING = 2;

    public TitlelineHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.modelGroup.add(this.getModel(200288));
        this.modelGroup.add(this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861));
        this.modelGroup.add(this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864));
        this.getTerminal().getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.modelGroup.removeAll();
        this.getTerminal().getSourceController().removeActiveSourceListener(this);
    }

    public void setSourceIcon(ISourceSlot iSourceSlot) {
        int n = MediaUtils.getHMISourceIcon(iSourceSlot);
        this.logger.hmi().log(1000000, "[%1.setSourceIcon] '%2','%3'", (Object)LOGCLASS, (Object)iSourceSlot.getSource(), (long)n);
        this.getResourceLocatorModel(200288).setResourceLocator(n, iSourceSlot.getCaptionIcon());
    }

    public void resetIcons() {
        this.logger.hmi().log(1000000, "[%1.resetIcons]", (Object)LOGCLASS);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864).setValue(0);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861).setValue(0);
    }

    public void setRepeatScopeIcon(int n) {
        this.logger.hmi().log(1000000, "[%1.setRepeatScopeIcon] '%2'", (Object)LOGCLASS, (long)n);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864).setValue(n);
    }

    public void setMixIcon(boolean bl) {
        this.logger.hmi().log(1000000, "[%1.setMixIcon] '%2'", (Object)LOGCLASS, (Object)(bl ? "ENABLED" : "DISABLED"));
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861).setValue(bl ? 1 : 0);
    }

    public void flush() {
        this.logger.hmi().log(1000000, "[%1.flush]", (Object)LOGCLASS);
        this.modelGroup.flush();
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        int n;
        this.logger.hmi().log(1000000, "[%1.activeSourceChanged] ", (Object)LOGCLASS);
        if (activeSourceState.getSlot().getSource().getType() == 11) {
            this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Bluetooth source is active", (Object)LOGCLASS);
            if (activeSourceState.getState() == 1) {
                this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Bluetooth is playing", (Object)LOGCLASS);
                n = 2;
            } else if (activeSourceState.getState() == 11) {
                this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Bluetooth is off", (Object)LOGCLASS);
                n = 0;
            } else {
                this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Bluetooth source is active but not ready", (Object)LOGCLASS);
                n = 1;
            }
        } else {
            this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Bluetooth not active", (Object)LOGCLASS);
            n = 0;
        }
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4501).setValue(n);
    }

    public void sourceDeactivated() {
    }
}

