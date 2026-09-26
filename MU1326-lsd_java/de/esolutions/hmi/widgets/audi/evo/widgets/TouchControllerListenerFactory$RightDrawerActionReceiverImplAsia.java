/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IRightDrawerActionReceiverTextController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$RightDrawerActionReceiverImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

final class TouchControllerListenerFactory$RightDrawerActionReceiverImplAsia
implements TouchControllerListenerFactory$IRightDrawerActionReceiverTextController {
    private IRightDrawerActionReceiver delegate = null;
    private TouchControllerAsia touchController = null;

    private TouchControllerListenerFactory$RightDrawerActionReceiverImplAsia(TouchControllerAsia touchControllerAsia, TouchControllerListenerFactory$RightDrawerActionReceiverImpl touchControllerListenerFactory$RightDrawerActionReceiverImpl) {
        this.touchController = touchControllerAsia;
        this.delegate = touchControllerListenerFactory$RightDrawerActionReceiverImpl;
    }

    @Override
    public void executeAction(int n) {
        switch (n) {
            case 5: {
                this.touchController.switchToSpeller(0);
                break;
            }
            case 8: {
                this.touchController.switchToSpeller(3);
                break;
            }
            case 9: {
                this.touchController.switchToSpeller(4);
                break;
            }
            case 10: {
                this.touchController.switchToSpeller(5);
                break;
            }
            case 11: {
                this.touchController.switchToSpeller(7);
                break;
            }
            case 12: {
                this.touchController.switchToSpeller(6);
                break;
            }
            case 13: {
                this.touchController.setRecognitionTimeOutValue(500);
                break;
            }
            case 14: {
                this.touchController.setRecognitionTimeOutValue(750);
                break;
            }
            case 15: {
                this.touchController.setRecognitionTimeOutValue(1000);
                break;
            }
            case 2: {
                this.touchController.clearSuggestion();
                this.delegate.executeAction(2);
                break;
            }
            default: {
                this.delegate.executeAction(n);
            }
        }
    }

    /* synthetic */ TouchControllerListenerFactory$RightDrawerActionReceiverImplAsia(TouchControllerAsia touchControllerAsia, TouchControllerListenerFactory$RightDrawerActionReceiverImpl touchControllerListenerFactory$RightDrawerActionReceiverImpl, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchControllerAsia, touchControllerListenerFactory$RightDrawerActionReceiverImpl);
    }
}

