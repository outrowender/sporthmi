.version 50 0 
.class public super [101] 
.super [103] 
.field private [104] [105] 

.method protected [107] : [108] 
    .attribute [106] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     new [21] 
L8:     dup 
L9:     bipush 10 
L11:    invokespecial [17] 
L14:    putfield [22] 
L17:    invokestatic [6] 
L20:    astore_1 
L21:    aload_1 
L22:    ifnull L29 
L25:    aload_1 
L26:    invokevirtual [11] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [109] : [110] 
    .attribute [106] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [18] 
L5:     aload_0 
L6:     new [21] 
L9:     dup 
L10:    bipush 10 
L12:    invokespecial [17] 
L15:    putfield [22] 
L18:    invokestatic [6] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnull L30 
L26:    aload_2 
L27:    invokevirtual [11] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected final [111] : [112] 
    .attribute [106] .code stack 6 locals 1 
L0:     aconst_null 
L1:     astore 6 
L3:     aload 5 
L5:     ifnull L58 
L8:     aload_0 
L9:     getfield [10] 
L12:    aload 5 
L14:    invokevirtual [12] 
L17:    checkcast [8] 
L20:    astore 6 
L22:    aload 6 
L24:    ifnonnull L58 
L27:    new [23] 
L30:    dup 
L31:    aload 5 
L33:    aload_0 
L34:    aload 5 
L36:    invokevirtual [13] 
L39:    aload_0 
L40:    aconst_null 
L41:    invokespecial [19] 
L44:    astore 6 
L46:    aload_0 
L47:    getfield [10] 
L50:    aload 5 
L52:    aload 6 
L54:    invokevirtual [14] 
L57:    pop 
L58:    aload_0 
L59:    aload_1 
L60:    aload_2 
L61:    iload_3 
L62:    iload 4 
L64:    aload 6 
L66:    invokevirtual [15] 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [106] .code stack 2 locals 0 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [20] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Method [29] [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Field [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Class [56] 
.const [22] = Field [57] [58] 
.const [23] = Class [59] 
.const [24] = Class [60] 
.const [25] = Utf8 java/security/SecureClassLoader 
.const [26] = Utf8 java/lang/ClassLoader 
.const [27] = Utf8 java/util/Hashtable 
.const [28] = Utf8 java/lang/System 
.const [29] = Class [61] 
.const [30] = NameAndType [62] [63] 
.const [31] = Utf8 java/lang/SecurityManager 
.const [32] = Utf8 java/security/ProtectionDomain 
.const [33] = Utf8 java/security/Permissions 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Utf8 java/util/Hashtable 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Utf8 java/security/ProtectionDomain 
.const [60] = Utf8 java/security/Permissions 
.const [61] = Utf8 java/lang/System 
.const [62] = Utf8 getSecurityManager 
.const [63] = Utf8 ()Ljava/lang/SecurityManager; 
.const [64] = Utf8 java/security/SecureClassLoader 
.const [65] = Utf8 domainForCodeSource 
.const [66] = Utf8 Ljava/util/Hashtable; 
.const [67] = Utf8 java/lang/SecurityManager 
.const [68] = Utf8 checkCreateClassLoader 
.const [69] = Utf8 ()V 
.const [70] = Utf8 java/util/Hashtable 
.const [71] = Utf8 get 
.const [72] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [73] = Utf8 java/security/SecureClassLoader 
.const [74] = Utf8 getPermissions 
.const [75] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.const [76] = Utf8 java/util/Hashtable 
.const [77] = Utf8 put 
.const [78] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [79] = Utf8 java/security/SecureClassLoader 
.const [80] = Utf8 defineClass 
.const [81] = Utf8 (Ljava/lang/String;[BIILjava/security/ProtectionDomain;)Ljava/lang/Class; 
.const [82] = Utf8 java/lang/ClassLoader 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/util/Hashtable 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (I)V 
.const [88] = Utf8 java/lang/ClassLoader 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [91] = Utf8 java/security/ProtectionDomain 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Ljava/security/CodeSource;Ljava/security/PermissionCollection;Ljava/lang/ClassLoader;[Ljava/security/Principal;)V 
.const [94] = Utf8 java/security/Permissions 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/security/SecureClassLoader 
.const [98] = Utf8 domainForCodeSource 
.const [99] = Utf8 Ljava/util/Hashtable; 
.const [100] = Utf8 java/security/SecureClassLoader 
.const [101] = Class [100] 
.const [102] = Utf8 java/lang/ClassLoader 
.const [103] = Class [102] 
.const [104] = Utf8 domainForCodeSource 
.const [105] = Utf8 Ljava/util/Hashtable; 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [111] = Utf8 defineClass 
.const [112] = Utf8 (Ljava/lang/String;[BIILjava/security/CodeSource;)Ljava/lang/Class; 
.const [113] = Utf8 getPermissions 
.const [114] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.end class 
