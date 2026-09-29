.version 50 0 
.class public super abstract [193] 
.super [195] 
.field private static final [196] [197] 
.field static [198] [199] 

.method protected annotation [201] : [202] 
    .attribute [200] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [203] : [204] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [39] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [205] : [206] 
    .attribute [200] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [40] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [207] : [208] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [209] : [210] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [211] : [212] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [200] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     astore_2 
L5:     goto L36 
L8:     aload_2 
L9:     invokeinterface [43] 0 
L14:    checkcast [3] 
L17:    astore_3 
L18:    aload_3 
L19:    invokevirtual [28] 
L22:    aload_1 
L23:    invokeinterface [44] 0 
L28:    invokevirtual [29] 
L31:    ifeq L36 
L34:    aload_3 
L35:    areturn 
L36:    aload_2 
L37:    invokeinterface [45] 0 
L42:    ifne L8 
L45:    aconst_null 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public abstract [215] : [216] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [217] : [218] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected static [219] : [220] 
    .attribute [200] .code stack 2 locals 1 
L0:     invokestatic [8] 
L3:     astore_1 
L4:     aload_1 
L5:     ifnull L14 
L8:     aload_1 
L9:     ldc [9] 
L11:    invokevirtual [30] 
L14:    aload_0 
L15:    putstatic [41] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public abstract [221] : [222] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [200] .code stack 3 locals 1 
L0:     new [46] 
L3:     dup 
L4:     ldc [13] 
L6:     invokespecial [42] 
L9:     aload_0 
L10:    invokevirtual [31] 
L13:    invokevirtual [32] 
L16:    invokevirtual [33] 
L19:    astore_1 
L20:    aload_0 
L21:    invokevirtual [34] 
L24:    ifnull L57 
L27:    new [46] 
L30:    dup 
L31:    aload_1 
L32:    invokestatic [14] 
L35:    invokespecial [42] 
L38:    ldc [15] 
L40:    invokevirtual [32] 
L43:    aload_0 
L44:    invokevirtual [34] 
L47:    invokevirtual [31] 
L50:    invokevirtual [32] 
L53:    invokevirtual [33] 
L56:    astore_1 
L57:    new [46] 
L60:    dup 
L61:    aload_1 
L62:    invokestatic [14] 
L65:    invokespecial [42] 
L68:    ldc [16] 
L70:    invokevirtual [32] 
L73:    aload_0 
L74:    invokevirtual [35] 
L77:    invokevirtual [36] 
L80:    invokevirtual [33] 
L83:    astore_1 
L84:    aload_1 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public static [225] : [226] 
    .attribute [200] .code stack 1 locals 2 
L0:     getstatic [11] 
L3:     ifnull L10 
L6:     getstatic [11] 
L9:     areturn 
L10:    ldc [17] 
L12:    invokestatic [19] 
L15:    invokestatic [21] 
L18:    checkcast [6] 
L21:    astore_0 
L22:    aload_0 
L23:    ifnull L53 
        .catch [24] from L26 to L44 using L44 
        .catch [25] from L26 to L44 using L48 
        .catch [26] from L26 to L44 using L52 
