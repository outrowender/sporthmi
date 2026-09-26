.version 50 0 
.class public super abstract [135] 
.super [137] 
.field static [138] [139] 

.method public annotation [141] : [142] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 2 locals 1 
L0:     invokestatic [5] 
L3:     astore_0 
L4:     aload_0 
L5:     ifnull L15 
L8:     aload_0 
L9:     getstatic [7] 
L12:    invokevirtual [24] 
L15:    invokestatic [9] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [145] : [146] 
    .attribute [140] .code stack 2 locals 1 
L0:     getstatic [10] 
L3:     ifnonnull L55 
L6:     ldc [11] 
L8:     invokestatic [13] 
L11:    invokestatic [15] 
L14:    checkcast [16] 
L17:    astore_0 
        .catch [20] from L18 to L38 using L38 
L18:    aload_0 
L19:    ifnull L39 
L22:    aload_0 
L23:    invokestatic [18] 
L26:    invokevirtual [25] 
L29:    checkcast [2] 
L32:    putstatic [31] 
L35:    goto L39 
L38:    pop 
L39:    getstatic [10] 
L42:    ifnonnull L55 
L45:    new [33] 
L48:    dup 
L49:    invokespecial [32] 
L52:    putstatic [31] 
L55:    getstatic [10] 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [147] : [148] 
    .attribute [140] .code stack 2 locals 1 
L0:     invokestatic [5] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L15 
L8:     aload_1 
L9:     getstatic [21] 
L12:    invokevirtual [24] 
L15:    aload_0 
L16:    putstatic [31] 
L19:    return 
L20:    
    .end code 
.end method 

.method public abstract [149] : [150] 
    .attribute [140] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [151] : [152] 
    .attribute [140] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [26] 
L5:     invokevirtual [27] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [28] 
L5:     aload_2 
L6:     invokevirtual [29] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Method [37] [38] 
.const [6] = Class [39] 
.const [7] = Field [40] [41] 
.const [8] = Class [42] 
.const [9] = Method [43] [44] 
.const [10] = Field [45] [46] 
.const [11] = String [47] 
.const [12] = Class [48] 
.const [13] = Method [49] [50] 
.const [14] = Class [51] 
.const [15] = Method [52] [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Method [56] [57] 
.const [19] = Class [58] 
.const [20] = Class [59] 
.const [21] = Field [60] [61] 
.const [22] = Class [62] 
.const [23] = Class [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = Method [80] [81] 
.const [33] = Class [82] 
.const [34] = Utf8 java/security/Policy 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/lang/System 
.const [37] = Class [83] 
.const [38] = NameAndType [84] [85] 
.const [39] = Utf8 java/security/SecurityPermission 
.const [40] = Class [86] 
.const [41] = NameAndType [87] [88] 
.const [42] = Utf8 java/lang/SecurityManager 
.const [43] = Class [89] 
.const [44] = NameAndType [90] [91] 
.const [45] = Class [92] 
.const [46] = NameAndType [93] [94] 
.const [47] = Utf8 'policy.provider' 
.const [48] = Utf8 com/ibm/oti/util/PriviAction 
.const [49] = Class [95] 
.const [50] = NameAndType [96] [97] 
.const [51] = Utf8 java/security/AccessController 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Utf8 java/lang/String 
.const [55] = Utf8 java/lang/Class 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 com/ibm/oti/util/DefaultPolicy 
.const [59] = Utf8 java/lang/Exception 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Utf8 java/security/ProtectionDomain 
.const [63] = Utf8 java/security/PermissionCollection 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Class [131] 
.const [81] = NameAndType [132] [133] 
.const [82] = Utf8 com/ibm/oti/util/DefaultPolicy 
.const [83] = Utf8 java/lang/System 
.const [84] = Utf8 getSecurityManager 
.const [85] = Utf8 ()Ljava/lang/SecurityManager; 
.const [86] = Utf8 java/security/SecurityPermission 
.const [87] = Utf8 permissionToGetPolicy 
.const [88] = Utf8 Ljava/security/SecurityPermission; 
.const [89] = Utf8 java/security/Policy 
.const [90] = Utf8 getPolicyImpl 
.const [91] = Utf8 ()Ljava/security/Policy; 
.const [92] = Utf8 java/security/Policy 
.const [93] = Utf8 policy 
.const [94] = Utf8 Ljava/security/Policy; 
.const [95] = Utf8 com/ibm/oti/util/PriviAction 
.const [96] = Utf8 getSecurityProperty 
.const [97] = Utf8 (Ljava/lang/String;)Ljava/security/PrivilegedAction; 
.const [98] = Utf8 java/security/AccessController 
.const [99] = Utf8 doPrivileged 
.const [100] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [101] = Utf8 java/lang/Class 
.const [102] = Utf8 forName 
.const [103] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [104] = Utf8 java/security/SecurityPermission 
.const [105] = Utf8 permissionToSetPolicy 
.const [106] = Utf8 Ljava/security/SecurityPermission; 
.const [107] = Utf8 java/lang/SecurityManager 
.const [108] = Utf8 checkPermission 
.const [109] = Utf8 (Ljava/security/Permission;)V 
.const [110] = Utf8 java/lang/Class 
.const [111] = Utf8 newInstance 
.const [112] = Utf8 ()Ljava/lang/Object; 
.const [113] = Utf8 java/security/ProtectionDomain 
.const [114] = Utf8 getCodeSource 
.const [115] = Utf8 ()Ljava/security/CodeSource; 
.const [116] = Utf8 java/security/Policy 
.const [117] = Utf8 getPermissions 
.const [118] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.const [119] = Utf8 java/security/Policy 
.const [120] = Utf8 getPermissions 
.const [121] = Utf8 (Ljava/security/ProtectionDomain;)Ljava/security/PermissionCollection; 
.const [122] = Utf8 java/security/PermissionCollection 
.const [123] = Utf8 implies 
.const [124] = Utf8 (Ljava/security/Permission;)Z 
.const [125] = Utf8 java/lang/Object 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 java/security/Policy 
.const [129] = Utf8 policy 
.const [130] = Utf8 Ljava/security/Policy; 
.const [131] = Utf8 com/ibm/oti/util/DefaultPolicy 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 java/security/Policy 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 policy 
.const [139] = Utf8 Ljava/security/Policy; 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 getPolicy 
.const [144] = Utf8 ()Ljava/security/Policy; 
.const [145] = Utf8 getPolicyImpl 
.const [146] = Utf8 ()Ljava/security/Policy; 
.const [147] = Utf8 setPolicy 
.const [148] = Utf8 (Ljava/security/Policy;)V 
.const [149] = Utf8 getPermissions 
.const [150] = Utf8 (Ljava/security/CodeSource;)Ljava/security/PermissionCollection; 
.const [151] = Utf8 refresh 
.const [152] = Utf8 ()V 
.const [153] = Utf8 getPermissions 
.const [154] = Utf8 (Ljava/security/ProtectionDomain;)Ljava/security/PermissionCollection; 
.const [155] = Utf8 implies 
.const [156] = Utf8 (Ljava/security/ProtectionDomain;Ljava/security/Permission;)Z 
.end class 
