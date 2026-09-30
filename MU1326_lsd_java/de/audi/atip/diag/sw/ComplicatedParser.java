/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag.sw;

import de.audi.atip.diag.sw.IParamParser;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ComplicatedParser
implements IParamParser {
    public static final int CLASS_TYPE_UNKNOWN = -1;
    public static final int CLASS_TYPE_INT = 0;
    public static final int CLASS_TYPE_LONG = 1;
    public static final int CLASS_TYPE_FLOAT = 2;
    public static final int CLASS_TYPE_DOUBLE = 3;
    public static final int CLASS_TYPE_STRING = 4;
    public static final int CLASS_TYPE_BOOLEAN = 5;
    public static final Class[][] TYPES = new Class[][]{{Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, class$java$lang$String == null ? (class$java$lang$String = ComplicatedParser.class$("java.lang.String")) : class$java$lang$String, Boolean.TYPE}, {array$I == null ? (array$I = ComplicatedParser.class$("[I")) : array$I, array$J == null ? (array$J = ComplicatedParser.class$("[J")) : array$J, array$F == null ? (array$F = ComplicatedParser.class$("[F")) : array$F, array$D == null ? (array$D = ComplicatedParser.class$("[D")) : array$D, array$Ljava$lang$String == null ? (array$Ljava$lang$String = ComplicatedParser.class$("[Ljava.lang.String;")) : array$Ljava$lang$String, array$Z == null ? (array$Z = ComplicatedParser.class$("[Z")) : array$Z}, {array$$I == null ? (array$$I = ComplicatedParser.class$("[[I")) : array$$I, array$$J == null ? (array$$J = ComplicatedParser.class$("[[J")) : array$$J, array$$F == null ? (array$$F = ComplicatedParser.class$("[[F")) : array$$F, array$$D == null ? (array$$D = ComplicatedParser.class$("[[D")) : array$$D, array$$Ljava$lang$String == null ? (array$$Ljava$lang$String = ComplicatedParser.class$("[[Ljava.lang.String;")) : array$$Ljava$lang$String, array$$Z == null ? (array$$Z = ComplicatedParser.class$("[[Z")) : array$$Z}, {array$$$I == null ? (array$$$I = ComplicatedParser.class$("[[[I")) : array$$$I, array$$$J == null ? (array$$$J = ComplicatedParser.class$("[[[J")) : array$$$J, array$$$F == null ? (array$$$F = ComplicatedParser.class$("[[[F")) : array$$$F, array$$$D == null ? (array$$$D = ComplicatedParser.class$("[[[D")) : array$$$D, array$$$Ljava$lang$String == null ? (array$$$Ljava$lang$String = ComplicatedParser.class$("[[[Ljava.lang.String;")) : array$$$Ljava$lang$String, array$$$Z == null ? (array$$$Z = ComplicatedParser.class$("[[[Z")) : array$$$Z}};
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$J;
    static /* synthetic */ Class array$F;
    static /* synthetic */ Class array$D;
    static /* synthetic */ Class array$Ljava$lang$String;
    static /* synthetic */ Class array$Z;
    static /* synthetic */ Class array$$I;
    static /* synthetic */ Class array$$J;
    static /* synthetic */ Class array$$F;
    static /* synthetic */ Class array$$D;
    static /* synthetic */ Class array$$Ljava$lang$String;
    static /* synthetic */ Class array$$Z;
    static /* synthetic */ Class array$$$I;
    static /* synthetic */ Class array$$$J;
    static /* synthetic */ Class array$$$F;
    static /* synthetic */ Class array$$$D;
    static /* synthetic */ Class array$$$Ljava$lang$String;
    static /* synthetic */ Class array$$$Z;

    private String parseNewLine(String string) {
        String string2 = string;
        if (string2 != null && string2.length() > 0) {
            int n = 0;
            int n2 = -1;
            while ((n2 = string2.indexOf("\\n", n)) != -1) {
                string2 = new StringBuffer().append(string2.substring(0, n2)).append('\n').append(string2.substring(n2 + 2)).toString();
                n = n2 + 1;
            }
        }
        return string2;
    }

    protected String tokenizer(StringTokenizer stringTokenizer, LinkedList linkedList, LinkedList linkedList2, int n, int[] nArray, int[] nArray2) {
        nArray[0] = n;
        LinkedList linkedList3 = null;
        LinkedList linkedList4 = null;
        nArray2[0] = -1;
        String string = null;
        while (stringTokenizer.hasMoreTokens()) {
            string = stringTokenizer.nextToken().trim();
            if (string.compareTo(",") == 0) continue;
            if (string.compareTo("{") == 0) {
                linkedList3 = new LinkedList();
                linkedList4 = new LinkedList();
                string = this.tokenizer(stringTokenizer, linkedList3, linkedList4, n + 1, nArray, nArray2);
                if (string.compareTo("}") != 0 || nArray2[0] == -1) continue;
                linkedList.add(TYPES[nArray[0] - n][nArray2[0]]);
                Object object = Array.newInstance(TYPES[nArray[0] - n - 1][nArray2[0]], linkedList4.size());
                linkedList4.toArray((Object[])object);
                linkedList2.add(object);
                string = null;
                continue;
            }
            if (string.compareTo("}") == 0) break;
            try {
                nArray2[0] = 0;
                int n2 = Integer.parseInt(string);
                linkedList.add(Integer.TYPE);
                linkedList2.add(new Integer(n2));
                string = null;
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    nArray2[0] = 1;
                    long l = Long.parseLong(string);
                    linkedList.add(Long.TYPE);
                    linkedList2.add(new Long(l));
                    string = null;
                }
                catch (NumberFormatException numberFormatException2) {
                    try {
                        nArray2[0] = 2;
                        float f2 = Float.parseFloat(string);
                        linkedList.add(Float.TYPE);
                        linkedList2.add(new Float(f2));
                        string = null;
                    }
                    catch (NumberFormatException numberFormatException3) {
                        try {
                            nArray2[0] = 3;
                            double d2 = Double.parseDouble(string);
                            linkedList.add(Double.TYPE);
                            linkedList2.add(new Double(d2));
                            string = null;
                        }
                        catch (NumberFormatException numberFormatException4) {
                            if (string != null && (string.toLowerCase().equals("true") || string.toLowerCase().equals("false"))) {
                                nArray2[0] = 5;
                                linkedList.add(Boolean.TYPE);
                                linkedList2.add(Boolean.valueOf(string));
                                string = null;
                                continue;
                            }
                            nArray2[0] = 4;
                            linkedList.add(class$java$lang$String == null ? ComplicatedParser.class$("java.lang.String") : class$java$lang$String);
                            if (string.startsWith("\"") && string.endsWith("\"")) {
                                char[] cArray = new char[string.length() - 2];
                                string.getChars(1, string.length() - 1, cArray, 0);
                                string = new String(cArray);
                            }
                            string = this.parseNewLine(string);
                            linkedList2.add(string);
                            string = null;
                        }
                    }
                }
            }
        }
        return string;
    }

    public boolean parseParams(String string, LinkedList linkedList, LinkedList linkedList2) {
        boolean bl = false;
        try {
            if (string != null && linkedList != null && linkedList2 != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",{}", true);
                this.tokenizer(stringTokenizer, linkedList, linkedList2, 0, new int[]{0}, new int[]{0});
                bl = true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    public void testFunction(String[] stringArray) {
        System.out.println(stringArray);
    }

    public void testFunction(String[][] stringArray) {
        System.out.println(stringArray);
    }

    public void testFunction(String[][][] stringArray) {
        System.out.println(stringArray);
    }

    public void testFunction(String[] stringArray, long l, String[] stringArray2, String[][] stringArray3) {
        System.out.println("");
    }

    public static void main(String[] stringArray) {
        ComplicatedParser complicatedParser = new ComplicatedParser();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean bl = false;
        bl = complicatedParser.parseParams("", linkedList, linkedList2);
        System.out.println(bl);
        Method method = null;
        try {
            method = complicatedParser.getClass().getMethod("testFunction", (Class[])linkedList.toArray(new Class[linkedList.size()]));
            Object[] objectArray = linkedList2.toArray();
            method.invoke(complicatedParser, objectArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
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

