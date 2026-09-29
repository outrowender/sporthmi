.version 50 0 
.class public super [381] 
.super [383] 
.implements [385] 
.field private [386] [387] 
.field private [388] [389] 
.field private [390] [391] 
.field private [392] [393] 
.field private [394] [395] 
.field private [396] [397] 
.field private [398] [399] 
.field private [400] [401] 
.field private [402] [403] 

.method public annotation [405] : [406] 
    .attribute [404] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [407] : [408] 
    .attribute [404] .code stack 5 locals 2 
        .catch [8] from L0 to L133 using L134 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [54] 
L5:     aload_2 
L6:     ldc [2] 
L8:     new [70] 
L11:    dup 
L12:    aload_0 
L13:    getfield [36] 
L16:    invokespecial [55] 
L19:    invokevirtual [37] 
L22:    aload_2 
L23:    ldc [4] 
L25:    new [70] 
L28:    dup 
L29:    aload_0 
L30:    getfield [38] 
L33:    invokespecial [55] 
L36:    invokevirtual [37] 
L39:    aload_2 
L40:    ldc [5] 
L42:    new [73] 
L45:    dup 
L46:    aload_0 
L47:    getfield [39] 
L50:    invokespecial [56] 
L53:    invokevirtual [37] 
L56:    aload_2 
L57:    ldc [7] 
L59:    new [73] 
L62:    dup 
L63:    aload_0 
L64:    getfield [40] 
L67:    invokespecial [56] 
L70:    invokevirtual [37] 
L73:    aload_0 
L74:    getfield [41] 
L77:    newarray byte 
L79:    astore_3 
L80:    aload_0 
L81:    aload_0 
L82:    getfield [42] 
L85:    newarray byte 
L87:    putfield [78] 
L90:    aload_1 
L91:    aload_3 
L92:    invokevirtual [44] 
L95:    pop 
L96:    aload_1 
L97:    aload_0 
L98:    getfield [43] 
L101:   invokevirtual [44] 
L104:   pop 
L105:   aload_0 
L106:   aload_0 
L107:   aload_3 
L108:   invokespecial [57] 
L111:   putfield [79] 
L114:   aload_0 
L115:   iconst_0 
L116:   invokespecial [58] 
L119:   astore 4 
L121:   aload_0 
L122:   aconst_null 
L123:   putfield [79] 
L126:   aload_0 
L127:   aconst_null 
L128:   putfield [78] 
L131:   aload 4 
L133:   areturn 
L134:   astore_3 
L135:   new [80] 
L138:   dup 
L139:   new [81] 
L142:   dup 
L143:   invokespecial [59] 
L146:   ldc [11] 
L148:   invokevirtual [46] 
L151:   aload_3 
L152:   invokevirtual [47] 
L155:   invokevirtual [46] 
L158:   invokevirtual [48] 
L161:   invokespecial [60] 
L164:   athrow 
L165:   nop 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 

.method private [409] : [410] 
    .attribute [404] .code stack 4 locals 11 
L0:     aload_0 
L1:     getfield [45] 
L4:     iload_1 
L5:     iaload 
L6:     istore_2 
L7:     aload_0 
L8:     getfield [45] 
L11:    iload_1 
L12:    iconst_1 
L13:    iadd 
L14:    iaload 
L15:    istore_3 
L16:    iload_2 
L17:    tableswitch 1 
            L68 
            L167 
            L322 
            L335 
            L294 
            L264 
            L251 
            L239 
            L277 
            default : L363 

