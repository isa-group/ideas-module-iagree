ace.define('ace/theme/ao', ['require', 'exports', 'module' , 'ace/lib/dom'], function(require, exports, module) {

exports.isDark = false;
exports.cssClass = "ace-iAgree";
exports.cssText = ".ace-iAgree{\
}\
.ace_token_Keyword.ace_keyword{\
	color: #708;\
}\
.ace_string{\
	color: blue;\
}\
.ace_variable.ace_def{\
	color: #71a;\
}\
.ace_variable.ace_def2{\
	color: #4900b7;\
}\
.ace_entity-name-tag.ace_atom{\
	color: #05a;\
}\
.ace_entity-name-tag.ace_atom2{\
	color: #a532a9;\
}\
.ace_entity-name-tag.ace_condition{\
	color: #986c80;\
	font-style: italic;\
}\
.ace_token_Keyword.ace_roles{\
	color: #4a2b99;\
	font-style: italic;\
}\
.ace_entity-name-tag.ace_attribute{\
	color: #219;\
}\
.ace_entity-name-tag.ace_type{\
	color: #39238c;\
	font-style: italic;\
}\
.ace_entity-name-tag.ace_interval{\
	color: #39238c;\
	font-style: italic;\
}\
.ace_entity-name-tag.ace_compensation{\
	color: #05a;\
	font-style: italic;\
}\
.ace_entity-name-tag.ace_true{\
	color: #20800b;\
}\
.ace_entity-name-tag.ace_false{\
	color: #be361b;\
}\
.ace_url{\
	color: #0000FF;\
}\
.ace_variables{\
	color: #000000;\
}\
.ace_comment{\
	color: #236e24;\
}\
.ace_variable.ace_functions.ace_1{\
	color: #DF7401;\
}\
.ace-iAgree .ace_gutter {\
background: rgba(250, 250, 250, 0.5);\
color: #BDBDBD;\
overflow : visible;\
border-right: 1px solid rgba(0,0,0,0.05);\
}\
.ace-iAgree .ace_print-margin {\
width: 1px;\
background: #e8e8e8;\
}\
.ace-iAgree {\
background-color: #FFFFFF;\
}\
.ace-iAgree .ace_cursor {\
color: black;\
}\
.ace-iAgree .ace_invisible {\
color: rgb(191, 191, 191);\
}\
.ace-iAgree .ace_constant.ace_buildin {\
color: rgb(88, 72, 246);\
}\
.ace-iAgree .ace_constant.ace_language {\
color: rgb(88, 92, 246);\
}\
.ace-iAgree .ace_constant.ace_library {\
color: rgb(6, 150, 14);\
}\
.ace-iAgree .ace_invalid {\
background-color: rgb(153, 0, 0);\
color: white;\
}\
.ace-iAgree .ace_fold {\
}\
.ace-iAgree .ace_support.ace_function {\
color: rgb(60, 76, 114);\
}\
.ace-iAgree .ace_support.ace_constant {\
color: rgb(6, 150, 14);\
}\
.ace-iAgree .ace_support.ace_type,\
.ace-iAgree .ace_support.ace_class\
.ace-iAgree .ace_support.ace_other {\
color: rgb(109, 121, 222);\
}\
.ace-iAgree .ace_variable.ace_parameter {\
font-style:italic;\
color:#FD971F;\
}\
.ace-iAgree .ace_constant.ace_numeric {\
color: rgb(0, 0, 205);\
}\
.ace-iAgree .ace_xml-pe {\
color: rgb(104, 104, 91);\
}\
.ace-iAgree .ace_entity.ace_name.ace_function {\
color: #0000A2;\
}\
.ace-iAgree .ace_heading {\
color: rgb(12, 7, 255);\
}\
.ace-iAgree .ace_list {\
color:rgb(185, 6, 144);\
}\
.ace-iAgree .ace_marker-layer .ace_selection {\
background: rgba(45, 151, 221, 0.29);\
}\
.ace-iAgree .ace_marker-layer .ace_step {\
background: rgb(252, 255, 0);\
}\
.ace-iAgree .ace_marker-layer .ace_stack {\
background: rgb(164, 229, 101);\
}\
.ace-iAgree .ace_marker-layer .ace_bracket {\
margin: -1px 0 0 -1px;\
border: 1px solid rgb(192, 192, 192);\
}\
.ace-iAgree .ace_marker-layer .ace_active-line {\
background: rgba(133, 151, 170, 0.09);\
}\
.ace-iAgree .ace_gutter-active-line {\
background-color: rgba(66, 66, 66, 0.06);\
border-right: 1px solid rgba(66, 128, 178, 0.19);\
right: -1px;\
}\
.ace-iAgree .ace_marker-layer .ace_selected-word {\
background: rgba(66, 128, 178, 0.12);\
border-bottom: 1px solid rgba(66, 128, 178, 0.19);\
}\
.ace-iAgree .ace_storage,\
.ace-iAgree .ace_meta.ace_tag {\
color: rgb(147, 15, 128);\
}\
.ace-iAgree .ace_entity.ace_other.ace_attribute-name {\
color: #994409;\
}\
";

var dom = require("../lib/dom");
dom.importCssString(exports.cssText, exports.cssClass);
});
