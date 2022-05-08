
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]{1,40})@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]{1,20}\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else if ($(input).attr('type') == 'birth' || $(input).attr('name') == 'birth') {
            if ($(input).val().trim().match(/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/)==null){
                return false;
            }
        }
        else if ($(input).attr('type') == 'passport' || $(input).attr('name') == 'passport') {
            if ($(input).val().trim().match(/^[a-zA-Z]{2}\d{7}$/)==null){
                return false;
            }
        }
        else if ($(input).attr('type') == 'phone' || $(input).attr('name') == 'phone') {
            if ($(input).val().trim().match(/^((8|\+[1-9])[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/)==null){
                return false;
            }
        }

        else if ($(input).attr('type') == 'name' || $(input).attr('name') == 'name' || $(input).attr('type') == 'surname' || $(input).attr('name') == 'surname') {
            if ($(input).val().trim().match(/^[a-zA-Z][a-zA-Z_]*[a-zA-Z](?<![_\s\-]{2,60}.*)$/)==null){
                return false;
            }
        }
        else if ($(input).attr('type') == 'pass' || $(input).attr('name') == 'pass') {
            if ($(input).val().trim().match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,30}$/)==null){
                return false;
            }
        }
        if( $(input).attr('name') == 'repass') {
            if($(".pass").val() != $(".repass").val()) {
                return false;
            }
        }

        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);