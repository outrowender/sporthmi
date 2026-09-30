/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;

public class XMLAttributesImpl
implements XMLAttributes {
    protected static final int TABLE_SIZE = 101;
    protected static final int SIZE_LIMIT = 20;
    protected boolean fNamespaces = true;
    protected int fLargeCount = 1;
    protected int fLength;
    protected Attribute[] fAttributes = new Attribute[4];
    protected Attribute[] fAttributeTableView;
    protected int[] fAttributeTableViewChainState;
    protected int fTableViewBuckets;
    protected boolean fIsTableViewConsistent;

    public XMLAttributesImpl() {
        this(101);
    }

    public XMLAttributesImpl(int n) {
        this.fTableViewBuckets = n;
        for (int i2 = 0; i2 < this.fAttributes.length; ++i2) {
            this.fAttributes[i2] = new Attribute();
        }
    }

    public void setNamespaces(boolean bl) {
        this.fNamespaces = bl;
    }

    public int addAttribute(QName qName, String string, String string2) {
        Attribute[] attributeArray;
        int n;
        if (this.fLength < 20) {
            int n2 = n = qName.uri != null && !qName.uri.equals("") ? this.getIndexFast(qName.uri, qName.localpart) : this.getIndexFast(qName.rawname);
            if (n == -1) {
                n = this.fLength;
                if (this.fLength++ == this.fAttributes.length) {
                    attributeArray = new Attribute[this.fAttributes.length + 4];
                    System.arraycopy((Object)this.fAttributes, 0, (Object)attributeArray, 0, this.fAttributes.length);
                    for (int i2 = this.fAttributes.length; i2 < attributeArray.length; ++i2) {
                        attributeArray[i2] = new Attribute();
                    }
                    this.fAttributes = attributeArray;
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
                    Attribute[] attributeArray2 = new Attribute[this.fAttributes.length << 1];
                    System.arraycopy((Object)this.fAttributes, 0, (Object)attributeArray2, 0, this.fAttributes.length);
                    for (int i3 = this.fAttributes.length; i3 < attributeArray2.length; ++i3) {
                        attributeArray2[i3] = new Attribute();
                    }
                    this.fAttributes = attributeArray2;
                }
                this.fAttributeTableViewChainState[n3] = this.fLargeCount;
                this.fAttributes[n].next = null;
                this.fAttributeTableView[n3] = this.fAttributes[n];
            } else {
                Attribute attribute = this.fAttributeTableView[n3];
                while (attribute != null && attribute.name.rawname != qName.rawname) {
                    attribute = attribute.next;
                }
                if (attribute == null) {
                    n = this.fLength;
                    if (this.fLength++ == this.fAttributes.length) {
                        Attribute[] attributeArray3 = new Attribute[this.fAttributes.length << 1];
                        System.arraycopy((Object)this.fAttributes, 0, (Object)attributeArray3, 0, this.fAttributes.length);
                        for (int i4 = this.fAttributes.length; i4 < attributeArray3.length; ++i4) {
                            attributeArray3[i4] = new Attribute();
                        }
                        this.fAttributes = attributeArray3;
                    }
                    this.fAttributes[n].next = this.fAttributeTableView[n3];
                    this.fAttributeTableView[n3] = this.fAttributes[n];
                } else {
                    n = this.getIndexFast(qName.rawname);
                }
            }
        }
        attributeArray = this.fAttributes[n];
        attributeArray.name.setValues(qName);
        attributeArray.type = string;
        attributeArray.value = string2;
        attributeArray.nonNormalizedValue = string2;
        attributeArray.specified = false;
        attributeArray.augs.removeAllItems();
        return n;
    }

    public void removeAllAttributes() {
        this.fLength = 0;
    }

    public void removeAttributeAt(int n) {
        this.fIsTableViewConsistent = false;
        if (n < this.fLength - 1) {
            Attribute attribute = this.fAttributes[n];
            System.arraycopy((Object)this.fAttributes, n + 1, (Object)this.fAttributes, n, this.fLength - n - 1);
            this.fAttributes[this.fLength - 1] = attribute;
        }
        --this.fLength;
    }

    public void setName(int n, QName qName) {
        this.fAttributes[n].name.setValues(qName);
    }

    public void getName(int n, QName qName) {
        qName.setValues(this.fAttributes[n].name);
    }

    public void setType(int n, String string) {
        this.fAttributes[n].type = string;
    }

    public void setValue(int n, String string) {
        Attribute attribute = this.fAttributes[n];
        attribute.value = string;
        attribute.nonNormalizedValue = string;
    }

    public void setNonNormalizedValue(int n, String string) {
        if (string == null) {
            string = this.fAttributes[n].value;
        }
        this.fAttributes[n].nonNormalizedValue = string;
    }

    public String getNonNormalizedValue(int n) {
        String string = this.fAttributes[n].nonNormalizedValue;
        return string;
    }

    public void setSpecified(int n, boolean bl) {
        this.fAttributes[n].specified = bl;
    }

    public boolean isSpecified(int n) {
        return this.fAttributes[n].specified;
    }

    public int getLength() {
        return this.fLength;
    }

    public String getType(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.getReportableType(this.fAttributes[n].type);
    }

    public String getType(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.getReportableType(this.fAttributes[n].type) : null;
    }

    public String getValue(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].value;
    }

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

    public int getIndex(String string) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            Attribute attribute = this.fAttributes[i2];
            if (attribute.name.rawname == null || !attribute.name.rawname.equals(string)) continue;
            return i2;
        }
        return -1;
    }

    public int getIndex(String string, String string2) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            Attribute attribute = this.fAttributes[i2];
            if (attribute.name.localpart == null || !attribute.name.localpart.equals(string2) || string != attribute.name.uri && (string == null || attribute.name.uri == null || !attribute.name.uri.equals(string))) continue;
            return i2;
        }
        return -1;
    }

    public String getLocalName(int n) {
        if (!this.fNamespaces) {
            return "";
        }
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].name.localpart;
    }

    public String getQName(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.rawname;
        return string != null ? string : "";
    }

    public String getType(String string, String string2) {
        if (!this.fNamespaces) {
            return null;
        }
        int n = this.getIndex(string, string2);
        return n != -1 ? this.getReportableType(this.fAttributes[n].type) : null;
    }

    public String getPrefix(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.prefix;
        return string != null ? string : "";
    }

    public String getURI(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        String string = this.fAttributes[n].name.uri;
        return string;
    }

    public String getValue(String string, String string2) {
        int n = this.getIndex(string, string2);
        return n != -1 ? this.getValue(n) : null;
    }

    public Augmentations getAugmentations(String string, String string2) {
        int n = this.getIndex(string, string2);
        return n != -1 ? this.fAttributes[n].augs : null;
    }

    public Augmentations getAugmentations(String string) {
        int n = this.getIndex(string);
        return n != -1 ? this.fAttributes[n].augs : null;
    }

    public Augmentations getAugmentations(int n) {
        if (n < 0 || n >= this.fLength) {
            return null;
        }
        return this.fAttributes[n].augs;
    }

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
            Attribute attribute = this.fAttributes[i2];
            if (attribute.name.rawname != string) continue;
            return i2;
        }
        return -1;
    }

    public void addAttributeNS(QName qName, String string, String string2) {
        Attribute[] attributeArray;
        int n = this.fLength;
        if (this.fLength++ == this.fAttributes.length) {
            attributeArray = this.fLength < 20 ? new Attribute[this.fAttributes.length + 4] : new Attribute[this.fAttributes.length << 1];
            System.arraycopy((Object)this.fAttributes, 0, (Object)attributeArray, 0, this.fAttributes.length);
            for (int i2 = this.fAttributes.length; i2 < attributeArray.length; ++i2) {
                attributeArray[i2] = new Attribute();
            }
            this.fAttributes = attributeArray;
        }
        attributeArray = this.fAttributes[n];
        attributeArray.name.setValues(qName);
        attributeArray.type = string;
        attributeArray.value = string2;
        attributeArray.nonNormalizedValue = string2;
        attributeArray.specified = false;
        attributeArray.augs.removeAllItems();
    }

    public QName checkDuplicatesNS() {
        if (this.fLength <= 20) {
            for (int i2 = 0; i2 < this.fLength - 1; ++i2) {
                Attribute attribute = this.fAttributes[i2];
                for (int i3 = i2 + 1; i3 < this.fLength; ++i3) {
                    Attribute attribute2 = this.fAttributes[i3];
                    if (attribute.name.localpart != attribute2.name.localpart || attribute.name.uri != attribute2.name.uri) continue;
                    return attribute2.name;
                }
            }
        } else {
            this.fIsTableViewConsistent = false;
            this.prepareTableView();
            for (int i4 = this.fLength - 1; i4 >= 0; --i4) {
                Attribute attribute = this.fAttributes[i4];
                int n = this.getTableViewBucket(attribute.name.localpart, attribute.name.uri);
                if (this.fAttributeTableViewChainState[n] != this.fLargeCount) {
                    this.fAttributeTableViewChainState[n] = this.fLargeCount;
                    attribute.next = null;
                    this.fAttributeTableView[n] = attribute;
                    continue;
                }
                Attribute attribute3 = this.fAttributeTableView[n];
                while (attribute3 != null) {
                    if (attribute3.name.localpart == attribute.name.localpart && attribute3.name.uri == attribute.name.uri) {
                        return attribute.name;
                    }
                    attribute3 = attribute3.next;
                }
                attribute.next = this.fAttributeTableView[n];
                this.fAttributeTableView[n] = attribute;
            }
        }
        return null;
    }

    public int getIndexFast(String string, String string2) {
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            Attribute attribute = this.fAttributes[i2];
            if (attribute.name.localpart != string2 || attribute.name.uri != string) continue;
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
        return (string.hashCode() & Integer.MAX_VALUE) % this.fTableViewBuckets;
    }

    protected int getTableViewBucket(String string, String string2) {
        if (string2 == null) {
            return (string.hashCode() & Integer.MAX_VALUE) % this.fTableViewBuckets;
        }
        return (string.hashCode() + string2.hashCode() & Integer.MAX_VALUE) % this.fTableViewBuckets;
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
            this.fAttributeTableView = new Attribute[this.fTableViewBuckets];
            this.fAttributeTableViewChainState = new int[this.fTableViewBuckets];
        } else {
            this.cleanTableView();
        }
    }

    protected void prepareAndPopulateTableView() {
        this.prepareTableView();
        for (int i2 = 0; i2 < this.fLength; ++i2) {
            Attribute attribute = this.fAttributes[i2];
            int n = this.getTableViewBucket(attribute.name.rawname);
            if (this.fAttributeTableViewChainState[n] != this.fLargeCount) {
                this.fAttributeTableViewChainState[n] = this.fLargeCount;
                attribute.next = null;
                this.fAttributeTableView[n] = attribute;
                continue;
            }
            attribute.next = this.fAttributeTableView[n];
            this.fAttributeTableView[n] = attribute;
        }
    }

    static class Attribute {
        public QName name = new QName();
        public String type;
        public String value;
        public String nonNormalizedValue;
        public boolean specified;
        public boolean schemaId;
        public Augmentations augs = new AugmentationsImpl();
        public Attribute next;

        Attribute() {
        }
    }
}

