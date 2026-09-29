.version 50 0 
.class public super abstract [456] 
.super [458] 
.field private volatile [459] [460] 
.field private volatile [461] [462] 
.field static synthetic [463] [464] 

.method public [466] : [467] 
    .attribute [465] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [68] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [78] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [79] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [468] : [469] 
    .attribute [465] .code stack 1 locals 0 
L0:     iconst_0 
L1:     newarray int 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [470] : [471] 
    .attribute [465] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [69] 
L4:     aload_0 
L5:     invokevirtual [33] 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [472] : [473] 
    .attribute [465] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_0 
L9:     getfield [32] 
L12:    invokevirtual [35] 
L15:    pop 
L16:    aload_0 
L17:    getfield [32] 
L20:    ifeq L40 
L23:    aload_0 
L24:    getfield [36] 
L27:    checkcast [7] 
L30:    invokevirtual [37] 
L33:    astore_1 
L34:    aload_0 
L35:    aload_1 
L36:    arraylength 
L37:    invokevirtual [38] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [474] : [475] 
    .attribute [465] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [5] 
L6:     ldc [8] 
L8:     aload_0 
L9:     getfield [31] 
L12:    invokevirtual [35] 
L15:    pop 
L16:    aload_0 
L17:    getfield [31] 
L20:    ifeq L43 
L23:    aload_0 
L24:    getfield [36] 
L27:    checkcast [7] 
L30:    invokevirtual [37] 
L33:    astore_1 
L34:    aload_0 
L35:    aload_0 
L36:    aload_1 
L37:    invokespecial [70] 
L40:    invokevirtual [39] 
L43:    return 
L44:    
    .end code 
.end method 

.method protected abstract [476] : [477] 
    .attribute [465] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [478] : [479] 
    .attribute [465] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private [480] : [481] 
    .attribute [465] .code stack 5 locals 2 
L0:     aload_1 
L1:     arraylength 
L2:     anewarray [9] 
L5:     astore_2 
L6:     iconst_0 
L7:     istore_3 
L8:     iload_3 
L9:     aload_1 
L10:    arraylength 
L11:    if_icmpge L30 
L14:    aload_2 
L15:    iload_3 
L16:    aload_0 
L17:    aload_1 
L18:    iload_3 
L19:    aaload 
L20:    invokespecial [71] 
L23:    aastore 
L24:    iinc 3 1 
L27:    goto L8 
L30:    aload_2 
L31:    areturn 
L32:    
    .end code 
.end method 

.method private [482] : [483] 
    .attribute [465] .code stack 5 locals 4 
