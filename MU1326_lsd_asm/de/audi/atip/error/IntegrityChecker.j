.version 50 0 
.class public super [251] 
.super [253] 
.field private final [254] [255] 

.method public [257] : [258] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [44] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [53] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [256] .code stack 3 locals 5 
L0:     new [54] 
L3:     dup 
L4:     invokespecial [45] 
L7:     astore_1 
        .catch [12] from L8 to L135 using L138 
L8:     ldc [3] 
L10:    aload_0 
L11:    getfield [31] 
L14:    invokeinterface [55] 0 
L19:    invokeinterface [56] 0 
L24:    invokevirtual [32] 
L27:    ifeq L41 
L30:    getstatic [4] 
L33:    ldc [5] 
L35:    invokevirtual [33] 
L38:    goto L135 
L41:    aload_0 
L42:    getfield [31] 
L45:    invokeinterface [55] 0 
L50:    invokeinterface [56] 0 
L55:    astore_2 
L56:    aload_0 
L57:    ldc [6] 
L59:    invokespecial [46] 
L62:    astore_3 
L63:    aload_2 
L64:    aload_3 
L65:    invokevirtual [32] 
L68:    ifne L86 
L71:    aload_0 
L72:    ldc [7] 
L74:    invokespecial [47] 
L77:    aload_1 
L78:    ldc [8] 
L80:    invokeinterface [57] 0 
L85:    pop 
L86:    aload_0 
L87:    getfield [31] 
L90:    invokeinterface [55] 0 
L95:    invokeinterface [58] 0 
L100:   astore 4 
L102:   aload_0 
L103:   ldc [9] 
L105:   invokespecial [46] 
L108:   astore 5 
L110:   aload 4 
L112:   aload 5 
L114:   invokevirtual [32] 
L117:   ifne L135 
L120:   aload_0 
L121:   ldc [10] 
L123:   invokespecial [47] 
L126:   aload_1 
L127:   ldc [11] 
L129:   invokeinterface [57] 0 
L134:   pop 
L135:   goto L167 
L138:   astore_2 
L139:   getstatic [4] 
L142:   new [59] 
L145:   dup 
L146:   invokespecial [48] 
L149:   ldc [14] 
L151:   invokevirtual [34] 
L154:   aload_2 
L155:   invokevirtual [35] 
L158:   invokevirtual [34] 
L161:   invokevirtual [36] 
L164:   invokevirtual [33] 
L167:   aload_1 
L168:   aload_1 
L169:   invokeinterface [60] 0 
L174:   anewarray [15] 
L177:   invokeinterface [62] 0 
L182:   checkcast [16] 
L185:   checkcast [16] 
L188:   areturn 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method private [261] : [262] 
    .attribute [256] .code stack 3 locals 0 
L0:     getstatic [4] 
L3:     ldc [17] 
L5:     invokevirtual [33] 
L8:     getstatic [4] 
L11:    new [59] 
L14:    dup 
L15:    invokespecial [48] 
L18:    ldc [14] 
L20:    invokevirtual [34] 
L23:    aload_1 
L24:    invokevirtual [34] 
L27:    invokevirtual [36] 
L30:    invokevirtual [33] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [263] : [264] 
    .attribute [256] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     invokevirtual [37] 
L7:     ifnull L20 
L10:    aload_0 
L11:    invokespecial [49] 
L14:    invokevirtual [37] 
L17:    goto L23 
L20:    invokestatic [18] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method private [265] : [266] 
    .attribute [256] .code stack 3 locals 6 
L0:     ldc [3] 
L2:     astore_2 
L3:     aconst_null 
L4:     astore_3 
L5:     aconst_null 
L6:     astore 4 
L8:     aload_0 
L9:     invokespecial [50] 
L12:    aload_1 
L13:    invokevirtual [38] 
L16:    astore_3 
L17:    new [63] 
L20:    dup 
L21:    aload_3 
L22:    invokespecial [51] 
L25:    astore 4 
L27:    aload 4 
L29:    invokevirtual [39] 
L32:    bipush 32 
L34:    if_icmpne L60 
L37:    bipush 32 
L39:    newarray byte 
L41:    astore 5 
L43:    aload 4 
L45:    aload 5 
L47:    invokevirtual [40] 
L50:    new [61] 
L53:    dup 
L54:    aload 5 
L56:    invokespecial [52] 
L59:    astore_2 
        .catch [12] from L60 to L78 using L81 
        .catch [12] from L8 to L60 using L91 
