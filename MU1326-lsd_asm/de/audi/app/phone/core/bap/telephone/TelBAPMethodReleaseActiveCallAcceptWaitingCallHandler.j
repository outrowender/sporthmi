.version 50 0 
.class super [164] 
.super [166] 

.method annotation [168] : [169] 
    .attribute [167] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [28] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [170] : [171] 
    .attribute [167] .code stack 4 locals 6 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [21] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [22] 
L16:    astore_1 
L17:    aload_0 
L18:    invokevirtual [23] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnonnull L39 
L26:    aload_0 
L27:    getfield [20] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    invokevirtual [21] 
L37:    pop 
L38:    return 
L39:    aload_1 
L40:    ifnonnull L60 
L43:    aload_0 
L44:    getfield [20] 
L47:    ldc [4] 
L49:    ldc [6] 
L51:    invokevirtual [21] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [29] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [32] 0 
L66:    astore_3 
L67:    aload_1 
L68:    invokeinterface [33] 0 
L73:    astore 4 
L75:    aload_3 
L76:    ifnull L88 
L79:    aload_3 
L80:    invokeinterface [34] 0 
L85:    goto L89 
L88:    aconst_null 
L89:    astore 5 
L91:    aload 4 
L93:    ifnull L106 
L96:    aload 4 
L98:    invokeinterface [34] 0 
L103:   goto L107 
L106:   aconst_null 
L107:   astore 6 
L109:   aload 5 
L111:   ifnull L162 
L114:   aload 5 
L116:   invokevirtual [24] 
L119:   ifeq L162 
L122:   aload 5 
L124:   invokevirtual [25] 
L127:   ifeq L162 
L130:   aload_0 
L131:   getfield [20] 
L134:   ldc [7] 
L136:   ldc [3] 
L138:   invokevirtual [21] 
L141:   pop 
L142:   aload_0 
L143:   invokevirtual [26] 
L146:   invokeinterface [35] 0 
L151:   iconst_1 
L152:   iconst_1 
L153:   aload_0 
L154:   invokeinterface [36] 0 
L159:   goto L238 
L162:   aload 6 
L164:   ifnull L222 
L167:   aload 6 
L169:   invokevirtual [24] 
L172:   ifeq L222 
L175:   aload_0 
L176:   getfield [20] 
L179:   ldc [2] 
L181:   ldc [8] 
L183:   invokevirtual [21] 
L186:   pop 
L187:   aload_0 
L188:   invokevirtual [26] 
L191:   invokeinterface [35] 0 
L196:   iconst_1 
L197:   iconst_1 
L198:   aload_0 
L199:   invokeinterface [37] 0 
L204:   aload_0 
L205:   invokevirtual [26] 
L208:   invokeinterface [38] 0 
L213:   iconst_1 
L214:   invokeinterface [39] 0 
L219:   goto L238 
L222:   aload_0 
L223:   getfield [20] 
L226:   ldc [7] 
L228:   ldc [9] 
L230:   invokevirtual [21] 
L233:   pop 
L234:   aload_0 
L235:   invokespecial [29] 
L238:   return 
L239:   nop 
L240:   
    .end code 
.end method 

.method private [172] : [173] 
    .attribute [167] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [167] .code stack 2 locals 0 
L0:     iload_1 
L1:     ifne L19 
L4:     aload_0 
L5:     invokevirtual [26] 
L8:     invokeinterface [38] 0 
L13:    iconst_1 
L14:    invokeinterface [40] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [167] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [30] 
L15:    aload_0 
L16:    invokevirtual [26] 
L19:    invokeinterface [38] 0 
L24:    iconst_0 
L25:    invokeinterface [40] 0 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [178] : [179] 
    .attribute [167] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [41] 
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

.method static synthetic [180] : [181] 
    .attribute [167] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [182] : [183] 
    .attribute [167] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [42] 
