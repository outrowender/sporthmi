.version 50 0 
.class public final super [169] 
.super [171] 
.field private [172] [173] 
.field private [174] [175] 
.field private [176] [177] 
.field private [178] [179] 
.field private [180] [181] 
.field private [182] [183] 
.field private [184] [185] 
.field private final synthetic [186] [187] 

.method public [189] : [190] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [24] 
L9:     aload_0 
L10:    bipush 64 
L12:    newarray byte 
L14:    putfield [26] 
L17:    aload_0 
L18:    aload_2 
L19:    putfield [27] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [28] 
L27:    aload_0 
L28:    iconst_m1 
L29:    putfield [29] 
L32:    aload_0 
L33:    iconst_0 
L34:    putfield [30] 
L37:    aload_0 
L38:    iconst_0 
L39:    putfield [31] 
L42:    aload_0 
L43:    iconst_0 
L44:    putfield [32] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [11] 
L5:     putfield [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [188] .code stack 5 locals 2 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [13] 
L6:     aload_0 
L7:     getfield [14] 
L10:    if_icmpge L34 
L13:    aload_0 
L14:    getfield [9] 
L17:    aload_0 
L18:    dup 
L19:    getfield [13] 
L22:    dup_x1 
L23:    iconst_1 
L24:    iadd 
L25:    putfield [30] 
L28:    baload 
L29:    sipush 255 
L32:    iand 
L33:    areturn 
L34:    aload_0 
L35:    getfield [13] 
L38:    aload_0 
L39:    getfield [12] 
L42:    if_icmpne L47 
L45:    iconst_m1 
L46:    areturn 
L47:    aload_0 
L48:    getfield [13] 
L51:    aload_0 
L52:    getfield [9] 
L55:    arraylength 
L56:    if_icmpne L87 
L59:    aload_0 
L60:    getfield [13] 
L63:    iconst_1 
L64:    ishl 
L65:    newarray byte 
L67:    astore_2 
L68:    aload_0 
L69:    getfield [9] 
L72:    iconst_0 
L73:    aload_2 
L74:    iconst_0 
L75:    aload_0 
L76:    getfield [13] 
L79:    invokestatic [2] 
L82:    aload_0 
L83:    aload_2 
L84:    putfield [26] 
L87:    aload_0 
L88:    getfield [10] 
L91:    invokevirtual [16] 
L94:    istore_1 
L95:    iload_1 
L96:    iconst_m1 
L97:    if_icmpne L110 
L100:   aload_0 
L101:   aload_0 
L102:   getfield [13] 
L105:   putfield [29] 
L108:   iconst_m1 
L109:   areturn 
L110:   aload_0 
L111:   getfield [9] 
L114:   aload_0 
L115:   dup 
L116:   getfield [14] 
L119:   dup_x1 
L120:   iconst_1 
L121:   iadd 
L122:   putfield [31] 
L125:   iload_1 
L126:   i2b 
L127:   bastore 
L128:   aload_0 
L129:   dup 
L130:   getfield [13] 
L133:   iconst_1 
L134:   iadd 
L135:   putfield [30] 
L138:   iload_1 
L139:   sipush 255 
L142:   iand 
L143:   areturn 
L144:   
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [188] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     isub 
L9:     istore 4 
L11:    iload 4 
L13:    ifne L83 
L16:    aload_0 
L17:    getfield [13] 
L20:    aload_0 
L21:    getfield [12] 
L24:    if_icmpne L29 
L27:    iconst_m1 
L28:    areturn 
L29:    aload_0 
L30:    getfield [8] 
L33:    getfield [17] 
L36:    getfield [18] 
L39:    ifeq L53 
L42:    aload_0 
L43:    getfield [10] 
L46:    aload_1 
L47:    iload_2 
L48:    iload_3 
L49:    invokevirtual [19] 
L52:    areturn 
L53:    aload_0 
L54:    invokevirtual [20] 
L57:    istore 5 
L59:    iload 5 
L61:    iconst_m1 
L62:    if_icmpne L75 
L65:    aload_0 
L66:    aload_0 
L67:    getfield [13] 
L70:    putfield [29] 
L73:    iconst_m1 
L74:    areturn 
L75:    aload_1 
L76:    iload_2 
L77:    iload 5 
L79:    i2b 
L80:    bastore 
L81:    iconst_1 
L82:    areturn 
L83:    iload_3 
L84:    iload 4 
L86:    if_icmpge L95 
L89:    iload_3 
L90:    ifgt L98 
L93:    iconst_0 
L94:    areturn 
L95:    iload 4 
L97:    istore_3 
L98:    aload_1 
L99:    ifnull L116 
L102:   aload_0 
L103:   getfield [9] 
L106:   aload_0 
L107:   getfield [13] 
L110:   aload_1 
L111:   iload_2 
L112:   iload_3 
L113:   invokestatic [2] 
L116:   aload_0 
L117:   dup 
L118:   getfield [13] 
L121:   iload_3 
L122:   iadd 
L123:   putfield [30] 
L126:   iload_3 
L127:   areturn 
L128:   
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [188] .code stack 5 locals 1 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifgt L8 
L6:     lconst_0 
L7:     freturn 
L8:     aload_0 
L9:     getfield [14] 
L12:    aload_0 
L13:    getfield [13] 
L16:    isub 
L17:    istore_3 
L18:    iload_3 
L19:    ifne L44 
L22:    aload_0 
L23:    getfield [13] 
L26:    aload_0 
L27:    getfield [12] 
L30:    if_icmpne L35 
L33:    lconst_0 
L34:    freturn 
L35:    aload_0 
L36:    getfield [10] 
L39:    lload_1 
L40:    invokevirtual [21] 
L43:    freturn 
L44:    lload_1 
L45:    iload_3 
L46:    i2l 
L47:    lcmp 
L48:    ifgt L65 
L51:    aload_0 
L52:    dup 
L53:    getfield [13] 
L56:    i2l 
L57:    lload_1 
L58:    ladd 
L59:    l2i 
L60:    putfield [30] 
L63:    lload_1 
L64:    freturn 
L65:    aload_0 
L66:    dup 
L67:    getfield [13] 
L70:    iload_3 
L71:    iadd 
L72:    putfield [30] 
L75:    aload_0 
L76:    getfield [13] 
L79:    aload_0 
L80:    getfield [12] 
L83:    if_icmpne L89 
L86:    iload_3 
L87:    i2l 
L88:    freturn 
L89:    lload_1 
L90:    iload_3 
L91:    i2l 
L92:    lsub 
L93:    lstore_1 
L94:    aload_0 
L95:    getfield [10] 
L98:    lload_1 
L99:    invokevirtual [21] 
L102:   iload_3 
L103:   i2l 
L104:   ladd 
L105:   freturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [188] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     isub 
L9:     istore_1 
L10:    iload_1 
L11:    ifne L52 
L14:    aload_0 
L15:    getfield [13] 
L18:    aload_0 
L19:    getfield [12] 
L22:    if_icmpne L27 
L25:    iconst_m1 
L26:    areturn 
L27:    aload_0 
L28:    getfield [8] 
L31:    getfield [17] 
L34:    getfield [18] 
L37:    ifeq L50 
L40:    aload_0 
L41:    getfield [10] 
L44:    invokevirtual [22] 
L47:    goto L51 
L50:    iconst_0 
L51:    areturn 
L52:    iload_1 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [13] 
L5:     putfield [32] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [15] 
L5:     putfield [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [188] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [10] 
L11:    invokevirtual [23] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [27] 
L19:    return 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [33] [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Field [40] [41] 
.const [9] = Field [42] [43] 
.const [10] = Field [44] [45] 
.const [11] = Field [46] [47] 
.const [12] = Field [48] [49] 
.const [13] = Field [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Field [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Field [58] [59] 
.const [18] = Field [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Field [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Class [90] 
.const [34] = NameAndType [91] [92] 
.const [35] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [36] = Utf8 java/io/InputStream 
.const [37] = Utf8 java/lang/System 
.const [38] = Utf8 org/apache/xerces/impl/XMLEntityManager 
.const [39] = Utf8 org/apache/xerces/impl/XMLEntityManager$ScannedEntity 
.const [40] = Class [93] 
.const [41] = NameAndType [94] [95] 
.const [42] = Class [96] 
.const [43] = NameAndType [97] [98] 
.const [44] = Class [99] 
.const [45] = NameAndType [100] [101] 
.const [46] = Class [102] 
.const [47] = NameAndType [103] [104] 
.const [48] = Class [105] 
.const [49] = NameAndType [106] [107] 
.const [50] = Class [108] 
.const [51] = NameAndType [109] [110] 
.const [52] = Class [111] 
.const [53] = NameAndType [112] [113] 
.const [54] = Class [114] 
.const [55] = NameAndType [115] [116] 
.const [56] = Class [117] 
.const [57] = NameAndType [118] [119] 
.const [58] = Class [120] 
.const [59] = NameAndType [121] [122] 
.const [60] = Class [123] 
.const [61] = NameAndType [124] [125] 
.const [62] = Class [126] 
.const [63] = NameAndType [127] [128] 
.const [64] = Class [129] 
.const [65] = NameAndType [130] [131] 
.const [66] = Class [132] 
.const [67] = NameAndType [133] [134] 
.const [68] = Class [135] 
.const [69] = NameAndType [136] [137] 
.const [70] = Class [138] 
.const [71] = NameAndType [139] [140] 
.const [72] = Class [141] 
.const [73] = NameAndType [142] [143] 
.const [74] = Class [144] 
.const [75] = NameAndType [145] [146] 
.const [76] = Class [147] 
.const [77] = NameAndType [148] [149] 
.const [78] = Class [150] 
.const [79] = NameAndType [151] [152] 
.const [80] = Class [153] 
.const [81] = NameAndType [154] [155] 
.const [82] = Class [156] 
.const [83] = NameAndType [157] [158] 
.const [84] = Class [159] 
.const [85] = NameAndType [160] [161] 
.const [86] = Class [162] 
.const [87] = NameAndType [163] [164] 
.const [88] = Class [165] 
.const [89] = NameAndType [166] [167] 
.const [90] = Utf8 java/lang/System 
.const [91] = Utf8 arraycopy 
.const [92] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [93] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [94] = Utf8 this$0 
.const [95] = Utf8 Lorg/apache/xerces/impl/XMLEntityManager; 
.const [96] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [97] = Utf8 fData 
.const [98] = Utf8 [B 
.const [99] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [100] = Utf8 fInputStream 
.const [101] = Utf8 Ljava/io/InputStream; 
.const [102] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [103] = Utf8 fStartOffset 
.const [104] = Utf8 I 
.const [105] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [106] = Utf8 fEndOffset 
.const [107] = Utf8 I 
.const [108] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [109] = Utf8 fOffset 
.const [110] = Utf8 I 
.const [111] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [112] = Utf8 fLength 
.const [113] = Utf8 I 
.const [114] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [115] = Utf8 fMark 
.const [116] = Utf8 I 
.const [117] = Utf8 java/io/InputStream 
.const [118] = Utf8 read 
.const [119] = Utf8 ()I 
.const [120] = Utf8 org/apache/xerces/impl/XMLEntityManager 
.const [121] = Utf8 fCurrentEntity 
.const [122] = Utf8 Lorg/apache/xerces/impl/XMLEntityManager$ScannedEntity; 
.const [123] = Utf8 org/apache/xerces/impl/XMLEntityManager$ScannedEntity 
.const [124] = Utf8 mayReadChunks 
.const [125] = Utf8 Z 
.const [126] = Utf8 java/io/InputStream 
.const [127] = Utf8 read 
.const [128] = Utf8 ([BII)I 
.const [129] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [130] = Utf8 read 
.const [131] = Utf8 ()I 
.const [132] = Utf8 java/io/InputStream 
.const [133] = Utf8 skip 
.const [134] = Utf8 (J)J 
.const [135] = Utf8 java/io/InputStream 
.const [136] = Utf8 available 
.const [137] = Utf8 ()I 
.const [138] = Utf8 java/io/InputStream 
.const [139] = Utf8 close 
.const [140] = Utf8 ()V 
.const [141] = Utf8 java/io/InputStream 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [145] = Utf8 this$0 
.const [146] = Utf8 Lorg/apache/xerces/impl/XMLEntityManager; 
.const [147] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [148] = Utf8 fData 
.const [149] = Utf8 [B 
.const [150] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [151] = Utf8 fInputStream 
.const [152] = Utf8 Ljava/io/InputStream; 
.const [153] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [154] = Utf8 fStartOffset 
.const [155] = Utf8 I 
.const [156] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [157] = Utf8 fEndOffset 
.const [158] = Utf8 I 
.const [159] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [160] = Utf8 fOffset 
.const [161] = Utf8 I 
.const [162] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [163] = Utf8 fLength 
.const [164] = Utf8 I 
.const [165] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [166] = Utf8 fMark 
.const [167] = Utf8 I 
.const [168] = Utf8 org/apache/xerces/impl/XMLEntityManager$RewindableInputStream 
.const [169] = Class [168] 
.const [170] = Utf8 java/io/InputStream 
.const [171] = Class [170] 
.const [172] = Utf8 fInputStream 
.const [173] = Utf8 Ljava/io/InputStream; 
.const [174] = Utf8 fData 
.const [175] = Utf8 [B 
.const [176] = Utf8 fStartOffset 
.const [177] = Utf8 I 
.const [178] = Utf8 fEndOffset 
.const [179] = Utf8 I 
.const [180] = Utf8 fOffset 
.const [181] = Utf8 I 
.const [182] = Utf8 fLength 
.const [183] = Utf8 I 
.const [184] = Utf8 fMark 
.const [185] = Utf8 I 
.const [186] = Utf8 this$0 
.const [187] = Utf8 Lorg/apache/xerces/impl/XMLEntityManager; 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lorg/apache/xerces/impl/XMLEntityManager;Ljava/io/InputStream;)V 
.const [191] = Utf8 setStartOffset 
.const [192] = Utf8 (I)V 
.const [193] = Utf8 rewind 
.const [194] = Utf8 ()V 
.const [195] = Utf8 read 
.const [196] = Utf8 ()I 
.const [197] = Utf8 read 
.const [198] = Utf8 ([BII)I 
.const [199] = Utf8 skip 
.const [200] = Utf8 (J)J 
.const [201] = Utf8 available 
.const [202] = Utf8 ()I 
.const [203] = Utf8 mark 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 reset 
.const [206] = Utf8 ()V 
.const [207] = Utf8 markSupported 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 close 
.const [210] = Utf8 ()V 
.end class 
