$(document).ready(function() {
	var max_fields      = 12; //maximum input boxes allowed
	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
	var add_button      = $(".add_field_button"); //Add button ID
	
	var x = 1; //initlal text box count
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
		if(x <= max_fields){ //max input box allowed
			x++; //text box increment
			$(wrapper).append('<div class="col-5" style="margin-left: -25px">' +
                        '<select class="form-control" name="ingredientName"> <c:forEach var="item" items="${LIST_NUTRITIONAL}"> <option value="${item.name}">${item.name}</option> </c:forEach> </select>' +
                        '</div>' +
                        '<div class="col-2">' +
                        '<input class="form-control" type="number" step="0.1" name="quantity" min="1" placeholder="Amount" style="margin-left: 10px">' +
                        '</div>' +
                        '<div class="col-2" style="display: inline-table,margin-top: 2px">' +
                        '<select class="form-control" name="unit"> <option value="Gram">Gram (g)</option> <option value="Gram">Kilogram (kg)</option> <option value="Gram">Pound (lb)</option> <option value="Gram">Milliliter (ml)</option> <option value="Gram">Liter </option> <option value="Gram">Cup </option> <option value="Gram">Teaspoons (tsp)</option> <option value="Gram">Tablespoons (tbsp)</option> <option value="Gram">Part</option></select>' +
                        '</div>'+
                        '<a href="#" class="remove_field" style="margin:auto; display: table;">Remove</a></div>' //add input box
		); //add input box
            x++;
        }
	});
	
	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	})
});

