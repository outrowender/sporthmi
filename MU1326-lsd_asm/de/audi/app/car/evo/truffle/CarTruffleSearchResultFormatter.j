.version 50 0 
.class public super [146] 
.super [148] 
.field private final [149] [150] 

.method protected [152] : [153] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [151] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [18] 
L12:    pop 
L13:    new [34] 
L16:    dup 
L17:    aload_1 
L18:    invokespecial [30] 
L21:    astore_2 
L22:    aload_1 
L23:    invokevirtual [19] 
L26:    astore_3 
L27:    aload_3 
L28:    iconst_5 
L29:    invokestatic [5] 
L32:    astore 4 
L34:    aload_3 
L35:    bipush 22 
L37:    invokestatic [5] 
L40:    astore 5 
L42:    aload_3 
L43:    bipush 23 
L45:    invokestatic [5] 
L48:    astore 6 
L50:    aload 6 
L52:    ifnull L85 
L55:    aload 6 
L57:    invokevirtual [20] 
L60:    ifnull L85 
L63:    aload 6 
L65:    invokevirtual [20] 
L68:    arraylength 
L69:    ifle L85 
L72:    aload_2 
L73:    aload_0 
L74:    aload 6 
L76:    invokespecial [31] 
L79:    invokevirtual [21] 
L82:    goto L94 
L85:    aload_2 
L86:    aload_0 
L87:    aconst_null 
L88:    invokespecial [31] 
L91:    invokevirtual [21] 
L94:    aload_2 
L95:    aload_1 
L96:    invokevirtual [22] 
L99:    invokevirtual [23] 
L102:   aload_2 
L103:   aload_0 
L104:   aload 4 
L106:   invokespecial [31] 
L109:   invokevirtual [24] 
L112:   aload_2 
L113:   aload_0 
L114:   aload 5 
L116:   invokespecial [31] 
L119:   invokevirtual [25] 
L122:   aload_2 
L123:   areturn 
L124:   
    .end code 
.end method 

.method private [156] : [157] 
    .attribute [151] .code stack 5 locals 4 
