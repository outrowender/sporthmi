.version 50 0 
.class public super [389] 
.super [391] 
.field private [392] [393] 

.method public [395] : [396] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [64] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [71] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [397] : [398] 
    .attribute [394] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [61] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [399] : [400] 
    .attribute [394] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [62] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [401] : [402] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [63] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [72] 
L21:    aload_0 
L22:    getfield [61] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [71] 
L33:    aload_0 
L34:    invokespecial [65] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [403] : [404] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [405] : [406] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [4] 
L4:     iconst_1 
L5:     invokespecial [66] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [407] : [408] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [409] : [410] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [411] : [412] 
    .attribute [394] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [7] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [73] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [67] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [413] : [414] 
    .attribute [394] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [9] 
L9:     lstore_2 
L10:    lload_2 
L11:    lconst_0 
L12:    lcmp 
L13:    ifne L20 
L16:    aconst_null 
L17:    goto L29 
L20:    new [74] 
L23:    dup 
L24:    lload_2 
L25:    iconst_1 
L26:    invokespecial [68] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [415] : [416] 
    .attribute [394] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [11] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [74] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [68] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [417] : [418] 
    .attribute [394] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [12] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [74] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [68] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [419] : [420] 
    .attribute [394] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [13] 
L9:     aload_1 
L10:    invokestatic [14] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [421] : [422] 
    .attribute [394] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [13] 
L9:     aload_1 
L10:    invokestatic [15] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [423] : [424] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [16] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [425] : [426] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [17] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [427] : [428] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [18] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [429] : [430] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [19] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [431] : [432] 
    .attribute [394] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [20] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [433] : [434] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [21] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [435] : [436] 
    .attribute [394] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [22] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [75] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [69] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [437] : [438] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [24] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [439] : [440] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [25] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [441] : [442] 
    .attribute [394] .code stack 1 locals 0 
L0:     invokestatic [26] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [443] : [444] 
    .attribute [394] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [27] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [28] 
L14:    lstore_3 
L15:    lload_3 
L16:    lconst_0 
L17:    lcmp 
L18:    ifne L25 
L21:    aconst_null 
L22:    goto L34 
L25:    new [76] 
L28:    dup 
L29:    lload_3 
L30:    iconst_1 
L31:    invokespecial [70] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [445] : [446] 
    .attribute [394] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [30] 
L9:     aload_1 
L10:    aload_2 
L11:    iload_3 
L12:    invokestatic [31] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [447] : [448] 
    .attribute [394] .code stack 10 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     invokestatic [27] 
L10:    aload_2 
L11:    aload_3 
L12:    invokestatic [32] 
L15:    aload_3 
L16:    invokestatic [33] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [449] : [450] 
    .attribute [394] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [13] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [34] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [451] : [452] 
    .attribute [394] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [35] 
L9:     aload_1 
L10:    invokestatic [36] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [453] : [454] 
    .attribute [394] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [37] 
L9:     aload_1 
L10:    invokestatic [38] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [455] : [456] 
    .attribute [394] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [39] 
L9:     aload_1 
L10:    invokestatic [40] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [457] : [458] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [41] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [459] : [460] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [42] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [461] : [462] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [43] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [463] : [464] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [44] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [465] : [466] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [45] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [467] : [468] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [46] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [469] : [470] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [47] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [471] : [472] 
    .attribute [394] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [48] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [473] : [474] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [49] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [475] : [476] 
    .attribute [394] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [50] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [477] : [478] 
    .attribute [394] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [51] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [479] : [480] 
    .attribute [394] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     aload_0 
