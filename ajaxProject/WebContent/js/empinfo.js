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