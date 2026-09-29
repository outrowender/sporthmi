.version 50 0 
.class super [331] 
.super [333] 
.field private static final [334] [335] 
.field private static [336] [337] 
.field private static [338] [339] 
.field [340] [341] 
.field [342] [343] 
.field private [344] [345] 
.field private [346] [347] 
.field [348] [349] 

.method static [351] : [352] 
    .attribute [350] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray byte 
L3:     dup 
L4:     iconst_0 
L5:     bipush 13 
L7:     bastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 10 
L12:    bastore 
L13:    putstatic [54] 
L16:    new [62] 
L19:    dup 
L20:    ldc [6] 
L22:    iconst_0 
L23:    invokespecial [55] 
L26:    putstatic [56] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method [353] : [354] 
    .attribute [350] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     iconst_1 
L6:     newarray byte 
L8:     putfield [63] 
L11:    aload_0 
L12:    iconst_1 
L13:    newarray char 
L15:    putfield [64] 
L18:    aload_0 
L19:    bipush 70 
L21:    newarray byte 
L23:    putfield [65] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [355] : [356] 
    .attribute [350] .code stack 5 locals 6 
L0:     iconst_0 
L1:     istore_3 
L2:     bipush 70 
L4:     istore 4 
L6:     new [66] 
L9:     dup 
L10:    aload_1 
L11:    invokevirtual [36] 
L14:    invokestatic [10] 
L17:    invokespecial [58] 
L20:    ldc [11] 
L22:    invokevirtual [37] 
L25:    invokevirtual [38] 
L28:    ldc [12] 
L30:    invokevirtual [39] 
L33:    astore 5 
L35:    aload 5 
L37:    arraylength 
L38:    iload 4 
L40:    if_icmple L118 
L43:    goto L108 
L46:    aload 5 
L48:    arraylength 
L49:    iload_3 
L50:    isub 
L51:    istore 6 
L53:    iload 6 
L55:    iload 4 
L57:    if_icmple L64 
L60:    iload 4 
L62:    istore 6 
L64:    iload_3 
L65:    ifle L77 
L68:    aload_0 
L69:    getfield [40] 
L72:    bipush 32 
L74:    invokevirtual [41] 
L77:    aload_0 
L78:    getfield [40] 
L81:    aload 5 
L83:    iload_3 
L84:    iload 6 
L86:    invokevirtual [42] 
L89:    aload_0 
L90:    getfield [40] 
L93:    getstatic [4] 
L96:    invokevirtual [43] 
L99:    iload_3 
L100:   iload 6 
L102:   iadd 
L103:   istore_3 
L104:   bipush 69 
L106:   istore 4 
L108:   aload 5 
L110:   arraylength 
L111:   iload_3 
L112:   isub 
L113:   iload 4 
L115:   if_icmpge L46 
L118:   aload 5 
L120:   arraylength 
L121:   iload_3 
L122:   isub 
L123:   istore 6 
L125:   aload 5 
L127:   iload_3 
L128:   aload_0 
L129:   getfield [35] 
L132:   iconst_0 
L133:   iload 6 
L135:   invokestatic [15] 
L138:   iconst_0 
L139:   istore 7 
L141:   goto L317 
L144:   aload_0 
L145:   getfield [34] 
L148:   iconst_0 
L149:   aload_2 
L150:   iload 7 
L152:   invokevirtual [44] 
L155:   castore 
L156:   aload_0 
L157:   getfield [34] 
L160:   iconst_0 
L161:   caload 
L162:   sipush 128 
L165:   if_icmplt L175 
L168:   aload_0 
L169:   getfield [45] 
L172:   ifnonnull L197 
L175:   aload_0 
L176:   getfield [33] 
L179:   iconst_0 
L180:   aload_0 
L181:   getfield [34] 
L184:   iconst_0 
L185:   caload 
L186:   i2b 
L187:   bastore 
L188:   aload_0 
L189:   getfield [33] 
L192:   astore 8 
L194:   goto L212 
L197:   aload_0 
L198:   getfield [45] 
L201:   aload_0 
L202:   getfield [34] 
L205:   iconst_0 
L206:   iconst_1 
L207:   invokevirtual [46] 
L210:   astore 8 
L212:   iload 6 
L214:   aload 8 
L216:   arraylength 
L217:   iadd 
L218:   iload 4 
L220:   if_icmple L270 
L223:   iload 4 
L225:   bipush 70 
L227:   if_icmpeq L239 
L230:   aload_0 
L231:   getfield [40] 
L234:   bipush 32 
L236:   invokevirtual [41] 
L239:   aload_0 
L240:   getfield [40] 
L243:   aload_0 
L244:   getfield [35] 
L247:   iconst_0 
L248:   iload 6 
L250:   invokevirtual [42] 
L253:   aload_0 
L254:   getfield [40] 
L257:   getstatic [4] 
L260:   invokevirtual [43] 
L263:   bipush 69 
L265:   istore 4 
L267:   iconst_0 
L268:   istore 6 
L270:   aload 8 
L272:   arraylength 
L273:   iconst_1 
L274:   if_icmpne L291 
L277:   aload_0 
L278:   getfield [35] 
L281:   iload 6 
L283:   aload 8 
L285:   iconst_0 
L286:   baload 
L287:   bastore 
L288:   goto L306 
L291:   aload 8 
L293:   iconst_0 
L294:   aload_0 
L295:   getfield [35] 
L298:   iload 6 
L300:   aload 8 
L302:   arraylength 
L303:   invokestatic [15] 
L306:   iload 6 
L308:   aload 8 
L310:   arraylength 
L311:   iadd 
L312:   istore 6 
L314:   iinc 7 1 
L317:   iload 7 
L319:   aload_2 
L320:   invokevirtual [47] 
L323:   if_icmplt L144 
L326:   iload 6 
L328:   ifle L371 
L331:   iload 4 
L333:   bipush 70 
L335:   if_icmpeq L347 
L338:   aload_0 
L339:   getfield [40] 
L342:   bipush 32 
L344:   invokevirtual [41] 
L347:   aload_0 
L348:   getfield [40] 
L351:   aload_0 
L352:   getfield [35] 
L355:   iconst_0 
L356:   iload 6 
L358:   invokevirtual [42] 
L361:   aload_0 
L362:   getfield [40] 
L365:   getstatic [4] 
L368:   invokevirtual [43] 
L371:   return 
L372:   
    .end code 
