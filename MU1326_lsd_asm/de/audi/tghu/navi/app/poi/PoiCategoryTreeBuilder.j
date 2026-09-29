.version 50 0 
.class public super [190] 
.super [192] 
.field private final [193] [194] 
.field private [195] [196] 
.field private [197] [198] 

.method public [200] : [201] 
    .attribute [199] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    new [34] 
L13:    dup 
L14:    invokespecial [30] 
L17:    putfield [35] 
L20:    aload_0 
L21:    new [36] 
L24:    dup 
L25:    invokespecial [31] 
L28:    putfield [37] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [199] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_1 
L5:     getfield [16] 
L8:     invokevirtual [17] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnull L90 
L16:    new [38] 
L19:    dup 
L20:    aload_1 
L21:    invokespecial [32] 
L24:    astore_3 
L25:    aload_2 
L26:    aload_3 
L27:    invokevirtual [18] 
L30:    aload_0 
L31:    getfield [15] 
L34:    invokevirtual [19] 
L37:    astore 4 
L39:    aload 4 
L41:    invokeinterface [39] 0 
L46:    ifeq L89 
L49:    aload 4 
L51:    invokeinterface [40] 0 
L56:    checkcast [4] 
L59:    astore 5 
L61:    aload 5 
L63:    invokevirtual [20] 
L66:    aload_3 
L67:    invokevirtual [21] 
L70:    if_icmpne L86 
L73:    aload_3 
L74:    aload 5 
L76:    invokevirtual [18] 
L79:    aload 4 
L81:    invokeinterface [41] 0 
L86:    goto L39 
L89:    return 
L90:    aload_0 
L91:    getfield [15] 
L94:    invokevirtual [19] 
L97:    astore_3 
L98:    aload_3 
L99:    invokeinterface [39] 0 
L104:   ifeq L162 
L107:   aload_3 
L108:   invokeinterface [40] 0 
L113:   checkcast [4] 
L116:   astore 4 
L118:   aload_0 
L119:   getfield [14] 
L122:   aload_1 
L123:   getfield [16] 
L126:   aload 4 
L128:   invokevirtual [22] 
L131:   astore_2 
L132:   aload_2 
L133:   ifnull L159 
L136:   aload_2 
L137:   invokevirtual [23] 
L140:   getfield [24] 
L143:   ifeq L159 
L146:   aload_2 
L147:   new [38] 
L150:   dup 
L151:   aload_1 
L152:   invokespecial [32] 
L155:   invokevirtual [18] 
L158:   return 
L159:   goto L98 
L162:   aload_0 
L163:   getfield [15] 
L166:   new [38] 
L169:   dup 
L170:   aload_1 
L171:   invokespecial [32] 
L174:   invokevirtual [25] 
L177:   pop 
L178:   return 
L179:   nop 
L180:   
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [199] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [14] 
L4:     getstatic [5] 
L7:     invokevirtual [17] 
L10:    astore_1 
L11:    aload_0 
L12:    getfield [15] 
L15:    invokevirtual [26] 
L18:    ifne L41 
L21:    aload_0 
L22:    getfield [13] 
L25:    ldc [6] 
L27:    ldc [7] 
L29:    aload_0 
L30:    getfield [15] 
L33:    invokevirtual [27] 
L36:    i2l 
L37:    invokevirtual [28] 
L40:    pop 
L41:    aload_0 
L42:    getfield [15] 
L45:    invokevirtual [19] 
L48:    astore_2 
L49:    aload_2 
L50:    invokeinterface [39] 0 
L55:    ifeq L76 
L58:    aload_2 
L59:    invokeinterface [40] 0 
L64:    checkcast [4] 
L67:    astore_3 
L68:    aload_1 
L69:    aload_3 
L70:    invokevirtual [18] 
L73:    goto L49 
L76:    aload_0 
L77:    getfield [14] 
L80:    areturn 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Class [43] 
.const [4] = Class [44] 
.const [5] = Field [45] [46] 
.const [6] = Int -1601830656 
.const [7] = String [47] 
.const [8] = Class [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = Class [51] 
.const [12] = Class [52] 
.const [13] = Field [53] [54] 
.const [14] = Field [55] [56] 
.const [15] = Field [57] [58] 
.const [16] = Field [59] [60] 
.const [17] = Method [61] [62] 
.const [18] = Method [63] [64] 
.const [19] = Method [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Method [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Field [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Class [95] 
.const [35] = Field [96] [97] 
.const [36] = Class [98] 
.const [37] = Field [99] [100] 
.const [38] = Class [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [43] = Utf8 java/util/ArrayList 
.const [44] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [45] = Class [108] 
.const [46] = NameAndType [109] [110] 
.const [47] = Utf8 'PoiCategoryTreeBuilder#build %1 where missing their correct parent and added to the root' 
.const [48] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/tghu/navi/app/map/impl/ContentListItem 
.const [51] = Utf8 java/util/Iterator 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Class [111] 
.const [54] = NameAndType [112] [113] 
.const [55] = Class [114] 
.const [56] = NameAndType [115] [116] 
.const [57] = Class [117] 
.const [58] = NameAndType [118] [119] 
.const [59] = Class [120] 
.const [60] = NameAndType [121] [122] 
.const [61] = Class [123] 
.const [62] = NameAndType [124] [125] 
.const [63] = Class [126] 
.const [64] = NameAndType [127] [128] 
.const [65] = Class [129] 
.const [66] = NameAndType [130] [131] 
.const [67] = Class [132] 
.const [68] = NameAndType [133] [134] 
.const [69] = Class [135] 
.const [70] = NameAndType [136] [137] 
.const [71] = Class [138] 
.const [72] = NameAndType [139] [140] 
.const [73] = Class [141] 
.const [74] = NameAndType [142] [143] 
.const [75] = Class [144] 
.const [76] = NameAndType [145] [146] 
.const [77] = Class [147] 
.const [78] = NameAndType [148] [149] 
.const [79] = Class [150] 
.const [80] = NameAndType [151] [152] 
.const [81] = Class [153] 
.const [82] = NameAndType [154] [155] 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Utf8 java/util/ArrayList 
.const [99] = Class [177] 
.const [100] = NameAndType [178] [179] 
.const [101] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [109] = Utf8 ROOT_ID 
.const [110] = Utf8 I 
.const [111] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [112] = Utf8 logger 
.const [113] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [115] = Utf8 categoryTree 
.const [116] = Utf8 Lde/audi/tghu/navi/app/poi/PoiCategoryTree; 
.const [117] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [118] = Utf8 freeNodes 
.const [119] = Utf8 Ljava/util/ArrayList; 
.const [120] = Utf8 de/audi/tghu/navi/app/map/impl/ContentListItem 
.const [121] = Utf8 parentId 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [124] = Utf8 getTreeNode 
.const [125] = Utf8 (I)Lde/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode; 
.const [126] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [127] = Utf8 addChild 
.const [128] = Utf8 (Lde/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode;)V 
.const [129] = Utf8 java/util/ArrayList 
.const [130] = Utf8 iterator 
.const [131] = Utf8 ()Ljava/util/Iterator; 
.const [132] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [133] = Utf8 getParentUID 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [136] = Utf8 getUID 
.const [137] = Utf8 ()I 
.const [138] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [139] = Utf8 getTreeNode 
.const [140] = Utf8 (ILde/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode;)Lde/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode; 
.const [141] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [142] = Utf8 getCategory 
.const [143] = Utf8 ()Lde/audi/tghu/navi/app/map/impl/ContentListItem; 
.const [144] = Utf8 de/audi/tghu/navi/app/map/impl/ContentListItem 
.const [145] = Utf8 isParent 
.const [146] = Utf8 Z 
.const [147] = Utf8 java/util/ArrayList 
.const [148] = Utf8 add 
.const [149] = Utf8 (Ljava/lang/Object;)Z 
.const [150] = Utf8 java/util/ArrayList 
.const [151] = Utf8 isEmpty 
.const [152] = Utf8 ()Z 
.const [153] = Utf8 java/util/ArrayList 
.const [154] = Utf8 size 
.const [155] = Utf8 ()I 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;J)Z 
.const [159] = Utf8 java/lang/Object 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 java/util/ArrayList 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTree$CategoryTreeNode 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/audi/tghu/navi/app/map/impl/ContentListItem;)V 
.const [171] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [172] = Utf8 logger 
.const [173] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [174] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [175] = Utf8 categoryTree 
.const [176] = Utf8 Lde/audi/tghu/navi/app/poi/PoiCategoryTree; 
.const [177] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [178] = Utf8 freeNodes 
.const [179] = Utf8 Ljava/util/ArrayList; 
.const [180] = Utf8 java/util/Iterator 
.const [181] = Utf8 hasNext 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 java/util/Iterator 
.const [184] = Utf8 next 
.const [185] = Utf8 ()Ljava/lang/Object; 
.const [186] = Utf8 java/util/Iterator 
.const [187] = Utf8 remove 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/tghu/navi/app/poi/PoiCategoryTreeBuilder 
.const [190] = Class [189] 
.const [191] = Utf8 java/lang/Object 
.const [192] = Class [191] 
.const [193] = Utf8 logger 
.const [194] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [195] = Utf8 categoryTree 
.const [196] = Utf8 Lde/audi/tghu/navi/app/poi/PoiCategoryTree; 
.const [197] = Utf8 freeNodes 
.const [198] = Utf8 Ljava/util/ArrayList; 
.const [199] = Utf8 Code 
.const [200] = Utf8 <init> 
.const [201] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [202] = Utf8 add 
.const [203] = Utf8 (Lde/audi/tghu/navi/app/map/impl/ContentListItem;)V 
.const [204] = Utf8 build 
.const [205] = Utf8 ()Lde/audi/tghu/navi/app/poi/PoiCategoryTree; 
.end class 
