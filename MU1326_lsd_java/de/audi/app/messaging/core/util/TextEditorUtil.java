/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import org.dsi.ifc.online.DictationValueSentence;
import org.dsi.ifc.online.DictationValueSentenceElement;

public final class TextEditorUtil
extends AbstractMessagingComponent
implements IMessagingComponent {
    public TextEditorUtil(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public static String mapToString(LinkedList linkedList) {
        Buffer buffer = new Buffer(linkedList.size() * 4);
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String[] stringArray = (String[])iterator.next();
            buffer.append(stringArray[0]);
        }
        return buffer.toString();
    }

    public static LinkedList mapToTextList(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ,.?!-\"\\:;()<>=@~/%#\u00a7\u0080$\n", true);
        LinkedList linkedList = new LinkedList();
        while (stringTokenizer.hasMoreTokens()) {
            linkedList.add(new String[]{stringTokenizer.nextToken()});
        }
        return linkedList;
    }

    public static LinkedList concatDictationText(LinkedList linkedList, LinkedList linkedList2) {
        LinkedList linkedList3 = null;
        if (linkedList.isEmpty()) {
            linkedList3 = new LinkedList(linkedList2);
        } else if (linkedList2.isEmpty()) {
            linkedList3 = new LinkedList(linkedList);
        } else {
            String string;
            linkedList3 = new LinkedList(linkedList);
            boolean bl = true;
            String[] stringArray = (String[])linkedList.getLast();
            String[] stringArray2 = (String[])linkedList.getFirst();
            if (stringArray != null && stringArray.length == 1 && (string = stringArray[0]) != null && string.length() == 1) {
                boolean bl2 = bl = !Character.isWhitespace(string.charAt(0));
            }
            if (bl && stringArray2 != null && stringArray2.length == 1 && (string = stringArray2[0]) != null && string.length() == 1) {
                boolean bl3 = bl = !Character.isWhitespace(string.charAt(0));
            }
            if (bl) {
                linkedList3.add(new String[]{" "});
            }
            linkedList3.addAll(linkedList2);
        }
        return linkedList3;
    }

    public static LinkedList truncateDictationText(LinkedList linkedList, int n) {
        return new LinkedList(linkedList.subList(0, n));
    }

    public void setText(int n, LinkedList linkedList, boolean bl, int n2) {
        this.log.log(10000000, "[TextEditorUtil#setTextEditorContent] hasAlternatives = %1, focusedIndex = %2", bl, (long)n2);
        int n3 = n2;
        int n4 = linkedList.size();
        if (n2 != 0) {
            if (n4 == 0) {
                n3 = 0;
            } else if (n2 < 0) {
                n3 = 0;
            } else if (n2 > n4 - 1) {
                n3 = n4 - 1;
            }
            if (n3 != n2) {
                this.log.log(100000, "[TextEditorUtil#setTextEditorContent] focusedIndex out of bounds, adjusted value: %1 -> %2.", (long)n2, (long)n3);
            }
        }
        int n5 = bl ? 1 : 0;
        TextEditorModelApp textEditorModelApp = this.framework.getHmiServiceApp().getTextEditorModel(n);
        textEditorModelApp.setDictationMode(n5);
        textEditorModelApp.setText(linkedList);
    }

    public LinkedList processDictationText(DictationValueSentence dictationValueSentence) {
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
            this.log.log(10000000, "[TextEditorUtil#getDictationText] Applying HMI space insertion.");
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

    public void addCaseAlternative(LinkedList linkedList) {
        try {
            String string;
            String[] stringArray;
            if (!linkedList.isEmpty() && (stringArray = (String[])linkedList.getFirst()) != null && stringArray.length == 1 && (string = stringArray[0]) != null && string.length() > 0) {
                char c2 = string.charAt(0);
                String string2 = null;
                if (Character.isUpperCase(c2)) {
                    string2 = string.toLowerCase();
                } else if (Character.isLowerCase(c2)) {
                    string2 = string.toUpperCase();
                }
                if (string2 != null) {
                    String[] stringArray2 = new String[]{string, string2};
                    linkedList.set(0, stringArray2);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[TextEditorUtil#addCaseAlternative]");
        }
    }

    private DictationValueSentenceElement[] rectifyDictationElements(DictationValueSentenceElement[] dictationValueSentenceElementArray) {
        LinkedList linkedList = new LinkedList();
        boolean bl = true;
        if (dictationValueSentenceElementArray == null) {
            this.log.log(100000, "[TextEditorUtil#rectifyDictationElements] Element array is null.");
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
            this.log.log(100000, "[TextEditorUtil#rectifyDictationElement] Element at index %1 is null.", (long)n);
        } else {
            String[] stringArray = dictationValueSentenceElement.getWords();
            if (stringArray == null) {
                this.log.log(100000, "[TextEditorUtil#rectifyDictationElement] Word array of element at index %1 is null.", (long)n);
            } else if (stringArray.length == 0) {
                this.log.log(100000, "[TextEditorUtil#rectifyDictationElement] Word array of element at index %1 is empty.", (long)n);
            } else {
                int n2 = 0;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    if (!Strings.isNullOrEmpty(stringArray[i2])) {
                        ++n2;
                        continue;
                    }
                    this.log.log(100000, "[TextEditorUtil#rectifyDictationElement] Word array of element at index %1 has a null or empty element at index %2.", (long)n, (long)i2);
                }
                if (n2 == stringArray.length) {
                    dictationValueSentenceElement2 = dictationValueSentenceElement;
                } else if (n2 > 0) {
                    String[] stringArray2 = new String[n2];
                    int n3 = 0;
                    for (int i3 = 0; i3 < stringArray.length; ++i3) {
                        if (Strings.isNullOrEmpty(stringArray[i3])) continue;
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

