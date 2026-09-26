.version 50 0 
.class public super [72] 
.super [74] 
.field private [75] [76] 
.field private [77] [78] 
.field private [79] [80] 

.method public [82] : [83] 
    .attribute [81] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [81] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [12] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [17] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [86] : [87] 
    .attribute [81] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [88] : [89] 
    .attribute [81] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [12] 
L12:    pop 
L13:    aload_1 
L14:    ifnonnull L23 
L17:    aload_0 
L18:    aconst_null 
L19:    putfield [18] 
L22:    return 
L23:    aload_0 
L24:    aload_1 
L25:    arraylength 
L26:    anewarray [5] 
L29:    putfield [18] 
L32:    aload_1 
L33:    iconst_0 
L34:    aload_0 
L35:    getfield [14] 
L38:    iconst_0 
L39:    aload_1 
L40:    arraylength 
L41:    invokestatic [6] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [90] : [91] 
    .attribute [81] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [81] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [17] 
L5:     aload_0 
L6:     aconst_null 
L7:     putfield [18] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [19] 
.const [4] = String [20] 
.const [5] = Class [21] 
.const [6] = Method [22] [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Field [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Field [38] [39] 
.const [17] = Field [40] [41] 
.const [18] = Field [42] [43] 
.const [19] = Utf8 'NaviSDSTrufflesHistoryHelper#setLastTruffleSearchText: string=%1' 
.const [20] = Utf8 'NaviSDSTrufflesHistoryHelper#setLastTruffleSearchText: alternativeSearchTexts=%1' 
.const [21] = Utf8 java/lang/String 
.const [22] = Class [44] 
.const [23] = NameAndType [45] [46] 
.const [24] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Utf8 java/lang/System 
.const [28] = Class [47] 
.const [29] = NameAndType [48] [49] 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Utf8 java/lang/System 
.const [45] = Utf8 arraycopy 
.const [46] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [47] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [48] = Utf8 logger 
.const [49] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 log 
.const [52] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [53] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [54] = Utf8 lastTruffleSearchText 
.const [55] = Utf8 Ljava/lang/String; 
.const [56] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [57] = Utf8 lastTruffleAlternativeSearchTexts 
.const [58] = Utf8 [Ljava/lang/String; 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [63] = Utf8 logger 
.const [64] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [66] = Utf8 lastTruffleSearchText 
.const [67] = Utf8 Ljava/lang/String; 
.const [68] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [69] = Utf8 lastTruffleAlternativeSearchTexts 
.const [70] = Utf8 [Ljava/lang/String; 
.const [71] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSTrufflesHistoryHelper 
.const [72] = Class [71] 
.const [73] = Utf8 java/lang/Object 
.const [74] = Class [73] 
.const [75] = Utf8 lastTruffleSearchText 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 lastTruffleAlternativeSearchTexts 
.const [78] = Utf8 [Ljava/lang/String; 
.const [79] = Utf8 logger 
.const [80] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [81] = Utf8 Code 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [84] = Utf8 setLastTruffleSearchText 
.const [85] = Utf8 (Ljava/lang/String;)V 
.const [86] = Utf8 getLastTruffleSearchText 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 setLastTruffleAlternativeSearchTexts 
.const [89] = Utf8 ([Ljava/lang/String;)V 
.const [90] = Utf8 getLastTruffleAlternativeSearchTexts 
.const [91] = Utf8 ()[Ljava/lang/String; 
.const [92] = Utf8 clearLastTruffleSearchTexts 
.const [93] = Utf8 ()V 
.end class 
