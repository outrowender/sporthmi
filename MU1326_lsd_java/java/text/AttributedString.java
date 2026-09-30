/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.Annotation;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class AttributedString {
    String text;
    Map attributeMap;

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator) {
        StringBuffer stringBuffer = new StringBuffer();
        while (attributedCharacterIterator.current() != '\uffff') {
            stringBuffer.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
        }
        this.text = stringBuffer.toString();
        Set set = attributedCharacterIterator.getAllAttributeKeys();
        this.attributeMap = new HashMap(set.size() * 4 / 3 + 1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute)iterator.next();
            attributedCharacterIterator.setIndex(0);
            while (attributedCharacterIterator.current() != '\uffff') {
                int n = attributedCharacterIterator.getRunStart(attribute);
                int n2 = attributedCharacterIterator.getRunLimit(attribute);
                Object object = attributedCharacterIterator.getAttribute(attribute);
                if (object != null) {
                    this.addAttribute(attribute, object, n, n2);
                }
                attributedCharacterIterator.setIndex(n2);
            }
        }
    }

    private AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2, Set set) {
        if (n < attributedCharacterIterator.getBeginIndex() || n2 > attributedCharacterIterator.getEndIndex() || n > n2) {
            throw new IllegalArgumentException();
        }
        StringBuffer stringBuffer = new StringBuffer();
        attributedCharacterIterator.setIndex(n);
        while (attributedCharacterIterator.getIndex() < n2) {
            stringBuffer.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
        }
        this.text = stringBuffer.toString();
        this.attributeMap = new HashMap(set.size() * 4 / 3 + 1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute)iterator.next();
            attributedCharacterIterator.setIndex(n);
            while (attributedCharacterIterator.getIndex() < n2) {
                Object object = attributedCharacterIterator.getAttribute(attribute);
                int n3 = attributedCharacterIterator.getRunStart(attribute);
                int n4 = attributedCharacterIterator.getRunLimit(attribute);
                if (object instanceof Annotation && n3 >= n && n4 <= n2 || object != null && !(object instanceof Annotation)) {
                    this.addAttribute(attribute, object, (n3 < n ? n : n3) - n, (n4 > n2 ? n2 : n4) - n);
                }
                attributedCharacterIterator.setIndex(n4);
            }
        }
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2) {
        this(attributedCharacterIterator, n, n2, attributedCharacterIterator.getAllAttributeKeys());
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int n, int n2, AttributedCharacterIterator.Attribute[] attributeArray) {
        this(attributedCharacterIterator, n, n2, new HashSet(Arrays.asList(attributeArray)));
    }

    public AttributedString(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.text = string;
        this.attributeMap = new HashMap(11);
    }

    public AttributedString(String string, Map map) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (string.length() == 0 && !map.isEmpty()) {
            throw new IllegalArgumentException(Msg.getString("K000e"));
        }
        this.text = string;
        this.attributeMap = new HashMap(map.size() * 4 / 3 + 1);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new Range(0, this.text.length(), entry.getValue()));
            this.attributeMap.put(entry.getKey(), arrayList);
        }
    }

    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object object) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        if (this.text.length() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = (ArrayList)this.attributeMap.get(attribute);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.attributeMap.put(attribute, arrayList);
        } else {
            arrayList.clear();
        }
        arrayList.add(new Range(0, this.text.length(), object));
    }

    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object object, int n, int n2) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 > this.text.length() || n >= n2) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = (ArrayList)this.attributeMap.get(attribute);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            arrayList.add(new Range(n, n2, object));
            this.attributeMap.put(attribute, arrayList);
            return;
        }
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            Range range = (Range)listIterator.next();
            if (n2 <= range.start) {
                listIterator.previous();
                break;
            }
            if (n >= range.end && (n != range.end || !(object == null ? range.value == null : object.equals(range.value)))) continue;
            Range range2 = null;
            listIterator.remove();
            range2 = new Range(range.start, n, range.value);
            Range range3 = new Range(n2, range.end, range.value);
            while (n2 > range.end && listIterator.hasNext()) {
                range = (Range)listIterator.next();
                if (n2 <= range.end) {
                    if (n2 <= range.start && (n2 != range.start || !(object == null ? range.value == null : object.equals(range.value)))) continue;
                    listIterator.remove();
                    range3 = new Range(n2, range.end, range.value);
                    break;
                }
                listIterator.remove();
            }
            if (object == null ? range2.value == null : object.equals(range2.value)) {
                if (object == null ? range3.value == null : object.equals(range3.value)) {
                    listIterator.add(new Range(range2.start < n ? range2.start : n, range3.end > n2 ? range3.end : n2, range2.value));
                } else {
                    listIterator.add(new Range(range2.start < n ? range2.start : n, n2, range2.value));
                    if (range3.start < range3.end) {
                        listIterator.add(range3);
                    }
                }
            } else if (object == null ? range3.value == null : object.equals(range3.value)) {
                if (range2.start < range2.end) {
                    listIterator.add(range2);
                }
                listIterator.add(new Range(n, range3.end > n2 ? range3.end : n2, range3.value));
            } else {
                if (range2.start < range2.end) {
                    listIterator.add(range2);
                }
                listIterator.add(new Range(n, n2, object));
                if (range3.start < range3.end) {
                    listIterator.add(range3);
                }
            }
            return;
        }
        listIterator.add(new Range(n, n2, object));
    }

    public void addAttributes(Map map, int n, int n2) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.addAttribute((AttributedCharacterIterator.Attribute)entry.getKey(), entry.getValue(), n, n2);
        }
    }

    public AttributedCharacterIterator getIterator() {
        return new AttributedIterator(this);
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributeArray) {
        return new AttributedIterator(this, attributeArray, 0, this.text.length());
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributeArray, int n, int n2) {
        return new AttributedIterator(this, attributeArray, n, n2);
    }

    static class Range {
        int start;
        int end;
        Object value;

        Range(int n, int n2, Object object) {
            this.start = n;
            this.end = n2;
            this.value = object;
        }
    }

    static class AttributedIterator
    implements AttributedCharacterIterator {
        private int begin;
        private int end;
        private int offset;
        private AttributedString attrString;
        private HashSet attributesAllowed;
        private static Object marker = new Object();

        AttributedIterator(AttributedString attributedString) {
            this.attrString = attributedString;
            this.begin = 0;
            this.end = attributedString.text.length();
            this.offset = 0;
        }

        AttributedIterator(AttributedString attributedString, AttributedCharacterIterator.Attribute[] attributeArray, int n, int n2) {
            if (n < 0 || n2 > attributedString.text.length() || n > n2) {
                throw new IllegalArgumentException();
            }
            this.begin = n;
            this.end = n2;
            this.offset = n;
            this.attrString = attributedString;
            if (attributeArray != null) {
                HashSet hashSet = new HashSet(attributeArray.length * 4 / 3 + 1);
                int n3 = attributeArray.length;
                while (--n3 >= 0) {
                    hashSet.add(attributeArray[n3]);
                }
                this.attributesAllowed = hashSet;
            }
        }

        public Object clone() {
            try {
                AttributedIterator attributedIterator = (AttributedIterator)super.clone();
                if (this.attributesAllowed != null) {
                    attributedIterator.attributesAllowed = (HashSet)this.attributesAllowed.clone();
                }
                return attributedIterator;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                return null;
            }
        }

        public char current() {
            if (this.offset == this.end) {
                return '\uffff';
            }
            return this.attrString.text.charAt(this.offset);
        }

        public char first() {
            if (this.begin == this.end) {
                return '\uffff';
            }
            this.offset = this.begin;
            return this.attrString.text.charAt(this.offset);
        }

        public int getBeginIndex() {
            return this.begin;
        }

        public int getEndIndex() {
            return this.end;
        }

        public int getIndex() {
            return this.offset;
        }

        private boolean inRange(Range range) {
            if (!(range.value instanceof Annotation)) {
                return true;
            }
            return range.start >= this.begin && range.start < this.end && range.end > this.begin && range.end <= this.end;
        }

        private boolean inRange(ArrayList arrayList) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Range range = (Range)iterator.next();
                if (range.start >= this.begin && range.start < this.end) {
                    return !(range.value instanceof Annotation) || range.end > this.begin && range.end <= this.end;
                }
                if (range.end <= this.begin || range.end > this.end) continue;
                return !(range.value instanceof Annotation) || range.start >= this.begin && range.start < this.end;
            }
            return false;
        }

        public Set getAllAttributeKeys() {
            if (this.begin == 0 && this.end == this.attrString.text.length() && this.attributesAllowed == null) {
                return this.attrString.attributeMap.keySet();
            }
            HashSet hashSet = new HashSet(this.attrString.attributeMap.size() * 4 / 3 + 1);
            Iterator iterator = this.attrString.attributeMap.entrySet().iterator();
            while (iterator.hasNext()) {
                ArrayList arrayList;
                Map.Entry entry = (Map.Entry)iterator.next();
                if (this.attributesAllowed != null && !this.attributesAllowed.contains(entry.getKey()) || !this.inRange(arrayList = (ArrayList)entry.getValue())) continue;
                hashSet.add(entry.getKey());
            }
            return hashSet;
        }

        private Object currentValue(ArrayList arrayList, boolean bl) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Range range = (Range)iterator.next();
                if (this.offset < range.start || this.offset >= range.end) continue;
                return this.inRange(range) ? range.value : (bl ? marker : null);
            }
            return bl ? marker : null;
        }

        public Object getAttribute(AttributedCharacterIterator.Attribute attribute) {
            if (this.attributesAllowed != null && !this.attributesAllowed.contains(attribute)) {
                return null;
            }
            ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attribute);
            if (arrayList == null) {
                return null;
            }
            return this.currentValue(arrayList, false);
        }

        public Map getAttributes() {
            HashMap hashMap = new HashMap(this.attrString.attributeMap.size() * 4 / 3 + 1);
            Iterator iterator = this.attrString.attributeMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Object object;
                Map.Entry entry = (Map.Entry)iterator.next();
                if (this.attributesAllowed != null && !this.attributesAllowed.contains(entry.getKey()) || (object = this.currentValue((ArrayList)entry.getValue(), true)) == marker) continue;
                hashMap.put(entry.getKey(), object);
            }
            return hashMap;
        }

        public int getRunLimit() {
            return this.getRunLimit(this.getAllAttributeKeys());
        }

        private int runLimit(ArrayList arrayList) {
            int n = this.end;
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                Range range = (Range)listIterator.previous();
                if (range.value == null) continue;
                if (range.end <= this.begin) break;
                if (this.offset >= range.start && this.offset < range.end) {
                    return this.inRange(range) ? range.end : n;
                }
                if (this.offset >= range.end) break;
                n = range.start;
            }
            return n;
        }

        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            if (this.attributesAllowed != null && !this.attributesAllowed.contains(attribute)) {
                return this.end;
            }
            ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attribute);
            if (arrayList == null) {
                return this.end;
            }
            return this.runLimit(arrayList);
        }

        public int getRunLimit(Set set) {
            int n = this.end;
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute)iterator.next();
                int n2 = this.getRunLimit(attribute);
                if (n2 >= n) continue;
                n = n2;
            }
            return n;
        }

        public int getRunStart() {
            return this.getRunStart(this.getAllAttributeKeys());
        }

        private int runStart(ArrayList arrayList) {
            int n = this.begin;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Range range = (Range)iterator.next();
                if (range.start >= this.end) break;
                if (this.offset >= range.start && this.offset < range.end) {
                    return this.inRange(range) ? range.start : n;
                }
                if (this.offset < range.start) break;
                n = range.end;
            }
            return n;
        }

        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            if (this.attributesAllowed != null && !this.attributesAllowed.contains(attribute)) {
                return this.begin;
            }
            ArrayList arrayList = (ArrayList)this.attrString.attributeMap.get(attribute);
            if (arrayList == null) {
                return this.begin;
            }
            return this.runStart(arrayList);
        }

        public int getRunStart(Set set) {
            int n = this.begin;
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute)iterator.next();
                int n2 = this.getRunStart(attribute);
                if (n2 <= n) continue;
                n = n2;
            }
            return n;
        }

        public char last() {
            if (this.begin == this.end) {
                return '\uffff';
            }
            this.offset = this.end - 1;
            return this.attrString.text.charAt(this.offset);
        }

        public char next() {
            if (this.offset >= this.end - 1) {
                this.offset = this.end;
                return '\uffff';
            }
            return this.attrString.text.charAt(++this.offset);
        }

        public char previous() {
            if (this.offset == this.begin) {
                return '\uffff';
            }
            return this.attrString.text.charAt(--this.offset);
        }

        public char setIndex(int n) {
            if (n < this.begin || n > this.end) {
                throw new IllegalArgumentException();
            }
            this.offset = n;
            if (this.offset == this.end) {
                return '\uffff';
            }
            return this.attrString.text.charAt(this.offset);
        }
    }
}

