.version 50 0 
.class public final super [745] 
.super [747] 
.field public static final [748] [749] 
.field public static final [750] [751] 
.field public static final [752] [753] 
.field public static final [754] [755] 
.field public static final [756] [757] 
.field public static final [758] [759] 
.field public static final [760] [761] 
.field public static final [762] [763] 
.field public static final [764] [765] 
.field public static final [766] [767] 
.field public static final [768] [769] 
.field public static final [770] [771] 
.field public static final [772] [773] 
.field public static final [774] [775] 
.field public static final [776] [777] 
.field public static final [778] [779] 
.field public static final [780] [781] 
.field public static final [782] [783] 
.field public static final [784] [785] 
.field public static final [786] [787] 
.field public static final [788] [789] 
.field public static final [790] [791] 
.field public static final [792] [793] 
.field public static final [794] [795] 
.field public static final [796] [797] 
.field public static final [798] [799] 
.field public static final [800] [801] 
.field public static final [802] [803] 
.field public static final [804] [805] 
.field private static [806] [807] 
.field private static [808] [809] 
.field private final [810] [811] 
.field private final [812] [813] 
.field static synthetic [814] [815] 

.method public final interface [817] : [818] 
    .attribute [816] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [106] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [819] : [820] 
    .attribute [816] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [107] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [821] : [822] 
    .attribute [816] .code stack 5 locals 1 
L0:     iload_0 
L1:     getstatic [5] 
L4:     arraylength 
L5:     if_icmpge L30 
L8:     iload_0 
L9:     iflt L30 
L12:    getstatic [5] 
L15:    iload_0 
L16:    aaload 
L17:    getfield [106] 
L20:    iload_0 
L21:    if_icmpne L30 
L24:    getstatic [5] 
L27:    iload_0 
L28:    aaload 
L29:    areturn 
L30:    iconst_0 
L31:    istore_1 
L32:    iload_1 
L33:    getstatic [5] 
L36:    arraylength 
L37:    if_icmpge L64 
L40:    getstatic [5] 
L43:    iload_1 
L44:    aaload 
L45:    getfield [106] 
L48:    iload_0 
L49:    if_icmpne L58 
L52:    getstatic [5] 
L55:    iload_1 
L56:    aaload 
L57:    areturn 
L58:    iinc 1 1 
L61:    goto L32 
L64:    new [152] 
L67:    dup 
L68:    new [153] 
L71:    dup 
L72:    invokespecial [114] 
L75:    ldc [8] 
L77:    invokevirtual [108] 
L80:    getstatic [9] 
L83:    ifnonnull L98 
L86:    ldc [10] 
L88:    invokestatic [11] 
L91:    dup 
L92:    putstatic [115] 
L95:    goto L101 
L98:    getstatic [9] 
L101:   invokevirtual [109] 
L104:   ldc [12] 
L106:   invokevirtual [108] 
L109:   iload_0 
L110:   invokevirtual [110] 
L113:   invokevirtual [111] 
L116:   invokespecial [116] 
L119:   athrow 
L120:   
    .end code 
.end method 

.method private [823] : [824] 
    .attribute [816] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [117] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [151] 
L9:     aload_0 
L10:    getstatic [13] 
L13:    dup 
L14:    iconst_1 
L15:    iadd 
L16:    putstatic [118] 
L19:    putfield [150] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [825] : [826] 
    .attribute [816] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [117] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [151] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [150] 
L14:    iload_2 
L15:    iconst_1 
L16:    iadd 
L17:    putstatic [118] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [827] : [828] 
    .attribute [816] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [117] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [151] 
L9:     aload_0 
L10:    aload_2 
L11:    getfield [106] 
L14:    putfield [150] 
L17:    aload_0 
L18:    getfield [106] 
L21:    iconst_1 
L22:    iadd 
L23:    putstatic [118] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [829] : [830] 
    .attribute [816] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [149] 
L9:     dup 
L10:    invokespecial [112] 
L13:    aload_1 
L14:    invokevirtual [105] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [831] : [832] 
    .attribute [816] .code stack 4 locals 0 
