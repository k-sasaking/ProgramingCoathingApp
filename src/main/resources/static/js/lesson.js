// 表示/非表示ボタン
function clickView(id, text){
    var btn = id+'btn';
    var view = document.getElementById(id);
    var viewBtn = document.getElementById(btn);
    if(view.style.display=='none'){
        view.style.display = 'block';
        viewBtn.innerText = text + 'を非表示';
    }else{
        view.style.display = 'none';
        viewBtn.innerText = text + 'を表示';
    }
}

// 解答を表示
function clickAns(id){
    clickView(id, '解答');
}

// ヒントを表示
function clickAns(id){
    clickView(id, 'ヒント');
}

// 余談を表示
function clickYodan(id){
    clickView(id, '余談');
}

// テキストエリアを可変にする
//var lineHeight = parseInt(textarea.css('lineHeight'));
//textarea.on('keydown', function(e) {
//alert('aaa');
//var lines = ($(this).val() + '\n').match(/\n/g).length;
//$(this).height(lineHeight * lines);
//});

var sectionContent = document.getElementById('sectionContent');
var fitTextarea = function(){
     rownum = sectionContent.value.match(/\r\n|\n/g);
     if(rownum.length > 10){
        sectionContent.rows = rownum.length;
     }
}
sectionContent.addEventListener('keyup', fitTextarea)
fitTextarea();