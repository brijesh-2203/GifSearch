$(document).ready(function ()
{
   $("input").on('keyup',function (e)
   {
       var val = $("#search-id").val();
       e.preventDefault()
       $.ajax({
           type: "GET",
           url: "/gif/"+val,
           success: function(data) {
               $("#gif").html('');
               if(data.length ==0){
                   $("#gif").text("GIF not found.....");
               }
                for(var i = 0, j = data.length; i < j; i++) {

                     $("#gif").append("<img src='" + data[i] + "'  width='200' height='170' class='gif-dg'>");
                 }
           },
           error: function(textStatus) {
               $("#gif").html('');
           },
           processData: false,
           contentType: false
       });
   })

})