.const [4] = Int -1601830656 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = Int 1078071040 
.const [8] = String [45] 
.const [9] = String [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Field [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = InterfaceMethod [81] [82] 
.const [33] = InterfaceMethod [83] [84] 
.const [34] = InterfaceMethod [85] [86] 
.const [35] = InterfaceMethod [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = InterfaceMethod [91] [92] 
.const [38] = InterfaceMethod [93] [94] 
.const [39] = InterfaceMethod [95] [96] 
.const [40] = InterfaceMethod [97] [98] 
.const [41] = Class [99] 
.const [42] = Utf8 '[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall]' 
.const [43] = Utf8 '[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] combiService is null --> NOP!' 
.const [44] = Utf8 '[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] telState is null --> NOP!' 
.const [45] = Utf8 '[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] accepting call on non call leading device.' 
.const [46] = Utf8 '[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#releaseActiveCallAcceptWaitingCall] There is no incoming and active call, returning MPRACAWC_RESULT_NOT_SUCCESSFUL' 
.const [47] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1 
.const [48] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [49] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [52] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [53] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [54] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [55] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [56] = Utf8 de/audi/app/phone/core/callcontrol/ITelCallControl 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Class [142] 
.const [86] = NameAndType [143] [144] 
.const [87] = Class [145] 
.const [88] = NameAndType [146] [147] 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Class [151] 
.const [92] = NameAndType [152] [153] 
.const [93] = Class [154] 
.const [94] = NameAndType [155] [156] 
.const [95] = Class [157] 
.const [96] = NameAndType [158] [159] 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1 
.const [100] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [101] = Utf8 log 
.const [102] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;)Z 
.const [106] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [107] = Utf8 getTelephoneState 
.const [108] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [109] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [110] = Utf8 getCombiBapServicePhone 
.const [111] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [112] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [113] = Utf8 isHasIncomingCall 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [116] = Utf8 isHasActiveCall 
.const [117] = Utf8 ()Z 
.const [118] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [119] = Utf8 getApplication 
.const [120] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [121] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [122] = Utf8 enqueueResultNotification 
.const [123] = Utf8 (Ljava/lang/Runnable;)V 
.const [124] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [127] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [128] = Utf8 sendResultNotSuccessful 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [131] = Utf8 sendResult 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler;I)V 
.const [136] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [137] = Utf8 getCallLeadingDevice 
.const [138] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [139] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [140] = Utf8 getNonCallLeadingDevice 
.const [141] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [142] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [143] = Utf8 getCallState 
.const [144] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [145] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [146] = Utf8 getTelephoneDSIAccess 
.const [147] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [148] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [149] = Utf8 acceptWaitingCallReplaceActiveCall 
.const [150] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [151] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [152] = Utf8 acceptIncomingCallOnNonCallLeadingDevice 
.const [153] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [154] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [155] = Utf8 getCallControl 
.const [156] = Utf8 ()Lde/audi/app/phone/core/callcontrol/ITelCallControl; 
.const [157] = Utf8 de/audi/app/phone/core/callcontrol/ITelCallControl 
.const [158] = Utf8 acceptIncomingCall 
.const [159] = Utf8 (I)V 
.const [160] = Utf8 de/audi/app/phone/core/callcontrol/ITelCallControl 
.const [161] = Utf8 acceptOnNCLDOngoing 
.const [162] = Utf8 (Z)V 
.const [163] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler 
.const [164] = Class [163] 
.const [165] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [166] = Class [165] 
.const [167] = Utf8 Code 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [170] = Utf8 releaseActiveCallAcceptWaitingCall 
.const [171] = Utf8 ()V 
.const [172] = Utf8 sendResultNotSuccessful 
.const [173] = Utf8 ()V 
.const [174] = Utf8 responseHangupCall 
.const [175] = Utf8 (II)V 
.const [176] = Utf8 responseAcceptCall 
.const [177] = Utf8 (II)V 
.const [178] = Utf8 sendResult 
.const [179] = Utf8 (I)V 
.const [180] = Utf8 access$000 
.const [181] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler;)Lde/audi/atip/log/LogChannel; 
.const [182] = Utf8 access$100 
.const [183] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
