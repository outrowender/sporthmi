.version 50 0 
.class super [87] 
.super [89] 
.implements [91] 
.implements [93] 
.field private static final [94] [95] 
.field private final transient [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 4 locals 2 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_3 
L5:     aload_2 
L6:     checkcast [2] 
L9:     astore 4 
L11:    aload_3 
L12:    getfield [11] 
L15:    invokestatic [3] 
L18:    ifne L40 
L21:    aload 4 
L23:    getfield [11] 
L26:    invokestatic [3] 
L29:    ifne L40 
L32:    aload_0 
L33:    aload_3 
L34:    aload 4 
L36:    invokespecial [18] 
L39:    areturn 
L40:    aload_3 
L41:    getfield [11] 
L44:    invokestatic [3] 
L47:    ifne L52 
L50:    iconst_m1 
L51:    areturn 
L52:    aload 4 
L54:    getfield [11] 
L57:    invokestatic [3] 
L60:    ifne L65 
L63:    iconst_1 
L64:    areturn 
L65:    aload_3 
L66:    getfield [12] 
L69:    aload 4 
L71:    getfield [12] 
L74:    lsub 
L75:    l2i 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [103] : [104] 
    .attribute [98] .code stack 4 locals 2 
L0:     aload_1 
L1:     invokevirtual [13] 
L4:     ifeq L36 
L7:     aload_2 
L8:     invokevirtual [13] 
L11:    ifeq L36 
L14:    aload_1 
L15:    getfield [14] 
L18:    invokestatic [4] 
L21:    istore_3 
L22:    aload_2 
L23:    getfield [14] 
L26:    invokestatic [4] 
L29:    istore 4 
L31:    iload_3 
L32:    iload 4 
L34:    isub 
L35:    areturn 
L36:    aload_1 
L37:    invokevirtual [13] 
L40:    ifeq L45 
L43:    iconst_1 
L44:    areturn 
L45:    aload_2 
L46:    invokevirtual [13] 
L49:    ifeq L54 
L52:    iconst_m1 
L53:    areturn 
L54:    aload_0 
L55:    getfield [10] 
L58:    invokevirtual [15] 
L61:    aload_1 
L62:    getfield [11] 
L65:    aload_2 
L66:    getfield [11] 
L69:    invokevirtual [16] 
L72:    istore_3 
L73:    iload_3 
L74:    ifeq L79 
L77:    iload_3 
L78:    areturn 
L79:    aload_1 
L80:    getfield [14] 
L83:    aload_2 
L84:    getfield [14] 
L87:    isub 
L88:    istore 4 
L90:    iload 4 
L92:    ifeq L98 
L95:    iload 4 
L97:    areturn 
L98:    aload_1 
L99:    getfield [12] 
L102:   aload_2 
L103:   getfield [12] 
L106:   lsub 
L107:   l2i 
L108:   areturn 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Method [21] [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Field [30] [31] 
.const [11] = Field [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [21] = Class [50] 
.const [22] = NameAndType [51] [52] 
.const [23] = Class [53] 
.const [24] = NameAndType [54] [55] 
.const [25] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoAlphabetically 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 de/audi/tuner/app/Utilities 
.const [28] = Utf8 de/audi/tuner/app/LanguageManager 
.const [29] = Utf8 java/text/Collator 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Class [68] 
.const [39] = NameAndType [69] [70] 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Utf8 de/audi/tuner/app/Utilities 
.const [51] = Utf8 isEmpty 
.const [52] = Utf8 (Ljava/lang/String;)Z 
.const [53] = Utf8 de/audi/tuner/app/Utilities 
.const [54] = Utf8 convertPi 
.const [55] = Utf8 (I)I 
.const [56] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoAlphabetically 
.const [57] = Utf8 langMngr 
.const [58] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [59] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [60] = Utf8 name 
.const [61] = Utf8 Ljava/lang/String; 
.const [62] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [63] = Utf8 frequency 
.const [64] = Utf8 J 
.const [65] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [66] = Utf8 isScroller 
.const [67] = Utf8 ()Z 
.const [68] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [69] = Utf8 pi 
.const [70] = Utf8 I 
.const [71] = Utf8 de/audi/tuner/app/LanguageManager 
.const [72] = Utf8 getCollator 
.const [73] = Utf8 ()Ljava/text/Collator; 
.const [74] = Utf8 java/text/Collator 
.const [75] = Utf8 compare 
.const [76] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoAlphabetically 
.const [81] = Utf8 compareByRDS 
.const [82] = Utf8 (Lde/audi/tuner/app/amfm/AMFMStation;Lde/audi/tuner/app/amfm/AMFMStation;)I 
.const [83] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoAlphabetically 
.const [84] = Utf8 langMngr 
.const [85] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [86] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoAlphabetically 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 java/util/Comparator 
.const [91] = Class [90] 
.const [92] = Utf8 java/io/Serializable 
.const [93] = Class [92] 
.const [94] = Utf8 serialVersionUID 
.const [95] = Utf8 J 
.const [96] = Utf8 langMngr 
.const [97] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [101] = Utf8 compare 
.const [102] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [103] = Utf8 compareByRDS 
.const [104] = Utf8 (Lde/audi/tuner/app/amfm/AMFMStation;Lde/audi/tuner/app/amfm/AMFMStation;)I 
.end class 
