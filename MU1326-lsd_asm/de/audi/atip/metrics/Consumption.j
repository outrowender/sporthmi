.version 50 0 
.class public super [344] 
.super [346] 
.field public static final [347] [348] 
.field public static final [349] [350] 
.field public static final [351] [352] 
.field public static final [353] [354] 
.field public static final [355] [356] 
.field public static final [357] [358] 
.field public static final [359] [360] 
.field public static final [361] [362] 
.field public static final [363] [364] 
.field public static final [365] [366] 
.field public static final [367] [368] 
.field public static final [369] [370] 
.field private static final [371] [372] 
.field private static final [373] [374] 
.field private static final [375] [376] 
.field private static final [377] [378] 
.field private static final [379] [380] 
.field private static final [381] [382] 
.field private static final [383] [384] 
.field private static final [385] [386] 
.field private static final [387] [388] 
.field private static final [389] [390] 
.field private static final [391] [392] 
.field private static [393] [394] 
.field private static [395] [396] 
.field private static [397] [398] 
.field public static final [399] [400] 
.field public static final [401] [402] 
.field private [403] [404] 
.field public static final [405] [406] 
.field public static final [407] [408] 
.field private [409] [410] 
.field private [411] [412] 

.method public [414] : [415] 
    .attribute [413] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [55] 
L6:     aload_0 
L7:     iconst_1 
L8:     putfield [69] 
L11:    aload_0 
L12:    invokespecial [56] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [70] 
L20:    aload_0 
L21:    iconst_2 
L22:    putfield [71] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [416] : [417] 
    .attribute [413] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [57] 
L6:     aload_0 
L7:     iload_3 
L8:     putfield [69] 
L11:    return 
L12:    
    .end code 
.end method 

.method private static [418] : [419] 
    .attribute [413] .code stack 3 locals 0 
L0:     iload_1 
L1:     iload_2 
L2:     if_icmpeq L15 
L5:     new [72] 
L8:     dup 
L9:     ldc [3] 
L11:    invokespecial [58] 
L14:    athrow 
L15:    fload_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [420] : [421] 
    .attribute [413] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     tableswitch 2 
            L32 
            L35 
            L38 
            default : L41 

L32:    goto L41 
L35:    goto L41 
L38:    goto L41 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [422] : [423] 
    .attribute [413] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L67 
L5:     iload_0 
L6:     iconst_2 
L7:     if_icmpeq L67 
L10:    iload_0 
L11:    iconst_3 
L12:    if_icmpeq L67 
L15:    iload_0 
L16:    iconst_4 
L17:    if_icmpeq L67 
L20:    iload_0 
L21:    iconst_5 
L22:    if_icmpeq L67 
L25:    iload_0 
L26:    bipush 6 
L28:    if_icmpeq L67 
L31:    iload_0 
L32:    bipush 7 
L34:    if_icmpeq L67 
L37:    iload_0 
L38:    bipush 8 
L40:    if_icmpeq L67 
L43:    iload_0 
L44:    bipush 9 
L46:    if_icmpeq L67 
L49:    iload_0 
L50:    bipush 10 
L52:    if_icmpeq L67 
L55:    iload_0 
L56:    bipush 11 
L58:    if_icmpeq L67 
L61:    iload_0 
L62:    bipush 12 
L64:    if_icmpne L69 
L67:    iconst_1 
L68:    areturn 
L69:    iconst_0 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public static [424] : [425] 
    .attribute [413] .code stack 2 locals 0 
L0:     iload_0 
L1:     invokestatic [4] 
L4:     ifne L15 
L7:     new [72] 
L10:    dup 
L11:    invokespecial [59] 
L14:    athrow 
L15:    iload_0 
L16:    putstatic [60] 
L19:    return 
L20:    
    .end code 
.end method 

.method public static [426] : [427] 
    .attribute [413] .code stack 2 locals 0 
L0:     iload_0 
L1:     invokestatic [4] 
L4:     ifne L15 
L7:     new [72] 
L10:    dup 
L11:    invokespecial [59] 
L14:    athrow 
L15:    iload_0 
L16:    putstatic [61] 
L19:    return 
L20:    
    .end code 
.end method 

.method public static [428] : [429] 
    .attribute [413] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public static [430] : [431] 
    .attribute [413] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [432] : [433] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [70] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [434] : [435] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [71] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [436] : [437] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [73] 
L5:     aload_0 
L6:     invokespecial [56] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [438] : [439] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokespecial [62] 
L5:     invokevirtual [41] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [440] : [441] 
    .attribute [413] .code stack 2 locals 0 
L0:     iload_1 
L1:     invokestatic [4] 
L4:     ifne L15 
L7:     new [72] 
L10:    dup 
L11:    invokespecial [59] 
L14:    athrow 
L15:    aload_0 
L16:    iload_1 
L17:    invokevirtual [41] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [442] : [443] 
    .attribute [413] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     aload_0 
