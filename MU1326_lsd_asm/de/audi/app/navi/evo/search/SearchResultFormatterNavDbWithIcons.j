.version 50 0 
.class public super [135] 
.super [137] 
.field private static final [138] [139] 
.field private static final [140] [141] 
.field protected [142] [143] 
.field protected [144] [145] 
.field protected [146] [147] 
.field protected [148] [149] 
.field protected [150] [151] 

.method public [153] : [154] 
    .attribute [152] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     aload 5 
L8:     invokespecial [17] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [21] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [22] 
L21:    aload_0 
L22:    aload 6 
L24:    putfield [23] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [152] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [18] 
L5:     astore_2 
L6:     aload_0 
L7:     getfield [11] 
L10:    ifnull L19 
L13:    aload_0 
L14:    aload_2 
L15:    aload_1 
L16:    invokespecial [19] 
L19:    aload_2 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [157] : [158] 
    .attribute [152] .code stack 3 locals 1 
L0:     invokestatic [2] 
L3:     ifeq L23 
L6:     aload_1 
L7:     bipush 7 
L9:     iconst_0 
L10:    invokevirtual [12] 
L13:    pop 
L14:    aload_1 
L15:    bipush 8 
L17:    iconst_0 
L18:    invokevirtual [12] 
L21:    pop 
L22:    return 
L23:    aload_2 
L24:    getfield [13] 
L27:    iconst_2 
L28:    if_icmpne L46 
L31:    aload_2 
L32:    getfield [13] 
L35:    iconst_2 
L36:    if_icmpne L63 
L39:    aload_2 
L40:    getfield [14] 
L43:    ifne L63 
L46:    aload_1 
L47:    bipush 7 
L49:    iconst_0 
L50:    invokevirtual [12] 
L53:    pop 
L54:    aload_1 
L55:    bipush 8 
L57:    iconst_0 
L58:    invokevirtual [12] 
L61:    pop 
L62:    return 
L63:    aload_0 
L64:    aload_0 
L65:    getfield [11] 
L68:    invokeinterface [24] 0 
L73:    invokespecial [20] 
L76:    astore_3 
L77:    aload_0 
L78:    aload_3 
L79:    iconst_0 
L80:    iaload 
L81:    putfield [21] 
L84:    aload_0 
L85:    aload_3 
L86:    iconst_1 
L87:    iaload 
L88:    putfield [25] 
L91:    aload_0 
L92:    aload_0 
L93:    getfield [11] 
L96:    invokeinterface [26] 0 
L101:   invokespecial [20] 
L104:   astore_3 
L105:   aload_0 
L106:   aload_3 
L107:   iconst_0 
L108:   iaload 
L109:   putfield [22] 
L112:   aload_0 
L113:   aload_3 
L114:   iconst_1 
L115:   iaload 
L116:   putfield [27] 
L119:   aload_2 
L120:   getfield [14] 
L123:   aload_0 
L124:   getfield [15] 
L127:   iand 
L128:   ifne L145 
L131:   aload_1 
L132:   bipush 7 
L134:   aload_0 
L135:   getfield [9] 
L138:   invokevirtual [12] 
L141:   pop 
L142:   goto L153 
L145:   aload_1 
L146:   bipush 7 
L148:   iconst_0 
L149:   invokevirtual [12] 
L152:   pop 
L153:   aload_2 
L154:   getfield [14] 
L157:   aload_0 
L158:   getfield [16] 
L161:   iand 
L162:   ifne L179 
L165:   aload_1 
L166:   bipush 8 
L168:   aload_0 
L169:   getfield [10] 
L172:   invokevirtual [12] 
L175:   pop 
L176:   goto L187 
L179:   aload_1 
L180:   bipush 8 
L182:   iconst_0 
L183:   invokevirtual [12] 
L186:   pop 
L187:   return 
L188:   
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [152] .code stack 3 locals 1 
L0:     iconst_2 
L1:     newarray int 
L3:     astore_2 
L4:     iload_1 
L5:     tableswitch 3 
            L48 
            L104 
            L104 
            L62 
            L70 
            L81 
            L93 
            default : L104 