L68:    aload_0 
L69:    getfield [45] 
L72:    iload_3 
L73:    iaload 
L74:    istore 5 
L76:    aload_0 
L77:    getfield [45] 
L80:    iload_3 
L81:    iconst_1 
L82:    iadd 
L83:    iaload 
L84:    iconst_2 
L85:    imul 
L86:    istore 6 
L88:    iload_3 
L89:    iconst_2 
L90:    iadd 
L91:    istore 7 
L93:    new [82] 
L96:    dup 
L97:    invokespecial [61] 
L100:   astore 8 
L102:   iconst_0 
L103:   istore 9 
L105:   iload 9 
L107:   iload 5 
L109:   if_icmpge L160 
L112:   aload_0 
L113:   getfield [45] 
L116:   iload 7 
L118:   iload 9 
L120:   iadd 
L121:   iaload 
L122:   istore 10 
L124:   aload_0 
L125:   iload 10 
L127:   invokespecial [62] 
L130:   astore 11 
L132:   aload_0 
L133:   iload 6 
L135:   iload 9 
L137:   iconst_2 
L138:   imul 
L139:   iadd 
L140:   invokespecial [58] 
L143:   astore 12 
L145:   aload 8 
L147:   aload 11 
L149:   aload 12 
L151:   invokevirtual [37] 
L154:   iinc 9 1 
L157:   goto L105 
L160:   aload 8 
L162:   astore 4 
L164:   goto L390 
L167:   aload_0 
L168:   getfield [45] 
L171:   iload_3 
L172:   iaload 
L173:   istore 5 
L175:   aload_0 
L176:   getfield [45] 
L179:   iload_3 
L180:   iconst_1 
L181:   iadd 
L182:   iaload 
L183:   iconst_2 
L184:   imul 
L185:   istore 6 
L187:   new [83] 
L190:   dup 
L191:   invokespecial [63] 
L194:   astore 7 
L196:   iconst_0 
L197:   istore 8 
L199:   iload 8 
L201:   iload 5 
L203:   if_icmpge L232 
L206:   aload_0 
L207:   iload 6 
L209:   iload 8 
L211:   iconst_2 
L212:   imul 
L213:   iadd 
L214:   invokespecial [58] 
L217:   astore 9 
L219:   aload 7 
L221:   aload 9 
L223:   invokevirtual [49] 
L226:   iinc 8 1 
L229:   goto L199 
L232:   aload 7 
L234:   astore 4 
L236:   goto L390 
L239:   new [84] 
L242:   dup 
L243:   invokespecial [64] 
L246:   astore 4 
L248:   goto L390 
L251:   new [70] 
L254:   dup 
L255:   iconst_0 
L256:   invokespecial [55] 
L259:   astore 4 
L261:   goto L390 
L264:   new [70] 
L267:   dup 
L268:   iconst_1 
L269:   invokespecial [55] 
L272:   astore 4 
L274:   goto L390 
L277:   new [85] 
L280:   dup 
L281:   aload_0 
L282:   iload_3 
L283:   invokespecial [62] 
L286:   invokespecial [65] 
L289:   astore 4 
L291:   goto L390 
L294:   aload_0 
L295:   iload_3 
L296:   invokespecial [62] 
L299:   astore 5 
L301:   aload 5 
L303:   invokestatic [16] 
L306:   dstore 6 
L308:   new [86] 
L311:   dup 
L312:   dload 6 
L314:   invokespecial [66] 
L317:   astore 4 
L319:   goto L390 
L322:   new [73] 
L325:   dup 
L326:   iload_3 
L327:   invokespecial [56] 
L330:   astore 4 
L332:   goto L390 
L335:   aload_0 
L336:   iload_3 
L337:   invokespecial [62] 
L340:   astore 5 
L342:   aload 5 
L344:   invokestatic [18] 
L347:   istore 6 
L349:   new [73] 
L352:   dup 
L353:   iload 6 
L355:   invokespecial [56] 
L358:   astore 4 
L360:   goto L390 
L363:   new [80] 
L366:   dup 
L367:   new [81] 
L370:   dup 
L371:   invokespecial [59] 
L374:   ldc [19] 
L376:   invokevirtual [46] 
L379:   iload_2 
L380:   invokevirtual [50] 
L383:   invokevirtual [48] 
L386:   invokespecial [60] 
L389:   athrow 
L390:   aload 4 
L392:   areturn 
L393:   nop 
L394:   nop 
L395:   nop 
L396:   
    .end code 
.end method 

.method private [411] : [412] 
    .attribute [404] .code stack 5 locals 4 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     istore_3 
L4:     aload_0 
L5:     getfield [43] 
L8:     iload_3 
L9:     baload 
L10:    ifeq L22 
L13:    iinc 3 1 
L16:    iinc 2 1 
L19:    goto L4 
L22:    iload_2 
L23:    newarray byte 
L25:    astore 4 
L27:    aload_0 
L28:    getfield [43] 
L31:    iload_1 
L32:    aload 4 
L34:    iconst_0 
L35:    iload_2 
L36:    invokestatic [20] 
        .catch [22] from L39 to L51 using L52 
