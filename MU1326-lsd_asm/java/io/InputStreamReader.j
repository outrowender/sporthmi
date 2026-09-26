.version 50 0 
.class public super [279] 
.super [281] 
.field private [282] [283] 
.field [284] [285] 
.field private [286] [287] 
.field private [288] [289] 
.field private [290] [291] 
.field private [292] [293] 

.method public [295] : [296] 
    .attribute [294] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [43] 
L5:     aload_0 
L6:     sipush 8192 
L9:     newarray byte 
L11:    putfield [54] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [55] 
L19:    new [56] 
L22:    dup 
L23:    ldc [5] 
L25:    ldc [6] 
L27:    invokespecial [44] 
L30:    invokestatic [7] 
L33:    checkcast [9] 
L36:    astore_2 
L37:    aload_0 
L38:    aload_2 
L39:    invokestatic [10] 
L42:    putfield [57] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [294] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [43] 
L5:     aload_0 
L6:     sipush 8192 
L9:     newarray byte 
L11:    putfield [54] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [55] 
L19:    aload_0 
L20:    aload_2 
L21:    invokestatic [13] 
L24:    dup_x1 
L25:    putfield [57] 
L28:    ifnonnull L40 
L31:    new [58] 
L34:    dup 
L35:    aload_2 
L36:    invokespecial [45] 
L39:    athrow 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [294] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [31] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L38 using L41 
L7:     aload_0 
L8:     getfield [28] 
L11:    ifnull L36 
L14:    aload_0 
L15:    getfield [29] 
L18:    invokevirtual [32] 
L21:    aload_0 
L22:    aconst_null 
L23:    putfield [57] 
L26:    aload_0 
L27:    aconst_null 
L28:    putfield [55] 
L31:    aload_0 
L32:    aconst_null 
L33:    putfield [54] 
L36:    aload_1 
L37:    monitorexit 
L38:    goto L44 
        .catch [0] from L41 to L43 using L41 
L41:    aload_1 
L42:    monitorexit 
L43:    athrow 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private [301] : [302] 
    .attribute [294] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifle L59 
L7:     aload_0 
L8:     getfield [34] 
L11:    ifle L59 
L14:    aload_0 
L15:    dup 
L16:    getfield [33] 
L19:    aload_0 
L20:    getfield [34] 
L23:    isub 
L24:    putfield [60] 
L27:    aload_0 
L28:    getfield [33] 
L31:    ifle L54 
L34:    aload_0 
L35:    getfield [28] 
L38:    aload_0 
L39:    getfield [34] 
L42:    aload_0 
L43:    getfield [28] 
L46:    iconst_0 
L47:    aload_0 
L48:    getfield [33] 
L51:    invokestatic [16] 
L54:    aload_0 
L55:    iconst_0 
L56:    putfield [61] 
L59:    aload_0 
L60:    getfield [29] 
L63:    aload_0 
L64:    getfield [28] 
L67:    aload_0 
L68:    getfield [33] 
L71:    aload_0 
L72:    getfield [28] 
L75:    arraylength 
L76:    aload_0 
L77:    getfield [33] 
L80:    isub 
L81:    invokevirtual [35] 
L84:    istore_1 
L85:    iload_1 
L86:    iflt L107 
L89:    aload_0 
L90:    dup 
L91:    getfield [33] 
L94:    iload_1 
L95:    iadd 
L96:    putfield [60] 
L99:    aload_0 
L100:   iconst_0 
L101:   putfield [62] 
L104:   goto L127 
L107:   aload_0 
L108:   getfield [33] 
L111:   ifle L127 
L114:   new [63] 
L117:   dup 
L118:   ldc [19] 
L120:   invokestatic [20] 
L123:   invokespecial [46] 
L126:   athrow 
L127:   iload_1 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private [303] : [304] 
    .attribute [294] .code stack 5 locals 2 
