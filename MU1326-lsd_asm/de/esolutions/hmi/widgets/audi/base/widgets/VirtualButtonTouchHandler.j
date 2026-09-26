.version 50 0 
.class public super [348] 
.super [350] 
.implements [352] 
.implements [354] 
.implements [356] 
.field private [357] [358] 
.field private [359] [360] 
.field static final [361] [362] 
.field private [363] [364] 
.field private [365] [366] 
.field private [367] [368] 
.field private static final [369] [370] 
.field private static final [371] [372] 

.method public [374] : [375] 
    .attribute [373] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [62] 
L4:     aload_0 
L5:     ldc2_w [81] 
L8:     putfield [67] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [68] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [69] 
L21:    aload_0 
L22:    aload_1 
L23:    putfield [70] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [376] : [377] 
    .attribute [373] .code stack 5 locals 4 
L0:     aload_1 
L1:     invokevirtual [44] 
L4:     ifne L20 
L7:     aload_1 
L8:     invokevirtual [45] 
L11:    ifne L20 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [46] 
L19:    return 
L20:    aload_0 
L21:    getfield [42] 
L24:    ifne L35 
L27:    aload_0 
L28:    aload_0 
L29:    invokevirtual [47] 
L32:    putfield [69] 
L35:    aload_0 
L36:    aload_1 
L37:    invokespecial [63] 
L40:    istore_3 
L41:    aload_1 
L42:    invokevirtual [44] 
L45:    ifne L63 
L48:    aload_1 
L49:    invokevirtual [45] 
L52:    iconst_1 
L53:    if_icmpgt L63 
L56:    aload_2 
L57:    instanceof [2] 
L60:    ifne L64 
L63:    return 
L64:    aload_1 
L65:    iconst_0 
L66:    invokevirtual [48] 
L69:    aload_0 
L70:    aload_1 
L71:    invokespecial [64] 
L74:    istore 4 
L76:    aload_0 
L77:    iload_3 
L78:    iload 4 
L80:    invokespecial [65] 
L83:    fstore 5 
L85:    aload_0 
L86:    fload 5 
L88:    iload 4 
L90:    aload_2 
L91:    checkcast [2] 
L94:    invokevirtual [49] 
L97:    istore 6 
L99:    getstatic [3] 
L102:   ldc [4] 
L104:   ldc [5] 
L106:   iload 6 
L108:   i2l 
L109:   invokevirtual [50] 
L112:   pop 
L113:   aload_2 
L114:   instanceof [2] 
L117:   ifeq L204 
L120:   aload_0 
L121:   getfield [51] 
L124:   ifne L167 
L127:   aload_2 
L128:   checkcast [2] 
L131:   iload 6 
L133:   aload_0 
L134:   getfield [43] 
L137:   invokevirtual [52] 
L140:   invokeinterface [72] 0 
L145:   invokeinterface [73] 0 
L150:   getstatic [3] 
L153:   ldc [4] 
L155:   ldc [6] 
L157:   iload 6 
L159:   i2l 
L160:   invokevirtual [50] 
L163:   pop 
L164:   goto L204 
L167:   aload_2 
L168:   checkcast [2] 
L171:   iload 6 
L173:   aload_0 
L174:   getfield [43] 
L177:   invokevirtual [52] 
L180:   invokeinterface [72] 0 
L185:   invokeinterface [74] 0 
L190:   getstatic [3] 
L193:   ldc [4] 
L195:   ldc [7] 
L197:   iload 6 
L199:   i2l 
L200:   invokevirtual [50] 
L203:   pop 
L204:   return 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 

.method private [378] : [379] 
    .attribute [373] .code stack 6 locals 6 
L0:     aload_0 
L1:     invokevirtual [53] 
L4:     lstore_2 
L5:     lload_2 
L6:     aload_0 
L7:     getfield [40] 
L10:    lsub 
L11:    lstore 4 
L13:    aload_0 
L14:    lload_2 
L15:    putfield [67] 
L18:    lload 4 
L20:    ldc_w [1] 
L23:    invokestatic [8] 
L26:    l2i 
L27:    istore 6 
L29:    aload_1 
L30:    invokevirtual [54] 
L33:    istore 7 
L35:    iload 7 
L37:    ifle L43 
L40:    iload 7 
L42:    areturn 
L43:    getstatic [3] 
L46:    ldc [4] 
L48:    ldc [9] 
L50:    aload_1 
L51:    iload 6 
L53:    i2l 
L54:    invokevirtual [55] 
L57:    pop 
L58:    iload 6 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [380] : [381] 
    .attribute [373] .code stack 2 locals 0 
