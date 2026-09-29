/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

import de.audi.app.sdsmanager.apps.phone.PhoneSequenceElement;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public class PhoneSequenceHandler {
    public static final String SEQUENCE_DELIMITER;
    private final LogChannel lc = Logger.getAppPhoneLog();
    private List numberSequence = new ArrayList(3);
    private List pinSequence = new ArrayList(1);
    private List mailboxSequence = new ArrayList(3);

    final void clearSequence(byte by) {
        this.lc.log(-2137614336, "PhoneSequenceHandler#clearSequence: type=%1", (long)by);
        switch (by) {
            case 0: {
                this.numberSequence.clear();
                break;
            }
            case 1: {
                this.pinSequence.clear();
                break;
            }
            case 2: {
                this.mailboxSequence.clear();
                break;
            }
            default: {
                this.lc.log(-1601830656, "PhoneSequenceHandler#clearSequence: Unhandled type %1!", (long)by);
            }
        }
    }

    public void addToSequence(PhoneSequenceElement phoneSequenceElement, byte by) {
        if (phoneSequenceElement == null) {
            this.lc.log(10000, "PhoneSequenceHandler#addToSequence: No element given!");
            return;
        }
        List list = this.getSequence(by);
        if (list == null) {
            this.lc.log(10000, "PhoneSequenceHandler#addToSequence: Unhandled type %1!", (long)by);
            return;
        }
        this.lc.log(-2137614336, "PhoneSequenceHandler#addToSequence: Adding sequence element %1!", (Object)phoneSequenceElement);
        list.add(phoneSequenceElement);
    }

    public String removeLastFromSequence(byte by) {
        List list = this.getSequence(by);
        if (list == null || !this.hasSequenceElements(by)) {
            return null;
        }
        return ((PhoneSequenceElement)list.remove(list.size() - 1)).getNumber();
    }

    void matchTextWithSequence(String string, byte by) {
        switch (by) {
            case 0: {
                this.numberSequence = PhoneSequenceHandler.matchChangedText(string, this.numberSequence);
                this.lc.log(-2137614336, "PhoneSequenceHandler#matchTextWithSequence: numberSequence=%1", (Object)this.numberSequence);
                break;
            }
            case 1: {
                this.pinSequence = PhoneSequenceHandler.matchChangedText(string, this.pinSequence);
                this.lc.log(-2137614336, "PhoneSequenceHandler#matchTextWithSequence: pinSequence=%1", (Object)this.pinSequence);
                break;
            }
            case 2: {
                this.mailboxSequence = PhoneSequenceHandler.matchChangedText(string, this.mailboxSequence);
                this.lc.log(-2137614336, "PhoneSequenceHandler#matchTextWithSequence: mailboxSequence=%1", (Object)this.mailboxSequence);
                break;
            }
            default: {
                this.lc.log(-1601830656, "PhoneSequenceHandler#matchTextWithSequence: Unhandled type %1!", (long)by);
            }
        }
    }

    private static List matchChangedText(String string, List list) {
        String string2 = SDSUtils.remove(string, ' ');
        int n = string2.length();
        ArrayList arrayList = new ArrayList(3);
        if (n == 0) {
            return arrayList;
        }
        String string3 = PhoneSequenceHandler.sequencetoString(list);
        int n2 = string3.length();
        if (n == n2) {
            return list;
        }
        int n3 = PhoneSequenceHandler.getDiffPos(string2, string3);
        if (n3 == n2) {
            return PhoneSequenceHandler.appendToSequence(list, string2.substring(n3));
        }
        int n4 = 0;
        int n5 = 0;
        boolean bl = false;
        int n6 = list.size();
        for (int i2 = 0; i2 < n6; ++i2) {
            PhoneSequenceElement phoneSequenceElement = (PhoneSequenceElement)list.get(i2);
            if (bl) {
                arrayList.add(phoneSequenceElement);
                continue;
            }
            String string4 = phoneSequenceElement.getNumber();
            int n7 = string4.length();
            if (n7 == 1 && n < n2) {
                bl = true;
                continue;
            }
            if ((n5 += n7) <= n3) {
                n4 = n5;
                arrayList.add(phoneSequenceElement);
                continue;
            }
            bl = true;
            if (n4 >= string2.length()) break;
            int n8 = Math.min(string2.length(), n5 + (n > n2 ? 1 : -1));
            phoneSequenceElement.setNumber(string2.substring(n4, n8));
            arrayList.add(phoneSequenceElement);
        }
        return arrayList;
    }

    private static List appendToSequence(List list, String string) {
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.isEmpty()) {
            arrayList.add(new PhoneSequenceElement(string, true));
            return arrayList;
        }
        PhoneSequenceElement phoneSequenceElement = (PhoneSequenceElement)arrayList.get(arrayList.size() - 1);
        if (phoneSequenceElement.isHaptical()) {
            String string2 = phoneSequenceElement.getNumber();
            phoneSequenceElement.setNumber(new StringBuffer().append(string2).append(string).toString());
            return arrayList;
        }
        arrayList.add(new PhoneSequenceElement(string, true));
        return arrayList;
    }

    public static String sequencetoString(List list) {
        int n = list.size();
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(((PhoneSequenceElement)list.get(i2)).getNumber());
        }
        return buffer.toString();
    }

    public String sequenceToString(byte by, String string) {
        return PhoneSequenceHandler.sequenceToString(this.getSequence(by), string);
    }

    private static String sequenceToString(List list, String string) {
        if (list == null) {
            System.err.println("PhoneSequenceHandler#sequenceToString: No sequence given!");
            return null;
        }
        int n = list.size() - 1;
        if (n == -1) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < n; ++i2) {
            PhoneSequenceElement phoneSequenceElement = (PhoneSequenceElement)list.get(i2);
            buffer.append(phoneSequenceElement.getNumber());
        }
        PhoneSequenceElement phoneSequenceElement = (PhoneSequenceElement)list.get(n);
        buffer.append(n > 0 && !phoneSequenceElement.isHaptical() ? string : "").append(phoneSequenceElement.getNumber());
        return buffer.toString();
    }

    private static int getDiffPos(String string, String string2) {
        if (string == null || string2 == null) {
            System.err.println("PhoneSequenceHandler#getDiffPos: No actual or no expected string given!");
            return 0;
        }
        int n = Math.min(string.length(), string2.length());
        for (int i2 = 0; i2 < n; ++i2) {
            if (string.charAt(i2) == string2.charAt(i2)) continue;
            return i2;
        }
        return n;
    }

    public List getSequence(byte by) {
        switch (by) {
            case 0: {
                return this.numberSequence;
            }
            case 1: {
                return this.pinSequence;
            }
            case 2: {
                return this.mailboxSequence;
            }
        }
        return null;
    }

    public boolean hasSequenceElements(byte by) {
        List list = this.getSequence(by);
        if (list == null) {
            return false;
        }
        return !list.isEmpty();
    }

    public static void main(String[] stringArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new PhoneSequenceElement("1", true));
        arrayList.add(new PhoneSequenceElement("45", false));
        arrayList.add(new PhoneSequenceElement("678", false));
        String string = PhoneSequenceHandler.sequencetoString(arrayList);
        String string2 = new StringBuffer().append("Old sequence: ").append(string).toString();
        System.out.println(new StringBuffer().append("Expected: ").append(string).append("\nActual:   ").append("45678").toString());
        System.out.println(new StringBuffer().append("Differing position: ").append(PhoneSequenceHandler.getDiffPos(string, SDSUtils.remove("45678", ' '))).toString());
        List list = PhoneSequenceHandler.matchChangedText("45678", arrayList);
        System.out.println(new StringBuffer().append(string2).append("\nNew sequence: ").append(PhoneSequenceHandler.sequencetoString(list)).toString());
    }
}

