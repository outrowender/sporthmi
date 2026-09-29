/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.util.Vector;
import org.apache.xerces.dom.AttrImpl;
import org.apache.xerces.dom.AttributeMap;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.apache.xerces.dom.DOMNormalizer;
import org.apache.xerces.dom.ElementImpl;
import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public final class DOMNormalizer$XMLAttributesProxy
implements XMLAttributes {
    protected AttributeMap fAttributes;
    protected CoreDocumentImpl fDocument;
    protected ElementImpl fElement;
    protected final Vector fAugmentations = new Vector(5);
    private final /* synthetic */ DOMNormalizer this$0;

    protected DOMNormalizer$XMLAttributesProxy(DOMNormalizer dOMNormalizer) {
        this.this$0 = dOMNormalizer;
    }

    public void setAttributes(AttributeMap attributeMap, CoreDocumentImpl coreDocumentImpl, ElementImpl elementImpl) {
        this.fDocument = coreDocumentImpl;
        this.fAttributes = attributeMap;
        this.fElement = elementImpl;
        if (attributeMap != null) {
            int n = attributeMap.getLength();
            this.fAugmentations.setSize(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.fAugmentations.setElementAt(new AugmentationsImpl(), i2);
            }
        } else {
            this.fAugmentations.setSize(0);
        }
    }

    @Override
    public int addAttribute(QName qName, String string, String string2) {
        int n = this.fElement.getXercesAttribute(qName.uri, qName.localpart);
        if (n < 0) {
            AttrImpl attrImpl = (AttrImpl)((CoreDocumentImpl)this.fElement.getOwnerDocument()).createAttributeNS(qName.uri, qName.rawname, qName.localpart);
            attrImpl.setNodeValue(string2);
            n = this.fElement.setXercesAttributeNode(attrImpl);
            this.fAugmentations.insertElementAt(new AugmentationsImpl(), n);
            attrImpl.setSpecified(false);
        }
        return n;
    }

    @Override
    public void removeAllAttributes() {
    }

    @Override
    public void removeAttributeAt(int n) {
    }

    @Override
    public int getLength() {
        return this.fAttributes != null ? this.fAttributes.getLength() : 0;
    }

    @Override
    public int getIndex(String string) {
        return -1;
    }

    @Override
    public int getIndex(String string, String string2) {
        return -1;
    }

    @Override
    public void setName(int n, QName qName) {
    }

    @Override
    public void getName(int n, QName qName) {
        if (this.fAttributes != null) {
            this.this$0.updateQName((Node)this.fAttributes.getItem(n), qName);
        }
    }

    @Override
    public String getPrefix(int n) {
        if (this.fAttributes != null) {
            Node node = (Node)this.fAttributes.getItem(n);
            String string = node.getPrefix();
            string = string != null && string.length() != 0 ? this.this$0.fSymbolTable.addSymbol(string) : null;
            return string;
        }
        return null;
    }

    @Override
    public String getURI(int n) {
        if (this.fAttributes != null) {
            Node node = (Node)this.fAttributes.getItem(n);
            String string = node.getNamespaceURI();
            string = string != null ? this.this$0.fSymbolTable.addSymbol(string) : null;
            return string;
        }
        return null;
    }

    @Override
    public String getLocalName(int n) {
        if (this.fAttributes != null) {
            Node node = (Node)this.fAttributes.getItem(n);
            String string = node.getLocalName();
            string = string != null ? this.this$0.fSymbolTable.addSymbol(string) : null;
            return string;
        }
        return null;
    }

    @Override
    public String getQName(int n) {
        if (this.fAttributes != null) {
            Node node = (Node)this.fAttributes.getItem(n);
            String string = this.this$0.fSymbolTable.addSymbol(node.getNodeName());
            return string;
        }
        return null;
    }

    @Override
    public void setType(int n, String string) {
    }

    @Override
    public String getType(int n) {
        return "CDATA";
    }

    @Override
    public String getType(String string) {
        return "CDATA";
    }

    @Override
    public String getType(String string, String string2) {
        return "CDATA";
    }

    @Override
    public void setValue(int n, String string) {
        if (this.fAttributes != null) {
            AttrImpl attrImpl = (AttrImpl)this.fAttributes.getItem(n);
            boolean bl = attrImpl.getSpecified();
            attrImpl.setValue(string);
            attrImpl.setSpecified(bl);
        }
    }

    @Override
    public String getValue(int n) {
        return this.fAttributes != null ? this.fAttributes.item(n).getNodeValue() : "";
    }

    @Override
    public String getValue(String string) {
        return null;
    }

    @Override
    public String getValue(String string, String string2) {
        if (this.fAttributes != null) {
            Node node = this.fAttributes.getNamedItemNS(string, string2);
            return node != null ? node.getNodeValue() : null;
        }
        return null;
    }

    @Override
    public void setNonNormalizedValue(int n, String string) {
    }

    @Override
    public String getNonNormalizedValue(int n) {
        return null;
    }

    @Override
    public void setSpecified(int n, boolean bl) {
        AttrImpl attrImpl = (AttrImpl)this.fAttributes.getItem(n);
        attrImpl.setSpecified(bl);
    }

    @Override
    public boolean isSpecified(int n) {
        return ((Attr)this.fAttributes.getItem(n)).getSpecified();
    }

    @Override
    public Augmentations getAugmentations(int n) {
        return (Augmentations)this.fAugmentations.elementAt(n);
    }

    @Override
    public Augmentations getAugmentations(String string, String string2) {
        return null;
    }

    @Override
    public Augmentations getAugmentations(String string) {
        return null;
    }

    @Override
    public void setAugmentations(int n, Augmentations augmentations) {
        this.fAugmentations.setElementAt(augmentations, n);
    }
}

