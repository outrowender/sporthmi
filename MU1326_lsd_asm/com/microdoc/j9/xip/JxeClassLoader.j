.version 50 0 
.class public final super [239] 
.super [241] 
.field private final [242] [243] 
.field private final [244] [245] 
.field private final [246] [247] 
.field private final [248] [249] 
.field private final [250] [251] 
.field private static [252] [253] 

.method static [255] : [256] 
    .attribute [254] .code stack 2 locals 0 
L0:     new [44] 
L3:     dup 
L4:     invokespecial [36] 
L7:     putstatic [37] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [254] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [38] 
L5:     aload_0 
L6:     aload_1 
L7:     putfield [45] 
L10:    aload_0 
L11:    aload_2 
L12:    putfield [46] 
L15:    aload_0 
L16:    aload_3 
L17:    invokevirtual [20] 
L20:    ifeq L30 
L23:    aload_3 
L24:    invokevirtual [21] 
L27:    goto L31 
L30:    aconst_null 
L31:    putfield [47] 
L34:    aload_0 
L35:    aload_3 
L36:    invokevirtual [23] 
L39:    putfield [48] 
L42:    aload_0 
L43:    aload 4 
L45:    putfield [49] 
L48:    aload_0 
L49:    getfield [19] 
L52:    invokevirtual [26] 
L55:    aload_0 
L56:    getfield [22] 
L59:    ifnull L77 
L62:    getstatic [5] 
L65:    aload_0 
L66:    getfield [24] 
L69:    aload_0 
L70:    getfield [22] 
L73:    invokevirtual [27] 
L76:    pop 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [254] .code stack 3 locals 2 
        .catch [8] from L0 to L7 using L8 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [39] 
L5:     astore_2 
L6:     aload_2 
L7:     areturn 
L8:     astore_2 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [28] 
L14:    astore_3 
L15:    aload_3 
L16:    ifnull L21 
L19:    aload_3 
L20:    areturn 
L21:    aload_0 
L22:    getfield [18] 
L25:    aload_1 
L26:    aload_0 
L27:    invokevirtual [29] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [254] .code stack 6 locals 6 
        .catch [8] from L0 to L7 using L8 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [39] 
L5:     astore_2 
L6:     aload_2 
L7:     areturn 
L8:     astore_2 
L9:     aload_0 
L10:    getfield [24] 
L13:    aload_1 
L14:    invokestatic [10] 
L17:    astore_3 
L18:    aload_3 
L19:    ifnull L118 
L22:    aconst_null 
L23:    astore 4 
        .catch [17] from L25 to L53 using L56 
L25:    new [50] 
L28:    dup 
L29:    new [51] 
L32:    dup 
L33:    ldc [14] 
L35:    invokespecial [40] 
L38:    aload_0 
L39:    getfield [25] 
L42:    invokevirtual [30] 
L45:    invokevirtual [31] 
L48:    invokespecial [41] 
L51:    astore 4 
L53:    goto L58 
L56:    astore 5 
L58:    new [52] 
L61:    dup 
L62:    aload 4 
L64:    aconst_null 
L65:    invokespecial [42] 
L68:    astore 5 
L70:    new [53] 
L73:    dup 
L74:    aload 5 
L76:    aconst_null 
L77:    invokespecial [43] 
L80:    astore 6 
L82:    aload_0 
L83:    aload_1 
L84:    aload_3 
L85:    iconst_0 
L86:    aload_3 
L87:    arraylength 
L88:    aload 6 
L90:    invokevirtual [32] 
L93:    astore 7 
L95:    aload_0 
L96:    getfield [22] 
L99:    ifnull L115 
L102:   getstatic [5] 
L105:   aload 7 
L107:   aload_0 
L108:   getfield [22] 
L111:   invokevirtual [27] 
L114:   pop 
L115:   aload 7 
L117:   areturn 
L118:   aconst_null 
L119:   areturn 
L120:   
    .end code 