L48:    aload_2 
L49:    iconst_0 
L50:    bipush 8 
L52:    iastore 
L53:    aload_2 
L54:    iconst_1 
L55:    sipush 128 
L58:    iastore 
L59:    goto L112 
L62:    aload_2 
L63:    iconst_0 
L64:    iconst_2 
L65:    iastore 
L66:    aload_2 
L67:    iconst_1 
L68:    iconst_2 
L69:    iastore 
L70:    aload_2 
L71:    iconst_0 
L72:    iconst_1 
L73:    iastore 
L74:    aload_2 
L75:    iconst_1 
L76:    iconst_1 
L77:    iastore 
L78:    goto L112 
L81:    aload_2 
L82:    iconst_0 
L83:    iconst_4 
L84:    iastore 
L85:    aload_2 
L86:    iconst_1 
L87:    bipush 8 
L89:    iastore 
L90:    goto L112 
L93:    aload_2 
L94:    iconst_0 
L95:    iconst_3 
L96:    iastore 
L97:    aload_2 
L98:    iconst_1 
L99:    iconst_4 
L100:   iastore 
L101:   goto L112 
L104:   aload_2 
L105:   iconst_0 
L106:   iconst_0 
L107:   iastore 
L108:   aload_2 
L109:   iconst_1 
L110:   iconst_m1 
L111:   iastore 
L112:   aload_2 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Field [36] [37] 
.const [10] = Field [38] [39] 
.const [11] = Field [40] [41] 
.const [12] = Method [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = InterfaceMethod [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = InterfaceMethod [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = Class [74] 
.const [29] = NameAndType [75] [76] 
.const [30] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [31] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDb 
.const [32] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [33] = Utf8 de/audi/atip/search/util/SearchResultListRow 
.const [34] = Utf8 org/dsi/ifc/search/SearchResult 
.const [35] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [36] = Class [77] 
.const [37] = NameAndType [78] [79] 
.const [38] = Class [80] 
.const [39] = NameAndType [81] [82] 
.const [40] = Class [83] 
.const [41] = NameAndType [84] [85] 
.const [42] = Class [86] 
.const [43] = NameAndType [87] [88] 
.const [44] = Class [89] 
.const [45] = NameAndType [90] [91] 
.const [46] = Class [92] 
.const [47] = NameAndType [93] [94] 
.const [48] = Class [95] 
.const [49] = NameAndType [96] [97] 
.const [50] = Class [98] 
.const [51] = NameAndType [99] [100] 
.const [52] = Class [101] 
.const [53] = NameAndType [102] [103] 
.const [54] = Class [104] 
.const [55] = NameAndType [105] [106] 
.const [56] = Class [107] 
.const [57] = NameAndType [108] [109] 
.const [58] = Class [110] 
.const [59] = NameAndType [111] [112] 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [75] = Utf8 isHURegionAsia 
.const [76] = Utf8 ()Z 
.const [77] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [78] = Utf8 primaryFueltypeId 
.const [79] = Utf8 I 
.const [80] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [81] = Utf8 secondaryFueltypeId 
.const [82] = Utf8 I 
.const [83] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [84] = Utf8 carKombiService 
.const [85] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [86] = Utf8 de/audi/atip/search/util/SearchResultListRow 
.const [87] = Utf8 setInteger 
.const [88] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [89] = Utf8 org/dsi/ifc/search/SearchResult 
.const [90] = Utf8 entryType 
.const [91] = Utf8 I 
.const [92] = Utf8 org/dsi/ifc/search/SearchResult 
.const [93] = Utf8 entryFlags 
.const [94] = Utf8 I 
.const [95] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [96] = Utf8 primaryFueltypeMask 
.const [97] = Utf8 I 
.const [98] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [99] = Utf8 secondaryFueltypeMask 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDb 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/tghu/navi/app/InterAppService;Lde/audi/tghu/navi/app/IconHandler;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/favorite/INaviFavoriteHandler;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [104] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDb 
.const [105] = Utf8 formatResult 
.const [106] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [107] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [108] = Utf8 handleAdditionalIcons 
.const [109] = Utf8 (Lde/audi/atip/search/util/SearchResultListRow;Lorg/dsi/ifc/search/SearchResult;)V 
.const [110] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [111] = Utf8 getIdAndMask 
.const [112] = Utf8 (I)[I 
.const [113] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [114] = Utf8 primaryFueltypeId 
.const [115] = Utf8 I 
.const [116] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [117] = Utf8 secondaryFueltypeId 
.const [118] = Utf8 I 
.const [119] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [120] = Utf8 carKombiService 
.const [121] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [122] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [123] = Utf8 getEngineTypePrimary 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [126] = Utf8 primaryFueltypeMask 
.const [127] = Utf8 I 
.const [128] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [129] = Utf8 getEngineTypeSecondary 
.const [130] = Utf8 ()I 
.const [131] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [132] = Utf8 secondaryFueltypeMask 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDbWithIcons 
.const [135] = Class [134] 
.const [136] = Utf8 de/audi/app/navi/evo/search/SearchResultFormatterNavDb 
.const [137] = Class [136] 
.const [138] = Utf8 SEARCHRESULT_MASK_FULL 
.const [139] = Utf8 I 
.const [140] = Utf8 MISSING 
.const [141] = Utf8 I 
.const [142] = Utf8 carKombiService 
.const [143] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [144] = Utf8 primaryFueltypeId 
.const [145] = Utf8 I 
.const [146] = Utf8 primaryFueltypeMask 
.const [147] = Utf8 I 
.const [148] = Utf8 secondaryFueltypeId 
.const [149] = Utf8 I 
.const [150] = Utf8 secondaryFueltypeMask 
.const [151] = Utf8 I 
.const [152] = Utf8 Code 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/audi/tghu/navi/app/InterAppService;Lde/audi/tghu/navi/app/IconHandler;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/favorite/INaviFavoriteHandler;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/car/kombi/ICarKombiService;)V 
.const [155] = Utf8 formatResult 
.const [156] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [157] = Utf8 handleAdditionalIcons 
.const [158] = Utf8 (Lde/audi/atip/search/util/SearchResultListRow;Lorg/dsi/ifc/search/SearchResult;)V 
.const [159] = Utf8 getIdAndMask 
.const [160] = Utf8 (I)[I 
.end class 