L39:    getstatic [21] 
L42:    aload 4 
L44:    invokevirtual [51] 
L47:    astore 5 
L49:    aload 5 
L51:    areturn 
L52:    astore 5 
L54:    new [87] 
L57:    dup 
L58:    aload 4 
L60:    invokespecial [67] 
L63:    areturn 
L64:    
    .end code 
.end method 

.method private [413] : [414] 
    .attribute [404] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [41] 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [36] 
L9:     ifeq L19 
L12:    iload_2 
L13:    iconst_4 
L14:    idiv 
L15:    istore_2 
L16:    goto L23 
L19:    iload_2 
L20:    iconst_2 
L21:    idiv 
L22:    istore_2 
L23:    iload_2 
L24:    newarray int 
L26:    astore_3 
L27:    aload_0 
L28:    getfield [36] 
L31:    ifeq L74 
L34:    iconst_0 
L35:    istore 4 
L37:    iconst_0 
L38:    istore 5 
L40:    iload 5 
L42:    iload_2 
L43:    if_icmpge L71 
L46:    aload_3 
L47:    iload 5 
L49:    aload_0 
L50:    getfield [52] 
L53:    aload_1 
L54:    iload 4 
L56:    invokeinterface [89] 0 
L61:    iastore 
L62:    iinc 4 4 
L65:    iinc 5 1 
L68:    goto L40 
L71:    goto L111 
L74:    iconst_0 
L75:    istore 4 
L77:    iconst_0 
L78:    istore 5 
L80:    iload 5 
L82:    iload_2 
L83:    if_icmpge L111 
L86:    aload_3 
L87:    iload 5 
L89:    aload_0 
L90:    getfield [52] 
L93:    aload_1 
L94:    iload 4 
L96:    invokeinterface [90] 0 
L101:   iastore 
L102:   iinc 4 2 
L105:   iinc 5 1 
L108:   goto L80 
L111:   aload_3 
L112:   areturn 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method private [415] : [416] 
    .attribute [404] .code stack 4 locals 2 
