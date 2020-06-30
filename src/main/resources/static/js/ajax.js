/* Ajaxの処理 */
$(function(){
   // Pyblish/Unpublishボタンが押された時
   $('.btn-fav').click(function(){

        var id = $(this).attr('id');
        var username = $('#username').text();
        var result = false
        
        // Ajaxの定義
        $.ajax({
          type: "GET",
          url: '/favorite/' + id + '?username=' + username,
          async: true,
          dataType: 'json',
          // successの処理
          success: function(data) {
              success(data, id);
          },
          // errorの処理
          error: function(XMLHttpRequest, textStatus, errorThrown) {
              error(XMLHttpRequest, textStatus, errorThrown);
          }
        });
   });

});


// Ajax通信成功時処理
function success(data, id) {
    var classname = $('#'+id).children('i').attr("class");
    alert('お気に入りに登録しました。')
    if(classname.indexOf('far')> -1){
        $('#'+id).children('i').removeClass('far');
        $('#'+id).children('i').addClass('fa');
   }
   else{
	    alert('お気に入りから外しました。')
        $('#'+id).children('i').removeClass('fa');
        $('#'+id).children('i').addClass('far');
   }

}

// Ajax通信失敗時処理
function error(XMLHttpRequest, textStatus, errorThrown) {
 alert("error" + textStatus);   
}