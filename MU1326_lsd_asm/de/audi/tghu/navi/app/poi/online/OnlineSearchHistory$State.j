.version 50 0 
.class public super [84] 
.super [86] 
.field public static final [87] [88] 
.field public static final [89] [90] 
.field private static final [91] [92] 
.field private [93] [94] 

.method public [96] : [97] 
    .attribute [95] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 880 
L9:     aload_2 
L10:    invokespecial [18] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [98] : [99] 
    .attribute [95] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     putfield [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [100] : [101] 
    .attribute [95] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     putfield [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [102] : [103] 
    .attribute [95] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [11] 
L5:     aload_1 
L6:     invokevirtual [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [104] : [105] 
    .attribute [95] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     aload_1 
L3:     invokevirtual [13] 
L6:     putfield [20] 
L9:     aload_0 
L10:    getfield [11] 
L13:    ifnonnull L23 
L16:    aload_0 
L17:    getstatic [2] 
L20:    putfield [20] 
L23:    return 
L24:    
    .end code 
.end method 

.method protected [106] : [107] 
    .attribute [95] .code stack 7 locals 1 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [15] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [16] 
        .catch [5] from L20 to L47 using L50 
L20:    iload_1 
L21:    ifle L47 
L24:    aload_0 
L25:    aload_0 
L26:    aload_3 
L27:    invokevirtual [13] 
L30:    putfield [20] 
L33:    aload_0 
L34:    getfield [11] 
L37:    ifnonnull L47 
L40:    aload_0 
L41:    getstatic [2] 
L44:    putfield [20] 
L47:    goto L67 
L50:    astore 4 
L52:    aload_0 
L53:    invokevirtual [14] 
L56:    sipush 10000 
L59:    ldc [6] 
L61:    aload 4 
L63:    invokevirtual [17] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method public interface [108] : [109] 
    .attribute [95] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [110] : [111] 
    .attribute [95] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [112] : [113] 
    .attribute [95] .code stack 1 locals 0 
L0:     iconst_0 
L1:     anewarray [7] 
L4:     putstatic [19] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [21] [22] 
.const [3] = Int -2137614336 
.const [4] = String [23] 
.const [5] = Class [24] 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Field [48] [49] 
.const [21] = Class [50] 
.const [22] = NameAndType [51] [52] 
.const [23] = Utf8 'OnlineSearchHistory.State#convertContainer( %1, %2 )' 
.const [24] = Utf8 java/io/IOException 
.const [25] = Utf8 'OnlineSearchHistory.State#convertContainer - error on converting the persistent state format' 
.const [26] = Utf8 java/lang/String 
.const [27] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [28] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [51] = Utf8 DEFAULT_HISTORY 
.const [52] = Utf8 [Ljava/lang/String; 
.const [53] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [54] = Utf8 history 
.const [55] = Utf8 [Ljava/lang/String; 
.const [56] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [57] = Utf8 serializeStringArray 
.const [58] = Utf8 ([Ljava/lang/String;Ljava/io/DataOutputStream;)V 
.const [59] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [60] = Utf8 deserializeStringArray 
.const [61] = Utf8 (Ljava/io/DataInputStream;)[Ljava/lang/String; 
.const [62] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [63] = Utf8 getLogChannel 
.const [64] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 log 
.const [67] = Utf8 (ILjava/lang/String;JJ)Z 
.const [68] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [69] = Utf8 initWithDefaultValues 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/audi/atip/log/LogChannel 
.const [72] = Utf8 log 
.const [73] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [74] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [77] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [78] = Utf8 DEFAULT_HISTORY 
.const [79] = Utf8 [Ljava/lang/String; 
.const [80] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [81] = Utf8 history 
.const [82] = Utf8 [Ljava/lang/String; 
.const [83] = Utf8 de/audi/tghu/navi/app/poi/online/OnlineSearchHistory$State 
.const [84] = Class [83] 
.const [85] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [86] = Class [85] 
.const [87] = Utf8 VERSION 
.const [88] = Utf8 I 
.const [89] = Utf8 KEY 
.const [90] = Utf8 I 
.const [91] = Utf8 DEFAULT_HISTORY 
.const [92] = Utf8 [Ljava/lang/String; 
.const [93] = Utf8 history 
.const [94] = Utf8 [Ljava/lang/String; 
.const [95] = Utf8 Code 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [98] = Utf8 initWithDefaultValues 
.const [99] = Utf8 ()V 
.const [100] = Utf8 initFromOldKeys 
.const [101] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [102] = Utf8 serialize 
.const [103] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [104] = Utf8 deserialize 
.const [105] = Utf8 (Ljava/io/DataInputStream;)V 
.const [106] = Utf8 convertContainer 
.const [107] = Utf8 (IILjava/io/DataInputStream;)V 
.const [108] = Utf8 getHistory 
.const [109] = Utf8 ()[Ljava/lang/String; 
.const [110] = Utf8 setHistory 
.const [111] = Utf8 ([Ljava/lang/String;)V 
.const [112] = Utf8 <clinit> 
.const [113] = Utf8 ()V 
.end class 
