/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.ITranscriptPreprocessor;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;
import org.dsi.ifc.online.DictationValueSentence;
import org.dsi.ifc.online.DictationValueSentenceElement;

final class TranscriptPreprocessor
implements ITranscriptPreprocessor {
    private final LogChannel log;

    TranscriptPreprocessor(LogChannel logChannel) {
        this.log = logChannel;
    }

    public LinkedList preprocessTranscript(DictationValueSentence dictationValueSentence) {
        DictationValueSentenceElement dictationValueSentenceElement;
        int n;
        DictationValueSentenceElement[] dictationValueSentenceElementArray = this.rectifyDictationElements(dictationValueSentence.getList());
        LinkedList linkedList = new LinkedList();
        boolean bl = false;
        if (dictationValueSentenceElementArray.length > 1) {
            bl = true;
            for (n = 0; n < dictationValueSentenceElementArray.length; ++n) {
                dictationValueSentenceElement = dictationValueSentenceElementArray[n];
                String string = dictationValueSentenceElement.getWords()[0];
                if (string.length() != 1 || !Character.isWhitespace(string.charAt(0))) continue;
                bl = false;
                break;
            }
        }
        if (bl) {
            this.log.log(10000000, "[TranscriptPreprocessor#preprocessTranscript] Applying HMI space insertion.");
        }
        for (n = 0; n < dictationValueSentenceElementArray.length; ++n) {
            dictationValueSentenceElement = dictationValueSentenceElementArray[n];
            linkedList.add(dictationValueSentenceElement.getWords());
            if (!bl || n >= dictationValueSentenceElementArray.length - 1) continue;
            boolean bl2 = true;
            String string = dictationValueSentenceElementArray[n + 1].getWords()[0];
            if (string.length() == 1) {
                char c2 = string.charAt(0);
                switch (c2) {
                    case '!': 
                    case ',': 
                    case '.': 
                    case ':': 
                    case ';': 
                    case '?': {
                        bl2 = false;
                        break;
                    }
                    default: {
                        bl2 = true;
                    }
                }
            }
            if (!bl2) continue;
            linkedList.add(new String[]{" "});
        }
        return linkedList;
    }

    private DictationValueSentenceElement[] rectifyDictationElements(DictationValueSentenceElement[] dictationValueSentenceElementArray) {
        LinkedList linkedList = new LinkedList();
        boolean bl = true;
        if (dictationValueSentenceElementArray == null) {
            this.log.log(100000, "[TranscriptPreprocessor#rectifyDictationElements] Element array is null.");
            bl = false;
        } else {
            for (int i2 = 0; i2 < dictationValueSentenceElementArray.length; ++i2) {
                DictationValueSentenceElement dictationValueSentenceElement = dictationValueSentenceElementArray[i2];
                DictationValueSentenceElement dictationValueSentenceElement2 = this.rectifyDictationElement(dictationValueSentenceElement, i2);
                if (dictationValueSentenceElement2 == null) {
                    bl = false;
                    continue;
                }
                if (dictationValueSentenceElement2 != dictationValueSentenceElement) {
                    bl = false;
                    linkedList.add(dictationValueSentenceElement2);
                    continue;
                }
                linkedList.add(dictationValueSentenceElement);
            }
        }
        Object[] objectArray = null;
        if (bl) {
            objectArray = dictationValueSentenceElementArray;
        } else {
            objectArray = new DictationValueSentenceElement[linkedList.size()];
            objectArray = (DictationValueSentenceElement[])linkedList.toArray(objectArray);
        }
        return objectArray;
    }

    private DictationValueSentenceElement rectifyDictationElement(DictationValueSentenceElement dictationValueSentenceElement, int n) {
        DictationValueSentenceElement dictationValueSentenceElement2 = null;
        if (dictationValueSentenceElement == null) {
            this.log.log(100000, "[TranscriptPreprocessor#rectifyDictationElement] Element at index %1 is null.", (long)n);
        } else {
            String[] stringArray = dictationValueSentenceElement.getWords();
            if (stringArray == null) {
                this.log.log(100000, "[TranscriptPreprocessor#rectifyDictationElement] Word array of element at index %1 is null.", (long)n);
            } else if (stringArray.length == 0) {
                this.log.log(100000, "[TranscriptPreprocessor#rectifyDictationElement] Word array of element at index %1 is empty.", (long)n);
            } else {
                int n2 = 0;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    if (!DictationUtil.isNullOrEmpty(stringArray[i2])) {
                        ++n2;
                        continue;
                    }
                    this.log.log(100000, "[TranscriptPreprocessor#rectifyDictationElement] Word array of element at index %1 has a null or empty element at index %2.", (long)n, (long)i2);
                }
                if (n2 == stringArray.length) {
                    dictationValueSentenceElement2 = dictationValueSentenceElement;
                } else if (n2 > 0) {
                    String[] stringArray2 = new String[n2];
                    int n3 = 0;
                    for (int i3 = 0; i3 < stringArray.length; ++i3) {
                        if (DictationUtil.isNullOrEmpty(stringArray[i3])) continue;
                        stringArray2[n3] = stringArray[i3];
                        ++n3;
                    }
                    dictationValueSentenceElement2 = new DictationValueSentenceElement(stringArray2);
                }
            }
        }
        return dictationValueSentenceElement2;
    }
}