L0:     new [154] 
L3:     dup 
L4:     ldc [15] 
L6:     invokestatic [16] 
L9:     invokespecial [119] 
L12:    putstatic [120] 
L15:    new [154] 
L18:    dup 
L19:    ldc [18] 
L21:    invokestatic [19] 
L24:    invokespecial [119] 
L27:    putstatic [121] 
L30:    new [154] 
L33:    dup 
L34:    ldc [21] 
L36:    invokestatic [22] 
L39:    invokespecial [119] 
L42:    putstatic [122] 
L45:    new [154] 
L48:    dup 
L49:    ldc [24] 
L51:    invokestatic [25] 
L54:    invokespecial [119] 
L57:    putstatic [123] 
L60:    new [154] 
L63:    dup 
L64:    ldc [27] 
L66:    invokestatic [28] 
L69:    invokespecial [119] 
L72:    putstatic [124] 
L75:    new [154] 
L78:    dup 
L79:    ldc [30] 
L81:    invokestatic [31] 
L84:    invokespecial [119] 
L87:    putstatic [125] 
L90:    new [154] 
L93:    dup 
L94:    ldc [33] 
L96:    invokestatic [34] 
L99:    invokespecial [119] 
L102:   putstatic [126] 
L105:   new [154] 
L108:   dup 
L109:   ldc [36] 
L111:   invokestatic [37] 
L114:   invokespecial [119] 
L117:   putstatic [127] 
L120:   new [154] 
L123:   dup 
L124:   ldc [39] 
L126:   invokestatic [40] 
L129:   invokespecial [119] 
L132:   putstatic [128] 
L135:   new [154] 
L138:   dup 
L139:   ldc [42] 
L141:   invokestatic [43] 
L144:   invokespecial [119] 
L147:   putstatic [129] 
L150:   new [154] 
L153:   dup 
L154:   ldc [45] 
L156:   invokestatic [46] 
L159:   invokespecial [119] 
L162:   putstatic [130] 
L165:   new [154] 
L168:   dup 
L169:   ldc [48] 
L171:   invokestatic [49] 
L174:   invokespecial [119] 
L177:   putstatic [131] 
L180:   new [154] 
L183:   dup 
L184:   ldc [51] 
L186:   invokestatic [52] 
L189:   invokespecial [119] 
L192:   putstatic [132] 
L195:   new [154] 
L198:   dup 
L199:   ldc [54] 
L201:   invokestatic [55] 
L204:   invokespecial [119] 
L207:   putstatic [133] 
L210:   new [154] 
L213:   dup 
L214:   ldc [57] 
L216:   invokestatic [58] 
L219:   invokespecial [119] 
L222:   putstatic [134] 
L225:   new [154] 
L228:   dup 
L229:   ldc [60] 
L231:   invokestatic [61] 
L234:   invokespecial [119] 
L237:   putstatic [135] 
L240:   new [154] 
L243:   dup 
L244:   ldc [63] 
L246:   invokestatic [64] 
L249:   invokespecial [119] 
L252:   putstatic [136] 
L255:   new [154] 
L258:   dup 
L259:   ldc [66] 
L261:   invokestatic [67] 
L264:   invokespecial [119] 
L267:   putstatic [137] 
L270:   new [154] 
L273:   dup 
L274:   ldc [69] 
L276:   invokestatic [70] 
L279:   invokespecial [119] 
L282:   putstatic [138] 
L285:   new [154] 
L288:   dup 
L289:   ldc [72] 
L291:   invokestatic [73] 
L294:   invokespecial [119] 
L297:   putstatic [139] 
L300:   new [154] 
L303:   dup 
L304:   ldc [75] 
L306:   invokestatic [76] 
L309:   invokespecial [119] 
L312:   putstatic [140] 
L315:   new [154] 
L318:   dup 
L319:   ldc [78] 
L321:   invokestatic [79] 
L324:   invokespecial [119] 
L327:   putstatic [141] 
L330:   new [154] 
L333:   dup 
L334:   ldc [81] 
L336:   invokestatic [82] 
L339:   invokespecial [119] 
L342:   putstatic [142] 
L345:   new [154] 
L348:   dup 
L349:   ldc [84] 
L351:   invokestatic [85] 
L354:   invokespecial [119] 
L357:   putstatic [143] 
L360:   new [154] 
L363:   dup 
L364:   ldc [87] 
L366:   invokestatic [88] 
L369:   invokespecial [119] 
L372:   putstatic [144] 
L375:   new [154] 
L378:   dup 
L379:   ldc [90] 
L381:   invokestatic [91] 
L384:   invokespecial [119] 
L387:   putstatic [145] 
L390:   new [154] 
L393:   dup 
L394:   ldc [93] 
L396:   invokestatic [94] 
L399:   invokespecial [119] 
L402:   putstatic [146] 
L405:   new [154] 
L408:   dup 
L409:   ldc [96] 
L411:   invokestatic [97] 
L414:   invokespecial [119] 
L417:   putstatic [147] 
L420:   new [154] 
L423:   dup 
L424:   ldc [99] 
L426:   invokestatic [100] 
L429:   invokespecial [119] 
L432:   putstatic [148] 
L435:   bipush 29 
L437:   anewarray [14] 
L440:   dup 
L441:   iconst_0 
L442:   getstatic [17] 
L445:   aastore 
L446:   dup 
L447:   iconst_1 
L448:   getstatic [20] 
L451:   aastore 
L452:   dup 
L453:   iconst_2 
L454:   getstatic [23] 
L457:   aastore 
L458:   dup 
L459:   iconst_3 
L460:   getstatic [26] 
L463:   aastore 
L464:   dup 
L465:   iconst_4 
L466:   getstatic [29] 
L469:   aastore 
L470:   dup 
L471:   iconst_5 
L472:   getstatic [32] 
L475:   aastore 
L476:   dup 
L477:   bipush 6 
L479:   getstatic [35] 
L482:   aastore 
L483:   dup 
L484:   bipush 7 
L486:   getstatic [38] 
L489:   aastore 
L490:   dup 
L491:   bipush 8 
L493:   getstatic [41] 
L496:   aastore 
L497:   dup 
L498:   bipush 9 
L500:   getstatic [44] 
L503:   aastore 
L504:   dup 
L505:   bipush 10 
L507:   getstatic [47] 
L510:   aastore 
L511:   dup 
L512:   bipush 11 
L514:   getstatic [50] 
L517:   aastore 
L518:   dup 
L519:   bipush 12 
L521:   getstatic [53] 
L524:   aastore 
L525:   dup 
L526:   bipush 13 
L528:   getstatic [56] 
L531:   aastore 
L532:   dup 
L533:   bipush 14 
L535:   getstatic [59] 
L538:   aastore 
L539:   dup 
L540:   bipush 15 
L542:   getstatic [62] 
L545:   aastore 
L546:   dup 
L547:   bipush 16 
L549:   getstatic [65] 
L552:   aastore 
L553:   dup 
L554:   bipush 17 
L556:   getstatic [68] 
L559:   aastore 
L560:   dup 
L561:   bipush 18 
L563:   getstatic [71] 
L566:   aastore 
L567:   dup 
L568:   bipush 19 
L570:   getstatic [74] 
L573:   aastore 
L574:   dup 
L575:   bipush 20 
L577:   getstatic [77] 
L580:   aastore 
L581:   dup 
L582:   bipush 21 
L584:   getstatic [80] 
L587:   aastore 
L588:   dup 
L589:   bipush 22 
L591:   getstatic [83] 
L594:   aastore 
L595:   dup 
L596:   bipush 23 
L598:   getstatic [86] 
L601:   aastore 
L602:   dup 
L603:   bipush 24 
L605:   getstatic [89] 
L608:   aastore 
L609:   dup 
L610:   bipush 25 
L612:   getstatic [92] 
L615:   aastore 
L616:   dup 
L617:   bipush 26 
L619:   getstatic [95] 
L622:   aastore 
L623:   dup 
L624:   bipush 27 
L626:   getstatic [98] 
L629:   aastore 
L630:   dup 
L631:   bipush 28 
L633:   getstatic [101] 
L636:   aastore 
L637:   putstatic [113] 
L640:   iconst_0 
L641:   putstatic [118] 
L644:   return 
L645:   nop 
L646:   nop 
L647:   nop 
L648:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [155] [156] 
.const [3] = Class [157] 
.const [4] = Class [158] 
.const [5] = Field [159] [160] 
.const [6] = Class [161] 
.const [7] = Class [162] 
.const [8] = String [163] 
.const [9] = Field [164] [165] 
.const [10] = String [166] 
.const [11] = Method [167] [168] 
.const [12] = String [169] 
.const [13] = Field [170] [171] 
.const [14] = Class [172] 
.const [15] = String [173] 
.const [16] = Method [174] [175] 
.const [17] = Field [176] [177] 
.const [18] = String [178] 
.const [19] = Method [179] [180] 
.const [20] = Field [181] [182] 
.const [21] = String [183] 
.const [22] = Method [184] [185] 
.const [23] = Field [186] [187] 
.const [24] = String [188] 
.const [25] = Method [189] [190] 
.const [26] = Field [191] [192] 
.const [27] = String [193] 
.const [28] = Method [194] [195] 
.const [29] = Field [196] [197] 
.const [30] = String [198] 
.const [31] = Method [199] [200] 
.const [32] = Field [201] [202] 
.const [33] = String [203] 
.const [34] = Method [204] [205] 
.const [35] = Field [206] [207] 
.const [36] = String [208] 
.const [37] = Method [209] [210] 
.const [38] = Field [211] [212] 
.const [39] = String [213] 
.const [40] = Method [214] [215] 
.const [41] = Field [216] [217] 
.const [42] = String [218] 
.const [43] = Method [219] [220] 
.const [44] = Field [221] [222] 
.const [45] = String [223] 
.const [46] = Method [224] [225] 
.const [47] = Field [226] [227] 
.const [48] = String [228] 
.const [49] = Method [229] [230] 
.const [50] = Field [231] [232] 
.const [51] = String [233] 
.const [52] = Method [234] [235] 
.const [53] = Field [236] [237] 
.const [54] = String [238] 
.const [55] = Method [239] [240] 
.const [56] = Field [241] [242] 
.const [57] = String [243] 
.const [58] = Method [244] [245] 
.const [59] = Field [246] [247] 
.const [60] = String [248] 
.const [61] = Method [249] [250] 
.const [62] = Field [251] [252] 
.const [63] = String [253] 
.const [64] = Method [254] [255] 
.const [65] = Field [256] [257] 
.const [66] = String [258] 
.const [67] = Method [259] [260] 
.const [68] = Field [261] [262] 
.const [69] = String [263] 
.const [70] = Method [264] [265] 
.const [71] = Field [266] [267] 
.const [72] = String [268] 
.const [73] = Method [269] [270] 
.const [74] = Field [271] [272] 
.const [75] = String [273] 
.const [76] = Method [274] [275] 
.const [77] = Field [276] [277] 
.const [78] = String [278] 
.const [79] = Method [279] [280] 
.const [80] = Field [281] [282] 
.const [81] = String [283] 
.const [82] = Method [284] [285] 
.const [83] = Field [286] [287] 
.const [84] = String [288] 
.const [85] = Method [289] [290] 
.const [86] = Field [291] [292] 
.const [87] = String [293] 
.const [88] = Method [294] [295] 
.const [89] = Field [296] [297] 
.const [90] = String [298] 
.const [91] = Method [299] [300] 
.const [92] = Field [301] [302] 
.const [93] = String [303] 
.const [94] = Method [304] [305] 
.const [95] = Field [306] [307] 
.const [96] = String [308] 
.const [97] = Method [309] [310] 
.const [98] = Field [311] [312] 
.const [99] = String [313] 
.const [100] = Method [314] [315] 
.const [101] = Field [316] [317] 
.const [102] = Class [318] 
.const [103] = Class [319] 
.const [104] = Class [320] 
.const [105] = Method [321] [322] 
.const [106] = Field [323] [324] 
.const [107] = Field [325] [326] 
.const [108] = Method [327] [328] 
.const [109] = Method [329] [330] 
.const [110] = Method [331] [332] 
.const [111] = Method [333] [334] 
.const [112] = Method [335] [336] 
.const [113] = Field [337] [338] 
.const [114] = Method [339] [340] 
.const [115] = Field [341] [342] 
.const [116] = Method [343] [344] 
.const [117] = Method [345] [346] 
.const [118] = Field [347] [348] 
.const [119] = Method [349] [350] 
.const [120] = Field [351] [352] 
.const [121] = Field [353] [354] 
.const [122] = Field [355] [356] 
.const [123] = Field [357] [358] 
.const [124] = Field [359] [360] 
.const [125] = Field [361] [362] 
.const [126] = Field [363] [364] 
.const [127] = Field [365] [366] 
.const [128] = Field [367] [368] 
.const [129] = Field [369] [370] 
.const [130] = Field [371] [372] 
.const [131] = Field [373] [374] 
.const [132] = Field [375] [376] 
.const [133] = Field [377] [378] 
.const [134] = Field [379] [380] 
.const [135] = Field [381] [382] 
.const [136] = Field [383] [384] 
.const [137] = Field [385] [386] 
.const [138] = Field [387] [388] 
.const [139] = Field [389] [390] 
.const [140] = Field [391] [392] 
.const [141] = Field [393] [394] 
.const [142] = Field [395] [396] 
.const [143] = Field [397] [398] 
.const [144] = Field [399] [400] 
.const [145] = Field [401] [402] 
.const [146] = Field [403] [404] 
.const [147] = Field [405] [406] 
.const [148] = Field [407] [408] 
.const [149] = Class [409] 
.const [150] = Field [410] [411] 
.const [151] = Field [412] [413] 
.const [152] = Class [414] 
.const [153] = Class [415] 
.const [154] = Class [416] 
.const [155] = Class [417] 
.const [156] = NameAndType [418] [419] 
.const [157] = Utf8 java/lang/ClassNotFoundException 
.const [158] = Utf8 java/lang/NoClassDefFoundError 
.const [159] = Class [420] 
.const [160] = NameAndType [421] [422] 
.const [161] = Utf8 java/lang/IllegalArgumentException 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 'No enum ' 
.const [164] = Class [423] 
.const [165] = NameAndType [424] [425] 
.const [166] = Utf8 'de.esolutions.graphics.eal.texOptions_t' 
.const [167] = Class [426] 
.const [168] = NameAndType [427] [428] 
.const [169] = Utf8 ' with value ' 
.const [170] = Class [429] 
.const [171] = NameAndType [430] [431] 
.const [172] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [173] = Utf8 TEX_OPTIONS_MASK_MEMORY 
.const [174] = Class [432] 
.const [175] = NameAndType [433] [434] 
.const [176] = Class [435] 
.const [177] = NameAndType [436] [437] 
.const [178] = Utf8 TEX_OPTIONS_MASK_FILTER 
.const [179] = Class [438] 
.const [180] = NameAndType [439] [440] 
.const [181] = Class [441] 
.const [182] = NameAndType [442] [443] 
.const [183] = Utf8 TEX_OPTIONS_MASK_WRAP 
.const [184] = Class [444] 
.const [185] = NameAndType [445] [446] 
.const [186] = Class [447] 
.const [187] = NameAndType [448] [449] 
.const [188] = Utf8 TEX_OPTIONS_MASK_COMPRESSION 
.const [189] = Class [450] 
.const [190] = NameAndType [451] [452] 
.const [191] = Class [453] 
.const [192] = NameAndType [454] [455] 
.const [193] = Utf8 TEX_OPTIONS_MASK_FORMAT 
.const [194] = Class [456] 
.const [195] = NameAndType [457] [458] 
.const [196] = Class [459] 
.const [197] = NameAndType [460] [461] 
.const [198] = Utf8 TEX_OPTIONS_MASK_EXT 
.const [199] = Class [462] 
.const [200] = NameAndType [463] [464] 
.const [201] = Class [465] 
.const [202] = NameAndType [466] [467] 
.const [203] = Utf8 TEX_OPTIONS_MEMORY_GPU 
.const [204] = Class [468] 
.const [205] = NameAndType [469] [470] 
.const [206] = Class [471] 
.const [207] = NameAndType [472] [473] 
.const [208] = Utf8 TEX_OPTIONS_MEMORY_RAM 
.const [209] = Class [474] 
.const [210] = NameAndType [475] [476] 
.const [211] = Class [477] 
.const [212] = NameAndType [478] [479] 
.const [213] = Utf8 TEX_OPTIONS_FILTER_POINT 
.const [214] = Class [480] 
.const [215] = NameAndType [481] [482] 
.const [216] = Class [483] 
.const [217] = NameAndType [484] [485] 
.const [218] = Utf8 TEX_OPTIONS_FILTER_BILINEAR 
.const [219] = Class [486] 
.const [220] = NameAndType [487] [488] 
.const [221] = Class [489] 
.const [222] = NameAndType [490] [491] 
.const [223] = Utf8 TEX_OPTIONS_FILTER_TRILINAR 
.const [224] = Class [492] 
.const [225] = NameAndType [493] [494] 
.const [226] = Class [495] 
.const [227] = NameAndType [496] [497] 
.const [228] = Utf8 TEX_OPTIONS_FILTER_MIMAP 
.const [229] = Class [498] 
.const [230] = NameAndType [499] [500] 
.const [231] = Class [501] 
.const [232] = NameAndType [502] [503] 
.const [233] = Utf8 TEX_OPTIONS_WRAP_REPEAT 
.const [234] = Class [504] 
.const [235] = NameAndType [505] [506] 
.const [236] = Class [507] 
.const [237] = NameAndType [508] [509] 
.const [238] = Utf8 TEX_OPTIONS_WRAP_CLAMP 
.const [239] = Class [510] 
.const [240] = NameAndType [511] [512] 
.const [241] = Class [513] 
.const [242] = NameAndType [514] [515] 
.const [243] = Utf8 TEX_OPTIONS_COMPRESSION_NONE 
.const [244] = Class [516] 
.const [245] = NameAndType [517] [518] 
.const [246] = Class [519] 
.const [247] = NameAndType [520] [521] 
.const [248] = Utf8 TEX_OPTIONS_COMPRESSION_ETC 
.const [249] = Class [522] 
.const [250] = NameAndType [523] [524] 
.const [251] = Class [525] 
.const [252] = NameAndType [526] [527] 
.const [253] = Utf8 TEX_OPTIONS_COMPRESSION_DXT3_RGBA 
.const [254] = Class [528] 
.const [255] = NameAndType [529] [530] 
.const [256] = Class [531] 
.const [257] = NameAndType [532] [533] 
.const [258] = Utf8 TEX_OPTIONS_COMPRESSION_DXT5_RGBA 
.const [259] = Class [534] 
.const [260] = NameAndType [535] [536] 
.const [261] = Class [537] 
.const [262] = NameAndType [538] [539] 
.const [263] = Utf8 TEX_OPTIONS_FORMAT_RGBA_8888 
.const [264] = Class [540] 
.const [265] = NameAndType [541] [542] 
.const [266] = Class [543] 
.const [267] = NameAndType [544] [545] 
.const [268] = Utf8 TEX_OPTIONS_FORMAT_RGB_888 
.const [269] = Class [546] 
.const [270] = NameAndType [547] [548] 
.const [271] = Class [549] 
.const [272] = NameAndType [550] [551] 
.const [273] = Utf8 TEX_OPTIONS_FORMAT_RGB_565 
.const [274] = Class [552] 
.const [275] = NameAndType [553] [554] 
.const [276] = Class [555] 
.const [277] = NameAndType [556] [557] 
.const [278] = Utf8 TEX_OPTIONS_FORMAT_L_8 
.const [279] = Class [558] 
.const [280] = NameAndType [559] [560] 
.const [281] = Class [561] 
.const [282] = NameAndType [562] [563] 
.const [283] = Utf8 TEX_OPTIONS_FORMAT_A_8 
.const [284] = Class [564] 
.const [285] = NameAndType [565] [566] 
.const [286] = Class [567] 
.const [287] = NameAndType [568] [569] 
.const [288] = Utf8 TEX_OPTIONS_FORMAT_LA_88 
.const [289] = Class [570] 
.const [290] = NameAndType [571] [572] 
.const [291] = Class [573] 
.const [292] = NameAndType [574] [575] 
.const [293] = Utf8 TEX_OPTIONS_FORMAT_INVALID 
.const [294] = Class [576] 
.const [295] = NameAndType [577] [578] 
.const [296] = Class [579] 
.const [297] = NameAndType [580] [581] 
.const [298] = Utf8 TEX_OPTIONS_EXT_CLEAR_BLACK 
.const [299] = Class [582] 
.const [300] = NameAndType [583] [584] 
.const [301] = Class [585] 
.const [302] = NameAndType [586] [587] 
.const [303] = Utf8 TEX_OPTIONS_EXT_NO_ATLAS 
.const [304] = Class [588] 
.const [305] = NameAndType [589] [590] 
.const [306] = Class [591] 
.const [307] = NameAndType [592] [593] 
.const [308] = Utf8 TEX_OPTIONS_EXT_EXTERNAL_OES 
.const [309] = Class [594] 
.const [310] = NameAndType [595] [596] 
.const [311] = Class [597] 
.const [312] = NameAndType [598] [599] 
.const [313] = Utf8 TEX_OPTION_INVALID 
.const [314] = Class [600] 
.const [315] = NameAndType [601] [602] 
.const [316] = Class [603] 
.const [317] = NameAndType [604] [605] 
.const [318] = Utf8 java/lang/Object 
.const [319] = Utf8 java/lang/Class 
.const [320] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [321] = Class [606] 
.const [322] = NameAndType [607] [608] 
.const [323] = Class [609] 
.const [324] = NameAndType [610] [611] 
.const [325] = Class [612] 
.const [326] = NameAndType [613] [614] 
.const [327] = Class [615] 
.const [328] = NameAndType [616] [617] 
.const [329] = Class [618] 
.const [330] = NameAndType [619] [620] 
.const [331] = Class [621] 
.const [332] = NameAndType [622] [623] 
.const [333] = Class [624] 
.const [334] = NameAndType [625] [626] 
.const [335] = Class [627] 
.const [336] = NameAndType [628] [629] 
.const [337] = Class [630] 
.const [338] = NameAndType [631] [632] 
.const [339] = Class [633] 
.const [340] = NameAndType [634] [635] 
.const [341] = Class [636] 
.const [342] = NameAndType [637] [638] 
.const [343] = Class [639] 
.const [344] = NameAndType [640] [641] 
.const [345] = Class [642] 
.const [346] = NameAndType [643] [644] 
.const [347] = Class [645] 
.const [348] = NameAndType [646] [647] 
.const [349] = Class [648] 
.const [350] = NameAndType [649] [650] 
.const [351] = Class [651] 
.const [352] = NameAndType [652] [653] 
.const [353] = Class [654] 
.const [354] = NameAndType [655] [656] 
.const [355] = Class [657] 
.const [356] = NameAndType [658] [659] 
.const [357] = Class [660] 
.const [358] = NameAndType [661] [662] 
.const [359] = Class [663] 
.const [360] = NameAndType [664] [665] 
.const [361] = Class [666] 
.const [362] = NameAndType [667] [668] 
.const [363] = Class [669] 
.const [364] = NameAndType [670] [671] 
.const [365] = Class [672] 
.const [366] = NameAndType [673] [674] 
.const [367] = Class [675] 
.const [368] = NameAndType [676] [677] 
.const [369] = Class [678] 
.const [370] = NameAndType [679] [680] 
.const [371] = Class [681] 
.const [372] = NameAndType [682] [683] 
.const [373] = Class [684] 
.const [374] = NameAndType [685] [686] 
.const [375] = Class [687] 
.const [376] = NameAndType [688] [689] 
.const [377] = Class [690] 
.const [378] = NameAndType [691] [692] 
.const [379] = Class [693] 
.const [380] = NameAndType [694] [695] 
.const [381] = Class [696] 
.const [382] = NameAndType [697] [698] 
.const [383] = Class [699] 
.const [384] = NameAndType [700] [701] 
.const [385] = Class [702] 
.const [386] = NameAndType [703] [704] 
.const [387] = Class [705] 
.const [388] = NameAndType [706] [707] 
.const [389] = Class [708] 
.const [390] = NameAndType [709] [710] 
.const [391] = Class [711] 
.const [392] = NameAndType [712] [713] 
.const [393] = Class [714] 
.const [394] = NameAndType [715] [716] 
.const [395] = Class [717] 
.const [396] = NameAndType [718] [719] 
.const [397] = Class [720] 
.const [398] = NameAndType [721] [722] 
.const [399] = Class [723] 
.const [400] = NameAndType [724] [725] 
.const [401] = Class [726] 
.const [402] = NameAndType [727] [728] 
.const [403] = Class [729] 
.const [404] = NameAndType [730] [731] 
.const [405] = Class [732] 
.const [406] = NameAndType [733] [734] 
.const [407] = Class [735] 
.const [408] = NameAndType [736] [737] 
.const [409] = Utf8 java/lang/NoClassDefFoundError 
.const [410] = Class [738] 
.const [411] = NameAndType [739] [740] 
.const [412] = Class [741] 
.const [413] = NameAndType [742] [743] 
.const [414] = Utf8 java/lang/IllegalArgumentException 
.const [415] = Utf8 java/lang/StringBuffer 
.const [416] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [417] = Utf8 java/lang/Class 
.const [418] = Utf8 forName 
.const [419] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [420] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [421] = Utf8 swigValues 
.const [422] = Utf8 [Lde/esolutions/graphics/eal/texOptions_t; 
.const [423] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [424] = Utf8 class$de$esolutions$graphics$eal$texOptions_t 
.const [425] = Utf8 Ljava/lang/Class; 
.const [426] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [427] = Utf8 class$ 
.const [428] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [429] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [430] = Utf8 swigNext 
.const [431] = Utf8 I 
.const [432] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [433] = Utf8 eal_TEX_OPTIONS_MASK_MEMORY_get 
.const [434] = Utf8 ()I 
.const [435] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [436] = Utf8 TEX_OPTIONS_MASK_MEMORY 
.const [437] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [438] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [439] = Utf8 eal_TEX_OPTIONS_MASK_FILTER_get 
.const [440] = Utf8 ()I 
.const [441] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [442] = Utf8 TEX_OPTIONS_MASK_FILTER 
.const [443] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [444] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [445] = Utf8 eal_TEX_OPTIONS_MASK_WRAP_get 
.const [446] = Utf8 ()I 
.const [447] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [448] = Utf8 TEX_OPTIONS_MASK_WRAP 
.const [449] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [450] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [451] = Utf8 eal_TEX_OPTIONS_MASK_COMPRESSION_get 
.const [452] = Utf8 ()I 
.const [453] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [454] = Utf8 TEX_OPTIONS_MASK_COMPRESSION 
.const [455] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [456] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [457] = Utf8 eal_TEX_OPTIONS_MASK_FORMAT_get 
.const [458] = Utf8 ()I 
.const [459] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [460] = Utf8 TEX_OPTIONS_MASK_FORMAT 
.const [461] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [462] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [463] = Utf8 eal_TEX_OPTIONS_MASK_EXT_get 
.const [464] = Utf8 ()I 
.const [465] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [466] = Utf8 TEX_OPTIONS_MASK_EXT 
.const [467] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [468] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [469] = Utf8 eal_TEX_OPTIONS_MEMORY_GPU_get 
.const [470] = Utf8 ()I 
.const [471] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [472] = Utf8 TEX_OPTIONS_MEMORY_GPU 
.const [473] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [474] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [475] = Utf8 eal_TEX_OPTIONS_MEMORY_RAM_get 
.const [476] = Utf8 ()I 
.const [477] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [478] = Utf8 TEX_OPTIONS_MEMORY_RAM 
.const [479] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [480] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [481] = Utf8 eal_TEX_OPTIONS_FILTER_POINT_get 
.const [482] = Utf8 ()I 
.const [483] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [484] = Utf8 TEX_OPTIONS_FILTER_POINT 
.const [485] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [486] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [487] = Utf8 eal_TEX_OPTIONS_FILTER_BILINEAR_get 
.const [488] = Utf8 ()I 
.const [489] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [490] = Utf8 TEX_OPTIONS_FILTER_BILINEAR 
.const [491] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [492] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [493] = Utf8 eal_TEX_OPTIONS_FILTER_TRILINAR_get 
.const [494] = Utf8 ()I 
.const [495] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [496] = Utf8 TEX_OPTIONS_FILTER_TRILINAR 
.const [497] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [498] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [499] = Utf8 eal_TEX_OPTIONS_FILTER_MIMAP_get 
.const [500] = Utf8 ()I 
.const [501] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [502] = Utf8 TEX_OPTIONS_FILTER_MIMAP 
.const [503] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [504] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [505] = Utf8 eal_TEX_OPTIONS_WRAP_REPEAT_get 
.const [506] = Utf8 ()I 
.const [507] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [508] = Utf8 TEX_OPTIONS_WRAP_REPEAT 
.const [509] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [510] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [511] = Utf8 eal_TEX_OPTIONS_WRAP_CLAMP_get 
.const [512] = Utf8 ()I 
.const [513] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [514] = Utf8 TEX_OPTIONS_WRAP_CLAMP 
.const [515] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [516] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [517] = Utf8 eal_TEX_OPTIONS_COMPRESSION_NONE_get 
.const [518] = Utf8 ()I 
.const [519] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [520] = Utf8 TEX_OPTIONS_COMPRESSION_NONE 
.const [521] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [522] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [523] = Utf8 eal_TEX_OPTIONS_COMPRESSION_ETC_get 
.const [524] = Utf8 ()I 
.const [525] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [526] = Utf8 TEX_OPTIONS_COMPRESSION_ETC 
.const [527] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [528] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [529] = Utf8 eal_TEX_OPTIONS_COMPRESSION_DXT3_RGBA_get 
.const [530] = Utf8 ()I 
.const [531] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [532] = Utf8 TEX_OPTIONS_COMPRESSION_DXT3_RGBA 
.const [533] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [534] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [535] = Utf8 eal_TEX_OPTIONS_COMPRESSION_DXT5_RGBA_get 
.const [536] = Utf8 ()I 
.const [537] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [538] = Utf8 TEX_OPTIONS_COMPRESSION_DXT5_RGBA 
.const [539] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [540] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [541] = Utf8 eal_TEX_OPTIONS_FORMAT_RGBA_8888_get 
.const [542] = Utf8 ()I 
.const [543] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [544] = Utf8 TEX_OPTIONS_FORMAT_RGBA_8888 
.const [545] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [546] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [547] = Utf8 eal_TEX_OPTIONS_FORMAT_RGB_888_get 
.const [548] = Utf8 ()I 
.const [549] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [550] = Utf8 TEX_OPTIONS_FORMAT_RGB_888 
.const [551] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [552] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [553] = Utf8 eal_TEX_OPTIONS_FORMAT_RGB_565_get 
.const [554] = Utf8 ()I 
.const [555] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [556] = Utf8 TEX_OPTIONS_FORMAT_RGB_565 
.const [557] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [558] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [559] = Utf8 eal_TEX_OPTIONS_FORMAT_L_8_get 
.const [560] = Utf8 ()I 
.const [561] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [562] = Utf8 TEX_OPTIONS_FORMAT_L_8 
.const [563] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [564] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [565] = Utf8 eal_TEX_OPTIONS_FORMAT_A_8_get 
.const [566] = Utf8 ()I 
.const [567] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [568] = Utf8 TEX_OPTIONS_FORMAT_A_8 
.const [569] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [570] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [571] = Utf8 eal_TEX_OPTIONS_FORMAT_LA_88_get 
.const [572] = Utf8 ()I 
.const [573] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [574] = Utf8 TEX_OPTIONS_FORMAT_LA_88 
.const [575] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [576] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [577] = Utf8 eal_TEX_OPTIONS_FORMAT_INVALID_get 
.const [578] = Utf8 ()I 
.const [579] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [580] = Utf8 TEX_OPTIONS_FORMAT_INVALID 
.const [581] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [582] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [583] = Utf8 eal_TEX_OPTIONS_EXT_CLEAR_BLACK_get 
.const [584] = Utf8 ()I 
.const [585] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [586] = Utf8 TEX_OPTIONS_EXT_CLEAR_BLACK 
.const [587] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [588] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [589] = Utf8 eal_TEX_OPTIONS_EXT_NO_ATLAS_get 
.const [590] = Utf8 ()I 
.const [591] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [592] = Utf8 TEX_OPTIONS_EXT_NO_ATLAS 
.const [593] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [594] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [595] = Utf8 eal_TEX_OPTIONS_EXT_EXTERNAL_OES_get 
.const [596] = Utf8 ()I 
.const [597] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [598] = Utf8 TEX_OPTIONS_EXT_EXTERNAL_OES 
.const [599] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [600] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [601] = Utf8 eal_TEX_OPTION_INVALID_get 
.const [602] = Utf8 ()I 
.const [603] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [604] = Utf8 TEX_OPTION_INVALID 
.const [605] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [606] = Utf8 java/lang/NoClassDefFoundError 
.const [607] = Utf8 initCause 
.const [608] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [609] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [610] = Utf8 swigValue 
.const [611] = Utf8 I 
.const [612] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [613] = Utf8 swigName 
.const [614] = Utf8 Ljava/lang/String; 
.const [615] = Utf8 java/lang/StringBuffer 
.const [616] = Utf8 append 
.const [617] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [618] = Utf8 java/lang/StringBuffer 
.const [619] = Utf8 append 
.const [620] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [621] = Utf8 java/lang/StringBuffer 
.const [622] = Utf8 append 
.const [623] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [624] = Utf8 java/lang/StringBuffer 
.const [625] = Utf8 toString 
.const [626] = Utf8 ()Ljava/lang/String; 
.const [627] = Utf8 java/lang/NoClassDefFoundError 
.const [628] = Utf8 <init> 
.const [629] = Utf8 ()V 
.const [630] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [631] = Utf8 swigValues 
.const [632] = Utf8 [Lde/esolutions/graphics/eal/texOptions_t; 
.const [633] = Utf8 java/lang/StringBuffer 
.const [634] = Utf8 <init> 
.const [635] = Utf8 ()V 
.const [636] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [637] = Utf8 class$de$esolutions$graphics$eal$texOptions_t 
.const [638] = Utf8 Ljava/lang/Class; 
.const [639] = Utf8 java/lang/IllegalArgumentException 
.const [640] = Utf8 <init> 
.const [641] = Utf8 (Ljava/lang/String;)V 
.const [642] = Utf8 java/lang/Object 
.const [643] = Utf8 <init> 
.const [644] = Utf8 ()V 
.const [645] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [646] = Utf8 swigNext 
.const [647] = Utf8 I 
.const [648] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [649] = Utf8 <init> 
.const [650] = Utf8 (Ljava/lang/String;I)V 
.const [651] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [652] = Utf8 TEX_OPTIONS_MASK_MEMORY 
.const [653] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [654] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [655] = Utf8 TEX_OPTIONS_MASK_FILTER 
.const [656] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [657] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [658] = Utf8 TEX_OPTIONS_MASK_WRAP 
.const [659] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [660] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [661] = Utf8 TEX_OPTIONS_MASK_COMPRESSION 
.const [662] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [663] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [664] = Utf8 TEX_OPTIONS_MASK_FORMAT 
.const [665] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [666] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [667] = Utf8 TEX_OPTIONS_MASK_EXT 
.const [668] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [669] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [670] = Utf8 TEX_OPTIONS_MEMORY_GPU 
.const [671] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [672] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [673] = Utf8 TEX_OPTIONS_MEMORY_RAM 
.const [674] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [675] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [676] = Utf8 TEX_OPTIONS_FILTER_POINT 
.const [677] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [678] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [679] = Utf8 TEX_OPTIONS_FILTER_BILINEAR 
.const [680] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [681] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [682] = Utf8 TEX_OPTIONS_FILTER_TRILINAR 
.const [683] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [684] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [685] = Utf8 TEX_OPTIONS_FILTER_MIMAP 
.const [686] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [687] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [688] = Utf8 TEX_OPTIONS_WRAP_REPEAT 
.const [689] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [690] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [691] = Utf8 TEX_OPTIONS_WRAP_CLAMP 
.const [692] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [693] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [694] = Utf8 TEX_OPTIONS_COMPRESSION_NONE 
.const [695] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [696] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [697] = Utf8 TEX_OPTIONS_COMPRESSION_ETC 
.const [698] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [699] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [700] = Utf8 TEX_OPTIONS_COMPRESSION_DXT3_RGBA 
.const [701] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [702] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [703] = Utf8 TEX_OPTIONS_COMPRESSION_DXT5_RGBA 
.const [704] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [705] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [706] = Utf8 TEX_OPTIONS_FORMAT_RGBA_8888 
.const [707] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [708] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [709] = Utf8 TEX_OPTIONS_FORMAT_RGB_888 
.const [710] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [711] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [712] = Utf8 TEX_OPTIONS_FORMAT_RGB_565 
.const [713] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [714] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [715] = Utf8 TEX_OPTIONS_FORMAT_L_8 
.const [716] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [717] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [718] = Utf8 TEX_OPTIONS_FORMAT_A_8 
.const [719] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [720] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [721] = Utf8 TEX_OPTIONS_FORMAT_LA_88 
.const [722] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [723] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [724] = Utf8 TEX_OPTIONS_FORMAT_INVALID 
.const [725] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [726] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [727] = Utf8 TEX_OPTIONS_EXT_CLEAR_BLACK 
.const [728] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [729] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [730] = Utf8 TEX_OPTIONS_EXT_NO_ATLAS 
.const [731] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [732] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [733] = Utf8 TEX_OPTIONS_EXT_EXTERNAL_OES 
.const [734] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [735] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [736] = Utf8 TEX_OPTION_INVALID 
.const [737] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [738] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [739] = Utf8 swigValue 
.const [740] = Utf8 I 
.const [741] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [742] = Utf8 swigName 
.const [743] = Utf8 Ljava/lang/String; 
.const [744] = Utf8 de/esolutions/graphics/eal/texOptions_t 
.const [745] = Class [744] 
.const [746] = Utf8 java/lang/Object 
.const [747] = Class [746] 
.const [748] = Utf8 TEX_OPTIONS_MASK_MEMORY 
.const [749] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [750] = Utf8 TEX_OPTIONS_MASK_FILTER 
.const [751] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [752] = Utf8 TEX_OPTIONS_MASK_WRAP 
.const [753] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [754] = Utf8 TEX_OPTIONS_MASK_COMPRESSION 
.const [755] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [756] = Utf8 TEX_OPTIONS_MASK_FORMAT 
.const [757] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [758] = Utf8 TEX_OPTIONS_MASK_EXT 
.const [759] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [760] = Utf8 TEX_OPTIONS_MEMORY_GPU 
.const [761] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [762] = Utf8 TEX_OPTIONS_MEMORY_RAM 
.const [763] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [764] = Utf8 TEX_OPTIONS_FILTER_POINT 
.const [765] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [766] = Utf8 TEX_OPTIONS_FILTER_BILINEAR 
.const [767] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [768] = Utf8 TEX_OPTIONS_FILTER_TRILINAR 
.const [769] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [770] = Utf8 TEX_OPTIONS_FILTER_MIMAP 
.const [771] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [772] = Utf8 TEX_OPTIONS_WRAP_REPEAT 
.const [773] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [774] = Utf8 TEX_OPTIONS_WRAP_CLAMP 
.const [775] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [776] = Utf8 TEX_OPTIONS_COMPRESSION_NONE 
.const [777] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [778] = Utf8 TEX_OPTIONS_COMPRESSION_ETC 
.const [779] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [780] = Utf8 TEX_OPTIONS_COMPRESSION_DXT3_RGBA 
.const [781] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [782] = Utf8 TEX_OPTIONS_COMPRESSION_DXT5_RGBA 
.const [783] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [784] = Utf8 TEX_OPTIONS_FORMAT_RGBA_8888 
.const [785] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [786] = Utf8 TEX_OPTIONS_FORMAT_RGB_888 
.const [787] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [788] = Utf8 TEX_OPTIONS_FORMAT_RGB_565 
.const [789] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [790] = Utf8 TEX_OPTIONS_FORMAT_L_8 
.const [791] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [792] = Utf8 TEX_OPTIONS_FORMAT_A_8 
.const [793] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [794] = Utf8 TEX_OPTIONS_FORMAT_LA_88 
.const [795] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [796] = Utf8 TEX_OPTIONS_FORMAT_INVALID 
.const [797] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [798] = Utf8 TEX_OPTIONS_EXT_CLEAR_BLACK 
.const [799] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [800] = Utf8 TEX_OPTIONS_EXT_NO_ATLAS 
.const [801] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [802] = Utf8 TEX_OPTIONS_EXT_EXTERNAL_OES 
.const [803] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [804] = Utf8 TEX_OPTION_INVALID 
.const [805] = Utf8 Lde/esolutions/graphics/eal/texOptions_t; 
.const [806] = Utf8 swigValues 
.const [807] = Utf8 [Lde/esolutions/graphics/eal/texOptions_t; 
.const [808] = Utf8 swigNext 
.const [809] = Utf8 I 
.const [810] = Utf8 swigValue 
.const [811] = Utf8 I 
.const [812] = Utf8 swigName 
.const [813] = Utf8 Ljava/lang/String; 
.const [814] = Utf8 class$de$esolutions$graphics$eal$texOptions_t 
.const [815] = Utf8 Ljava/lang/Class; 
.const [816] = Utf8 Code 
.const [817] = Utf8 swigValue 
.const [818] = Utf8 ()I 
.const [819] = Utf8 toString 
.const [820] = Utf8 ()Ljava/lang/String; 
.const [821] = Utf8 swigToEnum 
.const [822] = Utf8 (I)Lde/esolutions/graphics/eal/texOptions_t; 
.const [823] = Utf8 <init> 
.const [824] = Utf8 (Ljava/lang/String;)V 
.const [825] = Utf8 <init> 
.const [826] = Utf8 (Ljava/lang/String;I)V 
.const [827] = Utf8 <init> 
.const [828] = Utf8 (Ljava/lang/String;Lde/esolutions/graphics/eal/texOptions_t;)V 
.const [829] = Utf8 class$ 
.const [830] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [831] = Utf8 <clinit> 
.const [832] = Utf8 ()V 
.end class 