L0:     new [64] 
L3:     dup 
L4:     aload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokespecial [47] 
L10:    astore 4 
L12:    aload_0 
L13:    getfield [30] 
L16:    aload_0 
L17:    getfield [28] 
L20:    aload_0 
L21:    getfield [34] 
L24:    aload_0 
L25:    getfield [33] 
L28:    aload_0 
L29:    getfield [34] 
L32:    isub 
L33:    aload 4 
L35:    invokevirtual [36] 
L38:    istore 5 
L40:    aload_0 
L41:    iload 5 
L43:    putfield [61] 
L46:    iload 5 
L48:    iconst_m1 
L49:    if_icmpeq L60 
L52:    aload 4 
L54:    invokevirtual [37] 
L57:    iload_2 
L58:    isub 
L59:    areturn 
L60:    new [63] 
L63:    dup 
L64:    invokespecial [48] 
L67:    athrow 
L68:    
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [294] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifnonnull L9 
L7:     aconst_null 
L8:     areturn 
L9:     aload_0 
L10:    getfield [30] 
L13:    instanceof [23] 
L16:    ifeq L30 
L19:    aload_0 
L20:    getfield [30] 
L23:    checkcast [23] 
L26:    invokevirtual [38] 
L29:    areturn 
L30:    aload_0 
L31:    getfield [30] 
L34:    invokespecial [49] 
L37:    invokevirtual [39] 
L40:    astore_1 
L41:    aload_1 
L42:    bipush 95 
L44:    invokevirtual [40] 
L47:    istore_2 
L48:    iload_2 
L49:    ifge L55 
L52:    ldc [6] 
L54:    areturn 
L55:    aload_1 
L56:    iload_2 
L57:    iconst_1 
L58:    iadd 
L59:    invokevirtual [41] 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [307] : [308] 
    .attribute [294] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [31] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L56 using L89 
L7:     aload_0 
L8:     getfield [28] 
L11:    ifnull L76 
L14:    iconst_1 
L15:    newarray char 
L17:    astore_2 
L18:    iconst_0 
L19:    istore_3 
L20:    aload_0 
L21:    getfield [34] 
L24:    aload_0 
L25:    getfield [33] 
L28:    if_icmpge L66 
L31:    aload_0 
L32:    aload_2 
L33:    iconst_0 
L34:    iconst_1 
L35:    invokespecial [50] 
L38:    istore_3 
L39:    goto L66 
L42:    aload_0 
L43:    invokespecial [51] 
L46:    istore 4 
L48:    iload 4 
L50:    iconst_m1 
L51:    if_icmpne L58 
L54:    aload_1 
L55:    monitorexit 
L56:    iconst_m1 
L57:    areturn 
        .catch [0] from L58 to L75 using L89 
L58:    aload_0 
L59:    aload_2 
L60:    iconst_0 
L61:    iconst_1 
L62:    invokespecial [50] 
L65:    istore_3 
L66:    iload_3 
L67:    ifeq L42 
L70:    aload_2 
L71:    iconst_0 
L72:    caload 
L73:    aload_1 
L74:    monitorexit 
L75:    areturn 
        .catch [0] from L76 to L91 using L89 
L76:    new [59] 
L79:    dup 
L80:    ldc [26] 
L82:    invokestatic [20] 
L85:    invokespecial [52] 
L88:    athrow 
L89:    aload_1 
L90:    monitorexit 
L91:    athrow 
L92:    
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [294] .code stack 5 locals 6 
L0:     iload_2 
L1:     iflt L204 
L4:     iload_2 
L5:     aload_1 
L6:     arraylength 
L7:     if_icmpgt L204 
L10:    iload_3 
L11:    iflt L204 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    iload_2 
L18:    isub 
L19:    if_icmpgt L204 
L22:    iconst_0 
L23:    istore 4 
L25:    iload_2 
L26:    istore 5 
L28:    aload_0 
L29:    getfield [31] 
L32:    dup 
L33:    astore 6 
L35:    monitorenter 
        .catch [0] from L36 to L147 using L200 
