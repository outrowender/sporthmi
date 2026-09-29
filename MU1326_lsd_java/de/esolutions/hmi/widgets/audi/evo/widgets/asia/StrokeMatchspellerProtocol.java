/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IInputLocker;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeConversionsAvailableListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeMatchspellerProtocol;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public class StrokeMatchspellerProtocol
implements IStrokeMatchspellerProtocol {
    private final MatchspellerModelGUI model;
    private final ITouchInputDataAsia asianTouchInputData;
    private final HMITerminal terminal;
    private IStrokeConversionsAvailableListener strokeConversionsAvailableListener;
    private String lastStrokesChanged;
    private int lastOffsetRequested;
    private int lastWindowSizeRequested;
    private final IInputLocker inputLocker;

    public StrokeMatchspellerProtocol(MatchspellerModelGUI matchspellerModelGUI, ITouchInputDataAsia iTouchInputDataAsia, IInputLocker iInputLocker, HMITerminal hMITerminal) {
        this.model = matchspellerModelGUI;
        this.terminal = hMITerminal;
        this.lastStrokesChanged = "";
        this.strokeConversionsAvailableListener = null;
        this.lastOffsetRequested = -1;
        this.lastWindowSizeRequested = -1;
        this.asianTouchInputData = iTouchInputDataAsia;
        this.inputLocker = iInputLocker;
    }

    @Override
    public void notifyMatchspellerStrokeConversionsAvailable() {
        this.inputLocker.setInputLock(false);
        if (this.strokeConversionsAvailableListener != null) {
            this.strokeConversionsAvailableListener.notifyMatchspellerStrokeConversionsAvailable();
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(-1601830656, "StrokeMatchspellerProtocol#notifyMatchspellerStrokeConversionAvailable: no IStrokeConversionsAvailableListener set.");
        }
    }

    @Override
    public void strokesChanged(String string, char c2) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "StrokeMatchspellerProtocol#strokesChanged [MODEL COMMUNICATION ->] calling strokesChanged with strokes \"%1\" and last char '%2'", (Object)string, (Object)StringUtility.sanitizeCharacterForLogging(c2));
        }
        this.lastStrokesChanged = string;
        this.model.strokesChanged(this.terminal.getTerminalID(), string, c2);
    }

    @Override
    public String getStrokes() {
        return this.lastStrokesChanged;
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2) {
        this.lastOffsetRequested = n;
        this.lastWindowSizeRequested = n2;
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "StrokeMatchspellerProtocol#requestValidHanziCharsWindow [MODEL COMMUNICATION ->] calling requestValidHanziCharsWindow with offset %1 and windowsize %2", (long)n, (long)n2);
        this.inputLocker.setInputLock(true);
        this.model.requestValidHanziCharsWindow(this.terminal.getTerminalID(), n, n2);
    }

    @Override
    public int getTotalAmountOfHanziCharacters() {
        int n = this.model.getTotalAmountOfHanziCharacters();
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "#StrokeMatchspellerProtocol#getTotalAmountOfHanziCharacters: getTotalAmountOfHanziCharacters returned %1, last strokesChanged was called with '%2'.", (Object)String.valueOf(n), (Object)this.lastStrokesChanged);
        }
        return n;
    }

    @Override
    public void setStrokeConversionsAvailableListener(IStrokeConversionsAvailableListener iStrokeConversionsAvailableListener) {
        this.strokeConversionsAvailableListener = iStrokeConversionsAvailableListener;
    }

    @Override
    public String getValidHanziCharsWindowResult() {
        String string = this.model.getValidHanziCharsWindowResult();
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "#StrokeMatchspellerProtocol#getValidHanziCharsWindowResult: getValidHanziCharsWindowResult returned '%1', last strokesChanged was called with '%2', offset was %3, windowSize was %4.", (Object)string, (Object)this.lastStrokesChanged, (Object)String.valueOf(this.lastOffsetRequested), (Object)String.valueOf(this.lastWindowSizeRequested));
        }
        return string;
    }

    @Override
    public void notifyModelTextValueChanged() {
        String string = this.model.getText();
        String string2 = this.asianTouchInputData.getCurrentText();
        if (StringUtilities.isNullOrEmpty(string)) {
            this.asianTouchInputData.clear(false);
        } else {
            if (!string.startsWith(string2)) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchControllerAsia#processModelUpdateEvent VALUE_UPDATED: model text ('%1') does not start with regular text ('%2'). Update event ignored!", (Object)string, (Object)string2);
                return;
            }
            if (string.equals(string2)) {
                this.asianTouchInputData.clearUnconvertedCharacters(false);
            } else {
                String string3;
                String string4 = string.substring(string2.length());
                if (!string4.equals(string3 = this.asianTouchInputData.getUnconvertedCharacters())) {
                    if (!string4.startsWith(string3)) {
                        IWidgetLogChannel.tpLogChannelInternal.log(-1601830656, "TouchControllerAsia#processModelUpdateEvent VALUE_UPDATED: stroke characters from model ('%1') do not start with current stroke chars ('%2'). Update event ignored!", (Object)string4, (Object)string3);
                        this.asianTouchInputData.clearUnconvertedCharacters(false);
                        this.asianTouchInputData.appendUnconvertedCharacters(string4, false);
                    } else {
                        this.asianTouchInputData.appendUnconvertedCharacters(string4.substring(string3.length()), false);
                    }
                }
            }
        }
    }
}

