.version 50 0 
.class public super [82] 
.super [84] 
.field public static final [85] [86] 
.field public static final [87] [88] 
.field private [89] [90] 

.method public [92] : [93] 
    .attribute [91] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 1042 
L9:     aload_2 
L10:    invokespecial [19] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [94] : [95] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [96] : [97] 
    .attribute [91] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     sipush 1004 
L5:     sipush 360 
L8:     iconst_0 
L9:     invokeinterface [21] 0 
L14:    putfield [20] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [98] : [99] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [12] 
L5:     invokevirtual [13] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [100] : [101] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [14] 
L5:     putfield [20] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [102] : [103] 
    .attribute [91] .code stack 7 locals 1 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [16] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [17] 
        .catch [4] from L20 to L32 using L35 
L20:    iload_1 
L21:    ifle L32 
L24:    aload_0 
L25:    aload_3 
L26:    invokevirtual [14] 
L29:    putfield [20] 
L32:    goto L52 
L35:    astore 4 
L37:    aload_0 
L38:    invokevirtual [15] 
L41:    sipush 10000 
L44:    ldc [5] 
L46:    aload 4 
L48:    invokevirtual [18] 
L51:    pop 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public interface [104] : [105] 
    .attribute [91] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [106] : [107] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = Class [23] 
.const [5] = String [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Field [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Method [45] [46] 
.const [20] = Field [47] [48] 
.const [21] = InterfaceMethod [49] [50] 
.const [22] = Utf8 'TripSettingsListener.State#convertContainer( %1, %2 )' 
.const [23] = Utf8 java/io/IOException 
.const [24] = Utf8 'TripSettingsListener.State#convertContainer - error on converting the persistent state format' 
.const [25] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [26] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [27] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [28] = Utf8 java/io/DataOutputStream 
.const [29] = Utf8 java/io/DataInputStream 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Class [72] 
.const [46] = NameAndType [73] [74] 
.const [47] = Class [75] 
.const [48] = NameAndType [76] [77] 
.const [49] = Class [78] 
.const [50] = NameAndType [79] [80] 
.const [51] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [52] = Utf8 timeMode 
.const [53] = Utf8 I 
.const [54] = Utf8 java/io/DataOutputStream 
.const [55] = Utf8 writeInt 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 java/io/DataInputStream 
.const [58] = Utf8 readInt 
.const [59] = Utf8 ()I 
.const [60] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [61] = Utf8 getLogChannel 
.const [62] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 log 
.const [65] = Utf8 (ILjava/lang/String;JJ)Z 
.const [66] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [67] = Utf8 initWithDefaultValues 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 log 
.const [71] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [72] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [75] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [76] = Utf8 timeMode 
.const [77] = Utf8 I 
.const [78] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [79] = Utf8 getInt 
.const [80] = Utf8 (III)I 
.const [81] = Utf8 de/audi/tghu/navi/app/rp/TripSettingsListener$State 
.const [82] = Class [81] 
.const [83] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [84] = Class [83] 
.const [85] = Utf8 VERSION 
.const [86] = Utf8 I 
.const [87] = Utf8 KEY 
.const [88] = Utf8 I 
.const [89] = Utf8 timeMode 
.const [90] = Utf8 I 
.const [91] = Utf8 Code 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [94] = Utf8 initWithDefaultValues 
.const [95] = Utf8 ()V 
.const [96] = Utf8 initFromOldKeys 
.const [97] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [98] = Utf8 serialize 
.const [99] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [100] = Utf8 deserialize 
.const [101] = Utf8 (Ljava/io/DataInputStream;)V 
.const [102] = Utf8 convertContainer 
.const [103] = Utf8 (IILjava/io/DataInputStream;)V 
.const [104] = Utf8 getTimeMode 
.const [105] = Utf8 ()I 
.const [106] = Utf8 setTimeMode 
.const [107] = Utf8 (I)V 
.end class 
