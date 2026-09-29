.version 50 0 
.class final super [141] 
.super [143] 
.field private [144] [145] 
.field private [146] [147] 
.field private [148] [149] 
.field private [150] [151] 
.field private [152] [153] 

.method [155] : [156] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [21] 
L5:     aload_3 
L6:     ifnull L63 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [24] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [25] 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [8] 
L24:    invokevirtual [10] 
L27:    putfield [26] 
L30:    aload_0 
L31:    aload_0 
L32:    getfield [9] 
L35:    aload_2 
L36:    invokevirtual [12] 
L39:    invokevirtual [13] 
L42:    putfield [27] 
L45:    aload_0 
L46:    getfield [14] 
L49:    ifnull L63 
L52:    aload_0 
L53:    aload_0 
L54:    getfield [14] 
L57:    getfield [15] 
L60:    putfield [28] 
L63:    return 
L64:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     istore_1 
L5:     aload_0 
L6:     getfield [14] 
L9:     ifnull L72 
L12:    iload_1 
L13:    iconst_m1 
L14:    if_icmpeq L36 
L17:    aload_0 
L18:    getfield [16] 
L21:    iload_1 
L22:    i2b 
L23:    invokevirtual [17] 
L26:    aload_0 
L27:    dup 
L28:    getfield [11] 
L31:    lconst_1 
L32:    lsub 
L33:    putfield [26] 
L36:    iload_1 
L37:    iconst_m1 
L38:    if_icmpeq L50 
L41:    aload_0 
L42:    getfield [11] 
L45:    lconst_0 
L46:    lcmp 
L47:    ifgt L72 
L50:    aload_0 
L51:    getfield [14] 
L54:    astore_2 
L55:    aload_0 
L56:    aconst_null 
L57:    putfield [27] 
L60:    aload_0 
L61:    getfield [9] 
L64:    aload_2 
L65:    aload_0 
L66:    getfield [8] 
L69:    invokevirtual [18] 
L72:    iload_1 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [154] .code stack 5 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial [23] 
L7:     istore 4 
L9:     aload_0 
L10:    getfield [14] 
L13:    ifnull L106 
L16:    iload 4 
L18:    iconst_m1 
L19:    if_icmpeq L67 
L22:    iload 4 
L24:    istore 5 
L26:    aload_0 
L27:    getfield [11] 
L30:    iload 5 
L32:    i2l 
L33:    lcmp 
L34:    ifge L44 
L37:    aload_0 
L38:    getfield [11] 
L41:    l2i 
L42:    istore 5 
L44:    aload_0 
L45:    getfield [16] 
L48:    aload_1 
L49:    iload_2 
L50:    iload 5 
L52:    invokevirtual [19] 
L55:    aload_0 
L56:    dup 
L57:    getfield [11] 
L60:    iload 4 
L62:    i2l 
L63:    lsub 
L64:    putfield [26] 
L67:    iload 4 
L69:    iconst_m1 
L70:    if_icmpeq L82 
L73:    aload_0 
L74:    getfield [11] 
L77:    lconst_0 
L78:    lcmp 
L79:    ifgt L106 
L82:    aload_0 
L83:    getfield [14] 
L86:    astore 5 
L88:    aload_0 
L89:    aconst_null 
L90:    putfield [27] 
L93:    aload_0 
L94:    getfield [9] 
L97:    aload 5 
L99:    aload_0 
L100:   getfield [8] 
L103:   invokevirtual [18] 
L106:   iload 4 
L108:   areturn 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [154] .code stack 7 locals 6 
L0:     lconst_0 
L1:     lstore_3 
L2:     lconst_0 
L3:     lstore 5 
L5:     sipush 4096 
L8:     newarray byte 
L10:    astore 7 
L12:    goto L61 
L15:    aload_0 
L16:    aload 7 
L18:    iconst_0 
L19:    lload_1 
L20:    lload_3 
L21:    lsub 
L22:    dup2 
L23:    lstore 5 
L25:    aload 7 
L27:    arraylength 
L28:    i2l 
L29:    lcmp 
L30:    ifle L39 
L33:    aload 7 
L35:    arraylength 
L36:    goto L42 
L39:    lload 5 
L41:    l2i 
L42:    invokevirtual [20] 
L45:    istore 8 
L47:    iload 8 
L49:    iconst_m1 
L50:    if_icmpne L55 
L53:    lload_3 
L54:    freturn 
L55:    lload_3 
L56:    iload 8 
L58:    i2l 
L59:    ladd 
L60:    lstore_3 
L61:    lload_3 
L62:    lload_1 
L63:    lcmp 
L64:    iflt L15 
L67:    lload_3 
L68:    freturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Field [35] [36] 
.const [9] = Field [37] [38] 
.const [10] = Method [39] [40] 
.const [11] = Field [41] [42] 
.const [12] = Method [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Field [47] [48] 
.const [15] = Field [49] [50] 
.const [16] = Field [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Field [67] [68] 
.const [25] = Field [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [30] = Utf8 java/io/FilterInputStream 
.const [31] = Utf8 java/util/zip/ZipEntry 
.const [32] = Utf8 java/util/jar/JarVerifier 
.const [33] = Utf8 java/util/jar/JarVerifier$VerifierEntry 
.const [34] = Utf8 java/security/MessageDigest 
.const [35] = Class [77] 
.const [36] = NameAndType [78] [79] 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Class [83] 
.const [40] = NameAndType [84] [85] 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Class [89] 
.const [44] = NameAndType [90] [91] 
.const [45] = Class [92] 
.const [46] = NameAndType [93] [94] 
.const [47] = Class [95] 
.const [48] = NameAndType [96] [97] 
.const [49] = Class [98] 
.const [50] = NameAndType [99] [100] 
.const [51] = Class [101] 
.const [52] = NameAndType [102] [103] 
.const [53] = Class [104] 
.const [54] = NameAndType [105] [106] 
.const [55] = Class [107] 
.const [56] = NameAndType [108] [109] 
.const [57] = Class [110] 
.const [58] = NameAndType [111] [112] 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Class [116] 
.const [62] = NameAndType [117] [118] 
.const [63] = Class [119] 
.const [64] = NameAndType [120] [121] 
.const [65] = Class [122] 
.const [66] = NameAndType [123] [124] 
.const [67] = Class [125] 
.const [68] = NameAndType [126] [127] 
.const [69] = Class [128] 
.const [70] = NameAndType [129] [130] 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [78] = Utf8 zipEntry 
.const [79] = Utf8 Ljava/util/zip/ZipEntry; 
.const [80] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [81] = Utf8 verifier 
.const [82] = Utf8 Ljava/util/jar/JarVerifier; 
.const [83] = Utf8 java/util/zip/ZipEntry 
.const [84] = Utf8 getSize 
.const [85] = Utf8 ()J 
.const [86] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [87] = Utf8 count 
.const [88] = Utf8 J 
.const [89] = Utf8 java/util/zip/ZipEntry 
.const [90] = Utf8 getName 
.const [91] = Utf8 ()Ljava/lang/String; 
.const [92] = Utf8 java/util/jar/JarVerifier 
.const [93] = Utf8 initEntry 
.const [94] = Utf8 (Ljava/lang/String;)Ljava/util/jar/JarVerifier$VerifierEntry; 
.const [95] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [96] = Utf8 entry 
.const [97] = Utf8 Ljava/util/jar/JarVerifier$VerifierEntry; 
.const [98] = Utf8 java/util/jar/JarVerifier$VerifierEntry 
.const [99] = Utf8 digest 
.const [100] = Utf8 Ljava/security/MessageDigest; 
.const [101] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [102] = Utf8 digest 
.const [103] = Utf8 Ljava/security/MessageDigest; 
.const [104] = Utf8 java/security/MessageDigest 
.const [105] = Utf8 update 
.const [106] = Utf8 (B)V 
.const [107] = Utf8 java/util/jar/JarVerifier 
.const [108] = Utf8 verifySignatures 
.const [109] = Utf8 (Ljava/util/jar/JarVerifier$VerifierEntry;Ljava/util/zip/ZipEntry;)V 
.const [110] = Utf8 java/security/MessageDigest 
.const [111] = Utf8 update 
.const [112] = Utf8 ([BII)V 
.const [113] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [114] = Utf8 read 
.const [115] = Utf8 ([BII)I 
.const [116] = Utf8 java/io/FilterInputStream 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Ljava/io/InputStream;)V 
.const [119] = Utf8 java/io/FilterInputStream 
.const [120] = Utf8 read 
.const [121] = Utf8 ()I 
.const [122] = Utf8 java/io/FilterInputStream 
.const [123] = Utf8 read 
.const [124] = Utf8 ([BII)I 
.const [125] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [126] = Utf8 zipEntry 
.const [127] = Utf8 Ljava/util/zip/ZipEntry; 
.const [128] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [129] = Utf8 verifier 
.const [130] = Utf8 Ljava/util/jar/JarVerifier; 
.const [131] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [132] = Utf8 count 
.const [133] = Utf8 J 
.const [134] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [135] = Utf8 entry 
.const [136] = Utf8 Ljava/util/jar/JarVerifier$VerifierEntry; 
.const [137] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [138] = Utf8 digest 
.const [139] = Utf8 Ljava/security/MessageDigest; 
.const [140] = Utf8 java/util/jar/JarFile$JarFileInputStream 
.const [141] = Class [140] 
.const [142] = Utf8 java/io/FilterInputStream 
.const [143] = Class [142] 
.const [144] = Utf8 count 
.const [145] = Utf8 J 
.const [146] = Utf8 zipEntry 
.const [147] = Utf8 Ljava/util/zip/ZipEntry; 
.const [148] = Utf8 verifier 
.const [149] = Utf8 Ljava/util/jar/JarVerifier; 
.const [150] = Utf8 entry 
.const [151] = Utf8 Ljava/util/jar/JarVerifier$VerifierEntry; 
.const [152] = Utf8 digest 
.const [153] = Utf8 Ljava/security/MessageDigest; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/io/InputStream;Ljava/util/zip/ZipEntry;Ljava/util/jar/JarVerifier;)V 
.const [157] = Utf8 read 
.const [158] = Utf8 ()I 
.const [159] = Utf8 read 
.const [160] = Utf8 ([BII)I 
.const [161] = Utf8 skip 
.const [162] = Utf8 (J)J 
.end class 
