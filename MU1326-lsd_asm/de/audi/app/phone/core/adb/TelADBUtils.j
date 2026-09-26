.version 50 0 
.class public super [35] 
.super [37] 

.method public annotation [39] : [40] 
    .attribute [38] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [41] : [42] 
    .attribute [38] .code stack 2 locals 2 
L0:     aload_0 
L1:     ifnull L11 
L4:     aload_0 
L5:     invokevirtual [6] 
L8:     goto L12 
L11:    aconst_null 
L12:    astore_1 
L13:    aload_1 
L14:    ifnull L60 
L17:    iconst_0 
L18:    istore_2 
L19:    iload_2 
L20:    aload_1 
L21:    arraylength 
L22:    if_icmpge L60 
L25:    aload_1 
L26:    iload_2 
L27:    aaload 
L28:    ifnull L54 
L31:    aload_1 
L32:    iload_2 
L33:    aaload 
L34:    invokevirtual [7] 
L37:    ifnull L54 
L40:    aload_1 
L41:    iload_2 
L42:    aaload 
L43:    invokevirtual [7] 
L46:    invokevirtual [8] 
L49:    ifle L54 
L52:    iconst_1 
L53:    areturn 
L54:    iinc 2 1 
L57:    goto L19 
L60:    iconst_0 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Class [12] 
.const [5] = Class [13] 
.const [6] = Method [14] [15] 
.const [7] = Method [16] [17] 
.const [8] = Method [18] [19] 
.const [9] = Method [20] [21] 
.const [10] = Utf8 java/lang/Object 
.const [11] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [12] = Utf8 org/dsi/ifc/organizer/EmailData 
.const [13] = Utf8 java/lang/String 
.const [14] = Class [22] 
.const [15] = NameAndType [23] [24] 
.const [16] = Class [25] 
.const [17] = NameAndType [26] [27] 
.const [18] = Class [28] 
.const [19] = NameAndType [29] [30] 
.const [20] = Class [31] 
.const [21] = NameAndType [32] [33] 
.const [22] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [23] = Utf8 getEmailData 
.const [24] = Utf8 ()[Lorg/dsi/ifc/organizer/EmailData; 
.const [25] = Utf8 org/dsi/ifc/organizer/EmailData 
.const [26] = Utf8 getEmailAddr 
.const [27] = Utf8 ()Ljava/lang/String; 
.const [28] = Utf8 java/lang/String 
.const [29] = Utf8 length 
.const [30] = Utf8 ()I 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 <init> 
.const [33] = Utf8 ()V 
.const [34] = Utf8 de/audi/app/phone/core/adb/TelADBUtils 
.const [35] = Class [34] 
.const [36] = Utf8 java/lang/Object 
.const [37] = Class [36] 
.const [38] = Utf8 Code 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 hasEmailAddress 
.const [42] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;)Z 
.end class 
