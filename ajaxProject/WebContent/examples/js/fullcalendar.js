let events = [];
var calendar;

// 모달 자바스크립트.
function showModal(args) {
   var modal = document.getElementById("myModal");
   modal.style.display = "block";
   var span = document.getElementsByClassName("close")[0];
   span.onclick = function() {
      modal.style.display = "none";
   }
   window.onclick = function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
   }
   
   var saveBtn = document.getElementById('saveBtn');
   saveBtn.onclick = function() {
      let title = document.getElementById('title').value;
      let start = document.getElementById('startDate').value;
      let end = document.getElementById('endDate').value;
      console.log(title, start, end);
      if (title) {
         calendar.addEvent({
            title: title,
            start: start,  //arg.start,
            end: end,   //arg.end,
            allDay: false  //arg.allDay
         });
         // db에 새로운 한건 등록.
         // console.log(title, start, end);
         createSchedule(title, start, end);
      }
      calendar.unselect();
   }
}

// 1. title, start_date, end_date 가지고 오는 method 만들기 => EmpDao.getSchedules()
// 2. json 타입으로 [{title: 값, start: 값, end: 값}, {}, {}, ...] => GetScheduleServlet
// 3. events: javascript의 object 타입으로 할당

document.addEventListener('DOMContentLoaded', function() {
   var calendarEl = document.getElementById('calendar');

   let xhtp = new XMLHttpRequest();
   xhtp.onreadystatechange = function(){
   if(xhtp.readyState == 4 && xhtp.status == 200){
      let data = xhtp.response;
      data.forEach(function(item){   //item이 events 배열에 넣어져야함
         events.push(item);
      });
      console.log(events);
      // events에 값을 할당하고 그 다음 메소드 호출
      
      calendar = new FullCalendar.Calendar(calendarEl, {
         headerToolbar: {
           left: 'prev,next today',
           center: 'title',
           right: 'dayGridMonth,timeGridWeek,timeGridDay'
         },
         initialDate: '2020-11-12',
         navLinks: true, // can click day/week names to navigate views
         selectable: true,
         selectMirror: true,
         select: function(arg) {
            // var title = prompt('스케줄 등록하세요.:"');
            // var start = prompt('시작일정: ');
            // var end = prompt('종료일정: ');

            showModal(arg);

           if (title) {
                calendar.addEvent({
               title: title,
               start: arg.start,
               end: arg.end,
               allDay: arg.allDay
             });
         // db에 새로운 한 건 등록 -> PutScheduleServlet
         // console.log(title, start, date);
         // createSchedule(title, start, end);
        }
        calendar.unselect()
      },
      eventClick: function(arg) {
        if (confirm('Are you sure you want to delete this event?')) {
          arg.event.remove();
let start = arg.event.start;
let title = arg.event.title;
if(start.getDate()<10)
  start = start.getFullYear()+'-'+(start.getMonth()+1) +'-0' + start.getDate();
else
  start = start.getFullYear()+'-'+(start.getMonth()+1) +'-' + start.getDate();

console.log(arg);
      // db에서 한 건 삭제 -> 서블릿
	   deleteSchedule(title, start);
        }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: events
    });   // calendar() 메소드 호출

    calendar.render();
   }
   
   }
   xhtp.responseType = 'json';
   xhtp.open('get', '../../GetScheduleServlet');
   xhtp.send();

});

function createSchedule(v1, v2, v3){
   let xhtp = new XMLHttpRequest();
   xhtp.onreadystatechange = function(){
      if(xhtp.readyState == 4 && xhtp.status == 200){
         console.log(xhtp);
         console.log(xhtp.response);
      }
   } 
   xhtp.open('get', '../../PutScheduleServlet?title='+v1+'&start='+v2+'&end='+v3);
   xhtp.send();
}

function deleteSchedule(v1, v2) {
   let xhtp = new XMLHttpRequest();
   xhtp.onreadystatechange = function(){
      if(xhtp.readyState == 4 && xhtp.status == 200){
         console.log(xhtp);
      }
   }
   xhtp.open('get', 'DeleteScheduleServlet?title='+v1+'&start='+v2);
   xhtp.send();
}
