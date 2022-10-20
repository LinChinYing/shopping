/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Quantity


******************************/
//三位一撇
function separator(numb) {
	var str = numb.toString().split(".");
	str[0] = str[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return str.join(".");
}

//把選取的商品巡訪出來
for (var i = 0; i < parseInt(localStorage.getItem("cartNum")); i++) {
	document.getElementById("cartUi").innerHTML +=
		`<li
            class=" cart_product d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-start">

            <div class="cart_product_image"><img width="50" height="50" src="${localStorage.getItem('image' + (i + 1))}" alt=""></div>

            <div class="cart_product_name" id="productName"><a href="product.html">${localStorage.getItem('name' + (i + 1))}</a></div>
            <div class="cart_product_info ml-auto">
                <div
                    class="cart_product_info_inner d-flex flex-row align-items-center justify-content-md-end justify-content-start">

                    <div id="cart_product_price${i}" class="cart_product_price">${localStorage.getItem('price' + (i + 1))}</div>

                    <div class="product_quantity_container">
                        <div class="product_quantity clearfix">
                            <input id="quantity_input${i}" type="text" pattern="[0-9]*" value="1">
                                <div class="quantity_buttons">
                                    <div id="quantity_inc_button${i}"
                                        class="quantity_inc quantity_control"
                                        onclick="qtychangeup(${i})"><i
                                            class="fa fa-caret-up" aria-hidden="true"></i></div>
                                    <div id="quantity_dec_button${i}"
                                        class="quantity_dec quantity_control"
                                        onclick="qtychangedown(${i})"><i
                                            class="fa fa-caret-down" aria-hidden="true"></i></div>
                                </div>
                        </div>
                    </div>

                    <div class="cart_product_total" id="cart_product_total${i}">${localStorage.getItem('price' + (i + 1))}</div>

                    <div class="cart_product_button">
                        <button class="cart_product_remove"><img src="images/trash.png"
                            alt=""></button>
                    </div>
                </div>
            </div>
        </li>`

}

//商品單價
for (var i = 0; i < parseInt(localStorage.getItem("cartNum")); i++) {
	let a = 0;
	a = parseInt(localStorage.getItem('price' + (i + 1)));
	document.getElementById("cart_product_price" + i).innerText = separator(a);
	document.getElementById("cart_product_total" + i).innerText = separator(a);
}


//小計跟總計
var g = 0;
var i = 0;
for (var z = 0; z < parseInt(localStorage.getItem("cartNum")); z++) {
	i = i + parseInt(localStorage.getItem('price' + (z + 1)));
}
document.getElementById("total").innerText = separator(i);
document.getElementById("finalTotal").innerText = separator(i);
localStorage.setItem('total', i);
localStorage.setItem('finalTotal', i);
//數量增加
function qtychangeup(num) {
	$('#quantity_input' + num).val(parseInt(document.getElementById("quantity_input" + num).value) + 1);
	let tol = $('#quantity_input' + num).val() * localStorage.getItem('price' + (num + 1));
	document.getElementById("cart_product_total" + num).innerText = separator(tol);
	var i = 0;
	for (var z = 0; z < parseInt(localStorage.getItem("cartNum")); z++) {
		i = i + parseInt($('#quantity_input' + z).val() * localStorage.getItem('price' + (z + 1)));
	}
	document.getElementById("total").innerText = separator(i);
	document.getElementById("finalTotal").innerText = separator(i);
	localStorage.setItem('total', i);
	localStorage.setItem('finalTotal', i);
}

//數量減少
function qtychangedown(num) {
	$('#quantity_input' + num).val(parseInt(document.getElementById("quantity_input" + num).value) - 1);
	let tol = $('#quantity_input' + num).val() * localStorage.getItem('price' + (num + 1));
	document.getElementById("cart_product_total" + num).innerText = separator(tol);
	var i = 0;
	for (var z = 0; z < parseInt(localStorage.getItem("cartNum")); z++) {
		i = i + parseInt($('#quantity_input' + z).val() * localStorage.getItem('price' + (z + 1)));
	}
	document.getElementById("total").innerText = separator(i);
	document.getElementById("finalTotal").innerText = separator(i);
	localStorage.setItem('total', i);
	localStorage.setItem('finalTotal', i);
}


$(document).ready(function() {
	"use strict";

	/* 
	
	1. Vars and Inits
	
	*/

	var header = $('.header');
	var menuActive = false;
	var menu = $('.menu');
	var burger = $('.burger_container');

	document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");

	//優惠代碼
	$("#cart_button_2").click(function() {
		if ($(".cart_coupon_input").val() == "flirtatious888") {
			var i = 0;
			i = parseInt(localStorage.getItem('total')) * 8 / 10;
			localStorage.setItem('finalTotal', i);
			document.getElementById("finalTotal").innerText = separator(i);

		} else {
			/*
			document.getElementById("finalTotal").innerText = document.getElementById("total").innerText;
			localStorage.setItem('finalTotal', document.getElementById("finalTotal").innerText);
			*/
		}

	})

	//把資料送到資料庫
	$("#cartBtn").click(function() {
		//localStorage.setItem('finalTotal', document.getElementById("finalTotal").innerText);
		var c = 0;

		c = c + parseInt(document.getElementById("finalTotal").innerText);

		function settimeout() {
			$.ajax({
				url: "/api/orders",
				type: "post",
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify({
					"orderid": 0,
					"total": c
				}),
				success: function(data) {
					g = data.orderid;
				}
			})
		}
		setTimeout(settimeout, 1);
		function settimeout2() {
			for (let num = 0; num < parseInt(localStorage.getItem("cartNum")); num++) {

				$.ajax({
					url: "/api/orderdetails",
					type: "post",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify({
						"orderid": g,
						"lname": localStorage.getItem("name" + (num + 1)),
						"quantity": document.getElementById("quantity_input" + num).value
					}),
					success: function() {
						window.location.href = "http://localhost:8080/checkout.html";
					}

				});

			}
		}
		setTimeout(settimeout2, 100);
	})


	setHeader();

	$(window).on('resize', function() {
		setHeader();
	});

	$(document).on('scroll', function() {
		setHeader();
	});

	initMenu();
	// initQuantity();

	/* 
	
	2. Set Header
	
	*/

	function setHeader() {
		if ($(window).scrollTop() > 100) {
			header.addClass('scrolled');
		}
		else {
			header.removeClass('scrolled');
		}
	}

	/* 
	
	3. Init Menu
	
	*/

	function initMenu() {
		if ($('.menu').length) {
			var menu = $('.menu');
			if ($('.burger_container').length) {
				burger.on('click', function() {
					if (menuActive) {
						closeMenu();
					}
					else {
						openMenu();

						$(document).one('click', function cls(e) {
							if ($(e.target).hasClass('menu_mm')) {
								$(document).one('click', cls);
							}
							else {
								closeMenu();
							}
						});
					}
				});
			}
		}
	}

	function openMenu() {
		menu.addClass('active');
		menuActive = true;
	}

	function closeMenu() {
		menu.removeClass('active');
		menuActive = false;
	}

	/* 
	
	4. Init Quantity
	
	*/

	// function initQuantity(num) {
	// 	// Handle product quantity input
	// 	if ($('.product_quantity').length) {
	// 		var input = $('#quantity_input'+ num);
	// 		var incButton = $('#quantity_inc_button'+ num);
	// 		var decButton = $('#quantity_dec_button'+ num);

	// 		var originalVal;
	// 		var endVal;

	// 		incButton.on('click', function() {
	// 			originalVal = input.val();
	// 			endVal = parseFloat(originalVal) + 1;
	// 			input.val(endVal);
	// 		});

	// 		decButton.on('click', function() {
	// 			originalVal = input.val();
	// 			if (originalVal > 0) {
	// 				endVal = parseFloat(originalVal) - 1;
	// 				input.val(endVal);
	// 			}
	// 		});
	// 	}
	// }
});