function changeDate(e){
    var button = document.getElementById('button');
    var href = '/page/1?sort-field=id&sort-dir=asc';
    var inputFrom = document.getElementById('from');
    var inputTo = document.getElementById('to');
    var str = href + '&date-start='
        + inputFrom.value + '&date-finish=' + inputTo.value
    button.setAttribute('href', str);
}

function openForm() {
    document.getElementById("myForm").style.display = 'block';
  }

function openFormEdit(text, id) {
    document.getElementById("myFormEdit").style.display = 'block';
    document.getElementById("txt-a").value = text;
    document.getElementById("form-action-dairy").action = '/edit/' + id;

}

  function closeForm() {
    document.getElementById("myForm").style.display = 'none';
      document.getElementById("myForm").style.visibility = "hidden";
      document.getElementById("myFormEdit").style.display = 'none';
  }

let order = false
function changeOrder(){
    // console.log('aboba')
    order = !order
    // this.getAttribute(${order}) = ![[${order}]];
    // [[${order}]] = ![[${order}]];
    // var el = document.getElementById("cont_post")
    // while (el.firstChild) {
    //     el.removeChild(el.firstChild);
    // }
    // var str_a = '<div class="container px-4 py-5">\n' +
    //     '    <h2 class="pb-2 border-bottom text-white">Дни</h2>\n' +
    //     '<div th:each="el,iter : ${dairy_entries}" class="row align-items-md-center g-5 py-5 model-content rounded-4 shadow m-5 bg-white">\n' +
    //     '    <div class="col-10 d-flex flex-column align-items-start gap-2">\n' +
    //     '        <h3 th:text="\'Запись \' + ${iter.index + 1}" class="fw-bold"></h3>\n' +
    //     '        <p th:text="${el.textEntry}" class="text-muted"></p>\n' +
    //     '    </div>\n' +
    //     '    <div class="col-1 d-flex flex-column gap-2">\n' +
    //     '        <h4 class="fw-semibold mb-0">Дата</h4>\n' +
    //     '        <p style="width: 100px;" th:text="${el.dateEntry}" class="text-muted"></p>\n' +
    //     '    </div>\n' +
    //     '    <div class="d-flex flex-row m-1">\n' +
    //     '        <form th:action="\'/remove/\' + ${el.id}" method="post">\n' +
    //     '            <button class="btn btn-light" type="submit">Удалить</button>\n' +
    //     '        </form>\n' +
    //     '        <div class="myClass"><button th:data-id="${el.id}" th:data-text="${el.textEntry}"  id="bt" class="btn btn-light" th:onclick="openFormEdit(this.getAttribute(\'data-text\'), this.getAttribute(\'data-id\'))">Редактировать</button></div>\n' +
    //     '    </div>\n' +
    //     '</div>\n' +
    //     '</div>'
    // var str_d = '<div th:fragment="descending" class="container px-4 py-5">\n' +
    //     '    <h2 class="pb-2 border-bottom text-white">Дни</h2>\n' +
    //     '<div th:each="i : ${#numbers.sequence(dairy_entries.size() - 1, 0 -1)}" th:with="n=${dairy_entries[i]}" class="row align-items-md-center g-5 py-5 model-content rounded-4 shadow m-5 bg-white">\n' +
    //     '    <div class="col-10 d-flex flex-column align-items-start gap-2">\n' +
    //     '        <h3 th:text="\'Запись \' + ${i + 1}" class="fw-bold"></h3>\n' +
    //     '        <p th:text="${el.textEntry}" class="text-muted"></p>\n' +
    //     '    </div>\n' +
    //     '    <div class="col-1 d-flex flex-column gap-2">\n' +
    //     '        <h4 class="fw-semibold mb-0">Дата</h4>\n' +
    //     '        <p style="width: 100px;" th:text="${el.dateEntry}" class="text-muted"></p>\n' +
    //     '    </div>\n' +
    //     '    <div class="d-flex flex-row m-1">\n' +
    //     '        <form th:action="\'/remove/\' + ${el.id}" method="post">\n' +
    //     '            <button class="btn btn-light" type="submit">Удалить</button>\n' +
    //     '        </form>\n' +
    //     '        <div class="myClass"><button th:data-id="${el.id}" th:data-text="${el.textEntry}"  id="bt" class="btn btn-light" th:onclick="openFormEdit(this.getAttribute(\'data-text\'), this.getAttribute(\'data-id\'))">Редактировать</button></div>\n' +
    //     '    </div>\n' +
    //     '</div>\n' +
    //     '</div>'
    // if(order){
    //     document.getElementById("btn-order").innerHTML = 'По возрастанию'
    //     el.innerHTML = str_a
    // }
    // else{
    //     document.getElementById("btn-order").innerHTML = 'По убыванию'
    //     el.innerHTML = str_d
    // }
    document.getElementById("btn-order").innerHTML = order ? 'По возрастанию' : 'По убыванию'
    //tmp = [[${dairy_entries}]]
    //console.log(tmp)
}