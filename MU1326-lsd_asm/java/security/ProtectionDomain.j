.version 50 0 
.class public super [173] 
.super [175] 
.field private [176] [177] 
.field private [178] [179] 
.field private [180] [181] 
.field private [182] [183] 
.field private [184] [185] 

.method public [187] : [188] 
    .attribute [186] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [34] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [35] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [36] 
L19:    aload_0 
L20:    getfield [21] 
L23:    ifnull L33 
L26:    aload_0 
L27:    getfield [21] 
L30:    invokevirtual [22] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [186] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [34] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [35] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [36] 
L19:    aload_0 
L20:    getfield [21] 
L23:    ifnull L33 
L26:    aload_0 
L27:    getfield [21] 
L30:    invokevirtual [22] 
L33:    aload_0 
L34:    iconst_1 
L35:    putfield [34] 
L38:    aload_0 
L39:    aload_3 
L40:    putfield [37] 
L43:    aload_0 
L44:    aload 4 
L46:    putfield [38] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public final interface [191] : [192] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final interface [193] : [194] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [195] : [196] 
    .attribute [186] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifnonnull L12 
L7:     iconst_0 
L8:     anewarray [5] 
L11:    areturn 
L12:    aload_0 
L13:    getfield [24] 
L16:    arraylength 
L17:    anewarray [5] 
L20:    astore_1 
L21:    aload_0 
L22:    getfield [24] 
L25:    iconst_0 
L26:    aload_1 
L27:    iconst_0 
L28:    aload_0 
L29:    getfield [24] 
L32:    arraylength 
L33:    invokestatic [7] 
L36:    aload_1 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public final interface [197] : [198] 
    .attribute [186] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [186] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     ifeq L49 
