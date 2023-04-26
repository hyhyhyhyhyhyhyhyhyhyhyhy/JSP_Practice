<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='/fullcal/dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar');

        // allEvents 초기화
        let allEvents = [{
          title: 'title1',
          start: '2023-04-05',
          end: '2023-04-10'
        }];
        // 서버의 json 데이터를 가져오기 위한 fetch.
        fetch('eventList.do')
        .then(resolve => resolve.json())
        .then(result => {
          result.forEach(event => {
            let newEvent = {
              title: event.title,
              start: event.StartDate,
              end: event.endDate
            }
            allEvents.push(newEvent);
          }); // end of forEach

          // Start..
        var calendar = new FullCalendar.Calendar(calendarEl, {
          headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
          },
          initialDate: new Date(),
          navLinks: true, // can click day/week names to navigate views
          selectable: true,
          selectMirror: true,
          select: function (arg) {
            var title = prompt('이벤트 등록: ');
              console.log(title, arg.startStr, arg.endStr);
              // Ajax호출.
              fetch('addEvent.do', {
                  method: "POST",
                  headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                  },
                  body: 'title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr
                })
                .then(resolve => resolve.json())
                .then(result => {
                    if (result.retCode == 'Success') {
                      // 화면에 추가된 이벤트 등록
                      if(title){
                      calendar.addEvent({
                        title: title,
                        start: arg.start,
                        end: arg.end,
                        allDay: arg.allDay
                      })
                    }
                  } else {
                    alert('실패!');
                  }
                })
            .catch(err => console.log(err));

            calendar.unselect()
          },
          eventClick: function (arg) {
            if (confirm('이벤트를 삭제?')) {
              arg.event.remove()
            }
          },
          editable: true,
          dayMaxEvents: true, // allow "more" link when too many events
          events: allEvents
        });
        calendar.render();
        // end ..
      }) // end of then
      .catch(error => console.log(error))
    }); // end of addEventListener.

  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

</body>

</html>