
$(document).ready(function () {
    $("#radioFilial").click(function () {
        $("#filial-form").css("display", "block");
        $("#categoria-form").css("display", "none");
        $("#cpf-form").css("display", "none");
    });

    $("#radioCatProd").click(function () {
        $("#filial-form").css("display", "none");
        $("#categoria-form").css("display", "block");
        $("#cpf-form").css("display", "none");
    });

    $("#radioCliente").click(function () {
        $("#filial-form").css("display", "none");
        $("#categoria-form").css("display", "none");
        $("#cpf-form").css("display", "inline-block");
    });
});
function buscarDetalhesVenda(codigoCarrinho) {
    let url = "relatorio?action=detalhes&CodigoItens="+codigoCarrinho;

    function getError() {
        return function (jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Not connect.\n Verify Network.');
            } else if (jqXHR.status == 404) {
                alert('Requested page not found. [404]');
            } else if (jqXHR.status == 500) {
                console.log('Internal Server Error [500].');
                alert("Não foi encontrado registros para essa filial!")
            } else if (exception === 'parsererror') {
                alert('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                alert('Time out error.');
            } else if (exception === 'abort') {
                alert('Ajax request aborted.');
            } else {
                alert('Uncaught Error.\n' + jqXHR.responseText);
            }
        };
    }

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        error:  getError(),
        beforeSend: getBeforeSend(),
        success: function (data) {
            let valorTotal = 0;
            let html = data.reduce(function (string, obj) {
                valorTotal += (obj.itensvenda*obj.valorprod);
                return string +"<tr class='linhaTabela'><td>"+obj.idProduto
                    +"</td><td>"+obj.codigobarrasprod
                    +"</td><td>"+obj.valorprod.toFixed(2)
                    +"</td><td>"+obj.nomeprod
                    +"</td><td>"+obj.categoriaprod
                    +"</td><td>"+obj.qtdestoque
                    +"</td><td>"+obj.itensvenda
                    +"</td><td>"+(obj.itensvenda*obj.valorprod).toFixed(2)+"</td></tr>";
            }, '');
            let htmlValorTotal = " <div class=\"text-xs font-weight-bold text-primary text-uppercase mb-1\">Valor total</div>" +
                "<div class='h5 mb-0 font-weight-bold text-gray-800'>R$:"+valorTotal.toFixed(2) +"</div>";
            $("#rootValorTotal").html(htmlValorTotal);
            $("table #rootModal").html(html);
        },
        complete: getComplete(),
    });
}
function getBeforeSend() {
    return function () {
        $("#valorTotal").css("display", "none");
        $("#loading").css("display", "inline-block");
        $(".loadingValorTotal").css("display", "inline-block");
    };
}

function getComplete() {
    return function () {
        $("#loading").css("display", "none")
        $(".loadingValorTotal").css("display", "none");
        $("#valorTotal").css("display", "block");
    };
}

function buscarCliente() {
    let cpf = $('#cpfCliente').val();
    let url = "relatorio?action=cliente&cpf=" + cpf;

    function getSuccess() {
        return function (data) {
            controiHtml(data);
        };
    }

    function getError() {
        return function () {
            alert("Cliente não encontrado!");
        };
    }

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        error: getError(),
        beforeSend: getBeforeSend(),
        success: getSuccess(),
        complete: getComplete(),
    });
}

function controiHtml(data) {
    let valorToal = 0.00;
    let html = data.reduce(function (string, obj) {
        valorToal += parseFloat(obj.precoTotal);
        return string + "<tr class=\"linhaTabela\" onclick=\"buscarDetalhesVenda("+obj.idItens+")\" data-toggle=\"modal\"\n" +
            "                                data-target=\".bd-example-modal-lg\"> <td>" + obj.id + "</td><td>" + obj.idItens + "</td> <td>" + obj.nomeCliente + " </td> <td>" + obj.idVendedor + " </td> <td>" +
            obj.filial + " </td> <td>R$: " + obj.precoTotal.toFixed(1) + "</td> <td>" + obj.dataDaVenda + "</td></tr>";
    }, '');
    let htmlValorTotal = "<div class=\"h5 mb-0 font-weight-bold text-gray-800\" id=\"valorTotal\">R$: " + valorToal.toFixed(2) + "</div>";

    $("#dataTable tbody").html(html);
    $(".card-body #valorTotal").html(htmlValorTotal);
}

function buscarFilial() {
    let filial = $('#filial').val().replace(" ", "%20");
    let url = "relatorio?action=filial&nome=" + filial;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        beforeSend: getBeforeSend(),
        success: getSuccess(),
        complete: getComplete(),
        error: function (jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Not connect.\n Verify Network.');
            } else if (jqXHR.status == 404) {
                alert('Requested page not found. [404]');
            } else if (jqXHR.status == 500) {
                console.log('Internal Server Error [500].');
                alert("Não foi encontrado registros para essa filial!")
            } else if (exception === 'parsererror') {
                alert('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                alert('Time out error.');
            } else if (exception === 'abort') {
                alert('Ajax request aborted.');
            } else {
                alert('Uncaught Error.\n' + jqXHR.responseText);
            }
            let htmlValorTotal = "<div class=\"h5 mb-0 font-weight-bold text-gray-800\" id=\"valorTotal\">R$: 000,00</div>";
            $(".card-body #valorTotal").html(htmlValorTotal);
        }
    });

    function getSuccess() {
        return function (data) {
            controiHtml(data)
        }
    }
}

function buscarCategoria() {
    let categoria = $('#categoria');
    alert(categoria.val())
}