.end method 

.method [357] : [358] 
    .attribute [350] .code stack 4 locals 7 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [67] 
L5:     new [69] 
L8:     dup 
L9:     ldc [18] 
L11:    invokespecial [59] 
L14:    invokestatic [20] 
L17:    checkcast [9] 
L20:    astore_3 
L21:    aload_3 
L22:    ifnull L61 
L25:    ldc [21] 
L27:    aload_3 
L28:    invokevirtual [48] 
L31:    ifeq L37 
L34:    ldc [22] 
L36:    astore_3 
L37:    aload_0 
L38:    aload_3 
L39:    invokestatic [23] 
L42:    putfield [68] 
L45:    aload_0 
L46:    getfield [45] 
L49:    ifnonnull L61 
L52:    new [70] 
L55:    dup 
L56:    aload_3 
L57:    invokespecial [60] 
L60:    athrow 
L61:    aload_1 
L62:    invokestatic [26] 
L65:    getstatic [27] 
L68:    invokevirtual [49] 
L71:    astore 4 
L73:    aload 4 
L75:    ifnull L152 
L78:    aload_0 
L79:    getstatic [27] 
L82:    aload 4 
L84:    invokespecial [61] 
L87:    aload_1 
L88:    invokestatic [26] 
L91:    invokevirtual [50] 
L94:    invokeinterface [71] 0 
L99:    astore 5 
L101:   goto L142 
L104:   aload 5 
L106:   invokeinterface [72] 0 
L111:   checkcast [5] 
L114:   astore 6 
L116:   aload 6 
L118:   getstatic [27] 
L121:   invokevirtual [51] 
L124:   ifne L142 
L127:   aload_0 
L128:   aload 6 
L130:   aload_1 
L131:   invokestatic [26] 
L134:   aload 6 
L136:   invokevirtual [49] 
L139:   invokespecial [61] 
L142:   aload 5 
L144:   invokeinterface [73] 0 
L149:   ifne L104 
L152:   aload_0 
L153:   getfield [40] 
L156:   getstatic [4] 
L159:   invokevirtual [43] 
L162:   aload_1 
L163:   invokestatic [31] 
L166:   invokevirtual [52] 
L169:   invokeinterface [71] 0 
L174:   astore 5 
L176:   goto L274 
L179:   aload 5 
L181:   invokeinterface [72] 0 
L186:   checkcast [9] 
L189:   astore 6 
L191:   aload_0 
L192:   getstatic [7] 
L195:   aload 6 
L197:   invokespecial [61] 
L200:   aload_1 
L201:   invokestatic [31] 
L204:   aload 6 
L206:   invokevirtual [53] 
L209:   checkcast [28] 
L212:   astore 7 
L214:   aload 7 
L216:   invokevirtual [50] 
L219:   invokeinterface [71] 0 
L224:   astore 8 
L226:   goto L254 
L229:   aload 8 
L231:   invokeinterface [72] 0 
L236:   checkcast [5] 
L239:   astore 9 
L241:   aload_0 
L242:   aload 9 
L244:   aload 7 
L246:   aload 9 
L248:   invokevirtual [49] 
L251:   invokespecial [61] 
L254:   aload 8 
L256:   invokeinterface [73] 0 
L261:   ifne L229 
L264:   aload_0 
L265:   getfield [40] 
L268:   getstatic [4] 
L271:   invokevirtual [43] 
L274:   aload 5 
L276:   invokeinterface [73] 0 
L281:   ifne L179 
L284:   return 
L285:   nop 
L286:   nop 
L287:   nop 
L288:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [74] 
.const [3] = Class [75] 
.const [4] = Field [76] [77] 
.const [5] = Class [78] 
.const [6] = String [79] 
.const [7] = Field [80] [81] 
.const [8] = Class [82] 
.const [9] = Class [83] 
.const [10] = Method [84] [85] 
.const [11] = String [86] 
.const [12] = String [87] 
.const [13] = Class [88] 
.const [14] = Class [89] 
.const [15] = Method [90] [91] 
.const [16] = Class [92] 
.const [17] = Class [93] 
.const [18] = String [94] 
.const [19] = Class [95] 
.const [20] = Method [96] [97] 
.const [21] = String [98] 
.const [22] = String [99] 
.const [23] = Method [100] [101] 
.const [24] = Class [102] 
.const [25] = Class [103] 
.const [26] = Method [104] [105] 
.const [27] = Field [106] [107] 
.const [28] = Class [108] 
.const [29] = Class [109] 
.const [30] = Class [110] 
.const [31] = Method [111] [112] 
.const [32] = Class [113] 
.const [33] = Field [114] [115] 
.const [34] = Field [116] [117] 
.const [35] = Field [118] [119] 
.const [36] = Method [120] [121] 
.const [37] = Method [122] [123] 
.const [38] = Method [124] [125] 
.const [39] = Method [126] [127] 
.const [40] = Field [128] [129] 
.const [41] = Method [130] [131] 
.const [42] = Method [132] [133] 
.const [43] = Method [134] [135] 
.const [44] = Method [136] [137] 
.const [45] = Field [138] [139] 
.const [46] = Method [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Method [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Method [148] [149] 
.const [51] = Method [150] [151] 
.const [52] = Method [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Field [156] [157] 
.const [55] = Method [158] [159] 
.const [56] = Field [160] [161] 
.const [57] = Method [162] [163] 
.const [58] = Method [164] [165] 
.const [59] = Method [166] [167] 
.const [60] = Method [168] [169] 
.const [61] = Method [170] [171] 
.const [62] = Class [172] 
.const [63] = Field [173] [174] 
.const [64] = Field [175] [176] 
.const [65] = Field [177] [178] 
.const [66] = Class [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = Class [184] 
.const [70] = Class [185] 
.const [71] = InterfaceMethod [186] [187] 
.const [72] = InterfaceMethod [188] [189] 
.const [73] = InterfaceMethod [190] [191] 
.const [74] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [75] = Utf8 java/lang/Object 
.const [76] = Class [192] 
.const [77] = NameAndType [193] [194] 
.const [78] = Utf8 java/util/jar/Attributes$Name 
.const [79] = Utf8 Name 
.const [80] = Class [195] 
.const [81] = NameAndType [196] [197] 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 java/lang/String 
.const [84] = Class [198] 
.const [85] = NameAndType [199] [200] 
.const [86] = Utf8 ': ' 
.const [87] = Utf8 ISO8859_1 
.const [88] = Utf8 java/io/OutputStream 
.const [89] = Utf8 java/lang/System 
.const [90] = Class [201] 
.const [91] = NameAndType [202] [203] 
.const [92] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [93] = Utf8 com/ibm/oti/util/PriviAction 
.const [94] = Utf8 'manifest.write.encoding' 
.const [95] = Utf8 java/security/AccessController 
.const [96] = Class [204] 
.const [97] = NameAndType [205] [206] 
.const [98] = Utf8 '' 
.const [99] = Utf8 UTF8 
.const [100] = Class [207] 
.const [101] = NameAndType [208] [209] 
.const [102] = Utf8 java/io/UnsupportedEncodingException 
.const [103] = Utf8 java/util/jar/Manifest 
.const [104] = Class [210] 
.const [105] = NameAndType [211] [212] 
.const [106] = Class [213] 
.const [107] = NameAndType [214] [215] 
.const [108] = Utf8 java/util/jar/Attributes 
.const [109] = Utf8 java/util/Set 
.const [110] = Utf8 java/util/Iterator 
.const [111] = Class [216] 
.const [112] = NameAndType [217] [218] 
.const [113] = Utf8 java/util/HashMap 
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
.const [146] = Class [267] 
.const [147] = NameAndType [268] [269] 
.const [148] = Class [270] 
.const [149] = NameAndType [271] [272] 
.const [150] = Class [273] 
.const [151] = NameAndType [274] [275] 
.const [152] = Class [276] 
.const [153] = NameAndType [277] [278] 
.const [154] = Class [279] 
.const [155] = NameAndType [280] [281] 
.const [156] = Class [282] 
.const [157] = NameAndType [283] [284] 
.const [158] = Class [285] 
.const [159] = NameAndType [286] [287] 
.const [160] = Class [288] 
.const [161] = NameAndType [289] [290] 
.const [162] = Class [291] 
.const [163] = NameAndType [292] [293] 
.const [164] = Class [294] 
.const [165] = NameAndType [295] [296] 
.const [166] = Class [297] 
.const [167] = NameAndType [298] [299] 
.const [168] = Class [300] 
.const [169] = NameAndType [301] [302] 
.const [170] = Class [303] 
.const [171] = NameAndType [304] [305] 
.const [172] = Utf8 java/util/jar/Attributes$Name 
.const [173] = Class [306] 
.const [174] = NameAndType [307] [308] 
.const [175] = Class [309] 
.const [176] = NameAndType [310] [311] 
.const [177] = Class [312] 
.const [178] = NameAndType [313] [314] 
.const [179] = Utf8 java/lang/StringBuffer 
.const [180] = Class [315] 
.const [181] = NameAndType [316] [317] 
.const [182] = Class [318] 
.const [183] = NameAndType [319] [320] 
.const [184] = Utf8 com/ibm/oti/util/PriviAction 
.const [185] = Utf8 java/io/UnsupportedEncodingException 
.const [186] = Class [321] 
.const [187] = NameAndType [322] [323] 
.const [188] = Class [324] 
.const [189] = NameAndType [325] [326] 
.const [190] = Class [327] 
.const [191] = NameAndType [328] [329] 
.const [192] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [193] = Utf8 sepBuf 
.const [194] = Utf8 [B 
.const [195] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [196] = Utf8 nameAttribute 
.const [197] = Utf8 Ljava/util/jar/Attributes$Name; 
.const [198] = Utf8 java/lang/String 
.const [199] = Utf8 valueOf 
.const [200] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [201] = Utf8 java/lang/System 
.const [202] = Utf8 arraycopy 
.const [203] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [204] = Utf8 java/security/AccessController 
.const [205] = Utf8 doPrivileged 
.const [206] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [207] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [208] = Utf8 getConverter 
.const [209] = Utf8 (Ljava/lang/String;)Lcom/ibm/oti/io/CharacterConverter; 
.const [210] = Utf8 java/util/jar/Manifest 
.const [211] = Utf8 access$0 
.const [212] = Utf8 (Ljava/util/jar/Manifest;)Ljava/util/jar/Attributes; 
.const [213] = Utf8 java/util/jar/Attributes$Name 
.const [214] = Utf8 MANIFEST_VERSION 
.const [215] = Utf8 Ljava/util/jar/Attributes$Name; 
.const [216] = Utf8 java/util/jar/Manifest 
.const [217] = Utf8 access$1 
.const [218] = Utf8 (Ljava/util/jar/Manifest;)Ljava/util/HashMap; 
.const [219] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [220] = Utf8 oneByte 
.const [221] = Utf8 [B 
.const [222] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [223] = Utf8 oneChar 
.const [224] = Utf8 [C 
.const [225] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [226] = Utf8 outBuf 
.const [227] = Utf8 [B 
.const [228] = Utf8 java/util/jar/Attributes$Name 
.const [229] = Utf8 toString 
.const [230] = Utf8 ()Ljava/lang/String; 
.const [231] = Utf8 java/lang/StringBuffer 
.const [232] = Utf8 append 
.const [233] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [234] = Utf8 java/lang/StringBuffer 
.const [235] = Utf8 toString 
.const [236] = Utf8 ()Ljava/lang/String; 
.const [237] = Utf8 java/lang/String 
.const [238] = Utf8 getBytes 
.const [239] = Utf8 (Ljava/lang/String;)[B 
.const [240] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [241] = Utf8 os 
.const [242] = Utf8 Ljava/io/OutputStream; 
.const [243] = Utf8 java/io/OutputStream 
.const [244] = Utf8 write 
.const [245] = Utf8 (I)V 
.const [246] = Utf8 java/io/OutputStream 
.const [247] = Utf8 write 
.const [248] = Utf8 ([BII)V 
.const [249] = Utf8 java/io/OutputStream 
.const [250] = Utf8 write 
.const [251] = Utf8 ([B)V 
.const [252] = Utf8 java/lang/String 
.const [253] = Utf8 charAt 
.const [254] = Utf8 (I)C 
.const [255] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [256] = Utf8 converter 
.const [257] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [258] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [259] = Utf8 convert 
.const [260] = Utf8 ([CII)[B 
.const [261] = Utf8 java/lang/String 
.const [262] = Utf8 length 
.const [263] = Utf8 ()I 
.const [264] = Utf8 java/lang/String 
.const [265] = Utf8 equals 
.const [266] = Utf8 (Ljava/lang/Object;)Z 
.const [267] = Utf8 java/util/jar/Attributes 
.const [268] = Utf8 getValue 
.const [269] = Utf8 (Ljava/util/jar/Attributes$Name;)Ljava/lang/String; 
.const [270] = Utf8 java/util/jar/Attributes 
.const [271] = Utf8 keySet 
.const [272] = Utf8 ()Ljava/util/Set; 
.const [273] = Utf8 java/util/jar/Attributes$Name 
.const [274] = Utf8 equals 
.const [275] = Utf8 (Ljava/lang/Object;)Z 
.const [276] = Utf8 java/util/HashMap 
.const [277] = Utf8 keySet 
.const [278] = Utf8 ()Ljava/util/Set; 
.const [279] = Utf8 java/util/HashMap 
.const [280] = Utf8 get 
.const [281] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [282] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [283] = Utf8 sepBuf 
.const [284] = Utf8 [B 
.const [285] = Utf8 java/util/jar/Attributes$Name 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (Ljava/lang/String;Z)V 
.const [288] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [289] = Utf8 nameAttribute 
.const [290] = Utf8 Ljava/util/jar/Attributes$Name; 
.const [291] = Utf8 java/lang/Object 
.const [292] = Utf8 <init> 
.const [293] = Utf8 ()V 
.const [294] = Utf8 java/lang/StringBuffer 
.const [295] = Utf8 <init> 
.const [296] = Utf8 (Ljava/lang/String;)V 
.const [297] = Utf8 com/ibm/oti/util/PriviAction 
.const [298] = Utf8 <init> 
.const [299] = Utf8 (Ljava/lang/String;)V 
.const [300] = Utf8 java/io/UnsupportedEncodingException 
.const [301] = Utf8 <init> 
.const [302] = Utf8 (Ljava/lang/String;)V 
.const [303] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [304] = Utf8 writeEntry 
.const [305] = Utf8 (Ljava/util/jar/Attributes$Name;Ljava/lang/String;)V 
.const [306] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [307] = Utf8 oneByte 
.const [308] = Utf8 [B 
.const [309] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [310] = Utf8 oneChar 
.const [311] = Utf8 [C 
.const [312] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [313] = Utf8 outBuf 
.const [314] = Utf8 [B 
.const [315] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [316] = Utf8 os 
.const [317] = Utf8 Ljava/io/OutputStream; 
.const [318] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [319] = Utf8 converter 
.const [320] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [321] = Utf8 java/util/Set 
.const [322] = Utf8 iterator 
.const [323] = Utf8 ()Ljava/util/Iterator; 
.const [324] = Utf8 java/util/Iterator 
.const [325] = Utf8 next 
.const [326] = Utf8 ()Ljava/lang/Object; 
.const [327] = Utf8 java/util/Iterator 
.const [328] = Utf8 hasNext 
.const [329] = Utf8 ()Z 
.const [330] = Utf8 java/util/jar/Manifest$WriteManifest 
.const [331] = Class [330] 
.const [332] = Utf8 java/lang/Object 
.const [333] = Class [332] 
.const [334] = Utf8 LIMIT 
.const [335] = Utf8 I 
.const [336] = Utf8 sepBuf 
.const [337] = Utf8 [B 
.const [338] = Utf8 nameAttribute 
.const [339] = Utf8 Ljava/util/jar/Attributes$Name; 
.const [340] = Utf8 oneByte 
.const [341] = Utf8 [B 
.const [342] = Utf8 oneChar 
.const [343] = Utf8 [C 
.const [344] = Utf8 converter 
.const [345] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [346] = Utf8 outBuf 
.const [347] = Utf8 [B 
.const [348] = Utf8 os 
.const [349] = Utf8 Ljava/io/OutputStream; 
.const [350] = Utf8 Code 
.const [351] = Utf8 <clinit> 
.const [352] = Utf8 ()V 
.const [353] = Utf8 <init> 
.const [354] = Utf8 ()V 
.const [355] = Utf8 writeEntry 
.const [356] = Utf8 (Ljava/util/jar/Attributes$Name;Ljava/lang/String;)V 
.const [357] = Utf8 write 
.const [358] = Utf8 (Ljava/util/jar/Manifest;Ljava/io/OutputStream;)V 
.end class 
