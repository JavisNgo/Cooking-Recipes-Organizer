/* global inputElement */

//document.addEventListener('DOMContentLoaded', function () {
//    var max_fields = 7; // maximum input boxes allowed
//    var wrapper = document.querySelector('.input_fields_wrap_Step'); // Fields wrapper
//    var add_button = document.querySelector('.add_field_button_Step'); // Add button ID
//
//    var x = 1; // initial text box count
//    add_button.addEventListener('click', function (e) {
//        e.preventDefault();
//        for (var x = 0; x <= max_fields; x++) { 
//            var size = size[x];
//            
//            var inputValue = size.textContent;
//            
//            var newDiv = document.createElement('div');
//            newDiv.setAttribute('class', 'row');
//            newDiv.setAttribute('style', 'margin-top:20px');
//            newDiv.setAttribute('style', 'margin-bottom:20px');
//            newDiv.value = inputValue;
//            
//            var col1 = document.createElement('div');
//            col1.setAttribute('class', 'col-3'); 
//            col1.setAttribute('style', 'margin-left:20px');
//            col1.value = inputValue;
//            
//            
//            var inputStepNumber = document.createElement('input');
//            inputStepNumber.setAttribute('class', 'form-control');
//            inputStepNumber.setAttribute('type', 'number');
//            inputStepNumber.setAttribute('min', '1');
//            inputStepNumber.setAttribute('name', 'stepNumber');
//            inputStepNumber.setAttribute('placeholder', 'Step...');
//            inputStepNumber.setAttribute('value', '' + x);
//            inputStepNumber.value = inputValue;
//
//            col1.appendChild(inputStepNumber);
//            newDiv.appendChild(col1);
//
//            var col2 = document.createElement('div');
//            col2.setAttribute('class', 'col-7');
//
//            var inputInstructions = document.createElement('input');
//            inputInstructions.setAttribute('class', 'form-control');
//            inputInstructions.setAttribute('type', 'text');
//            inputInstructions.setAttribute('name', 'instructions');
//            inputInstructions.setAttribute('placeholder', 'Instructions');
//
//            col2.appendChild(inputInstructions);
//            newDiv.appendChild(col2);
//
//            var removeLink = document.createElement('a');
//            removeLink.setAttribute('href', '#');
//            removeLink.setAttribute('class','remove_field');
//            removeLink.setAttribute('style', 'margin:auto');
//            removeLink.setAttribute('style', 'display:table');
//            removeLink.textContent = 'Remove';
//
//            newDiv.appendChild(removeLink);
//
//            wrapper.appendChild(newDiv); // add input box
//            x++;
//        }
//    });
//
//    wrapper.addEventListener('click', function (event) {
//        if (event.target.classList.contains('remove_field')) { // user click on remove text
//            event.preventDefault();
//            event.target.parentElement.remove();
//            x--;
//        }
//    });
//});
//
//
//
$(document).ready(function () {
    var max_fields = 7; //maximum input boxes allowed
    var wrapper = $(".input_fields_wrap_Step"); //Fields wrapper
    var add_button = $(".add_field_button_Step"); //Add button ID

    var x = 2; //initlal text box count
    $(add_button).click(function (e) { //on add input button click
        e.preventDefault();
        if (x <= max_fields) { //max input box allowed
            //text box increment
            $(wrapper).append('<div class="col-2 hihi">' +
                    '<input class="form-control" type="text" disabled value="' + x + '" name="stepNumber"/>' +
                    '<input class="form-control" type="hidden" value="' + x + '" name="stepNumber"/>' +
                    '</div>' +
                    '<div class="col-10 hihi1" style="display:flex;">' +
                    '<input class="form-control" type="text" name="instructions" placeholder="Instructions...." required/>' 
                    + '<button type="button" onclick="removeSteps(this)" style="margin:auto; display: table;">Remove</button>' +
                    ' </div>'
                    ); //add input box
            x++;
        }
    });

    $(wrapper).on("click", ".remove_field", function (e) { //user click on remove text
        e.preventDefault();
        $(this).parent('div').remove();
        x--;
    });
});





