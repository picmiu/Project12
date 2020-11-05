function showList(result){
         //console.log(result);
         let data = result;
         console.log(data);
         let ul = $('<ul />');
         data.forEach(function(item,idx){
            let li = $('<li />').html(item.id + ", ")
                           .attr('id',item.id);   
            //li.mouseover(function(){})
            $(li).on({
            'mouseover':mouseOverFunc,
            'mouseout' :function(){
               $(this).css('background','');
               }
            });
            let aTag = $('<a />').html(item.firstName)
            .attr('href','empInfo.jsp?id='+item.id);
            //li.mouseover(function)
            li.append(aTag);
            ul.append(li);
            
            localStorage.setItem('eid' + item.id, item.id);
            localStorage.setItem('efName' + item.id, item.efName);
            localStorage.setItem('elName' + item.id, item.elName);
            localStorage.setItem('esalary' + item.id, item.esalary);
            localStorage.setItem('eemail' + item.id, item.eemail);
            
         });
         $('#result').append(ul);
         };
         
function mouseOverCallback(event){
   let eid = localStorage.getItem('eid' + event.currentTarget.id);
   let efName = localStorage.getItem('efName' + event.currentTarget.efName);
   let elName = localStorage.getItem('elName' + event.currentTarget.elName);
   let esalary = localStorage.getItem('esalary' + event.currentTarget.esalary);
   let eemail = localStorage.getItem('eemail' + event.currentTarget.eemail);
   
            $('#eid').val(eid);
            $('#efName').val(efName);
            $('#elName').val(elName);
            $('#esalary').val(esalary);
            $('#eemail').val(eemail);
   
   
}

function mouseOverFunc() {
   $(this).css('background', 'yellow');
   let id = $(this).attr('id');
   
   $.ajax({
      url: 'GetEmpInfoServlet',
      data: {
         id: id
      },
      success: function (result) {
         console.log(result);
         //   jquery_index.html input 태그의 value 속성에 값을 할당.
               $('#eid').val(result.id);
               $('#efName').val(result.firstName);
               $('#elName').val(result.lastName);
               $('#esalary').val(result.salary);
               $('#eemail').val(result.email);
      },
      dataType: 'json'
   });
};
function mof(item){
   console.log(item);
   $(this).css('background','yellow');
   let id = $(this).attr('id');
      $.ajax({
         url:'GetEmpInfoServlet',
         data:{id:id},
         success:function(result){
            console.log(result);
            $('#eid').val(result.id);
            $('#efName').val(result.firstName);
            $('#elName').val(result.lastName);
            $('#esalary').val(result.salary);
            $('#eemail').val(result.email);
         //jquery_index.html input태그의 value속성에 값을 할당
            
            
         },
      dataType : 'json'
   });
};