L60:    aload_3 
L61:    ifnull L68 
L64:    aload_3 
L65:    invokevirtual [41] 
L68:    aload 4 
L70:    ifnull L78 
L73:    aload 4 
L75:    invokevirtual [42] 
L78:    goto L187 
L81:    astore 5 
L83:    aload 5 
L85:    invokevirtual [43] 
L88:    goto L187 
L91:    astore 5 
L93:    getstatic [4] 
L96:    new [59] 
L99:    dup 
L100:   invokespecial [48] 
L103:   ldc [14] 
L105:   invokevirtual [34] 
L108:   aload_1 
L109:   invokevirtual [34] 
L112:   ldc [20] 
L114:   invokevirtual [34] 
L117:   invokevirtual [36] 
L120:   invokevirtual [33] 
        .catch [12] from L123 to L141 using L144 
        .catch [0] from L8 to L60 using L154 
        .catch [0] from L91 to L123 using L154 
L123:   aload_3 
L124:   ifnull L131 
L127:   aload_3 
L128:   invokevirtual [41] 
L131:   aload 4 
L133:   ifnull L141 
L136:   aload 4 
L138:   invokevirtual [42] 
L141:   goto L187 
L144:   astore 5 
L146:   aload 5 
L148:   invokevirtual [43] 
L151:   goto L187 
L154:   astore 6 
        .catch [12] from L156 to L174 using L177 
        .catch [0] from L154 to L156 using L154 
