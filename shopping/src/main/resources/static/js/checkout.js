document.getElementById("cart_total_price").innerText = localStorage.getItem('finalTotal');
document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");

$("#cart_total_button").click(function() {
	//console.log(document.getElementById("addrNum").value +document.getElementById("addr").value);
	var a ;
	var b ;
	a=document.getElementById("name").value;
	b=document.getElementById("addrNum").value+document.getElementById("addr").value;
	$.ajax({
		url: "/api/orderdetails/"+319,
		type: "put",
		contentType: "application/json; charset=utf-8",
		//dataType: "json",
		data: JSON.stringify({
			"orderdetailsid": 319,
			"orderid":78,
			"name":a ,
			"address":b
			
		}),
		success: function() {
			window.location.href = "http://localhost:8080/order.html";
		}
	})
	
})