.version 50 0 
.class public super [123] 
.super [125] 
.field public static final [126] [127] 
.field public static final [128] [129] 
.field public static final [130] [131] 
.field public static final [132] [133] 
.field private [134] [135] 
.field private [136] [137] 
.field private [138] [139] 

.method public [141] : [142] 
    .attribute [140] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     lload_3 
L4:     iload 5 
L6:     iload 9 
L8:     invokespecial [22] 
L11:    aload_0 
L12:    iload 6 
L14:    putfield [26] 
L17:    aload_0 
L18:    iload 7 
L20:    putfield [27] 
L23:    aload_0 
L24:    iload 8 
L26:    putfield [28] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [140] .code stack 10 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     lload_3 
L4:     iload 5 
L6:     iload 6 
L8:     iload 7 
L10:    iconst_0 
L11:    iload 8 
L13:    invokespecial [23] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [147] : [148] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [149] : [150] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [151] : [152] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     lookupswitch 
            0 : L32 
            1 : L35 
            default : L38 

L32:    ldc [2] 
L34:    areturn 
L35:    ldc [3] 
L37:    areturn 
L38:    ldc [4] 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     bipush 20 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [140] .code stack 2 locals 0 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [24] 
L7:     ldc [6] 
L9:     invokevirtual [17] 
L12:    aload_0 
L13:    invokevirtual [18] 
L16:    invokevirtual [17] 
L19:    bipush 40 
L21:    invokevirtual [19] 
L24:    aload_0 
L25:    invokevirtual [16] 
L28:    invokevirtual [20] 
L31:    ldc [7] 
L33:    invokevirtual [17] 
L36:    aload_0 
L37:    invokespecial [25] 
L40:    invokevirtual [17] 
L43:    bipush 40 
L45:    invokevirtual [19] 
L48:    aload_0 
L49:    getfield [13] 
L52:    invokevirtual [20] 
L55:    ldc [8] 
L57:    invokevirtual [17] 
L60:    aload_0 
L61:    getfield [14] 
L64:    invokevirtual [20] 
L67:    ldc [9] 
L69:    invokevirtual [17] 
L72:    aload_0 
L73:    getfield [15] 
L76:    invokevirtual [20] 
L79:    invokevirtual [21] 
L82:    areturn 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [140] .code stack 1 locals 0 
L0:     ldc [10] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [30] 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = Class [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = String [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Class [73] 
.const [30] = Utf8 RIGHTTURN 
.const [31] = Utf8 LEFTTURN 
.const [32] = Utf8 <UNKNOWN> 
.const [33] = Utf8 java/lang/StringBuffer 
.const [34] = Utf8 'WheelButtonEvent: keyCode = ' 
.const [35] = Utf8 '), direction = ' 
.const [36] = Utf8 '), count = ' 
.const [37] = Utf8 ', subClickCount = ' 
.const [38] = Utf8 WheelButtonEvent 
.const [39] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [40] = Utf8 de/audi/atip/hmi/event/KeyEvent 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [75] = Utf8 direction 
.const [76] = Utf8 I 
.const [77] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [78] = Utf8 clickCount 
.const [79] = Utf8 I 
.const [80] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [81] = Utf8 subClickCount 
.const [82] = Utf8 I 
.const [83] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [84] = Utf8 getKeyCode 
.const [85] = Utf8 ()I 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 append 
.const [88] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [89] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [90] = Utf8 keycode2Text 
.const [91] = Utf8 ()Ljava/lang/String; 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 toString 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 de/audi/atip/hmi/event/KeyEvent 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;IJII)V 
.const [104] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;IJIIIII)V 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [111] = Utf8 direction2Text 
.const [112] = Utf8 ()Ljava/lang/String; 
.const [113] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [114] = Utf8 direction 
.const [115] = Utf8 I 
.const [116] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [117] = Utf8 clickCount 
.const [118] = Utf8 I 
.const [119] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [120] = Utf8 subClickCount 
.const [121] = Utf8 I 
.const [122] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [123] = Class [122] 
.const [124] = Utf8 de/audi/atip/hmi/event/KeyEvent 
.const [125] = Class [124] 
.const [126] = Utf8 RIGHTTURN 
.const [127] = Utf8 I 
.const [128] = Utf8 LEFTTURN 
.const [129] = Utf8 I 
.const [130] = Utf8 TURN_UP 
.const [131] = Utf8 I 
.const [132] = Utf8 TURN_DOWN 
.const [133] = Utf8 I 
.const [134] = Utf8 direction 
.const [135] = Utf8 I 
.const [136] = Utf8 clickCount 
.const [137] = Utf8 I 
.const [138] = Utf8 subClickCount 
.const [139] = Utf8 I 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;IJIIIII)V 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;IJIIII)V 
.const [145] = Utf8 getDirection 
.const [146] = Utf8 ()I 
.const [147] = Utf8 getClickCount 
.const [148] = Utf8 ()I 
.const [149] = Utf8 getSubClickCount 
.const [150] = Utf8 ()I 
.const [151] = Utf8 direction2Text 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 isVerticalDirection 
.const [154] = Utf8 ()Z 
.const [155] = Utf8 toStringWithDetails 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 toString 
.const [158] = Utf8 ()Ljava/lang/String; 
.end class 
