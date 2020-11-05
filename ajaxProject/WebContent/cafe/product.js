// product.js
// /GetProdListServlet
// /cafe/index.html
$.ajax({
	url:'../GetProdListServlet',
	dataType: 'json',
	data: {'category': category},
	success: function(result) {
		console.log(category);
		for (obj of result)
			createRow(obj);	
	}
});

function createRow(obj) {
	let div1 = $('<div	/>').attr('col-lg-4 col-md-6 mb-4');
	let div2 = $('<div	/>').attr('class', 'card h-100');
	let div2_a = $('<a />').attr('href', 'getProd.jsp?item_no=' + obj.itemNo);
	let img = $('<img />').attr({'class': 'card-img-top',
      							 'src': '../images/'+ obj.itemImg}); // attr두번써도됨.
	let div2_div = $('<div />').attr('class', 'card-body');
	let h4 = $('<h4 />').attr('class', 'card-title');
	let h4_a = $('<h4_a />').attr('href', '#').html('Item One');
	let price = new Intl.NumberFormat('ko-KR',
					 { style: 'currency', currency: 'KRW' }).format(obj.price);
	let h5 = $('<h5 />').html(price);
	let p = $('<p />').attr('class', 'card-text').html(obj.itemDesc);
	let div2_div1 = $('<div />').attr('class', 'card-footer');
	let ic = "";
	for(let i = 0; i < like; i++) {
		ic += '<i style="font-size:24px" class="fas">&#xf164;</i>';
		star += '&#xf164;';
	}
	if(obj.likeIt > like) {
		ic += '<i style="font-size:24px" class="far">&#xf164;</i>';
		star += '&#xf164;';
	}
	let small = $('<small />').attr('class','text-muted').html(ic);
	let like = Math.floor(obj.likeIt);
	
	
	//	부모 관계를 생성.
	div1.append(div2);
	div2.append(div2_a, div2_div, div2_div1);
	div2_a.append(img);
	div2_div.append(h4, h5, p);
	h4.append(h4_a);
	div2_div1.append(small);
	
	$('#data').append(div1);
}

let aTag = $('#navbarResponsive a');
aTag.on('click', function () {
	$('#navbarResponsive>ul>li').removeClass('active');
	$(this).parent().addClass('active');
})
