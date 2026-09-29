.version 50 0 
.class public super [183] 
.super [185] 
.field private final [186] [187] 
.field private final [188] [189] 
.field private final [190] [191] 
.field private final [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [39] 
L9:     aload_0 
L10:    aload 4 
L12:    putfield [40] 
L15:    aload_0 
L16:    aload_2 
L17:    putfield [41] 
L20:    aload_0 
L21:    aload_3 
L22:    putfield [42] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [194] .code stack 9 locals 4 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [26] 
L11:    pop 
L12:    aload_0 
L13:    getfield [22] 
L16:    ifnull L29 
L19:    aload_0 
L20:    getfield [22] 
L23:    invokevirtual [27] 
L26:    ifne L72 
L29:    aload_0 
L30:    getfield [24] 
L33:    ldc [4] 
L35:    ldc [5] 
L37:    invokevirtual [26] 
L40:    pop 
L41:    aload_0 
L42:    getfield [25] 
L45:    invokeinterface [43] 0 
L50:    astore_2 
L51:    aload_2 
L52:    new [44] 
L55:    dup 
L56:    aload_0 
L57:    aload_1 
L58:    invokespecial [36] 
L61:    invokevirtual [28] 
L64:    pop 
L65:    aload_2 
L66:    ldc [7] 
L68:    invokevirtual [29] 
L71:    return 
L72:    aload_0 
L73:    getfield [23] 
L76:    invokestatic [8] 
L79:    ifeq L173 
L82:    aload_0 
L83:    getfield [22] 
L86:    invokevirtual [30] 
L89:    istore_2 
L90:    aload_0 
L91:    getfield [22] 
L94:    invokevirtual [31] 
L97:    istore_3 
L98:    iload_2 
L99:    ifeq L107 
L102:   iload_3 
L103:   iconst_m1 
L104:   if_icmpne L111 
L107:   iconst_3 
L108:   goto L112 
L111:   iconst_0 
L112:   istore 4 
L114:   aload_0 
L115:   getfield [24] 
L118:   ldc [2] 
L120:   ldc [9] 
L122:   iload 4 
L124:   i2l 
L125:   iload_2 
L126:   i2l 
L127:   iload_3 
L128:   i2l 
L129:   invokevirtual [32] 
L132:   pop 
L133:   aload_0 
L134:   getfield [25] 
L137:   invokeinterface [43] 0 
L142:   astore 5 
L144:   aload 5 
L146:   new [45] 
L149:   dup 
L150:   aload_0 
L151:   aload_1 
L152:   iload 4 
L154:   iload_2 
L155:   iload_3 
L156:   invokespecial [37] 
L159:   invokevirtual [28] 
L162:   pop 
L163:   aload 5 
L165:   ldc [11] 
L167:   invokevirtual [29] 
L170:   goto L233 
L173:   aload_0 
L174:   getfield [24] 
L177:   ldc [2] 
L179:   ldc [12] 
L181:   invokevirtual [26] 
L184:   pop 
L185:   new [46] 
L188:   dup 
L189:   aload_0 
L190:   aload_1 
L191:   invokespecial [38] 
L194:   astore_2 
L195:   aload_0 
L196:   getfield [25] 
L199:   invokeinterface [43] 0 
L204:   astore_3 
L205:   aload_3 
L206:   aload_2 
L207:   invokevirtual [28] 
L210:   pop 
L211:   aload_3 
L212:   ldc [14] 
L214:   invokevirtual [29] 
L217:   aload_0 
L218:   getfield [22] 
L221:   aload_2 
L222:   invokevirtual [33] 
L225:   aload_0 
L226:   getfield [22] 
L229:   iconst_1 
L230:   invokevirtual [34] 
L233:   return 
L234:   nop 
L235:   nop 
L236:   
    .end code 
.end method 

.method static synthetic [199] : [200] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [47] 
.const [4] = Int -1601830656 
.const [5] = String [48] 
.const [6] = Class [49] 
.const [7] = String [50] 
.const [8] = Method [51] [52] 
.const [9] = String [53] 
.const [10] = Class [54] 
.const [11] = String [55] 
.const [12] = String [56] 
.const [13] = Class [57] 
.const [14] = String [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Field [66] [67] 
.const [23] = Field [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Field [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Method [96] [97] 
.const [38] = Method [98] [99] 
.const [39] = Field [100] [101] 
.const [40] = Field [102] [103] 
.const [41] = Field [104] [105] 
.const [42] = Field [106] [107] 
.const [43] = InterfaceMethod [108] [109] 
.const [44] = Class [110] 
.const [45] = Class [111] 
.const [46] = Class [112] 
.const [47] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit()' 
.const [48] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit() - traffic regulation is not present!' 
.const [49] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$1 
.const [50] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit_noTrafficRegulation' 
.const [51] = Class [113] 
.const [52] = NameAndType [114] [115] 
.const [53] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA enabled, notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3' 
.const [54] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$2 
.const [55] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationEnabled' 
.const [56] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA disabled, shortly enable VZA and wait for update' 
.const [57] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [58] = Utf8 'TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationDisabled' 
.const [59] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [63] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [64] = Utf8 de/audi/tghu/command/CommandList 
.const [65] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Class [149] 
.const [89] = NameAndType [150] [151] 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Class [155] 
.const [93] = NameAndType [156] [157] 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Class [161] 
.const [97] = NameAndType [162] [163] 
.const [98] = Class [164] 
.const [99] = NameAndType [165] [166] 
.const [100] = Class [167] 
.const [101] = NameAndType [168] [169] 
.const [102] = Class [170] 
.const [103] = NameAndType [171] [172] 
.const [104] = Class [173] 
.const [105] = NameAndType [174] [175] 
.const [106] = Class [176] 
.const [107] = NameAndType [177] [178] 
.const [108] = Class [179] 
.const [109] = NameAndType [180] [181] 
.const [110] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$1 
.const [111] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$2 
.const [112] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [113] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [114] = Utf8 isTrafficRegulationInfoEnabled 
.const [115] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [116] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [117] = Utf8 trafficRegulationService 
.const [118] = Utf8 Lde/audi/tghu/navi/app/tr/TrafficRegulationService; 
.const [119] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [120] = Utf8 env 
.const [121] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [122] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [123] = Utf8 logChannel 
.const [124] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [126] = Utf8 commandListFactory 
.const [127] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [128] = Utf8 de/audi/atip/log/LogChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (ILjava/lang/String;)Z 
.const [131] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [132] = Utf8 isTrafficRegulationPresent 
.const [133] = Utf8 ()Z 
.const [134] = Utf8 de/audi/tghu/command/CommandList 
.const [135] = Utf8 add 
.const [136] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [137] = Utf8 de/audi/tghu/command/CommandList 
.const [138] = Utf8 execute 
.const [139] = Utf8 (Ljava/lang/String;)V 
.const [140] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [141] = Utf8 getCurrentSpeedLimit 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [144] = Utf8 getCurrentSpeedLimitUnit 
.const [145] = Utf8 ()B 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [149] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [150] = Utf8 registerCurrentTrafficSignObserver 
.const [151] = Utf8 (Lde/audi/tghu/navi/app/tr/TrafficRegulationService$CurrentTrafficSignObserver;)V 
.const [152] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [153] = Utf8 setEnableTrafficRegulationInfo 
.const [154] = Utf8 (Z)V 
.const [155] = Utf8 java/lang/Object 
.const [156] = Utf8 <init> 
.const [157] = Utf8 ()V 
.const [158] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$1 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [161] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$2 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;Lde/audi/atip/interapp/NaviServiceListener;BIB)V 
.const [164] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [167] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [168] = Utf8 trafficRegulationService 
.const [169] = Utf8 Lde/audi/tghu/navi/app/tr/TrafficRegulationService; 
.const [170] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [171] = Utf8 env 
.const [172] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [173] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [174] = Utf8 logChannel 
.const [175] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [176] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [177] = Utf8 commandListFactory 
.const [178] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [179] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [180] = Utf8 createCommandList 
.const [181] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [182] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [183] = Class [182] 
.const [184] = Utf8 java/lang/Object 
.const [185] = Class [184] 
.const [186] = Utf8 env 
.const [187] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [188] = Utf8 logChannel 
.const [189] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [190] = Utf8 trafficRegulationService 
.const [191] = Utf8 Lde/audi/tghu/navi/app/tr/TrafficRegulationService; 
.const [192] = Utf8 commandListFactory 
.const [193] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Lde/audi/tghu/navi/app/tr/TrafficRegulationService;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/command/ICommandListFactory;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [197] = Utf8 requestCurrentSpeedLimit 
.const [198] = Utf8 (Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [199] = Utf8 access$000 
.const [200] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;)Lde/audi/tghu/navi/app/tr/TrafficRegulationService; 
.end class 