.end method 

.method protected [263] : [264] 
    .attribute [254] .code stack 2 locals 0 
L0:     getstatic [5] 
L3:     invokevirtual [33] 
L6:     pop 
L7:     aload_0 
L8:     getfield [19] 
L11:    invokevirtual [34] 
L14:    aload_0 
L15:    getfield [18] 
L18:    aload_0 
L19:    getfield [24] 
L22:    invokevirtual [35] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [265] : [266] 
    .attribute [254] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [267] : [268] 
    .attribute [254] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = Class [55] 
.const [4] = Class [56] 
.const [5] = Field [57] [58] 
.const [6] = Class [59] 
.const [7] = Class [60] 
.const [8] = Class [61] 
.const [9] = Class [62] 
.const [10] = Method [63] [64] 
.const [11] = Class [65] 
.const [12] = Class [66] 
.const [13] = Class [67] 
.const [14] = String [68] 
.const [15] = Class [69] 
.const [16] = Class [70] 
.const [17] = Class [71] 
.const [18] = Field [72] [73] 
.const [19] = Field [74] [75] 
.const [20] = Method [76] [77] 
.const [21] = Method [78] [79] 
.const [22] = Field [80] [81] 
.const [23] = Method [82] [83] 
.const [24] = Field [84] [85] 
.const [25] = Field [86] [87] 
.const [26] = Method [88] [89] 
.const [27] = Method [90] [91] 
.const [28] = Method [92] [93] 
.const [29] = Method [94] [95] 
.const [30] = Method [96] [97] 
.const [31] = Method [98] [99] 
.const [32] = Method [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Method [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Field [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Method [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Method [122] [123] 
.const [44] = Class [124] 
.const [45] = Field [125] [126] 
.const [46] = Field [127] [128] 
.const [47] = Field [129] [130] 
.const [48] = Field [131] [132] 
.const [49] = Field [133] [134] 
.const [50] = Class [135] 
.const [51] = Class [136] 
.const [52] = Class [137] 
.const [53] = Class [138] 
.const [54] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [55] = Utf8 java/lang/ClassLoader 
.const [56] = Utf8 java/util/WeakHashMap 
.const [57] = Class [139] 
.const [58] = NameAndType [140] [141] 
.const [59] = Utf8 com/microdoc/j9/xip/JxeData 
.const [60] = Utf8 com/microdoc/j9/xip/Archive 
.const [61] = Utf8 java/lang/ClassNotFoundException 
.const [62] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [63] = Class [142] 
.const [64] = NameAndType [143] [144] 
.const [65] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [66] = Utf8 java/net/URL 
.const [67] = Utf8 java/lang/StringBuffer 
.const [68] = Utf8 'jxe://' 
.const [69] = Utf8 java/security/CodeSource 
.const [70] = Utf8 java/security/ProtectionDomain 
.const [71] = Utf8 java/net/MalformedURLException 
.const [72] = Class [145] 
.const [73] = NameAndType [146] [147] 
.const [74] = Class [148] 
.const [75] = NameAndType [149] [150] 
.const [76] = Class [151] 
.const [77] = NameAndType [152] [153] 
.const [78] = Class [154] 
.const [79] = NameAndType [155] [156] 
.const [80] = Class [157] 
.const [81] = NameAndType [158] [159] 
.const [82] = Class [160] 
.const [83] = NameAndType [161] [162] 
.const [84] = Class [163] 
.const [85] = NameAndType [164] [165] 
.const [86] = Class [166] 
.const [87] = NameAndType [167] [168] 
.const [88] = Class [169] 
.const [89] = NameAndType [170] [171] 
.const [90] = Class [172] 
.const [91] = NameAndType [173] [174] 
.const [92] = Class [175] 
.const [93] = NameAndType [176] [177] 
.const [94] = Class [178] 
.const [95] = NameAndType [179] [180] 
.const [96] = Class [181] 
.const [97] = NameAndType [182] [183] 
.const [98] = Class [184] 
.const [99] = NameAndType [185] [186] 
.const [100] = Class [187] 
.const [101] = NameAndType [188] [189] 
.const [102] = Class [190] 
.const [103] = NameAndType [191] [192] 
.const [104] = Class [193] 
.const [105] = NameAndType [194] [195] 
.const [106] = Class [196] 
.const [107] = NameAndType [197] [198] 
.const [108] = Class [199] 
.const [109] = NameAndType [200] [201] 
.const [110] = Class [202] 
.const [111] = NameAndType [203] [204] 
.const [112] = Class [205] 
.const [113] = NameAndType [206] [207] 
.const [114] = Class [208] 
.const [115] = NameAndType [209] [210] 
.const [116] = Class [211] 
.const [117] = NameAndType [212] [213] 
.const [118] = Class [214] 
.const [119] = NameAndType [215] [216] 
.const [120] = Class [217] 
.const [121] = NameAndType [218] [219] 
.const [122] = Class [220] 
.const [123] = NameAndType [221] [222] 
.const [124] = Utf8 java/util/WeakHashMap 
.const [125] = Class [223] 
.const [126] = NameAndType [224] [225] 
.const [127] = Class [226] 
.const [128] = NameAndType [227] [228] 
.const [129] = Class [229] 
.const [130] = NameAndType [230] [231] 
.const [131] = Class [232] 
.const [132] = NameAndType [233] [234] 
.const [133] = Class [235] 
.const [134] = NameAndType [236] [237] 
.const [135] = Utf8 java/net/URL 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 java/security/CodeSource 
.const [138] = Utf8 java/security/ProtectionDomain 
.const [139] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [140] = Utf8 sAllocations 
.const [141] = Utf8 Ljava/util/WeakHashMap; 
.const [142] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [143] = Utf8 getRomClass 
.const [144] = Utf8 (Lcom/ibm/oti/vm/Jxe;Ljava/lang/String;)[B 
.const [145] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [146] = Utf8 fParent 
.const [147] = Utf8 Lcom/microdoc/j9/xip/XIPClassLoader; 
.const [148] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [149] = Utf8 fArchive 
.const [150] = Utf8 Lcom/microdoc/j9/xip/Archive; 
.const [151] = Utf8 com/microdoc/j9/xip/JxeData 
.const [152] = Utf8 isAllocated 
.const [153] = Utf8 ()Z 
.const [154] = Utf8 com/microdoc/j9/xip/JxeData 
.const [155] = Utf8 unloader 
.const [156] = Utf8 ()Lcom/microdoc/j9/xip/JxeDataUnloader; 
.const [157] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [158] = Utf8 fJxeDataUnloader 
.const [159] = Utf8 Lcom/microdoc/j9/xip/JxeDataUnloader; 
.const [160] = Utf8 com/microdoc/j9/xip/JxeData 
.const [161] = Utf8 getJxe 
.const [162] = Utf8 ()Lcom/ibm/oti/vm/Jxe; 
.const [163] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [164] = Utf8 fJxe 
.const [165] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [166] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [167] = Utf8 fJxeName 
.const [168] = Utf8 Ljava/lang/String; 
.const [169] = Utf8 com/microdoc/j9/xip/Archive 
.const [170] = Utf8 addRef 
.const [171] = Utf8 ()V 
.const [172] = Utf8 java/util/WeakHashMap 
.const [173] = Utf8 put 
.const [174] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [175] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [176] = Utf8 loadClassFromJxe 
.const [177] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [178] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [179] = Utf8 loadClassFromJxe 
.const [180] = Utf8 (Ljava/lang/String;Lcom/microdoc/j9/xip/JxeClassLoader;)Ljava/lang/Class; 
.const [181] = Utf8 java/lang/StringBuffer 
.const [182] = Utf8 append 
.const [183] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [184] = Utf8 java/lang/StringBuffer 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [188] = Utf8 defineClass 
.const [189] = Utf8 (Ljava/lang/String;[BIILjava/security/ProtectionDomain;)Ljava/lang/Class; 
.const [190] = Utf8 java/util/WeakHashMap 
.const [191] = Utf8 size 
.const [192] = Utf8 ()I 
.const [193] = Utf8 com/microdoc/j9/xip/Archive 
.const [194] = Utf8 release 
.const [195] = Utf8 ()V 
.const [196] = Utf8 com/microdoc/j9/xip/XIPClassLoader 
.const [197] = Utf8 freeJxeSegment 
.const [198] = Utf8 (Lcom/ibm/oti/vm/Jxe;)V 
.const [199] = Utf8 java/util/WeakHashMap 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [203] = Utf8 sAllocations 
.const [204] = Utf8 Ljava/util/WeakHashMap; 
.const [205] = Utf8 java/lang/ClassLoader 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Ljava/lang/ClassLoader;)V 
.const [208] = Utf8 java/lang/ClassLoader 
.const [209] = Utf8 loadClass 
.const [210] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [211] = Utf8 java/lang/StringBuffer 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Ljava/lang/String;)V 
.const [214] = Utf8 java/net/URL 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Ljava/lang/String;)V 
.const [217] = Utf8 java/security/CodeSource 
.const [218] = Utf8 <init> 
.const [219] = Utf8 (Ljava/net/URL;[Ljava/security/cert/Certificate;)V 
.const [220] = Utf8 java/security/ProtectionDomain 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Ljava/security/CodeSource;Ljava/security/PermissionCollection;)V 
.const [223] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [224] = Utf8 fParent 
.const [225] = Utf8 Lcom/microdoc/j9/xip/XIPClassLoader; 
.const [226] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [227] = Utf8 fArchive 
.const [228] = Utf8 Lcom/microdoc/j9/xip/Archive; 
.const [229] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [230] = Utf8 fJxeDataUnloader 
.const [231] = Utf8 Lcom/microdoc/j9/xip/JxeDataUnloader; 
.const [232] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [233] = Utf8 fJxe 
.const [234] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [235] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [236] = Utf8 fJxeName 
.const [237] = Utf8 Ljava/lang/String; 
.const [238] = Utf8 com/microdoc/j9/xip/JxeClassLoader 
.const [239] = Class [238] 
.const [240] = Utf8 java/lang/ClassLoader 
.const [241] = Class [240] 
.const [242] = Utf8 fJxeDataUnloader 
.const [243] = Utf8 Lcom/microdoc/j9/xip/JxeDataUnloader; 
.const [244] = Utf8 fJxe 
.const [245] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [246] = Utf8 fJxeName 
.const [247] = Utf8 Ljava/lang/String; 
.const [248] = Utf8 fArchive 
.const [249] = Utf8 Lcom/microdoc/j9/xip/Archive; 
.const [250] = Utf8 fParent 
.const [251] = Utf8 Lcom/microdoc/j9/xip/XIPClassLoader; 
.const [252] = Utf8 sAllocations 
.const [253] = Utf8 Ljava/util/WeakHashMap; 
.const [254] = Utf8 Code 
.const [255] = Utf8 <clinit> 
.const [256] = Utf8 ()V 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Lcom/microdoc/j9/xip/XIPClassLoader;Lcom/microdoc/j9/xip/Archive;Lcom/microdoc/j9/xip/JxeData;Ljava/lang/String;)V 
.const [259] = Utf8 loadClass 
.const [260] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [261] = Utf8 loadClassFromJxe 
.const [262] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [263] = Utf8 finalize 
.const [264] = Utf8 ()V 
.const [265] = Utf8 getJxeName 
.const [266] = Utf8 ()Ljava/lang/String; 
.const [267] = Utf8 toString 
.const [268] = Utf8 ()Ljava/lang/String; 
.end class 
