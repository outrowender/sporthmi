.version 50 0 
.class super abstract [364] 
.super [366] 
.field private [367] [368] 
.field private [369] [370] 
.field private [371] [372] 
.field private [373] [374] 
.field private [375] [376] 
.field private [377] [378] 
.field private [379] [380] 
.field private [381] [382] 
.field private [383] [384] 
.field private [385] [386] 
.field private [387] [388] 

.method public [390] : [391] 
    .attribute [389] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     iload_3 
L6:     iconst_1 
L7:     if_icmpge L15 
L10:    ldc [2] 
L12:    goto L16 
L15:    iload_3 
L16:    putfield [53] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [54] 
L24:    aload_0 
L25:    new [55] 
L28:    dup 
L29:    invokespecial [49] 
L32:    putfield [56] 
L35:    aload_0 
L36:    new [57] 
L39:    dup 
L40:    invokespecial [50] 
L43:    putfield [58] 
L46:    aload_0 
L47:    new [59] 
L50:    dup 
L51:    aload_1 
L52:    invokevirtual [20] 
L55:    invokevirtual [21] 
L58:    dload 4 
L60:    invokespecial [51] 
L63:    putfield [60] 
L66:    aload_0 
L67:    aload_1 
L68:    invokevirtual [23] 
L71:    ifne L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_0 
L79:    putfield [61] 
L82:    aload_0 
L83:    iload_2 
L84:    putfield [62] 
L87:    aload_0 
L88:    ldc [6] 
L90:    putfield [63] 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private static [392] : [393] 
    .attribute [389] .code stack 4 locals 0 
L0:     new [64] 
L3:     dup 
L4:     aload_0 
L5:     invokevirtual [21] 
L8:     iconst_1 
L9:     iadd 
L10:    invokespecial [52] 
L13:    aload_0 
L14:    invokevirtual [27] 
L17:    sipush 8230 
L20:    invokevirtual [28] 
L23:    invokevirtual [29] 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [394] : [395] 
    .attribute [389] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifeq L8 
L7:     return 
L8:     aload_0 
L9:     getfield [30] 
L12:    aload_0 
L13:    getfield [16] 
L16:    if_icmpge L81 
L19:    aload_0 
L20:    getfield [25] 
L23:    ifne L37 
L26:    aload_0 
L27:    getfield [19] 
L30:    aload_1 
L31:    invokeinterface [66] 0 
L36:    pop 
L37:    aload_0 
L38:    aload_1 
L39:    putfield [63] 
L42:    aload_0 
L43:    aload_0 
L44:    getfield [31] 
L47:    aload_0 
L48:    aload_1 
L49:    invokevirtual [32] 
L52:    invokestatic [8] 
L55:    putfield [67] 
L58:    aload_0 
L59:    dup 
L60:    getfield [30] 
L63:    iconst_1 
L64:    iadd 
L65:    putfield [65] 
L68:    aload_0 
L69:    aload_0 
L70:    getfield [30] 
L73:    iconst_1 
L74:    isub 
L75:    invokevirtual [33] 
L78:    goto L161 
L81:    aload_0 
L82:    getfield [26] 
L85:    invokestatic [9] 
L88:    astore_1 
L89:    aload_0 
L90:    getfield [30] 
L93:    iconst_1 
L94:    isub 
L95:    istore_2 
L96:    aload_0 
L97:    getfield [19] 
L100:   invokeinterface [68] 0 
L105:   ifne L130 
L108:   aload_0 
L109:   getfield [19] 
L112:   iload_2 
L113:   invokeinterface [69] 0 
L118:   pop 
L119:   aload_0 
L120:   getfield [19] 
L123:   aload_1 
L124:   invokeinterface [66] 0 
L129:   pop 
L130:   aload_0 
L131:   aload_1 
L132:   putfield [63] 
L135:   aload_0 
L136:   aload_0 
L137:   getfield [31] 
L140:   aload_0 
L141:   aload_1 
L142:   invokevirtual [32] 
L145:   invokestatic [8] 
L148:   putfield [67] 
L151:   aload_0 
L152:   iload_2 
L153:   invokevirtual [33] 
L156:   aload_0 
L157:   iconst_1 
L158:   putfield [61] 
L161:   aload_0 
L162:   aload_1 
L163:   putfield [70] 
L166:   return 
L167:   nop 
L168:   
    .end code 
