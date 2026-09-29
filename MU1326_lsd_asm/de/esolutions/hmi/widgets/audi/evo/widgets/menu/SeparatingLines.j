.version 50 0 
.class public super abstract [241] 
.super [243] 
.field protected [244] [245] 
.field private [246] [247] 
.field private [248] [249] 

.method public [251] : [252] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [44] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [45] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [253] : [254] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [45] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [250] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifeq L17 
L7:     new [46] 
L10:    dup 
L11:    ldc [3] 
L13:    invokespecial [38] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [19] 
L21:    ifnonnull L64 
L24:    aload_0 
L25:    getfield [20] 
L28:    instanceof [4] 
L31:    ifne L64 
L34:    new [46] 
L37:    dup 
L38:    new [48] 
L41:    dup 
L42:    invokespecial [39] 
L45:    ldc [6] 
L47:    invokevirtual [21] 
L50:    aload_0 
L51:    getfield [20] 
L54:    invokevirtual [22] 
L57:    invokevirtual [23] 
L60:    invokespecial [38] 
L63:    athrow 
L64:    aload_0 
L65:    invokevirtual [24] 
L68:    astore_3 
L69:    aload_3 
L70:    ifnull L113 
L73:    aload_3 
L74:    arraylength 
L75:    ifle L113 
L78:    aload_0 
L79:    getfield [19] 
L82:    ifnull L92 
L85:    aload_0 
L86:    getfield [19] 
L89:    goto L99 
L92:    aload_0 
L93:    getfield [20] 
L96:    checkcast [4] 
L99:    astore 4 
L101:   aload_0 
L102:   aload_3 
L103:   iconst_0 
L104:   iaload 
L105:   aload 4 
L107:   aload_1 
L108:   aload_2 
L109:   invokespecial [40] 
L112:   areturn 
L113:   aconst_null 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method private [259] : [260] 
    .attribute [250] .code stack 5 locals 2 
L0:     new [49] 
L3:     dup 
L4:     invokespecial [41] 
L7:     astore 5 
L9:     aload_0 
L10:    aload 5 
L12:    invokevirtual [25] 
L15:    astore 6 
L17:    aload 5 
L19:    aload 6 
L21:    invokevirtual [26] 
L24:    aload 5 
L26:    iconst_1 
L27:    newarray int 
L29:    dup 
L30:    iconst_0 
L31:    iload_1 
L32:    iastore 
L33:    invokevirtual [27] 
L36:    aload 5 
L38:    aload_3 
L39:    invokevirtual [28] 
L42:    aload 5 
L44:    aload 4 
L46:    invokevirtual [29] 
L49:    aload 5 
L51:    aload_0 
L52:    invokevirtual [30] 
L55:    invokevirtual [31] 
L58:    aload_2 
L59:    aload 5 
L61:    bipush 7 
L63:    invokevirtual [32] 
L66:    aload 5 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [250] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [42] 
L5:     aload_0 
L6:     getfield [20] 
L9:     instanceof [4] 
L12:    ifeq L33 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [20] 
L20:    checkcast [4] 
L23:    putfield [47] 
L26:    aload_0 
L27:    invokespecial [43] 
L30:    goto L45 
L33:    getstatic [8] 
L36:    sipush 10000 
L39:    ldc [9] 
L41:    invokevirtual [33] 
L44:    pop 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected abstract [263] : [264] 
    .attribute [250] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [250] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [267] : [268] 
    .attribute [250] .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifne L174 
