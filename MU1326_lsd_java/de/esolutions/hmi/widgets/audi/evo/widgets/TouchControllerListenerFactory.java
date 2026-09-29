/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$AnimationListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$FingerTraceListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IRightDrawerActionReceiverTextController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IUserHintPartialPopupListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$RightDrawerActionReceiverImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$RightDrawerActionReceiverImplAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$SpellerListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$SpellerListenerImplAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$TimerListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$TimerListenerImplAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$UserHintPartialPopupListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public final class TouchControllerListenerFactory {
    private final TouchController touchController;
    private final TouchControllerAsia touchControllerAsia;
    private final boolean isAsianTouchController;
    private static String lastOldText = "";
    private static String lastNewText = "";
    private static char lastCalculateLastInputCharRersult = '\u0000';

    public TouchControllerListenerFactory(TouchController touchController) {
        if (touchController == null) {
            throw new IllegalArgumentException("touchController is null");
        }
        this.touchController = touchController;
        this.isAsianTouchController = touchController instanceof TouchControllerAsia;
        this.touchControllerAsia = this.isAsianTouchController ? (TouchControllerAsia)touchController : null;
    }

    public TouchControllerListenerFactory$AnimationListenerImpl createAnimationListener() {
        return new TouchControllerListenerFactory$AnimationListenerImpl(this.touchController, null);
    }

    public TouchControllerListenerFactory$TimerListenerImpl createJobEventListener() {
        if (this.isAsianTouchController) {
            return new TouchControllerListenerFactory$TimerListenerImplAsia(this.touchControllerAsia);
        }
        return new TouchControllerListenerFactory$TimerListenerImpl(this.touchController, null);
    }

    public TouchControllerListenerFactory$IUserHintPartialPopupListener createUserHintPartialPopupListener() {
        return new TouchControllerListenerFactory$UserHintPartialPopupListenerImpl(this.touchController, null);
    }

    public FingerTraceListener createFingertraceListener() {
        return new TouchControllerListenerFactory$FingerTraceListenerImpl(this.touchController, null);
    }

    public TouchControllerListenerFactory$IRightDrawerActionReceiverTextController createRightDrawerActionReceiver() {
        TouchControllerListenerFactory$RightDrawerActionReceiverImpl touchControllerListenerFactory$RightDrawerActionReceiverImpl = new TouchControllerListenerFactory$RightDrawerActionReceiverImpl(this.touchController, null);
        if (this.isAsianTouchController) {
            return new TouchControllerListenerFactory$RightDrawerActionReceiverImplAsia(this.touchControllerAsia, touchControllerListenerFactory$RightDrawerActionReceiverImpl, null);
        }
        return touchControllerListenerFactory$RightDrawerActionReceiverImpl;
    }

    public ISpellerListener createSpellerListener() {
        TouchControllerListenerFactory$SpellerListenerImpl touchControllerListenerFactory$SpellerListenerImpl = new TouchControllerListenerFactory$SpellerListenerImpl(this.touchController, null);
        if (this.isAsianTouchController) {
            return new TouchControllerListenerFactory$SpellerListenerImplAsia(this.touchControllerAsia, touchControllerListenerFactory$SpellerListenerImpl, null);
        }
        return touchControllerListenerFactory$SpellerListenerImpl;
    }

    public IConversionCandidateSelectionHandler createConversionCandidateSelectionHandler() {
        if (this.isAsianTouchController) {
            return new TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl(this.touchControllerAsia, null);
        }
        IWidgetLogChannel.tpLogChannelInternal.log(1000, "TouchControllerListenerHelper#createConversionCandidateSelectionHandler not an Asian touchController! returning null.");
        return null;
    }

    public static char calculateLastInputChar(String string, String string2) {
        if (lastOldText.equals(string) && lastNewText.equals(string2)) {
            return lastCalculateLastInputCharRersult;
        }
        char c2 = string != null && string.length() > string2.length() ? (char)'\b' : (string2.length() > 0 ? string2.charAt(string2.length() - 1) : (char)'\u0000');
        return c2;
    }
}

