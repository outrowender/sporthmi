.version 50 0 
.class public super [94] 
.super [96] 
.field public static final [97] [98] 
.field public static final [99] [100] 
.field private [101] [102] 

.method public [104] : [105] 
    .attribute [103] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 890 
L9:     aload_2 
L10:    invokespecial [23] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [106] : [107] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     putfield [24] 
L6:     invokestatic [3] 
L9:     ifeq L18 
L12:    aload_0 
L13:    ldc [4] 
L15:    putfield [24] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [108] : [109] 
    .attribute [103] .code stack 5 locals 1 
L0:     ldc [2] 
L2:     astore_2 
L3:     invokestatic [3] 
L6:     ifeq L12 
L9:     ldc [4] 
L11:    astore_2 
L12:    aload_0 
L13:    aload_1 
L14:    sipush 1004 
L17:    sipush 800 
L20:    aload_2 
L21:    invokeinterface [25] 0 
L26:    putfield [24] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [110] : [111] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     invokevirtual [17] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [112] : [113] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [18] 
L5:     putfield [24] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [114] : [115] 
    .attribute [103] .code stack 7 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [20] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [21] 
        .catch [7] from L20 to L32 using L35 
L20:    iload_1 
L21:    ifle L32 
L24:    aload_0 
L25:    aload_3 
L26:    invokevirtual [18] 
L29:    putfield [24] 
L32:    goto L52 
L35:    astore 4 
L37:    aload_0 
L38:    invokevirtual [19] 
L41:    sipush 10000 
L44:    ldc [8] 
L46:    aload 4 
L48:    invokevirtual [22] 
L51:    pop 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public interface [116] : [117] 
    .attribute [103] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [103] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [26] 
.const [3] = Method [27] [28] 
.const [4] = String [29] 
.const [5] = Int -2137614336 
.const [6] = String [30] 
.const [7] = Class [31] 
.const [8] = String [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Class [39] 
.const [16] = Field [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Method [52] [53] 
.const [23] = Method [54] [55] 
.const [24] = Field [56] [57] 
.const [25] = InterfaceMethod [58] [59] 
.const [26] = Utf8 Google 
.const [27] = Class [60] 
.const [28] = NameAndType [61] [62] 
.const [29] = Utf8 AutoNavi 
.const [30] = Utf8 'OnlineSearchService.State#convertContainer( %1, %2 )' 
.const [31] = Utf8 java/io/IOException 
.const [32] = Utf8 'OnlineSearchService.State#convertContainer - error on converting the persistent state format' 
.const [33] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [34] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [35] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [36] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [37] = Utf8 java/io/DataOutputStream 
.const [38] = Utf8 java/io/DataInputStream 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Class [63] 
.const [41] = NameAndType [64] [65] 
.const [42] = Class [66] 
.const [43] = NameAndType [67] [68] 
.const [44] = Class [69] 
.const [45] = NameAndType [70] [71] 
.const [46] = Class [72] 
.const [47] = NameAndType [73] [74] 
.const [48] = Class [75] 
.const [49] = NameAndType [76] [77] 
.const [50] = Class [78] 
.const [51] = NameAndType [79] [80] 
.const [52] = Class [81] 
.const [53] = NameAndType [82] [83] 
.const [54] = Class [84] 
.const [55] = NameAndType [85] [86] 
.const [56] = Class [87] 
.const [57] = NameAndType [88] [89] 
.const [58] = Class [90] 
.const [59] = NameAndType [91] [92] 
.const [60] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [61] = Utf8 isHURegionCN 
.const [62] = Utf8 ()Z 
.const [63] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [64] = Utf8 poiOnlineProvider 
.const [65] = Utf8 Ljava/lang/String; 
.const [66] = Utf8 java/io/DataOutputStream 
.const [67] = Utf8 writeUTF 
.const [68] = Utf8 (Ljava/lang/String;)V 
.const [69] = Utf8 java/io/DataInputStream 
.const [70] = Utf8 readUTF 
.const [71] = Utf8 ()Ljava/lang/String; 
.const [72] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [73] = Utf8 getLogChannel 
.const [74] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 log 
.const [77] = Utf8 (ILjava/lang/String;JJ)Z 
.const [78] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [79] = Utf8 initWithDefaultValues 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 log 
.const [83] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [84] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [87] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [88] = Utf8 poiOnlineProvider 
.const [89] = Utf8 Ljava/lang/String; 
.const [90] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [91] = Utf8 getString 
.const [92] = Utf8 (IILjava/lang/String;)Ljava/lang/String; 
.const [93] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchProviderHandler$State 
.const [94] = Class [93] 
.const [95] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [96] = Class [95] 
.const [97] = Utf8 VERSION 
.const [98] = Utf8 I 
.const [99] = Utf8 KEY 
.const [100] = Utf8 I 
.const [101] = Utf8 poiOnlineProvider 
.const [102] = Utf8 Ljava/lang/String; 
.const [103] = Utf8 Code 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [106] = Utf8 initWithDefaultValues 
.const [107] = Utf8 ()V 
.const [108] = Utf8 initFromOldKeys 
.const [109] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [110] = Utf8 serialize 
.const [111] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [112] = Utf8 deserialize 
.const [113] = Utf8 (Ljava/io/DataInputStream;)V 
.const [114] = Utf8 convertContainer 
.const [115] = Utf8 (IILjava/io/DataInputStream;)V 
.const [116] = Utf8 getPoiOnlineProvider 
.const [117] = Utf8 ()Ljava/lang/String; 
.const [118] = Utf8 setPoiOnlineProvider 
.const [119] = Utf8 (Ljava/lang/String;)V 
.end class 
