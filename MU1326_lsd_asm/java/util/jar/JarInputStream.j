.version 50 0 
.class public super [289] 
.super [291] 
.field private [292] [293] 
.field private [294] [295] 
.field private [296] [297] 
.field private [298] [299] 
.field private [300] [301] 
.field private [302] [303] 
.field private [304] [305] 

.method public [307] : [308] 
    .attribute [306] .code stack 5 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [41] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [50] 
L10:    iload_2 
L11:    ifeq L27 
L14:    aload_0 
L15:    new [51] 
L18:    dup 
L19:    ldc [5] 
L21:    invokespecial [42] 
L24:    putfield [52] 
L27:    aload_0 
L28:    aload_0 
L29:    invokevirtual [19] 
L32:    dup_x1 
L33:    putfield [53] 
L36:    ifnonnull L40 
L39:    return 
L40:    aload_0 
L41:    getfield [20] 
L44:    invokevirtual [21] 
L47:    invokevirtual [22] 
L50:    astore_3 
L51:    aload_3 
L52:    ldc [8] 
L54:    invokevirtual [23] 
L57:    ifeq L88 
L60:    aload_0 
L61:    aconst_null 
L62:    putfield [53] 
L65:    aload_0 
L66:    invokevirtual [24] 
L69:    aload_0 
L70:    aload_0 
L71:    invokevirtual [19] 
L74:    putfield [53] 
L77:    aload_0 
L78:    getfield [20] 
L81:    invokevirtual [21] 
L84:    invokevirtual [22] 
L87:    astore_3 
L88:    aload_3 
L89:    ldc [9] 
L91:    invokevirtual [23] 
L94:    ifeq L137 
L97:    aload_0 
L98:    aconst_null 
L99:    putfield [53] 
L102:   aload_0 
L103:   new [55] 
L106:   dup 
L107:   aload_0 
L108:   iload_2 
L109:   invokespecial [43] 
L112:   putfield [56] 
L115:   aload_0 
L116:   invokevirtual [24] 
L119:   iload_2 
L120:   ifeq L170 
L123:   aload_0 
L124:   getfield [18] 
L127:   aload_0 
L128:   getfield [25] 
L131:   invokevirtual [26] 
L134:   goto L170 
L137:   new [57] 
L140:   dup 
L141:   iconst_3 
L142:   invokespecial [44] 
L145:   astore 4 
L147:   aload 4 
L149:   getfield [27] 
L152:   ldc [12] 
L154:   aconst_null 
L155:   invokeinterface [58] 0 
L160:   pop 
L161:   aload_0 
L162:   getfield [20] 
L165:   aload 4 
L167:   invokevirtual [28] 
L170:   return 
L171:   nop 
L172:   
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [306] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [45] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [311] : [312] 
    .attribute [306] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [306] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     checkcast [6] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [315] : [316] 
    .attribute [306] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L9 
