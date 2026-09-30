/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.mailbox;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.mailbox.TelMailboxHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.OptionModelListener;
import java.util.Map;

public class TelEvoMailboxHandler
extends TelMailboxHandler
implements OptionModelListener,
IActionProxyListener {
    private static final int BREADCRUMB_FAVORITES_EDIT = 3;
    private static final int BREADCRUMB_INTELLICALL_EDIT = 2;
    private static final int BREADCRUMB_FAVORITES_DEFINE = 1;
    private static final int BREADCRUMB_INTELLICALL_DEFINE = 0;
    private volatile boolean intellicallFullEntered;
    private volatile boolean favoritesEntered;

    public TelEvoMailboxHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new DialMailboxButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(10, this);
        this.getOptionModel(301077).setListener(this, this.getDialMailboxButtonId());
        this.getOptionModel(300427).setListener(this, this.getDialMailboxButtonId());
        this.getOptionModel(300803).setListener(this, this.getDialMailboxButtonId());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(10, this);
        this.getOptionModel(301077).resetListener();
        this.getOptionModel(300427).resetListener();
        this.getOptionModel(300803).resetListener();
    }

    protected void enterDefineMailboxNumber(int n, int n2) {
        if (this.intellicallFullEntered) {
            this.getChoiceModel(300764).setValue(0);
        } else if (this.favoritesEntered) {
            this.getChoiceModel(300764).setValue(1);
        }
        super.enterDefineMailboxNumber(n, n2);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelEvoMailboxHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
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
                        this.getChoiceModel(300764).setValue(2);
                    } else if (this.favoritesEntered) {
                        this.getChoiceModel(300764).setValue(3);
                    }
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
                default: {
                    this.log.log(10000000, "[TelEvoMailboxHandler#keyTyped] no handling for modelID=%1", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(1000000, "[TelEvoMailboxHandler#keyTyped] no handling for target model %1", (long)n2);
        }
    }

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
                this.log.log(100000, "[TelEvoMailboxHandler#actionProxyCallPerformed] no handling for methodID=%1", (long)n);
            }
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private class DialMailboxButtonListener
    extends TelDefaultButtonListener {
        public DialMailboxButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300406);
        }

        public void keyTyped(int n, int n2, int n3) {
            TelEvoMailboxHandler.this.dialMailboxNumber(n3);
        }
    }
}