L0:     bipush 16 
L2:     newarray byte 
L4:     astore_2 
L5:     aload_1 
L6:     aload_2 
L7:     invokevirtual [44] 
L10:    pop 
L11:    aload_2 
L12:    iconst_0 
L13:    baload 
L14:    bipush -27 
L16:    if_icmpne L35 
L19:    aload_2 
L20:    iconst_1 
L21:    baload 
L22:    bipush 11 
L24:    if_icmpne L35 
L27:    aload_2 
L28:    iconst_2 
L29:    baload 
L30:    bipush -49 
L32:    if_icmpeq L45 
L35:    new [80] 
L38:    dup 
L39:    ldc [24] 
L41:    invokespecial [60] 
L44:    athrow 
L45:    aload_2 
L46:    iconst_3 
L47:    baload 
L48:    istore_3 
L49:    aload_0 
L50:    aload_2 
L51:    iconst_3 
L52:    baload 
L53:    iconst_4 
L54:    ishr 
L55:    putfield [75] 
L58:    aload_0 
L59:    getfield [40] 
L62:    iconst_1 
L63:    if_icmpeq L76 
L66:    new [80] 
L69:    dup 
L70:    ldc [25] 
L72:    invokespecial [60] 
L75:    athrow 
L76:    aload_0 
L77:    iload_3 
L78:    iconst_1 
L79:    iand 
L80:    iconst_1 
L81:    if_icmpne L88 
L84:    iconst_1 
L85:    goto L89 
L88:    iconst_0 
L89:    putfield [72] 
L92:    aload_0 
L93:    iload_3 
L94:    iconst_2 
L95:    iand 
L96:    iconst_2 
L97:    if_icmpne L104 
L100:   iconst_1 
L101:   goto L105 
L104:   iconst_0 
L105:   putfield [71] 
L108:   aload_0 
L109:   getfield [38] 
L112:   ifeq L129 
L115:   aload_0 
L116:   new [91] 
L119:   dup 
L120:   invokespecial [68] 
L123:   putfield [88] 
L126:   goto L140 
L129:   aload_0 
L130:   new [92] 
L133:   dup 
L134:   invokespecial [69] 
L137:   putfield [88] 
L140:   aload_0 
L141:   aload_0 
L142:   getfield [52] 
L145:   aload_2 
L146:   iconst_4 
L147:   invokeinterface [89] 0 
L152:   putfield [74] 
L155:   aload_0 
L156:   aload_0 
L157:   getfield [52] 
L160:   aload_2 
L161:   bipush 8 
L163:   invokeinterface [89] 0 
L168:   putfield [76] 
L171:   aload_0 
L172:   aload_0 
L173:   getfield [52] 
L176:   aload_2 
L177:   bipush 12 
L179:   invokeinterface [89] 0 
L184:   putfield [77] 
L187:   return 
L188:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [93] 
.const [3] = Class [94] 
.const [4] = String [95] 
.const [5] = String [96] 
.const [6] = Class [97] 
.const [7] = String [98] 
.const [8] = Class [99] 
.const [9] = Class [100] 
.const [10] = Class [101] 
.const [11] = String [102] 
.const [12] = Class [103] 
.const [13] = Class [104] 
.const [14] = Class [105] 
.const [15] = Class [106] 
.const [16] = Method [107] [108] 
.const [17] = Class [109] 
.const [18] = Method [110] [111] 
.const [19] = String [112] 
.const [20] = Method [113] [114] 
.const [21] = Field [115] [116] 
.const [22] = Class [117] 
.const [23] = Class [118] 
.const [24] = String [119] 
.const [25] = String [120] 
.const [26] = Class [121] 
.const [27] = Class [122] 
.const [28] = Class [123] 
.const [29] = Class [124] 
.const [30] = Class [125] 
.const [31] = Class [126] 
.const [32] = Class [127] 
.const [33] = Class [128] 
.const [34] = Class [129] 
.const [35] = Class [130] 
.const [36] = Field [131] [132] 
.const [37] = Method [133] [134] 
.const [38] = Field [135] [136] 
.const [39] = Field [137] [138] 
.const [40] = Field [139] [140] 
.const [41] = Field [141] [142] 
.const [42] = Field [143] [144] 
.const [43] = Field [145] [146] 
.const [44] = Method [147] [148] 
.const [45] = Field [149] [150] 
.const [46] = Method [151] [152] 
.const [47] = Method [153] [154] 
.const [48] = Method [155] [156] 
.const [49] = Method [157] [158] 
.const [50] = Method [159] [160] 
.const [51] = Method [161] [162] 
.const [52] = Field [163] [164] 
.const [53] = Method [165] [166] 
.const [54] = Method [167] [168] 
.const [55] = Method [169] [170] 
.const [56] = Method [171] [172] 
.const [57] = Method [173] [174] 
.const [58] = Method [175] [176] 
.const [59] = Method [177] [178] 
.const [60] = Method [179] [180] 
.const [61] = Method [181] [182] 
.const [62] = Method [183] [184] 
.const [63] = Method [185] [186] 
.const [64] = Method [187] [188] 
.const [65] = Method [189] [190] 
.const [66] = Method [191] [192] 
.const [67] = Method [193] [194] 
.const [68] = Method [195] [196] 
.const [69] = Method [197] [198] 
.const [70] = Class [199] 
.const [71] = Field [200] [201] 
.const [72] = Field [202] [203] 
.const [73] = Class [204] 
.const [74] = Field [205] [206] 
.const [75] = Field [207] [208] 
.const [76] = Field [209] [210] 
.const [77] = Field [211] [212] 
.const [78] = Field [213] [214] 
.const [79] = Field [215] [216] 
.const [80] = Class [217] 
.const [81] = Class [218] 
.const [82] = Class [219] 
.const [83] = Class [220] 
.const [84] = Class [221] 
.const [85] = Class [222] 
.const [86] = Class [223] 
.const [87] = Class [224] 
.const [88] = Field [225] [226] 
.const [89] = InterfaceMethod [227] [228] 
.const [90] = InterfaceMethod [229] [230] 
.const [91] = Class [231] 
.const [92] = Class [232] 
.const [93] = Utf8 bits32 
.const [94] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [95] = Utf8 littleEndian 
.const [96] = Utf8 numElements 
.const [97] = Utf8 de/esolutions/fw/util/config/model/ConfigInteger 
.const [98] = Utf8 version 
.const [99] = Utf8 java/io/IOException 
.const [100] = Utf8 de/esolutions/fw/util/config/reader/ReadConfigException 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 'IO: ' 
.const [103] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [104] = Utf8 de/esolutions/fw/util/config/model/ConfigArray 
.const [105] = Utf8 de/esolutions/fw/util/config/model/ConfigNullValue 
.const [106] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [107] = Class [233] 
.const [108] = NameAndType [234] [235] 
.const [109] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [110] = Class [236] 
.const [111] = NameAndType [237] [238] 
.const [112] = Utf8 'Invalid BCF Element Type: ' 
.const [113] = Class [239] 
.const [114] = NameAndType [240] [241] 
.const [115] = Class [242] 
.const [116] = NameAndType [243] [244] 
.const [117] = Utf8 java/io/UnsupportedEncodingException 
.const [118] = Utf8 java/lang/String 
.const [119] = Utf8 'No BCF Header found!' 
.const [120] = Utf8 'Invalid BCF Version found!' 
.const [121] = Utf8 de/esolutions/fw/util/commons/miniser/LEMiniIntDeserializer 
.const [122] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntDeserializer 
.const [123] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 java/io/InputStream 
.const [126] = Utf8 java/lang/Double 
.const [127] = Utf8 java/lang/Integer 
.const [128] = Utf8 java/lang/System 
.const [129] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [130] = Utf8 de/esolutions/fw/util/commons/miniser/IMiniIntDeserializer 
.const [131] = Class [245] 
.const [132] = NameAndType [246] [247] 
.const [133] = Class [248] 
.const [134] = NameAndType [249] [250] 
.const [135] = Class [251] 
.const [136] = NameAndType [252] [253] 
.const [137] = Class [254] 
.const [138] = NameAndType [255] [256] 
.const [139] = Class [257] 
.const [140] = NameAndType [258] [259] 
.const [141] = Class [260] 
.const [142] = NameAndType [261] [262] 
.const [143] = Class [263] 
.const [144] = NameAndType [264] [265] 
.const [145] = Class [266] 
.const [146] = NameAndType [267] [268] 
.const [147] = Class [269] 
.const [148] = NameAndType [270] [271] 
.const [149] = Class [272] 
.const [150] = NameAndType [273] [274] 
.const [151] = Class [275] 
.const [152] = NameAndType [276] [277] 
.const [153] = Class [278] 
.const [154] = NameAndType [279] [280] 
.const [155] = Class [281] 
.const [156] = NameAndType [282] [283] 
.const [157] = Class [284] 
.const [158] = NameAndType [285] [286] 
.const [159] = Class [287] 
.const [160] = NameAndType [288] [289] 
.const [161] = Class [290] 
.const [162] = NameAndType [291] [292] 
.const [163] = Class [293] 
.const [164] = NameAndType [294] [295] 
.const [165] = Class [296] 
.const [166] = NameAndType [297] [298] 
.const [167] = Class [299] 
.const [168] = NameAndType [300] [301] 
.const [169] = Class [302] 
.const [170] = NameAndType [303] [304] 
.const [171] = Class [305] 
.const [172] = NameAndType [306] [307] 
.const [173] = Class [308] 
.const [174] = NameAndType [309] [310] 
.const [175] = Class [311] 
.const [176] = NameAndType [312] [313] 
.const [177] = Class [314] 
.const [178] = NameAndType [315] [316] 
.const [179] = Class [317] 
.const [180] = NameAndType [318] [319] 
.const [181] = Class [320] 
.const [182] = NameAndType [321] [322] 
.const [183] = Class [323] 
.const [184] = NameAndType [324] [325] 
.const [185] = Class [326] 
.const [186] = NameAndType [327] [328] 
.const [187] = Class [329] 
.const [188] = NameAndType [330] [331] 
.const [189] = Class [332] 
.const [190] = NameAndType [333] [334] 
.const [191] = Class [335] 
.const [192] = NameAndType [336] [337] 
.const [193] = Class [338] 
.const [194] = NameAndType [339] [340] 
.const [195] = Class [341] 
.const [196] = NameAndType [342] [343] 
.const [197] = Class [344] 
.const [198] = NameAndType [345] [346] 
.const [199] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [200] = Class [347] 
.const [201] = NameAndType [348] [349] 
.const [202] = Class [350] 
.const [203] = NameAndType [351] [352] 
.const [204] = Utf8 de/esolutions/fw/util/config/model/ConfigInteger 
.const [205] = Class [353] 
.const [206] = NameAndType [354] [355] 
.const [207] = Class [356] 
.const [208] = NameAndType [357] [358] 
.const [209] = Class [359] 
.const [210] = NameAndType [360] [361] 
.const [211] = Class [362] 
.const [212] = NameAndType [363] [364] 
.const [213] = Class [365] 
.const [214] = NameAndType [366] [367] 
.const [215] = Class [368] 
.const [216] = NameAndType [369] [370] 
.const [217] = Utf8 de/esolutions/fw/util/config/reader/ReadConfigException 
.const [218] = Utf8 java/lang/StringBuffer 
.const [219] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [220] = Utf8 de/esolutions/fw/util/config/model/ConfigArray 
.const [221] = Utf8 de/esolutions/fw/util/config/model/ConfigNullValue 
.const [222] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [223] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [224] = Utf8 java/lang/String 
.const [225] = Class [371] 
.const [226] = NameAndType [372] [373] 
.const [227] = Class [374] 
.const [228] = NameAndType [375] [376] 
.const [229] = Class [377] 
.const [230] = NameAndType [378] [379] 
.const [231] = Utf8 de/esolutions/fw/util/commons/miniser/LEMiniIntDeserializer 
.const [232] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntDeserializer 
.const [233] = Utf8 java/lang/Double 
.const [234] = Utf8 parseDouble 
.const [235] = Utf8 (Ljava/lang/String;)D 
.const [236] = Utf8 java/lang/Integer 
.const [237] = Utf8 parseInt 
.const [238] = Utf8 (Ljava/lang/String;)I 
.const [239] = Utf8 java/lang/System 
.const [240] = Utf8 arraycopy 
.const [241] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [242] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [243] = Utf8 UTF8 
.const [244] = Utf8 Lde/esolutions/fw/util/commons/StringConverter; 
.const [245] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [246] = Utf8 bits32 
.const [247] = Utf8 Z 
.const [248] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [249] = Utf8 addValue 
.const [250] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;)V 
.const [251] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [252] = Utf8 littleEndian 
.const [253] = Utf8 Z 
.const [254] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [255] = Utf8 numElements 
.const [256] = Utf8 I 
.const [257] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [258] = Utf8 version 
.const [259] = Utf8 I 
.const [260] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [261] = Utf8 elementBytes 
.const [262] = Utf8 I 
.const [263] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [264] = Utf8 stringBytes 
.const [265] = Utf8 I 
.const [266] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [267] = Utf8 rawStrings 
.const [268] = Utf8 [B 
.const [269] = Utf8 java/io/InputStream 
.const [270] = Utf8 read 
.const [271] = Utf8 ([B)I 
.const [272] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [273] = Utf8 elements 
.const [274] = Utf8 [I 
.const [275] = Utf8 java/lang/StringBuffer 
.const [276] = Utf8 append 
.const [277] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [278] = Utf8 java/io/IOException 
.const [279] = Utf8 getMessage 
.const [280] = Utf8 ()Ljava/lang/String; 
.const [281] = Utf8 java/lang/StringBuffer 
.const [282] = Utf8 toString 
.const [283] = Utf8 ()Ljava/lang/String; 
.const [284] = Utf8 de/esolutions/fw/util/config/model/ConfigArray 
.const [285] = Utf8 addValue 
.const [286] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;)V 
.const [287] = Utf8 java/lang/StringBuffer 
.const [288] = Utf8 append 
.const [289] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [290] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [291] = Utf8 getString 
.const [292] = Utf8 ([B)Ljava/lang/String; 
.const [293] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [294] = Utf8 deserializer 
.const [295] = Utf8 Lde/esolutions/fw/util/commons/miniser/IMiniIntDeserializer; 
.const [296] = Utf8 java/lang/Object 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [300] = Utf8 readHeader 
.const [301] = Utf8 (Ljava/io/InputStream;)V 
.const [302] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (Z)V 
.const [305] = Utf8 de/esolutions/fw/util/config/model/ConfigInteger 
.const [306] = Utf8 <init> 
.const [307] = Utf8 (I)V 
.const [308] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [309] = Utf8 getElements 
.const [310] = Utf8 ([B)[I 
.const [311] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [312] = Utf8 createConfigValue 
.const [313] = Utf8 (I)Lde/esolutions/fw/util/config/ConfigValue; 
.const [314] = Utf8 java/lang/StringBuffer 
.const [315] = Utf8 <init> 
.const [316] = Utf8 ()V 
.const [317] = Utf8 de/esolutions/fw/util/config/reader/ReadConfigException 
.const [318] = Utf8 <init> 
.const [319] = Utf8 (Ljava/lang/String;)V 
.const [320] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [321] = Utf8 <init> 
.const [322] = Utf8 ()V 
.const [323] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [324] = Utf8 getString 
.const [325] = Utf8 (I)Ljava/lang/String; 
.const [326] = Utf8 de/esolutions/fw/util/config/model/ConfigArray 
.const [327] = Utf8 <init> 
.const [328] = Utf8 ()V 
.const [329] = Utf8 de/esolutions/fw/util/config/model/ConfigNullValue 
.const [330] = Utf8 <init> 
.const [331] = Utf8 ()V 
.const [332] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [333] = Utf8 <init> 
.const [334] = Utf8 (Ljava/lang/String;)V 
.const [335] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [336] = Utf8 <init> 
.const [337] = Utf8 (D)V 
.const [338] = Utf8 java/lang/String 
.const [339] = Utf8 <init> 
.const [340] = Utf8 ([B)V 
.const [341] = Utf8 de/esolutions/fw/util/commons/miniser/LEMiniIntDeserializer 
.const [342] = Utf8 <init> 
.const [343] = Utf8 ()V 
.const [344] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntDeserializer 
.const [345] = Utf8 <init> 
.const [346] = Utf8 ()V 
.const [347] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [348] = Utf8 bits32 
.const [349] = Utf8 Z 
.const [350] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [351] = Utf8 littleEndian 
.const [352] = Utf8 Z 
.const [353] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [354] = Utf8 numElements 
.const [355] = Utf8 I 
.const [356] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [357] = Utf8 version 
.const [358] = Utf8 I 
.const [359] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [360] = Utf8 elementBytes 
.const [361] = Utf8 I 
.const [362] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [363] = Utf8 stringBytes 
.const [364] = Utf8 I 
.const [365] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [366] = Utf8 rawStrings 
.const [367] = Utf8 [B 
.const [368] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [369] = Utf8 elements 
.const [370] = Utf8 [I 
.const [371] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [372] = Utf8 deserializer 
.const [373] = Utf8 Lde/esolutions/fw/util/commons/miniser/IMiniIntDeserializer; 
.const [374] = Utf8 de/esolutions/fw/util/commons/miniser/IMiniIntDeserializer 
.const [375] = Utf8 retrieveInt 
.const [376] = Utf8 ([BI)I 
.const [377] = Utf8 de/esolutions/fw/util/commons/miniser/IMiniIntDeserializer 
.const [378] = Utf8 retrieveShort 
.const [379] = Utf8 ([BI)S 
.const [380] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigReader 
.const [381] = Class [380] 
.const [382] = Utf8 java/lang/Object 
.const [383] = Class [382] 
.const [384] = Utf8 de/esolutions/fw/util/config/reader/IConfigReader 
.const [385] = Class [384] 
.const [386] = Utf8 bits32 
.const [387] = Utf8 Z 
.const [388] = Utf8 littleEndian 
.const [389] = Utf8 Z 
.const [390] = Utf8 version 
.const [391] = Utf8 I 
.const [392] = Utf8 numElements 
.const [393] = Utf8 I 
.const [394] = Utf8 elementBytes 
.const [395] = Utf8 I 
.const [396] = Utf8 stringBytes 
.const [397] = Utf8 I 
.const [398] = Utf8 deserializer 
.const [399] = Utf8 Lde/esolutions/fw/util/commons/miniser/IMiniIntDeserializer; 
.const [400] = Utf8 rawStrings 
.const [401] = Utf8 [B 
.const [402] = Utf8 elements 
.const [403] = Utf8 [I 
.const [404] = Utf8 Code 
.const [405] = Utf8 <init> 
.const [406] = Utf8 ()V 
.const [407] = Utf8 readFromInputStream 
.const [408] = Utf8 (Ljava/io/InputStream;Lde/esolutions/fw/util/config/model/ConfigDictionary;)Lde/esolutions/fw/util/config/ConfigValue; 
.const [409] = Utf8 createConfigValue 
.const [410] = Utf8 (I)Lde/esolutions/fw/util/config/ConfigValue; 
.const [411] = Utf8 getString 
.const [412] = Utf8 (I)Ljava/lang/String; 
.const [413] = Utf8 getElements 
.const [414] = Utf8 ([B)[I 
.const [415] = Utf8 readHeader 
.const [416] = Utf8 (Ljava/io/InputStream;)V 
.end class 
