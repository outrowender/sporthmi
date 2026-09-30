/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PositionedInputStream;
import com.ibm.oti.util.PriviAction;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.AccessController;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

public class ASN1Decoder {
    private PositionedInputStream input;
    private int nesting = 0;
    private int sequenceItem = 0;
    private TypeMapper[] tagConfiguration;
    private boolean collectBytes;
    private ByteArrayOutputStream bytesCollected;
    public static final int END_OF_BER_CONTENTS = 0;
    public static final int BOOLEAN = 1;
    public static final int INTEGER = 2;
    public static final int BIT_STRING = 3;
    public static final int OCTET_STRING = 4;
    public static final int NULL = 5;
    public static final int OBJECT_IDENTIFIER = 6;
    public static final int SEQUENCE = 16;
    public static final int SET = 17;
    public static final int BMP_STRING = 30;
    public static final int NUMERIC_STRING = 18;
    public static final int PRINTABLE_STRING = 19;
    public static final int T61_STRING = 20;
    public static final int VIDEOTEXT_STRING = 21;
    public static final int IA5_STRING = 22;
    public static final int UTF_STRING = 12;
    public static final int UTC_TIME = 23;
    public static final int GENERALIZED_TIME = 24;
    public static final int CLASS_UNIVERSAL = 0;
    public static final int EXPLICIT = 160;
    public static final int LENGTH_UNKNOWN = -1;

    public ASN1Decoder(InputStream inputStream) {
        this.input = new PositionedInputStream(inputStream);
    }

    public ASN1Decoder(InputStream inputStream, boolean bl) {
        this.input = new PositionedInputStream(inputStream);
    }