L5:     invokestatic [52] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [77] [78] 
.const [3] = Method [79] [80] 
.const [4] = Method [81] [82] 
.const [5] = Method [83] [84] 
.const [6] = Method [85] [86] 
.const [7] = Method [87] [88] 
.const [8] = Class [89] 
.const [9] = Method [90] [91] 
.const [10] = Class [92] 
.const [11] = Method [93] [94] 
.const [12] = Method [95] [96] 
.const [13] = Method [97] [98] 
.const [14] = Method [99] [100] 
.const [15] = Method [101] [102] 
.const [16] = Method [103] [104] 
.const [17] = Method [105] [106] 
.const [18] = Method [107] [108] 
.const [19] = Method [109] [110] 
.const [20] = Method [111] [112] 
.const [21] = Method [113] [114] 
.const [22] = Method [115] [116] 
.const [23] = Class [117] 
.const [24] = Method [118] [119] 
.const [25] = Method [120] [121] 
.const [26] = Method [122] [123] 
.const [27] = Method [124] [125] 
.const [28] = Method [126] [127] 
.const [29] = Class [128] 
.const [30] = Method [129] [130] 
.const [31] = Method [131] [132] 
.const [32] = Method [133] [134] 
.const [33] = Method [135] [136] 
.const [34] = Method [137] [138] 
.const [35] = Method [139] [140] 
.const [36] = Method [141] [142] 
.const [37] = Method [143] [144] 
.const [38] = Method [145] [146] 
.const [39] = Method [147] [148] 
.const [40] = Method [149] [150] 
.const [41] = Method [151] [152] 
.const [42] = Method [153] [154] 
.const [43] = Method [155] [156] 
.const [44] = Method [157] [158] 
.const [45] = Method [159] [160] 
.const [46] = Method [161] [162] 
.const [47] = Method [163] [164] 
.const [48] = Method [165] [166] 
.const [49] = Method [167] [168] 
.const [50] = Method [169] [170] 
.const [51] = Method [171] [172] 
.const [52] = Method [173] [174] 
.const [53] = Class [175] 
.const [54] = Class [176] 
.const [55] = Class [177] 
.const [56] = Class [178] 
.const [57] = Class [179] 
.const [58] = Class [180] 
.const [59] = Class [181] 
.const [60] = Class [182] 
.const [61] = Field [183] [184] 
.const [62] = Method [185] [186] 
.const [63] = Field [187] [188] 
.const [64] = Method [189] [190] 
.const [65] = Method [191] [192] 
.const [66] = Method [193] [194] 
.const [67] = Method [195] [196] 
.const [68] = Method [197] [198] 
.const [69] = Method [199] [200] 
.const [70] = Method [201] [202] 
.const [71] = Field [203] [204] 
.const [72] = Field [205] [206] 
.const [73] = Class [207] 
.const [74] = Class [208] 
.const [75] = Class [209] 
.const [76] = Class [210] 
.const [77] = Class [211] 
.const [78] = NameAndType [212] [213] 
.const [79] = Class [214] 
.const [80] = NameAndType [215] [216] 
.const [81] = Class [217] 
.const [82] = NameAndType [218] [219] 
.const [83] = Class [220] 
.const [84] = NameAndType [221] [222] 
.const [85] = Class [223] 
.const [86] = NameAndType [224] [225] 
.const [87] = Class [226] 
.const [88] = NameAndType [227] [228] 
.const [89] = Utf8 de/esolutions/graphics/eal/api/IContext 
.const [90] = Class [229] 
.const [91] = NameAndType [230] [231] 
.const [92] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [93] = Class [232] 
.const [94] = NameAndType [233] [234] 
.const [95] = Class [235] 
.const [96] = NameAndType [236] [237] 
.const [97] = Class [238] 
.const [98] = NameAndType [239] [240] 
.const [99] = Class [241] 
.const [100] = NameAndType [242] [243] 
.const [101] = Class [244] 
.const [102] = NameAndType [245] [246] 
.const [103] = Class [247] 
.const [104] = NameAndType [248] [249] 
.const [105] = Class [250] 
.const [106] = NameAndType [251] [252] 
.const [107] = Class [253] 
.const [108] = NameAndType [254] [255] 
.const [109] = Class [256] 
.const [110] = NameAndType [257] [258] 
.const [111] = Class [259] 
.const [112] = NameAndType [260] [261] 
.const [113] = Class [262] 
.const [114] = NameAndType [263] [264] 
.const [115] = Class [265] 
.const [116] = NameAndType [266] [267] 
.const [117] = Utf8 de/esolutions/graphics/eal/api/IRenderer 
.const [118] = Class [268] 
.const [119] = NameAndType [269] [270] 
.const [120] = Class [271] 
.const [121] = NameAndType [272] [273] 
.const [122] = Class [274] 
.const [123] = NameAndType [275] [276] 
.const [124] = Class [277] 
.const [125] = NameAndType [278] [279] 
.const [126] = Class [280] 
.const [127] = NameAndType [281] [282] 
.const [128] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [129] = Class [283] 
.const [130] = NameAndType [284] [285] 
.const [131] = Class [286] 
.const [132] = NameAndType [287] [288] 
.const [133] = Class [289] 
.const [134] = NameAndType [290] [291] 
.const [135] = Class [292] 
.const [136] = NameAndType [293] [294] 
.const [137] = Class [295] 
.const [138] = NameAndType [296] [297] 
.const [139] = Class [298] 
.const [140] = NameAndType [299] [300] 
.const [141] = Class [301] 
.const [142] = NameAndType [302] [303] 
.const [143] = Class [304] 
.const [144] = NameAndType [305] [306] 
.const [145] = Class [307] 
.const [146] = NameAndType [308] [309] 
.const [147] = Class [310] 
.const [148] = NameAndType [311] [312] 
.const [149] = Class [313] 
.const [150] = NameAndType [314] [315] 
.const [151] = Class [316] 
.const [152] = NameAndType [317] [318] 
.const [153] = Class [319] 
.const [154] = NameAndType [320] [321] 
.const [155] = Class [322] 
.const [156] = NameAndType [323] [324] 
.const [157] = Class [325] 
.const [158] = NameAndType [326] [327] 
.const [159] = Class [328] 
.const [160] = NameAndType [329] [330] 
.const [161] = Class [331] 
.const [162] = NameAndType [332] [333] 
.const [163] = Class [334] 
.const [164] = NameAndType [335] [336] 
.const [165] = Class [337] 
.const [166] = NameAndType [338] [339] 
.const [167] = Class [340] 
.const [168] = NameAndType [341] [342] 
.const [169] = Class [343] 
.const [170] = NameAndType [344] [345] 
.const [171] = Class [346] 
.const [172] = NameAndType [347] [348] 
.const [173] = Class [349] 
.const [174] = NameAndType [350] [351] 
.const [175] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [176] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [177] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [178] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [179] = Utf8 de/esolutions/graphics/eal/glyphInformation_t 
.const [180] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [181] = Utf8 de/esolutions/graphics/eal/IEventImageSave 
.const [182] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [183] = Class [352] 
.const [184] = NameAndType [353] [354] 
.const [185] = Class [355] 
.const [186] = NameAndType [356] [357] 
.const [187] = Class [358] 
.const [188] = NameAndType [359] [360] 
.const [189] = Class [361] 
.const [190] = NameAndType [362] [363] 
.const [191] = Class [364] 
.const [192] = NameAndType [365] [366] 
.const [193] = Class [367] 
.const [194] = NameAndType [368] [369] 
.const [195] = Class [370] 
.const [196] = NameAndType [371] [372] 
.const [197] = Class [373] 
.const [198] = NameAndType [374] [375] 
.const [199] = Class [376] 
.const [200] = NameAndType [377] [378] 
.const [201] = Class [379] 
.const [202] = NameAndType [380] [381] 
.const [203] = Class [382] 
.const [204] = NameAndType [383] [384] 
.const [205] = Class [385] 
.const [206] = NameAndType [386] [387] 
.const [207] = Utf8 de/esolutions/graphics/eal/api/IContext 
.const [208] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [209] = Utf8 de/esolutions/graphics/eal/api/IRenderer 
.const [210] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [211] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [212] = Utf8 eal_api_IManager_SWIGUpcast 
.const [213] = Utf8 (J)J 
.const [214] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [215] = Utf8 delete_eal_api_IManager 
.const [216] = Utf8 (J)V 
.const [217] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [218] = Utf8 new_eal_api_IManager 
.const [219] = Utf8 ()J 
.const [220] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [221] = Utf8 eal_api_IManager_start 
.const [222] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)Z 
.const [223] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [224] = Utf8 eal_api_IManager_stop 
.const [225] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)Z 
.const [226] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [227] = Utf8 eal_api_IManager_getContext 
.const [228] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [229] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [230] = Utf8 eal_api_IManager_load 
.const [231] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Ljava/lang/String;)J 
.const [232] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [233] = Utf8 eal_api_IManager_getDefaultProject 
.const [234] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [235] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [236] = Utf8 eal_api_IManager_createDefaultProject 
.const [237] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [238] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [239] = Utf8 getCPtr 
.const [240] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [241] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [242] = Utf8 eal_api_IManager_setDefaultProject 
.const [243] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/api/IProject;)Z 
.const [244] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [245] = Utf8 eal_api_IManager_destroyDefaultProject 
.const [246] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/api/IProject;)Z 
.const [247] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [248] = Utf8 eal_api_IManager_printMemoryStatus 
.const [249] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [250] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [251] = Utf8 eal_api_IManager_getMemoryVRAM 
.const [252] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [253] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [254] = Utf8 eal_api_IManager_getMemoryRAM 
.const [255] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [256] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [257] = Utf8 eal_api_IManager_getMemoryRAMFree 
.const [258] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [259] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [260] = Utf8 eal_api_IManager_setMemorySize 
.const [261] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;J)Z 
.const [262] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [263] = Utf8 eal_api_IManager_isValid 
.const [264] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)Z 
.const [265] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [266] = Utf8 eal_api_IManager_getRenderer 
.const [267] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)J 
.const [268] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [269] = Utf8 eal_api_IManager_dispose 
.const [270] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [271] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [272] = Utf8 eal_api_IManager_dumpFontCaches 
.const [273] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Ljava/lang/String;)Z 
.const [274] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [275] = Utf8 eal_api_IManager_triggerDump 
.const [276] = Utf8 ()Ljava/lang/String; 
.const [277] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [278] = Utf8 getCPtr 
.const [279] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout;)J 
.const [280] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [281] = Utf8 eal_api_IManager_layout 
.const [282] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/api/ITextLayout;Ljava/lang/String;)J 
.const [283] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [284] = Utf8 getCPtr 
.const [285] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayoutResult;)J 
.const [286] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [287] = Utf8 eal_api_IManager_layoutGetWidth 
.const [288] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/api/ITextLayoutResult;[II)Z 
.const [289] = Utf8 de/esolutions/graphics/eal/glyphInformation_t 
.const [290] = Utf8 getCPtr 
.const [291] = Utf8 (Lde/esolutions/graphics/eal/glyphInformation_t;)J 
.const [292] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [293] = Utf8 eal_api_IManager_computeAvailableGlyphs 
.const [294] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Ljava/lang/String;JLde/esolutions/graphics/eal/api/ITextLayout;JLde/esolutions/graphics/eal/glyphInformation_t;)Z 
.const [295] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [296] = Utf8 eal_api_IManager_isMerged 
.const [297] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)Z 
.const [298] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [299] = Utf8 getCPtr 
.const [300] = Utf8 (Lde/esolutions/graphics/eal/IEventImage;)J 
.const [301] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [302] = Utf8 eal_api_IManager_execute__SWIG_0 
.const [303] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/IEventImage;)Z 
.const [304] = Utf8 de/esolutions/graphics/eal/IEventImageSave 
.const [305] = Utf8 getCPtr 
.const [306] = Utf8 (Lde/esolutions/graphics/eal/IEventImageSave;)J 
.const [307] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [308] = Utf8 eal_api_IManager_execute__SWIG_1 
.const [309] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/IEventImageSave;)Z 
.const [310] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [311] = Utf8 getCPtr 
.const [312] = Utf8 (Lde/esolutions/graphics/eal/IEventFontGroup;)J 
.const [313] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [314] = Utf8 eal_api_IManager_execute__SWIG_2 
.const [315] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/IEventFontGroup;)Z 
.const [316] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [317] = Utf8 eal_api_IManager_setObjectTracer 
.const [318] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Z)V 
.const [319] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [320] = Utf8 eal_api_IManager_dumpObjects 
.const [321] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [322] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [323] = Utf8 eal_api_IManager_dumpProfiling 
.const [324] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [325] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [326] = Utf8 eal_api_IManager_dumpRegistry 
.const [327] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [328] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [329] = Utf8 eal_api_IManager_dumpMemory 
.const [330] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [331] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [332] = Utf8 eal_api_IManager_dumpResources 
.const [333] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)V 
.const [334] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [335] = Utf8 eal_api_IManager_setRegistry 
.const [336] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Z)V 
.const [337] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [338] = Utf8 eal_api_IManager_setObjectWarnLimit 
.const [339] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;J)V 
.const [340] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [341] = Utf8 eal_api_IManager_setOpacityInvalidationInherit 
.const [342] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;Z)Z 
.const [343] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [344] = Utf8 eal_api_IManager_setEventThreadNumber 
.const [345] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;J)Z 
.const [346] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [347] = Utf8 eal_api_IManager_setFontDpi 
.const [348] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;I)Z 
.const [349] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [350] = Utf8 eal_api_IManager_getCurrentFontDpi 
.const [351] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;)I 
.const [352] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [353] = Utf8 swigCPtr 
.const [354] = Utf8 J 
.const [355] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [356] = Utf8 delete 
.const [357] = Utf8 ()V 
.const [358] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [359] = Utf8 swigCMemOwn 
.const [360] = Utf8 Z 
.const [361] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [362] = Utf8 <init> 
.const [363] = Utf8 (JZ)V 
.const [364] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [365] = Utf8 delete 
.const [366] = Utf8 ()V 
.const [367] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [368] = Utf8 <init> 
.const [369] = Utf8 (JZ)V 
.const [370] = Utf8 de/esolutions/graphics/eal/api/IContext 
.const [371] = Utf8 <init> 
.const [372] = Utf8 (JZ)V 
.const [373] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [374] = Utf8 <init> 
.const [375] = Utf8 (JZ)V 
.const [376] = Utf8 de/esolutions/graphics/eal/api/IRenderer 
.const [377] = Utf8 <init> 
.const [378] = Utf8 (JZ)V 
.const [379] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [380] = Utf8 <init> 
.const [381] = Utf8 (JZ)V 
.const [382] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [383] = Utf8 swigCPtr 
.const [384] = Utf8 J 
.const [385] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [386] = Utf8 swigCMemOwn 
.const [387] = Utf8 Z 
.const [388] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [389] = Class [388] 
.const [390] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [391] = Class [390] 
.const [392] = Utf8 swigCPtr 
.const [393] = Utf8 J 
.const [394] = Utf8 Code 
.const [395] = Utf8 <init> 
.const [396] = Utf8 (JZ)V 
.const [397] = Utf8 getCPtr 
.const [398] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;)J 
.const [399] = Utf8 finalize 
.const [400] = Utf8 ()V 
.const [401] = Utf8 delete 
.const [402] = Utf8 ()V 
.const [403] = Utf8 isDeleted 
.const [404] = Utf8 ()Z 
.const [405] = Utf8 <init> 
.const [406] = Utf8 ()V 
.const [407] = Utf8 start 
.const [408] = Utf8 ()Z 
.const [409] = Utf8 stop 
.const [410] = Utf8 ()Z 
.const [411] = Utf8 getContext 
.const [412] = Utf8 ()Lde/esolutions/graphics/eal/api/IContext; 
.const [413] = Utf8 load 
.const [414] = Utf8 (Ljava/lang/String;)Lde/esolutions/graphics/eal/api/IProject; 
.const [415] = Utf8 getDefaultProject 
.const [416] = Utf8 ()Lde/esolutions/graphics/eal/api/IProject; 
.const [417] = Utf8 createDefaultProject 
.const [418] = Utf8 ()Lde/esolutions/graphics/eal/api/IProject; 
.const [419] = Utf8 setDefaultProject 
.const [420] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)Z 
.const [421] = Utf8 destroyDefaultProject 
.const [422] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)Z 
.const [423] = Utf8 printMemoryStatus 
.const [424] = Utf8 ()V 
.const [425] = Utf8 getMemoryVRAM 
.const [426] = Utf8 ()J 
.const [427] = Utf8 getMemoryRAM 
.const [428] = Utf8 ()J 
.const [429] = Utf8 getMemoryRAMFree 
.const [430] = Utf8 ()J 
.const [431] = Utf8 setMemorySize 
.const [432] = Utf8 (J)Z 
.const [433] = Utf8 isValid 
.const [434] = Utf8 ()Z 
.const [435] = Utf8 getRenderer 
.const [436] = Utf8 ()Lde/esolutions/graphics/eal/api/IRenderer; 
.const [437] = Utf8 dispose 
.const [438] = Utf8 ()V 
.const [439] = Utf8 dumpFontCaches 
.const [440] = Utf8 (Ljava/lang/String;)Z 
.const [441] = Utf8 triggerDump 
.const [442] = Utf8 ()Ljava/lang/String; 
.const [443] = Utf8 layout 
.const [444] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout;Ljava/lang/String;)Lde/esolutions/graphics/eal/api/ITextLayoutResult; 
.const [445] = Utf8 layoutGetWidth 
.const [446] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayoutResult;[II)Z 
.const [447] = Utf8 computeAvailableGlyphs 
.const [448] = Utf8 (Ljava/lang/String;Lde/esolutions/graphics/eal/api/ITextLayout;Lde/esolutions/graphics/eal/glyphInformation_t;)Z 
.const [449] = Utf8 isMerged 
.const [450] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)Z 
.const [451] = Utf8 execute 
.const [452] = Utf8 (Lde/esolutions/graphics/eal/IEventImage;)Z 
.const [453] = Utf8 execute 
.const [454] = Utf8 (Lde/esolutions/graphics/eal/IEventImageSave;)Z 
.const [455] = Utf8 execute 
.const [456] = Utf8 (Lde/esolutions/graphics/eal/IEventFontGroup;)Z 
.const [457] = Utf8 setObjectTracer 
.const [458] = Utf8 (Z)V 
.const [459] = Utf8 dumpObjects 
.const [460] = Utf8 ()V 
.const [461] = Utf8 dumpProfiling 
.const [462] = Utf8 ()V 
.const [463] = Utf8 dumpRegistry 
.const [464] = Utf8 ()V 
.const [465] = Utf8 dumpMemory 
.const [466] = Utf8 ()V 
.const [467] = Utf8 dumpResources 
.const [468] = Utf8 ()V 
.const [469] = Utf8 setRegistry 
.const [470] = Utf8 (Z)V 
.const [471] = Utf8 setObjectWarnLimit 
.const [472] = Utf8 (J)V 
.const [473] = Utf8 setOpacityInvalidationInherit 
.const [474] = Utf8 (Z)Z 
.const [475] = Utf8 setEventThreadNumber 
.const [476] = Utf8 (J)Z 
.const [477] = Utf8 setFontDpi 
.const [478] = Utf8 (I)Z 
.const [479] = Utf8 getCurrentFontDpi 
.const [480] = Utf8 ()I 
.end class 
