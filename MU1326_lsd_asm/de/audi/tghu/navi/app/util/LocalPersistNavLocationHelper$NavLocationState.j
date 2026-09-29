.version 50 0 
.class public super [76] 
.super [78] 
.field public static final [79] [80] 
.field private [81] [82] 

.method public [84] : [85] 
    .attribute [83] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     iload_3 
L7:     aload_2 
L8:     invokespecial [17] 
L11:    aload_0 
L12:    iconst_1 
L13:    newarray byte 
L15:    dup 
L16:    iconst_0 
L17:    iconst_0 
L18:    bastore 
L19:    putfield [18] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [86] : [87] 
    .attribute [83] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     newarray byte 
L4:     putfield [18] 
L7:     aload_0 
L8:     getfield [11] 
L11:    iconst_0 
L12:    iconst_0 
L13:    bastore 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [88] : [89] 
    .attribute [83] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [13] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [90] : [91] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_1 
L5:     invokestatic [4] 
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
L2:     invokestatic [5] 
L5:     putfield [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [94] : [95] 
    .attribute [83] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [14] 
        .catch [6] from L4 to L16 using L19 
L4:     iload_1 
L5:     ifle L16 
L8:     aload_0 
L9:     aload_3 
L10:    invokestatic [5] 
L13:    putfield [18] 
L16:    goto L36 
L19:    astore 4 
L21:    aload_0 
L22:    invokevirtual [15] 
L25:    sipush 10000 
L28:    ldc [7] 
L30:    aload 4 
L32:    invokevirtual [16] 
L35:    pop 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
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
L1:     aload_1 
L2:     putfield [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [19] 
.const [4] = Method [20] [21] 
.const [5] = Method [22] [23] 
.const [6] = Class [24] 
.const [7] = String [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Field [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Field [43] [44] 
.const [19] = Utf8 'NavLocationState#initFromOldKeys' 
.const [20] = Class [45] 
.const [21] = NameAndType [46] [47] 
.const [22] = Class [48] 
.const [23] = NameAndType [49] [50] 
.const [24] = Utf8 java/io/IOException 
.const [25] = Utf8 'LocalPersistNavLocationHelper.NavLocationState#convertContainer - error on converting the persistent state format' 
.const [26] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [27] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [46] = Utf8 serializeByteArray 
.const [47] = Utf8 ([BLjava/io/DataOutputStream;)V 
.const [48] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [49] = Utf8 deserializeByteArray 
.const [50] = Utf8 (Ljava/io/DataInputStream;)[B 
.const [51] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [52] = Utf8 serializedNavLocation 
.const [53] = Utf8 [B 
.const [54] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [55] = Utf8 logChannel 
.const [56] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Utf8 log 
.const [59] = Utf8 (ILjava/lang/String;)Z 
.const [60] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [61] = Utf8 initWithDefaultValues 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [64] = Utf8 getLogChannel 
.const [65] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 log 
.const [68] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [69] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [72] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [73] = Utf8 serializedNavLocation 
.const [74] = Utf8 [B 
.const [75] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [78] = Class [77] 
.const [79] = Utf8 VERSION 
.const [80] = Utf8 I 
.const [81] = Utf8 serializedNavLocation 
.const [82] = Utf8 [B 
.const [83] = Utf8 Code 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;I)V 
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
.const [96] = Utf8 getNavLocation 
.const [97] = Utf8 ()[B 
.const [98] = Utf8 setNavLocation 
.const [99] = Utf8 ([B)V 
.end class 
