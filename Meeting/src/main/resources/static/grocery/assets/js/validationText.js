///////////////////////////       New //////////////////////////////////////////


function isAlphabetWithSpace(elem,title){
	var alphaExp = /^[a-zA-Z]{1}[a-zA-Z ]*$/;
	if(elem.match(alphaExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Character and Space allowed';
		return false;
	}
}

function isAlphanumericWithSpace(elem,title)
{
		var alphaExp = /^[0-9a-zA-Z]{1}[0-9a-zA-Z ]*$/;
	if(elem.match(alphaExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Only alphabets ,number and space allowed';
		return false;
	}
}

function isAlphanumeric(elem,title){
	var alphaExp = /^[0-9a-zA-Z]+$/;
	
	if(elem.match(alphaExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		
		document.getElementById(title).innerHTML='Character and number allowed';
		return false;
	}
}

function isNumeric(elem,title){
	var numericExpression = /^[0-9]+$/;
	if(elem.match(numericExpression)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Only Number allowed';
		return false;
	}
}

function emailValidator(elem,title){
	var emailExp = /^[a-zA-Z0-9]{1}[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$/;
	if(elem.match(emailExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Invalid Format of Email';
		return false;
	}
}

function mobileValidator(elem,title){
	var emailExp = /^[6-9]{1}[0-9]{9}/;
	if(elem.match(emailExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Invalid Format of Mobile';
		return false;
	}
}

function pincodeValidator(elem,title){
	var emailExp = /^[0-9]{6}/;
	if(elem.match(emailExp)){
	document.getElementById(title).innerHTML="";
		return true;
	}else{
		document.getElementById(title).innerHTML='Invalid Format of Pincode';
		return false;
	}
}


//////////////////////////////////////////  Old ////////////////////////////////////////////





function notEmpty(elem, helperMsg){
	if(elem.value.length == 0){
		alert(helperMsg);
		elem.focus(); // set the focus to this input
		return false;
	}
	return true;
}


function isDecimal(elem, helperMsg)
{
	var numericExpression = /^[-+]?[0-9]*[.,]?[0-9]+/;
	if(elem.match(numericExpression)){
		return true;
	}else{
		alert(helperMsg);
		elem.focus();
		return false;
	}
}

function lengthRestriction(elem, min, max){
	var uInput = elem.value;
	if(uInput.length >= min && uInput.length <= max){
		return true;
	}else{
		alert("Please enter between " +min+ " and " +max+ " characters");
		elem.focus();
		return false;
	}
}

function madeSelection(elem, helperMsg){
	if(elem.value == "Please Choose"){
		alert(helperMsg);
		elem.focus();
		return false;
	}else{
		return true;
	}
}



function checkdate(elem)
{
    var allowBlank=true;
    var minYear=1902;
    var maxYear=(new Date()).getFullYear();
    var errorMsg="";
    re=/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
    if(elem.value!='')
        {
            if(regs=elem.value.match(re))
                {
                    if(regs[1]<1||regs[1]>31)
                        {
                            errorMsg="invalid value for day:"+regs[1];

                        }
                      else if(regs[2]<1||regs[2]>12)
                          {
                           errorMsg="invalid value for month:"+regs[2];
                          }
                          else if(regs[3]<minYear||regs[3]>maxYear)
                              {
                                  errorMsg="invalid value for month:"+regs[3]+"-must be between"+minYear+"and"+maxYear;
                              }
                }
                else{
                   errorMsg="invalid date format:"+elem.value;
                }}
              else if(!allowBlank)
                {
                   errorMsg="empty date note allowed!"
                }
                if(errorMsg!="")
                    {
                        alert(errorMsg);
                        elem.focus();
                        return false;

                    }
                    return true;
                }


 function checkTime(elem)
                {
                    var errorMsg="";
                    re=/^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
                    if(elem.value!='')
                        {
                            if(regs=elem.value.match(re))
                                {
                                         if(regs[1]>23)
                                         {
                                           errorMsg="invalid value for hours:"+regs[1];
                                         }       if(!errorMsg && regs[2] > 59)
                                         {
                                            errorMsg="invalid value for minutes:"+regs[2];
                                         }
                                     }
                                     else{
                                         errorMsg="invalid time format"+elem.value;
                                     }}
                                 if(errorMsg!="")
                                     {
                                         alert(errorMsg);
                                         elem.focus();
                                         return false;

                                     }
                                     return true;
                }
