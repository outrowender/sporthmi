.version 50 0 
.class public super abstract [117] 
.super [119] 
.field private [120] [121] 
.field private static final [122] [123] 

.method static [125] : [126] 
    .attribute [124] .code stack 3 locals 0 
L0:     new [25] 
L3:     dup 
L4:     ldc [5] 
L6:     invokespecial [18] 
L9:     putstatic [19] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [127] : [128] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     invokespecial [20] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [26] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method [129] : [130] 
    .attribute [124] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [21] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [26] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [124] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [22] 
L5:     astore_2 
L6:     aload_2 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected synchronized [133] : [134] 
    .attribute [124] .code stack 4 locals 3 
L0:     invokestatic [8] 
L3:     astore_3 
L4:     aload_3 
L5:     ifnull L62 
L8:     aload_0 
L9:     getfield [12] 
L12:    ifne L62 
L15:    aload_1 
L16:    bipush 46 
L18:    invokevirtual [13] 
L21:    istore 4 
L23:    iload 4 
L25:    ifle L62 
        .catch [0] from L28 to L47 using L47 
L28:    aload_0 
L29:    iconst_1 
L30:    putfield [26] 
L33:    aload_3 
L34:    aload_1 
L35:    iconst_0 
L36:    iload 4 
L38:    invokevirtual [14] 
L41:    invokevirtual [15] 
L44:    goto L57 
L47:    astore 5 
L49:    aload_0 
L50:    iconst_0 
L51:    putfield [26] 
L54:    aload 5 
L56:    athrow 
L57:    aload_0 
L58:    iconst_0 
L59:    putfield [26] 
L62:    aload_0 
L63:    aload_1 
L64:    iload_2 
L65:    invokespecial [23] 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method abstract [135] : [136] 
    .attribute [124] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [137] : [138] 
    .attribute [124] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     astore_2 
L6:     aload_0 
L7:     invokevirtual [16] 
L10:    ifeq L20 
L13:    aload_2 
L14:    getstatic [6] 
L17:    invokevirtual [17] 
L20:    aload_2 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = String [30] 
.const [6] = Field [31] [32] 
.const [7] = Class [33] 
.const [8] = Method [34] [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Field [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Class [65] 
.const [26] = Field [66] [67] 
.const [27] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [28] = Utf8 java/net/URLClassLoader 
.const [29] = Utf8 java/lang/RuntimePermission 
.const [30] = Utf8 exitVM 
.const [31] = Class [68] 
.const [32] = NameAndType [69] [70] 
.const [33] = Utf8 java/lang/System 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Utf8 java/lang/String 
.const [37] = Utf8 java/lang/SecurityManager 
.const [38] = Utf8 java/security/PermissionCollection 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Utf8 java/lang/RuntimePermission 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [69] = Utf8 permissionToExitVM 
.const [70] = Utf8 Ljava/lang/RuntimePermission; 
.const [71] = Utf8 java/lang/System 
.const [72] = Utf8 getSecurityManager 
.const [73] = Utf8 ()Ljava/lang/SecurityManager; 
.const [74] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [75] = Utf8 checkingPackageAccess 
.const [76] = Utf8 Z 
.const [77] = Utf8 java/lang/String 
.const [78] = Utf8 lastIndexOf 
.const [79] = Utf8 (I)I 
.const [80] = Utf8 java/lang/String 
.const [81] = Utf8 substring 
.const [82] = Utf8 (II)Ljava/lang/String; 
.const [83] = Utf8 java/lang/SecurityManager 
.const [84] = Utf8 checkPackageAccess 
.const [85] = Utf8 (Ljava/lang/String;)V 
.const [86] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [87] = Utf8 addExitPermission 
.const [88] = Utf8 ()Z 
.const [89] = Utf8 java/security/PermissionCollection 
.const [90] = Utf8 add 
.const [91] = Utf8 (Ljava/security/Permission;)V 
.const [92] = Utf8 java/lang/RuntimePermission 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Ljava/lang/String;)V 
.const [95] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [96] = Utf8 permissionToExitVM 
.const [97] = Utf8 Ljava/lang/RuntimePermission; 
.const [98] = Utf8 java/net/URLClassLoader 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ([Ljava/net/URL;)V 
.const [101] = Utf8 java/net/URLClassLoader 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ([Ljava/net/URL;Ljava/lang/ClassLoader;)V 
.const [104] = Utf8 java/net/URLClassLoader 
.const [105] = Utf8 findClass 
.const [106] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [107] = Utf8 java/net/URLClassLoader 
.const [108] = Utf8 loadClass 
.const [109] = Utf8 (Ljava/lang/String;Z)Ljava/lang/Class; 
.const [110] = Utf8 java/net/URLClassLoader 
.const [111] = Utf8 getPermissions 
.const [112] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.const [113] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [114] = Utf8 checkingPackageAccess 
.const [115] = Utf8 Z 
.const [116] = Utf8 com/ibm/oti/vm/URLSystemClassLoader 
.const [117] = Class [116] 
.const [118] = Utf8 java/net/URLClassLoader 
.const [119] = Class [118] 
.const [120] = Utf8 checkingPackageAccess 
.const [121] = Utf8 Z 
.const [122] = Utf8 permissionToExitVM 
.const [123] = Utf8 Ljava/lang/RuntimePermission; 
.const [124] = Utf8 Code 
.const [125] = Utf8 <clinit> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ([Ljava/net/URL;Ljava/lang/ClassLoader;)V 
.const [131] = Utf8 findClass 
.const [132] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [133] = Utf8 loadClass 
.const [134] = Utf8 (Ljava/lang/String;Z)Ljava/lang/Class; 
.const [135] = Utf8 addExitPermission 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 getPermissions 
.const [138] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.end class 
