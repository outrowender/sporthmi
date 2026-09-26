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
    private static final String LOGCLASS;
    private final ModelGroup modelGroup = new ModelGroup();
    private static final int BT_STATE_OTHER;
    private static final int BT_STATE_NOT_READY;
    private static final int BT_STATE_PLAYING;

    public TitlelineHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"TitlelineHMIHandler");
        this.modelGroup.add(this.getModel(1611531008));
        this.modelGroup.add(this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861));
        this.modelGroup.add(this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864));
        this.getTerminal().getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"TitlelineHMIHandler");
        this.modelGroup.removeAll();
        this.getTerminal().getSourceController().removeActiveSourceListener(this);
    }

    @Override
    public void setSourceIcon(ISourceSlot iSourceSlot) {
        int n = MediaUtils.getHMISourceIcon(iSourceSlot);
        this.logger.hmi().log(1078071040, "[%1.setSourceIcon] '%2','%3'", (Object)"TitlelineHMIHandler", (Object)iSourceSlot.getSource(), (long)n);
        this.getResourceLocatorModel(1611531008).setResourceLocator(n, iSourceSlot.getCaptionIcon());
    }

    @Override
    public void resetIcons() {
        this.logger.hmi().log(1078071040, "[%1.resetIcons]", (Object)"TitlelineHMIHandler");
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864).setValue(0);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861).setValue(0);
    }

    @Override
    public void setRepeatScopeIcon(int n) {
        this.logger.hmi().log(1078071040, "[%1.setRepeatScopeIcon] '%2'", (Object)"TitlelineHMIHandler", (long)n);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3864).setValue(n);
    }

    @Override
    public void setMixIcon(boolean bl) {
        this.logger.hmi().log(1078071040, "[%1.setMixIcon] '%2'", (Object)"TitlelineHMIHandler", (Object)(bl ? "ENABLED" : "DISABLED"));
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(3861).setValue(bl ? 1 : 0);
    }

    @Override
    public void flush() {
        this.logger.hmi().log(1078071040, "[%1.flush]", (Object)"TitlelineHMIHandler");
        this.modelGroup.flush();
    }

    @Override
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        int n;
        this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] ", (Object)"TitlelineHMIHandler");
        if (activeSourceState.getSlot().getSource().getType() == 11) {
            this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] Bluetooth source is active", (Object)"TitlelineHMIHandler");
            if (activeSourceState.getState() == 1) {
                this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] Bluetooth is playing", (Object)"TitlelineHMIHandler");
                n = 2;
            } else if (activeSourceState.getState() == 11) {
                this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] Bluetooth is off", (Object)"TitlelineHMIHandler");
                n = 0;
            } else {
                this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] Bluetooth source is active but not ready", (Object)"TitlelineHMIHandler");
                n = 1;
            }
        } else {
            this.logger.hmi().log(1078071040, "[%1.activeSourceChanged] Bluetooth not active", (Object)"TitlelineHMIHandler");
            n = 0;
        }
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4501).setValue(n);
    }

    @Override
    public void sourceDeactivated() {
    }
}

