/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.RadioTextPlus;
import de.audi.tuner.app.Utilities;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class RadioTextPlusStorage {
    private final SimpleIntObjectMap rtContent;
    private final LogChannel log;
    private final String tuner;

    public RadioTextPlusStorage(LogChannel logChannel, String string) {
        this.log = logChannel;
        this.tuner = string;
        this.rtContent = new SimpleIntObjectMap(10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRadiotextPlus(int[] nArray, String[] stringArray) {
        SimpleIntObjectMap simpleIntObjectMap = this.rtContent;
        synchronized (simpleIntObjectMap) {
            this.storeContent(nArray, stringArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public RadioTextPlus getRadioTextPlus() {
        Object[] objectArray;
        int[] nArray;
        SimpleIntObjectMap simpleIntObjectMap = this.rtContent;
        synchronized (simpleIntObjectMap) {
            nArray = this.rtContent.getKeys();
            objectArray = this.rtContent.getValues();
        }
        simpleIntObjectMap = new SimpleIntObjectMap(objectArray.length);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            simpleIntObjectMap.add(nArray[i2], objectArray[i2]);
        }
        return new RadioTextPlus(simpleIntObjectMap, this.log);
    }

    public String getTag(int n) {
        String string = (String)this.rtContent.get(n);
        if (string != null) {
            return string;
        }
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        SimpleIntObjectMap simpleIntObjectMap = this.rtContent;
        synchronized (simpleIntObjectMap) {
            this.rtContent.clear();
        }
    }

    private void storeContent(int[] nArray, String[] stringArray) {
        if (!this.isRTPlusDataConsistent(nArray, stringArray)) {
            this.log.log(10000, "[%1.RadioTextPlusStorage.storeContent]RT+ update has errors -> reset RT+", (Object)this.tuner);
            this.reset();
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            String string = stringArray[i2];
            if (Utilities.isEmpty(string)) {
                this.rtContent.remove(n);
                continue;
            }
            this.rtContent.add(n, RadioTextPlusStorage.replaceTextRTplus(string.trim()));
        }
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[%3.RadioTextPlusStorage.storeContent] RT+: %1, %2 ", (Object)Utilities.toString(nArray), (Object)Utilities.toString(stringArray), (Object)this.tuner);
        }
    }

    private boolean isRTPlusDataConsistent(int[] nArray, String[] stringArray) {
        if (nArray != null && stringArray != null) {
            if (nArray.length == stringArray.length) {
                return true;
            }
            this.log.log(10000, "[%3.RadioTextPlusStorage.isRTPlusDataConsistent]RT+ data is inconsistent, length of tags: %1, length of content: %2", (Object)String.valueOf(nArray.length), (Object)String.valueOf(stringArray.length), (Object)this.tuner);
            return false;
        }
        this.log.log(10000, "[%3.RadioTextPlusStorage.isRTPlusDataConsistent]RT+ data is null, tags: %1, content: %2", (Object)nArray, (Object)stringArray, (Object)this.tuner);
        return false;
    }

    private static String replaceTextRTplus(String string) {
        String string2 = Utilities.replaceDelimiter(string, '\t', " ");
        string2 = Utilities.replaceDelimiter(string2, '\n', " ");
        string2 = Utilities.replaceDelimiter(string2, '\r', "");
        string2 = Utilities.replaceDelimiter(string2, '\u001f', "-");
        string2 = Utilities.replaceDelimiter(string2, '\u200e', "");
        string2 = Utilities.replaceDelimiter(string2, '\u200f', "");
        return string2;
    }
}

