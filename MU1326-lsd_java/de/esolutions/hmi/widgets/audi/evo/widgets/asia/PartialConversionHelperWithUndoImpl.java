/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IPartialConversionHelper;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import java.util.ArrayList;
import java.util.List;

public class PartialConversionHelperWithUndoImpl
implements IPartialConversionHelper {
    private Buffer currPartialConversion = new Buffer();
    private String selectedPredictionChars = "";
    private boolean isSelectOperation = false;
    private boolean isDeleteOperation = false;
    protected List userSelectedConversions = new ArrayList();
    private int deletionCounter = 0;
    private String lastSpelling = "";

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("{");
        buffer.append(new StringBuffer().append("currPartialConversion: ").append(this.currPartialConversion.toString()).append(",").toString());
        buffer.append(new StringBuffer().append("selectedPredictionChars: ").append(this.selectedPredictionChars).append(",").toString());
        buffer.append(new StringBuffer().append("isSelectOperation: ").append(this.isSelectOperation).append(",").toString());
        buffer.append(new StringBuffer().append("isDeleteOperation: ").append(this.isDeleteOperation).append(",").toString());
        buffer.append("}");
        return buffer.toString();
    }

    public String getCurrentConvertedCharactersMatch() {
        return StringUtilities.concatStringArray(this.userSelectedConversions, "");
    }

    @Override
    public void setCurrentSelectedPredictionChars(String string) {
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "PartialConversionHelper#setCurrentSelectedPredictionChars selectedChar='%1'.", (Object)string);
        this.isSelectOperation = true;
        this.userSelectedConversions.add(string);
    }

    @Override
    public void setIsDeleteOperation(boolean bl) {
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "PartialConversionHelper#setIsDeleteOperation %1.", bl);
        this.isDeleteOperation = bl;
        ++this.deletionCounter;
    }

    public void cancelPartialConversion() {
        this.reset();
    }

    @Override
    public String getPartialConversion(String string) {
        if (this.isDeleteOperation && string.length() > this.lastSpelling.length()) {
            for (int i2 = 0; i2 < this.deletionCounter; ++i2) {
                if (this.userSelectedConversions.isEmpty()) continue;
                this.userSelectedConversions.remove(this.userSelectedConversions.size() - 1);
            }
        }
        this.constructCurrentPartialConversion(string);
        this.deletionCounter = 0;
        this.isDeleteOperation = false;
        return this.currPartialConversion.toString();
    }

    @Override
    public void handlePartialConversion(String string, ITouchInputDataAsia iTouchInputDataAsia, IWordPredictionAccess iWordPredictionAccess) {
        String string2 = this.getPartialConversion(string);
        if (string.length() < 1) {
            boolean bl = iTouchInputDataAsia.getUnconvertedCharacters().length() > 0;
            this.handleEmptySpelling(string2, iTouchInputDataAsia);
            if (bl) {
                this.handleUserDBSelectedChars(iWordPredictionAccess);
            }
            this.reset();
        } else {
            this.handleNoneEmptySpelling(iTouchInputDataAsia, string2);
        }
        this.lastSpelling = string;
    }

    protected void handleNoneEmptySpelling(ITouchInputDataAsia iTouchInputDataAsia, String string) {
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsia#updateSpelling: set un-converted chars: %1", (Object)string);
        iTouchInputDataAsia.setUnconvertedCharacters(string, false);
    }

    protected void handleEmptySpelling(String string, ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(false);
        iTouchInputDataAsia.appendRegularCharacters(string, true);
    }

    private void handleUserDBSelectedChars(IWordPredictionAccess iWordPredictionAccess) {
        if (this.getCurrentConvertedCharactersMatch().length() > 0) {
            String string = this.getCurrentConvertedCharactersMatch();
            iWordPredictionAccess.addToUserPreference(this.lastSpelling, string);
        }
    }

    private void constructCurrentPartialConversion(String string) {
        this.currPartialConversion.clear();
        for (int i2 = 0; i2 < this.userSelectedConversions.size(); ++i2) {
            this.currPartialConversion.append(this.userSelectedConversions.get(i2));
        }
        this.currPartialConversion.append(string);
    }

    @Override
    public void reset() {
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "PartialConversionHelper#reset was called.");
        this.selectedPredictionChars = null;
        this.currPartialConversion.clear();
        this.isSelectOperation = false;
        this.isDeleteOperation = false;
        this.userSelectedConversions.clear();
        this.deletionCounter = 0;
        this.lastSpelling = "";
    }

    @Override
    public String getConvertedChars() {
        this.constructCurrentPartialConversion("");
        return this.currPartialConversion.toString();
    }

    public static final int countSeparator(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return 0;
        }
        char[] cArray = string.toCharArray();
        int n = 0;
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if ('\'' != cArray[i2]) continue;
            ++n;
        }
        return n;
    }
}