L7:     iconst_m1 
L8:     areturn 
L9:     aload_0 
L10:    aload_1 
L11:    iload_2 
L12:    iload_3 
L13:    invokespecial [46] 
L16:    istore 4 
L18:    aload_0 
L19:    getfield [30] 
L22:    ifnull L117 
L25:    aload_0 
L26:    getfield [17] 
L29:    ifne L117 
L32:    iload 4 
L34:    iconst_m1 
L35:    if_icmpne L106 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [50] 
L43:    aload_0 
L44:    getfield [31] 
L47:    ifeq L85 
L50:    aload_0 
L51:    getfield [18] 
L54:    aload_0 
L55:    getfield [32] 
L58:    invokevirtual [21] 
L61:    aload_0 
L62:    getfield [30] 
L65:    checkcast [14] 
L68:    invokevirtual [33] 
L71:    invokevirtual [34] 
L74:    aload_0 
L75:    getfield [18] 
L78:    invokevirtual [35] 
L81:    pop 
L82:    goto L117 
L85:    aload_0 
L86:    getfield [18] 
L89:    aload_0 
L90:    getfield [30] 
L93:    checkcast [15] 
L96:    aload_0 
L97:    getfield [32] 
L100:   invokevirtual [36] 
L103:   goto L117 
L106:   aload_0 
L107:   getfield [30] 
L110:   aload_1 
L111:   iload_2 
L112:   iload 4 
L114:   invokevirtual [37] 
L117:   iload 4 
L119:   areturn 
L120:   
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [306] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [50] 
L5:     aload_0 
L6:     getfield [20] 
L9:     ifnull L38 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [20] 
L17:    putfield [61] 
L20:    aload_0 
L21:    aconst_null 
L22:    putfield [53] 
L25:    aload_0 
L26:    getfield [32] 
L29:    aconst_null 
L30:    invokevirtual [28] 
L33:    aload_0 
L34:    getfield [32] 
L37:    areturn 
L38:    aload_0 
L39:    aload_0 
L40:    invokespecial [47] 
L43:    checkcast [6] 
L46:    putfield [61] 
L49:    aload_0 
L50:    getfield [32] 
L53:    ifnonnull L58 
L56:    aconst_null 
L57:    areturn 
L58:    aload_0 
L59:    getfield [18] 
L62:    ifnull L120 
L65:    aload_0 
L66:    aload_0 
L67:    getfield [32] 
L70:    invokevirtual [21] 
L73:    invokevirtual [22] 
L76:    ldc [8] 
L78:    invokevirtual [38] 
L81:    dup_x1 
L82:    putfield [60] 
L85:    ifeq L102 
L88:    aload_0 
L89:    new [62] 
L92:    dup 
L93:    invokespecial [48] 
L96:    putfield [59] 
L99:    goto L120 
L102:   aload_0 
L103:   aload_0 
L104:   getfield [18] 
L107:   aload_0 
L108:   getfield [32] 
L111:   invokevirtual [21] 
L114:   invokevirtual [39] 
L117:   putfield [59] 
L120:   aload_0 
L121:   getfield [32] 
L124:   areturn 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method protected [319] : [320] 
    .attribute [306] .code stack 3 locals 1 
