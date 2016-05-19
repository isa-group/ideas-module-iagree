ace.define("ace/theme/json",["require","exports","module","ace/lib/dom"], function(require, exports, module) {

exports.isDark = false;
exports.cssClass = "ace-json";
exports.cssText = ".ace-json .ace_gutter {\
background: #f6f6f6;\
color: #4D4D4C\
}\
.ace-json .ace_print-margin {\
width: 1px;\
background: #f6f6f6\
}\
.ace-json {\
background-color: #FFFFFF;\
color: #4D4D4C\
}\
.ace-json .ace_cursor {\
color: #AEAFAD\
}\
.ace-json .ace_marker-layer .ace_selection {\
background: #D6D6D6\
}\
.ace-json.ace_multiselect .ace_selection.ace_start {\
box-shadow: 0 0 3px 0px #FFFFFF;\
}\
.ace-json .ace_marker-layer .ace_step {\
background: rgb(255, 255, 0)\
}\
.ace-json .ace_marker-layer .ace_bracket {\
margin: -1px 0 0 -1px;\
border: 1px solid #D1D1D1\
}\
.ace-json .ace_marker-layer .ace_active-line {\
background: #EFEFEF\
}\
.ace-json .ace_gutter-active-line {\
background-color : #dcdcdc\
}\
.ace-json .ace_marker-layer .ace_selected-word {\
border: 1px solid #D6D6D6\
}\
.ace-json .ace_invisible {\
color: #D1D1D1\
}\
.ace-json .ace_keyword,\
.ace-json .ace_meta,\
.ace-json .ace_storage,\
.ace-json .ace_storage.ace_type,\
.ace-json .ace_support.ace_type {\
color: #8959A8\
}\
.ace-json .ace_keyword.ace_operator {\
color: #3E999F\
}\
.ace-json .ace_constant.ace_character,\
.ace-json .ace_constant.ace_language,\
.ace-json .ace_constant.ace_numeric,\
.ace-json .ace_keyword.ace_other.ace_unit,\
.ace-json .ace_support.ace_constant,\
.ace-json .ace_variable.ace_parameter {\
color: #F5871F\
}\
.ace-json .ace_constant.ace_other {\
color: #666969\
}\
.ace-json .ace_invalid {\
color: #FFFFFF;\
background-color: #C82829\
}\
.ace-json .ace_invalid.ace_deprecated {\
color: #FFFFFF;\
background-color: #8959A8\
}\
.ace-json .ace_fold {\
background-color: #4271AE;\
border-color: #4D4D4C\
}\
.ace-json .ace_entity.ace_name.ace_function,\
.ace-json .ace_support.ace_function,\
.ace-json .ace_variable {\
color: #4271AE\
}\
.ace-json .ace_support.ace_class,\
.ace-json .ace_support.ace_type {\
color: #C99E00\
}\
.ace-json .ace_heading,\
.ace-json .ace_markup.ace_heading,\
.ace-json .ace_string {\
color: #718C00\
}\
.ace-json .ace_entity.ace_name.ace_tag,\
.ace-json .ace_entity.ace_other.ace_attribute-name,\
.ace-json .ace_meta.ace_tag,\
.ace-json .ace_string.ace_regexp,\
.ace-json .ace_variable {\
color: #C82829\
}\
.ace-json .ace_comment {\
color: #8E908C\
}\
.ace-json .ace_indent-guide {\
background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAACCAYAAACZgbYnAAAAE0lEQVQImWP4////f4bdu3f/BwAlfgctduB85QAAAABJRU5ErkJggg==) right repeat-y\
}";

var dom = require("../lib/dom");
dom.importCssString(exports.cssText, exports.cssClass);
});