L36:    aload_0 
L37:    getfield [28] 
L40:    ifnull L187 
L43:    iconst_0 
L44:    istore 7 
L46:    iconst_1 
L47:    istore 8 
L49:    aload_0 
L50:    getfield [34] 
L53:    aload_0 
L54:    getfield [33] 
L57:    if_icmpge L175 
L60:    aload_0 
L61:    aload_1 
L62:    iload_2 
L63:    iload_3 
L64:    invokespecial [50] 
L67:    istore 7 
L69:    iload 4 
L71:    iload 7 
L73:    iadd 
L74:    istore 4 
L76:    aload_0 
L77:    getfield [29] 
L80:    invokevirtual [42] 
L83:    istore 8 
L85:    goto L175 
L88:    iload 5 
L90:    iload 7 
L92:    iadd 
L93:    istore 5 
L95:    iload 4 
L97:    ifle L121 
L100:   iload 8 
L102:   ifgt L121 
L105:   aload_0 
L106:   getfield [29] 
L109:   invokevirtual [42] 
L112:   dup 
L113:   istore 8 
L115:   ifgt L121 
L118:   goto L181 
L121:   aload_0 
L122:   invokespecial [51] 
L125:   istore 9 
L127:   iload 9 
L129:   iconst_m1 
L130:   if_icmpne L148 
L133:   iload 4 
L135:   ifne L142 
L138:   iconst_m1 
L139:   goto L144 
L142:   iload 4 
L144:   aload 6 
L146:   monitorexit 
L147:   areturn 
        .catch [0] from L148 to L186 using L200 
L148:   iload 8 
L150:   iload 9 
L152:   isub 
L153:   istore 8 
L155:   aload_0 
L156:   aload_1 
L157:   iload 5 
L159:   iload_3 
L160:   iload 4 
L162:   isub 
L163:   invokespecial [50] 
L166:   istore 7 
L168:   iload 4 
L170:   iload 7 
L172:   iadd 
L173:   istore 4 
L175:   iload 4 
L177:   iload_3 
L178:   if_icmplt L88 
L181:   iload 4 
L183:   aload 6 
L185:   monitorexit 
L186:   areturn 
        .catch [0] from L187 to L203 using L200 
L187:   new [59] 
L190:   dup 
L191:   ldc [26] 
L193:   invokestatic [20] 
L196:   invokespecial [52] 
L199:   athrow 
L200:   aload 6 
L202:   monitorexit 
L203:   athrow 
L204:   new [65] 
L207:   dup 
L208:   invokespecial [53] 
L211:   athrow 
L212:   
    .end code 
.end method 

.method public [311] : [312] 
    .attribute [294] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [31] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L42 using L56 
L7:     aload_0 
L8:     getfield [28] 
L11:    ifnull L43 
L14:    aload_0 
L15:    getfield [34] 
L18:    aload_0 
L19:    getfield [33] 
L22:    if_icmplt L39 
L25:    aload_0 
L26:    getfield [29] 
L29:    invokevirtual [42] 
L32:    ifgt L39 
L35:    iconst_0 
L36:    goto L40 
L39:    iconst_1 
L40:    aload_1 
L41:    monitorexit 
L42:    areturn 
        .catch [0] from L43 to L58 using L56 