L0:     getstatic [10] 
L3:     invokeinterface [75] 0 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [382] : [383] 
    .attribute [373] .code stack 5 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [43] 
L6:     invokevirtual [52] 
L9:     ifnull L33 
L12:    aload_0 
L13:    getfield [43] 
L16:    invokevirtual [52] 
L19:    invokeinterface [76] 0 
L24:    invokeinterface [77] 0 
L29:    istore_1 
L30:    goto L44 
L33:    getstatic [3] 
L36:    ldc [4] 
L38:    ldc [11] 
L40:    invokevirtual [56] 
L43:    pop 
L44:    iload_1 
L45:    lookupswitch 
            5 : L97 
            6 : L80 
            15 : L114 
            default : L131 

L80:    getstatic [3] 
L83:    ldc [4] 
L85:    ldc [12] 
L87:    iload_1 
L88:    i2l 
L89:    invokevirtual [50] 
L92:    pop 
L93:    sipush 1024 
L96:    areturn 
L97:    getstatic [3] 
L100:   ldc [4] 
L102:   ldc [13] 
L104:   iload_1 
L105:   i2l 
L106:   invokevirtual [50] 
L109:   pop 
L110:   sipush 1024 
L113:   areturn 
L114:   getstatic [3] 
L117:   ldc [4] 
L119:   ldc [14] 
L121:   iload_1 
L122:   i2l 
L123:   invokevirtual [50] 
L126:   pop 
L127:   sipush 256 
L130:   areturn 
L131:   getstatic [3] 
L134:   ldc [4] 
L136:   ldc [15] 
L138:   iload_1 
L139:   i2l 
L140:   invokevirtual [50] 
L143:   pop 
L144:   sipush 256 
L147:   areturn 
L148:   
    .end code 
.end method 

.method public [384] : [385] 
    .attribute [373] .code stack 9 locals 5 
L0:     aload_3 
L1:     invokeinterface [78] 0 
L6:     istore 4 
L8:     aload_3 
L9:     invokeinterface [79] 0 
L14:    istore 5 
L16:    aload_3 
L17:    invokeinterface [80] 0 
L22:    istore 6 
L24:    iload 4 
L26:    iload 5 
L28:    isub 
L29:    istore 7 
L31:    iload_2 
L32:    iload 6 
L34:    imul 
L35:    invokestatic [16] 
L38:    i2f 
L39:    iload 7 
L41:    i2f 
L42:    fdiv 
L43:    fload_1 
L44:    ldc [17] 
L46:    fdiv 
L47:    fmul 
L48:    iload 7 
L50:    i2f 
L51:    aload_0 
L52:    getfield [42] 
L55:    i2f 
L56:    fdiv 
L57:    fmul 
L58:    iload 7 
L60:    i2f 
L61:    fmul 
L62:    f2i 
L63:    istore 8 
L65:    iload 7 
L67:    bipush 60 
L69:    if_icmpge L86 
L72:    iload 8 
L74:    ifne L86 
L77:    fload_1 
L78:    fconst_0 
L79:    fcmpl 
L80:    ifle L86 
L83:    iconst_1 
L84:    istore 8 
L86:    getstatic [3] 
L89:    ldc [4] 
L91:    ldc [18] 
L93:    iload 8 
L95:    i2l 
L96:    iload 7 
L98:    i2l 
L99:    aload_0 
L100:   getfield [42] 
L103:   i2l 
L104:   invokevirtual [57] 
L107:   pop 
L108:   iload 8 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [386] : [387] 
    .attribute [373] .code stack 9 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [63] 
