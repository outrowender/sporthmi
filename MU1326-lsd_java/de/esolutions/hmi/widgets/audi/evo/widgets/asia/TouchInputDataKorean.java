/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.awtce.krstr.KoreanStringConversion
 *  de.awtce.krstr.KoreanStringConversion$KrstrException
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.awtce.krstr.KoreanStringConversion;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;

public final class TouchInputDataKorean
extends TouchInputDataAsia
implements ITouchInputDataAsia {
    @Override
    public void appendUnconvertedCharacters(String string, boolean bl) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            String string2 = this.getUnconvertedCharacters();
            this.autoConversionForAppendUnconvertedChars(string2, string, bl);
        }
    }

    @Override
    protected void deleteLastUnconvertedCharacter() {
        if (this.hasUnconvertedCharacters()) {
            String string;
            String string2 = string = this.getUnconvertedCharacters();
            try {
                string2 = TouchInputDataKorean.deletLastUnconverted(string);
            }
            catch (KoreanStringConversion.KrstrException krstrException) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchInputDataAsiaKorean#deleteLastUnconvertedCharacter: KrstrException when convert.");
            }
            this.currentlyUnconvertedCharacters.clear();
            this.currentlyUnconvertedCharacters.append(string2);
            this.notifyDataChange(3, false, string, this.getUnconvertedCharacters());
        }
    }

    private void autoConversionForAppendUnconvertedChars(String string, String string2, boolean bl) {
        String[] stringArray = null;
        try {
            stringArray = TouchInputDataKorean.getHangulConversion(string, string2);
        }
        catch (KoreanStringConversion.KrstrException krstrException) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchInputDataAsiaKorean#autoConversionForAppendUnconvertedChars: KrstrException when convert.");
        }
        if (stringArray == null || stringArray.length != 2) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchInputDataAsiaKorean#autoConversionForAppendUnconvertedChars: Conversion from KRStrConv is incorrect.");
            return;
        }
        if (stringArray[1].equals("")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchInputDataAsiaKorean#autoConversionForAppendUnconvertedChars: Conversion from KRStrConv is incorrect.");
        } else {
            this.currentlyUnconvertedCharacters.clear();
            this.currentlyUnconvertedCharacters.append(stringArray[1]);
            this.notifyDataChange(3, bl, string, this.getUnconvertedCharacters());
            if (stringArray[0].length() > 0) {
                this.appendRegularCharacters(stringArray[0], bl);
            }
        }
    }

    public static String deletLastUnconverted(String string) {
        return KoreanStringConversion.delete_last_jamo((String)string);
    }

    public static String[] getHangulConversion(String string, String string2) {
        String[] stringArray = new String[2];
        String string3 = KoreanStringConversion.jamo_to_hangul((String)new StringBuffer().append(string).append(string2).toString());
        stringArray[0] = string3.substring(0, string3.length() - 1);
        stringArray[1] = Character.toString(string3.charAt(string3.length() - 1));
        return stringArray;
    }
}