L43:    new [59] 
L46:    dup 
L47:    ldc [26] 
L49:    invokestatic [20] 
L52:    invokespecial [52] 
L55:    athrow 
L56:    aload_1 
L57:    monitorexit 
L58:    athrow 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [66] 
.const [3] = Class [67] 
.const [4] = Class [68] 
.const [5] = String [69] 
.const [6] = String [70] 
.const [7] = Method [71] [72] 
.const [8] = Class [73] 
.const [9] = Class [74] 
.const [10] = Method [75] [76] 
.const [11] = Class [77] 
.const [12] = Class [78] 
.const [13] = Method [79] [80] 
.const [14] = Class [81] 
.const [15] = Class [82] 
.const [16] = Method [83] [84] 
.const [17] = Class [85] 
.const [18] = Class [86] 
.const [19] = String [87] 
.const [20] = Method [88] [89] 
.const [21] = Class [90] 
.const [22] = Class [91] 
.const [23] = Class [92] 
.const [24] = Class [93] 
.const [25] = Class [94] 
.const [26] = String [95] 
.const [27] = Class [96] 
.const [28] = Field [97] [98] 
.const [29] = Field [99] [100] 
.const [30] = Field [101] [102] 
.const [31] = Field [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Field [107] [108] 
.const [34] = Field [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Method [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Method [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Method [145] [146] 
.const [53] = Method [147] [148] 
.const [54] = Field [149] [150] 
.const [55] = Field [151] [152] 
.const [56] = Class [153] 
.const [57] = Field [154] [155] 
.const [58] = Class [156] 
.const [59] = Class [157] 
.const [60] = Field [158] [159] 
.const [61] = Field [160] [161] 
.const [62] = Field [162] [163] 
.const [63] = Class [164] 
.const [64] = Class [165] 
.const [65] = Class [166] 
.const [66] = Utf8 java/io/InputStreamReader 
.const [67] = Utf8 java/io/Reader 
.const [68] = Utf8 com/ibm/oti/util/PriviAction 
.const [69] = Utf8 'file.encoding' 
.const [70] = Utf8 ISO8859_1 
.const [71] = Class [167] 
.const [72] = NameAndType [168] [169] 
.const [73] = Utf8 java/security/AccessController 
.const [74] = Utf8 java/lang/String 
.const [75] = Class [170] 
.const [76] = NameAndType [171] [172] 
.const [77] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [78] = Utf8 java/io/UnsupportedEncodingException 
.const [79] = Class [173] 
.const [80] = NameAndType [174] [175] 
.const [81] = Utf8 java/io/IOException 
.const [82] = Utf8 java/io/InputStream 
.const [83] = Class [176] 
.const [84] = NameAndType [177] [178] 
.const [85] = Utf8 java/lang/System 
.const [86] = Utf8 java/io/CharConversionException 
.const [87] = Utf8 K01a0 
.const [88] = Class [179] 
.const [89] = NameAndType [180] [181] 
.const [90] = Utf8 com/ibm/oti/util/Msg 
.const [91] = Utf8 com/ibm/oti/io/CharBuffer 
.const [92] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 K0070 
.const [96] = Utf8 java/lang/IndexOutOfBoundsException 
.const [97] = Class [182] 
.const [98] = NameAndType [183] [184] 
.const [99] = Class [185] 
.const [100] = NameAndType [186] [187] 
.const [101] = Class [188] 
.const [102] = NameAndType [189] [190] 
.const [103] = Class [191] 
.const [104] = NameAndType [192] [193] 
.const [105] = Class [194] 
.const [106] = NameAndType [195] [196] 
.const [107] = Class [197] 
.const [108] = NameAndType [198] [199] 
.const [109] = Class [200] 
.const [110] = NameAndType [201] [202] 
.const [111] = Class [203] 
.const [112] = NameAndType [204] [205] 
.const [113] = Class [206] 
.const [114] = NameAndType [207] [208] 
.const [115] = Class [209] 
.const [116] = NameAndType [210] [211] 
.const [117] = Class [212] 
.const [118] = NameAndType [213] [214] 
.const [119] = Class [215] 
.const [120] = NameAndType [216] [217] 
.const [121] = Class [218] 
.const [122] = NameAndType [219] [220] 
.const [123] = Class [221] 
.const [124] = NameAndType [222] [223] 
.const [125] = Class [224] 
.const [126] = NameAndType [225] [226] 
.const [127] = Class [227] 
.const [128] = NameAndType [228] [229] 
.const [129] = Class [230] 
.const [130] = NameAndType [231] [232] 
.const [131] = Class [233] 
.const [132] = NameAndType [234] [235] 
.const [133] = Class [236] 
.const [134] = NameAndType [237] [238] 
.const [135] = Class [239] 
.const [136] = NameAndType [240] [241] 
.const [137] = Class [242] 
.const [138] = NameAndType [243] [244] 
.const [139] = Class [245] 
.const [140] = NameAndType [246] [247] 
.const [141] = Class [248] 
.const [142] = NameAndType [249] [250] 
.const [143] = Class [251] 
.const [144] = NameAndType [252] [253] 
.const [145] = Class [254] 
.const [146] = NameAndType [255] [256] 
.const [147] = Class [257] 
.const [148] = NameAndType [258] [259] 
.const [149] = Class [260] 
.const [150] = NameAndType [261] [262] 
.const [151] = Class [263] 
.const [152] = NameAndType [264] [265] 
.const [153] = Utf8 com/ibm/oti/util/PriviAction 
.const [154] = Class [266] 
.const [155] = NameAndType [267] [268] 
.const [156] = Utf8 java/io/UnsupportedEncodingException 
.const [157] = Utf8 java/io/IOException 
.const [158] = Class [269] 
.const [159] = NameAndType [270] [271] 
.const [160] = Class [272] 
.const [161] = NameAndType [273] [274] 
.const [162] = Class [275] 
.const [163] = NameAndType [276] [277] 
.const [164] = Utf8 java/io/CharConversionException 
.const [165] = Utf8 com/ibm/oti/io/CharBuffer 
.const [166] = Utf8 java/lang/IndexOutOfBoundsException 
.const [167] = Utf8 java/security/AccessController 
.const [168] = Utf8 doPrivileged 
.const [169] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [170] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [171] = Utf8 getDefaultConverter 
.const [172] = Utf8 (Ljava/lang/String;)Lcom/ibm/oti/io/CharacterConverter; 
.const [173] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [174] = Utf8 getConverter 
.const [175] = Utf8 (Ljava/lang/String;)Lcom/ibm/oti/io/CharacterConverter; 
.const [176] = Utf8 java/lang/System 
.const [177] = Utf8 arraycopy 
.const [178] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [179] = Utf8 com/ibm/oti/util/Msg 
.const [180] = Utf8 getString 
.const [181] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [182] = Utf8 java/io/InputStreamReader 
.const [183] = Utf8 bytes 
.const [184] = Utf8 [B 
.const [185] = Utf8 java/io/InputStreamReader 
.const [186] = Utf8 in 
.const [187] = Utf8 Ljava/io/InputStream; 
.const [188] = Utf8 java/io/InputStreamReader 
.const [189] = Utf8 converter 
.const [190] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [191] = Utf8 java/io/InputStreamReader 
.const [192] = Utf8 lock 
.const [193] = Utf8 Ljava/lang/Object; 
.const [194] = Utf8 java/io/InputStream 
.const [195] = Utf8 close 
.const [196] = Utf8 ()V 
.const [197] = Utf8 java/io/InputStreamReader 
.const [198] = Utf8 count 
.const [199] = Utf8 I 
.const [200] = Utf8 java/io/InputStreamReader 
.const [201] = Utf8 pos 
.const [202] = Utf8 I 
.const [203] = Utf8 java/io/InputStream 
.const [204] = Utf8 read 
.const [205] = Utf8 ([BII)I 
.const [206] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [207] = Utf8 convert 
.const [208] = Utf8 ([BIILcom/ibm/oti/io/CharBuffer;)I 
.const [209] = Utf8 com/ibm/oti/io/CharBuffer 
.const [210] = Utf8 getPos 
.const [211] = Utf8 ()I 
.const [212] = Utf8 com/ibm/oti/io/NativeCharacterConverter 
.const [213] = Utf8 getJavaEncoding 
.const [214] = Utf8 ()Ljava/lang/String; 
.const [215] = Utf8 java/lang/Class 
.const [216] = Utf8 getName 
.const [217] = Utf8 ()Ljava/lang/String; 
.const [218] = Utf8 java/lang/String 
.const [219] = Utf8 indexOf 
.const [220] = Utf8 (I)I 
.const [221] = Utf8 java/lang/String 
.const [222] = Utf8 substring 
.const [223] = Utf8 (I)Ljava/lang/String; 
.const [224] = Utf8 java/io/InputStream 
.const [225] = Utf8 available 
.const [226] = Utf8 ()I 
.const [227] = Utf8 java/io/Reader 
.const [228] = Utf8 <init> 
.const [229] = Utf8 (Ljava/lang/Object;)V 
.const [230] = Utf8 com/ibm/oti/util/PriviAction 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [233] = Utf8 java/io/UnsupportedEncodingException 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Ljava/lang/String;)V 
.const [236] = Utf8 java/io/CharConversionException 
.const [237] = Utf8 <init> 
.const [238] = Utf8 (Ljava/lang/String;)V 
.const [239] = Utf8 com/ibm/oti/io/CharBuffer 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ([CII)V 
.const [242] = Utf8 java/io/CharConversionException 
.const [243] = Utf8 <init> 
.const [244] = Utf8 ()V 
.const [245] = Utf8 java/lang/Object 
.const [246] = Utf8 getClass 
.const [247] = Utf8 ()Ljava/lang/Class; 
.const [248] = Utf8 java/io/InputStreamReader 
.const [249] = Utf8 convert 
.const [250] = Utf8 ([CII)I 
.const [251] = Utf8 java/io/InputStreamReader 
.const [252] = Utf8 fillbuf 
.const [253] = Utf8 ()I 
.const [254] = Utf8 java/io/IOException 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (Ljava/lang/String;)V 
.const [257] = Utf8 java/lang/IndexOutOfBoundsException 
.const [258] = Utf8 <init> 
.const [259] = Utf8 ()V 
.const [260] = Utf8 java/io/InputStreamReader 
.const [261] = Utf8 bytes 
.const [262] = Utf8 [B 
.const [263] = Utf8 java/io/InputStreamReader 
.const [264] = Utf8 in 
.const [265] = Utf8 Ljava/io/InputStream; 
.const [266] = Utf8 java/io/InputStreamReader 
.const [267] = Utf8 converter 
.const [268] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [269] = Utf8 java/io/InputStreamReader 
.const [270] = Utf8 count 
.const [271] = Utf8 I 
.const [272] = Utf8 java/io/InputStreamReader 
.const [273] = Utf8 pos 
.const [274] = Utf8 I 
.const [275] = Utf8 java/io/InputStreamReader 
.const [276] = Utf8 charsAvailable 
.const [277] = Utf8 I 
.const [278] = Utf8 java/io/InputStreamReader 
.const [279] = Class [278] 
.const [280] = Utf8 java/io/Reader 
.const [281] = Class [280] 
.const [282] = Utf8 in 
.const [283] = Utf8 Ljava/io/InputStream; 
.const [284] = Utf8 converter 
.const [285] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [286] = Utf8 bytes 
.const [287] = Utf8 [B 
.const [288] = Utf8 pos 
.const [289] = Utf8 I 
.const [290] = Utf8 count 
.const [291] = Utf8 I 
.const [292] = Utf8 charsAvailable 
.const [293] = Utf8 I 
.const [294] = Utf8 Code 
.const [295] = Utf8 <init> 
.const [296] = Utf8 (Ljava/io/InputStream;)V 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (Ljava/io/InputStream;Ljava/lang/String;)V 
.const [299] = Utf8 close 
.const [300] = Utf8 ()V 
.const [301] = Utf8 fillbuf 
.const [302] = Utf8 ()I 
.const [303] = Utf8 convert 
.const [304] = Utf8 ([CII)I 
.const [305] = Utf8 getEncoding 
.const [306] = Utf8 ()Ljava/lang/String; 
.const [307] = Utf8 read 
.const [308] = Utf8 ()I 
.const [309] = Utf8 read 
.const [310] = Utf8 ([CII)I 
.const [311] = Utf8 ready 
.const [312] = Utf8 ()Z 
.end class 
