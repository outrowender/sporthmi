/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.atip.diag.sw;

import de.audi.atip.diag.sw.IParamParser;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class OriginalParser
implements IParamParser {
    static /* synthetic */ Class class$java$lang$String;

    @Override
    public boolean parseParams(String string, LinkedList linkedList, LinkedList linkedList2) {
        boolean bl;
        boolean bl2 = bl = string != null && linkedList != null && linkedList2 != null;
        if (bl) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String string2 = stringTokenizer.nextToken().trim();
                try {
                    int n = Integer.parseInt(string2);
                    linkedList.add(Integer.TYPE);
                    linkedList2.add(new Integer(n));
                }
                catch (NumberFormatException numberFormatException) {
                    try {
                        if (OriginalParser.isLongWithIdentifier(string2)) {
                            string2 = string2.substring(0, string2.length() - 1);
                        }
                        long l = Long.parseLong(string2);
                        linkedList.add(Long.TYPE);
                        linkedList2.add(new Long(l));
                    }
                    catch (NumberFormatException numberFormatException2) {
                        try {
                            float f2 = Float.parseFloat(string2);
                            linkedList.add(Float.TYPE);
                            linkedList2.add(new Float(f2));
                        }
                        catch (NumberFormatException numberFormatException3) {
                            try {
                                double d2 = Double.parseDouble((String)string2);
                                linkedList.add(Double.TYPE);
                                linkedList2.add(new Double(d2));
                            }
                            catch (NumberFormatException numberFormatException4) {
                                if (string2 != null && (string2.toLowerCase().equals("true") || string2.toLowerCase().equals("false"))) {
                                    linkedList.add(Boolean.TYPE);
                                    linkedList2.add(Boolean.valueOf(string2));
                                    continue;
                                }
                                linkedList.add(class$java$lang$String == null ? OriginalParser.class$("java.lang.String") : class$java$lang$String);
                                if (string2.startsWith("\"") && string2.endsWith("\"")) {
                                    char[] cArray = new char[string2.length() - 2];
                                    string2.getChars(1, string2.length() - 1, cArray, 0);
                                    string2 = new String(cArray);
                                }
                                linkedList2.add(string2);
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    public static boolean isLongWithIdentifier(String string) {
        if (null == string) {
            return false;
        }
        if ((string = string.trim()).length() <= 1) {
            return false;
        }
        char c2 = string.charAt(string.length() - 1);
        if (c2 != 'L' && c2 != 'l') {
            return false;
        }
        string = string.substring(0, string.length() - 1);
        try {
            Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