.end method 

.method public [396] : [397] 
    .attribute [389] .code stack 2 locals 0 
L0:     iload_1 
L1:     iflt L17 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [19] 
L9:     invokeinterface [71] 0 
L14:    if_icmplt L20 
L17:    ldc [6] 
L19:    areturn 
L20:    aload_0 
L21:    getfield [19] 
L24:    iload_1 
L25:    invokeinterface [72] 0 
L30:    checkcast [10] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [398] : [399] 
    .attribute [389] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [400] : [401] 
    .attribute [389] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [402] : [403] 
    .attribute [389] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [35] 
L7:     ifeq L24 
L10:    aload_0 
L11:    getfield [17] 
L14:    invokevirtual [23] 
L17:    ifeq L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [404] : [405] 
    .attribute [389] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifne L14 
L7:     aload_0 
L8:     invokevirtual [36] 
L11:    ifne L15 
L14:    return 
L15:    aload_0 
L16:    getfield [17] 
L19:    invokevirtual [23] 
L22:    ifne L31 
L25:    aload_0 
L26:    iconst_1 
L27:    putfield [61] 
L30:    return 
L31:    aload_0 
L32:    getfield [17] 
L35:    invokevirtual [37] 
L38:    astore_1 
L39:    aload_0 
L40:    getfield [34] 
L43:    ifnull L128 
L46:    aload_0 
L47:    getfield [18] 
L50:    iconst_0 
L51:    aload_0 
L52:    getfield [18] 
L55:    invokevirtual [38] 
L58:    aload_0 
L59:    getfield [34] 
L62:    invokevirtual [39] 
L65:    aload_1 
L66:    invokevirtual [40] 
L69:    pop 
L70:    aload_0 
L71:    getfield [18] 
L74:    invokevirtual [41] 
L77:    astore_1 
L78:    aload_0 
L79:    aconst_null 
L80:    putfield [70] 
L83:    aload_0 
L84:    dup 
L85:    getfield [30] 
L88:    iconst_1 
L89:    isub 
L90:    putfield [65] 
L93:    aload_0 
L94:    getfield [25] 
L97:    ifne L128 
L100:   aload_0 
L101:   getfield [19] 
L104:   invokeinterface [71] 0 
L109:   iconst_1 
L110:   isub 
L111:   istore_2 
L112:   aload_0 
L113:   getfield [19] 
L116:   iload_2 
L117:   invokeinterface [69] 0 
L122:   pop 
L123:   aload_0 
L124:   iload_2 
L125:   invokevirtual [33] 
L128:   aload_0 
L129:   aload_1 
L130:   invokevirtual [42] 
L133:   aload_0 
L134:   getfield [34] 
L137:   ifnull L167 
L140:   aload_1 
L141:   invokevirtual [21] 
L144:   ifle L167 
L147:   aload_1 
L148:   aload_1 
L149:   invokevirtual [21] 
L152:   iconst_1 
L153:   isub 
L154:   invokevirtual [43] 
L157:   bipush 10 
L159:   if_icmpne L167 
L162:   aload_0 
L163:   aconst_null 
L164:   putfield [70] 
L167:   aload_0 
L168:   getfield [24] 
L171:   ifne L189 
L174:   aload_0 
L175:   getfield [17] 
L178:   invokevirtual [23] 
L181:   ifne L189 
L184:   aload_0 
L185:   iconst_1 
L186:   putfield [61] 
L189:   aload_0 
L190:   getfield [22] 
L193:   aload_0 
L194:   getfield [30] 
L197:   aload_0 
L198:   getfield [24] 
L201:   ifeq L217 
L204:   aload_0 
L205:   getfield [17] 
L208:   invokevirtual [20] 
L211:   invokevirtual [21] 
L214:   goto L224 
L217:   aload_0 
L218:   getfield [17] 
L221:   invokevirtual [44] 
L224:   invokevirtual [45] 
L227:   return 
L228:   
    .end code 