L7:     aload_0 
L8:     getfield [19] 
L11:    ifnull L169 
L14:    aload_0 
L15:    getfield [18] 
L18:    ifeq L169 
L21:    aload_0 
L22:    invokevirtual [24] 
L25:    astore_1 
L26:    aload_1 
L27:    ifnull L35 
L30:    aload_1 
L31:    arraylength 
L32:    ifne L48 
L35:    getstatic [8] 
L38:    sipush 10000 
L41:    ldc [10] 
L43:    invokevirtual [33] 
L46:    pop 
L47:    return 
L48:    aload_0 
L49:    getfield [19] 
L52:    invokevirtual [34] 
L55:    astore_2 
L56:    aconst_null 
L57:    astore_3 
L58:    aconst_null 
L59:    astore 4 
L61:    iconst_0 
L62:    istore 5 
L64:    aload_2 
L65:    invokeinterface [50] 0 
L70:    istore 6 
L72:    iload 5 
L74:    iload 6 
L76:    if_icmpge L169 
L79:    aload_2 
L80:    iload 5 
L82:    invokeinterface [51] 0 
L87:    checkcast [11] 
L90:    astore 7 
L92:    aload_0 
L93:    getfield [19] 
L96:    aload 7 
L98:    invokevirtual [35] 
L101:   ifeq L163 
L104:   aload_3 
L105:   ifnonnull L117 
L108:   aload 7 
L110:   checkcast [12] 
L113:   astore_3 
L114:   goto L163 
L117:   aload 7 
L119:   checkcast [12] 
L122:   astore 4 
L124:   aload_0 
L125:   aload_1 
L126:   iconst_0 
L127:   iaload 
L128:   aload_0 
L129:   getfield [19] 
L132:   aload_3 
L133:   aload 4 
L135:   invokespecial [40] 
L138:   astore 8 
L140:   aload 8 
L142:   ifnull L160 
L145:   aload 8 
L147:   invokevirtual [36] 
L150:   checkcast [13] 
L153:   iconst_1 
L154:   iconst_5 
L155:   invokeinterface [52] 0 
L160:   aload 4 
L162:   astore_3 
L163:   iinc 5 1 
L166:   goto L72 
L169:   aload_0 
L170:   iconst_1 
L171:   putfield [44] 
L174:   return 
L175:   nop 
L176:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = String [54] 
.const [4] = Class [55] 
.const [5] = Class [56] 
.const [6] = String [57] 
.const [7] = Class [58] 
.const [8] = Field [59] [60] 
.const [9] = String [61] 
.const [10] = String [62] 
.const [11] = Class [63] 
.const [12] = Class [64] 
.const [13] = Class [65] 
.const [14] = Class [66] 
.const [15] = Class [67] 
.const [16] = Class [68] 
.const [17] = Field [69] [70] 
.const [18] = Field [71] [72] 
.const [19] = Field [73] [74] 
.const [20] = Field [75] [76] 
.const [21] = Method [77] [78] 
.const [22] = Method [79] [80] 
.const [23] = Method [81] [82] 
.const [24] = Method [83] [84] 
.const [25] = Method [85] [86] 
.const [26] = Method [87] [88] 
.const [27] = Method [89] [90] 
.const [28] = Method [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Method [97] [98] 
.const [32] = Method [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Method [113] [114] 
.const [40] = Method [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Method [119] [120] 
.const [43] = Method [121] [122] 
.const [44] = Field [123] [124] 
.const [45] = Field [125] [126] 
.const [46] = Class [127] 
.const [47] = Field [128] [129] 
.const [48] = Class [130] 
.const [49] = Class [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = InterfaceMethod [136] [137] 
.const [53] = Utf8 java/lang/IllegalStateException 
.const [54] = Utf8 'only supported in manual mode!' 
.const [55] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'cannot add separator to parent ' 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [59] = Class [138] 
.const [60] = NameAndType [139] [140] 
.const [61] = Utf8 'SeparatingLines#connected Parent is null or is not a menu.' 
.const [62] = Utf8 'SeparatingLinesHigh#setUpWidget No bitmaps were configured.' 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconRenderer 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 java/util/List 
.const [69] = Class [141] 
.const [70] = NameAndType [142] [143] 
.const [71] = Class [144] 
.const [72] = NameAndType [145] [146] 
.const [73] = Class [147] 
.const [74] = NameAndType [148] [149] 
.const [75] = Class [150] 
.const [76] = NameAndType [151] [152] 
.const [77] = Class [153] 
.const [78] = NameAndType [154] [155] 
.const [79] = Class [156] 
.const [80] = NameAndType [157] [158] 
.const [81] = Class [159] 
.const [82] = NameAndType [160] [161] 
.const [83] = Class [162] 
.const [84] = NameAndType [163] [164] 
.const [85] = Class [165] 
.const [86] = NameAndType [166] [167] 
.const [87] = Class [168] 
.const [88] = NameAndType [169] [170] 
.const [89] = Class [171] 
.const [90] = NameAndType [172] [173] 
.const [91] = Class [174] 
.const [92] = NameAndType [175] [176] 
.const [93] = Class [177] 
.const [94] = NameAndType [178] [179] 
.const [95] = Class [180] 
.const [96] = NameAndType [181] [182] 
.const [97] = Class [183] 
.const [98] = NameAndType [184] [185] 
.const [99] = Class [186] 
.const [100] = NameAndType [187] [188] 
.const [101] = Class [189] 
.const [102] = NameAndType [190] [191] 
.const [103] = Class [192] 
.const [104] = NameAndType [193] [194] 
.const [105] = Class [195] 
.const [106] = NameAndType [196] [197] 
.const [107] = Class [198] 
.const [108] = NameAndType [199] [200] 
.const [109] = Class [201] 
.const [110] = NameAndType [202] [203] 
.const [111] = Class [204] 
.const [112] = NameAndType [205] [206] 
.const [113] = Class [207] 
.const [114] = NameAndType [208] [209] 
.const [115] = Class [210] 
.const [116] = NameAndType [211] [212] 
.const [117] = Class [213] 
.const [118] = NameAndType [214] [215] 
.const [119] = Class [216] 
.const [120] = NameAndType [217] [218] 
.const [121] = Class [219] 
.const [122] = NameAndType [220] [221] 
.const [123] = Class [222] 
.const [124] = NameAndType [223] [224] 
.const [125] = Class [225] 
.const [126] = NameAndType [226] [227] 
.const [127] = Utf8 java/lang/IllegalStateException 
.const [128] = Class [228] 
.const [129] = NameAndType [229] [230] 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [132] = Class [231] 
.const [133] = NameAndType [232] [233] 
.const [134] = Class [234] 
.const [135] = NameAndType [235] [236] 
.const [136] = Class [237] 
.const [137] = NameAndType [238] [239] 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [139] = Utf8 menuItemLogCh 
.const [140] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [142] = Utf8 isSetUp 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [145] = Utf8 auto 
.const [146] = Utf8 Z 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [148] = Utf8 parentMenu 
.const [149] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController; 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [151] = Utf8 parent 
.const [152] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractWidget; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 append 
.const [155] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 append 
.const [158] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 toString 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [163] = Utf8 getBitmapIndices 
.const [164] = Utf8 ()[I 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [166] = Utf8 createIconRenderer 
.const [167] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController;)Lde/esolutions/hmi/widgets/audi/evo/widgets/IconRenderer; 
.const [168] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [169] = Utf8 setRenderer 
.const [170] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/IconRenderer;)V 
.const [171] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [172] = Utf8 setBitmaps 
.const [173] = Utf8 ([I)V 
.const [174] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [175] = Utf8 setPredecessor 
.const [176] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)V 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [178] = Utf8 setSuccessor 
.const [179] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)V 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [181] = Utf8 getX 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [184] = Utf8 setX 
.const [185] = Utf8 (I)V 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController 
.const [187] = Utf8 add 
.const [188] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;I)V 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;)Z 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController 
.const [193] = Utf8 getChildren 
.const [194] = Utf8 ()Ljava/util/List; 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController 
.const [196] = Utf8 isMenuItem 
.const [197] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)Z 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [199] = Utf8 getRenderer 
.const [200] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [202] = Utf8 <init> 
.const [203] = Utf8 ()V 
.const [204] = Utf8 java/lang/IllegalStateException 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Ljava/lang/String;)V 
.const [207] = Utf8 java/lang/StringBuffer 
.const [208] = Utf8 <init> 
.const [209] = Utf8 ()V 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [211] = Utf8 addSeparator 
.const [212] = Utf8 (ILde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController;Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController; 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController 
.const [214] = Utf8 <init> 
.const [215] = Utf8 ()V 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [217] = Utf8 connected 
.const [218] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/InitializationContext;)V 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [220] = Utf8 setUpWidget 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [223] = Utf8 isSetUp 
.const [224] = Utf8 Z 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [226] = Utf8 auto 
.const [227] = Utf8 Z 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [229] = Utf8 parentMenu 
.const [230] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController; 
.const [231] = Utf8 java/util/List 
.const [232] = Utf8 size 
.const [233] = Utf8 ()I 
.const [234] = Utf8 java/util/List 
.const [235] = Utf8 get 
.const [236] = Utf8 (I)Ljava/lang/Object; 
.const [237] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconRenderer 
.const [238] = Utf8 setAlignment 
.const [239] = Utf8 (II)V 
.const [240] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLines 
.const [241] = Class [240] 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [243] = Class [242] 
.const [244] = Utf8 parentMenu 
.const [245] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController; 
.const [246] = Utf8 isSetUp 
.const [247] = Utf8 Z 
.const [248] = Utf8 auto 
.const [249] = Utf8 Z 
.const [250] = Utf8 Code 
.const [251] = Utf8 <init> 
.const [252] = Utf8 ()V 
.const [253] = Utf8 isAuto 
.const [254] = Utf8 ()Z 
.const [255] = Utf8 setManual 
.const [256] = Utf8 ()V 
.const [257] = Utf8 addSeparator 
.const [258] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController; 
.const [259] = Utf8 addSeparator 
.const [260] = Utf8 (ILde/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuController;Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController; 
.const [261] = Utf8 connected 
.const [262] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/InitializationContext;)V 
.const [263] = Utf8 createIconRenderer 
.const [264] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/menu/SeparatingLineController;)Lde/esolutions/hmi/widgets/audi/evo/widgets/IconRenderer; 
.const [265] = Utf8 getRenderer 
.const [266] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [267] = Utf8 setUpWidget 
.const [268] = Utf8 ()V 
.end class 
