/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IRightDrawerActionReceiverTextController;

public final class MultilineTextFieldRightDrawerHandler
implements TouchControllerListenerFactory$IRightDrawerActionReceiverTextController {
    private MultilineTextFieldController mltCtrl;

    public MultilineTextFieldRightDrawerHandler(MultilineTextFieldController multilineTextFieldController) {
        this.mltCtrl = multilineTextFieldController;
    }

    @Override
    public void executeAction(int n) {
        if (this.mltCtrl != null) {
            switch (n) {
                case 1: {
                    this.mltCtrl.closeSpellerRightDrawer();
                    break;
                }
                case 2: {
                    this.mltCtrl.openSpellerRightDrawer();
                    break;
                }
                case 3: {
                    this.mltCtrl.clear();
                    break;
                }
                case 5: {
                    this.mltCtrl.changeCharset(0);
                    break;
                }
                case 6: {
                    this.mltCtrl.changeCharset(1);
                    break;
                }
                default: {
                    IWidgetLogChannel.logMessagingMultiline.log(10000, "MultilineTextFieldRightDrawerHandler#executeAction unhandled action ID %1", (long)n);
                }
            }
        }
    }
}

