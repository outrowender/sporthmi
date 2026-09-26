/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class User {
    private final String login;
    private boolean isMainUser;

    public static User getInstance(String string, boolean bl) {
        return new User(string, bl);
    }

    private User(String string, boolean bl) {
        this.login = string;
        this.isMainUser = bl;
    }

    public String getLogin() {
        return this.login;
    }

    public boolean isMainUser() {
        return this.isMainUser;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.isMainUser ? 1231 : 1237);
        n = 31 * n + (this.login == null ? 0 : this.login.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        User user = (User)object;
        if (this.isMainUser != user.isMainUser) {
            return false;
        }
        return !(this.login == null ? user.login != null : !this.login.equals(user.login));
    }

    public String toString() {
        return new StringBuffer().append("OnlineUser [login=").append(this.login).append(", isMainUser=").append(this.isMainUser).append("]").toString();
    }
}

