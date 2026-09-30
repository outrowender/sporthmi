/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.text.Normalizer;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Vector;

public class X500Principal
implements Principal {
    public static final int OUTPUT_RFC1779 = 0;
    public static final int OUTPUT_RFC2253 = 1;
    public static final int OUTPUT_CANONICAL = 2;
    private static final int RFC_1779 = 0;
    private static final int RFC_2253 = 1;
    private static final int RFC_2459 = 2;
    private int[] supportedStandards;
    private boolean[] outputMarker;
    protected Vector attributeTypes;
    protected Vector attributeValues;
    private static final ASN1OID[] RFC_1779_OIDs = new ASN1OID[7];
    private static final ASN1OID[] RFC_2253_OIDs = new ASN1OID[2];
    private static final ASN1OID[] RFC_2459_OIDs = new ASN1OID[9];
    private static final String[] RFC_1779_OID_keys = new String[7];
    private static final String[] RFC_2253_OID_keys = new String[2];
    private static final String[] RFC_2459_OID_keys = new String[9];

    static {
        int n = 0;
        int[] nArray = new int[]{2, 5, 4, 3};
        X500Principal.RFC_1779_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "CN";
        nArray = new int[]{2, 5, 4, 11};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "OU";
        nArray = new int[]{2, 5, 4, 10};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "O";
        nArray = new int[]{2, 5, 4, 9};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "STREET";
        nArray = new int[]{2, 5, 4, 7};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "L";
        nArray = new int[]{2, 5, 4, 8};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "ST";
        nArray = new int[]{2, 5, 4, 6};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "C";
        ++n;
        n = 0;
        int[] nArray2 = new int[7];
        nArray2[1] = 9;
        nArray2[2] = 2342;
        nArray2[3] = 19200300;
        nArray2[4] = 100;
        nArray2[5] = 1;
        nArray2[6] = 25;
        nArray = nArray2;
        X500Principal.RFC_2253_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2253_OID_keys[n] = "DC";
        ++n;
        int[] nArray3 = new int[7];
        nArray3[1] = 9;
        nArray3[2] = 2342;
        nArray3[3] = 19200300;
        nArray3[4] = 100;
        nArray3[5] = 1;
        nArray3[6] = 1;
        nArray = nArray3;
        X500Principal.RFC_2253_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2253_OID_keys[n] = "UID";
        ++n;
        n = 0;
        nArray = new int[]{2, 5, 4, 12};
        X500Principal.RFC_2459_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "TITLE";
        nArray = new int[]{2, 5, 4, 42};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "GIVENNAME";
        nArray = new int[]{2, 5, 4, 43};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "INITIALS";
        nArray = new int[]{2, 5, 4, 41};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "SURNAME";
        nArray = new int[]{2, 5, 4, 44};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "GENERATION";
        nArray = new int[]{1, 2, 840, 113549, 1, 9, 1};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "EMAILADDRESS";
        nArray = new int[]{2, 5, 4, 46};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "DNQ";
        nArray = new int[]{2, 5, 4, 46};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "DNQUALIFIER";
        nArray = new int[]{2, 5, 4, 5};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "SERIALNUMBER";
        ++n;
    }

    public X500Principal(String string) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        this.initFrom(string);
        if (this.attributeTypes.size() == 0) {
            throw new IllegalArgumentException(Msg.getString("K039f"));
        }
    }

    public X500Principal(byte[] byArray) throws ASN1Exception {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        ASN1Decoder.Node node = aSN1Decoder.readContents();
        this.initFrom(node);
    }

    public X500Principal(InputStream inputStream) throws ASN1Exception {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        ASN1Decoder.Node node = aSN1Decoder.readContents();
        this.initFrom(node);
    }

    public X500Principal(ASN1Decoder.Node node) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        this.initFrom(node);
    }

    private void initFrom(ASN1Decoder.Node node) {
        ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
        int n = 0;
        while (n < nodeArray.length) {
            ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[n].data;
            ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])nodeArray2[0].data;
            String string = null;
            string = nodeArray3[1].data instanceof ASN1Decoder.BMPString ? ((ASN1Decoder.BMPString)nodeArray3[1].data).bmpString : (String)nodeArray3[1].data;
            ASN1OID aSN1OID = new ASN1OID((int[])nodeArray3[0].data);
            this.attributeTypes.addElement(aSN1OID);
            this.attributeValues.addElement(string);
            ++n;
        }
    }

    private void initFrom(String string) {
        int n = 0;
        int n2 = 0;
        char c2 = this.getSeparator();
        while (true) {
            if (n < string.length() && string.charAt(n) == ' ') {
                ++n;
            }
            if ((n2 = string.indexOf(61, n)) == -1) break;
            String string2 = string.substring(n, n2);
            n = n2 + 1;
            boolean bl = false;
            if (string.charAt(n) == '\"') {
                ++n;
                bl = true;
            }
            if ((n2 = string.indexOf(bl ? 34 : (int)c2, n)) == -1) {
                n2 = string.length();
            }
            String string3 = string.substring(n, n2);
            n = n2 + (bl ? 2 : 1);
            ASN1OID aSN1OID = this.getOIDForKey(string2, this.supportedStandards);
            if (aSN1OID == null) {
                String string4 = string2.toLowerCase();
                if (string4.startsWith("oid")) {
                    aSN1OID = new ASN1OID(string4.substring(4));
                } else {
                    throw new IllegalArgumentException(Msg.getString("K03a0"));
                }
            }
            this.attributeTypes.addElement(aSN1OID);
            this.attributeValues.addElement(string3);
        }
    }

    private ASN1OID getOIDForKey(String string, int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException();
        }
        ASN1OID aSN1OID = null;
        int n = 0;
        while (n < nArray.length) {
            aSN1OID = this.getOIDForKey(string, nArray[n]);
            if (aSN1OID != null) {
                return aSN1OID;
            }
            ++n;
        }
        return null;
    }

    private ASN1OID getOIDForKey(String string, int n) {
        String[] stringArray = null;
        ASN1OID[] aSN1OIDArray = null;
        switch (n) {
            case 0: {
                stringArray = RFC_1779_OID_keys;
                aSN1OIDArray = RFC_1779_OIDs;
                break;
            }
            case 1: {
                stringArray = RFC_2253_OID_keys;
                aSN1OIDArray = RFC_2253_OIDs;
                break;
            }
            case 2: {
                stringArray = RFC_2459_OID_keys;
                aSN1OIDArray = RFC_2459_OIDs;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].equals(string)) {
                return aSN1OIDArray[n2];
            }
            ++n2;
        }
        return null;
    }

    private String getKeyForOID(ASN1OID aSN1OID, int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException();
        }
        String string = null;
        int n = 0;
        while (n < nArray.length) {
            string = this.getKeyForOID(aSN1OID, nArray[n]);
            if (string != null) {
                return string;
            }
            ++n;
        }
        return null;
    }

    private String getKeyForOID(ASN1OID aSN1OID, int n) {
        String[] stringArray = null;
        ASN1OID[] aSN1OIDArray = null;
        switch (n) {
            case 0: {
                stringArray = RFC_1779_OID_keys;
                aSN1OIDArray = RFC_1779_OIDs;
                break;
            }
            case 1: {
                stringArray = RFC_2253_OID_keys;
                aSN1OIDArray = RFC_2253_OIDs;
                break;
            }
            case 2: {
                stringArray = RFC_2459_OID_keys;
                aSN1OIDArray = RFC_2459_OIDs;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        int n2 = 0;
        while (n2 < aSN1OIDArray.length) {
            if (aSN1OIDArray[n2].equals(aSN1OID)) {
                return stringArray[n2];
            }
            ++n2;
        }
        return null;
    }

    public String getName() {
        return this.getName(1);
    }

    public String getName(int n) {
        int[] nArray;
        switch (n) {
            case 0: {
                nArray = new int[1];
                break;
            }
            case 1: 
            case 2: {
                int[] nArray2 = new int[2];
                nArray2[1] = 1;
                nArray = nArray2;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        this.outputMarker = new boolean[this.attributeTypes.size()];
        Arrays.fill(this.outputMarker, false);
        ASN1OID[] aSN1OIDArray = RFC_1779_OIDs;
        Vector vector = this.getAttributesForOutputFormat(nArray, null, aSN1OIDArray);
        if (n != 0) {
            aSN1OIDArray = RFC_2253_OIDs;
            vector = this.getAttributesForOutputFormat(nArray, vector, aSN1OIDArray);
        }
        int n2 = 0;
        while (n2 < this.attributeTypes.size()) {
            if (!this.outputMarker[n2]) {
                String string = "OID." + ((ASN1OID)this.attributeTypes.elementAt(n2)).toString();
                String string2 = (String)this.attributeValues.elementAt(n2);
                AttributeValuePair attributeValuePair = new AttributeValuePair(string, string2);
                vector.add(attributeValuePair);
                this.outputMarker[n2] = true;
            }
            ++n2;
        }
        if (n == 2) {
            return this.getAttributesAsCanonicalString(vector);
        }
        return this.getAttributesAsNonCanonicalString(vector);
    }

    private String getAttributesAsCanonicalString(Vector vector) {
        Object object;
        Object object2;
        TreeSet treeSet = new TreeSet();
        Object object3 = vector.iterator();
        while (object3.hasNext()) {
            object2 = (AttributeValuePair)object3.next();
            treeSet.add(object2);
        }
        object3 = new StringBuffer();
        object2 = treeSet.iterator();
        while (object2.hasNext()) {
            object = (AttributeValuePair)object2.next();
            ((StringBuffer)object3).append(((AttributeValuePair)object).getOutputString(2));
            ((StringBuffer)object3).append(this.getSeparator());
        }
        ((StringBuffer)object3).deleteCharAt(((StringBuffer)object3).length() - 1);
        object2 = ((StringBuffer)object3).toString();
        object2 = ((String)object2).toLowerCase(Locale.US);
        object2 = ((String)object2).toUpperCase(Locale.US);
        object = Normalizer.normalize((String)object2, Normalizer.DECOMP_COMPAT, 0);
        return object;
    }

    private String getAttributesAsNonCanonicalString(Vector vector) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            AttributeValuePair attributeValuePair = (AttributeValuePair)iterator.next();
            stringBuffer.append(attributeValuePair.getOutputString(1));
            stringBuffer.append(this.getSeparator());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    private Vector getAttributesForOutputFormat(int[] nArray, Vector vector, ASN1OID[] aSN1OIDArray) {
        Vector vector2 = vector != null ? vector : new Vector();
        int n = 0;
        while (n < aSN1OIDArray.length) {
            ASN1OID aSN1OID = aSN1OIDArray[n];
            int n2 = 0;
            while (n2 < this.attributeTypes.size()) {
                if (this.attributeTypes.elementAt(n2).equals(aSN1OID)) {
                    String string = this.getKeyForOID(aSN1OID, nArray);
                    String string2 = (String)this.attributeValues.elementAt(n2);
                    AttributeValuePair attributeValuePair = new AttributeValuePair(string, string2);
                    vector2.add(attributeValuePair);
                    this.outputMarker[n2] = true;
                }
                ++n2;
            }
            ++n;
        }
        return vector2;
    }

    public int hashCode() {
        return this.getName(2).hashCode();
    }

    public String toString() {
        return this.getName();
    }

    public String getValueForKey(String string) {
        ASN1OID aSN1OID = this.getOIDForKey(string, this.supportedStandards);
        int n = 0;
        while (n < this.attributeTypes.size()) {
            if (this.attributeTypes.elementAt(n).equals(aSN1OID)) {
                return (String)this.attributeValues.elementAt(n);
            }
            ++n;
        }
        return null;
    }

    public boolean equals(Object object) {
        if (!(object instanceof X500Principal)) {
            return false;
        }
        return this.getName(2).equals(((X500Principal)object).getName(2));
    }

    public byte[] getEncoded() {
        ASN1Decoder.Node node = this.toASN1Node();
        byte[] byArray = ASN1Encoder.encodeNode(node);
        return byArray;
    }

    public ASN1Decoder.Node toASN1Node() {
        ASN1Decoder.Node[] nodeArray = new ASN1Decoder.Node[this.attributeTypes.size()];
        int n = 0;
        while (n < this.attributeTypes.size()) {
            ASN1Decoder.Node[] nodeArray2 = new ASN1Decoder.Node[2];
            ASN1Decoder.Node node = new ASN1Decoder.Node();
            node.type = 6;
            node.data = ((ASN1OID)this.attributeTypes.elementAt(n)).representation();
            nodeArray2[0] = node;
            ASN1Decoder.Node node2 = new ASN1Decoder.Node();
            node2.type = 12;
            node2.data = this.attributeValues.elementAt(n);
            nodeArray2[1] = node2;
            ASN1Decoder.Node node3 = new ASN1Decoder.Node();
            node3.type = 16;
            node3.data = nodeArray2;
            ASN1Decoder.Node node4 = new ASN1Decoder.Node();
            node4.type = 17;
            node4.data = new ASN1Decoder.Node[]{node3};
            nodeArray[n] = node4;
            ++n;
        }
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 16;
        node.data = nodeArray;
        return node;
    }

    X500Principal() {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
    }

    public char getSeparator() {
        return ',';
    }

    private static class AttributeValuePair
    implements Comparable {
        private String type;
        private String value;

        public AttributeValuePair(String string, String string2) {
            this.type = string;
            this.value = string2;
        }

        public int compareTo(Object object) {
            AttributeValuePair attributeValuePair = (AttributeValuePair)object;
            if (this.isOID(this.type)) {
                if (this.isOID(attributeValuePair.type)) {
                    return this.type.compareTo(attributeValuePair.type);
                }
                return 1;
            }
            if (this.isOID(attributeValuePair.type)) {
                return -1;
            }
            return this.type.compareTo(attributeValuePair.type);
        }

        private boolean isOID(String string) {
            return string.toLowerCase().startsWith("oid");
        }

        public String getOutputString(int n) {
            StringBuffer stringBuffer = new StringBuffer(this.type.length() + this.value.length() + 3);
            stringBuffer.append(this.type);
            stringBuffer.append('=');
            String string = this.value;
            string = n == 2 ? this.stripInternalWhitespace(this.value.trim()) : this.value;
            if (this.value.charAt(0) == ' ' || this.value.charAt(0) == '#' || this.value.charAt(this.value.length() - 1) == ' ' || this.value.indexOf(44) != -1 || this.value.indexOf(61) != -1 || this.value.indexOf(43) != -1 || this.value.indexOf(60) != -1 || this.value.indexOf(62) != -1 || this.value.indexOf(35) != -1 || this.value.indexOf(59) != -1) {
                stringBuffer.append('\"');
                stringBuffer.append(string);
                stringBuffer.append('\"');
            } else {
                stringBuffer.append(string);
            }
            return stringBuffer.toString();
        }

        private String stripInternalWhitespace(String string) {
            char[] cArray = string.toCharArray();
            char[] cArray2 = new char[string.length()];
            int n = 0;
            int n2 = 0;
            while (n2 < string.length()) {
                if (Character.isWhitespace(cArray[n2])) {
                    cArray2[n++] = 32;
                    ++n2;
                    while (Character.isWhitespace(cArray[n2])) {
                        ++n2;
                    }
                    cArray2[n++] = cArray[n2];
                } else {
                    cArray2[n++] = cArray[n2];
                }
                ++n2;
            }
            return new String(cArray2);
        }

        public String toString() {
            return this.getOutputString(1);
        }
    }
}

