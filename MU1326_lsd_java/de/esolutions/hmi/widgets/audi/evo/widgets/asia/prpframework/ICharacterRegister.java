/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

public interface ICharacterRegister {
    public static final ICharacterRegister BLACKLIST_ALLOWING_EVERYTHING = new ICharacterRegister(){

        public boolean contains(char c2) {
            return false;
        }

        public String getName() {
            return "";
        }

        public int getSize() {
            return 0;
        }

        public boolean containsIgnoreCase(char c2) {
            return false;
        }
    };
    public static final ICharacterRegister WHITELIST_ALLOWING_EVERYTHING = new ICharacterRegister(){

        public boolean contains(char c2) {
            return true;
        }

        public String getName() {
            return "";
        }

        public int getSize() {
            return 0;
        }

        public boolean containsIgnoreCase(char c2) {
            return true;
        }
    };

    public int getSize();

    public String getName();

    public boolean contains(char var1);

    public boolean containsIgnoreCase(char var1);
}

