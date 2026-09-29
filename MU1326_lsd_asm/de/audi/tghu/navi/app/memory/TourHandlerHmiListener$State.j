.version 50 0 
.class public super [74] 
.super [76] 
.field private static final [77] [78] 
.field private static final [79] [80] 
.field private [81] [82] 

.method public [84] : [85] 
    .attribute [83] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 943 
L9:     aload_2 
L10:    invokespecial [18] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [86] : [87] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected enum [88] : [89] 
    .attribute [83] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [90] : [91] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [11] 
L5:     invokevirtual [12] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [92] : [93] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [13] 
L5:     putfield [19] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [94] : [95] 
    .attribute [83] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [15] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [16] 
        .catch [4] from L20 to L32 using L35 
L20:    iload_1 
L21:    ifle L32 
L24:    aload_0 
L25:    aload_3 
L26:    invokevirtual [13] 
L29:    putfield [19] 
L32:    goto L52 
L35:    astore 4 
L37:    aload_0 
L38:    getfield [14] 
L41:    sipush 10000 
L44:    ldc [5] 
L46:    aload 4 
L48:    invokevirtual [17] 
L51:    pop 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public interface [96] : [97] 
    .attribute [83] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [20] 
.const [4] = Class [21] 
.const [5] = String [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Field [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Method [38] [39] 
.const [17] = Method [40] [41] 
.const [18] = Method [42] [43] 
.const [19] = Field [44] [45] 
.const [20] = Utf8 'TourHandlerHmiListener.State#convertContainer( %1, %2 )' 
.const [21] = Utf8 java/io/IOException 
.const [22] = Utf8 'TourHandlerHmiListener.State#convertContainer - error on converting the persistent state format' 
.const [23] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [24] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [25] = Utf8 java/io/DataOutputStream 
.const [26] = Utf8 java/io/DataInputStream 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [47] = Utf8 offrDisclaimerPersistence 
.const [48] = Utf8 I 
.const [49] = Utf8 java/io/DataOutputStream 
.const [50] = Utf8 writeInt 
.const [51] = Utf8 (I)V 
.const [52] = Utf8 java/io/DataInputStream 
.const [53] = Utf8 readInt 
.const [54] = Utf8 ()I 
.const [55] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [56] = Utf8 logChannel 
.const [57] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 log 
.const [60] = Utf8 (ILjava/lang/String;JJ)Z 
.const [61] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [62] = Utf8 initWithDefaultValues 
.const [63] = Utf8 ()V 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 log 
.const [66] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [67] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [68] = Utf8 <init> 
.const [69] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [70] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [71] = Utf8 offrDisclaimerPersistence 
.const [72] = Utf8 I 
.const [73] = Utf8 de/audi/tghu/navi/app/memory/TourHandlerHmiListener$State 
.const [74] = Class [73] 
.const [75] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [76] = Class [75] 
.const [77] = Utf8 VERSION 
.const [78] = Utf8 I 
.const [79] = Utf8 KEY 
.const [80] = Utf8 I 
.const [81] = Utf8 offrDisclaimerPersistence 
.const [82] = Utf8 I 
.const [83] = Utf8 Code 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [86] = Utf8 initWithDefaultValues 
.const [87] = Utf8 ()V 
.const [88] = Utf8 initFromOldKeys 
.const [89] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [90] = Utf8 serialize 
.const [91] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [92] = Utf8 deserialize 
.const [93] = Utf8 (Ljava/io/DataInputStream;)V 
.const [94] = Utf8 convertContainer 
.const [95] = Utf8 (IILjava/io/DataInputStream;)V 
.const [96] = Utf8 getOffrDisclaimerPersistence 
.const [97] = Utf8 ()I 
.const [98] = Utf8 setOffrDisclaimerPersistence 
.const [99] = Utf8 (I)V 
.end class 
