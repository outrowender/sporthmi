.version 50 0 
.class super [149] 
.super [151] 
.field private final [152] [153] 

.method [155] : [156] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [28] 
L6:     aload_0 
L7:     aload_3 
L8:     putfield [32] 
L11:    return 
L12:    
    .end code 
.end method 

.method [157] : [158] 
    .attribute [154] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [20] 
L13:    pop 
L14:    aload_0 
L15:    invokevirtual [21] 
L18:    astore_2 
L19:    aload_0 
L20:    invokevirtual [22] 
L23:    astore_3 
L24:    aload_3 
L25:    ifnonnull L41 
L28:    aload_0 
L29:    getfield [18] 
L32:    ldc [4] 
L34:    ldc [5] 
L36:    invokevirtual [23] 
L39:    pop 
L40:    return 
L41:    aload_2 
L42:    ifnonnull L62 
L45:    aload_0 
L46:    getfield [18] 
L49:    ldc [4] 
L51:    ldc [6] 
L53:    invokevirtual [23] 
L56:    pop 
L57:    aload_0 
L58:    invokespecial [29] 
L61:    return 
L62:    aload_2 
L63:    invokeinterface [33] 0 
L68:    astore 4 
L70:    aload 4 
L72:    ifnull L159 
L75:    aload 4 
L77:    invokeinterface [34] 0 
L82:    ifnull L159 
L85:    aload_0 
L86:    getfield [19] 
L89:    iload_1 
L90:    invokevirtual [24] 
L93:    istore 5 
L95:    iload 5 
L97:    iconst_m1 
L98:    if_icmpeq L140 
L101:   aload_0 
L102:   getfield [18] 
L105:   ldc [2] 
L107:   ldc [7] 
L109:   iload_1 
L110:   i2l 
L111:   iload 5 
L113:   i2l 
L114:   invokevirtual [25] 
L117:   pop 
L118:   aload_0 
L119:   invokevirtual [26] 
L122:   invokeinterface [35] 0 
L127:   iload 5 
L129:   iconst_1 
L130:   iconst_1 
L131:   aload_0 
L132:   invokeinterface [36] 0 
L137:   goto L156 
L140:   aload_0 
L141:   getfield [18] 
L144:   ldc [4] 
L146:   ldc [8] 
L148:   invokevirtual [23] 
L151:   pop 
L152:   aload_0 
L153:   invokespecial [29] 
L156:   goto L163 
L159:   aload_0 
L160:   invokespecial [29] 
L163:   return 
L164:   
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [154] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [30] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [154] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [31] 
L10:    invokevirtual [27] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [165] : [166] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [167] : [168] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [38] 
.const [4] = Int -1601830656 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Class [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Method [78] [79] 
.const [32] = Field [80] [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = InterfaceMethod [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = Class [90] 
.const [38] = Utf8 '[TelBAPMethodSplitCallHandler#splitCall] bapCallID=%1' 
.const [39] = Utf8 '[TelBAPMethodSplitCallHandler#splitCall] combiService is null --> NOP!' 
.const [40] = Utf8 '[TelBAPMethodSplitCallHandler#splitCall] telState is null --> NOP!' 
.const [41] = Utf8 '[TelBAPMethodSplitCallHandler#splitCall] bapCallID=%1, dsiCallID=%2' 
.const [42] = Utf8 '[TelBAPMethodSplitCallHandler#splitCall] call id could not be determined.' 
.const [43] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler$1 
.const [44] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [45] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [48] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [49] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [50] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [51] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Class [145] 
.const [89] = NameAndType [146] [147] 
.const [90] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler$1 
.const [91] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [92] = Utf8 log 
.const [93] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [95] = Utf8 callArrayAccess 
.const [96] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [101] = Utf8 getTelephoneState 
.const [102] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [103] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [104] = Utf8 getCombiBapServicePhone 
.const [105] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;)Z 
.const [109] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [110] = Utf8 getDSICallID 
.const [111] = Utf8 (I)I 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;JJ)Z 
.const [115] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [116] = Utf8 getApplication 
.const [117] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [118] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [119] = Utf8 enqueueResultNotification 
.const [120] = Utf8 (Ljava/lang/Runnable;)V 
.const [121] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [124] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [125] = Utf8 sendResultNotSuccessful 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [128] = Utf8 sendResult 
.const [129] = Utf8 (I)V 
.const [130] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler$1 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler;I)V 
.const [133] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [134] = Utf8 callArrayAccess 
.const [135] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess; 
.const [136] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [137] = Utf8 getCallLeadingDevice 
.const [138] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [139] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [140] = Utf8 getCallState 
.const [141] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [142] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [143] = Utf8 getTelephoneDSIAccess 
.const [144] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [145] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [146] = Utf8 splitCall 
.const [147] = Utf8 (IIZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [148] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler 
.const [149] = Class [148] 
.const [150] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [151] = Class [150] 
.const [152] = Utf8 callArrayAccess 
.const [153] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;Lde/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess;)V 
.const [157] = Utf8 splitCall 
.const [158] = Utf8 (I)V 
.const [159] = Utf8 sendResultNotSuccessful 
.const [160] = Utf8 ()V 
.const [161] = Utf8 responseSplitCall 
.const [162] = Utf8 (II)V 
.const [163] = Utf8 sendResult 
.const [164] = Utf8 (I)V 
.const [165] = Utf8 access$000 
.const [166] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler;)Lde/audi/atip/log/LogChannel; 
.const [167] = Utf8 access$100 
.const [168] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSplitCallHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
