.version 50 0 
.class public super [79] 
.super [81] 
.field public static final [82] [83] 
.field public static final [84] [85] 
.field private [86] [87] 

.method public [89] : [90] 
    .attribute [88] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 1041 
L9:     aload_2 
L10:    invokespecial [17] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [91] : [92] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [93] : [94] 
    .attribute [88] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     sipush 1004 
L5:     sipush 1041 
L8:     iconst_0 
L9:     invokeinterface [19] 0 
L14:    putfield [18] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [95] : [96] 
    .attribute [88] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [11] 
        .catch [2] from L4 to L13 using L16 
L4:     iload_1 
L5:     ifle L13 
L8:     aload_0 
L9:     aload_3 
L10:    invokevirtual [12] 
L13:    goto L33 
L16:    astore 4 
L18:    aload_0 
L19:    invokevirtual [13] 
L22:    sipush 10000 
L25:    ldc [3] 
L27:    aload 4 
L29:    invokevirtual [14] 
L32:    pop 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [97] : [98] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [10] 
L5:     invokevirtual [15] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [99] : [100] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [16] 
L5:     putfield [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [101] : [102] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = String [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = InterfaceMethod [46] [47] 
.const [20] = Utf8 java/io/IOException 
.const [21] = Utf8 'TrafficMiniMapState#convertContainer - error on converting the persistent state format' 
.const [22] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [23] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [24] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [25] = Utf8 de/audi/atip/log/LogChannel 
.const [26] = Utf8 java/io/DataOutputStream 
.const [27] = Utf8 java/io/DataInputStream 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [49] = Utf8 active 
.const [50] = Utf8 Z 
.const [51] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [52] = Utf8 initWithDefaultValues 
.const [53] = Utf8 ()V 
.const [54] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [55] = Utf8 deserialize 
.const [56] = Utf8 (Ljava/io/DataInputStream;)V 
.const [57] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [58] = Utf8 getLogChannel 
.const [59] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 log 
.const [62] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [63] = Utf8 java/io/DataOutputStream 
.const [64] = Utf8 writeBoolean 
.const [65] = Utf8 (Z)V 
.const [66] = Utf8 java/io/DataInputStream 
.const [67] = Utf8 readBoolean 
.const [68] = Utf8 ()Z 
.const [69] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [72] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [73] = Utf8 active 
.const [74] = Utf8 Z 
.const [75] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [76] = Utf8 getBoolean 
.const [77] = Utf8 (IIZ)Z 
.const [78] = Utf8 de/audi/app/navi/evo/map/minimap/EvoTrafficMiniMap$TrafficMiniMapState 
.const [79] = Class [78] 
.const [80] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [81] = Class [80] 
.const [82] = Utf8 VERSION 
.const [83] = Utf8 I 
.const [84] = Utf8 KEY 
.const [85] = Utf8 I 
.const [86] = Utf8 active 
.const [87] = Utf8 Z 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [91] = Utf8 initWithDefaultValues 
.const [92] = Utf8 ()V 
.const [93] = Utf8 initFromOldKeys 
.const [94] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [95] = Utf8 convertContainer 
.const [96] = Utf8 (IILjava/io/DataInputStream;)V 
.const [97] = Utf8 serialize 
.const [98] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [99] = Utf8 deserialize 
.const [100] = Utf8 (Ljava/io/DataInputStream;)V 
.const [101] = Utf8 isActive 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 setActive 
.const [104] = Utf8 (Z)V 
.end class 
