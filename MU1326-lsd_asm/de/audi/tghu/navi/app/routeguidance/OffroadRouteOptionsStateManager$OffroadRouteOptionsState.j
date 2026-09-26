.version 50 0 
.class super [80] 
.super [82] 
.field public static final [83] [84] 
.field private static final [85] [86] 
.field private static final [87] [88] 
.field private [89] [90] 
.field private final synthetic [91] [92] 

.method public [94] : [95] 
    .attribute [93] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     aload_2 
L7:     iconst_1 
L8:     sipush 1004 
L11:    sipush 1044 
L14:    aload_3 
L15:    invokespecial [18] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [96] : [97] 
    .attribute [93] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected enum [98] : [99] 
    .attribute [93] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [100] : [101] 
    .attribute [93] .code stack 2 locals 0 
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

.method protected [102] : [103] 
    .attribute [93] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [13] 
L5:     putfield [20] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [104] : [105] 
    .attribute [93] .code stack 7 locals 1 
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
L29:    putfield [20] 
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

.method public interface [106] : [107] 
    .attribute [93] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [93] .code stack 2 locals 0 
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
.const [3] = String [21] 
.const [4] = Class [22] 
.const [5] = String [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Field [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Field [47] [48] 
.const [21] = Utf8 'OffroadRouteOptionsState#convertContainer( %1, %2 )' 
.const [22] = Utf8 java/io/IOException 
.const [23] = Utf8 'OffroadRouteOptionsState#convertContainer - error on converting the persistent state format' 
.const [24] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [25] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [26] = Utf8 java/io/DataOutputStream 
.const [27] = Utf8 java/io/DataInputStream 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [50] = Utf8 offroadRouteOptions 
.const [51] = Utf8 I 
.const [52] = Utf8 java/io/DataOutputStream 
.const [53] = Utf8 writeInt 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 java/io/DataInputStream 
.const [56] = Utf8 readInt 
.const [57] = Utf8 ()I 
.const [58] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [59] = Utf8 logChannel 
.const [60] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;JJ)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [65] = Utf8 initWithDefaultValues 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [70] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [73] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Lde/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager; 
.const [76] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [77] = Utf8 offroadRouteOptions 
.const [78] = Utf8 I 
.const [79] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [80] = Class [79] 
.const [81] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [82] = Class [81] 
.const [83] = Utf8 OFFORAD_ROUTE_OPTIONS_DEFAULT 
.const [84] = Utf8 I 
.const [85] = Utf8 VERSION 
.const [86] = Utf8 I 
.const [87] = Utf8 KEY 
.const [88] = Utf8 I 
.const [89] = Utf8 offroadRouteOptions 
.const [90] = Utf8 I 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lde/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager; 
.const [93] = Utf8 Code 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Lde/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager;Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [96] = Utf8 initWithDefaultValues 
.const [97] = Utf8 ()V 
.const [98] = Utf8 initFromOldKeys 
.const [99] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [100] = Utf8 serialize 
.const [101] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [102] = Utf8 deserialize 
.const [103] = Utf8 (Ljava/io/DataInputStream;)V 
.const [104] = Utf8 convertContainer 
.const [105] = Utf8 (IILjava/io/DataInputStream;)V 
.const [106] = Utf8 getDsiRouteOptionOffRoad 
.const [107] = Utf8 ()I 
.const [108] = Utf8 setDsiRouteOptionOffRoad 
.const [109] = Utf8 (I)V 
.end class 