L26:    aload_0 
L27:    invokestatic [23] 
L30:    astore_1 
L31:    aload_1 
L32:    invokevirtual [37] 
L35:    checkcast [2] 
L38:    putstatic [41] 
L41:    goto L53 
L44:    pop 
L45:    goto L53 
L48:    pop 
L49:    goto L53 
L52:    pop 
L53:    getstatic [11] 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [47] 
.const [3] = Class [48] 
.const [4] = Class [49] 
.const [5] = Class [50] 
.const [6] = Class [51] 
.const [7] = Class [52] 
.const [8] = Method [53] [54] 
.const [9] = String [55] 
.const [10] = Class [56] 
.const [11] = Field [57] [58] 
.const [12] = Class [59] 
.const [13] = String [60] 
.const [14] = Method [61] [62] 
.const [15] = String [63] 
.const [16] = String [64] 
.const [17] = String [65] 
.const [18] = Class [66] 
.const [19] = Method [67] [68] 
.const [20] = Class [69] 
.const [21] = Method [70] [71] 
.const [22] = Class [72] 
.const [23] = Method [73] [74] 
.const [24] = Class [75] 
.const [25] = Class [76] 
.const [26] = Class [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Method [104] [105] 
.const [41] = Field [106] [107] 
.const [42] = Method [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = Class [116] 
.const [47] = Utf8 java/security/IdentityScope 
.const [48] = Utf8 java/security/Identity 
.const [49] = Utf8 java/util/Enumeration 
.const [50] = Utf8 java/security/Principal 
.const [51] = Utf8 java/lang/String 
.const [52] = Utf8 java/lang/System 
.const [53] = Class [117] 
.const [54] = NameAndType [118] [119] 
.const [55] = Utf8 setSystemScope 
.const [56] = Utf8 java/lang/SecurityManager 
.const [57] = Class [120] 
.const [58] = NameAndType [121] [122] 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Name : ' 
.const [61] = Class [123] 
.const [62] = NameAndType [124] [125] 
.const [63] = Utf8 '\nScope name : ' 
.const [64] = Utf8 '\nNumber of identities : ' 
.const [65] = Utf8 'system.scope' 
.const [66] = Utf8 com/ibm/oti/util/PriviAction 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Utf8 java/security/AccessController 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Utf8 java/lang/Class 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Utf8 java/lang/ClassNotFoundException 
.const [76] = Utf8 java/lang/IllegalAccessException 
.const [77] = Utf8 java/lang/InstantiationException 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Class [183] 
.const [111] = NameAndType [184] [185] 
.const [112] = Class [186] 
.const [113] = NameAndType [187] [188] 
.const [114] = Class [189] 
.const [115] = NameAndType [190] [191] 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 java/lang/System 
.const [118] = Utf8 getSecurityManager 
.const [119] = Utf8 ()Ljava/lang/SecurityManager; 
.const [120] = Utf8 java/security/IdentityScope 
.const [121] = Utf8 systemScope 
.const [122] = Utf8 Ljava/security/IdentityScope; 
.const [123] = Utf8 java/lang/String 
.const [124] = Utf8 valueOf 
.const [125] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [126] = Utf8 com/ibm/oti/util/PriviAction 
.const [127] = Utf8 getSecurityProperty 
.const [128] = Utf8 (Ljava/lang/String;)Ljava/security/PrivilegedAction; 
.const [129] = Utf8 java/security/AccessController 
.const [130] = Utf8 doPrivileged 
.const [131] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [132] = Utf8 java/lang/Class 
.const [133] = Utf8 forName 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [135] = Utf8 java/security/IdentityScope 
.const [136] = Utf8 identities 
.const [137] = Utf8 ()Ljava/util/Enumeration; 
.const [138] = Utf8 java/security/Identity 
.const [139] = Utf8 getName 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 java/lang/String 
.const [142] = Utf8 equals 
.const [143] = Utf8 (Ljava/lang/Object;)Z 
.const [144] = Utf8 java/lang/SecurityManager 
.const [145] = Utf8 checkSecurityAccess 
.const [146] = Utf8 (Ljava/lang/String;)V 
.const [147] = Utf8 java/security/IdentityScope 
.const [148] = Utf8 getName 
.const [149] = Utf8 ()Ljava/lang/String; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 toString 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 java/security/IdentityScope 
.const [157] = Utf8 getScope 
.const [158] = Utf8 ()Ljava/security/IdentityScope; 
.const [159] = Utf8 java/security/IdentityScope 
.const [160] = Utf8 size 
.const [161] = Utf8 ()I 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 append 
.const [164] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [165] = Utf8 java/lang/Class 
.const [166] = Utf8 newInstance 
.const [167] = Utf8 ()Ljava/lang/Object; 
.const [168] = Utf8 java/security/Identity 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 java/security/Identity 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;)V 
.const [174] = Utf8 java/security/Identity 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;Ljava/security/IdentityScope;)V 
.const [177] = Utf8 java/security/IdentityScope 
.const [178] = Utf8 systemScope 
.const [179] = Utf8 Ljava/security/IdentityScope; 
.const [180] = Utf8 java/lang/StringBuffer 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Ljava/lang/String;)V 
.const [183] = Utf8 java/util/Enumeration 
.const [184] = Utf8 nextElement 
.const [185] = Utf8 ()Ljava/lang/Object; 
.const [186] = Utf8 java/security/Principal 
.const [187] = Utf8 getName 
.const [188] = Utf8 ()Ljava/lang/String; 
.const [189] = Utf8 java/util/Enumeration 
.const [190] = Utf8 hasMoreElements 
.const [191] = Utf8 ()Z 
.const [192] = Utf8 java/security/IdentityScope 
.const [193] = Class [192] 
.const [194] = Utf8 java/security/Identity 
.const [195] = Class [194] 
.const [196] = Utf8 serialVersionUID 
.const [197] = Utf8 J 
.const [198] = Utf8 systemScope 
.const [199] = Utf8 Ljava/security/IdentityScope; 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Ljava/lang/String;)V 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Ljava/lang/String;Ljava/security/IdentityScope;)V 
.const [207] = Utf8 addIdentity 
.const [208] = Utf8 (Ljava/security/Identity;)V 
.const [209] = Utf8 removeIdentity 
.const [210] = Utf8 (Ljava/security/Identity;)V 
.const [211] = Utf8 identities 
.const [212] = Utf8 ()Ljava/util/Enumeration; 
.const [213] = Utf8 getIdentity 
.const [214] = Utf8 (Ljava/security/Principal;)Ljava/security/Identity; 
.const [215] = Utf8 getIdentity 
.const [216] = Utf8 (Ljava/security/PublicKey;)Ljava/security/Identity; 
.const [217] = Utf8 getIdentity 
.const [218] = Utf8 (Ljava/lang/String;)Ljava/security/Identity; 
.const [219] = Utf8 setSystemScope 
.const [220] = Utf8 (Ljava/security/IdentityScope;)V 
.const [221] = Utf8 size 
.const [222] = Utf8 ()I 
.const [223] = Utf8 toString 
.const [224] = Utf8 ()Ljava/lang/String; 
.const [225] = Utf8 getSystemScope 
.const [226] = Utf8 ()Ljava/security/IdentityScope; 
.end class 