L0:     new [80] 
L3:     dup 
L4:     invokespecial [72] 
L7:     astore_2 
L8:     aload_1 
L9:     instanceof [10] 
L12:    ifeq L227 
L15:    aload_1 
L16:    checkcast [10] 
L19:    astore_3 
L20:    aload_2 
L21:    aload_3 
L22:    invokevirtual [40] 
L25:    putfield [81] 
L28:    aload_3 
L29:    invokevirtual [41] 
L32:    astore 4 
L34:    aload 4 
L36:    arraylength 
L37:    ifne L59 
L40:    aload_2 
L41:    aload_3 
L42:    invokevirtual [42] 
L45:    putfield [82] 
L48:    aload_2 
L49:    aload_3 
L50:    invokevirtual [43] 
L53:    putfield [83] 
L56:    goto L224 
L59:    aload_3 
L60:    invokevirtual [44] 
L63:    ifeq L93 
L66:    aload_3 
L67:    invokevirtual [45] 
L70:    astore 5 
L72:    aload_2 
L73:    aload 5 
L75:    invokevirtual [46] 
L78:    putfield [82] 
L81:    aload_2 
L82:    aload 5 
L84:    invokevirtual [47] 
L87:    putfield [84] 
L90:    goto L202 
L93:    aload_2 
L94:    aload 4 
L96:    iconst_0 
L97:    aaload 
L98:    invokevirtual [48] 
L101:   putfield [85] 
L104:   aload_2 
L105:   aload 4 
L107:   iconst_0 
L108:   aaload 
L109:   invokevirtual [49] 
L112:   putfield [86] 
L115:   aload_2 
L116:   aload 4 
L118:   iconst_0 
L119:   aaload 
L120:   invokevirtual [50] 
L123:   putfield [87] 
L126:   aload_2 
L127:   aload 4 
L129:   iconst_0 
L130:   aaload 
L131:   invokevirtual [51] 
L134:   putfield [88] 
L137:   aload_2 
L138:   aload 4 
L140:   iconst_0 
L141:   aaload 
L142:   invokevirtual [52] 
L145:   putfield [89] 
L148:   aload_2 
L149:   aload 4 
L151:   iconst_0 
L152:   aaload 
L153:   invokevirtual [53] 
L156:   putfield [90] 
L159:   aload_2 
L160:   aload 4 
L162:   iconst_0 
L163:   aaload 
L164:   invokevirtual [54] 
L167:   putfield [91] 
L170:   aload_2 
L171:   aload 4 
L173:   iconst_0 
L174:   aaload 
L175:   invokevirtual [55] 
L178:   aload 4 
L180:   iconst_0 
L181:   aaload 
L182:   invokevirtual [56] 
L185:   invokestatic [11] 
L188:   putfield [84] 
L191:   aload_2 
L192:   aload 4 
L194:   iconst_0 
L195:   aaload 
L196:   invokevirtual [57] 
L199:   putfield [82] 
L202:   aload_2 
L203:   aload 4 
L205:   iconst_0 
L206:   aaload 
L207:   invokevirtual [58] 
L210:   putfield [83] 
L213:   aload_2 
L214:   aload 4 
L216:   iconst_0 
L217:   aaload 
L218:   invokevirtual [59] 
L221:   putfield [92] 
L224:   goto L270 
L227:   aload_0 
L228:   getfield [34] 
L231:   sipush 10000 
L234:   ldc [12] 
L236:   getstatic [13] 
L239:   ifnonnull L254 
L242:   ldc [14] 
L244:   invokestatic [15] 
L247:   dup 
L248:   putstatic [73] 
L251:   goto L257 
L254:   getstatic [13] 
L257:   invokevirtual [60] 
L260:   aload_1 
L261:   invokespecial [74] 
L264:   invokevirtual [60] 
L267:   invokevirtual [61] 
L270:   aload_2 
L271:   areturn 
L272:   
    .end code 
.end method 

.method private static [484] : [485] 
    .attribute [465] .code stack 4 locals 4 
L0:     fload_0 
L1:     invokestatic [16] 
L4:     ifne L14 
L7:     fload_1 
L8:     invokestatic [16] 
L11:    ifeq L16 
L14:    aconst_null 
L15:    areturn 
L16:    fload_0 
L17:    f2d 
L18:    invokestatic [17] 
L21:    istore_2 
L22:    fload_1 
L23:    f2d 
L24:    invokestatic [17] 
L27:    istore_3 
L28:    new [93] 
L31:    dup 
L32:    iload_2 
L33:    iload_3 
L34:    invokespecial [75] 
L37:    astore 4 
L39:    new [94] 
L42:    dup 
L43:    invokespecial [76] 
L46:    astore 5 
L48:    aload 5 
L50:    aload 4 
L52:    invokevirtual [62] 
L55:    invokevirtual [63] 
L58:    ldc [20] 
L60:    invokevirtual [63] 
L63:    aload 4 
L65:    invokevirtual [64] 
L68:    invokevirtual [63] 
L71:    pop 
L72:    aload 5 
L74:    invokevirtual [65] 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [486] : [487] 
    .attribute [465] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [488] : [489] 
    .attribute [465] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [490] : [491] 
    .attribute [465] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [66] 
L4:     pop 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [492] : [493] 
    .attribute [465] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [79] 
L5:     iload_1 
L6:     ifeq L13 
L9:     aload_0 
L10:    invokespecial [69] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public enum [494] : [495] 
    .attribute [465] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [496] : [497] 
    .attribute [465] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [498] : [499] 
    .attribute [465] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [500] : [501] 
    .attribute [465] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [78] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [502] : [503] 
    .attribute [465] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [77] 
