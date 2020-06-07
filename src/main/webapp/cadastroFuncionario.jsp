<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>
<c:set var="funtionario" value="#{requestScope.funcionario}"/>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
<link href="topodapagina.css" rel="stylesheet">
<div align="center">
    <br>
    <br>
    <c:if test="${funtionario != null}">
        <h1 align="cemter">Editar Funcionário</h1>
    </c:if>
    <c:if test="${funtionario == null}">
        <h1 align="cemter">Cadastrar Funcionário</h1>
    </c:if>

    <script>
        $(function () {
            $('input[name=dataNascimento]').datepicker();
        });
    </script>

    <div class="col-md-6 mb-3">
        <h6><b>Dados Pessoais</b></h6><br>
        <c:if test="${funtionario == null}">
        <form method="POST" action='CadastroFuncionario'>
            </c:if>
            <c:if test="${funtionario != null}">
            <form method="POST" action='CadastroFuncionario?action=editar'>
                </c:if>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label>Nome</label>
                        <input name="nomeFuncionario" type="text" class="form-control" id="nomeFuncionario"
                               placeholder=""
                               value="${funtionario.nomeUsuario}"
                               maxlength="30" required>
                        <div class="invalid-feedback">
                            Nome obrigatório
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Sobrenome</label>
                        <input name="sobrenomeFuncionario" type="text" class="form-control" id="sobrenomeFuncionario"
                               placeholder="" value="${funtionario.sobrenomeUsuario}"
                               maxlength="30" required>
                        <div class="invalid-feedback">
                            Sobrenome obrigatório
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Data de Nascimento</label>
                        <input name="data_nascimento" type="date" class="form-control" id="dataNascimento"
                               placeholder=""
                               value="${funtionario.dataNascimento}"
                               maxlength="30" required>
                        <div class="invalid-feedback">
                            Inserir Data de Nascimento
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="generoFuncionario">Sexo</label>
                        <select name="generoFuncionario" class="custom-select d-block w-100" id="generoFuncionario"
                                required>
                            <c:if test="${funtionario.genero != null}">
                                <option value="${funtionario.genero}">${funtionario.genero}</option>
                            </c:if>
                            <c:if test="${funtionario.genero == null}">
                                <option value="">Selecionar...</option>
                            </c:if>

                            <option value="FEMININO">Feminino</option>
                            <option value="MASCULINO">Masculino</option>
                        </select>
                        <div class="invalid-feedback">
                            Favor selecionar o sexo.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>CPF</label>
                        <input name="cpfFuncionario" type="number" class="form-control" id="cpfFuncionario"
                               placeholder="000.000.000-00" value="${funtionario.cpf}"
                               maxlength="30" required>
                        <div class="invalid-feedback">
                            Inserir CPF válido
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Telefone</label>
                        <input name="telefone" type="number" class="form-control" id="telefoneFuncionario"
                               placeholder="(00) 00000-0000" value="${funtionario.telefone}"
                               maxlength="30" required>
                        <div class="invalid-feedback">
                            Inserir telefone
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="dep">Departamento</label>
                        <select name="departamento" class="custom-select d-block w-100" id="dep" required>
                            <c:if test="${funtionario.departamento != null}">
                                <option value="${funtionario.departamento}">${funtionario.departamento}</option>
                            </c:if>
                            <c:if test="${funtionario.departamento == null}">
                                <option value="">Selecionar...</option>
                            </c:if>
                            <option value="ADM">Admin</option>
                            <option value="VENDAS">Vendedor</option>
                            <option value="BACKOFFICE">Back Office</option>
                            <option value="TI">T.I</option>
                        </select>
                        <div class="invalid-feedback">
                            Inserir o Departamento
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Salário</label>
                        <input name="salario" type="number" class="form-control" id="salario" pattern="^\d+\.\d{2}"
                               placeholder="00,00" value="${funtionario.salario}" required>
                        <div class="invalid-feedback">
                            Insira o Salário
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Email</label>
                        <c:if test="${funtionario.email != null}">
                            <input name="emailFuncionario" type="text" class="form-control" id="email"
                                   placeholder="Email..."
                                   value="${funtionario.email}" disabled>
                        </c:if>
                        <c:if test="${funtionario.email == null}">
                            <input name="emailFuncionario" type="text" class="form-control" id="email"
                                   placeholder="Email..."
                                   value="" required>
                        </c:if>

                        <div class="invalid-feedback">
                            Email obrigatório
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Senha</label>
                        <c:if test="${funtionario != null}">
                            <div class="alert alert-warning" role="alert">
                                Redefinir Senha
                            </div>
                        </c:if>
                        <c:if test="${funtionario != null}">
                            <input name="senha" type="password" class="form-control" id="senha" placeholder="Senha"
                                   value="">
                        </c:if>
                        <c:if test="${funtionario == null}">
                            <input name="senha" type="password" class="form-control" id="senha" placeholder="Senha"
                                   value="">
                        </c:if>

                        <div class="invalid-feedback">
                            Senha é obrigatório
                        </div>
                    </div>
                </div>
    </div>
    <div class="col-md-6 mb-3">
        <hr>
        <br>
        <h6><b>Endereço</b></h6><br>
        <div class="row">
            <div class="col-md-4 mb-3">
                <label>CEP</label>
                <input name="cepFuncionario" type="number" class="form-control" id="cepFuncionario"
                       placeholder="00000-000" value="${funtionario.cep}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    CEP obrigatório
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label>Rua</label>
                <input name="ruaFuncionario" type="text" class="form-control" id="ruaFuncionario" placeholder=""
                       value="${funtionario.rua}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Rua obrigatório
                </div>
            </div>
            <div class="col-md-2 mb-3">
                <label>Nº</label>
                <input name="numeroFuncionario" type="number" class="form-control" id="numeroFuncionario" placeholder=""
                       value="${funtionario.numero}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Número obrigatório
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label>Complemento</label>
                <input name="complementoFuncionario" type="text" class="form-control" id="complementoFuncionario"
                       placeholder="" value="${funtionario.complemento}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Complemento
                </div>
            </div>
            <div class="col-md-8 mb-3">
                <label>Bairro</label>
                <input name="bairroFuncionario" type="text" class="form-control" id="bairroCFuncionario" placeholder=""
                       value="${funtionario.bairro}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Bairro
                </div>
            </div>
            <div class="col-md-8 mb-3">
                <label>Cidade</label>
                <input name="cidadeFuncionario" type="text" class="form-control" id="cidadeFuncionario" placeholder=""
                       value="${funtionario.cidade}"
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Cidade
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="ufFuncionario">UF</label>
                <select name="ufFuncionario" class="custom-select d-block w-100" id="ufFuncionario" required>
                    <c:if test="${funtionario.estado != null}">
                        <option value="${funtionario.estado}">${funtionario.estado}</option>
                    </c:if>
                    <c:if test="${funtionario.estado == null}">
                        <option value="">Selecionar...</option>
                    </c:if>

                    <option>AC</option>
                    <option>AL</option>
                    <option>AM</option>
                    <option>AP</option>
                    <option>BA</option>
                    <option>CE</option>
                    <option>DF</option>
                    <option>ES</option>
                    <option>GO</option>
                    <option>MA</option>
                    <option>MG</option>
                    <option>MS</option>
                    <option>MT</option>
                    <option>PA</option>
                    <option>PB</option>
                    <option>PE</option>
                    <option>PI</option>
                    <option>PR</option>
                    <option>RJ</option>
                    <option>RN</option>
                    <option>RO</option>
                    <option>RR</option>
                    <option>RS</option>
                    <option>SC</option>
                    <option>SE</option>
                    <option>SP</option>
                    <option>TO</option>
                </select>
                <div class="invalid-feedback">
                    Favor selecionar o estado.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-secondary btn-lg btn-block" type="submit">Gravar</button>
        </form>
        <button class="btn btn-secondary btn-lg btn-block" href="ListaFuncionario.jsp" type="submit">Lista de
            Funcionários
        </button>
    </div>
</div>
<c:import url="footer.jsp"/>
