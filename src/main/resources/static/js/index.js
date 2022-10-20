
if(localStorage.getItem("cartNum")==undefined){
	document.getElementById('cartNum').innerText = 0;
}else{
	document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");
};
const p1 = 1450;
const p2 = 145000;
const p3 = 3600;
document.getElementById('product_price1').innerText=p1.toLocaleString();
document.getElementById('product_price2').innerText=p2.toLocaleString();
document.getElementById('product_price3').innerText=p3.toLocaleString();


function populateStorage1() {
    
    localStorage.setItem('name1', document.getElementById('product_name1').innerText);
    localStorage.setItem('price1', p1);
    localStorage.setItem('image1', new URL(document.getElementById('product_image1').src).pathname);

    (localStorage.getItem("cartNum") == undefined) ?  localStorage.setItem("cartNum", 1) : localStorage.setItem("cartNum",parseInt(localStorage.getItem("cartNum"))  + 1) ;

    document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");
    document.getElementById('cart_numf').innerText = localStorage.getItem("cartNum");
}

function populateStorage2() {
   
    localStorage.setItem('name2', document.getElementById('product_name2').innerText);
    localStorage.setItem('price2', p2);
    localStorage.setItem('image2', new URL(document.getElementById('product_image2').src).pathname);

    (localStorage.getItem("cartNum") == undefined) ?  localStorage.setItem("cartNum", 1) : localStorage.setItem("cartNum",parseInt(localStorage.getItem("cartNum"))  + 1) ;

    document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");
    document.getElementById('cart_numf').innerText = localStorage.getItem("cartNum");
}

function populateStorage3() {
    
    localStorage.setItem('name3',  document.getElementById('product_name3').innerText);
    localStorage.setItem('price3', p3);
    localStorage.setItem('image3', new URL(document.getElementById('product_image3').src).pathname);

    (localStorage.getItem("cartNum") == undefined) ?  localStorage.setItem("cartNum", 1) : localStorage.setItem("cartNum",parseInt(localStorage.getItem("cartNum"))  + 1) ;

    document.getElementById('cartNum').innerText = localStorage.getItem("cartNum");
    document.getElementById('cart_numf').innerText = localStorage.getItem("cartNum");
}





