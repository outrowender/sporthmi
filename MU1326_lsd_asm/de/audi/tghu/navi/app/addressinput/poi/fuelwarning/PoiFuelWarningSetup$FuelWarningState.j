.version 50 0 
.class public super [110] 
.super [112] 
.field public static final [113] [114] 
.field public static final [115] [116] 
.field private [117] [118] 
.field private final [119] [120] 

.method public [122] : [123] 
    .attribute [121] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     sipush 400 
L9:     aload_2 
L10:    invokespecial [23] 
L13:    aload_0 
L14:    aload_0 
L15:    invokespecial [24] 
L18:    invokestatic [2] 
L21:    putfield [25] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [124] : [125] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [126] : [127] 
    .attribute [121] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     sipush 1004 
L5:     sipush 400 
L8:     iconst_0 
L9:     invokeinterface [27] 0 
L14:    putfield [26] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [128] : [129] 
    .attribute [121] .code stack 2 locals 0 
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

.method protected [130] : [131] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [18] 
L5:     putfield [26] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [132] : [133] 
    .attribute [121] .code stack 8 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [15] 
L12:    iload_1 
L13:    i2l 
L14:    iload_2 
L15:    i2l 
L16:    invokevirtual [20] 
L19:    pop 
L20:    aload_0 
L21:    invokevirtual [21] 
        .catch [5] from L24 to L36 using L39 
L24:    iload_1 
L25:    ifle L36 
L28:    aload_0 
L29:    aload_3 
L30:    invokevirtual [18] 
L33:    putfield [26] 
L36:    goto L60 
L39:    astore 4 
L41:    aload_0 
L42:    invokevirtual [19] 
L45:    sipush 10000 
L48:    ldc [6] 
L50:    aload_0 
L51:    getfield [15] 
L54:    aload 4 
L56:    invokevirtual [22] 
L59:    pop 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public interface [134] : [135] 
    .attribute [121] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Int -2137614336 
.const [4] = String [30] 
.const [5] = Class [31] 
.const [6] = String [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Class [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Field [61] [62] 
.const [26] = Field [63] [64] 
.const [27] = InterfaceMethod [65] [66] 
.const [28] = Class [67] 
.const [29] = NameAndType [68] [69] 
.const [30] = Utf8 '%1#convertContainer - persistedVersion=%2; containerVersion=%3' 
.const [31] = Utf8 java/io/IOException 
.const [32] = Utf8 '%1#convertContainer - error on converting the persistent state format, error=%2' 
.const [33] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [34] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [37] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [38] = Utf8 java/io/DataOutputStream 
.const [39] = Utf8 java/io/DataInputStream 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [68] = Utf8 getClassNameFromPackageName 
.const [69] = Utf8 (Ljava/lang/Class;)Ljava/lang/String; 
.const [70] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [71] = Utf8 CLASS_NAME 
.const [72] = Utf8 Ljava/lang/String; 
.const [73] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [74] = Utf8 recommendation 
.const [75] = Utf8 I 
.const [76] = Utf8 java/io/DataOutputStream 
.const [77] = Utf8 writeInt 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 java/io/DataInputStream 
.const [80] = Utf8 readInt 
.const [81] = Utf8 ()I 
.const [82] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [83] = Utf8 getLogChannel 
.const [84] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [88] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [89] = Utf8 initWithDefaultValues 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [94] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 getClass 
.const [99] = Utf8 ()Ljava/lang/Class; 
.const [100] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [101] = Utf8 CLASS_NAME 
.const [102] = Utf8 Ljava/lang/String; 
.const [103] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [104] = Utf8 recommendation 
.const [105] = Utf8 I 
.const [106] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [107] = Utf8 getInt 
.const [108] = Utf8 (III)I 
.const [109] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [110] = Class [109] 
.const [111] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [112] = Class [111] 
.const [113] = Utf8 VERSION 
.const [114] = Utf8 I 
.const [115] = Utf8 KEY 
.const [116] = Utf8 I 
.const [117] = Utf8 recommendation 
.const [118] = Utf8 I 
.const [119] = Utf8 CLASS_NAME 
.const [120] = Utf8 Ljava/lang/String; 
.const [121] = Utf8 Code 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [124] = Utf8 initWithDefaultValues 
.const [125] = Utf8 ()V 
.const [126] = Utf8 initFromOldKeys 
.const [127] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [128] = Utf8 serialize 
.const [129] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [130] = Utf8 deserialize 
.const [131] = Utf8 (Ljava/io/DataInputStream;)V 
.const [132] = Utf8 convertContainer 
.const [133] = Utf8 (IILjava/io/DataInputStream;)V 
.const [134] = Utf8 getRecommendation 
.const [135] = Utf8 ()I 
.const [136] = Utf8 setRecommendation 
.const [137] = Utf8 (I)V 
.end class 