L5:     istore_2 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [68] 
L11:    iconst_0 
L12:    istore_3 
L13:    getstatic [3] 
L16:    ldc [4] 
L18:    ldc [19] 
L20:    iload_2 
L21:    i2l 
L22:    iload_3 
L23:    i2l 
L24:    aload_1 
L25:    invokevirtual [45] 
L28:    i2l 
L29:    invokevirtual [57] 
L32:    pop 
L33:    aload_1 
L34:    invokevirtual [58] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [388] : [389] 
    .attribute [373] .code stack 5 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [66] 
L5:     istore_2 
L6:     aload_0 
L7:     aload_0 
L8:     getfield [41] 
L11:    ifne L18 
L14:    iload_2 
L15:    goto L22 
L18:    aload_0 
L19:    getfield [41] 
L22:    putfield [68] 
L25:    aload_1 
L26:    invokevirtual [45] 
L29:    iconst_1 
L30:    if_icmpne L43 
L33:    iload_2 
L34:    aload_0 
L35:    getfield [41] 
L38:    isub 
L39:    istore_3 
L40:    goto L45 
L43:    iconst_0 
L44:    istore_3 
L45:    aload_0 
L46:    getfield [41] 
L49:    aload_1 
L50:    invokevirtual [59] 
L53:    if_icmple L75 
L56:    aload_0 
L57:    iconst_1 
L58:    putfield [71] 
L61:    getstatic [3] 
L64:    ldc [4] 
L66:    ldc [20] 
L68:    invokevirtual [56] 
L71:    pop 
L72:    goto L91 
L75:    aload_0 
L76:    iconst_0 
L77:    putfield [71] 
L80:    getstatic [3] 
L83:    ldc [4] 
L85:    ldc [21] 
L87:    invokevirtual [56] 
L90:    pop 
L91:    aload_0 
L92:    iload_2 
L93:    putfield [68] 
L96:    getstatic [3] 
L99:    ldc [4] 
L101:   ldc [22] 
L103:   iload_3 
L104:   i2l 
L105:   invokevirtual [50] 
L108:   pop 
L109:   iload_3 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 

.method private [390] : [391] 
    .attribute [373] .code stack 6 locals 0 
L0:     aload_1 
L1:     invokevirtual [60] 
L4:     sipush 10911 
L7:     if_icmpeq L30 
L10:    aload_1 
L11:    invokevirtual [60] 
L14:    sipush 10905 
L17:    if_icmpeq L30 
L20:    aload_1 
L21:    invokevirtual [60] 
L24:    sipush 10904 
L27:    if_icmpne L35 
L30:    aload_1 
L31:    invokevirtual [59] 
L34:    areturn 
L35:    aload_1 
L36:    invokevirtual [60] 
L39:    sipush 10912 
L42:    if_icmpne L55 
L45:    aload_0 
L46:    getfield [41] 
L49:    aload_1 
L50:    invokevirtual [59] 
L53:    iadd 
L54:    areturn 
L55:    getstatic [3] 
L58:    ldc [4] 
L60:    ldc [23] 
L62:    aload_1 
L63:    aload_1 
L64:    invokevirtual [60] 
L67:    i2l 
L68:    invokevirtual [55] 
L71:    pop 
L72:    iconst_0 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [392] : [393] 
    .attribute [373] .code stack 5 locals 1 
L0:     iload_1 
L1:     ifne L17 
L4:     getstatic [3] 
L7:     ldc [4] 
L9:     ldc [24] 
L11:    invokevirtual [56] 
L14:    pop 
L15:    fconst_0 
L16:    areturn 
L17:    iload_2 
L18:    invokestatic [16] 
L21:    i2f 
L22:    iload_1 
L23:    i2f 
L24:    fdiv 
L25:    fstore_3 
L26:    fload_3 
L27:    ldc [25] 
L29:    invokestatic [26] 
L32:    fstore_3 
L33:    fload_3 
L34:    ldc [27] 
L36:    invokestatic [28] 
L39:    fstore_3 
L40:    getstatic [3] 
L43:    ldc [4] 
L45:    ldc [29] 
L47:    fload_3 
L48:    f2d 
L49:    invokevirtual [61] 
L52:    fload_3 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public enum [394] : [395] 
    .attribute [373] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [396] : [397] 
    .attribute [373] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [398] : [399] 
    .attribute [373] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [84] 