L0:     aload_1 
L1:     ifnonnull L15 
L4:     new [35] 
L7:     dup 
L8:     ldc [7] 
L10:    aconst_null 
L11:    invokespecial [32] 
L14:    areturn 
L15:    aconst_null 
L16:    astore_2 
L17:    aload_1 
L18:    invokevirtual [20] 
L21:    arraylength 
L22:    iconst_2 
L23:    imul 
L24:    newarray int 
L26:    astore_3 
L27:    iconst_0 
L28:    istore 4 
L30:    iconst_0 
L31:    istore 5 
L33:    iload 5 
L35:    aload_1 
L36:    invokevirtual [20] 
L39:    arraylength 
L40:    if_icmpge L92 
L43:    aload_1 
L44:    invokevirtual [20] 
L47:    iload 5 
L49:    aaload 
L50:    ifnull L86 
L53:    aload_3 
L54:    iload 4 
L56:    aload_1 
L57:    invokevirtual [20] 
L60:    iload 5 
L62:    aaload 
L63:    getfield [26] 
L66:    iastore 
L67:    aload_3 
L68:    iload 4 
L70:    iconst_1 
L71:    iadd 
L72:    aload_1 
L73:    invokevirtual [20] 
L76:    iload 5 
L78:    aaload 
L79:    getfield [27] 
L82:    iastore 
L83:    iinc 4 2 
L86:    iinc 5 1 
L89:    goto L33 
L92:    iload 4 
L94:    ifeq L111 
L97:    iload 4 
L99:    newarray int 
L101:   astore_2 
L102:   aload_3 
L103:   iconst_0 
L104:   aload_2 
L105:   iconst_0 
L106:   iload 4 
L108:   invokestatic [8] 
L111:   new [35] 
L114:   dup 
L115:   aload_1 
L116:   ifnull L126 
L119:   aload_1 
L120:   invokevirtual [28] 
L123:   goto L128 
L126:   ldc [9] 
L128:   aload_2 
L129:   invokespecial [32] 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [36] 
.const [4] = Class [37] 
.const [5] = Method [38] [39] 
.const [6] = Class [40] 
.const [7] = String [41] 
.const [8] = Method [42] [43] 
.const [9] = String [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Field [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Method [82] [83] 
.const [33] = Field [84] [85] 
.const [34] = Class [86] 
.const [35] = Class [87] 
.const [36] = Utf8 "[CarTruffleSearchResultFormatter#formatResult] result='%1'" 
.const [37] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [38] = Class [88] 
.const [39] = NameAndType [89] [90] 
.const [40] = Utf8 de/audi/atip/hmi/model/TextListCellHighlightText 
.const [41] = Utf8 '' 
.const [42] = Class [91] 
.const [43] = NameAndType [92] [93] 
.const [44] = Utf8 '-' 
.const [45] = Utf8 de/audi/app/car/evo/truffle/CarTruffleSearchResultFormatter 
.const [46] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 org/dsi/ifc/search/SearchResult 
.const [49] = Utf8 org/dsi/ifc/search/Token 
.const [50] = Utf8 org/dsi/ifc/search/Highlight 
.const [51] = Utf8 java/lang/System 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [87] = Utf8 de/audi/atip/hmi/model/TextListCellHighlightText 
.const [88] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [89] = Utf8 getTokenForType 
.const [90] = Utf8 ([Lorg/dsi/ifc/search/Token;I)Lorg/dsi/ifc/search/Token; 
.const [91] = Utf8 java/lang/System 
.const [92] = Utf8 arraycopy 
.const [93] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [94] = Utf8 de/audi/app/car/evo/truffle/CarTruffleSearchResultFormatter 
.const [95] = Utf8 logChannel 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [100] = Utf8 org/dsi/ifc/search/SearchResult 
.const [101] = Utf8 getTokens 
.const [102] = Utf8 ()[Lorg/dsi/ifc/search/Token; 
.const [103] = Utf8 org/dsi/ifc/search/Token 
.const [104] = Utf8 getHighlights 
.const [105] = Utf8 ()[Lorg/dsi/ifc/search/Highlight; 
.const [106] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [107] = Utf8 setTextLine2SynonymMatch 
.const [108] = Utf8 (Lde/audi/atip/hmi/model/TextListCellHighlightText;)V 
.const [109] = Utf8 org/dsi/ifc/search/SearchResult 
.const [110] = Utf8 getEntryType 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [113] = Utf8 setID 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [116] = Utf8 setTextLine1 
.const [117] = Utf8 (Lde/audi/atip/hmi/model/TextListCellHighlightText;)V 
.const [118] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [119] = Utf8 setTextLine2 
.const [120] = Utf8 (Lde/audi/atip/hmi/model/TextListCellHighlightText;)V 
.const [121] = Utf8 org/dsi/ifc/search/Highlight 
.const [122] = Utf8 highlightStart 
.const [123] = Utf8 I 
.const [124] = Utf8 org/dsi/ifc/search/Highlight 
.const [125] = Utf8 highlightEnd 
.const [126] = Utf8 I 
.const [127] = Utf8 org/dsi/ifc/search/Token 
.const [128] = Utf8 getToken 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/audi/app/car/evo/truffle/CarSearchResultListRow 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)V 
.const [136] = Utf8 de/audi/app/car/evo/truffle/CarTruffleSearchResultFormatter 
.const [137] = Utf8 createLine 
.const [138] = Utf8 (Lorg/dsi/ifc/search/Token;)Lde/audi/atip/hmi/model/TextListCellHighlightText; 
.const [139] = Utf8 de/audi/atip/hmi/model/TextListCellHighlightText 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Ljava/lang/String;[I)V 
.const [142] = Utf8 de/audi/app/car/evo/truffle/CarTruffleSearchResultFormatter 
.const [143] = Utf8 logChannel 
.const [144] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 de/audi/app/car/evo/truffle/CarTruffleSearchResultFormatter 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [148] = Class [147] 
.const [149] = Utf8 logChannel 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 Code 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/audi/atip/log/LogChannel;I)V 
.const [154] = Utf8 formatResult 
.const [155] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [156] = Utf8 createLine 
.const [157] = Utf8 (Lorg/dsi/ifc/search/Token;)Lde/audi/atip/hmi/model/TextListCellHighlightText; 
.end class 