L5:     getfield [39] 
L8:     iload_1 
L9:     invokestatic [7] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [444] : [445] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ifeq L16 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [39] 
L12:    invokevirtual [43] 
L15:    areturn 
L16:    aload_0 
L17:    aload_0 
L18:    invokespecial [62] 
L21:    invokevirtual [43] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [446] : [447] 
    .attribute [413] .code stack 4 locals 2 
L0:     iload_1 
L1:     invokestatic [4] 
L4:     ifne L15 
L7:     new [72] 
L10:    dup 
L11:    invokespecial [59] 
L14:    athrow 
L15:    new [74] 
L18:    dup 
L19:    invokespecial [63] 
L22:    astore_2 
L23:    aload_0 
L24:    getfield [40] 
L27:    aload_0 
L28:    getfield [39] 
L31:    iload_1 
L32:    invokestatic [7] 
L35:    fstore_3 
L36:    aload_0 
L37:    aload_2 
L38:    fload_3 
L39:    aload_0 
L40:    invokespecial [64] 
L43:    invokestatic [9] 
L46:    invokespecial [65] 
L49:    aload_2 
L50:    aload_0 
L51:    invokespecial [66] 
L54:    invokestatic [9] 
L57:    invokevirtual [44] 
L60:    pop 
L61:    aload_0 
L62:    getfield [45] 
L65:    aload_2 
L66:    invokestatic [10] 
L69:    ifne L80 
L72:    aload_0 
L73:    aload_2 
L74:    invokevirtual [46] 
L77:    putfield [75] 
L80:    aload_0 
L81:    getfield [45] 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method private [448] : [449] 
    .attribute [413] .code stack 4 locals 4 
L0:     aload_0 
L1:     invokevirtual [47] 
L4:     ifeq L134 
L7:     fload_2 
L8:     fstore 4 
L10:    fload 4 
L12:    f2i 
L13:    istore 5 
L15:    fload 4 
L17:    ldc [11] 
L19:    fmul 
L20:    invokestatic [12] 
L23:    f2d 
L24:    ldc2_w [76] 
L27:    dadd 
L28:    d2i 
L29:    iload 5 
L31:    bipush 10 
L33:    imul 
L34:    invokestatic [13] 
L37:    isub 
L38:    istore 6 
L40:    iload 5 
L42:    iload 6 
L44:    bipush 10 
L46:    idiv 
L47:    iadd 
L48:    istore 5 
L50:    iload 6 
L52:    bipush 10 
L54:    irem 
L55:    istore 6 
L57:    iload 5 
L59:    ifne L116 
L62:    iload 6 
L64:    ifne L116 
L67:    aload_0 
L68:    getfield [37] 
L71:    iconst_1 
L72:    if_icmpne L116 
L75:    iconst_0 
L76:    istore 7 
L78:    iload 7 
L80:    aload_0 
L81:    getfield [38] 
L84:    if_icmpge L100 
L87:    aload_1 
L88:    ldc [14] 
L90:    invokevirtual [44] 
L93:    pop 
L94:    iinc 7 1 
L97:    goto L78 
L100:   aload_1 
L101:   aload_3 
L102:   invokevirtual [44] 
L105:   pop 
L106:   aload_1 
L107:   ldc [14] 
L109:   invokevirtual [44] 
L112:   pop 
L113:   goto L131 
L116:   aload_1 
L117:   iload 5 
L119:   invokevirtual [48] 
L122:   pop 
L123:   aload_0 
L124:   aload_1 
L125:   iload 6 
L127:   aload_3 
L128:   invokevirtual [49] 
L131:   goto L143 
L134:   aload_1 
L135:   aload_0 
L136:   invokevirtual [50] 
L139:   invokevirtual [44] 
L142:   pop 
L143:   return 
L144:   
    .end code 
.end method 

.method protected [450] : [451] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_3 
L2:     invokevirtual [44] 
L5:     iload_2 
L6:     invokevirtual [48] 
L9:     pop 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [452] : [453] 
    .attribute [413] .code stack 5 locals 0 
L0:     iconst_2 
L1:     anewarray [15] 
L4:     dup 
L5:     iconst_0 
L6:     aload_0 
L7:     iload_1 
L8:     invokevirtual [51] 
L11:    aastore 
L12:    dup 
L13:    iconst_1 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [52] 
L19:    aastore 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [454] : [455] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [42] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [39] 
L12:    goto L19 
L15:    aload_0 
L16:    invokespecial [62] 
L19:    invokevirtual [53] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected static [456] : [457] 
    .attribute [413] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [16] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L437 
