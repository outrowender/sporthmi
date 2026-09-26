/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.XMLAttributesImpl$Attribute;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;

public class XMLAttributesImpl
implements XMLAttributes {
    protected static final int TABLE_SIZE;
    protected static final int SIZE_LIMIT;
    protected boolean fNamespaces = true;
    protected int fLargeCount = 1;
    protected int fLength;
    protected XMLAttributesImpl$Attribute[] fAttributes = new XMLAttributesImpl$Attribute[4];
    protected XMLAttributesImpl$Attribute[] fAttributeTableView;
    protected int[] fAttributeTableViewChainState;
    protected int fTableViewBuckets;
    protected boolean fIsTableViewConsistent;

    public XMLAttributesImpl() {
        this(101);
    }

    public XMLAttributesImpl(int n) {
        this.fTableViewBuckets = n;
        for (int i2 = 0; i2 < this.fAttributes.length; ++i2) {
            this.fAttributes[i2] = new XMLAttributesImpl$Attribute();
        }
    }

    public void setNamespaces(boolean bl) {
        this.fNamespaces = bl;
    }

    @Override
    public int addAttribute(QName qName, String string, String string2) {
        XMLAttributesImpl$Attribute[] xMLAttributesImpl$AttributeArray;
        int n;
        if (this.fLength < 20) {
            int n2 = n = qName.uri != null && !qName.uri.equals("") ? this.getIndexFast(qName.uri, qName.localpart) : this.getIndexFast(qName.rawname);
            if (n == -1) {
                n = this.fLength;
                if (this.fLength++ == this.fAttributes.length) {
                    xMLAttributesImpl$AttributeArray = new XMLAttributesImpl$Attribute[this.fAttributes.length + 4];
                    System.arraycopy((Object)this.fAttributes, 0, (Object)xMLAttributesImpl$AttributeArray, 0, this.fAttributes.length);
                    for (int i2 = this.fAttributes.length; i2 < xMLAttributesImpl$AttributeArray.length; ++i2) {
                        xMLAttributesImpl$AttributeArray[i2] = new XMLAttributesImpl$Attribute();
                    }
                    this.fAttributes = xMLAttributesImpl$AttributeArray;
                }
            }
        } else if (qName.uri == null || qName.uri.length() == 0 || (n = this.getIndexFast(qName.uri, qName.localpart)) == -1) {
            int n3;
            if (!this.fIsTableViewConsistent || this.fLength == 20) {
                this.prepareAndPopulateTableView();
                this.fIsTableViewConsistent = true;
            }
            if (this.fAttributeTableViewChainState[n3 = this.getTableViewBucket(qName.rawname)] != this.fLargeCount) {
                n = this.fLength;
                if (this.fLength++ == this.fAttributes.length) {
                    XMLAttributesImpl$Attribute[] xMLAttributesImpl$AttributeArray2 = new XMLAttributesImpl$Attribute[this.fAttributes.length << 1];
                    System.arraycopy((Object)this.fAttributes, 0, (Object)xMLAttributesImpl$AttributeArray2, 0, this.fAttributes.length);
                    for (int i3 = this.fAttributes.length; i3 < xMLAttributesImpl$AttributeArray2.length; ++i3) {
                        xMLAttributesImpl$AttributeArray2[i3] = new XMLAttributesImpl$Attribute();
                    }
                    this.fAttributes = xMLAttributesImpl$AttributeArray2;
                }
                this.fAttributeTableViewChainState[n3] = this.fLargeCount;
                this.fAttributes[n].next = null;
                this.fAttributeTableView[n3] = this.fAttributes[n];
            } else {
                XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributeTableView[n3];
                while (xMLAttributesImpl$Attribute != null && xMLAttributesImpl$Attribute.name.rawname != qName.rawname) {
                    xMLAttributesImpl$Attribute = xMLAttributesImpl$Attribute.next;
                }
                if (xMLAttributesImpl$Attribute == null) {
                    n = this.fLength;
                    if (this.fLength++ == this.fAttributes.length) {
                        XMLAttributesImpl$Attribute[] xMLAttributesImpl$AttributeArray3 = new XMLAttributesImpl$Attribute[this.fAttributes.length << 1];
                        System.arraycopy((Object)this.fAttributes, 0, (Object)xMLAttributesImpl$AttributeArray3, 0, this.fAttributes.length);
                        for (int i4 = this.fAttributes.length; i4 < xMLAttributesImpl$AttributeArray3.length; ++i4) {
                            xMLAttributesImpl$AttributeArray3[i4] = new XMLAttributesImpl$Attribute();
                        }
                        this.fAttributes = xMLAttributesImpl$AttributeArray3;
                    }
                    this.fAttributes[n].next = this.fAttributeTableView[n3];
                    this.fAttributeTableView[n3] = this.fAttributes[n];
                } else {
                    n = this.getIndexFast(qName.rawname);
                }
            }
        }
        xMLAttributesImpl$AttributeArray = this.fAttributes[n];
        xMLAttributesImpl$AttributeArray.name.setValues(qName);
        xMLAttributesImpl$AttributeArray.type = string;
        xMLAttributesImpl$AttributeArray.value = string2;
        xMLAttributesImpl$AttributeArray.nonNormalizedValue = string2;
        xMLAttributesImpl$AttributeArray.specified = false;
        xMLAttributesImpl$AttributeArray.augs.removeAllItems();
        return n;
    }

    @Override
    public void removeAllAttributes() {
        this.fLength = 0;
    }

    @Override
    public void removeAttributeAt(int n) {
        this.fIsTableViewConsistent = false;
        if (n < this.fLength - 1) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[n];
            System.arraycopy((Object)this.fAttributes, n + 1, (Object)this.fAttributes, n, this.fLength - n - 1);
            this.fAttributes[this.fLength - 1] = xMLAttributesImpl$Attribute;
        }
        --this.fLength;
    }

    @Override
    public void setName(int n, QName qName) {
        this.fAttributes[n].name.setValues(qName);
    }

    @Override
    public void getName(int n, QName qName) {
        qName.setValues(this.fAttributes[n].name);
    }

    @Override
    public void setType(int n, String string) {
        this.fAttributes[n].type = string;
    }

    @Override
    public void setValue(int n, String string) {
        XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[n];
        xMLAttributesImpl$Attribute.value = string;
        xMLAttributesImpl$Attribute.nonNormalizedValue = string;
    }

    @Override
    public void setNonNormalizedValue(int n, String string) {
        if (string == null) {
            string = this.fAttributes[n].value;
        }
        this.fAttributes[n].nonNormalizedValue = string;
    }

    @Override
    public String getNonNormalizedValue(int n) {
        String string = this.fAttributes[n].nonNormalizedValue;
        return string;
    }

    @Override
    public void setSpecified(int n, boolean bl) {
        this.fAttributes[n].specified = bl;
    }

    @Override
    public boolean isSpecified(int n) {
        return this.fAttributes[n].specified;
    }

    @Override
    public int getLength() {
        return this.fLength;
    }

    @Override
    public String getType(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.getReportableType(this.fAttributes[n].type);
    }

    @Override
    public String getType(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.getReportableType(this.fAttributes[n].type) : null;
    }

    @Override
    public String getValue(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].value;
    }

    @Override
    public String getValue(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.fAttributes[n].value : null;
    }

    public String getName(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].name.rawname;
    }

    @Override
    public int getIndex(String string) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
            if (xMLAttributesImpl$Attribute.name.rawname == null || !xMLAttributesImpl$Attribute.name.rawname.equals(string)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int getIndex(String string, String string2) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
            if (xMLAttributesImpl$Attribute.name.localpart == null || !xMLAttributesImpl$Attribute.name.localpart.equals(string2) || string != xMLAttributesImpl$Attribute.name.uri && (string == null || xMLAttributesImpl$Attribute.name.uri == null || !xMLAttributesImpl$Attribute.name.uri.equals(string))) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public String getLocalName(int n) {
        if (!this.fNamespaces) {
            return "";
        }
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].name.localpart;
    }

    @Override
    public String getQName(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.rawname;
        return string != null ? string : "";
    }

    @Override
    public String getType(String string, String string2) {
        if (!this.fNamespaces) {
            return null;
        }
        int n = this.getIndex(string, string2);
        return n != -1 ? this.getReportableType(this.fAttributes[n].type) : null;
    }

    @Override
    public String getPrefix(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.prefix;
        return string != null ? string : "";
    }

    @Override
    public String getURI(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.uri;
        return string;
    }

    @Override
    public String getValue(String string, String string2) {
        int n = this.getIndex(string, string2);
        return n != -1 ? this.getValue(n) : null;
    }

    @Override
    public Augmentations getAugmentations(String string, String string2) {
        int n = this.getIndex(string, string2);
        return n != -1 ? this.fAttributes[n].augs : null;
    }

    @Override
    public Augmentations getAugmentations(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.fAttributes[n].augs : null;
    }

    @Override
    public Augmentations getAugmentations(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].augs;
    }

    @Override
    public void setAugmentations(int n, Augmentations augmentations) {
        this.fAttributes[n].augs = augmentations;
    }

    public void setURI(int n, String string) {
        this.fAttributes[n].name.uri = string;
    }

    public void setSchemaId(int n, boolean bl) {
        this.fAttributes[n].schemaId = bl;
    }

    public boolean getSchemaId(int n) {
        if (n < 0 || n >= this.fLength) {
            return false;
        }
        return this.fAttributes[n].schemaId;
    }

    public boolean getSchemaId(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.fAttributes[n].schemaId : false;
    }

    public boolean getSchemaId(String string, String string2) {
        if (!this.fNamespaces) {
            return false;
        }
        int n = this.getIndex(string, string2);
        return n != -1 ? this.fAttributes[n].schemaId : false;
    }

    public int getIndexFast(String string) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
            if (xMLAttributesImpl$Attribute.name.rawname != string) continue;
            return i2;
        }
        return -1;
    }

    public void addAttributeNS(QName qName, String string, String string2) {
        XMLAttributesImpl$Attribute[] xMLAttributesImpl$AttributeArray;
        int n = this.fLength;
        if (this.fLength++ == this.fAttributes.length) {
            xMLAttributesImpl$AttributeArray = this.fLength < 20 ? new XMLAttributesImpl$Attribute[this.fAttributes.length + 4] : new XMLAttributesImpl$Attribute[this.fAttributes.length << 1];
            System.arraycopy((Object)this.fAttributes, 0, (Object)xMLAttributesImpl$AttributeArray, 0, this.fAttributes.length);
            for (int i2 = this.fAttributes.length; i2 < xMLAttributesImpl$AttributeArray.length; ++i2) {
                xMLAttributesImpl$AttributeArray[i2] = new XMLAttributesImpl$Attribute();
            }
            this.fAttributes = xMLAttributesImpl$AttributeArray;
        }
        xMLAttributesImpl$AttributeArray = this.fAttributes[n];
        xMLAttributesImpl$AttributeArray.name.setValues(qName);
        xMLAttributesImpl$AttributeArray.type = string;
        xMLAttributesImpl$AttributeArray.value = string2;
        xMLAttributesImpl$AttributeArray.nonNormalizedValue = string2;
        xMLAttributesImpl$AttributeArray.specified = false;
        xMLAttributesImpl$AttributeArray.augs.removeAllItems();
    }

    public QName checkDuplicatesNS() {
        if (this.fLength <= 20) {
            for (int i2 = 0; i2 < this.fLength - 1; ++i2) {
                XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
                for (int i3 = i2 + 1; i3 < this.fLength; ++i3) {
                    XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute2 = this.fAttributes[i3];
                    if (xMLAttributesImpl$Attribute.name.localpart != xMLAttributesImpl$Attribute2.name.localpart || xMLAttributesImpl$Attribute.name.uri != xMLAttributesImpl$Attribute2.name.uri) continue;
                    return xMLAttributesImpl$Attribute2.name;
                }
            }
        } else {
            this.fIsTableViewConsistent = false;
            this.prepareTableView();
            for (int i4 = this.fLength - 1; i4 >= 0; --i4) {
                XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i4];
                int n = this.getTableViewBucket(xMLAttributesImpl$Attribute.name.localpart, xMLAttributesImpl$Attribute.name.uri);
                if (this.fAttributeTableViewChainState[n] != this.fLargeCount) {
                    this.fAttributeTableViewChainState[n] = this.fLargeCount;
                    xMLAttributesImpl$Attribute.next = null;
                    this.fAttributeTableView[n] = xMLAttributesImpl$Attribute;
                    continue;
                }
                XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute3 = this.fAttributeTableView[n];
                while (xMLAttributesImpl$Attribute3 != null) {
                    if (xMLAttributesImpl$Attribute3.name.localpart == xMLAttributesImpl$Attribute.name.localpart && xMLAttributesImpl$Attribute3.name.uri == xMLAttributesImpl$Attribute.name.uri) {
                        return xMLAttributesImpl$Attribute.name;
                    }
                    xMLAttributesImpl$Attribute3 = xMLAttributesImpl$Attribute3.next;
                }
                xMLAttributesImpl$Attribute.next = this.fAttributeTableView[n];
                this.fAttributeTableView[n] = xMLAttributesImpl$Attribute;
            }
        }
        return null;
    }

    public int getIndexFast(String string, String string2) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
            if (xMLAttributesImpl$Attribute.name.localpart != string2 || xMLAttributesImpl$Attribute.name.uri != string) continue;
            return i2;
        }
        return -1;
    }

    private String getReportableType(String string) {
        if (string.charAt(0) == '(') {
            return "NMTOKEN";
        }
        return string;
    }

    protected int getTableViewBucket(String string) {
        return (string.hashCode() & 0xFFFFFF7F) % this.fTableViewBuckets;
    }

    protected int getTableViewBucket(String string, String string2) {
        if (string2 == null) {
            return (string.hashCode() & 0xFFFFFF7F) % this.fTableViewBuckets;
        }
        return (string.hashCode() + string2.hashCode() & 0xFFFFFF7F) % this.fTableViewBuckets;
    }

    protected void cleanTableView() {
        if (++this.fLargeCount < 0) {
            if (this.fAttributeTableViewChainState != null) {
                for (int i2 = this.fTableViewBuckets - 1; i2 >= 0; --i2) {
                    this.fAttributeTableViewChainState[i2] = 0;
                }
            }
            this.fLargeCount = 1;
        }
    }

    protected void prepareTableView() {
        if (this.fAttributeTableView == null) {
            this.fAttributeTableView = new XMLAttributesImpl$Attribute[this.fTableViewBuckets];
            this.fAttributeTableViewChainState = new int[this.fTableViewBuckets];
        } else {
            this.cleanTableView();
        }
    }

    protected void prepareAndPopulateTableView() {
        this.prepareTableView();
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            XMLAttributesImpl$Attribute xMLAttributesImpl$Attribute = this.fAttributes[i2];
            int n = this.getTableViewBucket(xMLAttributesImpl$Attribute.name.rawname);
            if (this.fAttributeTableViewChainState[n] != this.fLargeCount) {
                this.fAttributeTableViewChainState[n] = this.fLargeCount;
                xMLAttributesImpl$Attribute.next = null;
                this.fAttributeTableView[n] = xMLAttributesImpl$Attribute;
                continue;
            }
            xMLAttributesImpl$Attribute.next = this.fAttributeTableView[n];
            this.fAttributeTableView[n] = xMLAttributesImpl$Attribute;
        }
    }
}