    private int readByte() throws ASN1Exception {
        try {
            int n = this.input.read();
            if (n < 0) {
                throw new ASN1Exception();
            }
            if (this.collectBytes) {
                this.bytesCollected.write(n);
            }
            return n & 0xFF;
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private Date parseUTCDate(String string) {
        int[] nArray = this.parseYMD(string, 2);
        nArray[0] = nArray[0] <= 49 ? nArray[0] + 2000 : nArray[0] + 1900;
        return this.dateFromArray(string, nArray);
    }

    private Date parseGeneralizedDate(String string) {
        int[] nArray = this.parseYMD(string, 4);
        return this.dateFromArray(string, nArray);
    }

    private Date dateFromArray(String string, int[] nArray) {
        String string2 = this.getTZ(string);
        TimeZone timeZone = TimeZone.getTimeZone(string2);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(nArray[0], nArray[1] - 1, nArray[2], nArray[3], nArray[4], nArray[5]);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    private int[] parseYMD(String string, int n) {
        int n2 = 0;
        int n3 = n;
        int[] nArray = new int[6];
        int n4 = 0;
        while (n4 < nArray.length) {
            char c2;
            if (n4 == 5 && ((c2 = string.charAt(n2)) < '0' || c2 > '9')) break;
            nArray[n4] = Integer.parseInt(string.substring(n2, n2 + n3));
            n2 += n3;
            n3 = 2;
            ++n4;
        }
        return nArray;
    }

    private String getTZ(String string) {
        String string2 = "GMT";
        char c2 = string.charAt(string.length() - 1);
        if (c2 != 'Z') {
            string2 = String.valueOf(string2) + string.substring(string.length() - 5, string.length());
        }
        return string2;
    }

    public void collectBytes(boolean bl) {
        this.collectBytes = bl;
        this.bytesCollected = bl ? new ByteArrayOutputStream(1024) : null;
    }

    public byte[] collectedBytes() {
        if (this.collectBytes) {
            return this.bytesCollected.toByteArray();
        }
        return null;
    }

    public Node readContents() throws ASN1Exception {
        Node node = new Node();
        node.startPosition = this.input.currentPosition();
        this.readTag(node);
        this.computeTypeRedirection(node);
        switch (node.type) {
            case 16: {
                node.data = this.readSequence();
                break;
            }
            case 17: {
                node.data = this.readSet();
                break;
            }
            case 1: {
                node.data = this.readBoolean();
                break;
            }
            case 2: {
                node.data = this.readInteger();
                break;
            }
            case 5: {
                if (this.readByte() == 0) break;
                this.throwASN1Exception();
                break;
            }
            case 6: {
                node.data = this.readObjectIdentifier();
                break;
            }
            case 4: {
                node.data = this.readOctetString();
                break;
            }
            case 18: {
                node.data = this.readNumericString();
                break;
            }
            case 19: {
                node.data = this.readPrintableString();
                break;
            }
            case 30: {
                node.data = this.readBMPString();
                break;
            }
            case 22: {
                node.data = this.readIA5String();
                break;
            }
            case 12: {
                node.data = this.readUTFString();
                break;
            }
            case 20: {
                node.data = this.readT61String();
                break;
            }
            case 21: {
                node.data = this.readVideotextString();
                break;
            }
            case 3: {
                node.data = this.readBitString();
                break;
            }
            case 23: {
                node.data = this.readUTCTime();
                break;
            }
            case 24: {
                node.data = this.readGeneralizedTime();
                break;
            }
            case 0: {
                int n = this.readLength();
                if (n != 0) {
                    throw new ASN1Exception(Msg.getString("K0088"));
                }
                return null;
            }
            default: {
                throw new ASN1Exception(Msg.getString("K0089", node.type));
            }
        }
        node.endPosition = this.input.currentPosition() - 1;
        return node;
    }

    public Object readContentsToObject() throws ASN1Exception {
        Node node = new Node();
        node.startPosition = this.input.currentPosition();
        this.readTag(node);
        this.computeTypeRedirection(node);
        switch (node.type) {
            case 16: {
                node.data = this.readSequenceToObject();
                break;
            }
            case 17: {
                node.data = this.readSetToObject();
                break;
            }
            case 1: {
                node.data = this.readBoolean();
                break;
            }
            case 2: {
                node.data = this.readInteger();
                break;
            }
            case 5: {
                if (this.readByte() == 0) break;
                this.throwASN1Exception();
                break;
            }
            case 6: {
                node.data = this.readObjectIdentifier();
                break;
            }
            case 4: {
                node.data = this.readOctetString();
                break;
            }
            case 18: {
                node.data = this.readNumericString();
                break;
            }
            case 19: {
                node.data = this.readPrintableString();
                break;
            }
            case 30: {
                node.data = this.readBMPString();
                break;
            }
            case 22: {
                node.data = this.readIA5String();
                break;
            }
            case 12: {
                node.data = this.readUTFString();
                break;
            }
            case 20: {
                node.data = this.readT61String();
                break;
            }
            case 21: {
                node.data = this.readVideotextString();
                break;
            }
            case 3: {
                node.data = this.readBitString();
                break;
            }
            case 23: {
                node.data = this.readUTCTimeToObject();
                break;
            }
            case 24: {
                node.data = this.readGeneralizedTimeToObject();
                break;
            }
            case 0: {
                int n = this.readLength();
                if (n != 0) {
                    throw new ASN1Exception(Msg.getString("K0088"));
                }
                return null;
            }
            default: {
                throw new ASN1Exception(Msg.getString("K0089", node.type));
            }
        }
        node.endPosition = this.input.currentPosition() - 1;
        return node.data;
    }

    private void readFully(InputStream inputStream, byte[] byArray) throws ASN1Exception {
        try {
            this.readFully(inputStream, byArray, 0, byArray.length);
        }
        catch (IOException iOException) {
            throw new ASN1Exception(iOException.toString());
        }
    }

    private void readFully(InputStream inputStream, byte[] byArray, int n, int n2) throws IOException {
        int n3 = 0;
        int n4 = n2;
        while (n3 < n2) {
            int n5 = inputStream.read(byArray, n + n3, n4);
            if (n5 <= 0) {
                throw new IOException(Msg.getString("K008a", new Object[]{Integer.toString(n5), Integer.toString(n4), inputStream}));
            }
            if (this.collectBytes) {
                this.bytesCollected.write(byArray, n + n3, n5);
            }
            n3 += n5;
            n4 -= n5;
        }
    }

    protected Date readUTCTime() throws ASN1Exception {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return this.parseUTCDate(string);
    }

    protected UTCTime readUTCTimeToObject() throws ASN1Exception {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return new UTCTime(this.parseUTCDate(string));
    }

    protected Date readGeneralizedTime() throws ASN1Exception {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return this.parseGeneralizedDate(string);
    }

    protected GeneralizedTime readGeneralizedTimeToObject() throws ASN1Exception {
        String string = ASN1Decoder.convertToString(this.readOctetString());
        return new GeneralizedTime(this.parseGeneralizedDate(string));
    }

    protected BigInteger readInteger() throws ASN1Exception {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        return new BigInteger(1, byArray);
    }

    protected Boolean readBoolean() throws ASN1Exception {
        int n;
        int n2 = this.readLength();
        if (n2 != 1) {
            this.throwASN1Exception();
        }
        if ((n = this.readByte()) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    protected int readLength() throws ASN1Exception {
        int n = this.readByte();
        if (n < 128) {
            return n;
        }
        if (n == 128) {
            return -1;
        }
        int n2 = n & 0x7F;
        n = 0;
        int n3 = 0;
        while (n3 < n2) {
            n = n * 256 + this.readByte();
            ++n3;
        }
        if (n < 0) {
            this.throwASN1Exception();
        }
        return n;
    }

    protected int[] readObjectIdentifier() throws ASN1Exception {
        int n = this.readLength();
        int[] nArray = new int[n];
        int n2 = 0;
        while (n2 < nArray.length) {
            nArray[n2] = this.readByte();
            ++n2;
        }
        n2 = nArray.length + 1;
        int n3 = 1;
        while (n3 < nArray.length) {
            if (nArray[n3] >= 128) {
                --n2;
            }
            ++n3;
        }
        int[] nArray2 = new int[n2];
        nArray2[0] = nArray[0] / 40;
        nArray2[1] = nArray[0] % 40;
        int n4 = 1;
        int n5 = 2;
        while (n4 < nArray.length) {
            int n6 = n5;
            nArray2[n6] = nArray2[n6] * 128;
            if (nArray[n4] < 128) {
                int n7 = n5++;
                nArray2[n7] = nArray2[n7] + nArray[n4];
            } else {
                int n8 = n5;
                nArray2[n8] = nArray2[n8] + (nArray[n4] - 128);
            }
            ++n4;
        }
        return nArray2;
    }

    protected byte[] readOctetString() throws ASN1Exception {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        return byArray;
    }

    protected String readNumericString() throws ASN1Exception {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readPrintableString() throws ASN1Exception {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readIA5String() throws ASN1Exception {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readUTFString() throws ASN1Exception {
        String string = null;
        try {
            string = new String(this.readOctetString(), "UTF8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new ASN1Exception(Msg.getString("K0220", unsupportedEncodingException));
        }
        return string;
    }

    protected String readT61String() throws ASN1Exception {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected String readVideotextString() throws ASN1Exception {
        return ASN1Decoder.convertToString(this.readOctetString());
    }

    protected BitString readBitString() throws ASN1Exception {
        int n = this.readLength();
        int n2 = this.readByte();
        byte[] byArray = new byte[n - 1];
        this.readFully(this.input, byArray);
        return new BitString(n2, byArray);
    }

    protected Node[] readSequence() throws ASN1Exception {
        int n = this.readLength();
        int n2 = 0;
        Vector vector = new Vector();
        ++this.nesting;
        int n3 = 1;
        while (n2 < n || n == -1) {
            int n4 = this.input.currentPosition();
            this.sequenceItem = n3;
            Node node = this.readContents();
            if (n == -1 && node == null) break;
            vector.addElement(node);
            int n5 = this.input.currentPosition();
            int n6 = n5 - n4;
            n2 += n6;
            ++n3;
        }
        --this.nesting;
        if (n != -1 && n2 != n) {
            this.throwASN1Exception();
        }
        Object[] objectArray = new Node[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    protected Object[] readSequenceToObject() throws ASN1Exception {
        int n = this.readLength();
        int n2 = 0;
        Vector vector = new Vector();
        ++this.nesting;
        int n3 = 1;
        while (n2 < n || n == -1) {
            int n4 = this.input.currentPosition();
            this.sequenceItem = n3;
            Object object = this.readContentsToObject();
            if (n == -1 && object == null) break;
            vector.addElement(object);
            int n5 = this.input.currentPosition();
            int n6 = n5 - n4;
            n2 += n6;
            ++n3;
        }
        --this.nesting;
        if (n != -1 && n2 != n) {
            this.throwASN1Exception();
        }
        Object[] objectArray = new Object[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    protected Node[] readSet() throws ASN1Exception {
        return this.readSequence();
    }

    protected Set readSetToObject() throws ASN1Exception {
        return new Set(this.readSequenceToObject());
    }

    protected BMPString readBMPString() throws ASN1Exception {
        int n = this.readLength();
        byte[] byArray = new byte[n];
        this.readFully(this.input, byArray);
        String string = null;
        try {
            string = new String(byArray, "UnicodeBigUnmarked");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new ASN1Exception(Msg.getString("K018f", unsupportedEncodingException));
        }
        return new BMPString(string);
    }

    protected Node[] readConstructed() throws ASN1Exception {
        return this.readSequence();
    }

    protected void readTag(Node node) throws ASN1Exception {
        int n = this.readByte();
        node.elementClass = n >> 6;
        node.isPrimitive = (n & 0x20) == 0;
        int n2 = n & 0x1F;
        if (n2 == 31) {
            int n3;
            n2 = 0;
            do {
                n3 = this.readByte();
                n2 = n2 * 128 + (n3 & 0x7F);
            } while ((n3 & 0x80) != 0);
        }
        node.originalType = n2;
        node.type = n2;
    }

    public void configureTypeRedirection(int n, TypeMapper typeMapper) {
        if (this.tagConfiguration == null) {
            this.tagConfiguration = new TypeMapper[n + 5];
        }
        if (this.tagConfiguration.length <= n) {
            TypeMapper[] typeMapperArray = this.tagConfiguration;
            this.tagConfiguration = new TypeMapper[n + 5];
            int n2 = 0;
            while (n2 < typeMapperArray.length) {
                this.tagConfiguration[n2] = typeMapperArray[n2];
                ++n2;
            }
        }
        this.tagConfiguration[n] = typeMapper;
    }

    private void computeTypeRedirection(Node node) {
        if (node.elementClass == 0 && this.nesting == 0) {
            return;
        }
        if (this.tagConfiguration == null) {
            if (node.type == 0) {
                try {
                    this.readLength();
                    this.readTag(node);
                }
                catch (ASN1Exception aSN1Exception) {}
            }
            return;
        }
        if (this.nesting >= this.tagConfiguration.length) {
            return;
        }
        TypeMapper typeMapper = this.tagConfiguration[this.nesting];
        if (typeMapper == null) {
            return;
        }
        node.type = typeMapper.map(node.originalType, this.nesting, this.sequenceItem);
    }

    private void throwASN1Exception() throws ASN1Exception {
        throw new ASN1Exception(Msg.getString("K008b", this.input.currentPosition()));
    }

    public static Object getDecoded(byte[] byArray) throws ASN1Exception {
        if (byArray == null) {
            throw new ASN1Exception(Msg.getString("K0190"));
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        return aSN1Decoder.readContentsToObject();
    }

    private static String convertToString(byte[] byArray) {
        try {
            return new String(byArray, "ISO8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.toString());
        }
    }

    public static class Set {
        public Object[] sequence = null;

        public Set(Object[] objectArray) {
            this.sequence = objectArray;
        }
    }

    public static class Data {
        public byte[] data = null;

        public Data(byte[] byArray) {
            this.data = byArray;
        }
    }

    public static class Node {
        public static final int TAG_IMPLICIT = 1;
        public static final int TAG_EXPLICIT = 2;
        public static final int LAST = Integer.MAX_VALUE;
        public Object data;
        public int originalType = -1;
        public int tagtype = 1;
        public int type;
        public boolean isPrimitive;
        int elementClass;
        public int startPosition;
        public int endPosition;
        private static String lineTerminator = null;

        static {
            lineTerminator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));
        }

        public boolean isUniversal() {
            return this.elementClass == 0;
        }

        public boolean isApplication() {
            return this.elementClass == 1;
        }

        public boolean isContextSpecific() {
            return this.elementClass == 2;
        }

        public boolean isPrivate() {
            return this.elementClass == 3;
        }

        public Node subnode(int n) {
            try {
                int n2 = ((Node[])this.data).length;
                if (n >= n2) {
                    n = n2 - 1 - (Integer.MAX_VALUE - n);
                }
                return ((Node[])this.data)[n];
            }
            catch (Exception exception) {
                return null;
            }
        }

        public Node subnodeWithOriginalType(int n) {
            try {
                Node[] nodeArray = (Node[])this.data;
                int n2 = 0;
                while (n2 < nodeArray.length) {
                    Node node = nodeArray[n2];
                    if (node.originalType == n) {
                        return node;
                    }
                    ++n2;
                }
            }
            catch (Exception exception) {}
            return null;
        }

        public Object subnode(int[] nArray) {
            try {
                Node node = ((Node[])this.data)[nArray[0]];
                int n = 1;
                while (n < nArray.length) {
                    node = ((Node[])node.data)[nArray[n]];
                    ++n;
                }
                return node;
            }
            catch (Exception exception) {
                return null;
            }
        }

        public String toString() {
            return this.toString(0);
        }

        private String toString(int n) {
            if (this.type == 16 || this.type == 17) {
                StringBuffer stringBuffer = new StringBuffer();
                Node[] nodeArray = (Node[])this.data;
                if (this.type == 16) {
                    stringBuffer.append("[SEQUENCE]");
                } else {
                    stringBuffer.append("[SET]");
                }
                stringBuffer.append("(" + nodeArray.length + ") ... " + (this.endPosition - this.startPosition + 1));
                int n2 = 0;
                while (n2 < nodeArray.length) {
                    stringBuffer.append(lineTerminator);
                    int n3 = 0;
                    while (n3 < n + 2) {
                        stringBuffer.append(" ");
                        ++n3;
                    }
                    stringBuffer.append(nodeArray[n2].toString(n + 2));
                    ++n2;
                }
                return stringBuffer.toString();
            }
            if (this.data == null) {
                return "NULL";
            }
            if (this.data instanceof BitString) {
                return "[BIT_STRING] " + Node.getStringForByteArray(((BitString)this.data).data);
            }
            if (this.data instanceof byte[]) {
                return "[BIT_STRING] " + Node.getStringForByteArray((byte[])this.data);
            }
            if (this.data instanceof int[]) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("OID ");
                int[] nArray = (int[])this.data;
                stringBuffer.append(nArray[0]);
                int n4 = 1;
                while (n4 < nArray.length) {
                    stringBuffer.append("." + nArray[n4]);
                    ++n4;
                }
                return stringBuffer.toString();
            }
            return this.data.toString();
        }

        private static String getStringForByteArray(byte[] byArray) {
            StringBuffer stringBuffer = new StringBuffer();
            int n = 0;
            while (n < byArray.length) {
                stringBuffer.append(Integer.toHexString(byArray[n] >> 4 & 0xF));
                stringBuffer.append(Integer.toHexString(byArray[n] & 0xF));
                stringBuffer.append(" ");
                ++n;
            }
            return stringBuffer.toString().toUpperCase();
        }
    }

    public static class Set2 {
        public Object[] sequence = null;

        public Set2(Object[] objectArray) {
            this.sequence = objectArray;
        }
    }

    public static class UTCTime {
        public Date utcTime = null;

        public UTCTime(Date date) {
            this.utcTime = date;
        }
    }

    public static class Explicit {
        public Object type = null;

        public Explicit(Object object) {
            this.type = object;
        }
    }

    public static class BMPString {
        public String bmpString = null;

        public BMPString(String string) {
            this.bmpString = string;
        }
    }

    public static class BitString {
        public int unusedBits;
        public byte[] data;

        public BitString(int n, byte[] byArray) {
            this.unusedBits = n;
            this.data = byArray;
        }

        public int bitLength() {
            return this.data.length * 8 - this.unusedBits;
        }

        public boolean bitAt(int n) {
            int n2 = n / 8;
            int n3 = this.data[n2] & 0xFF;
            int n4 = n % 8;
            return (n3 >>> 7 - n4 & 1) == 1;
        }
    }

    public static interface TypeMapper {
        public int map(int var1, int var2, int var3);
    }

    public static class ImplicitSet {
        public Set2 set = null;
        public int tag = 0;

        public ImplicitSet(Set2 set2, int n) {
            this.set = set2;
            this.tag = n;
        }
    }

    public static class CertificateSet {
        public Object[] sequence = null;

        public CertificateSet(Object[] objectArray) {
            this.sequence = objectArray;
        }
    }

    public static class GeneralizedTime {
        public Date generalizedTime = null;

        public GeneralizedTime(Date date) {
            this.generalizedTime = date;
        }
    }
}

