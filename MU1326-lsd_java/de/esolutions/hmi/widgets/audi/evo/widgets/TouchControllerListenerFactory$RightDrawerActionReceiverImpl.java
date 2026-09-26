/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IRightDrawerActionReceiverTextController;

final class TouchControllerListenerFactory$RightDrawerActionReceiverImpl
implements TouchControllerListenerFactory$IRightDrawerActionReceiverTextController {
    private TouchController touchController = null;

    private TouchControllerListenerFactory$RightDrawerActionReceiverImpl(TouchController touchController) {
        this.touchController = touchController;
    }

    @Override
    public void executeAction(int n) {
        switch (n) {
            case 1: {
                this.touchController.closeSpeller(false, true);
                this.touchController.setSpellerLastMode(0);
                this.touchController.hideFingerTrace();
                break;
            }
            case 2: {
                this.touchController.openSpeller(true);
                break;
            }
            case 3: {
                this.touchController.clear(true);
                break;
            }
            case 5: {
                if (TouchController.isArabia()) {
                    ((TouchControllerArabia)this.touchController).setAutoCharsetSwitch(false);
                }
                this.touchController.changeCharset(0);
                break;
            }
            case 6: {
                this.touchController.changeCharset(1);
                break;
            }
            case 7: {
                if (TouchController.isArabia()) {
                    ((TouchControllerArabia)this.touchController).setAutoCharsetSwitch(false);
                }
                this.touchController.changeCharset(2);
                break;
            }
            default: {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchControllerAsRightDrawerActionReceiver#executeAction: unknown actionId %1", (long)n);
            }
        }
    }

    /* synthetic */ TouchControllerListenerFactory$RightDrawerActionReceiverImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