L9:     iload_0 
L10:    tableswitch 8 
            L356 
            L368 
            L362 
            L374 
            L380 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L374 
            L386 
            L392 
            L398 
            L404 
            L380 
            L374 
            L374 
            L380 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L434 
            L410 
            L416 
            L380 
            L380 
            L434 
            L422 
            L428 
            L380 
            L380 
            default : L434 

L356:   ldc [17] 
L358:   astore_1 
L359:   goto L437 
L362:   ldc [18] 
L364:   astore_1 
L365:   goto L437 
L368:   ldc [19] 
L370:   astore_1 
L371:   goto L437 
L374:   ldc [20] 
L376:   astore_1 
L377:   goto L437 
L380:   ldc [21] 
L382:   astore_1 
L383:   goto L437 
L386:   ldc [22] 
L388:   astore_1 
L389:   goto L437 
L392:   ldc [23] 
L394:   astore_1 
L395:   goto L437 
L398:   ldc [24] 
L400:   astore_1 
L401:   goto L437 
L404:   ldc [25] 
L406:   astore_1 
L407:   goto L437 
L410:   ldc [26] 
L412:   astore_1 
L413:   goto L437 
L416:   ldc [27] 
L418:   astore_1 
L419:   goto L437 
L422:   ldc [28] 
L424:   astore_1 
L425:   goto L437 
L428:   ldc [29] 
L430:   astore_1 
L431:   goto L437 
L434:   ldc [30] 
L436:   astore_1 
L437:   aload_1 
L438:   areturn 
L439:   nop 
L440:   
    .end code 
.end method 

.method private [458] : [459] 
    .attribute [413] .code stack 1 locals 1 
L0:     iconst_m1 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [39] 
L6:     tableswitch 1 
            L80 
            L68 
            L68 
            L74 
            L86 
            L92 
            L98 
            L104 
            L110 
            L116 
            L122 
            L128 
            default : L134 

L68:    bipush 12 
L70:    istore_1 
L71:    goto L137 
L74:    bipush 59 
L76:    istore_1 
L77:    goto L137 
L80:    bipush 11 
L82:    istore_1 
L83:    goto L137 
L86:    bipush 64 
L88:    istore_1 
L89:    goto L137 
L92:    bipush 65 
L94:    istore_1 
L95:    goto L137 
L98:    bipush 66 
L100:   istore_1 
L101:   goto L137 
L104:   bipush 67 
L106:   istore_1 
L107:   goto L137 
L110:   bipush 84 
L112:   istore_1 
L113:   goto L137 
L116:   bipush 85 
L118:   istore_1 
L119:   goto L137 
L122:   bipush 89 
L124:   istore_1 
L125:   goto L137 
L128:   bipush 90 
L130:   istore_1 
L131:   goto L137 
L134:   bipush 11 
L136:   istore_1 
L137:   iload_1 
L138:   areturn 
L139:   nop 
L140:   
    .end code 
.end method 

.method private [460] : [461] 
    .attribute [413] .code stack 1 locals 1 
L0:     iconst_m1 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [39] 
L6:     tableswitch 1 
            L80 
            L68 
            L68 
            L74 
            L86 
            L92 
            L98 
            L104 
            L110 
            L116 
            L122 
            L128 
            default : L134 

L68:    bipush 10 
L70:    istore_1 
L71:    goto L137 
L74:    bipush 8 
L76:    istore_1 
L77:    goto L137 
L80:    bipush 9 
L82:    istore_1 
L83:    goto L137 
L86:    bipush 60 
L88:    istore_1 
L89:    goto L137 
L92:    bipush 61 
L94:    istore_1 
L95:    goto L137 
L98:    bipush 62 
L100:   istore_1 
L101:   goto L137 
L104:   bipush 63 
L106:   istore_1 
L107:   goto L137 
L110:   bipush 82 
L112:   istore_1 
L113:   goto L137 
L116:   bipush 83 
L118:   istore_1 
L119:   goto L137 
L122:   bipush 87 
L124:   istore_1 
L125:   goto L137 
L128:   bipush 88 
L130:   istore_1 
L131:   goto L137 
L134:   bipush 9 
L136:   istore_1 
L137:   iload_1 
L138:   areturn 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [462] : [463] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [42] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [39] 
L12:    goto L19 
L15:    aload_0 
L16:    invokespecial [62] 
L19:    invokevirtual [52] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [464] : [465] 
    .attribute [413] .code stack 2 locals 1 
L0:     iload_1 
L1:     invokestatic [4] 
L4:     ifne L15 
L7:     new [72] 
L10:    dup 
L11:    invokespecial [59] 
L14:    athrow 
L15:    aload_0 
L16:    invokespecial [66] 
L19:    invokestatic [9] 
L22:    astore_2 
L23:    aconst_null 
L24:    aload_2 
L25:    if_acmpeq L35 
L28:    aload_2 
L29:    invokevirtual [54] 
L32:    goto L37 
L35:    ldc [30] 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [466] : [467] 
    .attribute [413] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [42] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [39] 
