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
    private static final String LOGCLASS = "ImplicitRepeatHandler";
    public static final String GLOBAL_KEY_REPEAT_MEDIUM = "GLOBAL_KEY_REPEAT_MEDIUM";
    public static final int DEFAULT_REPEAT_MEDIUM = 0;
    private IMediaLogger logger;
    private ChoiceModelApp repeatMediumChoice;

    public ImplicitRepeatHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger();
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.repeatMediumChoice = this.getChoiceModel(200621);
        this.repeatMediumChoice.setValue(0);
        this.repeatMediumChoice.setStatus(3);
        this.repeatMediumChoice.setChoiceListener(this);
        this.getTerminal().addResetSettingsListener(this);
        this.readFromPersistence();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.repeatMediumChoice.setChoiceListener(null);
    }

    private void readFromPersistence() {
        this.logger.main().log(1000000, "[%1.readFromPersistence '%2']", (Object)LOGCLASS);
        this.repeatMediumChoice.setValue(0);
        this.repeatMediumChoice.setStatus(1);
    }

    private void storeToPersistence() {
        this.logger.main().log(1000000, "[%1.storeToPersistence '%2']", (Object)LOGCLASS, (long)this.repeatMediumChoice.getValue());
    }

    public boolean isImplicitRepeatByCategory(int n) {
        this.logger.main().log(1000000, "[%1.isImplicitRepeatByCategory]", (Object)LOGCLASS);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot.getSource().getType() == 11) {
            return false;
        }
        if (n == 2 || n == 7) {
            return false;
        }
        return this.repeatMediumChoice.getValue() == 0;
    }

    public boolean isImplicitRepeatByContentType(int n) {
        this.logger.main().log(1000000, "[%1.isImplicitRepeatByContentType]", (Object)LOGCLASS);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot.getSource().getType() == 11) {
            return false;
        }
        if (n == 0) {
            return false;
        }
        return this.repeatMediumChoice.getValue() == 0;
    }

    public void onResetSettings(int n) {
        this.repeatMediumChoice.setValue(0);
        this.storeToPersistence();
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi().log(1000000, "[%1.itemSelected]", (Object)LOGCLASS);
        switch (n) {
            case 200621: {
                int n5 = this.repeatMediumChoice.getValue() == 1 ? 0 : 1;
                this.repeatMediumChoice.setValue(n5);
                this.storeToPersistence();
                break;
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