L7:     invokestatic [9] 
L10:    aload_0 
L11:    invokevirtual [25] 
L14:    astore_2 
L15:    aload_0 
L16:    getfield [21] 
L19:    ifnull L33 
L22:    aload_0 
L23:    getfield [21] 
L26:    aload_1 
L27:    invokevirtual [26] 
L30:    ifne L47 
L33:    aload_2 
L34:    ifnull L45 
L37:    aload_2 
L38:    aload_1 
L39:    invokevirtual [26] 
L42:    ifne L47 
L45:    iconst_0 
L46:    areturn 
L47:    iconst_1 
L48:    areturn 
L49:    aload_0 
L50:    getfield [21] 
L53:    ifnull L69 
L56:    aload_0 
L57:    getfield [21] 
L60:    aload_1 
L61:    invokevirtual [26] 
L64:    ifeq L69 
L67:    iconst_1 
L68:    areturn 
L69:    iconst_0 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [186] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     ldc [11] 
L6:     invokespecial [32] 
L9:     astore_1 
L10:    aload_0 
L11:    getfield [20] 
L14:    ifnonnull L27 
L17:    aload_1 
L18:    ldc [12] 
L20:    invokevirtual [27] 
L23:    pop 
L24:    goto L39 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [20] 
L32:    invokevirtual [28] 
L35:    invokevirtual [27] 
L38:    pop 
L39:    new [40] 
L42:    dup 
L43:    ldc [15] 
L45:    invokespecial [33] 
L48:    invokestatic [17] 
L51:    checkcast [18] 
L54:    astore_2 
L55:    aload_1 
L56:    aload_2 
L57:    invokevirtual [27] 
L60:    pop 
L61:    aload_0 
L62:    getfield [21] 
L65:    ifnonnull L78 
L68:    aload_1 
L69:    ldc [12] 
L71:    invokevirtual [27] 
L74:    pop 
L75:    goto L90 
L78:    aload_1 
L79:    aload_0 
L80:    getfield [21] 
L83:    invokevirtual [29] 
L86:    invokevirtual [27] 
L89:    pop 
L90:    aload_1 
L91:    invokevirtual [30] 
L94:    areturn 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = Class [43] 
.const [5] = Class [44] 
.const [6] = Class [45] 
.const [7] = Method [46] [47] 
.const [8] = Class [48] 
.const [9] = Method [49] [50] 
.const [10] = Class [51] 
.const [11] = String [52] 
.const [12] = String [53] 
.const [13] = Class [54] 
.const [14] = Class [55] 
.const [15] = String [56] 
.const [16] = Class [57] 
.const [17] = Method [58] [59] 
.const [18] = Class [60] 
.const [19] = Field [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Field [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Field [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Field [91] [92] 
.const [35] = Field [93] [94] 
.const [36] = Field [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = Field [99] [100] 
.const [39] = Class [101] 
.const [40] = Class [102] 
.const [41] = Utf8 java/security/ProtectionDomain 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 java/security/PermissionCollection 
.const [44] = Utf8 java/security/Principal 
.const [45] = Utf8 java/lang/System 
.const [46] = Class [103] 
.const [47] = NameAndType [104] [105] 
.const [48] = Utf8 java/security/Policy 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Utf8 java/lang/StringBuffer 
.const [52] = Utf8 'ProtectionDomain ' 
.const [53] = Utf8 null 
.const [54] = Utf8 java/security/CodeSource 
.const [55] = Utf8 com/ibm/oti/util/PriviAction 
.const [56] = Utf8 'line.separator' 
.const [57] = Utf8 java/security/AccessController 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Utf8 java/lang/String 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Class [157] 
.const [92] = NameAndType [158] [159] 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 com/ibm/oti/util/PriviAction 
.const [103] = Utf8 java/lang/System 
.const [104] = Utf8 arraycopy 
.const [105] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [106] = Utf8 java/security/Policy 
.const [107] = Utf8 getPolicyImpl 
.const [108] = Utf8 ()Ljava/security/Policy; 
.const [109] = Utf8 java/security/AccessController 
.const [110] = Utf8 doPrivileged 
.const [111] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [112] = Utf8 java/security/ProtectionDomain 
.const [113] = Utf8 dynamicPermissionChecking 
.const [114] = Utf8 Z 
.const [115] = Utf8 java/security/ProtectionDomain 
.const [116] = Utf8 cs 
.const [117] = Utf8 Ljava/security/CodeSource; 
.const [118] = Utf8 java/security/ProtectionDomain 
.const [119] = Utf8 pc 
.const [120] = Utf8 Ljava/security/PermissionCollection; 
.const [121] = Utf8 java/security/PermissionCollection 
.const [122] = Utf8 setReadOnly 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/security/ProtectionDomain 
.const [125] = Utf8 classLoader 
.const [126] = Utf8 Ljava/lang/ClassLoader; 
.const [127] = Utf8 java/security/ProtectionDomain 
.const [128] = Utf8 principals 
.const [129] = Utf8 [Ljava/security/Principal; 
.const [130] = Utf8 java/security/Policy 
.const [131] = Utf8 getPermissions 
.const [132] = Utf8 (Ljava/security/ProtectionDomain;)Ljava/security/PermissionCollection; 
.const [133] = Utf8 java/security/PermissionCollection 
.const [134] = Utf8 implies 
.const [135] = Utf8 (Ljava/security/Permission;)Z 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [139] = Utf8 java/security/CodeSource 
.const [140] = Utf8 toString 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 java/security/PermissionCollection 
.const [143] = Utf8 toString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 toString 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 java/lang/Object 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Ljava/lang/String;)V 
.const [154] = Utf8 com/ibm/oti/util/PriviAction 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/lang/String;)V 
.const [157] = Utf8 java/security/ProtectionDomain 
.const [158] = Utf8 dynamicPermissionChecking 
.const [159] = Utf8 Z 
.const [160] = Utf8 java/security/ProtectionDomain 
.const [161] = Utf8 cs 
.const [162] = Utf8 Ljava/security/CodeSource; 
.const [163] = Utf8 java/security/ProtectionDomain 
.const [164] = Utf8 pc 
.const [165] = Utf8 Ljava/security/PermissionCollection; 
.const [166] = Utf8 java/security/ProtectionDomain 
.const [167] = Utf8 classLoader 
.const [168] = Utf8 Ljava/lang/ClassLoader; 
.const [169] = Utf8 java/security/ProtectionDomain 
.const [170] = Utf8 principals 
.const [171] = Utf8 [Ljava/security/Principal; 
.const [172] = Utf8 java/security/ProtectionDomain 
.const [173] = Class [172] 
.const [174] = Utf8 java/lang/Object 
.const [175] = Class [174] 
.const [176] = Utf8 cs 
.const [177] = Utf8 Ljava/security/CodeSource; 
.const [178] = Utf8 pc 
.const [179] = Utf8 Ljava/security/PermissionCollection; 
.const [180] = Utf8 classLoader 
.const [181] = Utf8 Ljava/lang/ClassLoader; 
.const [182] = Utf8 principals 
.const [183] = Utf8 [Ljava/security/Principal; 
.const [184] = Utf8 dynamicPermissionChecking 
.const [185] = Utf8 Z 
.const [186] = Utf8 Code 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Ljava/security/CodeSource;Ljava/security/PermissionCollection;)V 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Ljava/security/CodeSource;Ljava/security/PermissionCollection;Ljava/lang/ClassLoader;[Ljava/security/Principal;)V 
.const [191] = Utf8 getCodeSource 
.const [192] = Utf8 ()Ljava/security/CodeSource; 
.const [193] = Utf8 getPermissions 
.const [194] = Utf8 ()Ljava/security/PermissionCollection; 
.const [195] = Utf8 getPrincipals 
.const [196] = Utf8 ()[Ljava/security/Principal; 
.const [197] = Utf8 getClassLoader 
.const [198] = Utf8 ()Ljava/lang/ClassLoader; 
.const [199] = Utf8 implies 
.const [200] = Utf8 (Ljava/security/Permission;)Z 
.const [201] = Utf8 toString 
.const [202] = Utf8 ()Ljava/lang/String; 
.end class 
