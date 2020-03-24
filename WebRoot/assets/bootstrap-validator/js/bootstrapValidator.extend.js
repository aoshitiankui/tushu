(function ($) {
    /**
     * Simplified Chinese language package
     * Translated by @shamiao
     */
    //validate是验证的方法  
    $.fn.bootstrapValidator.validators.idCard = {  
        validate: function(validator, $field, options) {  
            var value = $field.val();  
            if (value === '') {  
                return true;  
            }  
            return /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/.test(value);  
        }  
    };
    
    $.fn.bootstrapValidator.validators.minNumber = {  
            validate: function(validator, $field, options) {  
                var value = $field.val();  
                if (value === '') {  
                    return true;  
                } 
                
                var returnVal = true;
                inputZ=value;
                var ArrMen= inputZ.split(".");    //截取字符串
                if(ArrMen.length==2){
                    if(ArrMen[1].length>2){    //判断小数点后面的字符串长度
                        returnVal = false;
                        return false;
                    }
                }
                return returnVal;
                
            }  
        };
    
    $.fn.bootstrapValidator.validators.identifyingcode = {  
            validate: function(validator, $field, options) {  
                var value = $field.val();  
                if (value === '') {  
                    return true;  
                } 
                
                var returnVal = true;
                
                if(value.length!=4){
                	return false;
                }
                return returnVal;
                
            }  
        };
    $.fn.bootstrapValidator.validators.filecheck = {  
            validate: function(validator, $field, options) {
            	 
            	var files= $field.parent().parent().parent().parent().parent().find("input.filescheck");
            	 
            	var value =files.val();
            	 
                if (value === '') {  
                    return false;  
                } 
                
                return true;
                
            }  
        };
}(window.jQuery));
