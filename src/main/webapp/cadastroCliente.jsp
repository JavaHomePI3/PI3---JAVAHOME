<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="header.jsp"/>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
 
<link href="topodapagina.css" rel="stylesheet">
<div align="center">
    <br>
    <br>
<center><h1>Cadastrar Cliente</h1></center>
    <br>

    <script>
        $(function() {
            $('input[name=dataNascimento]').datepicker();
        });
    </script> 
    
        <div class="col-md-6 mb-3">
            <h6>Dados Pessoais</h6><br>
        <form method="POST" action='/CadastroCliente' name="inserir" >
        <div class="row">
            <div class="col-md-4 mb-3">
                <label>Nome</label>
                <input name="nomeCliente" type="text" class="form-control" id="nomeCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Nome obrigatório
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label>Sobrenome</label>
                <input name="sobrenomeCliente" type="text" class="form-control" id="sobrenomeCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Sobrenome obrigatório
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label>Data de Nascimento</label>
                <input name="dataNascimento" type="date" class="form-control" id="dataNascimento" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Inseri Data de Nascimento
                </div>
            </div>
                <div class="col-md-3 mb-3">
                <label for="sexo">Sexo</label>
                <select name="genero" class="custom-select d-block w-100" id="generoCliente" required>
                    <option value="">Selecionar...</option>
                    <option>Feminino</option>
                    <option>Masculino</option>
                </select>
                <div class="invalid-feedback">
                    Favor selecionar o sexo.
                </div> 
                </div>
            <div class="col-md-4 mb-3">
                <label>CPF</label>
                <input name="cpfCliente" type="number" class="form-control" id="cpfCliente" placeholder="000.000.000-00" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Inserir CPF válido
                </div>
            </div>
            <div class="col-md-5 mb-3">
                <label>E-mail</label>
                <input name="emailCliente" type="text" class="form-control" id="emailCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    E-mail obrigatório
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label>Telefone</label>
                <input name="telefoneCliente" type="number" class="form-control" id="telefoneCliente" placeholder="(00) 00000-0000" value=""
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
                <input name="cepCliente" type="number" class="form-control" id="cepCliente" placeholder="00000-000" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    CEP obrigatório
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label>Rua</label>
                <input name="ruaCliente" type="text" class="form-control" id="ruaCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Rua obrigatório
                </div>
            </div>
            <div class="col-md-2 mb-3">
                <label>Nº</label>
                <input name="nCliente" type="number" class="form-control" id="numeroCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Número obrigatório
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label>Complemento</label>
                <input name="complementoCliente" type="text" class="form-control" id="complementoCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Complemento
                </div>
            </div>  
            <div class="col-md-8 mb-3">
                <label>Bairro</label>
                <input name="bairroCliente" type="text" class="form-control" id="bairroCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Bairro
                </div>
            </div> 
            <div class="col-md-8 mb-3">
                <label>Cidade</label>
                <input name="cidadeCliente" type="text" class="form-control" id="cidadeCliente" placeholder="" value=""
                       maxlength="30" required>
                <div class="invalid-feedback">
                    Cidade
                </div>
            </div> 
            <div class="col-md-4 mb-3">
                <label for="uf">UF</label>
                <select name="uf" class="custom-select d-block w-100" id="ufCliente" required>
                    <option value="">Selecionar...</option>
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
            <button class="btn btn-secondary btn-lg btn-block" href="ListaClientes.jsp" type="submit">Lista de Clientes</button>
                </div>
        </div>
        <c:import url="footer.jsp"/>