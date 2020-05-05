<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:import url="header.jsp"/>
<c:set var="cliente" value="${requestScope.cliente}"/>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
<link href="topodapagina.css" rel="stylesheet">
<div align="center">
    <h1 align="cemter">Cadastrar Cliente</h1>
    <script>
        $(function () {
            $('input[name=dataNascimento]').datepicker();
        });
    </script>

    <div class="col-md-6 mb-3">
        <h6>Dados Pessoais</h6><br>
        <form method="POST" action='CadastroCliente' >
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label>Nome</label>
                    <input name="nomeCliente" type="text" class="form-control" id="nomeCliente" placeholder=""
                           value="${cliente.nomeUsuario}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        Nome obrigatório
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label>Sobrenome</label>
                    <input name="sobrenomeCliente" type="text" class="form-control" id="sobrenomeCliente" placeholder=""
                           value="${cliente.sobrenomeUsuario}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        Sobrenome obrigatório
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label>Data de Nascimento</label>
                    <input name="data_nascimento" type="date" class="form-control" id="dataNascimento" placeholder=""
                           value="${cliente.dataNascimento}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        Inseri Data de Nascimento
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="generoCliente">Sexo</label>
                    <select name="generoCliente" class="custom-select d-block w-100" id="generoCliente" required>
                        <c:if test="${cliente.genero != null}">
                            <option><c:out value="${cliente.genero}" /></option>
                        </c:if>
                        <c:if test="${cliente.genero == null}">
                            <option>Selecionar...</option>
                        </c:if>
                        <option value="FEMININO">Feminino</option>
                        <option VALUE="MASCULINO">Masculino</option>
                    </select>
                    <div class="invalid-feedback">
                        Favor selecionar o sexo.
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label>CPF</label>
                    <input name="cpfCliente" type="number" class="form-control" id="cpfCliente"
                           placeholder="000.000.000-00"
                           value="${cliente.cpf}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        Inserir CPF válido
                    </div>
                </div>
                <div class="col-md-5 mb-3">
                    <label>E-mail</label>
                    <input name="emailCliente" type="text" class="form-control" id="emailCliente" placeholder=""
                           value="${cliente.email}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        E-mail obrigatório
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label>Telefone</label>
                    <input name="telefoneCliente" type="number" class="form-control" id="telefoneCliente"
                           placeholder="(00) 00000-0000"
                           value="${cliente.telefone}"
                           maxlength="30" required>
                    <div class="invalid-feedback">
                        Inserir telefone
                    </div>
                </div>
            </div>
    </div>
    <div class="col-md-6 mb-3">
        <h6>Endereço</h6><br>
        <div class="row">
            <div class="col-md-4 mb-3">
                <label>CEP</label>
                <input name="cepCliente" type="number" class="form-control" id="cepCliente" placeholder="00000-000"
                       value="${cliente.cep}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    CEP obrigatório
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label>Rua</label>
                <input name="ruaCliente" type="text" class="form-control" id="ruaCliente" placeholder=""
                       value="${cliente.rua}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Rua obrigatório
                </div>
            </div>
            <div class="col-md-2 mb-3">
                <label>Nº</label>
                <input name="numeroCliente" type="number" class="form-control" id="numeroCliente" placeholder=""
                       value="${cliente.numero}"
                       maxlength="30" required/>
                <div class="invalid-feedback">
                    Número obrigatório
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label>Complemento</label>
                <input name="complementoCliente" type="text" class="form-control" id="complementoCliente" placeholder=""
                       value="${cliente.telefone}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Complemento
                </div>
            </div>
            <div class="col-md-8 mb-3">
                <label>Bairro</label>
                <input name="bairroCliente" type="text" class="form-control" id="bairroCliente" placeholder=""
                       value="${cliente.bairro}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Bairro
                </div>
            </div>
            <div class="col-md-8 mb-3">
                <label>Cidade</label>
                <input name="cidadeCliente" type="text" class="form-control" id="cidadeCliente" placeholder=""
                       value="${cliente.cidade}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Cidade
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="ufCliente">UF</label>
                <select name="ufCliente" class="custom-select d-block w-100" id="ufCliente" required>
                    <c:if test="${cliente.estado != null}">
                        <option><c:out value="${cliente.estado}" /></option>
                    </c:if>
                    <c:if test="${cliente.estado == null}">
                        <option>Selecionar...</option>
                    </c:if>

                    <option value="AC">AC</option>
                    <option value="AL">AL</option>
                    <option value="AM">AM</option>
                    <option value="AP">AP</option>
                    <option value="BA">BA</option>
                    <option value="CE">CE</option>
                    <option value="DF">DF</option>
                    <option value="ES">ES</option>
                    <option value="GO">GO</option>
                    <option value="MA">MA</option>
                    <option value="MG">MG</option>
                    <option value="MS">MS</option>
                    <option value="MT">MT</option>
                    <option value="PA">PA</option>
                    <option value="PB">PB</option>
                    <option value="PE">PE</option>
                    <option value="PI">PI</option>
                    <option value="PR">PR</option>
                    <option value="RJ">RJ</option>
                    <option value="RN">RN</option>
                    <option value="RO">RO</option>
                    <option value="RR">RR</option>
                    <option value="RS">RS</option>
                    <option value="SC">SC</option>
                    <option value="SE">SE</option>
                    <option value="SP">SP</option>
                    <option value="TO">TO</option>
                </select>
                <div class="invalid-feedback">
                    Favor selecionar o estado.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <c:set var="acao" value="${requestScope.action}"/>

        <c:if test="${acao == null }">
            <button class="btn btn-secondary btn-lg btn-block" type="submit">Gravar</button>
        </c:if>

        <c:if test="${acao != null }">
            <input type="text" value="editar" name="acao" hidden>
            <button class="btn btn-secondary btn-lg btn-block" type="submit">Editar</button>
        </c:if>
        </form>
        <a class="btn btn-secondary btn-lg btn-block" href="CadastroCliente?action=listar" type="submit">Lista de Clientes</a>
    </div>
</div>
<c:import url="footer.jsp"/>