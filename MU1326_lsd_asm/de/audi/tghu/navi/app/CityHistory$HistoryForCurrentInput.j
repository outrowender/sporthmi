.version 50 0 
.class public super [93] 
.super [95] 
.field public static final [96] [97] 
.field private final [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L33 
L7:     aload_0 
L8:     getfield [13] 
L11:    invokeinterface [20] 0 
L16:    ifne L33 
L19:    aload_0 
L20:    getfield [13] 
L23:    iconst_0 
L24:    invokeinterface [21] 0 
L29:    checkcast [2] 
L32:    areturn 
L33:    aconst_null 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [100] .code stack 6 locals 2 
L0:     aload_1 
L1:     ldc [3] 
L3:     ldc [4] 
L5:     invokevirtual [14] 
L8:     pop 
L9:     aload_0 
L10:    getfield [13] 
L13:    ifnonnull L18 
L16:    aconst_null 
L17:    areturn 
L18:    aload_0 
L19:    getfield [13] 
L22:    invokeinterface [22] 0 
L27:    anewarray [5] 
L30:    astore_3 
L31:    iconst_0 
L32:    istore 4 
L34:    iload 4 
L36:    aload_0 
L37:    getfield [13] 
L40:    invokeinterface [22] 0 
L45:    if_icmpge L83 
L48:    aload_3 
L49:    iload 4 
L51:    aload_2 
L52:    aload_0 
L53:    getfield [13] 
L56:    iload 4 
L58:    invokeinterface [21] 0 
L63:    checkcast [2] 
L66:    ldc [6] 
L68:    iload 4 
L70:    iadd 
L71:    invokeinterface [23] 0 
L76:    aastore 
L77:    iinc 4 1 
L80:    goto L34 
L83:    aload_3 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method static [107] : [108] 
    .attribute [100] .code stack 4 locals 0 
L0:     new [24] 
L3:     dup 
L4:     new [25] 
L7:     dup 
L8:     invokespecial [16] 
L11:    invokespecial [17] 
L14:    putstatic [18] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Int -2137614336 
.const [4] = String [27] 
.const [5] = Class [28] 
.const [6] = Int 1078071040 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Field [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = Class [57] 
.const [25] = Class [58] 
.const [26] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryEntry 
.const [27] = Utf8 'CityHistory#HistoryForCurrentInput#getEntriesForList' 
.const [28] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [29] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [30] = Utf8 java/util/ArrayList 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 java/util/List 
.const [33] = Utf8 de/audi/atip/log/LogChannel 
.const [34] = Utf8 de/audi/tghu/navi/app/HistoryListRowBuilder 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Class [86] 
.const [54] = NameAndType [87] [88] 
.const [55] = Class [89] 
.const [56] = NameAndType [90] [91] 
.const [57] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [58] = Utf8 java/util/ArrayList 
.const [59] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [60] = Utf8 matchingHistoryEntries 
.const [61] = Utf8 Ljava/util/List; 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 log 
.const [64] = Utf8 (ILjava/lang/String;)Z 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 java/util/ArrayList 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (Ljava/util/List;)V 
.const [74] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [75] = Utf8 NO_HISTORY 
.const [76] = Utf8 Lde/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput; 
.const [77] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [78] = Utf8 matchingHistoryEntries 
.const [79] = Utf8 Ljava/util/List; 
.const [80] = Utf8 java/util/List 
.const [81] = Utf8 isEmpty 
.const [82] = Utf8 ()Z 
.const [83] = Utf8 java/util/List 
.const [84] = Utf8 get 
.const [85] = Utf8 (I)Ljava/lang/Object; 
.const [86] = Utf8 java/util/List 
.const [87] = Utf8 size 
.const [88] = Utf8 ()I 
.const [89] = Utf8 de/audi/tghu/navi/app/HistoryListRowBuilder 
.const [90] = Utf8 buildListRow 
.const [91] = Utf8 (Lde/audi/tghu/navi/app/CityHistory$HistoryEntry;I)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [92] = Utf8 de/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput 
.const [93] = Class [92] 
.const [94] = Utf8 java/lang/Object 
.const [95] = Class [94] 
.const [96] = Utf8 NO_HISTORY 
.const [97] = Utf8 Lde/audi/tghu/navi/app/CityHistory$HistoryForCurrentInput; 
.const [98] = Utf8 matchingHistoryEntries 
.const [99] = Utf8 Ljava/util/List; 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ljava/util/List;)V 
.const [103] = Utf8 getBestMatchingEntry 
.const [104] = Utf8 ()Lde/audi/tghu/navi/app/CityHistory$HistoryEntry; 
.const [105] = Utf8 getEntriesForList 
.const [106] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/HistoryListRowBuilder;)[Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [107] = Utf8 <clinit> 
.const [108] = Utf8 ()V 
.end class 
