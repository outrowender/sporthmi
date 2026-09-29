/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.evo.content.IImplicitRepeatHandler;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class ImplicitRepeatHandler
extends AbstractMediaTerminalComponent
implements ChoiceListener,
IImplicitRepeatHandler,
IResetSettingsListener {
    private static final String LOGCLASS;
    public static final String GLOBAL_KEY_REPEAT_MEDIUM;
    public static final int DEFAULT_REPEAT_MEDIUM;
    private IMediaLogger logger;
    private ChoiceModelApp repeatMediumChoice;

    public ImplicitRepeatHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger();
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"ImplicitRepeatHandler");
        this.repeatMediumChoice = this.getChoiceModel(-1391525120);
        this.repeatMediumChoice.setValue(0);
        this.repeatMediumChoice.setStatus(3);
        this.repeatMediumChoice.setChoiceListener(this);
        this.getTerminal().addResetSettingsListener(this);
        this.readFromPersistence();
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"ImplicitRepeatHandler");
        this.repeatMediumChoice.setChoiceListener(null);
    }

    private void readFromPersistence() {
        this.logger.main().log(1078071040, "[%1.readFromPersistence '%2']", (Object)"ImplicitRepeatHandler");
        this.repeatMediumChoice.setValue(0);
        this.repeatMediumChoice.setStatus(1);
    }

    private void storeToPersistence() {
        this.logger.main().log(1078071040, "[%1.storeToPersistence '%2']", (Object)"ImplicitRepeatHandler", (long)this.repeatMediumChoice.getValue());
    }

    @Override
    public boolean isImplicitRepeatByCategory(int n) {
        this.logger.main().log(1078071040, "[%1.isImplicitRepeatByCategory]", (Object)"ImplicitRepeatHandler");
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot.getSource().getType() == 11) {
            return false;
        }
        if (n == 2 || n == 7) {
            return false;
        }
        return this.repeatMediumChoice.getValue() == 0;
    }

    @Override
    public boolean isImplicitRepeatByContentType(int n) {
        this.logger.main().log(1078071040, "[%1.isImplicitRepeatByContentType]", (Object)"ImplicitRepeatHandler");
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot.getSource().getType() == 11) {
            return false;
        }
        if (n == 0) {
            return false;
        }
        return this.repeatMediumChoice.getValue() == 0;
    }

    @Override
    public void onResetSettings(int n) {
        this.repeatMediumChoice.setValue(0);
        this.storeToPersistence();
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi().log(1078071040, "[%1.itemSelected]", (Object)"ImplicitRepeatHandler");
        switch (n) {
            case 200621: {
                int n5 = this.repeatMediumChoice.getValue() == 1 ? 0 : 1;
                this.repeatMediumChoice.setValue(n5);
                this.storeToPersistence();
                break;
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