L0:     new [54] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [49] 
L8:     astore_2 
L9:     aload_0 
L10:    getfield [25] 
L13:    ifnull L28 
L16:    aload_2 
L17:    aload_0 
L18:    getfield [25] 
L21:    aload_1 
L22:    invokevirtual [40] 
L25:    invokevirtual [28] 
L28:    aload_2 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = Class [64] 
.const [4] = Class [65] 
.const [5] = String [66] 
.const [6] = Class [67] 
.const [7] = Class [68] 
.const [8] = String [69] 
.const [9] = String [70] 
.const [10] = Class [71] 
.const [11] = Class [72] 
.const [12] = String [73] 
.const [13] = Class [74] 
.const [14] = Class [75] 
.const [15] = Class [76] 
.const [16] = Class [77] 
.const [17] = Field [78] [79] 
.const [18] = Field [80] [81] 
.const [19] = Method [82] [83] 
.const [20] = Field [84] [85] 
.const [21] = Method [86] [87] 
.const [22] = Method [88] [89] 
.const [23] = Method [90] [91] 
.const [24] = Method [92] [93] 
.const [25] = Field [94] [95] 
.const [26] = Method [96] [97] 
.const [27] = Field [98] [99] 
.const [28] = Method [100] [101] 
.const [29] = Method [102] [103] 
.const [30] = Field [104] [105] 
.const [31] = Field [106] [107] 
.const [32] = Field [108] [109] 
.const [33] = Method [110] [111] 
.const [34] = Method [112] [113] 
.const [35] = Method [114] [115] 
.const [36] = Method [116] [117] 
.const [37] = Method [118] [119] 
.const [38] = Method [120] [121] 
.const [39] = Method [122] [123] 
.const [40] = Method [124] [125] 
.const [41] = Method [126] [127] 
.const [42] = Method [128] [129] 
.const [43] = Method [130] [131] 
.const [44] = Method [132] [133] 
.const [45] = Method [134] [135] 
.const [46] = Method [136] [137] 
.const [47] = Method [138] [139] 
.const [48] = Method [140] [141] 
.const [49] = Method [142] [143] 
.const [50] = Field [144] [145] 
.const [51] = Class [146] 
.const [52] = Field [147] [148] 
.const [53] = Field [149] [150] 
.const [54] = Class [151] 
.const [55] = Class [152] 
.const [56] = Field [153] [154] 
.const [57] = Class [155] 
.const [58] = InterfaceMethod [156] [157] 
.const [59] = Field [158] [159] 
.const [60] = Field [160] [161] 
.const [61] = Field [162] [163] 
.const [62] = Class [164] 
.const [63] = Utf8 java/util/jar/JarInputStream 
.const [64] = Utf8 java/util/zip/ZipInputStream 
.const [65] = Utf8 java/util/jar/JarVerifier 
.const [66] = Utf8 JarInputStream 
.const [67] = Utf8 java/util/jar/JarEntry 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 META-INF/ 
.const [70] = Utf8 'META-INF/MANIFEST.MF' 
.const [71] = Utf8 java/util/jar/Manifest 
.const [72] = Utf8 java/util/jar/Attributes 
.const [73] = Utf8 hidden 
.const [74] = Utf8 java/util/Map 
.const [75] = Utf8 java/io/ByteArrayOutputStream 
.const [76] = Utf8 java/util/jar/JarVerifier$VerifierEntry 
.const [77] = Utf8 java/io/OutputStream 
.const [78] = Class [165] 
.const [79] = NameAndType [166] [167] 
.const [80] = Class [168] 
.const [81] = NameAndType [169] [170] 
.const [82] = Class [171] 
.const [83] = NameAndType [172] [173] 
.const [84] = Class [174] 
.const [85] = NameAndType [175] [176] 
.const [86] = Class [177] 
.const [87] = NameAndType [178] [179] 
.const [88] = Class [180] 
.const [89] = NameAndType [181] [182] 
.const [90] = Class [183] 
.const [91] = NameAndType [184] [185] 
.const [92] = Class [186] 
.const [93] = NameAndType [187] [188] 
.const [94] = Class [189] 
.const [95] = NameAndType [190] [191] 
.const [96] = Class [192] 
.const [97] = NameAndType [193] [194] 
.const [98] = Class [195] 
.const [99] = NameAndType [196] [197] 
.const [100] = Class [198] 
.const [101] = NameAndType [199] [200] 
.const [102] = Class [201] 
.const [103] = NameAndType [202] [203] 
.const [104] = Class [204] 
.const [105] = NameAndType [205] [206] 
.const [106] = Class [207] 
.const [107] = NameAndType [208] [209] 
.const [108] = Class [210] 
.const [109] = NameAndType [211] [212] 
.const [110] = Class [213] 
.const [111] = NameAndType [214] [215] 
.const [112] = Class [216] 
.const [113] = NameAndType [217] [218] 
.const [114] = Class [219] 
.const [115] = NameAndType [220] [221] 
.const [116] = Class [222] 
.const [117] = NameAndType [223] [224] 
.const [118] = Class [225] 
.const [119] = NameAndType [226] [227] 
.const [120] = Class [228] 
.const [121] = NameAndType [229] [230] 
.const [122] = Class [231] 
.const [123] = NameAndType [232] [233] 
.const [124] = Class [234] 
.const [125] = NameAndType [235] [236] 
.const [126] = Class [237] 
.const [127] = NameAndType [238] [239] 
.const [128] = Class [240] 
.const [129] = NameAndType [241] [242] 
.const [130] = Class [243] 
.const [131] = NameAndType [244] [245] 
.const [132] = Class [246] 
.const [133] = NameAndType [247] [248] 
.const [134] = Class [249] 
.const [135] = NameAndType [250] [251] 
.const [136] = Class [252] 
.const [137] = NameAndType [253] [254] 
.const [138] = Class [255] 
.const [139] = NameAndType [256] [257] 
.const [140] = Class [258] 
.const [141] = NameAndType [259] [260] 
.const [142] = Class [261] 
.const [143] = NameAndType [262] [263] 
.const [144] = Class [264] 
.const [145] = NameAndType [265] [266] 
.const [146] = Utf8 java/util/jar/JarVerifier 
.const [147] = Class [267] 
.const [148] = NameAndType [268] [269] 
.const [149] = Class [270] 
.const [150] = NameAndType [271] [272] 
.const [151] = Utf8 java/util/jar/JarEntry 
.const [152] = Utf8 java/util/jar/Manifest 
.const [153] = Class [273] 
.const [154] = NameAndType [274] [275] 
.const [155] = Utf8 java/util/jar/Attributes 
.const [156] = Class [276] 
.const [157] = NameAndType [277] [278] 
.const [158] = Class [279] 
.const [159] = NameAndType [280] [281] 
.const [160] = Class [282] 
.const [161] = NameAndType [283] [284] 
.const [162] = Class [285] 
.const [163] = NameAndType [286] [287] 
.const [164] = Utf8 java/io/ByteArrayOutputStream 
.const [165] = Utf8 java/util/jar/JarInputStream 
.const [166] = Utf8 eos 
.const [167] = Utf8 Z 
.const [168] = Utf8 java/util/jar/JarInputStream 
.const [169] = Utf8 verifier 
.const [170] = Utf8 Ljava/util/jar/JarVerifier; 
.const [171] = Utf8 java/util/jar/JarInputStream 
.const [172] = Utf8 getNextJarEntry 
.const [173] = Utf8 ()Ljava/util/jar/JarEntry; 
.const [174] = Utf8 java/util/jar/JarInputStream 
.const [175] = Utf8 mEntry 
.const [176] = Utf8 Ljava/util/jar/JarEntry; 
.const [177] = Utf8 java/util/jar/JarEntry 
.const [178] = Utf8 getName 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 java/lang/String 
.const [181] = Utf8 toUpperCase 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 java/lang/String 
.const [184] = Utf8 equals 
.const [185] = Utf8 (Ljava/lang/Object;)Z 
.const [186] = Utf8 java/util/jar/JarInputStream 
.const [187] = Utf8 closeEntry 
.const [188] = Utf8 ()V 
.const [189] = Utf8 java/util/jar/JarInputStream 
.const [190] = Utf8 manifest 
.const [191] = Utf8 Ljava/util/jar/Manifest; 
.const [192] = Utf8 java/util/jar/JarVerifier 
.const [193] = Utf8 setManifest 
.const [194] = Utf8 (Ljava/util/jar/Manifest;)V 
.const [195] = Utf8 java/util/jar/Attributes 
.const [196] = Utf8 map 
.const [197] = Utf8 Ljava/util/Map; 
.const [198] = Utf8 java/util/jar/JarEntry 
.const [199] = Utf8 setAttributes 
.const [200] = Utf8 (Ljava/util/jar/Attributes;)V 
.const [201] = Utf8 java/util/jar/JarInputStream 
.const [202] = Utf8 getNextEntry 
.const [203] = Utf8 ()Ljava/util/zip/ZipEntry; 
.const [204] = Utf8 java/util/jar/JarInputStream 
.const [205] = Utf8 verStream 
.const [206] = Utf8 Ljava/io/OutputStream; 
.const [207] = Utf8 java/util/jar/JarInputStream 
.const [208] = Utf8 isMeta 
.const [209] = Utf8 Z 
.const [210] = Utf8 java/util/jar/JarInputStream 
.const [211] = Utf8 jarEntry 
.const [212] = Utf8 Ljava/util/jar/JarEntry; 
.const [213] = Utf8 java/io/ByteArrayOutputStream 
.const [214] = Utf8 toByteArray 
.const [215] = Utf8 ()[B 
.const [216] = Utf8 java/util/jar/JarVerifier 
.const [217] = Utf8 addMetaEntry 
.const [218] = Utf8 (Ljava/lang/String;[B)V 
.const [219] = Utf8 java/util/jar/JarVerifier 
.const [220] = Utf8 readCertificates 
.const [221] = Utf8 ()Z 
.const [222] = Utf8 java/util/jar/JarVerifier 
.const [223] = Utf8 verifySignatures 
.const [224] = Utf8 (Ljava/util/jar/JarVerifier$VerifierEntry;Ljava/util/zip/ZipEntry;)V 
.const [225] = Utf8 java/io/OutputStream 
.const [226] = Utf8 write 
.const [227] = Utf8 ([BII)V 
.const [228] = Utf8 java/lang/String 
.const [229] = Utf8 startsWith 
.const [230] = Utf8 (Ljava/lang/String;)Z 
.const [231] = Utf8 java/util/jar/JarVerifier 
.const [232] = Utf8 initEntry 
.const [233] = Utf8 (Ljava/lang/String;)Ljava/util/jar/JarVerifier$VerifierEntry; 
.const [234] = Utf8 java/util/jar/Manifest 
.const [235] = Utf8 getAttributes 
.const [236] = Utf8 (Ljava/lang/String;)Ljava/util/jar/Attributes; 
.const [237] = Utf8 java/util/zip/ZipInputStream 
.const [238] = Utf8 <init> 
.const [239] = Utf8 (Ljava/io/InputStream;)V 
.const [240] = Utf8 java/util/jar/JarVerifier 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Ljava/lang/String;)V 
.const [243] = Utf8 java/util/jar/Manifest 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (Ljava/io/InputStream;Z)V 
.const [246] = Utf8 java/util/jar/Attributes 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (I)V 
.const [249] = Utf8 java/util/jar/JarInputStream 
.const [250] = Utf8 <init> 
.const [251] = Utf8 (Ljava/io/InputStream;Z)V 
.const [252] = Utf8 java/util/zip/ZipInputStream 
.const [253] = Utf8 read 
.const [254] = Utf8 ([BII)I 
.const [255] = Utf8 java/util/zip/ZipInputStream 
.const [256] = Utf8 getNextEntry 
.const [257] = Utf8 ()Ljava/util/zip/ZipEntry; 
.const [258] = Utf8 java/io/ByteArrayOutputStream 
.const [259] = Utf8 <init> 
.const [260] = Utf8 ()V 
.const [261] = Utf8 java/util/jar/JarEntry 
.const [262] = Utf8 <init> 
.const [263] = Utf8 (Ljava/lang/String;)V 
.const [264] = Utf8 java/util/jar/JarInputStream 
.const [265] = Utf8 eos 
.const [266] = Utf8 Z 
.const [267] = Utf8 java/util/jar/JarInputStream 
.const [268] = Utf8 verifier 
.const [269] = Utf8 Ljava/util/jar/JarVerifier; 
.const [270] = Utf8 java/util/jar/JarInputStream 
.const [271] = Utf8 mEntry 
.const [272] = Utf8 Ljava/util/jar/JarEntry; 
.const [273] = Utf8 java/util/jar/JarInputStream 
.const [274] = Utf8 manifest 
.const [275] = Utf8 Ljava/util/jar/Manifest; 
.const [276] = Utf8 java/util/Map 
.const [277] = Utf8 put 
.const [278] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [279] = Utf8 java/util/jar/JarInputStream 
.const [280] = Utf8 verStream 
.const [281] = Utf8 Ljava/io/OutputStream; 
.const [282] = Utf8 java/util/jar/JarInputStream 
.const [283] = Utf8 isMeta 
.const [284] = Utf8 Z 
.const [285] = Utf8 java/util/jar/JarInputStream 
.const [286] = Utf8 jarEntry 
.const [287] = Utf8 Ljava/util/jar/JarEntry; 
.const [288] = Utf8 java/util/jar/JarInputStream 
.const [289] = Class [288] 
.const [290] = Utf8 java/util/zip/ZipInputStream 
.const [291] = Class [290] 
.const [292] = Utf8 manifest 
.const [293] = Utf8 Ljava/util/jar/Manifest; 
.const [294] = Utf8 eos 
.const [295] = Utf8 Z 
.const [296] = Utf8 mEntry 
.const [297] = Utf8 Ljava/util/jar/JarEntry; 
.const [298] = Utf8 jarEntry 
.const [299] = Utf8 Ljava/util/jar/JarEntry; 
.const [300] = Utf8 isMeta 
.const [301] = Utf8 Z 
.const [302] = Utf8 verifier 
.const [303] = Utf8 Ljava/util/jar/JarVerifier; 
.const [304] = Utf8 verStream 
.const [305] = Utf8 Ljava/io/OutputStream; 
.const [306] = Utf8 Code 
.const [307] = Utf8 <init> 
.const [308] = Utf8 (Ljava/io/InputStream;Z)V 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Ljava/io/InputStream;)V 
.const [311] = Utf8 getManifest 
.const [312] = Utf8 ()Ljava/util/jar/Manifest; 
.const [313] = Utf8 getNextJarEntry 
.const [314] = Utf8 ()Ljava/util/jar/JarEntry; 
.const [315] = Utf8 read 
.const [316] = Utf8 ([BII)I 
.const [317] = Utf8 getNextEntry 
.const [318] = Utf8 ()Ljava/util/zip/ZipEntry; 
.const [319] = Utf8 createZipEntry 
.const [320] = Utf8 (Ljava/lang/String;)Ljava/util/zip/ZipEntry; 
.end class 