.end method 

.method public [406] : [407] 
    .attribute [389] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [46] 
L4:     aload_0 
L5:     getfield [22] 
L8:     invokevirtual [47] 
L11:    invokestatic [8] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [408] : [409] 
    .attribute [389] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [410] : [411] 
    .attribute [389] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [412] : [413] 
    .attribute [389] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [414] : [415] 
    .attribute [389] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [416] : [417] 
    .attribute [389] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [418] : [419] 
    .attribute [389] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -129 
.const [3] = Class [73] 
.const [4] = Class [74] 
.const [5] = Class [75] 
.const [6] = String [76] 
.const [7] = Class [77] 
.const [8] = Method [78] [79] 
.const [9] = Method [80] [81] 
.const [10] = Class [82] 
.const [11] = Class [83] 
.const [12] = Class [84] 
.const [13] = Class [85] 
.const [14] = Class [86] 
.const [15] = Class [87] 
.const [16] = Field [88] [89] 
.const [17] = Field [90] [91] 
.const [18] = Field [92] [93] 
.const [19] = Field [94] [95] 
.const [20] = Method [96] [97] 
.const [21] = Method [98] [99] 
.const [22] = Field [100] [101] 
.const [23] = Method [102] [103] 
.const [24] = Field [104] [105] 
.const [25] = Field [106] [107] 
.const [26] = Field [108] [109] 
.const [27] = Method [110] [111] 
.const [28] = Method [112] [113] 
.const [29] = Method [114] [115] 
.const [30] = Field [116] [117] 
.const [31] = Field [118] [119] 
.const [32] = Method [120] [121] 
.const [33] = Method [122] [123] 
.const [34] = Field [124] [125] 
.const [35] = Method [126] [127] 
.const [36] = Method [128] [129] 
.const [37] = Method [130] [131] 
.const [38] = Method [132] [133] 
.const [39] = Method [134] [135] 
.const [40] = Method [136] [137] 
.const [41] = Method [138] [139] 
.const [42] = Method [140] [141] 
.const [43] = Method [142] [143] 
.const [44] = Method [144] [145] 
.const [45] = Method [146] [147] 
.const [46] = Method [148] [149] 
.const [47] = Method [150] [151] 
.const [48] = Method [152] [153] 
.const [49] = Method [154] [155] 
.const [50] = Method [156] [157] 
.const [51] = Method [158] [159] 
.const [52] = Method [160] [161] 
.const [53] = Field [162] [163] 
.const [54] = Field [164] [165] 
.const [55] = Class [166] 
.const [56] = Field [167] [168] 
.const [57] = Class [169] 
.const [58] = Field [170] [171] 
.const [59] = Class [172] 
.const [60] = Field [173] [174] 
.const [61] = Field [175] [176] 
.const [62] = Field [177] [178] 
.const [63] = Field [179] [180] 
.const [64] = Class [181] 
.const [65] = Field [182] [183] 
.const [66] = InterfaceMethod [184] [185] 
.const [67] = Field [186] [187] 
.const [68] = InterfaceMethod [188] [189] 
.const [69] = InterfaceMethod [190] [191] 
.const [70] = Field [192] [193] 
.const [71] = InterfaceMethod [194] [195] 
.const [72] = InterfaceMethod [196] [197] 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 java/util/ArrayList 
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [76] = Utf8 '' 
.const [77] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [78] = Class [198] 
.const [79] = NameAndType [199] [200] 
.const [80] = Class [201] 
.const [81] = NameAndType [202] [203] 
.const [82] = Utf8 java/lang/String 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [84] = Utf8 java/lang/Object 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [86] = Utf8 java/util/List 
.const [87] = Utf8 java/lang/Math 
.const [88] = Class [204] 
.const [89] = NameAndType [205] [206] 
.const [90] = Class [207] 
.const [91] = NameAndType [208] [209] 
.const [92] = Class [210] 
.const [93] = NameAndType [211] [212] 
.const [94] = Class [213] 
.const [95] = NameAndType [214] [215] 
.const [96] = Class [216] 
.const [97] = NameAndType [217] [218] 
.const [98] = Class [219] 
.const [99] = NameAndType [220] [221] 
.const [100] = Class [222] 
.const [101] = NameAndType [223] [224] 
.const [102] = Class [225] 
.const [103] = NameAndType [226] [227] 
.const [104] = Class [228] 
.const [105] = NameAndType [229] [230] 
.const [106] = Class [231] 
.const [107] = NameAndType [232] [233] 
.const [108] = Class [234] 
.const [109] = NameAndType [235] [236] 
.const [110] = Class [237] 
.const [111] = NameAndType [238] [239] 
.const [112] = Class [240] 
.const [113] = NameAndType [241] [242] 
.const [114] = Class [243] 
.const [115] = NameAndType [244] [245] 
.const [116] = Class [246] 
.const [117] = NameAndType [247] [248] 
.const [118] = Class [249] 
.const [119] = NameAndType [250] [251] 
.const [120] = Class [252] 
.const [121] = NameAndType [253] [254] 
.const [122] = Class [255] 
.const [123] = NameAndType [256] [257] 
.const [124] = Class [258] 
.const [125] = NameAndType [259] [260] 
.const [126] = Class [261] 
.const [127] = NameAndType [262] [263] 
.const [128] = Class [264] 
.const [129] = NameAndType [265] [266] 
.const [130] = Class [267] 
.const [131] = NameAndType [268] [269] 
.const [132] = Class [270] 
.const [133] = NameAndType [271] [272] 
.const [134] = Class [273] 
.const [135] = NameAndType [274] [275] 
.const [136] = Class [276] 
.const [137] = NameAndType [277] [278] 
.const [138] = Class [279] 
.const [139] = NameAndType [280] [281] 
.const [140] = Class [282] 
.const [141] = NameAndType [283] [284] 
.const [142] = Class [285] 
.const [143] = NameAndType [286] [287] 
.const [144] = Class [288] 
.const [145] = NameAndType [289] [290] 
.const [146] = Class [291] 
.const [147] = NameAndType [292] [293] 
.const [148] = Class [294] 
.const [149] = NameAndType [295] [296] 
.const [150] = Class [297] 
.const [151] = NameAndType [298] [299] 
.const [152] = Class [300] 
.const [153] = NameAndType [301] [302] 
.const [154] = Class [303] 
.const [155] = NameAndType [304] [305] 
.const [156] = Class [306] 
.const [157] = NameAndType [307] [308] 
.const [158] = Class [309] 
.const [159] = NameAndType [310] [311] 
.const [160] = Class [312] 
.const [161] = NameAndType [313] [314] 
.const [162] = Class [315] 
.const [163] = NameAndType [316] [317] 
.const [164] = Class [318] 
.const [165] = NameAndType [319] [320] 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Class [321] 
.const [168] = NameAndType [322] [323] 
.const [169] = Utf8 java/util/ArrayList 
.const [170] = Class [324] 
.const [171] = NameAndType [325] [326] 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [173] = Class [327] 
.const [174] = NameAndType [328] [329] 
.const [175] = Class [330] 
.const [176] = NameAndType [331] [332] 
.const [177] = Class [333] 
.const [178] = NameAndType [334] [335] 
.const [179] = Class [336] 
.const [180] = NameAndType [337] [338] 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Class [339] 
.const [183] = NameAndType [340] [341] 
.const [184] = Class [342] 
.const [185] = NameAndType [343] [344] 
.const [186] = Class [345] 
.const [187] = NameAndType [346] [347] 
.const [188] = Class [348] 
.const [189] = NameAndType [349] [350] 
.const [190] = Class [351] 
.const [191] = NameAndType [352] [353] 
.const [192] = Class [354] 
.const [193] = NameAndType [355] [356] 
.const [194] = Class [357] 
.const [195] = NameAndType [358] [359] 
.const [196] = Class [360] 
.const [197] = NameAndType [361] [362] 
.const [198] = Utf8 java/lang/Math 
.const [199] = Utf8 max 
.const [200] = Utf8 (II)I 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [202] = Utf8 addEllipsis 
.const [203] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [205] = Utf8 maxLines 
.const [206] = Utf8 I 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [208] = Utf8 iterator 
.const [209] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator; 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [211] = Utf8 tempFrame 
.const [212] = Utf8 Ljava/lang/StringBuffer; 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [214] = Utf8 lines 
.const [215] = Utf8 Ljava/util/List; 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [217] = Utf8 getText 
.const [218] = Utf8 ()Ljava/lang/String; 
.const [219] = Utf8 java/lang/String 
.const [220] = Utf8 length 
.const [221] = Utf8 ()I 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [223] = Utf8 estimator 
.const [224] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator; 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [226] = Utf8 hasNext 
.const [227] = Utf8 ()Z 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [229] = Utf8 finished 
.const [230] = Utf8 Z 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [232] = Utf8 forgetContent 
.const [233] = Utf8 Z 
.const [234] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [235] = Utf8 lastLine 
.const [236] = Utf8 Ljava/lang/String; 
.const [237] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [238] = Utf8 append 
.const [239] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [240] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [241] = Utf8 append 
.const [242] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [243] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [244] = Utf8 toString 
.const [245] = Utf8 ()Ljava/lang/String; 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [247] = Utf8 lineCount 
.const [248] = Utf8 I 
.const [249] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [250] = Utf8 maxLineWidth 
.const [251] = Utf8 I 
.const [252] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [253] = Utf8 getLineWidth 
.const [254] = Utf8 (Ljava/lang/String;)I 
.const [255] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [256] = Utf8 onLineChanged 
.const [257] = Utf8 (I)V 
.const [258] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [259] = Utf8 lastFrameLine 
.const [260] = Utf8 Ljava/lang/String; 
.const [261] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [262] = Utf8 isAtStart 
.const [263] = Utf8 ()Z 
.const [264] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [265] = Utf8 isReady 
.const [266] = Utf8 ()Z 
.const [267] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [268] = Utf8 next 
.const [269] = Utf8 ()Ljava/lang/String; 
.const [270] = Utf8 java/lang/StringBuffer 
.const [271] = Utf8 length 
.const [272] = Utf8 ()I 
.const [273] = Utf8 java/lang/StringBuffer 
.const [274] = Utf8 replace 
.const [275] = Utf8 (IILjava/lang/String;)Ljava/lang/StringBuffer; 
.const [276] = Utf8 java/lang/StringBuffer 
.const [277] = Utf8 append 
.const [278] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [279] = Utf8 java/lang/StringBuffer 
.const [280] = Utf8 toString 
.const [281] = Utf8 ()Ljava/lang/String; 
.const [282] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [283] = Utf8 mergeFrame 
.const [284] = Utf8 (Ljava/lang/String;)V 
.const [285] = Utf8 java/lang/String 
.const [286] = Utf8 charAt 
.const [287] = Utf8 (I)C 
.const [288] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [289] = Utf8 getOffset 
.const [290] = Utf8 ()I 
.const [291] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [292] = Utf8 update 
.const [293] = Utf8 (II)V 
.const [294] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [295] = Utf8 getMinLines 
.const [296] = Utf8 ()I 
.const [297] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [298] = Utf8 getEstimatedLineCount 
.const [299] = Utf8 ()I 
.const [300] = Utf8 java/lang/Object 
.const [301] = Utf8 <init> 
.const [302] = Utf8 ()V 
.const [303] = Utf8 java/lang/StringBuffer 
.const [304] = Utf8 <init> 
.const [305] = Utf8 ()V 
.const [306] = Utf8 java/util/ArrayList 
.const [307] = Utf8 <init> 
.const [308] = Utf8 ()V 
.const [309] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [310] = Utf8 <init> 
.const [311] = Utf8 (ID)V 
.const [312] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [313] = Utf8 <init> 
.const [314] = Utf8 (I)V 
.const [315] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [316] = Utf8 maxLines 
.const [317] = Utf8 I 
.const [318] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [319] = Utf8 iterator 
.const [320] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator; 
.const [321] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [322] = Utf8 tempFrame 
.const [323] = Utf8 Ljava/lang/StringBuffer; 
.const [324] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [325] = Utf8 lines 
.const [326] = Utf8 Ljava/util/List; 
.const [327] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [328] = Utf8 estimator 
.const [329] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator; 
.const [330] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [331] = Utf8 finished 
.const [332] = Utf8 Z 
.const [333] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [334] = Utf8 forgetContent 
.const [335] = Utf8 Z 
.const [336] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [337] = Utf8 lastLine 
.const [338] = Utf8 Ljava/lang/String; 
.const [339] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [340] = Utf8 lineCount 
.const [341] = Utf8 I 
.const [342] = Utf8 java/util/List 
.const [343] = Utf8 add 
.const [344] = Utf8 (Ljava/lang/Object;)Z 
.const [345] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [346] = Utf8 maxLineWidth 
.const [347] = Utf8 I 
.const [348] = Utf8 java/util/List 
.const [349] = Utf8 isEmpty 
.const [350] = Utf8 ()Z 
.const [351] = Utf8 java/util/List 
.const [352] = Utf8 remove 
.const [353] = Utf8 (I)Ljava/lang/Object; 
.const [354] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [355] = Utf8 lastFrameLine 
.const [356] = Utf8 Ljava/lang/String; 
.const [357] = Utf8 java/util/List 
.const [358] = Utf8 size 
.const [359] = Utf8 ()I 
.const [360] = Utf8 java/util/List 
.const [361] = Utf8 get 
.const [362] = Utf8 (I)Ljava/lang/Object; 
.const [363] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractPage 
.const [364] = Class [363] 
.const [365] = Utf8 java/lang/Object 
.const [366] = Class [365] 
.const [367] = Utf8 iterator 
.const [368] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator; 
.const [369] = Utf8 lines 
.const [370] = Utf8 Ljava/util/List; 
.const [371] = Utf8 estimator 
.const [372] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator; 
.const [373] = Utf8 maxLineWidth 
.const [374] = Utf8 I 
.const [375] = Utf8 maxLines 
.const [376] = Utf8 I 
.const [377] = Utf8 lineCount 
.const [378] = Utf8 I 
.const [379] = Utf8 finished 
.const [380] = Utf8 Z 
.const [381] = Utf8 forgetContent 
.const [382] = Utf8 Z 
.const [383] = Utf8 tempFrame 
.const [384] = Utf8 Ljava/lang/StringBuffer; 
.const [385] = Utf8 lastFrameLine 
.const [386] = Utf8 Ljava/lang/String; 
.const [387] = Utf8 lastLine 
.const [388] = Utf8 Ljava/lang/String; 
.const [389] = Utf8 Code 
.const [390] = Utf8 <init> 
.const [391] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;ZID)V 
.const [392] = Utf8 addEllipsis 
.const [393] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [394] = Utf8 addLine 
.const [395] = Utf8 (Ljava/lang/String;)V 
.const [396] = Utf8 getLine 
.const [397] = Utf8 (I)Ljava/lang/String; 
.const [398] = Utf8 isEmpty 
.const [399] = Utf8 ()Z 
.const [400] = Utf8 isFinished 
.const [401] = Utf8 ()Z 
.const [402] = Utf8 isAtStart 
.const [403] = Utf8 ()Z 
.const [404] = Utf8 update 
.const [405] = Utf8 ()V 
.const [406] = Utf8 getEstimatedLineCount 
.const [407] = Utf8 ()I 
.const [408] = Utf8 getWidth 
.const [409] = Utf8 ()I 
.const [410] = Utf8 isReady 
.const [411] = Utf8 ()Z 
.const [412] = Utf8 mergeFrame 
.const [413] = Utf8 (Ljava/lang/String;)V 
.const [414] = Utf8 getMinLines 
.const [415] = Utf8 ()I 
.const [416] = Utf8 onLineChanged 
.const [417] = Utf8 (I)V 
.const [418] = Utf8 getLineWidth 
.const [419] = Utf8 (Ljava/lang/String;)I 
.end class 