L12:    goto L19 
L15:    aload_0 
L16:    invokespecial [62] 
L19:    invokevirtual [51] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [468] : [469] 
    .attribute [413] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokevirtual [47] 
L4:     ifne L12 
L7:     aload_0 
L8:     invokevirtual [50] 
L11:    areturn 
L12:    iload_1 
L13:    invokestatic [4] 
L16:    ifne L27 
L19:    new [72] 
L22:    dup 
L23:    invokespecial [59] 
L26:    athrow 
L27:    new [74] 
L30:    dup 
L31:    bipush 32 
L33:    invokespecial [67] 
L36:    astore_2 
L37:    aload_0 
L38:    getfield [40] 
L41:    aload_0 
L42:    getfield [39] 
L45:    iload_1 
L46:    invokestatic [7] 
L49:    fstore_3 
L50:    aload_0 
L51:    aload_2 
L52:    fload_3 
L53:    aload_0 
L54:    invokespecial [64] 
L57:    invokestatic [9] 
L60:    invokespecial [65] 
L63:    aload_2 
L64:    invokevirtual [46] 
L67:    invokevirtual [54] 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [470] : [471] 
    .attribute [413] .code stack 1 locals 0 
L0:     getstatic [31] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method private [472] : [473] 
    .attribute [413] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ifne L11 
L7:     getstatic [6] 
L10:    areturn 
L11:    getstatic [5] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [474] : [475] 
    .attribute [413] .code stack 1 locals 0 
