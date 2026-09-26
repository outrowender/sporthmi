.version 50 0 
.class public super [169] 
.super [171] 
.implements [173] 
.field final [174] [175] 
.field private [176] [177] 
.field [178] [179] 
.field private [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [25] 
L14:    putfield [38] 
L17:    aload_0 
L18:    aconst_null 
L19:    putfield [39] 
L22:    aload_0 
L23:    new [40] 
L26:    dup 
L27:    iconst_5 
L28:    invokespecial [36] 
L31:    putfield [41] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnull L89 
L4:     aload_0 
L5:     getfield [26] 
L8:     ldc [3] 
L10:    ldc [4] 
L12:    aload_0 
L13:    getfield [28] 
L16:    invokevirtual [29] 
L19:    i2l 
L20:    invokevirtual [30] 
L23:    pop 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [39] 
        .catch [6] from L29 to L68 using L71 
L29:    iconst_0 
L30:    istore_2 
L31:    iload_2 
L32:    aload_0 
L33:    getfield [28] 
L36:    invokevirtual [29] 
L39:    if_icmpge L68 
L42:    aload_0 
L43:    getfield [27] 
L46:    aload_0 
L47:    getfield [28] 
L50:    iload_2 
L51:    invokevirtual [31] 
L54:    checkcast [5] 
L57:    invokeinterface [42] 0 
L62:    iinc 2 1 
L65:    goto L31 
L68:    goto L106 
L71:    astore_2 
L72:    aload_0 
L73:    getfield [26] 
L76:    sipush 10000 
L79:    ldc [7] 
L81:    aload_2 
L82:    invokevirtual [32] 
L85:    pop 
L86:    goto L106 
L89:    aload_0 
L90:    getfield [26] 
L93:    ldc [8] 
L95:    ldc [9] 
L97:    invokevirtual [33] 
L100:   pop 
L101:   aload_0 
L102:   aconst_null 
L103:   putfield [39] 
L106:   return 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifnull L55 
L7:     aload_0 
L8:     getfield [26] 
L11:    ldc [3] 
L13:    ldc [10] 
L15:    invokevirtual [33] 
L18:    pop 
        .catch [6] from L19 to L37 using L38 
L19:    aload_0 
L20:    getfield [27] 
L23:    invokeinterface [43] 0 
L28:    iconst_1 
L29:    if_icmpne L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    areturn 
L38:    astore_1 
L39:    aload_0 
L40:    getfield [26] 
L43:    sipush 10000 
L46:    ldc [11] 
L48:    aload_1 
L49:    invokevirtual [32] 
L52:    pop 
L53:    iconst_0 
L54:    areturn 
L55:    aload_0 
L56:    getfield [26] 
L59:    ldc [8] 
L61:    ldc [12] 
L63:    invokevirtual [33] 
L66:    pop 
L67:    iconst_0 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     aload_1 
L5:     invokevirtual [34] 
L8:     pop 
L9:     aload_0 
L10:    getfield [27] 
L13:    ifnull L59 
L16:    aload_0 
L17:    getfield [26] 
L20:    ldc [3] 
L22:    ldc [13] 
L24:    invokevirtual [33] 
L27:    pop 
        .catch [6] from L28 to L38 using L41 
L28:    aload_0 
L29:    getfield [27] 
L32:    aload_1 
L33:    invokeinterface [42] 0 
L38:    goto L71 
L41:    astore_2 
L42:    aload_0 
L43:    getfield [26] 
L46:    sipush 10000 
L49:    ldc [14] 
L51:    aload_2 
L52:    invokevirtual [32] 
L55:    pop 
L56:    goto L71 
L59:    aload_0 
L60:    getfield [26] 
L63:    ldc [8] 
L65:    ldc [15] 
L67:    invokevirtual [33] 
L70:    pop 
L71:    return 
L72:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [182] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifnull L50 
L7:     aload_0 
L8:     getfield [26] 
L11:    ldc [3] 
L13:    ldc [16] 
L15:    invokevirtual [33] 
L18:    pop 
        .catch [6] from L19 to L29 using L32 
L19:    aload_0 
L20:    getfield [27] 
L23:    iload_1 
L24:    invokeinterface [44] 0 
L29:    goto L62 
L32:    astore_2 
L33:    aload_0 
L34:    getfield [26] 
L37:    sipush 10000 
L40:    ldc [17] 
L42:    aload_2 
L43:    invokevirtual [32] 
L46:    pop 
L47:    goto L62 
L50:    aload_0 
L51:    getfield [26] 
L54:    ldc [8] 
L56:    ldc [18] 
L58:    invokevirtual [33] 
L61:    pop 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [182] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifnull L50 
L7:     aload_0 
L8:     getfield [26] 
L11:    ldc [3] 
L13:    ldc [19] 
L15:    invokevirtual [33] 
L18:    pop 
        .catch [6] from L19 to L29 using L32 
L19:    aload_0 
L20:    getfield [27] 
L23:    iload_1 
L24:    invokeinterface [45] 0 
L29:    goto L62 
L32:    astore_2 
L33:    aload_0 
L34:    getfield [26] 
L37:    sipush 10000 
L40:    ldc [17] 
L42:    aload_2 
L43:    invokevirtual [32] 
L46:    pop 
L47:    goto L62 
L50:    aload_0 
L51:    getfield [26] 
L54:    ldc [8] 
L56:    ldc [18] 
L58:    invokevirtual [33] 
L61:    pop 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Int -2137614336 
.const [4] = String [47] 
.const [5] = Class [48] 
.const [6] = Class [49] 
.const [7] = String [50] 
.const [8] = Int -1601830656 
.const [9] = String [51] 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = String [54] 
.const [13] = String [55] 
.const [14] = String [56] 
.const [15] = String [57] 
.const [16] = String [58] 
.const [17] = String [59] 
.const [18] = String [60] 
.const [19] = String [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Class [64] 
.const [23] = Class [65] 
.const [24] = Class [66] 
.const [25] = Method [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Method [85] [86] 
.const [35] = Method [87] [88] 
.const [36] = Method [89] [90] 
.const [37] = Field [91] [92] 
.const [38] = Field [93] [94] 
.const [39] = Field [95] [96] 
.const [40] = Class [97] 
.const [41] = Field [98] [99] 
.const [42] = InterfaceMethod [100] [101] 
.const [43] = InterfaceMethod [102] [103] 
.const [44] = InterfaceMethod [104] [105] 
.const [45] = InterfaceMethod [106] [107] 
.const [46] = Utf8 java/util/ArrayList 
.const [47] = Utf8 'ViewSizeChangeHandler#setViewSizeManager() listeners.size()=%1 ' 
.const [48] = Utf8 de/audi/atip/mmicombi/IViewSizeListener 
.const [49] = Utf8 java/lang/Exception 
.const [50] = Utf8 'ViewSizeChangeHandler#setViewSizeManager() - ERROR = %1' 
.const [51] = Utf8 'ViewSizeChangeHandler#setViewSizeManager( null )' 
.const [52] = Utf8 'ViewSizeChangeHandler#isSmallStageActive()' 
.const [53] = Utf8 'ViewSizeChangeHandler#isSmallStageActive() - ERROR = %1' 
.const [54] = Utf8 'ViewSizeChangeHandler#isSmallStageActive() - null' 
.const [55] = Utf8 'ViewSizeChangeHandler#addViewSizeChangedListener()' 
.const [56] = Utf8 'ViewSizeChangeHandler#addViewSizeChangedListener() - ERROR = %1' 
.const [57] = Utf8 'ViewSizeChangeHandler#addViewSizeChangedListener() - null' 
.const [58] = Utf8 'ViewSizeChangeHandler#requestLargeViewSize()' 
.const [59] = Utf8 'ViewSizeChangeHandler#requestViewSizeChange() - ERROR = %1' 
.const [60] = Utf8 'ViewSizeChangeHandler#requestViewSizeChange() - null' 
.const [61] = Utf8 'ViewSizeChangeHandler#unrequestLargeViewSize()' 
.const [62] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [67] = Class [108] 
.const [68] = NameAndType [109] [110] 
.const [69] = Class [111] 
.const [70] = NameAndType [112] [113] 
.const [71] = Class [114] 
.const [72] = NameAndType [115] [116] 
.const [73] = Class [117] 
.const [74] = NameAndType [118] [119] 
.const [75] = Class [120] 
.const [76] = NameAndType [121] [122] 
.const [77] = Class [123] 
.const [78] = NameAndType [124] [125] 
.const [79] = Class [126] 
.const [80] = NameAndType [127] [128] 
.const [81] = Class [129] 
.const [82] = NameAndType [130] [131] 
.const [83] = Class [132] 
.const [84] = NameAndType [133] [134] 
.const [85] = Class [135] 
.const [86] = NameAndType [136] [137] 
.const [87] = Class [138] 
.const [88] = NameAndType [139] [140] 
.const [89] = Class [141] 
.const [90] = NameAndType [142] [143] 
.const [91] = Class [144] 
.const [92] = NameAndType [145] [146] 
.const [93] = Class [147] 
.const [94] = NameAndType [148] [149] 
.const [95] = Class [150] 
.const [96] = NameAndType [151] [152] 
.const [97] = Utf8 java/util/ArrayList 
.const [98] = Class [153] 
.const [99] = NameAndType [154] [155] 
.const [100] = Class [156] 
.const [101] = NameAndType [157] [158] 
.const [102] = Class [159] 
.const [103] = NameAndType [160] [161] 
.const [104] = Class [162] 
.const [105] = NameAndType [163] [164] 
.const [106] = Class [165] 
.const [107] = NameAndType [166] [167] 
.const [108] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [109] = Utf8 getLogChannel 
.const [110] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [112] = Utf8 logChannel 
.const [113] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [115] = Utf8 viewSizeManager 
.const [116] = Utf8 Lde/audi/atip/mmicombi/IViewSizeManager; 
.const [117] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [118] = Utf8 listeners 
.const [119] = Utf8 Ljava/util/ArrayList; 
.const [120] = Utf8 java/util/ArrayList 
.const [121] = Utf8 size 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/audi/atip/log/LogChannel 
.const [124] = Utf8 log 
.const [125] = Utf8 (ILjava/lang/String;J)Z 
.const [126] = Utf8 java/util/ArrayList 
.const [127] = Utf8 get 
.const [128] = Utf8 (I)Ljava/lang/Object; 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;)Z 
.const [135] = Utf8 java/util/ArrayList 
.const [136] = Utf8 add 
.const [137] = Utf8 (Ljava/lang/Object;)Z 
.const [138] = Utf8 java/lang/Object 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 java/util/ArrayList 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [145] = Utf8 env 
.const [146] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [147] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [148] = Utf8 logChannel 
.const [149] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [150] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [151] = Utf8 viewSizeManager 
.const [152] = Utf8 Lde/audi/atip/mmicombi/IViewSizeManager; 
.const [153] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [154] = Utf8 listeners 
.const [155] = Utf8 Ljava/util/ArrayList; 
.const [156] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [157] = Utf8 addViewSizeListener 
.const [158] = Utf8 (Lde/audi/atip/mmicombi/IViewSizeListener;)V 
.const [159] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [160] = Utf8 getCurrentViewSize 
.const [161] = Utf8 ()I 
.const [162] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [163] = Utf8 requestLargeViewSize 
.const [164] = Utf8 (I)V 
.const [165] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [166] = Utf8 unrequestLargeViewSize 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 de/audi/tghu/navi/app/interapp/ViewSizeChangeHandler 
.const [169] = Class [168] 
.const [170] = Utf8 java/lang/Object 
.const [171] = Class [170] 
.const [172] = Utf8 de/audi/tghu/navi/app/interapp/IViewSizeChangeHandler 
.const [173] = Class [172] 
.const [174] = Utf8 env 
.const [175] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [176] = Utf8 listeners 
.const [177] = Utf8 Ljava/util/ArrayList; 
.const [178] = Utf8 logChannel 
.const [179] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [180] = Utf8 viewSizeManager 
.const [181] = Utf8 Lde/audi/atip/mmicombi/IViewSizeManager; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [185] = Utf8 setViewSizeManager 
.const [186] = Utf8 (Lde/audi/atip/mmicombi/IViewSizeManager;)V 
.const [187] = Utf8 isSmallStageActive 
.const [188] = Utf8 ()Z 
.const [189] = Utf8 addViewSizeChangedListener 
.const [190] = Utf8 (Lde/audi/atip/mmicombi/IViewSizeListener;)V 
.const [191] = Utf8 requestLargeViewSize 
.const [192] = Utf8 (I)V 
.const [193] = Utf8 unrequestLargeViewSize 
.const [194] = Utf8 (I)V 
.end class 
