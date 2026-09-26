.version 50 0 
.class super [104] 
.super [106] 
.implements [108] 
.field private final [109] [110] 
.field private final synthetic [111] [112] 

.method public [114] : [115] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     aload_0 
L6:     invokespecial [19] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [21] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [113] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_0 
L12:    getfield [16] 
L15:    i2l 
L16:    invokevirtual [17] 
L19:    pop 
L20:    aload_0 
L21:    getfield [15] 
L24:    invokestatic [5] 
L27:    invokeinterface [22] 0 
L32:    aload_0 
L33:    getfield [16] 
L36:    iconst_0 
L37:    invokeinterface [23] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [113] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokestatic [6] 
L7:     ldc [3] 
L9:     ldc [7] 
L11:    iload_1 
L12:    invokevirtual [18] 
L15:    pop 
L16:    iload_1 
L17:    ifeq L24 
L20:    iconst_0 
L21:    goto L25 
L24:    iconst_1 
L25:    istore_2 
L26:    aload_0 
L27:    getfield [15] 
L30:    invokestatic [8] 
L33:    invokeinterface [22] 0 
L38:    iload_2 
L39:    iconst_0 
L40:    invokeinterface [24] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [25] [26] 
.const [3] = Int 1078071040 
.const [4] = String [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = String [32] 
.const [8] = Method [33] [34] 
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
.const [20] = Field [51] [52] 
.const [21] = Field [53] [54] 
.const [22] = InterfaceMethod [55] [56] 
.const [23] = InterfaceMethod [57] [58] 
.const [24] = InterfaceMethod [59] [60] 
.const [25] = Class [61] 
.const [26] = NameAndType [62] [63] 
.const [27] = Utf8 '[TelDialNumberSessionHandler.TelCallControlHandler#hangupCall] hanging up callID=%1' 
.const [28] = Class [64] 
.const [29] = NameAndType [65] [66] 
.const [30] = Class [67] 
.const [31] = NameAndType [68] [69] 
.const [32] = Utf8 '[TelDialNumberSessionHandler.TelCallControlHandler#muteMicrophone] mute=%1' 
.const [33] = Class [70] 
.const [34] = NameAndType [71] [72] 
.const [35] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [40] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler 
.const [62] = Utf8 access$000 
.const [63] = Utf8 (Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler;)Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler 
.const [65] = Utf8 access$100 
.const [66] = Utf8 (Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler;)Lde/audi/app/phone/core/ITelApplication; 
.const [67] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler 
.const [68] = Utf8 access$200 
.const [69] = Utf8 (Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler;)Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler 
.const [71] = Utf8 access$300 
.const [72] = Utf8 (Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler;)Lde/audi/app/phone/core/ITelApplication; 
.const [73] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler; 
.const [76] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [77] = Utf8 telCallId 
.const [78] = Utf8 S 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;J)Z 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 log 
.const [84] = Utf8 (ILjava/lang/String;Z)Z 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler; 
.const [91] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [92] = Utf8 telCallId 
.const [93] = Utf8 S 
.const [94] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [95] = Utf8 getTelephoneDSIAccess 
.const [96] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [97] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [98] = Utf8 hangupCall 
.const [99] = Utf8 (II)V 
.const [100] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [101] = Utf8 requestSetMICMuteState 
.const [102] = Utf8 (II)V 
.const [103] = Utf8 de/audi/app/phone/core/interapp/TelDialNumberSessionHandler$TelCallControlHandler 
.const [104] = Class [103] 
.const [105] = Utf8 java/lang/Object 
.const [106] = Class [105] 
.const [107] = Utf8 de/audi/atip/interapp/phone/ITelCallControl 
.const [108] = Class [107] 
.const [109] = Utf8 telCallId 
.const [110] = Utf8 S 
.const [111] = Utf8 this$0 
.const [112] = Utf8 Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler; 
.const [113] = Utf8 Code 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/app/phone/core/interapp/TelDialNumberSessionHandler;S)V 
.const [116] = Utf8 hangupCall 
.const [117] = Utf8 ()V 
.const [118] = Utf8 muteMicrophone 
.const [119] = Utf8 (Z)V 
.end class 
