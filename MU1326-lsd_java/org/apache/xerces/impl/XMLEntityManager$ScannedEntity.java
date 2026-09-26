/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.io.InputStream;
import java.io.Reader;
import org.apache.xerces.impl.XMLEntityManager;
import org.apache.xerces.impl.XMLEntityManager$CharacterBuffer;
import org.apache.xerces.impl.XMLEntityManager$Entity;
import org.apache.xerces.xni.XMLResourceIdentifier;

public class XMLEntityManager$ScannedEntity
extends XMLEntityManager$Entity {
    public InputStream stream;
    public Reader reader;
    public XMLResourceIdentifier entityLocation;
    public int lineNumber;
    public int columnNumber;
    public String encoding;
    boolean externallySpecifiedEncoding;
    public String xmlVersion;
    public boolean literal;
    public boolean isExternal;
    public char[] ch;
    public int position;
    public int baseCharOffset;
    public int startPosition;
    public int count;
    public boolean mayReadChunks;
    private XMLEntityManager$CharacterBuffer fCharacterBuffer;
    private byte[] fByteBuffer;
    private final /* synthetic */ XMLEntityManager this$0;

    public XMLEntityManager$ScannedEntity(XMLEntityManager xMLEntityManager, String string, XMLResourceIdentifier xMLResourceIdentifier, InputStream inputStream, Reader reader, byte[] byArray, String string2, boolean bl, boolean bl2, boolean bl3) {
        this.this$0 = xMLEntityManager;
        super(string, xMLEntityManager.fInExternalSubset);
        this.lineNumber = 1;
        this.columnNumber = 1;
        this.externallySpecifiedEncoding = false;
        this.xmlVersion = "1.0";
        this.ch = null;
        this.entityLocation = xMLResourceIdentifier;
        this.stream = inputStream;
        this.reader = reader;
        this.encoding = string2;
        this.literal = bl;
        this.mayReadChunks = bl2;
        this.isExternal = bl3;
        this.fCharacterBuffer = XMLEntityManager.access$200(xMLEntityManager).getBuffer(bl3);
        this.ch = XMLEntityManager$CharacterBuffer.access$300(this.fCharacterBuffer);
        this.fByteBuffer = byArray;
    }

    @Override
    public final boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public final boolean isUnparsed() {
        return false;
    }

    public void setReader(InputStream inputStream, String string, Boolean bl) {
        XMLEntityManager.access$402(this.this$0, this.fByteBuffer);
        this.reader = this.this$0.createReader(inputStream, string, bl);
        this.fByteBuffer = XMLEntityManager.access$400(this.this$0);
    }

    public String getExpandedSystemId() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (xMLEntityManager$ScannedEntity.entityLocation == null || xMLEntityManager$ScannedEntity.entityLocation.getExpandedSystemId() == null) continue;
            return xMLEntityManager$ScannedEntity.entityLocation.getExpandedSystemId();
        }
        return null;
    }

    public String getLiteralSystemId() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (xMLEntityManager$ScannedEntity.entityLocation == null || xMLEntityManager$ScannedEntity.entityLocation.getLiteralSystemId() == null) continue;
            return xMLEntityManager$ScannedEntity.entityLocation.getLiteralSystemId();
        }
        return null;
    }

    public int getLineNumber() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (!xMLEntityManager$ScannedEntity.isExternal()) continue;
            return xMLEntityManager$ScannedEntity.lineNumber;
        }
        return -1;
    }

    public int getColumnNumber() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (!xMLEntityManager$ScannedEntity.isExternal()) continue;
            return xMLEntityManager$ScannedEntity.columnNumber;
        }
        return -1;
    }

    public int getCharacterOffset() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (!xMLEntityManager$ScannedEntity.isExternal()) continue;
            return xMLEntityManager$ScannedEntity.baseCharOffset + (xMLEntityManager$ScannedEntity.position - xMLEntityManager$ScannedEntity.startPosition);
        }
        return -1;
    }

    public String getEncoding() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (!xMLEntityManager$ScannedEntity.isExternal()) continue;
            return xMLEntityManager$ScannedEntity.encoding;
        }
        return null;
    }

    public String getXMLVersion() {
        int n = this.this$0.fEntityStack.size();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.this$0.fEntityStack.elementAt(i2);
            if (!xMLEntityManager$ScannedEntity.isExternal()) continue;
            return xMLEntityManager$ScannedEntity.xmlVersion;
        }
        return null;
    }

    public boolean isEncodingExternallySpecified() {
        return this.externallySpecifiedEncoding;
    }

    public void setEncodingExternallySpecified(boolean bl) {
        this.externallySpecifiedEncoding = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name=\"").append(this.name).append('\"');
        stringBuffer.append(",ch=");
        stringBuffer.append(this.ch);
        stringBuffer.append(",position=").append(this.position);
        stringBuffer.append(",count=").append(this.count);
        stringBuffer.append(",baseCharOffset=").append(this.baseCharOffset);
        stringBuffer.append(",startPosition=").append(this.startPosition);
        return stringBuffer.toString();
    }

    static /* synthetic */ XMLEntityManager$CharacterBuffer access$000(XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity) {
        return xMLEntityManager$ScannedEntity.fCharacterBuffer;
    }

    static /* synthetic */ byte[] access$100(XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity) {
        return xMLEntityManager$ScannedEntity.fByteBuffer;
    }
}

