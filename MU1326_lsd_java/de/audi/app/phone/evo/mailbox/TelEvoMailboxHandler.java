/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.mailbox;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.mailbox.TelMailboxHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.mailbox.TelEvoMailboxHandler$DialMailboxButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;
import java.util.Map;

public class TelEvoMailboxHandler
extends TelMailboxHandler
implements OptionModelListener,
IActionProxyListener {
    private static final int BREADCRUMB_FAVORITES_EDIT;
    private static final int BREADCRUMB_INTELLICALL_EDIT;
    private static final int BREADCRUMB_FAVORITES_DEFINE;
    private static final int BREADCRUMB_INTELLICALL_DEFINE;
    private volatile boolean intellicallFullEntered;
    private volatile boolean favoritesEntered;

    public TelEvoMailboxHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEvoMailboxHandler$DialMailboxButtonListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(10, this);
        this.getOptionModel(362284032).setListener(this, this.getDialMailboxButtonId());
        this.getOptionModel(-1953168384).setListener(this, this.getDialMailboxButtonId());
        this.getOptionModel(60228608).setListener(this, this.getDialMailboxButtonId());
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(10, this);
        this.getOptionModel(362284032).resetListener();
        this.getOptionModel(-1953168384).resetListener();
        this.getOptionModel(60228608).resetListener();
    }

    @Override
    protected void enterDefineMailboxNumber(int n, int n2) {
        if (this.intellicallFullEntered) {
            this.getChoiceModel(-594148352).setValue(0);
        } else if (this.favoritesEntered) {
            this.getChoiceModel(-594148352).setValue(1);
        }
        super.enterDefineMailboxNumber(n, n2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelEvoMailboxHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == this.getDialMailboxButtonId()) {
            switch (n) {
                case 301077: {
                    this.dialMailboxNumber(n5);
                    break;
                }
                case 300427: {
                    this.deleteMailboxNumber(n5);
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
                case 300803: {
                    this.setMailboxSpellerWithCurrentMailboxNumber();
                    if (this.intellicallFullEntered) {
                        this.getChoiceModel(-594148352).setValue(2);
                    } else if (this.favoritesEntered) {
                        this.getChoiceModel(-594148352).setValue(3);
                    }
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
                default: {
                    this.log.log(-2137614336, "[TelEvoMailboxHandler#keyTyped] no handling for modelID=%1", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(1078071040, "[TelEvoMailboxHandler#keyTyped] no handling for target model %1", (long)n2);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 4: {
                this.intellicallFullEntered = true;
                this.favoritesEntered = false;
                break;
            }
            case 10: {
                this.intellicallFullEntered = false;
                this.favoritesEntered = true;
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelEvoMailboxHandler#actionProxyCallPerformed] no handling for methodID=%1", (long)n);
            }
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    static /* synthetic */ void access$000(TelEvoMailboxHandler telEvoMailboxHandler, int n) {
        telEvoMailboxHandler.dialMailboxNumber(n);
    }
}

