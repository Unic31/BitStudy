$(function () {
    //h1.title클릭시 음악 목록이 나오도록 한다
    $("h1.title").click(function () {
        $("ul.music-list").slideDown('slow')
    });

    //곡 선택시 이벤트
    $("ul.music-list li").click(function () {
        //노래 제목을 얻어서 h1.title 넣기
        let title = $(this).text();
        $("h1.title").text(title);

        //class를 얻어서 #cd에 class로 주기
        let selectClass=$(this).attr("class");
        // $("#cd").attr("class",selectClass)

        //cd가 change 되는 효과를 주기 위해서 animate를 이용
        $("#cd").animate({"width":"0"},'slow',function(){
            //cd변경
            $("#cd").attr("class",selectClass)
            //다시 너비 조절
            $(this).animate({width:'300px'},'slow');

        })




        $(this).parent().slideUp('slow')
    })





})