L9:     dup 
L10:    invokespecial [67] 
L13:    aload_1 
L14:    invokevirtual [30] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [95] [96] 
.const [3] = Class [97] 
.const [4] = Class [98] 
.const [5] = Int -2137614336 
.const [6] = String [99] 
.const [7] = Class [100] 
.const [8] = String [101] 
.const [9] = Class [102] 
.const [10] = Class [103] 
.const [11] = Method [104] [105] 
.const [12] = String [106] 
.const [13] = Field [107] [108] 
.const [14] = String [109] 
.const [15] = Method [110] [111] 
.const [16] = Method [112] [113] 
.const [17] = Method [114] [115] 
.const [18] = Class [116] 
.const [19] = Class [117] 
.const [20] = String [118] 
.const [21] = Class [119] 
.const [22] = Class [120] 
.const [23] = Class [121] 
.const [24] = Class [122] 
.const [25] = Class [123] 
.const [26] = Class [124] 
.const [27] = Class [125] 
.const [28] = Class [126] 
.const [29] = Class [127] 
.const [30] = Method [128] [129] 
.const [31] = Field [130] [131] 
.const [32] = Field [132] [133] 
.const [33] = Method [134] [135] 
.const [34] = Field [136] [137] 
.const [35] = Method [138] [139] 
.const [36] = Field [140] [141] 
.const [37] = Method [142] [143] 
.const [38] = Method [144] [145] 
.const [39] = Method [146] [147] 
.const [40] = Method [148] [149] 
.const [41] = Method [150] [151] 
.const [42] = Method [152] [153] 
.const [43] = Method [154] [155] 
.const [44] = Method [156] [157] 
.const [45] = Method [158] [159] 
.const [46] = Method [160] [161] 
.const [47] = Method [162] [163] 
.const [48] = Method [164] [165] 
.const [49] = Method [166] [167] 
.const [50] = Method [168] [169] 
.const [51] = Method [170] [171] 
.const [52] = Method [172] [173] 
.const [53] = Method [174] [175] 
.const [54] = Method [176] [177] 
.const [55] = Method [178] [179] 
.const [56] = Method [180] [181] 
.const [57] = Method [182] [183] 
.const [58] = Method [184] [185] 
.const [59] = Method [186] [187] 
.const [60] = Method [188] [189] 
.const [61] = Method [190] [191] 
.const [62] = Method [192] [193] 
.const [63] = Method [194] [195] 
.const [64] = Method [196] [197] 
.const [65] = Method [198] [199] 
.const [66] = Method [200] [201] 
.const [67] = Method [202] [203] 
.const [68] = Method [204] [205] 
.const [69] = Method [206] [207] 
.const [70] = Method [208] [209] 
.const [71] = Method [210] [211] 
.const [72] = Method [212] [213] 
.const [73] = Field [214] [215] 
.const [74] = Method [216] [217] 
.const [75] = Method [218] [219] 
.const [76] = Method [220] [221] 
.const [77] = Class [222] 
.const [78] = Field [223] [224] 
.const [79] = Field [225] [226] 
.const [80] = Class [227] 
.const [81] = Field [228] [229] 
.const [82] = Field [230] [231] 
.const [83] = Field [232] [233] 
.const [84] = Field [234] [235] 
.const [85] = Field [236] [237] 
.const [86] = Field [238] [239] 
.const [87] = Field [240] [241] 
.const [88] = Field [242] [243] 
.const [89] = Field [244] [245] 
.const [90] = Field [246] [247] 
.const [91] = Field [248] [249] 
.const [92] = Field [250] [251] 
.const [93] = Class [252] 
.const [94] = Class [253] 
.const [95] = Class [254] 
.const [96] = NameAndType [255] [256] 
.const [97] = Utf8 java/lang/ClassNotFoundException 
.const [98] = Utf8 java/lang/NoClassDefFoundError 
.const [99] = Utf8 '[AbstractDestinationsListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1' 
.const [100] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [101] = Utf8 '[AbstractDestinationsListAdapterFastList#sendCurrentList] called (pushListNotification=%1)' 
.const [102] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [103] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [104] = Class [257] 
.const [105] = NameAndType [258] [259] 
.const [106] = Utf8 '[AbstractDestinationsListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)' 
.const [107] = Class [260] 
.const [108] = NameAndType [261] [262] 
.const [109] = Utf8 'de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry' 
.const [110] = Class [263] 
.const [111] = NameAndType [264] [265] 
.const [112] = Class [266] 
.const [113] = NameAndType [267] [268] 
.const [114] = Class [269] 
.const [115] = NameAndType [270] [271] 
.const [116] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [117] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [118] = Utf8 ', ' 
.const [119] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [120] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractListAdapterFastListNavi 
.const [121] = Utf8 java/lang/Class 
.const [122] = Utf8 de/audi/atip/log/LogChannel 
.const [123] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/FormattedDestination 
.const [124] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [125] = Utf8 java/lang/Object 
.const [126] = Utf8 java/lang/Float 
.const [127] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [128] = Class [272] 
.const [129] = NameAndType [273] [274] 
.const [130] = Class [275] 
.const [131] = NameAndType [276] [277] 
.const [132] = Class [278] 
.const [133] = NameAndType [279] [280] 
.const [134] = Class [281] 
.const [135] = NameAndType [282] [283] 
.const [136] = Class [284] 
.const [137] = NameAndType [285] [286] 
.const [138] = Class [287] 
.const [139] = NameAndType [288] [289] 
.const [140] = Class [290] 
.const [141] = NameAndType [291] [292] 
.const [142] = Class [293] 
.const [143] = NameAndType [294] [295] 
.const [144] = Class [296] 
.const [145] = NameAndType [297] [298] 
.const [146] = Class [299] 
.const [147] = NameAndType [300] [301] 
.const [148] = Class [302] 
.const [149] = NameAndType [303] [304] 
.const [150] = Class [305] 
.const [151] = NameAndType [306] [307] 
.const [152] = Class [308] 
.const [153] = NameAndType [309] [310] 
.const [154] = Class [311] 
.const [155] = NameAndType [312] [313] 
.const [156] = Class [314] 
.const [157] = NameAndType [315] [316] 
.const [158] = Class [317] 
.const [159] = NameAndType [318] [319] 
.const [160] = Class [320] 
.const [161] = NameAndType [321] [322] 
.const [162] = Class [323] 
.const [163] = NameAndType [324] [325] 
.const [164] = Class [326] 
.const [165] = NameAndType [327] [328] 
.const [166] = Class [329] 
.const [167] = NameAndType [330] [331] 
.const [168] = Class [332] 
.const [169] = NameAndType [333] [334] 
.const [170] = Class [335] 
.const [171] = NameAndType [336] [337] 
.const [172] = Class [338] 
.const [173] = NameAndType [339] [340] 
.const [174] = Class [341] 
.const [175] = NameAndType [342] [343] 
.const [176] = Class [344] 
.const [177] = NameAndType [345] [346] 
.const [178] = Class [347] 
.const [179] = NameAndType [348] [349] 
.const [180] = Class [350] 
.const [181] = NameAndType [351] [352] 
.const [182] = Class [353] 
.const [183] = NameAndType [354] [355] 
.const [184] = Class [356] 
.const [185] = NameAndType [357] [358] 
.const [186] = Class [359] 
.const [187] = NameAndType [360] [361] 
.const [188] = Class [362] 
.const [189] = NameAndType [363] [364] 
.const [190] = Class [365] 
.const [191] = NameAndType [366] [367] 
.const [192] = Class [368] 
.const [193] = NameAndType [369] [370] 
.const [194] = Class [371] 
.const [195] = NameAndType [372] [373] 
.const [196] = Class [374] 
.const [197] = NameAndType [375] [376] 
.const [198] = Class [377] 
.const [199] = NameAndType [378] [379] 
.const [200] = Class [380] 
.const [201] = NameAndType [381] [382] 
.const [202] = Class [383] 
.const [203] = NameAndType [384] [385] 
.const [204] = Class [386] 
.const [205] = NameAndType [387] [388] 
.const [206] = Class [389] 
.const [207] = NameAndType [390] [391] 
.const [208] = Class [392] 
.const [209] = NameAndType [393] [394] 
.const [210] = Class [395] 
.const [211] = NameAndType [396] [397] 
.const [212] = Class [398] 
.const [213] = NameAndType [399] [400] 
.const [214] = Class [401] 
.const [215] = NameAndType [402] [403] 
.const [216] = Class [404] 
.const [217] = NameAndType [405] [406] 
.const [218] = Class [407] 
.const [219] = NameAndType [408] [409] 
.const [220] = Class [410] 
.const [221] = NameAndType [411] [412] 
.const [222] = Utf8 java/lang/NoClassDefFoundError 
.const [223] = Class [413] 
.const [224] = NameAndType [414] [415] 
.const [225] = Class [416] 
.const [226] = NameAndType [417] [418] 
.const [227] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [228] = Class [419] 
.const [229] = NameAndType [420] [421] 
.const [230] = Class [422] 
.const [231] = NameAndType [423] [424] 
.const [232] = Class [425] 
.const [233] = NameAndType [426] [427] 
.const [234] = Class [428] 
.const [235] = NameAndType [429] [430] 
.const [236] = Class [431] 
.const [237] = NameAndType [432] [433] 
.const [238] = Class [434] 
.const [239] = NameAndType [435] [436] 
.const [240] = Class [437] 
.const [241] = NameAndType [438] [439] 
.const [242] = Class [440] 
.const [243] = NameAndType [441] [442] 
.const [244] = Class [443] 
.const [245] = NameAndType [444] [445] 
.const [246] = Class [446] 
.const [247] = NameAndType [447] [448] 
.const [248] = Class [449] 
.const [249] = NameAndType [450] [451] 
.const [250] = Class [452] 
.const [251] = NameAndType [453] [454] 
.const [252] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [253] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [254] = Utf8 java/lang/Class 
.const [255] = Utf8 forName 
.const [256] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [257] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [258] = Utf8 getCoordinates 
.const [259] = Utf8 (FF)Ljava/lang/String; 
.const [260] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [261] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry 
.const [262] = Utf8 Ljava/lang/Class; 
.const [263] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [264] = Utf8 class$ 
.const [265] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [266] = Utf8 java/lang/Float 
.const [267] = Utf8 isNaN 
.const [268] = Utf8 (F)Z 
.const [269] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [270] = Utf8 degreeToWgs84 
.const [271] = Utf8 (D)I 
.const [272] = Utf8 java/lang/NoClassDefFoundError 
.const [273] = Utf8 initCause 
.const [274] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [275] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [276] = Utf8 pushListNotification 
.const [277] = Utf8 Z 
.const [278] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [279] = Utf8 currentListSizeNotification 
.const [280] = Utf8 Z 
.const [281] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [282] = Utf8 sendCurrentList 
.const [283] = Utf8 ()V 
.const [284] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [285] = Utf8 logChannel 
.const [286] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [287] = Utf8 de/audi/atip/log/LogChannel 
.const [288] = Utf8 log 
.const [289] = Utf8 (ILjava/lang/String;Z)Z 
.const [290] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [291] = Utf8 listHandler 
.const [292] = Utf8 Lde/audi/app/bap/fw/arrays/ArrayHandler; 
.const [293] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [294] = Utf8 getManagedList 
.const [295] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [296] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [297] = Utf8 pushCurrentListSize 
.const [298] = Utf8 (I)V 
.const [299] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [300] = Utf8 pushList 
.const [301] = Utf8 ([Lorg/dsi/ifc/kombifastlist/DataAddress;)V 
.const [302] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [303] = Utf8 getPosID 
.const [304] = Utf8 ()I 
.const [305] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [306] = Utf8 getAddressList 
.const [307] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination; 
.const [308] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [309] = Utf8 getDescription 
.const [310] = Utf8 ()Ljava/lang/String; 
.const [311] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [312] = Utf8 getPOIType 
.const [313] = Utf8 ()I 
.const [314] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [315] = Utf8 hasFormattedDestination 
.const [316] = Utf8 ()Z 
.const [317] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [318] = Utf8 getFormattedDestination 
.const [319] = Utf8 ()Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination; 
.const [320] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/FormattedDestination 
.const [321] = Utf8 getFirstLine 
.const [322] = Utf8 ()Ljava/lang/String; 
.const [323] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/FormattedDestination 
.const [324] = Utf8 getSecondLine 
.const [325] = Utf8 ()Ljava/lang/String; 
.const [326] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [327] = Utf8 getLastName 
.const [328] = Utf8 ()Ljava/lang/String; 
.const [329] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [330] = Utf8 getFirstName 
.const [331] = Utf8 ()Ljava/lang/String; 
.const [332] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [333] = Utf8 getStreet 
.const [334] = Utf8 ()Ljava/lang/String; 
.const [335] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [336] = Utf8 getCity 
.const [337] = Utf8 ()Ljava/lang/String; 
.const [338] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [339] = Utf8 getState 
.const [340] = Utf8 ()Ljava/lang/String; 
.const [341] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [342] = Utf8 getPostalCode 
.const [343] = Utf8 ()Ljava/lang/String; 
.const [344] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [345] = Utf8 getCountry 
.const [346] = Utf8 ()Ljava/lang/String; 
.const [347] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [348] = Utf8 getLatitude 
.const [349] = Utf8 ()F 
.const [350] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [351] = Utf8 getLongitude 
.const [352] = Utf8 ()F 
.const [353] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [354] = Utf8 getPOIDescription 
.const [355] = Utf8 ()Ljava/lang/String; 
.const [356] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [357] = Utf8 getPOIType 
.const [358] = Utf8 ()I 
.const [359] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [360] = Utf8 getAddressType 
.const [361] = Utf8 ()I 
.const [362] = Utf8 java/lang/Class 
.const [363] = Utf8 getName 
.const [364] = Utf8 ()Ljava/lang/String; 
.const [365] = Utf8 de/audi/atip/log/LogChannel 
.const [366] = Utf8 log 
.const [367] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [368] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [369] = Utf8 formatLatitude 
.const [370] = Utf8 ()Ljava/lang/String; 
.const [371] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [372] = Utf8 append 
.const [373] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [374] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [375] = Utf8 formatLongitude 
.const [376] = Utf8 ()Ljava/lang/String; 
.const [377] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [378] = Utf8 toString 
.const [379] = Utf8 ()Ljava/lang/String; 
.const [380] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [381] = Utf8 sendFullRangeUpdate 
.const [382] = Utf8 ()Z 
.const [383] = Utf8 java/lang/NoClassDefFoundError 
.const [384] = Utf8 <init> 
.const [385] = Utf8 ()V 
.const [386] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractListAdapterFastListNavi 
.const [387] = Utf8 <init> 
.const [388] = Utf8 (Lde/audi/app/bap/fw/arrays/ArrayHandler;)V 
.const [389] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [390] = Utf8 sendCurrentListSize 
.const [391] = Utf8 ()V 
.const [392] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [393] = Utf8 convertList 
.const [394] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)[Lorg/dsi/ifc/kombifastlist/DataAddress; 
.const [395] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [396] = Utf8 convertArrayElement 
.const [397] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Lorg/dsi/ifc/kombifastlist/DataAddress; 
.const [398] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [399] = Utf8 <init> 
.const [400] = Utf8 ()V 
.const [401] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [402] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry 
.const [403] = Utf8 Ljava/lang/Class; 
.const [404] = Utf8 java/lang/Object 
.const [405] = Utf8 getClass 
.const [406] = Utf8 ()Ljava/lang/Class; 
.const [407] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [408] = Utf8 <init> 
.const [409] = Utf8 (II)V 
.const [410] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [411] = Utf8 <init> 
.const [412] = Utf8 ()V 
.const [413] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [414] = Utf8 pushListNotification 
.const [415] = Utf8 Z 
.const [416] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [417] = Utf8 currentListSizeNotification 
.const [418] = Utf8 Z 
.const [419] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [420] = Utf8 pos 
.const [421] = Utf8 I 
.const [422] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [423] = Utf8 poiDescription 
.const [424] = Utf8 Ljava/lang/String; 
.const [425] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [426] = Utf8 poiType 
.const [427] = Utf8 I 
.const [428] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [429] = Utf8 coordinates 
.const [430] = Utf8 Ljava/lang/String; 
.const [431] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [432] = Utf8 lastName 
.const [433] = Utf8 Ljava/lang/String; 
.const [434] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [435] = Utf8 firstName 
.const [436] = Utf8 Ljava/lang/String; 
.const [437] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [438] = Utf8 street 
.const [439] = Utf8 Ljava/lang/String; 
.const [440] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [441] = Utf8 city 
.const [442] = Utf8 Ljava/lang/String; 
.const [443] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [444] = Utf8 region 
.const [445] = Utf8 Ljava/lang/String; 
.const [446] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [447] = Utf8 postalCode 
.const [448] = Utf8 Ljava/lang/String; 
.const [449] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [450] = Utf8 country 
.const [451] = Utf8 Ljava/lang/String; 
.const [452] = Utf8 org/dsi/ifc/kombifastlist/DataAddress 
.const [453] = Utf8 addressType 
.const [454] = Utf8 I 
.const [455] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractDestinationsListAdapterFastList 
.const [456] = Class [455] 
.const [457] = Utf8 de/audi/app/combi/bap/app/navi/list/AbstractListAdapterFastListNavi 
.const [458] = Class [457] 
.const [459] = Utf8 pushListNotification 
.const [460] = Utf8 Z 
.const [461] = Utf8 currentListSizeNotification 
.const [462] = Utf8 Z 
.const [463] = Utf8 class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry 
.const [464] = Utf8 Ljava/lang/Class; 
.const [465] = Utf8 Code 
.const [466] = Utf8 <init> 
.const [467] = Utf8 (Lde/audi/app/bap/fw/arrays/ArrayHandler;)V 
.const [468] = Utf8 getDSINotifications 
.const [469] = Utf8 ()[I 
.const [470] = Utf8 sendFullRangeUpdate 
.const [471] = Utf8 ()Z 
.const [472] = Utf8 sendCurrentListSize 
.const [473] = Utf8 ()V 
.const [474] = Utf8 sendCurrentList 
.const [475] = Utf8 ()V 
.const [476] = Utf8 pushCurrentListSize 
.const [477] = Utf8 (I)V 
.const [478] = Utf8 pushList 
.const [479] = Utf8 ([Lorg/dsi/ifc/kombifastlist/DataAddress;)V 
.const [480] = Utf8 convertList 
.const [481] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)[Lorg/dsi/ifc/kombifastlist/DataAddress; 
.const [482] = Utf8 convertArrayElement 
.const [483] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Lorg/dsi/ifc/kombifastlist/DataAddress; 
.const [484] = Utf8 getCoordinates 
.const [485] = Utf8 (FF)Ljava/lang/String; 
.const [486] = Utf8 isSpontaneousStatusRequestSupported 
.const [487] = Utf8 ()Z 
.const [488] = Utf8 sendStatusRequest 
.const [489] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [490] = Utf8 sendChangedArrayRequest 
.const [491] = Utf8 (Lde/audi/app/bap/fw/arrays/ListDelta;)V 
.const [492] = Utf8 setNotificationCurrentListSizes 
.const [493] = Utf8 (Z)V 
.const [494] = Utf8 addNavBookJob 
.const [495] = Utf8 (IILorg/dsi/ifc/kombifastlist/ArrayHeader;)V 
.const [496] = Utf8 addNavBookJobs 
.const [497] = Utf8 (II[Lorg/dsi/ifc/kombifastlist/ArrayHeader;)V 
.const [498] = Utf8 isPushListNotification 
.const [499] = Utf8 ()Z 
.const [500] = Utf8 setPushListNotification 
.const [501] = Utf8 (Z)V 
.const [502] = Utf8 class$ 
.const [503] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
