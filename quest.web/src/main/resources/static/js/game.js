var appendGames =function(data){
$(".row").empty();
for (i = 0; i < data.length; i++) {
    $(".row").append(
        "<div class='col-sm-3' style='background-color:lavender;'" + "onclick = showModel("+ "'"+ data[i].id + "'" + ")>" +
           "<div>" +
               " <p>" + data[i].name +"</p> " +
               " <p>Type</p>" +
                "<p>"+data[i].location+"</p>"+
                "<p>"+data[i].questDescribe+"</p>" +
                "<p>"+data[i].price+"</p>"+
            "</div>"+
        "</div>");
    }
}

var getGames = function(){
    $.ajax({
      method: "get",
      url: "/list",
      data: {'dateFrom' : $("#dateFrom").val()},
      success: appendGames
    });
}


$(document).ready(function() {
    getGames();
    $("#gameFilter").click(getGames);
});

var showModel = function(id){
    setQuestFormAction(id);
    $("#myModal").modal("show");
}

var setQuestFormAction =function(id){
    var href = "/play?quest="+id;
    $('#guestPlay').attr("href", href);
}
