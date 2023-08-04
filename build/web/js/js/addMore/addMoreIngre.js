                                var max_fields = 7; // Số lượng tối đa các ô input
                                var inputContainer = document.querySelector("#inputIngredient"); // Các ô input sẽ được đặt vào wrapper này
                                var x = 2; // Biến đếm số lượng ô input hiện tại
                                function addMoreIngredients() {
                                    var newInput = document.createElement("div");
                                    newInput.className = 'row';
                                    newInput.style = 'margin-top: 20px; margin-bottom: 20px; margin-left: 3px';
                                    newInput.innerHTML =
                                            '<div class="col-7" style="margin-left: -25px">' +
                                            '<select class="form-control" name="ingredientName"> <c:forEach var="item" items="${LIST_NUTRITIONAL}"> <option value="${item.name}">${item.name}</option> </c:forEach> </select>' +
                                            '</div>' +
                                            '<div class="col-2">' +
                                            '<input class="form-control" type="number" step="0.1" name="quantity" min="1" placeholder="Amount" style="margin-left: 10px">' +
                                            '</div>' +
                                            '<div class="col-2" style="display: inline-table,margin-top: 2px">' +
                                            '<select class="form-control" name="unit"> <option value="Gram">Gram (g)</option> <option value="Kilogram">Kilogram (kg)</option> <option value="Pound">Pound (lb)</option> <option value="Milliliter">Milliliter (ml)</option> <option value="Liter">Liter </option> <option value="Cup">Cup </option> <option value="Teaspoons">Teaspoons (tsp)</option> <option value="Tablespoons">Tablespoons (tbsp)</option> <option value="Part">Part</option></select>' +
                                            '</div>' +
                                            '<button type="button" onclick="removeIngredient(this)" style="margin:auto; display: table;">Remove</button>';
                                    if (x <= max_fields) { // Kiểm tra số lượng ô input đã đạt tối đa chưa
                                        // Thêm ô input mới
                                        inputContainer.appendChild(newInput);
                                        x++;
                                        console.log(x);
                                    } else {
                                        alert('Can not create more');
                                    }
                                }

                                function removeIngredient(element) {
                                    var inputContainer = document.querySelector("#inputIngredient");
                                    inputContainer.removeChild(element.parentNode);
                                    x--;
                                }