.const [3] = Field [85] [86] 
.const [4] = Int -2137614336 
.const [5] = String [87] 
.const [6] = String [88] 
.const [7] = String [89] 
.const [8] = Method [90] [91] 
.const [9] = String [92] 
.const [10] = Field [93] [94] 
.const [11] = String [95] 
.const [12] = String [96] 
.const [13] = String [97] 
.const [14] = String [98] 
.const [15] = String [99] 
.const [16] = Method [100] [101] 
.const [17] = Int 41025 
.const [18] = String [102] 
.const [19] = String [103] 
.const [20] = String [104] 
.const [21] = String [105] 
.const [22] = String [106] 
.const [23] = String [107] 
.const [24] = String [108] 
.const [25] = Int 16448 
.const [26] = Method [109] [110] 
.const [27] = Int 49216 
.const [28] = Method [111] [112] 
.const [29] = String [113] 
.const [30] = Class [114] 
.const [31] = Class [115] 
.const [32] = Class [116] 
.const [33] = Class [117] 
.const [34] = Class [118] 
.const [35] = Class [119] 
.const [36] = Class [120] 
.const [37] = Class [121] 
.const [38] = Class [122] 
.const [39] = Class [123] 
.const [40] = Field [124] [125] 
.const [41] = Field [126] [127] 
.const [42] = Field [128] [129] 
.const [43] = Field [130] [131] 
.const [44] = Method [132] [133] 
.const [45] = Method [134] [135] 
.const [46] = Method [136] [137] 
.const [47] = Method [138] [139] 
.const [48] = Method [140] [141] 
.const [49] = Method [142] [143] 
.const [50] = Method [144] [145] 
.const [51] = Field [146] [147] 
.const [52] = Method [148] [149] 
.const [53] = Method [150] [151] 
.const [54] = Method [152] [153] 
.const [55] = Method [154] [155] 
.const [56] = Method [156] [157] 
.const [57] = Method [158] [159] 
.const [58] = Method [160] [161] 
.const [59] = Method [162] [163] 
.const [60] = Method [164] [165] 
.const [61] = Method [166] [167] 
.const [62] = Method [168] [169] 
.const [63] = Method [170] [171] 
.const [64] = Method [172] [173] 
.const [65] = Method [174] [175] 
.const [66] = Method [176] [177] 
.const [67] = Field [178] [179] 
.const [68] = Field [180] [181] 
.const [69] = Field [182] [183] 
.const [70] = Field [184] [185] 
.const [71] = Field [186] [187] 
.const [72] = InterfaceMethod [188] [189] 
.const [73] = InterfaceMethod [190] [191] 
.const [74] = InterfaceMethod [192] [193] 
.const [75] = InterfaceMethod [194] [195] 
.const [76] = InterfaceMethod [196] [197] 
.const [77] = InterfaceMethod [198] [199] 
.const [78] = InterfaceMethod [200] [201] 
.const [79] = InterfaceMethod [202] [203] 
.const [80] = InterfaceMethod [204] [205] 
.const [81] = Long -1L 
.const [83] = Int -129 
.const [84] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [85] = Class [206] 
.const [86] = NameAndType [207] [208] 
.const [87] = Utf8 'VirtualButtonTouchHandler#touchPadPositionMoved: touch gesture transformed into %1 clicks' 
.const [88] = Utf8 'VirtualButtonTouchHandler#touchPadPositionMoved: increment model to: %1' 
.const [89] = Utf8 'VirtualButtonTouchHandler#touchPadPositionMoved: decrement model to: %1' 
.const [90] = Class [209] 
.const [91] = NameAndType [210] [211] 
.const [92] = Utf8 'VirtualButtonTouchHandler#getDeltaTime: event has no deltatime. time since last event: %2, event: %1' 
.const [93] = Class [212] 
.const [94] = NameAndType [213] [214] 
.const [95] = Utf8 '#TouchController#getKeyPanelTouchResolution: Terminal is Null' 
.const [96] = Utf8 '#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_ALLINTOUCH (%1)' 
.const [97] = Utf8 '#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_TOUCHWHEEL (%1)' 
.const [98] = Utf8 '#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_AB3 (%1)' 
.const [99] = Utf8 '#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: NONE (%1)' 
.const [100] = Class [215] 
.const [101] = NameAndType [216] [217] 
.const [102] = Utf8 'VirtualButtonTouchHandler#transformTouchGestureToTicks: clickCount: %1, range: %2 resolution: %3' 
.const [103] = Utf8 'VirtualButtonTouchHandler#touchPadReleased: deltatime: %1, distance: %2, finger: %3' 
.const [104] = Utf8 'VirtualButtonTouchHandler#getAbsoluteX: Direction of swipe gesture is left' 
.const [105] = Utf8 'VirtualButtonTouchHandler#getAbsoluteX: Direction of swipe gesture is right' 
.const [106] = Utf8 'VirtualButtonTouchHandler#getRelativeSwipeDistance: TouchDistance: %1' 
.const [107] = Utf8 'VirtualButtonTouchHandler#getAbsoluteX: unknown touch event type %2 for event: %1' 
.const [108] = Utf8 'VirtualButtonTouchHandler#getSwipeSpeed: can not measure speed (duration=0).' 
.const [109] = Class [218] 
.const [110] = NameAndType [219] [220] 
.const [111] = Class [221] 
.const [112] = NameAndType [222] [223] 
.const [113] = Utf8 'VirtualButtonTouchHandler#getSwipeSpeed: speed of touch gesture: %1' 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [115] = Utf8 java/lang/Object 
.const [116] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButton 
.const [119] = Utf8 de/audi/atip/hmi/HMITerminal 
.const [120] = Utf8 java/lang/Math 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [122] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [123] = Utf8 de/audi/atip/hmi/KbdService 
.const [124] = Class [224] 
.const [125] = NameAndType [225] [226] 
.const [126] = Class [227] 
.const [127] = NameAndType [228] [229] 
.const [128] = Class [230] 
.const [129] = NameAndType [231] [232] 
.const [130] = Class [233] 
.const [131] = NameAndType [234] [235] 
.const [132] = Class [236] 
.const [133] = NameAndType [237] [238] 
.const [134] = Class [239] 
.const [135] = NameAndType [240] [241] 
.const [136] = Class [242] 
.const [137] = NameAndType [243] [244] 
.const [138] = Class [245] 
.const [139] = NameAndType [246] [247] 
.const [140] = Class [248] 
.const [141] = NameAndType [249] [250] 
.const [142] = Class [251] 
.const [143] = NameAndType [252] [253] 
.const [144] = Class [254] 
.const [145] = NameAndType [255] [256] 
.const [146] = Class [257] 
.const [147] = NameAndType [258] [259] 
.const [148] = Class [260] 
.const [149] = NameAndType [261] [262] 
.const [150] = Class [263] 
.const [151] = NameAndType [264] [265] 
.const [152] = Class [266] 
.const [153] = NameAndType [267] [268] 
.const [154] = Class [269] 
.const [155] = NameAndType [270] [271] 
.const [156] = Class [272] 
.const [157] = NameAndType [273] [274] 
.const [158] = Class [275] 
.const [159] = NameAndType [276] [277] 
.const [160] = Class [278] 
.const [161] = NameAndType [279] [280] 
.const [162] = Class [281] 
.const [163] = NameAndType [282] [283] 
.const [164] = Class [284] 
.const [165] = NameAndType [285] [286] 
.const [166] = Class [287] 
.const [167] = NameAndType [288] [289] 
.const [168] = Class [290] 
.const [169] = NameAndType [291] [292] 
.const [170] = Class [293] 
.const [171] = NameAndType [294] [295] 
.const [172] = Class [296] 
.const [173] = NameAndType [297] [298] 
.const [174] = Class [299] 
.const [175] = NameAndType [300] [301] 
.const [176] = Class [302] 
.const [177] = NameAndType [303] [304] 
.const [178] = Class [305] 
.const [179] = NameAndType [306] [307] 
.const [180] = Class [308] 
.const [181] = NameAndType [309] [310] 
.const [182] = Class [311] 
.const [183] = NameAndType [312] [313] 
.const [184] = Class [314] 
.const [185] = NameAndType [315] [316] 
.const [186] = Class [317] 
.const [187] = NameAndType [318] [319] 
.const [188] = Class [320] 
.const [189] = NameAndType [321] [322] 
.const [190] = Class [323] 
.const [191] = NameAndType [324] [325] 
.const [192] = Class [326] 
.const [193] = NameAndType [327] [328] 
.const [194] = Class [329] 
.const [195] = NameAndType [330] [331] 
.const [196] = Class [332] 
.const [197] = NameAndType [333] [334] 
.const [198] = Class [335] 
.const [199] = NameAndType [336] [337] 
.const [200] = Class [338] 
.const [201] = NameAndType [339] [340] 
.const [202] = Class [341] 
.const [203] = NameAndType [342] [343] 
.const [204] = Class [344] 
.const [205] = NameAndType [345] [346] 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [207] = Utf8 logChannel 
.const [208] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [209] = Utf8 java/lang/Math 
.const [210] = Utf8 min 
.const [211] = Utf8 (JJ)J 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [213] = Utf8 framework 
.const [214] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [215] = Utf8 java/lang/Math 
.const [216] = Utf8 abs 
.const [217] = Utf8 (I)I 
.const [218] = Utf8 java/lang/Math 
.const [219] = Utf8 max 
.const [220] = Utf8 (FF)F 
.const [221] = Utf8 java/lang/Math 
.const [222] = Utf8 min 
.const [223] = Utf8 (FF)F 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [225] = Utf8 lastTouchTime 
.const [226] = Utf8 J 
.const [227] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [228] = Utf8 lastTouchX 
.const [229] = Utf8 I 
.const [230] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [231] = Utf8 touchXResolution 
.const [232] = Utf8 I 
.const [233] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [234] = Utf8 virtualButton 
.const [235] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/VirtualButton; 
.const [236] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [237] = Utf8 isConsumed 
.const [238] = Utf8 ()Z 
.const [239] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [240] = Utf8 getFingerCount 
.const [241] = Utf8 ()I 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [243] = Utf8 touchPadReleased 
.const [244] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [246] = Utf8 getKeyPanelTouchResolution 
.const [247] = Utf8 ()I 
.const [248] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [249] = Utf8 consume 
.const [250] = Utf8 (Z)V 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [252] = Utf8 transformTouchGestureToTicks 
.const [253] = Utf8 (FILde/audi/atip/hmi/modelaccess/RangeModelGUI;)I 
.const [254] = Utf8 de/audi/atip/log/LogChannel 
.const [255] = Utf8 log 
.const [256] = Utf8 (ILjava/lang/String;J)Z 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [258] = Utf8 swipeDirection 
.const [259] = Utf8 I 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButton 
.const [261] = Utf8 getTerminal 
.const [262] = Utf8 ()Lde/audi/atip/hmi/HMITerminal; 
.const [263] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [264] = Utf8 getCurrentTime 
.const [265] = Utf8 ()J 
.const [266] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [267] = Utf8 getDeltaTime 
.const [268] = Utf8 ()I 
.const [269] = Utf8 de/audi/atip/log/LogChannel 
.const [270] = Utf8 log 
.const [271] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [272] = Utf8 de/audi/atip/log/LogChannel 
.const [273] = Utf8 log 
.const [274] = Utf8 (ILjava/lang/String;)Z 
.const [275] = Utf8 de/audi/atip/log/LogChannel 
.const [276] = Utf8 log 
.const [277] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [278] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [279] = Utf8 consume 
.const [280] = Utf8 ()V 
.const [281] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [282] = Utf8 getX 
.const [283] = Utf8 ()I 
.const [284] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [285] = Utf8 getID 
.const [286] = Utf8 ()I 
.const [287] = Utf8 de/audi/atip/log/LogChannel 
.const [288] = Utf8 log 
.const [289] = Utf8 (ILjava/lang/String;D)V 
.const [290] = Utf8 java/lang/Object 
.const [291] = Utf8 <init> 
.const [292] = Utf8 ()V 
.const [293] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [294] = Utf8 getDeltaTime 
.const [295] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [296] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [297] = Utf8 getRelativeSwipeDistance 
.const [298] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [299] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [300] = Utf8 getSwipeSpeed 
.const [301] = Utf8 (II)F 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [303] = Utf8 getAbsoluteX 
.const [304] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [305] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [306] = Utf8 lastTouchTime 
.const [307] = Utf8 J 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [309] = Utf8 lastTouchX 
.const [310] = Utf8 I 
.const [311] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [312] = Utf8 touchXResolution 
.const [313] = Utf8 I 
.const [314] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [315] = Utf8 virtualButton 
.const [316] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/VirtualButton; 
.const [317] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [318] = Utf8 swipeDirection 
.const [319] = Utf8 I 
.const [320] = Utf8 de/audi/atip/hmi/HMITerminal 
.const [321] = Utf8 getTerminalID 
.const [322] = Utf8 ()I 
.const [323] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [324] = Utf8 increment 
.const [325] = Utf8 (II)V 
.const [326] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [327] = Utf8 decrement 
.const [328] = Utf8 (II)V 
.const [329] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [330] = Utf8 getMonotonicTime 
.const [331] = Utf8 ()J 
.const [332] = Utf8 de/audi/atip/hmi/HMITerminal 
.const [333] = Utf8 getKbdService 
.const [334] = Utf8 ()Lde/audi/atip/hmi/KbdService; 
.const [335] = Utf8 de/audi/atip/hmi/KbdService 
.const [336] = Utf8 getCurrentKeyboardType 
.const [337] = Utf8 ()I 
.const [338] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [339] = Utf8 getMaximum 
.const [340] = Utf8 ()I 
.const [341] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [342] = Utf8 getMinimum 
.const [343] = Utf8 ()I 
.const [344] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [345] = Utf8 getStep 
.const [346] = Utf8 ()I 
.const [347] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/VirtualButtonTouchHandler 
.const [348] = Class [347] 
.const [349] = Utf8 java/lang/Object 
.const [350] = Class [349] 
.const [351] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetConstants 
.const [352] = Class [351] 
.const [353] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [354] = Class [353] 
.const [355] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [356] = Class [355] 
.const [357] = Utf8 virtualButton 
.const [358] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/VirtualButton; 
.const [359] = Utf8 lastTouchTime 
.const [360] = Utf8 J 
.const [361] = Utf8 USE_TOUCHEVENT_DELTATIME 
.const [362] = Utf8 Z 
.const [363] = Utf8 lastTouchX 
.const [364] = Utf8 I 
.const [365] = Utf8 swipeDirection 
.const [366] = Utf8 I 
.const [367] = Utf8 touchXResolution 
.const [368] = Utf8 I 
.const [369] = Utf8 MAX_SWIPE_SPEED 
.const [370] = Utf8 I 
.const [371] = Utf8 MIN_SWIPE_SPEED 
.const [372] = Utf8 I 
.const [373] = Utf8 Code 
.const [374] = Utf8 <init> 
.const [375] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/VirtualButton;)V 
.const [376] = Utf8 touchPadPositionMoved 
.const [377] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;Ljava/lang/Object;)V 
.const [378] = Utf8 getDeltaTime 
.const [379] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [380] = Utf8 getCurrentTime 
.const [381] = Utf8 ()J 
.const [382] = Utf8 getKeyPanelTouchResolution 
.const [383] = Utf8 ()I 
.const [384] = Utf8 transformTouchGestureToTicks 
.const [385] = Utf8 (FILde/audi/atip/hmi/modelaccess/RangeModelGUI;)I 
.const [386] = Utf8 touchPadReleased 
.const [387] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [388] = Utf8 getRelativeSwipeDistance 
.const [389] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [390] = Utf8 getAbsoluteX 
.const [391] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)I 
.const [392] = Utf8 getSwipeSpeed 
.const [393] = Utf8 (II)F 
.const [394] = Utf8 animate 
.const [395] = Utf8 (IFI)V 
.const [396] = Utf8 animationStarted 
.const [397] = Utf8 (II)V 
.const [398] = Utf8 animationFinished 
.const [399] = Utf8 (II)V 
.end class 