L0:     ldc [32] 
L2:     putstatic [68] 
L5:     iconst_1 
L6:     putstatic [60] 
L9:     bipush 6 
L11:    putstatic [61] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [78] 
.const [3] = String [79] 
.const [4] = Method [80] [81] 
.const [5] = Field [82] [83] 
.const [6] = Field [84] [85] 
.const [7] = Method [86] [87] 
.const [8] = Class [88] 
.const [9] = Method [89] [90] 
.const [10] = Method [91] [92] 
.const [11] = Int 8257 
.const [12] = Method [93] [94] 
.const [13] = Method [95] [96] 
.const [14] = String [97] 
.const [15] = Class [98] 
.const [16] = Method [99] [100] 
.const [17] = String [101] 
.const [18] = String [102] 
.const [19] = String [103] 
.const [20] = String [104] 
.const [21] = String [105] 
.const [22] = String [106] 
.const [23] = String [107] 
.const [24] = String [108] 
.const [25] = String [109] 
.const [26] = String [110] 
.const [27] = String [111] 
.const [28] = String [112] 
.const [29] = String [113] 
.const [30] = String [114] 
.const [31] = Field [115] [116] 
.const [32] = String [117] 
.const [33] = Class [118] 
.const [34] = Class [119] 
.const [35] = Class [120] 
.const [36] = Field [121] [122] 
.const [37] = Field [123] [124] 
.const [38] = Field [125] [126] 
.const [39] = Field [127] [128] 
.const [40] = Field [129] [130] 
.const [41] = Method [131] [132] 
.const [42] = Field [133] [134] 
.const [43] = Method [135] [136] 
.const [44] = Method [137] [138] 
.const [45] = Field [139] [140] 
.const [46] = Method [141] [142] 
.const [47] = Method [143] [144] 
.const [48] = Method [145] [146] 
.const [49] = Method [147] [148] 
.const [50] = Method [149] [150] 
.const [51] = Method [151] [152] 
.const [52] = Method [153] [154] 
.const [53] = Method [155] [156] 
.const [54] = Method [157] [158] 
.const [55] = Method [159] [160] 
.const [56] = Method [161] [162] 
.const [57] = Method [163] [164] 
.const [58] = Method [165] [166] 
.const [59] = Method [167] [168] 
.const [60] = Field [169] [170] 
.const [61] = Field [171] [172] 
.const [62] = Method [173] [174] 
.const [63] = Method [175] [176] 
.const [64] = Method [177] [178] 
.const [65] = Method [179] [180] 
.const [66] = Method [181] [182] 
.const [67] = Method [183] [184] 
.const [68] = Field [185] [186] 
.const [69] = Field [187] [188] 
.const [70] = Field [189] [190] 
.const [71] = Field [191] [192] 
.const [72] = Class [193] 
.const [73] = Field [194] [195] 
.const [74] = Class [196] 
.const [75] = Field [197] [198] 
.const [76] = Double +0x10000000000000p-53 
.const [78] = Utf8 java/lang/IllegalArgumentException 
.const [79] = Utf8 'Data conversion between different units is not supported!' 
.const [80] = Class [199] 
.const [81] = NameAndType [200] [201] 
.const [82] = Class [202] 
.const [83] = NameAndType [203] [204] 
.const [84] = Class [205] 
.const [85] = NameAndType [206] [207] 
.const [86] = Class [208] 
.const [87] = NameAndType [209] [210] 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Class [211] 
.const [90] = NameAndType [212] [213] 
.const [91] = Class [214] 
.const [92] = NameAndType [215] [216] 
.const [93] = Class [217] 
.const [94] = NameAndType [218] [219] 
.const [95] = Class [220] 
.const [96] = NameAndType [221] [222] 
.const [97] = Utf8 '-' 
.const [98] = Utf8 java/lang/String 
.const [99] = Class [223] 
.const [100] = NameAndType [224] [225] 
.const [101] = Utf8 ' km/l' 
.const [102] = Utf8 ' mpg' 
.const [103] = Utf8 ' l/100km' 
.const [104] = Utf8 ',' 
.const [105] = Utf8 '.' 
.const [106] = Utf8 ' kWh/mi' 
.const [107] = Utf8 ' kWh/100km' 
.const [108] = Utf8 ' km/kWh' 
.const [109] = Utf8 ' mi/kWh' 
.const [110] = Utf8 ' l/h' 
.const [111] = Utf8 ' gal/h' 
.const [112] = Utf8 ' kg/h' 
.const [113] = Utf8 kWh/h 
.const [114] = Utf8 '' 
.const [115] = Class [226] 
.const [116] = NameAndType [227] [228] 
.const [117] = Utf8 '---' 
.const [118] = Utf8 de/audi/atip/metrics/Consumption 
.const [119] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [120] = Utf8 java/lang/Math 
.const [121] = Class [229] 
.const [122] = NameAndType [230] [231] 
.const [123] = Class [232] 
.const [124] = NameAndType [233] [234] 
.const [125] = Class [235] 
.const [126] = NameAndType [236] [237] 
.const [127] = Class [238] 
.const [128] = NameAndType [239] [240] 
.const [129] = Class [241] 
.const [130] = NameAndType [242] [243] 
.const [131] = Class [244] 
.const [132] = NameAndType [245] [246] 
.const [133] = Class [247] 
.const [134] = NameAndType [248] [249] 
.const [135] = Class [250] 
.const [136] = NameAndType [251] [252] 
.const [137] = Class [253] 
.const [138] = NameAndType [254] [255] 
.const [139] = Class [256] 
.const [140] = NameAndType [257] [258] 
.const [141] = Class [259] 
.const [142] = NameAndType [260] [261] 
.const [143] = Class [262] 
.const [144] = NameAndType [263] [264] 
.const [145] = Class [265] 
.const [146] = NameAndType [266] [267] 
.const [147] = Class [268] 
.const [148] = NameAndType [269] [270] 
.const [149] = Class [271] 
.const [150] = NameAndType [272] [273] 
.const [151] = Class [274] 
.const [152] = NameAndType [275] [276] 
.const [153] = Class [277] 
.const [154] = NameAndType [278] [279] 
.const [155] = Class [280] 
.const [156] = NameAndType [281] [282] 
.const [157] = Class [283] 
.const [158] = NameAndType [284] [285] 
.const [159] = Class [286] 
.const [160] = NameAndType [287] [288] 
.const [161] = Class [289] 
.const [162] = NameAndType [290] [291] 
.const [163] = Class [292] 
.const [164] = NameAndType [293] [294] 
.const [165] = Class [295] 
.const [166] = NameAndType [296] [297] 
.const [167] = Class [298] 
.const [168] = NameAndType [299] [300] 
.const [169] = Class [301] 
.const [170] = NameAndType [302] [303] 
.const [171] = Class [304] 
.const [172] = NameAndType [305] [306] 
.const [173] = Class [307] 
.const [174] = NameAndType [308] [309] 
.const [175] = Class [310] 
.const [176] = NameAndType [311] [312] 
.const [177] = Class [313] 
.const [178] = NameAndType [314] [315] 
.const [179] = Class [316] 
.const [180] = NameAndType [317] [318] 
.const [181] = Class [319] 
.const [182] = NameAndType [320] [321] 
.const [183] = Class [322] 
.const [184] = NameAndType [323] [324] 
.const [185] = Class [325] 
.const [186] = NameAndType [326] [327] 
.const [187] = Class [328] 
.const [188] = NameAndType [329] [330] 
.const [189] = Class [331] 
.const [190] = NameAndType [332] [333] 
.const [191] = Class [334] 
.const [192] = NameAndType [335] [336] 
.const [193] = Utf8 java/lang/IllegalArgumentException 
.const [194] = Class [337] 
.const [195] = NameAndType [338] [339] 
.const [196] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [197] = Class [340] 
.const [198] = NameAndType [341] [342] 
.const [199] = Utf8 de/audi/atip/metrics/Consumption 
.const [200] = Utf8 unitIsValid 
.const [201] = Utf8 (I)Z 
.const [202] = Utf8 de/audi/atip/metrics/Consumption 
.const [203] = Utf8 systemUnit 
.const [204] = Utf8 I 
.const [205] = Utf8 de/audi/atip/metrics/Consumption 
.const [206] = Utf8 systemUnitElektro 
.const [207] = Utf8 I 
.const [208] = Utf8 de/audi/atip/metrics/Consumption 
.const [209] = Utf8 convertData 
.const [210] = Utf8 (FII)F 
.const [211] = Utf8 de/audi/atip/metrics/Consumption 
.const [212] = Utf8 getText 
.const [213] = Utf8 (I)Ljava/lang/String; 
.const [214] = Utf8 de/audi/atip/metrics/Consumption 
.const [215] = Utf8 contentEquals 
.const [216] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [217] = Utf8 java/lang/Math 
.const [218] = Utf8 abs 
.const [219] = Utf8 (F)F 
.const [220] = Utf8 java/lang/Math 
.const [221] = Utf8 abs 
.const [222] = Utf8 (I)I 
.const [223] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [224] = Utf8 getText 
.const [225] = Utf8 (I)Ljava/lang/String; 
.const [226] = Utf8 de/audi/atip/metrics/Consumption 
.const [227] = Utf8 TEXT_INVALID 
.const [228] = Utf8 Ljava/lang/String; 
.const [229] = Utf8 de/audi/atip/metrics/Consumption 
.const [230] = Utf8 referenceUnit 
.const [231] = Utf8 Z 
.const [232] = Utf8 de/audi/atip/metrics/Consumption 
.const [233] = Utf8 zeroValueFormat 
.const [234] = Utf8 I 
.const [235] = Utf8 de/audi/atip/metrics/Consumption 
.const [236] = Utf8 numberOfMajorPlacesMax 
.const [237] = Utf8 I 
.const [238] = Utf8 de/audi/atip/metrics/Consumption 
.const [239] = Utf8 unit 
.const [240] = Utf8 I 
.const [241] = Utf8 de/audi/atip/metrics/Consumption 
.const [242] = Utf8 value 
.const [243] = Utf8 F 
.const [244] = Utf8 de/audi/atip/metrics/Consumption 
.const [245] = Utf8 getValueInUnit 
.const [246] = Utf8 (I)F 
.const [247] = Utf8 de/audi/atip/metrics/Consumption 
.const [248] = Utf8 useInstanceUnit 
.const [249] = Utf8 Z 
.const [250] = Utf8 de/audi/atip/metrics/Consumption 
.const [251] = Utf8 format 
.const [252] = Utf8 (I)Ljava/lang/String; 
.const [253] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [254] = Utf8 append 
.const [255] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [256] = Utf8 de/audi/atip/metrics/Consumption 
.const [257] = Utf8 lastFormat 
.const [258] = Utf8 Ljava/lang/String; 
.const [259] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [260] = Utf8 toString 
.const [261] = Utf8 ()Ljava/lang/String; 
.const [262] = Utf8 de/audi/atip/metrics/Consumption 
.const [263] = Utf8 isMetricvalid 
.const [264] = Utf8 ()Z 
.const [265] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [266] = Utf8 append 
.const [267] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [268] = Utf8 de/audi/atip/metrics/Consumption 
.const [269] = Utf8 appendMantissa 
.const [270] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;ILjava/lang/String;)V 
.const [271] = Utf8 de/audi/atip/metrics/Consumption 
.const [272] = Utf8 getInvalidText 
.const [273] = Utf8 ()Ljava/lang/String; 
.const [274] = Utf8 de/audi/atip/metrics/Consumption 
.const [275] = Utf8 getFormattedValue 
.const [276] = Utf8 (I)Ljava/lang/String; 
.const [277] = Utf8 de/audi/atip/metrics/Consumption 
.const [278] = Utf8 getFormattedUnit 
.const [279] = Utf8 (I)Ljava/lang/String; 
.const [280] = Utf8 de/audi/atip/metrics/Consumption 
.const [281] = Utf8 getStringValueAndUnit 
.const [282] = Utf8 (I)[Ljava/lang/String; 
.const [283] = Utf8 java/lang/String 
.const [284] = Utf8 trim 
.const [285] = Utf8 ()Ljava/lang/String; 
.const [286] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (FI)V 
.const [289] = Utf8 de/audi/atip/metrics/Consumption 
.const [290] = Utf8 importValue 
.const [291] = Utf8 ()V 
.const [292] = Utf8 de/audi/atip/metrics/Consumption 
.const [293] = Utf8 <init> 
.const [294] = Utf8 (FI)V 
.const [295] = Utf8 java/lang/IllegalArgumentException 
.const [296] = Utf8 <init> 
.const [297] = Utf8 (Ljava/lang/String;)V 
.const [298] = Utf8 java/lang/IllegalArgumentException 
.const [299] = Utf8 <init> 
.const [300] = Utf8 ()V 
.const [301] = Utf8 de/audi/atip/metrics/Consumption 
.const [302] = Utf8 systemUnit 
.const [303] = Utf8 I 
.const [304] = Utf8 de/audi/atip/metrics/Consumption 
.const [305] = Utf8 systemUnitElektro 
.const [306] = Utf8 I 
.const [307] = Utf8 de/audi/atip/metrics/Consumption 
.const [308] = Utf8 getReferenceUnit 
.const [309] = Utf8 ()I 
.const [310] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [311] = Utf8 <init> 
.const [312] = Utf8 ()V 
.const [313] = Utf8 de/audi/atip/metrics/Consumption 
.const [314] = Utf8 getTextConstantSeparator 
.const [315] = Utf8 ()I 
.const [316] = Utf8 de/audi/atip/metrics/Consumption 
.const [317] = Utf8 formatValue 
.const [318] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;FLjava/lang/String;)V 
.const [319] = Utf8 de/audi/atip/metrics/Consumption 
.const [320] = Utf8 getTextConstantUnit 
.const [321] = Utf8 ()I 
.const [322] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [323] = Utf8 <init> 
.const [324] = Utf8 (I)V 
.const [325] = Utf8 de/audi/atip/metrics/Consumption 
.const [326] = Utf8 TEXT_INVALID 
.const [327] = Utf8 Ljava/lang/String; 
.const [328] = Utf8 de/audi/atip/metrics/Consumption 
.const [329] = Utf8 referenceUnit 
.const [330] = Utf8 Z 
.const [331] = Utf8 de/audi/atip/metrics/Consumption 
.const [332] = Utf8 zeroValueFormat 
.const [333] = Utf8 I 
.const [334] = Utf8 de/audi/atip/metrics/Consumption 
.const [335] = Utf8 numberOfMajorPlacesMax 
.const [336] = Utf8 I 
.const [337] = Utf8 de/audi/atip/metrics/Consumption 
.const [338] = Utf8 value 
.const [339] = Utf8 F 
.const [340] = Utf8 de/audi/atip/metrics/Consumption 
.const [341] = Utf8 lastFormat 
.const [342] = Utf8 Ljava/lang/String; 
.const [343] = Utf8 de/audi/atip/metrics/Consumption 
.const [344] = Class [343] 
.const [345] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [346] = Class [345] 
.const [347] = Utf8 L_PER_100KM 
.const [348] = Utf8 I 
.const [349] = Utf8 MPG_US 
.const [350] = Utf8 I 
.const [351] = Utf8 MPG_UK 
.const [352] = Utf8 I 
.const [353] = Utf8 KM_PER_L 
.const [354] = Utf8 I 
.const [355] = Utf8 KWHPM 
.const [356] = Utf8 I 
.const [357] = Utf8 KWHP100KM 
.const [358] = Utf8 I 
.const [359] = Utf8 KMPKWH 
.const [360] = Utf8 I 
.const [361] = Utf8 MPKWH 
.const [362] = Utf8 I 
.const [363] = Utf8 L_PER_H 
.const [364] = Utf8 I 
.const [365] = Utf8 GAL_PER_H 
.const [366] = Utf8 I 
.const [367] = Utf8 KG_PER_H 
.const [368] = Utf8 I 
.const [369] = Utf8 KWH_PER_H 
.const [370] = Utf8 I 
.const [371] = Utf8 TEXT_CONSUMPTION_KM_PER_LITER 
.const [372] = Utf8 Ljava/lang/String; 
.const [373] = Utf8 TEXT_CONSUMPTION_MILES_PER_GALLON 
.const [374] = Utf8 Ljava/lang/String; 
.const [375] = Utf8 TEXT_CONSUMPTION_LITER_PER_100KM 
.const [376] = Utf8 Ljava/lang/String; 
.const [377] = Utf8 TEXT_CONSUMPTION_KWHPM 
.const [378] = Utf8 Ljava/lang/String; 
.const [379] = Utf8 TEXT_CONSUMPTION_KWHP100KM 
.const [380] = Utf8 Ljava/lang/String; 
.const [381] = Utf8 TEXT_CONSUMPTION_KMPKWH 
.const [382] = Utf8 Ljava/lang/String; 
.const [383] = Utf8 TEXT_CONSUMPTION_MPKWH 
.const [384] = Utf8 Ljava/lang/String; 
.const [385] = Utf8 TEXT_CONSUMPTION_LITER_PER_HOUR 
.const [386] = Utf8 Ljava/lang/String; 
.const [387] = Utf8 TEXT_CONSUMPTION_GALLON_PER_HOUR 
.const [388] = Utf8 Ljava/lang/String; 
.const [389] = Utf8 TEXT_CONSUMPTION_KILOGRAM_PER_HOUR 
.const [390] = Utf8 Ljava/lang/String; 
.const [391] = Utf8 TEXT_CONSUMPTION_KILOWATTHOUR_PER_HOUR 
.const [392] = Utf8 Ljava/lang/String; 
.const [393] = Utf8 TEXT_INVALID 
.const [394] = Utf8 Ljava/lang/String; 
.const [395] = Utf8 systemUnit 
.const [396] = Utf8 I 
.const [397] = Utf8 systemUnitElektro 
.const [398] = Utf8 I 
.const [399] = Utf8 REFERENCE_UNIT_PETROL 
.const [400] = Utf8 Z 
.const [401] = Utf8 REFERENCE_UNIT_ELEKTRO 
.const [402] = Utf8 Z 
.const [403] = Utf8 referenceUnit 
.const [404] = Utf8 Z 
.const [405] = Utf8 ZERO_VALUE_FORMAT_ZEROS 
.const [406] = Utf8 I 
.const [407] = Utf8 ZERO_VALUE_FORMAT_MINUS 
.const [408] = Utf8 I 
.const [409] = Utf8 zeroValueFormat 
.const [410] = Utf8 I 
.const [411] = Utf8 numberOfMajorPlacesMax 
.const [412] = Utf8 I 
.const [413] = Utf8 Code 
.const [414] = Utf8 <init> 
.const [415] = Utf8 (FI)V 
.const [416] = Utf8 <init> 
.const [417] = Utf8 (FIZ)V 
.const [418] = Utf8 convertData 
.const [419] = Utf8 (FII)F 
.const [420] = Utf8 importValue 
.const [421] = Utf8 ()V 
.const [422] = Utf8 unitIsValid 
.const [423] = Utf8 (I)Z 
.const [424] = Utf8 setSystemUnit 
.const [425] = Utf8 (I)V 
.const [426] = Utf8 setSystemUnitElektro 
.const [427] = Utf8 (I)V 
.const [428] = Utf8 getSystemUnit 
.const [429] = Utf8 ()I 
.const [430] = Utf8 getSystemUnitElektro 
.const [431] = Utf8 ()I 
.const [432] = Utf8 setZeroValueFormat 
.const [433] = Utf8 (I)V 
.const [434] = Utf8 setNumberOfMajorPlacesMax 
.const [435] = Utf8 (I)V 
.const [436] = Utf8 setValue 
.const [437] = Utf8 (F)V 
.const [438] = Utf8 getValue 
.const [439] = Utf8 ()F 
.const [440] = Utf8 getValue 
.const [441] = Utf8 (I)F 
.const [442] = Utf8 getValueInUnit 
.const [443] = Utf8 (I)F 
.const [444] = Utf8 format 
.const [445] = Utf8 ()Ljava/lang/String; 
.const [446] = Utf8 format 
.const [447] = Utf8 (I)Ljava/lang/String; 
.const [448] = Utf8 formatValue 
.const [449] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;FLjava/lang/String;)V 
.const [450] = Utf8 appendMantissa 
.const [451] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;ILjava/lang/String;)V 
.const [452] = Utf8 getStringValueAndUnit 
.const [453] = Utf8 (I)[Ljava/lang/String; 
.const [454] = Utf8 getStringValueAndUnit 
.const [455] = Utf8 ()[Ljava/lang/String; 
.const [456] = Utf8 getText 
.const [457] = Utf8 (I)Ljava/lang/String; 
.const [458] = Utf8 getTextConstantSeparator 
.const [459] = Utf8 ()I 
.const [460] = Utf8 getTextConstantUnit 
.const [461] = Utf8 ()I 
.const [462] = Utf8 getFormattedMetricUnit 
.const [463] = Utf8 ()Ljava/lang/String; 
.const [464] = Utf8 getFormattedUnit 
.const [465] = Utf8 (I)Ljava/lang/String; 
.const [466] = Utf8 getFormattedValue 
.const [467] = Utf8 ()Ljava/lang/String; 
.const [468] = Utf8 getFormattedValue 
.const [469] = Utf8 (I)Ljava/lang/String; 
.const [470] = Utf8 getInvalidText 
.const [471] = Utf8 ()Ljava/lang/String; 
.const [472] = Utf8 getReferenceUnit 
.const [473] = Utf8 ()I 
.const [474] = Utf8 <clinit> 
.const [475] = Utf8 ()V 
.end class 