L156:   aload_3 
L157:   ifnull L164 
L160:   aload_3 
L161:   invokevirtual [41] 
L164:   aload 4 
L166:   ifnull L174 
L169:   aload 4 
L171:   invokevirtual [42] 
L174:   goto L184 
L177:   astore 7 
L179:   aload 7 
L181:   invokevirtual [43] 
L184:   aload 6 
L186:   athrow 
L187:   aload_2 
L188:   areturn 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [64] 
.const [3] = String [65] 
.const [4] = Field [66] [67] 
.const [5] = String [68] 
.const [6] = String [69] 
.const [7] = String [70] 
.const [8] = String [71] 
.const [9] = String [72] 
.const [10] = String [73] 
.const [11] = String [74] 
.const [12] = Class [75] 
.const [13] = Class [76] 
.const [14] = String [77] 
.const [15] = Class [78] 
.const [16] = Class [79] 
.const [17] = String [80] 
.const [18] = Method [81] [82] 
.const [19] = Class [83] 
.const [20] = String [84] 
.const [21] = Class [85] 
.const [22] = Class [86] 
.const [23] = Class [87] 
.const [24] = Class [88] 
.const [25] = Class [89] 
.const [26] = Class [90] 
.const [27] = Class [91] 
.const [28] = Class [92] 
.const [29] = Class [93] 
.const [30] = Class [94] 
.const [31] = Field [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Method [123] [124] 
.const [46] = Method [125] [126] 
.const [47] = Method [127] [128] 
.const [48] = Method [129] [130] 
.const [49] = Method [131] [132] 
.const [50] = Method [133] [134] 
.const [51] = Method [135] [136] 
.const [52] = Method [137] [138] 
.const [53] = Field [139] [140] 
.const [54] = Class [141] 
.const [55] = InterfaceMethod [142] [143] 
.const [56] = InterfaceMethod [144] [145] 
.const [57] = InterfaceMethod [146] [147] 
.const [58] = InterfaceMethod [148] [149] 
.const [59] = Class [150] 
.const [60] = InterfaceMethod [151] [152] 
.const [61] = Class [153] 
.const [62] = InterfaceMethod [154] [155] 
.const [63] = Class [156] 
.const [64] = Utf8 java/util/ArrayList 
.const [65] = Utf8 '' 
.const [66] = Class [157] 
.const [67] = NameAndType [158] [159] 
.const [68] = Utf8 'HMI-IntegrityChecker: ZIP started, do not check the integrity' 
.const [69] = Utf8 'checksum_diag_jar.md5' 
.const [70] = Utf8 'diag.jar MD5 differs from builtin MD5, update your diag.jar !!!' 
.const [71] = Utf8 'diag.jar wrong version!' 
.const [72] = Utf8 'checksum_lang_data.md5' 
.const [73] = Utf8 'lang_data.zip MD5 differs from builtin MD5, update your lang_data.zip!' 
.const [74] = Utf8 'lang_data.zip wrong version!' 
.const [75] = Utf8 java/lang/Exception 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Utf8 'HMI-IntegrityChecker[ERROR]: ' 
.const [78] = Utf8 java/lang/String 
.const [79] = Utf8 [Ljava/lang/String; 
.const [80] = Utf8 '[ERROR] ######## HMI integrity check fails ###########' 
.const [81] = Class [160] 
.const [82] = NameAndType [161] [162] 
.const [83] = Utf8 java/io/DataInputStream 
.const [84] = Utf8 ' is not in the class path or does not contain md5 file!' 
.const [85] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [88] = Utf8 de/audi/atip/base/IVersionInfo 
.const [89] = Utf8 java/lang/System 
.const [90] = Utf8 java/io/PrintStream 
.const [91] = Utf8 java/util/List 
.const [92] = Utf8 java/lang/Class 
.const [93] = Utf8 java/lang/ClassLoader 
.const [94] = Utf8 java/io/InputStream 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Class [175] 
.const [104] = NameAndType [176] [177] 
.const [105] = Class [178] 
.const [106] = NameAndType [179] [180] 
.const [107] = Class [181] 
.const [108] = NameAndType [182] [183] 
.const [109] = Class [184] 
.const [110] = NameAndType [185] [186] 
.const [111] = Class [187] 
.const [112] = NameAndType [188] [189] 
.const [113] = Class [190] 
.const [114] = NameAndType [191] [192] 
.const [115] = Class [193] 
.const [116] = NameAndType [194] [195] 
.const [117] = Class [196] 
.const [118] = NameAndType [197] [198] 
.const [119] = Class [199] 
.const [120] = NameAndType [200] [201] 
.const [121] = Class [202] 
.const [122] = NameAndType [203] [204] 
.const [123] = Class [205] 
.const [124] = NameAndType [206] [207] 
.const [125] = Class [208] 
.const [126] = NameAndType [209] [210] 
.const [127] = Class [211] 
.const [128] = NameAndType [212] [213] 
.const [129] = Class [214] 
.const [130] = NameAndType [215] [216] 
.const [131] = Class [217] 
.const [132] = NameAndType [218] [219] 
.const [133] = Class [220] 
.const [134] = NameAndType [221] [222] 
.const [135] = Class [223] 
.const [136] = NameAndType [224] [225] 
.const [137] = Class [226] 
.const [138] = NameAndType [227] [228] 
.const [139] = Class [229] 
.const [140] = NameAndType [230] [231] 
.const [141] = Utf8 java/util/ArrayList 
.const [142] = Class [232] 
.const [143] = NameAndType [233] [234] 
.const [144] = Class [235] 
.const [145] = NameAndType [236] [237] 
.const [146] = Class [238] 
.const [147] = NameAndType [239] [240] 
.const [148] = Class [241] 
.const [149] = NameAndType [242] [243] 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Class [244] 
.const [152] = NameAndType [245] [246] 
.const [153] = Utf8 java/lang/String 
.const [154] = Class [247] 
.const [155] = NameAndType [248] [249] 
.const [156] = Utf8 java/io/DataInputStream 
.const [157] = Utf8 java/lang/System 
.const [158] = Utf8 out 
.const [159] = Utf8 Ljava/io/PrintStream; 
.const [160] = Utf8 java/lang/ClassLoader 
.const [161] = Utf8 getSystemClassLoader 
.const [162] = Utf8 ()Ljava/lang/ClassLoader; 
.const [163] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [164] = Utf8 fw 
.const [165] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [166] = Utf8 java/lang/String 
.const [167] = Utf8 equals 
.const [168] = Utf8 (Ljava/lang/Object;)Z 
.const [169] = Utf8 java/io/PrintStream 
.const [170] = Utf8 println 
.const [171] = Utf8 (Ljava/lang/String;)V 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 append 
.const [174] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [175] = Utf8 java/lang/Exception 
.const [176] = Utf8 getMessage 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 toString 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 java/lang/Class 
.const [182] = Utf8 getClassLoader 
.const [183] = Utf8 ()Ljava/lang/ClassLoader; 
.const [184] = Utf8 java/lang/ClassLoader 
.const [185] = Utf8 getResourceAsStream 
.const [186] = Utf8 (Ljava/lang/String;)Ljava/io/InputStream; 
.const [187] = Utf8 java/io/DataInputStream 
.const [188] = Utf8 available 
.const [189] = Utf8 ()I 
.const [190] = Utf8 java/io/DataInputStream 
.const [191] = Utf8 readFully 
.const [192] = Utf8 ([B)V 
.const [193] = Utf8 java/io/InputStream 
.const [194] = Utf8 close 
.const [195] = Utf8 ()V 
.const [196] = Utf8 java/io/DataInputStream 
.const [197] = Utf8 close 
.const [198] = Utf8 ()V 
.const [199] = Utf8 java/lang/Exception 
.const [200] = Utf8 printStackTrace 
.const [201] = Utf8 ()V 
.const [202] = Utf8 java/lang/Object 
.const [203] = Utf8 <init> 
.const [204] = Utf8 ()V 
.const [205] = Utf8 java/util/ArrayList 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [209] = Utf8 getFileContent 
.const [210] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [211] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [212] = Utf8 print 
.const [213] = Utf8 (Ljava/lang/String;)V 
.const [214] = Utf8 java/lang/StringBuffer 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 java/lang/Object 
.const [218] = Utf8 getClass 
.const [219] = Utf8 ()Ljava/lang/Class; 
.const [220] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [221] = Utf8 getResourceClassLoader 
.const [222] = Utf8 ()Ljava/lang/ClassLoader; 
.const [223] = Utf8 java/io/DataInputStream 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Ljava/io/InputStream;)V 
.const [226] = Utf8 java/lang/String 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ([B)V 
.const [229] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [230] = Utf8 fw 
.const [231] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [232] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [233] = Utf8 getVersionInfo 
.const [234] = Utf8 ()Lde/audi/atip/base/IVersionInfo; 
.const [235] = Utf8 de/audi/atip/base/IVersionInfo 
.const [236] = Utf8 getDiagChecksum 
.const [237] = Utf8 ()Ljava/lang/String; 
.const [238] = Utf8 java/util/List 
.const [239] = Utf8 add 
.const [240] = Utf8 (Ljava/lang/Object;)Z 
.const [241] = Utf8 de/audi/atip/base/IVersionInfo 
.const [242] = Utf8 getLangDataChecksum 
.const [243] = Utf8 ()Ljava/lang/String; 
.const [244] = Utf8 java/util/List 
.const [245] = Utf8 size 
.const [246] = Utf8 ()I 
.const [247] = Utf8 java/util/List 
.const [248] = Utf8 toArray 
.const [249] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [250] = Utf8 de/audi/atip/error/IntegrityChecker 
.const [251] = Class [250] 
.const [252] = Utf8 java/lang/Object 
.const [253] = Class [252] 
.const [254] = Utf8 fw 
.const [255] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [256] = Utf8 Code 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [259] = Utf8 getTargetIntegrityInfo 
.const [260] = Utf8 ()[Ljava/lang/String; 
.const [261] = Utf8 print 
.const [262] = Utf8 (Ljava/lang/String;)V 
.const [263] = Utf8 getResourceClassLoader 
.const [264] = Utf8 ()Ljava/lang/ClassLoader; 
.const [265] = Utf8 getFileContent 
.const [266] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.end class 
